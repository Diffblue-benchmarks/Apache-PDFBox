package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFontFactoryDiffblueTest {
  /**
   * Test {@link PDFontFactory#createFont(COSDictionary, ResourceCache)} with
   * {@code dictionary}, {@code resourceCache}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFontFactory#createFont(COSDictionary, ResourceCache)}
   */
  @Test
  @DisplayName("Test createFont(COSDictionary, ResourceCache) with 'dictionary', 'resourceCache'; then return COSObject is COSDictionary()")
  void testCreateFontWithDictionaryResourceCache_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDFont actualCreateFontResult = PDFontFactory.createFont(dictionary, new DefaultResourceCache());

    // Assert
    FontBoxFont fontBoxFont = ((PDType1Font) actualCreateFontResult).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    assertTrue(actualCreateFontResult instanceof PDType1Font);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertSame(dictionary, actualCreateFontResult.getCOSObject());
  }

  /**
   * Test {@link PDFontFactory#createFont(COSDictionary, ResourceCache)} with
   * {@code dictionary}, {@code resourceCache}.
   * <ul>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFontFactory#createFont(COSDictionary, ResourceCache)}
   */
  @Test
  @DisplayName("Test createFont(COSDictionary, ResourceCache) with 'dictionary', 'resourceCache'; then return COSObject is COSStream()")
  void testCreateFontWithDictionaryResourceCache_thenReturnCOSObjectIsCOSStream() throws IOException {
    // Arrange
    COSStream dictionary = new COSStream();

    // Act
    PDFont actualCreateFontResult = PDFontFactory.createFont(dictionary, new DefaultResourceCache());

    // Assert
    FontBoxFont fontBoxFont = ((PDType1Font) actualCreateFontResult).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    assertTrue(actualCreateFontResult instanceof PDType1Font);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertSame(dictionary, actualCreateFontResult.getCOSObject());
  }

  /**
   * Test {@link PDFontFactory#createFont(COSDictionary)} with {@code dictionary}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFontFactory#createFont(COSDictionary)}
   */
  @Test
  @DisplayName("Test createFont(COSDictionary) with 'dictionary'; then return COSObject is COSDictionary()")
  void testCreateFontWithDictionary_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDFont actualCreateFontResult = PDFontFactory.createFont(dictionary);

    // Assert
    FontBoxFont fontBoxFont = ((PDType1Font) actualCreateFontResult).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    assertTrue(actualCreateFontResult instanceof PDType1Font);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertSame(dictionary, actualCreateFontResult.getCOSObject());
  }

  /**
   * Test {@link PDFontFactory#createFont(COSDictionary)} with {@code dictionary}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFontFactory#createFont(COSDictionary)}
   */
  @Test
  @DisplayName("Test createFont(COSDictionary) with 'dictionary'; when COSStream(); then return COSObject is COSStream()")
  void testCreateFontWithDictionary_whenCOSStream_thenReturnCOSObjectIsCOSStream() throws IOException {
    // Arrange
    COSStream dictionary = new COSStream();

    // Act
    PDFont actualCreateFontResult = PDFontFactory.createFont(dictionary);

    // Assert
    FontBoxFont fontBoxFont = ((PDType1Font) actualCreateFontResult).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    assertTrue(actualCreateFontResult instanceof PDType1Font);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertSame(dictionary, actualCreateFontResult.getCOSObject());
  }

  /**
   * Test {@link PDFontFactory#createDescendantFont(COSDictionary, PDType0Font)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFontFactory#createDescendantFont(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName("Test createDescendantFont(COSDictionary, PDType0Font); when COSDictionary(); then throw IOException")
  void testCreateDescendantFont_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFontFactory.createDescendantFont(new COSDictionary(), null));
  }

  /**
   * Test {@link PDFontFactory#createDescendantFont(COSDictionary, PDType0Font)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFontFactory#createDescendantFont(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName("Test createDescendantFont(COSDictionary, PDType0Font); when COSStream(); then throw IOException")
  void testCreateDescendantFont_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFontFactory.createDescendantFont(new COSStream(), null));
  }
}
