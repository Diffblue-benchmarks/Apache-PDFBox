package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ASCIIHexFilterDiffblueTest {
  /**
   * Test {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <ul>
   *   <li>Then return JPXSMask is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then return JPXSMask is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult ASCIIHexFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex_thenReturnJPXSMaskIsNull() throws IOException {
    // Arrange
    ASCIIHexFilter asciiHexFilter = new ASCIIHexFilter();

    DataInputStream encoded = mock(DataInputStream.class);
    when(encoded.read()).thenReturn(62);
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = asciiHexFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    verify(encoded).read();
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCIIHexFilter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult ASCIIHexFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex_thenThrowIOException() throws IOException {
    // Arrange
    ASCIIHexFilter asciiHexFilter = new ASCIIHexFilter();

    DataInputStream encoded = mock(DataInputStream.class);
    when(encoded.read()).thenThrow(new IOException());
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        IOException.class, () -> asciiHexFilter.decode(encoded, decoded, new COSDictionary(), 1));
    verify(encoded).read();
  }

  /**
   * Test {@link ASCIIHexFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link ASCIIHexFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCIIHexFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    ASCIIHexFilter asciiHexFilter = new ASCIIHexFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    asciiHexFilter.encode(input, encoded, new COSDictionary());

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    byte[] expectedToByteArrayResult = "4158415841584158".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, encoded.toByteArray());
  }
}
