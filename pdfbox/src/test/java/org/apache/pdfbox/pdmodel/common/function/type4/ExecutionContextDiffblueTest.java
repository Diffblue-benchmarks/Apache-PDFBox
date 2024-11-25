package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExecutionContextDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExecutionContext#ExecutionContext(Operators)}
   *   <li>{@link ExecutionContext#getOperators()}
   *   <li>{@link ExecutionContext#getStack()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    Operators operatorSet = new Operators();

    // Act
    ExecutionContext actualExecutionContext = new ExecutionContext(operatorSet);
    Operators actualOperators = actualExecutionContext.getOperators();

    // Assert
    assertTrue(actualExecutionContext.getStack().isEmpty());
    assertSame(operatorSet, actualOperators);
  }
}
