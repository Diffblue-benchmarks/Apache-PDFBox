package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.junit.jupiter.api.Test;

class AbstractStructuredTypeDiffblueTest {
  /**
   * Method under test: {@link AbstractStructuredType#getNamespace()}
   */
  @Test
  void testGetNamespace() {
    // Arrange, Act and Assert
    assertEquals("http://ns.adobe.com/pdf/1.3/", (new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getNamespace());
  }

  /**
   * Method under test: {@link AbstractStructuredType#setNamespace(String)}
   */
  @Test
  void testSetNamespace() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setNamespace("Ns");

    // Assert
    assertEquals("Ns", adobePDFSchema.getNamespace());
  }

  /**
   * Method under test: {@link AbstractStructuredType#getPrefix()}
   */
  @Test
  void testGetPrefix() {
    // Arrange, Act and Assert
    assertEquals("pdf", (new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPrefix());
  }

  /**
   * Method under test: {@link AbstractStructuredType#setPrefix(String)}
   */
  @Test
  void testSetPrefix() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setPrefix("Pf");

    // Assert
    assertEquals("Pf", adobePDFSchema.getPrefix());
  }

  /**
   * Method under test: {@link AbstractStructuredType#getPreferedPrefix()}
   */
  @Test
  void testGetPreferedPrefix() {
    // Arrange, Act and Assert
    assertEquals("pdf", (new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPreferedPrefix());
  }

  /**
   * Method under test:
   * {@link AbstractStructuredType#getPropertyValueAsString(String)}
   */
  @Test
  void testGetPropertyValueAsString() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPropertyValueAsString("Field Name"));
  }

  /**
   * Method under test:
   * {@link AbstractStructuredType#getPropertyValueAsString(String)}
   */
  @Test
  void testGetPropertyValueAsString2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getPropertyValueAsString("Field Name"));
  }

  /**
   * Method under test:
   * {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}
   */
  @Test
  void testGetDatePropertyAsCalendar() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getDatePropertyAsCalendar("Field Name"));
  }

  /**
   * Method under test:
   * {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}
   */
  @Test
  void testGetDatePropertyAsCalendar2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getDatePropertyAsCalendar("Field Name"));
  }

  /**
   * Method under test:
   * {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}
   */
  @Test
  void testGetDatePropertyAsCalendar3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Field Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getDatePropertyAsCalendar("Field Name"));
  }

  /**
   * Method under test:
   * {@link AbstractStructuredType#createTextType(String, String)}
   */
  @Test
  void testCreateTextType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    TextType actualCreateTextTypeResult = (new AdobePDFSchema(metadata)).createTextType("Property Name", "42");

    // Assert
    assertEquals("42", actualCreateTextTypeResult.getStringValue());
    assertEquals("42", actualCreateTextTypeResult.getRawValue());
    assertEquals("42", actualCreateTextTypeResult.getValue());
    assertEquals("Property Name", actualCreateTextTypeResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualCreateTextTypeResult.getNamespace());
    assertEquals("pdf", actualCreateTextTypeResult.getPrefix());
    assertTrue(actualCreateTextTypeResult.getAllAttributes().isEmpty());
    assertSame(metadata, actualCreateTextTypeResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link AbstractStructuredType#createArrayProperty(String, Cardinality)}
   */
  @Test
  void testCreateArrayProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ArrayProperty actualCreateArrayPropertyResult = (new AdobePDFSchema(metadata)).createArrayProperty("Property Name",
        Cardinality.Simple);

    // Assert
    assertEquals("Property Name", actualCreateArrayPropertyResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualCreateArrayPropertyResult.getNamespace());
    assertEquals("pdf", actualCreateArrayPropertyResult.getPrefix());
    assertEquals(Cardinality.Simple, actualCreateArrayPropertyResult.getArrayType());
    List<AbstractField> allProperties = actualCreateArrayPropertyResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getAllAttributes().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getElementsAsString().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualCreateArrayPropertyResult.getContainer().getAllProperties());
    assertSame(metadata, actualCreateArrayPropertyResult.getMetadata());
  }
}
