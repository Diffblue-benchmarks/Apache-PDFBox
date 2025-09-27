package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertThrows;
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

class JPXFilterDiffblueTest {
  /**
   * Test {@link JPXFilter#decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}, {@code options}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link JPXFilter#decode(InputStream, OutputStream, COSDictionary, int,
   * DecodeOptions)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions) with 'encoded', 'decoded', 'parameters', 'index', 'options'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.filter.DecodeResult JPXFilter.decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)"
  })
  void testDecodeWithEncodedDecodedParametersIndexOptions_thenThrowIOException()
      throws IOException {
    // Arrange
    JPXFilter jpxFilter = new JPXFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> jpxFilter.decode(encoded, decoded, new COSDictionary(), 1, DecodeOptions.DEFAULT));
  }

  /**
   * Test {@link JPXFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link JPXFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.filter.DecodeResult JPXFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex_thenThrowIOException() throws IOException {
    // Arrange
    JPXFilter jpxFilter = new JPXFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        IOException.class, () -> jpxFilter.decode(encoded, decoded, new COSDictionary(), 1));
  }

  /**
   * Test {@link JPXFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input},
   * {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link JPXFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JPXFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    JPXFilter jpxFilter = new JPXFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> jpxFilter.encode(input, encoded, new COSDictionary()));
  }
}
