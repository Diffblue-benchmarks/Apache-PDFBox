package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractStructuredTypeDiffblueTest {
  /**
   * Test {@link AbstractStructuredType#getNamespace()}.
   * <p>
   * Method under test: {@link AbstractStructuredType#getNamespace()}
   */
  @Test
  @DisplayName("Test getNamespace()")
  void testGetNamespace() {
    // Arrange, Act and Assert
    assertEquals("http://ns.adobe.com/pdf/1.3/", (new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getNamespace());
  }

  /**
   * Test {@link AbstractStructuredType#setNamespace(String)}.
   * <p>
   * Method under test: {@link AbstractStructuredType#setNamespace(String)}
   */
  @Test
  @DisplayName("Test setNamespace(String)")
  void testSetNamespace() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setNamespace("Ns");

    // Assert
    assertEquals("Ns", adobePDFSchema.getNamespace());
  }

  /**
   * Test {@link AbstractStructuredType#getPrefix()}.
   * <p>
   * Method under test: {@link AbstractStructuredType#getPrefix()}
   */
  @Test
  @DisplayName("Test getPrefix()")
  void testGetPrefix() {
    // Arrange, Act and Assert
    assertEquals("pdf", (new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPrefix());
  }

  /**
   * Test {@link AbstractStructuredType#setPrefix(String)}.
   * <p>
   * Method under test: {@link AbstractStructuredType#setPrefix(String)}
   */
  @Test
  @DisplayName("Test setPrefix(String)")
  void testSetPrefix() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setPrefix("Pf");

    // Assert
    assertEquals("Pf", adobePDFSchema.getPrefix());
  }

  /**
   * Test {@link AbstractStructuredType#getPreferedPrefix()}.
   * <p>
   * Method under test: {@link AbstractStructuredType#getPreferedPrefix()}
   */
  @Test
  @DisplayName("Test getPreferedPrefix()")
  void testGetPreferedPrefix() {
    // Arrange, Act and Assert
    assertEquals("pdf", (new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPreferedPrefix());
  }

  /**
   * Test {@link AbstractStructuredType#getPropertyValueAsString(String)}.
   * <p>
   * Method under test:
   * {@link AbstractStructuredType#getPropertyValueAsString(String)}
   */
  @Test
  @DisplayName("Test getPropertyValueAsString(String)")
  void testGetPropertyValueAsString() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getPropertyValueAsString("Field Name"));
  }

  /**
   * Test {@link AbstractStructuredType#getPropertyValueAsString(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractStructuredType#getPropertyValueAsString(String)}
   */
  @Test
  @DisplayName("Test getPropertyValueAsString(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetPropertyValueAsString_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPropertyValueAsString("Field Name"));
  }

  /**
   * Test {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}.
   * <p>
   * Method under test:
   * {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}
   */
  @Test
  @DisplayName("Test getDatePropertyAsCalendar(String)")
  void testGetDatePropertyAsCalendar() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getDatePropertyAsCalendar("Field Name"));
  }

  /**
   * Test {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}.
   * <p>
   * Method under test:
   * {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}
   */
  @Test
  @DisplayName("Test getDatePropertyAsCalendar(String)")
  void testGetDatePropertyAsCalendar2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Field Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getDatePropertyAsCalendar("Field Name"));
  }

  /**
   * Test {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}
   */
  @Test
  @DisplayName("Test getDatePropertyAsCalendar(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetDatePropertyAsCalendar_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getDatePropertyAsCalendar("Field Name"));
  }

  /**
   * Test {@link AbstractStructuredType#createTextType(String, String)}.
   * <ul>
   *   <li>Then return StringValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractStructuredType#createTextType(String, String)}
   */
  @Test
  @DisplayName("Test createTextType(String, String); then return StringValue is '42'")
  void testCreateTextType_thenReturnStringValueIs42() {
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
   * Test {@link AbstractStructuredType#createArrayProperty(String, Cardinality)}.
   * <ul>
   *   <li>Then return {@code Property Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractStructuredType#createArrayProperty(String, Cardinality)}
   */
  @Test
  @DisplayName("Test createArrayProperty(String, Cardinality); then return 'Property Name'")
  void testCreateArrayProperty_thenReturnPropertyName() {
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
