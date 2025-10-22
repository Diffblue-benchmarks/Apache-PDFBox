package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Type1CharStringParserDiffblueTest {
  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>Given A backspace A backspace A backspace A Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; given A backspace A backspace A backspace A Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_givenABackspaceABackspaceABackspaceABytesIsUtf8() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> subrs = new ArrayList<>();
    subrs.add("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    List<Object> actualParseResult = type1CharStringParser.parse(bytes, subrs, "Glyph Name");

    // Assert
    assertEquals(8, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(0)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>Given A backspace A backspace A backspace A Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; given A backspace A backspace A backspace A Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_givenABackspaceABackspaceABackspaceABytesIsUtf82() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> subrs = new ArrayList<>();
    subrs.add("A\bA\bA\bA\b".getBytes("UTF-8"));
    subrs.add("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    List<Object> actualParseResult = type1CharStringParser.parse(bytes, subrs, "Glyph Name");

    // Assert
    assertEquals(8, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(0)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>Then return first intValue is minus seventy-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; then return first intValue is minus seventy-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_thenReturnFirstIntValueIsMinusSeventyFour() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(8, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(0)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>Then return first is {@code RRCURVETO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; then return first is 'RRCURVETO'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
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
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>Then return first is {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; then return first is 'UNKNOWN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_thenReturnFirstIsUnknown() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type1CharStringParser.parse(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(CharStringCommand.UNKNOWN, getResult);
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; then return size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_thenReturnSizeIsFour() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type1CharStringParser.parse(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(4, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(1)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(3)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(2)).intValue());
    assertEquals(1480677441, ((Integer) actualParseResult.get(0)).intValue());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>When {@code AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; when 'AXAXAX' Bytes is 'UTF-8'; then return size is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_whenAxaxaxBytesIsUtf8_thenReturnSizeIsSix() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "\b\nAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name");

    // Assert
    assertEquals(6, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(5)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(4)).intValue());
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>When {@code X XAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; when 'X XAXAX' Bytes is 'UTF-8'; then return size is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
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
    assertEquals(-51, ((Integer) actualParseResult.get(5)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(4)).intValue());
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }

  /**
   * Test {@link Type1CharStringParser#parse(byte[], List, String)} with {@code bytes}, {@code subrs}, {@code glyphName}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return size is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  @DisplayName("Test parse(byte[], List, String) with 'bytes', 'subrs', 'glyphName'; when 'XAXAXAX' Bytes is 'UTF-8'; then return size is seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type1CharStringParser.parse(byte[], List, String)"})
  void testParseWithBytesSubrsGlyphName_whenXaxaxaxBytesIsUtf8_thenReturnSizeIsSeven() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "\fXAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name");

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
