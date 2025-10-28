package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PredictorDiffblueTest {
  /**
   * Method under test: {@link Predictor#calculateRowLength(int, int, int)}
   */
  @Test
  void testCalculateRowLength() {
    // Arrange, Act and Assert
    assertEquals(4, Predictor.calculateRowLength(3, 3, 3));
    assertEquals(8, Predictor.calculateRowLength(7, 3, 3));
    assertEquals(9, Predictor.calculateRowLength(8, 3, 3));
    assertEquals(2, Predictor.calculateRowLength(1, 3, 3));
  }

  /**
   * Method under test: {@link Predictor#getBitSeq(int, int, int)}
   */
  @Test
  void testGetBitSeq() {
    // Arrange, Act and Assert
    assertEquals(1, Predictor.getBitSeq(3, 1, 3));
    assertEquals(0, Predictor.getBitSeq(0, 1, 3));
    assertEquals(7, Predictor.getBitSeq(-1, 1, 3));
    assertEquals(0, Predictor.getBitSeq(Integer.MIN_VALUE, 1, 3));
  }

  /**
   * Method under test: {@link Predictor#calcSetBitSeq(int, int, int, int)}
   */
  @Test
  void testCalcSetBitSeq() {
    // Arrange, Act and Assert
    assertEquals(5, Predictor.calcSetBitSeq(3, 1, 3, 42));
    assertEquals(-11, Predictor.calcSetBitSeq(-1, 1, 3, 42));
    assertEquals(4, Predictor.calcSetBitSeq(0, 1, 3, 42));
    assertEquals(-2147483644, Predictor.calcSetBitSeq(Integer.MIN_VALUE, 1, 3, 42));
  }
}
