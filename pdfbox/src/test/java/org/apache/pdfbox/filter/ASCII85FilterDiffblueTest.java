package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
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

class ASCII85FilterDiffblueTest {
  /**
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[]{'e', -105, -108, -114, 'e', -105, -108, -114}, decoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode2() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(0, decoded.toByteArray().length);
    byte[] byteArray = new byte[7];
    assertEquals(7, encoded.read(byteArray));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode3() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[]{-84, 'R', 'z', -67, -84, 'R', 'z', -67}, decoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode4() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("\rXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[]{-84, 'R', 'z', -67, -84, 'R', 'z', -67}, decoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode5() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(" XAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[]{-84, 'R', 'z', -67, -84, 'R', 'z', -67}, decoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode6() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[]{'d', -62, -114, -42, 'd', -62, -114, -42}, decoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode7() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("A\rAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[]{'d', -62, -114, -42, 'd', -62, -114, -42}, decoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode8() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("A AXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[]{'d', -62, -114, -42, 'd', -62, -114, -42}, decoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testDecode9() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    DataInputStream encoded = mock(DataInputStream.class);
    when(encoded.read()).thenReturn(126);
    doNothing().when(encoded).close();
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    verify(encoded).close();
    verify(encoded).read();
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(0, decoded.toByteArray().length);
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Method under test:
   * {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    byte[] expectedToByteArrayResult = "6!-ET6!-ET~>\n".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, encoded.toByteArray());
  }

  /**
   * Method under test:
   * {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode2() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(0, encoded.toByteArray().length);
  }

  /**
   * Method under test:
   * {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  void testEncode3() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.encode(input, encoded, new COSDictionary());

    // Assert
    verify(input).transferTo(isA(OutputStream.class));
    assertEquals(0, encoded.toByteArray().length);
  }
}
