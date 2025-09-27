package org.apache.pdfbox.contentstream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import java.util.ArrayList;
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
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;
import org.apache.pdfbox.pdmodel.font.PDType3CharProc;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDTransparencyGroup;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFStreamEngineDiffblueTest {
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
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    annotation.setRectangle(rectangle);

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(PDRectangle.A0);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, appearance);

    // Assert
    verify(appearance).getBBox();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getWidth()).thenThrow(new IllegalArgumentException());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    annotation.setRectangle(PDRectangle.A0);

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(PDRectangle.A0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdfMarkedContentExtractor.processAnnotation(annotation, appearance));
    verify(pdImmutableRectangle).getWidth();
    verify(appearance).getBBox();
    verify(annotation).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation3() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(1.0E-5f);
    when(pdImmutableRectangle.getWidth()).thenReturn(1.0E-5f);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    annotation.setRectangle(PDRectangle.A0);

    PDImmutableRectangle pdImmutableRectangle2 = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle2.getWidth()).thenThrow(new IllegalArgumentException());

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(pdImmutableRectangle2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdfMarkedContentExtractor.processAnnotation(annotation, appearance));
    verify(pdImmutableRectangle).getHeight();
    verify(pdImmutableRectangle).getWidth();
    verify(pdImmutableRectangle2).getWidth();
    verify(appearance).getBBox();
    verify(annotation).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation4() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(1.0E-5f);
    when(pdImmutableRectangle.getWidth()).thenReturn(1.0E-5f);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    annotation.setRectangle(PDRectangle.A0);

    PDImmutableRectangle pdImmutableRectangle2 = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle2.getHeight()).thenThrow(new IllegalArgumentException());
    when(pdImmutableRectangle2.getWidth()).thenReturn(1.0E-5f);

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(pdImmutableRectangle2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdfMarkedContentExtractor.processAnnotation(annotation, appearance));
    verify(pdImmutableRectangle).getHeight();
    verify(pdImmutableRectangle2).getHeight();
    verify(pdImmutableRectangle).getWidth();
    verify(pdImmutableRectangle2).getWidth();
    verify(appearance).getBBox();
    verify(annotation).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *   <li>Then calls {@link PDAppearanceStream#getBBox()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given A0; when PDAnnotationCaret(); then calls getBBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenA0_whenPDAnnotationCaret_thenCallsGetBBox() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(PDRectangle.A0);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, appearance);

    // Assert
    verify(appearance).getBBox();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#toFloatArray()} return array of {@code float} with
   *       ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray toFloatArray() return array of float with ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenCOSArrayToFloatArrayReturnArrayOfFloatWithTenAnd05()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(stream));

    // Assert
    verify(cosArray).toFloatArray();
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#toFloatArray()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray toFloatArray() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenCOSArrayToFloatArrayThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenThrow(new IllegalArgumentException());

    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            pdfMarkedContentExtractor.processAnnotation(
                annotation, new PDAppearanceStream(stream)));
    verify(cosArray).toFloatArray();
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link COSStream} {@link COSStream#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray(); when COSStream getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenCOSArray_whenCOSStreamGetCOSArrayReturnCOSArray()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(stream));

    // Assert
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link PDAppearanceStream#getResources()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given IllegalArgumentException(); then calls getResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenIllegalArgumentException_thenCallsGetResources()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getResources()).thenThrow(new IllegalArgumentException());
    when(appearance.getBBox()).thenReturn(PDRectangle.A0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdfMarkedContentExtractor.processAnnotation(annotation, appearance));
    verify(appearance).getBBox();
    verify(appearance).getResources();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PDAnnotationCaret} {@link PDAnnotationCaret#getRectangle()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given 'null'; when PDAnnotationCaret getRectangle() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenNull_whenPDAnnotationCaretGetRectangleReturnNull()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getRectangle()).thenReturn(null);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    annotation.setRectangle(PDRectangle.A0);

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(PDRectangle.A0);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, appearance);

    // Assert
    verify(appearance).getBBox();
    verify(annotation).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PDAppearanceStream} {@link PDAppearanceStream#getBBox()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given 'null'; when PDAppearanceStream getBBox() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenNull_whenPDAppearanceStreamGetBBoxReturnNull()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(null);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, appearance);

    // Assert
    verify(appearance).getBBox();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link PDImmutableRectangle} {@link PDImmutableRectangle#getHeight()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given PDImmutableRectangle getHeight() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenPDImmutableRectangleGetHeightReturnZero() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(0.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(1.0E-5f);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    annotation.setRectangle(PDRectangle.A0);

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(PDRectangle.A0);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, appearance);

    // Assert
    verify(pdImmutableRectangle).getHeight();
    verify(pdImmutableRectangle).getWidth();
    verify(appearance).getBBox();
    verify(annotation).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link PDImmutableRectangle} {@link PDImmutableRectangle#getHeight()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given PDImmutableRectangle getHeight() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenPDImmutableRectangleGetHeightReturnZero2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(1.0E-5f);
    when(pdImmutableRectangle.getWidth()).thenReturn(1.0E-5f);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    annotation.setRectangle(PDRectangle.A0);

    PDImmutableRectangle pdImmutableRectangle2 = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle2.getHeight()).thenReturn(0.0f);
    when(pdImmutableRectangle2.getWidth()).thenReturn(1.0E-5f);

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(pdImmutableRectangle2);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, appearance);

    // Assert
    verify(pdImmutableRectangle).getHeight();
    verify(pdImmutableRectangle2).getHeight();
    verify(pdImmutableRectangle).getWidth();
    verify(pdImmutableRectangle2).getWidth();
    verify(appearance).getBBox();
    verify(annotation).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link PDImmutableRectangle} {@link PDImmutableRectangle#getWidth()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given PDImmutableRectangle getWidth() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenPDImmutableRectangleGetWidthReturnZero() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getWidth()).thenReturn(0.0f);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    annotation.setRectangle(PDRectangle.A0);

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(PDRectangle.A0);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, appearance);

    // Assert
    verify(pdImmutableRectangle).getWidth();
    verify(appearance).getBBox();
    verify(annotation).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Given {@link PDImmutableRectangle} {@link PDImmutableRectangle#getWidth()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); given PDImmutableRectangle getWidth() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenPDImmutableRectangleGetWidthReturnZero2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(1.0E-5f);
    when(pdImmutableRectangle.getWidth()).thenReturn(1.0E-5f);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    annotation.setRectangle(PDRectangle.A0);

    PDImmutableRectangle pdImmutableRectangle2 = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle2.getWidth()).thenReturn(0.0f);

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(pdImmutableRectangle2);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, appearance);

    // Assert
    verify(pdImmutableRectangle).getHeight();
    verify(pdImmutableRectangle).getWidth();
    verify(pdImmutableRectangle2).getWidth();
    verify(appearance).getBBox();
    verify(annotation).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()} Rectangle is {@link
   *       PDRectangle#PDRectangle()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); when PDAnnotationCaret() Rectangle is PDRectangle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_whenPDAnnotationCaretRectangleIsPDRectangle() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(new PDRectangle());

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(PDRectangle.A0);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, appearance);

    // Assert
    verify(appearance).getBBox();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceStream} {@link PDAppearanceStream#getBBox()} return {@link
   *       PDRectangle#PDRectangle()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test processAnnotation(PDAnnotation, PDAppearanceStream); when PDAppearanceStream getBBox() return PDRectangle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_whenPDAppearanceStreamGetBBoxReturnPDRectangle() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);

    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(new PDRectangle());

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, appearance);

    // Assert
    verify(appearance).getBBox();
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
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getBBox()).thenThrow(new IllegalArgumentException());
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            pdfMarkedContentExtractor.processTilingPattern(
                tilingPattern, color, PDDeviceGray.INSTANCE, new Matrix()));
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getResources()).thenThrow(new IllegalArgumentException());
    when(pdAppearanceStream.getBBox()).thenReturn(PDRectangle.A0);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdfMarkedContentExtractor.showAnnotation(annotation));
    verify(pdAppearanceStream).getBBox();
    verify(pdAppearanceStream).getResources();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getWidth()).thenThrow(new IllegalArgumentException());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getBBox()).thenReturn(pdImmutableRectangle);

    PDImmutableRectangle pdImmutableRectangle2 = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle2.getHeight()).thenReturn(1.0E-5f);
    when(pdImmutableRectangle2.getWidth()).thenReturn(1.0E-5f);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle2);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdfMarkedContentExtractor.showAnnotation(annotation));
    verify(pdImmutableRectangle2).getHeight();
    verify(pdImmutableRectangle2).getWidth();
    verify(pdImmutableRectangle).getWidth();
    verify(pdAppearanceStream).getBBox();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation3() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenThrow(new IllegalArgumentException());
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getBBox()).thenReturn(pdImmutableRectangle);

    PDImmutableRectangle pdImmutableRectangle2 = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle2.getHeight()).thenReturn(1.0E-5f);
    when(pdImmutableRectangle2.getWidth()).thenReturn(1.0E-5f);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle2);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdfMarkedContentExtractor.showAnnotation(annotation));
    verify(pdImmutableRectangle2).getHeight();
    verify(pdImmutableRectangle).getHeight();
    verify(pdImmutableRectangle2).getWidth();
    verify(pdImmutableRectangle).getWidth();
    verify(pdAppearanceStream).getBBox();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSStream#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given COSArray() add FALSE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenCOSArrayAddFalse_thenCallsGetCOSArray() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(null);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   *   <li>Then calls {@link COSStream#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given COSStream getCOSArray(COSName) return COSArray(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenCOSStreamGetCOSArrayReturnCOSArray_thenCallsGetCOSArray()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(null);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenIllegalArgumentException() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenThrow(new IllegalArgumentException());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdfMarkedContentExtractor.showAnnotation(annotation));
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PDAnnotation} {@link PDAnnotation#getNormalAppearanceStream()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given 'null'; when PDAnnotation getNormalAppearanceStream() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenNull_whenPDAnnotationGetNormalAppearanceStreamReturnNull()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(null);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(annotation).getNormalAppearanceStream();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link PDAppearanceStream} {@link PDAppearanceStream#getBBox()} return {@link
   *       PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given PDAppearanceStream getBBox() return A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenPDAppearanceStreamGetBBoxReturnA0() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getBBox()).thenReturn(PDRectangle.A0);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(null);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pdAppearanceStream).getBBox();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link PDAppearanceStream} {@link PDAppearanceStream#getBBox()} return {@link
   *       PDRectangle#PDRectangle()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given PDAppearanceStream getBBox() return PDRectangle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenPDAppearanceStreamGetBBoxReturnPDRectangle() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getBBox()).thenReturn(new PDRectangle());

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pdAppearanceStream).getBBox();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link PDAppearanceStream#PDAppearanceStream(COSStream)} with stream is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given PDAppearanceStream(COSStream) with stream is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenPDAppearanceStreamWithStreamIsCOSStream() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(null);
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link PDAppearanceStream#PDAppearanceStream(COSStream)} with stream is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given PDAppearanceStream(COSStream) with stream is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenPDAppearanceStreamWithStreamIsCOSStream2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link PDImmutableRectangle} {@link PDImmutableRectangle#getHeight()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given PDImmutableRectangle getHeight() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenPDImmutableRectangleGetHeightReturnZero() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getBBox()).thenReturn(PDRectangle.A0);

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(0.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(1.0E-5f);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pdImmutableRectangle).getHeight();
    verify(pdImmutableRectangle).getWidth();
    verify(pdAppearanceStream).getBBox();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link PDImmutableRectangle} {@link PDImmutableRectangle#getHeight()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given PDImmutableRectangle getHeight() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenPDImmutableRectangleGetHeightReturnZero2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(0.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getBBox()).thenReturn(pdImmutableRectangle);

    PDImmutableRectangle pdImmutableRectangle2 = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle2.getHeight()).thenReturn(1.0E-5f);
    when(pdImmutableRectangle2.getWidth()).thenReturn(1.0E-5f);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle2);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pdImmutableRectangle2).getHeight();
    verify(pdImmutableRectangle).getHeight();
    verify(pdImmutableRectangle2).getWidth();
    verify(pdImmutableRectangle).getWidth();
    verify(pdAppearanceStream).getBBox();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link PDImmutableRectangle} {@link PDImmutableRectangle#getWidth()} return zero.
   *   <li>Then calls {@link PDImmutableRectangle#getWidth()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test showAnnotation(PDAnnotation); given PDImmutableRectangle getWidth() return zero; then calls getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenPDImmutableRectangleGetWidthReturnZero_thenCallsGetWidth()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getBBox()).thenReturn(PDRectangle.A0);

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getWidth()).thenReturn(0.0f);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pdImmutableRectangle).getWidth();
    verify(pdAppearanceStream).getBBox();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given PDRectangle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenPDRectangle() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getBBox()).thenReturn(PDRectangle.A0);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(pdAppearanceStream).getBBox();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_thenCallsAdd() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(null);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).toFloatArray();
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getResources()).thenThrow(new IllegalStateException());
    when(pdAppearanceStream.getBBox()).thenReturn(pdImmutableRectangle);

    PDImmutableRectangle pdImmutableRectangle2 = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle2.getHeight()).thenReturn(1.0E-5f);
    when(pdImmutableRectangle2.getWidth()).thenReturn(1.0E-5f);

    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle2);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> pdfMarkedContentExtractor.showAnnotation(annotation));
    verify(pdImmutableRectangle2).getHeight();
    verify(pdImmutableRectangle).getHeight();
    verify(pdImmutableRectangle2).getWidth();
    verify(pdImmutableRectangle).getWidth();
    verify(pdAppearanceStream).getBBox();
    verify(pdAppearanceStream).getResources();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
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
   * Test {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PDType3Font} {@link PDType3Font#getCharProc(int)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}
   */
  @Test
  @DisplayName(
      "Test showType3Glyph(Matrix, PDType3Font, int, Vector); given 'null'; when PDType3Font getCharProc(int) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.showType3Glyph(Matrix, PDType3Font, int, Vector)"})
  void testShowType3Glyph_givenNull_whenPDType3FontGetCharProcReturnNull() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    Matrix textRenderingMatrix = new Matrix();

    PDType3Font font = mock(PDType3Font.class);
    when(font.getCharProc(anyInt())).thenReturn(null);

    // Act
    pdfMarkedContentExtractor.showType3Glyph(
        textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert
    verify(font).getCharProc(1);
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
   * Test {@link PDFStreamEngine#beginMarkedContentSequence(COSName, COSDictionary)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.beginMarkedContentSequence(COSName, COSDictionary)"})
  void testBeginMarkedContentSequence() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    COSDictionary properties = new COSDictionary();

    // Act
    pdfMarkedContentExtractor.beginMarkedContentSequence(COSName.A, properties);

    // Assert
    List<PDMarkedContent> markedContents = pdfMarkedContentExtractor.getMarkedContents();
    assertEquals(1, markedContents.size());
    PDMarkedContent getResult = markedContents.get(0);
    assertEquals("A", getResult.getTag());
    assertNull(getResult.getActualText());
    assertNull(getResult.getAlternateDescription());
    assertNull(getResult.getExpandedForm());
    assertNull(getResult.getLanguage());
    assertEquals(-1, getResult.getMCID());
    assertTrue(getResult.getContents().isEmpty());
    assertSame(properties, getResult.getProperties());
  }

  /**
   * Test {@link PDFStreamEngine#beginMarkedContentSequence(COSName, COSDictionary)}.
   *
   * <p>Method under test: {@link PDFStreamEngine#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.beginMarkedContentSequence(COSName, COSDictionary)"})
  void testBeginMarkedContentSequence2() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    COSDictionary properties = new COSDictionary();

    // Act
    pdfMarkedContentExtractor.beginMarkedContentSequence(null, properties);

    // Assert
    List<PDMarkedContent> markedContents = pdfMarkedContentExtractor.getMarkedContents();
    assertEquals(1, markedContents.size());
    PDMarkedContent getResult = markedContents.get(0);
    assertNull(getResult.getActualText());
    assertNull(getResult.getAlternateDescription());
    assertNull(getResult.getExpandedForm());
    assertNull(getResult.getLanguage());
    assertNull(getResult.getTag());
    assertEquals(-1, getResult.getMCID());
    assertTrue(getResult.getContents().isEmpty());
    assertSame(properties, getResult.getProperties());
  }

  /**
   * Test {@link PDFStreamEngine#processOperator(Operator, List)} with {@code operator}, {@code
   * operands}.
   *
   * <ul>
   *   <li>Given {@code Do}.
   *   <li>Then calls {@link Operator#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#processOperator(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test processOperator(Operator, List) with 'operator', 'operands'; given 'Do'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.processOperator(Operator, List)"})
  void testProcessOperatorWithOperatorOperands_givenDo_thenCallsGetName() throws IOException {
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
   * Test {@link PDFStreamEngine#operatorException(Operator, List, IOException)}.
   *
   * <ul>
   *   <li>Given {@code Do}.
   *   <li>When {@link Operator} {@link Operator#getName()} return {@code Do}.
   *   <li>Then calls {@link Operator#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamEngine#operatorException(Operator, List, IOException)}
   */
  @Test
  @DisplayName(
      "Test operatorException(Operator, List, IOException); given 'Do'; when Operator getName() return 'Do'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.operatorException(Operator, List, IOException)"})
  void testOperatorException_givenDo_whenOperatorGetNameReturnDo_thenCallsGetName()
      throws IOException {
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

    IOException exception = new IOException("foo");
    exception.initCause(new DataFormatException());

    // Act
    pdfMarkedContentExtractor.operatorException(operator, operands, exception);

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
  @MethodsUnderTest({"java.util.Deque PDFStreamEngine.saveGraphicsStack()"})
  void testSaveGraphicsStack_thenReturnSizeIsOne() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act and Assert
    assertEquals(1, pdfMarkedContentExtractor.saveGraphicsStack().size());
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
   * <p>Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.setLineDashPattern(COSArray, int)"})
  void testSetLineDashPattern2() throws IOException {
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
   * <p>Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamEngine.setLineDashPattern(COSArray, int)"})
  void testSetLineDashPattern3() throws IOException {
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
