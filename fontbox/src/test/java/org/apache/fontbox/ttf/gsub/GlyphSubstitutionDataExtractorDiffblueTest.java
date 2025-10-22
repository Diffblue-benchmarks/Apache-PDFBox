package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.apache.fontbox.ttf.table.common.FeatureListTable;
import org.apache.fontbox.ttf.table.common.FeatureRecord;
import org.apache.fontbox.ttf.table.common.FeatureTable;
import org.apache.fontbox.ttf.table.common.LangSysTable;
import org.apache.fontbox.ttf.table.common.LookupListTable;
import org.apache.fontbox.ttf.table.common.LookupSubTable;
import org.apache.fontbox.ttf.table.common.LookupTable;
import org.apache.fontbox.ttf.table.common.ScriptTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyphSubstitutionDataExtractorDiffblueTest {
  /**
   * Test {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)} with {@code scriptName}, {@code scriptTable}, {@code featureListTable}, {@code lookupListTable}.
   * <p>
   * Method under test: {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)}
   */
  @Test
  @DisplayName("Test getGsubData(String, ScriptTable, FeatureListTable, LookupListTable) with 'scriptName', 'scriptTable', 'featureListTable', 'lookupListTable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GsubData GlyphSubstitutionDataExtractor.getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)"})
  void testGetGsubDataWithScriptNameScriptTableFeatureListTableLookupListTable() {
    // Arrange
    GlyphSubstitutionDataExtractor glyphSubstitutionDataExtractor = new GlyphSubstitutionDataExtractor();
    LangSysTable defaultLangSysTable = new LangSysTable(1, 1, 3, new int[]{});

    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());

    FeatureListTable featureListTable = new FeatureListTable(3,
        new FeatureRecord[]{new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[]{1, -1, 1, -1}))});

    // Act
    GsubData actualGsubData = glyphSubstitutionDataExtractor.getGsubData("Script Name", scriptTable, featureListTable,
        new LookupListTable(3,
            new LookupTable[]{new LookupTable(1, 1, 1, new LookupSubTable[]{mock(LookupSubTable.class)})}));

    // Assert
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Name", actualGsubData.getActiveScriptName());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(actualGsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)} with {@code scriptName}, {@code scriptTable}, {@code featureListTable}, {@code lookupListTable}.
   * <p>
   * Method under test: {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)}
   */
  @Test
  @DisplayName("Test getGsubData(String, ScriptTable, FeatureListTable, LookupListTable) with 'scriptName', 'scriptTable', 'featureListTable', 'lookupListTable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GsubData GlyphSubstitutionDataExtractor.getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)"})
  void testGetGsubDataWithScriptNameScriptTableFeatureListTableLookupListTable2() {
    // Arrange
    GlyphSubstitutionDataExtractor glyphSubstitutionDataExtractor = new GlyphSubstitutionDataExtractor();
    ScriptTable scriptTable = new ScriptTable(null, new HashMap<>());

    FeatureListTable featureListTable = new FeatureListTable(3,
        new FeatureRecord[]{new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[]{1, -1, 1, -1}))});

    // Act
    GsubData actualGsubData = glyphSubstitutionDataExtractor.getGsubData("Script Name", scriptTable, featureListTable,
        new LookupListTable(3,
            new LookupTable[]{new LookupTable(1, 1, 1, new LookupSubTable[]{mock(LookupSubTable.class)})}));

    // Assert
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Name", actualGsubData.getActiveScriptName());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(actualGsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)} with {@code scriptName}, {@code scriptTable}, {@code featureListTable}, {@code lookupListTable}.
   * <p>
   * Method under test: {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)}
   */
  @Test
  @DisplayName("Test getGsubData(String, ScriptTable, FeatureListTable, LookupListTable) with 'scriptName', 'scriptTable', 'featureListTable', 'lookupListTable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GsubData GlyphSubstitutionDataExtractor.getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)"})
  void testGetGsubDataWithScriptNameScriptTableFeatureListTableLookupListTable3() {
    // Arrange
    GlyphSubstitutionDataExtractor glyphSubstitutionDataExtractor = new GlyphSubstitutionDataExtractor();

    HashMap<String, LangSysTable> langSysTables = new HashMap<>();
    langSysTables.put("foo", new LangSysTable(1, 1, 3, new int[]{4, 1, 4, 1}));
    ScriptTable scriptTable = new ScriptTable(new LangSysTable(1, 1, 3, new int[]{}), langSysTables);

    FeatureListTable featureListTable = new FeatureListTable(3,
        new FeatureRecord[]{new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[]{1, -1, 1, -1}))});

    // Act
    GsubData actualGsubData = glyphSubstitutionDataExtractor.getGsubData("Script Name", scriptTable, featureListTable,
        new LookupListTable(3,
            new LookupTable[]{new LookupTable(1, 1, 1, new LookupSubTable[]{mock(LookupSubTable.class)})}));

    // Assert
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Name", actualGsubData.getActiveScriptName());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(actualGsubData.getSupportedFeatures().isEmpty());
  }
}
