package org.apache.pdfbox.examples.rendering;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType3CharProc;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomGraphicsStreamEngineDiffblueTest {
  /**
   * Test {@link CustomGraphicsStreamEngine#CustomGraphicsStreamEngine(PDPage)}.
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#CustomGraphicsStreamEngine(PDPage)}
   */
  @Test
  @DisplayName("Test new CustomGraphicsStreamEngine(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.<init>(PDPage)"})
  void testNewCustomGraphicsStreamEngine() throws IOException {
    // Arrange and Act
    CustomGraphicsStreamEngine actualCustomGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());

    // Assert
    Point2D currentPoint = actualCustomGraphicsStreamEngine.getCurrentPoint();
    assertTrue(currentPoint instanceof Float);
    assertNull(actualCustomGraphicsStreamEngine.getCurrentPage());
    assertNull(actualCustomGraphicsStreamEngine.getResources());
    assertNull(actualCustomGraphicsStreamEngine.getGraphicsState());
    assertNull(actualCustomGraphicsStreamEngine.getInitialMatrix());
    assertEquals(0, actualCustomGraphicsStreamEngine.getGraphicsStackSize());
    assertEquals(0, actualCustomGraphicsStreamEngine.getLevel());
    assertEquals(0.0d, currentPoint.getX());
    assertEquals(0.0d, currentPoint.getY());
    assertEquals(0.0f, ((Float) currentPoint).x);
    assertEquals(0.0f, ((Float) currentPoint).y);
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#run()}.
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun() throws IOException {
    // Arrange
    PDPage page = new PDPage(new COSDictionary());
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertSame(page, customGraphicsStreamEngine.getCurrentPage());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#run()}.
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun2() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    ArrayList<PDStream> contents = new ArrayList<>();
    page.setContents(contents);
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    float[][] values = customGraphicsStreamEngine.getInitialMatrix().getValues();
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
   * Test {@link CustomGraphicsStreamEngine#run()}.
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun3() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    page.setAnnotations(annotations);
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    float[][] values = customGraphicsStreamEngine.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(annotations, ((COSArray) getResult).toList());
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#run()}.
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun4() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    PDRectangle cropBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    page.setCropBox(cropBox);
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    assertEquals(1, customGraphicsStreamEngine.getGraphicsState().getCurrentClippingPaths().size());
    assertEquals(3, customGraphicsStreamEngine.getInitialMatrix().getValues().length);
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#run()}.
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun5() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    List<PDAnnotation> annotations2 = customGraphicsStreamEngine.getCurrentPage().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationCaret);
    COSDictionary cOSObject = getResult.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    float[][] values = customGraphicsStreamEngine.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[] {}, ((PDAnnotationCaret) getResult).getRectDifferences(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#run()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName(
      "Test run(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun_givenArrayListAddPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    float[][] values = customGraphicsStreamEngine.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#run()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName(
      "Test run(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun_givenPDPageContentsIsPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    float[][] values = customGraphicsStreamEngine.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#run()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link PDStream#PDStream(COSStream)} with str
   *       is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run(); given PDPage() Contents is PDStream(COSStream) with str is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun_givenPDPageContentsIsPDStreamWithStrIsCOSStream() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSStream()));
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    float[][] values = customGraphicsStreamEngine.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    PDGraphicsState graphicsState = customGraphicsStreamEngine.getGraphicsState();
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#run()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#PDRectangle()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run(); given PDPage() CropBox is PDRectangle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun_givenPDPageCropBoxIsPDRectangle() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle());
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    assertEquals(1, customGraphicsStreamEngine.getGraphicsState().getCurrentClippingPaths().size());
    assertEquals(3, customGraphicsStreamEngine.getInitialMatrix().getValues().length);
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#run()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new CustomGraphicsStreamEngine(null).run());
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#getCurrentPoint()}.
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#getCurrentPoint()}
   */
  @Test
  @DisplayName("Test getCurrentPoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Point2D CustomGraphicsStreamEngine.getCurrentPoint()"})
  void testGetCurrentPoint() throws IOException {
    // Arrange and Act
    Point2D actualCurrentPoint = new CustomGraphicsStreamEngine(new PDPage()).getCurrentPoint();

    // Assert
    assertTrue(actualCurrentPoint instanceof Float);
    assertEquals(0.0d, actualCurrentPoint.getX());
    assertEquals(0.0d, actualCurrentPoint.getY());
    assertEquals(0.0f, ((Float) actualCurrentPoint).x);
    assertEquals(0.0f, ((Float) actualCurrentPoint).y);
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName("Test showGlyph(Matrix, PDFont, int, Vector); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showGlyph(Matrix, PDFont, int, Vector)"})
  void testShowGlyph_thenThrowIllegalStateException() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    Matrix textRenderingMatrix = new Matrix();

    PDType3Font font = mock(PDType3Font.class);
    PDType3Font font2 = new PDType3Font(new COSDictionary());
    PDType3CharProc pdType3CharProc = new PDType3CharProc(font2, new COSStream());
    when(font.getCharProc(anyInt())).thenReturn(pdType3CharProc);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            customGraphicsStreamEngine.showGlyph(
                textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f)));
    verify(font).getCharProc(1);
  }
}
