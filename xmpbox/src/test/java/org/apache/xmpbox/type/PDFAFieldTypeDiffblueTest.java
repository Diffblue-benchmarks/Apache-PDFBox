package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFAFieldTypeDiffblueTest {
  /**
   * Test {@link PDFAFieldType#PDFAFieldType(XMPMetadata)}.
   * <p>
   * Method under test: {@link PDFAFieldType#PDFAFieldType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new PDFAFieldType(XMPMetadata)")
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

  /**
   * Test {@link PDFAFieldType#getName()}.
   * <ul>
   *   <li>Given {@link PDFAFieldType#PDFAFieldType(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAFieldType#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDFAFieldType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetName_givenPDFAFieldTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFAFieldType(XMPMetadata.createXMPMetadata())).getName());
  }

  /**
   * Test {@link PDFAFieldType#getName()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAFieldType#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'Value'")
  void testGetName_thenReturnValue() {
    // Arrange
    PDFAFieldType pdfaFieldType = new PDFAFieldType(XMPMetadata.createXMPMetadata());
    pdfaFieldType.addSimpleProperty(PDFAFieldType.NAME, "Value");

    // Act and Assert
    assertEquals("Value", pdfaFieldType.getName());
  }

  /**
   * Test {@link PDFAFieldType#getValueType()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAFieldType#getValueType()}
   */
  @Test
  @DisplayName("Test getValueType(); then return 'null'")
  void testGetValueType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFAFieldType(XMPMetadata.createXMPMetadata())).getValueType());
  }

  /**
   * Test {@link PDFAFieldType#getValueType()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAFieldType#getValueType()}
   */
  @Test
  @DisplayName("Test getValueType(); then return 'Value'")
  void testGetValueType_thenReturnValue() {
    // Arrange
    PDFAFieldType pdfaFieldType = new PDFAFieldType(XMPMetadata.createXMPMetadata());
    pdfaFieldType.addSimpleProperty(PDFAFieldType.VALUETYPE, "Value");

    // Act and Assert
    assertEquals("Value", pdfaFieldType.getValueType());
  }

  /**
   * Test {@link PDFAFieldType#getDescription()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAFieldType#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return 'null'")
  void testGetDescription_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFAFieldType(XMPMetadata.createXMPMetadata())).getDescription());
  }

  /**
   * Test {@link PDFAFieldType#getDescription()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAFieldType#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return 'Value'")
  void testGetDescription_thenReturnValue() {
    // Arrange
    PDFAFieldType pdfaFieldType = new PDFAFieldType(XMPMetadata.createXMPMetadata());
    pdfaFieldType.addSimpleProperty(PDFAFieldType.DESCRIPTION, "Value");

    // Act and Assert
    assertEquals("Value", pdfaFieldType.getDescription());
  }
}
