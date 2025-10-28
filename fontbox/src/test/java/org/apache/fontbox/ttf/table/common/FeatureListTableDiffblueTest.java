package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class FeatureListTableDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FeatureListTable#FeatureListTable(int, FeatureRecord[])}
   *   <li>{@link FeatureListTable#toString()}
   *   <li>{@link FeatureListTable#getFeatureCount()}
   *   <li>{@link FeatureListTable#getFeatureRecords()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    FeatureRecord[] featureRecords = new FeatureRecord[]{
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[]{1, -1, 1, -1}))};

    // Act
    FeatureListTable actualFeatureListTable = new FeatureListTable(3, featureRecords);
    String actualToStringResult = actualFeatureListTable.toString();
    int actualFeatureCount = actualFeatureListTable.getFeatureCount();

    // Assert
    assertEquals("FeatureListTable[featureCount=3]", actualToStringResult);
    assertEquals(3, actualFeatureCount);
    assertSame(featureRecords, actualFeatureListTable.getFeatureRecords());
  }
}
