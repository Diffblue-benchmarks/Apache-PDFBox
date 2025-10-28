package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class PDFAFieldTypeDiffblueTest {
  /**
   * Method under test: {@link PDFAFieldType#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new PDFAFieldType(XMPMetadata.createXMPMetadata())).getName());
  }

  /**
   * Method under test: {@link PDFAFieldType#getName()}
   */
  @Test
  void testGetName2() {
    // Arrange
    PDFAFieldType pdfaFieldType = new PDFAFieldType(XMPMetadata.createXMPMetadata());
    pdfaFieldType.addSimpleProperty(PDFAFieldType.NAME, "Value");

    // Act and Assert
    assertEquals("Value", pdfaFieldType.getName());
  }

  /**
   * Method under test: {@link PDFAFieldType#getValueType()}
   */
  @Test
  void testGetValueType() {
    // Arrange, Act and Assert
    assertNull((new PDFAFieldType(XMPMetadata.createXMPMetadata())).getValueType());
  }

  /**
   * Method under test: {@link PDFAFieldType#getValueType()}
   */
  @Test
  void testGetValueType2() {
    // Arrange
    PDFAFieldType pdfaFieldType = new PDFAFieldType(XMPMetadata.createXMPMetadata());
    pdfaFieldType.addSimpleProperty(PDFAFieldType.VALUETYPE, "Value");

    // Act and Assert
    assertEquals("Value", pdfaFieldType.getValueType());
  }

  /**
   * Method under test: {@link PDFAFieldType#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange, Act and Assert
    assertNull((new PDFAFieldType(XMPMetadata.createXMPMetadata())).getDescription());
  }

  /**
   * Method under test: {@link PDFAFieldType#getDescription()}
   */
  @Test
  void testGetDescription2() {
    // Arrange
    PDFAFieldType pdfaFieldType = new PDFAFieldType(XMPMetadata.createXMPMetadata());
    pdfaFieldType.addSimpleProperty(PDFAFieldType.DESCRIPTION, "Value");

    // Act and Assert
    assertEquals("Value", pdfaFieldType.getDescription());
  }

  /**
   * Method under test: {@link PDFAFieldType#PDFAFieldType(XMPMetadata)}
   */
  @Test
  void testNewPDFAFieldType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PDFAFieldType actualPdfaFieldType = new PDFAFieldType(metadata);

    // Assert
    assertEquals("http://www.aiim.org/pdfa/ns/field#", actualPdfaFieldType.getNamespace());
    assertEquals("pdfaField", actualPdfaFieldType.getPreferedPrefix());
    assertEquals("pdfaField", actualPdfaFieldType.getPrefix());
    assertNull(actualPdfaFieldType.getPropertyName());
    assertNull(actualPdfaFieldType.getDescription());
    assertNull(actualPdfaFieldType.getName());
    assertNull(actualPdfaFieldType.getValueType());
    List<AbstractField> allProperties = actualPdfaFieldType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPdfaFieldType.getAllAttributes().isEmpty());
    assertTrue(actualPdfaFieldType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualPdfaFieldType.getContainer().getAllProperties());
    assertSame(metadata, actualPdfaFieldType.getMetadata());
  }
}
