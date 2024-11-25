package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.TextType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFAExtensionSchemaDiffblueTest {
  /**
   * Test {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata)}.
   * <p>
   * Method under test:
   * {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new PDFAExtensionSchema(XMPMetadata)")
  void testNewPDFAExtensionSchema() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAExtensionSchema actualPdfaExtensionSchema = new PDFAExtensionSchema(metadata);

    // Assert
    assertEquals("", actualPdfaExtensionSchema.getAboutValue());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", actualPdfaExtensionSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualPdfaExtensionSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("pdfaExtension", allNamespacesWithPrefix.get("http://www.aiim.org/pdfa/ns/extension/"));
    assertEquals("pdfaExtension", actualPdfaExtensionSchema.getPreferedPrefix());
    assertEquals("pdfaExtension", actualPdfaExtensionSchema.getPrefix());
    assertNull(actualPdfaExtensionSchema.getPropertyName());
    assertNull(actualPdfaExtensionSchema.getSchemasProperty());
    assertNull(actualPdfaExtensionSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualPdfaExtensionSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPdfaExtensionSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualPdfaExtensionSchema.getContainer().getAllProperties());
    assertSame(metadata, actualPdfaExtensionSchema.getMetadata());
  }

  /**
   * Test {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata, String)}.
   * <p>
   * Method under test:
   * {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new PDFAExtensionSchema(XMPMetadata, String)")
  void testNewPDFAExtensionSchema2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAExtensionSchema actualPdfaExtensionSchema = new PDFAExtensionSchema(metadata, "Prefix");

    // Assert
    assertEquals("", actualPdfaExtensionSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualPdfaExtensionSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Prefix", allNamespacesWithPrefix.get("http://www.aiim.org/pdfa/ns/extension/"));
    assertEquals("Prefix", actualPdfaExtensionSchema.getPrefix());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", actualPdfaExtensionSchema.getNamespace());
    assertEquals("pdfaExtension", actualPdfaExtensionSchema.getPreferedPrefix());
    assertNull(actualPdfaExtensionSchema.getPropertyName());
    assertNull(actualPdfaExtensionSchema.getSchemasProperty());
    assertNull(actualPdfaExtensionSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualPdfaExtensionSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPdfaExtensionSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualPdfaExtensionSchema.getContainer().getAllProperties());
    assertSame(metadata, actualPdfaExtensionSchema.getMetadata());
  }

  /**
   * Test {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata, String)}.
   * <p>
   * Method under test:
   * {@link PDFAExtensionSchema#PDFAExtensionSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new PDFAExtensionSchema(XMPMetadata, String)")
  void testNewPDFAExtensionSchema3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAExtensionSchema actualPdfaExtensionSchema = new PDFAExtensionSchema(metadata, null);

    // Assert
    assertEquals("", actualPdfaExtensionSchema.getAboutValue());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", actualPdfaExtensionSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualPdfaExtensionSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("pdfaExtension", allNamespacesWithPrefix.get("http://www.aiim.org/pdfa/ns/extension/"));
    assertEquals("pdfaExtension", actualPdfaExtensionSchema.getPreferedPrefix());
    assertEquals("pdfaExtension", actualPdfaExtensionSchema.getPrefix());
    assertNull(actualPdfaExtensionSchema.getPropertyName());
    assertNull(actualPdfaExtensionSchema.getSchemasProperty());
    assertNull(actualPdfaExtensionSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualPdfaExtensionSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPdfaExtensionSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualPdfaExtensionSchema.getContainer().getAllProperties());
    assertSame(metadata, actualPdfaExtensionSchema.getMetadata());
  }

  /**
   * Test {@link PDFAExtensionSchema#getSchemasProperty()}.
   * <p>
   * Method under test: {@link PDFAExtensionSchema#getSchemasProperty()}
   */
  @Test
  @DisplayName("Test getSchemasProperty()")
  void testGetSchemasProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAExtensionSchema pdfaExtensionSchema = new PDFAExtensionSchema(metadata);
    pdfaExtensionSchema.addBagValueAsSimple("Simple Name", PDFAExtensionSchema.SCHEMAS);
    pdfaExtensionSchema.addBagValueAsSimple(PDFAExtensionSchema.SCHEMAS, "42");

    // Act
    ArrayProperty actualSchemasProperty = pdfaExtensionSchema.getSchemasProperty();

    // Assert
    List<AbstractField> allProperties = actualSchemasProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = actualSchemasProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", getResult.getNamespace());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", actualSchemasProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("pdfaExtension", getResult.getPrefix());
    assertEquals("pdfaExtension", actualSchemasProperty.getPrefix());
    assertEquals(Cardinality.Bag, actualSchemasProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualSchemasProperty.getAllAttributes().isEmpty());
    assertTrue(actualSchemasProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PDFAExtensionSchema.SCHEMAS, actualSchemasProperty.getPropertyName());
    assertSame(allProperties, actualSchemasProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualSchemasProperty.getMetadata());
  }

  /**
   * Test {@link PDFAExtensionSchema#getSchemasProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAExtensionSchema#getSchemasProperty()}
   */
  @Test
  @DisplayName("Test getSchemasProperty(); then return AllProperties size is one")
  void testGetSchemasProperty_thenReturnAllPropertiesSizeIsOne() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PDFAExtensionSchema pdfaExtensionSchema = new PDFAExtensionSchema(metadata);
    pdfaExtensionSchema.addBagValueAsSimple(PDFAExtensionSchema.SCHEMAS, "42");

    // Act
    ArrayProperty actualSchemasProperty = pdfaExtensionSchema.getSchemasProperty();

    // Assert
    List<AbstractField> allProperties = actualSchemasProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = actualSchemasProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", getResult.getNamespace());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/", actualSchemasProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("pdfaExtension", getResult.getPrefix());
    assertEquals("pdfaExtension", actualSchemasProperty.getPrefix());
    assertEquals(Cardinality.Bag, actualSchemasProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualSchemasProperty.getAllAttributes().isEmpty());
    assertTrue(actualSchemasProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PDFAExtensionSchema.SCHEMAS, actualSchemasProperty.getPropertyName());
    assertSame(allProperties, actualSchemasProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
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
  void testGetSchemasProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFAExtensionSchema(XMPMetadata.createXMPMetadata())).getSchemasProperty());
  }
}
