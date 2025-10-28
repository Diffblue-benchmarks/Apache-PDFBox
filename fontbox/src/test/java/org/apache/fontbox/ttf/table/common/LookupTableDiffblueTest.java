package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.fontbox.ttf.table.gsub.LookupTypeSingleSubstFormat1;
import org.junit.jupiter.api.Test;

class LookupTableDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LookupTable#LookupTable(int, int, int, LookupSubTable[])}
   *   <li>{@link LookupTable#toString()}
   *   <li>{@link LookupTable#getLookupFlag()}
   *   <li>{@link LookupTable#getLookupType()}
   *   <li>{@link LookupTable#getMarkFilteringSet()}
   *   <li>{@link LookupTable#getSubTables()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    LookupSubTable[] subTables = new LookupSubTable[]{
        new LookupTypeSingleSubstFormat1(1, new CoverageTableFormat1(1, new int[]{1, -1, 1, -1}), (short) 1)};

    // Act
    LookupTable actualLookupTable = new LookupTable(1, 1, 1, subTables);
    String actualToStringResult = actualLookupTable.toString();
    int actualLookupFlag = actualLookupTable.getLookupFlag();
    int actualLookupType = actualLookupTable.getLookupType();
    int actualMarkFilteringSet = actualLookupTable.getMarkFilteringSet();

    // Assert
    assertEquals("LookupTable[lookupType=1,lookupFlag=1,markFilteringSet=1]", actualToStringResult);
    assertEquals(1, actualLookupFlag);
    assertEquals(1, actualLookupType);
    assertEquals(1, actualMarkFilteringSet);
    assertSame(subTables, actualLookupTable.getSubTables());
  }
}
