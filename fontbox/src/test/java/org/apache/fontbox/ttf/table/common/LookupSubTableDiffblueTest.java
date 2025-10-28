package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.fontbox.ttf.table.gsub.LookupTypeSingleSubstFormat1;
import org.junit.jupiter.api.Test;

class LookupSubTableDiffblueTest {
  /**
   * Method under test: {@link LookupSubTable#getSubstFormat()}
   */
  @Test
  void testGetSubstFormat() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new LookupTypeSingleSubstFormat1(1, new CoverageTableFormat1(1, new int[]{1, -1, 1, -1}), (short) 1))
            .getSubstFormat());
  }

  /**
   * Method under test: {@link LookupSubTable#getCoverageTable()}
   */
  @Test
  void testGetCoverageTable() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[]{1, -1, 1, -1});

    // Act and Assert
    assertSame(coverageTable, (new LookupTypeSingleSubstFormat1(1, coverageTable, (short) 1)).getCoverageTable());
  }
}
