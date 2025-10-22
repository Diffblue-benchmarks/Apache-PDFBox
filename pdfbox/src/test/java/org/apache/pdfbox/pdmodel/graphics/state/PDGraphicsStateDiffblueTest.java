package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDGraphicsState.<init>(PDRectangle)"})
  void testNewPDGraphicsState_whenA0_thenNonStrokingJavaCompositeReturnAlphaComposite() {
    // Arrange and Act
    PDGraphicsState actualPdGraphicsState = new PDGraphicsState(PDRectangle.A0);

    // Assert
    Composite nonStrokingJavaComposite = actualPdGraphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    PDColorSpace nonStrokingColorSpace = actualPdGraphicsState.getNonStrokingColorSpace();
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertNull(actualPdGraphicsState.getTransfer());
    assertNull(actualPdGraphicsState.getSoftMask());
    assertNull(actualPdGraphicsState.getRenderingIntent());
    assertNull(actualPdGraphicsState.getTextLineMatrix());
    assertNull(actualPdGraphicsState.getTextMatrix());
    assertEquals(0, actualPdGraphicsState.getLineCap());
    assertEquals(0, actualPdGraphicsState.getLineJoin());
    assertEquals(0, actualPdGraphicsState.getOverprintMode());
    assertEquals(0.0d, actualPdGraphicsState.getSmoothness());
    assertEquals(1, actualPdGraphicsState.getCurrentClippingPaths().size());
    assertEquals(1.0d, actualPdGraphicsState.getAlphaConstant());
    assertEquals(1.0d, actualPdGraphicsState.getFlatness());
    assertEquals(1.0d, actualPdGraphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, actualPdGraphicsState.getLineWidth());
    assertEquals(10.0f, actualPdGraphicsState.getMiterLimit());
    assertFalse(actualPdGraphicsState.isAlphaSource());
    assertFalse(actualPdGraphicsState.isNonStrokingOverprint());
    assertFalse(actualPdGraphicsState.isOverprint());
    assertFalse(actualPdGraphicsState.isStrokeAdjustment());
    assertSame(nonStrokingJavaComposite, actualPdGraphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, actualPdGraphicsState.getStrokingColorSpace());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double PDGraphicsState.getAlphaConstant()", "BlendMode PDGraphicsState.getBlendMode()",
      "List PDGraphicsState.getCurrentClippingPaths()", "Matrix PDGraphicsState.getCurrentTransformationMatrix()",
      "double PDGraphicsState.getFlatness()", "int PDGraphicsState.getLineCap()",
      "PDLineDashPattern PDGraphicsState.getLineDashPattern()", "int PDGraphicsState.getLineJoin()",
      "float PDGraphicsState.getLineWidth()", "float PDGraphicsState.getMiterLimit()",
      "double PDGraphicsState.getNonStrokeAlphaConstant()", "PDColor PDGraphicsState.getNonStrokingColor()",
      "PDColorSpace PDGraphicsState.getNonStrokingColorSpace()", "int PDGraphicsState.getOverprintMode()",
      "RenderingIntent PDGraphicsState.getRenderingIntent()", "double PDGraphicsState.getSmoothness()",
      "PDSoftMask PDGraphicsState.getSoftMask()", "PDColor PDGraphicsState.getStrokingColor()",
      "PDColorSpace PDGraphicsState.getStrokingColorSpace()", "Matrix PDGraphicsState.getTextLineMatrix()",
      "Matrix PDGraphicsState.getTextMatrix()", "PDTextState PDGraphicsState.getTextState()",
      "COSBase PDGraphicsState.getTransfer()", "boolean PDGraphicsState.isAlphaSource()",
      "boolean PDGraphicsState.isNonStrokingOverprint()", "boolean PDGraphicsState.isOverprint()",
      "boolean PDGraphicsState.isStrokeAdjustment()", "void PDGraphicsState.setAlphaConstant(double)",
      "void PDGraphicsState.setAlphaSource(boolean)", "void PDGraphicsState.setCurrentTransformationMatrix(Matrix)",
      "void PDGraphicsState.setFlatness(double)", "void PDGraphicsState.setLineCap(int)",
      "void PDGraphicsState.setLineDashPattern(PDLineDashPattern)", "void PDGraphicsState.setLineJoin(int)",
      "void PDGraphicsState.setLineWidth(float)", "void PDGraphicsState.setMiterLimit(float)",
      "void PDGraphicsState.setNonStrokeAlphaConstant(double)", "void PDGraphicsState.setNonStrokingColor(PDColor)",
      "void PDGraphicsState.setNonStrokingColorSpace(PDColorSpace)",
      "void PDGraphicsState.setNonStrokingOverprint(boolean)", "void PDGraphicsState.setOverprint(boolean)",
      "void PDGraphicsState.setOverprintMode(int)", "void PDGraphicsState.setRenderingIntent(RenderingIntent)",
      "void PDGraphicsState.setSmoothness(double)", "void PDGraphicsState.setSoftMask(PDSoftMask)",
      "void PDGraphicsState.setStrokeAdjustment(boolean)", "void PDGraphicsState.setStrokingColor(PDColor)",
      "void PDGraphicsState.setStrokingColorSpace(PDColorSpace)", "void PDGraphicsState.setTextLineMatrix(Matrix)",
      "void PDGraphicsState.setTextMatrix(Matrix)", "void PDGraphicsState.setTextState(PDTextState)",
      "void PDGraphicsState.setTransfer(COSBase)"})
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

    // Assert
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDGraphicsState.setBlendMode(BlendMode)"})
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
    assertTrue(bounds2D instanceof Double);
    Rectangle2D frame2 = frame.getFrame();
    Rectangle2D bounds2D2 = frame2.getBounds2D();
    assertTrue(bounds2D2 instanceof Double);
    assertTrue(frame instanceof Double);
    assertTrue(frame2 instanceof Double);
    Rectangle2D frame3 = frame2.getFrame();
    assertTrue(frame3 instanceof Double);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDGraphicsState.setBlendMode(BlendMode)"})
  void testSetBlendMode_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDGraphicsState(PDRectangle.A0)).setBlendMode(null));
  }

  /**
   * Test {@link PDGraphicsState#clone()}.
   * <ul>
   *   <li>Then CurrentClippingPath Bounds Bounds Frame Bounds2D return {@link Rectangle2D.Double}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDGraphicsState#clone()}
   */
  @Test
  @DisplayName("Test clone(); then CurrentClippingPath Bounds Bounds Frame Bounds2D return Double")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGraphicsState PDGraphicsState.clone()"})
  void testClone_thenCurrentClippingPathBoundsBoundsFrameBounds2DReturnDouble() {
    // Arrange and Act
    PDGraphicsState actualCloneResult = (new PDGraphicsState(PDRectangle.A0)).clone();

    // Assert
    Rectangle2D frame = actualCloneResult.getCurrentClippingPath().getBounds().getBounds().getFrame();
    assertTrue(frame.getBounds2D() instanceof Double);
    assertTrue(frame instanceof Double);
    assertTrue(frame.getFrame() instanceof Double);
    float[][] values = actualCloneResult.getCurrentTransformationMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{}, actualCloneResult.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, actualCloneResult.getNonStrokingColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGraphicsState PDGraphicsState.clone()"})
  void testClone_thenReturnTextLineMatrixIsMatrix() {
    // Arrange
    PDGraphicsState pdGraphicsState = new PDGraphicsState(PDRectangle.A0);
    Matrix value = new Matrix();
    pdGraphicsState.setTextLineMatrix(value);
    pdGraphicsState.setTextMatrix(null);

    // Act
    PDGraphicsState actualCloneResult = pdGraphicsState.clone();

    // Assert
    assertEquals(value, actualCloneResult.getTextLineMatrix());
    assertArrayEquals(new float[]{}, actualCloneResult.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, actualCloneResult.getNonStrokingColor().getComponents(), 0.0f);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGraphicsState PDGraphicsState.clone()"})
  void testClone_thenReturnTextMatrixIsMatrix() {
    // Arrange
    PDGraphicsState pdGraphicsState = new PDGraphicsState(PDRectangle.A0);
    pdGraphicsState.setTextLineMatrix(null);
    Matrix value = new Matrix();
    pdGraphicsState.setTextMatrix(value);

    // Act
    PDGraphicsState actualCloneResult = pdGraphicsState.clone();

    // Assert
    assertEquals(value, actualCloneResult.getTextMatrix());
    assertArrayEquals(new float[]{}, actualCloneResult.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, actualCloneResult.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDGraphicsState#getCurrentClippingPath()}.
   * <p>
   * Method under test: {@link PDGraphicsState#getCurrentClippingPath()}
   */
  @Test
  @DisplayName("Test getCurrentClippingPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Area PDGraphicsState.getCurrentClippingPath()"})
  void testGetCurrentClippingPath() {
    // Arrange and Act
    Area actualCurrentClippingPath = (new PDGraphicsState(PDRectangle.A0)).getCurrentClippingPath();

    // Assert
    assertTrue(actualCurrentClippingPath.getBounds2D() instanceof Double);
    assertFalse(actualCurrentClippingPath.isEmpty());
    assertTrue(actualCurrentClippingPath.isRectangular());
  }
}
