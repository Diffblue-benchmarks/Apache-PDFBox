package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class OperatorsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Operators}
   */
  @Test
  void testNewOperators() {
    // Arrange, Act and Assert
    assertNull((new Operators()).getOperator("Operator Name"));
  }
}
