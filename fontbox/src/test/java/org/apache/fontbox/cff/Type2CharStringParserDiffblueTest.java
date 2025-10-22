package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Type2CharStringParserDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Type2CharStringParser#Type2CharStringParser(String)}
   *   <li>{@link Type2CharStringParser#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type2CharStringParser.<init>(String)", "String Type2CharStringParser.toString()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Font Name", (new Type2CharStringParser("Font Name")).toString());
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and one.</li>
   *   <li>Then second return {@link CharStringCommand}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); when array of byte with 'A' and one; then second return CharStringCommand")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenArrayOfByteWithAAndOne_thenSecondReturnCharStringCommand() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{'A', 1, 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(1);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-74, ((Integer) actualParseResult.get(0)).intValue());
    assertEquals(CharStringCommand.HSTEM, getResult);
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   * <ul>
   *   <li>When array of {@code byte} with backspace and one.</li>
   *   <li>Then second return {@link CharStringCommand}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); when array of byte with backspace and one; then second return CharStringCommand")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenArrayOfByteWithBackspaceAndOne_thenSecondReturnCharStringCommand() throws IOException {
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
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); when array of byte with minus one and 'X'; then return size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenArrayOfByteWithMinusOneAndX_thenReturnSizeIsFour() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(4, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(1)).intValue());
    assertEquals(22593.344747081712d, ((Double) actualParseResult.get(0)).doubleValue());
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.</li>
   *   <li>Then return first is {@code HSTEM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); when array of byte with one and 'X'; then return first is 'HSTEM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenArrayOfByteWithOneAndX_thenReturnFirstIsHstem() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(CharStringCommand.HSTEM, getResult);
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   * <ul>
   *   <li>When array of {@code byte} with thirty-one and {@code X}.</li>
   *   <li>Then return first is {@code HVCURVETO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); when array of byte with thirty-one and 'X'; then return first is 'HVCURVETO'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenArrayOfByteWithThirtyOneAndX_thenReturnFirstIsHvcurveto() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{31, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(CharStringCommand.HVCURVETO, getResult);
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-eight and {@code X}.</li>
   *   <li>Then return size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); when array of byte with twenty-eight and 'X'; then return size is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenArrayOfByteWithTwentyEightAndX_thenReturnSizeIsSix() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{28, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(6, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(1)).intValue());
    assertEquals(22593, ((Integer) actualParseResult.get(0)).intValue());
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then return first is {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); when array of byte with zero and 'X'; then return first is 'UNKNOWN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenArrayOfByteWithZeroAndX_thenReturnFirstIsUnknown() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(CharStringCommand.UNKNOWN, getResult);
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return first intValue is minus seventy-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return first intValue is minus seventy-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenAxaxaxaxBytesIsUtf8_thenReturnFirstIntValueIsMinusSeventyFour() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(bytes, new byte[][]{"AXAXAXAX".getBytes("UTF-8")},
        new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(0)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   * <ul>
   *   <li>When empty 2D array of {@code byte}.</li>
   *   <li>Then return size is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); when empty 2D array of byte; then return size is seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenEmpty2dArrayOfByte_thenReturnSizeIsSeven() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");
    byte[] bytes = "\b\nAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(bytes, new byte[][]{"AXAXAXAX".getBytes("UTF-8")},
        new byte[][]{});

    // Assert
    assertEquals(7, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(2)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(4)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(1)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(3)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(5)).intValue());
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return size is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); when 'null'; then return size is seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenNull_thenReturnSizeIsSeven() throws IOException {
    // Arrange
    Type2CharStringParser type2CharStringParser = new Type2CharStringParser("Font Name");
    byte[] bytes = "\b\nAXAXAX".getBytes("UTF-8");

    // Act
    List<Object> actualParseResult = type2CharStringParser.parse(bytes, new byte[][]{"AXAXAXAX".getBytes("UTF-8")},
        null);

    // Assert
    assertEquals(7, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(2)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(4)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(1)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(3)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(5)).intValue());
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return first is {@code RRCURVETO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); when 'XAXAXAX' Bytes is 'UTF-8'; then return first is 'RRCURVETO'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenXaxaxaxBytesIsUtf8_thenReturnFirstIsRrcurveto() throws IOException {
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
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(CharStringCommand.RRCURVETO, getResult);
  }
}
