package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SequenceTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SequenceTable#SequenceTable(int, int[])}
   *   <li>{@link SequenceTable#toString()}
   *   <li>{@link SequenceTable#getGlyphCount()}
   *   <li>{@link SequenceTable#getSubstituteGlyphIDs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SequenceTable.<init>(int, int[])",
    "int SequenceTable.getGlyphCount()",
    "int[] SequenceTable.getSubstituteGlyphIDs()",
    "String SequenceTable.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    int[] substituteGlyphIDs = new int[] {1, 2, 1, 2};

    // Act
    SequenceTable actualSequenceTable = new SequenceTable(3, substituteGlyphIDs);
    String actualToStringResult = actualSequenceTable.toString();
    int actualGlyphCount = actualSequenceTable.getGlyphCount();
    int[] actualSubstituteGlyphIDs = actualSequenceTable.getSubstituteGlyphIDs();

    // Assert
    assertEquals(
        "SequenceTable{glyphCount=3, substituteGlyphIDs=[1, 2, 1, 2]}", actualToStringResult);
    assertEquals(3, actualGlyphCount);
    assertSame(substituteGlyphIDs, actualSubstituteGlyphIDs);
    assertArrayEquals(new int[] {1, 2, 1, 2}, actualSubstituteGlyphIDs);
  }
}
