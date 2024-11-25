package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardinalityDiffblueTest {
  /**
   * Test {@link Cardinality#isArray()}.
   * <p>
   * Method under test: {@link Cardinality#isArray()}
   */
  @Test
  @DisplayName("Test isArray()")
  void testIsArray() {
    // Arrange, Act and Assert
    assertFalse(Cardinality.valueOf("Simple").isArray());
  }
}
