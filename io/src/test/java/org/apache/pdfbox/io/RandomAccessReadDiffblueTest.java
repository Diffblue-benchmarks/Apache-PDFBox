package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.nio.ByteBuffer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RandomAccessReadDiffblueTest {
  /**
   * Method under test: {@link RandomAccessRead#read(byte[])}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessReadBuffer = new RandomAccessReadBuffer();
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadBuffer.read(b));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Method under test: {@link RandomAccessRead#read(byte[])}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = createBufferFromStreamResult.read(b);

    // Assert
    assertEquals(0, createBufferFromStreamResult.available());
    ByteBuffer byteBuffer = createBufferFromStreamResult.currentBuffer;
    assertEquals(8, byteBuffer.position());
    assertEquals(8, actualReadResult);
    assertEquals(8, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(8L, createBufferFromStreamResult.getPosition());
    assertEquals(8L, createBufferFromStreamResult.pointer);
    assertFalse(byteBuffer.hasRemaining());
    assertArrayEquals(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, b);
  }

  /**
   * Method under test: {@link RandomAccessRead#read(byte[])}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = createBufferFromStreamResult.read(b);

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(4088, createBufferFromStreamResult.available());
    assertEquals(8, createBufferFromStreamResult.currentBuffer.position());
    assertEquals(8, actualReadResult);
    assertEquals(8, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(8L, createBufferFromStreamResult.getPosition());
    assertEquals(8L, createBufferFromStreamResult.pointer);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0}, b);
  }

  /**
   * Method under test: {@link RandomAccessRead#peek()}
   */
  @Test
  void testPeek() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new RandomAccessReadBuffer()).peek());
    assertEquals(65,
        RandomAccessReadBuffer
            .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}))
            .peek());
  }

  /**
   * Method under test: {@link RandomAccessRead#peek()}
   */
  @Test
  void testPeek2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    int actualPeekResult = RandomAccessReadBuffer.createBufferFromStream(inputStream).peek();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(0, actualPeekResult);
  }

  /**
   * Method under test: {@link RandomAccessRead#available()}
   */
  @Test
  void testAvailable() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new RandomAccessReadBuffer()).available());
  }

  /**
   * Method under test: {@link RandomAccessRead#available()}
   */
  @Test
  void testAvailable2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    int actualAvailableResult = RandomAccessReadBuffer.createBufferFromStream(inputStream).available();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualAvailableResult);
  }

  /**
   * Method under test: {@link RandomAccessRead#skip(int)}
   */
  @Test
  void testSkip() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    // Act
    createBufferFromStreamResult.skip(3);

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(3, createBufferFromStreamResult.currentBuffer.position());
    assertEquals(3, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(3L, createBufferFromStreamResult.getPosition());
    assertEquals(3L, createBufferFromStreamResult.pointer);
    assertEquals(4093, createBufferFromStreamResult.available());
  }
}
