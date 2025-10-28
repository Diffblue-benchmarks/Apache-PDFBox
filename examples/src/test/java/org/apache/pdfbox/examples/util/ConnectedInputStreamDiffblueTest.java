package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConnectedInputStreamDiffblueTest {
  /**
   * Method under test: {@link ConnectedInputStream#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    ConnectedInputStream connectedInputStream = new ConnectedInputStream(null,
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(65, connectedInputStream.read());
    byte[] b = new byte[7];
    assertEquals(7, connectedInputStream.read(b));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Method under test: {@link ConnectedInputStream#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(1);

    // Act
    int actualReadResult = (new ConnectedInputStream(null, is)).read();

    // Assert
    verify(is).read();
    assertEquals(1, actualReadResult);
  }

  /**
   * Method under test: {@link ConnectedInputStream#read(byte[])}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    ConnectedInputStream connectedInputStream = new ConnectedInputStream(null,
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    int actualReadResult = connectedInputStream.read("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-1, connectedInputStream.read(new byte[]{}));
    assertEquals(8, actualReadResult);
  }

  /**
   * Method under test: {@link ConnectedInputStream#read(byte[])}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read(Mockito.<byte[]>any())).thenReturn(1);
    ConnectedInputStream connectedInputStream = new ConnectedInputStream(null, is);

    // Act
    int actualReadResult = connectedInputStream.read("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(is).read(isA(byte[].class));
    assertEquals(1, actualReadResult);
  }

  /**
   * Method under test: {@link ConnectedInputStream#read(byte[])}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read(Mockito.<byte[]>any())).thenThrow(new IOException("foo"));
    ConnectedInputStream connectedInputStream = new ConnectedInputStream(null, is);

    // Act and Assert
    assertThrows(IOException.class, () -> connectedInputStream.read("AXAXAXAX".getBytes("UTF-8")));
    verify(is).read(isA(byte[].class));
  }

  /**
   * Method under test: {@link ConnectedInputStream#read(byte[], int, int)}
   */
  @Test
  void testRead6() throws IOException {
    // Arrange
    ConnectedInputStream connectedInputStream = new ConnectedInputStream(null,
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, connectedInputStream.read(b, 1, 3));
    byte[] b2 = new byte[5];
    assertEquals(5, connectedInputStream.read(b2));
    assertEquals(8, b.length);
    assertEquals('A', b[1]);
    assertEquals('A', b[3]);
    assertEquals('X', b[2]);
    assertArrayEquals("XAXAX".getBytes("UTF-8"), b2);
  }

  /**
   * Method under test: {@link ConnectedInputStream#read(byte[], int, int)}
   */
  @Test
  void testRead7() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    ConnectedInputStream connectedInputStream = new ConnectedInputStream(null, is);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = connectedInputStream.read(b, 1, 3);

    // Assert
    verify(is).read(isA(byte[].class), eq(1), eq(3));
    assertEquals(1, actualReadResult);
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('X', b[1]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link ConnectedInputStream#read(byte[], int, int)}
   */
  @Test
  void testRead8() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    ConnectedInputStream connectedInputStream = new ConnectedInputStream(null, is);

    // Act and Assert
    assertThrows(IOException.class, () -> connectedInputStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
    verify(is).read(isA(byte[].class), eq(1), eq(3));
  }

  /**
   * Method under test: {@link ConnectedInputStream#skip(long)}
   */
  @Test
  void testSkip() throws IOException {
    // Arrange
    ConnectedInputStream connectedInputStream = new ConnectedInputStream(null,
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(1L, connectedInputStream.skip(1L));
    byte[] b = new byte[7];
    assertEquals(7, connectedInputStream.read(b));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Method under test: {@link ConnectedInputStream#skip(long)}
   */
  @Test
  void testSkip2() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.skip(anyLong())).thenReturn(1L);

    // Act
    long actualSkipResult = (new ConnectedInputStream(null, is)).skip(1L);

    // Assert
    verify(is).skip(eq(1L));
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test: {@link ConnectedInputStream#available()}
   */
  @Test
  void testAvailable() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8,
        (new ConnectedInputStream(null, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).available());
  }

  /**
   * Method under test: {@link ConnectedInputStream#available()}
   */
  @Test
  void testAvailable2() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.available()).thenReturn(1);

    // Act
    int actualAvailableResult = (new ConnectedInputStream(null, is)).available();

    // Assert
    verify(is).available();
    assertEquals(1, actualAvailableResult);
  }

  /**
   * Method under test: {@link ConnectedInputStream#mark(int)}
   */
  @Test
  void testMark() {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doNothing().when(is).mark(anyInt());

    // Act
    (new ConnectedInputStream(null, is)).mark(1);

    // Assert that nothing has changed
    verify(is).mark(eq(1));
  }

  /**
   * Method under test: {@link ConnectedInputStream#reset()}
   */
  @Test
  void testReset() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doNothing().when(is).reset();

    // Act
    (new ConnectedInputStream(null, is)).reset();

    // Assert that nothing has changed
    verify(is).reset();
  }

  /**
   * Method under test: {@link ConnectedInputStream#markSupported()}
   */
  @Test
  void testMarkSupported() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        (new ConnectedInputStream(null, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).markSupported());
  }

  /**
   * Method under test: {@link ConnectedInputStream#markSupported()}
   */
  @Test
  void testMarkSupported2() {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.markSupported()).thenReturn(true);

    // Act
    boolean actualMarkSupportedResult = (new ConnectedInputStream(null, is)).markSupported();

    // Assert
    verify(is).markSupported();
    assertTrue(actualMarkSupportedResult);
  }

  /**
   * Method under test: {@link ConnectedInputStream#markSupported()}
   */
  @Test
  void testMarkSupported3() {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.markSupported()).thenReturn(false);

    // Act
    boolean actualMarkSupportedResult = (new ConnectedInputStream(null, is)).markSupported();

    // Assert
    verify(is).markSupported();
    assertFalse(actualMarkSupportedResult);
  }

  /**
   * Method under test:
   * {@link ConnectedInputStream#ConnectedInputStream(HttpURLConnection, InputStream)}
   */
  @Test
  void testNewConnectedInputStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8,
        (new ConnectedInputStream(null, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read(new byte[8]));
  }
}
