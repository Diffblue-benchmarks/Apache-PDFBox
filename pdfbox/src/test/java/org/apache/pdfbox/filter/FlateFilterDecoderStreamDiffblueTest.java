package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlateFilterDecoderStreamDiffblueTest {
  /**
   * Method under test: {@link FlateFilterDecoderStream#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read());
    assertEquals(0,
        (new FlateFilterDecoderStream(new ByteArrayInputStream(new byte[]{'A', 'X', 3, 'X', 'A', 'X', 'A', 'X'})))
            .read());
    assertEquals(-1, (new FlateFilterDecoderStream(new ByteArrayInputStream(new byte[]{}))).read());
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    when(inputStream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new FlateFilterDecoderStream(inputStream)).read();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, flateFilterDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(
        new ByteArrayInputStream(new byte[]{'A', 'X', 3, 'X', 'A', 'X', 'A', 'X'}));

    // Act and Assert
    assertEquals(0, flateFilterDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(
        new ByteArrayInputStream(new byte[]{'A', 'X', 4, 'X', 'A', 'X', 'A', 'X'}));

    // Act and Assert
    assertEquals(0, flateFilterDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead6() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    when(inputStream.read()).thenReturn(1);
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(inputStream);

    // Act
    int actualReadResult = flateFilterDecoderStream.read("XXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert
    verify(inputStream, atLeast(1)).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  void testRead7() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read()).thenReturn(1);
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(inputStream);

    // Act
    int actualReadResult = flateFilterDecoderStream.read("XXAXAXAX".getBytes("UTF-8"), 2, -1);

    // Assert
    verify(inputStream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read()).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    (new FlateFilterDecoderStream(inputStream)).close();

    // Assert that nothing has changed
    verify(inputStream).close();
    verify(inputStream, atLeast(1)).read();
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#markSupported()}
   */
  @Test
  void testMarkSupported() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).markSupported());
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#markSupported()}
   */
  @Test
  void testMarkSupported2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read()).thenReturn(1);

    // Act
    boolean actualMarkSupportedResult = (new FlateFilterDecoderStream(inputStream)).markSupported();

    // Assert
    verify(inputStream, atLeast(1)).read();
    assertFalse(actualMarkSupportedResult);
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#skip(long)}
   */
  @Test
  void testSkip() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).skip(1L));
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#skip(long)}
   */
  @Test
  void testSkip2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new FlateFilterDecoderStream(inputStream)).skip(1L);

    // Assert
    verify(inputStream, atLeast(1)).read();
    assertEquals(0L, actualSkipResult);
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#available()}
   */
  @Test
  void testAvailable() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).available());
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#available()}
   */
  @Test
  void testAvailable2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read()).thenReturn(1);

    // Act
    int actualAvailableResult = (new FlateFilterDecoderStream(inputStream)).available();

    // Assert
    verify(inputStream, atLeast(1)).read();
    assertEquals(0, actualAvailableResult);
  }

  /**
   * Method under test: {@link FlateFilterDecoderStream#reset()}
   */
  @Test
  void testReset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).reset());
  }

  /**
   * Method under test:
   * {@link FlateFilterDecoderStream#FlateFilterDecoderStream(InputStream)}
   */
  @Test
  void testNewFlateFilterDecoderStream() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    new FlateFilterDecoderStream(inputStream);

    // Assert
    byte[] byteArray = new byte[6];
    assertEquals(6, inputStream.read(byteArray));
    assertArrayEquals("AXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link FlateFilterDecoderStream#FlateFilterDecoderStream(InputStream)}
   */
  @Test
  void testNewFlateFilterDecoderStream2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read()).thenReturn(1);

    // Act
    new FlateFilterDecoderStream(inputStream);

    // Assert
    verify(inputStream, atLeast(1)).read();
  }
}
