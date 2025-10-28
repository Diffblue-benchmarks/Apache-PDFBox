package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class FeatureRecordDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FeatureRecord#FeatureRecord(String, FeatureTable)}
   *   <li>{@link FeatureRecord#toString()}
   *   <li>{@link FeatureRecord#getFeatureTable()}
   *   <li>{@link FeatureRecord#getFeatureTag()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    FeatureTable featureTable = new FeatureTable(1000, 3, new int[]{1, -1, 1, -1});

    // Act
    FeatureRecord actualFeatureRecord = new FeatureRecord("Feature Tag", featureTable);
    String actualToStringResult = actualFeatureRecord.toString();
    FeatureTable actualFeatureTable = actualFeatureRecord.getFeatureTable();

    // Assert
    assertEquals("Feature Tag", actualFeatureRecord.getFeatureTag());
    assertEquals("FeatureRecord[featureTag=Feature Tag]", actualToStringResult);
    assertSame(featureTable, actualFeatureTable);
  }
}
