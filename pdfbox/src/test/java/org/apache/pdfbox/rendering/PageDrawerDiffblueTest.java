package org.apache.pdfbox.rendering;

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
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDTransparencyGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentMembershipDictionary;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.pdmodel.interactive.annotation.AnnotationFilter;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PageDrawerDiffblueTest {
  /**
   * Test {@link PageDrawer#PageDrawer(PageDrawerParameters)}.
   * <p>
   * Method under test: {@link PageDrawer#PageDrawer(PageDrawerParameters)}
   */
  @Test
  @DisplayName("Test new PageDrawer(PageDrawerParameters)")
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
   * Test {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}
   */
  @Test
  @DisplayName("Test drawPage(Graphics2D, PDRectangle); then throw IOException")
  void testDrawPage_thenThrowIOException() throws IOException {
    // Arrange
    PDPage page = mock(PDPage.class);
    when(page.getContentsForStreamParsing()).thenThrow(new IOException("foo"));
    when(page.getResources()).thenReturn(new PDResources());
    when(page.getBBox()).thenReturn(PDRectangle.A0);
    when(page.hasContents()).thenReturn(true);
    when(page.getMatrix()).thenReturn(new Matrix());
    when(page.getCropBox()).thenReturn(PDRectangle.A0);
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(new PDFRenderer(new PDDocument()), page, true, RenderDestination.EXPORT, null, 10.0f));
    GroupGraphics g = mock(GroupGraphics.class);
    when(g.getClip()).thenReturn(new Polygon());
    doNothing().when(g).addRenderingHints(Mockito.<Map<Object, Object>>any());
    doNothing().when(g).scale(anyDouble(), anyDouble());
    doNothing().when(g).translate(anyDouble(), anyDouble());
    when(g.getTransform()).thenReturn(new AffineTransform());

    // Act and Assert
    assertThrows(IOException.class, () -> pageDrawer.drawPage(g, PDRectangle.A0));
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
   * Test
   * {@link PageDrawer#drawTilingPattern(Graphics2D, PDTilingPattern, PDColorSpace, PDColor, Matrix)}.
   * <ul>
   *   <li>Then calls {@link PDContentStream#getContentsForStreamParsing()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#drawTilingPattern(Graphics2D, PDTilingPattern, PDColorSpace, PDColor, Matrix)}
   */
  @Test
  @DisplayName("Test drawTilingPattern(Graphics2D, PDTilingPattern, PDColorSpace, PDColor, Matrix); then calls getContentsForStreamParsing()")
  void testDrawTilingPattern_thenCallsGetContentsForStreamParsing() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

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
    verify(pattern).getBBox();
    verify(pattern).getResources();
    verify(g).addRenderingHints((Map<?, ?>) isNull());
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   * <p>
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName("Test getPaint(PDColor)")
  void testGetPaint() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(new COSArray(), null));

    // Assert
    assertTrue(actualPaint instanceof Color);
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
    assertEquals(0, ((Color) actualPaint).getRGB());
    assertEquals(131586, darkerResult.getRGB());
    assertEquals(197379, brighterResult.getRGB());
    assertEquals(2, brighterResult6.getTransparency());
    assertEquals(2, brighterResult5.getTransparency());
    assertEquals(2, brighterResult4.getTransparency());
    assertEquals(2, brighterResult3.getTransparency());
    assertEquals(2, brighterResult2.getTransparency());
    assertEquals(2, brighterResult.getTransparency());
    assertEquals(2, darkerResult.getTransparency());
    assertEquals(2, darkerResult2.getTransparency());
    assertEquals(2, actualPaint.getTransparency());
    assertEquals(263172, brighterResult2.getRGB());
    assertEquals(328965, brighterResult3.getRGB());
    assertEquals(460551, brighterResult4.getRGB());
    assertEquals(65793, darkerResult2.getRGB());
    assertEquals(657930, brighterResult5.getRGB());
    assertEquals(921102, brighterResult6.getRGB());
    assertEquals(brighterResult2.darker(), brighterResult2.darker());
    assertEquals(actualPaint, darkerResult2.darker());
    assertEquals(actualPaint, ((Color) actualPaint).darker());
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is
   * {@link COSArray#COSArray()} and colorSpace is
   * {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName("Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is INSTANCE")
  void testGetPaint_whenPDColorWithArrayIsCOSArrayAndColorSpaceIsInstance() throws IOException {
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
   * Test {@link PageDrawer#getPaint(PDColor)}.
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is
   * {@link COSArray#COSArray()} and colorSpace is
   * {@link PDCalGray#PDCalGray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName("Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDCalGray()")
  void testGetPaint_whenPDColorWithArrayIsCOSArrayAndColorSpaceIsPDCalGray() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    COSArray array = new COSArray();

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(array, new PDCalGray()));

    // Assert
    assertTrue(actualPaint instanceof Color);
    assertEquals(((Color) actualPaint).black, actualPaint);
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is
   * {@link COSArray#COSArray()} and colorSpace is
   * {@link PDCalRGB#PDCalRGB()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName("Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDCalRGB()")
  void testGetPaint_whenPDColorWithArrayIsCOSArrayAndColorSpaceIsPDCalRGB() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    COSArray array = new COSArray();

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(array, new PDCalRGB()));

    // Assert
    assertTrue(actualPaint instanceof Color);
    assertEquals(((Color) actualPaint).black, actualPaint);
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is
   * {@link COSArray#COSArray()} and colorSpace is {@link PDLab#PDLab()}.</li>
   *   <li>Then return {@link Color#black}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName("Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDLab(); then return black")
  void testGetPaint_whenPDColorWithArrayIsCOSArrayAndColorSpaceIsPDLab_thenReturnBlack() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    COSArray array = new COSArray();

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(array, new PDLab()));

    // Assert
    assertTrue(actualPaint instanceof Color);
    assertEquals(((Color) actualPaint).black, actualPaint);
  }

  /**
   * Test {@link PageDrawer#transferClip(Graphics2D)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link GroupGraphics#addRenderingHints(Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#transferClip(Graphics2D)}
   */
  @Test
  @DisplayName("Test transferClip(Graphics2D); given HashMap(); then calls addRenderingHints(Map)")
  void testTransferClip_givenHashMap_thenCallsAddRenderingHints() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

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
    verify(graphics).addRenderingHints(isA(Map.class));
    verify(graphics).setClip(isA(Shape.class));
  }

  /**
   * Test {@link PageDrawer#showFontGlyph(Matrix, PDFont, int, Vector)}.
   * <ul>
   *   <li>Then calls {@link PDType1Font#getFontMatrix()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showFontGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName("Test showFontGlyph(Matrix, PDFont, int, Vector); then calls getFontMatrix()")
  void testShowFontGlyph_thenCallsGetFontMatrix() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

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
    verify(font).getFontMatrix();
    verify(font).getNormalizedPath(eq(1));
    verify(font).hasGlyph(eq(1));
  }

  /**
   * Test {@link PageDrawer#appendRectangle(Point2D, Point2D, Point2D, Point2D)}.
   * <p>
   * Method under test:
   * {@link PageDrawer#appendRectangle(Point2D, Point2D, Point2D, Point2D)}
   */
  @Test
  @DisplayName("Test appendRectangle(Point2D, Point2D, Point2D, Point2D)")
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
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D = bounds6.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds5.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds4.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds3.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = linePath.getBounds2D();
    Rectangle bounds7 = bounds2D5.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D6 = bounds9.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle bounds10 = bounds2D7.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle2D bounds2D8 = bounds11.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D bounds2D9 = bounds.getBounds2D();
    Rectangle bounds12 = bounds2D9.getBounds();
    Rectangle bounds13 = bounds12.getBounds();
    Rectangle2D bounds2D10 = bounds13.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D11 = bounds8.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    Rectangle bounds14 = frame.getBounds();
    Rectangle bounds15 = bounds14.getBounds();
    Rectangle2D bounds2D12 = bounds15.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D frame2 = bounds.getFrame();
    Rectangle bounds16 = frame2.getBounds();
    Rectangle bounds17 = bounds16.getBounds();
    Rectangle2D bounds2D13 = bounds17.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle bounds18 = bounds2D4.getBounds();
    Rectangle2D bounds2D14 = bounds18.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    Rectangle2D bounds2D15 = bounds10.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds12.getBounds2D();
    assertTrue(bounds2D16 instanceof Rectangle);
    Rectangle2D bounds2D17 = bounds7.getBounds2D();
    assertTrue(bounds2D17 instanceof Rectangle);
    Rectangle2D bounds2D18 = bounds2D5.getBounds2D();
    Rectangle bounds19 = bounds2D18.getBounds();
    Rectangle2D bounds2D19 = bounds19.getBounds2D();
    assertTrue(bounds2D19 instanceof Rectangle);
    Rectangle2D frame3 = bounds3.getFrame();
    Rectangle bounds20 = frame3.getBounds();
    Rectangle2D bounds2D20 = bounds20.getBounds2D();
    assertTrue(bounds2D20 instanceof Rectangle);
    Rectangle2D bounds2D21 = bounds14.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D bounds2D22 = bounds16.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D frame4 = bounds2D5.getFrame();
    Rectangle bounds21 = frame4.getBounds();
    Rectangle2D bounds2D23 = bounds21.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    Rectangle2D bounds2D24 = bounds2D3.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D4.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D7.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D9.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D17.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D26.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D27.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Point2D currentPoint = linePath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Point2D.Float);
    Rectangle2D bounds2D31 = frame.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D32 = frame2.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds4.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds2D7.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds2D9.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(frame4 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = bounds7.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Rectangle2D frame9 = frame.getFrame();
    assertTrue(frame9 instanceof Rectangle2D.Double);
    Rectangle2D frame10 = frame2.getFrame();
    assertTrue(frame10 instanceof Rectangle2D.Double);
    assertTrue(bounds2D5 instanceof Rectangle2D.Float);
    assertTrue(bounds2D18 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D33 = bounds2D18.getBounds2D();
    assertTrue(bounds2D33 instanceof Rectangle2D.Float);
    Rectangle bounds22 = bounds6.getBounds();
    assertEquals(1, bounds22.x);
    assertEquals(1, bounds6.x);
    assertEquals(1, bounds5.x);
    assertEquals(1, bounds4.x);
    Rectangle bounds23 = bounds9.getBounds();
    assertEquals(1, bounds23.x);
    assertEquals(1, bounds3.x);
    Rectangle bounds24 = bounds11.getBounds();
    assertEquals(1, bounds24.x);
    Rectangle bounds25 = bounds13.getBounds();
    assertEquals(1, bounds25.x);
    assertEquals(1, bounds9.x);
    Rectangle bounds26 = bounds15.getBounds();
    assertEquals(1, bounds26.x);
    Rectangle bounds27 = bounds17.getBounds();
    assertEquals(1, bounds27.x);
    assertEquals(1, bounds2.x);
    Rectangle bounds28 = bounds18.getBounds();
    assertEquals(1, bounds28.x);
    assertEquals(1, bounds11.x);
    assertEquals(1, bounds13.x);
    assertEquals(1, bounds8.x);
    Rectangle bounds29 = bounds19.getBounds();
    assertEquals(1, bounds29.x);
    Rectangle bounds30 = bounds20.getBounds();
    assertEquals(1, bounds30.x);
    assertEquals(1, bounds15.x);
    assertEquals(1, bounds17.x);
    Rectangle bounds31 = bounds21.getBounds();
    assertEquals(1, bounds31.x);
    assertEquals(1, bounds.x);
    Rectangle bounds32 = bounds2D3.getBounds();
    assertEquals(1, bounds32.x);
    assertEquals(1, bounds18.x);
    assertEquals(1, bounds10.x);
    assertEquals(1, bounds12.x);
    Rectangle bounds33 = bounds2D17.getBounds();
    assertEquals(1, bounds33.x);
    assertEquals(1, bounds7.x);
    Rectangle bounds34 = bounds2D26.getBounds();
    assertEquals(1, bounds34.x);
    Rectangle bounds35 = bounds2D27.getBounds();
    assertEquals(1, bounds35.x);
    assertEquals(1, bounds19.x);
    Rectangle bounds36 = bounds2D31.getBounds();
    assertEquals(1, bounds36.x);
    Rectangle bounds37 = bounds2D32.getBounds();
    assertEquals(1, bounds37.x);
    Rectangle bounds38 = frame5.getBounds();
    assertEquals(1, bounds38.x);
    assertEquals(1, bounds20.x);
    assertEquals(1, bounds14.x);
    Rectangle bounds39 = frame6.getBounds();
    assertEquals(1, bounds39.x);
    Rectangle bounds40 = frame7.getBounds();
    assertEquals(1, bounds40.x);
    assertEquals(1, bounds16.x);
    assertEquals(1, bounds21.x);
    Rectangle bounds41 = frame8.getBounds();
    assertEquals(1, bounds41.x);
    Rectangle bounds42 = frame9.getBounds();
    assertEquals(1, bounds42.x);
    Rectangle bounds43 = frame10.getBounds();
    assertEquals(1, bounds43.x);
    assertEquals(1, ((Rectangle) bounds2D).x);
    assertEquals(1, ((Rectangle) bounds2D2).x);
    assertEquals(1, ((Rectangle) bounds2D3).x);
    assertEquals(1, ((Rectangle) bounds2D4).x);
    assertEquals(1, ((Rectangle) bounds2D6).x);
    assertEquals(1, ((Rectangle) bounds2D7).x);
    assertEquals(1, ((Rectangle) bounds2D8).x);
    assertEquals(1, ((Rectangle) bounds2D10).x);
    assertEquals(1, ((Rectangle) bounds2D11).x);
    assertEquals(1, ((Rectangle) bounds2D12).x);
    assertEquals(1, ((Rectangle) bounds2D13).x);
    assertEquals(1, ((Rectangle) bounds2D9).x);
    assertEquals(1, ((Rectangle) bounds2D14).x);
    assertEquals(1, ((Rectangle) bounds2D15).x);
    assertEquals(1, ((Rectangle) bounds2D16).x);
    assertEquals(1, ((Rectangle) bounds2D17).x);
    assertEquals(1, ((Rectangle) bounds2D19).x);
    assertEquals(1, ((Rectangle) bounds2D20).x);
    assertEquals(1, ((Rectangle) bounds2D21).x);
    assertEquals(1, ((Rectangle) bounds2D22).x);
    assertEquals(1, ((Rectangle) bounds2D23).x);
    assertEquals(1, ((Rectangle) bounds2D24).x);
    assertEquals(1, ((Rectangle) bounds2D25).x);
    assertEquals(1, ((Rectangle) bounds2D26).x);
    assertEquals(1, ((Rectangle) bounds2D27).x);
    assertEquals(1, ((Rectangle) bounds2D28).x);
    assertEquals(1, ((Rectangle) bounds2D29).x);
    assertEquals(1, ((Rectangle) bounds2D30).x);
    assertEquals(1, bounds22.y);
    assertEquals(1, bounds6.y);
    assertEquals(1, bounds5.y);
    assertEquals(1, bounds4.y);
    assertEquals(1, bounds23.y);
    assertEquals(1, bounds3.y);
    assertEquals(1, bounds24.y);
    assertEquals(1, bounds25.y);
    assertEquals(1, bounds9.y);
    assertEquals(1, bounds26.y);
    assertEquals(1, bounds27.y);
    assertEquals(1, bounds2.y);
    assertEquals(1, bounds28.y);
    assertEquals(1, bounds11.y);
    assertEquals(1, bounds13.y);
    assertEquals(1, bounds8.y);
    assertEquals(1, bounds29.y);
    assertEquals(1, bounds30.y);
    assertEquals(1, bounds15.y);
    assertEquals(1, bounds17.y);
    assertEquals(1, bounds31.y);
    assertEquals(1, bounds.y);
    assertEquals(1, bounds32.y);
    assertEquals(1, bounds18.y);
    assertEquals(1, bounds10.y);
    assertEquals(1, bounds12.y);
    assertEquals(1, bounds33.y);
    assertEquals(1, bounds7.y);
    assertEquals(1, bounds34.y);
    assertEquals(1, bounds35.y);
    assertEquals(1, bounds19.y);
    assertEquals(1, bounds36.y);
    assertEquals(1, bounds37.y);
    assertEquals(1, bounds38.y);
    assertEquals(1, bounds20.y);
    assertEquals(1, bounds14.y);
    assertEquals(1, bounds39.y);
    assertEquals(1, bounds40.y);
    assertEquals(1, bounds16.y);
    assertEquals(1, bounds21.y);
    assertEquals(1, bounds41.y);
    assertEquals(1, bounds42.y);
    assertEquals(1, bounds43.y);
    assertEquals(1, ((Rectangle) bounds2D).y);
    assertEquals(1, ((Rectangle) bounds2D2).y);
    assertEquals(1, ((Rectangle) bounds2D3).y);
    assertEquals(1, ((Rectangle) bounds2D4).y);
    assertEquals(1, ((Rectangle) bounds2D6).y);
    assertEquals(1, ((Rectangle) bounds2D7).y);
    assertEquals(1, ((Rectangle) bounds2D8).y);
    assertEquals(1, ((Rectangle) bounds2D10).y);
    assertEquals(1, ((Rectangle) bounds2D11).y);
    assertEquals(1, ((Rectangle) bounds2D12).y);
    assertEquals(1, ((Rectangle) bounds2D13).y);
    assertEquals(1, ((Rectangle) bounds2D9).y);
    assertEquals(1, ((Rectangle) bounds2D14).y);
    assertEquals(1, ((Rectangle) bounds2D15).y);
    assertEquals(1, ((Rectangle) bounds2D16).y);
    assertEquals(1, ((Rectangle) bounds2D17).y);
    assertEquals(1, ((Rectangle) bounds2D19).y);
    assertEquals(1, ((Rectangle) bounds2D20).y);
    assertEquals(1, ((Rectangle) bounds2D21).y);
    assertEquals(1, ((Rectangle) bounds2D22).y);
    assertEquals(1, ((Rectangle) bounds2D23).y);
    assertEquals(1, ((Rectangle) bounds2D24).y);
    assertEquals(1, ((Rectangle) bounds2D25).y);
    assertEquals(1, ((Rectangle) bounds2D26).y);
    assertEquals(1, ((Rectangle) bounds2D27).y);
    assertEquals(1, ((Rectangle) bounds2D28).y);
    assertEquals(1, ((Rectangle) bounds2D29).y);
    assertEquals(1, ((Rectangle) bounds2D30).y);
    assertEquals(1.0d, bounds6.getX());
    assertEquals(1.0d, bounds5.getX());
    assertEquals(1.0d, bounds4.getX());
    assertEquals(1.0d, bounds3.getX());
    assertEquals(1.0d, bounds9.getX());
    assertEquals(1.0d, bounds2.getX());
    assertEquals(1.0d, bounds11.getX());
    assertEquals(1.0d, bounds13.getX());
    assertEquals(1.0d, bounds8.getX());
    assertEquals(1.0d, bounds15.getX());
    assertEquals(1.0d, bounds17.getX());
    assertEquals(1.0d, bounds.getX());
    assertEquals(1.0d, bounds18.getX());
    assertEquals(1.0d, bounds10.getX());
    assertEquals(1.0d, bounds12.getX());
    assertEquals(1.0d, bounds7.getX());
    assertEquals(1.0d, bounds19.getX());
    assertEquals(1.0d, bounds20.getX());
    assertEquals(1.0d, bounds14.getX());
    assertEquals(1.0d, bounds16.getX());
    assertEquals(1.0d, bounds21.getX());
    assertEquals(1.0d, bounds6.getY());
    assertEquals(1.0d, bounds5.getY());
    assertEquals(1.0d, bounds4.getY());
    assertEquals(1.0d, bounds3.getY());
    assertEquals(1.0d, bounds9.getY());
    assertEquals(1.0d, bounds2.getY());
    assertEquals(1.0d, bounds11.getY());
    assertEquals(1.0d, bounds13.getY());
    assertEquals(1.0d, bounds8.getY());
    assertEquals(1.0d, bounds15.getY());
    assertEquals(1.0d, bounds17.getY());
    assertEquals(1.0d, bounds.getY());
    assertEquals(1.0d, bounds18.getY());
    assertEquals(1.0d, bounds10.getY());
    assertEquals(1.0d, bounds12.getY());
    assertEquals(1.0d, bounds7.getY());
    assertEquals(1.0d, bounds19.getY());
    assertEquals(1.0d, bounds20.getY());
    assertEquals(1.0d, bounds14.getY());
    assertEquals(1.0d, bounds16.getY());
    assertEquals(1.0d, bounds21.getY());
    assertEquals(1.0d, bounds6.getCenterX());
    assertEquals(1.0d, bounds5.getCenterX());
    assertEquals(1.0d, bounds4.getCenterX());
    assertEquals(1.0d, bounds3.getCenterX());
    assertEquals(1.0d, bounds9.getCenterX());
    assertEquals(1.0d, bounds2.getCenterX());
    assertEquals(1.0d, bounds11.getCenterX());
    assertEquals(1.0d, bounds13.getCenterX());
    assertEquals(1.0d, bounds8.getCenterX());
    assertEquals(1.0d, bounds15.getCenterX());
    assertEquals(1.0d, bounds17.getCenterX());
    assertEquals(1.0d, bounds2D3.getCenterX());
    assertEquals(1.0d, bounds2D4.getCenterX());
    assertEquals(1.0d, bounds2D7.getCenterX());
    assertEquals(1.0d, bounds2D9.getCenterX());
    assertEquals(1.0d, bounds2D17.getCenterX());
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(1.0d, bounds2D5.getCenterX());
    assertEquals(1.0d, bounds2D26.getCenterX());
    assertEquals(1.0d, bounds2D27.getCenterX());
    assertEquals(1.0d, bounds2D18.getCenterX());
    assertEquals(1.0d, bounds2D31.getCenterX());
    assertEquals(1.0d, bounds2D32.getCenterX());
    assertEquals(1.0d, bounds18.getCenterX());
    assertEquals(1.0d, bounds10.getCenterX());
    assertEquals(1.0d, bounds12.getCenterX());
    assertEquals(1.0d, bounds7.getCenterX());
    assertEquals(1.0d, bounds19.getCenterX());
    assertEquals(1.0d, bounds20.getCenterX());
    assertEquals(1.0d, bounds14.getCenterX());
    assertEquals(1.0d, bounds16.getCenterX());
    assertEquals(1.0d, bounds21.getCenterX());
    assertEquals(1.0d, frame5.getCenterX());
    assertEquals(1.0d, frame3.getCenterX());
    assertEquals(1.0d, frame.getCenterX());
    assertEquals(1.0d, frame6.getCenterX());
    assertEquals(1.0d, frame7.getCenterX());
    assertEquals(1.0d, frame2.getCenterX());
    assertEquals(1.0d, frame4.getCenterX());
    assertEquals(1.0d, frame8.getCenterX());
    assertEquals(1.0d, frame9.getCenterX());
    assertEquals(1.0d, frame10.getCenterX());
    assertEquals(1.0d, bounds6.getCenterY());
    assertEquals(1.0d, bounds5.getCenterY());
    assertEquals(1.0d, bounds4.getCenterY());
    assertEquals(1.0d, bounds3.getCenterY());
    assertEquals(1.0d, bounds9.getCenterY());
    assertEquals(1.0d, bounds2.getCenterY());
    assertEquals(1.0d, bounds11.getCenterY());
    assertEquals(1.0d, bounds13.getCenterY());
    assertEquals(1.0d, bounds8.getCenterY());
    assertEquals(1.0d, bounds15.getCenterY());
    assertEquals(1.0d, bounds17.getCenterY());
    assertEquals(1.0d, bounds2D3.getCenterY());
    assertEquals(1.0d, bounds2D4.getCenterY());
    assertEquals(1.0d, bounds2D7.getCenterY());
    assertEquals(1.0d, bounds2D9.getCenterY());
    assertEquals(1.0d, bounds2D17.getCenterY());
    assertEquals(1.0d, bounds.getCenterY());
    assertEquals(1.0d, bounds2D5.getCenterY());
    assertEquals(1.0d, bounds2D26.getCenterY());
    assertEquals(1.0d, bounds2D27.getCenterY());
    assertEquals(1.0d, bounds2D18.getCenterY());
    assertEquals(1.0d, bounds2D31.getCenterY());
    assertEquals(1.0d, bounds2D32.getCenterY());
    assertEquals(1.0d, bounds18.getCenterY());
    assertEquals(1.0d, bounds10.getCenterY());
    assertEquals(1.0d, bounds12.getCenterY());
    assertEquals(1.0d, bounds7.getCenterY());
    assertEquals(1.0d, bounds19.getCenterY());
    assertEquals(1.0d, bounds20.getCenterY());
    assertEquals(1.0d, bounds14.getCenterY());
    assertEquals(1.0d, bounds16.getCenterY());
    assertEquals(1.0d, bounds21.getCenterY());
    assertEquals(1.0d, frame5.getCenterY());
    assertEquals(1.0d, frame3.getCenterY());
    assertEquals(1.0d, frame.getCenterY());
    assertEquals(1.0d, frame6.getCenterY());
    assertEquals(1.0d, frame7.getCenterY());
    assertEquals(1.0d, frame2.getCenterY());
    assertEquals(1.0d, frame4.getCenterY());
    assertEquals(1.0d, frame8.getCenterY());
    assertEquals(1.0d, frame9.getCenterY());
    assertEquals(1.0d, frame10.getCenterY());
    assertEquals(1.0d, bounds6.getMaxX());
    assertEquals(1.0d, bounds5.getMaxX());
    assertEquals(1.0d, bounds4.getMaxX());
    assertEquals(1.0d, bounds3.getMaxX());
    assertEquals(1.0d, bounds9.getMaxX());
    assertEquals(1.0d, bounds2.getMaxX());
    assertEquals(1.0d, bounds11.getMaxX());
    assertEquals(1.0d, bounds13.getMaxX());
    assertEquals(1.0d, bounds8.getMaxX());
    assertEquals(1.0d, bounds15.getMaxX());
    assertEquals(1.0d, bounds17.getMaxX());
    assertEquals(1.0d, bounds2D3.getMaxX());
    assertEquals(1.0d, bounds2D4.getMaxX());
    assertEquals(1.0d, bounds2D7.getMaxX());
    assertEquals(1.0d, bounds2D9.getMaxX());
    assertEquals(1.0d, bounds2D17.getMaxX());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds2D5.getMaxX());
    assertEquals(1.0d, bounds2D26.getMaxX());
    assertEquals(1.0d, bounds2D27.getMaxX());
    assertEquals(1.0d, bounds2D18.getMaxX());
    assertEquals(1.0d, bounds2D31.getMaxX());
    assertEquals(1.0d, bounds2D32.getMaxX());
    assertEquals(1.0d, bounds18.getMaxX());
    assertEquals(1.0d, bounds10.getMaxX());
    assertEquals(1.0d, bounds12.getMaxX());
    assertEquals(1.0d, bounds7.getMaxX());
    assertEquals(1.0d, bounds19.getMaxX());
    assertEquals(1.0d, bounds20.getMaxX());
    assertEquals(1.0d, bounds14.getMaxX());
    assertEquals(1.0d, bounds16.getMaxX());
    assertEquals(1.0d, bounds21.getMaxX());
    assertEquals(1.0d, frame5.getMaxX());
    assertEquals(1.0d, frame3.getMaxX());
    assertEquals(1.0d, frame.getMaxX());
    assertEquals(1.0d, frame6.getMaxX());
    assertEquals(1.0d, frame7.getMaxX());
    assertEquals(1.0d, frame2.getMaxX());
    assertEquals(1.0d, frame4.getMaxX());
    assertEquals(1.0d, frame8.getMaxX());
    assertEquals(1.0d, frame9.getMaxX());
    assertEquals(1.0d, frame10.getMaxX());
    assertEquals(1.0d, bounds6.getMaxY());
    assertEquals(1.0d, bounds5.getMaxY());
    assertEquals(1.0d, bounds4.getMaxY());
    assertEquals(1.0d, bounds3.getMaxY());
    assertEquals(1.0d, bounds9.getMaxY());
    assertEquals(1.0d, bounds2.getMaxY());
    assertEquals(1.0d, bounds11.getMaxY());
    assertEquals(1.0d, bounds13.getMaxY());
    assertEquals(1.0d, bounds8.getMaxY());
    assertEquals(1.0d, bounds15.getMaxY());
    assertEquals(1.0d, bounds17.getMaxY());
    assertEquals(1.0d, bounds2D3.getMaxY());
    assertEquals(1.0d, bounds2D4.getMaxY());
    assertEquals(1.0d, bounds2D7.getMaxY());
    assertEquals(1.0d, bounds2D9.getMaxY());
    assertEquals(1.0d, bounds2D17.getMaxY());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(1.0d, bounds2D5.getMaxY());
    assertEquals(1.0d, bounds2D26.getMaxY());
    assertEquals(1.0d, bounds2D27.getMaxY());
    assertEquals(1.0d, bounds2D18.getMaxY());
    assertEquals(1.0d, bounds2D31.getMaxY());
    assertEquals(1.0d, bounds2D32.getMaxY());
    assertEquals(1.0d, bounds18.getMaxY());
    assertEquals(1.0d, bounds10.getMaxY());
    assertEquals(1.0d, bounds12.getMaxY());
    assertEquals(1.0d, bounds7.getMaxY());
    assertEquals(1.0d, bounds19.getMaxY());
    assertEquals(1.0d, bounds20.getMaxY());
    assertEquals(1.0d, bounds14.getMaxY());
    assertEquals(1.0d, bounds16.getMaxY());
    assertEquals(1.0d, bounds21.getMaxY());
    assertEquals(1.0d, frame5.getMaxY());
    assertEquals(1.0d, frame3.getMaxY());
    assertEquals(1.0d, frame.getMaxY());
    assertEquals(1.0d, frame6.getMaxY());
    assertEquals(1.0d, frame7.getMaxY());
    assertEquals(1.0d, frame2.getMaxY());
    assertEquals(1.0d, frame4.getMaxY());
    assertEquals(1.0d, frame8.getMaxY());
    assertEquals(1.0d, frame9.getMaxY());
    assertEquals(1.0d, frame10.getMaxY());
    assertEquals(1.0d, bounds6.getMinX());
    assertEquals(1.0d, bounds5.getMinX());
    assertEquals(1.0d, bounds4.getMinX());
    assertEquals(1.0d, bounds3.getMinX());
    assertEquals(1.0d, bounds9.getMinX());
    assertEquals(1.0d, bounds2.getMinX());
    assertEquals(1.0d, bounds11.getMinX());
    assertEquals(1.0d, bounds13.getMinX());
    assertEquals(1.0d, bounds8.getMinX());
    assertEquals(1.0d, bounds15.getMinX());
    assertEquals(1.0d, bounds17.getMinX());
    assertEquals(1.0d, bounds2D3.getMinX());
    assertEquals(1.0d, bounds2D4.getMinX());
    assertEquals(1.0d, bounds2D7.getMinX());
    assertEquals(1.0d, bounds2D9.getMinX());
    assertEquals(1.0d, bounds2D17.getMinX());
    assertEquals(1.0d, bounds.getMinX());
    assertEquals(1.0d, bounds2D5.getMinX());
    assertEquals(1.0d, bounds2D26.getMinX());
    assertEquals(1.0d, bounds2D27.getMinX());
    assertEquals(1.0d, bounds2D18.getMinX());
    assertEquals(1.0d, bounds2D31.getMinX());
    assertEquals(1.0d, bounds2D32.getMinX());
    assertEquals(1.0d, bounds18.getMinX());
    assertEquals(1.0d, bounds10.getMinX());
    assertEquals(1.0d, bounds12.getMinX());
    assertEquals(1.0d, bounds7.getMinX());
    assertEquals(1.0d, bounds19.getMinX());
    assertEquals(1.0d, bounds20.getMinX());
    assertEquals(1.0d, bounds14.getMinX());
    assertEquals(1.0d, bounds16.getMinX());
    assertEquals(1.0d, bounds21.getMinX());
    assertEquals(1.0d, frame5.getMinX());
    assertEquals(1.0d, frame3.getMinX());
    assertEquals(1.0d, frame.getMinX());
    assertEquals(1.0d, frame6.getMinX());
    assertEquals(1.0d, frame7.getMinX());
    assertEquals(1.0d, frame2.getMinX());
    assertEquals(1.0d, frame4.getMinX());
    assertEquals(1.0d, frame8.getMinX());
    assertEquals(1.0d, frame9.getMinX());
    assertEquals(1.0d, frame10.getMinX());
    assertEquals(1.0d, bounds6.getMinY());
    assertEquals(1.0d, bounds5.getMinY());
    assertEquals(1.0d, bounds4.getMinY());
    assertEquals(1.0d, bounds3.getMinY());
    assertEquals(1.0d, bounds9.getMinY());
    assertEquals(1.0d, bounds2.getMinY());
    assertEquals(1.0d, bounds11.getMinY());
    assertEquals(1.0d, bounds13.getMinY());
    assertEquals(1.0d, bounds8.getMinY());
    assertEquals(1.0d, bounds15.getMinY());
    assertEquals(1.0d, bounds17.getMinY());
    assertEquals(1.0d, bounds2D3.getMinY());
    assertEquals(1.0d, bounds2D4.getMinY());
    assertEquals(1.0d, bounds2D7.getMinY());
    assertEquals(1.0d, bounds2D9.getMinY());
    assertEquals(1.0d, bounds2D17.getMinY());
    assertEquals(1.0d, bounds.getMinY());
    assertEquals(1.0d, bounds2D5.getMinY());
    assertEquals(1.0d, bounds2D26.getMinY());
    assertEquals(1.0d, bounds2D27.getMinY());
    assertEquals(1.0d, bounds2D18.getMinY());
    assertEquals(1.0d, bounds2D31.getMinY());
    assertEquals(1.0d, bounds2D32.getMinY());
    assertEquals(1.0d, bounds18.getMinY());
    assertEquals(1.0d, bounds10.getMinY());
    assertEquals(1.0d, bounds12.getMinY());
    assertEquals(1.0d, bounds7.getMinY());
    assertEquals(1.0d, bounds19.getMinY());
    assertEquals(1.0d, bounds20.getMinY());
    assertEquals(1.0d, bounds14.getMinY());
    assertEquals(1.0d, bounds16.getMinY());
    assertEquals(1.0d, bounds21.getMinY());
    assertEquals(1.0d, frame5.getMinY());
    assertEquals(1.0d, frame3.getMinY());
    assertEquals(1.0d, frame.getMinY());
    assertEquals(1.0d, frame6.getMinY());
    assertEquals(1.0d, frame7.getMinY());
    assertEquals(1.0d, frame2.getMinY());
    assertEquals(1.0d, frame4.getMinY());
    assertEquals(1.0d, frame8.getMinY());
    assertEquals(1.0d, frame9.getMinY());
    assertEquals(1.0d, frame10.getMinY());
    assertEquals(1.0d, bounds2D3.getX());
    assertEquals(1.0d, bounds2D4.getX());
    assertEquals(1.0d, bounds2D7.getX());
    assertEquals(1.0d, bounds2D9.getX());
    assertEquals(1.0d, bounds2D17.getX());
    assertEquals(1.0d, bounds2D5.getX());
    assertEquals(1.0d, bounds2D26.getX());
    assertEquals(1.0d, bounds2D27.getX());
    assertEquals(1.0d, bounds2D18.getX());
    assertEquals(1.0d, bounds2D31.getX());
    assertEquals(1.0d, bounds2D32.getX());
    assertEquals(1.0d, frame5.getX());
    assertEquals(1.0d, frame3.getX());
    assertEquals(1.0d, frame.getX());
    assertEquals(1.0d, frame6.getX());
    assertEquals(1.0d, frame7.getX());
    assertEquals(1.0d, frame2.getX());
    assertEquals(1.0d, frame4.getX());
    assertEquals(1.0d, frame8.getX());
    assertEquals(1.0d, frame9.getX());
    assertEquals(1.0d, frame10.getX());
    assertEquals(1.0d, bounds2D3.getY());
    assertEquals(1.0d, bounds2D4.getY());
    assertEquals(1.0d, bounds2D7.getY());
    assertEquals(1.0d, bounds2D9.getY());
    assertEquals(1.0d, bounds2D17.getY());
    assertEquals(1.0d, bounds2D5.getY());
    assertEquals(1.0d, bounds2D26.getY());
    assertEquals(1.0d, bounds2D27.getY());
    assertEquals(1.0d, bounds2D18.getY());
    assertEquals(1.0d, bounds2D31.getY());
    assertEquals(1.0d, bounds2D32.getY());
    assertEquals(1.0d, frame5.getY());
    assertEquals(1.0d, frame3.getY());
    assertEquals(1.0d, frame.getY());
    assertEquals(1.0d, frame6.getY());
    assertEquals(1.0d, frame7.getY());
    assertEquals(1.0d, frame2.getY());
    assertEquals(1.0d, frame4.getY());
    assertEquals(1.0d, frame8.getY());
    assertEquals(1.0d, frame9.getY());
    assertEquals(1.0d, frame10.getY());
    assertEquals(1.0f, ((Rectangle2D.Float) bounds2D5).x);
    assertEquals(1.0f, ((Rectangle2D.Float) bounds2D18).x);
    assertEquals(1.0f, ((Rectangle2D.Float) bounds2D33).x);
    assertEquals(1.0f, ((Rectangle2D.Float) bounds2D5).y);
    assertEquals(1.0f, ((Rectangle2D.Float) bounds2D18).y);
    assertEquals(1.0f, ((Rectangle2D.Float) bounds2D33).y);
    assertEquals(p0, bounds6.getLocation());
    assertEquals(p0, bounds5.getLocation());
    assertEquals(p0, bounds4.getLocation());
    assertEquals(p0, bounds3.getLocation());
    assertEquals(p0, bounds9.getLocation());
    assertEquals(p0, bounds2.getLocation());
    assertEquals(p0, bounds11.getLocation());
    assertEquals(p0, bounds13.getLocation());
    assertEquals(p0, bounds8.getLocation());
    assertEquals(p0, bounds15.getLocation());
    assertEquals(p0, bounds17.getLocation());
    assertEquals(p0, bounds.getLocation());
    assertEquals(p0, bounds18.getLocation());
    assertEquals(p0, bounds10.getLocation());
    assertEquals(p0, bounds12.getLocation());
    assertEquals(p0, bounds7.getLocation());
    assertEquals(p0, bounds19.getLocation());
    assertEquals(p0, bounds20.getLocation());
    assertEquals(p0, bounds14.getLocation());
    assertEquals(p0, bounds16.getLocation());
    assertEquals(p0, bounds21.getLocation());
    assertEquals(p0, ((Rectangle) bounds2D3).getLocation());
    assertEquals(p0, ((Rectangle) bounds2D4).getLocation());
    assertEquals(p0, ((Rectangle) bounds2D7).getLocation());
    assertEquals(p0, ((Rectangle) bounds2D9).getLocation());
    assertEquals(p0, ((Rectangle) bounds2D17).getLocation());
    assertEquals(p0, ((Rectangle) bounds2D26).getLocation());
    assertEquals(p0, ((Rectangle) bounds2D27).getLocation());
    assertEquals(p0, currentPoint);
    assertEquals(p0, currentPoint2);
  }

  /**
   * Test {@link PageDrawer#getNonStrokingPaint()}.
   * <ul>
   *   <li>Then return {@link Color}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#getNonStrokingPaint()}
   */
  @Test
  @DisplayName("Test getNonStrokingPaint(); then return Color")
  void testGetNonStrokingPaint_thenReturnColor() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());

    // Act
    Paint actualNonStrokingPaint = pageDrawer.getNonStrokingPaint();

    // Assert
    assertTrue(actualNonStrokingPaint instanceof Color);
    assertEquals(((Color) actualNonStrokingPaint).black, actualNonStrokingPaint);
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test {@link PageDrawer#moveTo(float, float)}.
   * <p>
   * Method under test: {@link PageDrawer#moveTo(float, float)}
   */
  @Test
  @DisplayName("Test moveTo(float, float)")
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
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D = bounds6.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds5.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds4.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds3.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    Rectangle bounds7 = bounds2D5.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D6 = bounds9.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = linePath.getBounds2D();
    Rectangle bounds10 = bounds2D7.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle2D bounds2D8 = bounds12.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D bounds2D9 = bounds2.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle bounds13 = bounds2D9.getBounds();
    Rectangle bounds14 = bounds13.getBounds();
    Rectangle2D bounds2D10 = bounds14.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D11 = bounds8.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds11.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    Rectangle bounds15 = frame.getBounds();
    Rectangle bounds16 = bounds15.getBounds();
    Rectangle2D bounds2D13 = bounds16.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    Rectangle2D frame2 = bounds.getFrame();
    Rectangle bounds17 = frame2.getBounds();
    Rectangle bounds18 = bounds17.getBounds();
    Rectangle2D bounds2D14 = bounds18.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle bounds19 = bounds2D4.getBounds();
    Rectangle2D bounds2D15 = bounds19.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds13.getBounds2D();
    assertTrue(bounds2D16 instanceof Rectangle);
    Rectangle2D bounds2D17 = bounds7.getBounds2D();
    assertTrue(bounds2D17 instanceof Rectangle);
    Rectangle2D bounds2D18 = bounds10.getBounds2D();
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D19 = bounds2D7.getBounds2D();
    Rectangle bounds20 = bounds2D19.getBounds();
    Rectangle2D bounds2D20 = bounds20.getBounds2D();
    assertTrue(bounds2D20 instanceof Rectangle);
    Rectangle2D frame3 = bounds3.getFrame();
    Rectangle bounds21 = frame3.getBounds();
    Rectangle2D bounds2D21 = bounds21.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D bounds2D22 = bounds15.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D bounds2D23 = bounds17.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    Rectangle2D frame4 = bounds2D7.getFrame();
    Rectangle bounds22 = frame4.getBounds();
    Rectangle2D bounds2D24 = bounds22.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D3.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D4.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D9.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D5.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D18.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D27.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D28.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    Point2D currentPoint = linePath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Point2D.Float);
    Rectangle2D bounds2D32 = frame.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D33 = frame2.getBounds2D();
    assertTrue(bounds2D33 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds4.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds2D9.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds2D5.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(frame4 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = bounds10.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Rectangle2D frame9 = frame.getFrame();
    assertTrue(frame9 instanceof Rectangle2D.Double);
    Rectangle2D frame10 = frame2.getFrame();
    assertTrue(frame10 instanceof Rectangle2D.Double);
    assertTrue(bounds2D7 instanceof Rectangle2D.Float);
    assertTrue(bounds2D19 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D34 = bounds2D19.getBounds2D();
    assertTrue(bounds2D34 instanceof Rectangle2D.Float);
    Rectangle bounds23 = bounds6.getBounds();
    assertEquals(10, bounds23.x);
    assertEquals(10, bounds6.x);
    assertEquals(10, bounds5.x);
    assertEquals(10, bounds4.x);
    Rectangle bounds24 = bounds9.getBounds();
    assertEquals(10, bounds24.x);
    Rectangle bounds25 = bounds12.getBounds();
    assertEquals(10, bounds25.x);
    assertEquals(10, bounds3.x);
    Rectangle bounds26 = bounds14.getBounds();
    assertEquals(10, bounds26.x);
    assertEquals(10, bounds9.x);
    assertEquals(10, bounds12.x);
    Rectangle bounds27 = bounds16.getBounds();
    assertEquals(10, bounds27.x);
    Rectangle bounds28 = bounds18.getBounds();
    assertEquals(10, bounds28.x);
    assertEquals(10, bounds2.x);
    Rectangle bounds29 = bounds19.getBounds();
    assertEquals(10, bounds29.x);
    assertEquals(10, bounds14.x);
    assertEquals(10, bounds8.x);
    assertEquals(10, bounds11.x);
    Rectangle bounds30 = bounds20.getBounds();
    assertEquals(10, bounds30.x);
    Rectangle bounds31 = bounds21.getBounds();
    assertEquals(10, bounds31.x);
    assertEquals(10, bounds16.x);
    assertEquals(10, bounds18.x);
    Rectangle bounds32 = bounds22.getBounds();
    assertEquals(10, bounds32.x);
    assertEquals(10, bounds.x);
    Rectangle bounds33 = bounds2D3.getBounds();
    assertEquals(10, bounds33.x);
    assertEquals(10, bounds19.x);
    assertEquals(10, bounds13.x);
    assertEquals(10, bounds7.x);
    Rectangle bounds34 = bounds2D17.getBounds();
    assertEquals(10, bounds34.x);
    Rectangle bounds35 = bounds2D18.getBounds();
    assertEquals(10, bounds35.x);
    assertEquals(10, bounds10.x);
    Rectangle bounds36 = bounds2D27.getBounds();
    assertEquals(10, bounds36.x);
    Rectangle bounds37 = bounds2D28.getBounds();
    assertEquals(10, bounds37.x);
    assertEquals(10, bounds20.x);
    Rectangle bounds38 = bounds2D32.getBounds();
    assertEquals(10, bounds38.x);
    Rectangle bounds39 = bounds2D33.getBounds();
    assertEquals(10, bounds39.x);
    Rectangle bounds40 = frame5.getBounds();
    assertEquals(10, bounds40.x);
    assertEquals(10, bounds21.x);
    assertEquals(10, bounds15.x);
    Rectangle bounds41 = frame6.getBounds();
    assertEquals(10, bounds41.x);
    Rectangle bounds42 = frame7.getBounds();
    assertEquals(10, bounds42.x);
    assertEquals(10, bounds17.x);
    assertEquals(10, bounds22.x);
    Rectangle bounds43 = frame8.getBounds();
    assertEquals(10, bounds43.x);
    Rectangle bounds44 = frame9.getBounds();
    assertEquals(10, bounds44.x);
    Rectangle bounds45 = frame10.getBounds();
    assertEquals(10, bounds45.x);
    assertEquals(10, ((Rectangle) bounds2D).x);
    assertEquals(10, ((Rectangle) bounds2D2).x);
    assertEquals(10, ((Rectangle) bounds2D3).x);
    assertEquals(10, ((Rectangle) bounds2D4).x);
    assertEquals(10, ((Rectangle) bounds2D6).x);
    assertEquals(10, ((Rectangle) bounds2D8).x);
    assertEquals(10, ((Rectangle) bounds2D9).x);
    assertEquals(10, ((Rectangle) bounds2D10).x);
    assertEquals(10, ((Rectangle) bounds2D11).x);
    assertEquals(10, ((Rectangle) bounds2D12).x);
    assertEquals(10, ((Rectangle) bounds2D13).x);
    assertEquals(10, ((Rectangle) bounds2D14).x);
    assertEquals(10, ((Rectangle) bounds2D5).x);
    assertEquals(10, ((Rectangle) bounds2D15).x);
    assertEquals(10, ((Rectangle) bounds2D16).x);
    assertEquals(10, ((Rectangle) bounds2D17).x);
    assertEquals(10, ((Rectangle) bounds2D18).x);
    assertEquals(10, ((Rectangle) bounds2D20).x);
    assertEquals(10, ((Rectangle) bounds2D21).x);
    assertEquals(10, ((Rectangle) bounds2D22).x);
    assertEquals(10, ((Rectangle) bounds2D23).x);
    assertEquals(10, ((Rectangle) bounds2D24).x);
    assertEquals(10, ((Rectangle) bounds2D25).x);
    assertEquals(10, ((Rectangle) bounds2D26).x);
    assertEquals(10, ((Rectangle) bounds2D27).x);
    assertEquals(10, ((Rectangle) bounds2D28).x);
    assertEquals(10, ((Rectangle) bounds2D29).x);
    assertEquals(10, ((Rectangle) bounds2D30).x);
    assertEquals(10, ((Rectangle) bounds2D31).x);
    assertEquals(10, bounds23.y);
    assertEquals(10, bounds6.y);
    assertEquals(10, bounds5.y);
    assertEquals(10, bounds4.y);
    assertEquals(10, bounds24.y);
    assertEquals(10, bounds25.y);
    assertEquals(10, bounds3.y);
    assertEquals(10, bounds26.y);
    assertEquals(10, bounds9.y);
    assertEquals(10, bounds12.y);
    assertEquals(10, bounds27.y);
    assertEquals(10, bounds28.y);
    assertEquals(10, bounds2.y);
    assertEquals(10, bounds29.y);
    assertEquals(10, bounds14.y);
    assertEquals(10, bounds8.y);
    assertEquals(10, bounds11.y);
    assertEquals(10, bounds30.y);
    assertEquals(10, bounds31.y);
    assertEquals(10, bounds16.y);
    assertEquals(10, bounds18.y);
    assertEquals(10, bounds32.y);
    assertEquals(10, bounds.y);
    assertEquals(10, bounds33.y);
    assertEquals(10, bounds19.y);
    assertEquals(10, bounds13.y);
    assertEquals(10, bounds7.y);
    assertEquals(10, bounds34.y);
    assertEquals(10, bounds35.y);
    assertEquals(10, bounds10.y);
    assertEquals(10, bounds36.y);
    assertEquals(10, bounds37.y);
    assertEquals(10, bounds20.y);
    assertEquals(10, bounds38.y);
    assertEquals(10, bounds39.y);
    assertEquals(10, bounds40.y);
    assertEquals(10, bounds21.y);
    assertEquals(10, bounds15.y);
    assertEquals(10, bounds41.y);
    assertEquals(10, bounds42.y);
    assertEquals(10, bounds17.y);
    assertEquals(10, bounds22.y);
    assertEquals(10, bounds43.y);
    assertEquals(10, bounds44.y);
    assertEquals(10, bounds45.y);
    assertEquals(10, ((Rectangle) bounds2D).y);
    assertEquals(10, ((Rectangle) bounds2D2).y);
    assertEquals(10, ((Rectangle) bounds2D3).y);
    assertEquals(10, ((Rectangle) bounds2D4).y);
    assertEquals(10, ((Rectangle) bounds2D6).y);
    assertEquals(10, ((Rectangle) bounds2D8).y);
    assertEquals(10, ((Rectangle) bounds2D9).y);
    assertEquals(10, ((Rectangle) bounds2D10).y);
    assertEquals(10, ((Rectangle) bounds2D11).y);
    assertEquals(10, ((Rectangle) bounds2D12).y);
    assertEquals(10, ((Rectangle) bounds2D13).y);
    assertEquals(10, ((Rectangle) bounds2D14).y);
    assertEquals(10, ((Rectangle) bounds2D5).y);
    assertEquals(10, ((Rectangle) bounds2D15).y);
    assertEquals(10, ((Rectangle) bounds2D16).y);
    assertEquals(10, ((Rectangle) bounds2D17).y);
    assertEquals(10, ((Rectangle) bounds2D18).y);
    assertEquals(10, ((Rectangle) bounds2D20).y);
    assertEquals(10, ((Rectangle) bounds2D21).y);
    assertEquals(10, ((Rectangle) bounds2D22).y);
    assertEquals(10, ((Rectangle) bounds2D23).y);
    assertEquals(10, ((Rectangle) bounds2D24).y);
    assertEquals(10, ((Rectangle) bounds2D25).y);
    assertEquals(10, ((Rectangle) bounds2D26).y);
    assertEquals(10, ((Rectangle) bounds2D27).y);
    assertEquals(10, ((Rectangle) bounds2D28).y);
    assertEquals(10, ((Rectangle) bounds2D29).y);
    assertEquals(10, ((Rectangle) bounds2D30).y);
    assertEquals(10, ((Rectangle) bounds2D31).y);
    assertEquals(10.0d, bounds6.getX());
    assertEquals(10.0d, bounds5.getX());
    assertEquals(10.0d, bounds4.getX());
    assertEquals(10.0d, bounds3.getX());
    assertEquals(10.0d, bounds9.getX());
    assertEquals(10.0d, bounds12.getX());
    assertEquals(10.0d, bounds2.getX());
    assertEquals(10.0d, bounds14.getX());
    assertEquals(10.0d, bounds8.getX());
    assertEquals(10.0d, bounds11.getX());
    assertEquals(10.0d, bounds16.getX());
    assertEquals(10.0d, bounds18.getX());
    assertEquals(10.0d, bounds.getX());
    assertEquals(10.0d, bounds19.getX());
    assertEquals(10.0d, bounds13.getX());
    assertEquals(10.0d, bounds7.getX());
    assertEquals(10.0d, bounds10.getX());
    assertEquals(10.0d, bounds20.getX());
    assertEquals(10.0d, bounds21.getX());
    assertEquals(10.0d, bounds15.getX());
    assertEquals(10.0d, bounds17.getX());
    assertEquals(10.0d, bounds22.getX());
    assertEquals(10.0d, bounds6.getY());
    assertEquals(10.0d, bounds5.getY());
    assertEquals(10.0d, bounds4.getY());
    assertEquals(10.0d, bounds3.getY());
    assertEquals(10.0d, bounds9.getY());
    assertEquals(10.0d, bounds12.getY());
    assertEquals(10.0d, bounds2.getY());
    assertEquals(10.0d, bounds14.getY());
    assertEquals(10.0d, bounds8.getY());
    assertEquals(10.0d, bounds11.getY());
    assertEquals(10.0d, bounds16.getY());
    assertEquals(10.0d, bounds18.getY());
    assertEquals(10.0d, bounds.getY());
    assertEquals(10.0d, bounds19.getY());
    assertEquals(10.0d, bounds13.getY());
    assertEquals(10.0d, bounds7.getY());
    assertEquals(10.0d, bounds10.getY());
    assertEquals(10.0d, bounds20.getY());
    assertEquals(10.0d, bounds21.getY());
    assertEquals(10.0d, bounds15.getY());
    assertEquals(10.0d, bounds17.getY());
    assertEquals(10.0d, bounds22.getY());
    assertEquals(10.0d, currentPoint2.getX());
    assertEquals(10.0d, currentPoint2.getY());
    assertEquals(10.0d, bounds6.getCenterX());
    assertEquals(10.0d, bounds5.getCenterX());
    assertEquals(10.0d, bounds4.getCenterX());
    assertEquals(10.0d, bounds3.getCenterX());
    assertEquals(10.0d, bounds9.getCenterX());
    assertEquals(10.0d, bounds12.getCenterX());
    assertEquals(10.0d, bounds2.getCenterX());
    assertEquals(10.0d, bounds14.getCenterX());
    assertEquals(10.0d, bounds8.getCenterX());
    assertEquals(10.0d, bounds11.getCenterX());
    assertEquals(10.0d, bounds16.getCenterX());
    assertEquals(10.0d, bounds18.getCenterX());
    assertEquals(10.0d, bounds2D3.getCenterX());
    assertEquals(10.0d, bounds2D4.getCenterX());
    assertEquals(10.0d, bounds2D9.getCenterX());
    assertEquals(10.0d, bounds2D5.getCenterX());
    assertEquals(10.0d, bounds2D18.getCenterX());
    assertEquals(10.0d, bounds.getCenterX());
    assertEquals(10.0d, bounds2D7.getCenterX());
    assertEquals(10.0d, bounds2D27.getCenterX());
    assertEquals(10.0d, bounds2D28.getCenterX());
    assertEquals(10.0d, bounds2D19.getCenterX());
    assertEquals(10.0d, bounds2D32.getCenterX());
    assertEquals(10.0d, bounds2D33.getCenterX());
    assertEquals(10.0d, bounds19.getCenterX());
    assertEquals(10.0d, bounds13.getCenterX());
    assertEquals(10.0d, bounds7.getCenterX());
    assertEquals(10.0d, bounds10.getCenterX());
    assertEquals(10.0d, bounds20.getCenterX());
    assertEquals(10.0d, bounds21.getCenterX());
    assertEquals(10.0d, bounds15.getCenterX());
    assertEquals(10.0d, bounds17.getCenterX());
    assertEquals(10.0d, bounds22.getCenterX());
    assertEquals(10.0d, frame5.getCenterX());
    assertEquals(10.0d, frame3.getCenterX());
    assertEquals(10.0d, frame.getCenterX());
    assertEquals(10.0d, frame6.getCenterX());
    assertEquals(10.0d, frame7.getCenterX());
    assertEquals(10.0d, frame2.getCenterX());
    assertEquals(10.0d, frame4.getCenterX());
    assertEquals(10.0d, frame8.getCenterX());
    assertEquals(10.0d, frame9.getCenterX());
    assertEquals(10.0d, frame10.getCenterX());
    assertEquals(10.0d, bounds6.getCenterY());
    assertEquals(10.0d, bounds5.getCenterY());
    assertEquals(10.0d, bounds4.getCenterY());
    assertEquals(10.0d, bounds3.getCenterY());
    assertEquals(10.0d, bounds9.getCenterY());
    assertEquals(10.0d, bounds12.getCenterY());
    assertEquals(10.0d, bounds2.getCenterY());
    assertEquals(10.0d, bounds14.getCenterY());
    assertEquals(10.0d, bounds8.getCenterY());
    assertEquals(10.0d, bounds11.getCenterY());
    assertEquals(10.0d, bounds16.getCenterY());
    assertEquals(10.0d, bounds18.getCenterY());
    assertEquals(10.0d, bounds2D3.getCenterY());
    assertEquals(10.0d, bounds2D4.getCenterY());
    assertEquals(10.0d, bounds2D9.getCenterY());
    assertEquals(10.0d, bounds2D5.getCenterY());
    assertEquals(10.0d, bounds2D18.getCenterY());
    assertEquals(10.0d, bounds.getCenterY());
    assertEquals(10.0d, bounds2D7.getCenterY());
    assertEquals(10.0d, bounds2D27.getCenterY());
    assertEquals(10.0d, bounds2D28.getCenterY());
    assertEquals(10.0d, bounds2D19.getCenterY());
    assertEquals(10.0d, bounds2D32.getCenterY());
    assertEquals(10.0d, bounds2D33.getCenterY());
    assertEquals(10.0d, bounds19.getCenterY());
    assertEquals(10.0d, bounds13.getCenterY());
    assertEquals(10.0d, bounds7.getCenterY());
    assertEquals(10.0d, bounds10.getCenterY());
    assertEquals(10.0d, bounds20.getCenterY());
    assertEquals(10.0d, bounds21.getCenterY());
    assertEquals(10.0d, bounds15.getCenterY());
    assertEquals(10.0d, bounds17.getCenterY());
    assertEquals(10.0d, bounds22.getCenterY());
    assertEquals(10.0d, frame5.getCenterY());
    assertEquals(10.0d, frame3.getCenterY());
    assertEquals(10.0d, frame.getCenterY());
    assertEquals(10.0d, frame6.getCenterY());
    assertEquals(10.0d, frame7.getCenterY());
    assertEquals(10.0d, frame2.getCenterY());
    assertEquals(10.0d, frame4.getCenterY());
    assertEquals(10.0d, frame8.getCenterY());
    assertEquals(10.0d, frame9.getCenterY());
    assertEquals(10.0d, frame10.getCenterY());
    assertEquals(10.0d, bounds6.getMaxX());
    assertEquals(10.0d, bounds5.getMaxX());
    assertEquals(10.0d, bounds4.getMaxX());
    assertEquals(10.0d, bounds3.getMaxX());
    assertEquals(10.0d, bounds9.getMaxX());
    assertEquals(10.0d, bounds12.getMaxX());
    assertEquals(10.0d, bounds2.getMaxX());
    assertEquals(10.0d, bounds14.getMaxX());
    assertEquals(10.0d, bounds8.getMaxX());
    assertEquals(10.0d, bounds11.getMaxX());
    assertEquals(10.0d, bounds16.getMaxX());
    assertEquals(10.0d, bounds18.getMaxX());
    assertEquals(10.0d, bounds2D3.getMaxX());
    assertEquals(10.0d, bounds2D4.getMaxX());
    assertEquals(10.0d, bounds2D9.getMaxX());
    assertEquals(10.0d, bounds2D5.getMaxX());
    assertEquals(10.0d, bounds2D18.getMaxX());
    assertEquals(10.0d, bounds.getMaxX());
    assertEquals(10.0d, bounds2D7.getMaxX());
    assertEquals(10.0d, bounds2D27.getMaxX());
    assertEquals(10.0d, bounds2D28.getMaxX());
    assertEquals(10.0d, bounds2D19.getMaxX());
    assertEquals(10.0d, bounds2D32.getMaxX());
    assertEquals(10.0d, bounds2D33.getMaxX());
    assertEquals(10.0d, bounds19.getMaxX());
    assertEquals(10.0d, bounds13.getMaxX());
    assertEquals(10.0d, bounds7.getMaxX());
    assertEquals(10.0d, bounds10.getMaxX());
    assertEquals(10.0d, bounds20.getMaxX());
    assertEquals(10.0d, bounds21.getMaxX());
    assertEquals(10.0d, bounds15.getMaxX());
    assertEquals(10.0d, bounds17.getMaxX());
    assertEquals(10.0d, bounds22.getMaxX());
    assertEquals(10.0d, frame5.getMaxX());
    assertEquals(10.0d, frame3.getMaxX());
    assertEquals(10.0d, frame.getMaxX());
    assertEquals(10.0d, frame6.getMaxX());
    assertEquals(10.0d, frame7.getMaxX());
    assertEquals(10.0d, frame2.getMaxX());
    assertEquals(10.0d, frame4.getMaxX());
    assertEquals(10.0d, frame8.getMaxX());
    assertEquals(10.0d, frame9.getMaxX());
    assertEquals(10.0d, frame10.getMaxX());
    assertEquals(10.0d, bounds6.getMaxY());
    assertEquals(10.0d, bounds5.getMaxY());
    assertEquals(10.0d, bounds4.getMaxY());
    assertEquals(10.0d, bounds3.getMaxY());
    assertEquals(10.0d, bounds9.getMaxY());
    assertEquals(10.0d, bounds12.getMaxY());
    assertEquals(10.0d, bounds2.getMaxY());
    assertEquals(10.0d, bounds14.getMaxY());
    assertEquals(10.0d, bounds8.getMaxY());
    assertEquals(10.0d, bounds11.getMaxY());
    assertEquals(10.0d, bounds16.getMaxY());
    assertEquals(10.0d, bounds18.getMaxY());
    assertEquals(10.0d, bounds2D3.getMaxY());
    assertEquals(10.0d, bounds2D4.getMaxY());
    assertEquals(10.0d, bounds2D9.getMaxY());
    assertEquals(10.0d, bounds2D5.getMaxY());
    assertEquals(10.0d, bounds2D18.getMaxY());
    assertEquals(10.0d, bounds.getMaxY());
    assertEquals(10.0d, bounds2D7.getMaxY());
    assertEquals(10.0d, bounds2D27.getMaxY());
    assertEquals(10.0d, bounds2D28.getMaxY());
    assertEquals(10.0d, bounds2D19.getMaxY());
    assertEquals(10.0d, bounds2D32.getMaxY());
    assertEquals(10.0d, bounds2D33.getMaxY());
    assertEquals(10.0d, bounds19.getMaxY());
    assertEquals(10.0d, bounds13.getMaxY());
    assertEquals(10.0d, bounds7.getMaxY());
    assertEquals(10.0d, bounds10.getMaxY());
    assertEquals(10.0d, bounds20.getMaxY());
    assertEquals(10.0d, bounds21.getMaxY());
    assertEquals(10.0d, bounds15.getMaxY());
    assertEquals(10.0d, bounds17.getMaxY());
    assertEquals(10.0d, bounds22.getMaxY());
    assertEquals(10.0d, frame5.getMaxY());
    assertEquals(10.0d, frame3.getMaxY());
    assertEquals(10.0d, frame.getMaxY());
    assertEquals(10.0d, frame6.getMaxY());
    assertEquals(10.0d, frame7.getMaxY());
    assertEquals(10.0d, frame2.getMaxY());
    assertEquals(10.0d, frame4.getMaxY());
    assertEquals(10.0d, frame8.getMaxY());
    assertEquals(10.0d, frame9.getMaxY());
    assertEquals(10.0d, frame10.getMaxY());
    assertEquals(10.0d, bounds6.getMinX());
    assertEquals(10.0d, bounds5.getMinX());
    assertEquals(10.0d, bounds4.getMinX());
    assertEquals(10.0d, bounds3.getMinX());
    assertEquals(10.0d, bounds9.getMinX());
    assertEquals(10.0d, bounds12.getMinX());
    assertEquals(10.0d, bounds2.getMinX());
    assertEquals(10.0d, bounds14.getMinX());
    assertEquals(10.0d, bounds8.getMinX());
    assertEquals(10.0d, bounds11.getMinX());
    assertEquals(10.0d, bounds16.getMinX());
    assertEquals(10.0d, bounds18.getMinX());
    assertEquals(10.0d, bounds2D3.getMinX());
    assertEquals(10.0d, bounds2D4.getMinX());
    assertEquals(10.0d, bounds2D9.getMinX());
    assertEquals(10.0d, bounds2D5.getMinX());
    assertEquals(10.0d, bounds2D18.getMinX());
    assertEquals(10.0d, bounds.getMinX());
    assertEquals(10.0d, bounds2D7.getMinX());
    assertEquals(10.0d, bounds2D27.getMinX());
    assertEquals(10.0d, bounds2D28.getMinX());
    assertEquals(10.0d, bounds2D19.getMinX());
    assertEquals(10.0d, bounds2D32.getMinX());
    assertEquals(10.0d, bounds2D33.getMinX());
    assertEquals(10.0d, bounds19.getMinX());
    assertEquals(10.0d, bounds13.getMinX());
    assertEquals(10.0d, bounds7.getMinX());
    assertEquals(10.0d, bounds10.getMinX());
    assertEquals(10.0d, bounds20.getMinX());
    assertEquals(10.0d, bounds21.getMinX());
    assertEquals(10.0d, bounds15.getMinX());
    assertEquals(10.0d, bounds17.getMinX());
    assertEquals(10.0d, bounds22.getMinX());
    assertEquals(10.0d, frame5.getMinX());
    assertEquals(10.0d, frame3.getMinX());
    assertEquals(10.0d, frame.getMinX());
    assertEquals(10.0d, frame6.getMinX());
    assertEquals(10.0d, frame7.getMinX());
    assertEquals(10.0d, frame2.getMinX());
    assertEquals(10.0d, frame4.getMinX());
    assertEquals(10.0d, frame8.getMinX());
    assertEquals(10.0d, frame9.getMinX());
    assertEquals(10.0d, frame10.getMinX());
    assertEquals(10.0d, bounds6.getMinY());
    assertEquals(10.0d, bounds5.getMinY());
    assertEquals(10.0d, bounds4.getMinY());
    assertEquals(10.0d, bounds3.getMinY());
    assertEquals(10.0d, bounds9.getMinY());
    assertEquals(10.0d, bounds12.getMinY());
    assertEquals(10.0d, bounds2.getMinY());
    assertEquals(10.0d, bounds14.getMinY());
    assertEquals(10.0d, bounds8.getMinY());
    assertEquals(10.0d, bounds11.getMinY());
    assertEquals(10.0d, bounds16.getMinY());
    assertEquals(10.0d, bounds18.getMinY());
    assertEquals(10.0d, bounds2D3.getMinY());
    assertEquals(10.0d, bounds2D4.getMinY());
    assertEquals(10.0d, bounds2D9.getMinY());
    assertEquals(10.0d, bounds2D5.getMinY());
    assertEquals(10.0d, bounds2D18.getMinY());
    assertEquals(10.0d, bounds.getMinY());
    assertEquals(10.0d, bounds2D7.getMinY());
    assertEquals(10.0d, bounds2D27.getMinY());
    assertEquals(10.0d, bounds2D28.getMinY());
    assertEquals(10.0d, bounds2D19.getMinY());
    assertEquals(10.0d, bounds2D32.getMinY());
    assertEquals(10.0d, bounds2D33.getMinY());
    assertEquals(10.0d, bounds19.getMinY());
    assertEquals(10.0d, bounds13.getMinY());
    assertEquals(10.0d, bounds7.getMinY());
    assertEquals(10.0d, bounds10.getMinY());
    assertEquals(10.0d, bounds20.getMinY());
    assertEquals(10.0d, bounds21.getMinY());
    assertEquals(10.0d, bounds15.getMinY());
    assertEquals(10.0d, bounds17.getMinY());
    assertEquals(10.0d, bounds22.getMinY());
    assertEquals(10.0d, frame5.getMinY());
    assertEquals(10.0d, frame3.getMinY());
    assertEquals(10.0d, frame.getMinY());
    assertEquals(10.0d, frame6.getMinY());
    assertEquals(10.0d, frame7.getMinY());
    assertEquals(10.0d, frame2.getMinY());
    assertEquals(10.0d, frame4.getMinY());
    assertEquals(10.0d, frame8.getMinY());
    assertEquals(10.0d, frame9.getMinY());
    assertEquals(10.0d, frame10.getMinY());
    assertEquals(10.0d, bounds2D3.getX());
    assertEquals(10.0d, bounds2D4.getX());
    assertEquals(10.0d, bounds2D9.getX());
    assertEquals(10.0d, bounds2D5.getX());
    assertEquals(10.0d, bounds2D18.getX());
    assertEquals(10.0d, bounds2D7.getX());
    assertEquals(10.0d, bounds2D27.getX());
    assertEquals(10.0d, bounds2D28.getX());
    assertEquals(10.0d, bounds2D19.getX());
    assertEquals(10.0d, bounds2D32.getX());
    assertEquals(10.0d, bounds2D33.getX());
    assertEquals(10.0d, frame5.getX());
    assertEquals(10.0d, frame3.getX());
    assertEquals(10.0d, frame.getX());
    assertEquals(10.0d, frame6.getX());
    assertEquals(10.0d, frame7.getX());
    assertEquals(10.0d, frame2.getX());
    assertEquals(10.0d, frame4.getX());
    assertEquals(10.0d, frame8.getX());
    assertEquals(10.0d, frame9.getX());
    assertEquals(10.0d, frame10.getX());
    assertEquals(10.0d, bounds2D3.getY());
    assertEquals(10.0d, bounds2D4.getY());
    assertEquals(10.0d, bounds2D9.getY());
    assertEquals(10.0d, bounds2D5.getY());
    assertEquals(10.0d, bounds2D18.getY());
    assertEquals(10.0d, bounds2D7.getY());
    assertEquals(10.0d, bounds2D27.getY());
    assertEquals(10.0d, bounds2D28.getY());
    assertEquals(10.0d, bounds2D19.getY());
    assertEquals(10.0d, bounds2D32.getY());
    assertEquals(10.0d, bounds2D33.getY());
    assertEquals(10.0d, frame5.getY());
    assertEquals(10.0d, frame3.getY());
    assertEquals(10.0d, frame.getY());
    assertEquals(10.0d, frame6.getY());
    assertEquals(10.0d, frame7.getY());
    assertEquals(10.0d, frame2.getY());
    assertEquals(10.0d, frame4.getY());
    assertEquals(10.0d, frame8.getY());
    assertEquals(10.0d, frame9.getY());
    assertEquals(10.0d, frame10.getY());
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).x);
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).y);
    assertEquals(10.0f, ((Rectangle2D.Float) bounds2D7).x);
    assertEquals(10.0f, ((Rectangle2D.Float) bounds2D19).x);
    assertEquals(10.0f, ((Rectangle2D.Float) bounds2D34).x);
    assertEquals(10.0f, ((Rectangle2D.Float) bounds2D7).y);
    assertEquals(10.0f, ((Rectangle2D.Float) bounds2D19).y);
    assertEquals(10.0f, ((Rectangle2D.Float) bounds2D34).y);
    assertEquals(currentPoint2, bounds6.getLocation());
    assertEquals(currentPoint2, bounds5.getLocation());
    assertEquals(currentPoint2, bounds4.getLocation());
    assertEquals(currentPoint2, bounds3.getLocation());
    assertEquals(currentPoint2, bounds9.getLocation());
    assertEquals(currentPoint2, bounds12.getLocation());
    assertEquals(currentPoint2, bounds2.getLocation());
    assertEquals(currentPoint2, bounds14.getLocation());
    assertEquals(currentPoint2, bounds8.getLocation());
    assertEquals(currentPoint2, bounds11.getLocation());
    assertEquals(currentPoint2, bounds16.getLocation());
    assertEquals(currentPoint2, bounds18.getLocation());
    assertEquals(currentPoint2, bounds.getLocation());
    assertEquals(currentPoint2, bounds19.getLocation());
    assertEquals(currentPoint2, bounds13.getLocation());
    assertEquals(currentPoint2, bounds7.getLocation());
    assertEquals(currentPoint2, bounds10.getLocation());
    assertEquals(currentPoint2, bounds20.getLocation());
    assertEquals(currentPoint2, bounds21.getLocation());
    assertEquals(currentPoint2, bounds15.getLocation());
    assertEquals(currentPoint2, bounds17.getLocation());
    assertEquals(currentPoint2, bounds22.getLocation());
    assertEquals(currentPoint2, ((Rectangle) bounds2D3).getLocation());
    assertEquals(currentPoint2, ((Rectangle) bounds2D4).getLocation());
    assertEquals(currentPoint2, ((Rectangle) bounds2D9).getLocation());
    assertEquals(currentPoint2, ((Rectangle) bounds2D5).getLocation());
    assertEquals(currentPoint2, ((Rectangle) bounds2D18).getLocation());
    assertEquals(currentPoint2, ((Rectangle) bounds2D27).getLocation());
    assertEquals(currentPoint2, ((Rectangle) bounds2D28).getLocation());
    assertEquals(currentPoint2, currentPoint);
  }

  /**
   * Test {@link PageDrawer#lineTo(float, float)}.
   * <p>
   * Method under test: {@link PageDrawer#lineTo(float, float)}
   */
  @Test
  @DisplayName("Test lineTo(float, float)")
  void testLineTo() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    Point p0 = new Point(1, 1);

    Point p1 = new Point(1, 1);

    Point p2 = new Point(1, 1);

    pageDrawer.appendRectangle(p0, p1, p2, new Point(1, 1));

    // Act
    pageDrawer.lineTo(10.0f, 10.0f);

    // Assert that nothing has changed
    GeneralPath linePath = pageDrawer.getLinePath();
    Rectangle bounds = linePath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D = bounds6.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds5.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds4.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds3.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    Rectangle bounds7 = bounds2D5.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D6 = bounds9.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = linePath.getBounds2D();
    Rectangle bounds10 = bounds2D7.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle2D bounds2D8 = bounds12.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D bounds2D9 = bounds2.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle bounds13 = bounds2D9.getBounds();
    Rectangle bounds14 = bounds13.getBounds();
    Rectangle2D bounds2D10 = bounds14.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D11 = bounds8.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds11.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    Rectangle bounds15 = frame.getBounds();
    Rectangle bounds16 = bounds15.getBounds();
    Rectangle2D bounds2D13 = bounds16.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    Rectangle2D frame2 = bounds.getFrame();
    Rectangle bounds17 = frame2.getBounds();
    Rectangle bounds18 = bounds17.getBounds();
    Rectangle2D bounds2D14 = bounds18.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle bounds19 = bounds2D4.getBounds();
    Rectangle2D bounds2D15 = bounds19.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds13.getBounds2D();
    assertTrue(bounds2D16 instanceof Rectangle);
    Rectangle2D bounds2D17 = bounds7.getBounds2D();
    assertTrue(bounds2D17 instanceof Rectangle);
    Rectangle2D bounds2D18 = bounds10.getBounds2D();
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D19 = bounds2D7.getBounds2D();
    Rectangle bounds20 = bounds2D19.getBounds();
    Rectangle2D bounds2D20 = bounds20.getBounds2D();
    assertTrue(bounds2D20 instanceof Rectangle);
    Rectangle2D frame3 = bounds3.getFrame();
    Rectangle bounds21 = frame3.getBounds();
    Rectangle2D bounds2D21 = bounds21.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D bounds2D22 = bounds15.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D bounds2D23 = bounds17.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    Rectangle2D frame4 = bounds2D7.getFrame();
    Rectangle bounds22 = frame4.getBounds();
    Rectangle2D bounds2D24 = bounds22.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D3.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D4.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D9.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D5.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D18.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D27.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D28.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    Point2D currentPoint = linePath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Point2D.Float);
    Rectangle2D bounds2D32 = frame.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D33 = frame2.getBounds2D();
    assertTrue(bounds2D33 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds4.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds2D9.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds2D5.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(frame4 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = bounds10.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Rectangle2D frame9 = frame.getFrame();
    assertTrue(frame9 instanceof Rectangle2D.Double);
    Rectangle2D frame10 = frame2.getFrame();
    assertTrue(frame10 instanceof Rectangle2D.Double);
    assertTrue(bounds2D7 instanceof Rectangle2D.Float);
    assertTrue(bounds2D19 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D34 = bounds2D19.getBounds2D();
    assertTrue(bounds2D34 instanceof Rectangle2D.Float);
    assertEquals(10.0d, currentPoint2.getX());
    assertEquals(10.0d, currentPoint2.getY());
    assertEquals(10.0d, bounds6.getMaxX());
    assertEquals(10.0d, bounds5.getMaxX());
    assertEquals(10.0d, bounds4.getMaxX());
    assertEquals(10.0d, bounds3.getMaxX());
    assertEquals(10.0d, bounds9.getMaxX());
    assertEquals(10.0d, bounds12.getMaxX());
    assertEquals(10.0d, bounds2.getMaxX());
    assertEquals(10.0d, bounds14.getMaxX());
    assertEquals(10.0d, bounds8.getMaxX());
    assertEquals(10.0d, bounds11.getMaxX());
    assertEquals(10.0d, bounds16.getMaxX());
    assertEquals(10.0d, bounds18.getMaxX());
    assertEquals(10.0d, bounds2D3.getMaxX());
    assertEquals(10.0d, bounds2D4.getMaxX());
    assertEquals(10.0d, bounds2D9.getMaxX());
    assertEquals(10.0d, bounds2D5.getMaxX());
    assertEquals(10.0d, bounds2D18.getMaxX());
    assertEquals(10.0d, bounds.getMaxX());
    assertEquals(10.0d, bounds2D7.getMaxX());
    assertEquals(10.0d, bounds2D27.getMaxX());
    assertEquals(10.0d, bounds2D28.getMaxX());
    assertEquals(10.0d, bounds2D19.getMaxX());
    assertEquals(10.0d, bounds2D32.getMaxX());
    assertEquals(10.0d, bounds2D33.getMaxX());
    assertEquals(10.0d, bounds19.getMaxX());
    assertEquals(10.0d, bounds13.getMaxX());
    assertEquals(10.0d, bounds7.getMaxX());
    assertEquals(10.0d, bounds10.getMaxX());
    assertEquals(10.0d, bounds20.getMaxX());
    assertEquals(10.0d, bounds21.getMaxX());
    assertEquals(10.0d, bounds15.getMaxX());
    assertEquals(10.0d, bounds17.getMaxX());
    assertEquals(10.0d, bounds22.getMaxX());
    assertEquals(10.0d, frame5.getMaxX());
    assertEquals(10.0d, frame3.getMaxX());
    assertEquals(10.0d, frame.getMaxX());
    assertEquals(10.0d, frame6.getMaxX());
    assertEquals(10.0d, frame7.getMaxX());
    assertEquals(10.0d, frame2.getMaxX());
    assertEquals(10.0d, frame4.getMaxX());
    assertEquals(10.0d, frame8.getMaxX());
    assertEquals(10.0d, frame9.getMaxX());
    assertEquals(10.0d, frame10.getMaxX());
    assertEquals(10.0d, bounds6.getMaxY());
    assertEquals(10.0d, bounds5.getMaxY());
    assertEquals(10.0d, bounds4.getMaxY());
    assertEquals(10.0d, bounds3.getMaxY());
    assertEquals(10.0d, bounds9.getMaxY());
    assertEquals(10.0d, bounds12.getMaxY());
    assertEquals(10.0d, bounds2.getMaxY());
    assertEquals(10.0d, bounds14.getMaxY());
    assertEquals(10.0d, bounds8.getMaxY());
    assertEquals(10.0d, bounds11.getMaxY());
    assertEquals(10.0d, bounds16.getMaxY());
    assertEquals(10.0d, bounds18.getMaxY());
    assertEquals(10.0d, bounds2D3.getMaxY());
    assertEquals(10.0d, bounds2D4.getMaxY());
    assertEquals(10.0d, bounds2D9.getMaxY());
    assertEquals(10.0d, bounds2D5.getMaxY());
    assertEquals(10.0d, bounds2D18.getMaxY());
    assertEquals(10.0d, bounds.getMaxY());
    assertEquals(10.0d, bounds2D7.getMaxY());
    assertEquals(10.0d, bounds2D27.getMaxY());
    assertEquals(10.0d, bounds2D28.getMaxY());
    assertEquals(10.0d, bounds2D19.getMaxY());
    assertEquals(10.0d, bounds2D32.getMaxY());
    assertEquals(10.0d, bounds2D33.getMaxY());
    assertEquals(10.0d, bounds19.getMaxY());
    assertEquals(10.0d, bounds13.getMaxY());
    assertEquals(10.0d, bounds7.getMaxY());
    assertEquals(10.0d, bounds10.getMaxY());
    assertEquals(10.0d, bounds20.getMaxY());
    assertEquals(10.0d, bounds21.getMaxY());
    assertEquals(10.0d, bounds15.getMaxY());
    assertEquals(10.0d, bounds17.getMaxY());
    assertEquals(10.0d, bounds22.getMaxY());
    assertEquals(10.0d, frame5.getMaxY());
    assertEquals(10.0d, frame3.getMaxY());
    assertEquals(10.0d, frame.getMaxY());
    assertEquals(10.0d, frame6.getMaxY());
    assertEquals(10.0d, frame7.getMaxY());
    assertEquals(10.0d, frame2.getMaxY());
    assertEquals(10.0d, frame4.getMaxY());
    assertEquals(10.0d, frame8.getMaxY());
    assertEquals(10.0d, frame9.getMaxY());
    assertEquals(10.0d, frame10.getMaxY());
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).x);
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).y);
    assertEquals(5.5d, bounds6.getCenterX());
    assertEquals(5.5d, bounds5.getCenterX());
    assertEquals(5.5d, bounds4.getCenterX());
    assertEquals(5.5d, bounds3.getCenterX());
    assertEquals(5.5d, bounds9.getCenterX());
    assertEquals(5.5d, bounds12.getCenterX());
    assertEquals(5.5d, bounds2.getCenterX());
    assertEquals(5.5d, bounds14.getCenterX());
    assertEquals(5.5d, bounds8.getCenterX());
    assertEquals(5.5d, bounds11.getCenterX());
    assertEquals(5.5d, bounds16.getCenterX());
    assertEquals(5.5d, bounds18.getCenterX());
    assertEquals(5.5d, bounds2D3.getCenterX());
    assertEquals(5.5d, bounds2D4.getCenterX());
    assertEquals(5.5d, bounds2D9.getCenterX());
    assertEquals(5.5d, bounds2D5.getCenterX());
    assertEquals(5.5d, bounds2D18.getCenterX());
    assertEquals(5.5d, bounds.getCenterX());
    assertEquals(5.5d, bounds2D7.getCenterX());
    assertEquals(5.5d, bounds2D27.getCenterX());
    assertEquals(5.5d, bounds2D28.getCenterX());
    assertEquals(5.5d, bounds2D19.getCenterX());
    assertEquals(5.5d, bounds2D32.getCenterX());
    assertEquals(5.5d, bounds2D33.getCenterX());
    assertEquals(5.5d, bounds19.getCenterX());
    assertEquals(5.5d, bounds13.getCenterX());
    assertEquals(5.5d, bounds7.getCenterX());
    assertEquals(5.5d, bounds10.getCenterX());
    assertEquals(5.5d, bounds20.getCenterX());
    assertEquals(5.5d, bounds21.getCenterX());
    assertEquals(5.5d, bounds15.getCenterX());
    assertEquals(5.5d, bounds17.getCenterX());
    assertEquals(5.5d, bounds22.getCenterX());
    assertEquals(5.5d, frame5.getCenterX());
    assertEquals(5.5d, frame3.getCenterX());
    assertEquals(5.5d, frame.getCenterX());
    assertEquals(5.5d, frame6.getCenterX());
    assertEquals(5.5d, frame7.getCenterX());
    assertEquals(5.5d, frame2.getCenterX());
    assertEquals(5.5d, frame4.getCenterX());
    assertEquals(5.5d, frame8.getCenterX());
    assertEquals(5.5d, frame9.getCenterX());
    assertEquals(5.5d, frame10.getCenterX());
    assertEquals(5.5d, bounds6.getCenterY());
    assertEquals(5.5d, bounds5.getCenterY());
    assertEquals(5.5d, bounds4.getCenterY());
    assertEquals(5.5d, bounds3.getCenterY());
    assertEquals(5.5d, bounds9.getCenterY());
    assertEquals(5.5d, bounds12.getCenterY());
    assertEquals(5.5d, bounds2.getCenterY());
    assertEquals(5.5d, bounds14.getCenterY());
    assertEquals(5.5d, bounds8.getCenterY());
    assertEquals(5.5d, bounds11.getCenterY());
    assertEquals(5.5d, bounds16.getCenterY());
    assertEquals(5.5d, bounds18.getCenterY());
    assertEquals(5.5d, bounds2D3.getCenterY());
    assertEquals(5.5d, bounds2D4.getCenterY());
    assertEquals(5.5d, bounds2D9.getCenterY());
    assertEquals(5.5d, bounds2D5.getCenterY());
    assertEquals(5.5d, bounds2D18.getCenterY());
    assertEquals(5.5d, bounds.getCenterY());
    assertEquals(5.5d, bounds2D7.getCenterY());
    assertEquals(5.5d, bounds2D27.getCenterY());
    assertEquals(5.5d, bounds2D28.getCenterY());
    assertEquals(5.5d, bounds2D19.getCenterY());
    assertEquals(5.5d, bounds2D32.getCenterY());
    assertEquals(5.5d, bounds2D33.getCenterY());
    assertEquals(5.5d, bounds19.getCenterY());
    assertEquals(5.5d, bounds13.getCenterY());
    assertEquals(5.5d, bounds7.getCenterY());
    assertEquals(5.5d, bounds10.getCenterY());
    assertEquals(5.5d, bounds20.getCenterY());
    assertEquals(5.5d, bounds21.getCenterY());
    assertEquals(5.5d, bounds15.getCenterY());
    assertEquals(5.5d, bounds17.getCenterY());
    assertEquals(5.5d, bounds22.getCenterY());
    assertEquals(5.5d, frame5.getCenterY());
    assertEquals(5.5d, frame3.getCenterY());
    assertEquals(5.5d, frame.getCenterY());
    assertEquals(5.5d, frame6.getCenterY());
    assertEquals(5.5d, frame7.getCenterY());
    assertEquals(5.5d, frame2.getCenterY());
    assertEquals(5.5d, frame4.getCenterY());
    assertEquals(5.5d, frame8.getCenterY());
    assertEquals(5.5d, frame9.getCenterY());
    assertEquals(5.5d, frame10.getCenterY());
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    Dimension size5 = size4.getSize();
    assertEquals(9, size5.height);
    Dimension size6 = bounds3.getSize();
    Dimension size7 = size6.getSize();
    Dimension size8 = size7.getSize();
    Dimension size9 = size8.getSize();
    assertEquals(9, size9.height);
    assertEquals(9, size4.height);
    Dimension size10 = bounds4.getSize();
    Dimension size11 = size10.getSize();
    Dimension size12 = size11.getSize();
    assertEquals(9, size12.height);
    assertEquals(9, size8.height);
    assertEquals(9, size3.height);
    Dimension size13 = bounds10.getSize();
    Dimension size14 = size13.getSize();
    Dimension size15 = size14.getSize();
    assertEquals(9, size15.height);
    Dimension size16 = ((Rectangle) bounds2D9).getSize();
    Dimension size17 = size16.getSize();
    Dimension size18 = size17.getSize();
    assertEquals(9, size18.height);
    Dimension size19 = ((Rectangle) bounds2D5).getSize();
    Dimension size20 = size19.getSize();
    Dimension size21 = size20.getSize();
    assertEquals(9, size21.height);
    Dimension size22 = bounds5.getSize();
    Dimension size23 = size22.getSize();
    assertEquals(9, size23.height);
    assertEquals(9, size11.height);
    assertEquals(9, size7.height);
    Dimension size24 = bounds8.getSize();
    Dimension size25 = size24.getSize();
    assertEquals(9, size25.height);
    Dimension size26 = bounds11.getSize();
    Dimension size27 = size26.getSize();
    assertEquals(9, size27.height);
    assertEquals(9, size2.height);
    Dimension size28 = bounds13.getSize();
    Dimension size29 = size28.getSize();
    assertEquals(9, size29.height);
    Dimension size30 = bounds7.getSize();
    Dimension size31 = size30.getSize();
    assertEquals(9, size31.height);
    assertEquals(9, size14.height);
    Dimension size32 = bounds15.getSize();
    Dimension size33 = size32.getSize();
    assertEquals(9, size33.height);
    Dimension size34 = bounds17.getSize();
    Dimension size35 = size34.getSize();
    assertEquals(9, size35.height);
    Dimension size36 = ((Rectangle) bounds2D4).getSize();
    Dimension size37 = size36.getSize();
    assertEquals(9, size37.height);
    assertEquals(9, size17.height);
    assertEquals(9, size20.height);
    Dimension size38 = bounds6.getSize();
    assertEquals(9, size38.height);
    assertEquals(9, size22.height);
    assertEquals(9, size10.height);
    assertEquals(9, size6.height);
    Dimension size39 = bounds9.getSize();
    assertEquals(9, size39.height);
    Dimension size40 = bounds12.getSize();
    assertEquals(9, size40.height);
    Dimension size41 = bounds14.getSize();
    assertEquals(9, size41.height);
    assertEquals(9, size24.height);
    assertEquals(9, size26.height);
    Dimension size42 = bounds16.getSize();
    assertEquals(9, size42.height);
    Dimension size43 = bounds18.getSize();
    assertEquals(9, size43.height);
    assertEquals(9, size.height);
    Dimension size44 = bounds19.getSize();
    assertEquals(9, size44.height);
    assertEquals(9, size28.height);
    assertEquals(9, size30.height);
    assertEquals(9, size13.height);
    Dimension size45 = bounds20.getSize();
    assertEquals(9, size45.height);
    Dimension size46 = bounds21.getSize();
    assertEquals(9, size46.height);
    assertEquals(9, size32.height);
    assertEquals(9, size34.height);
    Dimension size47 = bounds22.getSize();
    assertEquals(9, size47.height);
    Dimension size48 = ((Rectangle) bounds2D3).getSize();
    assertEquals(9, size48.height);
    assertEquals(9, size36.height);
    assertEquals(9, size16.height);
    assertEquals(9, size19.height);
    Dimension size49 = ((Rectangle) bounds2D18).getSize();
    assertEquals(9, size49.height);
    Dimension size50 = ((Rectangle) bounds2D27).getSize();
    assertEquals(9, size50.height);
    Dimension size51 = ((Rectangle) bounds2D28).getSize();
    assertEquals(9, size51.height);
    assertEquals(9, size5.width);
    assertEquals(9, size9.width);
    assertEquals(9, size4.width);
    assertEquals(9, size12.width);
    assertEquals(9, size8.width);
    assertEquals(9, size3.width);
    assertEquals(9, size15.width);
    assertEquals(9, size18.width);
    assertEquals(9, size21.width);
    assertEquals(9, size23.width);
    assertEquals(9, size11.width);
    assertEquals(9, size7.width);
    assertEquals(9, size25.width);
    assertEquals(9, size27.width);
    assertEquals(9, size2.width);
    assertEquals(9, size29.width);
    assertEquals(9, size31.width);
    assertEquals(9, size14.width);
    assertEquals(9, size33.width);
    assertEquals(9, size35.width);
    assertEquals(9, size37.width);
    assertEquals(9, size17.width);
    assertEquals(9, size20.width);
    assertEquals(9, size38.width);
    assertEquals(9, size22.width);
    assertEquals(9, size10.width);
    assertEquals(9, size6.width);
    assertEquals(9, size39.width);
    assertEquals(9, size40.width);
    assertEquals(9, size41.width);
    assertEquals(9, size24.width);
    assertEquals(9, size26.width);
    assertEquals(9, size42.width);
    assertEquals(9, size43.width);
    assertEquals(9, size.width);
    assertEquals(9, size44.width);
    assertEquals(9, size28.width);
    assertEquals(9, size30.width);
    assertEquals(9, size13.width);
    assertEquals(9, size45.width);
    assertEquals(9, size46.width);
    assertEquals(9, size32.width);
    assertEquals(9, size34.width);
    assertEquals(9, size47.width);
    assertEquals(9, size48.width);
    assertEquals(9, size36.width);
    assertEquals(9, size16.width);
    assertEquals(9, size19.width);
    assertEquals(9, size49.width);
    assertEquals(9, size50.width);
    assertEquals(9, size51.width);
    Rectangle bounds23 = bounds6.getBounds();
    assertEquals(9, bounds23.height);
    assertEquals(9, bounds6.height);
    assertEquals(9, bounds5.height);
    assertEquals(9, bounds4.height);
    Rectangle bounds24 = bounds9.getBounds();
    assertEquals(9, bounds24.height);
    Rectangle bounds25 = bounds12.getBounds();
    assertEquals(9, bounds25.height);
    assertEquals(9, bounds3.height);
    Rectangle bounds26 = bounds14.getBounds();
    assertEquals(9, bounds26.height);
    assertEquals(9, bounds9.height);
    assertEquals(9, bounds12.height);
    Rectangle bounds27 = bounds16.getBounds();
    assertEquals(9, bounds27.height);
    Rectangle bounds28 = bounds18.getBounds();
    assertEquals(9, bounds28.height);
    assertEquals(9, bounds2.height);
    Rectangle bounds29 = bounds19.getBounds();
    assertEquals(9, bounds29.height);
    assertEquals(9, bounds14.height);
    assertEquals(9, bounds8.height);
    assertEquals(9, bounds11.height);
    Rectangle bounds30 = bounds20.getBounds();
    assertEquals(9, bounds30.height);
    Rectangle bounds31 = bounds21.getBounds();
    assertEquals(9, bounds31.height);
    assertEquals(9, bounds16.height);
    assertEquals(9, bounds18.height);
    Rectangle bounds32 = bounds22.getBounds();
    assertEquals(9, bounds32.height);
    assertEquals(9, bounds.height);
    Rectangle bounds33 = bounds2D3.getBounds();
    assertEquals(9, bounds33.height);
    assertEquals(9, bounds19.height);
    assertEquals(9, bounds13.height);
    assertEquals(9, bounds7.height);
    Rectangle bounds34 = bounds2D17.getBounds();
    assertEquals(9, bounds34.height);
    Rectangle bounds35 = bounds2D18.getBounds();
    assertEquals(9, bounds35.height);
    assertEquals(9, bounds10.height);
    Rectangle bounds36 = bounds2D27.getBounds();
    assertEquals(9, bounds36.height);
    Rectangle bounds37 = bounds2D28.getBounds();
    assertEquals(9, bounds37.height);
    assertEquals(9, bounds20.height);
    Rectangle bounds38 = bounds2D32.getBounds();
    assertEquals(9, bounds38.height);
    Rectangle bounds39 = bounds2D33.getBounds();
    assertEquals(9, bounds39.height);
    Rectangle bounds40 = frame5.getBounds();
    assertEquals(9, bounds40.height);
    assertEquals(9, bounds21.height);
    assertEquals(9, bounds15.height);
    Rectangle bounds41 = frame6.getBounds();
    assertEquals(9, bounds41.height);
    Rectangle bounds42 = frame7.getBounds();
    assertEquals(9, bounds42.height);
    assertEquals(9, bounds17.height);
    assertEquals(9, bounds22.height);
    Rectangle bounds43 = frame8.getBounds();
    assertEquals(9, bounds43.height);
    Rectangle bounds44 = frame9.getBounds();
    assertEquals(9, bounds44.height);
    Rectangle bounds45 = frame10.getBounds();
    assertEquals(9, bounds45.height);
    assertEquals(9, ((Rectangle) bounds2D).height);
    assertEquals(9, ((Rectangle) bounds2D2).height);
    assertEquals(9, ((Rectangle) bounds2D3).height);
    assertEquals(9, ((Rectangle) bounds2D4).height);
    assertEquals(9, ((Rectangle) bounds2D6).height);
    assertEquals(9, ((Rectangle) bounds2D8).height);
    assertEquals(9, ((Rectangle) bounds2D9).height);
    assertEquals(9, ((Rectangle) bounds2D10).height);
    assertEquals(9, ((Rectangle) bounds2D11).height);
    assertEquals(9, ((Rectangle) bounds2D12).height);
    assertEquals(9, ((Rectangle) bounds2D13).height);
    assertEquals(9, ((Rectangle) bounds2D14).height);
    assertEquals(9, ((Rectangle) bounds2D5).height);
    assertEquals(9, ((Rectangle) bounds2D15).height);
    assertEquals(9, ((Rectangle) bounds2D16).height);
    assertEquals(9, ((Rectangle) bounds2D17).height);
    assertEquals(9, ((Rectangle) bounds2D18).height);
    assertEquals(9, ((Rectangle) bounds2D20).height);
    assertEquals(9, ((Rectangle) bounds2D21).height);
    assertEquals(9, ((Rectangle) bounds2D22).height);
    assertEquals(9, ((Rectangle) bounds2D23).height);
    assertEquals(9, ((Rectangle) bounds2D24).height);
    assertEquals(9, ((Rectangle) bounds2D25).height);
    assertEquals(9, ((Rectangle) bounds2D26).height);
    assertEquals(9, ((Rectangle) bounds2D27).height);
    assertEquals(9, ((Rectangle) bounds2D28).height);
    assertEquals(9, ((Rectangle) bounds2D29).height);
    assertEquals(9, ((Rectangle) bounds2D30).height);
    assertEquals(9, ((Rectangle) bounds2D31).height);
    assertEquals(9, bounds23.width);
    assertEquals(9, bounds6.width);
    assertEquals(9, bounds5.width);
    assertEquals(9, bounds4.width);
    assertEquals(9, bounds24.width);
    assertEquals(9, bounds25.width);
    assertEquals(9, bounds3.width);
    assertEquals(9, bounds26.width);
    assertEquals(9, bounds9.width);
    assertEquals(9, bounds12.width);
    assertEquals(9, bounds27.width);
    assertEquals(9, bounds28.width);
    assertEquals(9, bounds2.width);
    assertEquals(9, bounds29.width);
    assertEquals(9, bounds14.width);
    assertEquals(9, bounds8.width);
    assertEquals(9, bounds11.width);
    assertEquals(9, bounds30.width);
    assertEquals(9, bounds31.width);
    assertEquals(9, bounds16.width);
    assertEquals(9, bounds18.width);
    assertEquals(9, bounds32.width);
    assertEquals(9, bounds.width);
    assertEquals(9, bounds33.width);
    assertEquals(9, bounds19.width);
    assertEquals(9, bounds13.width);
    assertEquals(9, bounds7.width);
    assertEquals(9, bounds34.width);
    assertEquals(9, bounds35.width);
    assertEquals(9, bounds10.width);
    assertEquals(9, bounds36.width);
    assertEquals(9, bounds37.width);
    assertEquals(9, bounds20.width);
    assertEquals(9, bounds38.width);
    assertEquals(9, bounds39.width);
    assertEquals(9, bounds40.width);
    assertEquals(9, bounds21.width);
    assertEquals(9, bounds15.width);
    assertEquals(9, bounds41.width);
    assertEquals(9, bounds42.width);
    assertEquals(9, bounds17.width);
    assertEquals(9, bounds22.width);
    assertEquals(9, bounds43.width);
    assertEquals(9, bounds44.width);
    assertEquals(9, bounds45.width);
    assertEquals(9, ((Rectangle) bounds2D).width);
    assertEquals(9, ((Rectangle) bounds2D2).width);
    assertEquals(9, ((Rectangle) bounds2D3).width);
    assertEquals(9, ((Rectangle) bounds2D4).width);
    assertEquals(9, ((Rectangle) bounds2D6).width);
    assertEquals(9, ((Rectangle) bounds2D8).width);
    assertEquals(9, ((Rectangle) bounds2D9).width);
    assertEquals(9, ((Rectangle) bounds2D10).width);
    assertEquals(9, ((Rectangle) bounds2D11).width);
    assertEquals(9, ((Rectangle) bounds2D12).width);
    assertEquals(9, ((Rectangle) bounds2D13).width);
    assertEquals(9, ((Rectangle) bounds2D14).width);
    assertEquals(9, ((Rectangle) bounds2D5).width);
    assertEquals(9, ((Rectangle) bounds2D15).width);
    assertEquals(9, ((Rectangle) bounds2D16).width);
    assertEquals(9, ((Rectangle) bounds2D17).width);
    assertEquals(9, ((Rectangle) bounds2D18).width);
    assertEquals(9, ((Rectangle) bounds2D20).width);
    assertEquals(9, ((Rectangle) bounds2D21).width);
    assertEquals(9, ((Rectangle) bounds2D22).width);
    assertEquals(9, ((Rectangle) bounds2D23).width);
    assertEquals(9, ((Rectangle) bounds2D24).width);
    assertEquals(9, ((Rectangle) bounds2D25).width);
    assertEquals(9, ((Rectangle) bounds2D26).width);
    assertEquals(9, ((Rectangle) bounds2D27).width);
    assertEquals(9, ((Rectangle) bounds2D28).width);
    assertEquals(9, ((Rectangle) bounds2D29).width);
    assertEquals(9, ((Rectangle) bounds2D30).width);
    assertEquals(9, ((Rectangle) bounds2D31).width);
    assertEquals(9.0d, size4.getHeight());
    assertEquals(9.0d, size8.getHeight());
    assertEquals(9.0d, size3.getHeight());
    assertEquals(9.0d, size11.getHeight());
    assertEquals(9.0d, size7.getHeight());
    assertEquals(9.0d, size2.getHeight());
    assertEquals(9.0d, size14.getHeight());
    assertEquals(9.0d, size17.getHeight());
    assertEquals(9.0d, size20.getHeight());
    assertEquals(9.0d, size22.getHeight());
    assertEquals(9.0d, size10.getHeight());
    assertEquals(9.0d, size6.getHeight());
    assertEquals(9.0d, size24.getHeight());
    assertEquals(9.0d, size26.getHeight());
    assertEquals(9.0d, size.getHeight());
    assertEquals(9.0d, size28.getHeight());
    assertEquals(9.0d, size30.getHeight());
    assertEquals(9.0d, size13.getHeight());
    assertEquals(9.0d, size32.getHeight());
    assertEquals(9.0d, size34.getHeight());
    assertEquals(9.0d, size36.getHeight());
    assertEquals(9.0d, size16.getHeight());
    assertEquals(9.0d, size19.getHeight());
    assertEquals(9.0d, size4.getWidth());
    assertEquals(9.0d, size8.getWidth());
    assertEquals(9.0d, size3.getWidth());
    assertEquals(9.0d, size11.getWidth());
    assertEquals(9.0d, size7.getWidth());
    assertEquals(9.0d, size2.getWidth());
    assertEquals(9.0d, size14.getWidth());
    assertEquals(9.0d, size17.getWidth());
    assertEquals(9.0d, size20.getWidth());
    assertEquals(9.0d, size22.getWidth());
    assertEquals(9.0d, size10.getWidth());
    assertEquals(9.0d, size6.getWidth());
    assertEquals(9.0d, size24.getWidth());
    assertEquals(9.0d, size26.getWidth());
    assertEquals(9.0d, size.getWidth());
    assertEquals(9.0d, size28.getWidth());
    assertEquals(9.0d, size30.getWidth());
    assertEquals(9.0d, size13.getWidth());
    assertEquals(9.0d, size32.getWidth());
    assertEquals(9.0d, size34.getWidth());
    assertEquals(9.0d, size36.getWidth());
    assertEquals(9.0d, size16.getWidth());
    assertEquals(9.0d, size19.getWidth());
    assertEquals(9.0d, bounds6.getHeight());
    assertEquals(9.0d, bounds5.getHeight());
    assertEquals(9.0d, bounds4.getHeight());
    assertEquals(9.0d, bounds3.getHeight());
    assertEquals(9.0d, bounds9.getHeight());
    assertEquals(9.0d, bounds12.getHeight());
    assertEquals(9.0d, bounds2.getHeight());
    assertEquals(9.0d, bounds14.getHeight());
    assertEquals(9.0d, bounds8.getHeight());
    assertEquals(9.0d, bounds11.getHeight());
    assertEquals(9.0d, bounds16.getHeight());
    assertEquals(9.0d, bounds18.getHeight());
    assertEquals(9.0d, bounds.getHeight());
    assertEquals(9.0d, bounds19.getHeight());
    assertEquals(9.0d, bounds13.getHeight());
    assertEquals(9.0d, bounds7.getHeight());
    assertEquals(9.0d, bounds10.getHeight());
    assertEquals(9.0d, bounds20.getHeight());
    assertEquals(9.0d, bounds21.getHeight());
    assertEquals(9.0d, bounds15.getHeight());
    assertEquals(9.0d, bounds17.getHeight());
    assertEquals(9.0d, bounds22.getHeight());
    assertEquals(9.0d, bounds6.getWidth());
    assertEquals(9.0d, bounds5.getWidth());
    assertEquals(9.0d, bounds4.getWidth());
    assertEquals(9.0d, bounds3.getWidth());
    assertEquals(9.0d, bounds9.getWidth());
    assertEquals(9.0d, bounds12.getWidth());
    assertEquals(9.0d, bounds2.getWidth());
    assertEquals(9.0d, bounds14.getWidth());
    assertEquals(9.0d, bounds8.getWidth());
    assertEquals(9.0d, bounds11.getWidth());
    assertEquals(9.0d, bounds16.getWidth());
    assertEquals(9.0d, bounds18.getWidth());
    assertEquals(9.0d, bounds.getWidth());
    assertEquals(9.0d, bounds19.getWidth());
    assertEquals(9.0d, bounds13.getWidth());
    assertEquals(9.0d, bounds7.getWidth());
    assertEquals(9.0d, bounds10.getWidth());
    assertEquals(9.0d, bounds20.getWidth());
    assertEquals(9.0d, bounds21.getWidth());
    assertEquals(9.0d, bounds15.getWidth());
    assertEquals(9.0d, bounds17.getWidth());
    assertEquals(9.0d, bounds22.getWidth());
    assertEquals(9.0d, bounds2D3.getHeight());
    assertEquals(9.0d, bounds2D4.getHeight());
    assertEquals(9.0d, bounds2D9.getHeight());
    assertEquals(9.0d, bounds2D5.getHeight());
    assertEquals(9.0d, bounds2D18.getHeight());
    assertEquals(9.0d, bounds2D7.getHeight());
    assertEquals(9.0d, bounds2D27.getHeight());
    assertEquals(9.0d, bounds2D28.getHeight());
    assertEquals(9.0d, bounds2D19.getHeight());
    assertEquals(9.0d, bounds2D32.getHeight());
    assertEquals(9.0d, bounds2D33.getHeight());
    assertEquals(9.0d, frame5.getHeight());
    assertEquals(9.0d, frame3.getHeight());
    assertEquals(9.0d, frame.getHeight());
    assertEquals(9.0d, frame6.getHeight());
    assertEquals(9.0d, frame7.getHeight());
    assertEquals(9.0d, frame2.getHeight());
    assertEquals(9.0d, frame4.getHeight());
    assertEquals(9.0d, frame8.getHeight());
    assertEquals(9.0d, frame9.getHeight());
    assertEquals(9.0d, frame10.getHeight());
    assertEquals(9.0d, bounds2D3.getWidth());
    assertEquals(9.0d, bounds2D4.getWidth());
    assertEquals(9.0d, bounds2D9.getWidth());
    assertEquals(9.0d, bounds2D5.getWidth());
    assertEquals(9.0d, bounds2D18.getWidth());
    assertEquals(9.0d, bounds2D7.getWidth());
    assertEquals(9.0d, bounds2D27.getWidth());
    assertEquals(9.0d, bounds2D28.getWidth());
    assertEquals(9.0d, bounds2D19.getWidth());
    assertEquals(9.0d, bounds2D32.getWidth());
    assertEquals(9.0d, bounds2D33.getWidth());
    assertEquals(9.0d, frame5.getWidth());
    assertEquals(9.0d, frame3.getWidth());
    assertEquals(9.0d, frame.getWidth());
    assertEquals(9.0d, frame6.getWidth());
    assertEquals(9.0d, frame7.getWidth());
    assertEquals(9.0d, frame2.getWidth());
    assertEquals(9.0d, frame4.getWidth());
    assertEquals(9.0d, frame8.getWidth());
    assertEquals(9.0d, frame9.getWidth());
    assertEquals(9.0d, frame10.getWidth());
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D7).height);
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D19).height);
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D34).height);
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D7).width);
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D19).width);
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D34).width);
    assertFalse(bounds6.isEmpty());
    assertFalse(bounds5.isEmpty());
    assertFalse(bounds4.isEmpty());
    assertFalse(bounds3.isEmpty());
    assertFalse(bounds9.isEmpty());
    assertFalse(bounds12.isEmpty());
    assertFalse(bounds2.isEmpty());
    assertFalse(bounds14.isEmpty());
    assertFalse(bounds8.isEmpty());
    assertFalse(bounds11.isEmpty());
    assertFalse(bounds16.isEmpty());
    assertFalse(bounds18.isEmpty());
    assertFalse(bounds.isEmpty());
    assertFalse(bounds19.isEmpty());
    assertFalse(bounds13.isEmpty());
    assertFalse(bounds7.isEmpty());
    assertFalse(bounds10.isEmpty());
    assertFalse(bounds20.isEmpty());
    assertFalse(bounds21.isEmpty());
    assertFalse(bounds15.isEmpty());
    assertFalse(bounds17.isEmpty());
    assertFalse(bounds22.isEmpty());
    assertFalse(bounds2D3.isEmpty());
    assertFalse(bounds2D4.isEmpty());
    assertFalse(bounds2D9.isEmpty());
    assertFalse(bounds2D5.isEmpty());
    assertFalse(bounds2D18.isEmpty());
    assertFalse(bounds2D7.isEmpty());
    assertFalse(bounds2D27.isEmpty());
    assertFalse(bounds2D28.isEmpty());
    assertFalse(bounds2D19.isEmpty());
    assertFalse(bounds2D32.isEmpty());
    assertFalse(bounds2D33.isEmpty());
    assertFalse(frame5.isEmpty());
    assertFalse(frame3.isEmpty());
    assertFalse(frame.isEmpty());
    assertFalse(frame6.isEmpty());
    assertFalse(frame7.isEmpty());
    assertFalse(frame2.isEmpty());
    assertFalse(frame4.isEmpty());
    assertFalse(frame8.isEmpty());
    assertFalse(frame9.isEmpty());
    assertFalse(frame10.isEmpty());
    assertEquals(currentPoint2, currentPoint);
  }

  /**
   * Test {@link PageDrawer#curveTo(float, float, float, float, float, float)}.
   * <p>
   * Method under test:
   * {@link PageDrawer#curveTo(float, float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test curveTo(float, float, float, float, float, float)")
  void testCurveTo() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    Point p0 = new Point(1, 1);

    Point p1 = new Point(1, 1);

    Point p2 = new Point(1, 1);

    pageDrawer.appendRectangle(p0, p1, p2, new Point(1, 1));

    // Act
    pageDrawer.curveTo(10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Assert that nothing has changed
    GeneralPath linePath = pageDrawer.getLinePath();
    Rectangle bounds = linePath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D = bounds6.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds5.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds4.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds3.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    Rectangle bounds7 = bounds2D5.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D6 = bounds9.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = linePath.getBounds2D();
    Rectangle bounds10 = bounds2D7.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle2D bounds2D8 = bounds12.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D bounds2D9 = bounds2.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle bounds13 = bounds2D9.getBounds();
    Rectangle bounds14 = bounds13.getBounds();
    Rectangle2D bounds2D10 = bounds14.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D11 = bounds8.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds11.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    Rectangle bounds15 = frame.getBounds();
    Rectangle bounds16 = bounds15.getBounds();
    Rectangle2D bounds2D13 = bounds16.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    Rectangle2D frame2 = bounds.getFrame();
    Rectangle bounds17 = frame2.getBounds();
    Rectangle bounds18 = bounds17.getBounds();
    Rectangle2D bounds2D14 = bounds18.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle bounds19 = bounds2D4.getBounds();
    Rectangle2D bounds2D15 = bounds19.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds13.getBounds2D();
    assertTrue(bounds2D16 instanceof Rectangle);
    Rectangle2D bounds2D17 = bounds7.getBounds2D();
    assertTrue(bounds2D17 instanceof Rectangle);
    Rectangle2D bounds2D18 = bounds10.getBounds2D();
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D19 = bounds2D7.getBounds2D();
    Rectangle bounds20 = bounds2D19.getBounds();
    Rectangle2D bounds2D20 = bounds20.getBounds2D();
    assertTrue(bounds2D20 instanceof Rectangle);
    Rectangle2D frame3 = bounds3.getFrame();
    Rectangle bounds21 = frame3.getBounds();
    Rectangle2D bounds2D21 = bounds21.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D bounds2D22 = bounds15.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D bounds2D23 = bounds17.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    Rectangle2D frame4 = bounds2D7.getFrame();
    Rectangle bounds22 = frame4.getBounds();
    Rectangle2D bounds2D24 = bounds22.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D3.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D4.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D9.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D5.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D18.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D27.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D28.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    Point2D currentPoint = linePath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Point2D.Float);
    Rectangle2D bounds2D32 = frame.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D33 = frame2.getBounds2D();
    assertTrue(bounds2D33 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds4.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds2D9.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds2D5.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(frame4 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = bounds10.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Rectangle2D frame9 = frame.getFrame();
    assertTrue(frame9 instanceof Rectangle2D.Double);
    Rectangle2D frame10 = frame2.getFrame();
    assertTrue(frame10 instanceof Rectangle2D.Double);
    assertTrue(bounds2D7 instanceof Rectangle2D.Float);
    assertTrue(bounds2D19 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D34 = bounds2D19.getBounds2D();
    assertTrue(bounds2D34 instanceof Rectangle2D.Float);
    assertEquals(10.0d, currentPoint2.getX());
    assertEquals(10.0d, currentPoint2.getY());
    assertEquals(10.0d, bounds6.getMaxX());
    assertEquals(10.0d, bounds5.getMaxX());
    assertEquals(10.0d, bounds4.getMaxX());
    assertEquals(10.0d, bounds3.getMaxX());
    assertEquals(10.0d, bounds9.getMaxX());
    assertEquals(10.0d, bounds12.getMaxX());
    assertEquals(10.0d, bounds2.getMaxX());
    assertEquals(10.0d, bounds14.getMaxX());
    assertEquals(10.0d, bounds8.getMaxX());
    assertEquals(10.0d, bounds11.getMaxX());
    assertEquals(10.0d, bounds16.getMaxX());
    assertEquals(10.0d, bounds18.getMaxX());
    assertEquals(10.0d, bounds2D3.getMaxX());
    assertEquals(10.0d, bounds2D4.getMaxX());
    assertEquals(10.0d, bounds2D9.getMaxX());
    assertEquals(10.0d, bounds2D5.getMaxX());
    assertEquals(10.0d, bounds2D18.getMaxX());
    assertEquals(10.0d, bounds.getMaxX());
    assertEquals(10.0d, bounds2D7.getMaxX());
    assertEquals(10.0d, bounds2D27.getMaxX());
    assertEquals(10.0d, bounds2D28.getMaxX());
    assertEquals(10.0d, bounds2D19.getMaxX());
    assertEquals(10.0d, bounds2D32.getMaxX());
    assertEquals(10.0d, bounds2D33.getMaxX());
    assertEquals(10.0d, bounds19.getMaxX());
    assertEquals(10.0d, bounds13.getMaxX());
    assertEquals(10.0d, bounds7.getMaxX());
    assertEquals(10.0d, bounds10.getMaxX());
    assertEquals(10.0d, bounds20.getMaxX());
    assertEquals(10.0d, bounds21.getMaxX());
    assertEquals(10.0d, bounds15.getMaxX());
    assertEquals(10.0d, bounds17.getMaxX());
    assertEquals(10.0d, bounds22.getMaxX());
    assertEquals(10.0d, frame5.getMaxX());
    assertEquals(10.0d, frame3.getMaxX());
    assertEquals(10.0d, frame.getMaxX());
    assertEquals(10.0d, frame6.getMaxX());
    assertEquals(10.0d, frame7.getMaxX());
    assertEquals(10.0d, frame2.getMaxX());
    assertEquals(10.0d, frame4.getMaxX());
    assertEquals(10.0d, frame8.getMaxX());
    assertEquals(10.0d, frame9.getMaxX());
    assertEquals(10.0d, frame10.getMaxX());
    assertEquals(10.0d, bounds6.getMaxY());
    assertEquals(10.0d, bounds5.getMaxY());
    assertEquals(10.0d, bounds4.getMaxY());
    assertEquals(10.0d, bounds3.getMaxY());
    assertEquals(10.0d, bounds9.getMaxY());
    assertEquals(10.0d, bounds12.getMaxY());
    assertEquals(10.0d, bounds2.getMaxY());
    assertEquals(10.0d, bounds14.getMaxY());
    assertEquals(10.0d, bounds8.getMaxY());
    assertEquals(10.0d, bounds11.getMaxY());
    assertEquals(10.0d, bounds16.getMaxY());
    assertEquals(10.0d, bounds18.getMaxY());
    assertEquals(10.0d, bounds2D3.getMaxY());
    assertEquals(10.0d, bounds2D4.getMaxY());
    assertEquals(10.0d, bounds2D9.getMaxY());
    assertEquals(10.0d, bounds2D5.getMaxY());
    assertEquals(10.0d, bounds2D18.getMaxY());
    assertEquals(10.0d, bounds.getMaxY());
    assertEquals(10.0d, bounds2D7.getMaxY());
    assertEquals(10.0d, bounds2D27.getMaxY());
    assertEquals(10.0d, bounds2D28.getMaxY());
    assertEquals(10.0d, bounds2D19.getMaxY());
    assertEquals(10.0d, bounds2D32.getMaxY());
    assertEquals(10.0d, bounds2D33.getMaxY());
    assertEquals(10.0d, bounds19.getMaxY());
    assertEquals(10.0d, bounds13.getMaxY());
    assertEquals(10.0d, bounds7.getMaxY());
    assertEquals(10.0d, bounds10.getMaxY());
    assertEquals(10.0d, bounds20.getMaxY());
    assertEquals(10.0d, bounds21.getMaxY());
    assertEquals(10.0d, bounds15.getMaxY());
    assertEquals(10.0d, bounds17.getMaxY());
    assertEquals(10.0d, bounds22.getMaxY());
    assertEquals(10.0d, frame5.getMaxY());
    assertEquals(10.0d, frame3.getMaxY());
    assertEquals(10.0d, frame.getMaxY());
    assertEquals(10.0d, frame6.getMaxY());
    assertEquals(10.0d, frame7.getMaxY());
    assertEquals(10.0d, frame2.getMaxY());
    assertEquals(10.0d, frame4.getMaxY());
    assertEquals(10.0d, frame8.getMaxY());
    assertEquals(10.0d, frame9.getMaxY());
    assertEquals(10.0d, frame10.getMaxY());
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).x);
    assertEquals(10.0f, ((Point2D.Float) currentPoint2).y);
    assertEquals(5.5d, bounds6.getCenterX());
    assertEquals(5.5d, bounds5.getCenterX());
    assertEquals(5.5d, bounds4.getCenterX());
    assertEquals(5.5d, bounds3.getCenterX());
    assertEquals(5.5d, bounds9.getCenterX());
    assertEquals(5.5d, bounds12.getCenterX());
    assertEquals(5.5d, bounds2.getCenterX());
    assertEquals(5.5d, bounds14.getCenterX());
    assertEquals(5.5d, bounds8.getCenterX());
    assertEquals(5.5d, bounds11.getCenterX());
    assertEquals(5.5d, bounds16.getCenterX());
    assertEquals(5.5d, bounds18.getCenterX());
    assertEquals(5.5d, bounds2D3.getCenterX());
    assertEquals(5.5d, bounds2D4.getCenterX());
    assertEquals(5.5d, bounds2D9.getCenterX());
    assertEquals(5.5d, bounds2D5.getCenterX());
    assertEquals(5.5d, bounds2D18.getCenterX());
    assertEquals(5.5d, bounds.getCenterX());
    assertEquals(5.5d, bounds2D7.getCenterX());
    assertEquals(5.5d, bounds2D27.getCenterX());
    assertEquals(5.5d, bounds2D28.getCenterX());
    assertEquals(5.5d, bounds2D19.getCenterX());
    assertEquals(5.5d, bounds2D32.getCenterX());
    assertEquals(5.5d, bounds2D33.getCenterX());
    assertEquals(5.5d, bounds19.getCenterX());
    assertEquals(5.5d, bounds13.getCenterX());
    assertEquals(5.5d, bounds7.getCenterX());
    assertEquals(5.5d, bounds10.getCenterX());
    assertEquals(5.5d, bounds20.getCenterX());
    assertEquals(5.5d, bounds21.getCenterX());
    assertEquals(5.5d, bounds15.getCenterX());
    assertEquals(5.5d, bounds17.getCenterX());
    assertEquals(5.5d, bounds22.getCenterX());
    assertEquals(5.5d, frame5.getCenterX());
    assertEquals(5.5d, frame3.getCenterX());
    assertEquals(5.5d, frame.getCenterX());
    assertEquals(5.5d, frame6.getCenterX());
    assertEquals(5.5d, frame7.getCenterX());
    assertEquals(5.5d, frame2.getCenterX());
    assertEquals(5.5d, frame4.getCenterX());
    assertEquals(5.5d, frame8.getCenterX());
    assertEquals(5.5d, frame9.getCenterX());
    assertEquals(5.5d, frame10.getCenterX());
    assertEquals(5.5d, bounds6.getCenterY());
    assertEquals(5.5d, bounds5.getCenterY());
    assertEquals(5.5d, bounds4.getCenterY());
    assertEquals(5.5d, bounds3.getCenterY());
    assertEquals(5.5d, bounds9.getCenterY());
    assertEquals(5.5d, bounds12.getCenterY());
    assertEquals(5.5d, bounds2.getCenterY());
    assertEquals(5.5d, bounds14.getCenterY());
    assertEquals(5.5d, bounds8.getCenterY());
    assertEquals(5.5d, bounds11.getCenterY());
    assertEquals(5.5d, bounds16.getCenterY());
    assertEquals(5.5d, bounds18.getCenterY());
    assertEquals(5.5d, bounds2D3.getCenterY());
    assertEquals(5.5d, bounds2D4.getCenterY());
    assertEquals(5.5d, bounds2D9.getCenterY());
    assertEquals(5.5d, bounds2D5.getCenterY());
    assertEquals(5.5d, bounds2D18.getCenterY());
    assertEquals(5.5d, bounds.getCenterY());
    assertEquals(5.5d, bounds2D7.getCenterY());
    assertEquals(5.5d, bounds2D27.getCenterY());
    assertEquals(5.5d, bounds2D28.getCenterY());
    assertEquals(5.5d, bounds2D19.getCenterY());
    assertEquals(5.5d, bounds2D32.getCenterY());
    assertEquals(5.5d, bounds2D33.getCenterY());
    assertEquals(5.5d, bounds19.getCenterY());
    assertEquals(5.5d, bounds13.getCenterY());
    assertEquals(5.5d, bounds7.getCenterY());
    assertEquals(5.5d, bounds10.getCenterY());
    assertEquals(5.5d, bounds20.getCenterY());
    assertEquals(5.5d, bounds21.getCenterY());
    assertEquals(5.5d, bounds15.getCenterY());
    assertEquals(5.5d, bounds17.getCenterY());
    assertEquals(5.5d, bounds22.getCenterY());
    assertEquals(5.5d, frame5.getCenterY());
    assertEquals(5.5d, frame3.getCenterY());
    assertEquals(5.5d, frame.getCenterY());
    assertEquals(5.5d, frame6.getCenterY());
    assertEquals(5.5d, frame7.getCenterY());
    assertEquals(5.5d, frame2.getCenterY());
    assertEquals(5.5d, frame4.getCenterY());
    assertEquals(5.5d, frame8.getCenterY());
    assertEquals(5.5d, frame9.getCenterY());
    assertEquals(5.5d, frame10.getCenterY());
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    Dimension size5 = size4.getSize();
    assertEquals(9, size5.height);
    Dimension size6 = bounds3.getSize();
    Dimension size7 = size6.getSize();
    Dimension size8 = size7.getSize();
    Dimension size9 = size8.getSize();
    assertEquals(9, size9.height);
    assertEquals(9, size4.height);
    Dimension size10 = bounds4.getSize();
    Dimension size11 = size10.getSize();
    Dimension size12 = size11.getSize();
    assertEquals(9, size12.height);
    assertEquals(9, size8.height);
    assertEquals(9, size3.height);
    Dimension size13 = bounds10.getSize();
    Dimension size14 = size13.getSize();
    Dimension size15 = size14.getSize();
    assertEquals(9, size15.height);
    Dimension size16 = ((Rectangle) bounds2D9).getSize();
    Dimension size17 = size16.getSize();
    Dimension size18 = size17.getSize();
    assertEquals(9, size18.height);
    Dimension size19 = ((Rectangle) bounds2D5).getSize();
    Dimension size20 = size19.getSize();
    Dimension size21 = size20.getSize();
    assertEquals(9, size21.height);
    Dimension size22 = bounds5.getSize();
    Dimension size23 = size22.getSize();
    assertEquals(9, size23.height);
    assertEquals(9, size11.height);
    assertEquals(9, size7.height);
    Dimension size24 = bounds8.getSize();
    Dimension size25 = size24.getSize();
    assertEquals(9, size25.height);
    Dimension size26 = bounds11.getSize();
    Dimension size27 = size26.getSize();
    assertEquals(9, size27.height);
    assertEquals(9, size2.height);
    Dimension size28 = bounds13.getSize();
    Dimension size29 = size28.getSize();
    assertEquals(9, size29.height);
    Dimension size30 = bounds7.getSize();
    Dimension size31 = size30.getSize();
    assertEquals(9, size31.height);
    assertEquals(9, size14.height);
    Dimension size32 = bounds15.getSize();
    Dimension size33 = size32.getSize();
    assertEquals(9, size33.height);
    Dimension size34 = bounds17.getSize();
    Dimension size35 = size34.getSize();
    assertEquals(9, size35.height);
    Dimension size36 = ((Rectangle) bounds2D4).getSize();
    Dimension size37 = size36.getSize();
    assertEquals(9, size37.height);
    assertEquals(9, size17.height);
    assertEquals(9, size20.height);
    Dimension size38 = bounds6.getSize();
    assertEquals(9, size38.height);
    assertEquals(9, size22.height);
    assertEquals(9, size10.height);
    assertEquals(9, size6.height);
    Dimension size39 = bounds9.getSize();
    assertEquals(9, size39.height);
    Dimension size40 = bounds12.getSize();
    assertEquals(9, size40.height);
    Dimension size41 = bounds14.getSize();
    assertEquals(9, size41.height);
    assertEquals(9, size24.height);
    assertEquals(9, size26.height);
    Dimension size42 = bounds16.getSize();
    assertEquals(9, size42.height);
    Dimension size43 = bounds18.getSize();
    assertEquals(9, size43.height);
    assertEquals(9, size.height);
    Dimension size44 = bounds19.getSize();
    assertEquals(9, size44.height);
    assertEquals(9, size28.height);
    assertEquals(9, size30.height);
    assertEquals(9, size13.height);
    Dimension size45 = bounds20.getSize();
    assertEquals(9, size45.height);
    Dimension size46 = bounds21.getSize();
    assertEquals(9, size46.height);
    assertEquals(9, size32.height);
    assertEquals(9, size34.height);
    Dimension size47 = bounds22.getSize();
    assertEquals(9, size47.height);
    Dimension size48 = ((Rectangle) bounds2D3).getSize();
    assertEquals(9, size48.height);
    assertEquals(9, size36.height);
    assertEquals(9, size16.height);
    assertEquals(9, size19.height);
    Dimension size49 = ((Rectangle) bounds2D18).getSize();
    assertEquals(9, size49.height);
    Dimension size50 = ((Rectangle) bounds2D27).getSize();
    assertEquals(9, size50.height);
    Dimension size51 = ((Rectangle) bounds2D28).getSize();
    assertEquals(9, size51.height);
    assertEquals(9, size5.width);
    assertEquals(9, size9.width);
    assertEquals(9, size4.width);
    assertEquals(9, size12.width);
    assertEquals(9, size8.width);
    assertEquals(9, size3.width);
    assertEquals(9, size15.width);
    assertEquals(9, size18.width);
    assertEquals(9, size21.width);
    assertEquals(9, size23.width);
    assertEquals(9, size11.width);
    assertEquals(9, size7.width);
    assertEquals(9, size25.width);
    assertEquals(9, size27.width);
    assertEquals(9, size2.width);
    assertEquals(9, size29.width);
    assertEquals(9, size31.width);
    assertEquals(9, size14.width);
    assertEquals(9, size33.width);
    assertEquals(9, size35.width);
    assertEquals(9, size37.width);
    assertEquals(9, size17.width);
    assertEquals(9, size20.width);
    assertEquals(9, size38.width);
    assertEquals(9, size22.width);
    assertEquals(9, size10.width);
    assertEquals(9, size6.width);
    assertEquals(9, size39.width);
    assertEquals(9, size40.width);
    assertEquals(9, size41.width);
    assertEquals(9, size24.width);
    assertEquals(9, size26.width);
    assertEquals(9, size42.width);
    assertEquals(9, size43.width);
    assertEquals(9, size.width);
    assertEquals(9, size44.width);
    assertEquals(9, size28.width);
    assertEquals(9, size30.width);
    assertEquals(9, size13.width);
    assertEquals(9, size45.width);
    assertEquals(9, size46.width);
    assertEquals(9, size32.width);
    assertEquals(9, size34.width);
    assertEquals(9, size47.width);
    assertEquals(9, size48.width);
    assertEquals(9, size36.width);
    assertEquals(9, size16.width);
    assertEquals(9, size19.width);
    assertEquals(9, size49.width);
    assertEquals(9, size50.width);
    assertEquals(9, size51.width);
    Rectangle bounds23 = bounds6.getBounds();
    assertEquals(9, bounds23.height);
    assertEquals(9, bounds6.height);
    assertEquals(9, bounds5.height);
    assertEquals(9, bounds4.height);
    Rectangle bounds24 = bounds9.getBounds();
    assertEquals(9, bounds24.height);
    Rectangle bounds25 = bounds12.getBounds();
    assertEquals(9, bounds25.height);
    assertEquals(9, bounds3.height);
    Rectangle bounds26 = bounds14.getBounds();
    assertEquals(9, bounds26.height);
    assertEquals(9, bounds9.height);
    assertEquals(9, bounds12.height);
    Rectangle bounds27 = bounds16.getBounds();
    assertEquals(9, bounds27.height);
    Rectangle bounds28 = bounds18.getBounds();
    assertEquals(9, bounds28.height);
    assertEquals(9, bounds2.height);
    Rectangle bounds29 = bounds19.getBounds();
    assertEquals(9, bounds29.height);
    assertEquals(9, bounds14.height);
    assertEquals(9, bounds8.height);
    assertEquals(9, bounds11.height);
    Rectangle bounds30 = bounds20.getBounds();
    assertEquals(9, bounds30.height);
    Rectangle bounds31 = bounds21.getBounds();
    assertEquals(9, bounds31.height);
    assertEquals(9, bounds16.height);
    assertEquals(9, bounds18.height);
    Rectangle bounds32 = bounds22.getBounds();
    assertEquals(9, bounds32.height);
    assertEquals(9, bounds.height);
    Rectangle bounds33 = bounds2D3.getBounds();
    assertEquals(9, bounds33.height);
    assertEquals(9, bounds19.height);
    assertEquals(9, bounds13.height);
    assertEquals(9, bounds7.height);
    Rectangle bounds34 = bounds2D17.getBounds();
    assertEquals(9, bounds34.height);
    Rectangle bounds35 = bounds2D18.getBounds();
    assertEquals(9, bounds35.height);
    assertEquals(9, bounds10.height);
    Rectangle bounds36 = bounds2D27.getBounds();
    assertEquals(9, bounds36.height);
    Rectangle bounds37 = bounds2D28.getBounds();
    assertEquals(9, bounds37.height);
    assertEquals(9, bounds20.height);
    Rectangle bounds38 = bounds2D32.getBounds();
    assertEquals(9, bounds38.height);
    Rectangle bounds39 = bounds2D33.getBounds();
    assertEquals(9, bounds39.height);
    Rectangle bounds40 = frame5.getBounds();
    assertEquals(9, bounds40.height);
    assertEquals(9, bounds21.height);
    assertEquals(9, bounds15.height);
    Rectangle bounds41 = frame6.getBounds();
    assertEquals(9, bounds41.height);
    Rectangle bounds42 = frame7.getBounds();
    assertEquals(9, bounds42.height);
    assertEquals(9, bounds17.height);
    assertEquals(9, bounds22.height);
    Rectangle bounds43 = frame8.getBounds();
    assertEquals(9, bounds43.height);
    Rectangle bounds44 = frame9.getBounds();
    assertEquals(9, bounds44.height);
    Rectangle bounds45 = frame10.getBounds();
    assertEquals(9, bounds45.height);
    assertEquals(9, ((Rectangle) bounds2D).height);
    assertEquals(9, ((Rectangle) bounds2D2).height);
    assertEquals(9, ((Rectangle) bounds2D3).height);
    assertEquals(9, ((Rectangle) bounds2D4).height);
    assertEquals(9, ((Rectangle) bounds2D6).height);
    assertEquals(9, ((Rectangle) bounds2D8).height);
    assertEquals(9, ((Rectangle) bounds2D9).height);
    assertEquals(9, ((Rectangle) bounds2D10).height);
    assertEquals(9, ((Rectangle) bounds2D11).height);
    assertEquals(9, ((Rectangle) bounds2D12).height);
    assertEquals(9, ((Rectangle) bounds2D13).height);
    assertEquals(9, ((Rectangle) bounds2D14).height);
    assertEquals(9, ((Rectangle) bounds2D5).height);
    assertEquals(9, ((Rectangle) bounds2D15).height);
    assertEquals(9, ((Rectangle) bounds2D16).height);
    assertEquals(9, ((Rectangle) bounds2D17).height);
    assertEquals(9, ((Rectangle) bounds2D18).height);
    assertEquals(9, ((Rectangle) bounds2D20).height);
    assertEquals(9, ((Rectangle) bounds2D21).height);
    assertEquals(9, ((Rectangle) bounds2D22).height);
    assertEquals(9, ((Rectangle) bounds2D23).height);
    assertEquals(9, ((Rectangle) bounds2D24).height);
    assertEquals(9, ((Rectangle) bounds2D25).height);
    assertEquals(9, ((Rectangle) bounds2D26).height);
    assertEquals(9, ((Rectangle) bounds2D27).height);
    assertEquals(9, ((Rectangle) bounds2D28).height);
    assertEquals(9, ((Rectangle) bounds2D29).height);
    assertEquals(9, ((Rectangle) bounds2D30).height);
    assertEquals(9, ((Rectangle) bounds2D31).height);
    assertEquals(9, bounds23.width);
    assertEquals(9, bounds6.width);
    assertEquals(9, bounds5.width);
    assertEquals(9, bounds4.width);
    assertEquals(9, bounds24.width);
    assertEquals(9, bounds25.width);
    assertEquals(9, bounds3.width);
    assertEquals(9, bounds26.width);
    assertEquals(9, bounds9.width);
    assertEquals(9, bounds12.width);
    assertEquals(9, bounds27.width);
    assertEquals(9, bounds28.width);
    assertEquals(9, bounds2.width);
    assertEquals(9, bounds29.width);
    assertEquals(9, bounds14.width);
    assertEquals(9, bounds8.width);
    assertEquals(9, bounds11.width);
    assertEquals(9, bounds30.width);
    assertEquals(9, bounds31.width);
    assertEquals(9, bounds16.width);
    assertEquals(9, bounds18.width);
    assertEquals(9, bounds32.width);
    assertEquals(9, bounds.width);
    assertEquals(9, bounds33.width);
    assertEquals(9, bounds19.width);
    assertEquals(9, bounds13.width);
    assertEquals(9, bounds7.width);
    assertEquals(9, bounds34.width);
    assertEquals(9, bounds35.width);
    assertEquals(9, bounds10.width);
    assertEquals(9, bounds36.width);
    assertEquals(9, bounds37.width);
    assertEquals(9, bounds20.width);
    assertEquals(9, bounds38.width);
    assertEquals(9, bounds39.width);
    assertEquals(9, bounds40.width);
    assertEquals(9, bounds21.width);
    assertEquals(9, bounds15.width);
    assertEquals(9, bounds41.width);
    assertEquals(9, bounds42.width);
    assertEquals(9, bounds17.width);
    assertEquals(9, bounds22.width);
    assertEquals(9, bounds43.width);
    assertEquals(9, bounds44.width);
    assertEquals(9, bounds45.width);
    assertEquals(9, ((Rectangle) bounds2D).width);
    assertEquals(9, ((Rectangle) bounds2D2).width);
    assertEquals(9, ((Rectangle) bounds2D3).width);
    assertEquals(9, ((Rectangle) bounds2D4).width);
    assertEquals(9, ((Rectangle) bounds2D6).width);
    assertEquals(9, ((Rectangle) bounds2D8).width);
    assertEquals(9, ((Rectangle) bounds2D9).width);
    assertEquals(9, ((Rectangle) bounds2D10).width);
    assertEquals(9, ((Rectangle) bounds2D11).width);
    assertEquals(9, ((Rectangle) bounds2D12).width);
    assertEquals(9, ((Rectangle) bounds2D13).width);
    assertEquals(9, ((Rectangle) bounds2D14).width);
    assertEquals(9, ((Rectangle) bounds2D5).width);
    assertEquals(9, ((Rectangle) bounds2D15).width);
    assertEquals(9, ((Rectangle) bounds2D16).width);
    assertEquals(9, ((Rectangle) bounds2D17).width);
    assertEquals(9, ((Rectangle) bounds2D18).width);
    assertEquals(9, ((Rectangle) bounds2D20).width);
    assertEquals(9, ((Rectangle) bounds2D21).width);
    assertEquals(9, ((Rectangle) bounds2D22).width);
    assertEquals(9, ((Rectangle) bounds2D23).width);
    assertEquals(9, ((Rectangle) bounds2D24).width);
    assertEquals(9, ((Rectangle) bounds2D25).width);
    assertEquals(9, ((Rectangle) bounds2D26).width);
    assertEquals(9, ((Rectangle) bounds2D27).width);
    assertEquals(9, ((Rectangle) bounds2D28).width);
    assertEquals(9, ((Rectangle) bounds2D29).width);
    assertEquals(9, ((Rectangle) bounds2D30).width);
    assertEquals(9, ((Rectangle) bounds2D31).width);
    assertEquals(9.0d, size4.getHeight());
    assertEquals(9.0d, size8.getHeight());
    assertEquals(9.0d, size3.getHeight());
    assertEquals(9.0d, size11.getHeight());
    assertEquals(9.0d, size7.getHeight());
    assertEquals(9.0d, size2.getHeight());
    assertEquals(9.0d, size14.getHeight());
    assertEquals(9.0d, size17.getHeight());
    assertEquals(9.0d, size20.getHeight());
    assertEquals(9.0d, size22.getHeight());
    assertEquals(9.0d, size10.getHeight());
    assertEquals(9.0d, size6.getHeight());
    assertEquals(9.0d, size24.getHeight());
    assertEquals(9.0d, size26.getHeight());
    assertEquals(9.0d, size.getHeight());
    assertEquals(9.0d, size28.getHeight());
    assertEquals(9.0d, size30.getHeight());
    assertEquals(9.0d, size13.getHeight());
    assertEquals(9.0d, size32.getHeight());
    assertEquals(9.0d, size34.getHeight());
    assertEquals(9.0d, size36.getHeight());
    assertEquals(9.0d, size16.getHeight());
    assertEquals(9.0d, size19.getHeight());
    assertEquals(9.0d, size4.getWidth());
    assertEquals(9.0d, size8.getWidth());
    assertEquals(9.0d, size3.getWidth());
    assertEquals(9.0d, size11.getWidth());
    assertEquals(9.0d, size7.getWidth());
    assertEquals(9.0d, size2.getWidth());
    assertEquals(9.0d, size14.getWidth());
    assertEquals(9.0d, size17.getWidth());
    assertEquals(9.0d, size20.getWidth());
    assertEquals(9.0d, size22.getWidth());
    assertEquals(9.0d, size10.getWidth());
    assertEquals(9.0d, size6.getWidth());
    assertEquals(9.0d, size24.getWidth());
    assertEquals(9.0d, size26.getWidth());
    assertEquals(9.0d, size.getWidth());
    assertEquals(9.0d, size28.getWidth());
    assertEquals(9.0d, size30.getWidth());
    assertEquals(9.0d, size13.getWidth());
    assertEquals(9.0d, size32.getWidth());
    assertEquals(9.0d, size34.getWidth());
    assertEquals(9.0d, size36.getWidth());
    assertEquals(9.0d, size16.getWidth());
    assertEquals(9.0d, size19.getWidth());
    assertEquals(9.0d, bounds6.getHeight());
    assertEquals(9.0d, bounds5.getHeight());
    assertEquals(9.0d, bounds4.getHeight());
    assertEquals(9.0d, bounds3.getHeight());
    assertEquals(9.0d, bounds9.getHeight());
    assertEquals(9.0d, bounds12.getHeight());
    assertEquals(9.0d, bounds2.getHeight());
    assertEquals(9.0d, bounds14.getHeight());
    assertEquals(9.0d, bounds8.getHeight());
    assertEquals(9.0d, bounds11.getHeight());
    assertEquals(9.0d, bounds16.getHeight());
    assertEquals(9.0d, bounds18.getHeight());
    assertEquals(9.0d, bounds.getHeight());
    assertEquals(9.0d, bounds19.getHeight());
    assertEquals(9.0d, bounds13.getHeight());
    assertEquals(9.0d, bounds7.getHeight());
    assertEquals(9.0d, bounds10.getHeight());
    assertEquals(9.0d, bounds20.getHeight());
    assertEquals(9.0d, bounds21.getHeight());
    assertEquals(9.0d, bounds15.getHeight());
    assertEquals(9.0d, bounds17.getHeight());
    assertEquals(9.0d, bounds22.getHeight());
    assertEquals(9.0d, bounds6.getWidth());
    assertEquals(9.0d, bounds5.getWidth());
    assertEquals(9.0d, bounds4.getWidth());
    assertEquals(9.0d, bounds3.getWidth());
    assertEquals(9.0d, bounds9.getWidth());
    assertEquals(9.0d, bounds12.getWidth());
    assertEquals(9.0d, bounds2.getWidth());
    assertEquals(9.0d, bounds14.getWidth());
    assertEquals(9.0d, bounds8.getWidth());
    assertEquals(9.0d, bounds11.getWidth());
    assertEquals(9.0d, bounds16.getWidth());
    assertEquals(9.0d, bounds18.getWidth());
    assertEquals(9.0d, bounds.getWidth());
    assertEquals(9.0d, bounds19.getWidth());
    assertEquals(9.0d, bounds13.getWidth());
    assertEquals(9.0d, bounds7.getWidth());
    assertEquals(9.0d, bounds10.getWidth());
    assertEquals(9.0d, bounds20.getWidth());
    assertEquals(9.0d, bounds21.getWidth());
    assertEquals(9.0d, bounds15.getWidth());
    assertEquals(9.0d, bounds17.getWidth());
    assertEquals(9.0d, bounds22.getWidth());
    assertEquals(9.0d, bounds2D3.getHeight());
    assertEquals(9.0d, bounds2D4.getHeight());
    assertEquals(9.0d, bounds2D9.getHeight());
    assertEquals(9.0d, bounds2D5.getHeight());
    assertEquals(9.0d, bounds2D18.getHeight());
    assertEquals(9.0d, bounds2D7.getHeight());
    assertEquals(9.0d, bounds2D27.getHeight());
    assertEquals(9.0d, bounds2D28.getHeight());
    assertEquals(9.0d, bounds2D19.getHeight());
    assertEquals(9.0d, bounds2D32.getHeight());
    assertEquals(9.0d, bounds2D33.getHeight());
    assertEquals(9.0d, frame5.getHeight());
    assertEquals(9.0d, frame3.getHeight());
    assertEquals(9.0d, frame.getHeight());
    assertEquals(9.0d, frame6.getHeight());
    assertEquals(9.0d, frame7.getHeight());
    assertEquals(9.0d, frame2.getHeight());
    assertEquals(9.0d, frame4.getHeight());
    assertEquals(9.0d, frame8.getHeight());
    assertEquals(9.0d, frame9.getHeight());
    assertEquals(9.0d, frame10.getHeight());
    assertEquals(9.0d, bounds2D3.getWidth());
    assertEquals(9.0d, bounds2D4.getWidth());
    assertEquals(9.0d, bounds2D9.getWidth());
    assertEquals(9.0d, bounds2D5.getWidth());
    assertEquals(9.0d, bounds2D18.getWidth());
    assertEquals(9.0d, bounds2D7.getWidth());
    assertEquals(9.0d, bounds2D27.getWidth());
    assertEquals(9.0d, bounds2D28.getWidth());
    assertEquals(9.0d, bounds2D19.getWidth());
    assertEquals(9.0d, bounds2D32.getWidth());
    assertEquals(9.0d, bounds2D33.getWidth());
    assertEquals(9.0d, frame5.getWidth());
    assertEquals(9.0d, frame3.getWidth());
    assertEquals(9.0d, frame.getWidth());
    assertEquals(9.0d, frame6.getWidth());
    assertEquals(9.0d, frame7.getWidth());
    assertEquals(9.0d, frame2.getWidth());
    assertEquals(9.0d, frame4.getWidth());
    assertEquals(9.0d, frame8.getWidth());
    assertEquals(9.0d, frame9.getWidth());
    assertEquals(9.0d, frame10.getWidth());
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D7).height);
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D19).height);
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D34).height);
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D7).width);
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D19).width);
    assertEquals(9.0f, ((Rectangle2D.Float) bounds2D34).width);
    assertFalse(bounds6.isEmpty());
    assertFalse(bounds5.isEmpty());
    assertFalse(bounds4.isEmpty());
    assertFalse(bounds3.isEmpty());
    assertFalse(bounds9.isEmpty());
    assertFalse(bounds12.isEmpty());
    assertFalse(bounds2.isEmpty());
    assertFalse(bounds14.isEmpty());
    assertFalse(bounds8.isEmpty());
    assertFalse(bounds11.isEmpty());
    assertFalse(bounds16.isEmpty());
    assertFalse(bounds18.isEmpty());
    assertFalse(bounds.isEmpty());
    assertFalse(bounds19.isEmpty());
    assertFalse(bounds13.isEmpty());
    assertFalse(bounds7.isEmpty());
    assertFalse(bounds10.isEmpty());
    assertFalse(bounds20.isEmpty());
    assertFalse(bounds21.isEmpty());
    assertFalse(bounds15.isEmpty());
    assertFalse(bounds17.isEmpty());
    assertFalse(bounds22.isEmpty());
    assertFalse(bounds2D3.isEmpty());
    assertFalse(bounds2D4.isEmpty());
    assertFalse(bounds2D9.isEmpty());
    assertFalse(bounds2D5.isEmpty());
    assertFalse(bounds2D18.isEmpty());
    assertFalse(bounds2D7.isEmpty());
    assertFalse(bounds2D27.isEmpty());
    assertFalse(bounds2D28.isEmpty());
    assertFalse(bounds2D19.isEmpty());
    assertFalse(bounds2D32.isEmpty());
    assertFalse(bounds2D33.isEmpty());
    assertFalse(frame5.isEmpty());
    assertFalse(frame3.isEmpty());
    assertFalse(frame.isEmpty());
    assertFalse(frame6.isEmpty());
    assertFalse(frame7.isEmpty());
    assertFalse(frame2.isEmpty());
    assertFalse(frame4.isEmpty());
    assertFalse(frame8.isEmpty());
    assertFalse(frame9.isEmpty());
    assertFalse(frame10.isEmpty());
    assertEquals(currentPoint2, currentPoint);
  }

  /**
   * Test {@link PageDrawer#getCurrentPoint()}.
   * <p>
   * Method under test: {@link PageDrawer#getCurrentPoint()}
   */
  @Test
  @DisplayName("Test getCurrentPoint()")
  void testGetCurrentPoint() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    // Act and Assert
    assertNull(
        (new PageDrawer(new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f)))
            .getCurrentPoint());
  }

  /**
   * Test {@link PageDrawer#showForm(PDFormXObject)}.
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup}
   * {@link PDOptionalContentGroup#getRenderState(RenderDestination)} return
   * {@code OFF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showForm(PDFormXObject)}
   */
  @Test
  @DisplayName("Test showForm(PDFormXObject); given PDOptionalContentGroup getRenderState(RenderDestination) return 'OFF'")
  void testShowForm_givenPDOptionalContentGroupGetRenderStateReturnOff() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(PDOptionalContentGroup.RenderState.OFF);
    PDFormXObject form = mock(PDFormXObject.class);
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    // Act
    pageDrawer.showForm(form);

    // Assert that nothing has changed
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(eq(RenderDestination.EXPORT));
  }

  /**
   * Test {@link PageDrawer#showForm(PDFormXObject)}.
   * <ul>
   *   <li>Then calls {@link PDContentStream#getContentsForStreamParsing()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showForm(PDFormXObject)}
   */
  @Test
  @DisplayName("Test showForm(PDFormXObject); then calls getContentsForStreamParsing()")
  void testShowForm_thenCallsGetContentsForStreamParsing() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(PDOptionalContentGroup.RenderState.ON);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getLength()).thenReturn(3L);
    PDFormXObject form = mock(PDFormXObject.class);
    when(form.getContentsForStreamParsing())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    when(form.getBBox()).thenReturn(PDRectangle.A0);
    when(form.getResources()).thenReturn(new PDResources());
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getCOSObject()).thenReturn(cosStream);
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    // Act
    pageDrawer.showForm(form);

    // Assert
    verify(form).getContentsForStreamParsing();
    verify(cosStream).getLength();
    verify(form).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
    verify(form).getResources();
    verify(pdOptionalContentGroup).getRenderState(eq(RenderDestination.EXPORT));
  }

  /**
   * Test {@link PageDrawer#showForm(PDFormXObject)}.
   * <ul>
   *   <li>When {@link PDFormXObject} {@link PDXObject#getCOSObject()} return
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then calls {@link PDXObject#getCOSObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showForm(PDFormXObject)}
   */
  @Test
  @DisplayName("Test showForm(PDFormXObject); when PDFormXObject getCOSObject() return COSStream(); then calls getCOSObject()")
  void testShowForm_whenPDFormXObjectGetCOSObjectReturnCOSStream_thenCallsGetCOSObject() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(PDOptionalContentGroup.RenderState.ON);
    PDFormXObject form = mock(PDFormXObject.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    // Act
    pageDrawer.showForm(form);

    // Assert
    verify(form).getCOSObject();
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(eq(RenderDestination.EXPORT));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup}
   * {@link PDOptionalContentGroup#getRenderState(RenderDestination)} return
   * {@code OFF}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); given PDOptionalContentGroup getRenderState(RenderDestination) return 'OFF'")
  void testShowTransparencyGroup_givenPDOptionalContentGroupGetRenderStateReturnOff() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(PDOptionalContentGroup.RenderState.OFF);
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert that nothing has changed
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(xobject).getCOSObject();
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(eq(RenderDestination.EXPORT));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup}
   * {@link PDOptionalContentGroup#getRenderState(RenderDestination)} return
   * {@code ON}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); given PDOptionalContentGroup getRenderState(RenderDestination) return 'ON'")
  void testShowTransparencyGroup_givenPDOptionalContentGroupGetRenderStateReturnOn() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(PDOptionalContentGroup.RenderState.ON);
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.transform(Mockito.<Matrix>any())).thenReturn(new GeneralPath(1));
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(pdRectangle);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(pdRectangle).transform(isA(Matrix.class));
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(eq(RenderDestination.EXPORT));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup#PDOptionalContentGroup(String)} with
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); given PDOptionalContentGroup(String) with 'Name'")
  void testShowTransparencyGroup_givenPDOptionalContentGroupWithName() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.transform(Mockito.<Matrix>any())).thenReturn(new GeneralPath(1));
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(pdRectangle);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(new PDOptionalContentGroup("Name"));
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(pdRectangle).transform(isA(Matrix.class));
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   * <ul>
   *   <li>Given
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); given PDOptionalContentMembershipDictionary()")
  void testShowTransparencyGroup_givenPDOptionalContentMembershipDictionary() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.transform(Mockito.<Matrix>any())).thenReturn(new GeneralPath(1));
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(pdRectangle);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(new PDOptionalContentMembershipDictionary());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(pdRectangle).transform(isA(Matrix.class));
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); given PDRectangle()")
  void testShowTransparencyGroup_givenPDRectangle() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(new PDRectangle());
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(null);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   * <ul>
   *   <li>Then calls {@link PDRectangle#transform(Matrix)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); then calls transform(Matrix)")
  void testShowTransparencyGroup_thenCallsTransform() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.transform(Mockito.<Matrix>any())).thenReturn(new GeneralPath(1));
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(pdRectangle);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(null);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(pdRectangle).transform(isA(Matrix.class));
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   * <ul>
   *   <li>When {@link PDTransparencyGroup} {@link PDFormXObject#getBBox()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); when PDTransparencyGroup getBBox() return 'null'")
  void testShowTransparencyGroup_whenPDTransparencyGroupGetBBoxReturnNull() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(null);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(null);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }

  /**
   * Test
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)")
  void testShowTransparencyGroupOnGraphics() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(PDOptionalContentGroup.RenderState.ON);
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.transform(Mockito.<Matrix>any())).thenReturn(new GeneralPath(1));
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(pdRectangle);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, new GroupGraphics(new BufferedImage(1, 1, 1), null));

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(pdRectangle).transform(isA(Matrix.class));
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(eq(RenderDestination.EXPORT));
  }

  /**
   * Test
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)")
  void testShowTransparencyGroupOnGraphics2() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(PDOptionalContentGroup.RenderState.OFF);
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, new GroupGraphics(new BufferedImage(1, 1, 1), null));

    // Assert that nothing has changed
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(xobject).getCOSObject();
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(eq(RenderDestination.EXPORT));
  }

  /**
   * Test
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup#PDOptionalContentGroup(String)} with
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); given PDOptionalContentGroup(String) with 'Name'")
  void testShowTransparencyGroupOnGraphics_givenPDOptionalContentGroupWithName() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.transform(Mockito.<Matrix>any())).thenReturn(new GeneralPath(1));
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(pdRectangle);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(new PDOptionalContentGroup("Name"));
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, new GroupGraphics(new BufferedImage(1, 1, 1), null));

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(pdRectangle).transform(isA(Matrix.class));
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }

  /**
   * Test
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <ul>
   *   <li>Given
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); given PDOptionalContentMembershipDictionary()")
  void testShowTransparencyGroupOnGraphics_givenPDOptionalContentMembershipDictionary() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.transform(Mockito.<Matrix>any())).thenReturn(new GeneralPath(1));
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(pdRectangle);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(new PDOptionalContentMembershipDictionary());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, new GroupGraphics(new BufferedImage(1, 1, 1), null));

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(pdRectangle).transform(isA(Matrix.class));
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }

  /**
   * Test
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); given PDRectangle()")
  void testShowTransparencyGroupOnGraphics_givenPDRectangle() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(new PDRectangle());
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(null);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, new GroupGraphics(new BufferedImage(1, 1, 1), null));

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }

  /**
   * Test
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <ul>
   *   <li>Then calls {@link PDRectangle#transform(Matrix)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); then calls transform(Matrix)")
  void testShowTransparencyGroupOnGraphics_thenCallsTransform() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.transform(Mockito.<Matrix>any())).thenReturn(new GeneralPath(1));
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(pdRectangle);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(null);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, new GroupGraphics(new BufferedImage(1, 1, 1), null));

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(pdRectangle).transform(isA(Matrix.class));
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }

  /**
   * Test
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <ul>
   *   <li>When {@link PDTransparencyGroup} {@link PDFormXObject#getBBox()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); when PDTransparencyGroup getBBox() return 'null'")
  void testShowTransparencyGroupOnGraphics_whenPDTransparencyGroupGetBBoxReturnNull() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getCOSObject()).thenReturn(new COSStream());
    when(form.getBBox()).thenReturn(null);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(null);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    (new PDResources()).add(xobject, "Prefix");

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, new GroupGraphics(new BufferedImage(1, 1, 1), null));

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(xobject).getCOSObject();
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }
}
