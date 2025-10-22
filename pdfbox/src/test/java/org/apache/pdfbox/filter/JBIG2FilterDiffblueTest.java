package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertThrows;
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

class JBIG2FilterDiffblueTest {
  /**
   * Test {@link JBIG2Filter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test: {@link JBIG2Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.filter.DecodeResult JBIG2Filter.decode(InputStream, OutputStream, COSDictionary, int)"})
  void testDecodeWithEncodedDecodedParametersIndex() throws IOException {
    // Arrange
    JBIG2Filter jbig2Filter = new JBIG2Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(IOException.class, () -> jbig2Filter.decode(encoded, decoded, new COSDictionary(), 1));
  }

  /**
   * Test {@link JBIG2Filter#decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)} with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}, {@code options}.
   * <p>
   * Method under test: {@link JBIG2Filter#decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions) with 'encoded', 'decoded', 'parameters', 'index', 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.filter.DecodeResult JBIG2Filter.decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)"})
  void testDecodeWithEncodedDecodedParametersIndexOptions() throws IOException {
    // Arrange
    JBIG2Filter jbig2Filter = new JBIG2Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> jbig2Filter.decode(encoded, decoded, new COSDictionary(), 1, DecodeOptions.DEFAULT));
  }

  /**
   * Test {@link JBIG2Filter#encode(InputStream, OutputStream, COSDictionary)} with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test: {@link JBIG2Filter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JBIG2Filter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    JBIG2Filter jbig2Filter = new JBIG2Filter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> jbig2Filter.encode(input, encoded, new COSDictionary()));
  }
}
