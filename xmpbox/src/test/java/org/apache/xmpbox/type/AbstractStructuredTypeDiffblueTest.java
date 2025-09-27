package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractStructuredTypeDiffblueTest {
  /**
   * Test {@link AbstractStructuredType#getNamespace()}.
   *
   * <p>Method under test: {@link AbstractStructuredType#getNamespace()}
   */
  @Test
  @DisplayName("Test getNamespace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractStructuredType.getNamespace()"})
  void testGetNamespace() {
    // Arrange, Act and Assert
    assertEquals(
        "http://ns.adobe.com/pdf/1.3/",
        new AdobePDFSchema(XMPMetadata.createXMPMetadata()).getNamespace());
  }

  /**
   * Test {@link AbstractStructuredType#setNamespace(String)}.
   *
   * <p>Method under test: {@link AbstractStructuredType#setNamespace(String)}
   */
  @Test
  @DisplayName("Test setNamespace(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractStructuredType.setNamespace(String)"})
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
   *
   * <p>Method under test: {@link AbstractStructuredType#getPrefix()}
   */
  @Test
  @DisplayName("Test getPrefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractStructuredType.getPrefix()"})
  void testGetPrefix() {
    // Arrange, Act and Assert
    assertEquals("pdf", new AdobePDFSchema(XMPMetadata.createXMPMetadata()).getPrefix());
  }

  /**
   * Test {@link AbstractStructuredType#setPrefix(String)}.
   *
   * <p>Method under test: {@link AbstractStructuredType#setPrefix(String)}
   */
  @Test
  @DisplayName("Test setPrefix(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractStructuredType.setPrefix(String)"})
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
   *
   * <p>Method under test: {@link AbstractStructuredType#getPreferedPrefix()}
   */
  @Test
  @DisplayName("Test getPreferedPrefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractStructuredType.getPreferedPrefix()"})
  void testGetPreferedPrefix() {
    // Arrange, Act and Assert
    assertEquals("pdf", new AdobePDFSchema(XMPMetadata.createXMPMetadata()).getPreferedPrefix());
  }

  /**
   * Test {@link AbstractStructuredType#getPropertyValueAsString(String)}.
   *
   * <p>Method under test: {@link AbstractStructuredType#getPropertyValueAsString(String)}
   */
  @Test
  @DisplayName("Test getPropertyValueAsString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractStructuredType.getPropertyValueAsString(String)"})
  void testGetPropertyValueAsString() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getPropertyValueAsString("Field Name"));
  }

  /**
   * Test {@link AbstractStructuredType#getPropertyValueAsString(String)}.
   *
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link AbstractStructuredType#getPropertyValueAsString(String)}
   */
  @Test
  @DisplayName(
      "Test getPropertyValueAsString(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractStructuredType.getPropertyValueAsString(String)"})
  void testGetPropertyValueAsString_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(
        new AdobePDFSchema(XMPMetadata.createXMPMetadata()).getPropertyValueAsString("Field Name"));
  }

  /**
   * Test {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}.
   *
   * <p>Method under test: {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}
   */
  @Test
  @DisplayName("Test getDatePropertyAsCalendar(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Calendar AbstractStructuredType.getDatePropertyAsCalendar(String)"})
  void testGetDatePropertyAsCalendar() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getDatePropertyAsCalendar("Field Name"));
  }

  /**
   * Test {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}.
   *
   * <p>Method under test: {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}
   */
  @Test
  @DisplayName("Test getDatePropertyAsCalendar(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Calendar AbstractStructuredType.getDatePropertyAsCalendar(String)"})
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
   *
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link AbstractStructuredType#getDatePropertyAsCalendar(String)}
   */
  @Test
  @DisplayName(
      "Test getDatePropertyAsCalendar(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Calendar AbstractStructuredType.getDatePropertyAsCalendar(String)"})
  void testGetDatePropertyAsCalendar_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(
        new AdobePDFSchema(XMPMetadata.createXMPMetadata())
            .getDatePropertyAsCalendar("Field Name"));
  }

  /**
   * Test {@link AbstractStructuredType#createTextType(String, String)}.
   *
   * <ul>
   *   <li>Then return StringValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractStructuredType#createTextType(String, String)}
   */
  @Test
  @DisplayName("Test createTextType(String, String); then return StringValue is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType AbstractStructuredType.createTextType(String, String)"})
  void testCreateTextType_thenReturnStringValueIs42() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    TextType actualCreateTextTypeResult =
        new AdobePDFSchema(metadata).createTextType("Property Name", "42");

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
   *
   * <ul>
   *   <li>Then return {@code Property Name}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractStructuredType#createArrayProperty(String, Cardinality)}
   */
  @Test
  @DisplayName("Test createArrayProperty(String, Cardinality); then return 'Property Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ArrayProperty AbstractStructuredType.createArrayProperty(String, Cardinality)"
  })
  void testCreateArrayProperty_thenReturnPropertyName() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ArrayProperty actualCreateArrayPropertyResult =
        new AdobePDFSchema(metadata).createArrayProperty("Property Name", Cardinality.Simple);

    // Assert
    assertEquals("Property Name", actualCreateArrayPropertyResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualCreateArrayPropertyResult.getNamespace());
    assertEquals("pdf", actualCreateArrayPropertyResult.getPrefix());
    assertEquals(Cardinality.Simple, actualCreateArrayPropertyResult.getArrayType());
    assertTrue(actualCreateArrayPropertyResult.getAllProperties().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getAllAttributes().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getElementsAsString().isEmpty());
    assertTrue(actualCreateArrayPropertyResult.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualCreateArrayPropertyResult.getMetadata());
  }
}
