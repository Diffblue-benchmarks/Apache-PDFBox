package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UniUtilDiffblueTest {
  /**
   * Test {@link UniUtil#getUniNameOfCodePoint(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return {@code uni-80000000}.
   * </ul>
   *
   * <p>Method under test: {@link UniUtil#getUniNameOfCodePoint(int)}
   */
  @Test
  @DisplayName("Test getUniNameOfCodePoint(int); when MIN_VALUE; then return 'uni-80000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UniUtil.getUniNameOfCodePoint(int)"})
  void testGetUniNameOfCodePoint_whenMin_value_thenReturnUni80000000() {
    // Arrange, Act and Assert
    assertEquals("uni-80000000", UniUtil.getUniNameOfCodePoint(Integer.MIN_VALUE));
  }

  /**
   * Test {@link UniUtil#getUniNameOfCodePoint(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code uni0001}.
   * </ul>
   *
   * <p>Method under test: {@link UniUtil#getUniNameOfCodePoint(int)}
   */
  @Test
  @DisplayName("Test getUniNameOfCodePoint(int); when one; then return 'uni0001'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UniUtil.getUniNameOfCodePoint(int)"})
  void testGetUniNameOfCodePoint_whenOne_thenReturnUni0001() {
    // Arrange, Act and Assert
    assertEquals("uni0001", UniUtil.getUniNameOfCodePoint(1));
  }

  /**
   * Test {@link UniUtil#getUniNameOfCodePoint(int)}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return {@code uni0010}.
   * </ul>
   *
   * <p>Method under test: {@link UniUtil#getUniNameOfCodePoint(int)}
   */
  @Test
  @DisplayName("Test getUniNameOfCodePoint(int); when SIZE; then return 'uni0010'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UniUtil.getUniNameOfCodePoint(int)"})
  void testGetUniNameOfCodePoint_whenSize_thenReturnUni0010() {
    // Arrange, Act and Assert
    assertEquals("uni0010", UniUtil.getUniNameOfCodePoint(Short.SIZE));
  }
}
