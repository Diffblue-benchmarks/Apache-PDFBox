package org.apache.pdfbox.text;

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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.pdfbox.contentstream.operator.DrawObject;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFTextStripperDiffblueTest {
  /**
   * Test new {@link PDFTextStripper} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PDFTextStripper}
   */
  @Test
  @DisplayName("Test new PDFTextStripper (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) EndBookmark is {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); given PDFTextStripper (default constructor) EndBookmark is PDOutlineItem()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); given PDPage()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) ArticleEnd is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); then PDFTextStripper (default constructor) ArticleEnd is lf")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) Output toString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); then PDFTextStripper (default constructor) Output toString is empty string")
  @Tag("MaintainedByDiffblue")
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
    assertFalse(pdfTextStripper.document.getPages().iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor) {@link PDFTextStripper#document} NumberOfPages is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); when PDDocument(); then PDFTextStripper (default constructor) document NumberOfPages is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText_whenPDDocument_thenPDFTextStripperDocumentNumberOfPagesIsZero() throws IOException {
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
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) EndBookmark is {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); given PDFTextStripper (default constructor) EndBookmark is PDOutlineItem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText_givenPDFTextStripperEndBookmarkIsPDOutlineItem() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setEndBookmark(new PDOutlineItem());
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
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText_givenPDFTextStripperStartBookmarkIsPDOutlineItem() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());
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
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); given PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText_givenPDPage() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

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
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) ArticleEnd is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); then PDFTextStripper (default constructor) ArticleEnd is lf")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText_thenPDFTextStripperArticleEndIsLf() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setAddMoreFormatting(true);
    PDDocument doc = new PDDocument();

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    assertEquals("\n", pdfTextStripper.getArticleEnd());
    assertEquals("\n", pdfTextStripper.getArticleStart());
    assertEquals("\n", pdfTextStripper.getPageStart());
    assertEquals("\n", pdfTextStripper.getParagraphEnd());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) {@link PDFTextStripper#document} NumberOfPages is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); then PDFTextStripper (default constructor) document NumberOfPages is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText_thenPDFTextStripperDocumentNumberOfPagesIsOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage(new COSDictionary()));

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(1, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(1, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor) {@link PDFTextStripper#document} NumberOfPages is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); when PDDocument(); then PDFTextStripper (default constructor) document NumberOfPages is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText_whenPDDocument_thenPDFTextStripperDocumentNumberOfPagesIsZero() throws IOException {
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
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) EndBookmark is {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>When {@link PDPageTree#PDPageTree()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); given PDFTextStripper (default constructor) EndBookmark is PDOutlineItem(); when PDPageTree()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_givenPDFTextStripperEndBookmarkIsPDOutlineItem_whenPDPageTree() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setEndBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert that nothing has changed
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>When {@link PDPageTree#PDPageTree()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem(); when PDPageTree()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_givenPDFTextStripperStartBookmarkIsPDOutlineItem_whenPDPageTree() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert that nothing has changed
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>When {@link PDPageTree#PDPageTree()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem(); when PDPageTree()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_givenPDFTextStripperStartBookmarkIsPDOutlineItem_whenPDPageTree2() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());
    pdfTextStripper.setEndBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert that nothing has changed
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); given PDPage(); then PDFTextStripper (default constructor) CurrentPage is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_givenPDPage_thenPDFTextStripperCurrentPageIsNull() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPageTree pages = new PDPageTree();
    pages.add(new PDPage());

    // Act
    pdfTextStripper.processPages(pages);

    // Assert
    assertNull(pdfTextStripper.getCurrentPage());
    assertNull(pdfTextStripper.getInitialMatrix());
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(2, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>Then {@link PDFTextStripperByArea#PDFTextStripperByArea()} TextLineMatrix is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); then PDFTextStripperByArea() TextLineMatrix is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_thenPDFTextStripperByAreaTextLineMatrixIsNull() throws IOException {
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
    assertNull(pdfTextStripperByArea.getTextLineMatrix());
    assertNull(pdfTextStripperByArea.getTextMatrix());
    assertEquals(1, pdfTextStripperByArea.getCharactersByArticle().size());
    assertEquals(1, pdfTextStripperByArea.getGraphicsStackSize());
    assertEquals(page, pdfTextStripperByArea.getCurrentPage());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); then PDFTextStripper (default constructor) CurrentPage is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_thenPDFTextStripperCurrentPageIsNull() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDPageTree pages = new PDPageTree();
    pages.add(page);

    // Act
    pdfTextStripper.processPages(pages);

    // Assert
    assertNull(pdfTextStripper.getCurrentPage());
    assertNull(pdfTextStripper.getInitialMatrix());
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(2, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>When {@link PDPageTree#PDPageTree(COSDictionary)} with root is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); when PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_whenPDPageTreeWithRootIsCOSDictionary() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.processPages(new PDPageTree(new COSDictionary()));

    // Assert that nothing has changed
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>When {@link PDPageTree#PDPageTree()}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPageNo is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); when PDPageTree(); then PDFTextStripper (default constructor) CurrentPageNo is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_whenPDPageTree_thenPDFTextStripperCurrentPageNoIsOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert that nothing has changed
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.endDocument(PDDocument)", "void PDFTextStripper.endPage(PDPage)",
      "boolean PDFTextStripper.getAddMoreFormatting()", "String PDFTextStripper.getArticleEnd()",
      "String PDFTextStripper.getArticleStart()", "float PDFTextStripper.getAverageCharTolerance()",
      "List PDFTextStripper.getCharactersByArticle()", "int PDFTextStripper.getCurrentPageNo()",
      "float PDFTextStripper.getDropThreshold()", "PDOutlineItem PDFTextStripper.getEndBookmark()",
      "int PDFTextStripper.getEndPage()", "float PDFTextStripper.getIndentThreshold()",
      "String PDFTextStripper.getLineSeparator()", "Writer PDFTextStripper.getOutput()",
      "String PDFTextStripper.getPageEnd()", "String PDFTextStripper.getPageStart()",
      "String PDFTextStripper.getParagraphEnd()", "String PDFTextStripper.getParagraphStart()",
      "boolean PDFTextStripper.getSeparateByBeads()", "boolean PDFTextStripper.getSortByPosition()",
      "float PDFTextStripper.getSpacingTolerance()", "PDOutlineItem PDFTextStripper.getStartBookmark()",
      "int PDFTextStripper.getStartPage()", "boolean PDFTextStripper.getSuppressDuplicateOverlappingText()",
      "String PDFTextStripper.getWordSeparator()", "void PDFTextStripper.setAddMoreFormatting(boolean)",
      "void PDFTextStripper.setArticleEnd(String)", "void PDFTextStripper.setArticleStart(String)",
      "void PDFTextStripper.setAverageCharTolerance(float)", "void PDFTextStripper.setDropThreshold(float)",
      "void PDFTextStripper.setEndBookmark(PDOutlineItem)", "void PDFTextStripper.setIndentThreshold(float)",
      "void PDFTextStripper.setLineSeparator(String)", "void PDFTextStripper.setListItemPatterns(List)",
      "void PDFTextStripper.setPageEnd(String)", "void PDFTextStripper.setPageStart(String)",
      "void PDFTextStripper.setParagraphEnd(String)", "void PDFTextStripper.setParagraphStart(String)",
      "void PDFTextStripper.setShouldSeparateByBeads(boolean)", "void PDFTextStripper.setSortByPosition(boolean)",
      "void PDFTextStripper.setSpacingTolerance(float)", "void PDFTextStripper.setStartBookmark(PDOutlineItem)",
      "void PDFTextStripper.setSuppressDuplicateOverlappingText(boolean)",
      "void PDFTextStripper.setWordSeparator(String)", "void PDFTextStripper.startDocument(PDDocument)",
      "void PDFTextStripper.startPage(PDPage)"})
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
    boolean actualSuppressDuplicateOverlappingText = pdfTextStripper.getSuppressDuplicateOverlappingText();

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
   * <ul>
   *   <li>Then {@link PDFTextStripperByArea#PDFTextStripperByArea()} TextLineMatrix is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); then PDFTextStripperByArea() TextLineMatrix is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.processPage(PDPage)"})
  void testProcessPage_thenPDFTextStripperByAreaTextLineMatrixIsNull() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));
    PDPage page = new PDPage();

    // Act
    pdfTextStripperByArea.processPage(page);

    // Assert
    assertNull(pdfTextStripperByArea.getTextLineMatrix());
    assertNull(pdfTextStripperByArea.getTextMatrix());
    assertEquals(1, pdfTextStripperByArea.getCharactersByArticle().size());
    assertEquals(1, pdfTextStripperByArea.getGraphicsStackSize());
    assertSame(page, pdfTextStripperByArea.getCurrentPage());
  }

  /**
   * Test {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor) {@link PDFTextStripper#actualText} is {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); given 'String'; then PDFTextStripper (default constructor) actualText is 'String'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.beginMarkedContentSequence(COSName, COSDictionary)"})
  void testBeginMarkedContentSequence_thenThrowIllegalArgumentException() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    COSDictionary properties = mock(COSDictionary.class);
    when(properties.getString(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException("Artifact"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdfTextStripper.beginMarkedContentSequence(COSName.A, properties));
    verify(properties).getString(isA(COSName.class));
  }

  /**
   * Test {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); when COSDictionary()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); when 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); when 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#setStartPage(int)}
   */
  @Test
  @DisplayName("Test setStartPage(int); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.setStartPage(int)"})
  void testSetStartPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDFTextStripper()).setStartPage(0));
  }

  /**
   * Test {@link PDFTextStripper#setEndPage(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor) EndPage is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#setEndPage(int)}
   */
  @Test
  @DisplayName("Test setEndPage(int); when three; then PDFTextStripper (default constructor) EndPage is three")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#setEndPage(int)}
   */
  @Test
  @DisplayName("Test setEndPage(int); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFTextStripper.setEndPage(int)"})
  void testSetEndPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDFTextStripper()).setEndPage(0));
  }

  /**
   * Test {@link PDFTextStripper#getListItemPatterns()}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor).</li>
   *   <li>Then return size is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getListItemPatterns()}
   */
  @Test
  @DisplayName("Test getListItemPatterns(); given PDFTextStripper (default constructor); then return size is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDFTextStripper.getListItemPatterns()"})
  void testGetListItemPatterns_givenPDFTextStripper_thenReturnSizeIsTen() {
    // Arrange and Act
    List<Pattern> actualListItemPatterns = (new PDFTextStripper()).getListItemPatterns();

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
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getListItemPatterns()}
   */
  @Test
  @DisplayName("Test getListItemPatterns(); then return Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link StringUtil#PATTERN_SPACE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link StringUtil#PATTERN_SPACE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#matchPattern(String, List)}
   */
  @Test
  @DisplayName("Test matchPattern(String, List); given PATTERN_SPACE; when ArrayList() add PATTERN_SPACE; then return 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link StringUtil#PATTERN_SPACE}.</li>
   *   <li>When space.</li>
   *   <li>Then return pattern is {@code \s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#matchPattern(String, List)}
   */
  @Test
  @DisplayName("Test matchPattern(String, List); given PATTERN_SPACE; when space; then return pattern is '\\s'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#matchPattern(String, List)}
   */
  @Test
  @DisplayName("Test matchPattern(String, List); when ArrayList(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pattern PDFTextStripper.matchPattern(String, List)"})
  void testMatchPattern_whenArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDFTextStripper.matchPattern("String", new ArrayList<>()));
  }
}
