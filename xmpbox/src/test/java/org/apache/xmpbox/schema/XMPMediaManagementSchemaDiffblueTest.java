package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.IntegerType;
import org.apache.xmpbox.type.RenditionClassType;
import org.apache.xmpbox.type.ResourceRefType;
import org.apache.xmpbox.type.TextType;
import org.apache.xmpbox.type.URIType;
import org.apache.xmpbox.type.URLType;
import org.junit.jupiter.api.Test;

class XMPMediaManagementSchemaDiffblueTest {
  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setDerivedFromProperty(ResourceRefType)}
   */
  @Test
  void testSetDerivedFromProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    ResourceRefType tt = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setDerivedFromProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setDerivedFromProperty(ResourceRefType)}
   */
  @Test
  void testSetDerivedFromProperty2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");
    ResourceRefType tt = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setDerivedFromProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult2.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", getResult2.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONS, getResult.getPropertyName());
    assertSame(tt, allProperties.get(1));
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setDerivedFromProperty(ResourceRefType)}
   */
  @Test
  void testSetDerivedFromProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory("42");
    xmpMediaManagementSchema.addVersions("42");
    ResourceRefType tt = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setDerivedFromProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult4 = allProperties3.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    List<String> elementsAsString2 = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("42", elementsAsString2.get(0));
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult4).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult4).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    assertEquals("42", ((TextType) getResult4).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult4.getNamespace());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", getResult2.getPrefix());
    assertEquals("xmpMM", getResult3.getPrefix());
    assertEquals("xmpMM", getResult4.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.HISTORY, getResult.getPropertyName());
    assertEquals(XMPMediaManagementSchema.VERSIONS, getResult2.getPropertyName());
    assertSame(tt, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getResourceRefProperty()}
   */
  @Test
  void testGetResourceRefProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getResourceRefProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getResourceRefProperty()}
   */
  @Test
  void testGetResourceRefProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getResourceRefProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getResourceRefProperty()}
   */
  @Test
  void testGetResourceRefProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getResourceRefProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setDocumentID(String)}
   */
  @Test
  void testSetDocumentID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setDocumentID("https://example.org/example");

    // Assert
    TextType documentIDProperty = xmpMediaManagementSchema.getDocumentIDProperty();
    assertTrue(documentIDProperty instanceof URIType);
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getDocumentID());
    assertEquals("https://example.org/example", documentIDProperty.getStringValue());
    assertEquals("https://example.org/example", documentIDProperty.getRawValue());
    assertEquals("https://example.org/example", documentIDProperty.getValue());
    assertEquals("xmpMM", documentIDProperty.getPrefix());
    assertNull(documentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(documentIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.DOCUMENTID, documentIDProperty.getPropertyName());
    assertSame(metadata, documentIDProperty.getMetadata());
    assertSame(documentIDProperty, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setDocumentID(String)}
   */
  @Test
  void testSetDocumentID2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setDocumentID("https://example.org/example");

    // Assert
    TextType documentIDProperty = xmpMediaManagementSchema.getDocumentIDProperty();
    assertTrue(documentIDProperty instanceof URIType);
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getDocumentID());
    assertEquals("https://example.org/example", documentIDProperty.getStringValue());
    assertEquals("https://example.org/example", documentIDProperty.getRawValue());
    assertEquals("https://example.org/example", documentIDProperty.getValue());
    assertEquals("xmpMM", documentIDProperty.getPrefix());
    assertNull(documentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(documentIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.DOCUMENTID, documentIDProperty.getPropertyName());
    assertSame(metadata, documentIDProperty.getMetadata());
    assertSame(documentIDProperty, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setDocumentID(String)}
   */
  @Test
  void testSetDocumentID3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setDocumentID("https://example.org/example");

    // Assert
    TextType documentIDProperty = xmpMediaManagementSchema.getDocumentIDProperty();
    assertTrue(documentIDProperty instanceof URIType);
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getDocumentID());
    assertEquals("https://example.org/example", documentIDProperty.getStringValue());
    assertEquals("https://example.org/example", documentIDProperty.getRawValue());
    assertEquals("https://example.org/example", documentIDProperty.getValue());
    assertEquals("xmpMM", documentIDProperty.getPrefix());
    assertNull(documentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(documentIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.DOCUMENTID, documentIDProperty.getPropertyName());
    assertSame(metadata, documentIDProperty.getMetadata());
    assertSame(documentIDProperty, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setDocumentID(String)}
   */
  @Test
  void testSetDocumentID4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.DOCUMENTID, "42");

    // Act
    xmpMediaManagementSchema.setDocumentID("https://example.org/example");

    // Assert
    TextType documentIDProperty = xmpMediaManagementSchema.getDocumentIDProperty();
    assertTrue(documentIDProperty instanceof URIType);
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getDocumentID());
    assertEquals("https://example.org/example", documentIDProperty.getStringValue());
    assertEquals("https://example.org/example", documentIDProperty.getRawValue());
    assertEquals("https://example.org/example", documentIDProperty.getValue());
    assertEquals("xmpMM", documentIDProperty.getPrefix());
    assertNull(documentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(documentIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.DOCUMENTID, documentIDProperty.getPropertyName());
    assertSame(metadata, documentIDProperty.getMetadata());
    assertSame(documentIDProperty, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}
   */
  @Test
  void testSetDocumentIDProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}
   */
  @Test
  void testSetDocumentIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}
   */
  @Test
  void testSetDocumentIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}
   */
  @Test
  void testSetDocumentIDProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getDocumentIDProperty()}
   */
  @Test
  void testGetDocumentIDProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getDocumentIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getDocumentIDProperty()}
   */
  @Test
  void testGetDocumentIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getDocumentIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getDocumentIDProperty()}
   */
  @Test
  void testGetDocumentIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getDocumentIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getDocumentID()}
   */
  @Test
  void testGetDocumentID() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getDocumentID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getDocumentID()}
   */
  @Test
  void testGetDocumentID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getDocumentID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getDocumentID()}
   */
  @Test
  void testGetDocumentID3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getDocumentID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setLastURL(String)}
   */
  @Test
  void testSetLastURL() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setLastURL("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getLastURL());
    URLType lastURLProperty = xmpMediaManagementSchema.getLastURLProperty();
    assertEquals("https://example.org/example", lastURLProperty.getStringValue());
    assertEquals("https://example.org/example", lastURLProperty.getRawValue());
    assertEquals("https://example.org/example", lastURLProperty.getValue());
    assertEquals("xmpMM", lastURLProperty.getPrefix());
    assertNull(lastURLProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(lastURLProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.LAST_URL, lastURLProperty.getPropertyName());
    assertSame(lastURLProperty, allProperties.get(0));
    assertSame(metadata, lastURLProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setLastURL(String)}
   */
  @Test
  void testSetLastURL2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setLastURL("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getLastURL());
    URLType lastURLProperty = xmpMediaManagementSchema.getLastURLProperty();
    assertEquals("https://example.org/example", lastURLProperty.getStringValue());
    assertEquals("https://example.org/example", lastURLProperty.getRawValue());
    assertEquals("https://example.org/example", lastURLProperty.getValue());
    assertEquals("xmpMM", lastURLProperty.getPrefix());
    assertNull(lastURLProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(lastURLProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.LAST_URL, lastURLProperty.getPropertyName());
    assertSame(lastURLProperty, allProperties.get(1));
    assertSame(metadata, lastURLProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setLastURL(String)}
   */
  @Test
  void testSetLastURL3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setLastURL("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getLastURL());
    URLType lastURLProperty = xmpMediaManagementSchema.getLastURLProperty();
    assertEquals("https://example.org/example", lastURLProperty.getStringValue());
    assertEquals("https://example.org/example", lastURLProperty.getRawValue());
    assertEquals("https://example.org/example", lastURLProperty.getValue());
    assertEquals("xmpMM", lastURLProperty.getPrefix());
    assertNull(lastURLProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(lastURLProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.LAST_URL, lastURLProperty.getPropertyName());
    assertSame(lastURLProperty, allProperties.get(2));
    assertSame(metadata, lastURLProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setLastURL(String)}
   */
  @Test
  void testSetLastURL4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.LAST_URL, "42");

    // Act
    xmpMediaManagementSchema.setLastURL("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getLastURL());
    URLType lastURLProperty = xmpMediaManagementSchema.getLastURLProperty();
    assertEquals("https://example.org/example", lastURLProperty.getStringValue());
    assertEquals("https://example.org/example", lastURLProperty.getRawValue());
    assertEquals("https://example.org/example", lastURLProperty.getValue());
    assertEquals("xmpMM", lastURLProperty.getPrefix());
    assertNull(lastURLProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(lastURLProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.LAST_URL, lastURLProperty.getPropertyName());
    assertSame(lastURLProperty, allProperties.get(0));
    assertSame(metadata, lastURLProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}
   */
  @Test
  void testSetLastURLProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    URLType tt = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpMediaManagementSchema.setLastURLProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}
   */
  @Test
  void testSetLastURLProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    URLType tt = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpMediaManagementSchema.setLastURLProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}
   */
  @Test
  void testSetLastURLProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("https://example.org/example");
    xmpMediaManagementSchema.addVersions("42");
    URLType tt = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpMediaManagementSchema.setLastURLProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}
   */
  @Test
  void testSetLastURLProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("https://example.org/example", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    URLType tt = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpMediaManagementSchema.setLastURLProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getLastURLProperty()}
   */
  @Test
  void testGetLastURLProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getLastURLProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getLastURLProperty()}
   */
  @Test
  void testGetLastURLProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getLastURLProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getLastURLProperty()}
   */
  @Test
  void testGetLastURLProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getLastURLProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getLastURL()}
   */
  @Test
  void testGetLastURL() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getLastURL());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getLastURL()}
   */
  @Test
  void testGetLastURL2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getLastURL());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getLastURL()}
   */
  @Test
  void testGetLastURL3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getLastURL());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setSaveId(Integer)}
   */
  @Test
  void testSetSaveId() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setSaveId(1);

    // Assert
    IntegerType saveIDProperty = xmpMediaManagementSchema.getSaveIDProperty();
    assertEquals("1", saveIDProperty.getStringValue());
    assertEquals("xmpMM", saveIDProperty.getPrefix());
    assertNull(saveIDProperty.getNamespace());
    assertEquals(1, xmpMediaManagementSchema.getSaveID().intValue());
    assertEquals(1, saveIDProperty.getValue().intValue());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(saveIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.SAVE_ID, saveIDProperty.getPropertyName());
    assertSame(saveIDProperty, allProperties.get(0));
    assertSame(metadata, saveIDProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setSaveId(Integer)}
   */
  @Test
  void testSetSaveId2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setSaveId(1);

    // Assert
    IntegerType saveIDProperty = xmpMediaManagementSchema.getSaveIDProperty();
    assertEquals("1", saveIDProperty.getStringValue());
    assertEquals("xmpMM", saveIDProperty.getPrefix());
    assertNull(saveIDProperty.getNamespace());
    assertEquals(1, xmpMediaManagementSchema.getSaveID().intValue());
    assertEquals(1, saveIDProperty.getValue().intValue());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(saveIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.SAVE_ID, saveIDProperty.getPropertyName());
    assertSame(saveIDProperty, allProperties.get(1));
    assertSame(metadata, saveIDProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setSaveId(Integer)}
   */
  @Test
  void testSetSaveId3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setSaveId(1);

    // Assert
    IntegerType saveIDProperty = xmpMediaManagementSchema.getSaveIDProperty();
    assertEquals("1", saveIDProperty.getStringValue());
    assertEquals("xmpMM", saveIDProperty.getPrefix());
    assertNull(saveIDProperty.getNamespace());
    assertEquals(1, xmpMediaManagementSchema.getSaveID().intValue());
    assertEquals(1, saveIDProperty.getValue().intValue());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(saveIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.SAVE_ID, saveIDProperty.getPropertyName());
    assertSame(saveIDProperty, allProperties.get(2));
    assertSame(metadata, saveIDProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setSaveId(Integer)}
   */
  @Test
  void testSetSaveId4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.SAVE_ID, "42");

    // Act
    xmpMediaManagementSchema.setSaveId(1);

    // Assert
    IntegerType saveIDProperty = xmpMediaManagementSchema.getSaveIDProperty();
    assertEquals("1", saveIDProperty.getStringValue());
    assertEquals("xmpMM", saveIDProperty.getPrefix());
    assertNull(saveIDProperty.getNamespace());
    assertEquals(1, xmpMediaManagementSchema.getSaveID().intValue());
    assertEquals(1, saveIDProperty.getValue().intValue());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(saveIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.SAVE_ID, saveIDProperty.getPropertyName());
    assertSame(saveIDProperty, allProperties.get(0));
    assertSame(metadata, saveIDProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}
   */
  @Test
  void testSetSaveIDProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    IntegerType tt = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpMediaManagementSchema.setSaveIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}
   */
  @Test
  void testSetSaveIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("Value");
    IntegerType tt = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpMediaManagementSchema.setSaveIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}
   */
  @Test
  void testSetSaveIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);
    xmpMediaManagementSchema.addVersions("Value");
    IntegerType tt = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpMediaManagementSchema.setSaveIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}
   */
  @Test
  void testSetSaveIDProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.HISTORY);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);
    xmpMediaManagementSchema.addVersions("Value");
    IntegerType tt = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpMediaManagementSchema.setSaveIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getSaveIDProperty()}
   */
  @Test
  void testGetSaveIDProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getSaveIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getSaveIDProperty()}
   */
  @Test
  void testGetSaveIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getSaveIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getSaveIDProperty()}
   */
  @Test
  void testGetSaveIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getSaveIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getSaveID()}
   */
  @Test
  void testGetSaveID() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getSaveID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getSaveID()}
   */
  @Test
  void testGetSaveID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getSaveID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getSaveID()}
   */
  @Test
  void testGetSaveID3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getSaveID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManager(String)}
   */
  @Test
  void testSetManager() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setManager("42");

    // Assert
    TextType managerProperty = xmpMediaManagementSchema.getManagerProperty();
    assertTrue(managerProperty instanceof AgentNameType);
    assertEquals("42", xmpMediaManagementSchema.getManager());
    assertEquals("42", managerProperty.getStringValue());
    assertEquals("42", managerProperty.getRawValue());
    assertEquals("42", managerProperty.getValue());
    assertEquals("xmpMM", managerProperty.getPrefix());
    assertNull(managerProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(managerProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGER, managerProperty.getPropertyName());
    assertSame(metadata, managerProperty.getMetadata());
    assertSame(managerProperty, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManager(String)}
   */
  @Test
  void testSetManager2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManager("42");

    // Assert
    TextType managerProperty = xmpMediaManagementSchema.getManagerProperty();
    assertTrue(managerProperty instanceof AgentNameType);
    assertEquals("42", xmpMediaManagementSchema.getManager());
    assertEquals("42", managerProperty.getStringValue());
    assertEquals("42", managerProperty.getRawValue());
    assertEquals("42", managerProperty.getValue());
    assertEquals("xmpMM", managerProperty.getPrefix());
    assertNull(managerProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(managerProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGER, managerProperty.getPropertyName());
    assertSame(metadata, managerProperty.getMetadata());
    assertSame(managerProperty, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManager(String)}
   */
  @Test
  void testSetManager3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManager("42");

    // Assert
    TextType managerProperty = xmpMediaManagementSchema.getManagerProperty();
    assertTrue(managerProperty instanceof AgentNameType);
    assertEquals("42", xmpMediaManagementSchema.getManager());
    assertEquals("42", managerProperty.getStringValue());
    assertEquals("42", managerProperty.getRawValue());
    assertEquals("42", managerProperty.getValue());
    assertEquals("xmpMM", managerProperty.getPrefix());
    assertNull(managerProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(managerProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGER, managerProperty.getPropertyName());
    assertSame(metadata, managerProperty.getMetadata());
    assertSame(managerProperty, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManager(String)}
   */
  @Test
  void testSetManager4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.MANAGER, "42");

    // Act
    xmpMediaManagementSchema.setManager("42");

    // Assert
    TextType managerProperty = xmpMediaManagementSchema.getManagerProperty();
    assertTrue(managerProperty instanceof AgentNameType);
    assertEquals("42", xmpMediaManagementSchema.getManager());
    assertEquals("42", managerProperty.getStringValue());
    assertEquals("42", managerProperty.getRawValue());
    assertEquals("42", managerProperty.getValue());
    assertEquals("xmpMM", managerProperty.getPrefix());
    assertNull(managerProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(managerProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGER, managerProperty.getPropertyName());
    assertSame(metadata, managerProperty.getMetadata());
    assertSame(managerProperty, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}
   */
  @Test
  void testSetManagerProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    AgentNameType tt = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    xmpMediaManagementSchema.setManagerProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}
   */
  @Test
  void testSetManagerProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    AgentNameType tt = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    xmpMediaManagementSchema.setManagerProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}
   */
  @Test
  void testSetManagerProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    AgentNameType tt = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    xmpMediaManagementSchema.setManagerProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}
   */
  @Test
  void testSetManagerProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    AgentNameType tt = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    xmpMediaManagementSchema.setManagerProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManagerProperty()}
   */
  @Test
  void testGetManagerProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getManagerProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManagerProperty()}
   */
  @Test
  void testGetManagerProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManagerProperty()}
   */
  @Test
  void testGetManagerProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManager()}
   */
  @Test
  void testGetManager() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getManager());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManager()}
   */
  @Test
  void testGetManager2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManager());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManager()}
   */
  @Test
  void testGetManager3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManager());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManageTo(String)}
   */
  @Test
  void testSetManageTo() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setManageTo("42");

    // Assert
    TextType manageToProperty = xmpMediaManagementSchema.getManageToProperty();
    assertTrue(manageToProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageTo());
    assertEquals("42", manageToProperty.getStringValue());
    assertEquals("42", manageToProperty.getRawValue());
    assertEquals("42", manageToProperty.getValue());
    assertEquals("xmpMM", manageToProperty.getPrefix());
    assertNull(manageToProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(manageToProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGETO, manageToProperty.getPropertyName());
    assertSame(metadata, manageToProperty.getMetadata());
    assertSame(manageToProperty, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManageTo(String)}
   */
  @Test
  void testSetManageTo2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManageTo("42");

    // Assert
    TextType manageToProperty = xmpMediaManagementSchema.getManageToProperty();
    assertTrue(manageToProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageTo());
    assertEquals("42", manageToProperty.getStringValue());
    assertEquals("42", manageToProperty.getRawValue());
    assertEquals("42", manageToProperty.getValue());
    assertEquals("xmpMM", manageToProperty.getPrefix());
    assertNull(manageToProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(manageToProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGETO, manageToProperty.getPropertyName());
    assertSame(metadata, manageToProperty.getMetadata());
    assertSame(manageToProperty, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManageTo(String)}
   */
  @Test
  void testSetManageTo3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManageTo("42");

    // Assert
    TextType manageToProperty = xmpMediaManagementSchema.getManageToProperty();
    assertTrue(manageToProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageTo());
    assertEquals("42", manageToProperty.getStringValue());
    assertEquals("42", manageToProperty.getRawValue());
    assertEquals("42", manageToProperty.getValue());
    assertEquals("xmpMM", manageToProperty.getPrefix());
    assertNull(manageToProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(manageToProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGETO, manageToProperty.getPropertyName());
    assertSame(metadata, manageToProperty.getMetadata());
    assertSame(manageToProperty, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManageTo(String)}
   */
  @Test
  void testSetManageTo4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.MANAGETO, "42");

    // Act
    xmpMediaManagementSchema.setManageTo("42");

    // Assert
    TextType manageToProperty = xmpMediaManagementSchema.getManageToProperty();
    assertTrue(manageToProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageTo());
    assertEquals("42", manageToProperty.getStringValue());
    assertEquals("42", manageToProperty.getRawValue());
    assertEquals("42", manageToProperty.getValue());
    assertEquals("xmpMM", manageToProperty.getPrefix());
    assertNull(manageToProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(manageToProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGETO, manageToProperty.getPropertyName());
    assertSame(metadata, manageToProperty.getMetadata());
    assertSame(manageToProperty, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManageToProperty(URIType)}
   */
  @Test
  void testSetManageToProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageToProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManageToProperty(URIType)}
   */
  @Test
  void testSetManageToProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageToProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManageToProperty(URIType)}
   */
  @Test
  void testSetManageToProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageToProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManageToProperty(URIType)}
   */
  @Test
  void testSetManageToProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageToProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageToProperty()}
   */
  @Test
  void testGetManageToProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getManageToProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageToProperty()}
   */
  @Test
  void testGetManageToProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageToProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageToProperty()}
   */
  @Test
  void testGetManageToProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageToProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageTo()}
   */
  @Test
  void testGetManageTo() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getManageTo());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageTo()}
   */
  @Test
  void testGetManageTo2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageTo());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageTo()}
   */
  @Test
  void testGetManageTo3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageTo());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManageUI(String)}
   */
  @Test
  void testSetManageUI() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setManageUI("42");

    // Assert
    TextType manageUIProperty = xmpMediaManagementSchema.getManageUIProperty();
    assertTrue(manageUIProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageUI());
    assertEquals("42", manageUIProperty.getStringValue());
    assertEquals("42", manageUIProperty.getRawValue());
    assertEquals("42", manageUIProperty.getValue());
    assertEquals("xmpMM", manageUIProperty.getPrefix());
    assertNull(manageUIProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(manageUIProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGEUI, manageUIProperty.getPropertyName());
    assertSame(metadata, manageUIProperty.getMetadata());
    assertSame(manageUIProperty, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManageUI(String)}
   */
  @Test
  void testSetManageUI2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManageUI("42");

    // Assert
    TextType manageUIProperty = xmpMediaManagementSchema.getManageUIProperty();
    assertTrue(manageUIProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageUI());
    assertEquals("42", manageUIProperty.getStringValue());
    assertEquals("42", manageUIProperty.getRawValue());
    assertEquals("42", manageUIProperty.getValue());
    assertEquals("xmpMM", manageUIProperty.getPrefix());
    assertNull(manageUIProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(manageUIProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGEUI, manageUIProperty.getPropertyName());
    assertSame(metadata, manageUIProperty.getMetadata());
    assertSame(manageUIProperty, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManageUI(String)}
   */
  @Test
  void testSetManageUI3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManageUI("42");

    // Assert
    TextType manageUIProperty = xmpMediaManagementSchema.getManageUIProperty();
    assertTrue(manageUIProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageUI());
    assertEquals("42", manageUIProperty.getStringValue());
    assertEquals("42", manageUIProperty.getRawValue());
    assertEquals("42", manageUIProperty.getValue());
    assertEquals("xmpMM", manageUIProperty.getPrefix());
    assertNull(manageUIProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(manageUIProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGEUI, manageUIProperty.getPropertyName());
    assertSame(metadata, manageUIProperty.getMetadata());
    assertSame(manageUIProperty, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManageUI(String)}
   */
  @Test
  void testSetManageUI4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.MANAGEUI, "42");

    // Act
    xmpMediaManagementSchema.setManageUI("42");

    // Assert
    TextType manageUIProperty = xmpMediaManagementSchema.getManageUIProperty();
    assertTrue(manageUIProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageUI());
    assertEquals("42", manageUIProperty.getStringValue());
    assertEquals("42", manageUIProperty.getRawValue());
    assertEquals("42", manageUIProperty.getValue());
    assertEquals("xmpMM", manageUIProperty.getPrefix());
    assertNull(manageUIProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(manageUIProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGEUI, manageUIProperty.getPropertyName());
    assertSame(metadata, manageUIProperty.getMetadata());
    assertSame(manageUIProperty, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}
   */
  @Test
  void testSetManageUIProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageUIProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}
   */
  @Test
  void testSetManageUIProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageUIProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}
   */
  @Test
  void testSetManageUIProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageUIProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}
   */
  @Test
  void testSetManageUIProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageUIProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageUIProperty()}
   */
  @Test
  void testGetManageUIProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getManageUIProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageUIProperty()}
   */
  @Test
  void testGetManageUIProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageUIProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageUIProperty()}
   */
  @Test
  void testGetManageUIProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageUIProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageUI()}
   */
  @Test
  void testGetManageUI() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getManageUI());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageUI()}
   */
  @Test
  void testGetManageUI2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageUI());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManageUI()}
   */
  @Test
  void testGetManageUI3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageUI());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManagerVariant(String)}
   */
  @Test
  void testSetManagerVariant() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setManagerVariant("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getManagerVariant());
    TextType managerVariantProperty = xmpMediaManagementSchema.getManagerVariantProperty();
    assertEquals("42", managerVariantProperty.getStringValue());
    assertEquals("42", managerVariantProperty.getRawValue());
    assertEquals("42", managerVariantProperty.getValue());
    assertEquals("xmpMM", managerVariantProperty.getPrefix());
    assertNull(managerVariantProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(managerVariantProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGERVARIANT, managerVariantProperty.getPropertyName());
    assertSame(managerVariantProperty, allProperties.get(0));
    assertSame(metadata, managerVariantProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManagerVariant(String)}
   */
  @Test
  void testSetManagerVariant2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManagerVariant("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getManagerVariant());
    TextType managerVariantProperty = xmpMediaManagementSchema.getManagerVariantProperty();
    assertEquals("42", managerVariantProperty.getStringValue());
    assertEquals("42", managerVariantProperty.getRawValue());
    assertEquals("42", managerVariantProperty.getValue());
    assertEquals("xmpMM", managerVariantProperty.getPrefix());
    assertNull(managerVariantProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(managerVariantProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGERVARIANT, managerVariantProperty.getPropertyName());
    assertSame(managerVariantProperty, allProperties.get(1));
    assertSame(metadata, managerVariantProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManagerVariant(String)}
   */
  @Test
  void testSetManagerVariant3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManagerVariant("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getManagerVariant());
    TextType managerVariantProperty = xmpMediaManagementSchema.getManagerVariantProperty();
    assertEquals("42", managerVariantProperty.getStringValue());
    assertEquals("42", managerVariantProperty.getRawValue());
    assertEquals("42", managerVariantProperty.getValue());
    assertEquals("xmpMM", managerVariantProperty.getPrefix());
    assertNull(managerVariantProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(managerVariantProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGERVARIANT, managerVariantProperty.getPropertyName());
    assertSame(managerVariantProperty, allProperties.get(2));
    assertSame(metadata, managerVariantProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setManagerVariant(String)}
   */
  @Test
  void testSetManagerVariant4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.MANAGERVARIANT, "42");

    // Act
    xmpMediaManagementSchema.setManagerVariant("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getManagerVariant());
    TextType managerVariantProperty = xmpMediaManagementSchema.getManagerVariantProperty();
    assertEquals("42", managerVariantProperty.getStringValue());
    assertEquals("42", managerVariantProperty.getRawValue());
    assertEquals("42", managerVariantProperty.getValue());
    assertEquals("xmpMM", managerVariantProperty.getPrefix());
    assertNull(managerVariantProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(managerVariantProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGERVARIANT, managerVariantProperty.getPropertyName());
    assertSame(managerVariantProperty, allProperties.get(0));
    assertSame(metadata, managerVariantProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}
   */
  @Test
  void testSetManagerVariantProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerVariantProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}
   */
  @Test
  void testSetManagerVariantProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerVariantProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}
   */
  @Test
  void testSetManagerVariantProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerVariantProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}
   */
  @Test
  void testSetManagerVariantProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerVariantProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getManagerVariantProperty()}
   */
  @Test
  void testGetManagerVariantProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getManagerVariantProperty());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getManagerVariantProperty()}
   */
  @Test
  void testGetManagerVariantProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerVariantProperty());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getManagerVariantProperty()}
   */
  @Test
  void testGetManagerVariantProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerVariantProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManagerVariant()}
   */
  @Test
  void testGetManagerVariant() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getManagerVariant());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManagerVariant()}
   */
  @Test
  void testGetManagerVariant2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerVariant());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManagerVariant()}
   */
  @Test
  void testGetManagerVariant3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerVariant());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setInstanceID(String)}
   */
  @Test
  void testSetInstanceID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setInstanceID("42");

    // Assert
    TextType instanceIDProperty = xmpMediaManagementSchema.getInstanceIDProperty();
    assertTrue(instanceIDProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getInstanceID());
    assertEquals("42", instanceIDProperty.getStringValue());
    assertEquals("42", instanceIDProperty.getRawValue());
    assertEquals("42", instanceIDProperty.getValue());
    assertEquals("xmpMM", instanceIDProperty.getPrefix());
    assertNull(instanceIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(instanceIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.INSTANCEID, instanceIDProperty.getPropertyName());
    assertSame(metadata, instanceIDProperty.getMetadata());
    assertSame(instanceIDProperty, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setInstanceID(String)}
   */
  @Test
  void testSetInstanceID2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setInstanceID("42");

    // Assert
    TextType instanceIDProperty = xmpMediaManagementSchema.getInstanceIDProperty();
    assertTrue(instanceIDProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getInstanceID());
    assertEquals("42", instanceIDProperty.getStringValue());
    assertEquals("42", instanceIDProperty.getRawValue());
    assertEquals("42", instanceIDProperty.getValue());
    assertEquals("xmpMM", instanceIDProperty.getPrefix());
    assertNull(instanceIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(instanceIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.INSTANCEID, instanceIDProperty.getPropertyName());
    assertSame(metadata, instanceIDProperty.getMetadata());
    assertSame(instanceIDProperty, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setInstanceID(String)}
   */
  @Test
  void testSetInstanceID3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setInstanceID("42");

    // Assert
    TextType instanceIDProperty = xmpMediaManagementSchema.getInstanceIDProperty();
    assertTrue(instanceIDProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getInstanceID());
    assertEquals("42", instanceIDProperty.getStringValue());
    assertEquals("42", instanceIDProperty.getRawValue());
    assertEquals("42", instanceIDProperty.getValue());
    assertEquals("xmpMM", instanceIDProperty.getPrefix());
    assertNull(instanceIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(instanceIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.INSTANCEID, instanceIDProperty.getPropertyName());
    assertSame(metadata, instanceIDProperty.getMetadata());
    assertSame(instanceIDProperty, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setInstanceID(String)}
   */
  @Test
  void testSetInstanceID4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.INSTANCEID, "42");

    // Act
    xmpMediaManagementSchema.setInstanceID("42");

    // Assert
    TextType instanceIDProperty = xmpMediaManagementSchema.getInstanceIDProperty();
    assertTrue(instanceIDProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getInstanceID());
    assertEquals("42", instanceIDProperty.getStringValue());
    assertEquals("42", instanceIDProperty.getRawValue());
    assertEquals("42", instanceIDProperty.getValue());
    assertEquals("xmpMM", instanceIDProperty.getPrefix());
    assertNull(instanceIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(instanceIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.INSTANCEID, instanceIDProperty.getPropertyName());
    assertSame(metadata, instanceIDProperty.getMetadata());
    assertSame(instanceIDProperty, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}
   */
  @Test
  void testSetInstanceIDProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setInstanceIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}
   */
  @Test
  void testSetInstanceIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setInstanceIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}
   */
  @Test
  void testSetInstanceIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setInstanceIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}
   */
  @Test
  void testSetInstanceIDProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    URIType tt = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setInstanceIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getInstanceIDProperty()}
   */
  @Test
  void testGetInstanceIDProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getInstanceIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getInstanceIDProperty()}
   */
  @Test
  void testGetInstanceIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getInstanceIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getInstanceIDProperty()}
   */
  @Test
  void testGetInstanceIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getInstanceIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getInstanceID()}
   */
  @Test
  void testGetInstanceID() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getInstanceID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getInstanceID()}
   */
  @Test
  void testGetInstanceID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getInstanceID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getInstanceID()}
   */
  @Test
  void testGetInstanceID3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getInstanceID());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManagedFromProperty(ResourceRefType)}
   */
  @Test
  void testSetManagedFromProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    ResourceRefType resourceRef = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setManagedFromProperty(resourceRef);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(resourceRef, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManagedFromProperty(ResourceRefType)}
   */
  @Test
  void testSetManagedFromProperty2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");
    ResourceRefType resourceRef = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setManagedFromProperty(resourceRef);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult2.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", getResult2.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONS, getResult.getPropertyName());
    assertSame(resourceRef, allProperties.get(1));
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setManagedFromProperty(ResourceRefType)}
   */
  @Test
  void testSetManagedFromProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory("42");
    xmpMediaManagementSchema.addVersions("42");
    ResourceRefType resourceRef = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setManagedFromProperty(resourceRef);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult4 = allProperties3.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    List<String> elementsAsString2 = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("42", elementsAsString2.get(0));
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult4).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult4).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    assertEquals("42", ((TextType) getResult4).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult4.getNamespace());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", getResult2.getPrefix());
    assertEquals("xmpMM", getResult3.getPrefix());
    assertEquals("xmpMM", getResult4.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.HISTORY, getResult.getPropertyName());
    assertEquals(XMPMediaManagementSchema.VERSIONS, getResult2.getPropertyName());
    assertSame(resourceRef, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManagedFromProperty()}
   */
  @Test
  void testGetManagedFromProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getManagedFromProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManagedFromProperty()}
   */
  @Test
  void testGetManagedFromProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagedFromProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getManagedFromProperty()}
   */
  @Test
  void testGetManagedFromProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagedFromProperty());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}
   */
  @Test
  void testSetOriginalDocumentID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setOriginalDocumentID("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getOriginalDocumentID());
    TextType originalDocumentIDProperty = xmpMediaManagementSchema.getOriginalDocumentIDProperty();
    assertEquals("https://example.org/example", originalDocumentIDProperty.getStringValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getRawValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getValue());
    assertEquals("xmpMM", originalDocumentIDProperty.getPrefix());
    assertNull(originalDocumentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(originalDocumentIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.ORIGINALDOCUMENTID, originalDocumentIDProperty.getPropertyName());
    assertSame(originalDocumentIDProperty, allProperties.get(0));
    assertSame(metadata, originalDocumentIDProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}
   */
  @Test
  void testSetOriginalDocumentID2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentID("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getOriginalDocumentID());
    TextType originalDocumentIDProperty = xmpMediaManagementSchema.getOriginalDocumentIDProperty();
    assertEquals("https://example.org/example", originalDocumentIDProperty.getStringValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getRawValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getValue());
    assertEquals("xmpMM", originalDocumentIDProperty.getPrefix());
    assertNull(originalDocumentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(originalDocumentIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.ORIGINALDOCUMENTID, originalDocumentIDProperty.getPropertyName());
    assertSame(originalDocumentIDProperty, allProperties.get(1));
    assertSame(metadata, originalDocumentIDProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}
   */
  @Test
  void testSetOriginalDocumentID3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentID("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getOriginalDocumentID());
    TextType originalDocumentIDProperty = xmpMediaManagementSchema.getOriginalDocumentIDProperty();
    assertEquals("https://example.org/example", originalDocumentIDProperty.getStringValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getRawValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getValue());
    assertEquals("xmpMM", originalDocumentIDProperty.getPrefix());
    assertNull(originalDocumentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(originalDocumentIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.ORIGINALDOCUMENTID, originalDocumentIDProperty.getPropertyName());
    assertSame(originalDocumentIDProperty, allProperties.get(2));
    assertSame(metadata, originalDocumentIDProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}
   */
  @Test
  void testSetOriginalDocumentID4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.ORIGINALDOCUMENTID, "42");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentID("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getOriginalDocumentID());
    TextType originalDocumentIDProperty = xmpMediaManagementSchema.getOriginalDocumentIDProperty();
    assertEquals("https://example.org/example", originalDocumentIDProperty.getStringValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getRawValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getValue());
    assertEquals("xmpMM", originalDocumentIDProperty.getPrefix());
    assertNull(originalDocumentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(originalDocumentIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.ORIGINALDOCUMENTID, originalDocumentIDProperty.getPropertyName());
    assertSame(originalDocumentIDProperty, allProperties.get(0));
    assertSame(metadata, originalDocumentIDProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}
   */
  @Test
  void testSetOriginalDocumentIDProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}
   */
  @Test
  void testSetOriginalDocumentIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}
   */
  @Test
  void testSetOriginalDocumentIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}
   */
  @Test
  void testSetOriginalDocumentIDProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getOriginalDocumentIDProperty()}
   */
  @Test
  void testGetOriginalDocumentIDProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getOriginalDocumentIDProperty());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getOriginalDocumentIDProperty()}
   */
  @Test
  void testGetOriginalDocumentIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getOriginalDocumentIDProperty());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getOriginalDocumentIDProperty()}
   */
  @Test
  void testGetOriginalDocumentIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getOriginalDocumentIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getOriginalDocumentID()}
   */
  @Test
  void testGetOriginalDocumentID() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getOriginalDocumentID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getOriginalDocumentID()}
   */
  @Test
  void testGetOriginalDocumentID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getOriginalDocumentID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getOriginalDocumentID()}
   */
  @Test
  void testGetOriginalDocumentID3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getOriginalDocumentID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setRenditionClass(String)}
   */
  @Test
  void testSetRenditionClass() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setRenditionClass("42");

    // Assert
    TextType renditionClassProperty = xmpMediaManagementSchema.getRenditionClassProperty();
    assertTrue(renditionClassProperty instanceof RenditionClassType);
    assertEquals("42", xmpMediaManagementSchema.getRenditionClass());
    assertEquals("42", renditionClassProperty.getStringValue());
    assertEquals("42", renditionClassProperty.getRawValue());
    assertEquals("42", renditionClassProperty.getValue());
    assertEquals("xmpMM", renditionClassProperty.getPrefix());
    assertNull(renditionClassProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(renditionClassProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.RENDITIONCLASS, renditionClassProperty.getPropertyName());
    assertSame(metadata, renditionClassProperty.getMetadata());
    assertSame(renditionClassProperty, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setRenditionClass(String)}
   */
  @Test
  void testSetRenditionClass2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setRenditionClass("42");

    // Assert
    TextType renditionClassProperty = xmpMediaManagementSchema.getRenditionClassProperty();
    assertTrue(renditionClassProperty instanceof RenditionClassType);
    assertEquals("42", xmpMediaManagementSchema.getRenditionClass());
    assertEquals("42", renditionClassProperty.getStringValue());
    assertEquals("42", renditionClassProperty.getRawValue());
    assertEquals("42", renditionClassProperty.getValue());
    assertEquals("xmpMM", renditionClassProperty.getPrefix());
    assertNull(renditionClassProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(renditionClassProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.RENDITIONCLASS, renditionClassProperty.getPropertyName());
    assertSame(metadata, renditionClassProperty.getMetadata());
    assertSame(renditionClassProperty, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setRenditionClass(String)}
   */
  @Test
  void testSetRenditionClass3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setRenditionClass("42");

    // Assert
    TextType renditionClassProperty = xmpMediaManagementSchema.getRenditionClassProperty();
    assertTrue(renditionClassProperty instanceof RenditionClassType);
    assertEquals("42", xmpMediaManagementSchema.getRenditionClass());
    assertEquals("42", renditionClassProperty.getStringValue());
    assertEquals("42", renditionClassProperty.getRawValue());
    assertEquals("42", renditionClassProperty.getValue());
    assertEquals("xmpMM", renditionClassProperty.getPrefix());
    assertNull(renditionClassProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(renditionClassProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.RENDITIONCLASS, renditionClassProperty.getPropertyName());
    assertSame(metadata, renditionClassProperty.getMetadata());
    assertSame(renditionClassProperty, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setRenditionClass(String)}
   */
  @Test
  void testSetRenditionClass4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.RENDITIONCLASS, "42");

    // Act
    xmpMediaManagementSchema.setRenditionClass("42");

    // Assert
    TextType renditionClassProperty = xmpMediaManagementSchema.getRenditionClassProperty();
    assertTrue(renditionClassProperty instanceof RenditionClassType);
    assertEquals("42", xmpMediaManagementSchema.getRenditionClass());
    assertEquals("42", renditionClassProperty.getStringValue());
    assertEquals("42", renditionClassProperty.getRawValue());
    assertEquals("42", renditionClassProperty.getValue());
    assertEquals("xmpMM", renditionClassProperty.getPrefix());
    assertNull(renditionClassProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(renditionClassProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.RENDITIONCLASS, renditionClassProperty.getPropertyName());
    assertSame(metadata, renditionClassProperty.getMetadata());
    assertSame(renditionClassProperty, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}
   */
  @Test
  void testSetRenditionClassProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    RenditionClassType tt = new RenditionClassType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionClassProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}
   */
  @Test
  void testSetRenditionClassProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    RenditionClassType tt = new RenditionClassType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionClassProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}
   */
  @Test
  void testSetRenditionClassProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    RenditionClassType tt = new RenditionClassType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionClassProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}
   */
  @Test
  void testSetRenditionClassProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    RenditionClassType tt = new RenditionClassType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionClassProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getRenditionClassProperty()}
   */
  @Test
  void testGetRenditionClassProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getRenditionClassProperty());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getRenditionClassProperty()}
   */
  @Test
  void testGetRenditionClassProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionClassProperty());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getRenditionClassProperty()}
   */
  @Test
  void testGetRenditionClassProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionClassProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getRenditionClass()}
   */
  @Test
  void testGetRenditionClass() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getRenditionClass());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getRenditionClass()}
   */
  @Test
  void testGetRenditionClass2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionClass());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getRenditionClass()}
   */
  @Test
  void testGetRenditionClass3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionClass());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionParams(String)}
   */
  @Test
  void testSetRenditionParams() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setRenditionParams("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getRenditionParams());
    TextType renditionParamsProperty = xmpMediaManagementSchema.getRenditionParamsProperty();
    assertEquals("https://example.org/example", renditionParamsProperty.getStringValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getRawValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getValue());
    assertEquals("xmpMM", renditionParamsProperty.getPrefix());
    assertNull(renditionParamsProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(renditionParamsProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.RENDITIONPARAMS, renditionParamsProperty.getPropertyName());
    assertSame(renditionParamsProperty, allProperties.get(0));
    assertSame(metadata, renditionParamsProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionParams(String)}
   */
  @Test
  void testSetRenditionParams2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setRenditionParams("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getRenditionParams());
    TextType renditionParamsProperty = xmpMediaManagementSchema.getRenditionParamsProperty();
    assertEquals("https://example.org/example", renditionParamsProperty.getStringValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getRawValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getValue());
    assertEquals("xmpMM", renditionParamsProperty.getPrefix());
    assertNull(renditionParamsProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(renditionParamsProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.RENDITIONPARAMS, renditionParamsProperty.getPropertyName());
    assertSame(renditionParamsProperty, allProperties.get(1));
    assertSame(metadata, renditionParamsProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionParams(String)}
   */
  @Test
  void testSetRenditionParams3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setRenditionParams("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getRenditionParams());
    TextType renditionParamsProperty = xmpMediaManagementSchema.getRenditionParamsProperty();
    assertEquals("https://example.org/example", renditionParamsProperty.getStringValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getRawValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getValue());
    assertEquals("xmpMM", renditionParamsProperty.getPrefix());
    assertNull(renditionParamsProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(renditionParamsProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.RENDITIONPARAMS, renditionParamsProperty.getPropertyName());
    assertSame(renditionParamsProperty, allProperties.get(2));
    assertSame(metadata, renditionParamsProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionParams(String)}
   */
  @Test
  void testSetRenditionParams4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.RENDITIONPARAMS, "42");

    // Act
    xmpMediaManagementSchema.setRenditionParams("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getRenditionParams());
    TextType renditionParamsProperty = xmpMediaManagementSchema.getRenditionParamsProperty();
    assertEquals("https://example.org/example", renditionParamsProperty.getStringValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getRawValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getValue());
    assertEquals("xmpMM", renditionParamsProperty.getPrefix());
    assertNull(renditionParamsProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(renditionParamsProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.RENDITIONPARAMS, renditionParamsProperty.getPropertyName());
    assertSame(renditionParamsProperty, allProperties.get(0));
    assertSame(metadata, renditionParamsProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}
   */
  @Test
  void testSetRenditionParamsProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionParamsProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}
   */
  @Test
  void testSetRenditionParamsProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionParamsProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}
   */
  @Test
  void testSetRenditionParamsProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionParamsProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}
   */
  @Test
  void testSetRenditionParamsProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionParamsProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getRenditionParamsProperty()}
   */
  @Test
  void testGetRenditionParamsProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getRenditionParamsProperty());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getRenditionParamsProperty()}
   */
  @Test
  void testGetRenditionParamsProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionParamsProperty());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#getRenditionParamsProperty()}
   */
  @Test
  void testGetRenditionParamsProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionParamsProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getRenditionParams()}
   */
  @Test
  void testGetRenditionParams() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getRenditionParams());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getRenditionParams()}
   */
  @Test
  void testGetRenditionParams2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionParams());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getRenditionParams()}
   */
  @Test
  void testGetRenditionParams3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionParams());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setVersionID(String)}
   */
  @Test
  void testSetVersionID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setVersionID("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getVersionID());
    TextType versionIDProperty = xmpMediaManagementSchema.getVersionIDProperty();
    assertEquals("42", versionIDProperty.getStringValue());
    assertEquals("42", versionIDProperty.getRawValue());
    assertEquals("42", versionIDProperty.getValue());
    assertEquals("xmpMM", versionIDProperty.getPrefix());
    assertNull(versionIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(versionIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONID, versionIDProperty.getPropertyName());
    assertSame(versionIDProperty, allProperties.get(0));
    assertSame(metadata, versionIDProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setVersionID(String)}
   */
  @Test
  void testSetVersionID2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setVersionID("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getVersionID());
    TextType versionIDProperty = xmpMediaManagementSchema.getVersionIDProperty();
    assertEquals("42", versionIDProperty.getStringValue());
    assertEquals("42", versionIDProperty.getRawValue());
    assertEquals("42", versionIDProperty.getValue());
    assertEquals("xmpMM", versionIDProperty.getPrefix());
    assertNull(versionIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(versionIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONID, versionIDProperty.getPropertyName());
    assertSame(versionIDProperty, allProperties.get(1));
    assertSame(metadata, versionIDProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setVersionID(String)}
   */
  @Test
  void testSetVersionID3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setVersionID("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getVersionID());
    TextType versionIDProperty = xmpMediaManagementSchema.getVersionIDProperty();
    assertEquals("42", versionIDProperty.getStringValue());
    assertEquals("42", versionIDProperty.getRawValue());
    assertEquals("42", versionIDProperty.getValue());
    assertEquals("xmpMM", versionIDProperty.getPrefix());
    assertNull(versionIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(versionIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONID, versionIDProperty.getPropertyName());
    assertSame(versionIDProperty, allProperties.get(2));
    assertSame(metadata, versionIDProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#setVersionID(String)}
   */
  @Test
  void testSetVersionID4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.VERSIONID, "42");

    // Act
    xmpMediaManagementSchema.setVersionID("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getVersionID());
    TextType versionIDProperty = xmpMediaManagementSchema.getVersionIDProperty();
    assertEquals("42", versionIDProperty.getStringValue());
    assertEquals("42", versionIDProperty.getRawValue());
    assertEquals("42", versionIDProperty.getValue());
    assertEquals("xmpMM", versionIDProperty.getPrefix());
    assertNull(versionIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(versionIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONID, versionIDProperty.getPropertyName());
    assertSame(versionIDProperty, allProperties.get(0));
    assertSame(metadata, versionIDProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}
   */
  @Test
  void testSetVersionIDProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setVersionIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}
   */
  @Test
  void testSetVersionIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setVersionIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}
   */
  @Test
  void testSetVersionIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setVersionIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}
   */
  @Test
  void testSetVersionIDProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    TextType tt = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setVersionIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersionIDProperty()}
   */
  @Test
  void testGetVersionIDProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getVersionIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersionIDProperty()}
   */
  @Test
  void testGetVersionIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getVersionIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersionIDProperty()}
   */
  @Test
  void testGetVersionIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getVersionIDProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersionID()}
   */
  @Test
  void testGetVersionID() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getVersionID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersionID()}
   */
  @Test
  void testGetVersionID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getVersionID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersionID()}
   */
  @Test
  void testGetVersionID3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getVersionID());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addVersions(String)}
   */
  @Test
  void testAddVersions() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.addVersions("42");

    // Assert
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    List<AbstractField> allProperties = versionsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> versions = xmpMediaManagementSchema.getVersions();
    assertEquals(1, versions.size());
    assertEquals("42", versions.get(0));
    List<String> elementsAsString = versionsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", versionsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", versionsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, versionsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONS, versionsProperty.getPropertyName());
    assertSame(versionsProperty, allProperties2.get(0));
    assertSame(allProperties, versionsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, versionsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addVersions(String)}
   */
  @Test
  void testAddVersions2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addVersions("42");

    // Assert
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    List<AbstractField> allProperties = versionsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> versions = xmpMediaManagementSchema.getVersions();
    assertEquals(2, versions.size());
    assertEquals("42", versions.get(0));
    assertEquals("42", versions.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", versionsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", getResult2.getPrefix());
    assertEquals("xmpMM", versionsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, versionsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(versions, versionsProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.VERSIONS, versionsProperty.getPropertyName());
    assertSame(versionsProperty, allProperties2.get(0));
    assertSame(allProperties, versionsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, versionsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addVersions(String)}
   */
  @Test
  void testAddVersions3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory("li");
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addVersions("42");

    // Assert
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    List<AbstractField> allProperties = versionsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> versions = xmpMediaManagementSchema.getVersions();
    assertEquals(2, versions.size());
    assertEquals("42", versions.get(0));
    assertEquals("42", versions.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", versionsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", getResult2.getPrefix());
    assertEquals("xmpMM", versionsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, versionsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(versions, versionsProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.VERSIONS, versionsProperty.getPropertyName());
    assertSame(versionsProperty, allProperties2.get(1));
    assertSame(allProperties, versionsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, versionsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addVersions(String)}
   */
  @Test
  void testAddVersions4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);

    // Act
    xmpMediaManagementSchema.addVersions("42");

    // Assert
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    List<AbstractField> allProperties = versionsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> versions = xmpMediaManagementSchema.getVersions();
    assertEquals(1, versions.size());
    assertEquals("42", versions.get(0));
    List<String> elementsAsString = versionsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", versionsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", versionsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, versionsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONS, versionsProperty.getPropertyName());
    assertSame(versionsProperty, allProperties2.get(1));
    assertSame(allProperties, versionsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, versionsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addVersions(String)}
   */
  @Test
  void testAddVersions5() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);

    // Act
    xmpMediaManagementSchema.addVersions("42");

    // Assert
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    List<AbstractField> allProperties = versionsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> versions = xmpMediaManagementSchema.getVersions();
    assertEquals(1, versions.size());
    assertEquals("42", versions.get(0));
    List<String> elementsAsString = versionsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", versionsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", versionsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Bag, versionsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONS, versionsProperty.getPropertyName());
    assertSame(versionsProperty, allProperties2.get(2));
    assertSame(allProperties, versionsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, versionsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersionsProperty()}
   */
  @Test
  void testGetVersionsProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getVersionsProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersionsProperty()}
   */
  @Test
  void testGetVersionsProperty2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    ArrayProperty actualVersionsProperty = xmpMediaManagementSchema.getVersionsProperty();

    // Assert
    List<AbstractField> allProperties = actualVersionsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = actualVersionsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualVersionsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", actualVersionsProperty.getPrefix());
    assertEquals(Cardinality.Bag, actualVersionsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualVersionsProperty.getAllAttributes().isEmpty());
    assertTrue(actualVersionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONS, actualVersionsProperty.getPropertyName());
    assertSame(allProperties, actualVersionsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualVersionsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersionsProperty()}
   */
  @Test
  void testGetVersionsProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    ArrayProperty actualVersionsProperty = xmpMediaManagementSchema.getVersionsProperty();

    // Assert
    List<AbstractField> allProperties = actualVersionsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = actualVersionsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualVersionsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", actualVersionsProperty.getPrefix());
    assertEquals(Cardinality.Bag, actualVersionsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualVersionsProperty.getAllAttributes().isEmpty());
    assertTrue(actualVersionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONS, actualVersionsProperty.getPropertyName());
    assertSame(allProperties, actualVersionsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualVersionsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersions()}
   */
  @Test
  void testGetVersions() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getVersions());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersions()}
   */
  @Test
  void testGetVersions2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act
    List<String> actualVersions = xmpMediaManagementSchema.getVersions();

    // Assert
    assertEquals(1, actualVersions.size());
    assertEquals("42", actualVersions.get(0));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getVersions()}
   */
  @Test
  void testGetVersions3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    List<String> actualVersions = xmpMediaManagementSchema.getVersions();

    // Assert
    assertEquals(1, actualVersions.size());
    assertEquals("42", actualVersions.get(0));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addHistory(String)}
   */
  @Test
  void testAddHistory() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);

    // Assert
    ArrayProperty historyProperty = xmpMediaManagementSchema.getHistoryProperty();
    List<AbstractField> allProperties = historyProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", historyProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", historyProperty.getPrefix());
    assertNull(xmpMediaManagementSchema.getIngredientsProperty());
    assertNull(xmpMediaManagementSchema.getVersionsProperty());
    List<String> history = xmpMediaManagementSchema.getHistory();
    assertEquals(1, history.size());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    List<String> elementsAsString = historyProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Seq, historyProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertTrue(historyProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.HISTORY, history.get(0));
    assertEquals(XMPMediaManagementSchema.HISTORY, elementsAsString.get(0));
    assertEquals(XMPMediaManagementSchema.HISTORY, historyProperty.getPropertyName());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult).getStringValue());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult).getRawValue());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult).getValue());
    assertSame(historyProperty, allProperties2.get(0));
    assertSame(allProperties, historyProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addHistory(String)}
   */
  @Test
  void testAddHistory2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);

    // Assert
    ArrayProperty historyProperty = xmpMediaManagementSchema.getHistoryProperty();
    List<AbstractField> allProperties = historyProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", historyProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", historyProperty.getPrefix());
    assertNull(xmpMediaManagementSchema.getIngredientsProperty());
    List<String> history = xmpMediaManagementSchema.getHistory();
    assertEquals(1, history.size());
    List<String> elementsAsString = historyProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Seq, historyProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertTrue(historyProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.HISTORY, history.get(0));
    assertEquals(XMPMediaManagementSchema.HISTORY, elementsAsString.get(0));
    assertEquals(XMPMediaManagementSchema.HISTORY, historyProperty.getPropertyName());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult).getStringValue());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult).getRawValue());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult).getValue());
    assertSame(historyProperty, allProperties2.get(1));
    assertSame(versionsProperty, allProperties2.get(0));
    assertSame(allProperties, historyProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addHistory(String)}
   */
  @Test
  void testAddHistory3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);

    // Assert
    ArrayProperty historyProperty = xmpMediaManagementSchema.getHistoryProperty();
    List<AbstractField> allProperties = historyProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", historyProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", getResult2.getPrefix());
    assertEquals("xmpMM", historyProperty.getPrefix());
    assertNull(xmpMediaManagementSchema.getIngredientsProperty());
    List<String> history = xmpMediaManagementSchema.getHistory();
    assertEquals(2, history.size());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Seq, historyProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertTrue(historyProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(history, historyProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.HISTORY, history.get(1));
    assertEquals(XMPMediaManagementSchema.HISTORY, historyProperty.getPropertyName());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult2).getStringValue());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult2).getRawValue());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult2).getValue());
    assertEquals(XMPMediaManagementSchema.VERSIONS, history.get(0));
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getStringValue());
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getRawValue());
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getValue());
    assertSame(historyProperty, allProperties2.get(0));
    assertSame(versionsProperty, allProperties2.get(1));
    assertSame(allProperties, historyProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addHistory(String)}
   */
  @Test
  void testAddHistory4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);

    // Assert
    ArrayProperty historyProperty = xmpMediaManagementSchema.getHistoryProperty();
    List<AbstractField> allProperties = historyProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", historyProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", historyProperty.getPrefix());
    List<String> history = xmpMediaManagementSchema.getHistory();
    assertEquals(1, history.size());
    List<String> elementsAsString = historyProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Seq, historyProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertTrue(historyProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty ingredientsProperty = xmpMediaManagementSchema.getIngredientsProperty();
    assertTrue(ingredientsProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.HISTORY, history.get(0));
    assertEquals(XMPMediaManagementSchema.HISTORY, elementsAsString.get(0));
    assertEquals(XMPMediaManagementSchema.HISTORY, historyProperty.getPropertyName());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult).getStringValue());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult).getRawValue());
    assertEquals(XMPMediaManagementSchema.HISTORY, ((TextType) getResult).getValue());
    assertSame(historyProperty, allProperties2.get(2));
    assertSame(ingredientsProperty, allProperties2.get(0));
    assertSame(versionsProperty, allProperties2.get(1));
    assertSame(allProperties, historyProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getHistoryProperty()}
   */
  @Test
  void testGetHistoryProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getHistoryProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getHistoryProperty()}
   */
  @Test
  void testGetHistoryProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getHistoryProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getHistoryProperty()}
   */
  @Test
  void testGetHistoryProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    ArrayProperty actualHistoryProperty = xmpMediaManagementSchema.getHistoryProperty();

    // Assert
    List<AbstractField> allProperties = actualHistoryProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualHistoryProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", actualHistoryProperty.getPrefix());
    List<String> elementsAsString = actualHistoryProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Seq, actualHistoryProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualHistoryProperty.getAllAttributes().isEmpty());
    assertTrue(actualHistoryProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.HISTORY, actualHistoryProperty.getPropertyName());
    assertEquals(XMPMediaManagementSchema.VERSIONS, elementsAsString.get(0));
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getStringValue());
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getRawValue());
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getValue());
    assertSame(allProperties, actualHistoryProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualHistoryProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getHistory()}
   */
  @Test
  void testGetHistory() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getHistory());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getHistory()}
   */
  @Test
  void testGetHistory2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getHistory());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getHistory()}
   */
  @Test
  void testGetHistory3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    List<String> actualHistory = xmpMediaManagementSchema.getHistory();

    // Assert
    assertEquals(1, actualHistory.size());
    assertEquals(XMPMediaManagementSchema.VERSIONS, actualHistory.get(0));
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addIngredients(String)}
   */
  @Test
  void testAddIngredients() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.INGREDIENTS);

    // Assert
    ArrayProperty ingredientsProperty = xmpMediaManagementSchema.getIngredientsProperty();
    List<AbstractField> allProperties = ingredientsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", ingredientsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", ingredientsProperty.getPrefix());
    assertNull(xmpMediaManagementSchema.getVersionsProperty());
    List<String> ingredients = xmpMediaManagementSchema.getIngredients();
    assertEquals(1, ingredients.size());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    List<String> elementsAsString = ingredientsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, ingredientsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(ingredientsProperty.getAllAttributes().isEmpty());
    assertTrue(ingredientsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredients.get(0));
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, elementsAsString.get(0));
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredientsProperty.getPropertyName());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult).getStringValue());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult).getRawValue());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult).getValue());
    assertSame(ingredientsProperty, allProperties2.get(0));
    assertSame(allProperties, ingredientsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, ingredientsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addIngredients(String)}
   */
  @Test
  void testAddIngredients2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.INGREDIENTS);

    // Assert
    ArrayProperty ingredientsProperty = xmpMediaManagementSchema.getIngredientsProperty();
    List<AbstractField> allProperties = ingredientsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", ingredientsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", ingredientsProperty.getPrefix());
    List<String> ingredients = xmpMediaManagementSchema.getIngredients();
    assertEquals(1, ingredients.size());
    List<String> elementsAsString = ingredientsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, ingredientsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(ingredientsProperty.getAllAttributes().isEmpty());
    assertTrue(ingredientsProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredients.get(0));
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, elementsAsString.get(0));
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredientsProperty.getPropertyName());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult).getStringValue());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult).getRawValue());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult).getValue());
    assertSame(ingredientsProperty, allProperties2.get(1));
    assertSame(versionsProperty, allProperties2.get(0));
    assertSame(allProperties, ingredientsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, ingredientsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addIngredients(String)}
   */
  @Test
  void testAddIngredients3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.INGREDIENTS);

    // Assert
    ArrayProperty ingredientsProperty = xmpMediaManagementSchema.getIngredientsProperty();
    List<AbstractField> allProperties = ingredientsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", ingredientsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", ingredientsProperty.getPrefix());
    List<String> ingredients = xmpMediaManagementSchema.getIngredients();
    assertEquals(1, ingredients.size());
    List<String> elementsAsString = ingredientsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Bag, ingredientsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(ingredientsProperty.getAllAttributes().isEmpty());
    assertTrue(ingredientsProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredients.get(0));
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, elementsAsString.get(0));
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredientsProperty.getPropertyName());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult).getStringValue());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult).getRawValue());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult).getValue());
    assertSame(ingredientsProperty, allProperties2.get(2));
    assertSame(versionsProperty, allProperties2.get(1));
    assertSame(allProperties, ingredientsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, ingredientsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#addIngredients(String)}
   */
  @Test
  void testAddIngredients4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.INGREDIENTS);

    // Assert
    ArrayProperty ingredientsProperty = xmpMediaManagementSchema.getIngredientsProperty();
    List<AbstractField> allProperties = ingredientsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", ingredientsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", getResult2.getPrefix());
    assertEquals("xmpMM", ingredientsProperty.getPrefix());
    List<String> ingredients = xmpMediaManagementSchema.getIngredients();
    assertEquals(2, ingredients.size());
    List<AbstractField> allProperties2 = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, ingredientsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(ingredientsProperty.getAllAttributes().isEmpty());
    assertTrue(ingredientsProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(ingredients, ingredientsProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredients.get(1));
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredientsProperty.getPropertyName());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult2).getStringValue());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult2).getRawValue());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ((TextType) getResult2).getValue());
    assertEquals(XMPMediaManagementSchema.VERSIONS, ingredients.get(0));
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getStringValue());
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getRawValue());
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getValue());
    assertSame(ingredientsProperty, allProperties2.get(0));
    assertSame(versionsProperty, allProperties2.get(1));
    assertSame(allProperties, ingredientsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, ingredientsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getIngredientsProperty()}
   */
  @Test
  void testGetIngredientsProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getIngredientsProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getIngredientsProperty()}
   */
  @Test
  void testGetIngredientsProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getIngredientsProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getIngredientsProperty()}
   */
  @Test
  void testGetIngredientsProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getIngredientsProperty());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getIngredientsProperty()}
   */
  @Test
  void testGetIngredientsProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    ArrayProperty actualIngredientsProperty = xmpMediaManagementSchema.getIngredientsProperty();

    // Assert
    List<AbstractField> allProperties = actualIngredientsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualIngredientsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpMM", getResult.getPrefix());
    assertEquals("xmpMM", actualIngredientsProperty.getPrefix());
    List<String> elementsAsString = actualIngredientsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualIngredientsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualIngredientsProperty.getAllAttributes().isEmpty());
    assertTrue(actualIngredientsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, actualIngredientsProperty.getPropertyName());
    assertEquals(XMPMediaManagementSchema.VERSIONS, elementsAsString.get(0));
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getStringValue());
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getRawValue());
    assertEquals(XMPMediaManagementSchema.VERSIONS, ((TextType) getResult).getValue());
    assertSame(allProperties, actualIngredientsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualIngredientsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getIngredients()}
   */
  @Test
  void testGetIngredients() {
    // Arrange, Act and Assert
    assertNull((new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())).getIngredients());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getIngredients()}
   */
  @Test
  void testGetIngredients2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getIngredients());
  }

  /**
   * Method under test: {@link XMPMediaManagementSchema#getIngredients()}
   */
  @Test
  void testGetIngredients3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    List<String> actualIngredients = xmpMediaManagementSchema.getIngredients();

    // Assert
    assertEquals(1, actualIngredients.size());
    assertEquals(XMPMediaManagementSchema.VERSIONS, actualIngredients.get(0));
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)}
   */
  @Test
  void testNewXMPMediaManagementSchema() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPMediaManagementSchema actualXmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Assert
    assertEquals("", actualXmpMediaManagementSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualXmpMediaManagementSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpMediaManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmpMM", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/mm/"));
    assertEquals("xmpMM", actualXmpMediaManagementSchema.getPreferedPrefix());
    assertEquals("xmpMM", actualXmpMediaManagementSchema.getPrefix());
    assertNull(actualXmpMediaManagementSchema.getSaveID());
    assertNull(actualXmpMediaManagementSchema.getDocumentID());
    assertNull(actualXmpMediaManagementSchema.getInstanceID());
    assertNull(actualXmpMediaManagementSchema.getLastURL());
    assertNull(actualXmpMediaManagementSchema.getManageTo());
    assertNull(actualXmpMediaManagementSchema.getManageUI());
    assertNull(actualXmpMediaManagementSchema.getManager());
    assertNull(actualXmpMediaManagementSchema.getManagerVariant());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentID());
    assertNull(actualXmpMediaManagementSchema.getRenditionClass());
    assertNull(actualXmpMediaManagementSchema.getRenditionParams());
    assertNull(actualXmpMediaManagementSchema.getVersionID());
    assertNull(actualXmpMediaManagementSchema.getPropertyName());
    assertNull(actualXmpMediaManagementSchema.getHistory());
    assertNull(actualXmpMediaManagementSchema.getIngredients());
    assertNull(actualXmpMediaManagementSchema.getVersions());
    assertNull(actualXmpMediaManagementSchema.getHistoryProperty());
    assertNull(actualXmpMediaManagementSchema.getIngredientsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionsProperty());
    assertNull(actualXmpMediaManagementSchema.getAboutAttribute());
    assertNull(actualXmpMediaManagementSchema.getSaveIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManagedFromProperty());
    assertNull(actualXmpMediaManagementSchema.getResourceRefProperty());
    assertNull(actualXmpMediaManagementSchema.getDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getInstanceIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManageToProperty());
    assertNull(actualXmpMediaManagementSchema.getManageUIProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerVariantProperty());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionClassProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionParamsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionIDProperty());
    assertNull(actualXmpMediaManagementSchema.getLastURLProperty());
    List<AbstractField> allProperties = actualXmpMediaManagementSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpMediaManagementSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpMediaManagementSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpMediaManagementSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata, String)}
   */
  @Test
  void testNewXMPMediaManagementSchema2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPMediaManagementSchema actualXmpMediaManagementSchema = new XMPMediaManagementSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualXmpMediaManagementSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualXmpMediaManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Own Prefix", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/mm/"));
    assertEquals("Own Prefix", actualXmpMediaManagementSchema.getPrefix());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualXmpMediaManagementSchema.getNamespace());
    assertEquals("xmpMM", actualXmpMediaManagementSchema.getPreferedPrefix());
    assertNull(actualXmpMediaManagementSchema.getSaveID());
    assertNull(actualXmpMediaManagementSchema.getDocumentID());
    assertNull(actualXmpMediaManagementSchema.getInstanceID());
    assertNull(actualXmpMediaManagementSchema.getLastURL());
    assertNull(actualXmpMediaManagementSchema.getManageTo());
    assertNull(actualXmpMediaManagementSchema.getManageUI());
    assertNull(actualXmpMediaManagementSchema.getManager());
    assertNull(actualXmpMediaManagementSchema.getManagerVariant());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentID());
    assertNull(actualXmpMediaManagementSchema.getRenditionClass());
    assertNull(actualXmpMediaManagementSchema.getRenditionParams());
    assertNull(actualXmpMediaManagementSchema.getVersionID());
    assertNull(actualXmpMediaManagementSchema.getPropertyName());
    assertNull(actualXmpMediaManagementSchema.getHistory());
    assertNull(actualXmpMediaManagementSchema.getIngredients());
    assertNull(actualXmpMediaManagementSchema.getVersions());
    assertNull(actualXmpMediaManagementSchema.getHistoryProperty());
    assertNull(actualXmpMediaManagementSchema.getIngredientsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionsProperty());
    assertNull(actualXmpMediaManagementSchema.getAboutAttribute());
    assertNull(actualXmpMediaManagementSchema.getSaveIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManagedFromProperty());
    assertNull(actualXmpMediaManagementSchema.getResourceRefProperty());
    assertNull(actualXmpMediaManagementSchema.getDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getInstanceIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManageToProperty());
    assertNull(actualXmpMediaManagementSchema.getManageUIProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerVariantProperty());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionClassProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionParamsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionIDProperty());
    assertNull(actualXmpMediaManagementSchema.getLastURLProperty());
    List<AbstractField> allProperties = actualXmpMediaManagementSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpMediaManagementSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpMediaManagementSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpMediaManagementSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata, String)}
   */
  @Test
  void testNewXMPMediaManagementSchema3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPMediaManagementSchema actualXmpMediaManagementSchema = new XMPMediaManagementSchema(metadata, null);

    // Assert
    assertEquals("", actualXmpMediaManagementSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualXmpMediaManagementSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpMediaManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmpMM", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/mm/"));
    assertEquals("xmpMM", actualXmpMediaManagementSchema.getPreferedPrefix());
    assertEquals("xmpMM", actualXmpMediaManagementSchema.getPrefix());
    assertNull(actualXmpMediaManagementSchema.getSaveID());
    assertNull(actualXmpMediaManagementSchema.getDocumentID());
    assertNull(actualXmpMediaManagementSchema.getInstanceID());
    assertNull(actualXmpMediaManagementSchema.getLastURL());
    assertNull(actualXmpMediaManagementSchema.getManageTo());
    assertNull(actualXmpMediaManagementSchema.getManageUI());
    assertNull(actualXmpMediaManagementSchema.getManager());
    assertNull(actualXmpMediaManagementSchema.getManagerVariant());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentID());
    assertNull(actualXmpMediaManagementSchema.getRenditionClass());
    assertNull(actualXmpMediaManagementSchema.getRenditionParams());
    assertNull(actualXmpMediaManagementSchema.getVersionID());
    assertNull(actualXmpMediaManagementSchema.getPropertyName());
    assertNull(actualXmpMediaManagementSchema.getHistory());
    assertNull(actualXmpMediaManagementSchema.getIngredients());
    assertNull(actualXmpMediaManagementSchema.getVersions());
    assertNull(actualXmpMediaManagementSchema.getHistoryProperty());
    assertNull(actualXmpMediaManagementSchema.getIngredientsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionsProperty());
    assertNull(actualXmpMediaManagementSchema.getAboutAttribute());
    assertNull(actualXmpMediaManagementSchema.getSaveIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManagedFromProperty());
    assertNull(actualXmpMediaManagementSchema.getResourceRefProperty());
    assertNull(actualXmpMediaManagementSchema.getDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getInstanceIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManageToProperty());
    assertNull(actualXmpMediaManagementSchema.getManageUIProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerVariantProperty());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionClassProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionParamsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionIDProperty());
    assertNull(actualXmpMediaManagementSchema.getLastURLProperty());
    List<AbstractField> allProperties = actualXmpMediaManagementSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpMediaManagementSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpMediaManagementSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpMediaManagementSchema.getMetadata());
  }
}
