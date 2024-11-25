package org.apache.pdfbox.examples.pdmodel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmbeddedMultipleFontsDiffblueTest {
  /**
   * Test
   * {@link EmbeddedMultipleFonts#showTextMultiple(PDPageContentStream, String, List, float)}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EmbeddedMultipleFonts#showTextMultiple(PDPageContentStream, String, List, float)}
   */
  @Test
  @DisplayName("Test showTextMultiple(PDPageContentStream, String, List, float); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  void testShowTextMultiple_givenPDTrueTypeFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDPageContentStream cs = new PDPageContentStream(document, new PDPage());

    ArrayList<PDFont> fonts = new ArrayList<>();
    fonts.add(new PDTrueTypeFont(new COSDictionary()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> EmbeddedMultipleFonts.showTextMultiple(cs, "Text", fonts, 10.0f));
  }

  /**
   * Test
   * {@link EmbeddedMultipleFonts#showTextMultiple(PDPageContentStream, String, List, float)}.
   * <ul>
   *   <li>When {@link Float#NaN}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EmbeddedMultipleFonts#showTextMultiple(PDPageContentStream, String, List, float)}
   */
  @Test
  @DisplayName("Test showTextMultiple(PDPageContentStream, String, List, float); when NaN; then throw IllegalArgumentException")
  void testShowTextMultiple_whenNaN_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDPageContentStream cs = new PDPageContentStream(document, new PDPage());

    ArrayList<PDFont> fonts = new ArrayList<>();
    fonts.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> EmbeddedMultipleFonts.showTextMultiple(cs, "Text", fonts, Float.NaN));
  }

  /**
   * Test
   * {@link EmbeddedMultipleFonts#showTextMultiple(PDPageContentStream, String, List, float)}.
   * <ul>
   *   <li>When {@link Float#NaN}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EmbeddedMultipleFonts#showTextMultiple(PDPageContentStream, String, List, float)}
   */
  @Test
  @DisplayName("Test showTextMultiple(PDPageContentStream, String, List, float); when NaN; then throw IllegalArgumentException")
  void testShowTextMultiple_whenNaN_thenThrowIllegalArgumentException2() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDPageContentStream cs = new PDPageContentStream(document, new PDPage());

    ArrayList<PDFont> fonts = new ArrayList<>();
    fonts.add(new PDMMType1Font(new COSDictionary()));
    fonts.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> EmbeddedMultipleFonts.showTextMultiple(cs, "Text", fonts, Float.NaN));
  }

  /**
   * Test {@link EmbeddedMultipleFonts#isWinAnsiEncoding(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmbeddedMultipleFonts#isWinAnsiEncoding(int)}
   */
  @Test
  @DisplayName("Test isWinAnsiEncoding(int); when one; then return 'false'")
  void testIsWinAnsiEncoding_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EmbeddedMultipleFonts.isWinAnsiEncoding(1));
  }

  /**
   * Test {@link EmbeddedMultipleFonts#isWinAnsiEncoding(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmbeddedMultipleFonts#isWinAnsiEncoding(int)}
   */
  @Test
  @DisplayName("Test isWinAnsiEncoding(int); when zero; then return 'false'")
  void testIsWinAnsiEncoding_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EmbeddedMultipleFonts.isWinAnsiEncoding(0));
  }
}
