package org.apache.fontbox.type1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Type1ParserDiffblueTest {
  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   * <ul>
   *   <li>When {@code A!AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[]); when 'A!AXAXAX' Bytes is 'UTF-8'; then throw IOException")
  void testParse_whenAAxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "A!AXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   * <ul>
   *   <li>When {@code A!%XAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[]); when 'A!%XAXAX' Bytes is 'UTF-8'; then throw IOException")
  void testParse_whenAXaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "A!%XAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   * <ul>
   *   <li>When {@code A!(XAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[]); when 'A!(XAXAX' Bytes is 'UTF-8'; then throw IOException")
  void testParse_whenAXaxaxBytesIsUtf8_thenThrowIOException2() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "A!(XAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[]); when 'A'; then throw IOException")
  void testParse_whenA_thenThrowIOException() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();

    // Act and Assert
    assertThrows(IOException.class,
        () -> type1Parser.parse(new byte[]{0, '!', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   * <ul>
   *   <li>When {@code [!AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[]); when '[!AXAXAX' Bytes is 'UTF-8'; then throw IOException")
  void testParse_whenAxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "[!AXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   * <ul>
   *   <li>When {@code !AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[]); when '!AXAXAX' Bytes is 'UTF-8'; then throw IOException")
  void testParse_whenAxaxaxBytesIsUtf8_thenThrowIOException2() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "\t!AXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IOException")
  void testParse_whenAxaxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[]); when empty array of byte; then throw IOException")
  void testParse_whenEmptyArrayOfByte_thenThrowIOException() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   * <ul>
   *   <li>When {@code [}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[]); when '['; then throw IOException")
  void testParse_whenLeftSquareBracket_thenThrowIOException() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();

    // Act and Assert
    assertThrows(IOException.class,
        () -> type1Parser.parse(new byte[]{0, '!', '[', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8")));
  }
}
