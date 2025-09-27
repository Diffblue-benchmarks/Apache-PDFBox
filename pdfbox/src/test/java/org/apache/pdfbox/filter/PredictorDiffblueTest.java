package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PredictorDiffblueTest {
  /**
   * Test {@link Predictor#calculateRowLength(int, int, int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return nine.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#calculateRowLength(int, int, int)}
   */
  @Test
  @DisplayName("Test calculateRowLength(int, int, int); when eight; then return nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.calculateRowLength(int, int, int)"})
  void testCalculateRowLength_whenEight_thenReturnNine() {
    // Arrange, Act and Assert
    assertEquals(9, Predictor.calculateRowLength(8, 3, 3));
  }

  /**
   * Test {@link Predictor#calculateRowLength(int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#calculateRowLength(int, int, int)}
   */
  @Test
  @DisplayName("Test calculateRowLength(int, int, int); when one; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.calculateRowLength(int, int, int)"})
  void testCalculateRowLength_whenOne_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, Predictor.calculateRowLength(1, 3, 3));
  }

  /**
   * Test {@link Predictor#calculateRowLength(int, int, int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#calculateRowLength(int, int, int)}
   */
  @Test
  @DisplayName("Test calculateRowLength(int, int, int); when seven; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.calculateRowLength(int, int, int)"})
  void testCalculateRowLength_whenSeven_thenReturnEight() {
    // Arrange, Act and Assert
    assertEquals(8, Predictor.calculateRowLength(7, 3, 3));
  }

  /**
   * Test {@link Predictor#calculateRowLength(int, int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#calculateRowLength(int, int, int)}
   */
  @Test
  @DisplayName("Test calculateRowLength(int, int, int); when three; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.calculateRowLength(int, int, int)"})
  void testCalculateRowLength_whenThree_thenReturnFour() {
    // Arrange, Act and Assert
    assertEquals(4, Predictor.calculateRowLength(3, 3, 3));
  }

  /**
   * Test {@link Predictor#getBitSeq(int, int, int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#getBitSeq(int, int, int)}
   */
  @Test
  @DisplayName("Test getBitSeq(int, int, int); when MIN_VALUE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.getBitSeq(int, int, int)"})
  void testGetBitSeq_whenMin_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Predictor.getBitSeq(Integer.MIN_VALUE, 1, 3));
  }

  /**
   * Test {@link Predictor#getBitSeq(int, int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return seven.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#getBitSeq(int, int, int)}
   */
  @Test
  @DisplayName("Test getBitSeq(int, int, int); when minus one; then return seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.getBitSeq(int, int, int)"})
  void testGetBitSeq_whenMinusOne_thenReturnSeven() {
    // Arrange, Act and Assert
    assertEquals(7, Predictor.getBitSeq(-1, 1, 3));
  }

  /**
   * Test {@link Predictor#getBitSeq(int, int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#getBitSeq(int, int, int)}
   */
  @Test
  @DisplayName("Test getBitSeq(int, int, int); when three; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.getBitSeq(int, int, int)"})
  void testGetBitSeq_whenThree_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, Predictor.getBitSeq(3, 1, 3));
  }

  /**
   * Test {@link Predictor#getBitSeq(int, int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#getBitSeq(int, int, int)}
   */
  @Test
  @DisplayName("Test getBitSeq(int, int, int); when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.getBitSeq(int, int, int)"})
  void testGetBitSeq_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Predictor.getBitSeq(0, 1, 3));
  }

  /**
   * Test {@link Predictor#calcSetBitSeq(int, int, int, int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#calcSetBitSeq(int, int, int, int)}
   */
  @Test
  @DisplayName("Test calcSetBitSeq(int, int, int, int); when forty-two; then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.calcSetBitSeq(int, int, int, int)"})
  void testCalcSetBitSeq_whenFortyTwo_thenReturnFive() {
    // Arrange and Act
    int actualCalcSetBitSeqResult = Predictor.calcSetBitSeq(3, 1, 3, 42);

    // Assert
    assertEquals(5, actualCalcSetBitSeqResult);
  }

  /**
   * Test {@link Predictor#calcSetBitSeq(int, int, int, int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return {@code -2147483644}.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#calcSetBitSeq(int, int, int, int)}
   */
  @Test
  @DisplayName("Test calcSetBitSeq(int, int, int, int); when MIN_VALUE; then return '-2147483644'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.calcSetBitSeq(int, int, int, int)"})
  void testCalcSetBitSeq_whenMin_value_thenReturn2147483644() {
    // Arrange and Act
    int actualCalcSetBitSeqResult = Predictor.calcSetBitSeq(Integer.MIN_VALUE, 1, 3, 42);

    // Assert
    assertEquals(-2147483644, actualCalcSetBitSeqResult);
  }

  /**
   * Test {@link Predictor#calcSetBitSeq(int, int, int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return minus eleven.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#calcSetBitSeq(int, int, int, int)}
   */
  @Test
  @DisplayName("Test calcSetBitSeq(int, int, int, int); when minus one; then return minus eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.calcSetBitSeq(int, int, int, int)"})
  void testCalcSetBitSeq_whenMinusOne_thenReturnMinusEleven() {
    // Arrange and Act
    int actualCalcSetBitSeqResult = Predictor.calcSetBitSeq(-1, 1, 3, 42);

    // Assert
    assertEquals(-11, actualCalcSetBitSeqResult);
  }

  /**
   * Test {@link Predictor#calcSetBitSeq(int, int, int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link Predictor#calcSetBitSeq(int, int, int, int)}
   */
  @Test
  @DisplayName("Test calcSetBitSeq(int, int, int, int); when zero; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Predictor.calcSetBitSeq(int, int, int, int)"})
  void testCalcSetBitSeq_whenZero_thenReturnFour() {
    // Arrange and Act
    int actualCalcSetBitSeqResult = Predictor.calcSetBitSeq(0, 1, 3, 42);

    // Assert
    assertEquals(4, actualCalcSetBitSeqResult);
  }
}
