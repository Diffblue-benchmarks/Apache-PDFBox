package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FilteredTextStripperDiffblueTest {
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
    assertFalse(actualFilteredTextStripper.isShouldProcessColorOperators());
    assertFalse(actualFilteredTextStripper.getAddMoreFormatting());
    assertFalse(actualFilteredTextStripper.getIgnoreContentStreamSpaceGlyphs());
    assertFalse(actualFilteredTextStripper.getSortByPosition());
    assertTrue(actualFilteredTextStripper.getSeparateByBeads());
    assertTrue(actualFilteredTextStripper.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualFilteredTextStripper.getEndPage());
  }
}
