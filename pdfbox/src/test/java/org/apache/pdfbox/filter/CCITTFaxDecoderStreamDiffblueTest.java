package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class CCITTFaxDecoderStreamDiffblueTest {
  /**
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 2, 1L, true)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(-1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 2, 1L, true)).read();

    // Assert
    verify(stream).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 2, 2, 1L, true)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> (new CCITTFaxDecoderStream(stream, -1, 2, 1L, true)).read());
    verify(stream, atLeast(1)).read();
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 128, 2, 1L, true)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  void testRead6() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 4, 1L, true)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(128, actualReadResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  void testRead7() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 2, 1L, false)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  void testRead8() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenThrow(new EOFException("foo"));

    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);
    ccittFaxDecoderStream.skip(1L);

    // Act
    int actualReadResult = ccittFaxDecoderStream.read();

    // Assert
    verify(stream).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  void testRead9() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 2, 4, 1L, true)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(Double.SIZE, actualReadResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  void testRead10() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(2);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 128, 2, 1L, true)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  void testRead11() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 4, 1L, false)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(128, actualReadResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead12() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ccittFaxDecoderStream.read(b, 1, 3);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals((byte) 0, b[1]);
    assertEquals(1, actualReadResult);
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead13() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(-1);
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ccittFaxDecoderStream.read(b, 1, 3);

    // Assert
    verify(stream).read();
    assertEquals((byte) 0, b[1]);
    assertEquals((byte) 0, b[2]);
    assertEquals((byte) 0, b[3]);
    assertEquals(3, actualReadResult);
    assertEquals(8, b.length);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead14() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 2, 2, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ccittFaxDecoderStream.read(b, 1, 3);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals((byte) 0, b[1]);
    assertEquals(1, actualReadResult);
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead15() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, -1, 2, 1L, true);

    // Act and Assert
    assertThrows(IOException.class, () -> ccittFaxDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
    verify(stream, atLeast(1)).read();
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead16() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 128, 2, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ccittFaxDecoderStream.read(b, 1, 3);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals((byte) 0, b[1]);
    assertEquals((byte) 0, b[2]);
    assertEquals((byte) 0, b[3]);
    assertEquals(3, actualReadResult);
    assertEquals(8, b.length);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead17() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 4, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ccittFaxDecoderStream.read(b, 1, 3);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1, actualReadResult);
    assertEquals(8, b.length);
    assertEquals(Byte.MIN_VALUE, b[1]);
    assertEquals('A', b[2]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead18() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, false);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ccittFaxDecoderStream.read(b, 1, 3);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals((byte) 0, b[1]);
    assertEquals(1, actualReadResult);
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead19() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenThrow(new EOFException("foo"));

    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);
    ccittFaxDecoderStream.skip(1L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ccittFaxDecoderStream.read(b, 1, 3);

    // Assert
    verify(stream).read();
    assertEquals((byte) 0, b[1]);
    assertEquals((byte) 0, b[2]);
    assertEquals((byte) 0, b[3]);
    assertEquals(3, actualReadResult);
    assertEquals(8, b.length);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  void testSkip() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 1, 2, 1L, true)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  void testSkip2() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(-1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 1, 2, 1L, true)).skip(1L);

    // Assert
    verify(stream).read();
    assertEquals(-1L, actualSkipResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  void testSkip3() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 2, 2, 1L, true)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  void testSkip4() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> (new CCITTFaxDecoderStream(stream, -1, 2, 1L, true)).skip(1L));
    verify(stream, atLeast(1)).read();
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  void testSkip5() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 128, 2, 1L, true)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  void testSkip6() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 1, 4, 1L, true)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  void testSkip7() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 1, 2, 1L, false)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  void testSkip8() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenThrow(new EOFException("foo"));

    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);
    ccittFaxDecoderStream.read(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 1, 3);

    // Act
    long actualSkipResult = ccittFaxDecoderStream.skip(1L);

    // Assert
    verify(stream).read();
    assertEquals(-1L, actualSkipResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  void testSkip9() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 2, 4, 1L, true)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  void testSkip10() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(2);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 128, 2, 1L, true)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  void testSkip11() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 1, 4, 1L, false)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#markSupported()}
   */
  @Test
  void testMarkSupported() {
    // Arrange, Act and Assert
    assertFalse((new CCITTFaxDecoderStream(mock(DataInputStream.class), 1, 2, 1L, true)).markSupported());
  }

  /**
   * Method under test: {@link CCITTFaxDecoderStream#reset()}
   */
  @Test
  void testReset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new CCITTFaxDecoderStream(mock(DataInputStream.class), 1, 2, 1L, true)).reset());
  }

  /**
   * Method under test:
   * {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}
   */
  @Test
  void testNewCCITTFaxDecoderStream() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 1, 1L, true));

  }

  /**
   * Method under test:
   * {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}
   */
  @Test
  void testNewCCITTFaxDecoderStream2() throws UnsupportedEncodingException {
    // Arrange and Act
    new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true);

    // Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0}, new byte[8]);
  }

  /**
   * Method under test:
   * {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}
   */
  @Test
  void testNewCCITTFaxDecoderStream3() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    byte[] byteArray = new byte[1];
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 3, 1L, true)).read(byteArray);
    assertEquals(-1, stream.read(new byte[]{}));
    assertEquals(1, actualReadResult);
    assertArrayEquals(new byte[]{0}, byteArray);
  }
}
