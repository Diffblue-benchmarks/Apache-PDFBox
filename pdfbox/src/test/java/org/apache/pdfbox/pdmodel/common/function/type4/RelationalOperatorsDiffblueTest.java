package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Eq;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Ge;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Gt;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Le;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Lt;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Ne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RelationalOperatorsDiffblueTest {
  /**
   * Test Eq {@link Eq#isEqual(Object, Object)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Eq#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Eq isEqual(Object, Object); when 'A'; then return 'false'")
  void testEqIsEqual_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new RelationalOperators.Eq()).isEqual((byte) 'A', "Op2"));
  }

  /**
   * Test Eq {@link Eq#isEqual(Object, Object)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Eq#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Eq isEqual(Object, Object); when 'A'; then return 'true'")
  void testEqIsEqual_whenA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new RelationalOperators.Eq()).isEqual((byte) 'A', (byte) 'A'));
  }

  /**
   * Test Eq {@link Eq#isEqual(Object, Object)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Eq#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Eq isEqual(Object, Object); when one; then return 'false'")
  void testEqIsEqual_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new RelationalOperators.Eq()).isEqual((byte) 'A', 1));
  }

  /**
   * Test Eq {@link Eq#isEqual(Object, Object)}.
   * <ul>
   *   <li>When {@code Op1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Eq#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Eq isEqual(Object, Object); when 'Op1'; then return 'false'")
  void testEqIsEqual_whenOp1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new RelationalOperators.Eq()).isEqual("Op1", "Op2"));
  }

  /**
   * Test Eq {@link Eq#isEqual(Object, Object)}.
   * <ul>
   *   <li>When {@code Op2}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Eq#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Eq isEqual(Object, Object); when 'Op2'; then return 'true'")
  void testEqIsEqual_whenOp2_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new RelationalOperators.Eq()).isEqual("Op2", "Op2"));
  }

  /**
   * Test Ge {@link Ge#compare(Number, Number)}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Ge#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Ge compare(Number, Number); when valueOf one; then return 'true'")
  void testGeCompare_whenValueOfOne_thenReturnTrue() {
    // Arrange
    RelationalOperators.Ge ge = new RelationalOperators.Ge();
    Integer num1 = Integer.valueOf(1);

    // Act and Assert
    assertTrue(ge.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Test Ge {@link Ge#compare(Number, Number)}.
   * <ul>
   *   <li>When valueOf zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Ge#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Ge compare(Number, Number); when valueOf zero; then return 'false'")
  void testGeCompare_whenValueOfZero_thenReturnFalse() {
    // Arrange
    RelationalOperators.Ge ge = new RelationalOperators.Ge();
    Integer num1 = Integer.valueOf(0);

    // Act and Assert
    assertFalse(ge.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Test Gt {@link Gt#compare(Number, Number)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Gt#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Gt compare(Number, Number); when ten; then return 'true'")
  void testGtCompare_whenTen_thenReturnTrue() {
    // Arrange
    RelationalOperators.Gt gt = new RelationalOperators.Gt();

    // Act and Assert
    assertTrue(gt.compare(10, Integer.valueOf(1)));
  }

  /**
   * Test Gt {@link Gt#compare(Number, Number)}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Gt#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Gt compare(Number, Number); when valueOf one; then return 'false'")
  void testGtCompare_whenValueOfOne_thenReturnFalse() {
    // Arrange
    RelationalOperators.Gt gt = new RelationalOperators.Gt();
    Integer num1 = Integer.valueOf(1);

    // Act and Assert
    assertFalse(gt.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Test Le {@link Le#compare(Number, Number)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Le#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Le compare(Number, Number); when ten; then return 'false'")
  void testLeCompare_whenTen_thenReturnFalse() {
    // Arrange
    RelationalOperators.Le le = new RelationalOperators.Le();

    // Act and Assert
    assertFalse(le.compare(10, Integer.valueOf(1)));
  }

  /**
   * Test Le {@link Le#compare(Number, Number)}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Le#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Le compare(Number, Number); when valueOf one; then return 'true'")
  void testLeCompare_whenValueOfOne_thenReturnTrue() {
    // Arrange
    RelationalOperators.Le le = new RelationalOperators.Le();
    Integer num1 = Integer.valueOf(1);

    // Act and Assert
    assertTrue(le.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Test Lt {@link Lt#compare(Number, Number)}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Lt#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Lt compare(Number, Number); when valueOf one; then return 'false'")
  void testLtCompare_whenValueOfOne_thenReturnFalse() {
    // Arrange
    RelationalOperators.Lt lt = new RelationalOperators.Lt();
    Integer num1 = Integer.valueOf(1);

    // Act and Assert
    assertFalse(lt.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Test Lt {@link Lt#compare(Number, Number)}.
   * <ul>
   *   <li>When valueOf zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Lt#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Lt compare(Number, Number); when valueOf zero; then return 'true'")
  void testLtCompare_whenValueOfZero_thenReturnTrue() {
    // Arrange
    RelationalOperators.Lt lt = new RelationalOperators.Lt();
    Integer num1 = Integer.valueOf(0);

    // Act and Assert
    assertTrue(lt.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Test Ne {@link Ne#isEqual(Object, Object)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Ne#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Ne isEqual(Object, Object); when 'A'; then return 'false'")
  void testNeIsEqual_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new RelationalOperators.Ne()).isEqual((byte) 'A', (byte) 'A'));
  }

  /**
   * Test Ne {@link Ne#isEqual(Object, Object)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Ne#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Ne isEqual(Object, Object); when 'A'; then return 'true'")
  void testNeIsEqual_whenA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new RelationalOperators.Ne()).isEqual((byte) 'A', "Op2"));
  }

  /**
   * Test Ne {@link Ne#isEqual(Object, Object)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Ne#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Ne isEqual(Object, Object); when one; then return 'true'")
  void testNeIsEqual_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new RelationalOperators.Ne()).isEqual((byte) 'A', 1));
  }

  /**
   * Test Ne {@link Ne#isEqual(Object, Object)}.
   * <ul>
   *   <li>When {@code Op1}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Ne#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Ne isEqual(Object, Object); when 'Op1'; then return 'true'")
  void testNeIsEqual_whenOp1_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new RelationalOperators.Ne()).isEqual("Op1", "Op2"));
  }

  /**
   * Test Ne {@link Ne#isEqual(Object, Object)}.
   * <ul>
   *   <li>When {@code Op2}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationalOperators.Ne#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Ne isEqual(Object, Object); when 'Op2'; then return 'false'")
  void testNeIsEqual_whenOp2_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new RelationalOperators.Ne()).isEqual("Op2", "Op2"));
  }
}
