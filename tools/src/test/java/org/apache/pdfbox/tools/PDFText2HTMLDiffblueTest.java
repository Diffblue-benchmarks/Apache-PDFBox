package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFText2HTMLDiffblueTest {
  /**
   * Test {@link PDFText2HTML#PDFText2HTML()}.
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PDFText2HTML}
   */
  @Test
  @DisplayName("Test new PDFText2HTML()")
  void testNewPDFText2HTML() throws IOException {
    // Arrange and Act
    PDFText2HTML actualPdfText2HTML = new PDFText2HTML();

    // Assert
    assertEquals(" ", actualPdfText2HTML.getWordSeparator());
    assertEquals("</div>\r\n", actualPdfText2HTML.getPageEnd());
    assertEquals("</p>\r\n", actualPdfText2HTML.getParagraphEnd());
    assertEquals("<div style=\"page-break-before:always; page-break-after:always\">",
        actualPdfText2HTML.getPageStart());
    assertEquals("<p>", actualPdfText2HTML.getParagraphStart());
    assertEquals("\r\n", actualPdfText2HTML.getArticleEnd());
    assertEquals("\r\n", actualPdfText2HTML.getArticleStart());
    assertEquals("\r\n", actualPdfText2HTML.getLineSeparator());
    assertNull(actualPdfText2HTML.getCurrentPage());
    assertNull(actualPdfText2HTML.getResources());
    assertNull(actualPdfText2HTML.getGraphicsState());
    assertNull(actualPdfText2HTML.getEndBookmark());
    assertNull(actualPdfText2HTML.getStartBookmark());
    assertNull(actualPdfText2HTML.getInitialMatrix());
    assertEquals(0, actualPdfText2HTML.getGraphicsStackSize());
    assertEquals(0, actualPdfText2HTML.getLevel());
    assertEquals(0.3f, actualPdfText2HTML.getAverageCharTolerance());
    assertEquals(0.5f, actualPdfText2HTML.getSpacingTolerance());
    assertEquals(1, actualPdfText2HTML.getStartPage());
    assertEquals(2.0f, actualPdfText2HTML.getIndentThreshold());
    assertEquals(2.5f, actualPdfText2HTML.getDropThreshold());
    assertFalse(actualPdfText2HTML.getAddMoreFormatting());
    assertFalse(actualPdfText2HTML.getSortByPosition());
    assertTrue(actualPdfText2HTML.getSeparateByBeads());
    assertTrue(actualPdfText2HTML.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualPdfText2HTML.getEndPage());
  }
}
