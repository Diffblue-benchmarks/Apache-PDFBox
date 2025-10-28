package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class LangSysTableDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LangSysTable#LangSysTable(int, int, int, int[])}
   *   <li>{@link LangSysTable#toString()}
   *   <li>{@link LangSysTable#getFeatureIndexCount()}
   *   <li>{@link LangSysTable#getFeatureIndices()}
   *   <li>{@link LangSysTable#getLookupOrder()}
   *   <li>{@link LangSysTable#getRequiredFeatureIndex()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    int[] featureIndices = new int[]{1, -1, 1, -1};

    // Act
    LangSysTable actualLangSysTable = new LangSysTable(1, 1, 3, featureIndices);
    String actualToStringResult = actualLangSysTable.toString();
    int actualFeatureIndexCount = actualLangSysTable.getFeatureIndexCount();
    int[] actualFeatureIndices = actualLangSysTable.getFeatureIndices();
    int actualLookupOrder = actualLangSysTable.getLookupOrder();

    // Assert
    assertEquals("LangSysTable[requiredFeatureIndex=1]", actualToStringResult);
    assertEquals(1, actualLookupOrder);
    assertEquals(1, actualLangSysTable.getRequiredFeatureIndex());
    assertEquals(3, actualFeatureIndexCount);
    assertSame(featureIndices, actualFeatureIndices);
  }
}
