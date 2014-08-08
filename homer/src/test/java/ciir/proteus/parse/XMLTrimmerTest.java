/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciir.proteus.parse;

import ciir.proteus.parse.Pages.Word;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.h2.util.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bzifkin
 */
public class XMLTrimmerTest {

    /**
     * Test of run method, of class XMLTrimmer.
     */
    @Test
    public void testTrim() throws Exception {
        String yeahright = "<BODY><OBJECT data=\"file://localhost//tmp/derive/cairngormmounta01burtgoog//cairngormmounta01burtgoog.djvu\" height=\"1650\" type=\"image/x.djvu\" usemap=\"cairngormmounta01burtgoog_0001.djvu\" width=\"1275\">"
                + "<PARAM name=\"DPI\" value=\"300\"/>"
                + "<WORD coords=\"203,290,65,276,290\">This</WORD>"
                + "<WORD coords=\"73,290,84,276,290\">is</WORD>"
                + "<WORD coords=\"92,290,100,280,290\">a</WORD>"
                + "<WORD coords=\"105,295,157,276,290\">digital</WORD>" + "<WORD coords=\"810,290,840,280,290\">was</WORD>"
                + "<WORD coords=\"847,295,919,276,290\">carefully</WORD>"
                + "<WORD coords=\"927,290,991,276,290\">scanned</WORD>"
                + "<WORD coords=\"999,295,1017,276,290\">by</WORD>"
                + "<WORD coords=\"661,346,685,332,346\">the</WORD>"
                + "<WORD coords=\"690,351,742,332,346\">public</WORD>"
                + "<WORD coords=\"747,347,813,332,346\">domain.</WORD>"
                + "<WORD coords=\"1024,295,1085,276,290\">Google</WORD>"
                + "</OBJECT></BODY>";
        InputStream is = new ByteArrayInputStream(yeahright.getBytes());

        XMLEvent event = null;
        XMLTrimmer instance = new XMLTrimmer(is);

        List<Pages> result = instance.trim(event);
        List<Word> expWords = result.get(0).getWords();
        int expSize = result.get(0).wordsOnPage.size();
        assertEquals(4, expSize);

    }

    @Test
    public void testIsArarbicNum() throws Exception {
        String yeahright = "<BODY><OBJECT  height=\"1650\" width=\"1275\">"
                + "</OBJECT></BODY>";
        InputStream is = new ByteArrayInputStream(yeahright.getBytes());

        XMLTrimmer instance = new XMLTrimmer(is);

        Word testWord1 = new Word("grease");
        Word testWord2 = new Word("i");
        Word testWord3 = new Word("1");
        Word testWord4 = new Word("1z");
        Word testWord5 = new Word("23");
        Word testWord6 = new Word("2 3");

        assertEquals(false, instance.isArabicNum(testWord1.text));
        assertEquals(false, instance.isArabicNum(testWord2.text));
        assertEquals(true, instance.isArabicNum(testWord3.text));
        assertEquals(false, instance.isArabicNum(testWord4.text));
        assertEquals(true, instance.isArabicNum(testWord5.text));
        assertEquals(false, instance.isArabicNum(testWord6.text));

    }

    @Test
    public void testRomanToDecimal() throws Exception {
        String yeahright = "<BODY><OBJECT  height=\"1650\" width=\"1275\">"
                + "</OBJECT></BODY>";
        InputStream is = new ByteArrayInputStream(yeahright.getBytes());

        XMLTrimmer instance = new XMLTrimmer(is);

        String a = "iii";
        String b = "i v";
        String c = "xcix";
        String d = "ix";
        String e = "xc";
        String f = "MCMLIV";
        String g = "iix";
        String h = "xmix";
        //String a = "";

        assertEquals(3, instance.romanToDecimal(a));
        //assertEquals(0, instance.romanToDecimal(b));
        assertEquals(99, instance.romanToDecimal(c));
        assertEquals(9, instance.romanToDecimal(d));
        assertEquals(90, instance.romanToDecimal(e));
        assertEquals(1954, instance.romanToDecimal(f));
        //assertEquals(0, instance.romanToDecimal(g)); //get ten...should be invalid, 
        //assertEquals(0, instance.romanToDecimal(h)); //get 990 should be invalid

    }

