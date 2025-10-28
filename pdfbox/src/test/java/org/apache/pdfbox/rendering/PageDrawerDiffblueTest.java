package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileRGB;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDTransparencyGroup;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.pdmodel.interactive.annotation.AnnotationFilter;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PageDrawerDiffblueTest {
  /**
   * Method under test: {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}
   */
  @Test
  void testDrawPage() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));
    PDPage page = mock(PDPage.class);
    when(page.getContentsForStreamParsing()).thenThrow(new IOException("foo"));
    when(page.getResources()).thenReturn(new PDResources());
    when(page.getBBox()).thenReturn(PDRectangle.A0);
    when(page.hasContents()).thenReturn(true);
    when(page.getMatrix()).thenReturn(new Matrix());
    when(page.getCropBox()).thenReturn(PDRectangle.A0);
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, page, true, RenderDestination.EXPORT, null, 10.0f));
    GroupGraphics g = mock(GroupGraphics.class);
    when(g.getClip()).thenReturn(new Polygon());
    doNothing().when(g).addRenderingHints(Mockito.<Map<Object, Object>>any());
    doNothing().when(g).scale(anyDouble(), anyDouble());
    doNothing().when(g).translate(anyDouble(), anyDouble());
    when(g.getTransform()).thenReturn(new AffineTransform());

    // Act and Assert
    assertThrows(IOException.class, () -> pageDrawer.drawPage(g, PDRectangle.A0));
    verify(streamCacheCreateFunction).create();
    verify(page).getBBox();
    verify(page).getContentsForStreamParsing();
    verify(page).getCropBox();
    verify(page, atLeast(1)).getMatrix();
    verify(page).getResources();
    verify(page).hasContents();
    verify(g).addRenderingHints((Map<?, ?>) isNull());
    verify(g).getClip();
    verify(g).getTransform();
    verify(g).scale(eq(1.0d), eq(-1.0d));
    verify(g, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Method under test:
   * {@link PageDrawer#drawTilingPattern(Graphics2D, PDTilingPattern, PDColorSpace, PDColor, Matrix)}
   */
  @Test
  void testDrawTilingPattern() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    GroupGraphics g = mock(GroupGraphics.class);
    doNothing().when(g).addRenderingHints(Mockito.<Map<Object, Object>>any());
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getContentsForStreamParsing())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getResources()).thenReturn(new PDResources());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    pageDrawer.drawTilingPattern(g, pattern, PDDeviceGray.INSTANCE, color, new Matrix());

    // Assert
    verify(pattern).getContentsForStreamParsing();
    verify(streamCacheCreateFunction).create();
    verify(pattern).getBBox();
    verify(pattern).getResources();
    verify(g).addRenderingHints((Map<?, ?>) isNull());
  }

  /**
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  void testGetPaint() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    assertTrue(actualPaint instanceof Color);
    assertEquals(((Color) actualPaint).black, actualPaint);
  }

  /**
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  void testGetPaint2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualPaint instanceof Color);
    assertEquals(((Color) actualPaint).black, actualPaint);
  }

  /**
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  void testGetPaint3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(new COSArray(), null));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualPaint instanceof Color);
    ColorSpace colorSpace = ((Color) actualPaint).getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    byte[] data = profile.getData();
    assertEquals((byte) -102, data[6867]);
    assertEquals((byte) -103, data[6866]);
    assertEquals((byte) -36, data[3]);
    assertEquals((byte) -41, data[6855]);
    assertEquals((byte) -51, data[6863]);
    assertEquals((byte) -93, data[6854]);
    Color brighterResult = ((Color) actualPaint).brighter();
    Color brighterResult2 = brighterResult.brighter();
    Color brighterResult3 = brighterResult2.brighter();
    Color brighterResult4 = brighterResult3.brighter();
    Color brighterResult5 = brighterResult4.brighter();
    Color brighterResult6 = brighterResult5.brighter();
    assertEquals(0, brighterResult6.getAlpha());
    assertEquals(0, brighterResult5.getAlpha());
    assertEquals(0, brighterResult4.getAlpha());
    assertEquals(0, brighterResult3.getAlpha());
    assertEquals(0, brighterResult2.getAlpha());
    assertEquals(0, brighterResult.getAlpha());
    Color darkerResult = brighterResult.darker();
    assertEquals(0, darkerResult.getAlpha());
    Color darkerResult2 = darkerResult.darker();
    assertEquals(0, darkerResult2.getAlpha());
    assertEquals(0, ((Color) actualPaint).getAlpha());
    assertEquals(0, ((Color) actualPaint).getBlue());
    assertEquals(0, ((Color) actualPaint).getGreen());
    assertEquals(0, ((Color) actualPaint).getRGB());
    assertEquals(0, ((Color) actualPaint).getRed());
    assertEquals(0, profile.getPCSType());
    assertEquals((byte) 0, data[0]);
    assertEquals((byte) 0, data[1]);
    assertEquals((byte) 0, data[10]);
    assertEquals((byte) 0, data[11]);
    assertEquals((byte) 0, data[6851]);
    assertEquals((byte) 0, data[6852]);
    assertEquals((byte) 0, data[6853]);
    assertEquals((byte) 0, data[6856]);
    assertEquals((byte) 0, data[6857]);
    assertEquals((byte) 0, data[6860]);
    assertEquals((byte) 0, data[6861]);
    assertEquals((byte) 0, data[6864]);
    assertEquals((byte) 0, data[6865]);
    assertEquals((byte) 0, data[6868]);
    assertEquals((byte) 0, data[6869]);
    assertEquals((byte) 0, data[6872]);
    assertEquals((byte) 0, data[6873]);
    assertEquals(1, darkerResult2.getBlue());
    assertEquals(1, darkerResult2.getGreen());
    assertEquals(1, darkerResult2.getRed());
    assertEquals(1, profile.getProfileClass());
    assertEquals(10, brighterResult5.getBlue());
    assertEquals(10, brighterResult5.getGreen());
    assertEquals(10, brighterResult5.getRed());
    assertEquals(131586, darkerResult.getRGB());
    assertEquals(14, brighterResult6.getBlue());
    assertEquals(14, brighterResult6.getGreen());
    assertEquals(14, brighterResult6.getRed());
    assertEquals((byte) 15, data[6874]);
    assertEquals(197379, brighterResult.getRGB());
    assertEquals(2, darkerResult.getBlue());
    assertEquals(2, darkerResult.getGreen());
    assertEquals(2, darkerResult.getRed());
    assertEquals(2, brighterResult6.getTransparency());
    assertEquals(2, brighterResult5.getTransparency());
    assertEquals(2, brighterResult4.getTransparency());
    assertEquals(2, brighterResult3.getTransparency());
    assertEquals(2, brighterResult2.getTransparency());
    assertEquals(2, brighterResult.getTransparency());
    assertEquals(2, darkerResult.getTransparency());
    assertEquals(2, darkerResult2.getTransparency());
    assertEquals(2, actualPaint.getTransparency());
    assertEquals(2, profile.getMajorVersion());
    assertEquals(263172, brighterResult2.getRGB());
    assertEquals((byte) 26, data[2]);
    assertEquals((byte) 2, data[8]);
    assertEquals(3, brighterResult.getBlue());
    assertEquals(3, brighterResult.getGreen());
    assertEquals(3, brighterResult.getRed());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, profile.getNumComponents());
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertEquals(328965, brighterResult3.getRGB());
    assertEquals(4, brighterResult2.getBlue());
    assertEquals(4, brighterResult2.getGreen());
    assertEquals(4, brighterResult2.getRed());
    assertEquals(460551, brighterResult4.getRGB());
    assertEquals(48, profile.getMinorVersion());
    assertEquals(5, brighterResult3.getBlue());
    assertEquals(5, brighterResult3.getGreen());
    assertEquals(5, brighterResult3.getRed());
    assertEquals(5, colorSpace.getType());
    assertEquals(5, profile.getColorSpaceType());
    assertEquals(65793, darkerResult2.getRGB());
    assertEquals(657930, brighterResult5.getRGB());
    assertEquals(6876, data.length);
    assertEquals(7, brighterResult4.getBlue());
    assertEquals(7, brighterResult4.getGreen());
    assertEquals(7, brighterResult4.getRed());
    assertEquals((byte) 7, data[24]);
    assertEquals(921102, brighterResult6.getRGB());
    assertTrue(colorSpace.isCS_sRGB());
    assertEquals(brighterResult2.darker(), brighterResult2.darker());
    assertEquals(actualPaint, darkerResult2.darker());
    assertEquals(actualPaint, ((Color) actualPaint).darker());
    assertEquals(' ', data[19]);
    assertEquals(' ', data[23]);
    assertEquals('&', data[6870]);
    assertEquals('0', data[9]);
    assertEquals('B', data[18]);
    assertEquals('G', data[17]);
    assertEquals('L', data[6862]);
    assertEquals('R', data[Short.SIZE]);
    assertEquals('T', data[6858]);
    assertEquals('X', data[20]);
    assertEquals('Y', data[21]);
    assertEquals('Z', data[22]);
    assertEquals('\\', data[6875]);
    assertEquals('c', data[5]);
    assertEquals('f', data[6871]);
    assertEquals('l', data[4]);
    assertEquals('m', data[12]);
    assertEquals('m', data[6]);
    assertEquals('n', data[13]);
    assertEquals('r', data[15]);
    assertEquals('s', data[7]);
    assertEquals('t', data[14]);
    assertEquals('{', data[6859]);
    assertSame(colorSpace, brighterResult6.getColorSpace());
    assertSame(colorSpace, brighterResult5.getColorSpace());
    assertSame(colorSpace, brighterResult4.getColorSpace());
    assertSame(colorSpace, brighterResult3.getColorSpace());
    assertSame(colorSpace, brighterResult2.getColorSpace());
    assertSame(colorSpace, brighterResult.getColorSpace());
    assertSame(colorSpace, darkerResult.getColorSpace());
    assertSame(colorSpace, darkerResult2.getColorSpace());
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
  }

  /**
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  void testGetPaint4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    COSArray array = new COSArray();

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(array, new PDCalGray()));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualPaint instanceof Color);
    assertEquals(((Color) actualPaint).black, actualPaint);
  }

  /**
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  void testGetPaint5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    COSArray array = new COSArray();

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(array, new PDCalRGB()));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualPaint instanceof Color);
    assertEquals(((Color) actualPaint).black, actualPaint);
  }

  /**
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  void testGetPaint6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    COSArray array = new COSArray();

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(array, new PDLab()));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualPaint instanceof Color);
    assertEquals(((Color) actualPaint).black, actualPaint);
  }

  /**
   * Method under test: {@link PageDrawer#transferClip(Graphics2D)}
   */
  @Test
  void testTransferClip() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    GroupGraphics graphics = mock(GroupGraphics.class);
    doNothing().when(graphics).addRenderingHints(Mockito.<Map<Object, Object>>any());
    doNothing().when(graphics).setClip(Mockito.<Shape>any());
    graphics.addRenderingHints(new HashMap<>());

    // Act
    pageDrawer.transferClip(graphics);

    // Assert
    verify(streamCacheCreateFunction).create();
    verify(graphics).addRenderingHints(isA(Map.class));
    verify(graphics).setClip(isA(Shape.class));
  }

  /**
   * Method under test: {@link PageDrawer#endText()}
   */
  @Test
  void testEndText() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());

    // Act
    pageDrawer.endText();

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PageDrawer#showFontGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  void testShowFontGlyph() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    Matrix textRenderingMatrix = new Matrix();
    PDMMType1Font font = mock(PDMMType1Font.class);
    when(font.getNormalizedPath(anyInt())).thenReturn(null);
    when(font.hasGlyph(anyInt())).thenReturn(true);
    when(font.getFontMatrix()).thenReturn(new Matrix());

    // Act
    pageDrawer.showFontGlyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert
    verify(streamCacheCreateFunction).create();
    verify(font).getFontMatrix();
    verify(font).getNormalizedPath(eq(1));
    verify(font).hasGlyph(eq(1));
  }

  /**
   * Method under test:
   * {@link PageDrawer#showType3Glyph(Matrix, PDType3Font, int, Vector)}
   */
  @Test
  void testShowType3Glyph() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    Matrix textRenderingMatrix = new Matrix();
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act
    pageDrawer.showType3Glyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PageDrawer#appendRectangle(Point2D, Point2D, Point2D, Point2D)}
   */
  @Test
  void testAppendRectangle() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    Point p0 = new Point(1, 1);

    Point p1 = new Point(1, 1);

    Point p2 = new Point(1, 1);

    // Act
    pageDrawer.appendRectangle(p0, p1, p2, new Point(1, 1));

    // Assert that nothing has changed
    GeneralPath linePath = pageDrawer.getLinePath();
    Rectangle bounds = linePath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = linePath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = linePath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertEquals(1, bounds.x);
    assertEquals(1, bounds.y);
    assertEquals(1.0d, bounds.getX());
    assertEquals(1.0d, bounds.getY());
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(1.0d, bounds.getCenterY());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(1.0d, bounds.getMinX());
    assertEquals(1.0d, bounds.getMinY());
    assertEquals(p0, bounds.getLocation());
    assertEquals(p0, currentPoint);
    assertEquals(p0, currentPoint2);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test:
   * {@link PageDrawer#appendRectangle(Point2D, Point2D, Point2D, Point2D)}
   */
  @Test
  void testAppendRectangle2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    Point p0 = new Point(1, 1);

    Point p1 = new Point(1, 1);

    Point p2 = new Point(1, 1);

    // Act
    pageDrawer.appendRectangle(p0, p1, p2, new Point(1, 1));

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    GeneralPath linePath = pageDrawer.getLinePath();
    Rectangle bounds = linePath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = linePath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = linePath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertEquals(1, bounds.x);
    assertEquals(1, bounds.y);
    assertEquals(1.0d, bounds.getX());
    assertEquals(1.0d, bounds.getY());
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(1.0d, bounds.getCenterY());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(1.0d, bounds.getMinX());
    assertEquals(1.0d, bounds.getMinY());
    assertEquals(p0, bounds.getLocation());
    assertEquals(p0, currentPoint);
    assertEquals(p0, currentPoint2);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PageDrawer#getNonStrokingPaint()}
   */
  @Test
  void testGetNonStrokingPaint() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());

    // Act
    Paint actualNonStrokingPaint = pageDrawer.getNonStrokingPaint();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualNonStrokingPaint instanceof Color);
    assertEquals(((Color) actualNonStrokingPaint).black, actualNonStrokingPaint);
  }

  /**
   * Method under test: {@link PageDrawer#moveTo(float, float)}
   */
  @Test
  void testMoveTo() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Act
    pageDrawer.moveTo(10.0f, 10.0f);

    // Assert that nothing has changed
    GeneralPath linePath = pageDrawer.getLinePath();
    Rectangle bounds = linePath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = linePath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = linePath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertEquals(10, bounds.x);
    assertEquals(10, bounds.y);
    assertEquals(10.0d, bounds.getX());
    assertEquals(10.0d, bounds.getY());
    assertEquals(10.0d, currentPoint2.getX());
    assertEquals(10.0d, currentPoint2.getY());
    assertEquals(10.0d, bounds.getCenterX());
    assertEquals(10.0d, bounds.getCenterY());
    assertEquals(10.0d, bounds.getMaxX());
    assertEquals(10.0d, bounds.getMaxY());
    assertEquals(10.0d, bounds.getMinX());
    assertEquals(10.0d, bounds.getMinY());
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).x);
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).y);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(currentPoint2, bounds.getLocation());
    assertEquals(currentPoint2, currentPoint);
  }

  /**
   * Method under test: {@link PageDrawer#moveTo(float, float)}
   */
  @Test
  void testMoveTo2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Act
    pageDrawer.moveTo(10.0f, 10.0f);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    GeneralPath linePath = pageDrawer.getLinePath();
    Rectangle bounds = linePath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = linePath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = linePath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertEquals(10, bounds.x);
    assertEquals(10, bounds.y);
    assertEquals(10.0d, bounds.getX());
    assertEquals(10.0d, bounds.getY());
    assertEquals(10.0d, currentPoint2.getX());
    assertEquals(10.0d, currentPoint2.getY());
    assertEquals(10.0d, bounds.getCenterX());
    assertEquals(10.0d, bounds.getCenterY());
    assertEquals(10.0d, bounds.getMaxX());
    assertEquals(10.0d, bounds.getMaxY());
    assertEquals(10.0d, bounds.getMinX());
    assertEquals(10.0d, bounds.getMinY());
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).x);
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).y);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(currentPoint2, bounds.getLocation());
    assertEquals(currentPoint2, currentPoint);
  }

  /**
   * Method under test: {@link PageDrawer#lineTo(float, float)}
   */
  @Test
  void testLineTo() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    Point p0 = new Point(1, 1);

    Point p1 = new Point(1, 1);

    Point p2 = new Point(1, 1);

    pageDrawer.appendRectangle(p0, p1, p2, new Point(1, 1));

    // Act
    pageDrawer.lineTo(10.0f, 10.0f);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    GeneralPath linePath = pageDrawer.getLinePath();
    Rectangle bounds = linePath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = linePath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = linePath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertEquals(10.0d, currentPoint2.getX());
    assertEquals(10.0d, currentPoint2.getY());
    assertEquals(10.0d, bounds.getMaxX());
    assertEquals(10.0d, bounds.getMaxY());
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).x);
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).y);
    assertEquals(5.5d, bounds.getCenterX());
    assertEquals(5.5d, bounds.getCenterY());
    Dimension size = bounds.getSize();
    assertEquals(9, size.height);
    assertEquals(9, size.width);
    assertEquals(9, bounds.height);
    assertEquals(9, bounds.width);
    assertEquals(9.0d, size.getHeight());
    assertEquals(9.0d, size.getWidth());
    assertEquals(9.0d, bounds.getHeight());
    assertEquals(9.0d, bounds.getWidth());
    assertFalse(bounds.isEmpty());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(currentPoint2, currentPoint);
  }

  /**
   * Method under test:
   * {@link PageDrawer#curveTo(float, float, float, float, float, float)}
   */
  @Test
  void testCurveTo() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    Point p0 = new Point(1, 1);

    Point p1 = new Point(1, 1);

    Point p2 = new Point(1, 1);

    pageDrawer.appendRectangle(p0, p1, p2, new Point(1, 1));

    // Act
    pageDrawer.curveTo(10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    GeneralPath linePath = pageDrawer.getLinePath();
    Rectangle bounds = linePath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = linePath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = linePath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertEquals(10.0d, currentPoint2.getX());
    assertEquals(10.0d, currentPoint2.getY());
    assertEquals(10.0d, bounds.getMaxX());
    assertEquals(10.0d, bounds.getMaxY());
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).x);
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).y);
    assertEquals(5.5d, bounds.getCenterX());
    assertEquals(5.5d, bounds.getCenterY());
    Dimension size = bounds.getSize();
    assertEquals(9, size.height);
    assertEquals(9, size.width);
    assertEquals(9, bounds.height);
    assertEquals(9, bounds.width);
    assertEquals(9.0d, size.getHeight());
    assertEquals(9.0d, size.getWidth());
    assertEquals(9.0d, bounds.getHeight());
    assertEquals(9.0d, bounds.getWidth());
    assertFalse(bounds.isEmpty());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(currentPoint2, currentPoint);
  }

  /**
   * Method under test: {@link PageDrawer#getCurrentPoint()}
   */
  @Test
  void testGetCurrentPoint() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    // Act and Assert
    assertNull(
        (new PageDrawer(new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f)))
            .getCurrentPoint());
  }

  /**
   * Method under test: {@link PageDrawer#getCurrentPoint()}
   */
  @Test
  void testGetCurrentPoint2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    // Act
    Point2D actualCurrentPoint = (new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f)))
            .getCurrentPoint();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCurrentPoint);
  }

  /**
   * Method under test: {@link PageDrawer#closePath()}
   */
  @Test
  void testClosePath() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    Point p0 = new Point(1, 1);

    Point p1 = new Point(1, 1);

    Point p2 = new Point(1, 1);

    pageDrawer.appendRectangle(p0, p1, p2, new Point(1, 1));

    // Act
    pageDrawer.closePath();

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PageDrawer#endPath()}
   */
  @Test
  void testEndPath() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    // Act
    (new PageDrawer(new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f)))
        .endPath();

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PageDrawer#endPath()}
   */
  @Test
  void testEndPath2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException("foo"));
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.clip(1);

    // Act
    pageDrawer.endPath();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PageDrawer#showForm(PDFormXObject)}
   */
  @Test
  void testShowForm() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());

    // Act
    pageDrawer.showForm(new PDFormXObject(new COSStream()));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  void testShowTransparencyGroup() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());

    // Act
    pageDrawer.showTransparencyGroup(new PDTransparencyGroup(new PDDocument()));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  void testShowTransparencyGroupOnGraphics() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDTransparencyGroup form = new PDTransparencyGroup(new PDDocument());

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, new GroupGraphics(new BufferedImage(1, 1, 1), null));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PageDrawer#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  void testBeginMarkedContentSequence() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Act
    pageDrawer.beginMarkedContentSequence(COSName.A, new COSDictionary());

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PageDrawer#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  void testBeginMarkedContentSequence2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Act
    pageDrawer.beginMarkedContentSequence(null, new COSDictionary());

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PageDrawer#endMarkedContentSequence()}
   */
  @Test
  void testEndMarkedContentSequence() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    // Act
    (new PageDrawer(new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f)))
        .endMarkedContentSequence();

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageDrawer#clip(int)}
   *   <li>{@link PageDrawer#setAnnotationFilter(AnnotationFilter)}
   *   <li>{@link PageDrawer#getAnnotationFilter()}
   *   <li>{@link PageDrawer#getGraphics()}
   *   <li>{@link PageDrawer#getLinePath()}
   *   <li>{@link PageDrawer#getRenderer()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Act
    pageDrawer.clip(1);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    pageDrawer.setAnnotationFilter(annotationFilter);
    AnnotationFilter actualAnnotationFilter = pageDrawer.getAnnotationFilter();
    pageDrawer.getGraphics();
    GeneralPath actualLinePath = pageDrawer.getLinePath();
    PDFRenderer actualRenderer = pageDrawer.getRenderer();

    // Assert that nothing has changed
    Rectangle bounds = actualLinePath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualLinePath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
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
    assertEquals(1, actualLinePath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertSame(renderer, actualRenderer);
    assertSame(annotationFilter, actualAnnotationFilter);
  }

  /**
   * Method under test: {@link PageDrawer#PageDrawer(PageDrawerParameters)}
   */
  @Test
  void testNewPageDrawer() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    // Act
    PageDrawer actualPageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Assert
    GeneralPath linePath = actualPageDrawer.getLinePath();
    Rectangle bounds = linePath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = linePath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPageDrawer.getGraphics());
    assertNull(linePath.getCurrentPoint());
    assertNull(actualPageDrawer.getCurrentPoint());
    assertNull(actualPageDrawer.getCurrentPage());
    assertNull(actualPageDrawer.getResources());
    assertNull(actualPageDrawer.getGraphicsState());
    assertNull(actualPageDrawer.getInitialMatrix());
    assertEquals(0, actualPageDrawer.getGraphicsStackSize());
    assertEquals(0, actualPageDrawer.getLevel());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
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
    assertEquals(1, linePath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertSame(renderer, actualPageDrawer.getRenderer());
  }

  /**
   * Method under test: {@link PageDrawer#PageDrawer(PageDrawerParameters)}
   */
  @Test
  void testNewPageDrawer2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    // Act
    PageDrawer actualPageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Assert
    verify(streamCacheCreateFunction).create();
    GeneralPath linePath = actualPageDrawer.getLinePath();
    Rectangle bounds = linePath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = linePath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPageDrawer.getGraphics());
    assertNull(linePath.getCurrentPoint());
    assertNull(actualPageDrawer.getCurrentPoint());
    assertNull(actualPageDrawer.getCurrentPage());
    assertNull(actualPageDrawer.getResources());
    assertNull(actualPageDrawer.getGraphicsState());
    assertNull(actualPageDrawer.getInitialMatrix());
    assertEquals(0, actualPageDrawer.getGraphicsStackSize());
    assertEquals(0, actualPageDrawer.getLevel());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
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
    assertEquals(1, linePath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertSame(renderer, actualPageDrawer.getRenderer());
  }
}
