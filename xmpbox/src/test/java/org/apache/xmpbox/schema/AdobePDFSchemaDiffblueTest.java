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
import org.apache.xmpbox.type.TextType;
import org.junit.jupiter.api.Test;

class AdobePDFSchemaDiffblueTest {
  /**
   * Method under test: {@link AdobePDFSchema#setKeywords(String)}
   */
  @Test
  void testSetKeywords() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setKeywords("42");

    // Assert
    assertEquals("42", adobePDFSchema.getKeywords());
    TextType keywordsProperty = adobePDFSchema.getKeywordsProperty();
    assertEquals("42", keywordsProperty.getStringValue());
    assertEquals("42", keywordsProperty.getRawValue());
    assertEquals("42", keywordsProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", keywordsProperty.getNamespace());
    assertEquals("pdf", keywordsProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(keywordsProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, keywordsProperty.getPropertyName());
    assertSame(keywordsProperty, allProperties.get(0));
    assertSame(metadata, keywordsProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setKeywords(String)}
   */
  @Test
  void testSetKeywords2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act
    adobePDFSchema.setKeywords("42");

    // Assert
    assertEquals("42", adobePDFSchema.getKeywords());
    TextType keywordsProperty = adobePDFSchema.getKeywordsProperty();
    assertEquals("42", keywordsProperty.getStringValue());
    assertEquals("42", keywordsProperty.getRawValue());
    assertEquals("42", keywordsProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", keywordsProperty.getNamespace());
    assertEquals("pdf", keywordsProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(keywordsProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, keywordsProperty.getPropertyName());
    assertSame(keywordsProperty, allProperties.get(0));
    assertSame(metadata, keywordsProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setKeywords(String)}
   */
  @Test
  void testSetKeywords3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.KEYWORDS);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act
    adobePDFSchema.setKeywords("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getKeywords());
    TextType keywordsProperty = adobePDFSchema.getKeywordsProperty();
    assertEquals("42", keywordsProperty.getStringValue());
    assertEquals("42", keywordsProperty.getRawValue());
    assertEquals("42", keywordsProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", keywordsProperty.getNamespace());
    assertEquals("pdf", keywordsProperty.getPrefix());
    assertTrue(keywordsProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, keywordsProperty.getPropertyName());
    assertSame(keywordsProperty, allProperties.get(1));
    assertSame(metadata, keywordsProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setKeywords(String)}
   */
  @Test
  void testSetKeywords4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    adobePDFSchema.setKeywords("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getKeywords());
    TextType keywordsProperty = adobePDFSchema.getKeywordsProperty();
    assertEquals("42", keywordsProperty.getStringValue());
    assertEquals("42", keywordsProperty.getRawValue());
    assertEquals("42", keywordsProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", keywordsProperty.getNamespace());
    assertEquals("pdf", keywordsProperty.getPrefix());
    assertTrue(keywordsProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, keywordsProperty.getPropertyName());
    assertSame(keywordsProperty, allProperties.get(1));
    assertSame(metadata, keywordsProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setKeywordsProperty(TextType)}
   */
  @Test
  void testSetKeywordsProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    TextType keywords = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setKeywordsProperty(keywords);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(keywords, allProperties.get(0));
  }

  /**
   * Method under test: {@link AdobePDFSchema#setKeywordsProperty(TextType)}
   */
  @Test
  void testSetKeywordsProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    TextType keywords = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setKeywordsProperty(keywords);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
    assertSame(keywords, allProperties.get(1));
  }

  /**
   * Method under test: {@link AdobePDFSchema#setKeywordsProperty(TextType)}
   */
  @Test
  void testSetKeywordsProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Property Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    TextType keywords = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setKeywordsProperty(keywords);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
    assertSame(keywords, allProperties.get(1));
  }

  /**
   * Method under test: {@link AdobePDFSchema#setPDFVersion(String)}
   */
  @Test
  void testSetPDFVersion() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setPDFVersion("42");

    // Assert
    assertEquals("42", adobePDFSchema.getPDFVersion());
    TextType pDFVersionProperty = adobePDFSchema.getPDFVersionProperty();
    assertEquals("42", pDFVersionProperty.getStringValue());
    assertEquals("42", pDFVersionProperty.getRawValue());
    assertEquals("42", pDFVersionProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", pDFVersionProperty.getNamespace());
    assertEquals("pdf", pDFVersionProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(pDFVersionProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PDF_VERSION, pDFVersionProperty.getPropertyName());
    assertSame(pDFVersionProperty, allProperties.get(0));
    assertSame(metadata, pDFVersionProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setPDFVersion(String)}
   */
  @Test
  void testSetPDFVersion2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act
    adobePDFSchema.setPDFVersion("42");

    // Assert
    assertEquals("42", adobePDFSchema.getPDFVersion());
    TextType pDFVersionProperty = adobePDFSchema.getPDFVersionProperty();
    assertEquals("42", pDFVersionProperty.getStringValue());
    assertEquals("42", pDFVersionProperty.getRawValue());
    assertEquals("42", pDFVersionProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", pDFVersionProperty.getNamespace());
    assertEquals("pdf", pDFVersionProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(pDFVersionProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PDF_VERSION, pDFVersionProperty.getPropertyName());
    assertSame(pDFVersionProperty, allProperties.get(0));
    assertSame(metadata, pDFVersionProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setPDFVersion(String)}
   */
  @Test
  void testSetPDFVersion3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PDF_VERSION);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act
    adobePDFSchema.setPDFVersion("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getPDFVersion());
    TextType pDFVersionProperty = adobePDFSchema.getPDFVersionProperty();
    assertEquals("42", pDFVersionProperty.getStringValue());
    assertEquals("42", pDFVersionProperty.getRawValue());
    assertEquals("42", pDFVersionProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", pDFVersionProperty.getNamespace());
    assertEquals("pdf", pDFVersionProperty.getPrefix());
    assertTrue(pDFVersionProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PDF_VERSION, pDFVersionProperty.getPropertyName());
    assertSame(pDFVersionProperty, allProperties.get(1));
    assertSame(metadata, pDFVersionProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setPDFVersion(String)}
   */
  @Test
  void testSetPDFVersion4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    adobePDFSchema.setPDFVersion("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getPDFVersion());
    TextType pDFVersionProperty = adobePDFSchema.getPDFVersionProperty();
    assertEquals("42", pDFVersionProperty.getStringValue());
    assertEquals("42", pDFVersionProperty.getRawValue());
    assertEquals("42", pDFVersionProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", pDFVersionProperty.getNamespace());
    assertEquals("pdf", pDFVersionProperty.getPrefix());
    assertTrue(pDFVersionProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PDF_VERSION, pDFVersionProperty.getPropertyName());
    assertSame(pDFVersionProperty, allProperties.get(1));
    assertSame(metadata, pDFVersionProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setPDFVersionProperty(TextType)}
   */
  @Test
  void testSetPDFVersionProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    TextType version = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setPDFVersionProperty(version);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(version, allProperties.get(0));
  }

  /**
   * Method under test: {@link AdobePDFSchema#setPDFVersionProperty(TextType)}
   */
  @Test
  void testSetPDFVersionProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    TextType version = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setPDFVersionProperty(version);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
    assertSame(version, allProperties.get(1));
  }

  /**
   * Method under test: {@link AdobePDFSchema#setPDFVersionProperty(TextType)}
   */
  @Test
  void testSetPDFVersionProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Property Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    TextType version = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setPDFVersionProperty(version);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
    assertSame(version, allProperties.get(1));
  }

  /**
   * Method under test: {@link AdobePDFSchema#setProducer(String)}
   */
  @Test
  void testSetProducer() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setProducer("42");

    // Assert
    assertEquals("42", adobePDFSchema.getProducer());
    TextType producerProperty = adobePDFSchema.getProducerProperty();
    assertEquals("42", producerProperty.getStringValue());
    assertEquals("42", producerProperty.getRawValue());
    assertEquals("42", producerProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", producerProperty.getNamespace());
    assertEquals("pdf", producerProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(producerProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PRODUCER, producerProperty.getPropertyName());
    assertSame(producerProperty, allProperties.get(0));
    assertSame(metadata, producerProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setProducer(String)}
   */
  @Test
  void testSetProducer2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act
    adobePDFSchema.setProducer("42");

    // Assert
    assertEquals("42", adobePDFSchema.getProducer());
    TextType producerProperty = adobePDFSchema.getProducerProperty();
    assertEquals("42", producerProperty.getStringValue());
    assertEquals("42", producerProperty.getRawValue());
    assertEquals("42", producerProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", producerProperty.getNamespace());
    assertEquals("pdf", producerProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(producerProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PRODUCER, producerProperty.getPropertyName());
    assertSame(producerProperty, allProperties.get(0));
    assertSame(metadata, producerProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setProducer(String)}
   */
  @Test
  void testSetProducer3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PRODUCER);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act
    adobePDFSchema.setProducer("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getProducer());
    TextType producerProperty = adobePDFSchema.getProducerProperty();
    assertEquals("42", producerProperty.getStringValue());
    assertEquals("42", producerProperty.getRawValue());
    assertEquals("42", producerProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", producerProperty.getNamespace());
    assertEquals("pdf", producerProperty.getPrefix());
    assertTrue(producerProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PRODUCER, producerProperty.getPropertyName());
    assertSame(producerProperty, allProperties.get(1));
    assertSame(metadata, producerProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setProducer(String)}
   */
  @Test
  void testSetProducer4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    adobePDFSchema.setProducer("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getProducer());
    TextType producerProperty = adobePDFSchema.getProducerProperty();
    assertEquals("42", producerProperty.getStringValue());
    assertEquals("42", producerProperty.getRawValue());
    assertEquals("42", producerProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", producerProperty.getNamespace());
    assertEquals("pdf", producerProperty.getPrefix());
    assertTrue(producerProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PRODUCER, producerProperty.getPropertyName());
    assertSame(producerProperty, allProperties.get(1));
    assertSame(metadata, producerProperty.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#setProducerProperty(TextType)}
   */
  @Test
  void testSetProducerProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    TextType producer = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setProducerProperty(producer);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(producer, allProperties.get(0));
  }

  /**
   * Method under test: {@link AdobePDFSchema#setProducerProperty(TextType)}
   */
  @Test
  void testSetProducerProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    TextType producer = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setProducerProperty(producer);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
    assertSame(producer, allProperties.get(1));
  }

  /**
   * Method under test: {@link AdobePDFSchema#setProducerProperty(TextType)}
   */
  @Test
  void testSetProducerProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Property Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    TextType producer = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setProducerProperty(producer);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
    assertSame(producer, allProperties.get(1));
  }

  /**
   * Method under test: {@link AdobePDFSchema#getKeywordsProperty()}
   */
  @Test
  void testGetKeywordsProperty() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getKeywordsProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getKeywordsProperty()}
   */
  @Test
  void testGetKeywordsProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getKeywordsProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getKeywordsProperty()}
   */
  @Test
  void testGetKeywordsProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.KEYWORDS);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getKeywordsProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getKeywordsProperty()}
   */
  @Test
  void testGetKeywordsProperty4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.KEYWORDS,
        AdobePDFSchema.KEYWORDS, AdobePDFSchema.KEYWORDS, "Value");

    adobePDFSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, adobePDFSchema.getKeywordsProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getKeywords()}
   */
  @Test
  void testGetKeywords() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getKeywords());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getKeywords()}
   */
  @Test
  void testGetKeywords2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getKeywords());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getKeywords()}
   */
  @Test
  void testGetKeywords3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.KEYWORDS);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getKeywords());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getKeywords()}
   */
  @Test
  void testGetKeywords4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.KEYWORDS,
        AdobePDFSchema.KEYWORDS, AdobePDFSchema.KEYWORDS, "Value"));

    // Act and Assert
    assertEquals("Value", adobePDFSchema.getKeywords());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getPDFVersionProperty()}
   */
  @Test
  void testGetPDFVersionProperty() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPDFVersionProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getPDFVersionProperty()}
   */
  @Test
  void testGetPDFVersionProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getPDFVersionProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getPDFVersionProperty()}
   */
  @Test
  void testGetPDFVersionProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PDF_VERSION);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getPDFVersionProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getPDFVersionProperty()}
   */
  @Test
  void testGetPDFVersionProperty4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.PDF_VERSION,
        AdobePDFSchema.PDF_VERSION, AdobePDFSchema.PDF_VERSION, "Value");

    adobePDFSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, adobePDFSchema.getPDFVersionProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getPDFVersion()}
   */
  @Test
  void testGetPDFVersion() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPDFVersion());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getPDFVersion()}
   */
  @Test
  void testGetPDFVersion2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getPDFVersion());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getPDFVersion()}
   */
  @Test
  void testGetPDFVersion3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PDF_VERSION);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getPDFVersion());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getPDFVersion()}
   */
  @Test
  void testGetPDFVersion4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.PDF_VERSION,
        AdobePDFSchema.PDF_VERSION, AdobePDFSchema.PDF_VERSION, "Value"));

    // Act and Assert
    assertEquals("Value", adobePDFSchema.getPDFVersion());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getProducerProperty()}
   */
  @Test
  void testGetProducerProperty() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getProducerProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getProducerProperty()}
   */
  @Test
  void testGetProducerProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getProducerProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getProducerProperty()}
   */
  @Test
  void testGetProducerProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PRODUCER);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getProducerProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getProducerProperty()}
   */
  @Test
  void testGetProducerProperty4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.PRODUCER,
        AdobePDFSchema.PRODUCER, AdobePDFSchema.PRODUCER, "Value");

    adobePDFSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, adobePDFSchema.getProducerProperty());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getProducer()}
   */
  @Test
  void testGetProducer() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getProducer());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getProducer()}
   */
  @Test
  void testGetProducer2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getProducer());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getProducer()}
   */
  @Test
  void testGetProducer3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PRODUCER);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getProducer());
  }

  /**
   * Method under test: {@link AdobePDFSchema#getProducer()}
   */
  @Test
  void testGetProducer4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.PRODUCER,
        AdobePDFSchema.PRODUCER, AdobePDFSchema.PRODUCER, "Value"));

    // Act and Assert
    assertEquals("Value", adobePDFSchema.getProducer());
  }

  /**
   * Method under test: {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)}
   */
  @Test
  void testNewAdobePDFSchema() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AdobePDFSchema actualAdobePDFSchema = new AdobePDFSchema(metadata);

    // Assert
    assertEquals("", actualAdobePDFSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualAdobePDFSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualAdobePDFSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("pdf", allNamespacesWithPrefix.get("http://ns.adobe.com/pdf/1.3/"));
    assertEquals("pdf", actualAdobePDFSchema.getPreferedPrefix());
    assertEquals("pdf", actualAdobePDFSchema.getPrefix());
    assertNull(actualAdobePDFSchema.getKeywords());
    assertNull(actualAdobePDFSchema.getPDFVersion());
    assertNull(actualAdobePDFSchema.getProducer());
    assertNull(actualAdobePDFSchema.getPropertyName());
    assertNull(actualAdobePDFSchema.getAboutAttribute());
    assertNull(actualAdobePDFSchema.getKeywordsProperty());
    assertNull(actualAdobePDFSchema.getPDFVersionProperty());
    assertNull(actualAdobePDFSchema.getProducerProperty());
    List<AbstractField> allProperties = actualAdobePDFSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualAdobePDFSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualAdobePDFSchema.getContainer().getAllProperties());
    assertSame(metadata, actualAdobePDFSchema.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata, String)}
   */
  @Test
  void testNewAdobePDFSchema2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AdobePDFSchema actualAdobePDFSchema = new AdobePDFSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualAdobePDFSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualAdobePDFSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Own Prefix", allNamespacesWithPrefix.get("http://ns.adobe.com/pdf/1.3/"));
    assertEquals("Own Prefix", actualAdobePDFSchema.getPrefix());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualAdobePDFSchema.getNamespace());
    assertEquals("pdf", actualAdobePDFSchema.getPreferedPrefix());
    assertNull(actualAdobePDFSchema.getKeywords());
    assertNull(actualAdobePDFSchema.getPDFVersion());
    assertNull(actualAdobePDFSchema.getProducer());
    assertNull(actualAdobePDFSchema.getPropertyName());
    assertNull(actualAdobePDFSchema.getAboutAttribute());
    assertNull(actualAdobePDFSchema.getKeywordsProperty());
    assertNull(actualAdobePDFSchema.getPDFVersionProperty());
    assertNull(actualAdobePDFSchema.getProducerProperty());
    List<AbstractField> allProperties = actualAdobePDFSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualAdobePDFSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualAdobePDFSchema.getContainer().getAllProperties());
    assertSame(metadata, actualAdobePDFSchema.getMetadata());
  }

  /**
   * Method under test: {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata, String)}
   */
  @Test
  void testNewAdobePDFSchema3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AdobePDFSchema actualAdobePDFSchema = new AdobePDFSchema(metadata, null);

    // Assert
    assertEquals("", actualAdobePDFSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualAdobePDFSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualAdobePDFSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("pdf", allNamespacesWithPrefix.get("http://ns.adobe.com/pdf/1.3/"));
    assertEquals("pdf", actualAdobePDFSchema.getPreferedPrefix());
    assertEquals("pdf", actualAdobePDFSchema.getPrefix());
    assertNull(actualAdobePDFSchema.getKeywords());
    assertNull(actualAdobePDFSchema.getPDFVersion());
    assertNull(actualAdobePDFSchema.getProducer());
    assertNull(actualAdobePDFSchema.getPropertyName());
    assertNull(actualAdobePDFSchema.getAboutAttribute());
    assertNull(actualAdobePDFSchema.getKeywordsProperty());
    assertNull(actualAdobePDFSchema.getPDFVersionProperty());
    assertNull(actualAdobePDFSchema.getProducerProperty());
    List<AbstractField> allProperties = actualAdobePDFSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualAdobePDFSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualAdobePDFSchema.getContainer().getAllProperties());
    assertSame(metadata, actualAdobePDFSchema.getMetadata());
  }
}
