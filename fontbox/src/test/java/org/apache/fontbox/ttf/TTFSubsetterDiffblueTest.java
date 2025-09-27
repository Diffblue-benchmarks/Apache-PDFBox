package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TTFSubsetterDiffblueTest {
  /**
   * Test {@link TTFSubsetter#getGIDMap()}.
   *
   * <p>Method under test: {@link TTFSubsetter#getGIDMap()}
   */
  @Test
  @DisplayName("Test getGIDMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TTFSubsetter.getGIDMap()"})
  void testGetGIDMap() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);

    // Act
    Map<Integer, Integer> actualGIDMap = new TTFSubsetter(ttf).getGIDMap();

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
   *
   * <p>Method under test: {@link TTFSubsetter#getGIDMap()}
   */
  @Test
  @DisplayName("Test getGIDMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TTFSubsetter.getGIDMap()"})
  void testGetGIDMap2() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {-1L, 0L, 1L, 0L});

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);

    // Act
    Map<Integer, Integer> actualGIDMap = new TTFSubsetter(ttf).getGIDMap();

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
   *
   * <p>Method under test: {@link TTFSubsetter#getGIDMap()}
   */
  @Test
  @DisplayName("Test getGIDMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TTFSubsetter.getGIDMap()"})
  void testGetGIDMap3() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {Long.MAX_VALUE, 0L, 1L, 0L});

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);

    // Act
    Map<Integer, Integer> actualGIDMap = new TTFSubsetter(ttf).getGIDMap();

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
   *
   * <p>Method under test: {@link TTFSubsetter#getGIDMap()}
   */
  @Test
  @DisplayName("Test getGIDMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TTFSubsetter.getGIDMap()"})
  void testGetGIDMap4() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {-1L, 0L, 1L, 0L});

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[] {});
    when(ttf.getOriginalData()).thenReturn(byteArrayInputStream);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);

    // Act
    Map<Integer, Integer> actualGIDMap = new TTFSubsetter(ttf).getGIDMap();

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
   *
   * <p>Method under test: {@link TTFSubsetter#getGIDMap()}
   */
  @Test
  @DisplayName("Test getGIDMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TTFSubsetter.getGIDMap()"})
  void testGetGIDMap5() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {1L, 500L, 1L, 0L});

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[] {});
    when(ttf.getOriginalData()).thenReturn(byteArrayInputStream);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);

    // Act
    Map<Integer, Integer> actualGIDMap = new TTFSubsetter(ttf).getGIDMap();

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
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#getGIDMap()}
   */
  @Test
  @DisplayName("Test getGIDMap(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TTFSubsetter.getGIDMap()"})
  void testGetGIDMap_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getOriginalData()).thenThrow(new UnsupportedOperationException());
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(new GlyphTable());
    when(ttf.getIndexToLocation()).thenReturn(new IndexToLocationTable());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new TTFSubsetter(ttf).getGIDMap());
    verify(ttf).getGlyph();
    verify(ttf).getIndexToLocation();
    verify(ttf).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream() throws IOException {
    // Arrange
    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getOriginalData()).thenThrow(new UnsupportedOperationException());
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(new GlyphTable());
    when(ttf.getIndexToLocation()).thenReturn(new IndexToLocationTable());
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(ttf).getGlyph();
    verify(ttf).getIndexToLocation();
    verify(ttf).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream2() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getHorizontalHeader()).thenThrow(new UnsupportedOperationException());
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable).getOffsets();
    verify(ttf).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getIndexToLocation();
    verify(ttf).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream3() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getMaximumProfile()).thenThrow(new UnsupportedOperationException());
    when(ttf.getHorizontalHeader()).thenReturn(new HorizontalHeaderTable());
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable).getOffsets();
    verify(ttf).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream4() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(new HorizontalMetricsTable());
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(new HorizontalHeaderTable());
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(EOFException.class, () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream5() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenThrow(new UnsupportedOperationException());

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(new HorizontalHeaderTable());
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream6() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    HorizontalHeaderTable horizontalHeaderTable = new HorizontalHeaderTable();
    horizontalHeaderTable.setNumberOfHMetrics(CmapTable.ENCODING_WIN_UNICODE_FULL);

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getOffset()).thenReturn(1L);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getPostScript()).thenThrow(new UnsupportedOperationException());
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(horizontalMetricsTable, atLeast(1)).getOffset();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream7() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    HorizontalHeaderTable horizontalHeaderTable = new HorizontalHeaderTable();
    horizontalHeaderTable.setNumberOfHMetrics(CmapTable.ENCODING_WIN_UNICODE_FULL);

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getOffset()).thenReturn(1L);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getGlyphNames()).thenThrow(new UnsupportedOperationException());

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(postScriptTable).getGlyphNames();
    verify(horizontalMetricsTable, atLeast(1)).getOffset();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream8() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    HorizontalHeaderTable horizontalHeaderTable = new HorizontalHeaderTable();
    horizontalHeaderTable.setNumberOfHMetrics(CmapTable.ENCODING_WIN_UNICODE_FULL);

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getOffset()).thenReturn(1L);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getItalicAngle()).thenThrow(new UnsupportedOperationException());
    when(postScriptTable.getGlyphNames()).thenReturn(new String[] {"Glyph Names"});

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(postScriptTable).getGlyphNames();
    verify(postScriptTable).getItalicAngle();
    verify(horizontalMetricsTable, atLeast(1)).getOffset();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link GlyphTable#TAG} is {@link TTFTable#TTFTable()}.
   *   <li>Then array length is two hundred twenty.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeToStream(OutputStream); given HashMap() TAG is TTFTable(); then array length is two hundred twenty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_givenHashMapTagIsTTFTable_thenArrayLengthIsTwoHundredTwenty()
      throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    HorizontalHeaderTable horizontalHeaderTable = new HorizontalHeaderTable();
    horizontalHeaderTable.setNumberOfHMetrics(CmapTable.ENCODING_WIN_UNICODE_FULL);

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getOffset()).thenReturn(1L);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    HashMap<String, TTFTable> stringTtfTableMap = new HashMap<>();
    stringTtfTableMap.put(GlyphTable.TAG, new TTFTable());

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getTableMap()).thenReturn(stringTtfTableMap);
    when(ttf.getPostScript()).thenReturn(new PostScriptTable());
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    ttfSubsetter.writeToStream(os);

    // Assert
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(horizontalMetricsTable, atLeast(1)).getOffset();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getPostScript();
    verify(ttf).getTableMap();
    verify(ttf).getUnicodeCmapLookup();
    assertEquals(220, os.toByteArray().length);
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link HorizontalMetricsTable#HorizontalMetricsTable()} Offset is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeToStream(OutputStream); given HorizontalMetricsTable() Offset is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_givenHorizontalMetricsTableOffsetIsFortyTwo() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    HorizontalMetricsTable horizontalMetricsTable = new HorizontalMetricsTable();
    horizontalMetricsTable.setOffset(42L);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(new HorizontalHeaderTable());
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(EOFException.class, () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link MaximumProfileTable#MaximumProfileTable()} Version is one.
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeToStream(OutputStream); given MaximumProfileTable() Version is one; then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_givenMaximumProfileTableVersionIsOne_thenThrowEOFException()
      throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    MaximumProfileTable maximumProfileTable = new MaximumProfileTable();
    maximumProfileTable.setVersion(1.0f);

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getOffset()).thenReturn(1L);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getHorizontalHeader()).thenReturn(new HorizontalHeaderTable());
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(EOFException.class, () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(horizontalMetricsTable, atLeast(1)).getOffset();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link NameRecord} (default constructor) LanguageId is one.
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeToStream(OutputStream); given NameRecord (default constructor) LanguageId is one; then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_givenNameRecordLanguageIdIsOne_thenThrowEOFException() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    NameRecord nameRecord = new NameRecord();
    nameRecord.setLanguageId(1);
    nameRecord.setNameId(1);
    nameRecord.setPlatformEncodingId(1);
    nameRecord.setPlatformId(1);
    nameRecord.setString("42");
    nameRecord.setStringLength(3);
    nameRecord.setStringOffset(42);

    ArrayList<NameRecord> nameRecordList = new ArrayList<>();
    nameRecordList.add(nameRecord);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(nameRecordList);

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(new HorizontalMetricsTable());
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(new HorizontalHeaderTable());
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(EOFException.class, () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link NameRecord} (default constructor) LanguageId is three.
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeToStream(OutputStream); given NameRecord (default constructor) LanguageId is three; then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_givenNameRecordLanguageIdIsThree_thenThrowEOFException()
      throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getOffset()).thenReturn(1L);

    NameRecord nameRecord = new NameRecord();
    nameRecord.setLanguageId(3);
    nameRecord.setNameId(3);
    nameRecord.setPlatformEncodingId(3);
    nameRecord.setPlatformId(3);
    nameRecord.setString("String Value");
    nameRecord.setStringLength(1);
    nameRecord.setStringOffset(2);

    ArrayList<NameRecord> nameRecordList = new ArrayList<>();
    nameRecordList.add(nameRecord);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(nameRecordList);

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(new HorizontalHeaderTable());
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(EOFException.class, () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(horizontalMetricsTable, atLeast(1)).getOffset();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link NameRecord} (default constructor) LanguageId is two.
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeToStream(OutputStream); given NameRecord (default constructor) LanguageId is two; then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_givenNameRecordLanguageIdIsTwo_thenThrowEOFException() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    NameRecord nameRecord = new NameRecord();
    nameRecord.setLanguageId(1);
    nameRecord.setNameId(1);
    nameRecord.setPlatformEncodingId(1);
    nameRecord.setPlatformId(1);
    nameRecord.setString("42");
    nameRecord.setStringLength(3);
    nameRecord.setStringOffset(42);

    NameRecord nameRecord2 = new NameRecord();
    nameRecord2.setLanguageId(2);
    nameRecord2.setNameId(2);
    nameRecord2.setPlatformEncodingId(2);
    nameRecord2.setPlatformId(2);
    nameRecord2.setString("Unexpected EOF exception parsing glyphId of hmtx table.");
    nameRecord2.setStringLength(42);
    nameRecord2.setStringOffset(1);

    ArrayList<NameRecord> nameRecordList = new ArrayList<>();
    nameRecordList.add(nameRecord2);
    nameRecordList.add(nameRecord);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(nameRecordList);

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(new HorizontalMetricsTable());
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(new HorizontalHeaderTable());
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(EOFException.class, () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link OpenTypeFont} {@link OpenTypeFont#getHeader()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeToStream(OutputStream); given OpenTypeFont getHeader() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_givenOpenTypeFontGetHeaderThrowUnsupportedOperationException()
      throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getHeader()).thenThrow(new UnsupportedOperationException());
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable).getOffsets();
    verify(ttf).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getHeader();
    verify(ttf).getIndexToLocation();
    verify(ttf).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link OpenTypeFont} {@link OpenTypeFont#getNaming()} return {@code null}.
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeToStream(OutputStream); given OpenTypeFont getNaming() return 'null'; then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_givenOpenTypeFontGetNamingReturnNull_thenThrowEOFException()
      throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(new HorizontalMetricsTable());
    when(ttf.getNaming()).thenReturn(null);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(new HorizontalHeaderTable());
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(EOFException.class, () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(ttf, atLeast(1)).getGlyph();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link OpenTypeFont} {@link OpenTypeFont#getPostScript()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream); given OpenTypeFont getPostScript() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_givenOpenTypeFontGetPostScriptReturnNull() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    HorizontalHeaderTable horizontalHeaderTable = new HorizontalHeaderTable();
    horizontalHeaderTable.setNumberOfHMetrics(CmapTable.ENCODING_WIN_UNICODE_FULL);

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getOffset()).thenReturn(1L);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getTableMap()).thenReturn(new HashMap<>());
    when(ttf.getPostScript()).thenReturn(null);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    ttfSubsetter.writeToStream(os);

    // Assert
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(horizontalMetricsTable, atLeast(1)).getOffset();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getPostScript();
    verify(ttf).getTableMap();
    verify(ttf).getUnicodeCmapLookup();
    assertEquals(220, os.toByteArray().length);
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Then array length is two hundred twenty.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream); then array length is two hundred twenty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_thenArrayLengthIsTwoHundredTwenty() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    HorizontalHeaderTable horizontalHeaderTable = new HorizontalHeaderTable();
    horizontalHeaderTable.setNumberOfHMetrics(CmapTable.ENCODING_WIN_UNICODE_FULL);

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getOffset()).thenReturn(1L);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getTableMap()).thenReturn(new HashMap<>());
    when(ttf.getPostScript()).thenReturn(new PostScriptTable());
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    ttfSubsetter.writeToStream(os);

    // Assert
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(horizontalMetricsTable, atLeast(1)).getOffset();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getPostScript();
    verify(ttf).getTableMap();
    verify(ttf).getUnicodeCmapLookup();
    assertEquals(220, os.toByteArray().length);
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream); then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_thenThrowEOFException() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getOffset()).thenReturn(1L);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(new HorizontalHeaderTable());
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);

    // Act and Assert
    assertThrows(EOFException.class, () -> ttfSubsetter.writeToStream(new ByteArrayOutputStream()));
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(horizontalMetricsTable, atLeast(1)).getOffset();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Then two hundred fifty-second element is zero.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream); then two hundred fifty-second element is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_thenTwoHundredFiftySecondElementIsZero() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    HorizontalHeaderTable horizontalHeaderTable = new HorizontalHeaderTable();
    horizontalHeaderTable.setNumberOfHMetrics(CmapTable.ENCODING_WIN_UNICODE_FULL);

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getOffset()).thenReturn(1L);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    PostScriptTable postScriptTable = new PostScriptTable();
    postScriptTable.setGlyphNames(new String[] {"42"});

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getTableMap()).thenReturn(new HashMap<>());
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    ttfSubsetter.writeToStream(os);

    // Assert
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(horizontalMetricsTable, atLeast(1)).getOffset();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getPostScript();
    verify(ttf).getTableMap();
    verify(ttf).getUnicodeCmapLookup();
    byte[] toByteArrayResult = os.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[251]);
    assertEquals((byte) 0, toByteArrayResult[252]);
    assertEquals((byte) 0, toByteArrayResult[253]);
    assertEquals((byte) 0, toByteArrayResult[254]);
    assertEquals((byte) 0, toByteArrayResult[255]);
    assertEquals((byte) 0, toByteArrayResult[259]);
    assertEquals((byte) 0, toByteArrayResult[263]);
    assertEquals((byte) 0, toByteArrayResult[267]);
    assertEquals((byte) 0, toByteArrayResult[275]);
    assertEquals(276, toByteArrayResult.length);
    assertEquals(GlyfDescript.X_SHORT_VECTOR, toByteArrayResult[272]);
    assertEquals('2', toByteArrayResult[274]);
    assertEquals('4', toByteArrayResult[273]);
  }

  /**
   * Test {@link TTFSubsetter#writeToStream(OutputStream)}.
   *
   * <ul>
   *   <li>Then two hundred seventy-eighth element is zero.
   * </ul>
   *
   * <p>Method under test: {@link TTFSubsetter#writeToStream(OutputStream)}
   */
  @Test
  @DisplayName("Test writeToStream(OutputStream); then two hundred seventy-eighth element is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TTFSubsetter.writeToStream(OutputStream)"})
  void testWriteToStream_thenTwoHundredSeventyEighthElementIsZero() throws IOException {
    // Arrange
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getOffset()).thenReturn(1L);

    IndexToLocationTable indexToLocationTable = mock(IndexToLocationTable.class);
    when(indexToLocationTable.getOffsets()).thenReturn(new long[] {0L, 0L, 1L, 0L});

    HeaderTable headerTable = new HeaderTable();
    headerTable.setModified(new GregorianCalendar(1, 1, 1));
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1, 1, 1);
    headerTable.setCreated(createdValue);

    HorizontalHeaderTable horizontalHeaderTable = new HorizontalHeaderTable();
    horizontalHeaderTable.setNumberOfHMetrics(CmapTable.ENCODING_WIN_UNICODE_FULL);

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getOffset()).thenReturn(1L);

    NamingTable namingTable = mock(NamingTable.class);
    when(namingTable.getNameRecords()).thenReturn(new ArrayList<>());

    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getItalicAngle()).thenReturn(10.0f);
    when(postScriptTable.getName(anyInt())).thenReturn("Name");
    when(postScriptTable.getIsFixedPitch()).thenReturn(1L);
    when(postScriptTable.getMaxMemType1()).thenReturn(1L);
    when(postScriptTable.getMaxMemType42()).thenReturn(1L);
    when(postScriptTable.getMinMemType1()).thenReturn(1L);
    when(postScriptTable.getMinMemType42()).thenReturn(1L);
    when(postScriptTable.getUnderlinePosition()).thenReturn((short) 1);
    when(postScriptTable.getUnderlineThickness()).thenReturn((short) 1);
    when(postScriptTable.getGlyphNames()).thenReturn(new String[] {"Glyph Names"});

    OpenTypeFont ttf = mock(OpenTypeFont.class);
    when(ttf.getTableMap()).thenReturn(new HashMap<>());
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getCmap()).thenReturn(new CmapTable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getNaming()).thenReturn(namingTable);
    when(ttf.getOS2Windows()).thenReturn(new OS2WindowsMetricsTable());
    when(ttf.getMaximumProfile()).thenReturn(new MaximumProfileTable());
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getIndexToLocation()).thenReturn(indexToLocationTable);
    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    ttfSubsetter.writeToStream(os);

    // Assert
    verify(indexToLocationTable, atLeast(1)).getOffsets();
    verify(namingTable).getNameRecords();
    verify(ttf, atLeast(1)).getGlyph();
    verify(postScriptTable).getGlyphNames();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(postScriptTable).getMaxMemType1();
    verify(postScriptTable).getMaxMemType42();
    verify(postScriptTable).getMinMemType1();
    verify(postScriptTable).getMinMemType42();
    verify(postScriptTable).getName(0);
    verify(postScriptTable).getUnderlinePosition();
    verify(postScriptTable).getUnderlineThickness();
    verify(horizontalMetricsTable, atLeast(1)).getOffset();
    verify(glyphTable, atLeast(1)).getOffset();
    verify(ttf).getCmap();
    verify(ttf).getHeader();
    verify(ttf, atLeast(1)).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getIndexToLocation();
    verify(ttf).getMaximumProfile();
    verify(ttf).getNaming();
    verify(ttf).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getPostScript();
    verify(ttf).getTableMap();
    verify(ttf).getUnicodeCmapLookup();
    byte[] toByteArrayResult = os.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[277]);
    assertEquals((byte) 0, toByteArrayResult[278]);
    assertEquals((byte) 0, toByteArrayResult[279]);
    assertEquals(280, toByteArrayResult.length);
    assertEquals(GlyfDescript.ON_CURVE, toByteArrayResult[255]);
    assertEquals(GlyfDescript.ON_CURVE, toByteArrayResult[259]);
    assertEquals(GlyfDescript.ON_CURVE, toByteArrayResult[263]);
    assertEquals(GlyfDescript.ON_CURVE, toByteArrayResult[267]);
    assertEquals(GlyfDescript.Y_SHORT_VECTOR, toByteArrayResult[272]);
    assertEquals('N', toByteArrayResult[273]);
    assertEquals('a', toByteArrayResult[274]);
    assertEquals('e', toByteArrayResult[276]);
    assertEquals('m', toByteArrayResult[275]);
  }
}
