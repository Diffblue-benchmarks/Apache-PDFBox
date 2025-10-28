package org.apache.fontbox.ttf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class MapBackedGsubDataDiffblueTest {
  /**
   * Method under test: {@link MapBackedGsubData#isFeatureSupported(String)}
   */
  @Test
  void testIsFeatureSupported() {
    // Arrange, Act and Assert
    assertFalse((new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()))
        .isFeatureSupported("Feature Name"));
  }

  /**
   * Method under test: {@link MapBackedGsubData#isFeatureSupported(String)}
   */
  @Test
  void testIsFeatureSupported2() {
    // Arrange
    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertFalse((new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap))
        .isFeatureSupported("Feature Name"));
  }

  /**
   * Method under test: {@link MapBackedGsubData#getFeature(String)}
   */
  @Test
  void testGetFeature() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()))
            .getFeature("Feature Name"));
  }

  /**
   * Method under test: {@link MapBackedGsubData#getSupportedFeatures()}
   */
  @Test
  void testGetSupportedFeatures() {
    // Arrange, Act and Assert
    assertTrue((new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>())).getSupportedFeatures()
        .isEmpty());
  }

  /**
   * Method under test: {@link MapBackedGsubData#getSupportedFeatures()}
   */
  @Test
  void testGetSupportedFeatures2() {
    // Arrange
    HashMap<String, Map<List<Integer>, List<Integer>>> glyphSubstitutionMap = new HashMap<>();
    glyphSubstitutionMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertTrue(
        (new MapBackedGsubData(Language.BENGALI, "Active Script Name", glyphSubstitutionMap)).getSupportedFeatures()
            .isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MapBackedGsubData#MapBackedGsubData(Language, String, Map)}
   *   <li>{@link MapBackedGsubData#getActiveScriptName()}
   *   <li>{@link MapBackedGsubData#getLanguage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MapBackedGsubData actualMapBackedGsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name",
        new HashMap<>());
    String actualActiveScriptName = actualMapBackedGsubData.getActiveScriptName();

    // Assert
    assertEquals("Active Script Name", actualActiveScriptName);
    assertEquals(Language.BENGALI, actualMapBackedGsubData.getLanguage());
  }
}
