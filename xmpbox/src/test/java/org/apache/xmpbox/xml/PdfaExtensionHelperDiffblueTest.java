package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.PDFAExtensionSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

class PdfaExtensionHelperDiffblueTest {
  /**
   * Test {@link PdfaExtensionHelper#validateNaming(XMPMetadata, Element)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PdfaExtensionHelper#validateNaming(XMPMetadata, Element)}
   */
  @Test
  @DisplayName("Test validateNaming(XMPMetadata, Element); then throw IllegalArgumentException")
  void testValidateNaming_thenThrowIllegalArgumentException() throws XmpParsingException {
    // Arrange
    XMPMetadata meta = XMPMetadata.createXMPMetadata();
    NamedNodeMap namedNodeMap = mock(NamedNodeMap.class);
    when(namedNodeMap.item(anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(namedNodeMap.getLength()).thenReturn(3);
    Element description = mock(Element.class);
    when(description.getAttributes()).thenReturn(namedNodeMap);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PdfaExtensionHelper.validateNaming(meta, description));
    verify(namedNodeMap).getLength();
    verify(namedNodeMap).item(eq(0));
    verify(description).getAttributes();
  }

  /**
   * Test {@link PdfaExtensionHelper#populateSchemaMapping(XMPMetadata)}.
   * <ul>
   *   <li>Then throw {@link XmpParsingException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PdfaExtensionHelper#populateSchemaMapping(XMPMetadata)}
   */
  @Test
  @DisplayName("Test populateSchemaMapping(XMPMetadata); then throw XmpParsingException")
  void testPopulateSchemaMapping_thenThrowXmpParsingException() throws XmpParsingException {
    // Arrange
    PDFAExtensionSchema obj = new PDFAExtensionSchema(XMPMetadata.createXMPMetadata(), "Prefix");
    obj.addBagValueAsSimple("http://www.aiim.org/pdfa/ns/extension/", "http://ns.adobe.com/pdf/1.3/");
    XMPMetadata meta = XMPMetadata.createXMPMetadata();
    meta.addSchema(obj);

    // Act and Assert
    assertThrows(XmpParsingException.class, () -> PdfaExtensionHelper.populateSchemaMapping(meta));
  }
}
