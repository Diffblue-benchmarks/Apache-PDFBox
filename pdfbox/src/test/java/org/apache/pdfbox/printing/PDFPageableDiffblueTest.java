package org.apache.pdfbox.printing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.RenderingHints;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFPageableDiffblueTest {
  /**
   * Test {@link PDFPageable#PDFPageable(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFPageable#PDFPageable(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFPageable(PDDocument); given ByteArrayOutputStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFPageable.<init>(PDDocument)"})
  void testNewPDFPageable_givenByteArrayOutputStream() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    PDFPageable actualPdfPageable = new PDFPageable(document);

    // Assert
    assertNull(actualPdfPageable.getRenderingHints());
    assertEquals(0, actualPdfPageable.getNumberOfPages());
    assertFalse(actualPdfPageable.isSubsamplingAllowed());
  }

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
}
