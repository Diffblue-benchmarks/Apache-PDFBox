package org.apache.fontbox.ttf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapBackedScriptFeatureDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapBackedScriptFeature#MapBackedScriptFeature(String, Map)}
   *   <li>{@link MapBackedScriptFeature#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapBackedScriptFeature.<init>(String, Map)", "String MapBackedScriptFeature.getName()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", (new MapBackedScriptFeature("Name", new HashMap<>())).getName());
  }

  /**
   * Test {@link MapBackedScriptFeature#getAllGlyphIdsForSubstitution()}.
   * <p>
   * Method under test: {@link MapBackedScriptFeature#getAllGlyphIdsForSubstitution()}
   */
  @Test
  @DisplayName("Test getAllGlyphIdsForSubstitution()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set MapBackedScriptFeature.getAllGlyphIdsForSubstitution()"})
  void testGetAllGlyphIdsForSubstitution() {
    // Arrange, Act and Assert
    assertTrue((new MapBackedScriptFeature("Name", new HashMap<>())).getAllGlyphIdsForSubstitution().isEmpty());
  }

  /**
   * Test {@link MapBackedScriptFeature#canReplaceGlyphs(List)}.
   * <ul>
   *   <li>Given five.</li>
   *   <li>When {@link ArrayList#ArrayList()} add five.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#canReplaceGlyphs(List)}
   */
  @Test
  @DisplayName("Test canReplaceGlyphs(List); given five; when ArrayList() add five; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapBackedScriptFeature.canReplaceGlyphs(List)"})
  void testCanReplaceGlyphs_givenFive_whenArrayListAddFive_thenReturnFalse() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(5);
    glyphIds.add(2);

    // Act and Assert
    assertFalse(mapBackedScriptFeature.canReplaceGlyphs(glyphIds));
  }

  /**
   * Test {@link MapBackedScriptFeature#canReplaceGlyphs(List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link ArrayList#ArrayList()} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#canReplaceGlyphs(List)}
   */
  @Test
  @DisplayName("Test canReplaceGlyphs(List); given HashMap() ArrayList() is ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapBackedScriptFeature.canReplaceGlyphs(List)"})
  void testCanReplaceGlyphs_givenHashMapArrayListIsArrayList_thenReturnTrue() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> featureMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    featureMap.put(integerList, new ArrayList<>());
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", featureMap);

    // Act and Assert
    assertTrue(mapBackedScriptFeature.canReplaceGlyphs(new ArrayList<>()));
  }

  /**
   * Test {@link MapBackedScriptFeature#canReplaceGlyphs(List)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#canReplaceGlyphs(List)}
   */
  @Test
  @DisplayName("Test canReplaceGlyphs(List); given two; when ArrayList() add two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapBackedScriptFeature.canReplaceGlyphs(List)"})
  void testCanReplaceGlyphs_givenTwo_whenArrayListAddTwo_thenReturnFalse() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(2);

    // Act and Assert
    assertFalse(mapBackedScriptFeature.canReplaceGlyphs(glyphIds));
  }

  /**
   * Test {@link MapBackedScriptFeature#canReplaceGlyphs(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#canReplaceGlyphs(List)}
   */
  @Test
  @DisplayName("Test canReplaceGlyphs(List); when ArrayList(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapBackedScriptFeature.canReplaceGlyphs(List)"})
  void testCanReplaceGlyphs_whenArrayList_thenReturnFalse() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    // Act and Assert
    assertFalse(mapBackedScriptFeature.canReplaceGlyphs(new ArrayList<>()));
  }

  /**
   * Test {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}.
   * <ul>
   *   <li>Given five.</li>
   *   <li>When {@link ArrayList#ArrayList()} add five.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}
   */
  @Test
  @DisplayName("Test getReplacementForGlyphs(List); given five; when ArrayList() add five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List MapBackedScriptFeature.getReplacementForGlyphs(List)"})
  void testGetReplacementForGlyphs_givenFive_whenArrayListAddFive() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(5);
    glyphIds.add(2);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> mapBackedScriptFeature.getReplacementForGlyphs(glyphIds));
  }

  /**
   * Test {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link ArrayList#ArrayList()} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}
   */
  @Test
  @DisplayName("Test getReplacementForGlyphs(List); given HashMap() ArrayList() is ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List MapBackedScriptFeature.getReplacementForGlyphs(List)"})
  void testGetReplacementForGlyphs_givenHashMapArrayListIsArrayList_thenReturnEmpty() {
    // Arrange
    HashMap<List<Integer>, List<Integer>> featureMap = new HashMap<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    featureMap.put(integerList, new ArrayList<>());
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", featureMap);

    // Act and Assert
    assertTrue(mapBackedScriptFeature.getReplacementForGlyphs(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}
   */
  @Test
  @DisplayName("Test getReplacementForGlyphs(List); given two; when ArrayList() add two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List MapBackedScriptFeature.getReplacementForGlyphs(List)"})
  void testGetReplacementForGlyphs_givenTwo_whenArrayListAddTwo() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(2);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> mapBackedScriptFeature.getReplacementForGlyphs(glyphIds));
  }

  /**
   * Test {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#getReplacementForGlyphs(List)}
   */
  @Test
  @DisplayName("Test getReplacementForGlyphs(List); when ArrayList(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List MapBackedScriptFeature.getReplacementForGlyphs(List)"})
  void testGetReplacementForGlyphs_whenArrayList_thenThrowUnsupportedOperationException() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> mapBackedScriptFeature.getReplacementForGlyphs(new ArrayList<>()));
  }

  /**
   * Test {@link MapBackedScriptFeature#equals(Object)}, and {@link MapBackedScriptFeature#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapBackedScriptFeature#equals(Object)}
   *   <li>{@link MapBackedScriptFeature#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapBackedScriptFeature.equals(Object)", "int MapBackedScriptFeature.hashCode()"})
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
   * Test {@link MapBackedScriptFeature#equals(Object)}, and {@link MapBackedScriptFeature#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapBackedScriptFeature#equals(Object)}
   *   <li>{@link MapBackedScriptFeature#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapBackedScriptFeature.equals(Object)", "int MapBackedScriptFeature.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature("Name", new HashMap<>());

    // Act and Assert
    assertEquals(mapBackedScriptFeature, mapBackedScriptFeature);
    int expectedHashCodeResult = mapBackedScriptFeature.hashCode();
    assertEquals(expectedHashCodeResult, mapBackedScriptFeature.hashCode());
  }

  /**
   * Test {@link MapBackedScriptFeature#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapBackedScriptFeature.equals(Object)", "int MapBackedScriptFeature.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MapBackedScriptFeature mapBackedScriptFeature = new MapBackedScriptFeature(null, new HashMap<>());

    // Act and Assert
    assertNotEquals(mapBackedScriptFeature, new MapBackedScriptFeature("Name", new HashMap<>()));
  }

  /**
   * Test {@link MapBackedScriptFeature#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapBackedScriptFeature.equals(Object)", "int MapBackedScriptFeature.hashCode()"})
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
   * Test {@link MapBackedScriptFeature#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapBackedScriptFeature.equals(Object)", "int MapBackedScriptFeature.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapBackedScriptFeature("Name", new HashMap<>()), null);
  }

  /**
   * Test {@link MapBackedScriptFeature#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapBackedScriptFeature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapBackedScriptFeature.equals(Object)", "int MapBackedScriptFeature.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapBackedScriptFeature("Name", new HashMap<>()), "Different type to MapBackedScriptFeature");
  }
}
