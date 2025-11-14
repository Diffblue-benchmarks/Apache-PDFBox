package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExtractTextDiffblueTest {
  @InjectMocks private ExtractText extractText;

  @Mock private File file;

  /**
   * Test {@link ExtractText#call()}.
   *
   * <p>Method under test: {@link ExtractText#call()}
   */
  @Test
  @DisplayName("Test call()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ExtractText.call()"})
  void testCall() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn("Absolute Path");
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), ""));

    // Act
    Integer actualCallResult = extractText.call();

    // Assert
    verify(file).getAbsolutePath();
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link ExtractText#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#getAbsolutePath()} return {@code Absolute Path}.
   *   <li>Then return intValue is four.
   * </ul>
   *
   * <p>Method under test: {@link ExtractText#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File getAbsolutePath() return 'Absolute Path'; then return intValue is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ExtractText.call()"})
  void testCall_givenFileGetAbsolutePathReturnAbsolutePath_thenReturnIntValueIsFour() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn("Absolute Path");
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act
    Integer actualCallResult = extractText.call();

    // Assert
    verify(file).getAbsolutePath();
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link ExtractText#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#getAbsolutePath()} return {@code null}.
   *   <li>Then return intValue is four.
   * </ul>
   *
   * <p>Method under test: {@link ExtractText#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File getAbsolutePath() return 'null'; then return intValue is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ExtractText.call()"})
  void testCall_givenFileGetAbsolutePathReturnNull_thenReturnIntValueIsFour() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn(null);
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act
    Integer actualCallResult = extractText.call();

    // Assert
    verify(file).getAbsolutePath();
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link ExtractText#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#getAbsolutePath()} return {@code .txt}.
   *   <li>Then return intValue is four.
   * </ul>
   *
   * <p>Method under test: {@link ExtractText#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File getAbsolutePath() return '.txt'; then return intValue is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ExtractText.call()"})
  void testCall_givenFileGetAbsolutePathReturnTxt_thenReturnIntValueIsFour() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn(".txt");
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act
    Integer actualCallResult = extractText.call();

    // Assert
    verify(file).getAbsolutePath();
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
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
   *   <li>When {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExtractText#getAngle(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test getAngle(TextPosition); when PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExtractText.getAngle(TextPosition)"})
  void testGetAngle_whenPDType1FontWithBaseFontIsTimesRoman_thenReturnZero() {
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

  /**
   * Test {@link ExtractText#getAngle(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExtractText#getAngle(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test getAngle(TextPosition); when PDType3Font(COSDictionary) with fontDictionary is COSStream(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExtractText.getAngle(TextPosition)"})
  void testGetAngle_whenPDType3FontWithFontDictionaryIsCOSStream_thenReturnZero()
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
                new PDType3Font(new COSStream()),
                10.0f,
                3)));
  }
}
