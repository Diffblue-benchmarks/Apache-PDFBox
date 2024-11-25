package org.apache.fontbox.ttf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MapBackedGsubDataDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapBackedGsubData#MapBackedGsubData(Language, String, Map)}
   *   <li>{@link MapBackedGsubData#getActiveScriptName()}
   *   <li>{@link MapBackedGsubData#getLanguage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    MapBackedGsubData actualMapBackedGsubData = new MapBackedGsubData(Language.BENGALI, "Active Script Name",
        new HashMap<>());
    String actualActiveScriptName = actualMapBackedGsubData.getActiveScriptName();

    // Assert
    assertEquals("Active Script Name", actualActiveScriptName);
    assertEquals(Language.BENGALI, actualMapBackedGsubData.getLanguage());
  }

  /**
   * Test {@link MapBackedGsubData#isFeatureSupported(String)}.
   * <p>
   * Method under test: {@link MapBackedGsubData#isFeatureSupported(String)}
   */
  @Test
  @DisplayName("Test isFeatureSupported(String)")
  void testIsFeatureSupported() {
    // Arrange, Act and Assert
    assertFalse((new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()))
        .isFeatureSupported("Feature Name"));
  }

  /**
   * Test {@link MapBackedGsubData#getFeature(String)}.
   * <p>
   * Method under test: {@link MapBackedGsubData#getFeature(String)}
   */
  @Test
  @DisplayName("Test getFeature(String)")
  void testGetFeature() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()))
            .getFeature("Feature Name"));
  }

  /**
   * Test {@link MapBackedGsubData#getSupportedFeatures()}.
   * <p>
   * Method under test: {@link MapBackedGsubData#getSupportedFeatures()}
   */
  @Test
  @DisplayName("Test getSupportedFeatures()")
  void testGetSupportedFeatures() {
    // Arrange, Act and Assert
    assertTrue((new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>())).getSupportedFeatures()
        .isEmpty());
  }
}
