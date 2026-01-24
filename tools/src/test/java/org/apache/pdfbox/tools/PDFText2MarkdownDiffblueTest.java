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

class PDFText2MarkdownDiffblueTest {
  /**
   * Test new {@link PDFText2Markdown} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PDFText2Markdown}
   */
  @Test
  @DisplayName("Test new PDFText2Markdown (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFText2Markdown.<init>()"})
  void testNewPDFText2Markdown() {
    // Arrange and Act
    PDFText2Markdown actualPdfText2Markdown = new PDFText2Markdown();

    // Assert
    assertEquals(" ", actualPdfText2Markdown.getWordSeparator());
    assertEquals("\n", actualPdfText2Markdown.getArticleEnd());
    assertEquals("\n", actualPdfText2Markdown.getArticleStart());
    assertEquals("\n", actualPdfText2Markdown.getLineSeparator());
    assertEquals("\n", actualPdfText2Markdown.getPageEnd());
    assertEquals("\n", actualPdfText2Markdown.getPageStart());
    assertEquals("\n", actualPdfText2Markdown.getParagraphEnd());
    assertEquals("\n", actualPdfText2Markdown.getParagraphStart());
    assertNull(actualPdfText2Markdown.getCurrentPage());
    assertNull(actualPdfText2Markdown.getResources());
    assertNull(actualPdfText2Markdown.getGraphicsState());
    assertNull(actualPdfText2Markdown.getEndBookmark());
    assertNull(actualPdfText2Markdown.getStartBookmark());
    assertNull(actualPdfText2Markdown.getInitialMatrix());
    assertEquals(0, actualPdfText2Markdown.getGraphicsStackSize());
    assertEquals(0, actualPdfText2Markdown.getLevel());
    assertEquals(0.3f, actualPdfText2Markdown.getAverageCharTolerance());
    assertEquals(0.5f, actualPdfText2Markdown.getSpacingTolerance());
    assertEquals(1, actualPdfText2Markdown.getStartPage());
    assertEquals(2.0f, actualPdfText2Markdown.getIndentThreshold());
    assertEquals(2.5f, actualPdfText2Markdown.getDropThreshold());
    assertFalse(actualPdfText2Markdown.getAddMoreFormatting());
    assertFalse(actualPdfText2Markdown.getSortByPosition());
    assertTrue(actualPdfText2Markdown.getSeparateByBeads());
    assertTrue(actualPdfText2Markdown.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualPdfText2Markdown.getEndPage());
  }
}
