package org.apache.fontbox.type1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Type1ParserDiffblueTest {
  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code A!AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], byte[]); when 'A!AXAXAX' Bytes is 'UTF-8'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.type1.Type1Font Type1Parser.parse(byte[], byte[])"})
  void testParse_whenAAxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new Type1Parser().parse("A!AXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code A!%XAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], byte[]); when 'A!%XAXAX' Bytes is 'UTF-8'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.type1.Type1Font Type1Parser.parse(byte[], byte[])"})
  void testParse_whenAXaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new Type1Parser().parse("A!%XAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code A!(XAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], byte[]); when 'A!(XAXAX' Bytes is 'UTF-8'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.type1.Type1Font Type1Parser.parse(byte[], byte[])"})
  void testParse_whenAXaxaxBytesIsUtf8_thenThrowIOException2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new Type1Parser().parse("A!(XAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[]); when 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.type1.Type1Font Type1Parser.parse(byte[], byte[])"})
  void testParse_whenA_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new Type1Parser()
                .parse(
                    new byte[] {0, '!', 'A', 'X', 'A', 'X', 'A', 'X'},
                    "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.type1.Type1Font Type1Parser.parse(byte[], byte[])"})
  void testParse_whenAxaxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new Type1Parser().parse("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Parser#parse(byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[]); when empty array of byte; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.type1.Type1Font Type1Parser.parse(byte[], byte[])"})
  void testParse_whenEmptyArrayOfByte_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new Type1Parser().parse(new byte[] {}, "AXAXAXAX".getBytes("UTF-8")));
  }
}
