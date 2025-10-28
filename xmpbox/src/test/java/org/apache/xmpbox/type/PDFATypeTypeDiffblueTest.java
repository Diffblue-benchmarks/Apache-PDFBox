package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class PDFATypeTypeDiffblueTest {
  /**
   * Method under test: {@link PDFATypeType#getNamespaceURI()}
   */
  @Test
  void testGetNamespaceURI() {
    // Arrange, Act and Assert
    assertNull((new PDFATypeType(XMPMetadata.createXMPMetadata())).getNamespaceURI());
  }

  /**
   * Method under test: {@link PDFATypeType#getNamespaceURI()}
   */
  @Test
  void testGetNamespaceURI2() {
    // Arrange
    PDFATypeType pdfaTypeType = new PDFATypeType(XMPMetadata.createXMPMetadata());
    pdfaTypeType.addSimpleProperty(PDFATypeType.NS_URI, "Value");

    // Act and Assert
    assertEquals("Value", pdfaTypeType.getNamespaceURI());
  }

  /**
   * Method under test: {@link PDFATypeType#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertNull((new PDFATypeType(XMPMetadata.createXMPMetadata())).getType());
  }

  /**
   * Method under test: {@link PDFATypeType#getType()}
   */
  @Test
  void testGetType2() {
    // Arrange
    PDFATypeType pdfaTypeType = new PDFATypeType(XMPMetadata.createXMPMetadata());
    pdfaTypeType.addSimpleProperty(PDFATypeType.TYPE, "Value");

    // Act and Assert
    assertEquals("Value", pdfaTypeType.getType());
  }

  /**
   * Method under test: {@link PDFATypeType#getPrefixValue()}
   */
  @Test
  void testGetPrefixValue() {
    // Arrange, Act and Assert
    assertNull((new PDFATypeType(XMPMetadata.createXMPMetadata())).getPrefixValue());
  }

  /**
   * Method under test: {@link PDFATypeType#getPrefixValue()}
   */
  @Test
  void testGetPrefixValue2() {
    // Arrange
    PDFATypeType pdfaTypeType = new PDFATypeType(XMPMetadata.createXMPMetadata());
    pdfaTypeType.addSimpleProperty(PDFATypeType.PREFIX, "Value");

    // Act and Assert
    assertEquals("Value", pdfaTypeType.getPrefixValue());
  }

  /**
   * Method under test: {@link PDFATypeType#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange, Act and Assert
    assertNull((new PDFATypeType(XMPMetadata.createXMPMetadata())).getDescription());
  }

  /**
   * Method under test: {@link PDFATypeType#getDescription()}
   */
  @Test
  void testGetDescription2() {
    // Arrange
    PDFATypeType pdfaTypeType = new PDFATypeType(XMPMetadata.createXMPMetadata());
    pdfaTypeType.addSimpleProperty(PDFATypeType.DESCRIPTION, "Value");

    // Act and Assert
    assertEquals("Value", pdfaTypeType.getDescription());
  }

  /**
   * Method under test: {@link PDFATypeType#getFields()}
   */
  @Test
  void testGetFields() {
    // Arrange, Act and Assert
    assertNull((new PDFATypeType(XMPMetadata.createXMPMetadata())).getFields());
  }

  /**
   * Method under test: {@link PDFATypeType#getFields()}
   */
  @Test
  void testGetFields2() {
    // Arrange
    PDFATypeType pdfaTypeType = new PDFATypeType(XMPMetadata.createXMPMetadata());
    ArrayProperty obj = new ArrayProperty(XMPMetadata.createXMPMetadata(), PDFATypeType.FIELD, PDFATypeType.FIELD,
        PDFATypeType.FIELD, Cardinality.Simple);

    pdfaTypeType.addProperty(obj);

    // Act and Assert
    assertSame(obj, pdfaTypeType.getFields());
  }

  /**
   * Method under test: {@link PDFATypeType#PDFATypeType(XMPMetadata)}
   */
  @Test
  void testNewPDFATypeType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFATypeType actualPdfaTypeType = new PDFATypeType(metadata);

    // Assert
    assertEquals("http://www.aiim.org/pdfa/ns/type#", actualPdfaTypeType.getNamespace());
    assertEquals("pdfaType", actualPdfaTypeType.getPreferedPrefix());
    assertEquals("pdfaType", actualPdfaTypeType.getPrefix());
    assertNull(actualPdfaTypeType.getPropertyName());
    assertNull(actualPdfaTypeType.getDescription());
    assertNull(actualPdfaTypeType.getNamespaceURI());
    assertNull(actualPdfaTypeType.getPrefixValue());
    assertNull(actualPdfaTypeType.getType());
    assertNull(actualPdfaTypeType.getFields());
    List<AbstractField> allProperties = actualPdfaTypeType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPdfaTypeType.getAllAttributes().isEmpty());
    assertTrue(actualPdfaTypeType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualPdfaTypeType.getContainer().getAllProperties());
    assertSame(metadata, actualPdfaTypeType.getMetadata());
  }
}
