package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CCITTFaxFilterDiffblueTest {
  /**
   * Test
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex2() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{-64, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex3() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex4() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{'A', 'X', 0, 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex5() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 0, 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex6() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{'A', 'X', 0, 'X', 'A', 'X', 0, 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>Then return Parameters is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then return Parameters is COSStream()")
  void testDecodeWithEncodedDecodedParametersIndex_thenReturnParametersIsCOSStream() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSStream parameters = new COSStream();

    // Act and Assert
    assertSame(parameters, ccittFaxFilter.decode(encoded, decoded, parameters, 1).getParameters());
  }

  /**
   * Test
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then throw IOException")
  void testDecodeWithEncodedDecodedParametersIndex_thenThrowIOException() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ccittFaxFilter.decode(encoded, decoded, new COSDictionary(), 1));
  }

  /**
   * Test
   * {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  void testReadFromDecoderStream() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream decoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, false);

    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    verify(stream, atLeast(1)).read();
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test
   * {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  void testReadFromDecoderStream2() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream decoderStream = new CCITTFaxDecoderStream(stream, 2, 2, 1L, true);

    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    verify(stream, atLeast(1)).read();
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test
   * {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array
   * of {@code byte} with one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[]); when ByteArrayInputStream(byte[]) with array of byte with one and 'X'")
  void testReadFromDecoderStream_whenByteArrayInputStreamWithArrayOfByteWithOneAndX() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream = new CCITTFaxDecoderStream(
        new ByteArrayInputStream(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}), 1, 2, 1L, true);

    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test
   * {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[]); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testReadFromDecoderStream_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream = new CCITTFaxDecoderStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true);

    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(1);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(0, encoded.toByteArray().length);
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  void testEncodeWithInputEncodedParameters2() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(7);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    assertArrayEquals(new byte[]{'#', -82, 'G', -8, -14, '?', -57, -111, -2, '0', 1, 0, 16, -56},
        encoded.toByteArray());
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then array length is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; given one; then array length is four")
  void testEncodeWithInputEncodedParameters_givenOne_thenArrayLengthIsFour() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(1);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    byte[] toByteArrayResult = encoded.toByteArray();
    assertEquals(4, toByteArrayResult.length);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[0]);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[3]);
    assertEquals('\b', toByteArrayResult[1]);
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code A}.</li>
   *   <li>Then fourth element is sixteen.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; given one; when 'A'; then fourth element is sixteen")
  void testEncodeWithInputEncodedParameters_givenOne_whenA_thenFourthElementIsSixteen() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(1);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    byte[] toByteArrayResult = encoded.toByteArray();
    assertEquals((byte) 16, toByteArrayResult[3]);
    assertEquals((byte) 1, toByteArrayResult[1]);
    assertEquals(5, toByteArrayResult.length);
    assertEquals(Byte.MAX_VALUE, toByteArrayResult[4]);
    assertEquals('P', toByteArrayResult[0]);
  }
}
