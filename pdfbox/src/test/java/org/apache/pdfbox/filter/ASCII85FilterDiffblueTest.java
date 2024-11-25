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

class ASCII85FilterDiffblueTest {
  /**
   * Test
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    assertArrayEquals(new byte[]{'e', -105, -108, -114, 'e', -105, -108, -114}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex2() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    assertArrayEquals(new byte[]{-84, 'R', 'z', -67, -84, 'R', 'z', -67}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex3() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("\rXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    assertArrayEquals(new byte[]{-84, 'R', 'z', -67, -84, 'R', 'z', -67}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex4() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(" XAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    assertArrayEquals(new byte[]{-84, 'R', 'z', -67, -84, 'R', 'z', -67}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex5() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    assertArrayEquals(new byte[]{'d', -62, -114, -42, 'd', -62, -114, -42}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex6() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("A\rAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    assertArrayEquals(new byte[]{'d', -62, -114, -42, 'd', -62, -114, -42}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  void testDecodeWithEncodedDecodedParametersIndex7() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("A AXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    assertArrayEquals(new byte[]{'d', -62, -114, -42, 'd', -62, -114, -42}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>Then return JPXSMask is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then return JPXSMask is 'null'")
  void testDecodeWithEncodedDecodedParametersIndex_thenReturnJPXSMaskIsNull() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

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
   * Test {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test:
   * {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    byte[] expectedToByteArrayResult = "6!-ET6!-ET~>\n".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, encoded.toByteArray());
  }

  /**
   * Test {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test:
   * {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  void testEncodeWithInputEncodedParameters2() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(0, encoded.toByteArray().length);
  }
}
