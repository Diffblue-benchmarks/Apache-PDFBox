package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFTextStripperByAreaDiffblueTest {
  /**
   * Test {@link PDFTextStripperByArea#PDFTextStripperByArea()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link PDFTextStripperByArea}
   */
  @Test
  @DisplayName("Test new PDFTextStripperByArea()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.<init>()"})
  void testNewPDFTextStripperByArea() throws IOException {
    // Arrange and Act
    PDFTextStripperByArea actualPdfTextStripperByArea = new PDFTextStripperByArea();

    // Assert
    assertEquals(" ", actualPdfTextStripperByArea.getWordSeparator());
    assertEquals("", actualPdfTextStripperByArea.getArticleEnd());
    assertEquals("", actualPdfTextStripperByArea.getArticleStart());
    assertEquals("", actualPdfTextStripperByArea.getPageStart());
    assertEquals("", actualPdfTextStripperByArea.getParagraphEnd());
    assertEquals("", actualPdfTextStripperByArea.getParagraphStart());
    assertEquals("\n", actualPdfTextStripperByArea.getLineSeparator());
    assertEquals("\n", actualPdfTextStripperByArea.getPageEnd());
    assertNull(actualPdfTextStripperByArea.getOutput());
    assertNull(actualPdfTextStripperByArea.actualText);
    assertNull(actualPdfTextStripperByArea.document);
    assertNull(actualPdfTextStripperByArea.getCurrentPage());
    assertNull(actualPdfTextStripperByArea.getResources());
    assertNull(actualPdfTextStripperByArea.getGraphicsState());
    assertNull(actualPdfTextStripperByArea.getEndBookmark());
    assertNull(actualPdfTextStripperByArea.getStartBookmark());
    assertNull(actualPdfTextStripperByArea.getInitialMatrix());
    assertEquals(0, actualPdfTextStripperByArea.getGraphicsStackSize());
    assertEquals(0, actualPdfTextStripperByArea.getLevel());
    assertEquals(0.3f, actualPdfTextStripperByArea.getAverageCharTolerance());
    assertEquals(0.5f, actualPdfTextStripperByArea.getSpacingTolerance());
    assertEquals(1, actualPdfTextStripperByArea.getCurrentPageNo());
    assertEquals(1, actualPdfTextStripperByArea.getStartPage());
    assertEquals(10, actualPdfTextStripperByArea.getListItemPatterns().size());
    assertEquals(2.0f, actualPdfTextStripperByArea.getIndentThreshold());
    assertEquals(2.5f, actualPdfTextStripperByArea.getDropThreshold());
    assertFalse(actualPdfTextStripperByArea.getAddMoreFormatting());
    assertFalse(actualPdfTextStripperByArea.getSeparateByBeads());
    assertFalse(actualPdfTextStripperByArea.getSortByPosition());
    assertFalse(actualPdfTextStripperByArea.firstActualTextPosition);
    assertTrue(actualPdfTextStripperByArea.getCharactersByArticle().isEmpty());
    assertTrue(actualPdfTextStripperByArea.getRegions().isEmpty());
    assertTrue(actualPdfTextStripperByArea.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualPdfTextStripperByArea.getEndPage());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFTextStripperByArea#setShouldSeparateByBeads(boolean)}
   *   <li>{@link PDFTextStripperByArea#getRegions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List PDFTextStripperByArea.getRegions()",
    "void PDFTextStripperByArea.setShouldSeparateByBeads(boolean)"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

    // Act
    pdfTextStripperByArea.setShouldSeparateByBeads(true);
    pdfTextStripperByArea.setShouldSeparateByBeads(true);

    // Assert
    assertTrue(pdfTextStripperByArea.getRegions().isEmpty());
  }

  /**
   * Test {@link PDFTextStripperByArea#extractRegions(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDFTextStripperByArea#PDFTextStripperByArea()} SortByPosition is {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  @DisplayName(
      "Test extractRegions(PDPage); given PDFTextStripperByArea() SortByPosition is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.extractRegions(PDPage)"})
  void testExtractRegions_givenPDFTextStripperByAreaSortByPositionIsTrue() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.setSortByPosition(true);
    pdfTextStripperByArea.addRegion("us-east-2", new Double());

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    pdfTextStripperByArea.extractRegions(page);

    // Assert
    assertNull(pdfTextStripperByArea.getTextLineMatrix());
    assertNull(pdfTextStripperByArea.getTextMatrix());
    assertEquals(1, pdfTextStripperByArea.getCharactersByArticle().size());
    assertEquals(1, pdfTextStripperByArea.getGraphicsStackSize());
    assertEquals(1, pdfTextStripperByArea.getEndPage());
    assertSame(page, pdfTextStripperByArea.getCurrentPage());
  }

  /**
   * Test {@link PDFTextStripperByArea#extractRegions(PDPage)}.
   *
   * <ul>
   *   <li>Then {@link PDFTextStripperByArea#PDFTextStripperByArea()} EndPage is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  @DisplayName("Test extractRegions(PDPage); then PDFTextStripperByArea() EndPage is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.extractRegions(PDPage)"})
  void testExtractRegions_thenPDFTextStripperByAreaEndPageIsOne() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addRegion("us-east-2", new Double());

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    pdfTextStripperByArea.extractRegions(page);

    // Assert
    assertNull(pdfTextStripperByArea.getTextLineMatrix());
    assertNull(pdfTextStripperByArea.getTextMatrix());
    assertEquals(1, pdfTextStripperByArea.getCharactersByArticle().size());
    assertEquals(1, pdfTextStripperByArea.getGraphicsStackSize());
    assertEquals(1, pdfTextStripperByArea.getEndPage());
    assertSame(page, pdfTextStripperByArea.getCurrentPage());
  }

  /**
   * Test {@link PDFTextStripperByArea#extractRegions(PDPage)}.
   *
   * <ul>
   *   <li>Then {@link PDFTextStripperByArea#PDFTextStripperByArea()} TextLineMatrix is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  @DisplayName("Test extractRegions(PDPage); then PDFTextStripperByArea() TextLineMatrix is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.extractRegions(PDPage)"})
  void testExtractRegions_thenPDFTextStripperByAreaTextLineMatrixIsNull() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    pdfTextStripperByArea.extractRegions(page);

    // Assert
    assertNull(pdfTextStripperByArea.getTextLineMatrix());
    assertNull(pdfTextStripperByArea.getTextMatrix());
    assertEquals(1, pdfTextStripperByArea.getCharactersByArticle().size());
    assertEquals(1, pdfTextStripperByArea.getGraphicsStackSize());
    assertSame(page, pdfTextStripperByArea.getCurrentPage());
  }

  /**
   * Test {@link PDFTextStripperByArea#extractRegions(PDPage)}.
   *
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.
   *   <li>Then {@link PDFTextStripperByArea#PDFTextStripperByArea()} EndPage is {@link
   *       Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  @DisplayName(
      "Test extractRegions(PDPage); when PDPage(); then PDFTextStripperByArea() EndPage is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.extractRegions(PDPage)"})
  void testExtractRegions_whenPDPage_thenPDFTextStripperByAreaEndPageIsMax_value()
      throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

    // Act
    pdfTextStripperByArea.extractRegions(new PDPage());

    // Assert that nothing has changed
    assertEquals(0, pdfTextStripperByArea.getGraphicsStackSize());
    assertTrue(pdfTextStripperByArea.getCharactersByArticle().isEmpty());
    assertEquals(Integer.MAX_VALUE, pdfTextStripperByArea.getEndPage());
  }

  /**
   * Test {@link PDFTextStripperByArea#extractRegions(PDPage)}.
   *
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.
   *   <li>Then {@link PDFTextStripperByArea#PDFTextStripperByArea()} GraphicsStackSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  @DisplayName(
      "Test extractRegions(PDPage); when PDPage(); then PDFTextStripperByArea() GraphicsStackSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.extractRegions(PDPage)"})
  void testExtractRegions_whenPDPage_thenPDFTextStripperByAreaGraphicsStackSizeIsZero()
      throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addRegion("us-east-2", new Double());

    // Act
    pdfTextStripperByArea.extractRegions(new PDPage());

    // Assert that nothing has changed
    assertEquals(0, pdfTextStripperByArea.getGraphicsStackSize());
    assertTrue(pdfTextStripperByArea.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripperByArea#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>Then calls {@link TextPosition#getX()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripperByArea#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName("Test processTextPosition(TextPosition); then calls getX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.processTextPosition(TextPosition)"})
  void testProcessTextPosition_thenCallsGetX() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addRegion("us-east-2", new Double());

    TextPosition text = mock(TextPosition.class);
    when(text.getX()).thenReturn(10.0f);
    when(text.getY()).thenReturn(10.0f);

    // Act
    pdfTextStripperByArea.processTextPosition(text);

    // Assert
    verify(text).getX();
    verify(text).getY();
  }
}
