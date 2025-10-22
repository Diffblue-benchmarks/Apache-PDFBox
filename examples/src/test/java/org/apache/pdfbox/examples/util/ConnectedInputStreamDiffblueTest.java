package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConnectedInputStreamDiffblueTest {
  /**
   * Test {@link ConnectedInputStream#ConnectedInputStream(HttpURLConnection, InputStream)}.
   * <p>
   * Method under test: {@link ConnectedInputStream#ConnectedInputStream(HttpURLConnection, InputStream)}
   */
  @Test
  @DisplayName("Test new ConnectedInputStream(HttpURLConnection, InputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConnectedInputStream.<init>(HttpURLConnection, InputStream)"})
  void testNewConnectedInputStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8,
        (new ConnectedInputStream(null, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read(new byte[8]));
  }

  /**
   * Test {@link ConnectedInputStream#read(byte[])} with {@code b}.
   * <p>
   * Method under test: {@link ConnectedInputStream#read(byte[])}
   */
  @Test
  @DisplayName("Test read(byte[]) with 'b'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConnectedInputStream.read(byte[])"})
  void testReadWithB() throws IOException {
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
   * Test {@link ConnectedInputStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code len}.
   * <ul>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectedInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConnectedInputStream.read(byte[], int, int)"})
  void testReadWithBOffLen_thenReturnThree() throws IOException {
    // Arrange
    ConnectedInputStream connectedInputStream = new ConnectedInputStream(null,
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, connectedInputStream.read(b, 1, 3));
    byte[] b2 = new byte[5];
    assertEquals(5, connectedInputStream.read(b2));
    assertArrayEquals("AAXAAXAX".getBytes("UTF-8"), b);
    assertArrayEquals("XAXAX".getBytes("UTF-8"), b2);
  }

  /**
   * Test {@link ConnectedInputStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code len}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectedInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConnectedInputStream.read(byte[], int, int)"})
  void testReadWithBOffLen_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    ConnectedInputStream connectedInputStream = new ConnectedInputStream(null, is);

    // Act and Assert
    assertThrows(IOException.class, () -> connectedInputStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
    verify(is).read(isA(byte[].class), eq(1), eq(3));
  }

  /**
   * Test {@link ConnectedInputStream#read(byte[])} with {@code b}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectedInputStream#read(byte[])}
   */
  @Test
  @DisplayName("Test read(byte[]) with 'b'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConnectedInputStream.read(byte[])"})
  void testReadWithB_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read(Mockito.<byte[]>any())).thenThrow(new IOException("foo"));
    ConnectedInputStream connectedInputStream = new ConnectedInputStream(null, is);

    // Act and Assert
    assertThrows(IOException.class, () -> connectedInputStream.read("AXAXAXAX".getBytes("UTF-8")));
    verify(is).read(isA(byte[].class));
  }

  /**
   * Test {@link ConnectedInputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectedInputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConnectedInputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws IOException {
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
   * Test {@link ConnectedInputStream#skip(long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectedInputStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long ConnectedInputStream.skip(long)"})
  void testSkip_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnOne() throws IOException {
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
   * Test {@link ConnectedInputStream#available()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectedInputStream#available()}
   */
  @Test
  @DisplayName("Test available(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConnectedInputStream.available()"})
  void testAvailable_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnEight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8,
        (new ConnectedInputStream(null, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).available());
  }

  /**
   * Test {@link ConnectedInputStream#markSupported()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#markSupported()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectedInputStream#markSupported()}
   */
  @Test
  @DisplayName("Test markSupported(); given DataInputStream markSupported() return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ConnectedInputStream.markSupported()"})
  void testMarkSupported_givenDataInputStreamMarkSupportedReturnFalse_thenReturnFalse() {
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
   * Test {@link ConnectedInputStream#markSupported()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectedInputStream#markSupported()}
   */
  @Test
  @DisplayName("Test markSupported(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ConnectedInputStream.markSupported()"})
  void testMarkSupported_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        (new ConnectedInputStream(null, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).markSupported());
  }
}
