package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.text.TextPosition;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrintTextLocationsDiffblueTest {
  /**
   * Test {@link PrintTextLocations#PrintTextLocations()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link PrintTextLocations}
   */
  @Test
  @DisplayName("Test new PrintTextLocations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintTextLocations.<init>()"})
  void testNewPrintTextLocations() throws IOException {
    // Arrange and Act
    PrintTextLocations actualPrintTextLocations = new PrintTextLocations();

    // Assert
    assertEquals(" ", actualPrintTextLocations.getWordSeparator());
    assertEquals("", actualPrintTextLocations.getArticleEnd());
    assertEquals("", actualPrintTextLocations.getArticleStart());
    assertEquals("", actualPrintTextLocations.getPageStart());
    assertEquals("", actualPrintTextLocations.getParagraphEnd());
    assertEquals("", actualPrintTextLocations.getParagraphStart());
    assertEquals("\n", actualPrintTextLocations.getLineSeparator());
    assertEquals("\n", actualPrintTextLocations.getPageEnd());
    assertNull(actualPrintTextLocations.getCurrentPage());
    assertNull(actualPrintTextLocations.getResources());
    assertNull(actualPrintTextLocations.getGraphicsState());
    assertNull(actualPrintTextLocations.getEndBookmark());
    assertNull(actualPrintTextLocations.getStartBookmark());
    assertNull(actualPrintTextLocations.getInitialMatrix());
    assertEquals(0, actualPrintTextLocations.getGraphicsStackSize());
    assertEquals(0, actualPrintTextLocations.getLevel());
    assertEquals(0.3f, actualPrintTextLocations.getAverageCharTolerance());
    assertEquals(0.5f, actualPrintTextLocations.getSpacingTolerance());
    assertEquals(1, actualPrintTextLocations.getStartPage());
    assertEquals(2.0f, actualPrintTextLocations.getIndentThreshold());
    assertEquals(2.5f, actualPrintTextLocations.getDropThreshold());
    assertFalse(actualPrintTextLocations.getAddMoreFormatting());
    assertFalse(actualPrintTextLocations.getSortByPosition());
    assertTrue(actualPrintTextLocations.getSeparateByBeads());
    assertTrue(actualPrintTextLocations.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualPrintTextLocations.getEndPage());
  }

  /**
   * Test {@link PrintTextLocations#writeString(String, List)} with {@code string}, {@code
   * textPositions}.
   *
   * <ul>
   *   <li>Then calls {@link TextPosition#getFontSize()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintTextLocations#writeString(String, List)}
   */
  @Test
  @DisplayName(
      "Test writeString(String, List) with 'string', 'textPositions'; then calls getFontSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintTextLocations.writeString(String, List)"})
  void testWriteStringWithStringTextPositions_thenCallsGetFontSize() throws IOException {
    // Arrange
    PrintTextLocations printTextLocations = new PrintTextLocations();

    TextPosition textPosition = mock(TextPosition.class);
    when(textPosition.getFontSize()).thenReturn(10.0f);
    when(textPosition.getHeightDir()).thenReturn(10.0f);
    when(textPosition.getWidthDirAdj()).thenReturn(10.0f);
    when(textPosition.getWidthOfSpace()).thenReturn(10.0f);
    when(textPosition.getXDirAdj()).thenReturn(10.0f);
    when(textPosition.getXScale()).thenReturn(10.0f);
    when(textPosition.getYDirAdj()).thenReturn(10.0f);
    when(textPosition.getUnicode()).thenReturn("Unicode");

    ArrayList<TextPosition> textPositions = new ArrayList<>();
    textPositions.add(textPosition);

    // Act
    printTextLocations.writeString("String", textPositions);

    // Assert
    verify(textPosition).getFontSize();
    verify(textPosition).getHeightDir();
    verify(textPosition).getUnicode();
    verify(textPosition).getWidthDirAdj();
    verify(textPosition).getWidthOfSpace();
    verify(textPosition).getXDirAdj();
    verify(textPosition).getXScale();
    verify(textPosition).getYDirAdj();
  }

  /**
   * Test {@link PrintTextLocations#writeString(String, List)} with {@code string}, {@code
   * textPositions}.
   *
   * <ul>
   *   <li>Then calls {@link Matrix#getScaleX()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintTextLocations#writeString(String, List)}
   */
  @Test
  @DisplayName(
      "Test writeString(String, List) with 'string', 'textPositions'; then calls getScaleX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintTextLocations.writeString(String, List)"})
  void testWriteStringWithStringTextPositions_thenCallsGetScaleX() throws IOException {
    // Arrange
    PrintTextLocations printTextLocations = new PrintTextLocations();

    Matrix textMatrix = mock(Matrix.class);
    when(textMatrix.getScaleX()).thenReturn(10.0f);
    when(textMatrix.getScaleY()).thenReturn(10.0f);
    when(textMatrix.getScalingFactorX()).thenReturn(10.0f);
    when(textMatrix.getShearX()).thenReturn(10.0f);
    when(textMatrix.getShearY()).thenReturn(10.0f);
    when(textMatrix.getTranslateX()).thenReturn(10.0f);
    when(textMatrix.getTranslateY()).thenReturn(10.0f);
    TextPosition textPosition =
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
            new int[] {1, 0, 1, 0},
            new PDMMType1Font(new COSDictionary()),
            10.0f,
            3);

    ArrayList<TextPosition> textPositions = new ArrayList<>();
    textPositions.add(textPosition);

    // Act
    printTextLocations.writeString("String", textPositions);

    // Assert
    verify(textMatrix).getScaleX();
    verify(textMatrix).getScaleY();
    verify(textMatrix).getScalingFactorX();
    verify(textMatrix).getShearX();
    verify(textMatrix).getShearY();
    verify(textMatrix, atLeast(1)).getTranslateX();
    verify(textMatrix).getTranslateY();
  }
}
