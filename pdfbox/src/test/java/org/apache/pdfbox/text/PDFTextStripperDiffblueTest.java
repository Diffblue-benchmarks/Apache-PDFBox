package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ByteArrayOutputStream;
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
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PDFTextStripperDiffblueTest {
  @Mock private Matrix matrix;

  @InjectMocks private PDFTextStripper pDFTextStripper;

  @Mock private PDFont pDFont;

  @Mock private PDRectangle pDRectangle;

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
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripper.getGraphicsState();
    assertTrue(
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getFrame()
            instanceof Double);
    Iterator<PDPage> iteratorResult = pdfTextStripper.document.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = nextResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(1, contentsForRandomAccess.available());
    assertEquals(1, contentsForStreamParsing.available());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText2() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setSortByPosition(true);

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripper.getGraphicsState();
    assertTrue(
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getFrame()
            instanceof Double);
    Iterator<PDPage> iteratorResult = pdfTextStripper.document.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = nextResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(1, contentsForRandomAccess.available());
    assertEquals(1, contentsForStreamParsing.available());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText3() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDDocument doc = new PDDocument();
    doc.addPage(page);

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
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText4() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    PDPage currentPage = pdfTextStripper.getCurrentPage();
    RandomAccessRead contentsForRandomAccess = currentPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = currentPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    int actualReadResult = currentPage.getContents().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForStreamParsing.available());
    PDGraphicsState graphicsState = pdfTextStripper.getGraphicsState();
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then {@link PDFTextStripper} (default constructor) {@link PDFTextStripper#document}
   *       Version is {@code 1.6}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getText(PDDocument); given ByteArrayOutputStream(); then PDFTextStripper (default constructor) document Version is '1.6'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText_givenByteArrayOutputStream_thenPDFTextStripperDocumentVersionIs16()
      throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = nextResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(1, contentsForRandomAccess.available());
    assertEquals(1, contentsForStreamParsing.available());
    assertEquals(1.6f, pdDocument.getVersion());
    assertFalse(iteratorResult.hasNext());
    PDGraphicsState graphicsState = pdfTextStripper.getGraphicsState();
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
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
  void testGetText_givenPDFTextStripperStartBookmarkIsPDOutlineItem2() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());
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
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPage BBox LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getText(PDDocument); then PDFTextStripper (default constructor) CurrentPage BBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText_thenPDFTextStripperCurrentPageBBoxLowerLeftXIsZero() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setSortByPosition(true);

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    PDPage currentPage = pdfTextStripper.getCurrentPage();
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
    PDGraphicsState graphicsState = pdfTextStripper.getGraphicsState();
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   *
   * <ul>
   *   <li>Then {@link PDFTextStripper} GraphicsState CurrentClippingPaths size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test getText(PDDocument); then PDFTextStripper GraphicsState CurrentClippingPaths size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFTextStripper.getText(PDDocument)"})
  void testGetText_thenPDFTextStripperGraphicsStateCurrentClippingPathsSizeIsOne()
      throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage page = new PDPage();
    page.setCropBox(pDRectangle);
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(page);

    // Act
    pDFTextStripper.getText(doc);

    // Assert
    verify(pDRectangle).getCOSArray();
    assertEquals(1, pDFTextStripper.getGraphicsState().getCurrentClippingPaths().size());
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
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    PDGraphicsState graphicsState = pdfTextStripper.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds();
    Rectangle2D frame = bounds.getBounds().getBounds().getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D frame2 = frame.getFrame();
    assertTrue(frame2 instanceof Double);
    assertEquals(0.0d, frame.getMinX());
    assertEquals(0.0d, frame.getMinY());
    assertEquals(0.0d, frame.getX());
    assertEquals(0.0d, frame.getY());
    assertEquals(396.0d, frame.getCenterY());
    assertEquals(612.0d, frame.getMaxX());
    assertEquals(612.0d, frame.getWidth());
    assertEquals(792.0d, frame.getHeight());
    assertEquals(792.0d, frame.getMaxY());
    assertFalse(frame.isEmpty());
    assertEquals(bounds, frame2);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText2() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDDocument doc = new PDDocument();
    doc.addPage(page);

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
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = nextResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    int actualReadResult = nextResult.getContents().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForStreamParsing.available());
    assertFalse(nextResult.getContentStreams().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.hasContents());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText3() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pDFTextStripper.writeText(doc, new StringWriter());

    // Assert
    PDPage currentPage = pDFTextStripper.getCurrentPage();
    RandomAccessRead contentsForRandomAccess = currentPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = currentPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    int actualReadResult = currentPage.getContents().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForStreamParsing.available());
    PDGraphicsState graphicsState = pDFTextStripper.getGraphicsState();
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is lf.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName(
      "Test writeText(PDDocument, Writer); given ByteArrayOutputStream(); then StringWriter() toString is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText_givenByteArrayOutputStream_thenStringWriterToStringIsLf() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(page);
    StringWriter outputStream = new StringWriter();

    // Act
    pdfTextStripper.writeText(doc, outputStream);

    // Assert
    assertEquals("\n", outputStream.toString());
    assertNull(pdfTextStripper.getTextLineMatrix());
    assertNull(pdfTextStripper.getTextMatrix());
    assertEquals(1, pdfTextStripper.getCharactersByArticle().size());
    assertEquals(1, pdfTextStripper.getGraphicsStackSize());
    assertEquals(page, pdfTextStripper.getCurrentPage());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName(
      "Test writeText(PDDocument, Writer); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne()
      throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    PDDocument doc = new PDDocument();
    doc.addPage(page);

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
   *
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) EndBookmark is {@link
   *       PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName(
      "Test writeText(PDDocument, Writer); given PDFTextStripper (default constructor) EndBookmark is PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) SortByPosition is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName(
      "Test writeText(PDDocument, Writer); given PDFTextStripper (default constructor) SortByPosition is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText_givenPDFTextStripperSortByPositionIsTrue() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setSortByPosition(true);

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    PDGraphicsState graphicsState = pdfTextStripper.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds();
    Rectangle2D frame = bounds.getBounds().getBounds().getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D frame2 = frame.getFrame();
    assertTrue(frame2 instanceof Double);
    assertEquals(0.0d, frame.getMinX());
    assertEquals(0.0d, frame.getMinY());
    assertEquals(0.0d, frame.getX());
    assertEquals(0.0d, frame.getY());
    assertEquals(396.0d, frame.getCenterY());
    assertEquals(612.0d, frame.getMaxX());
    assertEquals(612.0d, frame.getWidth());
    assertEquals(792.0d, frame.getHeight());
    assertEquals(792.0d, frame.getMaxY());
    assertFalse(frame.isEmpty());
    assertEquals(bounds, frame2);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   *
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is {@link
   *       PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName(
      "Test writeText(PDDocument, Writer); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is {@link
   *       PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName(
      "Test writeText(PDDocument, Writer); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.writeText(PDDocument, Writer)"})
  void testWriteText_givenPDFTextStripperStartBookmarkIsPDOutlineItem2() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); given PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = nextResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    int actualReadResult = nextResult.getContents().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForStreamParsing.available());
    assertFalse(nextResult.getContentStreams().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.hasContents());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   *
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) ArticleEnd is lf.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName(
      "Test writeText(PDDocument, Writer); then PDFTextStripper (default constructor) ArticleEnd is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) {@link PDFTextStripper#document}
   *       NumberOfPages is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName(
      "Test writeText(PDDocument, Writer); then PDFTextStripper (default constructor) document NumberOfPages is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    Path2D getResult = currentClippingPaths.get(0);
    Rectangle2D bounds2D = getResult.getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(getResult instanceof Path2D.Double);
    assertEquals(0.0d, bounds2D.getX());
    Dimension size = ((Rectangle) bounds2D).getSize();
    assertEquals(612, size.width);
    assertEquals(612.0d, bounds2D.getWidth());
    assertEquals(792, size.height);
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
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    PDPageTree pages = new PDPageTree();

    PDPage page = new PDPage();

    PDStream contents = new PDStream(new COSDocument());
    ArrayList<COSName> filters = new ArrayList<>();
    contents.setFilters(filters);
    page.setContents(contents);
    pages.add(page);

    // Act
    pdfTextStripperByArea.processPages(pages);

    // Assert
    Iterator<PDStream> contentStreams = pdfTextStripperByArea.getCurrentPage().getContentStreams();
    PDStream nextResult = contentStreams.next();
    boolean actualHasNextResult = contentStreams.hasNext();
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertFalse(actualHasNextResult);
    assertTrue(nextResult.getFilters().isEmpty());
    assertEquals(filters, ((COSArray) getResult).toList());
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
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
   *   <li>Given {@link PDFTextStripper} (default constructor).
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPageNo is two.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName(
      "Test processPages(PDPageTree); given PDFTextStripper (default constructor); then PDFTextStripper (default constructor) CurrentPageNo is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_givenPDFTextStripper_thenPDFTextStripperCurrentPageNoIsTwo()
      throws IOException {
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
   *   <li>Given {@link PDFTextStripper} (default constructor).
   *   <li>When {@link PDPageTree#PDPageTree()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName(
      "Test processPages(PDPageTree); given PDFTextStripper (default constructor); when PDPageTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_givenPDFTextStripper_whenPDPageTree() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert that nothing has changed
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   *
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor).
   *   <li>When {@link PDPageTree#PDPageTree(COSDictionary)} with root is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName(
      "Test processPages(PDPageTree); given PDFTextStripper (default constructor); when PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPages(PDPageTree)"})
  void testProcessPages_givenPDFTextStripper_whenPDPageTreeWithRootIsCOSDictionary()
      throws IOException {
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
    pdfTextStripper.setParagraphEnd("Paragraph End");
    pdfTextStripper.setParagraphStart("Paragraph Start");
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
    assertEquals("Paragraph End", actualParagraphEnd);
    assertEquals("Paragraph Start", actualParagraphStart);
    assertEquals("Separator", actualLineSeparator);
    assertEquals("Separator", pdfTextStripper.getWordSeparator());
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
    PDPage page = new PDPage(new COSDictionary());

    // Act
    pdfTextStripperByArea.processPage(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(page, pdfTextStripperByArea.getCurrentPage());
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
  void testProcessPage3() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

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
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(396.0d, frame.getCenterY());
    assertEquals(bounds, frame2);
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
  void testProcessPage4() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

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
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(396.0d, frame.getCenterY());
    assertEquals(bounds, frame2);
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
  void testProcessPage7() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

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
   * Test {@link PDFTextStripper#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.
   *   <li>Then {@link PDFTextStripperByArea#PDFTextStripperByArea()} CurrentPage is {@link
   *       PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test processPage(PDPage); given A0; then PDFTextStripperByArea() CurrentPage is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processPage(PDPage)"})
  void testProcessPage_givenA0_thenPDFTextStripperByAreaCurrentPageIsPDPage() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    // Act
    pdfTextStripperByArea.processPage(page);

    // Assert
    assertSame(page, pdfTextStripperByArea.getCurrentPage());
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
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
   *   <li>When {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); when COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.beginMarkedContentSequence(COSName, COSDictionary)"})
  void testBeginMarkedContentSequence_whenCOSStream() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.beginMarkedContentSequence(COSName.A, new COSStream());

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
   * Test {@link PDFTextStripper#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName("Test processTextPosition(TextPosition); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.processTextPosition(TextPosition)"})
  void testProcessTextPosition_thenThrowIllegalArgumentException() {
    // Arrange
    when(matrix.getTranslateX()).thenThrow(new IllegalArgumentException());

    TextPosition text =
        new TextPosition(
            1,
            10.0f,
            10.0f,
            matrix,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            "Unicode",
            new int[] {1, 0, 1, 0},
            pDFont,
            10.0f,
            3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pDFTextStripper.processTextPosition(text));
    verify(matrix).getTranslateX();
  }

  /**
   * Test {@link PDFTextStripper#setStartPage(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#setStartPage(int)}
   */
  @Test
  @DisplayName("Test setStartPage(int); when one; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripper.setStartPage(int)"})
  void testSetStartPage_whenOne_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new PDFTextStripper().setStartPage(1));
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
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one and {@link StringUtil#PATTERN_SPACE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripper#matchPattern(String, List)}
   */
  @Test
  @DisplayName(
      "Test matchPattern(String, List); given one; when ArrayList() add one and PATTERN_SPACE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pattern PDFTextStripper.matchPattern(String, List)"})
  void testMatchPattern_givenOne_whenArrayListAddOneAndPattern_space_thenReturnNull() {
    // Arrange
    ArrayList<Pattern> patterns = new ArrayList<>();
    patterns.add(StringUtil.PATTERN_SPACE);
    patterns.add(1, StringUtil.PATTERN_SPACE);

    // Act and Assert
    assertNull(PDFTextStripper.matchPattern("String", patterns));
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
