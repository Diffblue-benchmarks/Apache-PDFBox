package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FilteredTextStripperDiffblueTest {
  /**
   * Test new {@link FilteredTextStripper} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FilteredTextStripper}
   */
  @Test
  @DisplayName("Test new FilteredTextStripper (default constructor)")
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
    assertEquals("\r\n", actualFilteredTextStripper.getLineSeparator());
    assertEquals("\r\n", actualFilteredTextStripper.getPageEnd());
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
