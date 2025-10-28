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
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.Test;

class PDFPageableDiffblueTest {
  /**
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  void testGetPageFormat() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    PageFormat actualPageFormat = (new PDFPageable(document)).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(1, actualPageFormat.getOrientation());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, actualPageFormat.getWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(612.0d, paper.getWidth());
    assertEquals(792.0d, actualPageFormat.getHeight());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  void testGetPageFormat2() {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    PageFormat actualPageFormat = (new PDFPageable(document)).getPageFormat(1);

    // Assert
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(1, actualPageFormat.getOrientation());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, actualPageFormat.getWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(612.0d, paper.getWidth());
    assertEquals(792.0d, actualPageFormat.getHeight());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  void testGetPageFormat3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.save(new ByteArrayOutputStream(1), CompressParameters.DEFAULT_COMPRESSION);
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    PageFormat actualPageFormat = (new PDFPageable(document)).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(1, actualPageFormat.getOrientation());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, actualPageFormat.getWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(612.0d, paper.getWidth());
    assertEquals(792.0d, actualPageFormat.getHeight());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  void testGetPageFormat4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());

    // Act
    PageFormat actualPageFormat = (new PDFPageable(document)).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(1, actualPageFormat.getOrientation());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, actualPageFormat.getWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(612.0d, paper.getWidth());
    assertEquals(792.0d, actualPageFormat.getHeight());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  void testGetPageFormat5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(new PDPage(new COSDictionary()));

    // Act
    PageFormat actualPageFormat = (new PDFPageable(document)).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(1, actualPageFormat.getOrientation());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, actualPageFormat.getWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(612.0d, paper.getWidth());
    assertEquals(792.0d, actualPageFormat.getHeight());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  void testGetPageFormat6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    PageFormat actualPageFormat = (new PDFPageable(document)).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(1, actualPageFormat.getOrientation());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, actualPageFormat.getWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(612.0d, paper.getWidth());
    assertEquals(792.0d, actualPageFormat.getHeight());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  void testGetPageFormat7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDPage page = new PDPage();
    page.setRotation(1);

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    PageFormat actualPageFormat = (new PDFPageable(document)).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(1, actualPageFormat.getOrientation());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, actualPageFormat.getWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(612.0d, paper.getWidth());
    assertEquals(792.0d, actualPageFormat.getHeight());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  void testGetPageFormat8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(page);
    document.addPage(new PDPage());

    // Act
    PageFormat actualPageFormat = (new PDFPageable(document)).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(1, actualPageFormat.getOrientation());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, actualPageFormat.getWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(612.0d, paper.getWidth());
    assertEquals(792.0d, actualPageFormat.getHeight());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  void testGetPageFormat9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    PageFormat actualPageFormat = (new PDFPageable(document)).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-2.14748288E9d, actualPageFormat.getImageableHeight());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(-2.14748288E9d, paper.getImageableHeight());
    assertEquals(-2.147483008E9d, actualPageFormat.getImageableWidth());
    assertEquals(-2.147483008E9d, paper.getImageableWidth());
    assertEquals(1, actualPageFormat.getOrientation());
    assertEquals(2.147483648E9d, actualPageFormat.getImageableX());
    assertEquals(2.147483648E9d, actualPageFormat.getImageableY());
    assertEquals(2.147483648E9d, paper.getImageableX());
    assertEquals(2.147483648E9d, paper.getImageableY());
    assertEquals(612.0d, actualPageFormat.getWidth());
    assertEquals(612.0d, paper.getWidth());
    assertEquals(792.0d, actualPageFormat.getHeight());
    assertEquals(792.0d, paper.getHeight());
    assertArrayEquals(new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  void testGetPageFormat10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDPage page = new PDPage();
    page.setRotation(0);

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    PageFormat actualPageFormat = (new PDFPageable(document)).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(1, actualPageFormat.getOrientation());
    assertEquals(612.0d, actualPageFormat.getImageableWidth());
    assertEquals(612.0d, actualPageFormat.getWidth());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(612.0d, paper.getWidth());
    assertEquals(792.0d, actualPageFormat.getHeight());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  void testGetPageFormat11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDPage page = new PDPage();
    page.setRotation(90);

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    PageFormat actualPageFormat = (new PDFPageable(document)).getPageFormat(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualPageFormat.getOrientation());
    assertEquals(0.0d, actualPageFormat.getImageableX());
    assertEquals(0.0d, actualPageFormat.getImageableY());
    Paper paper = actualPageFormat.getPaper();
    assertEquals(0.0d, paper.getImageableX());
    assertEquals(0.0d, paper.getImageableY());
    assertEquals(612.0d, actualPageFormat.getHeight());
    assertEquals(612.0d, actualPageFormat.getImageableHeight());
    assertEquals(612.0d, paper.getImageableWidth());
    assertEquals(612.0d, paper.getWidth());
    assertEquals(792.0d, actualPageFormat.getImageableWidth());
    assertEquals(792.0d, actualPageFormat.getWidth());
    assertEquals(792.0d, paper.getHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(new double[]{0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 792.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Method under test: {@link PDFPageable#getPrintable(int)}
   */
  @Test
  void testGetPrintable() throws PrinterException {
    // Arrange
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(new PDPageTree());
    when(document.getNumberOfPages()).thenReturn(10);

    // Act
    Printable actualPrintable = (new PDFPageable(document)).getPrintable(1);
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
   * Method under test: {@link PDFPageable#getPrintable(int)}
   */
  @Test
  void testGetPrintable2() throws PrinterException {
    // Arrange
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(new PDPageTree(new COSDictionary()));
    when(document.getNumberOfPages()).thenReturn(10);

    // Act
    Printable actualPrintable = (new PDFPageable(document)).getPrintable(1);
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
   * Method under test: {@link PDFPageable#getPrintable(int)}
   */
  @Test
  void testGetPrintable3() throws PrinterException {
    // Arrange
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(mock(PDPageTree.class));
    when(document.getNumberOfPages()).thenReturn(10);

    // Act
    Printable actualPrintable = (new PDFPageable(document)).getPrintable(1);
    int actualPrintResult = actualPrintable.print(null, new PageFormat(), -1);

    // Assert
    verify(document).getNumberOfPages();
    verify(document, atLeast(1)).getPages();
    assertTrue(actualPrintable instanceof PDFPrintable);
    assertNull(((PDFPrintable) actualPrintable).getRenderingHints());
    assertEquals(1, actualPrintResult);
    assertFalse(((PDFPrintable) actualPrintable).isSubsamplingAllowed());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDFPageable#setRenderingHints(RenderingHints)}
   *   <li>{@link PDFPageable#setSubsamplingAllowed(boolean)}
   *   <li>{@link PDFPageable#getNumberOfPages()}
   *   <li>{@link PDFPageable#getRenderingHints()}
   *   <li>{@link PDFPageable#isSubsamplingAllowed()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDFPageable pdfPageable = new PDFPageable(new PDDocument());

    // Act
    pdfPageable.setRenderingHints(null);
    pdfPageable.setSubsamplingAllowed(true);
    int actualNumberOfPages = pdfPageable.getNumberOfPages();
    pdfPageable.getRenderingHints();

    // Assert that nothing has changed
    assertEquals(0, actualNumberOfPages);
    assertTrue(pdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument)}
   */
  @Test
  void testNewPDFPageable() {
    // Arrange and Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument());

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument)}
   */
  @Test
  void testNewPDFPageable2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument)}
   */
  @Test
  void testNewPDFPageable3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(1, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation)}
   */
  @Test
  void testNewPDFPageable4() {
    // Arrange and Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(), Orientation.AUTO);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation)}
   */
  @Test
  void testNewPDFPageable5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(streamCacheCreateFunction), Orientation.AUTO);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation)}
   */
  @Test
  void testNewPDFPageable6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(document, Orientation.AUTO);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(1, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean)}
   */
  @Test
  void testNewPDFPageable7() {
    // Arrange and Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(), Orientation.AUTO, true);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean)}
   */
  @Test
  void testNewPDFPageable8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(streamCacheCreateFunction), Orientation.AUTO, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean)}
   */
  @Test
  void testNewPDFPageable9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(document, Orientation.AUTO, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(1, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float)}
   */
  @Test
  void testNewPDFPageable10() {
    // Arrange and Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(), Orientation.AUTO, true, 10.0f);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float)}
   */
  @Test
  void testNewPDFPageable11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(streamCacheCreateFunction), Orientation.AUTO, true,
        10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float)}
   */
  @Test
  void testNewPDFPageable12() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(document, Orientation.AUTO, true, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(1, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float, boolean)}
   */
  @Test
  void testNewPDFPageable13() {
    // Arrange and Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(), Orientation.AUTO, true, 10.0f, true);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float, boolean)}
   */
  @Test
  void testNewPDFPageable14() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(streamCacheCreateFunction), Orientation.AUTO, true,
        10.0f, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float, boolean)}
   */
  @Test
  void testNewPDFPageable15() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(document, Orientation.AUTO, true, 10.0f, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(1, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }
}
