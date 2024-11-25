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
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CryptFilterDiffblueTest {
  /**
   * Test
   * {@link CryptFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>Then return JPXSMask is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CryptFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then return JPXSMask is 'null'")
  void testDecodeWithEncodedDecodedParametersIndex_thenReturnJPXSMaskIsNull() throws IOException {
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
   * Test
   * {@link CryptFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>Then return Parameters is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CryptFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then return Parameters is COSStream()")
  void testDecodeWithEncodedDecodedParametersIndex_thenReturnParametersIsCOSStream() throws IOException {
    // Arrange
    CryptFilter cryptFilter = new CryptFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSStream parameters = new COSStream();

    // Act and Assert
    assertSame(parameters, cryptFilter.decode(encoded, decoded, parameters, 1).getParameters());
  }

  /**
   * Test {@link CryptFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test:
   * {@link CryptFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  void testEncodeWithInputEncodedParameters() throws IOException {
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

  /**
   * Test {@link CryptFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CryptFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; when COSStream()")
  void testEncodeWithInputEncodedParameters_whenCOSStream() throws IOException {
    // Arrange
    CryptFilter cryptFilter = new CryptFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    cryptFilter.encode(input, encoded, new COSStream());

    // Assert that nothing has changed
    assertEquals(-1, input.read(new byte[]{}));
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, encoded.toByteArray());
  }
}
