package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.fontbox.ttf.CmapLookup;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GsubWorkerForBengaliDiffblueTest {
  /**
   * Test {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForBengali(CmapLookup, GsubData); then return applyTransforms ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForBengali.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForBengali_thenReturnApplyTransformsArrayListEmpty() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    // Act
    GsubWorkerForBengali actualGsubWorkerForBengali =
        new GsubWorkerForBengali(cmapLookup, gsubData);

    // Assert
    assertTrue(actualGsubWorkerForBengali.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForBengali(CmapLookup, GsubData); then return applyTransforms ArrayList() is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForBengali.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForBengali_thenReturnApplyTransformsArrayListIsArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    // Act
    GsubWorkerForBengali actualGsubWorkerForBengali =
        new GsubWorkerForBengali(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(2);
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} size is four.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForBengali(CmapLookup, GsubData); then return applyTransforms ArrayList() size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForBengali.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForBengali_thenReturnApplyTransformsArrayListSizeIsFour() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    // Act
    GsubWorkerForBengali actualGsubWorkerForBengali =
        new GsubWorkerForBengali(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(5);
    originalGlyphIds.add(2);
    originalGlyphIds.add(0);
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(4, actualApplyTransformsResult.size());
    assertEquals(0, actualApplyTransformsResult.get(2).intValue());
    assertEquals(2, actualApplyTransformsResult.get(3).intValue());
    assertEquals(5, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Test {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}.
   *
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName(
      "Test new GsubWorkerForBengali(CmapLookup, GsubData); then return applyTransforms ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GsubWorkerForBengali.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForBengali_thenReturnApplyTransformsArrayListSizeIsTwo() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    // Act
    GsubWorkerForBengali actualGsubWorkerForBengali =
        new GsubWorkerForBengali(cmapLookup, gsubData);
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(0);
    List<Integer> actualApplyTransformsResult =
        actualGsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(2, actualApplyTransformsResult.size());
    assertEquals(0, actualApplyTransformsResult.get(0).intValue());
    assertEquals(2, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Test {@link GsubWorkerForBengali#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given two; when ArrayList() add two; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForBengali.applyTransforms(List)"})
  void testApplyTransforms_givenTwo_whenArrayListAddTwo_thenReturnArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForBengali#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given two; when ArrayList() add two; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForBengali.applyTransforms(List)"})
  void testApplyTransforms_givenTwo_whenArrayListAddTwo_thenReturnArrayList2() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link GsubWorkerForBengali#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given two; when ArrayList() add two; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForBengali.applyTransforms(List)"})
  void testApplyTransforms_givenTwo_whenArrayListAddTwo_thenReturnSizeIsFour() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);
    originalGlyphIds.add(0);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(4, actualApplyTransformsResult.size());
    assertEquals(0, actualApplyTransformsResult.get(2).intValue());
    assertEquals(1, actualApplyTransformsResult.get(3).intValue());
    assertEquals(2, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Test {@link GsubWorkerForBengali#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given zero; when ArrayList() add zero; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForBengali.applyTransforms(List)"})
  void testApplyTransforms_givenZero_whenArrayListAddZero_thenReturnSizeIsTwo() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup, gsubData);

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(0);

    // Act
    List<Integer> actualApplyTransformsResult =
        gsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(2, actualApplyTransformsResult.size());
    assertEquals(0, actualApplyTransformsResult.get(0).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Test {@link GsubWorkerForBengali#applyTransforms(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GsubWorkerForBengali.applyTransforms(List)"})
  void testApplyTransforms_whenArrayList_thenReturnEmpty() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    MapBackedGsubData gsubData =
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>());

    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup, gsubData);

    // Act and Assert
    assertTrue(gsubWorkerForBengali.applyTransforms(new ArrayList<>()).isEmpty());
  }
}
