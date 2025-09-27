package org.apache.pdfbox.contentstream.operator.graphics;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.rendering.PageDrawerParameters;
import org.apache.pdfbox.rendering.RenderDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClosePathDiffblueTest {
  /**
   * Test {@link ClosePath#process(Operator, List)}.
   *
   * <p>Method under test: {@link ClosePath#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClosePath.process(Operator, List)"})
  void testProcess() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);

    PageDrawer context = new PageDrawer(parameters);
    Double p0 = new Double();
    Double p1 = new Double();
    Double p2 = new Double();

    context.appendRectangle(p0, p1, p2, new Double());
    ClosePath closePath = new ClosePath(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    closePath.process(operator, new ArrayList<>());

    // Assert
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }

  /**
   * Test {@link ClosePath#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link PageDrawerParameters#getDestination()}.
   * </ul>
   *
   * <p>Method under test: {@link ClosePath#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls getDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClosePath.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsGetDestination() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    ClosePath closePath = new ClosePath(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act
    closePath.process(operator, operands);

    // Assert
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }

  /**
   * Test {@link ClosePath#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link PageDrawerParameters#getDestination()}.
   * </ul>
   *
   * <p>Method under test: {@link ClosePath#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls getDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClosePath.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsGetDestination2() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    ClosePath closePath = new ClosePath(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSBoolean.FALSE);

    // Act
    closePath.process(operator, operands);

    // Assert
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }

  /**
   * Test {@link ClosePath#process(Operator, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link PageDrawerParameters#getDestination()}.
   * </ul>
   *
   * <p>Method under test: {@link ClosePath#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then calls getDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClosePath.process(Operator, List)"})
  void testProcess_whenArrayList_thenCallsGetDestination() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    ClosePath closePath = new ClosePath(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    closePath.process(operator, new ArrayList<>());

    // Assert
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }
}
