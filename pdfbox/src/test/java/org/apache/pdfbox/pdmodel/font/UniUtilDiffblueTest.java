package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UniUtilDiffblueTest {
  /**
   * Test {@link UniUtil#getUniNameOfCodePoint(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then return {@code uni-80000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UniUtil#getUniNameOfCodePoint(int)}
   */
  @Test
  @DisplayName("Test getUniNameOfCodePoint(int); when MIN_VALUE; then return 'uni-80000000'")
  void testGetUniNameOfCodePoint_whenMin_value_thenReturnUni80000000() {
    // Arrange, Act and Assert
    assertEquals("uni-80000000", UniUtil.getUniNameOfCodePoint(Integer.MIN_VALUE));
  }

  /**
   * Test {@link UniUtil#getUniNameOfCodePoint(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code uni0001}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UniUtil#getUniNameOfCodePoint(int)}
   */
  @Test
  @DisplayName("Test getUniNameOfCodePoint(int); when one; then return 'uni0001'")
  void testGetUniNameOfCodePoint_whenOne_thenReturnUni0001() {
    // Arrange, Act and Assert
    assertEquals("uni0001", UniUtil.getUniNameOfCodePoint(1));
  }

  /**
   * Test {@link UniUtil#getUniNameOfCodePoint(int)}.
   * <ul>
   *   <li>When {@link Short#SIZE}.</li>
   *   <li>Then return {@code uni0010}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UniUtil#getUniNameOfCodePoint(int)}
   */
  @Test
  @DisplayName("Test getUniNameOfCodePoint(int); when SIZE; then return 'uni0010'")
  void testGetUniNameOfCodePoint_whenSize_thenReturnUni0010() {
    // Arrange, Act and Assert
    assertEquals("uni0010", UniUtil.getUniNameOfCodePoint(Short.SIZE));
  }
}
