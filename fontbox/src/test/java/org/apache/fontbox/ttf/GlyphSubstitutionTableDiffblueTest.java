package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.apache.fontbox.ttf.table.common.FeatureListTable;
import org.apache.fontbox.ttf.table.common.FeatureRecord;
import org.apache.fontbox.ttf.table.common.FeatureTable;
import org.apache.fontbox.ttf.table.common.LangSysTable;
import org.apache.fontbox.ttf.table.common.ScriptTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GlyphSubstitutionTableDiffblueTest {
  @Mock private FeatureListTable featureListTable;

  @InjectMocks private GlyphSubstitutionTable glyphSubstitutionTable;

  @Mock private Map<String, ScriptTable> map;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GlyphSubstitutionTable}
   *   <li>{@link GlyphSubstitutionTable#getGsubData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GlyphSubstitutionTable.<init>()",
    "GsubData GlyphSubstitutionTable.getGsubData()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GlyphSubstitutionTable actualGlyphSubstitutionTable = new GlyphSubstitutionTable();
    GsubData actualGsubData = actualGlyphSubstitutionTable.getGsubData();

    // Assert
    assertNull(actualGlyphSubstitutionTable.getTag());
    assertNull(actualGsubData);
    assertEquals(0L, actualGlyphSubstitutionTable.getCheckSum());
    assertEquals(0L, actualGlyphSubstitutionTable.getLength());
    assertEquals(0L, actualGlyphSubstitutionTable.getOffset());
    assertFalse(actualGlyphSubstitutionTable.getInitialized());
  }

  /**
   * Test {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then calls {@link RandomAccessReadDataStream#readUnsignedInt()}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given IOException(); then calls readUnsignedInt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphSubstitutionTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenIOException_thenCallsReadUnsignedInt() throws IOException {
    // Arrange
    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedInt()).thenThrow(new IOException());
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.getCurrentPosition()).thenReturn(1L);

    // Act and Assert
    assertThrows(IOException.class, () -> glyphSubstitutionTable.read(ttf, data));
    verify(data).getCurrentPosition();
    verify(data).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then {@link GlyphSubstitutionTable#GlyphSubstitutionTable()} SupportedScriptTags Empty.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given zero; then GlyphSubstitutionTable() SupportedScriptTags Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphSubstitutionTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenZero_thenGlyphSubstitutionTableSupportedScriptTagsEmpty() throws IOException {
    // Arrange
    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(0);
    when(data.getCurrentPosition()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());

    // Act
    glyphSubstitutionTable.read(ttf, data);

    // Assert
    verify(data).getCurrentPosition();
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readUnsignedShort();
    assertTrue(glyphSubstitutionTable.getSupportedScriptTags().isEmpty());
    assertTrue(glyphSubstitutionTable.getInitialized());
  }

  /**
   * Test {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Then calls {@link RandomAccessReadDataStream#getOriginalDataSize()}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then calls getOriginalDataSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphSubstitutionTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenCallsGetOriginalDataSize() throws IOException {
    // Arrange
    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readString(anyInt())).thenReturn("String");
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedShort()).thenReturn(4);
    when(data.getCurrentPosition()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());

    // Act and Assert
    assertThrows(IOException.class, () -> glyphSubstitutionTable.read(ttf, data));
    verify(data).getCurrentPosition();
    verify(data, atLeast(1)).getOriginalDataSize();
    verify(data, atLeast(1)).seek(anyLong());
    verify(data, atLeast(1)).readString(4);
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  @DisplayName("Test getSubstitution(int, String[], List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getSubstitution(int, String[], List)"})
  void testGetSubstitution() {
    // Arrange
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {1, -1, 1, -1}));
    when(featureListTable.getFeatureRecords()).thenReturn(new FeatureRecord[] {featureRecord});
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    LangSysTable defaultLangSysTable = new LangSysTable(1, 1, 3, new int[] {});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    int actualSubstitution =
        glyphSubstitutionTable.getSubstitution(1, new String[] {"Script Tags"}, new ArrayList<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    verify(featureListTable).getFeatureRecords();
    assertEquals(1, actualSubstitution);
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  @DisplayName("Test getSubstitution(int, String[], List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getSubstitution(int, String[], List)"})
  void testGetSubstitution2() {
    // Arrange
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    ScriptTable scriptTable = new ScriptTable(null, new HashMap<>());
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    int actualSubstitution =
        glyphSubstitutionTable.getSubstitution(1, new String[] {"Script Tags"}, new ArrayList<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    assertEquals(1, actualSubstitution);
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  @DisplayName("Test getSubstitution(int, String[], List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getSubstitution(int, String[], List)"})
  void testGetSubstitution3() {
    // Arrange
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {1, -1, 1, -1}));
    when(featureListTable.getFeatureRecords()).thenReturn(new FeatureRecord[] {featureRecord});

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(OpenTypeScript.INHERITED);
    when(map.keySet()).thenReturn(stringSet);
    LangSysTable defaultLangSysTable = new LangSysTable(1, 1, 3, new int[] {});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    int actualSubstitution =
        glyphSubstitutionTable.getSubstitution(
            1, new String[] {OpenTypeScript.INHERITED}, new ArrayList<>());

    // Assert
    verify(map).get(isA(Object.class));
    verify(map).keySet();
    verify(featureListTable).getFeatureRecords();
    assertEquals(1, actualSubstitution);
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  @DisplayName("Test getSubstitution(int, String[], List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getSubstitution(int, String[], List)"})
  void testGetSubstitution4() {
    // Arrange
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {1, -1, 1, -1}));
    when(featureListTable.getFeatureRecords()).thenReturn(new FeatureRecord[] {featureRecord});

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(OpenTypeScript.INHERITED);
    when(map.keySet()).thenReturn(stringSet);
    LangSysTable defaultLangSysTable = new LangSysTable(1, 65535, 3, new int[] {});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    int actualSubstitution =
        glyphSubstitutionTable.getSubstitution(
            1, new String[] {OpenTypeScript.INHERITED}, new ArrayList<>());

    // Assert
    verify(map).get(isA(Object.class));
    verify(map).keySet();
    verify(featureListTable).getFeatureRecords();
    assertEquals(1, actualSubstitution);
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  @DisplayName("Test getSubstitution(int, String[], List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getSubstitution(int, String[], List)"})
  void testGetSubstitution5() {
    // Arrange
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {}));
    when(featureListTable.getFeatureRecords()).thenReturn(new FeatureRecord[] {featureRecord});

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(OpenTypeScript.INHERITED);
    when(map.keySet()).thenReturn(stringSet);
    LangSysTable defaultLangSysTable = new LangSysTable(1, 0, 3, new int[] {});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    int actualSubstitution =
        glyphSubstitutionTable.getSubstitution(
            1, new String[] {OpenTypeScript.INHERITED}, new ArrayList<>());

    // Assert
    verify(map).get(isA(Object.class));
    verify(map).keySet();
    verify(featureListTable).getFeatureRecords();
    assertEquals(1, actualSubstitution);
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  @DisplayName("Test getSubstitution(int, String[], List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getSubstitution(int, String[], List)"})
  void testGetSubstitution6() {
    // Arrange
    FeatureRecord featureRecord =
        new FeatureRecord("vrt2", new FeatureTable(1000, 3, new int[] {}));
    when(featureListTable.getFeatureRecords()).thenReturn(new FeatureRecord[] {featureRecord});

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(OpenTypeScript.INHERITED);
    when(map.keySet()).thenReturn(stringSet);
    LangSysTable defaultLangSysTable = new LangSysTable(1, 0, 3, new int[] {});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    int actualSubstitution =
        glyphSubstitutionTable.getSubstitution(
            1, new String[] {OpenTypeScript.INHERITED}, new ArrayList<>());

    // Assert
    verify(map).get(isA(Object.class));
    verify(map).keySet();
    verify(featureListTable).getFeatureRecords();
    assertEquals(1, actualSubstitution);
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link GlyphSubstitutionTable#GlyphSubstitutionTable()}.
   *   <li>When minus one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  @DisplayName(
      "Test getSubstitution(int, String[], List); given GlyphSubstitutionTable(); when minus one; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getSubstitution(int, String[], List)"})
  void testGetSubstitution_givenGlyphSubstitutionTable_whenMinusOne_thenReturnMinusOne() {
    // Arrange
    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable();

    // Act and Assert
    assertEquals(
        -1, glyphSubstitutionTable.getSubstitution(-1, new String[] {}, new ArrayList<>()));
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@code null}.
   *   <li>Then calls {@link Map#containsKey(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  @DisplayName(
      "Test getSubstitution(int, String[], List); given Map get(Object) return 'null'; then calls containsKey(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getSubstitution(int, String[], List)"})
  void testGetSubstitution_givenMapGetReturnNull_thenCallsContainsKey() {
    // Arrange
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    when(map.get(Mockito.<Object>any())).thenReturn(null);

    // Act
    int actualSubstitution =
        glyphSubstitutionTable.getSubstitution(1, new String[] {"Script Tags"}, new ArrayList<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    assertEquals(1, actualSubstitution);
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@link OpenTypeScript#INHERITED} and {@code Script
   *       Tags}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  @DisplayName(
      "Test getSubstitution(int, String[], List); when array of String with INHERITED and 'Script Tags'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getSubstitution(int, String[], List)"})
  void testGetSubstitution_whenArrayOfStringWithInheritedAndScriptTags() {
    // Arrange
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {}));
    when(featureListTable.getFeatureRecords()).thenReturn(new FeatureRecord[] {featureRecord});
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    LangSysTable defaultLangSysTable = new LangSysTable(1, 0, 3, new int[] {});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    int actualSubstitution =
        glyphSubstitutionTable.getSubstitution(
            1, new String[] {OpenTypeScript.INHERITED, "Script Tags"}, new ArrayList<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    verify(featureListTable).getFeatureRecords();
    assertEquals(1, actualSubstitution);
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@link OpenTypeScript#TAG_DEFAULT}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  @DisplayName("Test getSubstitution(int, String[], List); when array of String with TAG_DEFAULT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getSubstitution(int, String[], List)"})
  void testGetSubstitution_whenArrayOfStringWithTag_default() {
    // Arrange
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {1, -1, 1, -1}));
    when(featureListTable.getFeatureRecords()).thenReturn(new FeatureRecord[] {featureRecord});
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    LangSysTable defaultLangSysTable = new LangSysTable(1, 1, 3, new int[] {});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    int actualSubstitution =
        glyphSubstitutionTable.getSubstitution(
            1, new String[] {OpenTypeScript.TAG_DEFAULT}, new ArrayList<>());

    // Assert
    verify(map, atLeast(1)).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    verify(featureListTable).getFeatureRecords();
    assertEquals(1, actualSubstitution);
  }

  /**
   * Test {@link GlyphSubstitutionTable#getUnsubstitution(int)}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getUnsubstitution(int)}
   */
  @Test
  @DisplayName("Test getUnsubstitution(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getUnsubstitution(int)"})
  void testGetUnsubstitution() {
    // Arrange, Act and Assert
    assertEquals(1, new GlyphSubstitutionTable().getUnsubstitution(1));
  }

  /**
   * Test {@link GlyphSubstitutionTable#getGsubData(String)} with {@code String}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getGsubData(String)}
   */
  @Test
  @DisplayName("Test getGsubData(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubData GlyphSubstitutionTable.getGsubData(String)"})
  void testGetGsubDataWithString() {
    // Arrange
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {4, 1, 4, 1}));
    FeatureRecord featureRecord2 =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {4, 1, 4, 1}));
    when(featureListTable.getFeatureRecords())
        .thenReturn(new FeatureRecord[] {featureRecord, featureRecord2});
    LangSysTable defaultLangSysTable =
        new LangSysTable(1, 1, 3, new int[] {4, 2, 4, 2, 4, 2, 4, 2});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    GsubData actualGsubData = glyphSubstitutionTable.getGsubData("Script Tag");

    // Assert
    verify(map).get(isA(Object.class));
    verify(featureListTable).getFeatureRecords();
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Tag", actualGsubData.getActiveScriptName());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(actualGsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GlyphSubstitutionTable#getGsubData(String)} with {@code String}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getGsubData(String)}
   */
  @Test
  @DisplayName("Test getGsubData(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubData GlyphSubstitutionTable.getGsubData(String)"})
  void testGetGsubDataWithString2() {
    // Arrange
    ScriptTable scriptTable = new ScriptTable(null, new HashMap<>());
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    GsubData actualGsubData = glyphSubstitutionTable.getGsubData("Script Tag");

    // Assert
    verify(map).get(isA(Object.class));
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Tag", actualGsubData.getActiveScriptName());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(actualGsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GlyphSubstitutionTable#getGsubData(String)} with {@code String}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getGsubData(String)}
   */
  @Test
  @DisplayName("Test getGsubData(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubData GlyphSubstitutionTable.getGsubData(String)"})
  void testGetGsubDataWithString3() {
    // Arrange
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {4, 1, 4, 1}));
    FeatureRecord featureRecord2 =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {4, 1, 4, 1}));
    when(featureListTable.getFeatureRecords())
        .thenReturn(new FeatureRecord[] {featureRecord, featureRecord2});

    HashMap<String, LangSysTable> langSysTables = new HashMap<>();
    langSysTables.put("42", new LangSysTable(1, 1, 3, new int[] {4, 2, 4, 2}));
    ScriptTable scriptTable =
        new ScriptTable(new LangSysTable(1, 1, 3, new int[] {}), langSysTables);
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    GsubData actualGsubData = glyphSubstitutionTable.getGsubData("Script Tag");

    // Assert
    verify(map).get(isA(Object.class));
    verify(featureListTable, atLeast(1)).getFeatureRecords();
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Tag", actualGsubData.getActiveScriptName());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(actualGsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GlyphSubstitutionTable#getGsubData(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getGsubData(String)}
   */
  @Test
  @DisplayName(
      "Test getGsubData(String) with 'String'; given Map get(Object) return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubData GlyphSubstitutionTable.getGsubData(String)"})
  void testGetGsubDataWithString_givenMapGetReturnNull_thenReturnNull() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);

    // Act
    GsubData actualGsubData = glyphSubstitutionTable.getGsubData("Script Tag");

    // Assert
    verify(map).get(isA(Object.class));
    assertNull(actualGsubData);
  }

  /**
   * Test {@link GlyphSubstitutionTable#getGsubData(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then calls {@link FeatureListTable#getFeatureRecords()}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getGsubData(String)}
   */
  @Test
  @DisplayName("Test getGsubData(String) with 'String'; then calls getFeatureRecords()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubData GlyphSubstitutionTable.getGsubData(String)"})
  void testGetGsubDataWithString_thenCallsGetFeatureRecords() {
    // Arrange
    FeatureRecord featureRecord =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {4, 1, 4, 1}));
    FeatureRecord featureRecord2 =
        new FeatureRecord("Feature Tag", new FeatureTable(1000, 3, new int[] {4, 1, 4, 1}));
    when(featureListTable.getFeatureRecords())
        .thenReturn(new FeatureRecord[] {featureRecord, featureRecord2});
    LangSysTable defaultLangSysTable = new LangSysTable(1, 1, 3, new int[] {});
    ScriptTable scriptTable = new ScriptTable(defaultLangSysTable, new HashMap<>());
    when(map.get(Mockito.<Object>any())).thenReturn(scriptTable);

    // Act
    GsubData actualGsubData = glyphSubstitutionTable.getGsubData("Script Tag");

    // Assert
    verify(map).get(isA(Object.class));
    verify(featureListTable).getFeatureRecords();
    assertTrue(actualGsubData instanceof MapBackedGsubData);
    assertEquals("Script Tag", actualGsubData.getActiveScriptName());
    assertEquals(Language.UNSPECIFIED, actualGsubData.getLanguage());
    assertTrue(actualGsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSupportedScriptTags()}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSupportedScriptTags()}
   */
  @Test
  @DisplayName("Test getSupportedScriptTags()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GlyphSubstitutionTable.getSupportedScriptTags()"})
  void testGetSupportedScriptTags() {
    // Arrange
    when(map.keySet()).thenReturn(new HashSet<>());

    // Act
    Set<String> actualSupportedScriptTags = glyphSubstitutionTable.getSupportedScriptTags();

    // Assert
    verify(map).keySet();
    assertTrue(actualSupportedScriptTags.isEmpty());
  }
}
