package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.pdfbox.contentstream.operator.DrawObject;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFTextStripperDiffblueTest {
  /**
   * Test new {@link PDFTextStripper} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PDFTextStripper}
   */
  @Test
  @DisplayName("Test new PDFTextStripper (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.<init>()"})
  void testNewPDFTextStripper() {
    // Arrange and Act
    PDFTextStripper actualPdfTextStripper = new PDFTextStripper();

    // Assert
    assertEquals(" ", actualPdfTextStripper.getWordSeparator());
    assertEquals("", actualPdfTextStripper.getArticleEnd());
    assertEquals("", actualPdfTextStripper.getArticleStart());
    assertEquals("", actualPdfTextStripper.getPageStart());
    assertEquals("", actualPdfTextStripper.getParagraphEnd());
    assertEquals("", actualPdfTextStripper.getParagraphStart());
    assertEquals("\n", actualPdfTextStripper.getLineSeparator());
    assertEquals("\n", actualPdfTextStripper.getPageEnd());
    assertNull(actualPdfTextStripper.getOutput());
    assertNull(actualPdfTextStripper.actualText);
    assertNull(actualPdfTextStripper.document);
    assertNull(actualPdfTextStripper.getCurrentPage());
    assertNull(actualPdfTextStripper.getResources());
    assertNull(actualPdfTextStripper.getGraphicsState());
    assertNull(actualPdfTextStripper.getEndBookmark());
    assertNull(actualPdfTextStripper.getStartBookmark());
    assertNull(actualPdfTextStripper.getInitialMatrix());
    assertEquals(0, actualPdfTextStripper.getGraphicsStackSize());
    assertEquals(0, actualPdfTextStripper.getLevel());
    assertEquals(0.3f, actualPdfTextStripper.getAverageCharTolerance());
    assertEquals(0.5f, actualPdfTextStripper.getSpacingTolerance());
    assertEquals(1, actualPdfTextStripper.getCurrentPageNo());
    assertEquals(1, actualPdfTextStripper.getStartPage());
    assertEquals(10, actualPdfTextStripper.getListItemPatterns().size());
    assertEquals(2.0f, actualPdfTextStripper.getIndentThreshold());
    assertEquals(2.5f, actualPdfTextStripper.getDropThreshold());
    assertFalse(actualPdfTextStripper.getAddMoreFormatting());
    assertFalse(actualPdfTextStripper.getSortByPosition());
    assertFalse(actualPdfTextStripper.firstActualTextPosition);
    assertTrue(actualPdfTextStripper.getCharactersByArticle().isEmpty());
    assertTrue(actualPdfTextStripper.getSeparateByBeads());
    assertTrue(actualPdfTextStripper.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualPdfTextStripper.getEndPage());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getText(PDDocument); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    String actualText = pdfTextStripper.getText(doc);

    // Assert
    assertEquals("", pdfTextStripper.getOutput().toString());
    assertEquals("", actualText);
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(1, pdDocument.getNumberOfPages());
    assertEquals(1, pdDocument.getPages().getCount());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) EndBookmark is {@link
   *       PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getText(PDDocument); given PDFTextStripper (default constructor) EndBookmark is PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText_givenPDFTextStripperEndBookmarkIsPDOutlineItem() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setEndBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.getText(new PDDocument());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(0, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(0, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is {@link
   *       PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getText(PDDocument); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText_givenPDFTextStripperStartBookmarkIsPDOutlineItem() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.getText(new PDDocument());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(0, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(0, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); given PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText_givenPDPage() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    Iterator<PDPage> iteratorResult = pdfTextStripper.document.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    List<? extends COSBase> toListResult = nextResult.getArtBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertFalse(nextResult.getContentStreams().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.hasContents());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   *
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) ArticleEnd is lf.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getText(PDDocument); then PDFTextStripper (default constructor) ArticleEnd is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText_thenPDFTextStripperArticleEndIsLf() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setAddMoreFormatting(true);

    // Act
    pdfTextStripper.getText(new PDDocument());

    // Assert
    assertEquals("\n", pdfTextStripper.getArticleEnd());
    assertEquals("\n", pdfTextStripper.getArticleStart());
    assertEquals("\n", pdfTextStripper.getPageStart());
    assertEquals("\n", pdfTextStripper.getParagraphEnd());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   *
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) Output toString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getText(PDDocument); then PDFTextStripper (default constructor) Output toString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText_thenPDFTextStripperOutputToStringIsEmptyString() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage(new COSDictionary()));

    // Act
    String actualText = pdfTextStripper.getText(doc);

    // Assert
    assertEquals("", pdfTextStripper.getOutput().toString());
    assertEquals("", actualText);
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(1, pdDocument.getNumberOfPages());
    assertEquals(1, pdDocument.getPages().getCount());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then {@link PDFTextStripper} (default constructor) {@link PDFTextStripper#document}
   *       NumberOfPages is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getText(PDDocument); when PDDocument(); then PDFTextStripper (default constructor) document NumberOfPages is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText_whenPDDocument_thenPDFTextStripperDocumentNumberOfPagesIsZero()
      throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.getText(new PDDocument());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(0, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(0, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then {@link PDFTextStripper} (default constructor) {@link PDFTextStripper#document}
   *       NumberOfPages is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName(
      "Test writeText(PDDocument, Writer); when PDDocument(); then PDFTextStripper (default constructor) document NumberOfPages is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText_whenPDDocument_thenPDFTextStripperDocumentNumberOfPagesIsZero()
      throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    PDDocument doc = new PDDocument();

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(0, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(0, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDPageTree pages = new PDPageTree();
    pages.add(page);

    // Act
    pdfTextStripperByArea.processPages(pages);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    assertTrue(currentClippingPaths.get(0) instanceof Path2D.Double);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle2D bounds2D = currentClippingPath.getBounds2D();
    assertTrue(bounds2D instanceof Double);
    assertTrue(bounds2D.getBounds2D() instanceof Double);
    assertTrue(currentClippingPath.getBounds().getFrame() instanceof Double);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages2() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.processPage(new PDPage());
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDPageTree pages = new PDPageTree();
    pages.add(page);

    // Act
    pdfTextStripperByArea.processPages(pages);

    // Assert
    List<Path2D> currentClippingPaths =
        pdfTextStripperByArea.getGraphicsState().getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    Rectangle2D bounds2D = getResult.getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertEquals(0.0d, bounds2D.getMinX());
    assertEquals(0.0d, bounds2D.getMinY());
    assertEquals(0.0d, bounds2D.getX());
    assertEquals(306.0d, bounds2D.getCenterX());
    assertEquals(396.0d, bounds2D.getCenterY());
    assertEquals(612.0d, bounds2D.getMaxX());
    assertEquals(612.0d, bounds2D.getWidth());
    assertEquals(792.0d, bounds2D.getHeight());
    assertEquals(792.0d, bounds2D.getMaxY());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   *
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) EndBookmark is {@link
   *       PDOutlineItem#PDOutlineItem()}.
   *   <li>When {@link PDPageTree#PDPageTree()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName(
      "Test processPages(PDPageTree); given PDFTextStripper (default constructor) EndBookmark is PDOutlineItem(); when PDPageTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_givenPDFTextStripperEndBookmarkIsPDOutlineItem_whenPDPageTree()
      throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setEndBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert that nothing has changed
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   *
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is {@link
   *       PDOutlineItem#PDOutlineItem()}.
   *   <li>When {@link PDPageTree#PDPageTree()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName(
      "Test processPages(PDPageTree); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem(); when PDPageTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_givenPDFTextStripperStartBookmarkIsPDOutlineItem_whenPDPageTree()
      throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert that nothing has changed
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   *
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is {@link
   *       PDOutlineItem#PDOutlineItem()}.
   *   <li>When {@link PDPageTree#PDPageTree()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName(
      "Test processPages(PDPageTree); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem(); when PDPageTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_givenPDFTextStripperStartBookmarkIsPDOutlineItem_whenPDPageTree2()
      throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());
    pdfTextStripper.setEndBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert that nothing has changed
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPageNo is two.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName(
      "Test processPages(PDPageTree); given PDPage(); then PDFTextStripper (default constructor) CurrentPageNo is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_givenPDPage_thenPDFTextStripperCurrentPageNoIsTwo() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPageTree pages = new PDPageTree();
    pages.add(new PDPage());

    // Act
    pdfTextStripper.processPages(pages);

    // Assert
    assertEquals(2, pdfTextStripper.getCurrentPageNo());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   *
   * <ul>
   *   <li>Then {@link PDFTextStripperByArea#PDFTextStripperByArea()} CurrentPage BBox LowerLeftX is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName(
      "Test processPages(PDPageTree); then PDFTextStripperByArea() CurrentPage BBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_thenPDFTextStripperByAreaCurrentPageBBoxLowerLeftXIsZero()
      throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);
    page.setContents(new PDStream(new COSDocument()));

    PDPageTree pages = new PDPageTree();
    pages.add(page);

    // Act
    pdfTextStripperByArea.processPages(pages);

    // Assert
    PDPage currentPage = pdfTextStripperByArea.getCurrentPage();
    PDRectangle bBox = currentPage.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bleedBox = currentPage.getBleedBox();
    assertEquals(0.0f, bleedBox.getLowerLeftX());
    PDRectangle cropBox = currentPage.getCropBox();
    assertEquals(0.0f, cropBox.getLowerLeftX());
    PDRectangle mediaBox = currentPage.getMediaBox();
    assertEquals(0.0f, mediaBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bleedBox.getLowerLeftY());
    assertEquals(0.0f, cropBox.getLowerLeftY());
    assertEquals(0.0f, mediaBox.getLowerLeftY());
    assertEquals(612.0f, bBox.getUpperRightX());
    assertEquals(612.0f, bleedBox.getUpperRightX());
    assertEquals(612.0f, cropBox.getUpperRightX());
    assertEquals(612.0f, mediaBox.getUpperRightX());
    assertEquals(612.0f, bBox.getWidth());
    assertEquals(612.0f, bleedBox.getWidth());
    assertEquals(612.0f, cropBox.getWidth());
    assertEquals(612.0f, mediaBox.getWidth());
    assertEquals(792.0f, bBox.getHeight());
    assertEquals(792.0f, bleedBox.getHeight());
    assertEquals(792.0f, cropBox.getHeight());
    assertEquals(792.0f, mediaBox.getHeight());
    assertEquals(792.0f, bBox.getUpperRightY());
    assertEquals(792.0f, bleedBox.getUpperRightY());
    assertEquals(792.0f, cropBox.getUpperRightY());
    assertEquals(792.0f, mediaBox.getUpperRightY());
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   *
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPageNo is two.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName(
      "Test processPages(PDPageTree); then PDFTextStripper (default constructor) CurrentPageNo is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_thenPDFTextStripperCurrentPageNoIsTwo() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDPageTree pages = new PDPageTree();
    pages.add(page);

    // Act
    pdfTextStripper.processPages(pages);

    // Assert
    assertEquals(2, pdfTextStripper.getCurrentPageNo());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   *
   * <ul>
   *   <li>When {@link PDPageTree#PDPageTree(COSDictionary)} with root is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName(
      "Test processPages(PDPageTree); when PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_whenPDPageTreeWithRootIsCOSDictionary() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.processPages(new PDPageTree(new COSDictionary()));

    // Assert that nothing has changed
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   *
   * <ul>
   *   <li>When {@link PDPageTree#PDPageTree()}.
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPageNo is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName(
      "Test processPages(PDPageTree); when PDPageTree(); then PDFTextStripper (default constructor) CurrentPageNo is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_whenPDPageTree_thenPDFTextStripperCurrentPageNoIsOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert that nothing has changed
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFTextStripper#setAddMoreFormatting(boolean)}
   *   <li>{@link PDFTextStripper#setArticleEnd(String)}
   *   <li>{@link PDFTextStripper#setArticleStart(String)}
   *   <li>{@link PDFTextStripper#setAverageCharTolerance(float)}
   *   <li>{@link PDFTextStripper#setDropThreshold(float)}
   *   <li>{@link PDFTextStripper#setEndBookmark(PDOutlineItem)}
   *   <li>{@link PDFTextStripper#setIndentThreshold(float)}
   *   <li>{@link PDFTextStripper#setLineSeparator(String)}
   *   <li>{@link PDFTextStripper#setListItemPatterns(List)}
   *   <li>{@link PDFTextStripper#setPageEnd(String)}
   *   <li>{@link PDFTextStripper#setPageStart(String)}
   *   <li>{@link PDFTextStripper#setParagraphEnd(String)}
   *   <li>{@link PDFTextStripper#setParagraphStart(String)}
   *   <li>{@link PDFTextStripper#setShouldSeparateByBeads(boolean)}
   *   <li>{@link PDFTextStripper#setSortByPosition(boolean)}
   *   <li>{@link PDFTextStripper#setSpacingTolerance(float)}
   *   <li>{@link PDFTextStripper#setStartBookmark(PDOutlineItem)}
   *   <li>{@link PDFTextStripper#setSuppressDuplicateOverlappingText(boolean)}
   *   <li>{@link PDFTextStripper#setWordSeparator(String)}
   *   <li>{@link PDFTextStripper#endDocument(PDDocument)}
   *   <li>{@link PDFTextStripper#endPage(PDPage)}
   *   <li>{@link PDFTextStripper#startDocument(PDDocument)}
   *   <li>{@link PDFTextStripper#startPage(PDPage)}
   *   <li>{@link PDFTextStripper#getAddMoreFormatting()}
   *   <li>{@link PDFTextStripper#getArticleEnd()}
   *   <li>{@link PDFTextStripper#getArticleStart()}
   *   <li>{@link PDFTextStripper#getAverageCharTolerance()}
   *   <li>{@link PDFTextStripper#getCharactersByArticle()}
   *   <li>{@link PDFTextStripper#getCurrentPageNo()}
   *   <li>{@link PDFTextStripper#getDropThreshold()}
   *   <li>{@link PDFTextStripper#getEndBookmark()}
   *   <li>{@link PDFTextStripper#getEndPage()}
   *   <li>{@link PDFTextStripper#getIndentThreshold()}
   *   <li>{@link PDFTextStripper#getLineSeparator()}
   *   <li>{@link PDFTextStripper#getOutput()}
   *   <li>{@link PDFTextStripper#getPageEnd()}
   *   <li>{@link PDFTextStripper#getPageStart()}
   *   <li>{@link PDFTextStripper#getParagraphEnd()}
   *   <li>{@link PDFTextStripper#getParagraphStart()}
   *   <li>{@link PDFTextStripper#getSeparateByBeads()}
   *   <li>{@link PDFTextStripper#getSortByPosition()}
   *   <li>{@link PDFTextStripper#getSpacingTolerance()}
   *   <li>{@link PDFTextStripper#getStartBookmark()}
   *   <li>{@link PDFTextStripper#getStartPage()}
   *   <li>{@link PDFTextStripper#getSuppressDuplicateOverlappingText()}
   *   <li>{@link PDFTextStripper#getWordSeparator()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFTextStripper.endDocument(PDDocument)",
    "void PDFTextStripper.endPage(PDPage)",
    "boolean PDFTextStripper.getAddMoreFormatting()",
    "String PDFTextStripper.getArticleEnd()",
    "String PDFTextStripper.getArticleStart()",
    "float PDFTextStripper.getAverageCharTolerance()",
    "List PDFTextStripper.getCharactersByArticle()",
    "int PDFTextStripper.getCurrentPageNo()",
    "float PDFTextStripper.getDropThreshold()",
    "PDOutlineItem PDFTextStripper.getEndBookmark()",
    "int PDFTextStripper.getEndPage()",
    "float PDFTextStripper.getIndentThreshold()",
    "String PDFTextStripper.getLineSeparator()",
    "Writer PDFTextStripper.getOutput()",
    "String PDFTextStripper.getPageEnd()",
    "String PDFTextStripper.getPageStart()",
    "String PDFTextStripper.getParagraphEnd()",
    "String PDFTextStripper.getParagraphStart()",
    "boolean PDFTextStripper.getSeparateByBeads()",
    "boolean PDFTextStripper.getSortByPosition()",
    "float PDFTextStripper.getSpacingTolerance()",
    "PDOutlineItem PDFTextStripper.getStartBookmark()",
    "int PDFTextStripper.getStartPage()",
    "boolean PDFTextStripper.getSuppressDuplicateOverlappingText()",
    "String PDFTextStripper.getWordSeparator()",
    "void PDFTextStripper.setAddMoreFormatting(boolean)",
    "void PDFTextStripper.setArticleEnd(String)",
    "void PDFTextStripper.setArticleStart(String)",
    "void PDFTextStripper.setAverageCharTolerance(float)",
    "void PDFTextStripper.setDropThreshold(float)",
    "void PDFTextStripper.setEndBookmark(PDOutlineItem)",
    "void PDFTextStripper.setIndentThreshold(float)",
    "void PDFTextStripper.setLineSeparator(String)",
    "void PDFTextStripper.setListItemPatterns(List)",
    "void PDFTextStripper.setPageEnd(String)",
    "void PDFTextStripper.setPageStart(String)",
    "void PDFTextStripper.setParagraphEnd(String)",
    "void PDFTextStripper.setParagraphStart(String)",
    "void PDFTextStripper.setShouldSeparateByBeads(boolean)",
    "void PDFTextStripper.setSortByPosition(boolean)",
    "void PDFTextStripper.setSpacingTolerance(float)",
    "void PDFTextStripper.setStartBookmark(PDOutlineItem)",
    "void PDFTextStripper.setSuppressDuplicateOverlappingText(boolean)",
    "void PDFTextStripper.setWordSeparator(String)",
    "void PDFTextStripper.startDocument(PDDocument)",
    "void PDFTextStripper.startPage(PDPage)"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.setAddMoreFormatting(true);
    pdfTextStripper.setArticleEnd("42");
    pdfTextStripper.setArticleStart("42");
    pdfTextStripper.setAverageCharTolerance(10.0f);
    pdfTextStripper.setDropThreshold(10.0f);
    PDOutlineItem aEndBookmark = new PDOutlineItem();
    pdfTextStripper.setEndBookmark(aEndBookmark);
    pdfTextStripper.setIndentThreshold(10.0f);
    pdfTextStripper.setLineSeparator("Separator");
    pdfTextStripper.setListItemPatterns(new ArrayList<>());
    pdfTextStripper.setPageEnd("42");
    pdfTextStripper.setPageStart("42");
    pdfTextStripper.setParagraphEnd("foo");
    pdfTextStripper.setParagraphStart("foo");
    pdfTextStripper.setShouldSeparateByBeads(true);
    pdfTextStripper.setSortByPosition(true);
    pdfTextStripper.setSpacingTolerance(10.0f);
    PDOutlineItem aStartBookmark = new PDOutlineItem();
    pdfTextStripper.setStartBookmark(aStartBookmark);
    pdfTextStripper.setSuppressDuplicateOverlappingText(true);
    pdfTextStripper.setWordSeparator("Separator");
    pdfTextStripper.endDocument(new PDDocument());
    pdfTextStripper.endPage(new PDPage());
    pdfTextStripper.startDocument(new PDDocument());
    pdfTextStripper.startPage(new PDPage());
    boolean actualAddMoreFormatting = pdfTextStripper.getAddMoreFormatting();
    String actualArticleEnd = pdfTextStripper.getArticleEnd();
    String actualArticleStart = pdfTextStripper.getArticleStart();
    float actualAverageCharTolerance = pdfTextStripper.getAverageCharTolerance();
    List<List<TextPosition>> actualCharactersByArticle = pdfTextStripper.getCharactersByArticle();
    int actualCurrentPageNo = pdfTextStripper.getCurrentPageNo();
    float actualDropThreshold = pdfTextStripper.getDropThreshold();
    PDOutlineItem actualEndBookmark = pdfTextStripper.getEndBookmark();
    int actualEndPage = pdfTextStripper.getEndPage();
    float actualIndentThreshold = pdfTextStripper.getIndentThreshold();
    String actualLineSeparator = pdfTextStripper.getLineSeparator();
    Writer actualOutput = pdfTextStripper.getOutput();
    String actualPageEnd = pdfTextStripper.getPageEnd();
    String actualPageStart = pdfTextStripper.getPageStart();
    String actualParagraphEnd = pdfTextStripper.getParagraphEnd();
    String actualParagraphStart = pdfTextStripper.getParagraphStart();
    boolean actualSeparateByBeads = pdfTextStripper.getSeparateByBeads();
    boolean actualSortByPosition = pdfTextStripper.getSortByPosition();
    float actualSpacingTolerance = pdfTextStripper.getSpacingTolerance();
    PDOutlineItem actualStartBookmark = pdfTextStripper.getStartBookmark();
    int actualStartPage = pdfTextStripper.getStartPage();
    boolean actualSuppressDuplicateOverlappingText =
        pdfTextStripper.getSuppressDuplicateOverlappingText();

    // Assert
    assertEquals("42", actualArticleEnd);
    assertEquals("42", actualArticleStart);
    assertEquals("42", actualPageEnd);
    assertEquals("42", actualPageStart);
    assertEquals("Separator", actualLineSeparator);
    assertEquals("Separator", pdfTextStripper.getWordSeparator());
    assertEquals("foo", actualParagraphEnd);
    assertEquals("foo", actualParagraphStart);
    assertNull(actualOutput);
    assertEquals(1, actualCurrentPageNo);
    assertEquals(1, actualStartPage);
    assertEquals(10.0f, actualAverageCharTolerance);
    assertEquals(10.0f, actualDropThreshold);
    assertEquals(10.0f, actualIndentThreshold);
    assertEquals(10.0f, actualSpacingTolerance);
    assertTrue(actualCharactersByArticle.isEmpty());
    assertTrue(actualAddMoreFormatting);
    assertTrue(actualSeparateByBeads);
    assertTrue(actualSortByPosition);
    assertTrue(actualSuppressDuplicateOverlappingText);
    assertEquals(Integer.MAX_VALUE, actualEndPage);
    assertSame(aEndBookmark, actualEndBookmark);
    assertSame(aStartBookmark, actualStartBookmark);
  }

  /**
   * Test {@link PDFTextStripper#processPage(PDPage)}.
   *
   * <p>Method under test: {@link PDFTextStripper#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPage(PDPage)"})
  void testProcessPage() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    // Act
    pdfTextStripperByArea.processPage(new PDPage());

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getBounds().getFrame() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#processPage(PDPage)}.
   *
   * <p>Method under test: {@link PDFTextStripper#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPage(PDPage)"})
  void testProcessPage2() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    // Act
    pdfTextStripperByArea.processPage(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    assertTrue(currentClippingPaths.get(0) instanceof Path2D.Double);
    assertTrue(graphicsState.getCurrentClippingPath().getBounds2D() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#processPage(PDPage)}.
   *
   * <p>Method under test: {@link PDFTextStripper#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPage(PDPage)"})
  void testProcessPage3() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    pdfTextStripperByArea.processPage(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds();
    Rectangle2D frame = bounds.getBounds().getBounds().getBounds().getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D frame2 = frame.getFrame();
    assertTrue(frame2 instanceof Double);
    assertEquals(396.0d, frame.getCenterY());
    assertEquals(bounds, frame2);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#processPage(PDPage)}.
   *
   * <p>Method under test: {@link PDFTextStripper#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPage(PDPage)"})
  void testProcessPage4() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    PDPage page = new PDPage();
    ArrayList<PDStream> contents = new ArrayList<>();
    page.setContents(contents);

    // Act
    pdfTextStripperByArea.processPage(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    assertTrue(
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D()
            instanceof Rectangle);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(contents, ((COSArray) getResult).toList());
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#processPage(PDPage)}.
   *
   * <p>Method under test: {@link PDFTextStripper#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPage(PDPage)"})
  void testProcessPage5() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    PDPage page = new PDPage();
    PDRectangle cropBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    page.setCropBox(cropBox);

    // Act
    pdfTextStripperByArea.processPage(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    assertTrue(currentClippingPaths.get(0) instanceof Path2D.Double);
    assertTrue(graphicsState.getCurrentClippingPath().getBounds2D() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#processPage(PDPage)}.
   *
   * <p>Method under test: {@link PDFTextStripper#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPage(PDPage)"})
  void testProcessPage6() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    pdfTextStripperByArea.processPage(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds();
    Rectangle2D frame = bounds.getBounds().getBounds().getBounds().getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D frame2 = frame.getFrame();
    assertTrue(frame2 instanceof Double);
    assertEquals(396.0d, frame.getCenterY());
    assertEquals(bounds, frame2);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#processPage(PDPage)}.
   *
   * <p>Method under test: {@link PDFTextStripper#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPage(PDPage)"})
  void testProcessPage7() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    PDStream contents = new PDStream(new COSDocument());
    ArrayList<COSName> filters = new ArrayList<>();
    contents.setFilters(filters);

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    pdfTextStripperByArea.processPage(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    assertTrue(
        graphicsState
                .getCurrentClippingPath()
                .getBounds()
                .getBounds()
                .getBounds()
                .getBounds()
                .getBounds2D()
            instanceof Rectangle);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(filters, ((COSArray) getResult).toList());
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   *
   * <p>Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.beginMarkedContentSequence(COSName, COSDictionary)"})
  void testBeginMarkedContentSequence() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    COSDictionary properties = mock(COSDictionary.class);
    when(properties.getString(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdfTextStripper.beginMarkedContentSequence(COSName.A, properties));
    verify(properties).getString(isA(COSName.class));
  }

  /**
   * Test {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link COSName} {@link COSName#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test beginMarkedContentSequence(COSName, COSDictionary); given 'Name'; when COSName getName() return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.beginMarkedContentSequence(COSName, COSDictionary)"})
  void testBeginMarkedContentSequence_givenName_whenCOSNameGetNameReturnName() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    COSName tag = mock(COSName.class);
    when(tag.getName()).thenReturn("Name");

    COSDictionary properties = mock(COSDictionary.class);
    when(properties.getString(Mockito.<COSName>any())).thenReturn("String");

    // Act
    pdfTextStripper.beginMarkedContentSequence(tag, properties);

    // Assert
    verify(properties).getString(isA(COSName.class));
    verify(tag).getName();
    assertEquals("String", pdfTextStripper.actualText);
    assertTrue(pdfTextStripper.firstActualTextPosition);
  }

  /**
   * Test {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then {@link PDFTextStripper} (default constructor) {@link PDFTextStripper#actualText} is
   *       {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test beginMarkedContentSequence(COSName, COSDictionary); given 'String'; then PDFTextStripper (default constructor) actualText is 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.beginMarkedContentSequence(COSName, COSDictionary)"})
  void testBeginMarkedContentSequence_givenString_thenPDFTextStripperActualTextIsString() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    COSDictionary properties = mock(COSDictionary.class);
    when(properties.getString(Mockito.<COSName>any())).thenReturn("String");

    // Act
    pdfTextStripper.beginMarkedContentSequence(COSName.A, properties);

    // Assert
    verify(properties).getString(isA(COSName.class));
    assertEquals("String", pdfTextStripper.actualText);
    assertTrue(pdfTextStripper.firstActualTextPosition);
  }

  /**
   * Test {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.beginMarkedContentSequence(COSName, COSDictionary)"})
  void testBeginMarkedContentSequence_whenCOSDictionary() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.beginMarkedContentSequence(COSName.A, new COSDictionary());

    // Assert that nothing has changed
    assertFalse(pdfTextStripper.firstActualTextPosition);
  }

  /**
   * Test {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSName} {@link COSName#getName()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test beginMarkedContentSequence(COSName, COSDictionary); when COSName getName() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.beginMarkedContentSequence(COSName, COSDictionary)"})
  void testBeginMarkedContentSequence_whenCOSNameGetNameThrowIllegalArgumentException() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    COSName tag = mock(COSName.class);
    when(tag.getName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdfTextStripper.beginMarkedContentSequence(tag, mock(COSDictionary.class)));
    verify(tag).getName();
  }

  /**
   * Test {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.beginMarkedContentSequence(COSName, COSDictionary)"})
  void testBeginMarkedContentSequence_whenNull() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.beginMarkedContentSequence(null, new COSDictionary());

    // Assert that nothing has changed
    assertFalse(pdfTextStripper.firstActualTextPosition);
  }

  /**
   * Test {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.beginMarkedContentSequence(COSName, COSDictionary)"})
  void testBeginMarkedContentSequence_whenNull2() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.beginMarkedContentSequence(COSName.A, null);

    // Assert that nothing has changed
    assertFalse(pdfTextStripper.firstActualTextPosition);
  }

  /**
   * Test {@link PDFTextStripper#setStartPage(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#setStartPage(int)}
   */
  @Test
  @DisplayName("Test setStartPage(int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.setStartPage(int)"})
  void testSetStartPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDFTextStripper().setStartPage(0));
  }

  /**
   * Test {@link PDFTextStripper#setEndPage(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then {@link PDFTextStripper} (default constructor) EndPage is three.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#setEndPage(int)}
   */
  @Test
  @DisplayName(
      "Test setEndPage(int); when three; then PDFTextStripper (default constructor) EndPage is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.setEndPage(int)"})
  void testSetEndPage_whenThree_thenPDFTextStripperEndPageIsThree() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.setEndPage(3);

    // Assert
    assertEquals(3, pdfTextStripper.getEndPage());
  }

  /**
   * Test {@link PDFTextStripper#setEndPage(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#setEndPage(int)}
   */
  @Test
  @DisplayName("Test setEndPage(int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.setEndPage(int)"})
  void testSetEndPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDFTextStripper().setEndPage(0));
  }

  /**
   * Test {@link PDFTextStripper#getListItemPatterns()}.
   *
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor).
   *   <li>Then return size is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getListItemPatterns()}
   */
  @Test
  @DisplayName(
      "Test getListItemPatterns(); given PDFTextStripper (default constructor); then return size is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFTextStripper.getListItemPatterns()"})
  void testGetListItemPatterns_givenPDFTextStripper_thenReturnSizeIsTen() {
    // Arrange and Act
    List<Pattern> actualListItemPatterns = new PDFTextStripper().getListItemPatterns();

    // Assert
    assertEquals(10, actualListItemPatterns.size());
    assertEquals("[A-Z]\\)", actualListItemPatterns.get(6).pattern());
    assertEquals("[A-Z]\\.", actualListItemPatterns.get(4).pattern());
    assertEquals("[IVXL]+\\.", actualListItemPatterns.get(8).pattern());
    assertEquals("[a-z]\\)", actualListItemPatterns.get(7).pattern());
    assertEquals("[a-z]\\.", actualListItemPatterns.get(5).pattern());
    assertEquals("[ivxl]+\\.", actualListItemPatterns.get(9).pattern());
    assertEquals("\\.", actualListItemPatterns.get(0).pattern());
    assertEquals("\\[\\d+\\]", actualListItemPatterns.get(2).pattern());
    assertEquals("\\d+\\)", actualListItemPatterns.get(3).pattern());
    assertEquals("\\d+\\.", actualListItemPatterns.get(1).pattern());
  }

  /**
   * Test {@link PDFTextStripper#getListItemPatterns()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getListItemPatterns()}
   */
  @Test
  @DisplayName("Test getListItemPatterns(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFTextStripper.getListItemPatterns()"})
  void testGetListItemPatterns_thenReturnEmpty() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setListItemPatterns(new ArrayList<>());

    // Act and Assert
    assertTrue(pdfTextStripper.getListItemPatterns().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#matchPattern(String, List)}.
   *
   * <ul>
   *   <li>Given {@link StringUtil#PATTERN_SPACE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link StringUtil#PATTERN_SPACE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#matchPattern(String, List)}
   */
  @Test
  @DisplayName(
      "Test matchPattern(String, List); given PATTERN_SPACE; when ArrayList() add PATTERN_SPACE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pattern PDFTextStripper.matchPattern(String, List)"})
  void testMatchPattern_givenPattern_space_whenArrayListAddPattern_space_thenReturnNull() {
    // Arrange
    ArrayList<Pattern> patterns = new ArrayList<>();
    patterns.add(StringUtil.PATTERN_SPACE);

    // Act and Assert
    assertNull(PDFTextStripper.matchPattern("String", patterns));
  }

  /**
   * Test {@link PDFTextStripper#matchPattern(String, List)}.
   *
   * <ul>
   *   <li>Given {@link StringUtil#PATTERN_SPACE}.
   *   <li>When space.
   *   <li>Then return pattern is {@code \s}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#matchPattern(String, List)}
   */
  @Test
  @DisplayName(
      "Test matchPattern(String, List); given PATTERN_SPACE; when space; then return pattern is '\\s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pattern PDFTextStripper.matchPattern(String, List)"})
  void testMatchPattern_givenPattern_space_whenSpace_thenReturnPatternIsS() {
    // Arrange
    ArrayList<Pattern> patterns = new ArrayList<>();
    patterns.add(StringUtil.PATTERN_SPACE);

    // Act and Assert
    assertEquals("\\s", PDFTextStripper.matchPattern(" ", patterns).pattern());
  }

  /**
   * Test {@link PDFTextStripper#matchPattern(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#matchPattern(String, List)}
   */
  @Test
  @DisplayName("Test matchPattern(String, List); when ArrayList(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pattern PDFTextStripper.matchPattern(String, List)"})
  void testMatchPattern_whenArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDFTextStripper.matchPattern("String", new ArrayList<>()));
  }
}
