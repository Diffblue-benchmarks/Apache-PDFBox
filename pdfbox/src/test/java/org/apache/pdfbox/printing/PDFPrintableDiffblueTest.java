package org.apache.pdfbox.printing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.util.List;
import javax.swing.DebugGraphics;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFPrintableDiffblueTest {
  /**
   * Test {@link PDFPrintable#PDFPrintable(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return RenderingHints is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPrintable#PDFPrintable(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFPrintable(PDDocument); when PDDocument(); then return RenderingHints is 'null'")
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument());

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPrintable#PDFPrintable(PDDocument, Scaling)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return RenderingHints is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPrintable#PDFPrintable(PDDocument, Scaling)}
   */
  @Test
  @DisplayName("Test new PDFPrintable(PDDocument, Scaling); when PDDocument(); then return RenderingHints is 'null'")
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull2() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return RenderingHints is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean)}
   */
  @Test
  @DisplayName("Test new PDFPrintable(PDDocument, Scaling, boolean); when PDDocument(); then return RenderingHints is 'null'")
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull3() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE, true);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return RenderingHints is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float)}
   */
  @Test
  @DisplayName("Test new PDFPrintable(PDDocument, Scaling, boolean, float); when PDDocument(); then return RenderingHints is 'null'")
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull4() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE, true, 10.0f);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float, boolean)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return RenderingHints is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float, boolean)}
   */
  @Test
  @DisplayName("Test new PDFPrintable(PDDocument, Scaling, boolean, float, boolean); when PDDocument(); then return RenderingHints is 'null'")
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull5() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE, true, 10.0f, true);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float, boolean, PDFRenderer)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return RenderingHints is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float, boolean, PDFRenderer)}
   */
  @Test
  @DisplayName("Test new PDFPrintable(PDDocument, Scaling, boolean, float, boolean, PDFRenderer); when PDDocument(); then return RenderingHints is 'null'")
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull6() {
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDFPrintable#setRenderingHints(RenderingHints)}
   *   <li>{@link PDFPrintable#setSubsamplingAllowed(boolean)}
   *   <li>{@link PDFPrintable#getRenderingHints()}
   *   <li>{@link PDFPrintable#isSubsamplingAllowed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
   * Test {@link PDFPrintable#print(Graphics, PageFormat, int)}.
   * <ul>
   *   <li>Given {@link PDFPrintable#PDFPrintable(PDDocument)} with document is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPrintable#print(Graphics, PageFormat, int)}
   */
  @Test
  @DisplayName("Test print(Graphics, PageFormat, int); given PDFPrintable(PDDocument) with document is PDDocument(); then return one")
  void testPrint_givenPDFPrintableWithDocumentIsPDDocument_thenReturnOne() throws PrinterException {
    // Arrange
    PDFPrintable pdfPrintable = new PDFPrintable(new PDDocument());
    DebugGraphics graphics = new DebugGraphics();

    // Act and Assert
    assertEquals(1, pdfPrintable.print(graphics, new PageFormat(), 1));
  }

  /**
   * Test {@link PDFPrintable#print(Graphics, PageFormat, int)}.
   * <ul>
   *   <li>Given {@link PDFPrintable#PDFPrintable(PDDocument)} with document is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>When minus one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPrintable#print(Graphics, PageFormat, int)}
   */
  @Test
  @DisplayName("Test print(Graphics, PageFormat, int); given PDFPrintable(PDDocument) with document is PDDocument(); when minus one; then return one")
  void testPrint_givenPDFPrintableWithDocumentIsPDDocument_whenMinusOne_thenReturnOne() throws PrinterException {
    // Arrange
    PDFPrintable pdfPrintable = new PDFPrintable(new PDDocument());
    DebugGraphics graphics = new DebugGraphics();

    // Act and Assert
    assertEquals(1, pdfPrintable.print(graphics, new PageFormat(), -1));
  }

  /**
   * Test {@link PDFPrintable#getRotatedCropBox(PDPage)}.
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.</li>
   *   <li>When {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.</li>
   *   <li>Then return LowerLeftX is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPrintable#getRotatedCropBox(PDPage)}
   */
  @Test
  @DisplayName("Test getRotatedCropBox(PDPage); given A0; when PDPage() CropBox is A0; then return LowerLeftX is zero")
  void testGetRotatedCropBox_givenA0_whenPDPageCropBoxIsA0_thenReturnLowerLeftXIsZero() {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    // Act
    PDRectangle actualRotatedCropBox = PDFPrintable.getRotatedCropBox(page);

    // Assert
    COSArray cOSArray = actualRotatedCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftX());
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftY());
    assertEquals(612.0f, actualRotatedCropBox.getWidth());
    assertEquals(792.0f, actualRotatedCropBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualRotatedCropBox.getCOSObject());
  }

  /**
   * Test {@link PDFPrintable#getRotatedCropBox(PDPage)}.
   * <ul>
   *   <li>Then return Height is {@code -2.14748288E9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPrintable#getRotatedCropBox(PDPage)}
   */
  @Test
  @DisplayName("Test getRotatedCropBox(PDPage); then return Height is '-2.14748288E9'")
  void testGetRotatedCropBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualRotatedCropBox = PDFPrintable.getRotatedCropBox(page);

    // Assert
    assertEquals(-2.14748288E9f, actualRotatedCropBox.getHeight());
    assertEquals(-2.14748301E9f, actualRotatedCropBox.getWidth());
    assertEquals(2.14748365E9f, actualRotatedCropBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualRotatedCropBox.getLowerLeftY());
  }

  /**
   * Test {@link PDFPrintable#getRotatedCropBox(PDPage)}.
   * <ul>
   *   <li>Then return {@link PDImmutableRectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPrintable#getRotatedCropBox(PDPage)}
   */
  @Test
  @DisplayName("Test getRotatedCropBox(PDPage); then return PDImmutableRectangle")
  void testGetRotatedCropBox_thenReturnPDImmutableRectangle() {
    // Arrange
    PDPage page = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualRotatedCropBox = PDFPrintable.getRotatedCropBox(page);

    // Assert
    COSArray cOSArray = actualRotatedCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertTrue(actualRotatedCropBox instanceof PDImmutableRectangle);
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualRotatedCropBox.getCOSObject());
    PDRectangle pdRectangle = actualRotatedCropBox.LETTER;
    assertSame(pdRectangle, page.getArtBox());
    assertSame(pdRectangle, page.getBBox());
    assertSame(pdRectangle, page.getBleedBox());
    assertSame(pdRectangle, page.getCropBox());
    assertSame(pdRectangle, page.getMediaBox());
  }

  /**
   * Test {@link PDFPrintable#getRotatedCropBox(PDPage)}.
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.</li>
   *   <li>Then return LowerLeftX is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPrintable#getRotatedCropBox(PDPage)}
   */
  @Test
  @DisplayName("Test getRotatedCropBox(PDPage); when PDPage(); then return LowerLeftX is zero")
  void testGetRotatedCropBox_whenPDPage_thenReturnLowerLeftXIsZero() {
    // Arrange and Act
    PDRectangle actualRotatedCropBox = PDFPrintable.getRotatedCropBox(new PDPage());

    // Assert
    COSArray cOSArray = actualRotatedCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftX());
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftY());
    assertEquals(612.0f, actualRotatedCropBox.getWidth());
    assertEquals(792.0f, actualRotatedCropBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualRotatedCropBox.getCOSObject());
  }

  /**
   * Test {@link PDFPrintable#getRotatedMediaBox(PDPage)}.
   * <ul>
   *   <li>Then return {@link PDImmutableRectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPrintable#getRotatedMediaBox(PDPage)}
   */
  @Test
  @DisplayName("Test getRotatedMediaBox(PDPage); then return PDImmutableRectangle")
  void testGetRotatedMediaBox_thenReturnPDImmutableRectangle() {
    // Arrange
    PDPage page = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualRotatedMediaBox = PDFPrintable.getRotatedMediaBox(page);

    // Assert
    COSArray cOSArray = actualRotatedMediaBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertTrue(actualRotatedMediaBox instanceof PDImmutableRectangle);
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualRotatedMediaBox.getCOSObject());
    PDRectangle pdRectangle = actualRotatedMediaBox.LETTER;
    assertSame(pdRectangle, page.getArtBox());
    assertSame(pdRectangle, page.getBBox());
    assertSame(pdRectangle, page.getBleedBox());
    assertSame(pdRectangle, page.getCropBox());
    assertSame(pdRectangle, page.getMediaBox());
  }

  /**
   * Test {@link PDFPrintable#getRotatedMediaBox(PDPage)}.
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.</li>
   *   <li>Then COSArray toList first return {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPrintable#getRotatedMediaBox(PDPage)}
   */
  @Test
  @DisplayName("Test getRotatedMediaBox(PDPage); when PDPage(); then COSArray toList first return COSFloat")
  void testGetRotatedMediaBox_whenPDPage_thenCOSArrayToListFirstReturnCOSFloat() {
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
}
