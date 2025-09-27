package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.text.TextPosition;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FilteredTextStripperDiffblueTest {
  /**
   * Test {@link FilteredTextStripper#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>Given {@link Matrix} {@link Matrix#getScaleY()} return ten.
   *   <li>Then calls {@link Matrix#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredTextStripper#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); given Matrix getScaleY() return ten; then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilteredTextStripper.processTextPosition(TextPosition)"})
  void testProcessTextPosition_givenMatrixGetScaleYReturnTen_thenCallsClone() throws IOException {
    // Arrange
    FilteredTextStripper filteredTextStripper = new FilteredTextStripper();

    Matrix matrix = mock(Matrix.class);
    when(matrix.getScaleY()).thenReturn(10.0f);
    when(matrix.getShearY()).thenReturn(10.0f);
    doNothing().when(matrix).concatenate(Mockito.<Matrix>any());

    Matrix textMatrix = mock(Matrix.class);
    when(textMatrix.clone()).thenReturn(matrix);

    // Act
    filteredTextStripper.processTextPosition(
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
    verify(textMatrix).clone();
    verify(matrix).concatenate(isA(Matrix.class));
    verify(matrix).getScaleY();
    verify(matrix).getShearY();
  }

  /**
   * Test {@link FilteredTextStripper#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.
   *   <li>Then calls {@link Matrix#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredTextStripper#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); when PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilteredTextStripper.processTextPosition(TextPosition)"})
  void testProcessTextPosition_whenPDType1FontWithBaseFontIsTimesRoman_thenCallsClone() {
    // Arrange
    FilteredTextStripper filteredTextStripper = new FilteredTextStripper();

    Matrix matrix = mock(Matrix.class);
    when(matrix.getScaleY()).thenReturn(10.0f);
    when(matrix.getShearY()).thenReturn(10.0f);
    doNothing().when(matrix).concatenate(Mockito.<Matrix>any());

    Matrix textMatrix = mock(Matrix.class);
    when(textMatrix.clone()).thenReturn(matrix);

    // Act
    filteredTextStripper.processTextPosition(
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
    verify(textMatrix).clone();
    verify(matrix).concatenate(isA(Matrix.class));
    verify(matrix).getScaleY();
    verify(matrix).getShearY();
  }

  /**
   * Test {@link FilteredTextStripper#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredTextStripper#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); when PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilteredTextStripper.processTextPosition(TextPosition)"})
  void testProcessTextPosition_whenPDType3FontWithFontDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    FilteredTextStripper filteredTextStripper = new FilteredTextStripper();

    Matrix matrix = mock(Matrix.class);
    when(matrix.getScaleY()).thenReturn(10.0f);
    when(matrix.getShearY()).thenReturn(10.0f);
    doNothing().when(matrix).concatenate(Mockito.<Matrix>any());

    Matrix textMatrix = mock(Matrix.class);
    when(textMatrix.clone()).thenReturn(matrix);

    // Act
    filteredTextStripper.processTextPosition(
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
    verify(textMatrix).clone();
    verify(matrix).concatenate(isA(Matrix.class));
    verify(matrix).getScaleY();
    verify(matrix).getShearY();
  }

  /**
   * Test new {@link FilteredTextStripper} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FilteredTextStripper}
   */
  @Test
  @DisplayName("Test new FilteredTextStripper (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilteredTextStripper.<init>()"})
  void testNewFilteredTextStripper() {
    // Arrange and Act
    FilteredTextStripper actualFilteredTextStripper = new FilteredTextStripper();

    // Assert
    assertEquals(" ", actualFilteredTextStripper.getWordSeparator());
    assertEquals("", actualFilteredTextStripper.getArticleEnd());
    assertEquals("", actualFilteredTextStripper.getArticleStart());
    assertEquals("", actualFilteredTextStripper.getPageStart());
    assertEquals("", actualFilteredTextStripper.getParagraphEnd());
    assertEquals("", actualFilteredTextStripper.getParagraphStart());
    assertEquals("\n", actualFilteredTextStripper.getLineSeparator());
    assertEquals("\n", actualFilteredTextStripper.getPageEnd());
    assertNull(actualFilteredTextStripper.getCurrentPage());
    assertNull(actualFilteredTextStripper.getResources());
    assertNull(actualFilteredTextStripper.getGraphicsState());
    assertNull(actualFilteredTextStripper.getEndBookmark());
    assertNull(actualFilteredTextStripper.getStartBookmark());
    assertNull(actualFilteredTextStripper.getInitialMatrix());
    assertEquals(0, actualFilteredTextStripper.getGraphicsStackSize());
    assertEquals(0, actualFilteredTextStripper.getLevel());
    assertEquals(0.3f, actualFilteredTextStripper.getAverageCharTolerance());
    assertEquals(0.5f, actualFilteredTextStripper.getSpacingTolerance());
    assertEquals(1, actualFilteredTextStripper.getStartPage());
    assertEquals(2.0f, actualFilteredTextStripper.getIndentThreshold());
    assertEquals(2.5f, actualFilteredTextStripper.getDropThreshold());
    assertFalse(actualFilteredTextStripper.getAddMoreFormatting());
    assertFalse(actualFilteredTextStripper.getSortByPosition());
    assertTrue(actualFilteredTextStripper.getSeparateByBeads());
    assertTrue(actualFilteredTextStripper.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualFilteredTextStripper.getEndPage());
  }
}
