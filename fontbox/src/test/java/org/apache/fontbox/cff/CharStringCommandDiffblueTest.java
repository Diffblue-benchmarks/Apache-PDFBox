package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CharStringCommandDiffblueTest {
  /**
   * Test {@link CharStringCommand#getInstance(int, int)} with {@code b0},
   * {@code b1}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int, int)}
   */
  @Test
  @DisplayName("Test getInstance(int, int) with 'b0', 'b1'; when minus one; then return 'UNKNOWN'")
  void testGetInstanceWithB0B1_whenMinusOne_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(-1, 1));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int, int)} with {@code b0},
   * {@code b1}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int, int)}
   */
  @Test
  @DisplayName("Test getInstance(int, int) with 'b0', 'b1'; when one; then return 'UNKNOWN'")
  void testGetInstanceWithB0B1_whenOne_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(1, 1));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int, int)} with {@code b0},
   * {@code b1}.
   * <ul>
   *   <li>When seventeen.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int, int)}
   */
  @Test
  @DisplayName("Test getInstance(int, int) with 'b0', 'b1'; when seventeen; then return 'UNKNOWN'")
  void testGetInstanceWithB0B1_whenSeventeen_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(17, 1));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int, int)} with {@code b0},
   * {@code b1}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code HSTEM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int, int)}
   */
  @Test
  @DisplayName("Test getInstance(int, int) with 'b0', 'b1'; when zero; then return 'HSTEM'")
  void testGetInstanceWithB0B1_whenZero_thenReturnHstem() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.HSTEM, CharStringCommand.getInstance(0, 1));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int)} with {@code b0}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int)}
   */
  @Test
  @DisplayName("Test getInstance(int) with 'b0'; when minus one; then return 'UNKNOWN'")
  void testGetInstanceWithB0_whenMinusOne_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(-1));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int)} with {@code b0}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code HSTEM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int)}
   */
  @Test
  @DisplayName("Test getInstance(int) with 'b0'; when one; then return 'HSTEM'")
  void testGetInstanceWithB0_whenOne_thenReturnHstem() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.HSTEM, CharStringCommand.getInstance(1));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int)} with {@code b0}.
   * <ul>
   *   <li>When two hundred thirty.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int)}
   */
  @Test
  @DisplayName("Test getInstance(int) with 'b0'; when two hundred thirty; then return 'UNKNOWN'")
  void testGetInstanceWithB0_whenTwoHundredThirty_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(230));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int)} with {@code b0}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int)}
   */
  @Test
  @DisplayName("Test getInstance(int) with 'b0'; when zero; then return 'UNKNOWN'")
  void testGetInstanceWithB0_whenZero_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(0));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int[])} with {@code values}.
   * <ul>
   *   <li>When array of {@code int} with forty-two and one.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int[])}
   */
  @Test
  @DisplayName("Test getInstance(int[]) with 'values'; when array of int with forty-two and one; then return 'UNKNOWN'")
  void testGetInstanceWithValues_whenArrayOfIntWithFortyTwoAndOne_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(new int[]{42, 1, 42, 1}));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int[])} with {@code values}.
   * <ul>
   *   <li>When array of {@code int} with minus one.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int[])}
   */
  @Test
  @DisplayName("Test getInstance(int[]) with 'values'; when array of int with minus one; then return 'UNKNOWN'")
  void testGetInstanceWithValues_whenArrayOfIntWithMinusOne_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(new int[]{-1}));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int[])} with {@code values}.
   * <ul>
   *   <li>When array of {@code int} with one.</li>
   *   <li>Then return {@code HSTEM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int[])}
   */
  @Test
  @DisplayName("Test getInstance(int[]) with 'values'; when array of int with one; then return 'HSTEM'")
  void testGetInstanceWithValues_whenArrayOfIntWithOne_thenReturnHstem() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.HSTEM, CharStringCommand.getInstance(new int[]{1}));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int[])} with {@code values}.
   * <ul>
   *   <li>When array of {@code int} with two hundred thirty.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int[])}
   */
  @Test
  @DisplayName("Test getInstance(int[]) with 'values'; when array of int with two hundred thirty; then return 'UNKNOWN'")
  void testGetInstanceWithValues_whenArrayOfIntWithTwoHundredThirty_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(new int[]{230}));
  }

  /**
   * Test {@link CharStringCommand#getInstance(int[])} with {@code values}.
   * <ul>
   *   <li>When array of {@code int} with zero.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharStringCommand#getInstance(int[])}
   */
  @Test
  @DisplayName("Test getInstance(int[]) with 'values'; when array of int with zero; then return 'UNKNOWN'")
  void testGetInstanceWithValues_whenArrayOfIntWithZero_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(new int[]{0}));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CharStringCommand#getType1KeyWord()}
   *   <li>{@link CharStringCommand#getType2KeyWord()}
   *   <li>{@link CharStringCommand#getValue()}
   *   <li>{@link CharStringCommand#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    CharStringCommand valueOfResult = CharStringCommand.valueOf("HSTEM");

    // Act
    CharStringCommand.Type1KeyWord actualType1KeyWord = valueOfResult.getType1KeyWord();
    CharStringCommand.Type2KeyWord actualType2KeyWord = valueOfResult.getType2KeyWord();
    int actualValue = valueOfResult.getValue();

    // Assert
    assertEquals("HSTEM|", valueOfResult.toString());
    assertEquals(1, actualValue);
    assertEquals(CharStringCommand.Type1KeyWord.HSTEM, actualType1KeyWord);
    assertEquals(CharStringCommand.Type2KeyWord.HSTEM, actualType2KeyWord);
  }
}
