package org.apache.fontbox.pfb;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PfbParserDiffblueTest {
  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   * <p>
   * Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName("Test new PfbParser(InputStream)")
  void testNewPfbParser() throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{Byte.MIN_VALUE, 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3,
        'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    PfbParser actualPfbParser = new PfbParser(in);

    // Assert
    assertEquals(-1, in.read(new byte[]{}));
    assertEquals(-1, actualPfbParser.getInputStream().read(new byte[]{}));
    assertEquals(0, actualPfbParser.size());
    assertEquals(0, actualPfbParser.getPfbdata().length);
    assertEquals(0, actualPfbParser.getSegment1().length);
    assertEquals(0, actualPfbParser.getSegment2().length);
    assertArrayEquals(new int[]{0, 0, 0}, actualPfbParser.getLengths());
  }

  /**
   * Test {@link PfbParser#PfbParser(byte[])}.
   * <ul>
   *   <li>Then return InputStream read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PfbParser#PfbParser(byte[])}
   */
  @Test
  @DisplayName("Test new PfbParser(byte[]); then return InputStream read is minus one")
  void testNewPfbParser_thenReturnInputStreamReadIsMinusOne() throws IOException {
    // Arrange and Act
    PfbParser actualPfbParser = new PfbParser(new byte[]{Byte.MIN_VALUE, 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A',
        3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Assert
    assertEquals(-1, actualPfbParser.getInputStream().read(new byte[]{}));
    assertEquals(0, actualPfbParser.size());
    assertEquals(0, actualPfbParser.getPfbdata().length);
    assertEquals(0, actualPfbParser.getSegment1().length);
    assertEquals(0, actualPfbParser.getSegment2().length);
    assertArrayEquals(new int[]{0, 0, 0}, actualPfbParser.getLengths());
  }

  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   * <ul>
   *   <li>Then throw {@link EOFException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName("Test new PfbParser(InputStream); then throw EOFException")
  void testNewPfbParser_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(EOFException.class, () -> new PfbParser(new ByteArrayInputStream(new byte[]{Byte.MIN_VALUE, 1, 'A', 3,
        'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3})));
  }

  /**
   * Test {@link PfbParser#PfbParser(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and three.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PfbParser#PfbParser(byte[])}
   */
  @Test
  @DisplayName("Test new PfbParser(byte[]); when array of byte with 'A' and three; then throw IOException")
  void testNewPfbParser_whenArrayOfByteWithAAndThree_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PfbParser(
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3}));
  }

  /**
   * Test {@link PfbParser#PfbParser(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and
   * {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PfbParser#PfbParser(byte[])}
   */
  @Test
  @DisplayName("Test new PfbParser(byte[]); when array of byte with MIN_VALUE and 'A'; then throw IOException")
  void testNewPfbParser_whenArrayOfByteWithMin_valueAndA_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PfbParser(new byte[]{Byte.MIN_VALUE, 'A', 'A', 3, 'A', 3, 'A', 3, 'A', 3,
        'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3}));
  }

  /**
   * Test {@link PfbParser#PfbParser(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and one.</li>
   *   <li>Then throw {@link EOFException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PfbParser#PfbParser(byte[])}
   */
  @Test
  @DisplayName("Test new PfbParser(byte[]); when array of byte with MIN_VALUE and one; then throw EOFException")
  void testNewPfbParser_whenArrayOfByteWithMin_valueAndOne_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(EOFException.class, () -> new PfbParser(new byte[]{Byte.MIN_VALUE, 1, 'A', 3, 'A', 3, 'A', 3, 'A', 3,
        'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3}));
  }

  /**
   * Test {@link PfbParser#PfbParser(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PfbParser#PfbParser(byte[])}
   */
  @Test
  @DisplayName("Test new PfbParser(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IOException")
  void testNewPfbParser_whenAxaxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PfbParser("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array
   * of {@code byte} with {@code A} and three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName("Test new PfbParser(InputStream); when ByteArrayInputStream(byte[]) with array of byte with 'A' and three")
  void testNewPfbParser_whenByteArrayInputStreamWithArrayOfByteWithAAndThree() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PfbParser(new ByteArrayInputStream(
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3})));
  }

  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array
   * of {@code byte} with {@link Byte#MIN_VALUE} and {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName("Test new PfbParser(InputStream); when ByteArrayInputStream(byte[]) with array of byte with MIN_VALUE and 'A'")
  void testNewPfbParser_whenByteArrayInputStreamWithArrayOfByteWithMin_valueAndA() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PfbParser(new ByteArrayInputStream(new byte[]{Byte.MIN_VALUE, 'A', 'A', 3,
        'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3})));
  }

  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName("Test new PfbParser(InputStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testNewPfbParser_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PfbParser(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }
}
