package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScriptTableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ScriptTable#ScriptTable(LangSysTable, Map)}
   *   <li>{@link ScriptTable#getDefaultLangSysTable()}
   *   <li>{@link ScriptTable#getLangSysTables()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    LangSysTable defaultLangSysTable = new LangSysTable(1, 1, 3, new int[]{1, -1, 1, -1});

    HashMap<String, LangSysTable> langSysTables = new HashMap<>();

    // Act
    ScriptTable actualScriptTable = new ScriptTable(defaultLangSysTable, langSysTables);
    LangSysTable actualDefaultLangSysTable = actualScriptTable.getDefaultLangSysTable();
    Map<String, LangSysTable> actualLangSysTables = actualScriptTable.getLangSysTables();

    // Assert
    assertTrue(actualLangSysTables.isEmpty());
    assertSame(langSysTables, actualLangSysTables);
    assertSame(defaultLangSysTable, actualDefaultLangSysTable);
  }

  /**
   * Test {@link ScriptTable#toString()}.
   * <ul>
   *   <li>Then return
   * {@code ScriptTable[hasDefault=false,langSysRecordsCount=0]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScriptTable#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ScriptTable[hasDefault=false,langSysRecordsCount=0]'")
  void testToString_thenReturnScriptTableHasDefaultFalseLangSysRecordsCount0() {
    // Arrange, Act and Assert
    assertEquals("ScriptTable[hasDefault=false,langSysRecordsCount=0]",
        (new ScriptTable(null, new HashMap<>())).toString());
  }

  /**
   * Test {@link ScriptTable#toString()}.
   * <ul>
   *   <li>Then return
   * {@code ScriptTable[hasDefault=true,langSysRecordsCount=0]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScriptTable#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ScriptTable[hasDefault=true,langSysRecordsCount=0]'")
  void testToString_thenReturnScriptTableHasDefaultTrueLangSysRecordsCount0() {
    // Arrange
    LangSysTable defaultLangSysTable = new LangSysTable(1, 1, 3, new int[]{1, -1, 1, -1});

    // Act and Assert
    assertEquals("ScriptTable[hasDefault=true,langSysRecordsCount=0]",
        (new ScriptTable(defaultLangSysTable, new HashMap<>())).toString());
  }
}
