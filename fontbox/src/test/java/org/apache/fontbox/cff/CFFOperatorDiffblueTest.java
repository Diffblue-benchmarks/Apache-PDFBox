package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class CFFOperatorDiffblueTest {
  /**
   * Method under test: {@link CFFOperator#getOperator(int)}
   */
  @Test
  void testGetOperator() {
    // Arrange, Act and Assert
    assertEquals("Notice", CFFOperator.getOperator(1));
    assertNull(CFFOperator.getOperator(1, 1));
  }
}
