package org.apache.pdfbox.contentstream.operator.graphics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFGraphicsStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.rendering.PageDrawerParameters;
import org.apache.pdfbox.rendering.RenderDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CurveToReplicateInitialPointDiffblueTest {
  /**
   * Test {@link CurveToReplicateInitialPoint#process(Operator, List)}.
   *
   * <p>Method under test: {@link CurveToReplicateInitialPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CurveToReplicateInitialPoint.process(Operator, List)"})
  void testProcess() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);

    PageDrawer context = new PageDrawer(parameters);
    context.processPage(new PDPage());
    CurveToReplicateInitialPoint curveToReplicateInitialPoint =
        new CurveToReplicateInitialPoint(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSFloat.ONE);
    operands.add(COSFloat.ONE);
    operands.add(COSFloat.ONE);
    operands.add(COSFloat.ONE);

    // Act
    curveToReplicateInitialPoint.process(operator, operands);

    // Assert
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
    PDFGraphicsStreamEngine graphicsContext = curveToReplicateInitialPoint.getGraphicsContext();
    Point2D currentPoint = graphicsContext.getCurrentPoint();
    assertTrue(currentPoint instanceof Float);
    assertTrue(graphicsContext instanceof PageDrawer);
    assertEquals(1.0d, currentPoint.getX());
    assertEquals(1.0d, currentPoint.getY());
    assertEquals(1.0f, ((Float) currentPoint).x);
    assertEquals(1.0f, ((Float) currentPoint).y);
  }

  /**
   * Test {@link CurveToReplicateInitialPoint#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is {@code -3.4028235E38}.
   * </ul>
   *
   * <p>Method under test: {@link CurveToReplicateInitialPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSFloat(float) with aFloat is '-3.4028235E38'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CurveToReplicateInitialPoint.process(Operator, List)"})
  void testProcess_givenCOSFloatWithAFloatIs34028235e38() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    CurveToReplicateInitialPoint curveToReplicateInitialPoint =
        new CurveToReplicateInitialPoint(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(new COSFloat(-3.4028235E38f));

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> curveToReplicateInitialPoint.process(operator, operands));
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }

  /**
   * Test {@link CurveToReplicateInitialPoint#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is ten.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#COSFloat(float)} with aFloat is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link CurveToReplicateInitialPoint#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSFloat(float) with aFloat is ten; when ArrayList() add COSFloat(float) with aFloat is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CurveToReplicateInitialPoint.process(Operator, List)"})
  void testProcess_givenCOSFloatWithAFloatIsTen_whenArrayListAddCOSFloatWithAFloatIsTen()
      throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    CurveToReplicateInitialPoint curveToReplicateInitialPoint =
        new CurveToReplicateInitialPoint(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(new COSFloat(10.0f));

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> curveToReplicateInitialPoint.process(operator, operands));
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }

  /**
   * Test {@link CurveToReplicateInitialPoint#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link CurveToReplicateInitialPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSStream(); when ArrayList() add COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CurveToReplicateInitialPoint.process(Operator, List)"})
  void testProcess_givenCOSStream_whenArrayListAddCOSStream() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    CurveToReplicateInitialPoint curveToReplicateInitialPoint =
        new CurveToReplicateInitialPoint(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(new COSStream());

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> curveToReplicateInitialPoint.process(operator, operands));
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }

  /**
   * Test {@link CurveToReplicateInitialPoint#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link CurveToReplicateInitialPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CurveToReplicateInitialPoint.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    CurveToReplicateInitialPoint curveToReplicateInitialPoint =
        new CurveToReplicateInitialPoint(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSFloat.ONE);
    operands.add(COSFloat.ONE);
    operands.add(COSFloat.ONE);

    // Act
    curveToReplicateInitialPoint.process(operator, operands);

    // Assert that nothing has changed
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
    assertTrue(curveToReplicateInitialPoint.getGraphicsContext() instanceof PageDrawer);
  }

  /**
   * Test {@link CurveToReplicateInitialPoint#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link CurveToReplicateInitialPoint#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CurveToReplicateInitialPoint.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowMissingOperandException()
      throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    CurveToReplicateInitialPoint curveToReplicateInitialPoint =
        new CurveToReplicateInitialPoint(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> curveToReplicateInitialPoint.process(operator, operands));
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }

  /**
   * Test {@link CurveToReplicateInitialPoint#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link CurveToReplicateInitialPoint#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CurveToReplicateInitialPoint.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowMissingOperandException2()
      throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    CurveToReplicateInitialPoint curveToReplicateInitialPoint =
        new CurveToReplicateInitialPoint(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> curveToReplicateInitialPoint.process(operator, operands));
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }

  /**
   * Test {@link CurveToReplicateInitialPoint#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link CurveToReplicateInitialPoint#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given ONE; when ArrayList() add ONE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CurveToReplicateInitialPoint.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenThrowMissingOperandException()
      throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    CurveToReplicateInitialPoint curveToReplicateInitialPoint =
        new CurveToReplicateInitialPoint(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSFloat.ONE);

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> curveToReplicateInitialPoint.process(operator, operands));
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }

  /**
   * Test {@link CurveToReplicateInitialPoint#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link CurveToReplicateInitialPoint#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given ONE; when ArrayList() add ONE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CurveToReplicateInitialPoint.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenThrowMissingOperandException2()
      throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    CurveToReplicateInitialPoint curveToReplicateInitialPoint =
        new CurveToReplicateInitialPoint(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> curveToReplicateInitialPoint.process(operator, operands));
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }

  /**
   * Test {@link CurveToReplicateInitialPoint#process(Operator, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link CurveToReplicateInitialPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CurveToReplicateInitialPoint.process(Operator, List)"})
  void testProcess_whenArrayList_thenThrowMissingOperandException() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    CurveToReplicateInitialPoint curveToReplicateInitialPoint =
        new CurveToReplicateInitialPoint(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> curveToReplicateInitialPoint.process(operator, new ArrayList<>()));
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }
}
