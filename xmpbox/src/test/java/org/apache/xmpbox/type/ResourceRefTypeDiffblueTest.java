package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class ResourceRefTypeDiffblueTest {
  /**
   * Method under test: {@link ResourceRefType#getDocumentID()}
   */
  @Test
  void testGetDocumentID() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getDocumentID());
  }

  /**
   * Method under test: {@link ResourceRefType#getDocumentID()}
   */
  @Test
  void testGetDocumentID2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.DOCUMENT_ID, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getDocumentID());
  }

  /**
   * Method under test: {@link ResourceRefType#setDocumentID(String)}
   */
  @Test
  void testSetDocumentID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setDocumentID("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URIType);
    assertEquals("42", resourceRefType.getDocumentID());
    assertEquals("42", ((URIType) getResult).getStringValue());
    assertEquals("42", ((URIType) getResult).getRawValue());
    assertEquals("42", ((URIType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.DOCUMENT_ID, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getFilePath()}
   */
  @Test
  void testGetFilePath() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getFilePath());
  }

  /**
   * Method under test: {@link ResourceRefType#getFilePath()}
   */
  @Test
  void testGetFilePath2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.FILE_PATH, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getFilePath());
  }

  /**
   * Method under test: {@link ResourceRefType#setFilePath(String)}
   */
  @Test
  void testSetFilePath() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setFilePath("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URIType);
    assertEquals("42", resourceRefType.getFilePath());
    assertEquals("42", ((URIType) getResult).getStringValue());
    assertEquals("42", ((URIType) getResult).getRawValue());
    assertEquals("42", ((URIType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.FILE_PATH, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getInstanceID()}
   */
  @Test
  void testGetInstanceID() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getInstanceID());
  }

  /**
   * Method under test: {@link ResourceRefType#getInstanceID()}
   */
  @Test
  void testGetInstanceID2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.INSTANCE_ID, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getInstanceID());
  }

  /**
   * Method under test: {@link ResourceRefType#setInstanceID(String)}
   */
  @Test
  void testSetInstanceID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setInstanceID("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URIType);
    assertEquals("42", resourceRefType.getInstanceID());
    assertEquals("42", ((URIType) getResult).getStringValue());
    assertEquals("42", ((URIType) getResult).getRawValue());
    assertEquals("42", ((URIType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.INSTANCE_ID, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getLastModifyDate()}
   */
  @Test
  void testGetLastModifyDate() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getLastModifyDate());
  }

  /**
   * Method under test: {@link ResourceRefType#getLastModifyDate()}
   */
  @Test
  void testGetLastModifyDate2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.LAST_MODIFY_DATE, "");

    // Act and Assert
    assertNull(resourceRefType.getLastModifyDate());
  }

  /**
   * Method under test: {@link ResourceRefType#setLastModifyDate(Calendar)}
   */
  @Test
  void testSetLastModifyDate() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);
    GregorianCalendar value = new GregorianCalendar(1, 1, 1);

    // Act
    resourceRefType.setLastModifyDate(value);

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.LAST_MODIFY_DATE, getResult.getPropertyName());
    assertSame(value, ((DateType) getResult).getRawValue());
    assertSame(value, ((DateType) getResult).getValue());
    assertSame(value, resourceRefType.getLastModifyDate());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getManageUI()}
   */
  @Test
  void testGetManageUI() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getManageUI());
  }

  /**
   * Method under test: {@link ResourceRefType#getManageUI()}
   */
  @Test
  void testGetManageUI2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.MANAGE_UI, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getManageUI());
  }

  /**
   * Method under test: {@link ResourceRefType#setManageUI(String)}
   */
  @Test
  void testSetManageUI() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setManageUI("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URIType);
    assertEquals("42", resourceRefType.getManageUI());
    assertEquals("42", ((URIType) getResult).getStringValue());
    assertEquals("42", ((URIType) getResult).getRawValue());
    assertEquals("42", ((URIType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.MANAGE_UI, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getManageTo()}
   */
  @Test
  void testGetManageTo() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getManageTo());
  }

  /**
   * Method under test: {@link ResourceRefType#getManageTo()}
   */
  @Test
  void testGetManageTo2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.MANAGE_TO, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getManageTo());
  }

  /**
   * Method under test: {@link ResourceRefType#setManageTo(String)}
   */
  @Test
  void testSetManageTo() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setManageTo("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URIType);
    assertEquals("42", resourceRefType.getManageTo());
    assertEquals("42", ((URIType) getResult).getStringValue());
    assertEquals("42", ((URIType) getResult).getRawValue());
    assertEquals("42", ((URIType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.MANAGE_TO, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getManager()}
   */
  @Test
  void testGetManager() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getManager());
  }

  /**
   * Method under test: {@link ResourceRefType#getManager()}
   */
  @Test
  void testGetManager2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.MANAGER, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getManager());
  }

  /**
   * Method under test: {@link ResourceRefType#setManager(String)}
   */
  @Test
  void testSetManager() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setManager("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof AgentNameType);
    assertEquals("42", resourceRefType.getManager());
    assertEquals("42", ((AgentNameType) getResult).getStringValue());
    assertEquals("42", ((AgentNameType) getResult).getRawValue());
    assertEquals("42", ((AgentNameType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.MANAGER, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getManagerVariant()}
   */
  @Test
  void testGetManagerVariant() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getManagerVariant());
  }

  /**
   * Method under test: {@link ResourceRefType#getManagerVariant()}
   */
  @Test
  void testGetManagerVariant2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.MANAGER_VARIANT, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getManagerVariant());
  }

  /**
   * Method under test: {@link ResourceRefType#setManagerVariant(String)}
   */
  @Test
  void testSetManagerVariant() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setManagerVariant("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", resourceRefType.getManagerVariant());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.MANAGER_VARIANT, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getPartMapping()}
   */
  @Test
  void testGetPartMapping() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getPartMapping());
  }

  /**
   * Method under test: {@link ResourceRefType#getPartMapping()}
   */
  @Test
  void testGetPartMapping2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.PART_MAPPING, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getPartMapping());
  }

  /**
   * Method under test: {@link ResourceRefType#setPartMapping(String)}
   */
  @Test
  void testSetPartMapping() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setPartMapping("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", resourceRefType.getPartMapping());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.PART_MAPPING, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getRenditionParams()}
   */
  @Test
  void testGetRenditionParams() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getRenditionParams());
  }

  /**
   * Method under test: {@link ResourceRefType#getRenditionParams()}
   */
  @Test
  void testGetRenditionParams2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.RENDITION_PARAMS, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getRenditionParams());
  }

  /**
   * Method under test: {@link ResourceRefType#setRenditionParams(String)}
   */
  @Test
  void testSetRenditionParams() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setRenditionParams("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", resourceRefType.getRenditionParams());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.RENDITION_PARAMS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getVersionID()}
   */
  @Test
  void testGetVersionID() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getVersionID());
  }

  /**
   * Method under test: {@link ResourceRefType#getVersionID()}
   */
  @Test
  void testGetVersionID2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.VERSION_ID, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getVersionID());
  }

  /**
   * Method under test: {@link ResourceRefType#setVersionID(String)}
   */
  @Test
  void testSetVersionID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setVersionID("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", resourceRefType.getVersionID());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.VERSION_ID, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getMaskMarkers()}
   */
  @Test
  void testGetMaskMarkers() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getMaskMarkers());
  }

  /**
   * Method under test: {@link ResourceRefType#getMaskMarkers()}
   */
  @Test
  void testGetMaskMarkers2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.MASK_MARKERS, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getMaskMarkers());
  }

  /**
   * Method under test: {@link ResourceRefType#setMaskMarkers(String)}
   */
  @Test
  void testSetMaskMarkers() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setMaskMarkers("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ChoiceType);
    assertEquals("42", resourceRefType.getMaskMarkers());
    assertEquals("42", ((ChoiceType) getResult).getStringValue());
    assertEquals("42", ((ChoiceType) getResult).getRawValue());
    assertEquals("42", ((ChoiceType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.MASK_MARKERS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getRenditionClass()}
   */
  @Test
  void testGetRenditionClass() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getRenditionClass());
  }

  /**
   * Method under test: {@link ResourceRefType#getRenditionClass()}
   */
  @Test
  void testGetRenditionClass2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.RENDITION_CLASS, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getRenditionClass());
  }

  /**
   * Method under test: {@link ResourceRefType#setRenditionClass(String)}
   */
  @Test
  void testSetRenditionClass() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setRenditionClass("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof RenditionClassType);
    assertEquals("42", resourceRefType.getRenditionClass());
    assertEquals("42", ((RenditionClassType) getResult).getStringValue());
    assertEquals("42", ((RenditionClassType) getResult).getRawValue());
    assertEquals("42", ((RenditionClassType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.RENDITION_CLASS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getFromPart()}
   */
  @Test
  void testGetFromPart() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getFromPart());
  }

  /**
   * Method under test: {@link ResourceRefType#getFromPart()}
   */
  @Test
  void testGetFromPart2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.FROM_PART, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getFromPart());
  }

  /**
   * Method under test: {@link ResourceRefType#setFromPart(String)}
   */
  @Test
  void testSetFromPart() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setFromPart("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof PartType);
    assertEquals("42", resourceRefType.getFromPart());
    assertEquals("42", ((PartType) getResult).getStringValue());
    assertEquals("42", ((PartType) getResult).getRawValue());
    assertEquals("42", ((PartType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.FROM_PART, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getToPart()}
   */
  @Test
  void testGetToPart() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getToPart());
  }

  /**
   * Method under test: {@link ResourceRefType#getToPart()}
   */
  @Test
  void testGetToPart2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.TO_PART, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getToPart());
  }

  /**
   * Method under test: {@link ResourceRefType#setToPart(String)}
   */
  @Test
  void testSetToPart() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setToPart("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof PartType);
    assertEquals("42", resourceRefType.getToPart());
    assertEquals("42", ((PartType) getResult).getStringValue());
    assertEquals("42", ((PartType) getResult).getRawValue());
    assertEquals("42", ((PartType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.TO_PART, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#addAlternatePath(String)}
   */
  @Test
  void testAddAlternatePath() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.addAlternatePath("42");

    // Assert
    ArrayProperty alternatePathsProperty = resourceRefType.getAlternatePathsProperty();
    List<AbstractField> allProperties = alternatePathsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = alternatePathsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    List<String> alternatePaths = resourceRefType.getAlternatePaths();
    assertEquals(1, alternatePaths.size());
    assertEquals("42", alternatePaths.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("rdf", getResult.getPrefix());
    assertEquals("stRef", alternatePathsProperty.getPrefix());
    assertNull(getResult.getNamespace());
    assertNull(alternatePathsProperty.getNamespace());
    List<AbstractField> allProperties2 = resourceRefType.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Seq, alternatePathsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(alternatePathsProperty.getAllAttributes().isEmpty());
    assertTrue(alternatePathsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(ResourceRefType.ALTERNATE_PATHS, alternatePathsProperty.getPropertyName());
    assertSame(allProperties, alternatePathsProperty.getContainer().getAllProperties());
    assertSame(alternatePathsProperty, allProperties2.get(0));
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, alternatePathsProperty.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#addAlternatePath(String)}
   */
  @Test
  void testAddAlternatePath2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    ResourceRefType resourceRefType = new ResourceRefType(metadata);
    resourceRefType.addAlternatePath("42");

    // Act
    resourceRefType.addAlternatePath("42");

    // Assert
    ArrayProperty alternatePathsProperty = resourceRefType.getAlternatePathsProperty();
    List<AbstractField> allProperties = alternatePathsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> alternatePaths = resourceRefType.getAlternatePaths();
    assertEquals(2, alternatePaths.size());
    assertEquals("42", alternatePaths.get(0));
    assertEquals("42", alternatePaths.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("rdf", getResult.getPrefix());
    assertEquals("rdf", getResult2.getPrefix());
    assertEquals("stRef", alternatePathsProperty.getPrefix());
    assertNull(getResult.getNamespace());
    assertNull(getResult2.getNamespace());
    assertNull(alternatePathsProperty.getNamespace());
    List<AbstractField> allProperties2 = resourceRefType.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Seq, alternatePathsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(alternatePathsProperty.getAllAttributes().isEmpty());
    assertTrue(alternatePathsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(alternatePaths, alternatePathsProperty.getElementsAsString());
    assertEquals(ResourceRefType.ALTERNATE_PATHS, alternatePathsProperty.getPropertyName());
    assertSame(allProperties, alternatePathsProperty.getContainer().getAllProperties());
    assertSame(alternatePathsProperty, allProperties2.get(0));
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, alternatePathsProperty.getMetadata());
  }

  /**
   * Method under test: {@link ResourceRefType#getAlternatePathsProperty()}
   */
  @Test
  void testGetAlternatePathsProperty() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getAlternatePathsProperty());
  }

  /**
   * Method under test: {@link ResourceRefType#getAlternatePaths()}
   */
  @Test
  void testGetAlternatePaths() {
    // Arrange, Act and Assert
    assertNull((new ResourceRefType(XMPMetadata.createXMPMetadata())).getAlternatePaths());
  }

  /**
   * Method under test: {@link ResourceRefType#getAlternatePaths()}
   */
  @Test
  void testGetAlternatePaths2() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addAlternatePath("42");

    // Act
    List<String> actualAlternatePaths = resourceRefType.getAlternatePaths();

    // Assert
    assertEquals(1, actualAlternatePaths.size());
    assertEquals("42", actualAlternatePaths.get(0));
  }

  /**
   * Method under test: {@link ResourceRefType#getAlternatePaths()}
   */
  @Test
  void testGetAlternatePaths3() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addAlternatePath(ResourceRefType.ALTERNATE_PATHS);
    resourceRefType.addAlternatePath("42");

    // Act
    List<String> actualAlternatePaths = resourceRefType.getAlternatePaths();

    // Assert
    assertEquals(2, actualAlternatePaths.size());
    assertEquals("42", actualAlternatePaths.get(1));
    assertEquals(ResourceRefType.ALTERNATE_PATHS, actualAlternatePaths.get(0));
  }

  /**
   * Method under test: {@link ResourceRefType#getAlternatePaths()}
   */
  @Test
  void testGetAlternatePaths4() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addProperty(new ArrayProperty(XMPMetadata.createXMPMetadata(), ResourceRefType.ALTERNATE_PATHS,
        ResourceRefType.ALTERNATE_PATHS, ResourceRefType.ALTERNATE_PATHS, Cardinality.Simple));

    // Act and Assert
    assertTrue(resourceRefType.getAlternatePaths().isEmpty());
  }

  /**
   * Method under test: {@link ResourceRefType#ResourceRefType(XMPMetadata)}
   */
  @Test
  void testNewResourceRefType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ResourceRefType actualResourceRefType = new ResourceRefType(metadata);

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/sType/ResourceRef#", actualResourceRefType.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualResourceRefType.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("stRef", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/ResourceRef#"));
    assertEquals("stRef", actualResourceRefType.getPreferedPrefix());
    assertEquals("stRef", actualResourceRefType.getPrefix());
    assertNull(actualResourceRefType.getPropertyName());
    assertNull(actualResourceRefType.getDocumentID());
    assertNull(actualResourceRefType.getFilePath());
    assertNull(actualResourceRefType.getFromPart());
    assertNull(actualResourceRefType.getInstanceID());
    assertNull(actualResourceRefType.getManageTo());
    assertNull(actualResourceRefType.getManageUI());
    assertNull(actualResourceRefType.getManager());
    assertNull(actualResourceRefType.getManagerVariant());
    assertNull(actualResourceRefType.getMaskMarkers());
    assertNull(actualResourceRefType.getPartMapping());
    assertNull(actualResourceRefType.getRenditionClass());
    assertNull(actualResourceRefType.getRenditionParams());
    assertNull(actualResourceRefType.getToPart());
    assertNull(actualResourceRefType.getVersionID());
    assertNull(actualResourceRefType.getLastModifyDate());
    assertNull(actualResourceRefType.getAlternatePaths());
    assertNull(actualResourceRefType.getAlternatePathsProperty());
    List<AbstractField> allProperties = actualResourceRefType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualResourceRefType.getAllAttributes().isEmpty());
    assertSame(allProperties, actualResourceRefType.getContainer().getAllProperties());
    assertSame(metadata, actualResourceRefType.getMetadata());
  }
}
