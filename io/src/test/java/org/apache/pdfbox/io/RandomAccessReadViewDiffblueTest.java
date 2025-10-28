package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class RandomAccessReadViewDiffblueTest {
  /**
   * Method under test: {@link RandomAccessReadView#getPosition()}
   */
  @Test
  void testGetPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L)).getPosition());
    assertThrows(IOException.class, () -> (new RandomAccessReadView(null, 1L, 3L)).getPosition());
    assertEquals(0L, (new RandomAccessReadView(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), 1L, 3L))
        .getPosition());
    assertThrows(IOException.class,
        () -> (new RandomAccessReadView(new RandomAccessReadView(null, 1L, 3L), 1L, 3L)).getPosition());
    assertEquals(0L,
        (new RandomAccessReadView(new NonSeekableRandomAccessReadInputStream(mock(DataInputStream.class)), 1L, 3L))
            .getPosition());
  }

  /**
   * Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  void testSeek() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L);

    // Act
    randomAccessReadView.seek(1L);

    // Assert
    assertEquals(1L, randomAccessReadView.getPosition());
    assertEquals(2, randomAccessReadView.available());
  }

  /**
   * Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  void testSeek2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new RandomAccessReadView(null, 1L, 3L)).seek(1L));
  }

  /**
   * Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  void testSeek3() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L)).seek(-1L));
  }

  /**
   * Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  void testSeek4() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new RandomAccessReadView(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), Long.MAX_VALUE,
            3L)).seek(1L));
  }

  /**
   * Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  void testSeek5() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new RandomAccessReadView(new RandomAccessReadView(null, 1L, 3L), Long.MAX_VALUE, 3L)).seek(1L));
  }

  /**
   * Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  void testSeek6() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(
        new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), 1L, 3L);

    // Act
    randomAccessReadView.seek(1L);

    // Assert
    assertEquals(1L, randomAccessReadView.getPosition());
    assertEquals(2, randomAccessReadView.available());
  }

  /**
   * Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  void testSeek7() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(
        RandomAccessReadBuffer.createBufferFromStream(inputStream), 1L, 3L);

    // Act
    randomAccessReadView.seek(1L);

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(1L, randomAccessReadView.getPosition());
    assertEquals(2, randomAccessReadView.available());
  }

  /**
   * Method under test: {@link RandomAccessReadView#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L)).read());
    assertThrows(IOException.class, () -> (new RandomAccessReadView(null, 1L, 3L)).read());
    assertEquals(-1, (new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, -1L)).read());
    assertThrows(IOException.class,
        () -> (new RandomAccessReadView(new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), -1L, 3L))
            .read());
    assertThrows(IOException.class,
        () -> (new RandomAccessReadView(new RandomAccessReadView(null, 3L, 3L), -1L, 3L)).read());
    assertEquals(-1,
        (new RandomAccessReadView(new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), 3L, 3L)).read());
    assertThrows(IOException.class, () -> (new RandomAccessReadView(
        new RandomAccessReadView(new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), Long.MAX_VALUE, 3L),
        3L, 3L)).read());
    assertEquals(-1,
        (new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), 3L, 3L), 3L, 3L))
                .read());
  }

  /**
   * Method under test: {@link RandomAccessReadView#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})), 1L, 3L);

    // Act
    int actualReadResult = randomAccessReadView.read();

    // Assert
    assertEquals(1L, randomAccessReadView.getPosition());
    assertEquals(2, randomAccessReadView.available());
    assertEquals(3, actualReadResult);
  }

  /**
   * Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadView.read(b, 1, 3));
    assertEquals(-1L, randomAccessReadView.getPosition());
    assertEquals(4, randomAccessReadView.available());
    assertEquals(8, b.length);
    assertEquals('X', b[1]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(null, 1L, 3L);

    // Act and Assert
    assertThrows(IOException.class, () -> randomAccessReadView.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})), 1L, 3L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = randomAccessReadView.read(b, 1, 3);

    // Assert
    assertEquals(0, randomAccessReadView.available());
    assertEquals(3, actualReadResult);
    assertEquals(3L, randomAccessReadView.getPosition());
    assertEquals((byte) 3, b[1]);
    assertEquals((byte) 3, b[3]);
    assertEquals(8, b.length);
  }

  /**
   * Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  void testRead6() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, -1L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadView.read(b, 1, 3));
    assertEquals(8, b.length);
    assertEquals('X', b[1]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  void testRead7() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(
        new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), -1L, 3L);

    // Act and Assert
    assertThrows(IOException.class, () -> randomAccessReadView.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  void testRead8() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(new RandomAccessReadView(null, 3L, 3L), -1L,
        3L);

    // Act and Assert
    assertThrows(IOException.class, () -> randomAccessReadView.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  void testRead9() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(
        new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), 3L, 3L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadView.read(b, 1, 3));
    assertEquals(-1L, randomAccessReadView.getPosition());
    assertEquals(4, randomAccessReadView.available());
    assertEquals(8, b.length);
    assertEquals('X', b[1]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link RandomAccessReadView#length()}
   */
  @Test
  void testLength() throws IOException {
    // Arrange, Act and Assert
    assertEquals(3L, (new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L)).length());
    assertThrows(IOException.class, () -> (new RandomAccessReadView(null, 1L, 3L)).length());
    assertEquals(3L,
        (new RandomAccessReadView(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), 1L, 3L)).length());
    assertThrows(IOException.class,
        () -> (new RandomAccessReadView(new RandomAccessReadView(null, 1L, 3L), 1L, 3L)).length());
    assertEquals(3L,
        (new RandomAccessReadView(new NonSeekableRandomAccessReadInputStream(mock(DataInputStream.class)), 1L, 3L))
            .length());
  }

  /**
   * Method under test: {@link RandomAccessReadView#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L);

    // Act
    randomAccessReadView.close();

    // Assert
    assertTrue(randomAccessReadView.isClosed());
  }

  /**
   * Method under test: {@link RandomAccessReadView#close()}
   */
  @Test
  void testClose2() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L, true);

    // Act
    randomAccessReadView.close();

    // Assert
    assertTrue(randomAccessReadView.isClosed());
  }

  /**
   * Method under test: {@link RandomAccessReadView#close()}
   */
  @Test
  void testClose3() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(
        new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), 1L, 3L, true);

    // Act
    randomAccessReadView.close();

    // Assert
    assertTrue(randomAccessReadView.isClosed());
  }

  /**
   * Method under test: {@link RandomAccessReadView#close()}
   */
  @Test
  void testClose4() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(
        new NonSeekableRandomAccessReadInputStream(mock(DataInputStream.class)), 1L, 3L);

    // Act
    randomAccessReadView.close();

    // Assert
    assertTrue(randomAccessReadView.isClosed());
  }

  /**
   * Method under test: {@link RandomAccessReadView#isClosed()}
   */
  @Test
  void testIsClosed() {
    // Arrange, Act and Assert
    assertFalse((new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L)).isClosed());
    assertTrue((new RandomAccessReadView(null, 1L, 3L)).isClosed());
    assertFalse(
        (new RandomAccessReadView(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), 1L, 3L)).isClosed());
    assertTrue((new RandomAccessReadView(new RandomAccessReadView(null, 1L, 3L), 1L, 3L)).isClosed());
    assertFalse(
        (new RandomAccessReadView(new NonSeekableRandomAccessReadInputStream(mock(DataInputStream.class)), 1L, 3L))
            .isClosed());
  }

  /**
   * Method under test: {@link RandomAccessReadView#rewind(int)}
   */
  @Test
  void testRewind() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new RandomAccessReadView(null, 1L, 3L)).rewind(1));
    assertThrows(IOException.class,
        () -> (new RandomAccessReadView(new RandomAccessReadView(new RandomAccessReadBuffer(), -1L, 3L), -1L, 3L))
            .rewind(1));
    assertThrows(IOException.class,
        () -> (new RandomAccessReadView(new RandomAccessReadView(null, -1L, 3L), -1L, 3L)).rewind(1));
    assertThrows(IOException.class,
        () -> (new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadView(new RandomAccessReadBuffer(), -1L, 3L), -1L, 3L), 0L, 3L))
                .rewind(1));
  }

  /**
   * Method under test: {@link RandomAccessReadView#rewind(int)}
   */
  @Test
  void testRewind2() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})), 1L, 3L);

    // Act
    randomAccessReadView.rewind(1);

    // Assert
    assertEquals(-1L, randomAccessReadView.getPosition());
    assertEquals(4, randomAccessReadView.available());
  }

  /**
   * Method under test: {@link RandomAccessReadView#isEOF()}
   */
  @Test
  void testIsEOF() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L)).isEOF());
    assertThrows(IOException.class, () -> (new RandomAccessReadView(null, 1L, 3L)).isEOF());
    assertFalse(
        (new RandomAccessReadView(new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), 1L, 3L)).isEOF());
    assertTrue((new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, -1L)).isEOF());
    assertThrows(IOException.class,
        () -> (new RandomAccessReadView(new RandomAccessReadView(null, 3L, 3L), 1L, 3L)).isEOF());
    assertFalse(
        (new RandomAccessReadView(new NonSeekableRandomAccessReadInputStream(mock(DataInputStream.class)), 1L, 3L))
            .isEOF());
  }

  /**
   * Method under test: {@link RandomAccessReadView#createView(long, long)}
   */
  @Test
  void testCreateView() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L)).createView(1L, 3L));
  }

  /**
   * Method under test:
   * {@link RandomAccessReadView#RandomAccessReadView(RandomAccessRead, long, long)}
   */
  @Test
  void testNewRandomAccessReadView() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualRandomAccessReadView = new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L);

    // Assert
    assertEquals(0L, actualRandomAccessReadView.getPosition());
    assertEquals(3, actualRandomAccessReadView.available());
    assertFalse(actualRandomAccessReadView.isClosed());
  }

  /**
   * Method under test:
   * {@link RandomAccessReadView#RandomAccessReadView(RandomAccessRead, long, long)}
   */
  @Test
  void testNewRandomAccessReadView2() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualRandomAccessReadView = new RandomAccessReadView(
        new NonSeekableRandomAccessReadInputStream(mock(DataInputStream.class)), 1L, 3L);

    // Assert
    assertEquals(0L, actualRandomAccessReadView.getPosition());
    assertEquals(3, actualRandomAccessReadView.available());
    assertFalse(actualRandomAccessReadView.isClosed());
  }

  /**
   * Method under test:
   * {@link RandomAccessReadView#RandomAccessReadView(RandomAccessRead, long, long, boolean)}
   */
  @Test
  void testNewRandomAccessReadView3() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualRandomAccessReadView = new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L,
        true);

    // Assert
    assertEquals(0L, actualRandomAccessReadView.getPosition());
    assertEquals(3, actualRandomAccessReadView.available());
    assertFalse(actualRandomAccessReadView.isClosed());
  }

  /**
   * Method under test:
   * {@link RandomAccessReadView#RandomAccessReadView(RandomAccessRead, long, long, boolean)}
   */
  @Test
  void testNewRandomAccessReadView4() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualRandomAccessReadView = new RandomAccessReadView(
        new NonSeekableRandomAccessReadInputStream(mock(DataInputStream.class)), 1L, 3L, true);

    // Assert
    assertEquals(0L, actualRandomAccessReadView.getPosition());
    assertEquals(3, actualRandomAccessReadView.available());
    assertFalse(actualRandomAccessReadView.isClosed());
  }
}
