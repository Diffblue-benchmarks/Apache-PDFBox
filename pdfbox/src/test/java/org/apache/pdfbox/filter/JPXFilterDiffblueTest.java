package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class JPXFilterDiffblueTest {
  /**
   * Method under test:
   * {@link JPXFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode() throws IOException {
    // Arrange
    JPXFilter jpxFilter = new JPXFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(IOException.class, () -> jpxFilter.decode(encoded, decoded, new COSDictionary(), 1));
  }

  /**
   * Method under test:
   * {@link JPXFilter#decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)}
   */
  @Test
  void testDecode2() throws IOException {
    // Arrange
    JPXFilter jpxFilter = new JPXFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> jpxFilter.decode(encoded, decoded, new COSDictionary(), 1, DecodeOptions.DEFAULT));
  }

  /**
   * Method under test:
   * {@link JPXFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode() throws IOException {
    // Arrange
    JPXFilter jpxFilter = new JPXFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> jpxFilter.encode(input, encoded, new COSDictionary()));
  }
}
