package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CryptFilterDiffblueTest {
  /**
   * Test {@link CryptFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <ul>
   *   <li>Then return JPXSMask is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CryptFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then return JPXSMask is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult CryptFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex_thenReturnJPXSMaskIsNull() throws IOException {
    // Arrange
    CryptFilter cryptFilter = new CryptFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = cryptFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, decoded.toByteArray());
  }

  /**
   * Test {@link CryptFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input},
   * {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link CryptFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CryptFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    CryptFilter cryptFilter = new CryptFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    cryptFilter.encode(input, encoded, new COSDictionary());

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, encoded.toByteArray());
  }
}
