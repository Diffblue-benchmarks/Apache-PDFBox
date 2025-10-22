package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.RenderingHints;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PageDrawerParametersDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageDrawerParameters#PageDrawerParameters(PDFRenderer, PDPage, boolean, RenderDestination, RenderingHints, float)}
   *   <li>{@link PageDrawerParameters#getDestination()}
   *   <li>{@link PageDrawerParameters#getImageDownscalingOptimizationThreshold()}
   *   <li>{@link PageDrawerParameters#getPage()}
   *   <li>{@link PageDrawerParameters#getRenderer()}
   *   <li>{@link PageDrawerParameters#getRenderingHints()}
   *   <li>{@link PageDrawerParameters#isSubsamplingAllowed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PageDrawerParameters.<init>(PDFRenderer, PDPage, boolean, RenderDestination, RenderingHints, float)",
      "RenderDestination PageDrawerParameters.getDestination()",
      "float PageDrawerParameters.getImageDownscalingOptimizationThreshold()", "PDPage PageDrawerParameters.getPage()",
      "PDFRenderer PageDrawerParameters.getRenderer()", "RenderingHints PageDrawerParameters.getRenderingHints()",
      "boolean PageDrawerParameters.isSubsamplingAllowed()"})
  void testGettersAndSetters() {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PDPage page = new PDPage();

    // Act
    PageDrawerParameters actualPageDrawerParameters = new PageDrawerParameters(renderer, page, true,
        RenderDestination.EXPORT, null, 10.0f);
    RenderDestination actualDestination = actualPageDrawerParameters.getDestination();
    float actualImageDownscalingOptimizationThreshold = actualPageDrawerParameters
        .getImageDownscalingOptimizationThreshold();
    PDPage actualPage = actualPageDrawerParameters.getPage();
    PDFRenderer actualRenderer = actualPageDrawerParameters.getRenderer();
    RenderingHints actualRenderingHints = actualPageDrawerParameters.getRenderingHints();

    // Assert
    assertNull(actualRenderingHints);
    assertEquals(10.0f, actualImageDownscalingOptimizationThreshold);
    assertEquals(RenderDestination.EXPORT, actualDestination);
    assertTrue(actualPageDrawerParameters.isSubsamplingAllowed());
    assertSame(page, actualPage);
    assertSame(renderer, actualRenderer);
  }
}
