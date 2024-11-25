package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.apache.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TilingPaintFactoryDiffblueTest {
  /**
   * Test
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}.
   * <ul>
   *   <li>Given {@code -0.5}.</li>
   *   <li>When {@link PDTilingPattern} {@link PDTilingPattern#getXStep()} return
   * {@code -0.5}.</li>
   *   <li>Then return {@link TilingPaint}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  @DisplayName("Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given '-0.5'; when PDTilingPattern getXStep() return '-0.5'; then return TilingPaint")
  void testCreate_given05_whenPDTilingPatternGetXStepReturn05_thenReturnTilingPaint() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(-0.5f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}.
   * <ul>
   *   <li>Given {@code -0.5}.</li>
   *   <li>When {@link PDTilingPattern} {@link PDTilingPattern#getYStep()} return
   * {@code -0.5}.</li>
   *   <li>Then return {@link TilingPaint}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  @DisplayName("Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given '-0.5'; when PDTilingPattern getYStep() return '-0.5'; then return TilingPaint")
  void testCreate_given05_whenPDTilingPatternGetYStepReturn05_thenReturnTilingPaint() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(-0.5f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}.
   * <ul>
   *   <li>Given {@code 9000000.0}.</li>
   *   <li>When {@link PDTilingPattern} {@link PDTilingPattern#getXStep()} return
   * {@code 9000000.0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  @DisplayName("Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given '9000000.0'; when PDTilingPattern getXStep() return '9000000.0'")
  void testCreate_given90000000_whenPDTilingPatternGetXStepReturn90000000() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(9000000.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern, atLeast(1)).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link TilingPaint}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  @DisplayName("Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given COSDictionary(); when 'null'; then return TilingPaint")
  void testCreate_givenCOSDictionary_whenNull_thenReturnTilingPaint() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, null, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isNull(), isA(PDColor.class),
        isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link TilingPaint}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  @DisplayName("Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given COSDictionary(); when 'null'; then return TilingPaint")
  void testCreate_givenCOSDictionary_whenNull_thenReturnTilingPaint2() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, null, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isNull(), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When seven.</li>
   *   <li>Then return {@link TilingPaint}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  @DisplayName("Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given COSDictionary(); when seven; then return TilingPaint")
  void testCreate_givenCOSDictionary_whenSeven_thenReturnTilingPaint() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color,
        AffineTransform.getQuadrantRotateInstance(7));

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PDTilingPattern} {@link PDAbstractPattern#getCOSObject()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  @DisplayName("Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given 'null'; when PDTilingPattern getCOSObject() return 'null'")
  void testCreate_givenNull_whenPDTilingPatternGetCOSObjectReturnNull() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(null);
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link PDTilingPattern} {@link PDTilingPattern#getXStep()} return
   * zero.</li>
   *   <li>Then return {@link TilingPaint}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  @DisplayName("Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given zero; when PDTilingPattern getXStep() return zero; then return TilingPaint")
  void testCreate_givenZero_whenPDTilingPatternGetXStepReturnZero_thenReturnTilingPaint() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link PDTilingPattern} {@link PDTilingPattern#getYStep()} return
   * zero.</li>
   *   <li>Then return {@link TilingPaint}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  @DisplayName("Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given zero; when PDTilingPattern getYStep() return zero; then return TilingPaint")
  void testCreate_givenZero_whenPDTilingPatternGetYStepReturnZero_thenReturnTilingPaint() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Test
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}.
   * <ul>
   *   <li>When {@link PDTilingPattern} {@link PDTilingPattern#getXStep()} return
   * ten.</li>
   *   <li>Then return {@link TilingPaint}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  @DisplayName("Test create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform); when PDTilingPattern getXStep() return ten; then return TilingPaint")
  void testCreate_whenPDTilingPatternGetXStepReturnTen_thenReturnTilingPaint() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }
}
