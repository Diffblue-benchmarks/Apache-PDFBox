package org.apache.pdfbox.contentstream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
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
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDTransparencyGroup;
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
   * Test {@link PDFStreamEngine#showTransparencyGroup(PDTransparencyGroup)}.
   * <p>
   * Method under test: {@link PDFStreamEngine#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test showTransparencyGroup(PDTransparencyGroup)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showTransparencyGroup(PDTransparencyGroup)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showForm(PDFormXObject)"})
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
   * Method under test: {@link PDFStreamEngine#processTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  @DisplayName("Test processTransparencyGroup(PDTransparencyGroup)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processTransparencyGroup(PDTransparencyGroup)"})
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
   * Method under test: {@link PDFStreamEngine#processType3Stream(PDType3CharProc, Matrix)}
   */
  @Test
  @DisplayName("Test processType3Stream(PDType3CharProc, Matrix)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processType3Stream(PDType3CharProc, Matrix)"})
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
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <p>
   * Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
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
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.</li>
   *   <li>When {@link PDAnnotation} {@link PDAnnotation#getRectangle()} return {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); given A0; when PDAnnotation getRectangle() return A0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenA0_whenPDAnnotationGetRectangleReturnA0() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(new COSStream()));

    // Assert
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#toFloatArray()} return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray toFloatArray() return array of float with ten and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
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
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link COSStream} {@link COSDictionary#getCOSArray(COSName)} return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); given COSArray(); when COSStream getCOSArray(COSName) return COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
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
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); given PDRectangle()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
  void testProcessAnnotation_givenPDRectangle() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act
    pdfMarkedContentExtractor.processAnnotation(annotation, new PDAppearanceStream(new COSStream()));

    // Assert
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getHeight()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); given PDRectangle getHeight() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
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

    // Assert
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
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
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
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
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
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
   * Test {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}.
   * <ul>
   *   <li>When {@link PDAppearanceStream#PDAppearanceStream(COSStream)} with stream is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test processAnnotation(PDAnnotation, PDAppearanceStream); when PDAppearanceStream(COSStream) with stream is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processAnnotation(PDAnnotation, PDAppearanceStream)"})
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

    // Assert
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
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
   *   <li>When {@link PDAnnotation} {@link PDAnnotation#getRectangle()} return {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given A0; when PDAnnotation getRectangle() return A0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenA0_whenPDAnnotationGetRectangleReturnA0() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#toFloatArray()} return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given COSArray toFloatArray() return array of float with ten and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
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
   *   <li>Given {@link COSStream} {@link COSDictionary#getCOSArray(COSName)} return {@link COSArray#COSArray()}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given COSStream getCOSArray(COSName) return COSArray(); then calls getCOSArray(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
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
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
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
   *   <li>When {@link PDAnnotation} {@link PDAnnotation#getRectangle()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given 'null'; when PDAnnotation getRectangle() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenNull_whenPDAnnotationGetRectangleReturnNull() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(null);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link PDAppearanceStream#PDAppearanceStream(COSStream)} with stream is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given PDAppearanceStream(COSStream) with stream is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
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

    // Assert
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
  void testShowAnnotation_givenPDRectangle() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));

    // Act
    pdfMarkedContentExtractor.showAnnotation(annotation);

    // Assert
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getHeight()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given PDRectangle getHeight() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
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

    // Assert
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getWidth();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation).getRectangle();
  }

  /**
   * Test {@link PDFStreamEngine#showAnnotation(PDAnnotation)}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getHeight()} throw {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  @DisplayName("Test showAnnotation(PDAnnotation); given PDRectangle getHeight() throw IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showAnnotation(PDAnnotation)"})
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
   *   <li>Given {@link PDAppearanceDictionary#PDAppearanceDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName("Test getAppearance(PDAnnotation); given PDAppearanceDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName("Test getAppearance(PDAnnotation); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#getAppearance(PDAnnotation)}.
   * <ul>
   *   <li>Then return COSObject Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  @DisplayName("Test getAppearance(PDAnnotation); then return COSObject Key is 'null'")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceStream PDFStreamEngine.getAppearance(PDAnnotation)"})
  void testGetAppearance_whenPDAnnotationCaret_thenReturnNull() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getAppearance(new PDAnnotationCaret()));
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <p>
   * Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new float[]{}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <p>
   * Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  @Tag("MaintainedByDiffblue")
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
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertArrayEquals(new float[]{}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <p>
   * Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
  void testProcessChildStream3() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDPage contentStream = new PDPage();
    contentStream.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Assert
    assertNull(pdfMarkedContentExtractor.getTextLineMatrix());
    assertNull(pdfMarkedContentExtractor.getTextMatrix());
    assertEquals(1, pdfMarkedContentExtractor.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <p>
   * Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  @Tag("MaintainedByDiffblue")
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
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
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
    assertArrayEquals(new float[]{}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <p>
   * Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage)")
  @Tag("MaintainedByDiffblue")
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
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getFrame() instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertArrayEquals(new float[]{}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.</li>
   *   <li>When {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage); given A0; when PDPage() CropBox is A0")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage); given ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
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
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertArrayEquals(new float[]{}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage); given ArrayList(); when PDPage() Contents is ArrayList()")
  @Tag("MaintainedByDiffblue")
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
    assertTrue(graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getFrame() instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(contents, ((COSArray) getResult).toList());
    assertArrayEquals(new float[]{}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  @DisplayName("Test processChildStream(PDContentStream, PDPage); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.processChildStream(PDContentStream, PDPage)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showTextStrings(COSArray)"})
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

    // Assert
    verify(array).add(isA(COSObjectable.class));
    verify(array).iterator();
  }

  /**
   * Test {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}
   */
  @Test
  @DisplayName("Test showType3Glyph(Matrix, PDType3Font, int, Vector); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.showType3Glyph(Matrix, PDType3Font, int, Vector)"})
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
   * Test {@link PDFStreamEngine#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <p>
   * Method under test: {@link PDFStreamEngine#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDFStreamEngine#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary)")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link PDFStreamEngine#saveGraphicsState()}.
   * <ul>
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()} GraphicsStackSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#saveGraphicsState()}
   */
  @Test
  @DisplayName("Test saveGraphicsState(); then PDFMarkedContentExtractor() GraphicsStackSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.saveGraphicsState()"})
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
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()} GraphicsState is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#restoreGraphicsState()}
   */
  @Test
  @DisplayName("Test restoreGraphicsState(); then PDFMarkedContentExtractor() GraphicsState is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.restoreGraphicsState()"})
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
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDFStreamEngine#getGraphicsStackSize()}
   */
  @Test
  @DisplayName("Test getGraphicsStackSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDFStreamEngine.getGraphicsStackSize()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGraphicsState PDFStreamEngine.getGraphicsState()"})
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
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()} TextLineMatrix is {@link Matrix#Matrix()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#setTextLineMatrix(Matrix)}
   */
  @Test
  @DisplayName("Test setTextLineMatrix(Matrix); then PDFMarkedContentExtractor() TextLineMatrix is Matrix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.setTextLineMatrix(Matrix)"})
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
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()} TextMatrix is {@link Matrix#Matrix()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#setTextMatrix(Matrix)}
   */
  @Test
  @DisplayName("Test setTextMatrix(Matrix); then PDFMarkedContentExtractor() TextMatrix is Matrix()")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFStreamEngine.setLineDashPattern(COSArray, int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDResources PDFStreamEngine.getResources()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPage PDFStreamEngine.getCurrentPage()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Matrix PDFStreamEngine.getInitialMatrix()"})
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
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamEngine#transformWidth(float)}
   */
  @Test
  @DisplayName("Test transformWidth(float); then return ten")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDFStreamEngine#getLevel()}
   */
  @Test
  @DisplayName("Test getLevel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDFStreamEngine.getLevel()"})
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
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDFStreamEngine#decreaseLevel()}
   */
  @Test
  @DisplayName("Test decreaseLevel()")
  @Tag("MaintainedByDiffblue")
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
