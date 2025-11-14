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
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LZWFilterDiffblueTest {
  /**
   * Test {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <ul>
   *   <li>Then return JPXSMask is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then return JPXSMask is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult LZWFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex_thenReturnJPXSMaskIsNull() throws IOException {
    // Arrange
    LZWFilter lzwFilter = new LZWFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[] {});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = lzwFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult LZWFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex_thenThrowIOException() throws IOException {
    // Arrange
    LZWFilter lzwFilter = new LZWFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        IOException.class, () -> lzwFilter.decode(encoded, decoded, new COSDictionary(), 1));
  }

  /**
   * Test {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link LZWFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; when COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult LZWFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex_whenCOSStream_thenThrowIOException()
      throws IOException {
    // Arrange
    LZWFilter lzwFilter = new LZWFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(IOException.class, () -> lzwFilter.decode(encoded, decoded, new COSStream(), 1));
  }

  /**
   * Test {@link LZWFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code rawData},
   * {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link LZWFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'rawData', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LZWFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithRawDataEncodedParameters() throws IOException {
    // Arrange
    LZWFilter lzwFilter = new LZWFilter();
    ByteArrayInputStream rawData = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    lzwFilter.encode(rawData, encoded, new COSDictionary());

    // Assert
    int actualReadResult = rawData.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 16, 'K', 16, '(', '!', 'b', 2, 0}, encoded.toByteArray());
  }

  /**
   * Test {@link LZWFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code rawData},
   * {@code encoded}, {@code parameters}.
   *
   * <ul>
   *   <li>Given {@link EOFException#EOFException()}.
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link LZWFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'rawData', 'encoded', 'parameters'; given EOFException(); then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LZWFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithRawDataEncodedParameters_givenEOFException_thenThrowEOFException()
      throws IOException {
    // Arrange
    LZWFilter lzwFilter = new LZWFilter();

    DataInputStream rawData = mock(DataInputStream.class);
    when(rawData.read()).thenThrow(new EOFException());
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(EOFException.class, () -> lzwFilter.encode(rawData, encoded, new COSDictionary()));
    verify(rawData).read();
  }
}
