package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CCITTFaxFilterDiffblueTest {
  /**
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode2() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{-64, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode3() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode4() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{'A', 'X', 0, 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode5() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 0, 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode6() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ccittFaxFilter.decode(encoded, decoded, new COSDictionary(), 1));
  }

  /**
   * Method under test:
   * {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode7() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{'A', 'X', 0, 'X', 'A', 'X', 0, 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Method under test:
   * {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(1);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, '\b', 0, Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode2() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(1);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{'P', 1, 0, 16, Byte.MAX_VALUE}, encoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode3() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(1);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(0, encoded.toByteArray().length);
  }

  /**
   * Method under test:
   * {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode4() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(7);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{'#', -82, 'G', -8, -14, '?', -57, -111, -2, '0', 1, 0, 16, -56},
        encoded.toByteArray());
  }
}
