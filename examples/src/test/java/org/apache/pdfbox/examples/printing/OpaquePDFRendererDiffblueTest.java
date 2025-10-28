package org.apache.pdfbox.examples.printing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class OpaquePDFRendererDiffblueTest {
  /**
   * Method under test: {@link OpaquePDFRenderer#OpaquePDFRenderer(PDDocument)}
   */
  @Test
  void testNewOpaquePDFRenderer() {
    // Arrange and Act
    OpaquePDFRenderer actualOpaquePDFRenderer = new OpaquePDFRenderer(new PDDocument());

    // Assert
    assertNull(actualOpaquePDFRenderer.getRenderingHints());
    assertNull(actualOpaquePDFRenderer.getDefaultDestination());
    assertEquals(0.5f, actualOpaquePDFRenderer.getImageDownscalingOptimizationThreshold());
    assertFalse(actualOpaquePDFRenderer.isSubsamplingAllowed());
  }
}
