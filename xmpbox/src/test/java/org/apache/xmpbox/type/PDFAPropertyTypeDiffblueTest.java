package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class PDFAPropertyTypeDiffblueTest {
  /**
   * Method under test: {@link PDFAPropertyType#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new PDFAPropertyType(XMPMetadata.createXMPMetadata())).getName());
  }

  /**
   * Method under test: {@link PDFAPropertyType#getName()}
   */
  @Test
  void testGetName2() {
    // Arrange
    PDFAPropertyType pdfaPropertyType = new PDFAPropertyType(XMPMetadata.createXMPMetadata());
    pdfaPropertyType.addSimpleProperty(PDFAPropertyType.NAME, "Value");

    // Act and Assert
    assertEquals("Value", pdfaPropertyType.getName());
  }

  /**
   * Method under test: {@link PDFAPropertyType#getValueType()}
   */
  @Test
  void testGetValueType() {
    // Arrange, Act and Assert
    assertNull((new PDFAPropertyType(XMPMetadata.createXMPMetadata())).getValueType());
  }

  /**
   * Method under test: {@link PDFAPropertyType#getValueType()}
   */
  @Test
  void testGetValueType2() {
    // Arrange
    PDFAPropertyType pdfaPropertyType = new PDFAPropertyType(XMPMetadata.createXMPMetadata());
    pdfaPropertyType.addSimpleProperty(PDFAPropertyType.VALUETYPE, "Value");

    // Act and Assert
    assertEquals("Value", pdfaPropertyType.getValueType());
  }

  /**
   * Method under test: {@link PDFAPropertyType#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange, Act and Assert
    assertNull((new PDFAPropertyType(XMPMetadata.createXMPMetadata())).getDescription());
  }

  /**
   * Method under test: {@link PDFAPropertyType#getDescription()}
   */
  @Test
  void testGetDescription2() {
    // Arrange
    PDFAPropertyType pdfaPropertyType = new PDFAPropertyType(XMPMetadata.createXMPMetadata());
    pdfaPropertyType.addSimpleProperty(PDFAPropertyType.DESCRIPTION, "Value");

    // Act and Assert
    assertEquals("Value", pdfaPropertyType.getDescription());
  }

  /**
   * Method under test: {@link PDFAPropertyType#getCategory()}
   */
  @Test
  void testGetCategory() {
    // Arrange, Act and Assert
    assertNull((new PDFAPropertyType(XMPMetadata.createXMPMetadata())).getCategory());
  }

  /**
   * Method under test: {@link PDFAPropertyType#getCategory()}
   */
  @Test
  void testGetCategory2() {
    // Arrange
    PDFAPropertyType pdfaPropertyType = new PDFAPropertyType(XMPMetadata.createXMPMetadata());
    pdfaPropertyType.addSimpleProperty(PDFAPropertyType.CATEGORY, "Value");

    // Act and Assert
    assertEquals("Value", pdfaPropertyType.getCategory());
  }

  /**
   * Method under test: {@link PDFAPropertyType#PDFAPropertyType(XMPMetadata)}
   */
  @Test
  void testNewPDFAPropertyType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAPropertyType actualPdfaPropertyType = new PDFAPropertyType(metadata);

    // Assert
    assertEquals("http://www.aiim.org/pdfa/ns/property#", actualPdfaPropertyType.getNamespace());
    assertEquals("pdfaProperty", actualPdfaPropertyType.getPreferedPrefix());
    assertEquals("pdfaProperty", actualPdfaPropertyType.getPrefix());
    assertNull(actualPdfaPropertyType.getPropertyName());
    assertNull(actualPdfaPropertyType.getCategory());
    assertNull(actualPdfaPropertyType.getDescription());
    assertNull(actualPdfaPropertyType.getName());
    assertNull(actualPdfaPropertyType.getValueType());
    List<AbstractField> allProperties = actualPdfaPropertyType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPdfaPropertyType.getAllAttributes().isEmpty());
    assertTrue(actualPdfaPropertyType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualPdfaPropertyType.getContainer().getAllProperties());
    assertSame(metadata, actualPdfaPropertyType.getMetadata());
  }
}
