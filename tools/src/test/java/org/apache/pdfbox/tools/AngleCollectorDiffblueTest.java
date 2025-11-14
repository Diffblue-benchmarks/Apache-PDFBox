package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDFont;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AngleCollectorDiffblueTest {
  @InjectMocks private AngleCollector angleCollector;

  @Mock private Matrix matrix;

  @Mock private PDFont pDFont;

  /**
   * Test {@link AngleCollector#AngleCollector()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link AngleCollector}
   */
  @Test
  @DisplayName("Test new AngleCollector()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AngleCollector.<init>()"})
  void testNewAngleCollector() throws IOException {
    // Arrange and Act
    AngleCollector actualAngleCollector = new AngleCollector();

    // Assert
    assertEquals(" ", actualAngleCollector.getWordSeparator());
    assertEquals("", actualAngleCollector.getArticleEnd());
    assertEquals("", actualAngleCollector.getArticleStart());
    assertEquals("", actualAngleCollector.getPageStart());
    assertEquals("", actualAngleCollector.getParagraphEnd());
    assertEquals("", actualAngleCollector.getParagraphStart());
    assertEquals("\n", actualAngleCollector.getLineSeparator());
    assertEquals("\n", actualAngleCollector.getPageEnd());
    assertNull(actualAngleCollector.getCurrentPage());
    assertNull(actualAngleCollector.getResources());
    assertNull(actualAngleCollector.getGraphicsState());
    assertNull(actualAngleCollector.getEndBookmark());
    assertNull(actualAngleCollector.getStartBookmark());
    assertNull(actualAngleCollector.getInitialMatrix());
    assertEquals(0, actualAngleCollector.getGraphicsStackSize());
    assertEquals(0, actualAngleCollector.getLevel());
    assertEquals(0.3f, actualAngleCollector.getAverageCharTolerance());
    assertEquals(0.5f, actualAngleCollector.getSpacingTolerance());
    assertEquals(1, actualAngleCollector.getStartPage());
    assertEquals(2.0f, actualAngleCollector.getIndentThreshold());
    assertEquals(2.5f, actualAngleCollector.getDropThreshold());
    assertFalse(actualAngleCollector.isShouldProcessColorOperators());
    assertFalse(actualAngleCollector.getAddMoreFormatting());
    assertFalse(actualAngleCollector.getIgnoreContentStreamSpaceGlyphs());
    assertFalse(actualAngleCollector.getSortByPosition());
    assertTrue(actualAngleCollector.getAngles().isEmpty());
    assertTrue(actualAngleCollector.getSeparateByBeads());
    assertTrue(actualAngleCollector.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualAngleCollector.getEndPage());
  }

  /**
   * Test {@link AngleCollector#getAngles()}.
   *
   * <p>Method under test: {@link AngleCollector#getAngles()}
   */
  @Test
  @DisplayName("Test getAngles()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AngleCollector.getAngles()"})
  void testGetAngles() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new AngleCollector().getAngles().isEmpty());
  }

  /**
   * Test {@link AngleCollector#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then {@link AngleCollector} Angles contains forty-five.
   * </ul>
   *
   * <p>Method under test: {@link AngleCollector#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); given ten; then AngleCollector Angles contains forty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AngleCollector.processTextPosition(TextPosition)"})
  void testProcessTextPosition_givenTen_thenAngleCollectorAnglesContainsFortyFive() {
    // Arrange
    when(matrix.getScaleY()).thenReturn(10.0f);
    when(matrix.getShearY()).thenReturn(10.0f);
    doNothing().when(matrix).concatenate(Mockito.<Matrix>any());
    when(matrix.clone()).thenReturn(matrix);
    when(pDFont.getFontMatrix()).thenReturn(new Matrix());

    TextPosition text =
        new TextPosition(
            1,
            10.0f,
            10.0f,
            matrix,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            "Unicode",
            new int[] {1, -1, 1, -1},
            pDFont,
            10.0f,
            3);

    // Act
    angleCollector.processTextPosition(text);

    // Assert
    verify(pDFont).getFontMatrix();
    verify(matrix).clone();
    verify(matrix).concatenate(isA(Matrix.class));
    verify(matrix).getScaleY();
    verify(matrix).getShearY();
    Set<Integer> angles = angleCollector.getAngles();
    assertEquals(1, angles.size());
    assertTrue(angles.contains(45));
  }

  /**
   * Test {@link AngleCollector#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>Then {@link AngleCollector} Angles contains zero.
   * </ul>
   *
   * <p>Method under test: {@link AngleCollector#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName("Test processTextPosition(TextPosition); then AngleCollector Angles contains zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AngleCollector.processTextPosition(TextPosition)"})
  void testProcessTextPosition_thenAngleCollectorAnglesContainsZero() {
    // Arrange
    when(matrix.clone()).thenReturn(new Matrix());
    when(pDFont.getFontMatrix()).thenReturn(new Matrix());

    TextPosition text =
        new TextPosition(
            1,
            10.0f,
            10.0f,
            matrix,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            "Unicode",
            new int[] {1, -1, 1, -1},
            pDFont,
            10.0f,
            3);

    // Act
    angleCollector.processTextPosition(text);

    // Assert
    verify(pDFont).getFontMatrix();
    verify(matrix).clone();
    Set<Integer> angles = angleCollector.getAngles();
    assertEquals(1, angles.size());
    assertTrue(angles.contains(0));
  }

  /**
   * Test {@link AngleCollector#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link AngleCollector#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); when PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AngleCollector.processTextPosition(TextPosition)"})
  void testProcessTextPosition_whenPDMMType1FontWithFontDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    AngleCollector angleCollector = new AngleCollector();
    Matrix textMatrix = new Matrix();

    // Act
    angleCollector.processTextPosition(
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
            3));

    // Assert
    Set<Integer> angles = angleCollector.getAngles();
    assertEquals(1, angles.size());
    assertTrue(angles.contains(0));
  }

  /**
   * Test {@link AngleCollector#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link AngleCollector#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); when PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AngleCollector.processTextPosition(TextPosition)"})
  void testProcessTextPosition_whenPDTrueTypeFontWithFontDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    AngleCollector angleCollector = new AngleCollector();
    Matrix textMatrix = new Matrix();

    // Act
    angleCollector.processTextPosition(
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
            3));

    // Assert
    Set<Integer> angles = angleCollector.getAngles();
    assertEquals(1, angles.size());
    assertTrue(angles.contains(0));
  }

  /**
   * Test {@link AngleCollector#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.
   * </ul>
   *
   * <p>Method under test: {@link AngleCollector#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); when PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AngleCollector.processTextPosition(TextPosition)"})
  void testProcessTextPosition_whenPDType1FontWithBaseFontIsTimesRoman() throws IOException {
    // Arrange
    AngleCollector angleCollector = new AngleCollector();
    Matrix textMatrix = Matrix.getScaleInstance(10.0f, 10.0f);

    // Act
    angleCollector.processTextPosition(
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
            3));

    // Assert
    Set<Integer> angles = angleCollector.getAngles();
    assertEquals(1, angles.size());
    assertTrue(angles.contains(0));
  }

  /**
   * Test {@link AngleCollector#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link AngleCollector#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); when PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AngleCollector.processTextPosition(TextPosition)"})
  void testProcessTextPosition_whenPDType3FontWithFontDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    AngleCollector angleCollector = new AngleCollector();
    Matrix textMatrix = Matrix.getScaleInstance(10.0f, 10.0f);

    // Act
    angleCollector.processTextPosition(
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
            3));

    // Assert
    Set<Integer> angles = angleCollector.getAngles();
    assertEquals(1, angles.size());
    assertTrue(angles.contains(0));
  }
}
