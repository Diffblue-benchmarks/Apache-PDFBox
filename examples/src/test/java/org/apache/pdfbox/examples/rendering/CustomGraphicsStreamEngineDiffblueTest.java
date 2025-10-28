package org.apache.pdfbox.examples.rendering;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.graphics.state.PDTextState;
import org.apache.pdfbox.pdmodel.graphics.state.RenderingMode;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class CustomGraphicsStreamEngineDiffblueTest {
  /**
   * Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  void testRun() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    Composite nonStrokingJavaComposite = graphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getCurrentPoint() instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = graphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(graphicsState.getTransfer());
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(getResult2.getKey());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = graphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(graphicsState.getSoftMask());
    assertNull(graphicsState.getRenderingIntent());
    assertNull(customGraphicsStreamEngine.getTextLineMatrix());
    assertNull(customGraphicsStreamEngine.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, graphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    Matrix initialMatrix = customGraphicsStreamEngine.getInitialMatrix();
    assertEquals(0.0f, initialMatrix.getShearX());
    assertEquals(0.0f, initialMatrix.getShearY());
    assertEquals(0.0f, initialMatrix.getTranslateX());
    assertEquals(0.0f, initialMatrix.getTranslateY());
    assertEquals(1, getResult.getWindingRule());
    assertEquals(1, customGraphicsStreamEngine.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(1.0f, initialMatrix.getScaleX());
    assertEquals(1.0f, initialMatrix.getScaleY());
    assertEquals(1.0f, initialMatrix.getScalingFactorX());
    assertEquals(1.0f, initialMatrix.getScalingFactorY());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    float[][] values = initialMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(306.0d, bounds.getCenterX());
    assertEquals(396.0d, bounds.getCenterY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(612, bounds.width);
    assertEquals(612.0d, size.getWidth());
    assertEquals(612.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792, bounds.height);
    assertEquals(792.0d, size.getHeight());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(bounds.isEmpty());
    assertFalse(currentClippingPath.isEmpty());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(graphicsState.isAlphaSource());
    assertFalse(graphicsState.isNonStrokingOverprint());
    assertFalse(graphicsState.isOverprint());
    assertFalse(graphicsState.isStrokeAdjustment());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertEquals(initialMatrix, graphicsState.getCurrentTransformationMatrix());
    assertSame(page, customGraphicsStreamEngine.getCurrentPage());
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  void testRun2() throws IOException {
    // Arrange
    PDPage page = new PDPage(new COSDictionary());
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    Composite nonStrokingJavaComposite = graphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getCurrentPoint() instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = graphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(graphicsState.getTransfer());
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(getResult2.getKey());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = graphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(graphicsState.getSoftMask());
    assertNull(graphicsState.getRenderingIntent());
    assertNull(customGraphicsStreamEngine.getTextLineMatrix());
    assertNull(customGraphicsStreamEngine.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, graphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    Matrix initialMatrix = customGraphicsStreamEngine.getInitialMatrix();
    assertEquals(0.0f, initialMatrix.getShearX());
    assertEquals(0.0f, initialMatrix.getShearY());
    assertEquals(0.0f, initialMatrix.getTranslateX());
    assertEquals(0.0f, initialMatrix.getTranslateY());
    assertEquals(1, getResult.getWindingRule());
    assertEquals(1, customGraphicsStreamEngine.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(1.0f, initialMatrix.getScaleX());
    assertEquals(1.0f, initialMatrix.getScaleY());
    assertEquals(1.0f, initialMatrix.getScalingFactorX());
    assertEquals(1.0f, initialMatrix.getScalingFactorY());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    float[][] values = initialMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(306.0d, bounds.getCenterX());
    assertEquals(396.0d, bounds.getCenterY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(612, bounds.width);
    assertEquals(612.0d, size.getWidth());
    assertEquals(612.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792, bounds.height);
    assertEquals(792.0d, size.getHeight());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(bounds.isEmpty());
    assertFalse(currentClippingPath.isEmpty());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(graphicsState.isAlphaSource());
    assertFalse(graphicsState.isNonStrokingOverprint());
    assertFalse(graphicsState.isOverprint());
    assertFalse(graphicsState.isStrokeAdjustment());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertEquals(initialMatrix, graphicsState.getCurrentTransformationMatrix());
    assertSame(page, customGraphicsStreamEngine.getCurrentPage());
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  void testRun3() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle());
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    Composite nonStrokingJavaComposite = graphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getCurrentPoint() instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = graphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(graphicsState.getTransfer());
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(getResult2.getKey());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = graphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(graphicsState.getSoftMask());
    assertNull(graphicsState.getRenderingIntent());
    assertNull(customGraphicsStreamEngine.getTextLineMatrix());
    assertNull(customGraphicsStreamEngine.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, graphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    Matrix initialMatrix = customGraphicsStreamEngine.getInitialMatrix();
    assertEquals(0.0f, initialMatrix.getShearX());
    assertEquals(0.0f, initialMatrix.getShearY());
    assertEquals(0.0f, initialMatrix.getTranslateX());
    assertEquals(0.0f, initialMatrix.getTranslateY());
    assertEquals(1, getResult.getWindingRule());
    assertEquals(1, customGraphicsStreamEngine.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(1.0f, initialMatrix.getScaleX());
    assertEquals(1.0f, initialMatrix.getScaleY());
    assertEquals(1.0f, initialMatrix.getScalingFactorX());
    assertEquals(1.0f, initialMatrix.getScalingFactorY());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    float[][] values = initialMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(graphicsState.isAlphaSource());
    assertFalse(graphicsState.isNonStrokingOverprint());
    assertFalse(graphicsState.isOverprint());
    assertFalse(graphicsState.isStrokeAdjustment());
    assertTrue(bounds.isEmpty());
    assertTrue(currentClippingPath.isEmpty());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertEquals(initialMatrix, graphicsState.getCurrentTransformationMatrix());
    assertSame(page, customGraphicsStreamEngine.getCurrentPage());
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  void testRun4() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    Composite nonStrokingJavaComposite = graphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getCurrentPoint() instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = graphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(graphicsState.getTransfer());
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(getResult2.getKey());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = graphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(graphicsState.getSoftMask());
    assertNull(graphicsState.getRenderingIntent());
    assertNull(customGraphicsStreamEngine.getTextLineMatrix());
    assertNull(customGraphicsStreamEngine.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, graphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    Matrix initialMatrix = customGraphicsStreamEngine.getInitialMatrix();
    assertEquals(0.0f, initialMatrix.getShearX());
    assertEquals(0.0f, initialMatrix.getShearY());
    assertEquals(0.0f, initialMatrix.getTranslateX());
    assertEquals(0.0f, initialMatrix.getTranslateY());
    assertEquals(1, getResult.getWindingRule());
    assertEquals(1, customGraphicsStreamEngine.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(1.0f, initialMatrix.getScaleX());
    assertEquals(1.0f, initialMatrix.getScaleY());
    assertEquals(1.0f, initialMatrix.getScalingFactorX());
    assertEquals(1.0f, initialMatrix.getScalingFactorY());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    float[][] values = initialMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(306.0d, bounds.getCenterX());
    assertEquals(396.0d, bounds.getCenterY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(612, bounds.width);
    assertEquals(612.0d, size.getWidth());
    assertEquals(612.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792, bounds.height);
    assertEquals(792.0d, size.getHeight());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(bounds.isEmpty());
    assertFalse(currentClippingPath.isEmpty());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(graphicsState.isAlphaSource());
    assertFalse(graphicsState.isNonStrokingOverprint());
    assertFalse(graphicsState.isOverprint());
    assertFalse(graphicsState.isStrokeAdjustment());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertEquals(initialMatrix, graphicsState.getCurrentTransformationMatrix());
    assertSame(page, customGraphicsStreamEngine.getCurrentPage());
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  void testRun5() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    ArrayList<PDStream> contents = new ArrayList<>();
    page.setContents(contents);
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    Composite nonStrokingJavaComposite = graphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getCurrentPoint() instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult3 = toListResult.get(1);
    assertTrue(getResult3 instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = graphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(graphicsState.getTransfer());
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(getResult3.getKey());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = graphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(graphicsState.getSoftMask());
    assertNull(graphicsState.getRenderingIntent());
    assertNull(customGraphicsStreamEngine.getTextLineMatrix());
    assertNull(customGraphicsStreamEngine.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, graphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    Matrix initialMatrix = customGraphicsStreamEngine.getInitialMatrix();
    assertEquals(0.0f, initialMatrix.getShearX());
    assertEquals(0.0f, initialMatrix.getShearY());
    assertEquals(0.0f, initialMatrix.getTranslateX());
    assertEquals(0.0f, initialMatrix.getTranslateY());
    assertEquals(1, getResult.getWindingRule());
    assertEquals(1, customGraphicsStreamEngine.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(1.0f, initialMatrix.getScaleX());
    assertEquals(1.0f, initialMatrix.getScaleY());
    assertEquals(1.0f, initialMatrix.getScalingFactorX());
    assertEquals(1.0f, initialMatrix.getScalingFactorY());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    float[][] values = initialMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(306.0d, bounds.getCenterX());
    assertEquals(396.0d, bounds.getCenterY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(612, bounds.width);
    assertEquals(612.0d, size.getWidth());
    assertEquals(612.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792, bounds.height);
    assertEquals(792.0d, size.getHeight());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(bounds.isEmpty());
    assertFalse(currentClippingPath.isEmpty());
    assertFalse(getResult3.isDirect());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(graphicsState.isAlphaSource());
    assertFalse(graphicsState.isNonStrokingOverprint());
    assertFalse(graphicsState.isOverprint());
    assertFalse(graphicsState.isStrokeAdjustment());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(((COSInteger) getResult3).isValid());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(contents, ((COSArray) getResult2).toList());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertEquals(initialMatrix, graphicsState.getCurrentTransformationMatrix());
    assertSame(page, customGraphicsStreamEngine.getCurrentPage());
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  void testRun6() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    page.setAnnotations(annotations);
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    Composite nonStrokingJavaComposite = graphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getCurrentPoint() instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult3 = toListResult.get(1);
    assertTrue(getResult3 instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = graphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(graphicsState.getTransfer());
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(getResult3.getKey());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = graphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(graphicsState.getSoftMask());
    assertNull(graphicsState.getRenderingIntent());
    assertNull(customGraphicsStreamEngine.getTextLineMatrix());
    assertNull(customGraphicsStreamEngine.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, graphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    Matrix initialMatrix = customGraphicsStreamEngine.getInitialMatrix();
    assertEquals(0.0f, initialMatrix.getShearX());
    assertEquals(0.0f, initialMatrix.getShearY());
    assertEquals(0.0f, initialMatrix.getTranslateX());
    assertEquals(0.0f, initialMatrix.getTranslateY());
    assertEquals(1, getResult.getWindingRule());
    assertEquals(1, customGraphicsStreamEngine.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(1.0f, initialMatrix.getScaleX());
    assertEquals(1.0f, initialMatrix.getScaleY());
    assertEquals(1.0f, initialMatrix.getScalingFactorX());
    assertEquals(1.0f, initialMatrix.getScalingFactorY());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    float[][] values = initialMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(306.0d, bounds.getCenterX());
    assertEquals(396.0d, bounds.getCenterY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(612, bounds.width);
    assertEquals(612.0d, size.getWidth());
    assertEquals(612.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792, bounds.height);
    assertEquals(792.0d, size.getHeight());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(bounds.isEmpty());
    assertFalse(currentClippingPath.isEmpty());
    assertFalse(getResult3.isDirect());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(graphicsState.isAlphaSource());
    assertFalse(graphicsState.isNonStrokingOverprint());
    assertFalse(graphicsState.isOverprint());
    assertFalse(graphicsState.isStrokeAdjustment());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(((COSInteger) getResult3).isValid());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(annotations, ((COSArray) getResult2).toList());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertEquals(initialMatrix, graphicsState.getCurrentTransformationMatrix());
    assertSame(page, customGraphicsStreamEngine.getCurrentPage());
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  void testRun7() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    Composite nonStrokingJavaComposite = graphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    Point2D currentPoint = getResult.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = graphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(graphicsState.getTransfer());
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(getResult2.getKey());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = graphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(graphicsState.getSoftMask());
    assertNull(graphicsState.getRenderingIntent());
    assertNull(customGraphicsStreamEngine.getTextLineMatrix());
    assertNull(customGraphicsStreamEngine.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    assertEquals(0.0d, graphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    Matrix initialMatrix = customGraphicsStreamEngine.getInitialMatrix();
    assertEquals(0.0f, initialMatrix.getShearX());
    assertEquals(0.0f, initialMatrix.getShearY());
    assertEquals(0.0f, initialMatrix.getTranslateX());
    assertEquals(0.0f, initialMatrix.getTranslateY());
    assertEquals(1, getResult.getWindingRule());
    assertEquals(1, customGraphicsStreamEngine.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.07374213E9d, bounds.getCenterX());
    assertEquals(1.07374222E9d, bounds.getCenterY());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(1.0f, initialMatrix.getScaleX());
    assertEquals(1.0f, initialMatrix.getScaleY());
    assertEquals(1.0f, initialMatrix.getScalingFactorX());
    assertEquals(1.0f, initialMatrix.getScalingFactorY());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    Dimension size = bounds.getSize();
    assertEquals(2.147482856E9d, size.getHeight());
    assertEquals(2.147482856E9d, bounds.getHeight());
    assertEquals(2.147483036E9d, size.getWidth());
    assertEquals(2.147483036E9d, bounds.getWidth());
    assertEquals(2.147483648E9d, currentPoint.getX());
    assertEquals(2.147483648E9d, currentPoint.getY());
    assertEquals(2.147483648E9d, bounds.getMaxX());
    assertEquals(2.147483648E9d, bounds.getMaxY());
    assertEquals(2147482856, size.height);
    assertEquals(2147482856, bounds.height);
    assertEquals(2147483036, size.width);
    assertEquals(2147483036, bounds.width);
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    float[][] values = initialMatrix.getValues();
    assertEquals(3, values.length);
    Point location = bounds.getLocation();
    assertEquals(612, location.x);
    assertEquals(612, bounds.x);
    assertEquals(612.0d, location.getX());
    assertEquals(612.0d, bounds.getX());
    assertEquals(612.0d, bounds.getMinX());
    assertEquals(792, location.y);
    assertEquals(792, bounds.y);
    assertEquals(792.0d, location.getY());
    assertEquals(792.0d, bounds.getY());
    assertEquals(792.0d, bounds.getMinY());
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(bounds.isEmpty());
    assertFalse(currentClippingPath.isEmpty());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(graphicsState.isAlphaSource());
    assertFalse(graphicsState.isNonStrokingOverprint());
    assertFalse(graphicsState.isOverprint());
    assertFalse(graphicsState.isStrokeAdjustment());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertEquals(initialMatrix, graphicsState.getCurrentTransformationMatrix());
    assertSame(page, customGraphicsStreamEngine.getCurrentPage());
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  void testRun8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(contents);
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    verify(streamCacheCreateFunction).create();
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    Composite nonStrokingJavaComposite = graphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getCurrentPoint() instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = graphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(graphicsState.getTransfer());
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(getResult2.getKey());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = graphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(graphicsState.getSoftMask());
    assertNull(graphicsState.getRenderingIntent());
    assertNull(customGraphicsStreamEngine.getTextLineMatrix());
    assertNull(customGraphicsStreamEngine.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, graphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    Matrix initialMatrix = customGraphicsStreamEngine.getInitialMatrix();
    assertEquals(0.0f, initialMatrix.getShearX());
    assertEquals(0.0f, initialMatrix.getShearY());
    assertEquals(0.0f, initialMatrix.getTranslateX());
    assertEquals(0.0f, initialMatrix.getTranslateY());
    assertEquals(1, getResult.getWindingRule());
    assertEquals(1, customGraphicsStreamEngine.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(1.0f, initialMatrix.getScaleX());
    assertEquals(1.0f, initialMatrix.getScaleY());
    assertEquals(1.0f, initialMatrix.getScalingFactorX());
    assertEquals(1.0f, initialMatrix.getScalingFactorY());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    float[][] values = initialMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(306.0d, bounds.getCenterX());
    assertEquals(396.0d, bounds.getCenterY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(612, bounds.width);
    assertEquals(612.0d, size.getWidth());
    assertEquals(612.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792, bounds.height);
    assertEquals(792.0d, size.getHeight());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(bounds.isEmpty());
    assertFalse(currentClippingPath.isEmpty());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(graphicsState.isAlphaSource());
    assertFalse(graphicsState.isNonStrokingOverprint());
    assertFalse(graphicsState.isOverprint());
    assertFalse(graphicsState.isStrokeAdjustment());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertEquals(initialMatrix, graphicsState.getCurrentTransformationMatrix());
    assertSame(page, customGraphicsStreamEngine.getCurrentPage());
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  void testRun9() throws IOException {
    // Arrange
    new IOException("Create InputStream called without data being written before to stream.");

    PDPage page = new PDPage();
    PDDocument doc = new PDDocument();
    page.setContents(new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    Composite nonStrokingJavaComposite = graphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getCurrentPoint() instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = graphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(graphicsState.getTransfer());
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(getResult2.getKey());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = graphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(graphicsState.getSoftMask());
    assertNull(graphicsState.getRenderingIntent());
    assertNull(customGraphicsStreamEngine.getTextLineMatrix());
    assertNull(customGraphicsStreamEngine.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, graphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    Matrix initialMatrix = customGraphicsStreamEngine.getInitialMatrix();
    assertEquals(0.0f, initialMatrix.getShearX());
    assertEquals(0.0f, initialMatrix.getShearY());
    assertEquals(0.0f, initialMatrix.getTranslateX());
    assertEquals(0.0f, initialMatrix.getTranslateY());
    assertEquals(1, getResult.getWindingRule());
    assertEquals(1, customGraphicsStreamEngine.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(1.0f, initialMatrix.getScaleX());
    assertEquals(1.0f, initialMatrix.getScaleY());
    assertEquals(1.0f, initialMatrix.getScalingFactorX());
    assertEquals(1.0f, initialMatrix.getScalingFactorY());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    float[][] values = initialMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(306.0d, bounds.getCenterX());
    assertEquals(396.0d, bounds.getCenterY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(612, bounds.width);
    assertEquals(612.0d, size.getWidth());
    assertEquals(612.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792, bounds.height);
    assertEquals(792.0d, size.getHeight());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(bounds.isEmpty());
    assertFalse(currentClippingPath.isEmpty());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(graphicsState.isAlphaSource());
    assertFalse(graphicsState.isNonStrokingOverprint());
    assertFalse(graphicsState.isOverprint());
    assertFalse(graphicsState.isStrokeAdjustment());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertEquals(initialMatrix, graphicsState.getCurrentTransformationMatrix());
    assertSame(page, customGraphicsStreamEngine.getCurrentPage());
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#drawImage(PDImage)}
   */
  @Test
  void testDrawImage() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(new PDPage());
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    customGraphicsStreamEngine.drawImage(new PDImageXObject(new PDDocument(streamCacheCreateFunction)));

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#clip(int)}
   */
  @Test
  void testClip() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    (new CustomGraphicsStreamEngine(page)).clip(1);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#getCurrentPoint()}
   */
  @Test
  void testGetCurrentPoint() throws IOException {
    // Arrange and Act
    Point2D actualCurrentPoint = (new CustomGraphicsStreamEngine(new PDPage())).getCurrentPoint();

    // Assert
    assertTrue(actualCurrentPoint instanceof Point2D.Float);
    assertEquals(0.0d, actualCurrentPoint.getX());
    assertEquals(0.0d, actualCurrentPoint.getY());
    assertEquals(0.0f, ((Point2D.Float) actualCurrentPoint).x);
    assertEquals(0.0f, ((Point2D.Float) actualCurrentPoint).y);
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#getCurrentPoint()}
   */
  @Test
  void testGetCurrentPoint2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    Point2D actualCurrentPoint = (new CustomGraphicsStreamEngine(page)).getCurrentPoint();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCurrentPoint instanceof Point2D.Float);
    assertEquals(0.0d, actualCurrentPoint.getX());
    assertEquals(0.0d, actualCurrentPoint.getY());
    assertEquals(0.0f, ((Point2D.Float) actualCurrentPoint).x);
    assertEquals(0.0f, ((Point2D.Float) actualCurrentPoint).y);
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#closePath()}
   */
  @Test
  void testClosePath() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    (new CustomGraphicsStreamEngine(page)).closePath();

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#endPath()}
   */
  @Test
  void testEndPath() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    (new CustomGraphicsStreamEngine(page)).endPath();

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#strokePath()}
   */
  @Test
  void testStrokePath() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    (new CustomGraphicsStreamEngine(page)).strokePath();

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#fillPath(int)}
   */
  @Test
  void testFillPath() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    (new CustomGraphicsStreamEngine(page)).fillPath(1);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link CustomGraphicsStreamEngine#fillAndStrokePath(int)}
   */
  @Test
  void testFillAndStrokePath() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    (new CustomGraphicsStreamEngine(page)).fillAndStrokePath(1);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  void testShowTextStrings() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(new PDPage());
    customGraphicsStreamEngine.processPage(new PDPage());
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSArray());

    COSArray array = new COSArray();
    array.add(object);

    // Act
    customGraphicsStreamEngine.showTextStrings(array);

    // Assert
    verify(object).getCOSObject();
  }

  /**
   * Method under test:
   * {@link CustomGraphicsStreamEngine#CustomGraphicsStreamEngine(PDPage)}
   */
  @Test
  void testNewCustomGraphicsStreamEngine() {
    // Arrange and Act
    CustomGraphicsStreamEngine actualCustomGraphicsStreamEngine = new CustomGraphicsStreamEngine(new PDPage());

    // Assert
    assertNull(actualCustomGraphicsStreamEngine.getCurrentPage());
    assertNull(actualCustomGraphicsStreamEngine.getResources());
    assertNull(actualCustomGraphicsStreamEngine.getInitialMatrix());
    assertEquals(0, actualCustomGraphicsStreamEngine.getLevel());
  }
}
