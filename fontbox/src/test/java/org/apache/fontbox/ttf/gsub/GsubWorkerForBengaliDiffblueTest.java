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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GsubWorkerForBengaliDiffblueTest {
  /**
   * Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForBengali.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms2() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertEquals(1, actualApplyTransformsResult.size());
    assertEquals(2, actualApplyTransformsResult.get(0).intValue());
  }

  /**
   * Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms3() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms4() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(5);
    originalGlyphIds.add(1);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertEquals(3, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(2, actualApplyTransformsResult.get(2).intValue());
    assertEquals(5, actualApplyTransformsResult.get(1).intValue());
  }

  /**
   * Method under test: {@link GsubWorkerForBengali#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms5() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    GsubWorkerForBengali gsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);
    originalGlyphIds.add(5);
    originalGlyphIds.add(1);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult = gsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertEquals(5, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(1, actualApplyTransformsResult.get(2).intValue());
    assertEquals(2, actualApplyTransformsResult.get(1).intValue());
    assertEquals(2, actualApplyTransformsResult.get(4).intValue());
    assertEquals(5, actualApplyTransformsResult.get(3).intValue());
  }

  /**
   * Method under test:
   * {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}
   */
  @Test
  void testNewGsubWorkerForBengali() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    // Act
    GsubWorkerForBengali actualGsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForBengali.applyTransforms(new ArrayList<>());

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertTrue(actualApplyTransformsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}
   */
  @Test
  void testNewGsubWorkerForBengali2() {
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
   * Method under test:
   * {@link GsubWorkerForBengali#GsubWorkerForBengali(CmapLookup, GsubData)}
   */
  @Test
  void testNewGsubWorkerForBengali3() {
    // Arrange
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup cmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    // Act
    GsubWorkerForBengali actualGsubWorkerForBengali = new GsubWorkerForBengali(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(1);
    originalGlyphIds.add(2);
    originalGlyphIds.add(1);
    List<Integer> actualApplyTransformsResult = actualGsubWorkerForBengali.applyTransforms(originalGlyphIds);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    assertEquals(4, actualApplyTransformsResult.size());
    assertEquals(1, actualApplyTransformsResult.get(0).intValue());
    assertEquals(1, actualApplyTransformsResult.get(1).intValue());
    assertEquals(1, actualApplyTransformsResult.get(2).intValue());
    assertEquals(2, actualApplyTransformsResult.get(3).intValue());
  }
}
