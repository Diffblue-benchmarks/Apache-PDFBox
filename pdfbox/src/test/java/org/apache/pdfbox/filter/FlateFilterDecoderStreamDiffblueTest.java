package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FlateFilterDecoderStreamDiffblueTest {
  /**
   * Test {@link FlateFilterDecoderStream#FlateFilterDecoderStream(InputStream)}.
   * <p>
   * Method under test:
   * {@link FlateFilterDecoderStream#FlateFilterDecoderStream(InputStream)}
   */
  @Test
  @DisplayName("Test new FlateFilterDecoderStream(InputStream)")
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
   * Test {@link FlateFilterDecoderStream#read(byte[], int, int)} with
   * {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testReadWithByteIntInt_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, flateFilterDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link FlateFilterDecoderStream#read(byte[], int, int)} with
   * {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>When three.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given 'X'; when three; then return zero")
  void testReadWithByteIntInt_givenX_whenThree_thenReturnZero() throws IOException {
    // Arrange
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(
        new ByteArrayInputStream(new byte[]{'A', 'X', 3, 'X', 'A', 'X', 'A', 'X'}));

    // Act and Assert
    assertEquals(0, flateFilterDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link FlateFilterDecoderStream#read(byte[], int, int)} with
   * {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>When three.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given 'X'; when three; then return zero")
  void testReadWithByteIntInt_givenX_whenThree_thenReturnZero2() throws IOException {
    // Arrange
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(
        new ByteArrayInputStream(new byte[]{'A', 'X', 4, 'X', 'A', 'X', 'A', 'X'}));

    // Act and Assert
    assertEquals(0, flateFilterDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link FlateFilterDecoderStream#read(byte[], int, int)} with
   * {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; when minus one")
  void testReadWithByteIntInt_whenMinusOne() throws IOException {
    // Arrange
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, flateFilterDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, -1));
  }

  /**
   * Test {@link FlateFilterDecoderStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return minus one")
  void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link FlateFilterDecoderStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with empty array of byte; then return minus one")
  void testRead_givenByteArrayInputStreamWithEmptyArrayOfByte_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new FlateFilterDecoderStream(new ByteArrayInputStream(new byte[]{}))).read());
  }

  /**
   * Test {@link FlateFilterDecoderStream#read()}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); given 'X'; then return zero")
  void testRead_givenX_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new FlateFilterDecoderStream(new ByteArrayInputStream(new byte[]{'A', 'X', 3, 'X', 'A', 'X', 'A', 'X'})))
            .read());
  }

  /**
   * Test {@link FlateFilterDecoderStream#markSupported()}.
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#markSupported()}
   */
  @Test
  @DisplayName("Test markSupported()")
  void testMarkSupported() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).markSupported());
  }

  /**
   * Test {@link FlateFilterDecoderStream#skip(long)}.
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  void testSkip() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).skip(1L));
  }

  /**
   * Test {@link FlateFilterDecoderStream#available()}.
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#available()}
   */
  @Test
  @DisplayName("Test available()")
  void testAvailable() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).available());
  }

  /**
   * Test {@link FlateFilterDecoderStream#reset()}.
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#reset()}
   */
  @Test
  @DisplayName("Test reset()")
  void testReset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).reset());
  }
}
