package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.fontbox.ttf.table.gsub.LookupTypeSingleSubstFormat1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LookupListTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookupListTable#LookupListTable(int, LookupTable[])}
   *   <li>{@link LookupListTable#toString()}
   *   <li>{@link LookupListTable#getLookupCount()}
   *   <li>{@link LookupListTable#getLookups()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LookupListTable.<init>(int, LookupTable[])",
    "int LookupListTable.getLookupCount()",
    "LookupTable[] LookupListTable.getLookups()",
    "String LookupListTable.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LookupTypeSingleSubstFormat1 lookupTypeSingleSubstFormat1 =
        new LookupTypeSingleSubstFormat1(1, null, (short) 1);
    LookupSubTable[] subTables = new LookupSubTable[] {lookupTypeSingleSubstFormat1};
    LookupTable[] lookups = new LookupTable[] {new LookupTable(1, 1, 1, subTables)};

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
