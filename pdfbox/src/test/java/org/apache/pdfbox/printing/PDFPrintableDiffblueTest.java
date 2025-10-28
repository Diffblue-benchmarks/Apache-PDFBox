package org.apache.pdfbox.printing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.List;
import javax.swing.DebugGraphics;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.jupiter.api.Test;

class PDFPrintableDiffblueTest {
  /**
   * Method under test: {@link PDFPrintable#print(Graphics, PageFormat, int)}
   */
  @Test
  void testPrint() throws PrinterException {
    // Arrange
    PDFPrintable pdfPrintable = new PDFPrintable(new PDDocument());
    DebugGraphics graphics = new DebugGraphics();

    // Act and Assert
    assertEquals(1, pdfPrintable.print(graphics, new PageFormat(), 1));
  }

  /**
   * Method under test: {@link PDFPrintable#print(Graphics, PageFormat, int)}
   */
  @Test
  void testPrint2() throws PrinterException, IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFPrintable pdfPrintable = new PDFPrintable(new PDDocument(streamCacheCreateFunction));
    DebugGraphics graphics = new DebugGraphics();

    // Act
    int actualPrintResult = pdfPrintable.print(graphics, new PageFormat(), 1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualPrintResult);
  }

  /**
   * Method under test: {@link PDFPrintable#print(Graphics, PageFormat, int)}
   */
  @Test
  void testPrint3() throws PrinterException, IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFPrintable pdfPrintable = new PDFPrintable(new PDDocument(streamCacheCreateFunction));
    DebugGraphics graphics = new DebugGraphics();

    // Act
    int actualPrintResult = pdfPrintable.print(graphics, new PageFormat(), -1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualPrintResult);
  }

  /**
   * Method under test: {@link PDFPrintable#getRotatedCropBox(PDPage)}
   */
  @Test
  void testGetRotatedCropBox() {
    // Arrange and Act
    PDRectangle actualRotatedCropBox = PDFPrintable.getRotatedCropBox(new PDPage());

    // Assert
    COSArray cOSArray = actualRotatedCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftX());
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftY());
    assertEquals(612.0f, actualRotatedCropBox.getUpperRightX());
    assertEquals(612.0f, actualRotatedCropBox.getWidth());
    assertEquals(792.0f, actualRotatedCropBox.getHeight());
    assertEquals(792.0f, actualRotatedCropBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualRotatedCropBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDFPrintable#getRotatedCropBox(PDPage)}
   */
  @Test
  void testGetRotatedCropBox2() {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    // Act
    PDRectangle actualRotatedCropBox = PDFPrintable.getRotatedCropBox(page);

    // Assert
    COSArray cOSArray = actualRotatedCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftX());
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftY());
    assertEquals(612.0f, actualRotatedCropBox.getUpperRightX());
    assertEquals(612.0f, actualRotatedCropBox.getWidth());
    assertEquals(792.0f, actualRotatedCropBox.getHeight());
    assertEquals(792.0f, actualRotatedCropBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualRotatedCropBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDFPrintable#getRotatedCropBox(PDPage)}
   */
  @Test
  void testGetRotatedCropBox3() {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualRotatedCropBox = PDFPrintable.getRotatedCropBox(page);

    // Assert
    COSArray cOSArray = actualRotatedCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(-2.14748288E9f, actualRotatedCropBox.getHeight());
    assertEquals(-2.14748301E9f, actualRotatedCropBox.getWidth());
    assertEquals(2.14748365E9f, actualRotatedCropBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualRotatedCropBox.getLowerLeftY());
    assertEquals(612.0f, actualRotatedCropBox.getUpperRightX());
    assertEquals(792.0f, actualRotatedCropBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualRotatedCropBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDFPrintable#getRotatedCropBox(PDPage)}
   */
  @Test
  void testGetRotatedCropBox4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    PDRectangle actualRotatedCropBox = PDFPrintable.getRotatedCropBox(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSArray cOSArray = actualRotatedCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftX());
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftY());
    assertEquals(612.0f, actualRotatedCropBox.getUpperRightX());
    assertEquals(612.0f, actualRotatedCropBox.getWidth());
    assertEquals(792.0f, actualRotatedCropBox.getHeight());
    assertEquals(792.0f, actualRotatedCropBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualRotatedCropBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDFPrintable#getRotatedMediaBox(PDPage)}
   */
  @Test
  void testGetRotatedMediaBox() {
    // Arrange and Act
    PDRectangle actualRotatedMediaBox = PDFPrintable.getRotatedMediaBox(new PDPage());

    // Assert
    COSArray cOSArray = actualRotatedMediaBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualRotatedMediaBox.getLowerLeftX());
    assertEquals(0.0f, actualRotatedMediaBox.getLowerLeftY());
    assertEquals(612.0f, actualRotatedMediaBox.getUpperRightX());
    assertEquals(612.0f, actualRotatedMediaBox.getWidth());
    assertEquals(792.0f, actualRotatedMediaBox.getHeight());
    assertEquals(792.0f, actualRotatedMediaBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualRotatedMediaBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDFPrintable#getRotatedMediaBox(PDPage)}
   */
  @Test
  void testGetRotatedMediaBox2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    PDRectangle actualRotatedMediaBox = PDFPrintable.getRotatedMediaBox(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSArray cOSArray = actualRotatedMediaBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualRotatedMediaBox.getLowerLeftX());
    assertEquals(0.0f, actualRotatedMediaBox.getLowerLeftY());
    assertEquals(612.0f, actualRotatedMediaBox.getUpperRightX());
    assertEquals(612.0f, actualRotatedMediaBox.getWidth());
    assertEquals(792.0f, actualRotatedMediaBox.getHeight());
    assertEquals(792.0f, actualRotatedMediaBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualRotatedMediaBox.getCOSObject());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDFPrintable#setRenderingHints(RenderingHints)}
   *   <li>{@link PDFPrintable#setSubsamplingAllowed(boolean)}
   *   <li>{@link PDFPrintable#getRenderingHints()}
   *   <li>{@link PDFPrintable#isSubsamplingAllowed()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDFPrintable pdfPrintable = new PDFPrintable(new PDDocument());

    // Act
    pdfPrintable.setRenderingHints(null);
    pdfPrintable.setSubsamplingAllowed(true);
    pdfPrintable.getRenderingHints();

    // Assert that nothing has changed
    assertTrue(pdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test: {@link PDFPrintable#PDFPrintable(PDDocument)}
   */
  @Test
  void testNewPDFPrintable() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument());

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test: {@link PDFPrintable#PDFPrintable(PDDocument)}
   */
  @Test
  void testNewPDFPrintable2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test: {@link PDFPrintable#PDFPrintable(PDDocument, Scaling)}
   */
  @Test
  void testNewPDFPrintable3() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test: {@link PDFPrintable#PDFPrintable(PDDocument, Scaling)}
   */
  @Test
  void testNewPDFPrintable4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(streamCacheCreateFunction), Scaling.ACTUAL_SIZE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean)}
   */
  @Test
  void testNewPDFPrintable5() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE, true);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean)}
   */
  @Test
  void testNewPDFPrintable6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(streamCacheCreateFunction), Scaling.ACTUAL_SIZE,
        true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float)}
   */
  @Test
  void testNewPDFPrintable7() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE, true, 10.0f);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float)}
   */
  @Test
  void testNewPDFPrintable8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(streamCacheCreateFunction), Scaling.ACTUAL_SIZE,
        true, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float, boolean)}
   */
  @Test
  void testNewPDFPrintable9() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE, true, 10.0f, true);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float, boolean)}
   */
  @Test
  void testNewPDFPrintable10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(streamCacheCreateFunction), Scaling.ACTUAL_SIZE,
        true, 10.0f, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float, boolean, PDFRenderer)}
   */
  @Test
  void testNewPDFPrintable11() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(document, Scaling.ACTUAL_SIZE, true, 10.0f, true,
        new PDFRenderer(new PDDocument()));

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float, boolean, PDFRenderer)}
   */
  @Test
  void testNewPDFPrintable12() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(document, Scaling.ACTUAL_SIZE, true, 10.0f, true,
        new PDFRenderer(new PDDocument()));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }
}
