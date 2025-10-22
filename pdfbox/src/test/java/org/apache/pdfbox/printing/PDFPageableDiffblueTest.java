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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.RenderingHints;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.DebugGraphics;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFPageableDiffblueTest {
  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return NumberOfPages is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument); given PDPage(); then return NumberOfPages is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return NumberOfPages is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument, Orientation); given PDPage(); then return NumberOfPages is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return NumberOfPages is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument, Orientation, boolean); given PDPage(); then return NumberOfPages is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return NumberOfPages is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument, Orientation, boolean, float); given PDPage(); then return NumberOfPages is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return NumberOfPages is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float, boolean)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument, Orientation, boolean, float, boolean); given PDPage(); then return NumberOfPages is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return NumberOfPages is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument); when PDDocument(); then return NumberOfPages is zero")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return NumberOfPages is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument, Orientation); when PDDocument(); then return NumberOfPages is zero")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return NumberOfPages is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument, Orientation, boolean); when PDDocument(); then return NumberOfPages is zero")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return NumberOfPages is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument, Orientation, boolean, float); when PDDocument(); then return NumberOfPages is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument, Orientation, boolean, float)"})
  void testNewPDFPageable_whenPDDocument_thenReturnNumberOfPagesIsZero4() {
    // Arrange and Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(), Orientation.AUTO, true, 10.0f);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float, boolean)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return NumberOfPages is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#PDFPageable(PDDocument, Orientation, boolean, float, boolean)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument, Orientation, boolean, float, boolean); when PDDocument(); then return NumberOfPages is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument, Orientation, boolean, float, boolean)"})
  void testNewPDFPageable_whenPDDocument_thenReturnNumberOfPagesIsZero5() {
    // Arrange and Act
    PDFPageable actualPdfPageable = new PDFPageable(new PDDocument(), Orientation.AUTO, true, 10.0f, true);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDFPageable.getNumberOfPages()", "RenderingHints PDFPageable.getRenderingHints()",
      "boolean PDFPageable.isSubsamplingAllowed()", "void PDFPageable.setRenderingHints(RenderingHints)",
      "void PDFPageable.setSubsamplingAllowed(boolean)"})
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
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.</li>
   *   <li>Then return ImageableX is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#getPageFormat(int)}
   */
  @Test
  @DisplayName("Test getPageFormat(int); given PDDocument() addPage PDPage(); then return ImageableX is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageFormat PDFPageable.getPageFormat(int)"})
  void testGetPageFormat_givenPDDocumentAddPagePDPage_thenReturnImageableXIsZero() {
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
    assertEquals(792.0d, actualPageFormat.getHeight());
    assertEquals(792.0d, actualPageFormat.getImageableHeight());
    assertEquals(792.0d, paper.getImageableHeight());
    assertArrayEquals(new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, actualPageFormat.getMatrix(), 0.0);
  }

  /**
   * Test {@link PDFPageable#getPrintable(int)}.
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return {@link PDPageTree#PDPageTree()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#getPrintable(int)}
   */
  @Test
  @DisplayName("Test getPrintable(int); given PDDocument getPages() return PDPageTree()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Printable PDFPageable.getPrintable(int)"})
  void testGetPrintable_givenPDDocumentGetPagesReturnPDPageTree() throws PrinterException {
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
   * Test {@link PDFPageable#getPrintable(int)}.
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return {@link PDPageTree#PDPageTree(COSDictionary)} with root is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#getPrintable(int)}
   */
  @Test
  @DisplayName("Test getPrintable(int); given PDDocument getPages() return PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Printable PDFPageable.getPrintable(int)"})
  void testGetPrintable_givenPDDocumentGetPagesReturnPDPageTreeWithRootIsCOSDictionary() throws PrinterException {
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
   * Test {@link PDFPageable#getPrintable(int)}.
   * <ul>
   *   <li>Then return {@link Printable#print(Graphics, PageFormat, int)} with {@code null} and {@link PageFormat} (default constructor) and minus one is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFPageable#getPrintable(int)}
   */
  @Test
  @DisplayName("Test getPrintable(int); then return print(Graphics, PageFormat, int) with 'null' and PageFormat (default constructor) and minus one is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Printable PDFPageable.getPrintable(int)"})
  void testGetPrintable_thenReturnPrintWithNullAndPageFormatAndMinusOneIsOne() throws PrinterException {
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
}
