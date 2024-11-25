package org.apache.pdfbox.contentstream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
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
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;
import org.apache.pdfbox.pdmodel.font.PDType3CharProc;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDTransparencyGroup;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.graphics.state.PDTextState;
import org.apache.pdfbox.pdmodel.graphics.state.RenderingMode;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFStreamEngineDiffblueTest {
  /**
   * Test {@link PDFStreamEngine#showTransparencyGroup(PDTransparencyGroup)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup)")
  void testShowTransparencyGroup() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdfMarkedContentExtractor.showTransparencyGroup(new PDTransparencyGroup(new PDDocument())));
  }

  /**
   * Test {@link PDFStreamEngine#showForm(PDFormXObject)}.
   * <p>
   * Method under test: {@link PDFStreamEngine#showForm(PDFormXObject)}
   */
  @Test
  @DisplayName("Test showForm(PDFormXObject)")
  void testShowForm() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdfMarkedContentExtractor.showForm(new PDFormXObject(new COSStream())));
  }

  /**
   * Test {@link PDFStreamEngine#processTransparencyGroup(PDTransparencyGroup)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test processTransparencyGroup(PDTransparencyGroup)")
  void testProcessTransparencyGroup() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdfMarkedContentExtractor.processTransparencyGroup(new PDTransparencyGroup(new PDDocument())));
  }

  /**
   * Test {@link PDFStreamEngine#processType3Stream(PDType3CharProc, Matrix)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processType3Stream(PDType3CharProc, Matrix)}
   */
  @Test
  @DisplayName("Test processType3Stream(PDType3CharProc, Matrix)")
  void testProcessType3Stream() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDType3Font font = new PDType3Font(new COSDictionary());
    PDType3CharProc charProc = new PDType3CharProc(font, new COSStream());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdfMarkedContentExtractor.processType3Stream(charProc, new Matrix()));
  }

  /**
   * Test
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream)")
  void testProcessAnnotation() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{2.14748365E9f, 0.5f, 10.0f, 0.5f});
    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(stream));

    // Assert
    verify(cosArray).toFloatArray();
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getRectangle();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.</li>
   *   <li>When {@link PDAnnotation} {@link PDAnnotation#getRectangle()} return
   * {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); given A0; when PDAnnotation getRectangle() return A0")
  void testProcessAnnotation_givenA0_whenPDAnnotationGetRectangleReturnA0() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(new COSStream()));

    // Assert that nothing has changed
    verify(annotation).getRectangle();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#toFloatArray()} return array of
   * {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray toFloatArray() return array of float with ten and '0.5'")
  void testProcessAnnotation_givenCOSArrayToFloatArrayReturnArrayOfFloatWithTenAnd05() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(stream));

    // Assert
    verify(cosArray).toFloatArray();
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getRectangle();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link COSStream} {@link COSDictionary#getCOSArray(COSName)} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray(); when COSStream getCOSArray(COSName) return COSArray()")
  void testProcessAnnotation_givenCOSArray_whenCOSStreamGetCOSArrayReturnCOSArray() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(stream));

    // Assert
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getRectangle();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); given PDRectangle()")
  void testProcessAnnotation_givenPDRectangle() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(new COSStream()));

    // Assert that nothing has changed
    verify(annotation).getRectangle();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getHeight()} return
   * zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); given PDRectangle getHeight() return zero")
  void testProcessAnnotation_givenPDRectangleGetHeightReturnZero() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(0.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(new COSStream()));

    // Assert that nothing has changed
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getRectangle();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); then throw IllegalArgumentException")
  void testProcessAnnotation_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenThrow(new IllegalArgumentException("foo"));
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(new COSStream())));
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getRectangle();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); then throw IllegalArgumentException")
  void testProcessAnnotation_thenThrowIllegalArgumentException2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDRectangle pdRectangle2 = mock(PDRectangle.class);
    when(pdRectangle2.getHeight()).thenThrow(new IllegalArgumentException("foo"));
    when(pdRectangle2.getWidth()).thenReturn(10.0f);
    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getBBox()).thenReturn(pdRectangle2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdfMarkedContentExtractor.processAnnotation(annotation, appearance));
    verify(pdRectangle).getHeight();
    verify(pdRectangle2).getHeight();
    verify(pdRectangle).getWidth();
    verify(pdRectangle2).getWidth();
    verify(appearance).getBBox();
    verify(annotation).getRectangle();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); then throw IllegalStateException")
  void testProcessAnnotation_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX())
        .thenThrow(new IllegalStateException("Multiplying two matrices produces illegal values"));
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDRectangle pdRectangle2 = mock(PDRectangle.class);
    when(pdRectangle2.transform(Mockito.<Matrix>any())).thenReturn(new GeneralPath(1));
    when(pdRectangle2.getHeight()).thenReturn(10.0f);
    when(pdRectangle2.getWidth()).thenReturn(10.0f);
    PDAppearanceStream appearance = mock(PDAppearanceStream.class);
    when(appearance.getMatrix()).thenReturn(new Matrix());
    when(appearance.getResources()).thenReturn(new PDResources());
    when(appearance.getBBox()).thenReturn(pdRectangle2);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdfMarkedContentExtractor.processAnnotation(annotation, appearance));
    verify(pdRectangle).getHeight();
    verify(pdRectangle2).getHeight();
    verify(pdRectangle).getLowerLeftX();
    verify(pdRectangle).getWidth();
    verify(pdRectangle2).getWidth();
    verify(pdRectangle2).transform(isA(Matrix.class));
    verify(appearance).getBBox();
    verify(appearance).getMatrix();
    verify(appearance).getResources();
    verify(annotation).getRectangle();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>When {@link PDAppearanceStream#PDAppearanceStream(COSStream)} with stream
   * is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); when PDAppearanceStream(COSStream) with stream is COSStream()")
  void testProcessAnnotation_whenPDAppearanceStreamWithStreamIsCOSStream() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(new COSStream()));

    // Assert that nothing has changed
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getRectangle();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   * with {@code tilingPattern}, {@code color}, {@code colorSpace}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   */
  @Test
  @DisplayName("Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'")
  void testProcessTilingPatternWithTilingPatternColorColorSpace() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());

    // Act
    pdfMarkedContentExtractor.processTilingPattern(tilingPattern, new PDColor(new COSArray(), PDDeviceGray.INSTANCE),
        PDDeviceGray.INSTANCE);

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   * with {@code tilingPattern}, {@code color}, {@code colorSpace}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   */
  @Test
  @DisplayName("Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'")
  void testProcessTilingPatternWithTilingPatternColorColorSpace2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("\tXAXAXAX".getBytes("UTF-8"))));
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());

    // Act
    pdfMarkedContentExtractor.processTilingPattern(tilingPattern, new PDColor(new COSArray(), PDDeviceGray.INSTANCE),
        PDDeviceGray.INSTANCE);

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   * with {@code tilingPattern}, {@code color}, {@code colorSpace}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   */
  @Test
  @DisplayName("Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'")
  void testProcessTilingPatternWithTilingPatternColorColorSpace3() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing()).thenReturn(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());

    // Act
    pdfMarkedContentExtractor.processTilingPattern(tilingPattern, new PDColor(new COSArray(), PDDeviceGray.INSTANCE),
        PDDeviceGray.INSTANCE);

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   * with {@code tilingPattern}, {@code color}, {@code colorSpace}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   */
  @Test
  @DisplayName("Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'")
  void testProcessTilingPatternWithTilingPatternColorColorSpace4() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("A\tAXAXAX".getBytes("UTF-8"))));
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());

    // Act
    pdfMarkedContentExtractor.processTilingPattern(tilingPattern, new PDColor(new COSArray(), PDDeviceGray.INSTANCE),
        PDDeviceGray.INSTANCE);

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   * with {@code tilingPattern}, {@code color}, {@code colorSpace}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   */
  @Test
  @DisplayName("Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace) with 'tilingPattern', 'color', 'colorSpace'")
  void testProcessTilingPatternWithTilingPatternColorColorSpace5() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing()).thenReturn(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 4, 'A', 'X', 'A', 'X', 'A', 'X'})));
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    when(tilingPattern.getMatrix()).thenReturn(new Matrix());

    // Act
    pdfMarkedContentExtractor.processTilingPattern(tilingPattern, new PDColor(new COSArray(), PDDeviceGray.INSTANCE),
        PDDeviceGray.INSTANCE);

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getMatrix();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   * with {@code tilingPattern}, {@code color}, {@code colorSpace},
   * {@code patternMatrix}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   */
  @Test
  @DisplayName("Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix) with 'tilingPattern', 'color', 'colorSpace', 'patternMatrix'")
  void testProcessTilingPatternWithTilingPatternColorColorSpacePatternMatrix() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    pdfMarkedContentExtractor.processTilingPattern(tilingPattern, color, PDDeviceGray.INSTANCE, new Matrix());

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   * with {@code tilingPattern}, {@code color}, {@code colorSpace},
   * {@code patternMatrix}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   */
  @Test
  @DisplayName("Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix) with 'tilingPattern', 'color', 'colorSpace', 'patternMatrix'")
  void testProcessTilingPatternWithTilingPatternColorColorSpacePatternMatrix2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("\tXAXAXAX".getBytes("UTF-8"))));
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    pdfMarkedContentExtractor.processTilingPattern(tilingPattern, color, PDDeviceGray.INSTANCE, new Matrix());

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   * with {@code tilingPattern}, {@code color}, {@code colorSpace},
   * {@code patternMatrix}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   */
  @Test
  @DisplayName("Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix) with 'tilingPattern', 'color', 'colorSpace', 'patternMatrix'")
  void testProcessTilingPatternWithTilingPatternColorColorSpacePatternMatrix3() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("A\tAXAXAX".getBytes("UTF-8"))));
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    pdfMarkedContentExtractor.processTilingPattern(tilingPattern, color, PDDeviceGray.INSTANCE, new Matrix());

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   * with {@code tilingPattern}, {@code color}, {@code colorSpace},
   * {@code patternMatrix}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   */
  @Test
  @DisplayName("Test processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix) with 'tilingPattern', 'color', 'colorSpace', 'patternMatrix'; given 'A'")
  void testProcessTilingPatternWithTilingPatternColorColorSpacePatternMatrix_givenA() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing()).thenReturn(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    when(tilingPattern.getBBox()).thenReturn(PDRectangle.A0);
    when(tilingPattern.getResources()).thenReturn(new PDResources());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    pdfMarkedContentExtractor.processTilingPattern(tilingPattern, color, PDDeviceGray.INSTANCE, new Matrix());

    // Assert
    verify(tilingPattern).getContentsForStreamParsing();
    verify(tilingPattern).getBBox();
    verify(tilingPattern).getResources();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation)")
  void testShowAnnotation() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{2.14748365E9f, 0.5f, 10.0f, 0.5f});
    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(cosArray).toFloatArray();
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.</li>
   *   <li>When {@link PDAnnotation} {@link PDAnnotation#getRectangle()} return
   * {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given A0; when PDAnnotation getRectangle() return A0")
  void testShowAnnotation_givenA0_whenPDAnnotationGetRectangleReturnA0() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert that nothing has changed
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#toFloatArray()} return array of
   * {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given COSArray toFloatArray() return array of float with ten and '0.5'")
  void testShowAnnotation_givenCOSArrayToFloatArrayReturnArrayOfFloatWithTenAnd05() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(cosArray).toFloatArray();
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSDictionary#getCOSArray(COSName)} return
   * {@link COSArray#COSArray()}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given COSStream getCOSArray(COSName) return COSArray(); then calls getCOSArray(COSName)")
  void testShowAnnotation_givenCOSStreamGetCOSArrayReturnCOSArray_thenCallsGetCOSArray() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given IllegalArgumentException(String) with 'foo'")
  void testShowAnnotation_givenIllegalArgumentExceptionWithFoo() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenThrow(new IllegalArgumentException("foo"));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdfMarkedContentExtractor.showAnnotation(annotation));
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PDAnnotation} {@link PDAnnotation#getRectangle()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given 'null'; when PDAnnotation getRectangle() return 'null'")
  void testShowAnnotation_givenNull_whenPDAnnotationGetRectangleReturnNull() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(null);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert that nothing has changed
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link PDAppearanceStream#PDAppearanceStream(COSStream)} with
   * stream is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given PDAppearanceStream(COSStream) with stream is COSStream()")
  void testShowAnnotation_givenPDAppearanceStreamWithStreamIsCOSStream() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert that nothing has changed
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given PDRectangle()")
  void testShowAnnotation_givenPDRectangle() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert that nothing has changed
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getHeight()} return
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given PDRectangle getHeight() return zero")
  void testShowAnnotation_givenPDRectangleGetHeightReturnZero() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(0.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert that nothing has changed
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getHeight()} throw
   * {@link IllegalArgumentException#IllegalArgumentException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given PDRectangle getHeight() throw IllegalArgumentException(String) with 'foo'")
  void testShowAnnotation_givenPDRectangleGetHeightThrowIllegalArgumentExceptionWithFoo() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenThrow(new IllegalArgumentException("foo"));
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdfMarkedContentExtractor.showAnnotation(annotation));
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Then calls {@link PDFormXObject#getBBox()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); then calls getBBox()")
  void testShowAnnotation_thenCallsGetBBox() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenThrow(new IllegalArgumentException("foo"));
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getBBox()).thenReturn(pdRectangle);
    PDRectangle pdRectangle2 = mock(PDRectangle.class);
    when(pdRectangle2.getHeight()).thenReturn(10.0f);
    when(pdRectangle2.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle2);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdfMarkedContentExtractor.showAnnotation(annotation));
    verify(pdRectangle2).getHeight();
    verify(pdRectangle).getHeight();
    verify(pdRectangle2).getWidth();
    verify(pdRectangle).getWidth();
    verify(pdAppearanceStream).getBBox();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); then throw IllegalStateException")
  void testShowAnnotation_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.transform(Mockito.<Matrix>any())).thenReturn(new GeneralPath(1));
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getMatrix()).thenReturn(new Matrix());
    when(pdAppearanceStream.getResources()).thenReturn(new PDResources());
    when(pdAppearanceStream.getBBox()).thenReturn(pdRectangle);
    PDRectangle pdRectangle2 = mock(PDRectangle.class);
    when(pdRectangle2.getLowerLeftX())
        .thenThrow(new IllegalStateException("Multiplying two matrices produces illegal values"));
    when(pdRectangle2.getHeight()).thenReturn(10.0f);
    when(pdRectangle2.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle2);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdfMarkedContentExtractor.showAnnotation(annotation));
    verify(pdRectangle2).getHeight();
    verify(pdRectangle).getHeight();
    verify(pdRectangle2).getLowerLeftX();
    verify(pdRectangle2).getWidth();
    verify(pdRectangle).getWidth();
    verify(pdRectangle).transform(isA(Matrix.class));
    verify(pdAppearanceStream).getBBox();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).getResources();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#getAppearance(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName("Test getAppearance(PDAnnotation); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetAppearance_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getAppearance(annotation));
  }

  /**
   * Test {@link PDFStreamEngine#getAppearance(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link PDAppearanceDictionary#PDAppearanceDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName("Test getAppearance(PDAnnotation); given PDAppearanceDictionary()")
  void testGetAppearance_givenPDAppearanceDictionary() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(new PDAppearanceDictionary());

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getAppearance(annotation));
  }

  /**
   * Test {@link PDFStreamEngine#getAppearance(PDAnnotation)}.
   * <ul>
   *   <li>Given
   * {@link PDAppearanceDictionary#PDAppearanceDictionary(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName("Test getAppearance(PDAnnotation); given PDAppearanceDictionary(COSDictionary) with dictionary is COSDictionary()")
  void testGetAppearance_givenPDAppearanceDictionaryWithDictionaryIsCOSDictionary() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(new PDAppearanceDictionary(new COSDictionary()));

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getAppearance(annotation));
  }

  /**
   * Test {@link PDFStreamEngine#getAppearance(PDAnnotation)}.
   * <ul>
   *   <li>Then return Stream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName("Test getAppearance(PDAnnotation); then return Stream DecodeParms is 'null'")
  void testGetAppearance_thenReturnStreamDecodeParmsIsNull() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act
    PDAppearanceStream actualAppearance = pdfMarkedContentExtractor.getAppearance(annotation);

    // Assert
    PDStream stream2 = actualAppearance.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = actualAppearance.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(actualAppearance.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(actualAppearance.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(actualAppearance.getOptionalContent());
    assertNull(actualAppearance.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, actualAppearance.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = actualAppearance.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, actualAppearance.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, actualAppearance.getCOSObject());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#getAppearance(PDAnnotation)}.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName("Test getAppearance(PDAnnotation); when PDAnnotationCaret(); then return 'null'")
  void testGetAppearance_whenPDAnnotationCaret_thenReturnNull() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getAppearance(new PDAnnotationCaret()));
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  void testProcessChildStream() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    Rectangle bounds = pdfMarkedContentExtractor.getGraphicsState().getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds();
    Rectangle2D bounds2D = bounds2.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    Rectangle bounds3 = frame.getBounds();
    Rectangle2D bounds2D2 = bounds3.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds3.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Point location = bounds3.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    Point location2 = ((Rectangle) bounds2D).getLocation();
    assertEquals(0.0d, location2.getX());
    assertEquals(0.0d, location2.getY());
    Rectangle bounds4 = bounds2D.getBounds();
    assertEquals(0.0d, bounds4.getX());
    assertEquals(0.0d, bounds3.getX());
    assertEquals(0.0d, bounds4.getY());
    assertEquals(0.0d, bounds3.getY());
    assertEquals(0.0d, bounds3.getMinX());
    assertEquals(0.0d, bounds3.getMinY());
    assertEquals(306.0d, bounds3.getCenterX());
    assertEquals(396.0d, bounds3.getCenterY());
    Dimension size = bounds4.getSize();
    assertEquals(612, size.width);
    Dimension size2 = bounds3.getSize();
    assertEquals(612, size2.width);
    Dimension size3 = ((Rectangle) bounds2D).getSize();
    assertEquals(612.0d, size3.getWidth());
    assertEquals(612.0d, bounds4.getWidth());
    assertEquals(612.0d, bounds3.getWidth());
    assertEquals(612.0d, bounds3.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792, size2.height);
    assertEquals(792.0d, size3.getHeight());
    assertEquals(792.0d, bounds3.getHeight());
    assertEquals(792.0d, bounds3.getMaxY());
    assertFalse(bounds4.isEmpty());
    assertEquals(bounds, bounds3.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame2);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  void testProcessChildStream2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage(new COSDictionary());

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    PDGraphicsState graphicsState = pdfMarkedContentExtractor.getGraphicsState();
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
    assertNull(pdfMarkedContentExtractor.getTextLineMatrix());
    assertNull(pdfMarkedContentExtractor.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
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
    assertEquals(1, getResult.getWindingRule());
    assertEquals(1, pdfMarkedContentExtractor.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
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
    assertEquals(location, location.getLocation());
    assertEquals(location, currentPoint);
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  void testProcessChildStream3() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDPage contentStream = new PDPage();
    contentStream.setContents(new PDStream(new COSDocument()));

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    Rectangle2D bounds2D = pdfMarkedContentExtractor.getGraphicsState()
        .getCurrentClippingPath()
        .getBounds()
        .getBounds()
        .getBounds()
        .getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  void testProcessChildStream4() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDPage contentStream = new PDPage();
    contentStream.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    Rectangle bounds = pdfMarkedContentExtractor.getGraphicsState().getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds().getBounds();
    Rectangle2D bounds2D = bounds2.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds2D.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D frame = bounds2D.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle bounds3 = bounds2.getBounds();
    Point location = bounds3.getLocation();
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    Rectangle bounds4 = bounds3.getBounds();
    assertEquals(0.0d, bounds4.getX());
    assertEquals(0.0d, bounds4.getY());
    assertEquals(0.0d, bounds4.getMinX());
    assertEquals(0.0d, bounds4.getMinY());
    assertEquals(306.0d, bounds2D.getCenterX());
    assertEquals(396.0d, bounds2D.getCenterY());
    Dimension size = bounds4.getSize();
    assertEquals(612, size.width);
    Dimension size2 = bounds3.getSize();
    assertEquals(612.0d, size2.getWidth());
    assertEquals(612.0d, bounds4.getWidth());
    assertEquals(792, size.height);
    assertEquals(792.0d, size2.getHeight());
    assertEquals(792.0d, bounds4.getMaxY());
    assertFalse(bounds4.isEmpty());
    assertEquals(bounds, bounds2D.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  void testProcessChildStream5() throws IOException {
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
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    COSBase cOSObject = graphicsState.getLineDashPattern().getCOSObject();
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
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  void testProcessChildStream6() throws IOException {
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
    Rectangle bounds = pdfMarkedContentExtractor.getGraphicsState().getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds2.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle bounds4 = bounds2D2.getBounds();
    Rectangle2D bounds2D3 = bounds4.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D frame = bounds3.getFrame();
    Rectangle2D bounds2D4 = frame.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds4.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = frame.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Point location = ((Rectangle) bounds2D).getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    Point location2 = bounds3.getLocation().getLocation();
    assertEquals(0.0d, location2.getX());
    assertEquals(0.0d, location2.getY());
    assertEquals(0.0d, bounds2D.getMinX());
    assertEquals(0.0d, frame.getMinX());
    assertEquals(0.0d, bounds2D.getMinY());
    assertEquals(0.0d, frame.getMinY());
    assertEquals(0.0d, bounds2D.getX());
    assertEquals(0.0d, frame.getX());
    assertEquals(0.0d, bounds2D.getY());
    assertEquals(0.0d, frame.getY());
    assertEquals(306.0d, bounds4.getCenterX());
    assertEquals(306.0d, frame.getCenterX());
    assertEquals(396.0d, bounds4.getCenterY());
    assertEquals(396.0d, frame.getCenterY());
    Dimension size = ((Rectangle) bounds2D).getSize();
    assertEquals(612, size.width);
    Dimension size2 = bounds3.getSize().getSize();
    assertEquals(612.0d, size2.getWidth());
    assertEquals(612.0d, bounds2D.getMaxX());
    assertEquals(612.0d, frame.getMaxX());
    assertEquals(612.0d, bounds2D.getWidth());
    assertEquals(612.0d, frame.getWidth());
    assertEquals(792, size.height);
    assertEquals(792.0d, size2.getHeight());
    assertEquals(792.0d, bounds2D.getHeight());
    assertEquals(792.0d, frame.getHeight());
    assertEquals(792.0d, bounds2D.getMaxY());
    assertEquals(792.0d, frame.getMaxY());
    assertFalse(bounds2D.isEmpty());
    assertFalse(frame.isEmpty());
    assertEquals(bounds, bounds4.getBounds());
    assertEquals(bounds, frame.getBounds());
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, bounds2D4);
    assertEquals(bounds, frame2);
    assertEquals(bounds, frame3);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.</li>
   *   <li>When {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage); given A0; when PDPage() CropBox is A0")
  void testProcessChildStream_givenA0_whenPDPageCropBoxIsA0() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDPage contentStream = new PDPage();
    contentStream.setCropBox(PDRectangle.A0);

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    Rectangle bounds = pdfMarkedContentExtractor.getGraphicsState().getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds().getBounds();
    Rectangle2D bounds2D = bounds2.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds2D.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D frame = bounds2D.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle bounds3 = bounds2.getBounds();
    Point location = bounds3.getLocation();
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    Rectangle bounds4 = bounds3.getBounds();
    assertEquals(0.0d, bounds4.getX());
    assertEquals(0.0d, bounds4.getY());
    assertEquals(0.0d, bounds4.getMinX());
    assertEquals(0.0d, bounds4.getMinY());
    assertEquals(306.0d, bounds2D.getCenterX());
    assertEquals(396.0d, bounds2D.getCenterY());
    Dimension size = bounds4.getSize();
    assertEquals(612, size.width);
    Dimension size2 = bounds3.getSize();
    assertEquals(612.0d, size2.getWidth());
    assertEquals(612.0d, bounds4.getWidth());
    assertEquals(792, size.height);
    assertEquals(792.0d, size2.getHeight());
    assertEquals(792.0d, bounds4.getMaxY());
    assertFalse(bounds4.isEmpty());
    assertEquals(bounds, bounds2D.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage); given ArrayList() add 'null'")
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
    Rectangle2D bounds2D = pdfMarkedContentExtractor.getGraphicsState()
        .getCurrentClippingPath()
        .getBounds()
        .getBounds()
        .getBounds()
        .getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link PDPage#PDPage()} Contents is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage); given ArrayList(); when PDPage() Contents is ArrayList()")
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
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds();
    Rectangle2D bounds2D = bounds2.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    Rectangle bounds3 = frame.getBounds();
    Rectangle2D bounds2D2 = bounds3.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds3.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    COSBase cOSObject = graphicsState.getLineDashPattern().getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    Point location = bounds3.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    Point location2 = ((Rectangle) bounds2D).getLocation();
    assertEquals(0.0d, location2.getX());
    assertEquals(0.0d, location2.getY());
    Rectangle bounds4 = bounds2D.getBounds();
    assertEquals(0.0d, bounds4.getX());
    assertEquals(0.0d, bounds3.getX());
    assertEquals(0.0d, bounds4.getY());
    assertEquals(0.0d, bounds3.getY());
    assertEquals(0.0d, bounds3.getMinX());
    assertEquals(0.0d, bounds3.getMinY());
    assertEquals(306.0d, bounds3.getCenterX());
    assertEquals(396.0d, bounds3.getCenterY());
    Dimension size = bounds4.getSize();
    assertEquals(612, size.width);
    Dimension size2 = bounds3.getSize();
    assertEquals(612, size2.width);
    Dimension size3 = ((Rectangle) bounds2D).getSize();
    assertEquals(612.0d, size3.getWidth());
    assertEquals(612.0d, bounds4.getWidth());
    assertEquals(612.0d, bounds3.getWidth());
    assertEquals(612.0d, bounds3.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792, size2.height);
    assertEquals(792.0d, size3.getHeight());
    assertEquals(792.0d, bounds3.getHeight());
    assertEquals(792.0d, bounds3.getMaxY());
    assertFalse(bounds4.isEmpty());
    assertEquals(contents, ((COSArray) getResult).toList());
    assertEquals(bounds, bounds3.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame2);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage); when 'null'; then throw IllegalArgumentException")
  void testProcessChildStream_whenNull_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdfMarkedContentExtractor.processChildStream(new PDPage(), null));
  }

  /**
   * Test {@link PDFStreamEngine#showTextStrings(COSArray)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link COSArray#add(COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  @DisplayName("Test showTextStrings(COSArray); given ArrayList() iterator; then calls add(COSObjectable)")
  void testShowTextStrings_givenArrayListIterator_thenCallsAdd() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    COSArray array = mock(COSArray.class);

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    when(array.iterator()).thenReturn(cosBaseList.iterator());
    doNothing().when(array).add(Mockito.<COSObjectable>any());
    array.add(mock(COSObjectable.class));

    // Act
    pdfMarkedContentExtractor.showTextStrings(array);

    // Assert that nothing has changed
    verify(array).add(isA(COSObjectable.class));
    verify(array).iterator();
  }

  /**
   * Test
   * {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}
   */
  @Test
  @DisplayName("Test showType3Glyph(Matrix, PDType3Font, int, Vector); then throw IllegalStateException")
  void testShowType3Glyph_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    Matrix textRenderingMatrix = new Matrix();
    PDType3Font font = mock(PDType3Font.class);
    PDType3Font font2 = new PDType3Font(new COSDictionary());
    when(font.getCharProc(anyInt())).thenReturn(new PDType3CharProc(font2, new COSStream()));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdfMarkedContentExtractor.showType3Glyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f)));
    verify(font).getCharProc(eq(1));
  }

  /**
   * Test
   * {@link PDFStreamEngine#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary)")
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
   * Test
   * {@link PDFStreamEngine#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDFStreamEngine#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary)")
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
   * Test {@link PDFStreamEngine#saveGraphicsState()}.
   * <ul>
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()}
   * GraphicsStackSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#saveGraphicsState()}
   */
  @Test
  @DisplayName("Test saveGraphicsState(); then PDFMarkedContentExtractor() GraphicsStackSize is two")
  void testSaveGraphicsState_thenPDFMarkedContentExtractorGraphicsStackSizeIsTwo() throws IOException {
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
   * <ul>
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()}
   * GraphicsState is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#restoreGraphicsState()}
   */
  @Test
  @DisplayName("Test restoreGraphicsState(); then PDFMarkedContentExtractor() GraphicsState is 'null'")
  void testRestoreGraphicsState_thenPDFMarkedContentExtractorGraphicsStateIsNull() throws IOException {
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
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#saveGraphicsStack()}
   */
  @Test
  @DisplayName("Test saveGraphicsStack(); then return size is one")
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
   * <p>
   * Method under test: {@link PDFStreamEngine#getGraphicsStackSize()}
   */
  @Test
  @DisplayName("Test getGraphicsStackSize()")
  void testGetGraphicsStackSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFMarkedContentExtractor()).getGraphicsStackSize());
  }

  /**
   * Test {@link PDFStreamEngine#getGraphicsState()}.
   * <p>
   * Method under test: {@link PDFStreamEngine#getGraphicsState()}
   */
  @Test
  @DisplayName("Test getGraphicsState()")
  void testGetGraphicsState() {
    // Arrange, Act and Assert
    assertNull((new PDFMarkedContentExtractor()).getGraphicsState());
  }

  /**
   * Test {@link PDFStreamEngine#getTextLineMatrix()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#getTextLineMatrix()}
   */
  @Test
  @DisplayName("Test getTextLineMatrix(); then return 'null'")
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
   * <ul>
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()}
   * TextLineMatrix is {@link Matrix#Matrix()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#setTextLineMatrix(Matrix)}
   */
  @Test
  @DisplayName("Test setTextLineMatrix(Matrix); then PDFMarkedContentExtractor() TextLineMatrix is Matrix()")
  void testSetTextLineMatrix_thenPDFMarkedContentExtractorTextLineMatrixIsMatrix() throws IOException {
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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#getTextMatrix()}
   */
  @Test
  @DisplayName("Test getTextMatrix(); then return 'null'")
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
   * <ul>
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()}
   * TextMatrix is {@link Matrix#Matrix()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#setTextMatrix(Matrix)}
   */
  @Test
  @DisplayName("Test setTextMatrix(Matrix); then PDFMarkedContentExtractor() TextMatrix is Matrix()")
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
   * <p>
   * Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray, int)")
  void testSetLineDashPattern() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act
    pdfMarkedContentExtractor.setLineDashPattern(new COSArray(), 1);

    // Assert
    assertEquals(1, pdfMarkedContentExtractor.getGraphicsState().getLineDashPattern().getPhase());
  }

  /**
   * Test {@link PDFStreamEngine#getResources()}.
   * <p>
   * Method under test: {@link PDFStreamEngine#getResources()}
   */
  @Test
  @DisplayName("Test getResources()")
  void testGetResources() {
    // Arrange, Act and Assert
    assertNull((new PDFMarkedContentExtractor()).getResources());
  }

  /**
   * Test {@link PDFStreamEngine#getCurrentPage()}.
   * <p>
   * Method under test: {@link PDFStreamEngine#getCurrentPage()}
   */
  @Test
  @DisplayName("Test getCurrentPage()")
  void testGetCurrentPage() {
    // Arrange, Act and Assert
    assertNull((new PDFMarkedContentExtractor()).getCurrentPage());
  }

  /**
   * Test {@link PDFStreamEngine#getInitialMatrix()}.
   * <p>
   * Method under test: {@link PDFStreamEngine#getInitialMatrix()}
   */
  @Test
  @DisplayName("Test getInitialMatrix()")
  void testGetInitialMatrix() {
    // Arrange, Act and Assert
    assertNull((new PDFMarkedContentExtractor()).getInitialMatrix());
  }

  /**
   * Test {@link PDFStreamEngine#transformedPoint(float, float)}.
   * <ul>
   *   <li>Then return X is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#transformedPoint(float, float)}
   */
  @Test
  @DisplayName("Test transformedPoint(float, float); then return X is ten")
  void testTransformedPoint_thenReturnXIsTen() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act
    Point2D.Float actualTransformedPointResult = pdfMarkedContentExtractor.transformedPoint(10.0f, 10.0f);

    // Assert
    assertEquals(10.0d, actualTransformedPointResult.getX());
    assertEquals(10.0d, actualTransformedPointResult.getY());
    assertEquals(10.0f, actualTransformedPointResult.x);
    assertEquals(10.0f, actualTransformedPointResult.y);
  }

  /**
   * Test {@link PDFStreamEngine#transformWidth(float)}.
   * <ul>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#transformWidth(float)}
   */
  @Test
  @DisplayName("Test transformWidth(float); then return ten")
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
   * <p>
   * Method under test: {@link PDFStreamEngine#getLevel()}
   */
  @Test
  @DisplayName("Test getLevel()")
  void testGetLevel() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFMarkedContentExtractor()).getLevel());
  }

  /**
   * Test {@link PDFStreamEngine#increaseLevel()}.
   * <p>
   * Method under test: {@link PDFStreamEngine#increaseLevel()}
   */
  @Test
  @DisplayName("Test increaseLevel()")
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
   * <p>
   * Method under test: {@link PDFStreamEngine#decreaseLevel()}
   */
  @Test
  @DisplayName("Test decreaseLevel()")
  void testDecreaseLevel() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act
    pdfMarkedContentExtractor.decreaseLevel();

    // Assert
    assertEquals(-1, pdfMarkedContentExtractor.getLevel());
  }
}
