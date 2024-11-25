package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LigatureTableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LigatureTable#LigatureTable(int, int, int[])}
   *   <li>{@link LigatureTable#toString()}
   *   <li>{@link LigatureTable#getComponentCount()}
   *   <li>{@link LigatureTable#getComponentGlyphIDs()}
   *   <li>{@link LigatureTable#getLigatureGlyph()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    int[] componentGlyphIDs = new int[]{1, 2, 1, 2};

    // Act
    LigatureTable actualLigatureTable = new LigatureTable(1, 3, componentGlyphIDs);
    String actualToStringResult = actualLigatureTable.toString();
    int actualComponentCount = actualLigatureTable.getComponentCount();
    int[] actualComponentGlyphIDs = actualLigatureTable.getComponentGlyphIDs();

    // Assert
    assertEquals("LigatureTable[ligatureGlyph=1, componentCount=3]", actualToStringResult);
    assertEquals(1, actualLigatureTable.getLigatureGlyph());
    assertEquals(3, actualComponentCount);
    assertSame(componentGlyphIDs, actualComponentGlyphIDs);
  }
}
