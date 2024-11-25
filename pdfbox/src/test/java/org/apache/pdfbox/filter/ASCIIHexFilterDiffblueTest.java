package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ASCIIHexFilterDiffblueTest {
  /**
   * Test
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex() throws IOException {
    // Arrange
    ASCIIHexFilter asciiHexFilter = new ASCIIHexFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    asciiHexFilter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    assertArrayEquals(new byte[]{-97, -97, -97, -97}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex2() throws IOException {
    // Arrange
    ASCIIHexFilter asciiHexFilter = new ASCIIHexFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    asciiHexFilter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    assertArrayEquals(new byte[]{-17, -97, -97, -97}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex3() throws IOException {
    // Arrange
    ASCIIHexFilter asciiHexFilter = new ASCIIHexFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("\tXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    asciiHexFilter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    assertArrayEquals(new byte[]{-6, -6, -6, -16}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex4() throws IOException {
    // Arrange
    ASCIIHexFilter asciiHexFilter = new ASCIIHexFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("A>AXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = asciiHexFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    byte[] byteArray = new byte[6];
    assertEquals(6, encoded.read(byteArray));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals("AXAXAX".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new byte[]{-96}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex5() throws IOException {
    // Arrange
    ASCIIHexFilter asciiHexFilter = new ASCIIHexFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("\tXAXAXA\t".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    asciiHexFilter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    assertArrayEquals(new byte[]{-6, -6, -6}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then array length is zero")
  void testDecodeWithEncodedDecodedParametersIndex_thenArrayLengthIsZero() throws IOException {
    // Arrange
    ASCIIHexFilter asciiHexFilter = new ASCIIHexFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(">XAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = asciiHexFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(0, decoded.toByteArray().length);
    byte[] byteArray = new byte[7];
    assertEquals(7, encoded.read(byteArray));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ASCIIHexFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test:
   * {@link ASCIIHexFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    ASCIIHexFilter asciiHexFilter = new ASCIIHexFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    asciiHexFilter.encode(input, encoded, new COSDictionary());

    // Assert that nothing has changed
    assertEquals(-1, input.read(new byte[]{}));
    byte[] expectedToByteArrayResult = "4158415841584158".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, encoded.toByteArray());
  }
}
