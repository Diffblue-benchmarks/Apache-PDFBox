package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class Type1CharStringParserDiffblueTest {
  /**
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  void testParse() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(8, type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name").size());
  }

  /**
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  void testParse2() throws IOException {
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
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  void testParse3() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");

    // Act and Assert
    assertEquals(4,
        type1CharStringParser.parse(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, new ArrayList<>(), "Glyph Name")
            .size());
  }

  /**
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  void testParse4() throws IOException {
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
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  void testParse5() throws IOException {
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

  /**
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  void testParse6() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> subrs = new ArrayList<>();
    subrs.add("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(8, type1CharStringParser.parse(bytes, subrs, "Glyph Name").size());
  }

  /**
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  void testParse7() throws IOException {
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
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  void testParse8() throws IOException {
    // Arrange
    Type1CharStringParser type1CharStringParser = new Type1CharStringParser("Font Name");
    byte[] bytes = "\b\nAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(6, type1CharStringParser.parse(bytes, new ArrayList<>(), "Glyph Name").size());
  }

  /**
   * Method under test: {@link Type1CharStringParser#parse(byte[], List, String)}
   */
  @Test
  void testParse9() throws IOException {
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
}
