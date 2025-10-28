package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.IntegerType;
import org.apache.xmpbox.type.TextType;
import org.junit.jupiter.api.Test;

class PDFAIdentificationSchemaDiffblueTest {
  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setPartValueWithString(String)}
   */
  @Test
  void testSetPartValueWithString() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);

    // Act
    pdfaIdentificationSchema.setPartValueWithString("42");

    // Assert
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("42", partProperty.getRawValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(0));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setPartValueWithString(String)}
   */
  @Test
  void testSetPartValueWithString2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act
    pdfaIdentificationSchema.setPartValueWithString("42");

    // Assert
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("42", partProperty.getRawValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(0));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setPartValueWithString(String)}
   */
  @Test
  void testSetPartValueWithString3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.PART);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act
    pdfaIdentificationSchema.setPartValueWithString("42");

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("42", partProperty.getRawValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(1));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setPartValueWithString(String)}
   */
  @Test
  void testSetPartValueWithString4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    pdfaIdentificationSchema.setPartValueWithString("42");

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("42", partProperty.getRawValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(1));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setPartValueWithInt(int)}
   */
  @Test
  void testSetPartValueWithInt() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);

    // Act
    pdfaIdentificationSchema.setPartValueWithInt(42);

    // Assert
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(0));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setPartValueWithInt(int)}
   */
  @Test
  void testSetPartValueWithInt2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act
    pdfaIdentificationSchema.setPartValueWithInt(42);

    // Assert
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(0));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setPartValueWithInt(int)}
   */
  @Test
  void testSetPartValueWithInt3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.PART);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act
    pdfaIdentificationSchema.setPartValueWithInt(42);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(1));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setPartValueWithInt(int)}
   */
  @Test
  void testSetPartValueWithInt4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    pdfaIdentificationSchema.setPartValueWithInt(42);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(1));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setPart(Integer)}
   */
  @Test
  void testSetPart() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);

    // Act
    pdfaIdentificationSchema.setPart(42);

    // Assert
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(0));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setPart(Integer)}
   */
  @Test
  void testSetPart2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act
    pdfaIdentificationSchema.setPart(42);

    // Assert
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(0));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setPart(Integer)}
   */
  @Test
  void testSetPart3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.PART);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act
    pdfaIdentificationSchema.setPart(42);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(1));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setPart(Integer)}
   */
  @Test
  void testSetPart4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    pdfaIdentificationSchema.setPart(42);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    IntegerType partProperty = pdfaIdentificationSchema.getPartProperty();
    assertEquals("42", partProperty.getStringValue());
    assertEquals("pdfaid", partProperty.getPrefix());
    assertNull(partProperty.getNamespace());
    assertEquals(42, pdfaIdentificationSchema.getPart().intValue());
    assertEquals(42, partProperty.getValue().intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(1));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}
   */
  @Test
  void testSetPartProperty() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    IntegerType part = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    pdfaIdentificationSchema.setPartProperty(part);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(part, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}
   */
  @Test
  void testSetPartProperty2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("A", "Bag Value");
    IntegerType part = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    pdfaIdentificationSchema.setPartProperty(part);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(part, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}
   */
  @Test
  void testSetPartProperty3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", "Property Name");
    pdfaIdentificationSchema.addBagValueAsSimple("A", "Bag Value");
    IntegerType part = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    pdfaIdentificationSchema.setPartProperty(part);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(part, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}
   */
  @Test
  void testSetPartProperty4() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Property Name", "Bag Value");
    IntegerType part = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    pdfaIdentificationSchema.setPartProperty(part);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(part, allProperties.get(0));
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setAmd(String)}
   */
  @Test
  void testSetAmd() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);

    // Act
    pdfaIdentificationSchema.setAmd("42");

    // Assert
    assertEquals("42", pdfaIdentificationSchema.getAmd());
    assertEquals("42", pdfaIdentificationSchema.getAmendment());
    TextType amdProperty = pdfaIdentificationSchema.getAmdProperty();
    assertEquals("42", amdProperty.getStringValue());
    assertEquals("42", amdProperty.getRawValue());
    assertEquals("42", amdProperty.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", amdProperty.getNamespace());
    assertEquals("pdfaid", amdProperty.getPrefix());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(amdProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.AMD, amdProperty.getPropertyName());
    assertSame(amdProperty, allProperties.get(0));
    assertSame(metadata, amdProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setAmd(String)}
   */
  @Test
  void testSetAmd2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act
    pdfaIdentificationSchema.setAmd("42");

    // Assert
    assertEquals("42", pdfaIdentificationSchema.getAmd());
    assertEquals("42", pdfaIdentificationSchema.getAmendment());
    TextType amdProperty = pdfaIdentificationSchema.getAmdProperty();
    assertEquals("42", amdProperty.getStringValue());
    assertEquals("42", amdProperty.getRawValue());
    assertEquals("42", amdProperty.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", amdProperty.getNamespace());
    assertEquals("pdfaid", amdProperty.getPrefix());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(amdProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.AMD, amdProperty.getPropertyName());
    assertSame(amdProperty, allProperties.get(0));
    assertSame(metadata, amdProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setAmd(String)}
   */
  @Test
  void testSetAmd3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.AMD);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act
    pdfaIdentificationSchema.setAmd("42");

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", pdfaIdentificationSchema.getAmd());
    assertEquals("42", pdfaIdentificationSchema.getAmendment());
    TextType amdProperty = pdfaIdentificationSchema.getAmdProperty();
    assertEquals("42", amdProperty.getStringValue());
    assertEquals("42", amdProperty.getRawValue());
    assertEquals("42", amdProperty.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", amdProperty.getNamespace());
    assertEquals("pdfaid", amdProperty.getPrefix());
    assertTrue(amdProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.AMD, amdProperty.getPropertyName());
    assertSame(amdProperty, allProperties.get(1));
    assertSame(metadata, amdProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setAmd(String)}
   */
  @Test
  void testSetAmd4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    pdfaIdentificationSchema.setAmd("42");

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", pdfaIdentificationSchema.getAmd());
    assertEquals("42", pdfaIdentificationSchema.getAmendment());
    TextType amdProperty = pdfaIdentificationSchema.getAmdProperty();
    assertEquals("42", amdProperty.getStringValue());
    assertEquals("42", amdProperty.getRawValue());
    assertEquals("42", amdProperty.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", amdProperty.getNamespace());
    assertEquals("pdfaid", amdProperty.getPrefix());
    assertTrue(amdProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.AMD, amdProperty.getPropertyName());
    assertSame(amdProperty, allProperties.get(1));
    assertSame(metadata, amdProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setAmdProperty(TextType)}
   */
  @Test
  void testSetAmdProperty() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    TextType amd = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    pdfaIdentificationSchema.setAmdProperty(amd);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(amd, allProperties.get(0));
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setAmdProperty(TextType)}
   */
  @Test
  void testSetAmdProperty2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", "42");
    TextType amd = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    pdfaIdentificationSchema.setAmdProperty(amd);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
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
    assertSame(amd, allProperties.get(1));
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setAmdProperty(TextType)}
   */
  @Test
  void testSetAmdProperty3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Property Name", "Simple Name");
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", "42");
    TextType amd = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    pdfaIdentificationSchema.setAmdProperty(amd);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
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
    assertSame(amd, allProperties.get(1));
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  void testSetConformance() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertThrows(BadFieldValueException.class,
        () -> (new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata())).setConformance("42"));
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  void testSetConformance2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);

    // Act
    pdfaIdentificationSchema.setConformance("A");

    // Assert
    assertEquals("A", pdfaIdentificationSchema.getConformance());
    TextType conformanceProperty = pdfaIdentificationSchema.getConformanceProperty();
    assertEquals("A", conformanceProperty.getStringValue());
    assertEquals("A", conformanceProperty.getRawValue());
    assertEquals("A", conformanceProperty.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", conformanceProperty.getNamespace());
    assertEquals("pdfaid", conformanceProperty.getPrefix());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(conformanceProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.CONFORMANCE, conformanceProperty.getPropertyName());
    assertSame(conformanceProperty, allProperties.get(0));
    assertSame(metadata, conformanceProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  void testSetConformance3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);

    // Act
    pdfaIdentificationSchema.setConformance("B");

    // Assert
    assertEquals("B", pdfaIdentificationSchema.getConformance());
    TextType conformanceProperty = pdfaIdentificationSchema.getConformanceProperty();
    assertEquals("B", conformanceProperty.getStringValue());
    assertEquals("B", conformanceProperty.getRawValue());
    assertEquals("B", conformanceProperty.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", conformanceProperty.getNamespace());
    assertEquals("pdfaid", conformanceProperty.getPrefix());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(conformanceProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.CONFORMANCE, conformanceProperty.getPropertyName());
    assertSame(conformanceProperty, allProperties.get(0));
    assertSame(metadata, conformanceProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  void testSetConformance4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);

    // Act
    pdfaIdentificationSchema.setConformance("U");

    // Assert
    assertEquals("U", pdfaIdentificationSchema.getConformance());
    TextType conformanceProperty = pdfaIdentificationSchema.getConformanceProperty();
    assertEquals("U", conformanceProperty.getStringValue());
    assertEquals("U", conformanceProperty.getRawValue());
    assertEquals("U", conformanceProperty.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", conformanceProperty.getNamespace());
    assertEquals("pdfaid", conformanceProperty.getPrefix());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(conformanceProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.CONFORMANCE, conformanceProperty.getPropertyName());
    assertSame(conformanceProperty, allProperties.get(0));
    assertSame(metadata, conformanceProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  void testSetConformance5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple("A", "42");

    // Act
    pdfaIdentificationSchema.setConformance("A");

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
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
    assertEquals("A", pdfaIdentificationSchema.getConformance());
    assertEquals("A", getResult.getPropertyName());
    TextType conformanceProperty = pdfaIdentificationSchema.getConformanceProperty();
    assertEquals("A", conformanceProperty.getStringValue());
    assertEquals("A", conformanceProperty.getRawValue());
    assertEquals("A", conformanceProperty.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", conformanceProperty.getNamespace());
    assertEquals("pdfaid", conformanceProperty.getPrefix());
    assertTrue(conformanceProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.CONFORMANCE, conformanceProperty.getPropertyName());
    assertSame(conformanceProperty, allProperties.get(1));
    assertSame(metadata, conformanceProperty.getMetadata());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  void testSetConformance6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.CONFORMANCE, "A");
    pdfaIdentificationSchema.addBagValueAsSimple("A", "42");

    // Act
    pdfaIdentificationSchema.setConformance("A");

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
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
    assertEquals("A", pdfaIdentificationSchema.getConformance());
    assertEquals("A", getResult.getPropertyName());
    TextType conformanceProperty = pdfaIdentificationSchema.getConformanceProperty();
    assertEquals("A", conformanceProperty.getStringValue());
    assertEquals("A", conformanceProperty.getRawValue());
    assertEquals("A", conformanceProperty.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", conformanceProperty.getNamespace());
    assertEquals("pdfaid", conformanceProperty.getPrefix());
    assertTrue(conformanceProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.CONFORMANCE, conformanceProperty.getPropertyName());
    assertSame(conformanceProperty, allProperties.get(1));
    assertSame(metadata, conformanceProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  void testSetConformanceProperty() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> pdfaIdentificationSchema.setConformanceProperty(
        new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value")));
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  void testSetConformanceProperty2() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());

    TextType conf = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");
    conf.setValue("A");

    // Act
    pdfaIdentificationSchema.setConformanceProperty(conf);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(conf, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  void testSetConformanceProperty3() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());

    TextType conf = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");
    conf.setValue("B");

    // Act
    pdfaIdentificationSchema.setConformanceProperty(conf);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(conf, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  void testSetConformanceProperty4() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());

    TextType conf = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");
    conf.setValue("U");

    // Act
    pdfaIdentificationSchema.setConformanceProperty(conf);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(conf, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  void testSetConformanceProperty5() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("A", "42");

    TextType conf = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");
    conf.setValue("A");

    // Act
    pdfaIdentificationSchema.setConformanceProperty(conf);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
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
    assertEquals("A", getResult.getPropertyName());
    assertSame(conf, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  void testSetConformanceProperty6() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Property Name", "A");
    pdfaIdentificationSchema.addBagValueAsSimple("A", "42");

    TextType conf = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");
    conf.setValue("A");

    // Act
    pdfaIdentificationSchema.setConformanceProperty(conf);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
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
    assertEquals("A", getResult.getPropertyName());
    assertSame(conf, allProperties.get(1));
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getPart()}
   */
  @Test
  void testGetPart() {
    // Arrange, Act and Assert
    assertNull((new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata())).getPart());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getPart()}
   */
  @Test
  void testGetPart2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getPart());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getPart()}
   */
  @Test
  void testGetPart3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.PART);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getPart());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getPartProperty()}
   */
  @Test
  void testGetPartProperty() {
    // Arrange, Act and Assert
    assertNull((new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata())).getPartProperty());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getPartProperty()}
   */
  @Test
  void testGetPartProperty2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getPartProperty());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getPartProperty()}
   */
  @Test
  void testGetPartProperty3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.PART);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getPartProperty());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmendment()}
   */
  @Test
  void testGetAmendment() {
    // Arrange, Act and Assert
    assertNull((new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata())).getAmendment());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmendment()}
   */
  @Test
  void testGetAmendment2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmendment());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmendment()}
   */
  @Test
  void testGetAmendment3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.AMD);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmendment());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmendment()}
   */
  @Test
  void testGetAmendment4() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(),
        PDFAIdentificationSchema.AMD, PDFAIdentificationSchema.AMD, PDFAIdentificationSchema.AMD, "Value"));

    // Act and Assert
    assertEquals("Value", pdfaIdentificationSchema.getAmendment());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmdProperty()}
   */
  @Test
  void testGetAmdProperty() {
    // Arrange, Act and Assert
    assertNull((new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata())).getAmdProperty());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmdProperty()}
   */
  @Test
  void testGetAmdProperty2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmdProperty());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmdProperty()}
   */
  @Test
  void testGetAmdProperty3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.AMD);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmdProperty());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmdProperty()}
   */
  @Test
  void testGetAmdProperty4() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), PDFAIdentificationSchema.AMD,
        PDFAIdentificationSchema.AMD, PDFAIdentificationSchema.AMD, "Value");

    pdfaIdentificationSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, pdfaIdentificationSchema.getAmdProperty());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmd()}
   */
  @Test
  void testGetAmd() {
    // Arrange, Act and Assert
    assertNull((new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata())).getAmd());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmd()}
   */
  @Test
  void testGetAmd2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmd());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmd()}
   */
  @Test
  void testGetAmd3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.AMD);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmd());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getAmd()}
   */
  @Test
  void testGetAmd4() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(),
        PDFAIdentificationSchema.AMD, PDFAIdentificationSchema.AMD, PDFAIdentificationSchema.AMD, "Value"));

    // Act and Assert
    assertEquals("Value", pdfaIdentificationSchema.getAmd());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getConformanceProperty()}
   */
  @Test
  void testGetConformanceProperty() {
    // Arrange, Act and Assert
    assertNull((new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata())).getConformanceProperty());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getConformanceProperty()}
   */
  @Test
  void testGetConformanceProperty2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.CONFORMANCE, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getConformanceProperty());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getConformanceProperty()}
   */
  @Test
  void testGetConformanceProperty3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.CONFORMANCE);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.CONFORMANCE, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getConformanceProperty());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getConformanceProperty()}
   */
  @Test
  void testGetConformanceProperty4() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), PDFAIdentificationSchema.CONFORMANCE,
        PDFAIdentificationSchema.CONFORMANCE, PDFAIdentificationSchema.CONFORMANCE, "Value");

    pdfaIdentificationSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, pdfaIdentificationSchema.getConformanceProperty());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getConformance()}
   */
  @Test
  void testGetConformance() {
    // Arrange, Act and Assert
    assertNull((new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata())).getConformance());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getConformance()}
   */
  @Test
  void testGetConformance2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.CONFORMANCE, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getConformance());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getConformance()}
   */
  @Test
  void testGetConformance3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.CONFORMANCE);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.CONFORMANCE, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getConformance());
  }

  /**
   * Method under test: {@link PDFAIdentificationSchema#getConformance()}
   */
  @Test
  void testGetConformance4() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema
        .addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), PDFAIdentificationSchema.CONFORMANCE,
            PDFAIdentificationSchema.CONFORMANCE, PDFAIdentificationSchema.CONFORMANCE, "Value"));

    // Act and Assert
    assertEquals("Value", pdfaIdentificationSchema.getConformance());
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata)}
   */
  @Test
  void testNewPDFAIdentificationSchema() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAIdentificationSchema actualPdfaIdentificationSchema = new PDFAIdentificationSchema(metadata);

    // Assert
    assertEquals("", actualPdfaIdentificationSchema.getAboutValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", actualPdfaIdentificationSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualPdfaIdentificationSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("pdfaid", allNamespacesWithPrefix.get("http://www.aiim.org/pdfa/ns/id/"));
    assertEquals("pdfaid", actualPdfaIdentificationSchema.getPreferedPrefix());
    assertEquals("pdfaid", actualPdfaIdentificationSchema.getPrefix());
    assertNull(actualPdfaIdentificationSchema.getPart());
    assertNull(actualPdfaIdentificationSchema.getAmd());
    assertNull(actualPdfaIdentificationSchema.getAmendment());
    assertNull(actualPdfaIdentificationSchema.getConformance());
    assertNull(actualPdfaIdentificationSchema.getPropertyName());
    assertNull(actualPdfaIdentificationSchema.getAboutAttribute());
    assertNull(actualPdfaIdentificationSchema.getPartProperty());
    assertNull(actualPdfaIdentificationSchema.getAmdProperty());
    assertNull(actualPdfaIdentificationSchema.getConformanceProperty());
    List<AbstractField> allProperties = actualPdfaIdentificationSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPdfaIdentificationSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualPdfaIdentificationSchema.getContainer().getAllProperties());
    assertSame(metadata, actualPdfaIdentificationSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata, String)}
   */
  @Test
  void testNewPDFAIdentificationSchema2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAIdentificationSchema actualPdfaIdentificationSchema = new PDFAIdentificationSchema(metadata, "Prefix");

    // Assert
    assertEquals("", actualPdfaIdentificationSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualPdfaIdentificationSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Prefix", allNamespacesWithPrefix.get("http://www.aiim.org/pdfa/ns/id/"));
    assertEquals("Prefix", actualPdfaIdentificationSchema.getPrefix());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", actualPdfaIdentificationSchema.getNamespace());
    assertEquals("pdfaid", actualPdfaIdentificationSchema.getPreferedPrefix());
    assertNull(actualPdfaIdentificationSchema.getPart());
    assertNull(actualPdfaIdentificationSchema.getAmd());
    assertNull(actualPdfaIdentificationSchema.getAmendment());
    assertNull(actualPdfaIdentificationSchema.getConformance());
    assertNull(actualPdfaIdentificationSchema.getPropertyName());
    assertNull(actualPdfaIdentificationSchema.getAboutAttribute());
    assertNull(actualPdfaIdentificationSchema.getPartProperty());
    assertNull(actualPdfaIdentificationSchema.getAmdProperty());
    assertNull(actualPdfaIdentificationSchema.getConformanceProperty());
    List<AbstractField> allProperties = actualPdfaIdentificationSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPdfaIdentificationSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualPdfaIdentificationSchema.getContainer().getAllProperties());
    assertSame(metadata, actualPdfaIdentificationSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata, String)}
   */
  @Test
  void testNewPDFAIdentificationSchema3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAIdentificationSchema actualPdfaIdentificationSchema = new PDFAIdentificationSchema(metadata, null);

    // Assert
    assertEquals("", actualPdfaIdentificationSchema.getAboutValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", actualPdfaIdentificationSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualPdfaIdentificationSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("pdfaid", allNamespacesWithPrefix.get("http://www.aiim.org/pdfa/ns/id/"));
    assertEquals("pdfaid", actualPdfaIdentificationSchema.getPreferedPrefix());
    assertEquals("pdfaid", actualPdfaIdentificationSchema.getPrefix());
    assertNull(actualPdfaIdentificationSchema.getPart());
    assertNull(actualPdfaIdentificationSchema.getAmd());
    assertNull(actualPdfaIdentificationSchema.getAmendment());
    assertNull(actualPdfaIdentificationSchema.getConformance());
    assertNull(actualPdfaIdentificationSchema.getPropertyName());
    assertNull(actualPdfaIdentificationSchema.getAboutAttribute());
    assertNull(actualPdfaIdentificationSchema.getPartProperty());
    assertNull(actualPdfaIdentificationSchema.getAmdProperty());
    assertNull(actualPdfaIdentificationSchema.getConformanceProperty());
    List<AbstractField> allProperties = actualPdfaIdentificationSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPdfaIdentificationSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualPdfaIdentificationSchema.getContainer().getAllProperties());
    assertSame(metadata, actualPdfaIdentificationSchema.getMetadata());
  }
}
