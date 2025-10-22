package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.Cardinality;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFAExtensionSchemaDiffblueTest {
  /**
   * Test {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata)}.
   * <p>
   * Method under test: {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new PDFAExtensionSchema(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFAExtensionSchema.<init>(XMPMetadata)"})
  void testNewPDFAExtensionSchema() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAExtensionSchema actualPdfaExtensionSchema = new PDFAExtensionSchema(metadata);

    // Assert
    assertEquals("", actualPdfaExtensionSchema.getAboutValue());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", actualPdfaExtensionSchema.getNamespace());
    assertEquals("pdfaExtension", actualPdfaExtensionSchema.getPreferedPrefix());
    assertEquals("pdfaExtension", actualPdfaExtensionSchema.getPrefix());
    assertNull(actualPdfaExtensionSchema.getPropertyName());
    assertNull(actualPdfaExtensionSchema.getSchemasProperty());
    assertNull(actualPdfaExtensionSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix = actualPdfaExtensionSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualPdfaExtensionSchema.getAllProperties().isEmpty());
    assertTrue(actualPdfaExtensionSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://www.aiim.org/pdfa/ns/extension/"));
    assertSame(metadata, actualPdfaExtensionSchema.getMetadata());
  }

  /**
   * Test {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Prefix is {@code pdfaExtension}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new PDFAExtensionSchema(XMPMetadata, String); when 'null'; then return Prefix is 'pdfaExtension'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFAExtensionSchema.<init>(XMPMetadata, String)"})
  void testNewPDFAExtensionSchema_whenNull_thenReturnPrefixIsPdfaExtension() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAExtensionSchema actualPdfaExtensionSchema = new PDFAExtensionSchema(metadata, null);

    // Assert
    assertEquals("", actualPdfaExtensionSchema.getAboutValue());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", actualPdfaExtensionSchema.getNamespace());
    assertEquals("pdfaExtension", actualPdfaExtensionSchema.getPreferedPrefix());
    assertEquals("pdfaExtension", actualPdfaExtensionSchema.getPrefix());
    assertNull(actualPdfaExtensionSchema.getPropertyName());
    assertNull(actualPdfaExtensionSchema.getSchemasProperty());
    assertNull(actualPdfaExtensionSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix = actualPdfaExtensionSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualPdfaExtensionSchema.getAllProperties().isEmpty());
    assertTrue(actualPdfaExtensionSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://www.aiim.org/pdfa/ns/extension/"));
    assertSame(metadata, actualPdfaExtensionSchema.getMetadata());
  }

  /**
   * Test {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata, String)}.
   * <ul>
   *   <li>When {@code Prefix}.</li>
   *   <li>Then return {@code Prefix}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new PDFAExtensionSchema(XMPMetadata, String); when 'Prefix'; then return 'Prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFAExtensionSchema.<init>(XMPMetadata, String)"})
  void testNewPDFAExtensionSchema_whenPrefix_thenReturnPrefix() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAExtensionSchema actualPdfaExtensionSchema = new PDFAExtensionSchema(metadata, "Prefix");

    // Assert
    assertEquals("", actualPdfaExtensionSchema.getAboutValue());
    assertEquals("Prefix", actualPdfaExtensionSchema.getPrefix());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", actualPdfaExtensionSchema.getNamespace());
    assertEquals("pdfaExtension", actualPdfaExtensionSchema.getPreferedPrefix());
    assertNull(actualPdfaExtensionSchema.getPropertyName());
    assertNull(actualPdfaExtensionSchema.getSchemasProperty());
    assertNull(actualPdfaExtensionSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix = actualPdfaExtensionSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualPdfaExtensionSchema.getAllProperties().isEmpty());
    assertTrue(actualPdfaExtensionSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://www.aiim.org/pdfa/ns/extension/"));
    assertSame(metadata, actualPdfaExtensionSchema.getMetadata());
  }

  /**
   * Test {@link PDFAExtensionSchema#getSchemasProperty()}.
   * <p>
   * Method under test: {@link PDFAExtensionSchema#getSchemasProperty()}
   */
  @Test
  @DisplayName("Test getSchemasProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty PDFAExtensionSchema.getSchemasProperty()"})
  void testGetSchemasProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAExtensionSchema pdfaExtensionSchema = new PDFAExtensionSchema(metadata);
    pdfaExtensionSchema.addBagValueAsSimple("Simple Name", PDFAExtensionSchema.SCHEMAS);
    pdfaExtensionSchema.addBagValueAsSimple(PDFAExtensionSchema.SCHEMAS, "42");

    // Act
    ArrayProperty actualSchemasProperty = pdfaExtensionSchema.getSchemasProperty();

    // Assert
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", actualSchemasProperty.getNamespace());
    assertEquals("pdfaExtension", actualSchemasProperty.getPrefix());
    assertEquals(1, actualSchemasProperty.getAllProperties().size());
    assertEquals(1, actualSchemasProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualSchemasProperty.getArrayType());
    assertTrue(actualSchemasProperty.getAllAttributes().isEmpty());
    assertTrue(actualSchemasProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PDFAExtensionSchema.SCHEMAS, actualSchemasProperty.getPropertyName());
    assertSame(metadata, actualSchemasProperty.getMetadata());
  }

  /**
   * Test {@link PDFAExtensionSchema#getSchemasProperty()}.
   * <ul>
   *   <li>Then return Namespace is {@code http://www.aiim.org/pdfa/ns/extension/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAExtensionSchema#getSchemasProperty()}
   */
  @Test
  @DisplayName("Test getSchemasProperty(); then return Namespace is 'http://www.aiim.org/pdfa/ns/extension/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty PDFAExtensionSchema.getSchemasProperty()"})
  void testGetSchemasProperty_thenReturnNamespaceIsHttpWwwAiimOrgPdfaNsExtension() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAExtensionSchema pdfaExtensionSchema = new PDFAExtensionSchema(metadata);
    pdfaExtensionSchema.addBagValueAsSimple(PDFAExtensionSchema.SCHEMAS, "42");

    // Act
    ArrayProperty actualSchemasProperty = pdfaExtensionSchema.getSchemasProperty();

    // Assert
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", actualSchemasProperty.getNamespace());
    assertEquals("pdfaExtension", actualSchemasProperty.getPrefix());
    assertEquals(1, actualSchemasProperty.getAllProperties().size());
    assertEquals(1, actualSchemasProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualSchemasProperty.getArrayType());
    assertTrue(actualSchemasProperty.getAllAttributes().isEmpty());
    assertTrue(actualSchemasProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PDFAExtensionSchema.SCHEMAS, actualSchemasProperty.getPropertyName());
    assertSame(metadata, actualSchemasProperty.getMetadata());
  }

  /**
   * Test {@link PDFAExtensionSchema#getSchemasProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAExtensionSchema#getSchemasProperty()}
   */
  @Test
  @DisplayName("Test getSchemasProperty(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty PDFAExtensionSchema.getSchemasProperty()"})
  void testGetSchemasProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFAExtensionSchema(XMPMetadata.createXMPMetadata())).getSchemasProperty());
  }
}
