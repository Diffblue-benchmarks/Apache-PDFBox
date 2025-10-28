package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class UniUtilDiffblueTest {
  /**
   * Method under test: {@link UniUtil#getUniNameOfCodePoint(int)}
   */
  @Test
  void testGetUniNameOfCodePoint() {
    // Arrange, Act and Assert
    assertEquals("uni0001", UniUtil.getUniNameOfCodePoint(1));
    assertEquals("uni0010", UniUtil.getUniNameOfCodePoint(Short.SIZE));
    assertEquals("uni-80000000", UniUtil.getUniNameOfCodePoint(Integer.MIN_VALUE));
  }
}
