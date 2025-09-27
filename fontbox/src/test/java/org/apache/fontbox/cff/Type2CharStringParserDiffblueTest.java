package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Type2CharStringParserDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Type2CharStringParser#Type2CharStringParser(String)}
   *   <li>{@link Type2CharStringParser#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type2CharStringParser.<init>(String)",
    "String Type2CharStringParser.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Font Name", new Type2CharStringParser("Font Name").toString());
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   *
   * <p>Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult =
        new Type2CharStringParser("Font Name")
            .parse(
                "A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"),
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")},
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(Short.SIZE, actualParseResult.size());
    Object getResult = actualParseResult.get(11);
    assertTrue(getResult instanceof CharStringCommand);
    Object getResult2 = actualParseResult.get(13);
    assertTrue(getResult2 instanceof CharStringCommand);
    Object getResult3 = actualParseResult.get(15);
    assertTrue(getResult3 instanceof CharStringCommand);
    Object getResult4 = actualParseResult.get(3);
    assertTrue(getResult4 instanceof CharStringCommand);
    Object getResult5 = actualParseResult.get(5);
    assertTrue(getResult5 instanceof CharStringCommand);
    assertEquals(-74, ((Integer) actualParseResult.get(10)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(12)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(14)).intValue());
    assertEquals(CharStringCommand.RRCURVETO, getResult);
    assertEquals(CharStringCommand.RRCURVETO, getResult2);
    assertEquals(CharStringCommand.RRCURVETO, getResult3);
    assertEquals(CharStringCommand.RRCURVETO, getResult4);
    assertEquals(CharStringCommand.RRCURVETO, getResult5);
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   *
   * <ul>
   *   <li>Then return size is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName("Test parse(byte[], byte[][], byte[][]); then return size is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_thenReturnSizeIsFifteen() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult =
        new Type2CharStringParser("Font Name")
            .parse(
                "A\b\n\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"),
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")},
                null);

    // Assert
    assertEquals(15, actualParseResult.size());
    Object getResult = actualParseResult.get(10);
    assertTrue(getResult instanceof CharStringCommand);
    Object getResult2 = actualParseResult.get(12);
    assertTrue(getResult2 instanceof CharStringCommand);
    Object getResult3 = actualParseResult.get(14);
    assertTrue(getResult3 instanceof CharStringCommand);
    Object getResult4 = actualParseResult.get(2);
    assertTrue(getResult4 instanceof CharStringCommand);
    Object getResult5 = actualParseResult.get(4);
    assertTrue(getResult5 instanceof CharStringCommand);
    assertEquals(-74, ((Integer) actualParseResult.get(11)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(13)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(3)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(5)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(9)).intValue());
    assertEquals(CharStringCommand.RRCURVETO, getResult);
    assertEquals(CharStringCommand.RRCURVETO, getResult2);
    assertEquals(CharStringCommand.RRCURVETO, getResult3);
    assertEquals(CharStringCommand.RRCURVETO, getResult4);
    assertEquals(CharStringCommand.RRCURVETO, getResult5);
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and one.
   *   <li>Then second return {@link CharStringCommand}.
   * </ul>
   *
   * <p>Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], byte[][], byte[][]); when array of byte with 'A' and one; then second return CharStringCommand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenArrayOfByteWithAAndOne_thenSecondReturnCharStringCommand() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult =
        new Type2CharStringParser("Font Name")
            .parse(
                new byte[] {'A', 1, 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")},
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(1);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-51, ((Integer) actualParseResult.get(5)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(CharStringCommand.HSTEM, getResult);
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], byte[][], byte[][]); when array of byte with minus one and 'X'; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenArrayOfByteWithMinusOneAndX_thenReturnSizeIsFour() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult =
        new Type2CharStringParser("Font Name")
            .parse(
                new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")},
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(4, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(1)).intValue());
    assertEquals(22593.344747081712d, ((Double) actualParseResult.get(0)).doubleValue());
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.
   *   <li>Then return first is {@code HSTEM}.
   * </ul>
   *
   * <p>Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], byte[][], byte[][]); when array of byte with one and 'X'; then return first is 'HSTEM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenArrayOfByteWithOneAndX_thenReturnFirstIsHstem() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult =
        new Type2CharStringParser("Font Name")
            .parse(
                new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")},
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-51, ((Integer) actualParseResult.get(1)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(5)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(CharStringCommand.HSTEM, getResult);
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return first is {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], byte[][], byte[][]); when array of byte with zero and 'X'; then return first is 'UNKNOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenArrayOfByteWithZeroAndX_thenReturnFirstIsUnknown() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult =
        new Type2CharStringParser("Font Name")
            .parse(
                new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")},
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof CharStringCommand);
    assertEquals(-51, ((Integer) actualParseResult.get(1)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(5)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
    assertEquals(CharStringCommand.UNKNOWN, getResult);
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return size is eight.
   * </ul>
   *
   * <p>Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], byte[][], byte[][]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return size is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenAxaxaxaxBytesIsUtf8_thenReturnSizeIsEight() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult =
        new Type2CharStringParser("Font Name")
            .parse(
                "AXAXAXAX".getBytes("UTF-8"),
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")},
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(8, actualParseResult.size());
    assertEquals(-51, ((Integer) actualParseResult.get(1)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(5)).intValue());
    assertEquals(-51, ((Integer) actualParseResult.get(7)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(6)).intValue());
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then return third is {@code HSTEM}.
   * </ul>
   *
   * <p>Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], byte[][], byte[][]); when backspace; then return third is 'HSTEM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenBackspace_thenReturnThirdIsHstem() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult =
        new Type2CharStringParser("Font Name")
            .parse(
                new byte[] {
                  'A', '\b', 1, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                },
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")},
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(Short.SIZE, actualParseResult.size());
    Object getResult = actualParseResult.get(11);
    assertTrue(getResult instanceof CharStringCommand);
    Object getResult2 = actualParseResult.get(13);
    assertTrue(getResult2 instanceof CharStringCommand);
    Object getResult3 = actualParseResult.get(15);
    assertTrue(getResult3 instanceof CharStringCommand);
    Object getResult4 = actualParseResult.get(2);
    assertTrue(getResult4 instanceof CharStringCommand);
    Object getResult5 = actualParseResult.get(3);
    assertTrue(getResult5 instanceof CharStringCommand);
    Object getResult6 = actualParseResult.get(5);
    assertTrue(getResult6 instanceof CharStringCommand);
    assertEquals(-74, ((Integer) actualParseResult.get(10)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(12)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(14)).intValue());
    assertEquals(CharStringCommand.HSTEM, getResult4);
    assertEquals(CharStringCommand.RRCURVETO, getResult);
    assertEquals(CharStringCommand.RRCURVETO, getResult2);
    assertEquals(CharStringCommand.RRCURVETO, getResult3);
    assertEquals(CharStringCommand.RRCURVETO, getResult5);
    assertEquals(CharStringCommand.RRCURVETO, getResult6);
  }

  /**
   * Test {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}.
   *
   * <ul>
   *   <li>When empty 2D array of {@code byte}.
   *   <li>Then return size is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link Type2CharStringParser#parse(byte[], byte[][], byte[][])}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], byte[][], byte[][]); when empty 2D array of byte; then return size is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Type2CharStringParser.parse(byte[], byte[][], byte[][])"})
  void testParse_whenEmpty2dArrayOfByte_thenReturnSizeIsFifteen() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult =
        new Type2CharStringParser("Font Name")
            .parse(
                "A\b\n\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"),
                new byte[][] {"AXAXAXAX".getBytes("UTF-8")},
                new byte[][] {});

    // Assert
    assertEquals(15, actualParseResult.size());
    Object getResult = actualParseResult.get(10);
    assertTrue(getResult instanceof CharStringCommand);
    Object getResult2 = actualParseResult.get(12);
    assertTrue(getResult2 instanceof CharStringCommand);
    Object getResult3 = actualParseResult.get(14);
    assertTrue(getResult3 instanceof CharStringCommand);
    Object getResult4 = actualParseResult.get(2);
    assertTrue(getResult4 instanceof CharStringCommand);
    Object getResult5 = actualParseResult.get(4);
    assertTrue(getResult5 instanceof CharStringCommand);
    assertEquals(-74, ((Integer) actualParseResult.get(11)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(13)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(3)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(5)).intValue());
    assertEquals(-74, ((Integer) actualParseResult.get(9)).intValue());
    assertEquals(CharStringCommand.RRCURVETO, getResult);
    assertEquals(CharStringCommand.RRCURVETO, getResult2);
    assertEquals(CharStringCommand.RRCURVETO, getResult3);
    assertEquals(CharStringCommand.RRCURVETO, getResult4);
    assertEquals(CharStringCommand.RRCURVETO, getResult5);
  }
}
