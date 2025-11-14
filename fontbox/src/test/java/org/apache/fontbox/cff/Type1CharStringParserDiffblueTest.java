package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Type1CharStringParserDiffblueTest {
  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code
   * subrs}, {@code glyphName}.
   *
   * <p>Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "A\b\n\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult =
        type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(14, actualParseResult.size());
    Object getResult = actualParseResult.get(9);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-74, ((Integer) actualParseResult.get(8)).intValue());
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code
   * subrs}, {@code glyphName}.
   *
   * <p>Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName2() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "A\bA\nA\bA\bA\bA\bA\bA\b".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult =
        type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(14, actualParseResult.size());
    Object getResult = actualParseResult.get(9);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-74, ((Integer) actualParseResult.get(8)).intValue());
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code
   * subrs}, {@code glyphName}.
   *
   * <ul>
   *   <li>Then first return {@link CharStringCommand}.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; then first return CharStringCommand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_thenFirstReturnCharStringCommand() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult =
        type1CharStringParser.parse(
            new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-51, ((Integer) actualParseResult.get(5)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(CharStringCommand.UNKNOWN, getResult);
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code
   * subrs}, {@code glyphName}.
   *
   * <ul>
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_thenReturnSize() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult =
        type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(Short.SIZE, actualParseResult.size());
    Object getResult = actualParseResult.get(15);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-74, ((Integer) actualParseResult.get(14)).intValue());
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code
   * subrs}, {@code glyphName}.
   *
   * <ul>
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_thenReturnSizeIsFour() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult =
        type1CharStringParser.parse(
            new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(4, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(1)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(3)).intValue());
    assertEquals(1480677441, ((Integer) actualParseResult.get(0)).intValue());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code
   * subrs}, {@code glyphName}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return size is eight.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return size is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_whenAxaxaxaxBytesIsUtf8_thenReturnSizeIsEight()
      throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult =
        type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(8, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(5)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code
   * subrs}, {@code glyphName}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return size is seven.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; when 'XAXAXAX' Bytes is 'UTF-8'; then return size is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_whenXaxaxaxBytesIsUtf8_thenReturnSizeIsSeven()
      throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "\fXAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult =
        type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(7, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(2)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(4)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(1)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(3)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(5)).intValue());
  }
}
