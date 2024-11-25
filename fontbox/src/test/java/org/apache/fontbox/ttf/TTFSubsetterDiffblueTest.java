package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TTFSubsetterDiffblueTest {
  /**
   * Test {@link TTFSubsetter#getGIDMap()}.
   * <p>
   * Method under test: {@link TTFSubsetter#getGIDMap()}
   */
  @Test
  @DisplayName("Test getGIDMap()")
  void testGetGIDMap() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);
    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[]{0L, 0L, 1L, 0L});
    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);

    // Act
    Map<Integer, Integer> actualGIDMap = (new TTFSubsetter(ttf)).getGIDMap();

    // Assert
    verify(indexToLocationTable).getOffsets();
    verify(ttf).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getIndexToLocation();
    verify(ttf).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
    assertEquals(1, actualGIDMap.size());
    assertEquals(0, actualGIDMap.get(0).intValue());
  }

  /**
   * Test {@link TTFSubsetter#getGIDMap()}.
   * <p>
   * Method under test: {@link TTFSubsetter#getGIDMap()}
   */
  @Test
  @DisplayName("Test getGIDMap()")
  void testGetGIDMap2() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);
    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[]{Long.MAX_VALUE, 0L, 1L, 0L});
    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);

    // Act
    Map<Integer, Integer> actualGIDMap = (new TTFSubsetter(ttf)).getGIDMap();

    // Assert
    verify(indexToLocationTable).getOffsets();
    verify(ttf).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getIndexToLocation();
    verify(ttf).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
    assertEquals(1, actualGIDMap.size());
    assertEquals(0, actualGIDMap.get(0).intValue());
  }

  /**
   * Test {@link TTFSubsetter#getGIDMap()}.
   * <p>
   * Method under test: {@link TTFSubsetter#getGIDMap()}
   */
  @Test
  @DisplayName("Test getGIDMap()")
  void testGetGIDMap3() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);
    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[]{1L, 500L, 1L, 0L});
    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream(new byte[]{}));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);

    // Act
    Map<Integer, Integer> actualGIDMap = (new TTFSubsetter(ttf)).getGIDMap();

    // Assert
    verify(indexToLocationTable).getOffsets();
    verify(ttf).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getIndexToLocation();
    verify(ttf).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
    assertEquals(1, actualGIDMap.size());
    assertEquals(0, actualGIDMap.get(0).intValue());
  }
}
