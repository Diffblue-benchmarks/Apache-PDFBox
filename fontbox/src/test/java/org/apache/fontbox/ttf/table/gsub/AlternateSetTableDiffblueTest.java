package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class AlternateSetTableDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlternateSetTable#AlternateSetTable(int, int[])}
   *   <li>{@link AlternateSetTable#toString()}
   *   <li>{@link AlternateSetTable#getAlternateGlyphIDs()}
   *   <li>{@link AlternateSetTable#getGlyphCount()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    int[] alternateGlyphIDs = new int[]{1, 2, 1, 2};

    // Act
    AlternateSetTable actualAlternateSetTable = new AlternateSetTable(3, alternateGlyphIDs);
    String actualToStringResult = actualAlternateSetTable.toString();
    int[] actualAlternateGlyphIDs = actualAlternateSetTable.getAlternateGlyphIDs();

    // Assert
    assertEquals("AlternateSetTable{glyphCount=3, alternateGlyphIDs=[1, 2, 1, 2]}", actualToStringResult);
    assertEquals(3, actualAlternateSetTable.getGlyphCount());
    assertSame(alternateGlyphIDs, actualAlternateGlyphIDs);
  }
}
