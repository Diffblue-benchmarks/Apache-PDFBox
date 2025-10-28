package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.fontbox.ttf.table.gsub.LookupTypeSingleSubstFormat1;
import org.junit.jupiter.api.Test;

class LookupListTableDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LookupListTable#LookupListTable(int, LookupTable[])}
   *   <li>{@link LookupListTable#toString()}
   *   <li>{@link LookupListTable#getLookupCount()}
   *   <li>{@link LookupListTable#getLookups()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    LookupTable[] lookups = new LookupTable[]{
        new LookupTable(1, 1, 1, new LookupSubTable[]{new LookupTypeSingleSubstFormat1(1, null, (short) 1)})};

    // Act
    LookupListTable actualLookupListTable = new LookupListTable(3, lookups);
    String actualToStringResult = actualLookupListTable.toString();
    int actualLookupCount = actualLookupListTable.getLookupCount();

    // Assert
    assertEquals("LookupListTable[lookupCount=3]", actualToStringResult);
    assertEquals(3, actualLookupCount);
    assertSame(lookups, actualLookupListTable.getLookups());
  }
}
