package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PredictorDiffblueTest {
  /**
   * Test {@link Predictor#calculateRowLength(int, int, int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#calculateRowLength(int, int, int)}
   */
  @Test
  @DisplayName("Test calculateRowLength(int, int, int); when eight; then return nine")
  void testCalculateRowLength_whenEight_thenReturnNine() {
    // Arrange, Act and Assert
    assertEquals(9, Predictor.calculateRowLength(8, 3, 3));
  }

  /**
   * Test {@link Predictor#calculateRowLength(int, int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#calculateRowLength(int, int, int)}
   */
  @Test
  @DisplayName("Test calculateRowLength(int, int, int); when one; then return two")
  void testCalculateRowLength_whenOne_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, Predictor.calculateRowLength(1, 3, 3));
  }

  /**
   * Test {@link Predictor#calculateRowLength(int, int, int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#calculateRowLength(int, int, int)}
   */
  @Test
  @DisplayName("Test calculateRowLength(int, int, int); when seven; then return eight")
  void testCalculateRowLength_whenSeven_thenReturnEight() {
    // Arrange, Act and Assert
    assertEquals(8, Predictor.calculateRowLength(7, 3, 3));
  }

  /**
   * Test {@link Predictor#calculateRowLength(int, int, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#calculateRowLength(int, int, int)}
   */
  @Test
  @DisplayName("Test calculateRowLength(int, int, int); when three; then return four")
  void testCalculateRowLength_whenThree_thenReturnFour() {
    // Arrange, Act and Assert
    assertEquals(4, Predictor.calculateRowLength(3, 3, 3));
  }

  /**
   * Test {@link Predictor#getBitSeq(int, int, int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#getBitSeq(int, int, int)}
   */
  @Test
  @DisplayName("Test getBitSeq(int, int, int); when MIN_VALUE; then return zero")
  void testGetBitSeq_whenMin_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Predictor.getBitSeq(Integer.MIN_VALUE, 1, 3));
  }

  /**
   * Test {@link Predictor#getBitSeq(int, int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#getBitSeq(int, int, int)}
   */
  @Test
  @DisplayName("Test getBitSeq(int, int, int); when minus one; then return seven")
  void testGetBitSeq_whenMinusOne_thenReturnSeven() {
    // Arrange, Act and Assert
    assertEquals(7, Predictor.getBitSeq(-1, 1, 3));
  }

  /**
   * Test {@link Predictor#getBitSeq(int, int, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#getBitSeq(int, int, int)}
   */
  @Test
  @DisplayName("Test getBitSeq(int, int, int); when three; then return one")
  void testGetBitSeq_whenThree_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, Predictor.getBitSeq(3, 1, 3));
  }

  /**
   * Test {@link Predictor#getBitSeq(int, int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#getBitSeq(int, int, int)}
   */
  @Test
  @DisplayName("Test getBitSeq(int, int, int); when zero; then return zero")
  void testGetBitSeq_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Predictor.getBitSeq(0, 1, 3));
  }

  /**
   * Test {@link Predictor#calcSetBitSeq(int, int, int, int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#calcSetBitSeq(int, int, int, int)}
   */
  @Test
  @DisplayName("Test calcSetBitSeq(int, int, int, int); when forty-two; then return five")
  void testCalcSetBitSeq_whenFortyTwo_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5, Predictor.calcSetBitSeq(3, 1, 3, 42));
  }

  /**
   * Test {@link Predictor#calcSetBitSeq(int, int, int, int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then return {@code -2147483644}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#calcSetBitSeq(int, int, int, int)}
   */
  @Test
  @DisplayName("Test calcSetBitSeq(int, int, int, int); when MIN_VALUE; then return '-2147483644'")
  void testCalcSetBitSeq_whenMin_value_thenReturn2147483644() {
    // Arrange, Act and Assert
    assertEquals(-2147483644, Predictor.calcSetBitSeq(Integer.MIN_VALUE, 1, 3, 42));
  }

  /**
   * Test {@link Predictor#calcSetBitSeq(int, int, int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return minus eleven.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#calcSetBitSeq(int, int, int, int)}
   */
  @Test
  @DisplayName("Test calcSetBitSeq(int, int, int, int); when minus one; then return minus eleven")
  void testCalcSetBitSeq_whenMinusOne_thenReturnMinusEleven() {
    // Arrange, Act and Assert
    assertEquals(-11, Predictor.calcSetBitSeq(-1, 1, 3, 42));
  }

  /**
   * Test {@link Predictor#calcSetBitSeq(int, int, int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Predictor#calcSetBitSeq(int, int, int, int)}
   */
  @Test
  @DisplayName("Test calcSetBitSeq(int, int, int, int); when zero; then return four")
  void testCalcSetBitSeq_whenZero_thenReturnFour() {
    // Arrange, Act and Assert
    assertEquals(4, Predictor.calcSetBitSeq(0, 1, 3, 42));
  }
}
