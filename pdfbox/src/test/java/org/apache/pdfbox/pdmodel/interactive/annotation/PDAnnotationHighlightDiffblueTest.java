package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationHighlightDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationHighlight#constructAppearances()}
   */
  @Test
  void testConstructAppearances() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act
    (new PDAnnotationHighlight(dict)).constructAppearances();

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Method under test: {@link PDAnnotationHighlight#constructAppearances()}
   */
  @Test
  void testConstructAppearances2() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act
    (new PDAnnotationHighlight(dict)).constructAppearances();

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Method under test: {@link PDAnnotationHighlight#constructAppearances()}
   */
  @Test
  void testConstructAppearances3() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act
    (new PDAnnotationHighlight(dict)).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosArray).toFloatArray();
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link PDAnnotationHighlight#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances4() throws IOException {
    // Arrange
    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationHighlight.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
