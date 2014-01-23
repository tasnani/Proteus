/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package ciir.proteus.thrift;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatusResponse implements org.apache.thrift.TBase<StatusResponse, StatusResponse._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("StatusResponse");

  private static final org.apache.thrift.protocol.TField SITE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("siteId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField COLLECTION_DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("collectionData", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField LINK_DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("linkData", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField TOPIC_DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("topicData", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new StatusResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new StatusResponseTupleSchemeFactory());
  }

  public String siteId; // required
  public List<CollectionInfo> collectionData; // required
  public List<LinkInfo> linkData; // required
  public List<TopicInfo> topicData; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SITE_ID((short)1, "siteId"),
    COLLECTION_DATA((short)2, "collectionData"),
    LINK_DATA((short)3, "linkData"),
    TOPIC_DATA((short)4, "topicData");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SITE_ID
          return SITE_ID;
        case 2: // COLLECTION_DATA
          return COLLECTION_DATA;
        case 3: // LINK_DATA
          return LINK_DATA;
        case 4: // TOPIC_DATA
          return TOPIC_DATA;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SITE_ID, new org.apache.thrift.meta_data.FieldMetaData("siteId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COLLECTION_DATA, new org.apache.thrift.meta_data.FieldMetaData("collectionData", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, CollectionInfo.class))));
    tmpMap.put(_Fields.LINK_DATA, new org.apache.thrift.meta_data.FieldMetaData("linkData", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, LinkInfo.class))));
    tmpMap.put(_Fields.TOPIC_DATA, new org.apache.thrift.meta_data.FieldMetaData("topicData", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TopicInfo.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(StatusResponse.class, metaDataMap);
  }

  public StatusResponse() {
  }

  public StatusResponse(
    String siteId,
    List<CollectionInfo> collectionData,
    List<LinkInfo> linkData,
    List<TopicInfo> topicData)
  {
    this();
    this.siteId = siteId;
    this.collectionData = collectionData;
    this.linkData = linkData;
    this.topicData = topicData;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public StatusResponse(StatusResponse other) {
    if (other.isSetSiteId()) {
      this.siteId = other.siteId;
    }
    if (other.isSetCollectionData()) {
      List<CollectionInfo> __this__collectionData = new ArrayList<CollectionInfo>();
      for (CollectionInfo other_element : other.collectionData) {
        __this__collectionData.add(new CollectionInfo(other_element));
      }
      this.collectionData = __this__collectionData;
    }
    if (other.isSetLinkData()) {
      List<LinkInfo> __this__linkData = new ArrayList<LinkInfo>();
      for (LinkInfo other_element : other.linkData) {
        __this__linkData.add(new LinkInfo(other_element));
      }
      this.linkData = __this__linkData;
    }
    if (other.isSetTopicData()) {
      List<TopicInfo> __this__topicData = new ArrayList<TopicInfo>();
      for (TopicInfo other_element : other.topicData) {
        __this__topicData.add(new TopicInfo(other_element));
      }
      this.topicData = __this__topicData;
    }
  }

  public StatusResponse deepCopy() {
    return new StatusResponse(this);
  }

  @Override
  public void clear() {
    this.siteId = null;
    this.collectionData = null;
    this.linkData = null;
    this.topicData = null;
  }

  public String getSiteId() {
    return this.siteId;
  }

  public StatusResponse setSiteId(String siteId) {
    this.siteId = siteId;
    return this;
  }

  public void unsetSiteId() {
    this.siteId = null;
  }

  /** Returns true if field siteId is set (has been assigned a value) and false otherwise */
  public boolean isSetSiteId() {
    return this.siteId != null;
  }

  public void setSiteIdIsSet(boolean value) {
    if (!value) {
      this.siteId = null;
    }
  }

  public int getCollectionDataSize() {
    return (this.collectionData == null) ? 0 : this.collectionData.size();
  }

  public java.util.Iterator<CollectionInfo> getCollectionDataIterator() {
    return (this.collectionData == null) ? null : this.collectionData.iterator();
  }

  public void addToCollectionData(CollectionInfo elem) {
    if (this.collectionData == null) {
      this.collectionData = new ArrayList<CollectionInfo>();
    }
    this.collectionData.add(elem);
  }

  public List<CollectionInfo> getCollectionData() {
    return this.collectionData;
  }

  public StatusResponse setCollectionData(List<CollectionInfo> collectionData) {
    this.collectionData = collectionData;
    return this;
  }

  public void unsetCollectionData() {
    this.collectionData = null;
  }

  /** Returns true if field collectionData is set (has been assigned a value) and false otherwise */
  public boolean isSetCollectionData() {
    return this.collectionData != null;
  }

  public void setCollectionDataIsSet(boolean value) {
    if (!value) {
      this.collectionData = null;
    }
  }

  public int getLinkDataSize() {
    return (this.linkData == null) ? 0 : this.linkData.size();
  }

  public java.util.Iterator<LinkInfo> getLinkDataIterator() {
    return (this.linkData == null) ? null : this.linkData.iterator();
  }

  public void addToLinkData(LinkInfo elem) {
    if (this.linkData == null) {
      this.linkData = new ArrayList<LinkInfo>();
    }
    this.linkData.add(elem);
  }

  public List<LinkInfo> getLinkData() {
    return this.linkData;
  }

  public StatusResponse setLinkData(List<LinkInfo> linkData) {
    this.linkData = linkData;
    return this;
  }

  public void unsetLinkData() {
    this.linkData = null;
  }

  /** Returns true if field linkData is set (has been assigned a value) and false otherwise */
  public boolean isSetLinkData() {
    return this.linkData != null;
  }

  public void setLinkDataIsSet(boolean value) {
    if (!value) {
      this.linkData = null;
    }
  }

  public int getTopicDataSize() {
    return (this.topicData == null) ? 0 : this.topicData.size();
  }

  public java.util.Iterator<TopicInfo> getTopicDataIterator() {
    return (this.topicData == null) ? null : this.topicData.iterator();
  }

  public void addToTopicData(TopicInfo elem) {
    if (this.topicData == null) {
      this.topicData = new ArrayList<TopicInfo>();
    }
    this.topicData.add(elem);
  }

  public List<TopicInfo> getTopicData() {
    return this.topicData;
  }

  public StatusResponse setTopicData(List<TopicInfo> topicData) {
    this.topicData = topicData;
    return this;
  }

  public void unsetTopicData() {
    this.topicData = null;
  }

  /** Returns true if field topicData is set (has been assigned a value) and false otherwise */
  public boolean isSetTopicData() {
    return this.topicData != null;
  }

  public void setTopicDataIsSet(boolean value) {
    if (!value) {
      this.topicData = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SITE_ID:
      if (value == null) {
        unsetSiteId();
      } else {
        setSiteId((String)value);
      }
      break;

    case COLLECTION_DATA:
      if (value == null) {
        unsetCollectionData();
      } else {
        setCollectionData((List<CollectionInfo>)value);
      }
      break;

    case LINK_DATA:
      if (value == null) {
        unsetLinkData();
      } else {
        setLinkData((List<LinkInfo>)value);
      }
      break;

    case TOPIC_DATA:
      if (value == null) {
        unsetTopicData();
      } else {
        setTopicData((List<TopicInfo>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SITE_ID:
      return getSiteId();

    case COLLECTION_DATA:
      return getCollectionData();

    case LINK_DATA:
      return getLinkData();

    case TOPIC_DATA:
      return getTopicData();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SITE_ID:
      return isSetSiteId();
    case COLLECTION_DATA:
      return isSetCollectionData();
    case LINK_DATA:
      return isSetLinkData();
    case TOPIC_DATA:
      return isSetTopicData();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof StatusResponse)
      return this.equals((StatusResponse)that);
    return false;
  }

  public boolean equals(StatusResponse that) {
    if (that == null)
      return false;

    boolean this_present_siteId = true && this.isSetSiteId();
    boolean that_present_siteId = true && that.isSetSiteId();
    if (this_present_siteId || that_present_siteId) {
      if (!(this_present_siteId && that_present_siteId))
        return false;
      if (!this.siteId.equals(that.siteId))
        return false;
    }

    boolean this_present_collectionData = true && this.isSetCollectionData();
    boolean that_present_collectionData = true && that.isSetCollectionData();
    if (this_present_collectionData || that_present_collectionData) {
      if (!(this_present_collectionData && that_present_collectionData))
        return false;
      if (!this.collectionData.equals(that.collectionData))
        return false;
    }

    boolean this_present_linkData = true && this.isSetLinkData();
    boolean that_present_linkData = true && that.isSetLinkData();
    if (this_present_linkData || that_present_linkData) {
      if (!(this_present_linkData && that_present_linkData))
        return false;
      if (!this.linkData.equals(that.linkData))
        return false;
    }

    boolean this_present_topicData = true && this.isSetTopicData();
    boolean that_present_topicData = true && that.isSetTopicData();
    if (this_present_topicData || that_present_topicData) {
      if (!(this_present_topicData && that_present_topicData))
        return false;
      if (!this.topicData.equals(that.topicData))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_siteId = true && (isSetSiteId());
    builder.append(present_siteId);
    if (present_siteId)
      builder.append(siteId);

    boolean present_collectionData = true && (isSetCollectionData());
    builder.append(present_collectionData);
    if (present_collectionData)
      builder.append(collectionData);

    boolean present_linkData = true && (isSetLinkData());
    builder.append(present_linkData);
    if (present_linkData)
      builder.append(linkData);

    boolean present_topicData = true && (isSetTopicData());
    builder.append(present_topicData);
    if (present_topicData)
      builder.append(topicData);

    return builder.toHashCode();
  }

  public int compareTo(StatusResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    StatusResponse typedOther = (StatusResponse)other;

    lastComparison = Boolean.valueOf(isSetSiteId()).compareTo(typedOther.isSetSiteId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSiteId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.siteId, typedOther.siteId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCollectionData()).compareTo(typedOther.isSetCollectionData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCollectionData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.collectionData, typedOther.collectionData);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLinkData()).compareTo(typedOther.isSetLinkData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLinkData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.linkData, typedOther.linkData);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTopicData()).compareTo(typedOther.isSetTopicData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTopicData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.topicData, typedOther.topicData);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("StatusResponse(");
    boolean first = true;

    sb.append("siteId:");
    if (this.siteId == null) {
      sb.append("null");
    } else {
      sb.append(this.siteId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("collectionData:");
    if (this.collectionData == null) {
      sb.append("null");
    } else {
      sb.append(this.collectionData);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("linkData:");
    if (this.linkData == null) {
      sb.append("null");
    } else {
      sb.append(this.linkData);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("topicData:");
    if (this.topicData == null) {
      sb.append("null");
    } else {
      sb.append(this.topicData);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class StatusResponseStandardSchemeFactory implements SchemeFactory {
    public StatusResponseStandardScheme getScheme() {
      return new StatusResponseStandardScheme();
    }
  }

  private static class StatusResponseStandardScheme extends StandardScheme<StatusResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, StatusResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SITE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.siteId = iprot.readString();
              struct.setSiteIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COLLECTION_DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list186 = iprot.readListBegin();
                struct.collectionData = new ArrayList<CollectionInfo>(_list186.size);
                for (int _i187 = 0; _i187 < _list186.size; ++_i187)
                {
                  CollectionInfo _elem188; // required
                  _elem188 = new CollectionInfo();
                  _elem188.read(iprot);
                  struct.collectionData.add(_elem188);
                }
                iprot.readListEnd();
              }
              struct.setCollectionDataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LINK_DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list189 = iprot.readListBegin();
                struct.linkData = new ArrayList<LinkInfo>(_list189.size);
                for (int _i190 = 0; _i190 < _list189.size; ++_i190)
                {
                  LinkInfo _elem191; // required
                  _elem191 = new LinkInfo();
                  _elem191.read(iprot);
                  struct.linkData.add(_elem191);
                }
                iprot.readListEnd();
              }
              struct.setLinkDataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TOPIC_DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list192 = iprot.readListBegin();
                struct.topicData = new ArrayList<TopicInfo>(_list192.size);
                for (int _i193 = 0; _i193 < _list192.size; ++_i193)
                {
                  TopicInfo _elem194; // required
                  _elem194 = new TopicInfo();
                  _elem194.read(iprot);
                  struct.topicData.add(_elem194);
                }
                iprot.readListEnd();
              }
              struct.setTopicDataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, StatusResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.siteId != null) {
        oprot.writeFieldBegin(SITE_ID_FIELD_DESC);
        oprot.writeString(struct.siteId);
        oprot.writeFieldEnd();
      }
      if (struct.collectionData != null) {
        oprot.writeFieldBegin(COLLECTION_DATA_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.collectionData.size()));
          for (CollectionInfo _iter195 : struct.collectionData)
          {
            _iter195.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.linkData != null) {
        oprot.writeFieldBegin(LINK_DATA_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.linkData.size()));
          for (LinkInfo _iter196 : struct.linkData)
          {
            _iter196.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.topicData != null) {
        oprot.writeFieldBegin(TOPIC_DATA_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.topicData.size()));
          for (TopicInfo _iter197 : struct.topicData)
          {
            _iter197.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class StatusResponseTupleSchemeFactory implements SchemeFactory {
    public StatusResponseTupleScheme getScheme() {
      return new StatusResponseTupleScheme();
    }
  }

  private static class StatusResponseTupleScheme extends TupleScheme<StatusResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, StatusResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSiteId()) {
        optionals.set(0);
      }
      if (struct.isSetCollectionData()) {
        optionals.set(1);
      }
      if (struct.isSetLinkData()) {
        optionals.set(2);
      }
      if (struct.isSetTopicData()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetSiteId()) {
        oprot.writeString(struct.siteId);
      }
      if (struct.isSetCollectionData()) {
        {
          oprot.writeI32(struct.collectionData.size());
          for (CollectionInfo _iter198 : struct.collectionData)
          {
            _iter198.write(oprot);
          }
        }
      }
      if (struct.isSetLinkData()) {
        {
          oprot.writeI32(struct.linkData.size());
          for (LinkInfo _iter199 : struct.linkData)
          {
            _iter199.write(oprot);
          }
        }
      }
      if (struct.isSetTopicData()) {
        {
          oprot.writeI32(struct.topicData.size());
          for (TopicInfo _iter200 : struct.topicData)
          {
            _iter200.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, StatusResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.siteId = iprot.readString();
        struct.setSiteIdIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list201 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.collectionData = new ArrayList<CollectionInfo>(_list201.size);
          for (int _i202 = 0; _i202 < _list201.size; ++_i202)
          {
            CollectionInfo _elem203; // required
            _elem203 = new CollectionInfo();
            _elem203.read(iprot);
            struct.collectionData.add(_elem203);
          }
        }
        struct.setCollectionDataIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list204 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.linkData = new ArrayList<LinkInfo>(_list204.size);
          for (int _i205 = 0; _i205 < _list204.size; ++_i205)
          {
            LinkInfo _elem206; // required
            _elem206 = new LinkInfo();
            _elem206.read(iprot);
            struct.linkData.add(_elem206);
          }
        }
        struct.setLinkDataIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list207 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.topicData = new ArrayList<TopicInfo>(_list207.size);
          for (int _i208 = 0; _i208 < _list207.size; ++_i208)
          {
            TopicInfo _elem209; // required
            _elem209 = new TopicInfo();
            _elem209.read(iprot);
            struct.topicData.add(_elem209);
          }
        }
        struct.setTopicDataIsSet(true);
      }
    }
  }

}
