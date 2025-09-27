package org.apache.fontbox.ttf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapBackedGsubDataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapBackedGsubData#MapBackedGsubData(Language, String, Map)}
   *   <li>{@link MapBackedGsubData#getActiveScriptName()}
   *   <li>{@link MapBackedGsubData#getLanguage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MapBackedGsubData.<init>(Language, String, Map)",
    "String MapBackedGsubData.getActiveScriptName()",
    "Language MapBackedGsubData.getLanguage()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MapBackedGsubData actualMapBackedGsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());
    String actualActiveScriptName = actualMapBackedGsubData.getActiveScriptName();

    // Assert
    assertEquals("Active Script Name", actualActiveScriptName);
    assertEquals(Language.BENGALI, actualMapBackedGsubData.getLanguage());
  }

  /**
   * Test {@link MapBackedGsubData#isFeatureSupported(String)}.
   *
   * <p>Method under test: {@link MapBackedGsubData#isFeatureSupported(String)}
   */
  @Test
  @DisplayName("Test isFeatureSupported(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapBackedGsubData.isFeatureSupported(String)"})
  void testIsFeatureSupported() {
    // Arrange
    MapBackedGsubData mapBackedGsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    // Act and Assert
    assertFalse(mapBackedGsubData.isFeatureSupported("Feature Name"));
  }

  /**
   * Test {@link MapBackedGsubData#getFeature(String)}.
   *
   * <p>Method under test: {@link MapBackedGsubData#getFeature(String)}
   */
  @Test
  @DisplayName("Test getFeature(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.fontbox.ttf.model.ScriptFeature MapBackedGsubData.getFeature(String)"
  })
  void testGetFeature() {
    // Arrange
    MapBackedGsubData mapBackedGsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> mapBackedGsubData.getFeature("Feature Name"));
  }

  /**
   * Test {@link MapBackedGsubData#getSupportedFeatures()}.
   *
   * <p>Method under test: {@link MapBackedGsubData#getSupportedFeatures()}
   */
  @Test
  @DisplayName("Test getSupportedFeatures()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set MapBackedGsubData.getSupportedFeatures()"})
  void testGetSupportedFeatures() {
    // Arrange
    MapBackedGsubData mapBackedGsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    // Act and Assert
    assertTrue(mapBackedGsubData.getSupportedFeatures().isEmpty());
  }
}
