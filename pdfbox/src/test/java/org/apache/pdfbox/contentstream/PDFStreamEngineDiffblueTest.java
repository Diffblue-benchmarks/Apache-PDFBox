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
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFStreamEngineDiffblueTest {
  /**
   * Method under test:
   * {@link PDFStreamEngine#showTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  void testShowTransparencyGroup() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdfMarkedContentExtractor.showTransparencyGroup(new PDTransparencyGroup(new PDDocument())));
  }

  /**
   * Method under test: {@link PDFStreamEngine#showForm(PDFormXObject)}
   */
  @Test
  void testShowForm() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdfMarkedContentExtractor.showForm(new PDFormXObject(new COSStream())));
  }

  /**
   * Method under test:
   * {@link PDFStreamEngine#processTransparencyGroup(PDTransparencyGroup)}
   */
  @Test
  void testProcessTransparencyGroup() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdfMarkedContentExtractor.processTransparencyGroup(new PDTransparencyGroup(new PDDocument())));
  }

  /**
   * Method under test:
   * {@link PDFStreamEngine#processType3Stream(PDType3CharProc, Matrix)}
   */
  @Test
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
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  void testProcessAnnotation() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  void testProcessAnnotation2() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  void testProcessAnnotation3() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  void testProcessAnnotation4() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  void testProcessAnnotation5() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  void testProcessAnnotation6() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  void testProcessAnnotation7() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  void testProcessAnnotation8() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  void testProcessAnnotation9() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processAnnotation(PDAnnotation, PDAppearanceStream)}
   */
  @Test
  void testProcessAnnotation10() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   */
  @Test
  void testProcessTilingPattern() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   */
  @Test
  void testProcessTilingPattern2() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   */
  @Test
  void testProcessTilingPattern3() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   */
  @Test
  void testProcessTilingPattern4() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace)}
   */
  @Test
  void testProcessTilingPattern5() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    PDTilingPattern tilingPattern = mock(PDTilingPattern.class);
    when(tilingPattern.getContentsForStreamParsing()).thenReturn(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 2, 'A', 'X', 'A', 'X', 'A', 'X'})));
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
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   */
  @Test
  void testProcessTilingPattern6() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   */
  @Test
  void testProcessTilingPattern7() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   */
  @Test
  void testProcessTilingPattern8() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#processTilingPattern(PDTilingPattern, PDColor, PDColorSpace, Matrix)}
   */
  @Test
  void testProcessTilingPattern9() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation2() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation3() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation4() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation5() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation6() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation7() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation8() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation9() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation10() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation11() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#showAnnotation(PDAnnotation)}
   */
  @Test
  void testShowAnnotation12() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  void testGetAppearance() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getAppearance(new PDAnnotationCaret()));
  }

  /**
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  void testGetAppearance2() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(new PDAppearanceDictionary());

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getAppearance(annotation));
  }

  /**
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  void testGetAppearance3() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#getAppearance(PDAnnotation)}
   */
  @Test
  void testGetAppearance4() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));
    PDAppearanceStream ap = new PDAppearanceStream(stream);

    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(ap);

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
   * Method under test:
   * {@link PDFStreamEngine#processChildStream(PDContentStream, PDPage)}
   */
  @Test
  void testProcessChildStream() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdfMarkedContentExtractor.processChildStream(new PDPage(), null));
  }

  /**
   * Method under test: {@link PDFStreamEngine#showTextStrings(COSArray)}
   */
  @Test
  void testShowTextStrings() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    pdfMarkedContentExtractor.showTextStrings(array);

    // Assert
    verify(object).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDFStreamEngine#showFontGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  void testShowFontGlyph() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    Matrix textRenderingMatrix = new Matrix();
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDMMType1Font font = new PDMMType1Font(fontDictionary);

    // Act
    pdfMarkedContentExtractor.showFontGlyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert that nothing has changed
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}
   */
  @Test
  void testShowType3Glyph() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    Matrix textRenderingMatrix = new Matrix();
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);

    // Act
    pdfMarkedContentExtractor.showType3Glyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert that nothing has changed
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}
   */
  @Test
  void testShowType3Glyph2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    Matrix textRenderingMatrix = new Matrix();
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);

    // Act
    pdfMarkedContentExtractor.showType3Glyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert
    verify(fontDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}
   */
  @Test
  void testShowType3Glyph3() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    Matrix textRenderingMatrix = new Matrix();
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSDictionary(new COSDictionary()));
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);

    // Act
    pdfMarkedContentExtractor.showType3Glyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f));

    // Assert
    verify(fontDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link PDFStreamEngine#showType3Glyph(Matrix, PDType3Font, int, Vector)}
   */
  @Test
  void testShowType3Glyph4() throws IOException {
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
   * Method under test:
   * {@link PDFStreamEngine#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
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
   * Method under test:
   * {@link PDFStreamEngine#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
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
   * Method under test: {@link PDFStreamEngine#processOperator(String, List)}
   */
  @Test
  void testProcessOperator() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(cosDocument);

    // Act
    pdfMarkedContentExtractor.processOperator("Do", arguments);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDFStreamEngine#processOperator(Operator, List)}
   */
  @Test
  void testProcessOperator2() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    Operator operator = Operator.getOperator("Operator");
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.addAll(new ArrayList<>());
    operands.add(cosDocument);

    // Act
    pdfMarkedContentExtractor.processOperator(operator, operands);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDFStreamEngine#unsupportedOperator(Operator, List)}
   */
  @Test
  void testUnsupportedOperator() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    Operator operator = Operator.getOperator("Operator");
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(cosDocument);

    // Act
    pdfMarkedContentExtractor.unsupportedOperator(operator, operands);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDFStreamEngine#saveGraphicsState()}
   */
  @Test
  void testSaveGraphicsState() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#restoreGraphicsState()}
   */
  @Test
  void testRestoreGraphicsState() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#saveGraphicsStack()}
   */
  @Test
  void testSaveGraphicsStack() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act and Assert
    assertEquals(1, pdfMarkedContentExtractor.saveGraphicsStack().size());
  }

  /**
   * Method under test: {@link PDFStreamEngine#restoreGraphicsStack(Deque)}
   */
  @Test
  void testRestoreGraphicsStack() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDRectangle page = mock(PDRectangle.class);
    when(page.toGeneralPath()).thenReturn(new GeneralPath(1));
    PDGraphicsState pdGraphicsState = new PDGraphicsState(page);

    LinkedList<PDGraphicsState> snapshot = new LinkedList<>();
    snapshot.add(pdGraphicsState);

    // Act
    pdfMarkedContentExtractor.restoreGraphicsStack(snapshot);

    // Assert
    verify(page).toGeneralPath();
  }

  /**
   * Method under test: {@link PDFStreamEngine#getGraphicsStackSize()}
   */
  @Test
  void testGetGraphicsStackSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFMarkedContentExtractor()).getGraphicsStackSize());
  }

  /**
   * Method under test: {@link PDFStreamEngine#getGraphicsState()}
   */
  @Test
  void testGetGraphicsState() {
    // Arrange, Act and Assert
    assertNull((new PDFMarkedContentExtractor()).getGraphicsState());
  }

  /**
   * Method under test: {@link PDFStreamEngine#getTextLineMatrix()}
   */
  @Test
  void testGetTextLineMatrix() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getTextLineMatrix());
  }

  /**
   * Method under test: {@link PDFStreamEngine#setTextLineMatrix(Matrix)}
   */
  @Test
  void testSetTextLineMatrix() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#getTextMatrix()}
   */
  @Test
  void testGetTextMatrix() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act and Assert
    assertNull(pdfMarkedContentExtractor.getTextMatrix());
  }

  /**
   * Method under test: {@link PDFStreamEngine#setTextMatrix(Matrix)}
   */
  @Test
  void testSetTextMatrix() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#setLineDashPattern(COSArray, int)}
   */
  @Test
  void testSetLineDashPattern() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    pdfMarkedContentExtractor.setLineDashPattern(array, 1);

    // Assert
    verify(object).getCOSObject();
    PDLineDashPattern lineDashPattern = pdfMarkedContentExtractor.getGraphicsState().getLineDashPattern();
    assertEquals(1, lineDashPattern.getPhase());
    assertArrayEquals(new float[]{0.0f, 0.0f}, lineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Method under test: {@link PDFStreamEngine#getResources()}
   */
  @Test
  void testGetResources() {
    // Arrange, Act and Assert
    assertNull((new PDFMarkedContentExtractor()).getResources());
  }

  /**
   * Method under test: {@link PDFStreamEngine#getCurrentPage()}
   */
  @Test
  void testGetCurrentPage() {
    // Arrange, Act and Assert
    assertNull((new PDFMarkedContentExtractor()).getCurrentPage());
  }

  /**
   * Method under test: {@link PDFStreamEngine#getInitialMatrix()}
   */
  @Test
  void testGetInitialMatrix() {
    // Arrange, Act and Assert
    assertNull((new PDFMarkedContentExtractor()).getInitialMatrix());
  }

  /**
   * Method under test: {@link PDFStreamEngine#transformedPoint(float, float)}
   */
  @Test
  void testTransformedPoint() throws IOException {
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
   * Method under test: {@link PDFStreamEngine#transformWidth(float)}
   */
  @Test
  void testTransformWidth() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    PDPage contentStream = new PDPage();
    pdfMarkedContentExtractor.processChildStream(contentStream, new PDPage());

    // Act and Assert
    assertEquals(10.0f, pdfMarkedContentExtractor.transformWidth(10.0f));
  }

  /**
   * Method under test: {@link PDFStreamEngine#getLevel()}
   */
  @Test
  void testGetLevel() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFMarkedContentExtractor()).getLevel());
  }

  /**
   * Method under test: {@link PDFStreamEngine#increaseLevel()}
   */
  @Test
  void testIncreaseLevel() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act
    pdfMarkedContentExtractor.increaseLevel();

    // Assert
    assertEquals(1, pdfMarkedContentExtractor.getLevel());
  }

  /**
   * Method under test: {@link PDFStreamEngine#decreaseLevel()}
   */
  @Test
  void testDecreaseLevel() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act
    pdfMarkedContentExtractor.decreaseLevel();

    // Assert
    assertEquals(-1, pdfMarkedContentExtractor.getLevel());
  }
}
