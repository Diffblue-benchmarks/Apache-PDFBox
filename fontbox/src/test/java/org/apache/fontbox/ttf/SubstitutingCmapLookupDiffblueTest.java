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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SubstitutingCmapLookupDiffblueTest {
  /**
   * Method under test: {@link SubstitutingCmapLookup#getGlyphId(int)}
   */
  @Test
  void testGetGlyphId() {
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
   * Method under test: {@link SubstitutingCmapLookup#getGlyphId(int)}
   */
  @Test
  void testGetGlyphId2() {
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
   * Method under test: {@link SubstitutingCmapLookup#getGlyphId(int)}
   */
  @Test
  void testGetGlyphId3() {
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
   * Method under test: {@link SubstitutingCmapLookup#getCharCodes(int)}
   */
  @Test
  void testGetCharCodes() {
    // Arrange
    CmapSubtable cmap = new CmapSubtable();
    GlyphSubstitutionTable gsub = new GlyphSubstitutionTable();

    // Act and Assert
    assertNull((new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>())).getCharCodes(1));
  }

  /**
   * Method under test: {@link SubstitutingCmapLookup#getCharCodes(int)}
   */
  @Test
  void testGetCharCodes2() {
    // Arrange
    CmapSubtable cmap = new CmapSubtable();
    GlyphSubstitutionTable gsub = new GlyphSubstitutionTable();

    // Act and Assert
    assertNull((new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>())).getCharCodes(-1));
  }
}
