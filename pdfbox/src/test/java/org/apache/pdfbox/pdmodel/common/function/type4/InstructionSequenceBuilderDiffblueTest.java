package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InstructionSequenceBuilderDiffblueTest {
  /**
   * Test {@link InstructionSequenceBuilder#parseInt(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstructionSequenceBuilder#parseInt(String)}
   */
  @Test
  @DisplayName("Test parseInt(String); when '42'; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int InstructionSequenceBuilder.parseInt(String)"})
  void testParseInt_when42_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, InstructionSequenceBuilder.parseInt("42"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#parseReal(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstructionSequenceBuilder#parseReal(String)}
   */
  @Test
  @DisplayName("Test parseReal(String); when '42'; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float InstructionSequenceBuilder.parseReal(String)"})
  void testParseReal_when42_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f, InstructionSequenceBuilder.parseReal("42"));
  }
}
