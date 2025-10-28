package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.fontbox.ttf.table.common.CoverageTable;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.junit.jupiter.api.Test;

class LookupTypeSingleSubstFormat1DiffblueTest {
  /**
   * Method under test:
   * {@link LookupTypeSingleSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution() {
    // Arrange, Act and Assert
    assertEquals(8, (new LookupTypeSingleSubstFormat1(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), (short) 7))
        .doSubstitution(1, 1));
    assertEquals(8, (new LookupTypeSingleSubstFormat1(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), (short) 7))
        .doSubstitution(1, 0));
    assertEquals(1, (new LookupTypeSingleSubstFormat1(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), (short) 7))
        .doSubstitution(1, -1));
    assertEquals(9, (new LookupTypeSingleSubstFormat1(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), (short) 7))
        .doSubstitution(2, 1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LookupTypeSingleSubstFormat1#LookupTypeSingleSubstFormat1(int, CoverageTable, short)}
   *   <li>{@link LookupTypeSingleSubstFormat1#toString()}
   *   <li>{@link LookupTypeSingleSubstFormat1#getDeltaGlyphID()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[]{1, -1, 1, -1});

    // Act
    LookupTypeSingleSubstFormat1 actualLookupTypeSingleSubstFormat1 = new LookupTypeSingleSubstFormat1(1, coverageTable,
        (short) 1);
    String actualToStringResult = actualLookupTypeSingleSubstFormat1.toString();
    short actualDeltaGlyphID = actualLookupTypeSingleSubstFormat1.getDeltaGlyphID();

    // Assert
    assertEquals("LookupTypeSingleSubstFormat1[substFormat=1,deltaGlyphID=1]", actualToStringResult);
    assertEquals(1, actualLookupTypeSingleSubstFormat1.getSubstFormat());
    assertEquals((short) 1, actualDeltaGlyphID);
    assertSame(coverageTable, actualLookupTypeSingleSubstFormat1.getCoverageTable());
  }
}
