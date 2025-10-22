package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFontFactoryDiffblueTest {
  /**
   * Test {@link PDFontFactory#createFont(COSDictionary, ResourceCache)} with {@code dictionary}, {@code resourceCache}.
   * <ul>
   *   <li>Then FontBoxFont return {@link TrueTypeFont}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFontFactory#createFont(COSDictionary, ResourceCache)}
   */
  @Test
  @DisplayName("Test createFont(COSDictionary, ResourceCache) with 'dictionary', 'resourceCache'; then FontBoxFont return TrueTypeFont")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFont PDFontFactory.createFont(COSDictionary, ResourceCache)"})
  void testCreateFontWithDictionaryResourceCache_thenFontBoxFontReturnTrueTypeFont() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDFont actualCreateFontResult = PDFontFactory.createFont(dictionary, new DefaultResourceCache());

    // Assert
    assertTrue(((PDType1Font) actualCreateFontResult).getFontBoxFont() instanceof TrueTypeFont);
    assertTrue(actualCreateFontResult instanceof PDType1Font);
    assertTrue(((PDType1Font) actualCreateFontResult).getEncoding() instanceof StandardEncoding);
    assertNull(((PDType1Font) actualCreateFontResult).getSymbolicFlag());
    assertNull(actualCreateFontResult.getSubType());
    assertNull(actualCreateFontResult.getType());
    assertNull(actualCreateFontResult.getName());
    assertNull(((PDType1Font) actualCreateFontResult).getBaseFont());
    assertNull(actualCreateFontResult.getStandard14AFM());
    assertNull(actualCreateFontResult.getToUnicodeCMap());
    assertNull(((PDType1Font) actualCreateFontResult).getType1Font());
    assertNull(actualCreateFontResult.getFontDescriptor());
    assertEquals(0.0f, actualCreateFontResult.getAverageFontWidth());
    assertEquals(250.0f, actualCreateFontResult.getSpaceWidth());
    assertFalse(actualCreateFontResult.isVertical());
    assertFalse(actualCreateFontResult.isDamaged());
    assertFalse(actualCreateFontResult.isEmbedded());
    assertTrue(actualCreateFontResult.getWidths().isEmpty());
    assertSame(dictionary, actualCreateFontResult.getCOSObject());
  }

  /**
   * Test {@link PDFontFactory#createFont(COSDictionary)} with {@code dictionary}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then FontBoxFont return {@link TrueTypeFont}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFontFactory#createFont(COSDictionary)}
   */
  @Test
  @DisplayName("Test createFont(COSDictionary) with 'dictionary'; when COSDictionary(); then FontBoxFont return TrueTypeFont")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFont PDFontFactory.createFont(COSDictionary)"})
  void testCreateFontWithDictionary_whenCOSDictionary_thenFontBoxFontReturnTrueTypeFont() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDFont actualCreateFontResult = PDFontFactory.createFont(dictionary);

    // Assert
    assertTrue(((PDType1Font) actualCreateFontResult).getFontBoxFont() instanceof TrueTypeFont);
    assertTrue(actualCreateFontResult instanceof PDType1Font);
    assertTrue(((PDType1Font) actualCreateFontResult).getEncoding() instanceof StandardEncoding);
    assertNull(((PDType1Font) actualCreateFontResult).getSymbolicFlag());
    assertNull(actualCreateFontResult.getSubType());
    assertNull(actualCreateFontResult.getType());
    assertNull(actualCreateFontResult.getName());
    assertNull(((PDType1Font) actualCreateFontResult).getBaseFont());
    assertNull(actualCreateFontResult.getStandard14AFM());
    assertNull(actualCreateFontResult.getToUnicodeCMap());
    assertNull(((PDType1Font) actualCreateFontResult).getType1Font());
    assertNull(actualCreateFontResult.getFontDescriptor());
    assertEquals(0.0f, actualCreateFontResult.getAverageFontWidth());
    assertEquals(250.0f, actualCreateFontResult.getSpaceWidth());
    assertFalse(actualCreateFontResult.isVertical());
    assertFalse(actualCreateFontResult.isDamaged());
    assertFalse(actualCreateFontResult.isEmbedded());
    assertTrue(actualCreateFontResult.getWidths().isEmpty());
    assertSame(dictionary, actualCreateFontResult.getCOSObject());
  }

  /**
   * Test {@link PDFontFactory#createDescendantFont(COSDictionary, PDType0Font)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFontFactory#createDescendantFont(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName("Test createDescendantFont(COSDictionary, PDType0Font); when COSDictionary(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.font.PDCIDFont PDFontFactory.createDescendantFont(COSDictionary, PDType0Font)"})
  void testCreateDescendantFont_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFontFactory.createDescendantFont(new COSDictionary(), null));
  }
}
