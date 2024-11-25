package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FilteredText2MarkdownDiffblueTest {
  /**
   * Test new {@link FilteredText2Markdown} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FilteredText2Markdown}
   */
  @Test
  @DisplayName("Test new FilteredText2Markdown (default constructor)")
  void testNewFilteredText2Markdown() {
    // Arrange and Act
    FilteredText2Markdown actualFilteredText2Markdown = new FilteredText2Markdown();

    // Assert
    assertEquals(" ", actualFilteredText2Markdown.getWordSeparator());
    assertEquals("\r\n", actualFilteredText2Markdown.getArticleEnd());
    assertEquals("\r\n", actualFilteredText2Markdown.getArticleStart());
    assertEquals("\r\n", actualFilteredText2Markdown.getLineSeparator());
    assertEquals("\r\n", actualFilteredText2Markdown.getPageEnd());
    assertEquals("\r\n", actualFilteredText2Markdown.getPageStart());
    assertEquals("\r\n", actualFilteredText2Markdown.getParagraphEnd());
    assertEquals("\r\n", actualFilteredText2Markdown.getParagraphStart());
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
