package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
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

class FilteredText2MarkdownDiffblueTest {
  /**
   * Test {@link FilteredText2Markdown#processTextPosition(TextPosition)}.
   *
   * <p>Method under test: {@link FilteredText2Markdown#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName("Test processTextPosition(TextPosition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilteredText2Markdown.processTextPosition(TextPosition)"})
  void testProcessTextPosition() throws IOException {
    // Arrange
    FilteredText2Markdown filteredText2Markdown = new FilteredText2Markdown();

    Matrix matrix = mock(Matrix.class);
    when(matrix.getScaleY()).thenReturn(10.0f);
    when(matrix.getShearY()).thenReturn(10.0f);
    doNothing().when(matrix).concatenate(Mockito.<Matrix>any());

    Matrix textMatrix = mock(Matrix.class);
    when(textMatrix.clone()).thenReturn(matrix);

    // Act
    filteredText2Markdown.processTextPosition(
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
   * Test {@link FilteredText2Markdown#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>Given {@code Name As String}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredText2Markdown#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); given 'Name As String'; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilteredText2Markdown.processTextPosition(TextPosition)"})
  void testProcessTextPosition_givenNameAsString_thenCallsGetCOSArray() throws IOException {
    // Arrange
    FilteredText2Markdown filteredText2Markdown = new FilteredText2Markdown();

    Matrix matrix = mock(Matrix.class);
    when(matrix.getScaleY()).thenReturn(10.0f);
    when(matrix.getShearY()).thenReturn(10.0f);
    doNothing().when(matrix).concatenate(Mockito.<Matrix>any());

    Matrix textMatrix = mock(Matrix.class);
    when(textMatrix.clone()).thenReturn(matrix);

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);

    // Act
    filteredText2Markdown.processTextPosition(
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
            font,
            10.0f,
            3));

    // Assert
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(textMatrix).clone();
    verify(matrix).concatenate(isA(Matrix.class));
    verify(matrix).getScaleY();
    verify(matrix).getShearY();
  }

  /**
   * Test {@link FilteredText2Markdown#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.
   *   <li>Then calls {@link Matrix#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredText2Markdown#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); when PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilteredText2Markdown.processTextPosition(TextPosition)"})
  void testProcessTextPosition_whenPDType1FontWithBaseFontIsTimesRoman_thenCallsClone() {
    // Arrange
    FilteredText2Markdown filteredText2Markdown = new FilteredText2Markdown();

    Matrix matrix = mock(Matrix.class);
    when(matrix.getScaleY()).thenReturn(10.0f);
    when(matrix.getShearY()).thenReturn(10.0f);
    doNothing().when(matrix).concatenate(Mockito.<Matrix>any());

    Matrix textMatrix = mock(Matrix.class);
    when(textMatrix.clone()).thenReturn(matrix);

    // Act
    filteredText2Markdown.processTextPosition(
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
   * Test {@link FilteredText2Markdown#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredText2Markdown#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); when PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilteredText2Markdown.processTextPosition(TextPosition)"})
  void testProcessTextPosition_whenPDType3FontWithFontDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    FilteredText2Markdown filteredText2Markdown = new FilteredText2Markdown();

    Matrix matrix = mock(Matrix.class);
    when(matrix.getScaleY()).thenReturn(10.0f);
    when(matrix.getShearY()).thenReturn(10.0f);
    doNothing().when(matrix).concatenate(Mockito.<Matrix>any());

    Matrix textMatrix = mock(Matrix.class);
    when(textMatrix.clone()).thenReturn(matrix);

    // Act
    filteredText2Markdown.processTextPosition(
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
   * Test new {@link FilteredText2Markdown} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FilteredText2Markdown}
   */
  @Test
  @DisplayName("Test new FilteredText2Markdown (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilteredText2Markdown.<init>()"})
  void testNewFilteredText2Markdown() {
    // Arrange and Act
    FilteredText2Markdown actualFilteredText2Markdown = new FilteredText2Markdown();

    // Assert
    assertEquals(" ", actualFilteredText2Markdown.getWordSeparator());
    assertEquals("\n", actualFilteredText2Markdown.getArticleEnd());
    assertEquals("\n", actualFilteredText2Markdown.getArticleStart());
    assertEquals("\n", actualFilteredText2Markdown.getLineSeparator());
    assertEquals("\n", actualFilteredText2Markdown.getPageEnd());
    assertEquals("\n", actualFilteredText2Markdown.getPageStart());
    assertEquals("\n", actualFilteredText2Markdown.getParagraphEnd());
    assertEquals("\n", actualFilteredText2Markdown.getParagraphStart());
    assertNull(actualFilteredText2Markdown.getCurrentPage());
    assertNull(actualFilteredText2Markdown.getResources());
    assertNull(actualFilteredText2Markdown.getGraphicsState());
    assertNull(actualFilteredText2Markdown.getEndBookmark());
    assertNull(actualFilteredText2Markdown.getStartBookmark());
    assertNull(actualFilteredText2Markdown.getInitialMatrix());
    assertEquals(0, actualFilteredText2Markdown.getGraphicsStackSize());
    assertEquals(0, actualFilteredText2Markdown.getLevel());
    assertEquals(0.3f, actualFilteredText2Markdown.getAverageCharTolerance());
    assertEquals(0.5f, actualFilteredText2Markdown.getSpacingTolerance());
    assertEquals(1, actualFilteredText2Markdown.getStartPage());
    assertEquals(2.0f, actualFilteredText2Markdown.getIndentThreshold());
    assertEquals(2.5f, actualFilteredText2Markdown.getDropThreshold());
    assertFalse(actualFilteredText2Markdown.getAddMoreFormatting());
    assertFalse(actualFilteredText2Markdown.getSortByPosition());
    assertTrue(actualFilteredText2Markdown.getSeparateByBeads());
    assertTrue(actualFilteredText2Markdown.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualFilteredText2Markdown.getEndPage());
  }
}
