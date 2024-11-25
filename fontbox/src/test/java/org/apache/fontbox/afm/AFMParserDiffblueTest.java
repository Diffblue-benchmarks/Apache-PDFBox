package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AFMParserDiffblueTest {
  /**
   * Test {@link AFMParser#parse(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AFMParser#parse(boolean)}
   */
  @Test
  @DisplayName("Test parse(boolean) with 'boolean'; given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'")
  void testParseWithBoolean_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("A\tAXAXAX".getBytes("UTF-8")))).parse(true));
  }

  /**
   * Test {@link AFMParser#parse(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AFMParser#parse(boolean)}
   */
  @Test
  @DisplayName("Test parse(boolean) with 'boolean'; given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testParseWithBoolean_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).parse(true));
  }

  /**
   * Test {@link AFMParser#parse(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AFMParser#parse(boolean)}
   */
  @Test
  @DisplayName("Test parse(boolean) with 'boolean'; given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  void testParseWithBoolean_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("\tXAXAXAX".getBytes("UTF-8")))).parse(true));
  }

  /**
   * Test {@link AFMParser#parse()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AFMParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'; then throw IOException")
  void testParse_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("A\tAXAXAX".getBytes("UTF-8")))).parse());
  }

  /**
   * Test {@link AFMParser#parse()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AFMParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then throw IOException")
  void testParse_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).parse());
  }

  /**
   * Test {@link AFMParser#parse()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AFMParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'; then throw IOException")
  void testParse_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("\tXAXAXAX".getBytes("UTF-8")))).parse());
  }
}
