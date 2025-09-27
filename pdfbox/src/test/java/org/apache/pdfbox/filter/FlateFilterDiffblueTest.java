package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
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
import java.io.PipedOutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlateFilterDiffblueTest {
  /**
   * Test {@link FlateFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <ul>
   *   <li>Then return JPXSMask is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FlateFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then return JPXSMask is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult FlateFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex_thenReturnJPXSMaskIsNull() throws IOException {
    // Arrange
    FlateFilter flateFilter = new FlateFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[] {});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = flateFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test {@link FlateFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input},
   * {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link FlateFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlateFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    FlateFilter flateFilter = new FlateFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    flateFilter.encode(input, encoded, new COSDictionary());

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {'x', -100, 's', -116, 'p', 4, 'C', 0, '\n', -100, 2, 'e'},
        encoded.toByteArray());
  }

  /**
   * Test {@link FlateFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input},
   * {@code encoded}, {@code parameters}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FlateFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlateFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters_thenThrowIOException() throws IOException {
    // Arrange
    FlateFilter flateFilter = new FlateFilter();

    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenThrow(new IOException());
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(IOException.class, () -> flateFilter.encode(input, encoded, new COSDictionary()));
    verify(input).transferTo(isA(OutputStream.class));
  }

  /**
   * Test {@link FlateFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input},
   * {@code encoded}, {@code parameters}.
   *
   * <ul>
   *   <li>When {@link PipedOutputStream#PipedOutputStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FlateFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; when PipedOutputStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlateFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters_whenPipedOutputStream_thenThrowIOException()
      throws IOException {
    // Arrange
    FlateFilter flateFilter = new FlateFilter();

    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenThrow(new IOException());
    PipedOutputStream encoded = new PipedOutputStream();

    // Act and Assert
    assertThrows(IOException.class, () -> flateFilter.encode(input, encoded, new COSDictionary()));
    verify(input).transferTo(isA(OutputStream.class));
  }
}
