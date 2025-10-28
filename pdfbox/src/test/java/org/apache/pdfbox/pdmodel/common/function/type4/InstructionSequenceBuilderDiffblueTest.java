package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class InstructionSequenceBuilderDiffblueTest {
  /**
   * Method under test: {@link InstructionSequenceBuilder#parseInt(String)}
   */
  @Test
  void testParseInt() {
    // Arrange, Act and Assert
    assertEquals(42, InstructionSequenceBuilder.parseInt("42"));
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#parseReal(String)}
   */
  @Test
  void testParseReal() {
    // Arrange, Act and Assert
    assertEquals(42.0f, InstructionSequenceBuilder.parseReal("42"));
  }
}
