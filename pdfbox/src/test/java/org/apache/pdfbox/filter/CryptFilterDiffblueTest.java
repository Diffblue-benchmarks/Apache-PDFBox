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

class CryptFilterDiffblueTest {
  /**
   * Method under test:
   * {@link CryptFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode() throws IOException {
    // Arrange
    CryptFilter cryptFilter = new CryptFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = cryptFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, decoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link CryptFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode() throws IOException {
    // Arrange
    CryptFilter cryptFilter = new CryptFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    cryptFilter.encode(input, encoded, new COSDictionary());

    // Assert that nothing has changed
    assertEquals(-1, input.read(new byte[]{}));
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, encoded.toByteArray());
  }
}
