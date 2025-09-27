package org.apache.pdfbox.contentstream.operator.graphics;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.contentstream.PDFGraphicsStreamEngine;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.rendering.PageDrawerParameters;
import org.apache.pdfbox.rendering.RenderDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GraphicsOperatorProcessorDiffblueTest {
  /**
   * Test {@link GraphicsOperatorProcessor#getGraphicsContext()}.
   *
   * <p>Method under test: {@link GraphicsOperatorProcessor#getGraphicsContext()}
   */
  @Test
  @DisplayName("Test getGraphicsContext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFGraphicsStreamEngine GraphicsOperatorProcessor.getGraphicsContext()"})
  void testGetGraphicsContext() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);

    // Act
    PDFGraphicsStreamEngine actualGraphicsContext =
        new AppendRectangleToPath(context).getGraphicsContext();

    // Assert
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
    assertSame(context, actualGraphicsContext);
  }
}
