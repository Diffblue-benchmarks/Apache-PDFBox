package org.apache.pdfbox.printing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.RenderingHints;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.swing.DebugGraphics;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFPageableDiffblueTest {
  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return NumberOfPages is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#PDFPageable(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument); given PDPage(); then return NumberOfPages is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument)"})
  void testNewPDFPageable_givenPDPage_thenReturnNumberOfPagesIsOne() {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(document);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(1, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument, Orientation)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return NumberOfPages is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation)}
   */
  @Test
  @DisplayName(
      "Test new PDFPageable(PDDocument, Orientation); given PDPage(); then return NumberOfPages is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument, Orientation)"})
  void testNewPDFPageable_givenPDPage_thenReturnNumberOfPagesIsOne2() {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(document, Orientation.AUTO);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(1, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return NumberOfPages is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDFPageable(PDDocument, Orientation, boolean); given PDPage(); then return NumberOfPages is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument, Orientation, boolean)"})
  void testNewPDFPageable_givenPDPage_thenReturnNumberOfPagesIsOne3() {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(document, Orientation.AUTO, true);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(1, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return NumberOfPages is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float)}
   */
  @Test
  @DisplayName(
      "Test new PDFPageable(PDDocument, Orientation, boolean, float); given PDPage(); then return NumberOfPages is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument, Orientation, boolean, float)"})
  void testNewPDFPageable_givenPDPage_thenReturnNumberOfPagesIsOne4() {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(document, Orientation.AUTO, true, 10.0f);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(1, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return NumberOfPages is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDFPageable(PDDocument, Orientation, boolean, float, boolean); given PDPage(); then return NumberOfPages is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument, Orientation, boolean, float, boolean)"})
  void testNewPDFPageable_givenPDPage_thenReturnNumberOfPagesIsOne5() {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(document, Orientation.AUTO, true, 10.0f, true);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(1, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return NumberOfPages is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#PDFPageable(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDFPageable(PDDocument); when PDDocument(); then return NumberOfPages is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument)"})
  void testNewPDFPageable_whenPDDocument_thenReturnNumberOfPagesIsZero() {
    // Arrange and Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument());

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument, Orientation)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return NumberOfPages is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation)}
   */
  @Test
  @DisplayName(
      "Test new PDFPageable(PDDocument, Orientation); when PDDocument(); then return NumberOfPages is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument, Orientation)"})
  void testNewPDFPageable_whenPDDocument_thenReturnNumberOfPagesIsZero2() {
    // Arrange and Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(), Orientation.AUTO);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return NumberOfPages is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDFPageable(PDDocument, Orientation, boolean); when PDDocument(); then return NumberOfPages is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument, Orientation, boolean)"})
  void testNewPDFPageable_whenPDDocument_thenReturnNumberOfPagesIsZero3() {
    // Arrange and Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(), Orientation.AUTO, true);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return NumberOfPages is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float)}
   */
  @Test
  @DisplayName(
      "Test new PDFPageable(PDDocument, Orientation, boolean, float); when PDDocument(); then return NumberOfPages is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument, Orientation, boolean, float)"})
  void testNewPDFPageable_whenPDDocument_thenReturnNumberOfPagesIsZero4() {
    // Arrange and Act
    PDFPageable actualPdfPageable =
        new PDFPageable(new PDDocument(), Orientation.AUTO, true, 10.0f);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return NumberOfPages is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDFPageable(PDDocument, Orientation, boolean, float, boolean); when PDDocument(); then return NumberOfPages is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument, Orientation, boolean, float, boolean)"})
  void testNewPDFPageable_whenPDDocument_thenReturnNumberOfPagesIsZero5() {
    // Arrange and Act
    PDFPageable actualPdfPageable =
        new PDFPageable(new PDDocument(), Orientation.AUTO, true, 10.0f, true);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFPageable#setRenderingHints(RenderingHints)}
   *   <li>{@link PDFPageable#setSubsamplingAllowed(boolean)}
   *   <li>{@link PDFPageable#getNumberOfPages()}
   *   <li>{@link PDFPageable#getRenderingHints()}
   *   <li>{@link PDFPageable#isSubsamplingAllowed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PDFPageable.getNumberOfPages()",
    "RenderingHints PDFPageable.getRenderingHints()",
    "boolean PDFPageable.isSubsamplingAllowed()",
    "void PDFPageable.setRenderingHints(RenderingHints)",
    "void PDFPageable.setSubsamplingAllowed(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    PDFPageable pdfPageable = new PDFPageable(new PDDocument());

    // Act
    pdfPageable.setRenderingHints(null);
    pdfPageable.setSubsamplingAllowed(true);
    int actualNumberOfPages = pdfPageable.getNumberOfPages();
    RenderingHints actualRenderingHints = pdfPageable.getRenderingHints();

    // Assert
    assertNull(actualRenderingHints);
    assertEquals(0, actualNumberOfPages);
    assertTrue(pdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#getPageFormat(int)}.
   *
   * <p>Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  @DisplayName("Test getPageFormat(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageFormat PDFPageable.getPageFormat(int)"})
  void testGetPageFormat() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    PageFormat actualPageFormat = new PDFPageable(document).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(
        new double[] {1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Test {@link PDFPageable#getPageFormat(int)}.
   *
   * <p>Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  @DisplayName("Test getPageFormat(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageFormat PDFPageable.getPageFormat(int)"})
  void testGetPageFormat2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());

    // Act
    PageFormat actualPageFormat = new PDFPageable(document).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(
        new double[] {1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Test {@link PDFPageable#getPageFormat(int)}.
   *
   * <p>Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  @DisplayName("Test getPageFormat(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageFormat PDFPageable.getPageFormat(int)"})
  void testGetPageFormat3() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(new PDPage(new COSDictionary()));

    // Act
    PageFormat actualPageFormat = new PDFPageable(document).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(
        new double[] {1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Test {@link PDFPageable#getPageFormat(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  @DisplayName(
      "Test getPageFormat(int); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageFormat PDFPageable.getPageFormat(int)"})
  void testGetPageFormat_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne()
      throws IOException {
    // Arrange
    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(page);
    document.addPage(new PDPage());

    // Act
    PageFormat actualPageFormat = new PDFPageable(document).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(
        new double[] {1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Test {@link PDFPageable#getPageFormat(int)}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return ImageableX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  @DisplayName(
      "Test getPageFormat(int); given PDDocument() addPage PDPage(); then return ImageableX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageFormat PDFPageable.getPageFormat(int)"})
  void testGetPageFormat_givenPDDocumentAddPagePDPage_thenReturnImageableXIsZero() {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    PageFormat actualPageFormat = new PDFPageable(document).getPageFormat(1);

    // Assert
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(
        new double[] {1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Test {@link PDFPageable#getPageFormat(int)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   *   <li>When one.
   *   <li>Then return ImageableX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  @DisplayName(
      "Test getPageFormat(int); given PDPage() CropBox is A0; when one; then return ImageableX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageFormat PDFPageable.getPageFormat(int)"})
  void testGetPageFormat_givenPDPageCropBoxIsA0_whenOne_thenReturnImageableXIsZero()
      throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    PageFormat actualPageFormat = new PDFPageable(document).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(
        new double[] {1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Test {@link PDFPageable#getPageFormat(int)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is one.
   *   <li>When one.
   *   <li>Then return ImageableX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  @DisplayName(
      "Test getPageFormat(int); given PDPage() Rotation is one; when one; then return ImageableX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageFormat PDFPageable.getPageFormat(int)"})
  void testGetPageFormat_givenPDPageRotationIsOne_whenOne_thenReturnImageableXIsZero()
      throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setRotation(1);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    PageFormat actualPageFormat = new PDFPageable(document).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(
        new double[] {1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Test {@link PDFPageable#getPageFormat(int)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is zero.
   *   <li>When one.
   *   <li>Then return ImageableX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  @DisplayName(
      "Test getPageFormat(int); given PDPage() Rotation is zero; when one; then return ImageableX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageFormat PDFPageable.getPageFormat(int)"})
  void testGetPageFormat_givenPDPageRotationIsZero_whenOne_thenReturnImageableXIsZero()
      throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setRotation(0);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    PageFormat actualPageFormat = new PDFPageable(document).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(
        new double[] {1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Test {@link PDFPageable#getPageFormat(int)}.
   *
   * <ul>
   *   <li>Then return ImageableHeight is {@code -2.14748288E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  @DisplayName("Test getPageFormat(int); then return ImageableHeight is '-2.14748288E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageFormat PDFPageable.getPageFormat(int)"})
  void testGetPageFormat_thenReturnImageableHeightIs214748288e9() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    PDRectangle cropBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    page.setCropBox(cropBox);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    PageFormat actualPageFormat = new PDFPageable(document).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-2.14748288E9d, actualPageFormat.getImageableHeight());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(-2.14748288E9d, paper.getImageableHeight());
    assertEquals(-2.147483008E9d, actualPageFormat.getImageableWidth());
    assertEquals(-2.147483008E9d, paper.getImageableWidth());
    assertEquals(2.147483648E9d, actualPageFormat.getImageableX());
    assertEquals(2.147483648E9d, actualPageFormat.getImageableY());
    assertEquals(2.147483648E9d, paper.getImageableX());
    assertEquals(2.147483648E9d, paper.getImageableY());
    assertArrayEquals(
        new double[] {1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Test {@link PDFPageable#getPageFormat(int)}.
   *
   * <ul>
   *   <li>Then return ImageableX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  @DisplayName("Test getPageFormat(int); then return ImageableX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageFormat PDFPageable.getPageFormat(int)"})
  void testGetPageFormat_thenReturnImageableXIsZero() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    PageFormat actualPageFormat = new PDFPageable(document).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(
        new double[] {1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Test {@link PDFPageable#getPrintable(int)}.
   *
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return {@link
   *       PDPageTree#PDPageTree(COSDictionary)} with root is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#getPrintable(int)}
   */
  @Test
  @DisplayName(
      "Test getPrintable(int); given PDDocument getPages() return PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Printable PDFPageable.getPrintable(int)"})
  void testGetPrintable_givenPDDocumentGetPagesReturnPDPageTreeWithRootIsCOSDictionary()
      throws PrinterException {
    // Arrange
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(new PDPageTree(new COSDictionary()));
    when(document.getNumberOfPages()).thenReturn(10);

    // Act
    Printable actualPrintable = new PDFPageable(document).getPrintable(1);
    DebugGraphics debugGraphics = new DebugGraphics();
    int actualPrintResult = actualPrintable.print(debugGraphics, new PageFormat(), 1);

    // Assert
    verify(document).getNumberOfPages();
    verify(document, atLeast(1)).getPages();
    assertTrue(actualPrintable instanceof PDFPrintable);
    assertNull(((PDFPrintable) actualPrintable).getRenderingHints());
    assertEquals(1, actualPrintResult);
    assertFalse(((PDFPrintable) actualPrintable).isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#getPrintable(int)}.
   *
   * <ul>
   *   <li>Then return {@link Printable#print(Graphics, PageFormat, int)} with {@link
   *       DebugGraphics#DebugGraphics()} and {@link PageFormat} (default constructor) and minus one
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#getPrintable(int)}
   */
  @Test
  @DisplayName(
      "Test getPrintable(int); then return print(Graphics, PageFormat, int) with DebugGraphics() and PageFormat (default constructor) and minus one is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Printable PDFPageable.getPrintable(int)"})
  void testGetPrintable_thenReturnPrintWithDebugGraphicsAndPageFormatAndMinusOneIsOne()
      throws PrinterException {
    // Arrange
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(new PDPageTree());
    when(document.getNumberOfPages()).thenReturn(10);

    // Act
    Printable actualPrintable = new PDFPageable(document).getPrintable(1);
    DebugGraphics debugGraphics = new DebugGraphics();
    int actualPrintResult = actualPrintable.print(debugGraphics, new PageFormat(), -1);

    // Assert
    verify(document).getNumberOfPages();
    verify(document, atLeast(1)).getPages();
    assertTrue(actualPrintable instanceof PDFPrintable);
    assertNull(((PDFPrintable) actualPrintable).getRenderingHints());
    assertEquals(1, actualPrintResult);
    assertFalse(((PDFPrintable) actualPrintable).isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#getPrintable(int)}.
   *
   * <ul>
   *   <li>Then return {@link Printable#print(Graphics, PageFormat, int)} with {@link
   *       DebugGraphics#DebugGraphics()} and {@link PageFormat} (default constructor) and one is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#getPrintable(int)}
   */
  @Test
  @DisplayName(
      "Test getPrintable(int); then return print(Graphics, PageFormat, int) with DebugGraphics() and PageFormat (default constructor) and one is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Printable PDFPageable.getPrintable(int)"})
  void testGetPrintable_thenReturnPrintWithDebugGraphicsAndPageFormatAndOneIsOne()
      throws PrinterException {
    // Arrange
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(new PDPageTree());
    when(document.getNumberOfPages()).thenReturn(10);

    // Act
    Printable actualPrintable = new PDFPageable(document).getPrintable(1);
    DebugGraphics debugGraphics = new DebugGraphics();
    int actualPrintResult = actualPrintable.print(debugGraphics, new PageFormat(), 1);

    // Assert
    verify(document).getNumberOfPages();
    verify(document, atLeast(1)).getPages();
    assertTrue(actualPrintable instanceof PDFPrintable);
    assertNull(((PDFPrintable) actualPrintable).getRenderingHints());
    assertEquals(1, actualPrintResult);
    assertFalse(((PDFPrintable) actualPrintable).isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#getPrintable(int)}.
   *
   * <ul>
   *   <li>Then return {@link Printable#print(Graphics, PageFormat, int)} with {@code null} and
   *       {@link PageFormat} (default constructor) and one is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#getPrintable(int)}
   */
  @Test
  @DisplayName(
      "Test getPrintable(int); then return print(Graphics, PageFormat, int) with 'null' and PageFormat (default constructor) and one is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Printable PDFPageable.getPrintable(int)"})
  void testGetPrintable_thenReturnPrintWithNullAndPageFormatAndOneIsOne() throws PrinterException {
    // Arrange
    PDPageTree pdPageTree = mock(PDPageTree.class);
    when(pdPageTree.getCount()).thenReturn(1);

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getNumberOfPages()).thenReturn(10);

    // Act
    Printable actualPrintable = new PDFPageable(document).getPrintable(1);
    int actualPrintResult = actualPrintable.print(null, new PageFormat(), 1);

    // Assert
    verify(document).getNumberOfPages();
    verify(document, atLeast(1)).getPages();
    verify(pdPageTree).getCount();
    assertTrue(actualPrintable instanceof PDFPrintable);
    assertNull(((PDFPrintable) actualPrintable).getRenderingHints());
    assertEquals(1, actualPrintResult);
    assertFalse(((PDFPrintable) actualPrintable).isSubsamplingAllowed());
  }
}
