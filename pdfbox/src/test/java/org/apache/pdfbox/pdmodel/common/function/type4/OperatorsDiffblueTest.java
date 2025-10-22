package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OperatorsDiffblueTest {
  /**
   * Test new {@link Operators} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Operators}
   */
  @Test
  @DisplayName("Test new Operators (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Operators.<init>()"})
  void testNewOperators() {
    // Arrange, Act and Assert
    assertNull((new Operators()).getOperator("Operator Name"));
  }
}
