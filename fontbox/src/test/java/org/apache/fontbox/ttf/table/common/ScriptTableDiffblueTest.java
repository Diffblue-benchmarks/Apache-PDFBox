package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class ScriptTableDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ScriptTable#ScriptTable(LangSysTable, Map)}
   *   <li>{@link ScriptTable#getDefaultLangSysTable()}
   *   <li>{@link ScriptTable#getLangSysTables()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link ScriptTable#toString()}
   */
  @Test
  void testToString() {
    // Arrange
    LangSysTable defaultLangSysTable = new LangSysTable(1, 1, 3, new int[]{1, -1, 1, -1});

    // Act and Assert
    assertEquals("ScriptTable[hasDefault=true,langSysRecordsCount=0]",
        (new ScriptTable(defaultLangSysTable, new HashMap<>())).toString());
  }

  /**
   * Method under test: {@link ScriptTable#toString()}
   */
  @Test
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals("ScriptTable[hasDefault=false,langSysRecordsCount=0]",
        (new ScriptTable(null, new HashMap<>())).toString());
  }

  /**
   * Method under test: {@link ScriptTable#toString()}
   */
  @Test
  void testToString3() {
    // Arrange
    HashMap<String, LangSysTable> langSysTables = new HashMap<>();
    langSysTables.computeIfPresent("ScriptTable[hasDefault=%s,langSysRecordsCount=%d]", mock(BiFunction.class));

    // Act and Assert
    assertEquals("ScriptTable[hasDefault=true,langSysRecordsCount=0]",
        (new ScriptTable(new LangSysTable(1, 1, 3, new int[]{1, -1, 1, -1}), langSysTables)).toString());
  }
}
