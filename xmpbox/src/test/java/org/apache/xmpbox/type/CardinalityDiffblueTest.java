package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CardinalityDiffblueTest {
  /**
   * Test {@link Cardinality#isArray()}.
   *
   * <p>Method under test: {@link Cardinality#isArray()}
   */
  @Test
  @DisplayName("Test isArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Cardinality.isArray()"})
  void testIsArray() {
    // Arrange, Act and Assert
    assertFalse(Cardinality.valueOf("Simple").isArray());
  }
}
