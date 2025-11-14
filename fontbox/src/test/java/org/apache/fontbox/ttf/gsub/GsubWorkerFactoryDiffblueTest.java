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

class GsubWorkerFactoryDiffblueTest {
  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList = new ArrayList<>();
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForBengali);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(integerList.isEmpty());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker2() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", new HashMap<>());

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList = new ArrayList<>();
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
    assertTrue(integerList.isEmpty());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker3() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.GUJARATI, "Active Script Name", new HashMap<>());

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList = new ArrayList<>();
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForGujarati);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(Language.GUJARATI, gsubData.getLanguage());
    assertTrue(integerList.isEmpty());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker4() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    // Act and Assert
    assertTrue(
        gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData) instanceof GsubWorkerForBengali);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker5() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", new HashMap<>());

    // Act and Assert
    assertTrue(
        gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData) instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker6() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.GUJARATI, "Active Script Name", new HashMap<>());

    // Act and Assert
    assertTrue(
        gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData) instanceof GsubWorkerForGujarati);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(Language.GUJARATI, gsubData.getLanguage());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker7() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", new HashMap<>());
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.GUJARATI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList = new ArrayList<>();
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForGujarati);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.GUJARATI, gsubData.getLanguage());
    assertTrue(integerList.isEmpty());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(supportedFeatures.contains("rkrf"));
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker8() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.GUJARATI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList2 = new ArrayList<>();
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList2);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForGujarati);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.GUJARATI, gsubData.getLanguage());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(integerList, integerList2);
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus two.
   *   <li>Then {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test getGsubWorker(CmapLookup, GsubData); given ArrayList() add minus two; then ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenArrayListAddMinusTwo_thenArrayList() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
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
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList3 = new ArrayList<>();
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList3);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(integerList2, integerList3);
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test getGsubWorker(CmapLookup, GsubData); given ArrayList() add two; then ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenArrayListAddTwo_thenArrayList() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList2 = new ArrayList<>();

    listListMap.put(integerList, integerList2);

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList3 = new ArrayList<>();
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList3);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(integerList2, integerList3);
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test getGsubWorker(CmapLookup, GsubData); given ArrayList() add two; then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenArrayListAddTwo_thenArrayListSizeIsOne() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList2 = new ArrayList<>();
    integerList2.add(1);
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList2);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, integerList2.size());
    assertEquals(1, integerList2.get(0).intValue());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(integerList2, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test getGsubWorker(CmapLookup, GsubData); given ArrayList() add two; then ArrayList() size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenArrayListAddTwo_thenArrayListSizeIsThree() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList2 = new ArrayList<>();
    integerList2.add(1);
    integerList2.add(2);
    integerList2.add(1);
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList2);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(3, integerList2.size());
    assertEquals(1, integerList2.get(0).intValue());
    assertEquals(1, integerList2.get(2).intValue());
    assertEquals(2, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
    assertEquals(1, gsubData.getSupportedFeatures().size());
    assertEquals(2, integerList2.get(1).intValue());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test getGsubWorker(CmapLookup, GsubData); given ArrayList() add two; then ArrayList() size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenArrayListAddTwo_thenArrayListSizeIsThree2() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList2 = new ArrayList<>();
    integerList2.add(0);
    integerList2.add(2);
    integerList2.add(1);
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList2);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(3, integerList2.size());
    assertEquals(0, integerList2.get(0).intValue());
    assertEquals(2, actualApplyTransformsResult.size());
    assertEquals(0, actualApplyTransformsResult.get(0).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, integerList2.get(2).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
    assertEquals(1, gsubData.getSupportedFeatures().size());
    assertEquals(2, integerList2.get(1).intValue());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given HashMap(); then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenHashMap_thenArrayListEmpty() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", new HashMap<>());
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList = new ArrayList<>();
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
    assertTrue(integerList.isEmpty());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(supportedFeatures.contains("rkrf"));
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); then ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenArrayList() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList2 = new ArrayList<>();
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList2);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(integerList, integerList2);
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first intValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test getGsubWorker(CmapLookup, GsubData); then ArrayList() first intValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenArrayListFirstIntValueIsMinusOne() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList2 = new ArrayList<>();
    integerList2.add(-1);
    integerList2.add(2);
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList2);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForBengali);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(2, integerList2.size());
    assertEquals(-1, integerList2.get(0).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(2, integerList2.get(1).intValue());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
    assertTrue(supportedFeatures.contains("rkrf"));
    assertEquals(integerList2, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is five.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); then ArrayList() size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenArrayListSizeIsFive() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList2 = new ArrayList<>();
    integerList2.add(5);
    integerList2.add(1);
    integerList2.add(0);
    integerList2.add(-1);
    integerList2.add(2);
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList2);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForBengali);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(5, integerList2.size());
    assertEquals(-1, integerList2.get(3).intValue());
    assertEquals(6, actualApplyTransformsResult.size());
    assertEquals(-1, actualApplyTransformsResult.get(4).intValue());
    assertEquals(0, integerList2.get(2).intValue());
    assertEquals(0, actualApplyTransformsResult.get(0).intValue());
    assertEquals(0, actualApplyTransformsResult.get(2).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, integerList2.get(1).intValue());
    assertEquals(1, actualApplyTransformsResult.get(3).intValue());
    assertEquals(1, gsubData.getSupportedFeatures().size());
    assertEquals(2, integerList2.get(4).intValue());
    assertEquals(2, actualApplyTransformsResult.get(5).intValue());
    assertEquals(5, integerList2.get(0).intValue());
    assertEquals(5, actualApplyTransformsResult.get(1).intValue());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} third intValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test getGsubWorker(CmapLookup, GsubData); then ArrayList() third intValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenArrayListThirdIntValueIsMinusOne() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList2 = new ArrayList<>();
    integerList2.add(1);
    integerList2.add(0);
    integerList2.add(-1);
    integerList2.add(2);
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList2);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForBengali);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(4, integerList2.size());
    assertEquals(-1, integerList2.get(2).intValue());
    assertEquals(4, actualApplyTransformsResult.size());
    assertEquals(-1, actualApplyTransformsResult.get(2).intValue());
    assertEquals(0, integerList2.get(1).intValue());
    assertEquals(0, actualApplyTransformsResult.get(0).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, integerList2.get(0).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
    assertEquals(1, gsubData.getSupportedFeatures().size());
    assertEquals(2, integerList2.get(3).intValue());
    assertEquals(2, actualApplyTransformsResult.get(3).intValue());
    assertEquals(Language.BENGALI, gsubData.getLanguage());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} second intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test getGsubWorker(CmapLookup, GsubData); then return applyTransforms ArrayList() second intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnApplyTransformsArrayListSecondIntValueIsZero() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList2 = new ArrayList<>();
    integerList2.add(0);
    integerList2.add(0);
    integerList2.add(2);
    integerList2.add(1);
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList2);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(4, integerList2.size());
    assertEquals(0, integerList2.get(0).intValue());
    assertEquals(0, integerList2.get(1).intValue());
    assertEquals(3, actualApplyTransformsResult.size());
    assertEquals(0, actualApplyTransformsResult.get(0).intValue());
    assertEquals(0, actualApplyTransformsResult.get(1).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, integerList2.get(3).intValue());
    assertEquals(1, actualApplyTransformsResult.get(2).intValue());
    assertEquals(1, gsubData.getSupportedFeatures().size());
    assertEquals(2, integerList2.get(2).intValue());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test getGsubWorker(CmapLookup, GsubData); then return applyTransforms ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnApplyTransformsArrayListSizeIsOne() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList2 = new ArrayList<>();
    integerList2.add(2);
    integerList2.add(1);
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList2);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(2, integerList2.size());
    assertEquals(1, integerList2.get(1).intValue());
    assertEquals(1, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(1, supportedFeatures.size());
    assertEquals(2, integerList2.get(0).intValue());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
    assertTrue(supportedFeatures.contains("rkrf"));
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test getGsubWorker(CmapLookup, GsubData); then return applyTransforms ArrayList() size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnApplyTransformsArrayListSizeIsThree() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList2 = new ArrayList<>();
    integerList2.add(1);
    integerList2.add(0);
    integerList2.add(2);
    integerList2.add(1);
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList2);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(4, integerList2.size());
    assertEquals(0, integerList2.get(1).intValue());
    assertEquals(3, actualApplyTransformsResult.size());
    assertEquals(0, actualApplyTransformsResult.get(0).intValue());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(1, integerList2.get(0).intValue());
    assertEquals(1, integerList2.get(3).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
    assertEquals(1, actualApplyTransformsResult.get(2).intValue());
    assertEquals(1, gsubData.getSupportedFeatures().size());
    assertEquals(2, integerList2.get(2).intValue());
    assertEquals(Language.DEVANAGARI, gsubData.getLanguage());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultGsubWorker}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); then return DefaultGsubWorker")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnDefaultGsubWorker() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.UNSPECIFIED, "Active Script Name", new HashMap<>());

    // Act and Assert
    assertTrue(gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData) instanceof DefaultGsubWorker);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(Language.UNSPECIFIED, gsubData.getLanguage());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return {@link GsubWorkerForLatin}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); then return GsubWorkerForLatin")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnGsubWorkerForLatin() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.LATIN, "Active Script Name", new HashMap<>());

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData);
    ArrayList<Integer> integerList = new ArrayList<>();
    List<Integer> actualApplyTransformsResult = actualGsubWorker.applyTransforms(integerList);

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForLatin);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(Language.LATIN, gsubData.getLanguage());
    assertTrue(integerList.isEmpty());
    assertTrue(actualApplyTransformsResult.isEmpty());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return {@link GsubWorkerForLatin}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); then return GsubWorkerForLatin")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnGsubWorkerForLatin2() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.LATIN, "Active Script Name", new HashMap<>());

    // Act and Assert
    assertTrue(gsubWorkerFactory.getGsubWorker(cmapLookup, gsubData) instanceof GsubWorkerForLatin);
    assertEquals("Active Script Name", gsubData.getActiveScriptName());
    assertEquals(0, cmapLookup.getPlatformEncodingId());
    assertEquals(0, cmapLookup.getPlatformId());
    assertEquals(Language.LATIN, gsubData.getLanguage());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
  }
}
