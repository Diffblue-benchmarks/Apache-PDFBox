package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.fontbox.ttf.CmapLookup;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.GlyphSubstitutionTable;
import org.apache.fontbox.ttf.SubstitutingCmapLookup;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GsubWorkerForBengaliDiffblueTest {
  /**
   * Test {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForBengali(CmapLookup, GsubData); given one; then return applyTransforms ArrayList() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForBengali.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForBengali_givenOne_thenReturnApplyTransformsArrayListSizeIsTwo() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    // Act
    GsubWorkerForBengali actualGsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertEquals(2, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(2, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Test {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForBengali(CmapLookup, GsubData); then return applyTransforms ArrayList() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForBengali.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForBengali_thenReturnApplyTransformsArrayListEmpty() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    // Act
    GsubWorkerForBengali actualGsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Assert
    assertTrue(actualGsubWorkerForBengali.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForBengali(CmapLookup, GsubData); then return applyTransforms ArrayList() is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForBengali.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForBengali_thenReturnApplyTransformsArrayListIsArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();

    // Act
    GsubWorkerForBengali actualGsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);

    // Assert
    assertEquals(originalGlyphIds, actualGsubWorkerForBengali.applyTransforms(originalGlyphIds));
  }

  /**
   * Test {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}.
   * <ul>
   *   <li>Then return applyTransforms {@link ArrayList#ArrayList()} size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}
   */
  @Test
  @DisplayName("Test new GsubWorkerForBengali(CmapLookup, GsubData); then return applyTransforms ArrayList() size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GsubWorkerForBengali.<init>(CmapLookup, GsubData)"})
  void testNewGsubWorkerForBengali_thenReturnApplyTransformsArrayListSizeIsFour() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    // Act
    GsubWorkerForBengali actualGsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(5);
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertEquals(4, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(2).intValue());
    assertEquals(2, actualApplyTransformsResult.get(3).intValue());
    assertEquals(5, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Test {@link GsubWorkerForBengali#applyTransforms(List)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given two; when ArrayList() add two; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForBengali.applyTransforms(List)"})
  void testApplyTransforms_givenTwo_whenArrayListAddTwo_thenReturnArrayList() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);

    // Act and Assert
    assertEquals(originalGlyphIds, gsubWorkerForBengali.applyTransforms(originalGlyphIds));
  }

  /**
   * Test {@link GsubWorkerForBengali#applyTransforms(List)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given two; when ArrayList() add two; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForBengali.applyTransforms(List)"})
  void testApplyTransforms_givenTwo_whenArrayListAddTwo_thenReturnArrayList2() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(2);

    // Act and Assert
    assertEquals(originalGlyphIds, gsubWorkerForBengali.applyTransforms(originalGlyphIds));
  }

  /**
   * Test {@link GsubWorkerForBengali#applyTransforms(List)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given two; when ArrayList() add two; then return size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForBengali.applyTransforms(List)"})
  void testApplyTransforms_givenTwo_whenArrayListAddTwo_thenReturnSizeIsFour() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);
    originalGlyphIds.add(0);

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(4, actualApplyTransformsResult.size());
    assertEquals(0, actualApplyTransformsResult.get(2).intValue());
    assertEquals(1, actualApplyTransformsResult.get(3).intValue());
    assertEquals(2, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Test {@link GsubWorkerForBengali#applyTransforms(List)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); given zero; when ArrayList() add zero; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForBengali.applyTransforms(List)"})
  void testApplyTransforms_givenZero_whenArrayListAddZero_thenReturnSizeIsTwo() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(0);

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(2, actualApplyTransformsResult.size());
    assertEquals(0, actualApplyTransformsResult.get(0).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Test {@link GsubWorkerForBengali#applyTransforms(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GsubWorkerForBengali.applyTransforms(List)"})
  void testApplyTransforms_whenArrayList_thenReturnEmpty() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act and Assert
    assertTrue(gsubWorkerForBengali.applyTransforms(new ArrayList<>()).isEmpty());
  }
}
