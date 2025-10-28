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
import org.junit.jupiter.api.Test;

class RunLengthDecodeFilterDiffblueTest {
  /**
   * Method under test:
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = runLengthDecodeFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    byte[] expectedToByteArrayResult = "XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, decoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode2() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(
        new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = runLengthDecodeFilter.decode(encoded, decoded, parameters, 1);

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
   * Method under test:
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode3() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = runLengthDecodeFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    byte[] expectedToByteArrayResult = "XXXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, decoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode4() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = runLengthDecodeFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    byte[] expectedToByteArrayResult = "XAAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, decoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{7, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode2() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{-1, 'X', 5, 'A', 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode3() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AAAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{-2, 'A', 4, 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode4() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXXXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{0, 'A', -2, 'X', 3, 'A', 'X', 'A', 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode5() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAAAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{3, 'A', 'X', 'A', 'X', -2, 'A', 0, 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode6() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXXX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{4, 'A', 'X', 'A', 'X', 'A', -2, 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode7() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert that nothing has changed
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{Byte.MIN_VALUE}, encoded.toByteArray());
  }
}
