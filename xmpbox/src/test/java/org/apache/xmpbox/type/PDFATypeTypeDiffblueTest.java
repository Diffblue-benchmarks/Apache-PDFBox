package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFATypeTypeDiffblueTest {
  /**
   * Test {@link PDFATypeType#PDFATypeType(XMPMetadata)}.
   * <p>
   * Method under test: {@link PDFATypeType#PDFATypeType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new PDFATypeType(XMPMetadata)")
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

  /**
   * Test {@link PDFATypeType#getNamespaceURI()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFATypeType#getNamespaceURI()}
   */
  @Test
  @DisplayName("Test getNamespaceURI(); then return 'null'")
  void testGetNamespaceURI_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFATypeType(XMPMetadata.createXMPMetadata())).getNamespaceURI());
  }

  /**
   * Test {@link PDFATypeType#getNamespaceURI()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFATypeType#getNamespaceURI()}
   */
  @Test
  @DisplayName("Test getNamespaceURI(); then return 'Value'")
  void testGetNamespaceURI_thenReturnValue() {
    // Arrange
    PDFATypeType pdfaTypeType = new PDFATypeType(XMPMetadata.createXMPMetadata());
    pdfaTypeType.addSimpleProperty(PDFATypeType.NS_URI, "Value");

    // Act and Assert
    assertEquals("Value", pdfaTypeType.getNamespaceURI());
  }

  /**
   * Test {@link PDFATypeType#getType()}.
   * <ul>
   *   <li>Given {@link PDFATypeType#PDFATypeType(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFATypeType#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDFATypeType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetType_givenPDFATypeTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFATypeType(XMPMetadata.createXMPMetadata())).getType());
  }

  /**
   * Test {@link PDFATypeType#getType()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFATypeType#getType()}
   */
  @Test
  @DisplayName("Test getType(); then return 'Value'")
  void testGetType_thenReturnValue() {
    // Arrange
    PDFATypeType pdfaTypeType = new PDFATypeType(XMPMetadata.createXMPMetadata());
    pdfaTypeType.addSimpleProperty(PDFATypeType.TYPE, "Value");

    // Act and Assert
    assertEquals("Value", pdfaTypeType.getType());
  }

  /**
   * Test {@link PDFATypeType#getPrefixValue()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFATypeType#getPrefixValue()}
   */
  @Test
  @DisplayName("Test getPrefixValue(); then return 'null'")
  void testGetPrefixValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFATypeType(XMPMetadata.createXMPMetadata())).getPrefixValue());
  }

  /**
   * Test {@link PDFATypeType#getPrefixValue()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFATypeType#getPrefixValue()}
   */
  @Test
  @DisplayName("Test getPrefixValue(); then return 'Value'")
  void testGetPrefixValue_thenReturnValue() {
    // Arrange
    PDFATypeType pdfaTypeType = new PDFATypeType(XMPMetadata.createXMPMetadata());
    pdfaTypeType.addSimpleProperty(PDFATypeType.PREFIX, "Value");

    // Act and Assert
    assertEquals("Value", pdfaTypeType.getPrefixValue());
  }

  /**
   * Test {@link PDFATypeType#getDescription()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFATypeType#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return 'null'")
  void testGetDescription_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFATypeType(XMPMetadata.createXMPMetadata())).getDescription());
  }

  /**
   * Test {@link PDFATypeType#getDescription()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFATypeType#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return 'Value'")
  void testGetDescription_thenReturnValue() {
    // Arrange
    PDFATypeType pdfaTypeType = new PDFATypeType(XMPMetadata.createXMPMetadata());
    pdfaTypeType.addSimpleProperty(PDFATypeType.DESCRIPTION, "Value");

    // Act and Assert
    assertEquals("Value", pdfaTypeType.getDescription());
  }

  /**
   * Test {@link PDFATypeType#getFields()}.
   * <p>
   * Method under test: {@link PDFATypeType#getFields()}
   */
  @Test
  @DisplayName("Test getFields()")
  void testGetFields() {
    // Arrange
    PDFATypeType pdfaTypeType = new PDFATypeType(XMPMetadata.createXMPMetadata());
    ArrayProperty obj = new ArrayProperty(XMPMetadata.createXMPMetadata(), PDFATypeType.FIELD, PDFATypeType.FIELD,
        PDFATypeType.FIELD, Cardinality.Simple);

    pdfaTypeType.addProperty(obj);

    // Act and Assert
    assertSame(obj, pdfaTypeType.getFields());
  }

  /**
   * Test {@link PDFATypeType#getFields()}.
   * <ul>
   *   <li>Given {@link PDFATypeType#PDFATypeType(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFATypeType#getFields()}
   */
  @Test
  @DisplayName("Test getFields(); given PDFATypeType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetFields_givenPDFATypeTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFATypeType(XMPMetadata.createXMPMetadata())).getFields());
  }
}
