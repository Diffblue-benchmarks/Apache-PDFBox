package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.ttf.CmapLookup;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.junit.jupiter.api.Test;

class GsubWorkerFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker2() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker3() {
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

  /**
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker4() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker5() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker6() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker7() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker8() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker9() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker10() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker11() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker12() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker13() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker14() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker15() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker16() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker17() {
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
   * Method under test:
   * {@link GsubWorkerFactory#getGsubWorker(CmapLookup, GsubData)}
   */
  @Test
  void testGetGsubWorker18() {
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
}
