package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.fontbox.ttf.CmapLookup;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GsubWorkerForDevanagariDiffblueTest {
  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(originalGlyphIds.isEmpty());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari2() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(0);
    originalGlyphIds.add(1);
    originalGlyphIds.add(-2);
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(4, originalGlyphIds.size());
    assertEquals(-2, originalGlyphIds.get(3).intValue());
    assertEquals(4, actualApplyTransformsResult.size());
    assertEquals(-2, actualApplyTransformsResult.get(3).intValue());
    assertEquals(0, originalGlyphIds.get(1).intValue());
    assertEquals(0, actualApplyTransformsResult.get(0).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, originalGlyphIds.get(0).intValue());
    assertEquals(1, originalGlyphIds.get(2).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
    assertEquals(1, actualApplyTransformsResult.get(2).intValue());
    assertEquals(1, gsubData.getSupportedFeatures().size());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari3() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(0);
    originalGlyphIds.add(0);
    originalGlyphIds.add(1);
    originalGlyphIds.add(-2);
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(4, originalGlyphIds.size());
    assertEquals(-2, originalGlyphIds.get(3).intValue());
    assertEquals(4, actualApplyTransformsResult.size());
    assertEquals(-2, actualApplyTransformsResult.get(3).intValue());
    assertEquals(0, originalGlyphIds.get(0).intValue());
    assertEquals(0, originalGlyphIds.get(1).intValue());
    assertEquals(0, actualApplyTransformsResult.get(1).intValue());
    assertEquals(0, actualApplyTransformsResult.get(2).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, originalGlyphIds.get(2).intValue());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(1, gsubData.getSupportedFeatures().size());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus two.
   *   <li>Then {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given ArrayList() add minus two; then ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenArrayListAddMinusTwo_thenArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(-2);
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList2 = new ArrayList<>();

    listListMap.put(integerList, integerList2);

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds).isEmpty());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(integerList2, originalGlyphIds);
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given ArrayList() add two; then ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenArrayListAddTwo_thenArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList2 = new ArrayList<>();

    listListMap.put(integerList, integerList2);

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds).isEmpty());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(integerList2, originalGlyphIds);
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given ArrayList() add two; then ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenArrayListAddTwo_thenArrayList2() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList2 = new ArrayList<>();
    listListMap.put(integerList2, new ArrayList<>());
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds).isEmpty());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(integerList2, originalGlyphIds);
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given ArrayList() add two; then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenArrayListAddTwo_thenArrayListSizeIsOne() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(-2);
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(1, originalGlyphIds.size());
    assertEquals(-2, originalGlyphIds.get(0).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given ArrayList() add two; then ArrayList() size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenArrayListAddTwo_thenArrayListSizeIsThree() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(0);
    originalGlyphIds.add(1);
    originalGlyphIds.add(-2);
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(3, originalGlyphIds.size());
    assertEquals(-2, originalGlyphIds.get(2).intValue());
    assertEquals(0, originalGlyphIds.get(0).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, originalGlyphIds.get(1).intValue());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given ArrayList() add two; then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenArrayListAddTwo_thenArrayListSizeIsTwo() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(-2);
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(2, originalGlyphIds.size());
    assertEquals(-2, originalGlyphIds.get(1).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, originalGlyphIds.get(0).intValue());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link ArrayList#ArrayList()} is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given HashMap() ArrayList() is ArrayList(); then ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenHashMapArrayListIsArrayList_thenArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds).isEmpty());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(integerList, originalGlyphIds);
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given HashMap(); then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenHashMap_thenArrayListEmpty() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", new HashMap<>());
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(originalGlyphIds.isEmpty());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(supportedFeatures.contains("rkrf"));
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForDevanagari(CmapLookup, GsubData); then return applyTransforms ArrayList() size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_thenReturnApplyTransformsArrayListSizeIsThree() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);
    originalGlyphIds.add(-2);
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(4, originalGlyphIds.size());
    assertEquals(-2, originalGlyphIds.get(3).intValue());
    assertEquals(3, actualApplyTransformsResult.size());
    assertEquals(-2, actualApplyTransformsResult.get(2).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, originalGlyphIds.get(0).intValue());
    assertEquals(1, originalGlyphIds.get(2).intValue());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
    assertEquals(1, gsubData.getSupportedFeatures().size());
    assertEquals(2, originalGlyphIds.get(1).intValue());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForDevanagari(CmapLookup, GsubData); then return applyTransforms ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_thenReturnApplyTransformsArrayListSizeIsTwo() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);
    originalGlyphIds.add(-2);
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(3, originalGlyphIds.size());
    assertEquals(-2, originalGlyphIds.get(2).intValue());
    assertEquals(2, actualApplyTransformsResult.size());
    assertEquals(-2, actualApplyTransformsResult.get(1).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, originalGlyphIds.get(1).intValue());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(1, gsubData.getSupportedFeatures().size());
    assertEquals(2, originalGlyphIds.get(0).intValue());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>When {@link GsubData#NO_DATA_FOUND}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup,
   * GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); when NO_DATA_FOUND")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_whenNo_data_found() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    // Act
    new GsubWorkerForDevanagari(cmapLookup, GsubData.NO_DATA_FOUND);

    // Assert that nothing has changed
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus two.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given ArrayList() add minus two; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenArrayListAddMinusTwo_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(-2);
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);
    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given ArrayList() add two; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenArrayListAddTwo_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);
    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given ArrayList() add two; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenArrayListAddTwo_whenArrayList_thenReturnEmpty2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList2 = new ArrayList<>();
    listListMap.put(integerList2, new ArrayList<>());
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);
    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code rkrf} is {@link HashMap#HashMap()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given HashMap() 'rkrf' is HashMap(); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenHashMapRkrfIsHashMap_whenArrayList_thenReturnEmpty() {
    // Arrange
    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", new HashMap<>());
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);
    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link ArrayList#ArrayList()} add minus one.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given minus one; when ArrayList() add minus one; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenMinusOne_whenArrayListAddMinusOne_thenReturnArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(-1);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link ArrayList#ArrayList()} add minus one.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given minus one; when ArrayList() add minus one; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenMinusOne_whenArrayListAddMinusOne_thenReturnArrayList2() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(-1);
    originalGlyphIds.add(-1);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given one; when ArrayList() add one; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenOne_whenArrayListAddOne_thenReturnArrayList() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);
    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given one; when ArrayList() add one; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenOne_whenArrayListAddOne_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);
    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(1, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given one; when ArrayList() add one; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenOne_whenArrayListAddOne_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);
    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(2, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then return first intValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given zero; then return first intValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenZero_thenReturnFirstIntValueIsMinusOne() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(0);
    originalGlyphIds.add(0);
    originalGlyphIds.add(-1);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(4, actualApplyTransformsResult.size());
    assertEquals(-1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(0, actualApplyTransformsResult.get(1).intValue());
    assertEquals(0, actualApplyTransformsResult.get(2).intValue());
    assertEquals(2, actualApplyTransformsResult.get(3).intValue());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then return third intValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given zero; then return third intValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenZero_thenReturnThirdIntValueIsMinusOne() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(0);
    originalGlyphIds.add(-1);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(4, actualApplyTransformsResult.size());
    assertEquals(-1, actualApplyTransformsResult.get(2).intValue());
    assertEquals(0, actualApplyTransformsResult.get(0).intValue());
    assertEquals(2, actualApplyTransformsResult.get(1).intValue());
    assertEquals(2, actualApplyTransformsResult.get(3).intValue());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given zero; when ArrayList() add zero; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenZero_whenArrayListAddZero_thenReturnArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(0);
    originalGlyphIds.add(-1);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given zero; when ArrayList() add zero; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenZero_whenArrayListAddZero_thenReturnSizeIsThree() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(0);
    originalGlyphIds.add(0);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(3, actualApplyTransformsResult.size());
    assertEquals(0, actualApplyTransformsResult.get(1).intValue());
    assertEquals(0, actualApplyTransformsResult.get(2).intValue());
    assertEquals(2, actualApplyTransformsResult.get(0).intValue());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_whenArrayList_thenReturnEmpty() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(cmapLookup, gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_whenArrayList_thenReturnEmpty2() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);
    GsubWorkerForDevanagari gsubWorkerForDevanagari =
        new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }
}
