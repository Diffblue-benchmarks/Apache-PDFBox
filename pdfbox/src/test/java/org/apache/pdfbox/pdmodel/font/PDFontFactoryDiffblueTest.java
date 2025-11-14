package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFontFactoryDiffblueTest {
  /**
   * Test {@link PDFontFactory#createDescendantFont(COSDictionary, PDType0Font)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontFactory#createDescendantFont(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName(
      "Test createDescendantFont(COSDictionary, PDType0Font); when COSDictionary(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.font.PDCIDFont PDFontFactory.createDescendantFont(COSDictionary, PDType0Font)"
  })
  void testCreateDescendantFont_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> PDFontFactory.createDescendantFont(new COSDictionary(), null));
  }

  /**
   * Test {@link PDFontFactory#createDescendantFont(COSDictionary, PDType0Font)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontFactory#createDescendantFont(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName(
      "Test createDescendantFont(COSDictionary, PDType0Font); when COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.font.PDCIDFont PDFontFactory.createDescendantFont(COSDictionary, PDType0Font)"
  })
  void testCreateDescendantFont_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> PDFontFactory.createDescendantFont(new COSStream(), null));
  }
}
