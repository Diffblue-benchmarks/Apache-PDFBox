package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.common.function.type4.BitwiseOperators.And;
import org.apache.pdfbox.pdmodel.common.function.type4.BitwiseOperators.False;
import org.apache.pdfbox.pdmodel.common.function.type4.BitwiseOperators.Or;
import org.apache.pdfbox.pdmodel.common.function.type4.BitwiseOperators.True;
import org.apache.pdfbox.pdmodel.common.function.type4.BitwiseOperators.Xor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BitwiseOperatorsDiffblueTest {
  /**
   * Test And {@link And#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BitwiseOperators.And#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test And applyForBoolean(boolean, boolean); when 'false'; then return 'false'")
  void testAndApplyForBoolean_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BitwiseOperators.And()).applyForBoolean(false, false));
  }

  /**
   * Test And {@link And#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BitwiseOperators.And#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test And applyForBoolean(boolean, boolean); when 'true'; then return 'false'")
  void testAndApplyForBoolean_whenTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BitwiseOperators.And()).applyForBoolean(true, false));
  }

  /**
   * Test And {@link And#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BitwiseOperators.And#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test And applyForBoolean(boolean, boolean); when 'true'; then return 'true'")
  void testAndApplyForBoolean_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BitwiseOperators.And()).applyForBoolean(true, true));
  }

  /**
   * Test And {@link And#applyforInteger(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.And#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test And applyforInteger(int, int); when minus one; then return three")
  void testAndApplyforInteger_whenMinusOne_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new BitwiseOperators.And()).applyforInteger(-1, 3));
  }

  /**
   * Test And {@link And#applyforInteger(int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.And#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test And applyforInteger(int, int); when one; then return one")
  void testAndApplyforInteger_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new BitwiseOperators.And()).applyforInteger(1, 3));
  }

  /**
   * Test And {@link And#applyforInteger(int, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.And#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test And applyforInteger(int, int); when three; then return three")
  void testAndApplyforInteger_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new BitwiseOperators.And()).applyforInteger(3, 3));
  }

  /**
   * Test And {@link And#applyforInteger(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.And#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test And applyforInteger(int, int); when zero; then return zero")
  void testAndApplyforInteger_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new BitwiseOperators.And()).applyforInteger(0, 3));
  }

  /**
   * Test False {@link False#execute(ExecutionContext)}.
   * <ul>
   *   <li>Then {@link ExecutionContext#ExecutionContext(Operators)} with
   * operatorSet is {@link Operators} (default constructor) Stack size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.False#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test False execute(ExecutionContext); then ExecutionContext(Operators) with operatorSet is Operators (default constructor) Stack size is one")
  void testFalseExecute_thenExecutionContextWithOperatorSetIsOperatorsStackSizeIsOne() {
    // Arrange
    BitwiseOperators.False resultFalse = new BitwiseOperators.False();
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    resultFalse.execute(context);

    // Assert
    assertEquals(1, context.getStack().size());
  }

  /**
   * Test Or {@link Or#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BitwiseOperators.Or#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test Or applyForBoolean(boolean, boolean); when 'false'; then return 'false'")
  void testOrApplyForBoolean_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BitwiseOperators.Or()).applyForBoolean(false, false));
  }

  /**
   * Test Or {@link Or#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BitwiseOperators.Or#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test Or applyForBoolean(boolean, boolean); when 'false'; then return 'true'")
  void testOrApplyForBoolean_whenFalse_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BitwiseOperators.Or()).applyForBoolean(false, true));
  }

  /**
   * Test Or {@link Or#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BitwiseOperators.Or#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test Or applyForBoolean(boolean, boolean); when 'true'; then return 'true'")
  void testOrApplyForBoolean_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BitwiseOperators.Or()).applyForBoolean(true, true));
  }

  /**
   * Test Or {@link Or#applyforInteger(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.Or#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Or applyforInteger(int, int); when minus one; then return minus one")
  void testOrApplyforInteger_whenMinusOne_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new BitwiseOperators.Or()).applyforInteger(-1, 3));
  }

  /**
   * Test Or {@link Or#applyforInteger(int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.Or#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Or applyforInteger(int, int); when one; then return three")
  void testOrApplyforInteger_whenOne_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new BitwiseOperators.Or()).applyforInteger(1, 3));
  }

  /**
   * Test Or {@link Or#applyforInteger(int, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.Or#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Or applyforInteger(int, int); when three; then return three")
  void testOrApplyforInteger_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new BitwiseOperators.Or()).applyforInteger(3, 3));
  }

  /**
   * Test Or {@link Or#applyforInteger(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.Or#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Or applyforInteger(int, int); when zero; then return three")
  void testOrApplyforInteger_whenZero_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new BitwiseOperators.Or()).applyforInteger(0, 3));
  }

  /**
   * Test True {@link True#execute(ExecutionContext)}.
   * <ul>
   *   <li>Then {@link ExecutionContext#ExecutionContext(Operators)} with
   * operatorSet is {@link Operators} (default constructor) Stack size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.True#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test True execute(ExecutionContext); then ExecutionContext(Operators) with operatorSet is Operators (default constructor) Stack size is one")
  void testTrueExecute_thenExecutionContextWithOperatorSetIsOperatorsStackSizeIsOne() {
    // Arrange
    BitwiseOperators.True resultTrue = new BitwiseOperators.True();
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    resultTrue.execute(context);

    // Assert
    assertEquals(1, context.getStack().size());
  }

  /**
   * Test Xor {@link Xor#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BitwiseOperators.Xor#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test Xor applyForBoolean(boolean, boolean); when 'false'; then return 'true'")
  void testXorApplyForBoolean_whenFalse_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BitwiseOperators.Xor()).applyForBoolean(false, true));
  }

  /**
   * Test Xor {@link Xor#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BitwiseOperators.Xor#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test Xor applyForBoolean(boolean, boolean); when 'true'; then return 'false'")
  void testXorApplyForBoolean_whenTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BitwiseOperators.Xor()).applyForBoolean(true, true));
  }

  /**
   * Test Xor {@link Xor#applyforInteger(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return minus four.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.Xor#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Xor applyforInteger(int, int); when minus one; then return minus four")
  void testXorApplyforInteger_whenMinusOne_thenReturnMinusFour() {
    // Arrange, Act and Assert
    assertEquals(-4, (new BitwiseOperators.Xor()).applyforInteger(-1, 3));
  }

  /**
   * Test Xor {@link Xor#applyforInteger(int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.Xor#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Xor applyforInteger(int, int); when one; then return two")
  void testXorApplyforInteger_whenOne_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, (new BitwiseOperators.Xor()).applyforInteger(1, 3));
  }

  /**
   * Test Xor {@link Xor#applyforInteger(int, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.Xor#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Xor applyforInteger(int, int); when three; then return zero")
  void testXorApplyforInteger_whenThree_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new BitwiseOperators.Xor()).applyforInteger(3, 3));
  }

  /**
   * Test Xor {@link Xor#applyforInteger(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BitwiseOperators.Xor#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Xor applyforInteger(int, int); when zero; then return three")
  void testXorApplyforInteger_whenZero_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new BitwiseOperators.Xor()).applyforInteger(0, 3));
  }
}
