package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LZWFilterDiffblueTest {
  /**
   * Test {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex() throws IOException {
    // Arrange
    LZWFilter lzwFilter = new LZWFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(IOException.class, () -> lzwFilter.decode(encoded, decoded, new COSDictionary(), 1));
  }

  /**
   * Test {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>Then return JPXSMask is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then return JPXSMask is 'null'")
  void testDecodeWithEncodedDecodedParametersIndex_thenReturnJPXSMaskIsNull() throws IOException {
    // Arrange
    LZWFilter lzwFilter = new LZWFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = lzwFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; when 'A'; then throw IOException")
  void testDecodeWithEncodedDecodedParametersIndex_whenA_thenThrowIOException() throws IOException {
    // Arrange
    LZWFilter lzwFilter = new LZWFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(
        new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(IOException.class, () -> lzwFilter.decode(encoded, decoded, new COSDictionary(), 1));
  }

  /**
   * Test {@link LZWFilter#encode(InputStream, OutputStream, COSDictionary)} with
   * {@code rawData}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test:
   * {@link LZWFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'rawData', 'encoded', 'parameters'")
  void testEncodeWithRawDataEncodedParameters() throws IOException {
    // Arrange
    LZWFilter lzwFilter = new LZWFilter();
    ByteArrayInputStream rawData = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    lzwFilter.encode(rawData, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, rawData.read(new byte[]{}));
    byte[] toByteArrayResult = encoded.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 16, toByteArrayResult[1]);
    assertEquals((byte) 16, toByteArrayResult[3]);
    assertEquals((byte) 2, toByteArrayResult[7]);
    assertEquals(9, toByteArrayResult.length);
    assertEquals('!', toByteArrayResult[5]);
    assertEquals('(', toByteArrayResult[4]);
    assertEquals('K', toByteArrayResult[2]);
    assertEquals('b', toByteArrayResult[6]);
  }

  /**
   * Test {@link LZWFilter#encode(InputStream, OutputStream, COSDictionary)} with
   * {@code rawData}, {@code encoded}, {@code parameters}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>Then fourth element is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LZWFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'rawData', 'encoded', 'parameters'; given minus one; then fourth element is zero")
  void testEncodeWithRawDataEncodedParameters_givenMinusOne_thenFourthElementIsZero() throws IOException {
    // Arrange
    LZWFilter lzwFilter = new LZWFilter();
    DataInputStream rawData = mock(DataInputStream.class);
    when(rawData.read()).thenReturn(-1);
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    lzwFilter.encode(rawData, encoded, new COSDictionary());

    // Assert
    verify(rawData).read();
    byte[] toByteArrayResult = encoded.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[3]);
    assertEquals(4, toByteArrayResult.length);
    assertEquals('@', toByteArrayResult[1]);
    assertEquals('@', toByteArrayResult[2]);
  }
}
