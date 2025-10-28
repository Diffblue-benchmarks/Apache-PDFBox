package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.ttf.CmapLookup;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.GlyphSubstitutionTable;
import org.apache.fontbox.ttf.SubstitutingCmapLookup;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GsubWorkerForGujaratiDiffblueTest {
  /**
   * Method under test: {@link GsubWorkerForGujarati#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    GsubWorkerForGujarati gsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test: {@link GsubWorkerForGujarati#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms2() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", new HashMap<>());
    GsubWorkerForGujarati gsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test: {@link GsubWorkerForGujarati#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms3() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    GsubWorkerForGujarati gsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test: {@link GsubWorkerForGujarati#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms4() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    GsubWorkerForGujarati gsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test: {@link GsubWorkerForGujarati#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms5() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(-2);
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    GsubWorkerForGujarati gsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test: {@link GsubWorkerForGujarati#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms6() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList2 = new ArrayList<>();
    listListMap.put(integerList2, new ArrayList<>());
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    GsubWorkerForGujarati gsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test: {@link GsubWorkerForGujarati#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms7() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    GsubWorkerForGujarati gsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForGujarati.applyTransforms(originalGlyphIds);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test: {@link GsubWorkerForGujarati#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms8() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    GsubWorkerForGujarati gsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(-1);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForGujarati.applyTransforms(originalGlyphIds);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertEquals(1, actualApplyTransformsResult.size());
    assertEquals(-1, actualApplyTransformsResult.get(0).intValue());
  }

  /**
   * Method under test:
   * {@link GsubWorkerForGujarati#GsubWorkerForGujarati(CmapLookup, GsubData)}
   */
  @Test
  void testNewGsubWorkerForGujarati() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    // Act
    GsubWorkerForGujarati actualGsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link GsubWorkerForGujarati#GsubWorkerForGujarati(CmapLookup, GsubData)}
   */
  @Test
  void testNewGsubWorkerForGujarati2() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", new HashMap<>());

    // Act
    GsubWorkerForGujarati actualGsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link GsubWorkerForGujarati#GsubWorkerForGujarati(CmapLookup, GsubData)}
   */
  @Test
  void testNewGsubWorkerForGujarati3() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorkerForGujarati actualGsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link GsubWorkerForGujarati#GsubWorkerForGujarati(CmapLookup, GsubData)}
   */
  @Test
  void testNewGsubWorkerForGujarati4() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorkerForGujarati actualGsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link GsubWorkerForGujarati#GsubWorkerForGujarati(CmapLookup, GsubData)}
   */
  @Test
  void testNewGsubWorkerForGujarati5() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(-2);
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorkerForGujarati actualGsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link GsubWorkerForGujarati#GsubWorkerForGujarati(CmapLookup, GsubData)}
   */
  @Test
  void testNewGsubWorkerForGujarati6() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList2 = new ArrayList<>();
    listListMap.put(integerList2, new ArrayList<>());
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorkerForGujarati actualGsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForGujarati.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link GsubWorkerForGujarati#GsubWorkerForGujarati(CmapLookup, GsubData)}
   */
  @Test
  void testNewGsubWorkerForGujarati7() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorkerForGujarati actualGsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(-2);
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForGujarati.applyTransforms(originalGlyphIds);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertEquals(1, actualApplyTransformsResult.size());
    assertEquals(-2, actualApplyTransformsResult.get(0).intValue());
  }

  /**
   * Method under test:
   * {@link GsubWorkerForGujarati#GsubWorkerForGujarati(CmapLookup, GsubData)}
   */
  @Test
  void testNewGsubWorkerForGujarati8() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(-1);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorkerForGujarati actualGsubWorkerForGujarati = new GsubWorkerForGujarati(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(-1);
    originalGlyphIds.add(-1);
    originalGlyphIds.add(2);
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForGujarati.applyTransforms(originalGlyphIds);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertEquals(1, actualApplyTransformsResult.size());
    assertEquals(2, actualApplyTransformsResult.get(0).intValue());
  }
}
