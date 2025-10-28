package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlateFilterDiffblueTest {
  /**
   * Method under test:
   * {@link FlateFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode() throws IOException {
    // Arrange
    FlateFilter flateFilter = new FlateFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = flateFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Method under test:
   * {@link FlateFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode2() throws IOException {
    // Arrange
    FlateFilter flateFilter = new FlateFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = flateFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Method under test:
   * {@link FlateFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode() throws IOException {
    // Arrange
    FlateFilter flateFilter = new FlateFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    flateFilter.encode(input, encoded, new COSDictionary());

    // Assert that nothing has changed
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{'x', -100, 's', -116, 'p', 4, 'C', 0, '\n', -100, 2, 'e'}, encoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link FlateFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode2() throws IOException {
    // Arrange
    FlateFilter flateFilter = new FlateFilter();
    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    flateFilter.encode(input, encoded, new COSDictionary());

    // Assert that nothing has changed
    verify(input).transferTo(isA(OutputStream.class));
    assertArrayEquals(new byte[]{'x', -100, 3, 0, 0, 0, 0, 1}, encoded.toByteArray());
  }
}
