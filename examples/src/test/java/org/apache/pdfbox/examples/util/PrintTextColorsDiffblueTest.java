package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrintTextColorsDiffblueTest {
  /**
   * Test {@link PrintTextColors#PrintTextColors()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link PrintTextColors}
   */
  @Test
  @DisplayName("Test new PrintTextColors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintTextColors.<init>()"})
  void testNewPrintTextColors() throws IOException {
    // Arrange and Act
    PrintTextColors actualPrintTextColors = new PrintTextColors();

    // Assert
    assertEquals(" ", actualPrintTextColors.getWordSeparator());
    assertEquals("", actualPrintTextColors.getArticleEnd());
    assertEquals("", actualPrintTextColors.getArticleStart());
    assertEquals("", actualPrintTextColors.getPageStart());
    assertEquals("", actualPrintTextColors.getParagraphEnd());
    assertEquals("", actualPrintTextColors.getParagraphStart());
    assertEquals("\n", actualPrintTextColors.getLineSeparator());
    assertEquals("\n", actualPrintTextColors.getPageEnd());
    assertNull(actualPrintTextColors.getCurrentPage());
    assertNull(actualPrintTextColors.getResources());
    assertNull(actualPrintTextColors.getGraphicsState());
    assertNull(actualPrintTextColors.getEndBookmark());
    assertNull(actualPrintTextColors.getStartBookmark());
    assertNull(actualPrintTextColors.getInitialMatrix());
    assertEquals(0, actualPrintTextColors.getGraphicsStackSize());
    assertEquals(0, actualPrintTextColors.getLevel());
    assertEquals(0.3f, actualPrintTextColors.getAverageCharTolerance());
    assertEquals(0.5f, actualPrintTextColors.getSpacingTolerance());
    assertEquals(1, actualPrintTextColors.getStartPage());
    assertEquals(2.0f, actualPrintTextColors.getIndentThreshold());
    assertEquals(2.5f, actualPrintTextColors.getDropThreshold());
    assertFalse(actualPrintTextColors.getAddMoreFormatting());
    assertFalse(actualPrintTextColors.getSortByPosition());
    assertTrue(actualPrintTextColors.getSeparateByBeads());
    assertTrue(actualPrintTextColors.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualPrintTextColors.getEndPage());
  }
}
