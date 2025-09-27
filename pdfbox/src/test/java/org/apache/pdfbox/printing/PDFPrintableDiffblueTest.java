package org.apache.pdfbox.printing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import javax.swing.DebugGraphics;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFPrintableDiffblueTest {
  /**
   * Test {@link PDFPrintable#PDFPrintable(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return RenderingHints is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#PDFPrintable(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDFPrintable(PDDocument); when PDDocument(); then return RenderingHints is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPrintable.<init>(PDDocument)"})
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument());

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPrintable#PDFPrintable(PDDocument, Scaling)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return RenderingHints is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#PDFPrintable(PDDocument, Scaling)}
   */
  @Test
  @DisplayName(
      "Test new PDFPrintable(PDDocument, Scaling); when PDDocument(); then return RenderingHints is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPrintable.<init>(PDDocument, Scaling)"})
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull2() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return RenderingHints is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDFPrintable(PDDocument, Scaling, boolean); when PDDocument(); then return RenderingHints is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPrintable.<init>(PDDocument, Scaling, boolean)"})
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull3() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable = new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE, true);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return RenderingHints is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float)}
   */
  @Test
  @DisplayName(
      "Test new PDFPrintable(PDDocument, Scaling, boolean, float); when PDDocument(); then return RenderingHints is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPrintable.<init>(PDDocument, Scaling, boolean, float)"})
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull4() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable =
        new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE, true, 10.0f);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return RenderingHints is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDFPrintable(PDDocument, Scaling, boolean, float, boolean); when PDDocument(); then return RenderingHints is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPrintable.<init>(PDDocument, Scaling, boolean, float, boolean)"})
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull5() {
    // Arrange and Act
    PDFPrintable actualPdfPrintable =
        new PDFPrintable(new PDDocument(), Scaling.ACTUAL_SIZE, true, 10.0f, true);

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float, boolean,
   * PDFRenderer)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return RenderingHints is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#PDFPrintable(PDDocument, Scaling, boolean, float,
   * boolean, PDFRenderer)}
   */
  @Test
  @DisplayName(
      "Test new PDFPrintable(PDDocument, Scaling, boolean, float, boolean, PDFRenderer); when PDDocument(); then return RenderingHints is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFPrintable.<init>(PDDocument, Scaling, boolean, float, boolean, PDFRenderer)"
  })
  void testNewPDFPrintable_whenPDDocument_thenReturnRenderingHintsIsNull6() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDFPrintable actualPdfPrintable =
        new PDFPrintable(
            document, Scaling.ACTUAL_SIZE, true, 10.0f, true, new PDFRenderer(new PDDocument()));

    // Assert
    assertNull(actualPdfPrintable.getRenderingHints());
    assertFalse(actualPdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFPrintable#setSubsamplingAllowed(boolean)}
   *   <li>{@link PDFPrintable#getRenderingHints()}
   *   <li>{@link PDFPrintable#isSubsamplingAllowed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RenderingHints PDFPrintable.getRenderingHints()",
    "boolean PDFPrintable.isSubsamplingAllowed()",
    "void PDFPrintable.setRenderingHints(RenderingHints)",
    "void PDFPrintable.setSubsamplingAllowed(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    PDFPrintable pdfPrintable = new PDFPrintable(new PDDocument());

    // Act
    pdfPrintable.setSubsamplingAllowed(true);
    RenderingHints actualRenderingHints = pdfPrintable.getRenderingHints();

    // Assert
    assertNull(actualRenderingHints);
    assertTrue(pdfPrintable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPrintable#print(Graphics, PageFormat, int)}.
   *
   * <ul>
   *   <li>Given {@link PDFPrintable#PDFPrintable(PDDocument)} with document is {@link
   *       PDDocument#PDDocument()}.
   *   <li>When minus one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#print(Graphics, PageFormat, int)}
   */
  @Test
  @DisplayName(
      "Test print(Graphics, PageFormat, int); given PDFPrintable(PDDocument) with document is PDDocument(); when minus one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFPrintable.print(Graphics, PageFormat, int)"})
  void testPrint_givenPDFPrintableWithDocumentIsPDDocument_whenMinusOne_thenReturnOne()
      throws PrinterException {
    // Arrange
    PDFPrintable pdfPrintable = new PDFPrintable(new PDDocument());

    // Act and Assert
    assertEquals(1, pdfPrintable.print(null, new PageFormat(), -1));
  }

  /**
   * Test {@link PDFPrintable#print(Graphics, PageFormat, int)}.
   *
   * <ul>
   *   <li>When {@link DebugGraphics#DebugGraphics()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#print(Graphics, PageFormat, int)}
   */
  @Test
  @DisplayName("Test print(Graphics, PageFormat, int); when DebugGraphics(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFPrintable.print(Graphics, PageFormat, int)"})
  void testPrint_whenDebugGraphics_thenReturnOne() throws PrinterException {
    // Arrange
    PDFPrintable pdfPrintable = new PDFPrintable(new PDDocument());
    DebugGraphics graphics = new DebugGraphics();

    // Act and Assert
    assertEquals(1, pdfPrintable.print(graphics, new PageFormat(), 1));
  }

  /**
   * Test {@link PDFPrintable#getRotatedCropBox(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.
   *   <li>When {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   *   <li>Then return LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#getRotatedCropBox(PDPage)}
   */
  @Test
  @DisplayName(
      "Test getRotatedCropBox(PDPage); given A0; when PDPage() CropBox is A0; then return LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDFPrintable.getRotatedCropBox(PDPage)"})
  void testGetRotatedCropBox_givenA0_whenPDPageCropBoxIsA0_thenReturnLowerLeftXIsZero() {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    // Act
    PDRectangle actualRotatedCropBox = PDFPrintable.getRotatedCropBox(page);

    // Assert
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftX());
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftY());
    assertEquals(612.0f, actualRotatedCropBox.getWidth());
    assertEquals(792.0f, actualRotatedCropBox.getHeight());
  }

  /**
   * Test {@link PDFPrintable#getRotatedCropBox(PDPage)}.
   *
   * <ul>
   *   <li>Then return Height is {@code -2.14748288E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#getRotatedCropBox(PDPage)}
   */
  @Test
  @DisplayName("Test getRotatedCropBox(PDPage); then return Height is '-2.14748288E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDFPrintable.getRotatedCropBox(PDPage)"})
  void testGetRotatedCropBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage page = new PDPage();
    PDRectangle cropBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    page.setCropBox(cropBox);

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
   *
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.
   *   <li>Then return LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#getRotatedCropBox(PDPage)}
   */
  @Test
  @DisplayName("Test getRotatedCropBox(PDPage); when PDPage(); then return LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDFPrintable.getRotatedCropBox(PDPage)"})
  void testGetRotatedCropBox_whenPDPage_thenReturnLowerLeftXIsZero() {
    // Arrange and Act
    PDRectangle actualRotatedCropBox = PDFPrintable.getRotatedCropBox(new PDPage());

    // Assert
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftX());
    assertEquals(0.0f, actualRotatedCropBox.getLowerLeftY());
    assertEquals(612.0f, actualRotatedCropBox.getWidth());
    assertEquals(792.0f, actualRotatedCropBox.getHeight());
  }

  /**
   * Test {@link PDFPrintable#getRotatedMediaBox(PDPage)}.
   *
   * <ul>
   *   <li>Given ninety.
   *   <li>Then return Height is six hundred twelve.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#getRotatedMediaBox(PDPage)}
   */
  @Test
  @DisplayName(
      "Test getRotatedMediaBox(PDPage); given ninety; then return Height is six hundred twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDFPrintable.getRotatedMediaBox(PDPage)"})
  void testGetRotatedMediaBox_givenNinety_thenReturnHeightIsSixHundredTwelve() {
    // Arrange
    PDPage page = new PDPage();
    page.setRotation(90);

    // Act
    PDRectangle actualRotatedMediaBox = PDFPrintable.getRotatedMediaBox(page);

    // Assert
    assertEquals(612.0f, actualRotatedMediaBox.getHeight());
    assertEquals(612.0f, actualRotatedMediaBox.getUpperRightY());
    assertEquals(792.0f, actualRotatedMediaBox.getUpperRightX());
    assertEquals(792.0f, actualRotatedMediaBox.getWidth());
  }

  /**
   * Test {@link PDFPrintable#getRotatedMediaBox(PDPage)}.
   *
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.
   *   <li>Then return UpperRightX is six hundred twelve.
   * </ul>
   *
   * <p>Method under test: {@link PDFPrintable#getRotatedMediaBox(PDPage)}
   */
  @Test
  @DisplayName(
      "Test getRotatedMediaBox(PDPage); when PDPage(); then return UpperRightX is six hundred twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDFPrintable.getRotatedMediaBox(PDPage)"})
  void testGetRotatedMediaBox_whenPDPage_thenReturnUpperRightXIsSixHundredTwelve() {
    // Arrange and Act
    PDRectangle actualRotatedMediaBox = PDFPrintable.getRotatedMediaBox(new PDPage());

    // Assert
    assertEquals(612.0f, actualRotatedMediaBox.getUpperRightX());
    assertEquals(612.0f, actualRotatedMediaBox.getWidth());
    assertEquals(792.0f, actualRotatedMediaBox.getHeight());
    assertEquals(792.0f, actualRotatedMediaBox.getUpperRightY());
  }
}
