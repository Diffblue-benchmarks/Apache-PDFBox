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

class PDFASchemaTypeDiffblueTest {
  /**
   * Test {@link PDFASchemaType#PDFASchemaType(XMPMetadata)}.
   * <p>
   * Method under test: {@link PDFASchemaType#PDFASchemaType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new PDFASchemaType(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFASchemaType.<init>(XMPMetadata)"})
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
    assertTrue(actualPdfaSchemaType.getAllProperties().isEmpty());
    assertTrue(actualPdfaSchemaType.getAllAttributes().isEmpty());
    assertTrue(actualPdfaSchemaType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualPdfaSchemaType.getMetadata());
  }

  /**
   * Test {@link PDFASchemaType#getNamespaceURI()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFASchemaType#getNamespaceURI()}
   */
  @Test
  @DisplayName("Test getNamespaceURI(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFASchemaType.getNamespaceURI()"})
  void testGetNamespaceURI_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFASchemaType(XMPMetadata.createXMPMetadata())).getNamespaceURI());
  }

  /**
   * Test {@link PDFASchemaType#getNamespaceURI()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFASchemaType#getNamespaceURI()}
   */
  @Test
  @DisplayName("Test getNamespaceURI(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFASchemaType.getNamespaceURI()"})
  void testGetNamespaceURI_thenReturnValue() {
    // Arrange
    PDFASchemaType pdfaSchemaType = new PDFASchemaType(XMPMetadata.createXMPMetadata());
    pdfaSchemaType.addSimpleProperty(PDFASchemaType.NAMESPACE_URI, "Value");

    // Act and Assert
    assertEquals("Value", pdfaSchemaType.getNamespaceURI());
  }

  /**
   * Test {@link PDFASchemaType#getPrefixValue()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFASchemaType#getPrefixValue()}
   */
  @Test
  @DisplayName("Test getPrefixValue(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFASchemaType.getPrefixValue()"})
  void testGetPrefixValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFASchemaType(XMPMetadata.createXMPMetadata())).getPrefixValue());
  }

  /**
   * Test {@link PDFASchemaType#getPrefixValue()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFASchemaType#getPrefixValue()}
   */
  @Test
  @DisplayName("Test getPrefixValue(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFASchemaType.getPrefixValue()"})
  void testGetPrefixValue_thenReturnValue() {
    // Arrange
    PDFASchemaType pdfaSchemaType = new PDFASchemaType(XMPMetadata.createXMPMetadata());
    pdfaSchemaType.addSimpleProperty(PDFASchemaType.PREFIX, "Value");

    // Act and Assert
    assertEquals("Value", pdfaSchemaType.getPrefixValue());
  }

  /**
   * Test {@link PDFASchemaType#getProperty()}.
   * <p>
   * Method under test: {@link PDFASchemaType#getProperty()}
   */
  @Test
  @DisplayName("Test getProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty PDFASchemaType.getProperty()"})
  void testGetProperty() {
    // Arrange
    PDFASchemaType pdfaSchemaType = new PDFASchemaType(XMPMetadata.createXMPMetadata());
    ArrayProperty obj = new ArrayProperty(XMPMetadata.createXMPMetadata(), PDFASchemaType.PROPERTY,
        PDFASchemaType.PROPERTY, PDFASchemaType.PROPERTY, Cardinality.Simple);

    pdfaSchemaType.addProperty(obj);

    // Act and Assert
    assertSame(obj, pdfaSchemaType.getProperty());
  }

  /**
   * Test {@link PDFASchemaType#getProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFASchemaType#getProperty()}
   */
  @Test
  @DisplayName("Test getProperty(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty PDFASchemaType.getProperty()"})
  void testGetProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFASchemaType(XMPMetadata.createXMPMetadata())).getProperty());
  }

  /**
   * Test {@link PDFASchemaType#getValueType()}.
   * <p>
   * Method under test: {@link PDFASchemaType#getValueType()}
   */
  @Test
  @DisplayName("Test getValueType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty PDFASchemaType.getValueType()"})
  void testGetValueType() {
    // Arrange
    PDFASchemaType pdfaSchemaType = new PDFASchemaType(XMPMetadata.createXMPMetadata());
    ArrayProperty obj = new ArrayProperty(XMPMetadata.createXMPMetadata(), PDFASchemaType.VALUE_TYPE,
        PDFASchemaType.VALUE_TYPE, PDFASchemaType.VALUE_TYPE, Cardinality.Simple);

    pdfaSchemaType.addProperty(obj);

    // Act and Assert
    assertSame(obj, pdfaSchemaType.getValueType());
  }

  /**
   * Test {@link PDFASchemaType#getValueType()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFASchemaType#getValueType()}
   */
  @Test
  @DisplayName("Test getValueType(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty PDFASchemaType.getValueType()"})
  void testGetValueType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFASchemaType(XMPMetadata.createXMPMetadata())).getValueType());
  }
}
