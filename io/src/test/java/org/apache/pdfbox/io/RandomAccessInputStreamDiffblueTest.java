package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RandomAccessInputStreamDiffblueTest {
  /**
   * Method under test: {@link RandomAccessInputStream#restorePosition()}
   */
  @Test
  void testRestorePosition() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    (new RandomAccessInputStream(RandomAccessReadBuffer.createBufferFromStream(inputStream))).restorePosition();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
  }

  /**
   * Method under test: {@link RandomAccessInputStream#available()}
   */
  @Test
  void testAvailable() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new RandomAccessInputStream(new RandomAccessReadBuffer())).available());
    assertEquals(0,
        (new RandomAccessInputStream(new NonSeekableRandomAccessReadInputStream(mock(DataInputStream.class))))
            .available());
  }

  /**
   * Method under test: {@link RandomAccessInputStream#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new RandomAccessInputStream(new RandomAccessReadBuffer())).read());
    assertEquals(-1,
        (new RandomAccessInputStream(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L))).read());
    assertEquals(-1, (new RandomAccessInputStream(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L)))
        .read(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3));
  }

  /**
   * Method under test: {@link RandomAccessInputStream#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    RandomAccessInputStream randomAccessInputStream = new RandomAccessInputStream(RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})));

    // Act and Assert
    assertEquals(65, randomAccessInputStream.read());
    byte[] byteArray = new byte[7];
    assertEquals(7, randomAccessInputStream.read(byteArray));
    assertArrayEquals(new byte[]{1, 'A', 1, 'A', 1, 'A', 1}, byteArray);
  }

  /**
   * Method under test: {@link RandomAccessInputStream#read()}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    int actualReadResult = (new RandomAccessInputStream(RandomAccessReadBuffer.createBufferFromStream(inputStream)))
        .read();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(0, actualReadResult);
  }

  /**
   * Method under test: {@link RandomAccessInputStream#read(byte[], int, int)}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    RandomAccessInputStream randomAccessInputStream = new RandomAccessInputStream(new RandomAccessReadBuffer());
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessInputStream.read(b, 1, 3));
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('X', b[1]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link RandomAccessInputStream#skip(long)}
   */
  @Test
  void testSkip() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1L, (new RandomAccessInputStream(new RandomAccessReadBuffer())).skip(1L));
    assertEquals(0L, (new RandomAccessInputStream(new RandomAccessReadBuffer())).skip(0L));
  }

  /**
   * Method under test: {@link RandomAccessInputStream#skip(long)}
   */
  @Test
  void testSkip2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    long actualSkipResult = (new RandomAccessInputStream(RandomAccessReadBuffer.createBufferFromStream(inputStream)))
        .skip(1L);

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test:
   * {@link RandomAccessInputStream#RandomAccessInputStream(RandomAccessRead)}
   */
  @Test
  void testNewRandomAccessInputStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new RandomAccessInputStream(new RandomAccessReadBuffer())).read(new byte[]{}));
  }
}
