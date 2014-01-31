package ciir.proteus.parse;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.xml.stream.XMLStreamConstants;
import org.lemurproject.galago.core.parse.Document;
import org.lemurproject.galago.core.types.DocumentSplit;
import org.lemurproject.galago.tupleflow.Parameters;

/**
 * STATES:
 *
 * S0 = starting state. Reads in header information. Stay in this state until
 * you see the "text" open tag, then head to S1.
 *
 * S1 = "w" tags trigger a read from the "form" attribute, which is the
 * outputted string. "name" opening and closing tags are echoed to the output
 * string. "text" and "TEI" closing tags are also echoed to the output.
 *
 * S1 is a terminal state.
 *
 */
public class MBTEIBookParser extends MBTEIParserBase {

  Pattern wantedMetadata = Pattern.compile(".+");
  String header;
  // MCZ moving this to the ParserBase so we have access to it
  // HashMap<String, String> metadata;
  String currentMetaTag = null;
  StringBuilder tagBuilder;

  public MBTEIBookParser(DocumentSplit split, Parameters p) {
    super(split, p);
    // set up to parse the header
    metadata = new HashMap<String, String>();
    S0();
  }

  @Override
  public void cleanup() {
    // Do nothing in this situation for now. It's a pain to
    // cleanup properly. Easier to dump the incomplete data.
    parsedDocument = null;
  }

  public void S0() {
    // Put the more specific matches first
    addStartElementAction(textTag, "moveToS1");
    addStartElementAction(wantedMetadata, "captureMetadata");
    addEndElementAction(wantedMetadata, "stopCaptureMetadata");
    setCharactersAction("echo");
    // Collect everything else
    //addStartElementAction(matchAll, "echo");
    //addEndElementAction(matchAll, "echo");
  }

  public void moveToS1(int ignored) {
    //header = buffer.toString();
    buffer = new StringBuilder();
    contentLength = 0;
    // Matched on "text" opening, but that should be
    // echoed. Do it manually.
    echo(XMLStreamConstants.START_ELEMENT);

    // Move on to the new rules
    // First remove old matchers
    clearAllActions();

    // Now set up our normal processing matchers
    addStartElementAction(wordTag, "echoFormAttribute");
    addStartElementAction(nameTag, "transformNameTag");
    addEndElementAction(nameTag, "transformNameTag");
    addEndElementAction(textTag, "echo");
    // MCZ 31-JAN-2014 - adding Internet Archive identifier
    String archiveID = getArchiveIdentifier();
    // Note we do NOT want the archive ID to be parsed, we've seen some
    // that contain ":", ".", and lots of other characters that could be
    // interpreted as "word breaks"
    buffer.append("<archiveid tokenizetagcontent=\"false\">");
    buffer.append(archiveID);
    buffer.append("</archiveid>");   
    addEndElementAction(teiTag, "emitFinalDocument");
  }
  public String lastSeenNameTag = null;

  public void transformNameTag(int event) {
    switch (event) {
      case XMLStreamConstants.START_ELEMENT:
        String entityType = reader.getAttributeValue(null, "type").toLowerCase();
        buffer.append("<").append(entityType).append(">");
        lastSeenNameTag = entityType;
        break;
      case XMLStreamConstants.END_ELEMENT:
        if (lastSeenNameTag != null) {
          buffer.append("</").append(lastSeenNameTag).append(">");
        } else {
          Logger.getLogger(getClass()
                  .toString())
                  .log(Level.WARNING, "No open name tag, but close called!");
        }
        lastSeenNameTag = null;
        break;
    }
  }

  public void captureMetadata(int ignored) {
    currentMetaTag = reader.getLocalName();
    tagBuilder = new StringBuilder();
  }

  public void stopCaptureMetadata(int ignored) {
    if (currentMetaTag != null && tagBuilder != null) {
      metadata.put(currentMetaTag, tagBuilder.toString().trim());
      currentMetaTag = null;
      tagBuilder = null;
    }
  }

  public void echo(int event) {
    //super.echo(event);
    if (currentMetaTag != null
            && event == XMLStreamConstants.CHARACTERS) {
      tagBuilder.append(reader.getText()).append(" ");
    }
  }

  // This should only be called once but there isn't really a way
  // to handle that gracefully other than removing all the handlers.
  public void emitFinalDocument(int ignored) {
   
        
    if (contentLength > 0) {
      // Echo "</tei>" or whatever it is.
      echo(XMLStreamConstants.END_ELEMENT);

      //StringBuilder documentContent = new StringBuilder(header);
      String bookIdentifier = getArchiveIdentifier();
      parsedDocument = new Document(bookIdentifier,
              buffer.toString().trim());
      parsedDocument.metadata = metadata;
    }

    // Emit 1 document per file, or none at all.
    clearStartElementActions();
    clearEndElementActions();
    unsetCharactersAction();
    contentLength = 0;
  }
}
