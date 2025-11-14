package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.fontbox.ttf.table.gsub.LookupTypeSingleSubstFormat1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LookupSubTableDiffblueTest {
  /**
   * Test {@link LookupSubTable#getSubstFormat()}.
   *
   * <p>Method under test: {@link LookupSubTable#getSubstFormat()}
   */
  @Test
  @DisplayName("Test getSubstFormat()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LookupSubTable.getSubstFormat()"})
  void testGetSubstFormat() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[] {1, -1, 1, -1});
    LookupTypeSingleSubstFormat1 lookupTypeSingleSubstFormat1 =
        new LookupTypeSingleSubstFormat1(1, coverageTable, (short) 1);

    // Act and Assert
    assertEquals(1, lookupTypeSingleSubstFormat1.getSubstFormat());
  }

  /**
   * Test {@link LookupSubTable#getCoverageTable()}.
   *
   * <p>Method under test: {@link LookupSubTable#getCoverageTable()}
   */
  @Test
  @DisplayName("Test getCoverageTable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.fontbox.ttf.table.common.CoverageTable LookupSubTable.getCoverageTable()"
  })
  void testGetCoverageTable() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[] {1, -1, 1, -1});
    LookupTypeSingleSubstFormat1 lookupTypeSingleSubstFormat1 =
        new LookupTypeSingleSubstFormat1(1, coverageTable, (short) 1);

    // Act and Assert
    assertSame(coverageTable, lookupTypeSingleSubstFormat1.getCoverageTable());
  }
}
