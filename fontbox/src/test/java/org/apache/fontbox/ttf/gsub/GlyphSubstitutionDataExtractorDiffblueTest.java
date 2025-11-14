package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Set;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.apache.fontbox.ttf.table.common.FeatureListTable;
import org.apache.fontbox.ttf.table.common.FeatureRecord;
import org.apache.fontbox.ttf.table.common.FeatureTable;
import org.apache.fontbox.ttf.table.common.LangSysTable;
import org.apache.fontbox.ttf.table.common.LookupListTable;
import org.apache.fontbox.ttf.table.common.LookupSubTable;
import org.apache.fontbox.ttf.table.common.LookupTable;
import org.apache.fontbox.ttf.table.common.ScriptTable;
import org.apache.fontbox.ttf.table.gsub.LookupTypeSingleSubstFormat1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyphSubstitutionDataExtractorDiffblueTest {
  /**
   * Test {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable,
   * LookupListTable)} with {@code scriptName}, {@code scriptTable}, {@code featureListTable},
   * {@code lookupListTable}.
   *
   * <p>Method under test: {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable,
   * FeatureListTable, LookupListTable)}
   */
  @Test
  @DisplayName(
      "Test getGsubData(String, ScriptTable, FeatureListTable, LookupListTable) with 'scriptName', 'scriptTable', 'featureListTable', 'lookupListTable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GsubData GlyphSubstitutionDataExtractor.getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)"
  })
  void testGetGsubDataWithScriptNameScriptTableFeatureListTableLookupListTable() {
    // Arrange
    GlyphSubstitutionDataExtractor glyphSubstitutionDataExtractor =
        new GlyphSubstitutionDataExtractor();
    LangSysTable defaultLangSysTable = new LangSysTable(1, 1, 3, new int[] {});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {1, -1, 1, -1}));
    FeatureRecord[] featureRecords = new FeatureRecord[] {featureRecord};
    FeatureListTable featureListTable = new FeatureListTable(3, featureRecords);
    LookupSubTable[] subTables = new LookupSubTable[] {mock(LookupSubTable.class)};
    LookupTable[] lookups = new LookupTable[] {new LookupTable(1, 1, 1, subTables)};
    LookupListTable lookupListTable = new LookupListTable(3, lookups);

    // Act
    GsubData actualGsubData =
        glyphSubstitutionDataExtractor.getGsubData(
            "Script Name", scriptTable, featureListTable, lookupListTable);

    // Assert
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Name", actualGsubData.getActiveScriptName());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(actualGsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable,
   * LookupListTable)} with {@code scriptName}, {@code scriptTable}, {@code featureListTable},
   * {@code lookupListTable}.
   *
   * <p>Method under test: {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable,
   * FeatureListTable, LookupListTable)}
   */
  @Test
  @DisplayName(
      "Test getGsubData(String, ScriptTable, FeatureListTable, LookupListTable) with 'scriptName', 'scriptTable', 'featureListTable', 'lookupListTable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GsubData GlyphSubstitutionDataExtractor.getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)"
  })
  void testGetGsubDataWithScriptNameScriptTableFeatureListTableLookupListTable2() {
    // Arrange
    GlyphSubstitutionDataExtractor glyphSubstitutionDataExtractor =
        new GlyphSubstitutionDataExtractor();
    LangSysTable defaultLangSysTable =
        new LangSysTable(1, 1, 3, new int[] {4, 1, 4, 1, 4, 1, 4, 1});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {1, -1, 1, -1}));
    FeatureRecord[] featureRecords = new FeatureRecord[] {featureRecord};
    FeatureListTable featureListTable = new FeatureListTable(3, featureRecords);
    LookupSubTable[] subTables = new LookupSubTable[] {mock(LookupSubTable.class)};
    LookupTable[] lookups = new LookupTable[] {new LookupTable(1, 1, 1, subTables)};
    LookupListTable lookupListTable = new LookupListTable(3, lookups);

    // Act
    GsubData actualGsubData =
        glyphSubstitutionDataExtractor.getGsubData(
            "Script Name", scriptTable, featureListTable, lookupListTable);

    // Assert
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Name", actualGsubData.getActiveScriptName());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(actualGsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable,
   * LookupListTable)} with {@code scriptName}, {@code scriptTable}, {@code featureListTable},
   * {@code lookupListTable}.
   *
   * <p>Method under test: {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable,
   * FeatureListTable, LookupListTable)}
   */
  @Test
  @DisplayName(
      "Test getGsubData(String, ScriptTable, FeatureListTable, LookupListTable) with 'scriptName', 'scriptTable', 'featureListTable', 'lookupListTable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GsubData GlyphSubstitutionDataExtractor.getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)"
  })
  void testGetGsubDataWithScriptNameScriptTableFeatureListTableLookupListTable3() {
    // Arrange
    GlyphSubstitutionDataExtractor glyphSubstitutionDataExtractor =
        new GlyphSubstitutionDataExtractor();
    ScriptTable scriptTable = new ScriptTable(null, new HashMap<>());
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {1, -1, 1, -1}));
    FeatureRecord[] featureRecords = new FeatureRecord[] {featureRecord};
    FeatureListTable featureListTable = new FeatureListTable(3, featureRecords);
    LookupSubTable[] subTables = new LookupSubTable[] {mock(LookupSubTable.class)};
    LookupTable[] lookups = new LookupTable[] {new LookupTable(1, 1, 1, subTables)};
    LookupListTable lookupListTable = new LookupListTable(3, lookups);

    // Act
    GsubData actualGsubData =
        glyphSubstitutionDataExtractor.getGsubData(
            "Script Name", scriptTable, featureListTable, lookupListTable);

    // Assert
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Name", actualGsubData.getActiveScriptName());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(actualGsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable,
   * LookupListTable)} with {@code scriptName}, {@code scriptTable}, {@code featureListTable},
   * {@code lookupListTable}.
   *
   * <p>Method under test: {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable,
   * FeatureListTable, LookupListTable)}
   */
  @Test
  @DisplayName(
      "Test getGsubData(String, ScriptTable, FeatureListTable, LookupListTable) with 'scriptName', 'scriptTable', 'featureListTable', 'lookupListTable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GsubData GlyphSubstitutionDataExtractor.getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)"
  })
  void testGetGsubDataWithScriptNameScriptTableFeatureListTableLookupListTable4() {
    // Arrange
    GlyphSubstitutionDataExtractor glyphSubstitutionDataExtractor =
        new GlyphSubstitutionDataExtractor();
    LangSysTable defaultLangSysTable =
        new LangSysTable(1, 1, 3, new int[] {4, 1, 4, 1, 4, 1, 4, 1});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {4, 1, 4, 1}));
    FeatureRecord featureRecord2 =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {4, 1, 4, 1}));
    FeatureListTable featureListTable =
        new FeatureListTable(3, new FeatureRecord[] {featureRecord, featureRecord2});
    LookupSubTable[] subTables = new LookupSubTable[] {mock(LookupSubTable.class)};
    LookupTable[] lookups = new LookupTable[] {new LookupTable(1, 1, 1, subTables)};
    LookupListTable lookupListTable = new LookupListTable(3, lookups);

    // Act
    GsubData actualGsubData =
        glyphSubstitutionDataExtractor.getGsubData(
            "Script Name", scriptTable, featureListTable, lookupListTable);

    // Assert
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Name", actualGsubData.getActiveScriptName());
    Set<String> supportedFeatures = actualGsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(supportedFeatures.contains("Feature Tag"));
  }

  /**
   * Test {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable,
   * LookupListTable)} with {@code scriptName}, {@code scriptTable}, {@code featureListTable},
   * {@code lookupListTable}.
   *
   * <p>Method under test: {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable,
   * FeatureListTable, LookupListTable)}
   */
  @Test
  @DisplayName(
      "Test getGsubData(String, ScriptTable, FeatureListTable, LookupListTable) with 'scriptName', 'scriptTable', 'featureListTable', 'lookupListTable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GsubData GlyphSubstitutionDataExtractor.getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)"
  })
  void testGetGsubDataWithScriptNameScriptTableFeatureListTableLookupListTable5() {
    // Arrange
    GlyphSubstitutionDataExtractor glyphSubstitutionDataExtractor =
        new GlyphSubstitutionDataExtractor();

    HashMap<String, LangSysTable> langSysTables = new HashMap<>();
    langSysTables.put("Key", new LangSysTable(1, 1, 3, new int[] {}));
    ScriptTable scriptTable =
        new ScriptTable(new LangSysTable(1, 1, 3, new int[] {}), langSysTables);
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {1, -1, 1, -1}));
    FeatureRecord[] featureRecords = new FeatureRecord[] {featureRecord};
    FeatureListTable featureListTable = new FeatureListTable(3, featureRecords);
    LookupSubTable[] subTables = new LookupSubTable[] {mock(LookupSubTable.class)};
    LookupTable[] lookups = new LookupTable[] {new LookupTable(1, 1, 1, subTables)};
    LookupListTable lookupListTable = new LookupListTable(3, lookups);

    // Act
    GsubData actualGsubData =
        glyphSubstitutionDataExtractor.getGsubData(
            "Script Name", scriptTable, featureListTable, lookupListTable);

    // Assert
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Name", actualGsubData.getActiveScriptName());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(actualGsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable, FeatureListTable,
   * LookupListTable)} with {@code scriptName}, {@code scriptTable}, {@code featureListTable},
   * {@code lookupListTable}.
   *
   * <p>Method under test: {@link GlyphSubstitutionDataExtractor#getGsubData(String, ScriptTable,
   * FeatureListTable, LookupListTable)}
   */
  @Test
  @DisplayName(
      "Test getGsubData(String, ScriptTable, FeatureListTable, LookupListTable) with 'scriptName', 'scriptTable', 'featureListTable', 'lookupListTable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GsubData GlyphSubstitutionDataExtractor.getGsubData(String, ScriptTable, FeatureListTable, LookupListTable)"
  })
  void testGetGsubDataWithScriptNameScriptTableFeatureListTableLookupListTable6() {
    // Arrange
    GlyphSubstitutionDataExtractor glyphSubstitutionDataExtractor =
        new GlyphSubstitutionDataExtractor();
    LangSysTable defaultLangSysTable =
        new LangSysTable(1, 1, 3, new int[] {4, 1, 4, 1, 4, 1, 4, 1});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {4, 1, 4, 1}));
    FeatureRecord featureRecord2 =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {4, 1, 4, 1}));
    FeatureListTable featureListTable =
        new FeatureListTable(3, new FeatureRecord[] {featureRecord, featureRecord2});
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(4, new int[] {4, 2, 4, 2});
    LookupTypeSingleSubstFormat1 lookupTypeSingleSubstFormat1 =
        new LookupTypeSingleSubstFormat1(4, coverageTable, (short) 4);
    LookupSubTable[] subTables = new LookupSubTable[] {lookupTypeSingleSubstFormat1};
    LookupTable lookupTable = new LookupTable(4, 4, 4, subTables);
    CoverageTableFormat1 coverageTable2 = new CoverageTableFormat1(4, new int[] {4, 2, 4, 2});
    LookupTypeSingleSubstFormat1 lookupTypeSingleSubstFormat12 =
        new LookupTypeSingleSubstFormat1(4, coverageTable2, (short) 4);
    LookupSubTable[] subTables2 = new LookupSubTable[] {lookupTypeSingleSubstFormat12};
    LookupListTable lookupListTable =
        new LookupListTable(
            3, new LookupTable[] {lookupTable, new LookupTable(4, 4, 4, subTables2)});

    // Act
    GsubData actualGsubData =
        glyphSubstitutionDataExtractor.getGsubData(
            "Script Name", scriptTable, featureListTable, lookupListTable);

    // Assert
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Name", actualGsubData.getActiveScriptName());
    Set<String> supportedFeatures = actualGsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(supportedFeatures.contains("Feature Tag"));
  }
}
