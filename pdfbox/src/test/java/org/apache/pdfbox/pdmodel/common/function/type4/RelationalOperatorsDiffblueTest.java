package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Eq;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Ge;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Gt;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Le;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Lt;
import org.apache.pdfbox.pdmodel.common.function.type4.RelationalOperators.Ne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RelationalOperatorsDiffblueTest {
  /**
   * Test Eq {@link Eq#isEqual(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Eq#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Eq isEqual(Object, Object); when 'A'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Eq.isEqual(Object, Object)"})
  void testEqIsEqual_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Eq().isEqual((byte) 'A', "Op2"));
  }

  /**
   * Test Eq {@link Eq#isEqual(Object, Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Eq#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Eq isEqual(Object, Object); when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Eq.isEqual(Object, Object)"})
  void testEqIsEqual_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Eq().isEqual((byte) 'A', 1));
  }

  /**
   * Test Eq {@link Eq#isEqual(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code Op1}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Eq#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Eq isEqual(Object, Object); when 'Op1'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Eq.isEqual(Object, Object)"})
  void testEqIsEqual_whenOp1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Eq().isEqual("Op1", "Op2"));
  }

  /**
   * Test Eq {@link Eq#isEqual(Object, Object)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Eq#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Eq isEqual(Object, Object); when valueOf one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Eq.isEqual(Object, Object)"})
  void testEqIsEqual_whenValueOfOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Eq().isEqual(Integer.valueOf(1), Integer.valueOf(1)));
  }

  /**
   * Test Ge {@link Ge#compare(Number, Number)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Ge#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Ge compare(Number, Number); when valueOf one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Ge.compare(Number, Number)"})
  void testGeCompare_whenValueOfOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Ge().compare(Integer.valueOf(1), Integer.valueOf(1)));
  }

  /**
   * Test Ge {@link Ge#compare(Number, Number)}.
   *
   * <ul>
   *   <li>When valueOf zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Ge#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Ge compare(Number, Number); when valueOf zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Ge.compare(Number, Number)"})
  void testGeCompare_whenValueOfZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Ge().compare(Integer.valueOf(0), Integer.valueOf(1)));
  }

  /**
   * Test Gt {@link Gt#compare(Number, Number)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Gt#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Gt compare(Number, Number); when ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Gt.compare(Number, Number)"})
  void testGtCompare_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Gt().compare(10, Integer.valueOf(1)));
  }

  /**
   * Test Gt {@link Gt#compare(Number, Number)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Gt#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Gt compare(Number, Number); when valueOf one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Gt.compare(Number, Number)"})
  void testGtCompare_whenValueOfOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Gt().compare(Integer.valueOf(1), Integer.valueOf(1)));
  }

  /**
   * Test Le {@link Le#compare(Number, Number)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Le#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Le compare(Number, Number); when ten; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Le.compare(Number, Number)"})
  void testLeCompare_whenTen_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Le().compare(10, Integer.valueOf(1)));
  }

  /**
   * Test Le {@link Le#compare(Number, Number)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Le#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Le compare(Number, Number); when valueOf one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Le.compare(Number, Number)"})
  void testLeCompare_whenValueOfOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Le().compare(Integer.valueOf(1), Integer.valueOf(1)));
  }

  /**
   * Test Lt {@link Lt#compare(Number, Number)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Lt#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Lt compare(Number, Number); when valueOf one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Lt.compare(Number, Number)"})
  void testLtCompare_whenValueOfOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Lt().compare(Integer.valueOf(1), Integer.valueOf(1)));
  }

  /**
   * Test Lt {@link Lt#compare(Number, Number)}.
   *
   * <ul>
   *   <li>When valueOf zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Lt#compare(Number, Number)}
   */
  @Test
  @DisplayName("Test Lt compare(Number, Number); when valueOf zero; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Lt.compare(Number, Number)"})
  void testLtCompare_whenValueOfZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Lt().compare(Integer.valueOf(0), Integer.valueOf(1)));
  }

  /**
   * Test Ne {@link Ne#isEqual(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Ne#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Ne isEqual(Object, Object); when 'A'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Ne.isEqual(Object, Object)"})
  void testNeIsEqual_whenA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Ne().isEqual((byte) 'A', "Op2"));
  }

  /**
   * Test Ne {@link Ne#isEqual(Object, Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Ne#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Ne isEqual(Object, Object); when one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Ne.isEqual(Object, Object)"})
  void testNeIsEqual_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Ne().isEqual((byte) 'A', 1));
  }

  /**
   * Test Ne {@link Ne#isEqual(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code Op1}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Ne#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Ne isEqual(Object, Object); when 'Op1'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Ne.isEqual(Object, Object)"})
  void testNeIsEqual_whenOp1_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Ne().isEqual("Op1", "Op2"));
  }

  /**
   * Test Ne {@link Ne#isEqual(Object, Object)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Ne#isEqual(Object, Object)}
   */
  @Test
  @DisplayName("Test Ne isEqual(Object, Object); when valueOf one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Ne.isEqual(Object, Object)"})
  void testNeIsEqual_whenValueOfOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Ne().isEqual(Integer.valueOf(1), Integer.valueOf(1)));
  }
}
