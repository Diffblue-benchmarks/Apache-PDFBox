package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.IntegerType;
import org.apache.xmpbox.type.TextType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFAIdentificationSchemaDiffblueTest {
  /**
   * Test {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new PDFAIdentificationSchema(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.<init>(XMPMetadata)"})
  void testNewPDFAIdentificationSchema() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAIdentificationSchema actualPdfaIdentificationSchema =
        new PDFAIdentificationSchema(metadata);

    // Assert
    assertEquals("", actualPdfaIdentificationSchema.getAboutValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", actualPdfaIdentificationSchema.getNamespace());
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
    Map<String, String> allNamespacesWithPrefix =
        actualPdfaIdentificationSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualPdfaIdentificationSchema.getAllProperties().isEmpty());
    assertTrue(actualPdfaIdentificationSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://www.aiim.org/pdfa/ns/id/"));
    assertSame(metadata, actualPdfaIdentificationSchema.getMetadata());
  }

  /**
   * Test {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Prefix is {@code pdfaid}.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new PDFAIdentificationSchema(XMPMetadata, String); when 'null'; then return Prefix is 'pdfaid'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.<init>(XMPMetadata, String)"})
  void testNewPDFAIdentificationSchema_whenNull_thenReturnPrefixIsPdfaid() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAIdentificationSchema actualPdfaIdentificationSchema =
        new PDFAIdentificationSchema(metadata, null);

    // Assert
    assertEquals("", actualPdfaIdentificationSchema.getAboutValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", actualPdfaIdentificationSchema.getNamespace());
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
    Map<String, String> allNamespacesWithPrefix =
        actualPdfaIdentificationSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualPdfaIdentificationSchema.getAllProperties().isEmpty());
    assertTrue(actualPdfaIdentificationSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://www.aiim.org/pdfa/ns/id/"));
    assertSame(metadata, actualPdfaIdentificationSchema.getMetadata());
  }

  /**
   * Test {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code Prefix}.
   *   <li>Then return {@code Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new PDFAIdentificationSchema(XMPMetadata, String); when 'Prefix'; then return 'Prefix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.<init>(XMPMetadata, String)"})
  void testNewPDFAIdentificationSchema_whenPrefix_thenReturnPrefix() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAIdentificationSchema actualPdfaIdentificationSchema =
        new PDFAIdentificationSchema(metadata, "Prefix");

    // Assert
    assertEquals("", actualPdfaIdentificationSchema.getAboutValue());
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
    Map<String, String> allNamespacesWithPrefix =
        actualPdfaIdentificationSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualPdfaIdentificationSchema.getAllProperties().isEmpty());
    assertTrue(actualPdfaIdentificationSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://www.aiim.org/pdfa/ns/id/"));
    assertSame(metadata, actualPdfaIdentificationSchema.getMetadata());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPartValueWithString(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartValueWithString(String)}
   */
  @Test
  @DisplayName("Test setPartValueWithString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartValueWithString(String)"})
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
   * Test {@link PDFAIdentificationSchema#setPartValueWithString(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartValueWithString(String)}
   */
  @Test
  @DisplayName("Test setPartValueWithString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartValueWithString(String)"})
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
   * Test {@link PDFAIdentificationSchema#setPartValueWithString(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartValueWithString(String)}
   */
  @Test
  @DisplayName("Test setPartValueWithString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartValueWithString(String)"})
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
   * Test {@link PDFAIdentificationSchema#setPartValueWithString(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartValueWithString(String)}
   */
  @Test
  @DisplayName("Test setPartValueWithString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartValueWithString(String)"})
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
   * Test {@link PDFAIdentificationSchema#setPartValueWithInt(int)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartValueWithInt(int)}
   */
  @Test
  @DisplayName("Test setPartValueWithInt(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartValueWithInt(int)"})
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
    assertEquals(42, ((Integer) partProperty.getRawValue()).intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(0));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPartValueWithInt(int)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartValueWithInt(int)}
   */
  @Test
  @DisplayName("Test setPartValueWithInt(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartValueWithInt(int)"})
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
    assertEquals(42, ((Integer) partProperty.getRawValue()).intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(0));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPartValueWithInt(int)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartValueWithInt(int)}
   */
  @Test
  @DisplayName("Test setPartValueWithInt(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartValueWithInt(int)"})
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
    assertEquals(42, ((Integer) partProperty.getRawValue()).intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(1));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPartValueWithInt(int)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartValueWithInt(int)}
   */
  @Test
  @DisplayName("Test setPartValueWithInt(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartValueWithInt(int)"})
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
    assertEquals(42, ((Integer) partProperty.getRawValue()).intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(1));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPart(Integer)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPart(Integer)}
   */
  @Test
  @DisplayName("Test setPart(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPart(Integer)"})
  void testSetPart() {
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
    assertEquals(42, ((Integer) partProperty.getRawValue()).intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(0));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPart(Integer)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPart(Integer)}
   */
  @Test
  @DisplayName("Test setPart(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPart(Integer)"})
  void testSetPart2() {
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
    assertEquals(42, ((Integer) partProperty.getRawValue()).intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(1));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPart(Integer)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPart(Integer)}
   */
  @Test
  @DisplayName("Test setPart(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPart(Integer)"})
  void testSetPart3() {
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
    assertEquals(42, ((Integer) partProperty.getRawValue()).intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(1));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPart(Integer)}.
   *
   * <ul>
   *   <li>Given {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPart(Integer)}
   */
  @Test
  @DisplayName(
      "Test setPart(Integer); given PDFAIdentificationSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPart(Integer)"})
  void testSetPart_givenPDFAIdentificationSchemaWithMetadataIsCreateXMPMetadata() {
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
    assertEquals(42, ((Integer) partProperty.getRawValue()).intValue());
    assertTrue(partProperty.getAllAttributes().isEmpty());
    assertEquals(PDFAIdentificationSchema.PART, partProperty.getPropertyName());
    assertSame(partProperty, allProperties.get(0));
    assertSame(metadata, partProperty.getMetadata());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setPartProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartProperty(IntegerType)"})
  void testSetPartProperty() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    IntegerType part =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    pdfaIdentificationSchema.setPartProperty(part);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(part, allProperties.get(0));
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setPartProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartProperty(IntegerType)"})
  void testSetPartProperty2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("A", "Bag Value");
    IntegerType part =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    pdfaIdentificationSchema.setPartProperty(part);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("A", getResult.getPropertyName());
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Bag Value", elementsAsString.get(0));
    assertSame(part, allProperties.get(1));
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setPartProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartProperty(IntegerType)"})
  void testSetPartProperty3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", "Property Name");
    pdfaIdentificationSchema.addBagValueAsSimple("A", "Bag Value");
    IntegerType part =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    pdfaIdentificationSchema.setPartProperty(part);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    assertEquals("A", getResult2.getPropertyName());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertSame(part, allProperties.get(2));
  }

  /**
   * Test {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setPartProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setPartProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setPartProperty(IntegerType)"})
  void testSetPartProperty4() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Property Name", "Simple Name");
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", "Property Name");
    pdfaIdentificationSchema.addBagValueAsSimple("A", "Bag Value");
    IntegerType part =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    pdfaIdentificationSchema.setPartProperty(part);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    assertEquals("A", getResult2.getPropertyName());
    List<String> elementsAsString = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Bag Value", elementsAsString.get(0));
    List<String> elementsAsString2 = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("Property Name", elementsAsString2.get(0));
    assertEquals("Simple Name", getResult.getPropertyName());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setAmd(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setAmd(String)}
   */
  @Test
  @DisplayName("Test setAmd(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setAmd(String)"})
  void testSetAmd() {
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
   * Test {@link PDFAIdentificationSchema#setAmd(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setAmd(String)}
   */
  @Test
  @DisplayName("Test setAmd(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setAmd(String)"})
  void testSetAmd2() {
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
   * Test {@link PDFAIdentificationSchema#setAmd(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setAmd(String)}
   */
  @Test
  @DisplayName("Test setAmd(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setAmd(String)"})
  void testSetAmd3() {
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
   * Test {@link PDFAIdentificationSchema#setAmd(String)}.
   *
   * <ul>
   *   <li>Given {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setAmd(String)}
   */
  @Test
  @DisplayName(
      "Test setAmd(String); given PDFAIdentificationSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setAmd(String)"})
  void testSetAmd_givenPDFAIdentificationSchemaWithMetadataIsCreateXMPMetadata() {
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
   * Test {@link PDFAIdentificationSchema#setAmdProperty(TextType)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setAmdProperty(TextType)}
   */
  @Test
  @DisplayName("Test setAmdProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setAmdProperty(TextType)"})
  void testSetAmdProperty() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    TextType amd =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    pdfaIdentificationSchema.setAmdProperty(amd);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(amd, allProperties.get(0));
  }

  /**
   * Test {@link PDFAIdentificationSchema#setAmdProperty(TextType)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setAmdProperty(TextType)}
   */
  @Test
  @DisplayName("Test setAmdProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setAmdProperty(TextType)"})
  void testSetAmdProperty2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", "42");
    TextType amd =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

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
   * Test {@link PDFAIdentificationSchema#setAmdProperty(TextType)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setAmdProperty(TextType)}
   */
  @Test
  @DisplayName("Test setAmdProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setAmdProperty(TextType)"})
  void testSetAmdProperty3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Property Name", "Simple Name");
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", "42");
    TextType amd =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

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
  }

  /**
   * Test {@link PDFAIdentificationSchema#setConformance(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  @DisplayName("Test setConformance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformance(String)"})
  void testSetConformance() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());

    // Act
    pdfaIdentificationSchema.setConformance("A");

    // Assert
    assertEquals("A", pdfaIdentificationSchema.getConformance());
    TextType conformanceProperty = pdfaIdentificationSchema.getConformanceProperty();
    assertEquals("A", conformanceProperty.getStringValue());
    assertEquals("A", conformanceProperty.getRawValue());
    assertEquals("A", conformanceProperty.getValue());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(conformanceProperty, allProperties.get(0));
  }

  /**
   * Test {@link PDFAIdentificationSchema#setConformance(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  @DisplayName("Test setConformance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformance(String)"})
  void testSetConformance2() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());

    // Act
    pdfaIdentificationSchema.setConformance("B");

    // Assert
    assertEquals("B", pdfaIdentificationSchema.getConformance());
    TextType conformanceProperty = pdfaIdentificationSchema.getConformanceProperty();
    assertEquals("B", conformanceProperty.getStringValue());
    assertEquals("B", conformanceProperty.getRawValue());
    assertEquals("B", conformanceProperty.getValue());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setConformance(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  @DisplayName("Test setConformance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformance(String)"})
  void testSetConformance3() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());

    // Act
    pdfaIdentificationSchema.setConformance("U");

    // Assert
    assertEquals("U", pdfaIdentificationSchema.getConformance());
    TextType conformanceProperty = pdfaIdentificationSchema.getConformanceProperty();
    assertEquals("U", conformanceProperty.getStringValue());
    assertEquals("U", conformanceProperty.getRawValue());
    assertEquals("U", conformanceProperty.getValue());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setConformance(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  @DisplayName("Test setConformance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformance(String)"})
  void testSetConformance4() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("A", "42");

    // Act
    pdfaIdentificationSchema.setConformance("A");

    // Assert
    assertEquals("A", pdfaIdentificationSchema.getConformance());
    TextType conformanceProperty = pdfaIdentificationSchema.getConformanceProperty();
    assertEquals("A", conformanceProperty.getStringValue());
    assertEquals("A", conformanceProperty.getRawValue());
    assertEquals("A", conformanceProperty.getValue());
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(conformanceProperty, allProperties.get(1));
  }

  /**
   * Test {@link PDFAIdentificationSchema#setConformance(String)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  @DisplayName("Test setConformance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformance(String)"})
  void testSetConformance5() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
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
    assertEquals("A", getResult.getPropertyName());
  }

  /**
   * Test {@link PDFAIdentificationSchema#setConformance(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformance(String)}
   */
  @Test
  @DisplayName("Test setConformance(String); when '42'; then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformance(String)"})
  void testSetConformance_when42_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertThrows(
        BadFieldValueException.class,
        () -> new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata()).setConformance("42"));
  }

  /**
   * Test {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setConformanceProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformanceProperty(TextType)"})
  void testSetConformanceProperty() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());

    AgentNameType conf =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");
    conf.setValue("A");

    // Act
    pdfaIdentificationSchema.setConformanceProperty(conf);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(conf, allProperties.get(0));
  }

  /**
   * Test {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setConformanceProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformanceProperty(TextType)"})
  void testSetConformanceProperty2() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("A", "42");

    AgentNameType conf =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");
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
   * Test {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setConformanceProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformanceProperty(TextType)"})
  void testSetConformanceProperty3() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Property Name", "A");
    pdfaIdentificationSchema.addBagValueAsSimple("A", "42");

    AgentNameType conf =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");
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
  }

  /**
   * Test {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}.
   *
   * <ul>
   *   <li>Given {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setConformanceProperty(TextType); given 'B'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformanceProperty(TextType)"})
  void testSetConformanceProperty_givenB() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());

    AgentNameType conf =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");
    conf.setValue("B");

    // Act
    pdfaIdentificationSchema.setConformanceProperty(conf);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(conf, allProperties.get(0));
  }

  /**
   * Test {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}.
   *
   * <ul>
   *   <li>Given {@code U}.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setConformanceProperty(TextType); given 'U'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformanceProperty(TextType)"})
  void testSetConformanceProperty_givenU() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());

    AgentNameType conf =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");
    conf.setValue("U");

    // Act
    pdfaIdentificationSchema.setConformanceProperty(conf);

    // Assert
    List<AbstractField> allProperties = pdfaIdentificationSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(conf, allProperties.get(0));
  }

  /**
   * Test {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}.
   *
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#setConformanceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setConformanceProperty(TextType); then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFAIdentificationSchema.setConformanceProperty(TextType)"})
  void testSetConformanceProperty_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    TextType conf =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act and Assert
    assertThrows(
        BadFieldValueException.class, () -> pdfaIdentificationSchema.setConformanceProperty(conf));
  }

  /**
   * Test {@link PDFAIdentificationSchema#getPart()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getPart()}
   */
  @Test
  @DisplayName("Test getPart()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PDFAIdentificationSchema.getPart()"})
  void testGetPart() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getPart());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getPart()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getPart()}
   */
  @Test
  @DisplayName("Test getPart()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PDFAIdentificationSchema.getPart()"})
  void testGetPart2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.PART);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getPart());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getPart()}.
   *
   * <ul>
   *   <li>Given {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getPart()}
   */
  @Test
  @DisplayName(
      "Test getPart(); given PDFAIdentificationSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PDFAIdentificationSchema.getPart()"})
  void testGetPart_givenPDFAIdentificationSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata()).getPart());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getPartProperty()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getPartProperty()}
   */
  @Test
  @DisplayName("Test getPartProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType PDFAIdentificationSchema.getPartProperty()"})
  void testGetPartProperty() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getPartProperty());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getPartProperty()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getPartProperty()}
   */
  @Test
  @DisplayName("Test getPartProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType PDFAIdentificationSchema.getPartProperty()"})
  void testGetPartProperty2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.PART);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.PART, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getPartProperty());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getPartProperty()}.
   *
   * <ul>
   *   <li>Given {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getPartProperty()}
   */
  @Test
  @DisplayName(
      "Test getPartProperty(); given PDFAIdentificationSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType PDFAIdentificationSchema.getPartProperty()"})
  void testGetPartProperty_givenPDFAIdentificationSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata()).getPartProperty());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmendment()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmendment()}
   */
  @Test
  @DisplayName("Test getAmendment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getAmendment()"})
  void testGetAmendment() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmendment());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmendment()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmendment()}
   */
  @Test
  @DisplayName("Test getAmendment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getAmendment()"})
  void testGetAmendment2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.AMD);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmendment());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmendment()}.
   *
   * <ul>
   *   <li>Given {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmendment()}
   */
  @Test
  @DisplayName(
      "Test getAmendment(); given PDFAIdentificationSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getAmendment()"})
  void testGetAmendment_givenPDFAIdentificationSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata()).getAmendment());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmendment()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmendment()}
   */
  @Test
  @DisplayName("Test getAmendment(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getAmendment()"})
  void testGetAmendment_thenReturnValue() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            PDFAIdentificationSchema.AMD,
            PDFAIdentificationSchema.AMD,
            PDFAIdentificationSchema.AMD,
            "Value");
    pdfaIdentificationSchema.addProperty(obj);

    // Act and Assert
    assertEquals("Value", pdfaIdentificationSchema.getAmendment());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmdProperty()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmdProperty()}
   */
  @Test
  @DisplayName("Test getAmdProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PDFAIdentificationSchema.getAmdProperty()"})
  void testGetAmdProperty() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmdProperty());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmdProperty()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmdProperty()}
   */
  @Test
  @DisplayName("Test getAmdProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PDFAIdentificationSchema.getAmdProperty()"})
  void testGetAmdProperty2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.AMD);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmdProperty());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmdProperty()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmdProperty()}
   */
  @Test
  @DisplayName("Test getAmdProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PDFAIdentificationSchema.getAmdProperty()"})
  void testGetAmdProperty3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            PDFAIdentificationSchema.AMD,
            PDFAIdentificationSchema.AMD,
            PDFAIdentificationSchema.AMD,
            "Value");
    pdfaIdentificationSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, pdfaIdentificationSchema.getAmdProperty());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmdProperty()}.
   *
   * <ul>
   *   <li>Given {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmdProperty()}
   */
  @Test
  @DisplayName(
      "Test getAmdProperty(); given PDFAIdentificationSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PDFAIdentificationSchema.getAmdProperty()"})
  void testGetAmdProperty_givenPDFAIdentificationSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata()).getAmdProperty());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmd()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmd()}
   */
  @Test
  @DisplayName("Test getAmd()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getAmd()"})
  void testGetAmd() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmd());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmd()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmd()}
   */
  @Test
  @DisplayName("Test getAmd()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getAmd()"})
  void testGetAmd2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple("Simple Name", PDFAIdentificationSchema.AMD);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.AMD, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getAmd());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmd()}.
   *
   * <ul>
   *   <li>Given {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmd()}
   */
  @Test
  @DisplayName(
      "Test getAmd(); given PDFAIdentificationSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getAmd()"})
  void testGetAmd_givenPDFAIdentificationSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata()).getAmd());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getAmd()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getAmd()}
   */
  @Test
  @DisplayName("Test getAmd(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getAmd()"})
  void testGetAmd_thenReturnValue() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            PDFAIdentificationSchema.AMD,
            PDFAIdentificationSchema.AMD,
            PDFAIdentificationSchema.AMD,
            "Value");
    pdfaIdentificationSchema.addProperty(obj);

    // Act and Assert
    assertEquals("Value", pdfaIdentificationSchema.getAmd());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getConformanceProperty()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getConformanceProperty()}
   */
  @Test
  @DisplayName("Test getConformanceProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PDFAIdentificationSchema.getConformanceProperty()"})
  void testGetConformanceProperty() {
    // Arrange, Act and Assert
    assertNull(
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata()).getConformanceProperty());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getConformanceProperty()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getConformanceProperty()}
   */
  @Test
  @DisplayName("Test getConformanceProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PDFAIdentificationSchema.getConformanceProperty()"})
  void testGetConformanceProperty2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.CONFORMANCE, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getConformanceProperty());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getConformanceProperty()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getConformanceProperty()}
   */
  @Test
  @DisplayName("Test getConformanceProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PDFAIdentificationSchema.getConformanceProperty()"})
  void testGetConformanceProperty3() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(
        "Simple Name", PDFAIdentificationSchema.CONFORMANCE);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.CONFORMANCE, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getConformanceProperty());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getConformanceProperty()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getConformanceProperty()}
   */
  @Test
  @DisplayName("Test getConformanceProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PDFAIdentificationSchema.getConformanceProperty()"})
  void testGetConformanceProperty4() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            PDFAIdentificationSchema.CONFORMANCE,
            PDFAIdentificationSchema.CONFORMANCE,
            PDFAIdentificationSchema.CONFORMANCE,
            "Value");
    pdfaIdentificationSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, pdfaIdentificationSchema.getConformanceProperty());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getConformance()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getConformance()}
   */
  @Test
  @DisplayName("Test getConformance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getConformance()"})
  void testGetConformance() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.CONFORMANCE, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getConformance());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getConformance()}.
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getConformance()}
   */
  @Test
  @DisplayName("Test getConformance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getConformance()"})
  void testGetConformance2() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    pdfaIdentificationSchema.addBagValueAsSimple(
        "Simple Name", PDFAIdentificationSchema.CONFORMANCE);
    pdfaIdentificationSchema.addBagValueAsSimple(PDFAIdentificationSchema.CONFORMANCE, "42");

    // Act and Assert
    assertNull(pdfaIdentificationSchema.getConformance());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getConformance()}.
   *
   * <ul>
   *   <li>Given {@link PDFAIdentificationSchema#PDFAIdentificationSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getConformance()}
   */
  @Test
  @DisplayName(
      "Test getConformance(); given PDFAIdentificationSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getConformance()"})
  void testGetConformance_givenPDFAIdentificationSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata()).getConformance());
  }

  /**
   * Test {@link PDFAIdentificationSchema#getConformance()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link PDFAIdentificationSchema#getConformance()}
   */
  @Test
  @DisplayName("Test getConformance(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFAIdentificationSchema.getConformance()"})
  void testGetConformance_thenReturnValue() {
    // Arrange
    PDFAIdentificationSchema pdfaIdentificationSchema =
        new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            PDFAIdentificationSchema.CONFORMANCE,
            PDFAIdentificationSchema.CONFORMANCE,
            PDFAIdentificationSchema.CONFORMANCE,
            "Value");
    pdfaIdentificationSchema.addProperty(obj);

    // Act and Assert
    assertEquals("Value", pdfaIdentificationSchema.getConformance());
  }
}
