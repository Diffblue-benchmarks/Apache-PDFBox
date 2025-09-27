package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FeatureTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FeatureTable#FeatureTable(int, int, int[])}
   *   <li>{@link FeatureTable#toString()}
   *   <li>{@link FeatureTable#getFeatureParams()}
   *   <li>{@link FeatureTable#getLookupIndexCount()}
   *   <li>{@link FeatureTable#getLookupListIndices()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FeatureTable.<init>(int, int, int[])",
    "int FeatureTable.getFeatureParams()",
    "int FeatureTable.getLookupIndexCount()",
    "int[] FeatureTable.getLookupListIndices()",
    "String FeatureTable.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    int[] lookupListIndices = new int[] {1, -1, 1, -1};

    // Act
    FeatureTable actualFeatureTable = new FeatureTable(1000, 3, lookupListIndices);
    String actualToStringResult = actualFeatureTable.toString();
    int actualFeatureParams = actualFeatureTable.getFeatureParams();
    int actualLookupIndexCount = actualFeatureTable.getLookupIndexCount();
    int[] actualLookupListIndices = actualFeatureTable.getLookupListIndices();

    // Assert
    assertEquals("FeatureTable[lookupListIndicesCount=4]", actualToStringResult);
    assertEquals(1000, actualFeatureParams);
    assertEquals(3, actualLookupIndexCount);
    assertSame(lookupListIndices, actualLookupListIndices);
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualLookupListIndices);
  }
}
