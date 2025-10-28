package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NonSeekableRandomAccessReadInputStreamDiffblueTest {
  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    nonSeekableRandomAccessReadInputStream.close();

    // Assert
    assertTrue(nonSeekableRandomAccessReadInputStream.isClosed());
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#close()}
   */
  @Test
  void testClose2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    doNothing().when(inputStream).close();
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        inputStream);

    // Act
    nonSeekableRandomAccessReadInputStream.close();

    // Assert
    verify(inputStream).close();
    assertTrue(nonSeekableRandomAccessReadInputStream.isClosed());
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#seek(long)}
   */
  @Test
  void testSeek() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new NonSeekableRandomAccessReadInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .seek(1L));
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#skip(int)}
   */
  @Test
  void testSkip() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    nonSeekableRandomAccessReadInputStream.skip(3);

    // Assert
    assertEquals(3, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(5, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(8L, nonSeekableRandomAccessReadInputStream.size);
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#skip(int)}
   */
  @Test
  void testSkip2() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        new ByteArrayInputStream(new byte[]{}));

    // Act
    nonSeekableRandomAccessReadInputStream.skip(3);

    // Assert
    assertEquals(0, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(0, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.size);
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#skip(int)}
   */
  @Test
  void testSkip3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        inputStream);

    // Act
    nonSeekableRandomAccessReadInputStream.skip(3);

    // Assert
    verify(inputStream, atLeast(1)).read(Mockito.<byte[]>any());
    assertEquals(1, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.size);
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#skip(int)}
   */
  @Test
  void testSkip4() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new NonSeekableRandomAccessReadInputStream(inputStream)).skip(3));
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link NonSeekableRandomAccessReadInputStream#getPosition()}
   */
  @Test
  void testGetPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new NonSeekableRandomAccessReadInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .getPosition());
    assertEquals(0L, (new NonSeekableRandomAccessReadInputStream(mock(DataInputStream.class))).getPosition());
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    int actualReadResult = nonSeekableRandomAccessReadInputStream.read();

    // Assert
    assertEquals(1, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(1L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(1L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(65, actualReadResult);
    assertEquals(7, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(8L, nonSeekableRandomAccessReadInputStream.size);
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        new ByteArrayInputStream(new byte[]{}));

    // Act and Assert
    assertEquals(-1, nonSeekableRandomAccessReadInputStream.read());
    assertEquals(0, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(0, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.size);
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#read()}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        inputStream);

    // Act
    int actualReadResult = nonSeekableRandomAccessReadInputStream.read();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    assertEquals(0, actualReadResult);
    assertEquals(1, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(1L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(1L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(1L, nonSeekableRandomAccessReadInputStream.size);
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#read()}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new NonSeekableRandomAccessReadInputStream(inputStream)).read());
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link NonSeekableRandomAccessReadInputStream#read(byte[], int, int)}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, nonSeekableRandomAccessReadInputStream.read(b, 2, 3));
    assertEquals(3, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(5, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(8, b.length);
    assertEquals(8L, nonSeekableRandomAccessReadInputStream.size);
    assertEquals('A', b[2]);
    assertEquals('A', b[4]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test:
   * {@link NonSeekableRandomAccessReadInputStream#read(byte[], int, int)}
   */
  @Test
  void testRead6() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        new ByteArrayInputStream(new byte[]{}));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, nonSeekableRandomAccessReadInputStream.read(b, 2, 3));
    assertEquals(0, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(0, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.size);
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('A', b[4]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test:
   * {@link NonSeekableRandomAccessReadInputStream#read(byte[], int, int)}
   */
  @Test
  void testRead7() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        inputStream);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = nonSeekableRandomAccessReadInputStream.read(b, 2, 3);

    // Assert
    verify(inputStream, atLeast(1)).read(Mockito.<byte[]>any());
    assertEquals((byte) 0, b[2]);
    assertEquals((byte) 0, b[3]);
    assertEquals((byte) 0, b[4]);
    assertEquals(1, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(3, actualReadResult);
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.size);
    assertEquals(8, b.length);
  }

  /**
   * Method under test:
   * {@link NonSeekableRandomAccessReadInputStream#read(byte[], int, int)}
   */
  @Test
  void testRead8() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException("foo"));
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        inputStream);

    // Act and Assert
    assertThrows(IOException.class,
        () -> nonSeekableRandomAccessReadInputStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#length()}
   */
  @Test
  void testLength() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new NonSeekableRandomAccessReadInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).length());
    assertEquals(0L, (new NonSeekableRandomAccessReadInputStream(mock(DataInputStream.class))).length());
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#rewind(int)}
   */
  @Test
  void testRewind() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new NonSeekableRandomAccessReadInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .rewind(1));
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#rewind(int)}
   */
  @Test
  void testRewind2() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        mock(DataInputStream.class));

    // Act
    nonSeekableRandomAccessReadInputStream.rewind(-1);

    // Assert
    assertEquals(-1, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(1, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(1L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(1L, nonSeekableRandomAccessReadInputStream.position);
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#isClosed()}
   */
  @Test
  void testIsClosed() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse((new NonSeekableRandomAccessReadInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
        .isClosed());
  }

  /**
   * Method under test: {@link NonSeekableRandomAccessReadInputStream#isEOF()}
   */
  @Test
  void testIsEOF() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        (new NonSeekableRandomAccessReadInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).isEOF());
    assertFalse((new NonSeekableRandomAccessReadInputStream(mock(DataInputStream.class))).isEOF());
  }

  /**
   * Method under test:
   * {@link NonSeekableRandomAccessReadInputStream#createView(long, long)}
   */
  @Test
  void testCreateView() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new NonSeekableRandomAccessReadInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .createView(1L, 3L));
  }

  /**
   * Method under test:
   * {@link NonSeekableRandomAccessReadInputStream#NonSeekableRandomAccessReadInputStream(InputStream)}
   */
  @Test
  void testNewNonSeekableRandomAccessReadInputStream() throws IOException {
    // Arrange and Act
    NonSeekableRandomAccessReadInputStream actualNonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertEquals(0, actualNonSeekableRandomAccessReadInputStream.available());
    assertEquals(0, actualNonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(0L, actualNonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(0L, actualNonSeekableRandomAccessReadInputStream.position);
    assertEquals(0L, actualNonSeekableRandomAccessReadInputStream.size);
    assertFalse(actualNonSeekableRandomAccessReadInputStream.isClosed());
  }

  /**
   * Method under test:
   * {@link NonSeekableRandomAccessReadInputStream#NonSeekableRandomAccessReadInputStream(InputStream)}
   */
  @Test
  void testNewNonSeekableRandomAccessReadInputStream2() throws IOException {
    // Arrange and Act
    NonSeekableRandomAccessReadInputStream actualNonSeekableRandomAccessReadInputStream = new NonSeekableRandomAccessReadInputStream(
        mock(DataInputStream.class));

    // Assert
    assertEquals(0, actualNonSeekableRandomAccessReadInputStream.available());
    assertEquals(0, actualNonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(0L, actualNonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(0L, actualNonSeekableRandomAccessReadInputStream.position);
    assertEquals(0L, actualNonSeekableRandomAccessReadInputStream.size);
    assertFalse(actualNonSeekableRandomAccessReadInputStream.isClosed());
  }
}
