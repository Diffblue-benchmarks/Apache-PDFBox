package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileRGB;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.geom.Point2D.Float;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.cff.CFFCIDFont;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.pdmodel.graphics.color.PDSeparation;
import org.apache.pdfbox.pdmodel.graphics.color.PDTristimulus;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDTransparencyGroup;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup.RenderState;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
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
   *
   * <p>Method under test: {@link PageDrawer#PageDrawer(PageDrawerParameters)}
   */
  @Test
  @DisplayName("Test new PageDrawer(PageDrawerParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.<init>(PageDrawerParameters)"})
  void testNewPageDrawer() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    // Act
    PageDrawer actualPageDrawer = new PageDrawer(parameters);

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
   *
   * <p>Method under test: {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}
   */
  @Test
  @DisplayName("Test drawPage(Graphics2D, PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.drawPage(Graphics2D, PDRectangle)"})
  void testDrawPage() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PDPage page = new PDPage(new COSDictionary());

    PageDrawerParameters parameters =
        new PageDrawerParameters(renderer, page, true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    GroupGraphics g = mock(GroupGraphics.class);
    when(g.getClip()).thenReturn(new Ellipse2D.Double());
    doNothing().when(g).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(g).scale(anyDouble(), anyDouble());
    doNothing().when(g).translate(anyDouble(), anyDouble());
    when(g.getTransform()).thenReturn(new AffineTransform());

    // Act
    pageDrawer.drawPage(g, PDRectangle.A0);

    // Assert
    verify(g).addRenderingHints((Map<?, ?>) isNull());
    verify(g).getClip();
    verify(g).getTransform();
    verify(g).scale(1.0d, -1.0d);
    verify(g, atLeast(1)).translate(anyDouble(), anyDouble());
    Paint nonStrokingPaint = pageDrawer.getNonStrokingPaint();
    assertTrue(nonStrokingPaint instanceof Color);
    PDGraphicsState graphicsState = pageDrawer.getGraphicsState();
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals(1, graphicsState.getCurrentClippingPaths().size());
    Color actualDarkerResult = ((Color) nonStrokingPaint).darker();
    assertEquals(nonStrokingPaint, actualDarkerResult);
    assertSame(page, pageDrawer.getCurrentPage());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
  }

  /**
   * Test {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}.
   *
   * <p>Method under test: {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}
   */
  @Test
  @DisplayName("Test drawPage(Graphics2D, PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.drawPage(Graphics2D, PDRectangle)"})
  void testDrawPage2() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    ArrayList<PDStream> contents = new ArrayList<>();
    page.setContents(contents);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            new PDFRenderer(new PDDocument()), page, true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    GroupGraphics g = mock(GroupGraphics.class);
    when(g.getClip()).thenReturn(new Ellipse2D.Double());
    doNothing().when(g).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(g).scale(anyDouble(), anyDouble());
    doNothing().when(g).translate(anyDouble(), anyDouble());
    when(g.getTransform()).thenReturn(new AffineTransform());

    // Act
    pageDrawer.drawPage(g, PDRectangle.A0);

    // Assert
    verify(g).addRenderingHints((Map<?, ?>) isNull());
    verify(g).getClip();
    verify(g).getTransform();
    verify(g).scale(1.0d, -1.0d);
    verify(g, atLeast(1)).translate(anyDouble(), anyDouble());
    PDGraphicsState graphicsState = pageDrawer.getGraphicsState();
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    float[][] values = pageDrawer.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(contents, ((COSArray) getResult).toList());
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Annotations is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}
   */
  @Test
  @DisplayName("Test drawPage(Graphics2D, PDRectangle); given PDPage() Annotations is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.drawPage(Graphics2D, PDRectangle)"})
  void testDrawPage_givenPDPageAnnotationsIsArrayList() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            new PDFRenderer(new PDDocument()), page, true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    GroupGraphics g = mock(GroupGraphics.class);
    when(g.getClip()).thenReturn(new Ellipse2D.Double());
    doNothing().when(g).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(g).scale(anyDouble(), anyDouble());
    doNothing().when(g).translate(anyDouble(), anyDouble());
    when(g.getTransform()).thenReturn(new AffineTransform());

    // Act
    pageDrawer.drawPage(g, PDRectangle.A0);

    // Assert
    verify(g).addRenderingHints((Map<?, ?>) isNull());
    verify(g).getClip();
    verify(g).getTransform();
    verify(g).scale(1.0d, -1.0d);
    verify(g, atLeast(1)).translate(anyDouble(), anyDouble());
    float[][] values = pageDrawer.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    PDGraphicsState graphicsState = pageDrawer.getGraphicsState();
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test drawPage(Graphics2D, PDRectangle); given PDPage() CropBox is A0; then array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.drawPage(Graphics2D, PDRectangle)"})
  void testDrawPage_givenPDPageCropBoxIsA0_thenArrayLengthIsThree() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            new PDFRenderer(new PDDocument()), page, true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    GroupGraphics g = mock(GroupGraphics.class);
    when(g.getClip()).thenReturn(new Ellipse2D.Double());
    doNothing().when(g).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(g).scale(anyDouble(), anyDouble());
    doNothing().when(g).translate(anyDouble(), anyDouble());
    when(g.getTransform()).thenReturn(new AffineTransform());

    // Act
    pageDrawer.drawPage(g, PDRectangle.A0);

    // Assert
    verify(g).addRenderingHints((Map<?, ?>) isNull());
    verify(g).getClip();
    verify(g).getTransform();
    verify(g).scale(1.0d, -1.0d);
    verify(g, atLeast(1)).translate(anyDouble(), anyDouble());
    assertEquals(3, pageDrawer.getInitialMatrix().getValues().length);
  }

  /**
   * Test {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#drawPage(Graphics2D, PDRectangle)}
   */
  @Test
  @DisplayName("Test drawPage(Graphics2D, PDRectangle); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.drawPage(Graphics2D, PDRectangle)"})
  void testDrawPage_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            new PDFRenderer(new PDDocument()), null, true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    GroupGraphics g = mock(GroupGraphics.class);
    when(g.getClip()).thenReturn(new Ellipse2D.Double());
    doNothing().when(g).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(g).scale(anyDouble(), anyDouble());
    doNothing().when(g).translate(anyDouble(), anyDouble());
    when(g.getTransform()).thenReturn(new AffineTransform());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pageDrawer.drawPage(g, PDRectangle.A0));
    verify(g).addRenderingHints((Map<?, ?>) isNull());
    verify(g).getClip();
    verify(g).getTransform();
    verify(g).scale(1.0d, -1.0d);
    verify(g, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When {@link PDCalRGB#PDCalRGB()} Matrix is {@link Matrix#Matrix()}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName(
      "Test getPaint(PDColor); given Matrix(); when PDCalRGB() Matrix is Matrix(); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_givenMatrix_whenPDCalRGBMatrixIsMatrix_thenReturnArrayLengthIsThree()
      throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    PDCalRGB colorSpace = new PDCalRGB();
    colorSpace.setMatrix(new Matrix());
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    Paint actualPaint = pageDrawer.getPaint(color);

    // Assert
    assertTrue(actualPaint instanceof Color);
    ColorSpace colorSpace2 = ((Color) actualPaint).getColorSpace();
    assertTrue(colorSpace2 instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace2).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   *
   * <ul>
   *   <li>Given {@code None}.
   *   <li>When {@link PDSeparation#PDSeparation()} ColorantName is {@code None}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName("Test getPaint(PDColor); given 'None'; when PDSeparation() ColorantName is 'None'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_givenNone_whenPDSeparationColorantNameIsNone() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    PDSeparation colorSpace = new PDSeparation();
    colorSpace.setColorantName("None");
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    Paint actualPaint = pageDrawer.getPaint(color);

    // Assert
    assertTrue(actualPaint instanceof Color);
    ColorSpace colorSpace2 = ((Color) actualPaint).getColorSpace();
    assertTrue(colorSpace2 instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace2).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    Color brighterResult = ((Color) actualPaint).brighter();
    Color brighterResult2 = brighterResult.brighter();
    assertEquals(brighterResult2.darker(), brighterResult2.darker());
    assertEquals(actualPaint, ((Color) actualPaint).darker());
    assertSame(colorSpace2, brighterResult2.getColorSpace());
    assertSame(colorSpace2, brighterResult.getColorSpace());
    assertSame(colorSpace2, brighterResult.darker().getColorSpace());
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PDCalGray#PDCalGray()} Gamma is one.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName(
      "Test getPaint(PDColor); given one; when PDCalGray() Gamma is one; then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_givenOne_whenPDCalGrayGammaIsOne_thenReturnArrayLengthIsThree()
      throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    PDCalGray colorSpace = new PDCalGray();
    colorSpace.setGamma(1.0f);
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    Paint actualPaint = pageDrawer.getPaint(color);

    // Assert
    assertTrue(actualPaint instanceof Color);
    ColorSpace colorSpace2 = ((Color) actualPaint).getColorSpace();
    assertTrue(colorSpace2 instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace2).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   *
   * <ul>
   *   <li>Given {@link PDGamma#PDGamma()}.
   *   <li>Then return RGB is minus seven hundred sixty-nine.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName(
      "Test getPaint(PDColor); given PDGamma(); then return RGB is minus seven hundred sixty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_givenPDGamma_thenReturnRgbIsMinusSevenHundredSixtyNine() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    PDCalRGB colorSpace = new PDCalRGB();
    colorSpace.setGamma(new PDGamma());
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    Paint actualPaint = pageDrawer.getPaint(color);

    // Assert
    assertTrue(actualPaint instanceof Color);
    assertEquals(-769, ((Color) actualPaint).getRGB());
    assertEquals(252, ((Color) actualPaint).getGreen());
    assertEquals(255, ((Color) actualPaint).getBlue());
    assertEquals(255, ((Color) actualPaint).getRed());
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   *
   * <ul>
   *   <li>Given {@link PDTristimulus#PDTristimulus()}.
   *   <li>When {@link PDCalGray#PDCalGray()} WhitePoint is {@link PDTristimulus#PDTristimulus()}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName(
      "Test getPaint(PDColor); given PDTristimulus(); when PDCalGray() WhitePoint is PDTristimulus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_givenPDTristimulus_whenPDCalGrayWhitePointIsPDTristimulus() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    PDCalGray colorSpace = new PDCalGray();
    colorSpace.setWhitePoint(new PDTristimulus());
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    Paint actualPaint = pageDrawer.getPaint(color);

    // Assert
    assertTrue(actualPaint instanceof Color);
    ColorSpace colorSpace2 = ((Color) actualPaint).getColorSpace();
    assertTrue(colorSpace2 instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace2).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   *
   * <ul>
   *   <li>Given {@link PDTristimulus#PDTristimulus()}.
   *   <li>When {@link PDCalRGB#PDCalRGB()} WhitePoint is {@link PDTristimulus#PDTristimulus()}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName(
      "Test getPaint(PDColor); given PDTristimulus(); when PDCalRGB() WhitePoint is PDTristimulus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_givenPDTristimulus_whenPDCalRGBWhitePointIsPDTristimulus() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    PDCalRGB colorSpace = new PDCalRGB();
    colorSpace.setWhitePoint(new PDTristimulus());
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    Paint actualPaint = pageDrawer.getPaint(color);

    // Assert
    assertTrue(actualPaint instanceof Color);
    ColorSpace colorSpace2 = ((Color) actualPaint).getColorSpace();
    assertTrue(colorSpace2 instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace2).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   *
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName(
      "Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_whenPDColorWithArrayIsCOSArrayAndColorSpaceIsInstance() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    // Act
    Paint actualPaint = pageDrawer.getPaint(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    assertTrue(actualPaint instanceof Color);
    assertEquals(((Color) actualPaint).black, actualPaint);
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   *
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName(
      "Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_whenPDColorWithArrayIsCOSArrayAndColorSpaceIsNull() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);
    PDColor color = new PDColor(new COSArray(), null);

    // Act
    Paint actualPaint = pageDrawer.getPaint(color);

    // Assert
    assertTrue(actualPaint instanceof Color);
    ColorSpace colorSpace = ((Color) actualPaint).getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    Color brighterResult = ((Color) actualPaint).brighter();
    Color brighterResult2 = brighterResult.brighter();
    assertEquals(brighterResult2.darker(), brighterResult2.darker());
    assertEquals(actualPaint, ((Color) actualPaint).darker());
    assertSame(colorSpace, brighterResult2.getColorSpace());
    assertSame(colorSpace, brighterResult.getColorSpace());
    assertSame(colorSpace, brighterResult.darker().getColorSpace());
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   *
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@link PDCalGray#PDCalGray()}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName(
      "Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDCalGray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_whenPDColorWithArrayIsCOSArrayAndColorSpaceIsPDCalGray() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);
    COSArray array = new COSArray();
    PDColor color = new PDColor(array, new PDCalGray());

    // Act
    Paint actualPaint = pageDrawer.getPaint(color);

    // Assert
    assertTrue(actualPaint instanceof Color);
    ColorSpace colorSpace = ((Color) actualPaint).getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   *
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@link PDCalRGB#PDCalRGB()}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName(
      "Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDCalRGB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_whenPDColorWithArrayIsCOSArrayAndColorSpaceIsPDCalRGB() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);
    COSArray array = new COSArray();
    PDColor color = new PDColor(array, new PDCalRGB());

    // Act
    Paint actualPaint = pageDrawer.getPaint(color);

    // Assert
    assertTrue(actualPaint instanceof Color);
    ColorSpace colorSpace = ((Color) actualPaint).getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
  }

  /**
   * Test {@link PageDrawer#getPaint(PDColor)}.
   *
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@link PDLab#PDLab()}.
   *   <li>Then return {@link Color#black}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getPaint(PDColor)}
   */
  @Test
  @DisplayName(
      "Test getPaint(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDLab(); then return black")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getPaint(PDColor)"})
  void testGetPaint_whenPDColorWithArrayIsCOSArrayAndColorSpaceIsPDLab_thenReturnBlack()
      throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);
    COSArray array = new COSArray();
    PDColor color = new PDColor(array, new PDLab());

    // Act
    Paint actualPaint = pageDrawer.getPaint(color);

    // Assert
    assertTrue(actualPaint instanceof Color);
    assertEquals(((Color) actualPaint).black, actualPaint);
  }

  /**
   * Test {@link PageDrawer#transferClip(Graphics2D)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link GroupGraphics#addRenderingHints(Map)}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#transferClip(Graphics2D)}
   */
  @Test
  @DisplayName("Test transferClip(Graphics2D); given HashMap(); then calls addRenderingHints(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.transferClip(Graphics2D)"})
  void testTransferClip_givenHashMap_thenCallsAddRenderingHints() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    GroupGraphics graphics = mock(GroupGraphics.class);
    doNothing().when(graphics).addRenderingHints(Mockito.<Map<?, ?>>any());
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
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link PDMMType1Font#getFontBoxFont()}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showFontGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName(
      "Test showFontGlyph(Matrix, PDFont, int, Vector); given 'false'; then calls getFontBoxFont()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showFontGlyph(Matrix, PDFont, int, Vector)"})
  void testShowFontGlyph_givenFalse_thenCallsGetFontBoxFont() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    Matrix textRenderingMatrix = mock(Matrix.class);
    when(textRenderingMatrix.createAffineTransform()).thenReturn(new AffineTransform());

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDMMType1Font font = mock(PDMMType1Font.class);
    when(font.getNormalizedPath(anyInt())).thenReturn(null);
    when(font.hasGlyph(anyInt())).thenReturn(false);
    when(font.getName()).thenReturn("Name");
    when(font.getFontBoxFont()).thenReturn(new CFFCIDFont());
    when(font.getFontMatrix()).thenReturn(matrix);

    // Act
    pageDrawer.showFontGlyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert
    verify(font).getFontBoxFont();
    verify(font).getFontMatrix();
    verify(font).getName();
    verify(font).getNormalizedPath(1);
    verify(font).hasGlyph(1);
    verify(textRenderingMatrix).createAffineTransform();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PageDrawer#showFontGlyph(Matrix, PDFont, int, Vector)}.
   *
   * <ul>
   *   <li>Then calls {@link PDMMType1Font#getFontMatrix()}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showFontGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName("Test showFontGlyph(Matrix, PDFont, int, Vector); then calls getFontMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showFontGlyph(Matrix, PDFont, int, Vector)"})
  void testShowFontGlyph_thenCallsGetFontMatrix() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    Matrix textRenderingMatrix = mock(Matrix.class);
    when(textRenderingMatrix.createAffineTransform()).thenReturn(new AffineTransform());

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDMMType1Font font = mock(PDMMType1Font.class);
    when(font.getNormalizedPath(anyInt())).thenReturn(null);
    when(font.hasGlyph(anyInt())).thenReturn(true);
    when(font.getFontMatrix()).thenReturn(matrix);

    // Act
    pageDrawer.showFontGlyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert
    verify(font).getFontMatrix();
    verify(font).getNormalizedPath(1);
    verify(font).hasGlyph(1);
    verify(textRenderingMatrix).createAffineTransform();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PageDrawer#showType3Glyph(Matrix, PDType3Font, int, Vector)}.
   *
   * <ul>
   *   <li>When {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showType3Glyph(Matrix, PDType3Font, int, Vector)}
   */
  @Test
  @DisplayName(
      "Test showType3Glyph(Matrix, PDType3Font, int, Vector); when PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showType3Glyph(Matrix, PDType3Font, int, Vector)"})
  void testShowType3Glyph_whenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());
    Matrix textRenderingMatrix = new Matrix();
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act
    pageDrawer.showType3Glyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert that nothing has changed
    assertEquals(1.0f, textRenderingMatrix.getScaleX());
    assertEquals(1.0f, textRenderingMatrix.getScaleY());
    assertEquals(1.0f, textRenderingMatrix.getScalingFactorX());
    assertEquals(1.0f, textRenderingMatrix.getScalingFactorY());
    float[][] values = textRenderingMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(textRenderingMatrix, pageDrawer.getCurrentPage().getMatrix());
    assertEquals(
        textRenderingMatrix, pageDrawer.getGraphicsState().getCurrentTransformationMatrix());
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PageDrawer#appendRectangle(Point2D, Point2D, Point2D, Point2D)}.
   *
   * <p>Method under test: {@link PageDrawer#appendRectangle(Point2D, Point2D, Point2D, Point2D)}
   */
  @Test
  @DisplayName("Test appendRectangle(Point2D, Point2D, Point2D, Point2D)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.appendRectangle(Point2D, Point2D, Point2D, Point2D)"})
  void testAppendRectangle() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);
    Double p0 = new Double();
    Double p1 = new Double();
    Double p2 = new Double();

    // Act
    pageDrawer.appendRectangle(p0, p1, p2, new Double());

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
   *
   * <ul>
   *   <li>Then return {@link Color}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#getNonStrokingPaint()}
   */
  @Test
  @DisplayName("Test getNonStrokingPaint(); then return Color")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PageDrawer.getNonStrokingPaint()"})
  void testGetNonStrokingPaint_thenReturnColor() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    // Act
    Paint actualNonStrokingPaint = pageDrawer.getNonStrokingPaint();

    // Assert
    assertTrue(actualNonStrokingPaint instanceof Color);
    assertEquals(((Color) actualNonStrokingPaint).black, actualNonStrokingPaint);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageDrawer#setAnnotationFilter(AnnotationFilter)}
   *   <li>{@link PageDrawer#getAnnotationFilter()}
   *   <li>{@link PageDrawer#getGraphics()}
   *   <li>{@link PageDrawer#getLinePath()}
   *   <li>{@link PageDrawer#getRenderer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageDrawer.clip(int)",
    "AnnotationFilter PageDrawer.getAnnotationFilter()",
    "Graphics2D PageDrawer.getGraphics()",
    "GeneralPath PageDrawer.getLinePath()",
    "PDFRenderer PageDrawer.getRenderer()",
    "void PageDrawer.setAnnotationFilter(AnnotationFilter)"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);

    // Act
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
    assertTrue(frame instanceof Rectangle2D.Double);
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
   *
   * <p>Method under test: {@link PageDrawer#moveTo(float, float)}
   */
  @Test
  @DisplayName("Test moveTo(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.moveTo(float, float)"})
  void testMoveTo() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

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
   *
   * <p>Method under test: {@link PageDrawer#lineTo(float, float)}
   */
  @Test
  @DisplayName("Test lineTo(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.lineTo(float, float)"})
  void testLineTo() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    Double p0 = new Double();
    Double p1 = new Double();
    Double p2 = new Double();

    pageDrawer.appendRectangle(p0, p1, p2, new Double());

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
   *
   * <p>Method under test: {@link PageDrawer#curveTo(float, float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test curveTo(float, float, float, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.curveTo(float, float, float, float, float, float)"})
  void testCurveTo() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    Double p0 = new Double();
    Double p1 = new Double();
    Double p2 = new Double();

    pageDrawer.appendRectangle(p0, p1, p2, new Double());

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
   *
   * <p>Method under test: {@link PageDrawer#getCurrentPoint()}
   */
  @Test
  @DisplayName("Test getCurrentPoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Point2D PageDrawer.getCurrentPoint()"})
  void testGetCurrentPoint() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    // Act and Assert
    assertNull(new PageDrawer(parameters).getCurrentPoint());
  }

  /**
   * Test {@link PageDrawer#drawImage(PDImage)}.
   *
   * <ul>
   *   <li>Given {@link PDFRenderer} {@link PDFRenderer#isGroupEnabled(PDOptionalContentGroup)}
   *       return {@code false}.
   *   <li>Then calls {@link PDFRenderer#isGroupEnabled(PDOptionalContentGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#drawImage(PDImage)}
   */
  @Test
  @DisplayName(
      "Test drawImage(PDImage); given PDFRenderer isGroupEnabled(PDOptionalContentGroup) return 'false'; then calls isGroupEnabled(PDOptionalContentGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.drawImage(PDImage)"})
  void testDrawImage_givenPDFRendererIsGroupEnabledReturnFalse_thenCallsIsGroupEnabled()
      throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    when(renderer.isGroupEnabled(Mockito.<PDOptionalContentGroup>any())).thenReturn(false);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any())).thenReturn(null);

    PDImageXObject pdImage = mock(PDImageXObject.class);
    when(pdImage.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    // Act
    pageDrawer.drawImage(pdImage);

    // Assert
    verify(pdImage).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(RenderDestination.EXPORT);
    verify(renderer).isGroupEnabled(isA(PDOptionalContentGroup.class));
  }

  /**
   * Test {@link PageDrawer#drawImage(PDImage)}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup} {@link
   *       PDOptionalContentGroup#getRenderState(RenderDestination)} return {@link
   *       PDOptionalContentGroup.RenderState#OFF}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#drawImage(PDImage)}
   */
  @Test
  @DisplayName(
      "Test drawImage(PDImage); given PDOptionalContentGroup getRenderState(RenderDestination) return OFF")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.drawImage(PDImage)"})
  void testDrawImage_givenPDOptionalContentGroupGetRenderStateReturnOff() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(RenderState.OFF);

    PDImageXObject pdImage = mock(PDImageXObject.class);
    when(pdImage.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    // Act
    pageDrawer.drawImage(pdImage);

    // Assert
    verify(pdImage).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(RenderDestination.EXPORT);
  }

  /**
   * Test {@link PageDrawer#showForm(PDFormXObject)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showForm(PDFormXObject)}
   */
  @Test
  @DisplayName("Test showForm(PDFormXObject); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showForm(PDFormXObject)"})
  void testShowForm_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);
    PageDrawer pageDrawer = new PageDrawer(parameters);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> pageDrawer.showForm(new PDFormXObject(new COSStream())));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   *
   * <ul>
   *   <li>Given {@link Matrix} {@link Matrix#multiply(Matrix)} return {@link Matrix#Matrix()}.
   *   <li>Then calls {@link Matrix#multiply(Matrix)}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroup(PDTransparencyGroup); given Matrix multiply(Matrix) return Matrix(); then calls multiply(Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
  void testShowTransparencyGroup_givenMatrixMultiplyReturnMatrix_thenCallsMultiply()
      throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    Matrix matrix = mock(Matrix.class);
    when(matrix.multiply(Mockito.<Matrix>any())).thenReturn(new Matrix());

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.transform(Mockito.<Matrix>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getBBox()).thenReturn(pdImmutableRectangle);
    when(form.getMatrix()).thenReturn(matrix);
    when(form.getOptionalContent()).thenReturn(null);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(pdImmutableRectangle).transform(isA(Matrix.class));
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
    verify(matrix).multiply(isA(Matrix.class));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   *
   * <ul>
   *   <li>Given {@link PDFRenderer} {@link PDFRenderer#isGroupEnabled(PDOptionalContentGroup)}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroup(PDTransparencyGroup); given PDFRenderer isGroupEnabled(PDOptionalContentGroup) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
  void testShowTransparencyGroup_givenPDFRendererIsGroupEnabledReturnFalse() throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    when(renderer.isGroupEnabled(Mockito.<PDOptionalContentGroup>any())).thenReturn(false);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getOptionalContent()).thenReturn(new PDOptionalContentGroup("Name"));

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(form).getOptionalContent();
    verify(renderer).isGroupEnabled(isA(PDOptionalContentGroup.class));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   *
   * <ul>
   *   <li>Given {@link PDFRenderer} {@link PDFRenderer#isGroupEnabled(PDOptionalContentGroup)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroup(PDTransparencyGroup); given PDFRenderer isGroupEnabled(PDOptionalContentGroup) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
  void testShowTransparencyGroup_givenPDFRendererIsGroupEnabledReturnTrue() throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    when(renderer.isGroupEnabled(Mockito.<PDOptionalContentGroup>any())).thenReturn(true);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    Matrix matrix = mock(Matrix.class);
    when(matrix.multiply(Mockito.<Matrix>any())).thenReturn(new Matrix());

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.transform(Mockito.<Matrix>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getBBox()).thenReturn(pdImmutableRectangle);
    when(form.getMatrix()).thenReturn(matrix);
    when(form.getOptionalContent()).thenReturn(new PDOptionalContentGroup("Name"));

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(pdImmutableRectangle).transform(isA(Matrix.class));
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
    verify(renderer).isGroupEnabled(isA(PDOptionalContentGroup.class));
    verify(matrix).multiply(isA(Matrix.class));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup} {@link
   *       PDOptionalContentGroup#getRenderState(RenderDestination)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroup(PDTransparencyGroup); given PDOptionalContentGroup getRenderState(RenderDestination) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
  void testShowTransparencyGroup_givenPDOptionalContentGroupGetRenderStateReturnNull()
      throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    when(renderer.isGroupEnabled(Mockito.<PDOptionalContentGroup>any())).thenReturn(false);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any())).thenReturn(null);

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(RenderDestination.EXPORT);
    verify(renderer).isGroupEnabled(isA(PDOptionalContentGroup.class));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup} {@link
   *       PDOptionalContentGroup#getRenderState(RenderDestination)} return {@link
   *       PDOptionalContentGroup.RenderState#OFF}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroup(PDTransparencyGroup); given PDOptionalContentGroup getRenderState(RenderDestination) return OFF")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
  void testShowTransparencyGroup_givenPDOptionalContentGroupGetRenderStateReturnOff()
      throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(RenderState.OFF);

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(RenderDestination.EXPORT);
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup} {@link
   *       PDOptionalContentGroup#getRenderState(RenderDestination)} return {@code ON}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroup(PDTransparencyGroup); given PDOptionalContentGroup getRenderState(RenderDestination) return 'ON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
  void testShowTransparencyGroup_givenPDOptionalContentGroupGetRenderStateReturnOn()
      throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(RenderState.ON);

    Matrix matrix = mock(Matrix.class);
    when(matrix.multiply(Mockito.<Matrix>any())).thenReturn(new Matrix());

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.transform(Mockito.<Matrix>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getBBox()).thenReturn(pdImmutableRectangle);
    when(form.getMatrix()).thenReturn(matrix);
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(pdImmutableRectangle).transform(isA(Matrix.class));
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(RenderDestination.EXPORT);
    verify(matrix).multiply(isA(Matrix.class));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.
   *   <li>Then calls {@link COSStream#isDirect()}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroup(PDTransparencyGroup); given PDRectangle(); then calls isDirect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
  void testShowTransparencyGroup_givenPDRectangle_thenCallsIsDirect() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getBBox()).thenReturn(new PDRectangle());
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(null);

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    new PDResources().add(xobject, "Prefix");

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
   *
   * <ul>
   *   <li>Then calls {@link PDImmutableRectangle#transform(Matrix)}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup); then calls transform(Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDrawer.showTransparencyGroup(PDTransparencyGroup)"})
  void testShowTransparencyGroup_thenCallsTransform() throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.transform(Mockito.<Matrix>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getBBox()).thenReturn(pdImmutableRectangle);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(null);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");

    // Act
    pageDrawer.showTransparencyGroup(form);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(pdImmutableRectangle).transform(isA(Matrix.class));
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup,
   * Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"
  })
  void testShowTransparencyGroupOnGraphics() throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    when(renderer.isGroupEnabled(Mockito.<PDOptionalContentGroup>any())).thenReturn(false);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any())).thenReturn(null);

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), null);

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, graphics);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(RenderDestination.EXPORT);
    verify(renderer).isGroupEnabled(isA(PDOptionalContentGroup.class));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup,
   * Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"
  })
  void testShowTransparencyGroupOnGraphics2() throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(RenderState.OFF);

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), null);

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, graphics);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(RenderDestination.EXPORT);
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup,
   * Graphics2D)}
   */
  @Test
  @DisplayName("Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"
  })
  void testShowTransparencyGroupOnGraphics3() throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDOptionalContentGroup pdOptionalContentGroup = mock(PDOptionalContentGroup.class);
    when(pdOptionalContentGroup.getRenderState(Mockito.<RenderDestination>any()))
        .thenReturn(RenderState.ON);

    Matrix matrix = mock(Matrix.class);
    when(matrix.multiply(Mockito.<Matrix>any())).thenReturn(new Matrix());

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.transform(Mockito.<Matrix>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getBBox()).thenReturn(pdImmutableRectangle);
    when(form.getMatrix()).thenReturn(matrix);
    when(form.getOptionalContent()).thenReturn(pdOptionalContentGroup);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), null);

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, graphics);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(pdImmutableRectangle).transform(isA(Matrix.class));
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
    verify(pdOptionalContentGroup).getRenderState(RenderDestination.EXPORT);
    verify(matrix).multiply(isA(Matrix.class));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   *
   * <ul>
   *   <li>Given {@link PDFRenderer} {@link PDFRenderer#isGroupEnabled(PDOptionalContentGroup)}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup,
   * Graphics2D)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); given PDFRenderer isGroupEnabled(PDOptionalContentGroup) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"
  })
  void testShowTransparencyGroupOnGraphics_givenPDFRendererIsGroupEnabledReturnFalse()
      throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    when(renderer.isGroupEnabled(Mockito.<PDOptionalContentGroup>any())).thenReturn(false);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getOptionalContent()).thenReturn(new PDOptionalContentGroup("Name"));

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), null);

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, graphics);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(form).getOptionalContent();
    verify(renderer).isGroupEnabled(isA(PDOptionalContentGroup.class));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   *
   * <ul>
   *   <li>Given {@link PDFRenderer} {@link PDFRenderer#isGroupEnabled(PDOptionalContentGroup)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup,
   * Graphics2D)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); given PDFRenderer isGroupEnabled(PDOptionalContentGroup) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"
  })
  void testShowTransparencyGroupOnGraphics_givenPDFRendererIsGroupEnabledReturnTrue()
      throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    when(renderer.isGroupEnabled(Mockito.<PDOptionalContentGroup>any())).thenReturn(true);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    Matrix matrix = mock(Matrix.class);
    when(matrix.multiply(Mockito.<Matrix>any())).thenReturn(new Matrix());

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.transform(Mockito.<Matrix>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getBBox()).thenReturn(pdImmutableRectangle);
    when(form.getMatrix()).thenReturn(matrix);
    when(form.getOptionalContent()).thenReturn(new PDOptionalContentGroup("Name"));

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), null);

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, graphics);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(pdImmutableRectangle).transform(isA(Matrix.class));
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
    verify(renderer).isGroupEnabled(isA(PDOptionalContentGroup.class));
    verify(matrix).multiply(isA(Matrix.class));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.
   *   <li>Then calls {@link COSStream#isDirect()}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup,
   * Graphics2D)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); given PDRectangle(); then calls isDirect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"
  })
  void testShowTransparencyGroupOnGraphics_givenPDRectangle_thenCallsIsDirect() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getBBox()).thenReturn(new PDRectangle());
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(null);

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);
    new PDResources().add(xobject, "Prefix");
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), null);

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, graphics);

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
   *
   * <ul>
   *   <li>Then calls {@link Matrix#multiply(Matrix)}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup,
   * Graphics2D)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); then calls multiply(Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"
  })
  void testShowTransparencyGroupOnGraphics_thenCallsMultiply() throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    Matrix matrix = mock(Matrix.class);
    when(matrix.multiply(Mockito.<Matrix>any())).thenReturn(new Matrix());

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.transform(Mockito.<Matrix>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getBBox()).thenReturn(pdImmutableRectangle);
    when(form.getMatrix()).thenReturn(matrix);
    when(form.getOptionalContent()).thenReturn(null);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), null);

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, graphics);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(pdImmutableRectangle).transform(isA(Matrix.class));
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
    verify(matrix).multiply(isA(Matrix.class));
  }

  /**
   * Test {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)}.
   *
   * <ul>
   *   <li>Then calls {@link PDImmutableRectangle#transform(Matrix)}.
   * </ul>
   *
   * <p>Method under test: {@link PageDrawer#showTransparencyGroupOnGraphics(PDTransparencyGroup,
   * Graphics2D)}
   */
  @Test
  @DisplayName(
      "Test showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D); then calls transform(Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageDrawer.showTransparencyGroupOnGraphics(PDTransparencyGroup, Graphics2D)"
  })
  void testShowTransparencyGroupOnGraphics_thenCallsTransform() throws IOException {
    // Arrange
    PDFRenderer renderer = mock(PDFRenderer.class);
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    PageDrawer pageDrawer = new PageDrawer(parameters);
    pageDrawer.processPage(new PDPage());

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.transform(Mockito.<Matrix>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));

    PDTransparencyGroup form = mock(PDTransparencyGroup.class);
    when(form.getBBox()).thenReturn(pdImmutableRectangle);
    when(form.getMatrix()).thenReturn(new Matrix());
    when(form.getOptionalContent()).thenReturn(null);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDXObject>any(), Mockito.<String>any())).thenReturn(COSName.A);
    pdResources.add(mock(PDXObject.class), "Prefix");
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), null);

    // Act
    pageDrawer.showTransparencyGroupOnGraphics(form, graphics);

    // Assert
    verify(pdResources).add(isA(PDXObject.class), eq("Prefix"));
    verify(pdImmutableRectangle).transform(isA(Matrix.class));
    verify(form).getBBox();
    verify(form).getMatrix();
    verify(form).getOptionalContent();
  }
}
