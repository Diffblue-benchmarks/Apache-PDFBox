package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LangSysTableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LangSysTable.<init>(int, int, int, int[])", "int LangSysTable.getFeatureIndexCount()",
      "int[] LangSysTable.getFeatureIndices()", "int LangSysTable.getLookupOrder()",
      "int LangSysTable.getRequiredFeatureIndex()", "String LangSysTable.toString()"})
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
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualFeatureIndices);
  }
}
