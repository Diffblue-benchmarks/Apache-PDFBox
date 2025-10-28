package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CoverageTableDiffblueTest {
  /**
   * Method under test: {@link CoverageTable#getCoverageFormat()}
   */
  @Test
  void testGetCoverageFormat() {
    // Arrange, Act and Assert
    assertEquals(1, (new CoverageTableFormat1(1, new int[]{1, -1, 1, -1})).getCoverageFormat());
  }
}
