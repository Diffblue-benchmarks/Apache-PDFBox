package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class PDFASchemaTypeDiffblueTest {
  /**
   * Method under test: {@link PDFASchemaType#getNamespaceURI()}
   */
  @Test
  void testGetNamespaceURI() {
    // Arrange, Act and Assert
    assertNull((new PDFASchemaType(XMPMetadata.createXMPMetadata())).getNamespaceURI());
  }

  /**
   * Method under test: {@link PDFASchemaType#getNamespaceURI()}
   */
  @Test
  void testGetNamespaceURI2() {
    // Arrange
    PDFASchemaType pdfaSchemaType = new PDFASchemaType(XMPMetadata.createXMPMetadata());
    pdfaSchemaType.addSimpleProperty(PDFASchemaType.NAMESPACE_URI, "Value");

    // Act and Assert
    assertEquals("Value", pdfaSchemaType.getNamespaceURI());
  }

  /**
   * Method under test: {@link PDFASchemaType#getPrefixValue()}
   */
  @Test
  void testGetPrefixValue() {
    // Arrange, Act and Assert
    assertNull((new PDFASchemaType(XMPMetadata.createXMPMetadata())).getPrefixValue());
  }

  /**
   * Method under test: {@link PDFASchemaType#getPrefixValue()}
   */
  @Test
  void testGetPrefixValue2() {
    // Arrange
    PDFASchemaType pdfaSchemaType = new PDFASchemaType(XMPMetadata.createXMPMetadata());
    pdfaSchemaType.addSimpleProperty(PDFASchemaType.PREFIX, "Value");

    // Act and Assert
    assertEquals("Value", pdfaSchemaType.getPrefixValue());
  }

  /**
   * Method under test: {@link PDFASchemaType#getProperty()}
   */
  @Test
  void testGetProperty() {
    // Arrange, Act and Assert
    assertNull((new PDFASchemaType(XMPMetadata.createXMPMetadata())).getProperty());
  }

  /**
   * Method under test: {@link PDFASchemaType#getProperty()}
   */
  @Test
  void testGetProperty2() {
    // Arrange
    PDFASchemaType pdfaSchemaType = new PDFASchemaType(XMPMetadata.createXMPMetadata());
    ArrayProperty obj = new ArrayProperty(XMPMetadata.createXMPMetadata(), PDFASchemaType.PROPERTY,
        PDFASchemaType.PROPERTY, PDFASchemaType.PROPERTY, Cardinality.Simple);

    pdfaSchemaType.addProperty(obj);

    // Act and Assert
    assertSame(obj, pdfaSchemaType.getProperty());
  }

  /**
   * Method under test: {@link PDFASchemaType#getValueType()}
   */
  @Test
  void testGetValueType() {
    // Arrange, Act and Assert
    assertNull((new PDFASchemaType(XMPMetadata.createXMPMetadata())).getValueType());
  }

  /**
   * Method under test: {@link PDFASchemaType#getValueType()}
   */
  @Test
  void testGetValueType2() {
    // Arrange
    PDFASchemaType pdfaSchemaType = new PDFASchemaType(XMPMetadata.createXMPMetadata());
    ArrayProperty obj = new ArrayProperty(XMPMetadata.createXMPMetadata(), PDFASchemaType.VALUE_TYPE,
        PDFASchemaType.VALUE_TYPE, PDFASchemaType.VALUE_TYPE, Cardinality.Simple);

    pdfaSchemaType.addProperty(obj);

    // Act and Assert
    assertSame(obj, pdfaSchemaType.getValueType());
  }

  /**
   * Method under test: {@link PDFASchemaType#PDFASchemaType(XMPMetadata)}
   */
  @Test
  void testNewPDFASchemaType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFASchemaType actualPdfaSchemaType = new PDFASchemaType(metadata);

    // Assert
    assertEquals("http://www.aiim.org/pdfa/ns/schema#", actualPdfaSchemaType.getNamespace());
    assertEquals("pdfaSchema", actualPdfaSchemaType.getPreferedPrefix());
    assertEquals("pdfaSchema", actualPdfaSchemaType.getPrefix());
    assertNull(actualPdfaSchemaType.getPropertyName());
    assertNull(actualPdfaSchemaType.getNamespaceURI());
    assertNull(actualPdfaSchemaType.getPrefixValue());
    assertNull(actualPdfaSchemaType.getProperty());
    assertNull(actualPdfaSchemaType.getValueType());
    List<AbstractField> allProperties = actualPdfaSchemaType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPdfaSchemaType.getAllAttributes().isEmpty());
    assertTrue(actualPdfaSchemaType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualPdfaSchemaType.getContainer().getAllProperties());
    assertSame(metadata, actualPdfaSchemaType.getMetadata());
  }
}
