package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GsubWorkerForLatinDiffblueTest {
  /**
   * Test {@link GsubWorkerForLatin#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForLatin#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given one; when ArrayList() add one; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForLatin.applyTransforms(List)"})
  void testApplyTransforms_givenOne_whenArrayListAddOne_thenReturnArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForLatin gsubWorkerForLatin = new GsubWorkerForLatin(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForLatin.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForLatin#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForLatin#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given two; when ArrayList() add two; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForLatin.applyTransforms(List)"})
  void testApplyTransforms_givenTwo_whenArrayListAddTwo_thenReturnArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForLatin gsubWorkerForLatin = new GsubWorkerForLatin(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForLatin.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForLatin#applyTransforms(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForLatin#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForLatin.applyTransforms(List)"})
  void testApplyTransforms_whenArrayList_thenReturnEmpty() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForLatin gsubWorkerForLatin = new GsubWorkerForLatin(cmapLookup, gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForLatin.applyTransforms(new ArrayList<>()).isEmpty());
  }
}
