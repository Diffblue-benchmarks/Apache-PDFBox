package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class ASCII85InputStreamDiffblueTest {
  /**
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(101, (new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read());
    assertEquals(-1,
        (new ASCII85InputStream(new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}))).read());
    assertEquals(172, (new ASCII85InputStream(new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8")))).read());
    assertEquals(172, (new ASCII85InputStream(new ByteArrayInputStream("\rXAXAXAX".getBytes("UTF-8")))).read());
    assertEquals(172, (new ASCII85InputStream(new ByteArrayInputStream(" XAXAXAX".getBytes("UTF-8")))).read());
    assertThrows(IOException.class,
        () -> (new ASCII85InputStream(new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})))
            .read());
    assertEquals(-1, (new ASCII85InputStream(new ByteArrayInputStream("~XAXAXAX".getBytes("UTF-8")))).read());
    assertEquals(0, (new ASCII85InputStream(new ByteArrayInputStream("zXAXAXAX".getBytes("UTF-8")))).read());
    assertThrows(IOException.class, () -> (new ASCII85InputStream(
        new ByteArrayInputStream(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}))).read());
    assertEquals(-1,
        (new ASCII85InputStream(new ByteArrayInputStream(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}))).read());
    assertEquals(100, (new ASCII85InputStream(new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8")))).read());
    assertEquals(100, (new ASCII85InputStream(new ByteArrayInputStream("A\rAXAXAX".getBytes("UTF-8")))).read());
    assertEquals(100, (new ASCII85InputStream(new ByteArrayInputStream("A AXAXAX".getBytes("UTF-8")))).read());
    assertEquals(-1, (new ASCII85InputStream(new ByteArrayInputStream("A~AXAXAX".getBytes("UTF-8")))).read());
    assertEquals(101, (new ASCII85InputStream(new ByteArrayInputStream("AX~XAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(-1);

    // Act
    int actualReadResult = (new ASCII85InputStream(is)).read();

    // Assert
    verify(is).read();
    assertEquals(-1, actualReadResult);
  }

  /**
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));

    // Act and Assert
    assertThrows(IOException.class, () -> ascii85InputStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ascii85InputStream.read(data, 2, 3));
    assertEquals(8, data.length);
    assertEquals('A', data[2]);
    assertEquals('A', data[4]);
    assertEquals('X', data[3]);
  }

  /**
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("~XAXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ascii85InputStream.read(data, 2, 3));
    assertEquals(8, data.length);
    assertEquals('A', data[2]);
    assertEquals('A', data[4]);
    assertEquals('X', data[3]);
  }

  /**
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  void testRead6() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));

    // Act and Assert
    assertThrows(IOException.class, () -> ascii85InputStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  void testRead7() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ascii85InputStream.read(data, 2, 3));
    assertEquals(8, data.length);
    assertEquals('A', data[2]);
    assertEquals('A', data[4]);
    assertEquals('X', data[3]);
  }

  /**
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  void testRead8() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("A~AXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ascii85InputStream.read(data, 2, 3));
    assertEquals(8, data.length);
    assertEquals('A', data[2]);
    assertEquals('A', data[4]);
    assertEquals('X', data[3]);
  }

  /**
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  void testRead9() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("AX~XAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ascii85InputStream.read(data, 2, 3));
    assertEquals(8, data.length);
    assertEquals('A', data[4]);
    assertEquals('X', data[3]);
    assertEquals('e', data[2]);
  }

  /**
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  void testRead10() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(-1);
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(is);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ascii85InputStream.read(data, 2, 3);

    // Assert
    verify(is).read();
    assertEquals(0, actualReadResult);
    assertEquals(8, data.length);
    assertEquals('A', data[2]);
    assertEquals('A', data[4]);
    assertEquals('X', data[3]);
  }

  /**
   * Method under test: {@link ASCII85InputStream#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doNothing().when(is).close();

    // Act
    (new ASCII85InputStream(is)).close();

    // Assert
    verify(is).close();
  }

  /**
   * Method under test: {@link ASCII85InputStream#markSupported()}
   */
  @Test
  void testMarkSupported() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse((new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).markSupported());
    assertFalse((new ASCII85InputStream(mock(DataInputStream.class))).markSupported());
  }

  /**
   * Method under test: {@link ASCII85InputStream#skip(long)}
   */
  @Test
  void testSkip() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0L, (new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).skip(42L));
    assertEquals(0L, (new ASCII85InputStream(mock(DataInputStream.class))).skip(42L));
  }

  /**
   * Method under test: {@link ASCII85InputStream#available()}
   */
  @Test
  void testAvailable() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, (new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).available());
    assertEquals(0, (new ASCII85InputStream(mock(DataInputStream.class))).available());
  }

  /**
   * Method under test: {@link ASCII85InputStream#reset()}
   */
  @Test
  void testReset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).reset());
  }
}
