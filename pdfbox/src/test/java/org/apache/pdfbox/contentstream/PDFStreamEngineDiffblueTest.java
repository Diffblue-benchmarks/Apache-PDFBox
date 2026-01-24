package org.apache.pdfbox.contentstream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType3CharProc;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDTransparencyGroup;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.rendering.PageDrawerParameters;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PDFStreamEngineDiffblueTest {
  @Mock private Matrix matrix;

  @InjectMocks private PDFMarkedContentExtractor pDFMarkedContentExtractor;

  @Mock private PDFont pDFont;

  @Mock private PDRectangle pDRectangle;

  @InjectMocks private PageDrawer pageDrawer;

  @Mock private PageDrawerParameters pageDrawerParameters;

  /**
   * Test {@link PDFStreamEngine#processPage(PDPage)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processPage(PDPage)"})
  void testProcessPage() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act
    pdfMarkedContentExtractor.processPage(new PDPage());

    // Assert
    PDGraphicsState graphicsState = pdfMarkedContentExtractor.getGraphicsState();
    assertTrue(graphicsState.getCurrentClippingPath().getBounds2D() instanceof Double);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[] {0.0f}, nonStrokingColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processPage(PDPage)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processPage(PDPage)"})
  void testProcessPage2() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosArray.add((COSBase) object);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage page = new PDPage();
    page.setCropBox(pDRectangle);

    // Act
    pageDrawer.processPage(page);

    // Assert
    verify(pDRectangle).getCOSArray();
    PDGraphicsState graphicsState = pageDrawer.getGraphicsState();
    Rectangle2D bounds2D =
        graphicsState
            .getCurrentClippingPath()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertEquals(0.0d, bounds2D.getCenterX());
    assertEquals(0.0d, bounds2D.getCenterY());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_givenA() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObjectKey key = new COSObjectKey(1L, 1);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser parser = new COSParser(source);

    COSObject object = new COSObject(key, parser);
    cosArray.add((COSBase) object);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage page = new PDPage();
    page.setCropBox(pDRectangle);

    // Act
    pageDrawer.processPage(page);

    // Assert
    verify(pDRectangle).getCOSArray();
    PDGraphicsState graphicsState = pageDrawer.getGraphicsState();
    Rectangle2D bounds2D =
        graphicsState
            .getCurrentClippingPath()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertEquals(0.0d, bounds2D.getCenterX());
    assertEquals(0.0d, bounds2D.getCenterY());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_givenCOSArrayAddFalse() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage page = new PDPage();
    page.setCropBox(pDRectangle);

    // Act
    pageDrawer.processPage(page);

    // Assert
    verify(pDRectangle).getCOSArray();
    PDGraphicsState graphicsState = pageDrawer.getGraphicsState();
    Rectangle2D bounds2D =
        graphicsState
            .getCurrentClippingPath()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertEquals(0.0d, bounds2D.getCenterX());
    assertEquals(0.0d, bounds2D.getCenterY());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test processPage(PDPage); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    cosArray.add((COSBase) object);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage page = new PDPage();
    page.setCropBox(pDRectangle);

    // Act
    pageDrawer.processPage(page);

    // Assert
    verify(pDRectangle).getCOSArray();
    PDGraphicsState graphicsState = pageDrawer.getGraphicsState();
    Rectangle2D bounds2D =
        graphicsState
            .getCurrentClippingPath()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertEquals(0.0d, bounds2D.getCenterX());
    assertEquals(0.0d, bounds2D.getCenterY());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Then {@link PageDrawer} GraphicsState CurrentClippingPaths size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test processPage(PDPage); then PageDrawer GraphicsState CurrentClippingPaths size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_thenPageDrawerGraphicsStateCurrentClippingPathsSizeIsOne()
      throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage page = new PDPage();
    page.setCropBox(pDRectangle);

    // Act
    pageDrawer.processPage(page);

    // Assert
    verify(pDRectangle).getCOSArray();
    PDGraphicsState graphicsState = pageDrawer.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getBounds2D() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#showTransparencyGroup(PDTransparencyGroup)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showTransparencyGroup(PDTransparencyGroup)"})
  void testShowTransparencyGroup() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            pdfMarkedContentExtractor.showTransparencyGroup(
                new PDTransparencyGroup(new PDDocument())));
  }

  /**
   * Test {@link PDFStreamEngine#showForm(PDFormXObject)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#showForm(PDFormXObject)}
   */
  @Test
  @DisplayName("Test showForm(PDFormXObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showForm(PDFormXObject)"})
  void testShowForm() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> pdfMarkedContentExtractor.showForm(new PDFormXObject(new COSStream())));
  }

  /**
   * Test {@link PDFStreamEngine#processTransparencyGroup(PDTransparencyGroup)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test processTransparencyGroup(PDTransparencyGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processTransparencyGroup(PDTransparencyGroup)"})
  void testProcessTransparencyGroup() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            pdfMarkedContentExtractor.processTransparencyGroup(
                new PDTransparencyGroup(new PDDocument())));
  }

  /**
   * Test {@link PDFStreamEngine#processType3Stream(PDType3CharProc, Matrix)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processType3Stream(PDType3CharProc, Matrix)}
   */
  @Test
  @DisplayName("Test processType3Stream(PDType3CharProc, Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processType3Stream(PDType3CharProc, Matrix)"})
  void testProcessType3Stream() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDType3Font font = new PDType3Font(new COSDictionary());
    PDType3CharProc charProc = new PDType3CharProc(font, new COSStream());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> pdfMarkedContentExtractor.processType3Stream(charProc, new Matrix()));
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray() add A; then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenCOSArrayAddA_thenCallsGetCOSArray() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);

    // Act
    pDFMarkedContentExtractor.processAnnotation(
        annotation, new PDAppearanceStream(new COSStream()));

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray() add COSArray(); then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenCOSArrayAddCOSArray_thenCallsGetCOSArray() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSArray());
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);

    // Act
    pDFMarkedContentExtractor.processAnnotation(
        annotation, new PDAppearanceStream(new COSStream()));

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray() add COSDictionary(); then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenCOSArrayAddCOSDictionary_thenCallsGetCOSArray()
      throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSDictionary());
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);

    // Act
    pDFMarkedContentExtractor.processAnnotation(
        annotation, new PDAppearanceStream(new COSStream()));

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray() add ONE; then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenCOSArrayAddOne_thenCallsGetCOSArray() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSFloat.ONE);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);

    // Act
    pDFMarkedContentExtractor.processAnnotation(
        annotation, new PDAppearanceStream(new COSStream()));

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray() add ONE; then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenCOSArrayAddOne_thenCallsGetCOSArray2() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);

    // Act
    pDFMarkedContentExtractor.processAnnotation(
        annotation, new PDAppearanceStream(new COSStream()));

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_thenCallsGetCOSArray() throws IOException {
    // Arrange
    when(pDRectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);

    // Act
    pDFMarkedContentExtractor.processAnnotation(
        annotation, new PDAppearanceStream(new COSStream()));

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)} with
   * {@code tilingPattern}, {@code color}, {@code colorSpace}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor,
   * PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFStreamEngine.processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)"
  })
  void testProcessTilingPatternWithTilingPatternColorColorSpace() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getBBox()).thenThrow(new IllegalArgumentException());
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            pdfMarkedContentExtractor.processTilingPattern(
                tilingPattern,
                new PDColor(new COSArray(), PDDeviceGray.INSTANCE),
                PDDeviceGray.INSTANCE));
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)} with
   * {@code tilingPattern}, {@code color}, {@code colorSpace}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor,
   * PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFStreamEngine.processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)"
  })
  void testProcessTilingPatternWithTilingPatternColorColorSpace2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing()).thenReturn(new RandomAccessReadWriteBuffer());
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());

    // Act
    pdfMarkedContentExtractor.processTilingPattern(
        tilingPattern, new PDColor(new COSArray(), PDDeviceGray.INSTANCE), PDDeviceGray.INSTANCE);

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)} with
   * {@code tilingPattern}, {@code color}, {@code colorSpace}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor,
   * PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFStreamEngine.processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)"
  })
  void testProcessTilingPatternWithTilingPatternColorColorSpace3() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing())
        .thenReturn(
            new RandomAccessReadBuffer(new ByteArrayInputStream("A\tA\tA\tA\t".getBytes("UTF-8"))));
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());

    // Act
    pdfMarkedContentExtractor.processTilingPattern(
        tilingPattern, new PDColor(new COSArray(), PDDeviceGray.INSTANCE), PDDeviceGray.INSTANCE);

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)} with
   * {@code tilingPattern}, {@code color}, {@code colorSpace}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor,
   * PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFStreamEngine.processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)"
  })
  void testProcessTilingPatternWithTilingPatternColorColorSpace4() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing()).thenReturn(new RandomAccessReadWriteBuffer());
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());

    // Act
    pdfMarkedContentExtractor.processTilingPattern(
        tilingPattern, new PDColor(new COSArray(), PDDeviceRGB.INSTANCE), PDDeviceGray.INSTANCE);

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)} with
   * {@code tilingPattern}, {@code color}, {@code colorSpace}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor,
   * PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFStreamEngine.processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)"
  })
  void testProcessTilingPatternWithTilingPatternColorColorSpace5() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing()).thenReturn(new RandomAccessReadWriteBuffer());
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());
    COSArray array = new COSArray();
    PDColor color = new PDColor(array, new PDPattern(new PDResources()));

    // Act
    pdfMarkedContentExtractor.processTilingPattern(tilingPattern, color, PDDeviceGray.INSTANCE);

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)} with
   * {@code tilingPattern}, {@code color}, {@code colorSpace}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor,
   * PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFStreamEngine.processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)"
  })
  void testProcessTilingPatternWithTilingPatternColorColorSpace6() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing()).thenReturn(new RandomAccessReadWriteBuffer());
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), null);

    // Act
    pdfMarkedContentExtractor.processTilingPattern(tilingPattern, color, PDDeviceGray.INSTANCE);

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace,
   * Matrix)} with {@code tilingPattern}, {@code color}, {@code colorSpace}, {@code patternMatrix}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor,
   * PDColorSpace, Matrix)}
   */
  @Test
  @DisplayName(
      "Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix) with 'tilingPattern', 'color', 'colorSpace', 'patternMatrix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFStreamEngine.processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)"
  })
  void testProcessTilingPatternWithTilingPatternColorColorSpacePatternMatrix() throws IOException {
    // Arrange
    when(matrix.multiply(Mockito.<Matrix>any())).thenThrow(new IllegalArgumentException());
    PDTilingPattern tilingPattern = new PDTilingPattern();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            pDFMarkedContentExtractor.processTilingPattern(
                tilingPattern,
                new PDColor(new COSArray(), PDDeviceGray.INSTANCE),
                PDDeviceGray.INSTANCE,
                matrix));
    verify(matrix).multiply(isNull());
  }

  /**
   * Test {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)} with
   * {@code tilingPattern}, {@code color}, {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor,
   * PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFStreamEngine.processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)"
  })
  void testProcessTilingPatternWithTilingPatternColorColorSpace_whenNull() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing()).thenReturn(new RandomAccessReadWriteBuffer());
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());

    // Act
    pdfMarkedContentExtractor.processTilingPattern(
        tilingPattern, new PDColor(new COSArray(), PDDeviceGray.INSTANCE), null);

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given COSArray() add A; then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenCOSArrayAddA_thenCallsGetCOSArray() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);
    annotation.setAppearance(appearance);

    // Act
    pDFMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given COSArray() add COSArray(); then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenCOSArrayAddCOSArray_thenCallsGetCOSArray() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSArray());
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);
    annotation.setAppearance(appearance);

    // Act
    pDFMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given COSArray() add ONE; then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenCOSArrayAddOne_thenCallsGetCOSArray() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    COSArray cosArray = new COSArray();
    cosArray.add(COSFloat.ONE);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);
    annotation.setAppearance(appearance);

    // Act
    pDFMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given COSArray() add ONE; then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenCOSArrayAddOne_thenCallsGetCOSArray2() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);
    annotation.setAppearance(appearance);

    // Act
    pDFMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Key is {@link COSObjectKey#COSObjectKey(long, int)}
   *       with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given COSStream() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenCOSStreamKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne()
      throws IOException {
    // Arrange
    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));
    PDAppearanceStream ap = new PDAppearanceStream(stream);

    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(ap);
    when(pDRectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);
    annotation.setAppearance(appearance);

    // Act
    pDFMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_thenCallsGetCOSArray() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));
    when(pDRectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(pDRectangle);
    annotation.setAppearance(appearance);

    // Act
    pDFMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pDRectangle).getCOSArray();
  }

  /**
   * Test {@link PDFStreamEngine#getAppearance(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link PDAppearanceDictionary#PDAppearanceDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test getAppearance(PDAnnotation); given PDAppearanceDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceStream PDFStreamEngine.getAppearance(PDAnnotation)"})
  void testGetAppearance_givenPDAppearanceDictionary_thenReturnNull() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(new PDAppearanceDictionary());

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getAppearance(annotation));
  }

  /**
   * Test {@link PDFStreamEngine#getAppearance(PDAnnotation)}.
   *
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one
   *       and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test getAppearance(PDAnnotation); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceStream PDFStreamEngine.getAppearance(PDAnnotation)"})
  void testGetAppearance_thenReturnCOSObjectKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    COSStream stream = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);
    stream.setKey(key);
    PDAppearanceStream ap = new PDAppearanceStream(stream);

    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(ap);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act
    PDAppearanceStream actualAppearance = pdfMarkedContentExtractor.getAppearance(annotation);

    // Assert
    float[][] values = actualAppearance.getMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(key, actualAppearance.getCOSObject().getKey());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#getAppearance(PDAnnotation)}.
   *
   * <ul>
   *   <li>Then return COSObject Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName("Test getAppearance(PDAnnotation); then return COSObject Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceStream PDFStreamEngine.getAppearance(PDAnnotation)"})
  void testGetAppearance_thenReturnCOSObjectKeyIsNull() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act
    PDAppearanceStream actualAppearance = pdfMarkedContentExtractor.getAppearance(annotation);

    // Assert
    assertNull(actualAppearance.getCOSObject().getKey());
    float[][] values = actualAppearance.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#getAppearance(PDAnnotation)}.
   *
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName("Test getAppearance(PDAnnotation); when PDAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceStream PDFStreamEngine.getAppearance(PDAnnotation)"})
  void testGetAppearance_whenPDAnnotationCaret_thenReturnNull() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getAppearance(new PDAnnotationCaret()));
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    PDGraphicsState graphicsState = pdfMarkedContentExtractor.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getFrame() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDPage contentStream = new PDPage();
    contentStream.setContents(new PDStream(new COSDocument()));

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    PDGraphicsState graphicsState = pdfMarkedContentExtractor.getGraphicsState();
    Rectangle2D bounds2D =
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream3() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDPage contentStream = new PDPage();
    PDRectangle cropBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    contentStream.setCropBox(cropBox);

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    assertNull(pdfMarkedContentExtractor.getTextLineMatrix());
    assertNull(pdfMarkedContentExtractor.getTextMatrix());
    assertEquals(1, pdfMarkedContentExtractor.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream4() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDStream contents = new PDStream(new COSDocument());
    ArrayList<COSName> filters = new ArrayList<>();
    contents.setFilters(filters);

    PDPage contentStream = new PDPage();
    contentStream.setContents(contents);

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    PDGraphicsState graphicsState = pdfMarkedContentExtractor.getGraphicsState();
    Rectangle2D bounds2D =
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    Rectangle bounds = bounds2D.getBounds();
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(filters, ((COSArray) getResult).toList());
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream5() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage contentStream = new PDPage();
    contentStream.setContents(contents);

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    PDGraphicsState graphicsState = pdfMarkedContentExtractor.getGraphicsState();
    Rectangle bounds =
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getFrame() instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream6() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosArray.add((COSBase) object);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage contentStream = new PDPage();
    contentStream.setCropBox(pDRectangle);

    // Act
    pDFMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    verify(pDRectangle).getCOSArray();
    PDGraphicsState graphicsState = pDFMarkedContentExtractor.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds();
    Rectangle2D bounds2D = bounds.getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds2D.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D frame = bounds2D.getFrame();
    assertTrue(frame instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(306.0d, bounds2D.getCenterX());
    assertEquals(396.0d, bounds2D.getCenterY());
    assertEquals(bounds, bounds2D.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame);
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.
   *   <li>When {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName(
      "Test processChildStream(PDContentStream, PDPage); given A0; when PDPage() CropBox is A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream_givenA0_whenPDPageCropBoxIsA0() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDPage contentStream = new PDPage();
    contentStream.setCropBox(PDRectangle.A0);

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    assertNull(pdfMarkedContentExtractor.getTextLineMatrix());
    assertNull(pdfMarkedContentExtractor.getTextMatrix());
    assertEquals(1, pdfMarkedContentExtractor.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage); given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream_givenArrayListAddNull() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage contentStream = new PDPage();
    contentStream.setContents(contents);

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    PDGraphicsState graphicsState = pdfMarkedContentExtractor.getGraphicsState();
    Rectangle2D bounds2D =
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName(
      "Test processChildStream(PDContentStream, PDPage); given ArrayList(); when PDPage() Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream_givenArrayList_whenPDPageContentsIsArrayList() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDPage contentStream = new PDPage();
    ArrayList<PDStream> contents = new ArrayList<>();
    contentStream.setContents(contents);

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    PDGraphicsState graphicsState = pdfMarkedContentExtractor.getGraphicsState();
    assertTrue(
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getFrame()
            instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(contents, ((COSArray) getResult).toList());
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage); given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream_givenCOSArrayAddFalse() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage contentStream = new PDPage();
    contentStream.setCropBox(pDRectangle);

    // Act
    pDFMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    verify(pDRectangle).getCOSArray();
    PDGraphicsState graphicsState = pDFMarkedContentExtractor.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds();
    Rectangle2D bounds2D = bounds.getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds2D.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D frame = bounds2D.getFrame();
    assertTrue(frame instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(306.0d, bounds2D.getCenterX());
    assertEquals(396.0d, bounds2D.getCenterY());
    assertEquals(bounds, bounds2D.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame);
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage); given COSArray() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream_givenCOSArrayAddOne() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage contentStream = new PDPage();
    contentStream.setCropBox(pDRectangle);

    // Act
    pDFMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    verify(pDRectangle).getCOSArray();
    PDGraphicsState graphicsState = pDFMarkedContentExtractor.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds();
    Rectangle2D bounds2D = bounds.getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds2D.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D frame = bounds2D.getFrame();
    assertTrue(frame instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(306.0d, bounds2D.getCenterX());
    assertEquals(396.0d, bounds2D.getCenterY());
    assertEquals(bounds, bounds2D.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame);
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName(
      "Test processChildStream(PDContentStream, PDPage); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    cosArray.add((COSBase) object);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage contentStream = new PDPage();
    contentStream.setCropBox(pDRectangle);

    // Act
    pDFMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    verify(pDRectangle).getCOSArray();
    PDGraphicsState graphicsState = pDFMarkedContentExtractor.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds();
    Rectangle2D bounds2D = bounds.getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds2D.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D frame = bounds2D.getFrame();
    assertTrue(frame instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(306.0d, bounds2D.getCenterX());
    assertEquals(396.0d, bounds2D.getCenterY());
    assertEquals(bounds, bounds2D.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame);
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#showTextStrings(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  @DisplayName("Test showTextStrings(COSArray); given ArrayList() add A; then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showTextStrings(COSArray)"})
  void testShowTextStrings_givenArrayListAddA_thenCallsAdd() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(COSName.A);

    COSArray array = mock(COSArray.class);
    when(array.iterator()).thenReturn(cosBaseList.iterator());
    doNothing().when(array).add(Mockito.<COSBase>any());
    array.add(COSBoolean.FALSE);

    // Act
    pdfMarkedContentExtractor.showTextStrings(array);

    // Assert
    verify(array).add(isA(COSBase.class));
    verify(array).iterator();
  }

  /**
   * Test {@link PDFStreamEngine#showTextStrings(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  @DisplayName(
      "Test showTextStrings(COSArray); given ArrayList() add COSArray(); then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showTextStrings(COSArray)"})
  void testShowTextStrings_givenArrayListAddCOSArray_thenCallsAdd() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(new COSArray());

    COSArray array = mock(COSArray.class);
    when(array.iterator()).thenReturn(cosBaseList.iterator());
    doNothing().when(array).add(Mockito.<COSBase>any());
    array.add(COSBoolean.FALSE);

    // Act
    pdfMarkedContentExtractor.showTextStrings(array);

    // Assert
    verify(array).add(isA(COSBase.class));
    verify(array).iterator();
  }

  /**
   * Test {@link PDFStreamEngine#showTextStrings(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  @DisplayName(
      "Test showTextStrings(COSArray); given ArrayList() iterator; then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showTextStrings(COSArray)"})
  void testShowTextStrings_givenArrayListIterator_thenCallsAdd() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    COSArray array = mock(COSArray.class);

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    when(array.iterator()).thenReturn(cosBaseList.iterator());
    doNothing().when(array).add(Mockito.<COSBase>any());
    array.add(COSBoolean.FALSE);

    // Act
    pdfMarkedContentExtractor.showTextStrings(array);

    // Assert
    verify(array).add(isA(COSBase.class));
    verify(array).iterator();
  }

  /**
   * Test {@link PDFStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName("Test showGlyph(Matrix, PDFont, int, Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showGlyph(Matrix, PDFont, int, Vector)"})
  void testShowGlyph() throws IOException {
    // Arrange
    when(pDFont.getFontMatrix()).thenThrow(new IllegalArgumentException());
    Matrix textRenderingMatrix = new Matrix();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pageDrawer.showGlyph(textRenderingMatrix, pDFont, 1, new Vector(10.0f, 10.0f)));
    verify(pDFont).getFontMatrix();
  }

  /**
   * Test {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}
   */
  @Test
  @DisplayName("Test showType3Glyph(Matrix, PDType3Font, int, Vector); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showType3Glyph(Matrix, PDType3Font, int, Vector)"})
  void testShowType3Glyph_thenDoesNotThrow() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    Matrix textRenderingMatrix = new Matrix();
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdfMarkedContentExtractor.showType3Glyph(
                textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f)));
  }

  /**
   * Test {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}
   */
  @Test
  @DisplayName(
      "Test showType3Glyph(Matrix, PDType3Font, int, Vector); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showType3Glyph(Matrix, PDType3Font, int, Vector)"})
  void testShowType3Glyph_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    Matrix textRenderingMatrix = new Matrix();

    PDType3Font font = mock(PDType3Font.class);
    PDType3Font font2 = new PDType3Font(new COSDictionary());
    PDType3CharProc pdType3CharProc = new PDType3CharProc(font2, new COSStream());
    when(font.getCharProc(anyInt())).thenReturn(pdType3CharProc);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            pdfMarkedContentExtractor.showType3Glyph(
                textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f)));
    verify(font).getCharProc(1);
  }

  /**
   * Test {@link PDFStreamEngine#processOperator(Operator, List)} with {@code operator}, {@code
   * operands}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processOperator(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test processOperator(Operator, List) with 'operator', 'operands'; given FALSE; when ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processOperator(Operator, List)"})
  void testProcessOperatorWithOperatorOperands_givenFalse_whenArrayListAddFalse()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    Operator operator = mock(Operator.class);
    when(operator.getName()).thenReturn("Do");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act
    pdfMarkedContentExtractor.processOperator(operator, operands);

    // Assert
    verify(operator).getName();
  }

  /**
   * Test {@link PDFStreamEngine#processOperator(Operator, List)} with {@code operator}, {@code
   * operands}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processOperator(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test processOperator(Operator, List) with 'operator', 'operands'; given FALSE; when ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processOperator(Operator, List)"})
  void testProcessOperatorWithOperatorOperands_givenFalse_whenArrayListAddFalse2()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    Operator operator = mock(Operator.class);
    when(operator.getName()).thenReturn("Do");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSBoolean.FALSE);

    // Act
    pdfMarkedContentExtractor.processOperator(operator, operands);

    // Assert
    verify(operator).getName();
  }

  /**
   * Test {@link PDFStreamEngine#processOperator(Operator, List)} with {@code operator}, {@code
   * operands}.
   *
   * <ul>
   *   <li>Then calls {@link Operator#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processOperator(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test processOperator(Operator, List) with 'operator', 'operands'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processOperator(Operator, List)"})
  void testProcessOperatorWithOperatorOperands_thenCallsGetName() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    Operator operator = mock(Operator.class);
    when(operator.getName()).thenReturn("Do");

    // Act
    pdfMarkedContentExtractor.processOperator(operator, new ArrayList<>());

    // Assert
    verify(operator, atLeast(1)).getName();
  }

  /**
   * Test {@link PDFStreamEngine#operatorException(Operator, List, IOException)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link Operator#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#operatorException(Operator, List, IOException)}
   */
  @Test
  @DisplayName(
      "Test operatorException(Operator, List, IOException); given FALSE; when ArrayList() add FALSE; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.operatorException(Operator, List, IOException)"})
  void testOperatorException_givenFalse_whenArrayListAddFalse_thenCallsGetName()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    Operator operator = mock(Operator.class);
    when(operator.getName()).thenReturn("Do");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act
    pdfMarkedContentExtractor.operatorException(operator, operands, new IOException());

    // Assert
    verify(operator).getName();
  }

  /**
   * Test {@link PDFStreamEngine#operatorException(Operator, List, IOException)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link Operator#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#operatorException(Operator, List, IOException)}
   */
  @Test
  @DisplayName(
      "Test operatorException(Operator, List, IOException); given FALSE; when ArrayList() add FALSE; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.operatorException(Operator, List, IOException)"})
  void testOperatorException_givenFalse_whenArrayListAddFalse_thenCallsGetName2()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    Operator operator = mock(Operator.class);
    when(operator.getName()).thenReturn("Do");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSBoolean.FALSE);

    // Act
    pdfMarkedContentExtractor.operatorException(operator, operands, new IOException());

    // Assert
    verify(operator).getName();
  }

  /**
   * Test {@link PDFStreamEngine#operatorException(Operator, List, IOException)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Operator} {@link Operator#getName()} return {@code Name}.
   *   <li>Then calls {@link Operator#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#operatorException(Operator, List, IOException)}
   */
  @Test
  @DisplayName(
      "Test operatorException(Operator, List, IOException); given 'Name'; when Operator getName() return 'Name'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.operatorException(Operator, List, IOException)"})
  void testOperatorException_givenName_whenOperatorGetNameReturnName_thenCallsGetName()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    Operator operator = mock(Operator.class);
    when(operator.getName()).thenReturn("Name");
    ArrayList<COSBase> operands = new ArrayList<>();

    IOException exception = new IOException("An error occurred");
    exception.initCause(new DataFormatException());

    // Act
    pdfMarkedContentExtractor.operatorException(operator, operands, exception);

    // Assert
    verify(operator).getName();
  }

  /**
   * Test {@link PDFStreamEngine#operatorException(Operator, List, IOException)}.
   *
   * <ul>
   *   <li>Given {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()}.
   *   <li>Then calls {@link Operator#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#operatorException(Operator, List, IOException)}
   */
  @Test
  @DisplayName(
      "Test operatorException(Operator, List, IOException); given PDFMarkedContentExtractor(); then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.operatorException(Operator, List, IOException)"})
  void testOperatorException_givenPDFMarkedContentExtractor_thenCallsGetName() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    Operator operator = mock(Operator.class);
    when(operator.getName()).thenReturn("Do");
    ArrayList<COSBase> operands = new ArrayList<>();

    // Act
    pdfMarkedContentExtractor.operatorException(operator, operands, new IOException());

    // Assert
    verify(operator).getName();
  }

  /**
   * Test {@link PDFStreamEngine#saveGraphicsState()}.
   *
   * <ul>
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()} GraphicsStackSize is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#saveGraphicsState()}
   */
  @Test
  @DisplayName(
      "Test saveGraphicsState(); then PDFMarkedContentExtractor() GraphicsStackSize is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.saveGraphicsState()"})
  void testSaveGraphicsState_thenPDFMarkedContentExtractorGraphicsStackSizeIsTwo()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act
    pdfMarkedContentExtractor.saveGraphicsState();

    // Assert
    assertEquals(2, pdfMarkedContentExtractor.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFStreamEngine#restoreGraphicsState()}.
   *
   * <ul>
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()} GraphicsState is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#restoreGraphicsState()}
   */
  @Test
  @DisplayName(
      "Test restoreGraphicsState(); then PDFMarkedContentExtractor() GraphicsState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.restoreGraphicsState()"})
  void testRestoreGraphicsState_thenPDFMarkedContentExtractorGraphicsStateIsNull()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act
    pdfMarkedContentExtractor.restoreGraphicsState();

    // Assert
    assertNull(pdfMarkedContentExtractor.getGraphicsState());
    assertEquals(0, pdfMarkedContentExtractor.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFStreamEngine#saveGraphicsStack()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#saveGraphicsStack()}
   */
  @Test
  @DisplayName("Test saveGraphicsStack(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Deque PDFStreamEngine.saveGraphicsStack()"})
  void testSaveGraphicsStack_thenReturnSizeIsOne() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act and Assert
    assertEquals(1, pdfMarkedContentExtractor.saveGraphicsStack().size());
  }

  /**
   * Test {@link PDFStreamEngine#restoreGraphicsStack(Deque)}.
   *
   * <ul>
   *   <li>Then calls {@link PDRectangle#toGeneralPath()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#restoreGraphicsStack(Deque)}
   */
  @Test
  @DisplayName("Test restoreGraphicsStack(Deque); then calls toGeneralPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.restoreGraphicsStack(Deque)"})
  void testRestoreGraphicsStack_thenCallsToGeneralPath() throws IOException {
    // Arrange
    when(pDRectangle.toGeneralPath())
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));

    LinkedList<PDGraphicsState> snapshot = new LinkedList<>();
    snapshot.add(new PDGraphicsState(pDRectangle));

    // Act
    pDFMarkedContentExtractor.restoreGraphicsStack(snapshot);

    // Assert
    verify(pDRectangle).toGeneralPath();
  }

  /**
   * Test {@link PDFStreamEngine#restoreGraphicsStack(Deque)}.
   *
   * <ul>
   *   <li>Then calls {@link PDRectangle#toGeneralPath()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#restoreGraphicsStack(Deque)}
   */
  @Test
  @DisplayName("Test restoreGraphicsStack(Deque); then calls toGeneralPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.restoreGraphicsStack(Deque)"})
  void testRestoreGraphicsStack_thenCallsToGeneralPath2() throws IOException {
    // Arrange
    when(pDRectangle.toGeneralPath())
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));

    LinkedList<PDGraphicsState> snapshot = new LinkedList<>();
    snapshot.add(new PDGraphicsState(pDRectangle));
    snapshot.add(new PDGraphicsState(pDRectangle));

    // Act
    pDFMarkedContentExtractor.restoreGraphicsStack(snapshot);

    // Assert
    verify(pDRectangle, atLeast(1)).toGeneralPath();
  }

  /**
   * Test {@link PDFStreamEngine#getGraphicsStackSize()}.
   *
   * <p>Method under test: {@link PDFStreamEngine#getGraphicsStackSize()}
   */
  @Test
  @DisplayName("Test getGraphicsStackSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFStreamEngine.getGraphicsStackSize()"})
  void testGetGraphicsStackSize() {
    // Arrange, Act and Assert
    assertEquals(0, new PDFMarkedContentExtractor().getGraphicsStackSize());
  }

  /**
   * Test {@link PDFStreamEngine#getGraphicsState()}.
   *
   * <p>Method under test: {@link PDFStreamEngine#getGraphicsState()}
   */
  @Test
  @DisplayName("Test getGraphicsState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGraphicsState PDFStreamEngine.getGraphicsState()"})
  void testGetGraphicsState() {
    // Arrange, Act and Assert
    assertNull(new PDFMarkedContentExtractor().getGraphicsState());
  }

  /**
   * Test {@link PDFStreamEngine#getTextLineMatrix()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#getTextLineMatrix()}
   */
  @Test
  @DisplayName("Test getTextLineMatrix(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDFStreamEngine.getTextLineMatrix()"})
  void testGetTextLineMatrix_thenReturnNull() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getTextLineMatrix());
  }

  /**
   * Test {@link PDFStreamEngine#setTextLineMatrix(Matrix)}.
   *
   * <ul>
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()} TextLineMatrix is
   *       {@link Matrix#Matrix()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#setTextLineMatrix(Matrix)}
   */
  @Test
  @DisplayName(
      "Test setTextLineMatrix(Matrix); then PDFMarkedContentExtractor() TextLineMatrix is Matrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.setTextLineMatrix(Matrix)"})
  void testSetTextLineMatrix_thenPDFMarkedContentExtractorTextLineMatrixIsMatrix()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    Matrix value = new Matrix();

    // Act
    pdfMarkedContentExtractor.setTextLineMatrix(value);

    // Assert
    assertSame(value, pdfMarkedContentExtractor.getTextLineMatrix());
    assertSame(value, pdfMarkedContentExtractor.getGraphicsState().getTextLineMatrix());
  }

  /**
   * Test {@link PDFStreamEngine#getTextMatrix()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#getTextMatrix()}
   */
  @Test
  @DisplayName("Test getTextMatrix(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDFStreamEngine.getTextMatrix()"})
  void testGetTextMatrix_thenReturnNull() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getTextMatrix());
  }

  /**
   * Test {@link PDFStreamEngine#setTextMatrix(Matrix)}.
   *
   * <ul>
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()} TextMatrix is {@link
   *       Matrix#Matrix()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#setTextMatrix(Matrix)}
   */
  @Test
  @DisplayName(
      "Test setTextMatrix(Matrix); then PDFMarkedContentExtractor() TextMatrix is Matrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.setTextMatrix(Matrix)"})
  void testSetTextMatrix_thenPDFMarkedContentExtractorTextMatrixIsMatrix() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    Matrix value = new Matrix();

    // Act
    pdfMarkedContentExtractor.setTextMatrix(value);

    // Assert
    assertSame(value, pdfMarkedContentExtractor.getTextMatrix());
    assertSame(value, pdfMarkedContentExtractor.getGraphicsState().getTextMatrix());
  }

  /**
   * Test {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.setLineDashPattern(COSArray, int)"})
  void testSetLineDashPattern() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act
    pdfMarkedContentExtractor.setLineDashPattern(new COSArray(), 1);

    // Assert
    PDGraphicsState graphicsState = pdfMarkedContentExtractor.getGraphicsState();
    Rectangle2D frame = graphicsState.getCurrentClippingPath().getBounds().getBounds().getFrame();
    assertTrue(frame instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertTrue(toListResult.get(1) instanceof COSInteger);
    Rectangle bounds = frame.getBounds();
    assertEquals(0.0d, bounds.getLocation().getY());
    assertEquals(1, lineDashPattern.getPhase());
    assertEquals(792.0d, bounds.getSize().getHeight());
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray, int); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.setLineDashPattern(COSArray, int)"})
  void testSetLineDashPattern_givenA() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    COSArray array = new COSArray();
    COSObjectKey key = new COSObjectKey(1L, 1);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser parser = new COSParser(source);

    COSObject object = new COSObject(key, parser);
    array.add((COSBase) object);

    // Act
    pdfMarkedContentExtractor.setLineDashPattern(array, 1);

    // Assert
    PDLineDashPattern lineDashPattern =
        pdfMarkedContentExtractor.getGraphicsState().getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSInteger);
    assertEquals(1, lineDashPattern.getPhase());
    assertArrayEquals(new float[] {0.0f}, lineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName(
      "Test setLineDashPattern(COSArray, int); given COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.setLineDashPattern(COSArray, int)"})
  void testSetLineDashPattern_givenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    COSArray array = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    array.add((COSBase) object);

    // Act
    pdfMarkedContentExtractor.setLineDashPattern(array, 1);

    // Assert
    PDLineDashPattern lineDashPattern =
        pdfMarkedContentExtractor.getGraphicsState().getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSInteger);
    assertEquals(1, lineDashPattern.getPhase());
    assertArrayEquals(new float[] {0.0f}, lineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName(
      "Test setLineDashPattern(COSArray, int); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.setLineDashPattern(COSArray, int)"})
  void testSetLineDashPattern_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    COSArray array = new COSArray();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    array.add((COSBase) object);

    // Act
    pdfMarkedContentExtractor.setLineDashPattern(array, 1);

    // Assert
    PDLineDashPattern lineDashPattern =
        pdfMarkedContentExtractor.getGraphicsState().getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSInteger);
    assertEquals(1, lineDashPattern.getPhase());
    assertArrayEquals(new float[] {0.0f}, lineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray, int); given FALSE; when COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.setLineDashPattern(COSArray, int)"})
  void testSetLineDashPattern_givenFalse_whenCOSArrayAddFalse() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdfMarkedContentExtractor.setLineDashPattern(array, 1);

    // Assert
    PDLineDashPattern lineDashPattern =
        pdfMarkedContentExtractor.getGraphicsState().getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSInteger);
    assertEquals(1, lineDashPattern.getPhase());
    assertArrayEquals(new float[] {0.0f}, lineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray, int); given ONE; when COSArray() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.setLineDashPattern(COSArray, int)"})
  void testSetLineDashPattern_givenOne_whenCOSArrayAddOne() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    COSArray array = new COSArray();
    array.add(COSFloat.ONE);

    // Act
    pdfMarkedContentExtractor.setLineDashPattern(array, 1);

    // Assert
    PDGraphicsState graphicsState = pdfMarkedContentExtractor.getGraphicsState();
    Rectangle2D frame = graphicsState.getCurrentClippingPath().getBounds().getBounds().getFrame();
    assertTrue(frame instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertTrue(toListResult.get(1) instanceof COSInteger);
    assertEquals(0.0d, frame.getBounds().getLocation().getY());
    assertEquals(1, lineDashPattern.getPhase());
    assertArrayEquals(new float[] {1.0f}, lineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray, int); given ONE; when COSArray() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.setLineDashPattern(COSArray, int)"})
  void testSetLineDashPattern_givenOne_whenCOSArrayAddOne2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    COSArray array = new COSArray();
    array.add(COSInteger.ONE);

    // Act
    pdfMarkedContentExtractor.setLineDashPattern(array, 1);

    // Assert
    PDGraphicsState graphicsState = pdfMarkedContentExtractor.getGraphicsState();
    Rectangle2D frame = graphicsState.getCurrentClippingPath().getBounds().getBounds().getFrame();
    assertTrue(frame instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    Rectangle bounds = frame.getBounds();
    assertEquals(0.0d, bounds.getLocation().getY());
    assertEquals(2, ((COSArray) cOSObject).toList().size());
    assertEquals(792.0d, bounds.getSize().getHeight());
    assertArrayEquals(new float[] {1.0f}, lineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#getResources()}.
   *
   * <p>Method under test: {@link PDFStreamEngine#getResources()}
   */
  @Test
  @DisplayName("Test getResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDResources PDFStreamEngine.getResources()"})
  void testGetResources() {
    // Arrange, Act and Assert
    assertNull(new PDFMarkedContentExtractor().getResources());
  }

  /**
   * Test {@link PDFStreamEngine#getCurrentPage()}.
   *
   * <p>Method under test: {@link PDFStreamEngine#getCurrentPage()}
   */
  @Test
  @DisplayName("Test getCurrentPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDFStreamEngine.getCurrentPage()"})
  void testGetCurrentPage() {
    // Arrange, Act and Assert
    assertNull(new PDFMarkedContentExtractor().getCurrentPage());
  }

  /**
   * Test {@link PDFStreamEngine#getInitialMatrix()}.
   *
   * <p>Method under test: {@link PDFStreamEngine#getInitialMatrix()}
   */
  @Test
  @DisplayName("Test getInitialMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDFStreamEngine.getInitialMatrix()"})
  void testGetInitialMatrix() {
    // Arrange, Act and Assert
    assertNull(new PDFMarkedContentExtractor().getInitialMatrix());
  }

  /**
   * Test {@link PDFStreamEngine#transformedPoint(float, float)}.
   *
   * <ul>
   *   <li>Then return X is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#transformedPoint(float, float)}
   */
  @Test
  @DisplayName("Test transformedPoint(float, float); then return X is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Point2D.Float PDFStreamEngine.transformedPoint(float, float)"})
  void testTransformedPoint_thenReturnXIsTen() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act
    Float actualTransformedPointResult = pdfMarkedContentExtractor.transformedPoint(10.0f, 10.0f);

    // Assert
    assertEquals(10.0d, actualTransformedPointResult.getX());
    assertEquals(10.0d, actualTransformedPointResult.getY());
    assertEquals(10.0f, actualTransformedPointResult.x);
    assertEquals(10.0f, actualTransformedPointResult.y);
  }

  /**
   * Test {@link PDFStreamEngine#transformWidth(float)}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#transformWidth(float)}
   */
  @Test
  @DisplayName("Test transformWidth(float); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFStreamEngine.transformWidth(float)"})
  void testTransformWidth_thenReturnTen() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act and Assert
    assertEquals(10.0f, pdfMarkedContentExtractor.transformWidth(10.0f));
  }

  /**
   * Test {@link PDFStreamEngine#getLevel()}.
   *
   * <p>Method under test: {@link PDFStreamEngine#getLevel()}
   */
  @Test
  @DisplayName("Test getLevel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFStreamEngine.getLevel()"})
  void testGetLevel() {
    // Arrange, Act and Assert
    assertEquals(0, new PDFMarkedContentExtractor().getLevel());
  }

  /**
   * Test {@link PDFStreamEngine#increaseLevel()}.
   *
   * <p>Method under test: {@link PDFStreamEngine#increaseLevel()}
   */
  @Test
  @DisplayName("Test increaseLevel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.increaseLevel()"})
  void testIncreaseLevel() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act
    pdfMarkedContentExtractor.increaseLevel();

    // Assert
    assertEquals(1, pdfMarkedContentExtractor.getLevel());
  }

  /**
   * Test {@link PDFStreamEngine#decreaseLevel()}.
   *
   * <p>Method under test: {@link PDFStreamEngine#decreaseLevel()}
   */
  @Test
  @DisplayName("Test decreaseLevel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.decreaseLevel()"})
  void testDecreaseLevel() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act
    pdfMarkedContentExtractor.decreaseLevel();

    // Assert
    assertEquals(-1, pdfMarkedContentExtractor.getLevel());
  }
}
