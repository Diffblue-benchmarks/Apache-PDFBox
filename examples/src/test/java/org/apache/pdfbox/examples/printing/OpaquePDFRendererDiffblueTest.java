package org.apache.pdfbox.examples.printing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OpaquePDFRendererDiffblueTest {
  /**
   * Test {@link OpaquePDFRenderer#OpaquePDFRenderer(PDDocument)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OpaquePDFRenderer#OpaquePDFRenderer(PDDocument)}
   */
  @Test
  @DisplayName("Test new OpaquePDFRenderer(PDDocument); given PDPage(); when PDDocument() addPage PDPage()")
  void testNewOpaquePDFRenderer_givenPDPage_whenPDDocumentAddPagePDPage() {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    OpaquePDFRenderer actualOpaquePDFRenderer = new OpaquePDFRenderer(document);

    // Assert
    assertNull(actualOpaquePDFRenderer.getRenderingHints());
    assertNull(actualOpaquePDFRenderer.getDefaultDestination());
    assertEquals(0.5f, actualOpaquePDFRenderer.getImageDownscalingOptimizationThreshold());
    assertFalse(actualOpaquePDFRenderer.isSubsamplingAllowed());
  }

  /**
   * Test {@link OpaquePDFRenderer#OpaquePDFRenderer(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return RenderingHints is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OpaquePDFRenderer#OpaquePDFRenderer(PDDocument)}
   */
  @Test
  @DisplayName("Test new OpaquePDFRenderer(PDDocument); when PDDocument(); then return RenderingHints is 'null'")
  void testNewOpaquePDFRenderer_whenPDDocument_thenReturnRenderingHintsIsNull() {
    // Arrange and Act
    OpaquePDFRenderer actualOpaquePDFRenderer = new OpaquePDFRenderer(new PDDocument());

    // Assert
    assertNull(actualOpaquePDFRenderer.getRenderingHints());
    assertNull(actualOpaquePDFRenderer.getDefaultDestination());
    assertEquals(0.5f, actualOpaquePDFRenderer.getImageDownscalingOptimizationThreshold());
    assertFalse(actualOpaquePDFRenderer.isSubsamplingAllowed());
  }
}
