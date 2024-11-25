package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Type1CharStringParserDiffblueTest {
  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with
   * {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>Given A backspace A backspace A backspace A Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; given A backspace A backspace A backspace A Bytes is 'UTF-8'")
  void testParseWithBytesSubrsGlyphName_givenABackspaceABackspaceABackspaceABytesIsUtf8() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> subrs = new ArrayList<>();
    subrs.add("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(8, type1CharStringParser.parse(bytes, subrs, "Glyph Name").size());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with
   * {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>Given A backspace A backspace A backspace A Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; given A backspace A backspace A backspace A Bytes is 'UTF-8'")
  void testParseWithBytesSubrsGlyphName_givenABackspaceABackspaceABackspaceABytesIsUtf82() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> subrs = new ArrayList<>();
    subrs.add("A\bA\bA\bA\b".getBytes("UTF-8"));
    subrs.add("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(8, type1CharStringParser.parse(bytes, subrs, "Glyph Name").size());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with
   * {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>Then return first is {@code RRCURVETO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; then return first is 'RRCURVETO'")
  void testParseWithBytesSubrsGlyphName_thenReturnFirstIsRrcurveto() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "\bXAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with
   * {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; then return size is four")
  void testParseWithBytesSubrsGlyphName_thenReturnSizeIsFour() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");

    // Act and Assert
    assertEquals(4,
        type1CharStringParser.parse(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, new ArrayList<>(), "Glyph Name")
            .size());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with
   * {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; when array of byte with zero and 'X'")
  void testParseWithBytesSubrsGlyphName_whenArrayOfByteWithZeroAndX() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type1CharStringParser.parse(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(CharStringCommand.UNKNOWN, getResult);
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with
   * {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>When {@code AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; when 'AXAXAX' Bytes is 'UTF-8'; then return size is six")
  void testParseWithBytesSubrsGlyphName_whenAxaxaxBytesIsUtf8_thenReturnSizeIsSix() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "\b\nAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(6, type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name").size());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with
   * {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return size is eight")
  void testParseWithBytesSubrsGlyphName_whenAxaxaxaxBytesIsUtf8_thenReturnSizeIsEight() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(8, type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name").size());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with
   * {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>When {@code X XAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; when 'X XAXAX' Bytes is 'UTF-8'; then return size is six")
  void testParseWithBytesSubrsGlyphName_whenXXaxaxBytesIsUtf8_thenReturnSizeIsSix() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "\bX\nXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(6, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with
   * {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return size is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; when 'XAXAXAX' Bytes is 'UTF-8'; then return size is seven")
  void testParseWithBytesSubrsGlyphName_whenXaxaxaxBytesIsUtf8_thenReturnSizeIsSeven() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "\fXAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(7, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(CharStringCommand.UNKNOWN, getResult);
  }
}
