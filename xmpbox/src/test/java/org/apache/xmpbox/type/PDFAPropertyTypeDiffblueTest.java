package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFAPropertyTypeDiffblueTest {
  /**
   * Test {@link PDFAPropertyType#PDFAPropertyType(XMPMetadata)}.
   * <p>
   * Method under test: {@link PDFAPropertyType#PDFAPropertyType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new PDFAPropertyType(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFAPropertyType.<init>(XMPMetadata)"})
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
    assertTrue(actualPdfaPropertyType.getAllProperties().isEmpty());
    assertTrue(actualPdfaPropertyType.getAllAttributes().isEmpty());
    assertTrue(actualPdfaPropertyType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualPdfaPropertyType.getMetadata());
  }

  /**
   * Test {@link PDFAPropertyType#getName()}.
   * <ul>
   *   <li>Given {@link PDFAPropertyType#PDFAPropertyType(XMPMetadata)} with metadata is createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAPropertyType#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDFAPropertyType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFAPropertyType.getName()"})
  void testGetName_givenPDFAPropertyTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFAPropertyType(XMPMetadata.createXMPMetadata())).getName());
  }

  /**
   * Test {@link PDFAPropertyType#getName()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAPropertyType#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFAPropertyType.getName()"})
  void testGetName_thenReturnValue() {
    // Arrange
    PDFAPropertyType pdfaPropertyType = new PDFAPropertyType(XMPMetadata.createXMPMetadata());
    pdfaPropertyType.addSimpleProperty(PDFAPropertyType.NAME, "Value");

    // Act and Assert
    assertEquals("Value", pdfaPropertyType.getName());
  }

  /**
   * Test {@link PDFAPropertyType#getValueType()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAPropertyType#getValueType()}
   */
  @Test
  @DisplayName("Test getValueType(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFAPropertyType.getValueType()"})
  void testGetValueType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFAPropertyType(XMPMetadata.createXMPMetadata())).getValueType());
  }

  /**
   * Test {@link PDFAPropertyType#getValueType()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAPropertyType#getValueType()}
   */
  @Test
  @DisplayName("Test getValueType(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFAPropertyType.getValueType()"})
  void testGetValueType_thenReturnValue() {
    // Arrange
    PDFAPropertyType pdfaPropertyType = new PDFAPropertyType(XMPMetadata.createXMPMetadata());
    pdfaPropertyType.addSimpleProperty(PDFAPropertyType.VALUETYPE, "Value");

    // Act and Assert
    assertEquals("Value", pdfaPropertyType.getValueType());
  }

  /**
   * Test {@link PDFAPropertyType#getDescription()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAPropertyType#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFAPropertyType.getDescription()"})
  void testGetDescription_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFAPropertyType(XMPMetadata.createXMPMetadata())).getDescription());
  }

  /**
   * Test {@link PDFAPropertyType#getDescription()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAPropertyType#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFAPropertyType.getDescription()"})
  void testGetDescription_thenReturnValue() {
    // Arrange
    PDFAPropertyType pdfaPropertyType = new PDFAPropertyType(XMPMetadata.createXMPMetadata());
    pdfaPropertyType.addSimpleProperty(PDFAPropertyType.DESCRIPTION, "Value");

    // Act and Assert
    assertEquals("Value", pdfaPropertyType.getDescription());
  }

  /**
   * Test {@link PDFAPropertyType#getCategory()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAPropertyType#getCategory()}
   */
  @Test
  @DisplayName("Test getCategory(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFAPropertyType.getCategory()"})
  void testGetCategory_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFAPropertyType(XMPMetadata.createXMPMetadata())).getCategory());
  }

  /**
   * Test {@link PDFAPropertyType#getCategory()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFAPropertyType#getCategory()}
   */
  @Test
  @DisplayName("Test getCategory(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFAPropertyType.getCategory()"})
  void testGetCategory_thenReturnValue() {
    // Arrange
    PDFAPropertyType pdfaPropertyType = new PDFAPropertyType(XMPMetadata.createXMPMetadata());
    pdfaPropertyType.addSimpleProperty(PDFAPropertyType.CATEGORY, "Value");

    // Act and Assert
    assertEquals("Value", pdfaPropertyType.getCategory());
  }
}
