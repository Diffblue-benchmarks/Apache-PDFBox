package org.apache.pdfbox.examples.printing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.rendering.PageDrawerParameters;
import org.apache.pdfbox.rendering.RenderDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OpaquePDFRendererDiffblueTest {
  /**
   * Test {@link OpaquePDFRenderer#OpaquePDFRenderer(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link OpaquePDFRenderer#OpaquePDFRenderer(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new OpaquePDFRenderer(PDDocument); given PDPage(); when PDDocument() addPage PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OpaquePDFRenderer.<init>(PDDocument)"})
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
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return RenderingHints is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OpaquePDFRenderer#OpaquePDFRenderer(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new OpaquePDFRenderer(PDDocument); when PDDocument(); then return RenderingHints is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OpaquePDFRenderer.<init>(PDDocument)"})
  void testNewOpaquePDFRenderer_whenPDDocument_thenReturnRenderingHintsIsNull() {
    // Arrange and Act
    OpaquePDFRenderer actualOpaquePDFRenderer = new OpaquePDFRenderer(new PDDocument());

    // Assert
    assertNull(actualOpaquePDFRenderer.getRenderingHints());
    assertNull(actualOpaquePDFRenderer.getDefaultDestination());
    assertEquals(0.5f, actualOpaquePDFRenderer.getImageDownscalingOptimizationThreshold());
    assertFalse(actualOpaquePDFRenderer.isSubsamplingAllowed());
  }

  /**
   * Test {@link OpaquePDFRenderer#createPageDrawer(PageDrawerParameters)}.
   *
   * <p>Method under test: {@link OpaquePDFRenderer#createPageDrawer(PageDrawerParameters)}
   */
  @Test
  @DisplayName("Test createPageDrawer(PageDrawerParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDrawer OpaquePDFRenderer.createPageDrawer(PageDrawerParameters)"})
  void testCreatePageDrawer() throws IOException {
    // Arrange
    OpaquePDFRenderer opaquePDFRenderer = new OpaquePDFRenderer(new PDDocument());

    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);

    // Act
    PageDrawer actualCreatePageDrawerResult = opaquePDFRenderer.createPageDrawer(parameters);

    // Assert
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
    assertNull(actualCreatePageDrawerResult.getCurrentPoint());
    assertNull(actualCreatePageDrawerResult.getCurrentPage());
    assertNull(actualCreatePageDrawerResult.getResources());
    assertNull(actualCreatePageDrawerResult.getGraphicsState());
    assertNull(actualCreatePageDrawerResult.getRenderer());
    assertNull(actualCreatePageDrawerResult.getInitialMatrix());
    assertEquals(0, actualCreatePageDrawerResult.getGraphicsStackSize());
    assertEquals(0, actualCreatePageDrawerResult.getLevel());
  }
}
