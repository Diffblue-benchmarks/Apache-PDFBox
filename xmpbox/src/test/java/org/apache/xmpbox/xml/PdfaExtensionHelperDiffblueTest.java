package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.apache.xmpbox.schema.PDFAExtensionSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class PdfaExtensionHelperDiffblueTest {
  /**
   * Test {@link PdfaExtensionHelper#validateNaming(XMPMetadata, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PdfaExtensionHelper#validateNaming(XMPMetadata, Element)}
   */
  @Test
  @DisplayName(
      "Test validateNaming(XMPMetadata, Element); when IIOMetadataNode(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PdfaExtensionHelper.validateNaming(XMPMetadata, Element)"})
  void testValidateNaming_whenIIOMetadataNode_thenDoesNotThrow() throws XmpParsingException {
    // Arrange
    XMPMetadata meta = XMPMetadata.createXMPMetadata();

    // Act and Assert
    assertDoesNotThrow(() -> PdfaExtensionHelper.validateNaming(meta, new IIOMetadataNode()));
  }

  /**
   * Test {@link PdfaExtensionHelper#populateSchemaMapping(XMPMetadata)}.
   *
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PdfaExtensionHelper#populateSchemaMapping(XMPMetadata)}
   */
  @Test
  @DisplayName(
      "Test populateSchemaMapping(XMPMetadata); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PdfaExtensionHelper.populateSchemaMapping(XMPMetadata)"})
  void testPopulateSchemaMapping_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata()
      throws XmpParsingException {
    // Arrange
    XMPMetadata meta = XMPMetadata.createXMPMetadata();
    meta.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertDoesNotThrow(() -> PdfaExtensionHelper.populateSchemaMapping(meta));
  }

  /**
   * Test {@link PdfaExtensionHelper#populateSchemaMapping(XMPMetadata)}.
   *
   * <ul>
   *   <li>Then throw {@link XmpParsingException}.
   * </ul>
   *
   * <p>Method under test: {@link PdfaExtensionHelper#populateSchemaMapping(XMPMetadata)}
   */
  @Test
  @DisplayName("Test populateSchemaMapping(XMPMetadata); then throw XmpParsingException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PdfaExtensionHelper.populateSchemaMapping(XMPMetadata)"})
  void testPopulateSchemaMapping_thenThrowXmpParsingException() throws XmpParsingException {
    // Arrange
    PDFAExtensionSchema obj = new PDFAExtensionSchema(XMPMetadata.createXMPMetadata(), "Prefix");
    obj.addBagValueAsSimple(
        "http://www.aiim.org/pdfa/ns/extension/", "http://ns.adobe.com/pdf/1.3/");

    XMPMetadata meta = XMPMetadata.createXMPMetadata();
    meta.addSchema(obj);

    // Act and Assert
    assertThrows(XmpParsingException.class, () -> PdfaExtensionHelper.populateSchemaMapping(meta));
  }

  /**
   * Test {@link PdfaExtensionHelper#populateSchemaMapping(XMPMetadata)}.
   *
   * <ul>
   *   <li>When createXMPMetadata.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PdfaExtensionHelper#populateSchemaMapping(XMPMetadata)}
   */
  @Test
  @DisplayName(
      "Test populateSchemaMapping(XMPMetadata); when createXMPMetadata; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PdfaExtensionHelper.populateSchemaMapping(XMPMetadata)"})
  void testPopulateSchemaMapping_whenCreateXMPMetadata_thenDoesNotThrow()
      throws XmpParsingException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> PdfaExtensionHelper.populateSchemaMapping(XMPMetadata.createXMPMetadata()));
  }
}
