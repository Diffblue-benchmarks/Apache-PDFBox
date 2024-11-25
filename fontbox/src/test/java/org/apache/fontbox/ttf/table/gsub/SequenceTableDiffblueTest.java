package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SequenceTableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SequenceTable#SequenceTable(int, int[])}
   *   <li>{@link SequenceTable#toString()}
   *   <li>{@link SequenceTable#getGlyphCount()}
   *   <li>{@link SequenceTable#getSubstituteGlyphIDs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    int[] substituteGlyphIDs = new int[]{1, 2, 1, 2};

    // Act
    SequenceTable actualSequenceTable = new SequenceTable(3, substituteGlyphIDs);
    String actualToStringResult = actualSequenceTable.toString();
    int actualGlyphCount = actualSequenceTable.getGlyphCount();

    // Assert
    assertEquals("SequenceTable{glyphCount=3, substituteGlyphIDs=[1, 2, 1, 2]}", actualToStringResult);
    assertEquals(3, actualGlyphCount);
    assertSame(substituteGlyphIDs, actualSequenceTable.getSubstituteGlyphIDs());
  }
}
