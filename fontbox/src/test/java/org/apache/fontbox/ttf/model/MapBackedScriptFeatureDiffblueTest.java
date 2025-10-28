package org.apache.fontbox.ttf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class MapBackedScriptFeatureDiffblueTest {
  /**
   * Method under test:
   * {@link MapBackedScriptFeature#getAllGlyphIdsForSubstitution()}
   */
  @Test
  void testGetAllGlyphIdsForSubstitution() {
    // Arrange, Act and Assert
    assertTrue((new MapBackedScriptFeature("Name", new HashMap<>())).getAllGlyphIdsForSubstitution().isEmpty());
  }

  /**
   * Method under test:
   * {@link MapBackedScriptFeature#getAllGlyphIdsForSubstitution()}
   */
  @Test
  void testGetAllGlyphIdsForSubstitution2() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> featureMap = new HashMap<>();
    featureMap.computeIfPresent(new ArrayList<>(), mock(BiFunction.class));

    // Act and Assert
    assertTrue((new MapBackedScriptFeature("Name", featureMap)).getAllGlyphIdsForSubstitution().isEmpty());
  }

  /**
   * Method under test: {@link MapBackedScriptFeature#canReplaceGlyphs(List)}
   */
  @Test
  void testCanReplaceGlyphs() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    // Act and Assert
    assertFalse(mapBackedScriptFeature.canReplaceGlyphs(new ArrayList<>()));
  }

  /**
   * Method under test: {@link MapBackedScriptFeature#canReplaceGlyphs(List)}
   */
  @Test
  void testCanReplaceGlyphs2() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> featureMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    featureMap.put(integerList, new ArrayList<>());
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", featureMap);

    // Act and Assert
    assertTrue(mapBackedScriptFeature.canReplaceGlyphs(new ArrayList<>()));
  }

  /**
   * Method under test: {@link MapBackedScriptFeature#canReplaceGlyphs(List)}
   */
  @Test
  void testCanReplaceGlyphs3() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> featureMap = new HashMap<>();
    featureMap.computeIfPresent(new ArrayList<>(), mock(BiFunction.class));
    ArrayList<Integer> integerList = new ArrayList<>();
    featureMap.put(integerList, new ArrayList<>());
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", featureMap);

    // Act and Assert
    assertTrue(mapBackedScriptFeature.canReplaceGlyphs(new ArrayList<>()));
  }

  /**
   * Method under test: {@link MapBackedScriptFeature#canReplaceGlyphs(List)}
   */
  @Test
  void testCanReplaceGlyphs4() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(2);

    // Act and Assert
    assertFalse(mapBackedScriptFeature.canReplaceGlyphs(glyphIds));
  }

  /**
   * Method under test: {@link MapBackedScriptFeature#canReplaceGlyphs(List)}
   */
  @Test
  void testCanReplaceGlyphs5() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(5);
    glyphIds.add(2);

    // Act and Assert
    assertFalse(mapBackedScriptFeature.canReplaceGlyphs(glyphIds));
  }

  /**
   * Method under test:
   * {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}
   */
  @Test
  void testGetReplacementForGlyphs() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> mapBackedScriptFeature.getReplacementForGlyphs(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}
   */
  @Test
  void testGetReplacementForGlyphs2() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> featureMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    ArrayList<Integer> integerList2 = new ArrayList<>();
    featureMap.put(integerList, integerList2);
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", featureMap);

    // Act
    List<Integer> actualReplacementForGlyphs = mapBackedScriptFeature.getReplacementForGlyphs(new ArrayList<>());

    // Assert
    assertTrue(actualReplacementForGlyphs.isEmpty());
    assertSame(integerList2, actualReplacementForGlyphs);
  }

  /**
   * Method under test:
   * {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}
   */
  @Test
  void testGetReplacementForGlyphs3() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> featureMap = new HashMap<>();
    featureMap.computeIfPresent(new ArrayList<>(), mock(BiFunction.class));
    ArrayList<Integer> integerList = new ArrayList<>();
    ArrayList<Integer> integerList2 = new ArrayList<>();
    featureMap.put(integerList, integerList2);
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", featureMap);

    // Act
    List<Integer> actualReplacementForGlyphs = mapBackedScriptFeature.getReplacementForGlyphs(new ArrayList<>());

    // Assert
    assertTrue(actualReplacementForGlyphs.isEmpty());
    assertSame(integerList2, actualReplacementForGlyphs);
  }

  /**
   * Method under test:
   * {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}
   */
  @Test
  void testGetReplacementForGlyphs4() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(2);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> mapBackedScriptFeature.getReplacementForGlyphs(glyphIds));
  }

  /**
   * Method under test:
   * {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}
   */
  @Test
  void testGetReplacementForGlyphs5() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(5);
    glyphIds.add(2);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> mapBackedScriptFeature.getReplacementForGlyphs(glyphIds));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MapBackedScriptFeature#equals(Object)}
   *   <li>{@link MapBackedScriptFeature#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());
    MapBackedScriptFeature mapBackedScriptFeature2 = new MapBackedScriptFeature("Name", new HashMap<>());

    // Act and Assert
    assertEquals(mapBackedScriptFeature, mapBackedScriptFeature2);
    int expectedHashCodeResult = mapBackedScriptFeature.hashCode();
    assertEquals(expectedHashCodeResult, mapBackedScriptFeature2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MapBackedScriptFeature#equals(Object)}
   *   <li>{@link MapBackedScriptFeature#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    // Act and Assert
    assertEquals(mapBackedScriptFeature, mapBackedScriptFeature);
    int expectedHashCodeResult = mapBackedScriptFeature.hashCode();
    assertEquals(expectedHashCodeResult, mapBackedScriptFeature.hashCode());
  }

  /**
   * Method under test: {@link MapBackedScriptFeature#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature(null, new HashMap<>());

    // Act and Assert
    assertNotEquals(mapBackedScriptFeature, new MapBackedScriptFeature("Name", new HashMap<>()));
  }

  /**
   * Method under test: {@link MapBackedScriptFeature#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> featureMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    featureMap.put(integerList, new ArrayList<>());
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", featureMap);

    // Act and Assert
    assertNotEquals(mapBackedScriptFeature, new MapBackedScriptFeature("Name", new HashMap<>()));
  }

  /**
   * Method under test: {@link MapBackedScriptFeature#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> featureMap = new HashMap<>();
    featureMap.computeIfPresent(new ArrayList<>(), mock(BiFunction.class));
    ArrayList<Integer> integerList = new ArrayList<>();
    featureMap.put(integerList, new ArrayList<>());
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", featureMap);

    // Act and Assert
    assertNotEquals(mapBackedScriptFeature, new MapBackedScriptFeature("Name", new HashMap<>()));
  }

  /**
   * Method under test: {@link MapBackedScriptFeature#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapBackedScriptFeature("Name", new HashMap<>()), null);
  }

  /**
   * Method under test: {@link MapBackedScriptFeature#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapBackedScriptFeature("Name", new HashMap<>()), "Different type to MapBackedScriptFeature");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MapBackedScriptFeature#MapBackedScriptFeature(String, Map)}
   *   <li>{@link MapBackedScriptFeature#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", (new MapBackedScriptFeature("Name", new HashMap<>())).getName());
  }
}
