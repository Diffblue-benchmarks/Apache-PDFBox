package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendComposite;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDGraphicsStateDiffblueTest {
  /**
   * Method under test: {@link PDGraphicsState#setBlendMode(BlendMode)}
   */
  @Test
  void testSetBlendMode() {
    // Arrange
    PDGraphicsState pdGraphicsState = new PDGraphicsState(PDRectangle.A0);
    BlendMode blendMode = BlendMode.COLOR;

    // Act
    pdGraphicsState.setBlendMode(blendMode);

    // Assert
    assertTrue(pdGraphicsState.getNonStrokingJavaComposite() instanceof BlendComposite);
    assertTrue(pdGraphicsState.getStrokingJavaComposite() instanceof BlendComposite);
    Rectangle bounds = pdGraphicsState.getCurrentClippingPath().getBounds();
    assertEquals(bounds, bounds.getBounds());
    BlendMode expectedBlendMode = blendMode.COLOR;
    assertSame(expectedBlendMode, pdGraphicsState.getBlendMode());
  }

  /**
   * Method under test: {@link PDGraphicsState#setBlendMode(BlendMode)}
   */
  @Test
  void testSetBlendMode2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDGraphicsState(PDRectangle.A0)).setBlendMode(null));
  }

  /**
   * Method under test: {@link PDGraphicsState#intersectClippingPath(Area)}
   */
  @Test
  void testIntersectClippingPath() {
    // Arrange
    PDRectangle page = mock(PDRectangle.class);
    when(page.toGeneralPath()).thenReturn(new GeneralPath(1));
    PDGraphicsState pdGraphicsState = new PDGraphicsState(page);

    // Act
    pdGraphicsState.intersectClippingPath(new Area());

    // Assert
    verify(page).toGeneralPath();
  }

  /**
   * Method under test: {@link PDGraphicsState#intersectClippingPath(GeneralPath)}
   */
  @Test
  void testIntersectClippingPath2() {
    // Arrange
    PDRectangle page = mock(PDRectangle.class);
    when(page.toGeneralPath()).thenReturn(new GeneralPath(1));
    PDGraphicsState pdGraphicsState = new PDGraphicsState(page);

    // Act
    pdGraphicsState.intersectClippingPath(new GeneralPath(1));

    // Assert
    verify(page).toGeneralPath();
  }

  /**
   * Method under test: {@link PDGraphicsState#getCurrentClippingPath()}
   */
  @Test
  void testGetCurrentClippingPath() {
    // Arrange and Act
    Area actualCurrentClippingPath = (new PDGraphicsState(PDRectangle.A0)).getCurrentClippingPath();

    // Assert
    Rectangle bounds = actualCurrentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = actualCurrentClippingPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = bounds2D2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds2D2.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds2D2.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, bounds2D2.getMinY());
    assertEquals(0.0d, bounds2D2.getX());
    assertEquals(0.0d, bounds2D2.getY());
    assertEquals(1191.968505859375d, bounds2D2.getCenterX());
    assertEquals(1192.0d, bounds.getCenterX());
    assertEquals(1685.1968994140625d, bounds2D2.getCenterY());
    assertEquals(1685.5d, bounds.getCenterY());
    assertEquals(2383.93701171875d, bounds2D2.getMaxX());
    assertEquals(2383.93701171875d, bounds2D2.getWidth());
    Dimension size = bounds.getSize();
    assertEquals(2384, size.width);
    assertEquals(2384, bounds.width);
    assertEquals(2384.0d, size.getWidth());
    assertEquals(2384.0d, bounds.getWidth());
    assertEquals(2384.0d, bounds.getMaxX());
    assertEquals(3370.393798828125d, bounds2D2.getHeight());
    assertEquals(3370.393798828125d, bounds2D2.getMaxY());
    assertEquals(3371, size.height);
    assertEquals(3371, bounds.height);
    assertEquals(3371.0d, size.getHeight());
    assertEquals(3371.0d, bounds.getHeight());
    assertEquals(3371.0d, bounds.getMaxY());
    assertFalse(bounds.isEmpty());
    assertFalse(actualCurrentClippingPath.isEmpty());
    assertFalse(bounds2D2.isEmpty());
    assertTrue(actualCurrentClippingPath.isRectangular());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds2D2, bounds2D3);
    assertEquals(bounds2D2, frame2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDGraphicsState#setAlphaConstant(double)}
   *   <li>{@link PDGraphicsState#setAlphaSource(boolean)}
   *   <li>{@link PDGraphicsState#setCurrentTransformationMatrix(Matrix)}
   *   <li>{@link PDGraphicsState#setFlatness(double)}
   *   <li>{@link PDGraphicsState#setLineCap(int)}
   *   <li>{@link PDGraphicsState#setLineDashPattern(PDLineDashPattern)}
   *   <li>{@link PDGraphicsState#setLineJoin(int)}
   *   <li>{@link PDGraphicsState#setLineWidth(float)}
   *   <li>{@link PDGraphicsState#setMiterLimit(float)}
   *   <li>{@link PDGraphicsState#setNonStrokeAlphaConstant(double)}
   *   <li>{@link PDGraphicsState#setNonStrokingColor(PDColor)}
   *   <li>{@link PDGraphicsState#setNonStrokingColorSpace(PDColorSpace)}
   *   <li>{@link PDGraphicsState#setNonStrokingOverprint(boolean)}
   *   <li>{@link PDGraphicsState#setOverprint(boolean)}
   *   <li>{@link PDGraphicsState#setOverprintMode(int)}
   *   <li>{@link PDGraphicsState#setRenderingIntent(RenderingIntent)}
   *   <li>{@link PDGraphicsState#setSmoothness(double)}
   *   <li>{@link PDGraphicsState#setSoftMask(PDSoftMask)}
   *   <li>{@link PDGraphicsState#setStrokeAdjustment(boolean)}
   *   <li>{@link PDGraphicsState#setStrokingColor(PDColor)}
   *   <li>{@link PDGraphicsState#setStrokingColorSpace(PDColorSpace)}
   *   <li>{@link PDGraphicsState#setTextLineMatrix(Matrix)}
   *   <li>{@link PDGraphicsState#setTextMatrix(Matrix)}
   *   <li>{@link PDGraphicsState#setTextState(PDTextState)}
   *   <li>{@link PDGraphicsState#setTransfer(COSBase)}
   *   <li>{@link PDGraphicsState#getAlphaConstant()}
   *   <li>{@link PDGraphicsState#getBlendMode()}
   *   <li>{@link PDGraphicsState#getCurrentClippingPaths()}
   *   <li>{@link PDGraphicsState#getCurrentTransformationMatrix()}
   *   <li>{@link PDGraphicsState#getFlatness()}
   *   <li>{@link PDGraphicsState#getLineCap()}
   *   <li>{@link PDGraphicsState#getLineDashPattern()}
   *   <li>{@link PDGraphicsState#getLineJoin()}
   *   <li>{@link PDGraphicsState#getLineWidth()}
   *   <li>{@link PDGraphicsState#getMiterLimit()}
   *   <li>{@link PDGraphicsState#getNonStrokeAlphaConstant()}
   *   <li>{@link PDGraphicsState#getNonStrokingColor()}
   *   <li>{@link PDGraphicsState#getNonStrokingColorSpace()}
   *   <li>{@link PDGraphicsState#getOverprintMode()}
   *   <li>{@link PDGraphicsState#getRenderingIntent()}
   *   <li>{@link PDGraphicsState#getSmoothness()}
   *   <li>{@link PDGraphicsState#getSoftMask()}
   *   <li>{@link PDGraphicsState#getStrokingColor()}
   *   <li>{@link PDGraphicsState#getStrokingColorSpace()}
   *   <li>{@link PDGraphicsState#getTextLineMatrix()}
   *   <li>{@link PDGraphicsState#getTextMatrix()}
   *   <li>{@link PDGraphicsState#getTextState()}
   *   <li>{@link PDGraphicsState#getTransfer()}
   *   <li>{@link PDGraphicsState#isAlphaSource()}
   *   <li>{@link PDGraphicsState#isNonStrokingOverprint()}
   *   <li>{@link PDGraphicsState#isOverprint()}
   *   <li>{@link PDGraphicsState#isStrokeAdjustment()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDGraphicsState pdGraphicsState = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdGraphicsState.setAlphaConstant(10.0d);
    pdGraphicsState.setAlphaSource(true);
    Matrix value = new Matrix();
    pdGraphicsState.setCurrentTransformationMatrix(value);
    pdGraphicsState.setFlatness(10.0d);
    pdGraphicsState.setLineCap(42);
    PDLineDashPattern value2 = new PDLineDashPattern();
    pdGraphicsState.setLineDashPattern(value2);
    pdGraphicsState.setLineJoin(42);
    pdGraphicsState.setLineWidth(10.0f);
    pdGraphicsState.setMiterLimit(10.0f);
    pdGraphicsState.setNonStrokeAlphaConstant(10.0d);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    pdGraphicsState.setNonStrokingColor(color);
    pdGraphicsState.setNonStrokingColorSpace(PDDeviceGray.INSTANCE);
    pdGraphicsState.setNonStrokingOverprint(true);
    pdGraphicsState.setOverprint(true);
    pdGraphicsState.setOverprintMode(42);
    pdGraphicsState.setRenderingIntent(RenderingIntent.ABSOLUTE_COLORIMETRIC);
    pdGraphicsState.setSmoothness(10.0d);
    PDSoftMask softMask = new PDSoftMask(new COSDictionary());
    pdGraphicsState.setSoftMask(softMask);
    pdGraphicsState.setStrokeAdjustment(true);
    PDColor color2 = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    pdGraphicsState.setStrokingColor(color2);
    pdGraphicsState.setStrokingColorSpace(PDDeviceGray.INSTANCE);
    Matrix value3 = new Matrix();
    pdGraphicsState.setTextLineMatrix(value3);
    Matrix value4 = new Matrix();
    pdGraphicsState.setTextMatrix(value4);
    PDTextState value5 = new PDTextState();
    pdGraphicsState.setTextState(value5);
    pdGraphicsState.setTransfer(COSBoolean.FALSE);
    double actualAlphaConstant = pdGraphicsState.getAlphaConstant();
    BlendMode actualBlendMode = pdGraphicsState.getBlendMode();
    List<Path2D> actualCurrentClippingPaths = pdGraphicsState.getCurrentClippingPaths();
    Matrix actualCurrentTransformationMatrix = pdGraphicsState.getCurrentTransformationMatrix();
    double actualFlatness = pdGraphicsState.getFlatness();
    int actualLineCap = pdGraphicsState.getLineCap();
    PDLineDashPattern actualLineDashPattern = pdGraphicsState.getLineDashPattern();
    int actualLineJoin = pdGraphicsState.getLineJoin();
    float actualLineWidth = pdGraphicsState.getLineWidth();
    float actualMiterLimit = pdGraphicsState.getMiterLimit();
    double actualNonStrokeAlphaConstant = pdGraphicsState.getNonStrokeAlphaConstant();
    PDColor actualNonStrokingColor = pdGraphicsState.getNonStrokingColor();
    PDColorSpace actualNonStrokingColorSpace = pdGraphicsState.getNonStrokingColorSpace();
    int actualOverprintMode = pdGraphicsState.getOverprintMode();
    RenderingIntent actualRenderingIntent = pdGraphicsState.getRenderingIntent();
    double actualSmoothness = pdGraphicsState.getSmoothness();
    PDSoftMask actualSoftMask = pdGraphicsState.getSoftMask();
    PDColor actualStrokingColor = pdGraphicsState.getStrokingColor();
    PDColorSpace actualStrokingColorSpace = pdGraphicsState.getStrokingColorSpace();
    Matrix actualTextLineMatrix = pdGraphicsState.getTextLineMatrix();
    Matrix actualTextMatrix = pdGraphicsState.getTextMatrix();
    PDTextState actualTextState = pdGraphicsState.getTextState();
    COSBase actualTransfer = pdGraphicsState.getTransfer();
    boolean actualIsAlphaSourceResult = pdGraphicsState.isAlphaSource();
    boolean actualIsNonStrokingOverprintResult = pdGraphicsState.isNonStrokingOverprint();
    boolean actualIsOverprintResult = pdGraphicsState.isOverprint();

    // Assert that nothing has changed
    assertEquals(1, actualCurrentClippingPaths.size());
    assertTrue(actualCurrentClippingPaths.get(0) instanceof Path2D.Double);
    assertTrue(actualTransfer instanceof COSBoolean);
    assertTrue(actualNonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals(10.0d, actualAlphaConstant);
    assertEquals(10.0d, actualFlatness);
    assertEquals(10.0d, actualNonStrokeAlphaConstant);
    assertEquals(10.0d, actualSmoothness);
    assertEquals(10.0f, actualLineWidth);
    assertEquals(10.0f, actualMiterLimit);
    assertEquals(42, actualLineCap);
    assertEquals(42, actualLineJoin);
    assertEquals(42, actualOverprintMode);
    assertEquals(RenderingIntent.ABSOLUTE_COLORIMETRIC, actualRenderingIntent);
    assertTrue(actualIsAlphaSourceResult);
    assertTrue(actualIsNonStrokingOverprintResult);
    assertTrue(actualIsOverprintResult);
    assertTrue(pdGraphicsState.isStrokeAdjustment());
    assertSame(value2, actualLineDashPattern);
    assertSame(color, actualNonStrokingColor);
    assertSame(color2, actualStrokingColor);
    assertSame(softMask, actualSoftMask);
    assertSame(value5, actualTextState);
    assertSame(value, actualCurrentTransformationMatrix);
    assertSame(value3, actualTextLineMatrix);
    assertSame(value4, actualTextMatrix);
    assertSame(actualBlendMode.NORMAL, actualBlendMode);
    PDDeviceGray pdDeviceGray = ((PDDeviceGray) actualStrokingColorSpace).INSTANCE;
    assertSame(pdDeviceGray, actualNonStrokingColorSpace);
    assertSame(pdDeviceGray, actualStrokingColorSpace);
  }
}
