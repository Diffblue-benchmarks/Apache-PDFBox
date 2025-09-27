package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TilingPaintFactoryDiffblueTest {
  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>Given {@code -1.0E-5}.
   *   <li>When {@link PDTilingPattern} {@link PDTilingPattern#getXStep()} return {@code -1.0E-5}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given '-1.0E-5'; when PDTilingPattern getXStep() return '-1.0E-5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_given10e5_whenPDTilingPatternGetXStepReturn10e5() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.getScalingFactorX()).thenReturn(10.0f);
    when(matrix2.getScalingFactorY()).thenReturn(10.0f);

    Matrix matrix3 = mock(Matrix.class);
    when(matrix3.multiply(Mockito.<Matrix>any())).thenReturn(matrix2);

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(-1.0E-5f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix3);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2, atLeast(1)).getScalingFactorX();
    verify(matrix2, atLeast(1)).getScalingFactorY();
    verify(matrix3).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>Given {@code -1.0E-5}.
   *   <li>When {@link PDTilingPattern} {@link PDTilingPattern#getYStep()} return {@code -1.0E-5}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given '-1.0E-5'; when PDTilingPattern getYStep() return '-1.0E-5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_given10e5_whenPDTilingPatternGetYStepReturn10e5() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.getScalingFactorX()).thenReturn(10.0f);
    when(matrix2.getScalingFactorY()).thenReturn(10.0f);

    Matrix matrix3 = mock(Matrix.class);
    when(matrix3.multiply(Mockito.<Matrix>any())).thenReturn(matrix2);

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(-1.0E-5f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix3);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2, atLeast(1)).getScalingFactorX();
    verify(matrix2, atLeast(1)).getScalingFactorY();
    verify(matrix3).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>Given {@code 9000000.0}.
   *   <li>When {@link PDTilingPattern} {@link PDTilingPattern#getXStep()} return {@code 9000000.0}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given '9000000.0'; when PDTilingPattern getXStep() return '9000000.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_given90000000_whenPDTilingPatternGetXStepReturn90000000() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.getScalingFactorX()).thenReturn(10.0f);
    when(matrix2.getScalingFactorY()).thenReturn(10.0f);

    Matrix matrix3 = mock(Matrix.class);
    when(matrix3.multiply(Mockito.<Matrix>any())).thenReturn(matrix2);

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(9000000.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix3);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern, atLeast(1)).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2, atLeast(1)).getScalingFactorX();
    verify(matrix2, atLeast(1)).getScalingFactorY();
    verify(matrix3).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>Given {@code 9000000.0}.
   *   <li>When {@link PDTilingPattern} {@link PDTilingPattern#getYStep()} return {@code 9000000.0}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given '9000000.0'; when PDTilingPattern getYStep() return '9000000.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_given90000000_whenPDTilingPatternGetYStepReturn90000000() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.getScalingFactorX()).thenReturn(10.0f);
    when(matrix2.getScalingFactorY()).thenReturn(10.0f);

    Matrix matrix3 = mock(Matrix.class);
    when(matrix3.multiply(Mockito.<Matrix>any())).thenReturn(matrix2);

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(9000000.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix3);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern, atLeast(1)).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2, atLeast(1)).getScalingFactorX();
    verify(matrix2, atLeast(1)).getScalingFactorY();
    verify(matrix3).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>Given {@link Matrix} {@link Matrix#clone()} return {@link Matrix}.
   *   <li>Then return {@link TilingPaint}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given Matrix clone() return Matrix; then return TilingPaint")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_givenMatrixCloneReturnMatrix_thenReturnTilingPaint() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(mock(Matrix.class));

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.multiply(Mockito.<Matrix>any())).thenReturn(new Matrix());

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix2);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>Given {@link Matrix} {@link Matrix#clone()} return {@code null}.
   *   <li>Then return {@link TilingPaint}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given Matrix clone() return 'null'; then return TilingPaint")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_givenMatrixCloneReturnNull_thenReturnTilingPaint() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(null);

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.multiply(Mockito.<Matrix>any())).thenReturn(new Matrix());

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix2);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>Given {@link Matrix} {@link Matrix#getScalingFactorX()} return ten.
   *   <li>Then calls {@link Matrix#getScalingFactorX()}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given Matrix getScalingFactorX() return ten; then calls getScalingFactorX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_givenMatrixGetScalingFactorXReturnTen_thenCallsGetScalingFactorX()
      throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.getScalingFactorX()).thenReturn(10.0f);
    when(matrix2.getScalingFactorY()).thenReturn(10.0f);

    Matrix matrix3 = mock(Matrix.class);
    when(matrix3.multiply(Mockito.<Matrix>any())).thenReturn(matrix2);

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix3);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern, atLeast(1)).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2, atLeast(1)).getScalingFactorX();
    verify(matrix2, atLeast(1)).getScalingFactorY();
    verify(matrix3).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>Given {@link Matrix} {@link Matrix#multiply(Matrix)} return {@link Matrix#Matrix()}.
   *   <li>Then return {@link TilingPaint}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given Matrix multiply(Matrix) return Matrix(); then return TilingPaint")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_givenMatrixMultiplyReturnMatrix_thenReturnTilingPaint() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.multiply(Mockito.<Matrix>any())).thenReturn(new Matrix());

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix2);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PDTilingPattern} {@link PDTilingPattern#getCOSObject()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given 'null'; when PDTilingPattern getCOSObject() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_givenNull_whenPDTilingPatternGetCOSObjectReturnNull() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.getScalingFactorX()).thenReturn(10.0f);
    when(matrix2.getScalingFactorY()).thenReturn(10.0f);

    Matrix matrix3 = mock(Matrix.class);
    when(matrix3.multiply(Mockito.<Matrix>any())).thenReturn(matrix2);

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(null);
    when(pattern.getMatrix()).thenReturn(matrix3);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern, atLeast(1)).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2, atLeast(1)).getScalingFactorX();
    verify(matrix2, atLeast(1)).getScalingFactorY();
    verify(matrix3).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle(float, float)} with width is {@code 9000000.0} and
   *       height is {@code 9000000.0}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given PDRectangle(float, float) with width is '9000000.0' and height is '9000000.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_givenPDRectangleWithWidthIs90000000AndHeightIs90000000() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.multiply(Mockito.<Matrix>any())).thenReturn(new Matrix());

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(new PDRectangle(9000000.0f, 9000000.0f));
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix2);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern, atLeast(1)).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>Given {@link PageDrawer} {@link PageDrawer#drawTilingPattern(Graphics2D, PDTilingPattern,
   *       PDColorSpace, PDColor, Matrix)} throw {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given PageDrawer drawTilingPattern(Graphics2D, PDTilingPattern, PDColorSpace, PDColor, Matrix) throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_givenPageDrawerDrawTilingPatternThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doThrow(new IOException())
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.multiply(Mockito.<Matrix>any())).thenReturn(new Matrix());

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix2);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            tilingPaintFactory.create(
                pattern, PDDeviceGray.INSTANCE, color, new AffineTransform()));
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2).multiply(isA(Matrix.class));
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link Matrix#getScalingFactorX()}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); when 'null'; then calls getScalingFactorX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_whenNull_thenCallsGetScalingFactorX() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.getScalingFactorX()).thenReturn(10.0f);
    when(matrix2.getScalingFactorY()).thenReturn(10.0f);

    Matrix matrix3 = mock(Matrix.class);
    when(matrix3.multiply(Mockito.<Matrix>any())).thenReturn(matrix2);

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix3);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, null, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern, atLeast(1)).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isNull(),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2, atLeast(1)).getScalingFactorX();
    verify(matrix2, atLeast(1)).getScalingFactorY();
    verify(matrix3).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link Matrix#getScalingFactorX()}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); when 'null'; then calls getScalingFactorX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_whenNull_thenCallsGetScalingFactorX2() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.getScalingFactorX()).thenReturn(10.0f);
    when(matrix2.getScalingFactorY()).thenReturn(10.0f);

    Matrix matrix3 = mock(Matrix.class);
    when(matrix3.multiply(Mockito.<Matrix>any())).thenReturn(matrix2);

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix3);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, null, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern, atLeast(1)).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isNull(),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2, atLeast(1)).getScalingFactorX();
    verify(matrix2, atLeast(1)).getScalingFactorY();
    verify(matrix3).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then calls {@link Matrix#getScalingFactorX()}.
   * </ul>
   *
   * <p>Method under test: {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor,
   * AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); when seven; then calls getScalingFactorX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Paint TilingPaintFactory.create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)"
  })
  void testCreate_whenSeven_thenCallsGetScalingFactorX() throws IOException {
    // Arrange
    Matrix matrix = mock(Matrix.class);
    when(matrix.clone()).thenReturn(new Matrix());

    PageDrawer drawer = mock(PageDrawer.class);
    doNothing()
        .when(drawer)
        .drawTilingPattern(
            Mockito.<Graphics2D>any(),
            Mockito.<PDTilingPattern>any(),
            Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(),
            Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(matrix);
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.getScalingFactorX()).thenReturn(10.0f);
    when(matrix2.getScalingFactorY()).thenReturn(10.0f);

    Matrix matrix3 = mock(Matrix.class);
    when(matrix3.multiply(Mockito.<Matrix>any())).thenReturn(matrix2);

    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(matrix3);

    // Act
    Paint actualCreateResult =
        tilingPaintFactory.create(
            pattern,
            PDDeviceGray.INSTANCE,
            new PDColor(new COSArray(), PDDeviceGray.INSTANCE),
            AffineTransform.getQuadrantRotateInstance(7));

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern, atLeast(1)).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer)
        .drawTilingPattern(
            isA(Graphics2D.class),
            isA(PDTilingPattern.class),
            isA(PDColorSpace.class),
            isA(PDColor.class),
            isA(Matrix.class));
    verify(matrix).clone();
    verify(matrix2, atLeast(1)).getScalingFactorX();
    verify(matrix2, atLeast(1)).getScalingFactorY();
    verify(matrix3).multiply(isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }
}
