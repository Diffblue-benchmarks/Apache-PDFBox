package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.text.TextPosition;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExtractTextDiffblueTest {
  /**
   * Test {@link ExtractText#getAngle(TextPosition)}.
   *
   * <p>Method under test: {@link ExtractText#getAngle(TextPosition)}
   */
  @Test
  @DisplayName("Test getAngle(TextPosition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExtractText.getAngle(TextPosition)"})
  void testGetAngle() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertEquals(
        0,
        ExtractText.getAngle(
            new TextPosition(
                1,
                10.0f,
                10.0f,
                textMatrix,
                10.0f,
                10.0f,
                10.0f,
                10.0f,
                10.0f,
                "Unicode",
                new int[] {1, -1, 1, -1},
                new PDMMType1Font(new COSDictionary()),
                10.0f,
                3)));
  }

  /**
   * Test {@link ExtractText#getAngle(TextPosition)}.
   *
   * <p>Method under test: {@link ExtractText#getAngle(TextPosition)}
   */
  @Test
  @DisplayName("Test getAngle(TextPosition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExtractText.getAngle(TextPosition)"})
  void testGetAngle2() {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(10.0f, 10.0f);

    // Act and Assert
    assertEquals(
        0,
        ExtractText.getAngle(
            new TextPosition(
                1,
                10.0f,
                10.0f,
                textMatrix,
                10.0f,
                10.0f,
                10.0f,
                10.0f,
                10.0f,
                "Unicode",
                new int[] {1, -1, 1, -1},
                new PDType1Font(FontName.TIMES_ROMAN),
                10.0f,
                3)));
  }

  /**
   * Test {@link ExtractText#getAngle(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExtractText#getAngle(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test getAngle(TextPosition); when PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExtractText.getAngle(TextPosition)"})
  void testGetAngle_whenPDTrueTypeFontWithFontDictionaryIsCOSDictionary_thenReturnZero()
      throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertEquals(
        0,
        ExtractText.getAngle(
            new TextPosition(
                1,
                10.0f,
                10.0f,
                textMatrix,
                10.0f,
                10.0f,
                10.0f,
                10.0f,
                10.0f,
                "Unicode",
                new int[] {1, -1, 1, -1},
                new PDTrueTypeFont(new COSDictionary()),
                10.0f,
                3)));
  }

  /**
   * Test {@link ExtractText#getAngle(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExtractText#getAngle(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test getAngle(TextPosition); when PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExtractText.getAngle(TextPosition)"})
  void testGetAngle_whenPDType3FontWithFontDictionaryIsCOSDictionary_thenReturnZero()
      throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(10.0f, 10.0f);

    // Act and Assert
    assertEquals(
        0,
        ExtractText.getAngle(
            new TextPosition(
                1,
                10.0f,
                10.0f,
                textMatrix,
                10.0f,
                10.0f,
                10.0f,
                10.0f,
                10.0f,
                "Unicode",
                new int[] {1, -1, 1, -1},
                new PDType3Font(new COSDictionary()),
                10.0f,
                3)));
  }
}
