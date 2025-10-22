package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LigatureSetTableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LigatureSetTable#LigatureSetTable(int, LigatureTable[])}
   *   <li>{@link LigatureSetTable#toString()}
   *   <li>{@link LigatureSetTable#getLigatureCount()}
   *   <li>{@link LigatureSetTable#getLigatureTables()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LigatureSetTable.<init>(int, LigatureTable[])", "int LigatureSetTable.getLigatureCount()",
      "LigatureTable[] LigatureSetTable.getLigatureTables()", "String LigatureSetTable.toString()"})
  void testGettersAndSetters() {
    // Arrange
    LigatureTable[] ligatureTables = new LigatureTable[]{new LigatureTable(1, 3, new int[]{1, 2, 1, 2})};

    // Act
    LigatureSetTable actualLigatureSetTable = new LigatureSetTable(3, ligatureTables);
    String actualToStringResult = actualLigatureSetTable.toString();
    int actualLigatureCount = actualLigatureSetTable.getLigatureCount();

    // Assert
    assertEquals("LigatureSetTable[ligatureCount=3]", actualToStringResult);
    assertEquals(3, actualLigatureCount);
    assertSame(ligatureTables, actualLigatureSetTable.getLigatureTables());
  }
}
