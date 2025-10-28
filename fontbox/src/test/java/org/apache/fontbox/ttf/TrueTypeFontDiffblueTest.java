package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;

class TrueTypeFontDiffblueTest {
  /**
   * Method under test: {@link TrueTypeFont#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).close();

    // Assert that nothing has changed
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link TrueTypeFont#addTable(TTFTable)}
   */
  @Test
  void testAddTable() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    TTFTable table = new TTFTable();

    // Act
    trueTypeFont.addTable(table);

    // Assert
    assertEquals(1, trueTypeFont.getTables().size());
    Map<String, TTFTable> tableMap = trueTypeFont.getTableMap();
    assertEquals(1, tableMap.size());
    assertSame(table, tableMap.get(null));
  }

  /**
   * Method under test: {@link TrueTypeFont#addTable(TTFTable)}
   */
  @Test
  void testAddTable2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    TTFTable table = new TTFTable();

    // Act
    trueTypeFont.addTable(table);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(1, trueTypeFont.getTables().size());
    Map<String, TTFTable> tableMap = trueTypeFont.getTableMap();
    assertEquals(1, tableMap.size());
    assertSame(table, tableMap.get(null));
  }

  /**
   * Method under test: {@link TrueTypeFont#getTables()}
   */
  @Test
  void testGetTables() throws IOException {
    // Arrange, Act and Assert
    assertTrue(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getTables()
            .isEmpty());
  }

  /**
   * Method under test: {@link TrueTypeFont#getTables()}
   */
  @Test
  void testGetTables2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Collection<TTFTable> actualTables = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getTables();

    // Assert
    verify(inputStream).readAllBytes();
    assertTrue(actualTables.isEmpty());
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  void testGetTableBytes() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertEquals(0, trueTypeFont.getTableBytes(new TTFTable()).length);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  void testGetTableBytes2() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{})));

    // Act and Assert
    assertEquals(0, trueTypeFont.getTableBytes(new TTFTable()).length);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  void testGetTableBytes3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));

    // Act
    byte[] actualTableBytes = trueTypeFont.getTableBytes(new TTFTable());

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualTableBytes.length);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  void testGetTableBytes4() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")))));

    // Act and Assert
    assertEquals(0, trueTypeFont.getTableBytes(new TTFTable()).length);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  void testGetTableBytes5() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));

    TTFTable table = new TTFTable();
    table.setLength(3L);

    // Act
    byte[] actualTableBytes = trueTypeFont.getTableBytes(table);

    // Assert
    verify(inputStream).readAllBytes();
    assertArrayEquals("AXA".getBytes("UTF-8"), actualTableBytes);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  void testGetTableBytes6() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))));

    // Act and Assert
    assertEquals(0, trueTypeFont.getTableBytes(new TTFTable()).length);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  void testGetTableBytes7() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")))));

    TTFTable table = new TTFTable();
    table.setLength(3L);

    // Act
    byte[] actualTableBytes = trueTypeFont.getTableBytes(table);

    // Assert
    assertArrayEquals("A\bA".getBytes("UTF-8"), actualTableBytes);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  void testGetTable() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getTable("Tag"));
  }

  /**
   * Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  void testGetTable2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TTFTable actualTable = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getTable("Tag");

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualTable);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  void testGetTableNBytes() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertEquals(0, trueTypeFont.getTableNBytes(new TTFTable(), 1).length);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  void testGetTableNBytes2() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{})));

    // Act and Assert
    assertEquals(0, trueTypeFont.getTableNBytes(new TTFTable(), 1).length);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  void testGetTableNBytes3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));

    // Act
    byte[] actualTableNBytes = trueTypeFont.getTableNBytes(new TTFTable(), 1);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualTableNBytes.length);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  void testGetTableNBytes4() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")))));

    // Act and Assert
    assertEquals(0, trueTypeFont.getTableNBytes(new TTFTable(), 1).length);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  void testGetTableNBytes5() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));

    TTFTable table = new TTFTable();
    table.setLength(3L);

    // Act
    byte[] actualTableNBytes = trueTypeFont.getTableNBytes(table, 1);

    // Assert
    verify(inputStream).readAllBytes();
    assertArrayEquals(new byte[]{'A'}, actualTableNBytes);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  void testGetTableNBytes6() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))));

    // Act and Assert
    assertEquals(0, trueTypeFont.getTableNBytes(new TTFTable(), 1).length);
  }

  /**
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  void testGetTableNBytes7() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")))));

    TTFTable table = new TTFTable();
    table.setLength(3L);

    // Act and Assert
    assertArrayEquals(new byte[]{'A'}, trueTypeFont.getTableNBytes(table, 1));
  }

  /**
   * Method under test: {@link TrueTypeFont#getNaming()}
   */
  @Test
  void testGetNaming() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getNaming());
  }

  /**
   * Method under test: {@link TrueTypeFont#getNaming()}
   */
  @Test
  void testGetNaming2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    NamingTable actualNaming = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getNaming();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualNaming);
  }

  /**
   * Method under test: {@link TrueTypeFont#getPostScript()}
   */
  @Test
  void testGetPostScript() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getPostScript());
  }

  /**
   * Method under test: {@link TrueTypeFont#getPostScript()}
   */
  @Test
  void testGetPostScript2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PostScriptTable actualPostScript = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getPostScript();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualPostScript);
  }

  /**
   * Method under test: {@link TrueTypeFont#getOS2Windows()}
   */
  @Test
  void testGetOS2Windows() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getOS2Windows());
  }

  /**
   * Method under test: {@link TrueTypeFont#getOS2Windows()}
   */
  @Test
  void testGetOS2Windows2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    OS2WindowsMetricsTable actualOS2Windows = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream)))
        .getOS2Windows();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualOS2Windows);
  }

  /**
   * Method under test: {@link TrueTypeFont#getMaximumProfile()}
   */
  @Test
  void testGetMaximumProfile() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getMaximumProfile());
  }

  /**
   * Method under test: {@link TrueTypeFont#getMaximumProfile()}
   */
  @Test
  void testGetMaximumProfile2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    MaximumProfileTable actualMaximumProfile = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream)))
        .getMaximumProfile();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualMaximumProfile);
  }

  /**
   * Method under test: {@link TrueTypeFont#getHeader()}
   */
  @Test
  void testGetHeader() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getHeader());
  }

  /**
   * Method under test: {@link TrueTypeFont#getHeader()}
   */
  @Test
  void testGetHeader2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    HeaderTable actualHeader = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getHeader();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualHeader);
  }

  /**
   * Method under test: {@link TrueTypeFont#getHorizontalHeader()}
   */
  @Test
  void testGetHorizontalHeader() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getHorizontalHeader());
  }

  /**
   * Method under test: {@link TrueTypeFont#getHorizontalHeader()}
   */
  @Test
  void testGetHorizontalHeader2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    HorizontalHeaderTable actualHorizontalHeader = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream)))
        .getHorizontalHeader();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualHorizontalHeader);
  }

  /**
   * Method under test: {@link TrueTypeFont#getHorizontalMetrics()}
   */
  @Test
  void testGetHorizontalMetrics() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getHorizontalMetrics());
  }

  /**
   * Method under test: {@link TrueTypeFont#getHorizontalMetrics()}
   */
  @Test
  void testGetHorizontalMetrics2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    HorizontalMetricsTable actualHorizontalMetrics = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream)))
        .getHorizontalMetrics();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualHorizontalMetrics);
  }

  /**
   * Method under test: {@link TrueTypeFont#getIndexToLocation()}
   */
  @Test
  void testGetIndexToLocation() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getIndexToLocation());
  }

  /**
   * Method under test: {@link TrueTypeFont#getIndexToLocation()}
   */
  @Test
  void testGetIndexToLocation2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    IndexToLocationTable actualIndexToLocation = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream)))
        .getIndexToLocation();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualIndexToLocation);
  }

  /**
   * Method under test: {@link TrueTypeFont#getGlyph()}
   */
  @Test
  void testGetGlyph() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getGlyph());
  }

  /**
   * Method under test: {@link TrueTypeFont#getGlyph()}
   */
  @Test
  void testGetGlyph2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    GlyphTable actualGlyph = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getGlyph();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualGlyph);
  }

  /**
   * Method under test: {@link TrueTypeFont#getCmap()}
   */
  @Test
  void testGetCmap() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getCmap());
  }

  /**
   * Method under test: {@link TrueTypeFont#getCmap()}
   */
  @Test
  void testGetCmap2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    CmapTable actualCmap = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getCmap();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualCmap);
  }

  /**
   * Method under test: {@link TrueTypeFont#getVerticalHeader()}
   */
  @Test
  void testGetVerticalHeader() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getVerticalHeader());
  }

  /**
   * Method under test: {@link TrueTypeFont#getVerticalHeader()}
   */
  @Test
  void testGetVerticalHeader2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    VerticalHeaderTable actualVerticalHeader = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream)))
        .getVerticalHeader();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualVerticalHeader);
  }

  /**
   * Method under test: {@link TrueTypeFont#getVerticalMetrics()}
   */
  @Test
  void testGetVerticalMetrics() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getVerticalMetrics());
  }

  /**
   * Method under test: {@link TrueTypeFont#getVerticalMetrics()}
   */
  @Test
  void testGetVerticalMetrics2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    VerticalMetricsTable actualVerticalMetrics = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream)))
        .getVerticalMetrics();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualVerticalMetrics);
  }

  /**
   * Method under test: {@link TrueTypeFont#getVerticalOrigin()}
   */
  @Test
  void testGetVerticalOrigin() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getVerticalOrigin());
  }

  /**
   * Method under test: {@link TrueTypeFont#getVerticalOrigin()}
   */
  @Test
  void testGetVerticalOrigin2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    VerticalOriginTable actualVerticalOrigin = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream)))
        .getVerticalOrigin();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualVerticalOrigin);
  }

  /**
   * Method under test: {@link TrueTypeFont#getKerning()}
   */
  @Test
  void testGetKerning() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getKerning());
  }

  /**
   * Method under test: {@link TrueTypeFont#getKerning()}
   */
  @Test
  void testGetKerning2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    KerningTable actualKerning = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getKerning();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualKerning);
  }

  /**
   * Method under test: {@link TrueTypeFont#getGsub()}
   */
  @Test
  void testGetGsub() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getGsub());
  }

  /**
   * Method under test: {@link TrueTypeFont#getGsub()}
   */
  @Test
  void testGetGsub2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    GlyphSubstitutionTable actualGsub = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getGsub();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualGsub);
  }

  /**
   * Method under test: {@link TrueTypeFont#getOriginalData()}
   */
  @Test
  void testGetOriginalData() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getOriginalData()
            .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link TrueTypeFont#getOriginalData()}
   */
  @Test
  void testGetOriginalData2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    InputStream actualOriginalData = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getOriginalData();

    // Assert
    verify(inputStream).readAllBytes();
    byte[] byteArray = new byte[8];
    assertEquals(8, actualOriginalData.read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link TrueTypeFont#getOriginalDataSize()}
   */
  @Test
  void testGetOriginalDataSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8L,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getOriginalDataSize());
    assertEquals(8L,
        (new TrueTypeFont(new RandomAccessReadUnbufferedDataStream(
            new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
                .getOriginalDataSize());
  }

  /**
   * Method under test: {@link TrueTypeFont#getOriginalDataSize()}
   */
  @Test
  void testGetOriginalDataSize2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    long actualOriginalDataSize = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getOriginalDataSize();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(8L, actualOriginalDataSize);
  }

  /**
   * Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  void testReadTable() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));

    // Act
    trueTypeFont.readTable(new TTFTable());

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  void testReadTable2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    GlyphTable table = new GlyphTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert
    verify(inputStream).readAllBytes();
    assertTrue(table.getInitialized());
  }

  /**
   * Method under test: {@link TrueTypeFont#readTableHeaders(String, FontHeaders)}
   */
  @Test
  void testReadTableHeaders() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");
    outHeaders.setHeaderMacStyle(1);
    outHeaders.setIsOTFAndPostScript(true);
    outHeaders.setName("Name");
    outHeaders.setNonOtfGcid142("AXAXAXAX".getBytes("UTF-8"));
    outHeaders.setOs2Windows(new OS2WindowsMetricsTable());

    // Act
    trueTypeFont.readTableHeaders("Tag", outHeaders);

    // Assert that nothing has changed
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link TrueTypeFont#getNumberOfGlyphs()}
   */
  @Test
  void testGetNumberOfGlyphs() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getNumberOfGlyphs());
  }

  /**
   * Method under test: {@link TrueTypeFont#getNumberOfGlyphs()}
   */
  @Test
  void testGetNumberOfGlyphs2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualNumberOfGlyphs = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getNumberOfGlyphs();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualNumberOfGlyphs);
  }

  /**
   * Method under test: {@link TrueTypeFont#getUnitsPerEm()}
   */
  @Test
  void testGetUnitsPerEm() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getUnitsPerEm());
  }

  /**
   * Method under test: {@link TrueTypeFont#getUnitsPerEm()}
   */
  @Test
  void testGetUnitsPerEm2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualUnitsPerEm = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getUnitsPerEm();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualUnitsPerEm);
  }

  /**
   * Method under test: {@link TrueTypeFont#getAdvanceWidth(int)}
   */
  @Test
  void testGetAdvanceWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getAdvanceWidth(1));
  }

  /**
   * Method under test: {@link TrueTypeFont#getAdvanceWidth(int)}
   */
  @Test
  void testGetAdvanceWidth2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualAdvanceWidth = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getAdvanceWidth(1);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(250, actualAdvanceWidth);
  }

  /**
   * Method under test: {@link TrueTypeFont#getAdvanceHeight(int)}
   */
  @Test
  void testGetAdvanceHeight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getAdvanceHeight(1));
  }

  /**
   * Method under test: {@link TrueTypeFont#getAdvanceHeight(int)}
   */
  @Test
  void testGetAdvanceHeight2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualAdvanceHeight = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getAdvanceHeight(1);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(250, actualAdvanceHeight);
  }

  /**
   * Method under test: {@link TrueTypeFont#getName()}
   */
  @Test
  void testGetName() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getName());
  }

  /**
   * Method under test: {@link TrueTypeFont#getName()}
   */
  @Test
  void testGetName2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualName = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getName();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualName);
  }

  /**
   * Method under test: {@link TrueTypeFont#getUnicodeCmapLookup()}
   */
  @Test
  void testGetUnicodeCmapLookup() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getUnicodeCmapLookup());
    assertThrows(IOException.class,
        () -> (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getUnicodeCmapLookup(true));
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getUnicodeCmapLookup(false));
  }

  /**
   * Method under test: {@link TrueTypeFont#getUnicodeCmapLookup(boolean)}
   */
  @Test
  void testGetUnicodeCmapLookup2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    CmapLookup actualUnicodeCmapLookup = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream)))
        .getUnicodeCmapLookup(false);

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualUnicodeCmapLookup);
  }

  /**
   * Method under test: {@link TrueTypeFont#nameToGID(String)}
   */
  @Test
  void testNameToGID() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .nameToGID("Name"));
    assertEquals(OS2WindowsMetricsTable.FAMILY_CLASS_ORNAMENTALS,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .nameToGID("g9"));
    assertEquals(0,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .nameToGID("uni"));
    assertEquals(942,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .nameToGID("g942"));
  }

  /**
   * Method under test: {@link TrueTypeFont#nameToGID(String)}
   */
  @Test
  void testNameToGID2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualNameToGIDResult = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).nameToGID("Name");

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualNameToGIDResult);
  }

  /**
   * Method under test: {@link TrueTypeFont#getGsubData()}
   */
  @Test
  void testGetGsubData() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getGsubData();

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link TrueTypeFont#getWidth(String)}
   */
  @Test
  void testGetWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getWidth("Name"));
    assertEquals(250.0f,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getWidth("g9"));
    assertEquals(250.0f,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getWidth("uni"));
  }

  /**
   * Method under test: {@link TrueTypeFont#getWidth(String)}
   */
  @Test
  void testGetWidth2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    float actualWidth = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getWidth("Name");

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(250.0f, actualWidth);
  }

  /**
   * Method under test: {@link TrueTypeFont#getWidth(String)}
   */
  @Test
  void testGetWidth3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    float actualWidth = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getWidth("g942");

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(250.0f, actualWidth);
  }

  /**
   * Method under test: {@link TrueTypeFont#hasGlyph(String)}
   */
  @Test
  void testHasGlyph() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .hasGlyph("Name"));
    assertTrue(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .hasGlyph("g9"));
    assertFalse(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .hasGlyph("uni"));
    assertTrue(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .hasGlyph("g942"));
  }

  /**
   * Method under test: {@link TrueTypeFont#hasGlyph(String)}
   */
  @Test
  void testHasGlyph2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualHasGlyphResult = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).hasGlyph("Name");

    // Assert
    verify(inputStream).readAllBytes();
    assertFalse(actualHasGlyphResult);
  }

  /**
   * Method under test: {@link TrueTypeFont#getFontMatrix()}
   */
  @Test
  void testGetFontMatrix() throws IOException {
    // Arrange and Act
    List<Number> actualFontMatrix = (new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).getFontMatrix();

    // Assert
    assertEquals(6, actualFontMatrix.size());
    assertEquals(Float.POSITIVE_INFINITY, actualFontMatrix.get(0).floatValue());
    assertEquals(Float.POSITIVE_INFINITY, actualFontMatrix.get(3).floatValue());
  }

  /**
   * Method under test: {@link TrueTypeFont#getFontMatrix()}
   */
  @Test
  void testGetFontMatrix2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<Number> actualFontMatrix = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).getFontMatrix();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(6, actualFontMatrix.size());
    assertEquals(Float.POSITIVE_INFINITY, actualFontMatrix.get(0).floatValue());
    assertEquals(Float.POSITIVE_INFINITY, actualFontMatrix.get(3).floatValue());
  }

  /**
   * Method under test: {@link TrueTypeFont#enableGsubFeature(String)}
   */
  @Test
  void testEnableGsubFeature() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).enableGsubFeature("Feature Tag");

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link TrueTypeFont#disableGsubFeature(String)}
   */
  @Test
  void testDisableGsubFeature() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).disableGsubFeature("Feature Tag");

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link TrueTypeFont#enableVerticalSubstitutions()}
   */
  @Test
  void testEnableVerticalSubstitutions() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).enableVerticalSubstitutions();

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link TrueTypeFont#toString()}
   */
  @Test
  void testToString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("(null)",
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .toString());
  }

  /**
   * Method under test: {@link TrueTypeFont#toString()}
   */
  @Test
  void testToString2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualToStringResult = (new TrueTypeFont(new RandomAccessReadDataStream(inputStream))).toString();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals("(null)", actualToStringResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TrueTypeFont#setEnableGsub(boolean)}
   *   <li>{@link TrueTypeFont#setVersion(float)}
   *   <li>{@link TrueTypeFont#getTableMap()}
   *   <li>{@link TrueTypeFont#getVersion()}
   *   <li>{@link TrueTypeFont#isEnableGsub()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    trueTypeFont.setEnableGsub(true);
    trueTypeFont.setVersion(10.0f);
    Map<String, TTFTable> actualTableMap = trueTypeFont.getTableMap();
    float actualVersion = trueTypeFont.getVersion();
    boolean actualIsEnableGsubResult = trueTypeFont.isEnableGsub();

    // Assert that nothing has changed
    assertEquals(10.0f, actualVersion);
    assertTrue(actualTableMap.isEmpty());
    assertTrue(actualIsEnableGsubResult);
  }

  /**
   * Method under test: {@link TrueTypeFont#TrueTypeFont(TTFDataStream)}
   */
  @Test
  void testNewTrueTypeFont() throws IOException {
    // Arrange and Act
    TrueTypeFont actualTrueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertNull(actualTrueTypeFont.getName());
    assertNull(actualTrueTypeFont.getCmap());
    assertNull(actualTrueTypeFont.getGsub());
    assertNull(actualTrueTypeFont.getGlyph());
    assertNull(actualTrueTypeFont.getHeader());
    assertNull(actualTrueTypeFont.getHorizontalHeader());
    assertNull(actualTrueTypeFont.getHorizontalMetrics());
    assertNull(actualTrueTypeFont.getIndexToLocation());
    assertNull(actualTrueTypeFont.getKerning());
    assertNull(actualTrueTypeFont.getMaximumProfile());
    assertNull(actualTrueTypeFont.getNaming());
    assertNull(actualTrueTypeFont.getOS2Windows());
    assertNull(actualTrueTypeFont.getPostScript());
    assertNull(actualTrueTypeFont.getVerticalHeader());
    assertNull(actualTrueTypeFont.getVerticalMetrics());
    assertNull(actualTrueTypeFont.getVerticalOrigin());
    assertEquals(0, actualTrueTypeFont.getNumberOfGlyphs());
    assertEquals(0, actualTrueTypeFont.getUnitsPerEm());
    assertEquals(0.0f, actualTrueTypeFont.getVersion());
    List<Number> fontMatrix = actualTrueTypeFont.getFontMatrix();
    assertEquals(6, fontMatrix.size());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualTrueTypeFont.getOriginalData().read(byteArray));
    assertEquals(8L, actualTrueTypeFont.getOriginalDataSize());
    assertTrue(actualTrueTypeFont.getTables().isEmpty());
    assertTrue(actualTrueTypeFont.getTableMap().isEmpty());
    assertTrue(actualTrueTypeFont.isEnableGsub());
    assertEquals(Float.POSITIVE_INFINITY, fontMatrix.get(0).floatValue());
    assertEquals(Float.POSITIVE_INFINITY, fontMatrix.get(3).floatValue());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link TrueTypeFont#TrueTypeFont(TTFDataStream)}
   */
  @Test
  void testNewTrueTypeFont2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TrueTypeFont actualTrueTypeFont = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualTrueTypeFont.getName());
    assertNull(actualTrueTypeFont.getCmap());
    assertNull(actualTrueTypeFont.getGsub());
    assertNull(actualTrueTypeFont.getGlyph());
    assertNull(actualTrueTypeFont.getHeader());
    assertNull(actualTrueTypeFont.getHorizontalHeader());
    assertNull(actualTrueTypeFont.getHorizontalMetrics());
    assertNull(actualTrueTypeFont.getIndexToLocation());
    assertNull(actualTrueTypeFont.getKerning());
    assertNull(actualTrueTypeFont.getMaximumProfile());
    assertNull(actualTrueTypeFont.getNaming());
    assertNull(actualTrueTypeFont.getOS2Windows());
    assertNull(actualTrueTypeFont.getPostScript());
    assertNull(actualTrueTypeFont.getVerticalHeader());
    assertNull(actualTrueTypeFont.getVerticalMetrics());
    assertNull(actualTrueTypeFont.getVerticalOrigin());
    assertEquals(0, actualTrueTypeFont.getNumberOfGlyphs());
    assertEquals(0, actualTrueTypeFont.getUnitsPerEm());
    assertEquals(0.0f, actualTrueTypeFont.getVersion());
    List<Number> fontMatrix = actualTrueTypeFont.getFontMatrix();
    assertEquals(6, fontMatrix.size());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualTrueTypeFont.getOriginalData().read(byteArray));
    assertEquals(8L, actualTrueTypeFont.getOriginalDataSize());
    assertTrue(actualTrueTypeFont.getTables().isEmpty());
    assertTrue(actualTrueTypeFont.getTableMap().isEmpty());
    assertTrue(actualTrueTypeFont.isEnableGsub());
    assertEquals(Float.POSITIVE_INFINITY, fontMatrix.get(0).floatValue());
    assertEquals(Float.POSITIVE_INFINITY, fontMatrix.get(3).floatValue());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }
}
