package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.fontbox.ttf.table.common.CoverageTable;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.junit.jupiter.api.Test;

class LookupTypeSingleSubstFormat2DiffblueTest {
  /**
   * Method under test:
   * {@link LookupTypeSingleSubstFormat2#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution() {
    // Arrange, Act and Assert
    assertEquals(2,
        (new LookupTypeSingleSubstFormat2(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), new int[]{1, 2, 1, 2}))
            .doSubstitution(1, 1));
    assertEquals(1,
        (new LookupTypeSingleSubstFormat2(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), new int[]{1, 2, 1, 2}))
            .doSubstitution(1, 0));
    assertEquals(1,
        (new LookupTypeSingleSubstFormat2(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), new int[]{1, 2, 1, 2}))
            .doSubstitution(1, -1));
    assertEquals(2,
        (new LookupTypeSingleSubstFormat2(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), new int[]{1, 2, 1, 2}))
            .doSubstitution(2, 1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LookupTypeSingleSubstFormat2#LookupTypeSingleSubstFormat2(int, CoverageTable, int[])}
   *   <li>{@link LookupTypeSingleSubstFormat2#toString()}
   *   <li>{@link LookupTypeSingleSubstFormat2#getSubstituteGlyphIDs()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[]{1, -1, 1, -1});

    int[] substituteGlyphIDs = new int[]{1, 2, 1, 2};

    // Act
    LookupTypeSingleSubstFormat2 actualLookupTypeSingleSubstFormat2 = new LookupTypeSingleSubstFormat2(1, coverageTable,
        substituteGlyphIDs);
    String actualToStringResult = actualLookupTypeSingleSubstFormat2.toString();
    int[] actualSubstituteGlyphIDs = actualLookupTypeSingleSubstFormat2.getSubstituteGlyphIDs();

    // Assert
    assertEquals("LookupTypeSingleSubstFormat2[substFormat=1,substituteGlyphIDs=[1, 2, 1, 2]]", actualToStringResult);
    assertEquals(1, actualLookupTypeSingleSubstFormat2.getSubstFormat());
    assertSame(coverageTable, actualLookupTypeSingleSubstFormat2.getCoverageTable());
    assertSame(substituteGlyphIDs, actualSubstituteGlyphIDs);
  }
}
