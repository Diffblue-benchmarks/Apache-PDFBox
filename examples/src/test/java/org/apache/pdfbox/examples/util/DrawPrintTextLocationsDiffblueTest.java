package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawPrintTextLocationsDiffblueTest {
  /**
   * Test
   * {@link DrawPrintTextLocations#DrawPrintTextLocations(PDDocument, String)}.
   * <p>
   * Method under test:
   * {@link DrawPrintTextLocations#DrawPrintTextLocations(PDDocument, String)}
   */
  @Test
  @DisplayName("Test new DrawPrintTextLocations(PDDocument, String)")
  void testNewDrawPrintTextLocations() throws IOException {
    // Arrange and Act
    DrawPrintTextLocations actualDrawPrintTextLocations = new DrawPrintTextLocations(new PDDocument(), "foo.txt");

    // Assert
    assertEquals(" ", actualDrawPrintTextLocations.getWordSeparator());
    assertEquals("", actualDrawPrintTextLocations.getArticleEnd());
    assertEquals("", actualDrawPrintTextLocations.getArticleStart());
    assertEquals("", actualDrawPrintTextLocations.getPageStart());
    assertEquals("", actualDrawPrintTextLocations.getParagraphEnd());
    assertEquals("", actualDrawPrintTextLocations.getParagraphStart());
    assertEquals("\r\n", actualDrawPrintTextLocations.getLineSeparator());
    assertEquals("\r\n", actualDrawPrintTextLocations.getPageEnd());
    assertNull(actualDrawPrintTextLocations.getCurrentPage());
    assertNull(actualDrawPrintTextLocations.getResources());
    assertNull(actualDrawPrintTextLocations.getGraphicsState());
    assertNull(actualDrawPrintTextLocations.getEndBookmark());
    assertNull(actualDrawPrintTextLocations.getStartBookmark());
    assertNull(actualDrawPrintTextLocations.getInitialMatrix());
    assertEquals(0, actualDrawPrintTextLocations.getGraphicsStackSize());
    assertEquals(0, actualDrawPrintTextLocations.getLevel());
    assertEquals(0.3f, actualDrawPrintTextLocations.getAverageCharTolerance());
    assertEquals(0.5f, actualDrawPrintTextLocations.getSpacingTolerance());
    assertEquals(1, actualDrawPrintTextLocations.getStartPage());
    assertEquals(2.0f, actualDrawPrintTextLocations.getIndentThreshold());
    assertEquals(2.5f, actualDrawPrintTextLocations.getDropThreshold());
    assertFalse(actualDrawPrintTextLocations.getAddMoreFormatting());
    assertFalse(actualDrawPrintTextLocations.getSortByPosition());
    assertTrue(actualDrawPrintTextLocations.getSeparateByBeads());
    assertTrue(actualDrawPrintTextLocations.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualDrawPrintTextLocations.getEndPage());
  }
}
