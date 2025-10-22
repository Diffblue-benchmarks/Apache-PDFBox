package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import java.awt.geom.Point2D.Float;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
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
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDTransparencyGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup.RenderState;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentMembershipDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.AnnotationFilter;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.<init>(PageDrawerParameters)"})
  void testNewPageDrawer() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    // Act
    PageDrawer actualPageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Assert
    assertNull(actualPageDrawer.getGraphics());
    assertNull(actualPageDrawer.getCurrentPoint());
    assertNull(actualPageDrawer.getCurrentPage());
    assertNull(actualPageDrawer.getResources());
    assertNull(actualPageDrawer.getGraphicsState());
    assertNull(actualPageDrawer.getInitialMatrix());
    assertEquals(0, actualPageDrawer.getGraphicsStackSize());
    assertEquals(0, actualPageDrawer.getLevel());
    assertSame(renderer, actualPageDrawer.getRenderer());
  }

  /**
   * Test {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}.
   * <p>
   * Method under test: {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}
   */
  @Test
  @DisplayName("Test drawPage(Graphics2D, PDRectangle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.drawPage(Graphics2D, PDRectangle)"})
  void testDrawPage() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PDPage page = new PDPage();
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, page, true, RenderDestination.EXPORT, null, 10.0f));
    GroupGraphics g = mock(GroupGraphics.class);
    when(g.getClip()).thenReturn(new Polygon());
    doNothing().when(g).addRenderingHints(Mockito.<Map<Object, Object>>any());
    doNothing().when(g).scale(anyDouble(), anyDouble());
    doNothing().when(g).translate(anyDouble(), anyDouble());
    when(g.getTransform()).thenReturn(new AffineTransform());

    // Act
    pageDrawer.drawPage(g, PDRectangle.A0);

    // Assert
    verify(g).addRenderingHints((Map<?, ?>) isNull());
    verify(g).getClip();
    verify(g).getTransform();
    verify(g).scale(eq(1.0d), eq(-1.0d));
    verify(g, atLeast(1)).translate(anyDouble(), anyDouble());
    Paint nonStrokingPaint = pageDrawer.getNonStrokingPaint();
    assertTrue(nonStrokingPaint instanceof Color);
    assertEquals(nonStrokingPaint, ((Color) nonStrokingPaint).darker());
    assertSame(page, pageDrawer.getCurrentPage());
  }

  /**
   * Test {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}.
   * <p>
   * Method under test: {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}
   */
  @Test
  @DisplayName("Test drawPage(Graphics2D, PDRectangle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.drawPage(Graphics2D, PDRectangle)"})
  void testDrawPage2() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PDPage page = new PDPage(new COSDictionary());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, page, true, RenderDestination.EXPORT, null, 10.0f));
    GroupGraphics g = mock(GroupGraphics.class);
    when(g.getClip()).thenReturn(new Polygon());
    doNothing().when(g).addRenderingHints(Mockito.<Map<Object, Object>>any());
    doNothing().when(g).scale(anyDouble(), anyDouble());
    doNothing().when(g).translate(anyDouble(), anyDouble());
    when(g.getTransform()).thenReturn(new AffineTransform());

    // Act
    pageDrawer.drawPage(g, PDRectangle.A0);

    // Assert
    verify(g).addRenderingHints((Map<?, ?>) isNull());
    verify(g).getClip();
    verify(g).getTransform();
    verify(g).scale(eq(1.0d), eq(-1.0d));
    verify(g, atLeast(1)).translate(anyDouble(), anyDouble());
    Paint nonStrokingPaint = pageDrawer.getNonStrokingPaint();
    assertTrue(nonStrokingPaint instanceof Color);
    assertEquals(nonStrokingPaint, ((Color) nonStrokingPaint).darker());
    assertSame(page, pageDrawer.getCurrentPage());
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   * <ul>
   *   <li>Then return brighter Alpha is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName("Test getPaint(PDColor); then return brighter Alpha is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_thenReturnBrighterAlphaIsZero() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(new COSArray(), null));

    // Assert
    assertTrue(actualPaint instanceof Color);
    Color brighterResult = ((Color) actualPaint).brighter();
    assertEquals(0, brighterResult.getAlpha());
    assertEquals(0, ((Color) actualPaint).getAlpha());
    assertEquals(0, ((Color) actualPaint).getRGB());
    assertEquals(197379, brighterResult.getRGB());
    assertEquals(2, brighterResult.getTransparency());
    assertEquals(2, actualPaint.getTransparency());
    assertEquals(actualPaint, ((Color) actualPaint).darker());
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link COSArray#COSArray()} and colorSpace is {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName("Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is INSTANCE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
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
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link COSArray#COSArray()} and colorSpace is {@link PDCalGray#PDCalGray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName("Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDCalGray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
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
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link COSArray#COSArray()} and colorSpace is {@link PDCalRGB#PDCalRGB()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName("Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDCalRGB()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
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
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link COSArray#COSArray()} and colorSpace is {@link PDLab#PDLab()}.</li>
   *   <li>Then return {@link Color#black}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName("Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDLab(); then return black")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.transferClip(Graphics2D)"})
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
   * Method under test: {@link PageDrawer#showFontGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName("Test showFontGlyph(Matrix, PDFont, int, Vector); then calls getFontMatrix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showFontGlyph(Matrix, PDFont, int, Vector)"})
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
   * Method under test: {@link PageDrawer#appendRectangle(Point2D, Point2D, Point2D, Point2D)}
   */
  @Test
  @DisplayName("Test appendRectangle(Point2D, Point2D, Point2D, Point2D)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.appendRectangle(Point2D, Point2D, Point2D, Point2D)"})
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

    // Assert
    Point2D currentPoint = pageDrawer.getLinePath().getCurrentPoint();
    assertTrue(currentPoint instanceof Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Float);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Paint PageDrawer.getNonStrokingPaint()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.clip(int)", "AnnotationFilter PageDrawer.getAnnotationFilter()",
      "Graphics2D PageDrawer.getGraphics()", "GeneralPath PageDrawer.getLinePath()",
      "PDFRenderer PageDrawer.getRenderer()", "void PageDrawer.setAnnotationFilter(AnnotationFilter)"})
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
    Graphics2D actualGraphics = pageDrawer.getGraphics();
    GeneralPath actualLinePath = pageDrawer.getLinePath();
    PDFRenderer actualRenderer = pageDrawer.getRenderer();

    // Assert
    Rectangle bounds = actualLinePath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualLinePath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualGraphics);
    assertNull(actualLinePath.getCurrentPoint());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.moveTo(float, float)"})
  void testMoveTo() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Act
    pageDrawer.moveTo(10.0f, 10.0f);

    // Assert
    Point2D currentPoint = pageDrawer.getLinePath().getCurrentPoint();
    assertTrue(currentPoint instanceof Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Float);
    assertEquals(10.0d, currentPoint2.getX());
    assertEquals(10.0d, currentPoint2.getY());
    assertEquals(10.0f, ((Float) currentPoint2).x);
    assertEquals(10.0f, ((Float) currentPoint2).y);
    assertEquals(currentPoint2, currentPoint);
  }

  /**
   * Test {@link PageDrawer#lineTo(float, float)}.
   * <p>
   * Method under test: {@link PageDrawer#lineTo(float, float)}
   */
  @Test
  @DisplayName("Test lineTo(float, float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.lineTo(float, float)"})
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

    // Assert
    Point2D currentPoint = pageDrawer.getLinePath().getCurrentPoint();
    assertTrue(currentPoint instanceof Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Float);
    assertEquals(10.0d, currentPoint2.getX());
    assertEquals(10.0d, currentPoint2.getY());
    assertEquals(10.0f, ((Float) currentPoint2).x);
    assertEquals(10.0f, ((Float) currentPoint2).y);
    assertEquals(currentPoint2, currentPoint);
  }

  /**
   * Test {@link PageDrawer#curveTo(float, float, float, float, float, float)}.
   * <p>
   * Method under test: {@link PageDrawer#curveTo(float, float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test curveTo(float, float, float, float, float, float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.curveTo(float, float, float, float, float, float)"})
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

    // Assert
    Point2D currentPoint = pageDrawer.getLinePath().getCurrentPoint();
    assertTrue(currentPoint instanceof Float);
    Point2D currentPoint2 = pageDrawer.getCurrentPoint();
    assertTrue(currentPoint2 instanceof Float);
    assertEquals(10.0d, currentPoint2.getX());
    assertEquals(10.0d, currentPoint2.getY());
    assertEquals(10.0f, ((Float) currentPoint2).x);
    assertEquals(10.0f, ((Float) currentPoint2).y);
    assertEquals(currentPoint2, currentPoint);
  }

  /**
   * Test {@link PageDrawer#getCurrentPoint()}.
   * <p>
   * Method under test: {@link PageDrawer#getCurrentPoint()}
   */
  @Test
  @DisplayName("Test getCurrentPoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Point2D PageDrawer.getCurrentPoint()"})
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
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link PDFormXObject} {@link PDXObject#getCOSObject()} return {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showForm(PDFormXObject)}
   */
  @Test
  @DisplayName("Test showForm(PDFormXObject); given COSStream(); when PDFormXObject getCOSObject() return COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showForm(PDFormXObject)"})
  void testShowForm_givenCOSStream_whenPDFormXObjectGetCOSObjectReturnCOSStream() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any())).thenReturn(RenderState.ON);
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
   * Test {@link PageDrawer#showForm(PDFormXObject)}.
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup} {@link PDOptionalContentGroup#getRenderState(RenderDestination)} return {@code OFF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showForm(PDFormXObject)}
   */
  @Test
  @DisplayName("Test showForm(PDFormXObject); given PDOptionalContentGroup getRenderState(RenderDestination) return 'OFF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showForm(PDFormXObject)"})
  void testShowForm_givenPDOptionalContentGroupGetRenderStateReturnOff() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any())).thenReturn(RenderState.OFF);
    PDFormXObject form = mock(PDFormXObject.class);
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    // Act
    pageDrawer.showForm(form);

    // Assert
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(eq(RenderDestination.EXPORT));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup} {@link PDOptionalContentGroup#getRenderState(RenderDestination)} return {@code OFF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); given PDOptionalContentGroup getRenderState(RenderDestination) return 'OFF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
  void testShowTransparencyGroup_givenPDOptionalContentGroupGetRenderStateReturnOff() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any())).thenReturn(RenderState.OFF);
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

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(xobject).getCOSObject();
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(eq(RenderDestination.EXPORT));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup} {@link PDOptionalContentGroup#getRenderState(RenderDestination)} return {@code ON}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); given PDOptionalContentGroup getRenderState(RenderDestination) return 'ON'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
  void testShowTransparencyGroup_givenPDOptionalContentGroupGetRenderStateReturnOn() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any())).thenReturn(RenderState.ON);
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
   *   <li>Given {@link PDOptionalContentGroup#PDOptionalContentGroup(String)} with {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); given PDOptionalContentGroup(String) with 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
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
   *   <li>Given {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); given PDOptionalContentMembershipDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
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
   * Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); given PDRectangle()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
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
   * Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); then calls transform(Matrix)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
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
   *   <li>When {@link PDTransparencyGroup} {@link PDFormXObject#getBBox()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); when PDTransparencyGroup getBBox() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
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
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"})
  void testShowTransparencyGroupOnGraphics() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any())).thenReturn(RenderState.ON);
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
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"})
  void testShowTransparencyGroupOnGraphics2() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer pageDrawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    pageDrawer.processPage(new PDPage());
    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any())).thenReturn(RenderState.OFF);
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

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(xobject).getCOSObject();
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(eq(RenderDestination.EXPORT));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup#PDOptionalContentGroup(String)} with {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); given PDOptionalContentGroup(String) with 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"})
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
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <ul>
   *   <li>Given {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); given PDOptionalContentMembershipDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"})
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
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); given PDRectangle()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"})
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
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <ul>
   *   <li>Then calls {@link PDRectangle#transform(Matrix)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); then calls transform(Matrix)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"})
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
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   * <ul>
   *   <li>When {@link PDTransparencyGroup} {@link PDFormXObject#getBBox()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); when PDTransparencyGroup getBBox() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"})
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
