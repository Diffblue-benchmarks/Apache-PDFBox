package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlternateSetTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlternateSetTable#AlternateSetTable(int, int[])}
   *   <li>{@link AlternateSetTable#toString()}
   *   <li>{@link AlternateSetTable#getAlternateGlyphIDs()}
   *   <li>{@link AlternateSetTable#getGlyphCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlternateSetTable.<init>(int, int[])",
    "int[] AlternateSetTable.getAlternateGlyphIDs()",
    "int AlternateSetTable.getGlyphCount()",
    "String AlternateSetTable.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    int[] alternateGlyphIDs = new int[] {1, 2, 1, 2};

    // Act
    AlternateSetTable actualAlternateSetTable = new AlternateSetTable(3, alternateGlyphIDs);
    String actualToStringResult = actualAlternateSetTable.toString();
    int[] actualAlternateGlyphIDs = actualAlternateSetTable.getAlternateGlyphIDs();

    // Assert
    assertEquals(
        "AlternateSetTable{glyphCount=3, alternateGlyphIDs=[1, 2, 1, 2]}", actualToStringResult);
    assertEquals(3, actualAlternateSetTable.getGlyphCount());
    assertSame(alternateGlyphIDs, actualAlternateGlyphIDs);
    assertArrayEquals(new int[] {1, 2, 1, 2}, actualAlternateGlyphIDs);
  }
}
