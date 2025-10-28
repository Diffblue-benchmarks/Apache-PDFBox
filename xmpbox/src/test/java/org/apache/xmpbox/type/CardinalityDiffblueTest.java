package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class CardinalityDiffblueTest {
  /**
   * Method under test: {@link Cardinality#isArray()}
   */
  @Test
  void testIsArray() {
    // Arrange, Act and Assert
    assertFalse(Cardinality.valueOf("Simple").isArray());
  }
}
