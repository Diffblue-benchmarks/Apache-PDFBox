package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JBIG2FilterDiffblueTest {
  /**
   * Test
   * {@link JBIG2Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link JBIG2Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex() throws IOException {
    // Arrange
    JBIG2Filter jbig2Filter = new JBIG2Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenThrow(new UnsupportedOperationException("JBIG2"));
    when(cosArray.size()).thenReturn(3);
    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(parameters.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosArray);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> jbig2Filter.decode(encoded, decoded, parameters, 1));
    verify(cosArray).getObject(eq(1));
    verify(cosArray).size();
    verify(parameters, atLeast(1)).getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any());
    verify(parameters).getInt(isA(COSName.class), eq(1));
  }

  /**
   * Test
   * {@link JBIG2Filter#decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index},
   * {@code options}.
   * <p>
   * Method under test:
   * {@link JBIG2Filter#decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions) with 'encoded', 'decoded', 'parameters', 'index', 'options'")
  void testDecodeWithEncodedDecodedParametersIndexOptions() throws IOException {
    // Arrange
    JBIG2Filter jbig2Filter = new JBIG2Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenThrow(new UnsupportedOperationException("JBIG2"));
    when(cosArray.size()).thenReturn(3);
    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(parameters.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosArray);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> jbig2Filter.decode(encoded, decoded, parameters, 1, DecodeOptions.DEFAULT));
    verify(cosArray).getObject(eq(1));
    verify(cosArray).size();
    verify(parameters, atLeast(1)).getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any());
    verify(parameters).getInt(isA(COSName.class), eq(1));
  }

  /**
   * Test {@link JBIG2Filter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test:
   * {@link JBIG2Filter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    JBIG2Filter jbig2Filter = new JBIG2Filter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> jbig2Filter.encode(input, encoded, new COSDictionary()));
  }
}
