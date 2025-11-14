package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OperatorsDiffblueTest {
  /**
   * Test new {@link Operators} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Operators}
   */
  @Test
  @DisplayName("Test new Operators (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Operators.<init>()"})
  void testNewOperators() {
    // Arrange, Act and Assert
    assertNull(new Operators().getOperator("Operator Name"));
  }

  /**
   * Test {@link Operators#getOperator(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Operators#getOperator(String)}
   */
  @Test
  @DisplayName("Test getOperator(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.common.function.type4.Operator Operators.getOperator(String)"
  })
  void testGetOperator_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Operators().getOperator("Operator Name"));
  }
}
