package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SubstitutingCmapLookupDiffblueTest {
  /**
   * Test {@link SubstitutingCmapLookup#getGlyphId(int)}.
   * <ul>
   *   <li>Given {@link GlyphSubstitutionTable}
   * {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)} return
   * one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutingCmapLookup#getGlyphId(int)}
   */
  @Test
  @DisplayName("Test getGlyphId(int); given GlyphSubstitutionTable getSubstitution(int, String[], List) return one; then return one")
  void testGetGlyphId_givenGlyphSubstitutionTableGetSubstitutionReturnOne_thenReturnOne() {
    // Arrange
    CmapSubtable cmap = mock(CmapSubtable.class);
    when(cmap.getGlyphId(anyInt())).thenReturn(1);
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);

    // Act
    int actualGlyphId = (new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>())).getGlyphId(1);

    // Assert
    verify(cmap).getGlyphId(eq(1));
    verify(gsub).getSubstitution(eq(1), isA(String[].class), isA(List.class));
    assertEquals(1, actualGlyphId);
  }

  /**
   * Test {@link SubstitutingCmapLookup#getGlyphId(int)}.
   * <ul>
   *   <li>When {@code 1114111}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutingCmapLookup#getGlyphId(int)}
   */
  @Test
  @DisplayName("Test getGlyphId(int); when '1114111'; then return one")
  void testGetGlyphId_when1114111_thenReturnOne() {
    // Arrange
    CmapSubtable cmap = mock(CmapSubtable.class);
    when(cmap.getGlyphId(anyInt())).thenReturn(1);
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);

    // Act
    int actualGlyphId = (new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>())).getGlyphId(1114111);

    // Assert
    verify(cmap).getGlyphId(eq(1114111));
    verify(gsub).getSubstitution(eq(1), isA(String[].class), isA(List.class));
    assertEquals(1, actualGlyphId);
  }

  /**
   * Test {@link SubstitutingCmapLookup#getGlyphId(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutingCmapLookup#getGlyphId(int)}
   */
  @Test
  @DisplayName("Test getGlyphId(int); when zero; then return one")
  void testGetGlyphId_whenZero_thenReturnOne() {
    // Arrange
    CmapSubtable cmap = mock(CmapSubtable.class);
    when(cmap.getGlyphId(anyInt())).thenReturn(1);
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);

    // Act
    int actualGlyphId = (new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>())).getGlyphId(0);

    // Assert
    verify(cmap).getGlyphId(eq(0));
    verify(gsub).getSubstitution(eq(1), isA(String[].class), isA(List.class));
    assertEquals(1, actualGlyphId);
  }

  /**
   * Test {@link SubstitutingCmapLookup#getCharCodes(int)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutingCmapLookup#getCharCodes(int)}
   */
  @Test
  @DisplayName("Test getCharCodes(int); then return 'null'")
  void testGetCharCodes_thenReturnNull() {
    // Arrange
    CmapSubtable cmap = new CmapSubtable();
    GlyphSubstitutionTable gsub = new GlyphSubstitutionTable();

    // Act and Assert
    assertNull((new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>())).getCharCodes(1));
  }

  /**
   * Test {@link SubstitutingCmapLookup#getCharCodes(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutingCmapLookup#getCharCodes(int)}
   */
  @Test
  @DisplayName("Test getCharCodes(int); when minus one; then return 'null'")
  void testGetCharCodes_whenMinusOne_thenReturnNull() {
    // Arrange
    CmapSubtable cmap = new CmapSubtable();
    GlyphSubstitutionTable gsub = new GlyphSubstitutionTable();

    // Act and Assert
    assertNull((new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>())).getCharCodes(-1));
  }
}
