package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendComposite;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDGraphicsStateDiffblueTest {
  /**
   * Test {@link PDGraphicsState#PDGraphicsState(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then NonStrokingJavaComposite return {@link AlphaComposite}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDGraphicsState#PDGraphicsState(PDRectangle)}
   */
  @Test
  @DisplayName("Test new PDGraphicsState(PDRectangle); when A0; then NonStrokingJavaComposite return AlphaComposite")
  void testNewPDGraphicsState_whenA0_thenNonStrokingJavaCompositeReturnAlphaComposite() {
    // Arrange and Act
    PDGraphicsState actualPdGraphicsState = new PDGraphicsState(PDRectangle.A0);

    // Assert
    Composite nonStrokingJavaComposite = actualPdGraphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = actualPdGraphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = actualPdGraphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    Point2D currentPoint = getResult.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D4 = bounds2D3.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds2D3.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = actualPdGraphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = actualPdGraphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = actualPdGraphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(actualPdGraphicsState.getTransfer());
    PDColor nonStrokingColor = actualPdGraphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(getResult2.getKey());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = actualPdGraphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(actualPdGraphicsState.getSoftMask());
    assertNull(actualPdGraphicsState.getRenderingIntent());
    assertNull(actualPdGraphicsState.getTextLineMatrix());
    assertNull(actualPdGraphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, actualPdGraphicsState.getLineCap());
    assertEquals(0, actualPdGraphicsState.getLineJoin());
    assertEquals(0, actualPdGraphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
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
    assertEquals(0.0d, bounds2D3.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, bounds2D3.getMinY());
    assertEquals(0.0d, bounds2D3.getX());
    assertEquals(0.0d, bounds2D3.getY());
    assertEquals(0.0d, actualPdGraphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    Matrix currentTransformationMatrix = actualPdGraphicsState.getCurrentTransformationMatrix();
    assertEquals(0.0f, currentTransformationMatrix.getShearX());
    assertEquals(0.0f, currentTransformationMatrix.getShearY());
    assertEquals(0.0f, currentTransformationMatrix.getTranslateX());
    assertEquals(0.0f, currentTransformationMatrix.getTranslateY());
    assertEquals(1, getResult.getWindingRule());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, actualPdGraphicsState.getAlphaConstant());
    assertEquals(1.0d, actualPdGraphicsState.getFlatness());
    assertEquals(1.0d, actualPdGraphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, actualPdGraphicsState.getLineWidth());
    assertEquals(1.0f, currentTransformationMatrix.getScaleX());
    assertEquals(1.0f, currentTransformationMatrix.getScaleY());
    assertEquals(1.0f, currentTransformationMatrix.getScalingFactorX());
    assertEquals(1.0f, currentTransformationMatrix.getScalingFactorY());
    assertEquals(10.0f, actualPdGraphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(1191.968505859375d, bounds2D3.getCenterX());
    assertEquals(1192.0d, bounds.getCenterX());
    assertEquals(1685.1968994140625d, bounds2D3.getCenterY());
    assertEquals(1685.5d, bounds.getCenterY());
    assertEquals(2383.93701171875d, bounds2D3.getMaxX());
    assertEquals(2383.93701171875d, bounds2D3.getWidth());
    Dimension size = bounds.getSize();
    assertEquals(2384, size.width);
    assertEquals(2384, bounds.width);
    assertEquals(2384.0d, size.getWidth());
    assertEquals(2384.0d, bounds.getWidth());
    assertEquals(2384.0d, bounds.getMaxX());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    float[][] values = currentTransformationMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3370.393798828125d, bounds2D3.getHeight());
    assertEquals(3370.393798828125d, bounds2D3.getMaxY());
    assertEquals(3371, size.height);
    assertEquals(3371, bounds.height);
    assertEquals(3371.0d, size.getHeight());
    assertEquals(3371.0d, bounds.getHeight());
    assertEquals(3371.0d, bounds.getMaxY());
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(bounds.isEmpty());
    assertFalse(currentClippingPath.isEmpty());
    assertFalse(bounds2D3.isEmpty());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(actualPdGraphicsState.isAlphaSource());
    assertFalse(actualPdGraphicsState.isNonStrokingOverprint());
    assertFalse(actualPdGraphicsState.isOverprint());
    assertFalse(actualPdGraphicsState.isStrokeAdjustment());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(location, location.getLocation());
    assertEquals(location, currentPoint);
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D3.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds2D3, bounds2D2);
    assertEquals(bounds2D3, bounds2D4);
    assertEquals(bounds2D3, frame2);
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, actualPdGraphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, actualPdGraphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, actualPdGraphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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

  /**
   * Test {@link PDGraphicsState#setBlendMode(BlendMode)}.
   * <p>
   * Method under test: {@link PDGraphicsState#setBlendMode(BlendMode)}
   */
  @Test
  @DisplayName("Test setBlendMode(BlendMode)")
  void testSetBlendMode() {
    // Arrange
    PDGraphicsState pdGraphicsState = new PDGraphicsState(PDRectangle.A0);
    BlendMode blendMode = BlendMode.COLOR;

    // Act
    pdGraphicsState.setBlendMode(blendMode);

    // Assert
    Rectangle bounds = pdGraphicsState.getCurrentClippingPath().getBounds();
    Rectangle2D frame = bounds.getBounds().getFrame();
    Rectangle2D bounds2D = frame.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Double);
    Rectangle2D frame2 = frame.getFrame();
    Rectangle2D bounds2D2 = frame2.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = frame2.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(pdGraphicsState.getNonStrokingJavaComposite() instanceof BlendComposite);
    assertTrue(pdGraphicsState.getStrokingJavaComposite() instanceof BlendComposite);
    assertEquals(0.0d, bounds2D.getY());
    assertEquals(1192.0d, frame2.getCenterX());
    assertEquals(1685.5d, frame2.getCenterY());
    assertEquals(2384.0d, frame2.getMaxX());
    assertEquals(3371.0d, frame2.getHeight());
    assertEquals(3371.0d, frame2.getMaxY());
    assertFalse(bounds2D.isEmpty());
    assertEquals(bounds, frame2.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame3);
    BlendMode expectedBlendMode = blendMode.COLOR;
    assertSame(expectedBlendMode, pdGraphicsState.getBlendMode());
  }

  /**
   * Test {@link PDGraphicsState#setBlendMode(BlendMode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDGraphicsState#setBlendMode(BlendMode)}
   */
  @Test
  @DisplayName("Test setBlendMode(BlendMode); when 'null'; then throw IllegalArgumentException")
  void testSetBlendMode_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDGraphicsState(PDRectangle.A0)).setBlendMode(null));
  }

  /**
   * Test {@link PDGraphicsState#clone()}.
   * <ul>
   *   <li>Then CurrentClippingPath Bounds Bounds Frame Bounds2D return
   * {@link Double}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDGraphicsState#clone()}
   */
  @Test
  @DisplayName("Test clone(); then CurrentClippingPath Bounds Bounds Frame Bounds2D return Double")
  void testClone_thenCurrentClippingPathBoundsBoundsFrameBounds2DReturnDouble() {
    // Arrange, Act and Assert
    Rectangle bounds = (new PDGraphicsState(PDRectangle.A0)).clone().getCurrentClippingPath().getBounds();
    Rectangle2D frame = bounds.getBounds().getFrame();
    Rectangle2D bounds2D = frame.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Double);
    Rectangle2D frame2 = frame.getFrame();
    Rectangle2D bounds2D2 = frame2.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = frame2.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertEquals(0.0d, bounds2D.getX());
    assertEquals(0.0d, bounds2D.getY());
    assertEquals(1192.0d, frame2.getCenterX());
    assertEquals(1685.5d, frame2.getCenterY());
    assertEquals(3371.0d, frame2.getHeight());
    assertFalse(bounds2D.isEmpty());
    assertEquals(bounds, frame2.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame3);
  }

  /**
   * Test {@link PDGraphicsState#clone()}.
   * <ul>
   *   <li>Then return TextLineMatrix is {@link Matrix#Matrix()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDGraphicsState#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return TextLineMatrix is Matrix()")
  void testClone_thenReturnTextLineMatrixIsMatrix() {
    // Arrange
    PDGraphicsState pdGraphicsState = new PDGraphicsState(PDRectangle.A0);
    Matrix value = new Matrix();
    pdGraphicsState.setTextLineMatrix(value);
    pdGraphicsState.setTextMatrix(null);

    // Act and Assert
    assertEquals(value, pdGraphicsState.clone().getTextLineMatrix());
  }

  /**
   * Test {@link PDGraphicsState#clone()}.
   * <ul>
   *   <li>Then return TextMatrix is {@link Matrix#Matrix()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDGraphicsState#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return TextMatrix is Matrix()")
  void testClone_thenReturnTextMatrixIsMatrix() {
    // Arrange
    PDGraphicsState pdGraphicsState = new PDGraphicsState(PDRectangle.A0);
    pdGraphicsState.setTextLineMatrix(null);
    Matrix value = new Matrix();
    pdGraphicsState.setTextMatrix(value);

    // Act and Assert
    assertEquals(value, pdGraphicsState.clone().getTextMatrix());
  }

  /**
   * Test {@link PDGraphicsState#getCurrentClippingPath()}.
   * <p>
   * Method under test: {@link PDGraphicsState#getCurrentClippingPath()}
   */
  @Test
  @DisplayName("Test getCurrentClippingPath()")
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
}
