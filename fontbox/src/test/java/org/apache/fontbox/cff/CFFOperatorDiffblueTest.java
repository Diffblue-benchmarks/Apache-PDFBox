package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CFFOperatorDiffblueTest {
  /**
   * Test {@link CFFOperator#getOperator(int)} with {@code b0}.
   * <p>
   * Method under test: {@link CFFOperator#getOperator(int)}
   */
  @Test
  @DisplayName("Test getOperator(int) with 'b0'")
  void testGetOperatorWithB0() {
    // Arrange, Act and Assert
    assertEquals("Notice", CFFOperator.getOperator(1));
  }

  /**
   * Test {@link CFFOperator#getOperator(int, int)} with {@code b0}, {@code b1}.
   * <p>
   * Method under test: {@link CFFOperator#getOperator(int, int)}
   */
  @Test
  @DisplayName("Test getOperator(int, int) with 'b0', 'b1'")
  void testGetOperatorWithB0B1() {
    // Arrange, Act and Assert
    assertNull(CFFOperator.getOperator(1, 1));
  }
}
