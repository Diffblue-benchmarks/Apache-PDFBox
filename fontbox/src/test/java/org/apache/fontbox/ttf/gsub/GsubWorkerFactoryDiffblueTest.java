package org.apache.fontbox.ttf.gsub;

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

class GsubWorkerFactoryDiffblueTest {
  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus two.</li>
   *   <li>Then return {@link GsubWorkerForDevanagari}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given ArrayList() add minus two; then return GsubWorkerForDevanagari")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenArrayListAddMinusTwo_thenReturnGsubWorkerForDevanagari() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(-2);
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("locl", listListMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return {@link GsubWorkerForBengali}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given ArrayList() add two; then return GsubWorkerForBengali")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenArrayListAddTwo_thenReturnGsubWorkerForBengali() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("locl", listListMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForBengali);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return {@link GsubWorkerForDevanagari}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given ArrayList() add two; then return GsubWorkerForDevanagari")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenArrayListAddTwo_thenReturnGsubWorkerForDevanagari() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("locl", listListMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link GsubWorkerForBengali}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given HashMap(); then return GsubWorkerForBengali")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenHashMap_thenReturnGsubWorkerForBengali() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("locl", new HashMap<>());

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForBengali);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link GsubWorkerForDevanagari}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given HashMap(); then return GsubWorkerForDevanagari")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenHashMap_thenReturnGsubWorkerForDevanagari() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("locl", new HashMap<>());

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@code rkrf}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code rkrf} is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given 'rkrf'; when HashMap() 'rkrf' is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenRkrf_whenHashMapRkrfIsHashMap() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", new HashMap<>());

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.GUJARATI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForGujarati);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@code rkrf}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code rkrf} is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given 'rkrf'; when HashMap() 'rkrf' is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenRkrf_whenHashMapRkrfIsHashMap2() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.GUJARATI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForGujarati);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@code rkrf}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code rkrf} is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given 'rkrf'; when HashMap() 'rkrf' is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenRkrf_whenHashMapRkrfIsHashMap3() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("rkrf", listListMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.GUJARATI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForGujarati);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@code vatu}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code vatu} is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given 'vatu'; when HashMap() 'vatu' is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenVatu_whenHashMapVatuIsHashMap() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("vatu", new HashMap<>());

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@code vatu}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code vatu} is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given 'vatu'; when HashMap() 'vatu' is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenVatu_whenHashMapVatuIsHashMap2() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("vatu", new HashMap<>());

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.GUJARATI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForGujarati);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@code vatu}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code vatu} is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given 'vatu'; when HashMap() 'vatu' is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenVatu_whenHashMapVatuIsHashMap3() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("vatu", listListMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given {@code vatu}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code vatu} is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); given 'vatu'; when HashMap() 'vatu' is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_givenVatu_whenHashMapVatuIsHashMap4() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("vatu", listListMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.GUJARATI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForGujarati);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return {@link DefaultGsubWorker}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); then return DefaultGsubWorker")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnDefaultGsubWorker() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.UNSPECIFIED, "Active Script Name", new HashMap<>()));

    // Assert
    assertTrue(actualGsubWorker instanceof DefaultGsubWorker);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return {@link GsubWorkerForBengali}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); then return GsubWorkerForBengali")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnGsubWorkerForBengali() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForBengali);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return {@link GsubWorkerForBengali}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); then return GsubWorkerForBengali")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnGsubWorkerForBengali2() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("locl", listListMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForBengali);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return {@link GsubWorkerForDevanagari}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); then return GsubWorkerForDevanagari")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnGsubWorkerForDevanagari() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", new HashMap<>()));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return {@link GsubWorkerForDevanagari}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); then return GsubWorkerForDevanagari")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnGsubWorkerForDevanagari2() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    HashMap<List<Integer>, List<Integer>> listListMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    listListMap.put(integerList, new ArrayList<>());

    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.put("locl", listListMap);

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.DEVANAGARI, "Active Script Name", glyphSubstitutionMap));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForDevanagari);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return {@link GsubWorkerForGujarati}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test getGsubWorker(CmapLookup, GsubData); then return GsubWorkerForGujarati")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GsubWorker GsubWorkerFactory.getGsubWorker(CmapLookup, GsubData)"})
  void testGetGsubWorker_thenReturnGsubWorkerForGujarati() {
    // Arrange
    GsubWorkerFactory gsubWorkerFactory = new GsubWorkerFactory();
    CmapSubtable cmapLookup = new CmapSubtable();

    // Act
    GsubWorker actualGsubWorker = gsubWorkerFactory.getGsubWorker(cmapLookup,
        new MapBackedGsubData(Language.GUJARATI, "Active Script Name", new HashMap<>()));

    // Assert
    assertTrue(actualGsubWorker instanceof GsubWorkerForGujarati);
    assertTrue(actualGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }
}
