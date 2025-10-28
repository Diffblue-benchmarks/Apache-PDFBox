package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BitwiseOperatorsDiffblueTest {
  /**
   * Method under test:
   * {@link BitwiseOperators.And#applyForBoolean(boolean, boolean)}
   */
  @Test
  void testAndApplyForBoolean() {
    // Arrange, Act and Assert
    assertTrue((new BitwiseOperators.And()).applyForBoolean(true, true));
    assertFalse((new BitwiseOperators.And()).applyForBoolean(false, false));
    assertFalse((new BitwiseOperators.And()).applyForBoolean(true, false));
  }

  /**
   * Method under test: {@link BitwiseOperators.And#applyforInteger(int, int)}
   */
  @Test
  void testAndApplyforInteger() {
    // Arrange, Act and Assert
    assertEquals(3, (new BitwiseOperators.And()).applyforInteger(3, 3));
    assertEquals(1, (new BitwiseOperators.And()).applyforInteger(1, 3));
    assertEquals(0, (new BitwiseOperators.And()).applyforInteger(0, 3));
    assertEquals(3, (new BitwiseOperators.And()).applyforInteger(-1, 3));
  }

  /**
   * Method under test: {@link BitwiseOperators.False#execute(ExecutionContext)}
   */
  @Test
  void testFalseExecute() {
    // Arrange
    BitwiseOperators.False resultFalse = new BitwiseOperators.False();
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    resultFalse.execute(context);

    // Assert
    assertEquals(1, context.getStack().size());
  }

  /**
   * Method under test:
   * {@link BitwiseOperators.Or#applyForBoolean(boolean, boolean)}
   */
  @Test
  void testOrApplyForBoolean() {
    // Arrange, Act and Assert
    assertTrue((new BitwiseOperators.Or()).applyForBoolean(true, true));
    assertFalse((new BitwiseOperators.Or()).applyForBoolean(false, false));
    assertTrue((new BitwiseOperators.Or()).applyForBoolean(false, true));
  }

  /**
   * Method under test: {@link BitwiseOperators.Or#applyforInteger(int, int)}
   */
  @Test
  void testOrApplyforInteger() {
    // Arrange, Act and Assert
    assertEquals(3, (new BitwiseOperators.Or()).applyforInteger(3, 3));
    assertEquals(3, (new BitwiseOperators.Or()).applyforInteger(1, 3));
    assertEquals(3, (new BitwiseOperators.Or()).applyforInteger(0, 3));
    assertEquals(-1, (new BitwiseOperators.Or()).applyforInteger(-1, 3));
  }

  /**
   * Method under test: {@link BitwiseOperators.True#execute(ExecutionContext)}
   */
  @Test
  void testTrueExecute() {
    // Arrange
    BitwiseOperators.True resultTrue = new BitwiseOperators.True();
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    resultTrue.execute(context);

    // Assert
    assertEquals(1, context.getStack().size());
  }

  /**
   * Method under test:
   * {@link BitwiseOperators.Xor#applyForBoolean(boolean, boolean)}
   */
  @Test
  void testXorApplyForBoolean() {
    // Arrange, Act and Assert
    assertFalse((new BitwiseOperators.Xor()).applyForBoolean(true, true));
    assertTrue((new BitwiseOperators.Xor()).applyForBoolean(false, true));
  }

  /**
   * Method under test: {@link BitwiseOperators.Xor#applyforInteger(int, int)}
   */
  @Test
  void testXorApplyforInteger() {
    // Arrange, Act and Assert
    assertEquals(0, (new BitwiseOperators.Xor()).applyforInteger(3, 3));
    assertEquals(2, (new BitwiseOperators.Xor()).applyforInteger(1, 3));
    assertEquals(3, (new BitwiseOperators.Xor()).applyforInteger(0, 3));
    assertEquals(-4, (new BitwiseOperators.Xor()).applyforInteger(-1, 3));
  }
}
