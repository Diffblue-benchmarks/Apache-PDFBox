package org.apache.pdfbox.examples.rendering;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3CharProc;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationUnknown;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun6() throws IOException {
    // Arrange
    PDPage page = new PDPage();

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(new ArrayList<>());
    page.setContents(contents);
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    Iterator<PDStream> contentStreams =
        customGraphicsStreamEngine.getCurrentPage().getContentStreams();
    PDStream nextResult = contentStreams.next();
    float[][] values = customGraphicsStreamEngine.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(contentStreams.hasNext());
    assertTrue(nextResult.getFilters().isEmpty());
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
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun7() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(null);

    PDPage page = new PDPage();
    page.setContents(contents);
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    Iterator<PDStream> contentStreams =
        customGraphicsStreamEngine.getCurrentPage().getContentStreams();
    assertNull(contentStreams.next().getCOSObject());
    float[][] values = customGraphicsStreamEngine.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(contentStreams.hasNext());
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
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun8() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());
    annotations.add(pdAnnotationCaret);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    List<PDAnnotation> annotations2 = customGraphicsStreamEngine.getCurrentPage().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationUnknown);
    float[][] values = customGraphicsStreamEngine.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(pdAnnotationCaret, getResult);
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
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun9() throws IOException {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary(new COSDictionary()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(pdAnnotationCaret);

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
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun10() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(500L, 500);
    dictionary.setKey(key);
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(appearance);

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(pdAnnotationCaret);

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
    float[][] values = customGraphicsStreamEngine.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(key, getResult.getAppearance().getCOSObject().getKey());
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
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun11() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(appearance);

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(pdAnnotationCaret);

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
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun12() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setRectangle(new PDRectangle());
    pdAnnotationCaret.setAppearance(appearance);

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(pdAnnotationCaret);

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
    PDRectangle rectangle = getResult.getRectangle();
    assertEquals(0.0f, rectangle.getUpperRightX());
    assertEquals(0.0f, rectangle.getWidth());
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
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun13() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f));
    pdAnnotationCaret.setAppearance(appearance);

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(pdAnnotationCaret);

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
    PDRectangle rectangle = getResult.getRectangle();
    assertEquals(2.14748365E9f, rectangle.getHeight());
    assertEquals(2.14748365E9f, rectangle.getUpperRightY());
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
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun14() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream str =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 500L, 3L));
    page.setContents(new PDStream(str));
    CustomGraphicsStreamEngine customGraphicsStreamEngine = new CustomGraphicsStreamEngine(page);

    // Act
    customGraphicsStreamEngine.run();

    // Assert
    PDPage currentPage = customGraphicsStreamEngine.getCurrentPage();
    RandomAccessRead contentsForRandomAccess = currentPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadView);
    RandomAccessRead contentsForStreamParsing = currentPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadView);
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(3, contentsForRandomAccess.available());
    assertEquals(3, contentsForStreamParsing.available());
    float[][] values = customGraphicsStreamEngine.getInitialMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(51, new byte[51].length);
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForStreamParsing.isClosed());
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
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()} Appearance is {@link
   *       PDAppearanceDictionary#PDAppearanceDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run(); given PDAnnotationCaret() Appearance is PDAppearanceDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun_givenPDAnnotationCaretAppearanceIsPDAppearanceDictionary() throws IOException {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary());

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(pdAnnotationCaret);

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
   *   <li>Given {@link PDRectangle#PDRectangle()} LowerLeftX is {@code 2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#run()}
   */
  @Test
  @DisplayName("Test run(); given PDRectangle() LowerLeftX is '2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.run()"})
  void testRun_givenPDRectangleLowerLeftXIs214748365e9() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    PDRectangle rectangle = new PDRectangle();
    rectangle.setLowerLeftX(2.14748365E9f);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setRectangle(rectangle);
    pdAnnotationCaret.setAppearance(appearance);

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(pdAnnotationCaret);

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
   * Test {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}.
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  @DisplayName("Test showTextStrings(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showTextStrings(COSArray)"})
  void testShowTextStrings() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    customGraphicsStreamEngine.processPage(new PDPage());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();

    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    cosStream.addAll(new COSDictionary());

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(cosStream);

    COSArray array = mock(COSArray.class);
    when(array.iterator()).thenReturn(cosBaseList.iterator());
    doNothing().when(array).add(Mockito.<COSBase>any());
    array.add((COSBase) new COSArray());

    // Act
    customGraphicsStreamEngine.showTextStrings(array);

    // Assert
    verify(array).add(isA(COSBase.class));
    verify(array).iterator();
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}.
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  @DisplayName("Test showTextStrings(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showTextStrings(COSArray)"})
  void testShowTextStrings2() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    customGraphicsStreamEngine.processPage(new PDPage());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();

    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), -1L, 3L));
    cosStream.addAll(new COSDictionary());

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(cosStream);

    COSArray array = mock(COSArray.class);
    when(array.iterator()).thenReturn(cosBaseList.iterator());
    doNothing().when(array).add(Mockito.<COSBase>any());
    array.add((COSBase) new COSArray());

    // Act
    customGraphicsStreamEngine.showTextStrings(array);

    // Assert
    verify(array).add(isA(COSBase.class));
    verify(array).iterator();
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  @DisplayName("Test showTextStrings(COSArray); given 'A'; then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showTextStrings(COSArray)"})
  void testShowTextStrings_givenA_thenCallsAdd() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    customGraphicsStreamEngine.processPage(new PDPage());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    COSStream cosStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));
    cosStream.addAll(new COSDictionary());

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(cosStream);

    COSArray array = mock(COSArray.class);
    when(array.iterator()).thenReturn(cosBaseList.iterator());
    doNothing().when(array).add(Mockito.<COSBase>any());
    array.add((COSBase) new COSArray());

    // Act
    customGraphicsStreamEngine.showTextStrings(array);

    // Assert
    verify(array).add(isA(COSBase.class));
    verify(array).iterator();
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add Boolean is {@code true}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  @DisplayName(
      "Test showTextStrings(COSArray); given ArrayList() add Boolean is 'true'; then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showTextStrings(COSArray)"})
  void testShowTextStrings_givenArrayListAddBooleanIsTrue_thenCallsAdd() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    customGraphicsStreamEngine.processPage(new PDPage());

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(COSBoolean.getBoolean(true));

    COSArray array = mock(COSArray.class);
    when(array.iterator()).thenReturn(cosBaseList.iterator());
    doNothing().when(array).add(Mockito.<COSBase>any());
    array.add((COSBase) new COSArray());

    // Act
    customGraphicsStreamEngine.showTextStrings(array);

    // Assert
    verify(array).add(isA(COSBase.class));
    verify(array).iterator();
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  @DisplayName(
      "Test showTextStrings(COSArray); given ArrayList() add COSDictionary(); then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showTextStrings(COSArray)"})
  void testShowTextStrings_givenArrayListAddCOSDictionary_thenCallsAdd() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    customGraphicsStreamEngine.processPage(new PDPage());

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(new COSDictionary());

    COSArray array = mock(COSArray.class);
    when(array.iterator()).thenReturn(cosBaseList.iterator());
    doNothing().when(array).add(Mockito.<COSBase>any());
    array.add((COSBase) new COSArray());

    // Act
    customGraphicsStreamEngine.showTextStrings(array);

    // Assert
    verify(array).add(isA(COSBase.class));
    verify(array).iterator();
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  @DisplayName(
      "Test showTextStrings(COSArray); given ArrayList() iterator; then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showTextStrings(COSArray)"})
  void testShowTextStrings_givenArrayListIterator_thenCallsAdd() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    customGraphicsStreamEngine.processPage(new PDPage());

    COSArray array = mock(COSArray.class);

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    when(array.iterator()).thenReturn(cosBaseList.iterator());
    doNothing().when(array).add(Mockito.<COSBase>any());
    array.add((COSBase) new COSArray());

    // Act
    customGraphicsStreamEngine.showTextStrings(array);

    // Assert
    verify(array).add(isA(COSBase.class));
    verify(array).iterator();
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} addAll {@link COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  @DisplayName(
      "Test showTextStrings(COSArray); given COSStream() addAll COSDictionary(); then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showTextStrings(COSArray)"})
  void testShowTextStrings_givenCOSStreamAddAllCOSDictionary_thenCallsAdd() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    customGraphicsStreamEngine.processPage(new PDPage());

    COSStream cosStream = new COSStream();
    cosStream.addAll(new COSDictionary());

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(cosStream);

    COSArray array = mock(COSArray.class);
    when(array.iterator()).thenReturn(cosBaseList.iterator());
    doNothing().when(array).add(Mockito.<COSBase>any());
    array.add((COSBase) new COSArray());

    // Act
    customGraphicsStreamEngine.showTextStrings(array);

    // Assert
    verify(array).add(isA(COSBase.class));
    verify(array).iterator();
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}.
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName("Test showGlyph(Matrix, PDFont, int, Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showGlyph(Matrix, PDFont, int, Vector)"})
  void testShowGlyph() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    customGraphicsStreamEngine.processPage(new PDPage());
    Matrix textRenderingMatrix = new Matrix();

    PDType3CharProc pdType3CharProc = mock(PDType3CharProc.class);
    when(pdType3CharProc.getContentsForStreamParsing())
        .thenReturn(new RandomAccessReadWriteBuffer());
    when(pdType3CharProc.getResources()).thenReturn(new PDResources());
    when(pdType3CharProc.getMatrix()).thenReturn(new Matrix());

    PDType3Font font = mock(PDType3Font.class);
    when(font.getCharProc(anyInt())).thenReturn(pdType3CharProc);

    // Act
    customGraphicsStreamEngine.showGlyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert
    verify(pdType3CharProc).getContentsForStreamParsing();
    verify(pdType3CharProc).getMatrix();
    verify(pdType3CharProc).getResources();
    verify(font).getCharProc(1);
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then calls {@link PDType3CharProc#getContentsForStreamParsing()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName(
      "Test showGlyph(Matrix, PDFont, int, Vector); given 'A'; then calls getContentsForStreamParsing()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showGlyph(Matrix, PDFont, int, Vector)"})
  void testShowGlyph_givenA_thenCallsGetContentsForStreamParsing() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    customGraphicsStreamEngine.processPage(new PDPage());
    Matrix textRenderingMatrix = new Matrix();

    PDType3CharProc pdType3CharProc = mock(PDType3CharProc.class);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    when(pdType3CharProc.getContentsForStreamParsing())
        .thenReturn(new RandomAccessReadBuffer(input));
    when(pdType3CharProc.getResources()).thenReturn(new PDResources());
    when(pdType3CharProc.getMatrix()).thenReturn(new Matrix());

    PDType3Font font = mock(PDType3Font.class);
    when(font.getCharProc(anyInt())).thenReturn(pdType3CharProc);

    // Act
    customGraphicsStreamEngine.showGlyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert
    verify(pdType3CharProc).getContentsForStreamParsing();
    verify(pdType3CharProc).getMatrix();
    verify(pdType3CharProc).getResources();
    verify(font).getCharProc(1);
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}.
   *
   * <ul>
   *   <li>Then calls {@link PDType3Font#getFontMatrix()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName("Test showGlyph(Matrix, PDFont, int, Vector); then calls getFontMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showGlyph(Matrix, PDFont, int, Vector)"})
  void testShowGlyph_thenCallsGetFontMatrix() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    customGraphicsStreamEngine.processPage(new PDPage());
    Matrix textRenderingMatrix = new Matrix();

    PDType3Font font = mock(PDType3Font.class);
    when(font.getResources()).thenReturn(new PDResources());
    when(font.getFontMatrix()).thenReturn(new Matrix());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream charStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    PDType3Font font2 = mock(PDType3Font.class);
    when(font2.getCharProc(anyInt())).thenReturn(pdType3CharProc);

    // Act
    customGraphicsStreamEngine.showGlyph(textRenderingMatrix, font2, 1, new Vector(10.0f, 10.0f));

    // Assert
    verify(font2).getCharProc(1);
    verify(font).getFontMatrix();
    verify(font).getResources();
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

  /**
   * Test {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}.
   *
   * <ul>
   *   <li>When {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName(
      "Test showGlyph(Matrix, PDFont, int, Vector); when PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showGlyph(Matrix, PDFont, int, Vector)"})
  void testShowGlyph_whenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    Matrix textRenderingMatrix = new Matrix();
    PDMMType1Font font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            customGraphicsStreamEngine.showGlyph(
                textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f)));
  }

  /**
   * Test {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}.
   *
   * <ul>
   *   <li>When {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CustomGraphicsStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName(
      "Test showGlyph(Matrix, PDFont, int, Vector); when PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomGraphicsStreamEngine.showGlyph(Matrix, PDFont, int, Vector)"})
  void testShowGlyph_whenPDType3FontWithFontDictionaryIsCOSDictionary_thenDoesNotThrow()
      throws IOException {
    // Arrange
    CustomGraphicsStreamEngine customGraphicsStreamEngine =
        new CustomGraphicsStreamEngine(new PDPage());
    Matrix textRenderingMatrix = new Matrix();
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            customGraphicsStreamEngine.showGlyph(
                textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f)));
  }
}
