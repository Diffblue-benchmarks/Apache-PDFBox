package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Stack;
import org.apache.pdfbox.pdmodel.common.function.type4.BitwiseOperators.And;
import org.apache.pdfbox.pdmodel.common.function.type4.BitwiseOperators.False;
import org.apache.pdfbox.pdmodel.common.function.type4.BitwiseOperators.Or;
import org.apache.pdfbox.pdmodel.common.function.type4.BitwiseOperators.True;
import org.apache.pdfbox.pdmodel.common.function.type4.BitwiseOperators.Xor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BitwiseOperatorsDiffblueTest {
  /**
   * Test And {@link And#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link And#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test And applyForBoolean(boolean, boolean); when 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean And.applyForBoolean(boolean, boolean)"})
  void testAndApplyForBoolean_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new And()).applyForBoolean(false, false));
  }

  /**
   * Test And {@link And#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link And#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test And applyForBoolean(boolean, boolean); when 'true'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean And.applyForBoolean(boolean, boolean)"})
  void testAndApplyForBoolean_whenTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new And()).applyForBoolean(true, false));
  }

  /**
   * Test And {@link And#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link And#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test And applyForBoolean(boolean, boolean); when 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean And.applyForBoolean(boolean, boolean)"})
  void testAndApplyForBoolean_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new And()).applyForBoolean(true, true));
  }

  /**
   * Test And {@link And#applyforInteger(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link And#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test And applyforInteger(int, int); when minus one; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int And.applyforInteger(int, int)"})
  void testAndApplyforInteger_whenMinusOne_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new And()).applyforInteger(-1, 3));
  }

  /**
   * Test And {@link And#applyforInteger(int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link And#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test And applyforInteger(int, int); when one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int And.applyforInteger(int, int)"})
  void testAndApplyforInteger_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new And()).applyforInteger(1, 3));
  }

  /**
   * Test And {@link And#applyforInteger(int, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link And#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test And applyforInteger(int, int); when three; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int And.applyforInteger(int, int)"})
  void testAndApplyforInteger_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new And()).applyforInteger(3, 3));
  }

  /**
   * Test And {@link And#applyforInteger(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link And#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test And applyforInteger(int, int); when zero; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int And.applyforInteger(int, int)"})
  void testAndApplyforInteger_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new And()).applyforInteger(0, 3));
  }

  /**
   * Test False {@link False#execute(ExecutionContext)}.
   * <ul>
   *   <li>Then {@link ExecutionContext#ExecutionContext(Operators)} with operatorSet is {@link Operators} (default constructor) Stack size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link False#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test False execute(ExecutionContext); then ExecutionContext(Operators) with operatorSet is Operators (default constructor) Stack size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void False.execute(ExecutionContext)"})
  void testFalseExecute_thenExecutionContextWithOperatorSetIsOperatorsStackSizeIsOne() {
    // Arrange
    False resultFalse = new False();
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    resultFalse.execute(context);

    // Assert
    Stack<Object> stack = context.getStack();
    assertEquals(1, stack.size());
    assertFalse((Boolean) stack.get(0));
  }

  /**
   * Test Or {@link Or#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Or#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test Or applyForBoolean(boolean, boolean); when 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Or.applyForBoolean(boolean, boolean)"})
  void testOrApplyForBoolean_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Or()).applyForBoolean(false, false));
  }

  /**
   * Test Or {@link Or#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Or#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test Or applyForBoolean(boolean, boolean); when 'false'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Or.applyForBoolean(boolean, boolean)"})
  void testOrApplyForBoolean_whenFalse_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Or()).applyForBoolean(false, true));
  }

  /**
   * Test Or {@link Or#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Or#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test Or applyForBoolean(boolean, boolean); when 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Or.applyForBoolean(boolean, boolean)"})
  void testOrApplyForBoolean_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Or()).applyForBoolean(true, true));
  }

  /**
   * Test Or {@link Or#applyforInteger(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Or#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Or applyforInteger(int, int); when minus one; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Or.applyforInteger(int, int)"})
  void testOrApplyforInteger_whenMinusOne_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new Or()).applyforInteger(-1, 3));
  }

  /**
   * Test Or {@link Or#applyforInteger(int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Or#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Or applyforInteger(int, int); when one; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Or.applyforInteger(int, int)"})
  void testOrApplyforInteger_whenOne_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new Or()).applyforInteger(1, 3));
  }

  /**
   * Test Or {@link Or#applyforInteger(int, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Or#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Or applyforInteger(int, int); when three; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Or.applyforInteger(int, int)"})
  void testOrApplyforInteger_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new Or()).applyforInteger(3, 3));
  }

  /**
   * Test Or {@link Or#applyforInteger(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Or#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Or applyforInteger(int, int); when zero; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Or.applyforInteger(int, int)"})
  void testOrApplyforInteger_whenZero_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new Or()).applyforInteger(0, 3));
  }

  /**
   * Test True {@link True#execute(ExecutionContext)}.
   * <ul>
   *   <li>Then {@link ExecutionContext#ExecutionContext(Operators)} with operatorSet is {@link Operators} (default constructor) Stack size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link True#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test True execute(ExecutionContext); then ExecutionContext(Operators) with operatorSet is Operators (default constructor) Stack size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void True.execute(ExecutionContext)"})
  void testTrueExecute_thenExecutionContextWithOperatorSetIsOperatorsStackSizeIsOne() {
    // Arrange
    True resultTrue = new True();
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    resultTrue.execute(context);

    // Assert
    Stack<Object> stack = context.getStack();
    assertEquals(1, stack.size());
    assertTrue((Boolean) stack.get(0));
  }

  /**
   * Test Xor {@link Xor#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Xor#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test Xor applyForBoolean(boolean, boolean); when 'false'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Xor.applyForBoolean(boolean, boolean)"})
  void testXorApplyForBoolean_whenFalse_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Xor()).applyForBoolean(false, true));
  }

  /**
   * Test Xor {@link Xor#applyForBoolean(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Xor#applyForBoolean(boolean, boolean)}
   */
  @Test
  @DisplayName("Test Xor applyForBoolean(boolean, boolean); when 'true'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Xor.applyForBoolean(boolean, boolean)"})
  void testXorApplyForBoolean_whenTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Xor()).applyForBoolean(true, true));
  }

  /**
   * Test Xor {@link Xor#applyforInteger(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return minus four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Xor#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Xor applyforInteger(int, int); when minus one; then return minus four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Xor.applyforInteger(int, int)"})
  void testXorApplyforInteger_whenMinusOne_thenReturnMinusFour() {
    // Arrange, Act and Assert
    assertEquals(-4, (new Xor()).applyforInteger(-1, 3));
  }

  /**
   * Test Xor {@link Xor#applyforInteger(int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Xor#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Xor applyforInteger(int, int); when one; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Xor.applyforInteger(int, int)"})
  void testXorApplyforInteger_whenOne_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, (new Xor()).applyforInteger(1, 3));
  }

  /**
   * Test Xor {@link Xor#applyforInteger(int, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Xor#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Xor applyforInteger(int, int); when three; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Xor.applyforInteger(int, int)"})
  void testXorApplyforInteger_whenThree_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new Xor()).applyforInteger(3, 3));
  }

  /**
   * Test Xor {@link Xor#applyforInteger(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Xor#applyforInteger(int, int)}
   */
  @Test
  @DisplayName("Test Xor applyforInteger(int, int); when zero; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Xor.applyforInteger(int, int)"})
  void testXorApplyforInteger_whenZero_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new Xor()).applyforInteger(0, 3));
  }
}
