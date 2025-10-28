package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

class Type2CharStringParserDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Type2CharStringParser#Type2CharStringParser(String)}
   *   <li>{@link Type2CharStringParser#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Font Name", (new Type2CharStringParser("Font Name")).toString());
  }

  /**
   * Method under test:
   * {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  void testParse() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(8,
        type2CharStringParser
            .parse(bytes, new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")})
            .size());
  }

  /**
   * Method under test:
   * {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  void testParse2() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");
    byte[] bytes = "\bXAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(bytes, new byte[][]{"AXAXAXAX".getBytes("UTF-8")},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }

  /**
   * Method under test:
   * {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  void testParse3() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(CharStringCommand.HSTEM, getResult);
  }

  /**
   * Method under test:
   * {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  void testParse4() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(4, actualParseResult.size());
    assertEquals(22593.344747081712d, ((Double) actualParseResult.get(0)).doubleValue());
  }

  /**
   * Method under test:
   * {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  void testParse5() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(CharStringCommand.UNKNOWN, getResult);
  }

  /**
   * Method under test:
   * {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  void testParse6() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{31, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(CharStringCommand.HVCURVETO, getResult);
  }

  /**
   * Method under test:
   * {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  void testParse7() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{'A', 1, 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(1);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(CharStringCommand.HSTEM, getResult);
  }

  /**
   * Method under test:
   * {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  void testParse8() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act and Assert
    assertEquals(6,
        type2CharStringParser
            .parse(new byte[]{28, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")},
                new byte[][]{"AXAXAXAX".getBytes("UTF-8")})
            .size());
  }

  /**
   * Method under test:
   * {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  void testParse9() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{'\b', 1, 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    Object getResult2 = actualParseResult.get(1);
    assertTrue(getResult2 instanceof CharStringCommand);
    assertEquals(CharStringCommand.HSTEM, getResult2);
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }

  /**
   * Method under test:
   * {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  void testParse10() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");
    byte[] bytes = "\b\nAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(bytes, new byte[][]{"AXAXAXAX".getBytes("UTF-8")},
        null);

    // Assert
    assertEquals(7, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }

  /**
   * Method under test:
   * {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  void testParse11() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");
    byte[] bytes = "\b\nAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(bytes, new byte[][]{"AXAXAXAX".getBytes("UTF-8")},
        new byte[][]{});

    // Assert
    assertEquals(7, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }
}