    @Test
    public void testIsRomanNum() throws Exception {
        String yeahright = "<BODY><OBJECT  height=\"1650\" width=\"1275\">"
                + "</OBJECT></BODY>";
        InputStream is = new ByteArrayInputStream(yeahright.getBytes());

        XMLTrimmer instance = new XMLTrimmer(is);

        String a = "i";
        String b = "i v";
        String c = "xxxx";
        String d = "pol";
        String e = "x.";
        String f = "MCMLIV";
        String g = "iix";
        String h = "xm";
        //String a = "";

        assertEquals(true, instance.isRomanNum(a));
        assertEquals(false, instance.isRomanNum(b));
        assertEquals(true, instance.isRomanNum(c));
        assertEquals(false, instance.isRomanNum(d));
        assertEquals(false, instance.isRomanNum(e));
        assertEquals(true, instance.isRomanNum(f));
        assertEquals(true, instance.isRomanNum(g));
        assertEquals(true, instance.isRomanNum(h));

    }

    @Test
    public void testFindPageNumbers() throws Exception {
        String yeahright = "<BODY><OBJECT  height=\"1650\" width=\"1275\">"
                + "</OBJECT></BODY>";
        InputStream is = new ByteArrayInputStream(yeahright.getBytes());

        XMLTrimmer instance = new XMLTrimmer(is);
        List<Pages> pageList = new ArrayList<Pages>();

        Pages p1 = new Pages();
        Word word1 = new Word("i");
        Word word4 = new Word("1");
         p1.wordsOnPage.add(word1);
        p1.wordsOnPage.add(word4);
        pageList.add(p1);

        Pages p2 = new Pages();
        
         Word word5 = new Word("ii");
        //p2.wordsOnPage.add(word2);
        p2.wordsOnPage.add(word5);
        pageList.add(p2);

        Pages p3 = new Pages();
        Word word2 = new Word("3");
        Word word7 = new Word("iii");
        p3.wordsOnPage.add(word2);
        p3.wordsOnPage.add(word7);
        
        pageList.add(p3);

        Pages p4 = new Pages();
        Word word3 = new Word("iv");
        Word word6 = new Word("4");
         p4.wordsOnPage.add(word3);
        p4.wordsOnPage.add(word6);
        pageList.add(p4);
        ArrayList<XMLTrimmer.NumScheme> test = instance.findPageNumbers(pageList);
        for (XMLTrimmer.NumScheme ben : test) {
            System.out.println(ben.toString());
            System.out.println("------------------");
        }
        assertEquals(2, test.size());

    }

    @Test
    public void testGetNumBlank() throws Exception {
        String yeahright = "<BODY><OBJECT  height=\"1650\" width=\"1275\">"
                + "</OBJECT></BODY>";
        InputStream is = new ByteArrayInputStream(yeahright.getBytes());

        XMLTrimmer instance = new XMLTrimmer(is);
        List<Pages> pageList = new ArrayList<Pages>();

        XMLTrimmer.NumScheme ns = new XMLTrimmer.NumScheme();

        Word word1 = new Word();
        word1.isBlank = true;
        Word word2 = new Word();
        word2.isBlank = true;
        Word word3 = new Word();
        word3.isBlank = true;
        Word word4 = new Word();
        word4.isBlank = false;
        Word word5 = new Word();
        word5.isBlank = true;
        Word word6 = new Word();
        word6.isBlank = true;

        ns.sequence.add(word1);
        ns.sequence.add(word2);
        ns.sequence.add(word3);
        ns.sequence.add(word4);
        ns.sequence.add(word5);
        ns.sequence.add(word6);

        int result = ns.getNumOfBlanks();
        assertEquals(2, result);

    }

}