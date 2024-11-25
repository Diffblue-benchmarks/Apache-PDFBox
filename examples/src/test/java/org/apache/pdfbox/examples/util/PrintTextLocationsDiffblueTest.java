package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrintTextLocationsDiffblueTest {
  /**
   * Test {@link PrintTextLocations#PrintTextLocations()}.
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PrintTextLocations}
   */
  @Test
  @DisplayName("Test new PrintTextLocations()")
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
    assertEquals("\r\n", actualPrintTextLocations.getLineSeparator());
    assertEquals("\r\n", actualPrintTextLocations.getPageEnd());
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
}
