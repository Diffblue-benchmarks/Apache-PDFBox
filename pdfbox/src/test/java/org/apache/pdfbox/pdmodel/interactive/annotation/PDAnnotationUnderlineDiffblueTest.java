package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCaretAppearanceHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationUnderlineDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationUnderline#constructAppearances()}
   */
  @Test
  void testConstructAppearances() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline();
    pdAnnotationUnderline.setRectangle(rectangle);

    // Act
    pdAnnotationUnderline.constructAppearances();

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationUnderline#constructAppearances()}
   */
  @Test
  void testConstructAppearances2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline(dict);
    pdAnnotationUnderline.setRectangle(rectangle);

    // Act
    pdAnnotationUnderline.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationUnderline#constructAppearances()}
   */
  @Test
  void testConstructAppearances3() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline(dict);
    pdAnnotationUnderline.setRectangle(rectangle);

    // Act
    pdAnnotationUnderline.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationUnderline#constructAppearances()}
   */
  @Test
  void testConstructAppearances4() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline();
    pdAnnotationUnderline.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationUnderline.constructAppearances();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Method under test: {@link PDAnnotationUnderline#constructAppearances()}
   */
  @Test
  void testConstructAppearances5() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    COSArray array = new COSArray();
    when(annotation.getColor()).thenReturn(new PDColor(array, new PDCalGray()));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline();
    pdAnnotationUnderline.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationUnderline.constructAppearances();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Method under test: {@link PDAnnotationUnderline#constructAppearances()}
   */
  @Test
  void testConstructAppearances6() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(null);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline();
    pdAnnotationUnderline.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationUnderline.constructAppearances();

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Method under test: {@link PDAnnotationUnderline#constructAppearances()}
   */
  @Test
  void testConstructAppearances7() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline();
    pdAnnotationUnderline.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationUnderline.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray, atLeast(1)).isDirect();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Method under test: {@link PDAnnotationUnderline#constructAppearances()}
   */
  @Test
  void testConstructAppearances8() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline();
    pdAnnotationUnderline.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationUnderline.constructAppearances();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Method under test: {@link PDAnnotationUnderline#constructAppearances()}
   */
  @Test
  void testConstructAppearances9() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline();
    pdAnnotationUnderline.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationUnderline.constructAppearances();

    // Assert that nothing has changed
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Method under test:
   * {@link PDAnnotationUnderline#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances10() throws IOException {
    // Arrange
    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationUnderline.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDAnnotationUnderline#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances11() throws IOException {
    // Arrange
    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline();
    pdAnnotationUnderline.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationUnderline.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDAnnotationUnderline#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances12() throws IOException {
    // Arrange
    PDAnnotationUnderline pdAnnotationUnderline = new PDAnnotationUnderline(new COSDictionary());
    pdAnnotationUnderline.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationUnderline.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
