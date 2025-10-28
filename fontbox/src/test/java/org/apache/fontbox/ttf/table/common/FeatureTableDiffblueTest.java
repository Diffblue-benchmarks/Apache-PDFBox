package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class FeatureTableDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FeatureTable#FeatureTable(int, int, int[])}
   *   <li>{@link FeatureTable#toString()}
   *   <li>{@link FeatureTable#getFeatureParams()}
   *   <li>{@link FeatureTable#getLookupIndexCount()}
   *   <li>{@link FeatureTable#getLookupListIndices()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    int[] lookupListIndices = new int[]{1, -1, 1, -1};

    // Act
    FeatureTable actualFeatureTable = new FeatureTable(1000, 3, lookupListIndices);
    String actualToStringResult = actualFeatureTable.toString();
    int actualFeatureParams = actualFeatureTable.getFeatureParams();
    int actualLookupIndexCount = actualFeatureTable.getLookupIndexCount();

    // Assert
    assertEquals("FeatureTable[lookupListIndicesCount=4]", actualToStringResult);
    assertEquals(1000, actualFeatureParams);
    assertEquals(3, actualLookupIndexCount);
    assertSame(lookupListIndices, actualFeatureTable.getLookupListIndices());
  }
}
