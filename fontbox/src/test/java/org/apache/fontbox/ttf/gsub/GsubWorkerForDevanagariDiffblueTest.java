package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given ArrayList() add minus two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenArrayListAddMinusTwo() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(-2);
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given ArrayList() add two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenArrayListAddTwo() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given ArrayList() add two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenArrayListAddTwo2() {
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

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenHashMap() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", new HashMap<>());

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@code vatu}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code vatu} is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given 'vatu'; when HashMap() 'vatu' is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenVatu_whenHashMapVatuIsHashMap() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("vatu", new HashMap<>());

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@code vatu}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code vatu} is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); given 'vatu'; when HashMap() 'vatu' is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_givenVatu_whenHashMapVatuIsHashMap2() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("vatu", listListMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); then return applyTransforms ArrayList() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_thenReturnApplyTransformsArrayListEmpty() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Assert
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); then return applyTransforms ArrayList() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_thenReturnApplyTransformsArrayListEmpty2() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); then return applyTransforms ArrayList() is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_thenReturnApplyTransformsArrayListIsArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);

    // Assert
    assertEquals(originalGlyphIds, actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds));
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); then return applyTransforms ArrayList() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForDevanagari.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForDevanagari_thenReturnApplyTransformsArrayListSizeIsOne() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(1, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#GsubWorkerForDevanagari(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForDevanagari(CmapLookup, GsubData); then return applyTransforms ArrayList() size is two")
  @Tag("MaintainedByDiffblue")
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

    // Act
    GsubWorkerForDevanagari actualGsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(2, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus two.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given ArrayList() add minus two; when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
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
    MapBackedGsubData gsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    GsubWorkerForDevanagari gsubWorkerForDevanagari = new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given ArrayList() add two; when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenArrayListAddTwo_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    GsubWorkerForDevanagari gsubWorkerForDevanagari = new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given ArrayList() add two; when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
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
    MapBackedGsubData gsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    GsubWorkerForDevanagari gsubWorkerForDevanagari = new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link ArrayList#ArrayList()} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given HashMap() ArrayList() is ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenHashMapArrayListIsArrayList_thenReturnEmpty() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    GsubWorkerForDevanagari gsubWorkerForDevanagari = new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code rkrf} is {@link HashMap#HashMap()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given HashMap() 'rkrf' is HashMap(); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenHashMapRkrfIsHashMap_whenArrayList_thenReturnEmpty() {
    // Arrange
    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", new HashMap<>());
    MapBackedGsubData gsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    GsubWorkerForDevanagari gsubWorkerForDevanagari = new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code vatu} is {@link HashMap#HashMap()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given HashMap() 'vatu' is HashMap(); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenHashMapVatuIsHashMap_whenArrayList_thenReturnEmpty() {
    // Arrange
    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("vatu", new HashMap<>());
    MapBackedGsubData gsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    GsubWorkerForDevanagari gsubWorkerForDevanagari = new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code vatu} is {@link HashMap#HashMap()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given HashMap() 'vatu' is HashMap(); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenHashMapVatuIsHashMap_whenArrayList_thenReturnEmpty2() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("vatu", listListMap);
    MapBackedGsubData gsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    GsubWorkerForDevanagari gsubWorkerForDevanagari = new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given one; when ArrayList() add one; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenOne_whenArrayListAddOne_thenReturnArrayList() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    GsubWorkerForDevanagari gsubWorkerForDevanagari = new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);

    // Act and Assert
    assertEquals(originalGlyphIds, gsubWorkerForDevanagari.applyTransforms(originalGlyphIds));
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given one; when ArrayList() add one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenOne_whenArrayListAddOne_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    GsubWorkerForDevanagari gsubWorkerForDevanagari = new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(1, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given one; when ArrayList() add one; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_givenOne_whenArrayListAddOne_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);
    MapBackedGsubData gsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap);

    GsubWorkerForDevanagari gsubWorkerForDevanagari = new GsubWorkerForDevanagari(new CmapSubtable(), gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForDevanagari.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(2, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Test {@link GsubWorkerForDevanagari#applyTransforms(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForDevanagari#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForDevanagari.applyTransforms(List)"})
  void testApplyTransforms_whenArrayList_thenReturnEmpty() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    GsubWorkerForDevanagari gsubWorkerForDevanagari = new GsubWorkerForDevanagari(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act and Assert
    assertTrue(gsubWorkerForDevanagari.applyTransforms(new ArrayList<>()).isEmpty());
  }
}
