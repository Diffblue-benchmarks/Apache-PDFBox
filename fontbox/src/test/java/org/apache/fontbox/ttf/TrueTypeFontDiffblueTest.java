package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TrueTypeFontDiffblueTest {
  /**
   * Test {@link TrueTypeFont#TrueTypeFont(TTFDataStream)}.
   *
   * <p>Method under test: {@link TrueTypeFont#TrueTypeFont(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new TrueTypeFont(TTFDataStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrueTypeFont.<init>(TTFDataStream)"})
  void testNewTrueTypeFont() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    TrueTypeFont actualTrueTypeFont = new TrueTypeFont(fontData);

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
    assertEquals(6, actualTrueTypeFont.getFontMatrix().size());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualTrueTypeFont.getOriginalData().read(byteArray));
    assertEquals(8L, actualTrueTypeFont.getOriginalDataSize());
    assertTrue(actualTrueTypeFont.getTables().isEmpty());
    assertTrue(actualTrueTypeFont.getTableMap().isEmpty());
    assertTrue(actualTrueTypeFont.isEnableGsub());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TrueTypeFont#addTable(TTFTable)}.
   *
   * <p>Method under test: {@link TrueTypeFont#addTable(TTFTable)}
   */
  @Test
  @DisplayName("Test addTable(TTFTable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrueTypeFont.addTable(TTFTable)"})
  void testAddTable() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
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
   * Test {@link TrueTypeFont#getTables()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getTables()}
   */
  @Test
  @DisplayName("Test getTables()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection TrueTypeFont.getTables()"})
  void testGetTables() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertTrue(new TrueTypeFont(fontData).getTables().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrueTypeFont#setEnableGsub(boolean)}
   *   <li>{@link TrueTypeFont#setVersion(float)}
   *   <li>{@link TrueTypeFont#getTableMap()}
   *   <li>{@link TrueTypeFont#getVersion()}
   *   <li>{@link TrueTypeFont#isEnableGsub()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map TrueTypeFont.getTableMap()",
    "float TrueTypeFont.getVersion()",
    "boolean TrueTypeFont.isEnableGsub()",
    "void TrueTypeFont.setEnableGsub(boolean)",
    "void TrueTypeFont.setVersion(float)"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    // Act
    trueTypeFont.setEnableGsub(true);
    trueTypeFont.setVersion(10.0f);
    Map<String, TTFTable> actualTableMap = trueTypeFont.getTableMap();
    float actualVersion = trueTypeFont.getVersion();
    boolean actualIsEnableGsubResult = trueTypeFont.isEnableGsub();

    // Assert
    assertEquals(10.0f, actualVersion);
    assertTrue(actualTableMap.isEmpty());
    assertTrue(actualIsEnableGsubResult);
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName("Test getTableBytes(TTFTable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    // Act and Assert
    assertArrayEquals(new byte[] {}, trueTypeFont.getTableBytes(new TTFTable()));
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName("Test getTableBytes(TTFTable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes2() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    // Act and Assert
    assertArrayEquals(new byte[] {}, trueTypeFont.getTableBytes(new TTFTable()));
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return array of {@code byte} with {@code A} and three.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName(
      "Test getTableBytes(TTFTable); given 'A'; then return array of byte with 'A' and three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes_givenA_thenReturnArrayOfByteWithAAndThree() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(randomAccessRead);
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    TTFTable table = new TTFTable();
    table.setLength(3L);

    // Act and Assert
    assertArrayEquals(new byte[] {'A', 3, 'A'}, trueTypeFont.getTableBytes(table));
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link TTFTable#TTFTable()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName(
      "Test getTableBytes(TTFTable); given 'A'; when TTFTable(); then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes_givenA_whenTTFTable_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(randomAccessRead);
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    // Act and Assert
    assertArrayEquals(new byte[] {}, trueTypeFont.getTableBytes(new TTFTable()));
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName(
      "Test getTableBytes(TTFTable); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    // Act and Assert
    assertArrayEquals(new byte[] {}, trueTypeFont.getTableBytes(new TTFTable()));
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName(
      "Test getTableBytes(TTFTable); given RandomAccessReadWriteBuffer(int) with definedChunkSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes_givenRandomAccessReadWriteBufferWithDefinedChunkSizeIsZero()
      throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(0));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    // Act and Assert
    assertArrayEquals(new byte[] {}, trueTypeFont.getTableBytes(new TTFTable()));
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   *
   * <ul>
   *   <li>Then return {@code AXA} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName("Test getTableBytes(TTFTable); then return 'AXA' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes_thenReturnAxaBytesIsUtf8() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    TTFTable table = new TTFTable();
    table.setLength(3L);

    // Act and Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), trueTypeFont.getTableBytes(table));
  }

  /**
   * Test {@link TrueTypeFont#getTable(String)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  @DisplayName("Test getTable(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable TrueTypeFont.getTable(String)"})
  void testGetTable() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    TTFTable table = new TTFTable();
    trueTypeFont.addTable(table);

    // Act and Assert
    assertSame(table, trueTypeFont.getTable(null));
  }

  /**
   * Test {@link TrueTypeFont#getTable(String)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  @DisplayName("Test getTable(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable TrueTypeFont.getTable(String)"})
  void testGetTable2() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3));

    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    TTFTable table = new TTFTable();
    trueTypeFont.addTable(table);

    // Act and Assert
    assertSame(table, trueTypeFont.getTable(null));
  }

  /**
   * Test {@link TrueTypeFont#getTable(String)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  @DisplayName("Test getTable(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable TrueTypeFont.getTable(String)"})
  void testGetTable3() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3));

    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    TTFTable table = new TTFTable();
    trueTypeFont.addTable(table);

    // Act and Assert
    assertSame(table, trueTypeFont.getTable(null));
  }

  /**
   * Test {@link TrueTypeFont#getTable(String)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  @DisplayName("Test getTable(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable TrueTypeFont.getTable(String)"})
  void testGetTable4() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    GlyphTable table = new GlyphTable();
    trueTypeFont.addTable(table);

    // Act and Assert
    assertSame(table, trueTypeFont.getTable(null));
  }

  /**
   * Test {@link TrueTypeFont#getTable(String)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  @DisplayName("Test getTable(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable TrueTypeFont.getTable(String)"})
  void testGetTable5() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(randomAccessRead);

    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    TTFTable table = new TTFTable();
    trueTypeFont.addTable(table);

    // Act and Assert
    assertSame(table, trueTypeFont.getTable(null));
  }

  /**
   * Test {@link TrueTypeFont#getTable(String)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  @DisplayName("Test getTable(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable TrueTypeFont.getTable(String)"})
  void testGetTable6() throws IOException {
    // Arrange
    GlyphTable table = new GlyphTable();
    table.setLength(3L);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(randomAccessRead);

    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    trueTypeFont.addTable(table);

    // Act and Assert
    assertSame(table, trueTypeFont.getTable(null));
  }

  /**
   * Test {@link TrueTypeFont#getTable(String)}.
   *
   * <ul>
   *   <li>Given {@link GlyphTable#GlyphTable()} Length is three.
   *   <li>When {@code null}.
   *   <li>Then return {@link GlyphTable#GlyphTable()}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  @DisplayName(
      "Test getTable(String); given GlyphTable() Length is three; when 'null'; then return GlyphTable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable TrueTypeFont.getTable(String)"})
  void testGetTable_givenGlyphTableLengthIsThree_whenNull_thenReturnGlyphTable()
      throws IOException {
    // Arrange
    GlyphTable table = new GlyphTable();
    table.setLength(3L);
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    trueTypeFont.addTable(table);

    // Act and Assert
    assertSame(table, trueTypeFont.getTable(null));
  }

  /**
   * Test {@link TrueTypeFont#getTable(String)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  @DisplayName(
      "Test getTable(String); given RandomAccessReadWriteBuffer(int) with definedChunkSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable TrueTypeFont.getTable(String)"})
  void testGetTable_givenRandomAccessReadWriteBufferWithDefinedChunkSizeIsZero()
      throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(0));

    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    TTFTable table = new TTFTable();
    trueTypeFont.addTable(table);

    // Act and Assert
    assertSame(table, trueTypeFont.getTable(null));
  }

  /**
   * Test {@link TrueTypeFont#getTable(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  @DisplayName("Test getTable(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable TrueTypeFont.getTable(String)"})
  void testGetTable_thenReturnNull() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getTable("Tag"));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName("Test getTableNBytes(TTFTable, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    // Act and Assert
    assertArrayEquals(new byte[] {}, trueTypeFont.getTableNBytes(new TTFTable(), 1));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName("Test getTableNBytes(TTFTable, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes2() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    // Act and Assert
    assertArrayEquals(new byte[] {}, trueTypeFont.getTableNBytes(new TTFTable(), 1));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link TTFTable#TTFTable()} Length is three.
   *   <li>Then return array of {@code byte} with {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName(
      "Test getTableNBytes(TTFTable, int); given 'A'; when TTFTable() Length is three; then return array of byte with 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes_givenA_whenTTFTableLengthIsThree_thenReturnArrayOfByteWithA()
      throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(randomAccessRead);
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    TTFTable table = new TTFTable();
    table.setLength(3L);

    // Act and Assert
    assertArrayEquals(new byte[] {'A'}, trueTypeFont.getTableNBytes(table, 1));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link TTFTable#TTFTable()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName(
      "Test getTableNBytes(TTFTable, int); given 'A'; when TTFTable(); then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes_givenA_whenTTFTable_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(randomAccessRead);
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    // Act and Assert
    assertArrayEquals(new byte[] {}, trueTypeFont.getTableNBytes(new TTFTable(), 1));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName(
      "Test getTableNBytes(TTFTable, int); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    // Act and Assert
    assertArrayEquals(new byte[] {}, trueTypeFont.getTableNBytes(new TTFTable(), 1));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName(
      "Test getTableNBytes(TTFTable, int); given RandomAccessReadWriteBuffer(int) with definedChunkSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes_givenRandomAccessReadWriteBufferWithDefinedChunkSizeIsZero()
      throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(0));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    // Act and Assert
    assertArrayEquals(new byte[] {}, trueTypeFont.getTableNBytes(new TTFTable(), 1));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName("Test getTableNBytes(TTFTable, int); then return array of byte with 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes_thenReturnArrayOfByteWithA() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    TTFTable table = new TTFTable();
    table.setLength(3L);

    // Act and Assert
    assertArrayEquals(new byte[] {'A'}, trueTypeFont.getTableNBytes(table, 1));
  }

  /**
   * Test {@link TrueTypeFont#getNaming()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getNaming()}
   */
  @Test
  @DisplayName("Test getNaming()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.ttf.NamingTable TrueTypeFont.getNaming()"})
  void testGetNaming() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getNaming());
  }

  /**
   * Test {@link TrueTypeFont#getPostScript()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getPostScript()}
   */
  @Test
  @DisplayName("Test getPostScript()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.ttf.PostScriptTable TrueTypeFont.getPostScript()"})
  void testGetPostScript() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getPostScript());
  }

  /**
   * Test {@link TrueTypeFont#getOS2Windows()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getOS2Windows()}
   */
  @Test
  @DisplayName("Test getOS2Windows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OS2WindowsMetricsTable TrueTypeFont.getOS2Windows()"})
  void testGetOS2Windows() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getOS2Windows());
  }

  /**
   * Test {@link TrueTypeFont#getMaximumProfile()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getMaximumProfile()}
   */
  @Test
  @DisplayName("Test getMaximumProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.ttf.MaximumProfileTable TrueTypeFont.getMaximumProfile()"})
  void testGetMaximumProfile() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getMaximumProfile());
  }

  /**
   * Test {@link TrueTypeFont#getHeader()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getHeader()}
   */
  @Test
  @DisplayName("Test getHeader()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.ttf.HeaderTable TrueTypeFont.getHeader()"})
  void testGetHeader() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getHeader());
  }

  /**
   * Test {@link TrueTypeFont#getHorizontalHeader()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getHorizontalHeader()}
   */
  @Test
  @DisplayName("Test getHorizontalHeader()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.fontbox.ttf.HorizontalHeaderTable TrueTypeFont.getHorizontalHeader()"
  })
  void testGetHorizontalHeader() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getHorizontalHeader());
  }

  /**
   * Test {@link TrueTypeFont#getHorizontalMetrics()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getHorizontalMetrics()}
   */
  @Test
  @DisplayName("Test getHorizontalMetrics()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.fontbox.ttf.HorizontalMetricsTable TrueTypeFont.getHorizontalMetrics()"
  })
  void testGetHorizontalMetrics() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getHorizontalMetrics());
  }

  /**
   * Test {@link TrueTypeFont#getIndexToLocation()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getIndexToLocation()}
   */
  @Test
  @DisplayName("Test getIndexToLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.fontbox.ttf.IndexToLocationTable TrueTypeFont.getIndexToLocation()"
  })
  void testGetIndexToLocation() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getIndexToLocation());
  }

  /**
   * Test {@link TrueTypeFont#getGlyph()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getGlyph()}
   */
  @Test
  @DisplayName("Test getGlyph()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GlyphTable TrueTypeFont.getGlyph()"})
  void testGetGlyph() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getGlyph());
  }

  /**
   * Test {@link TrueTypeFont#getCmap()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getCmap()}
   */
  @Test
  @DisplayName("Test getCmap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.ttf.CmapTable TrueTypeFont.getCmap()"})
  void testGetCmap() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getCmap());
  }

  /**
   * Test {@link TrueTypeFont#getVerticalHeader()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getVerticalHeader()}
   */
  @Test
  @DisplayName("Test getVerticalHeader()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.ttf.VerticalHeaderTable TrueTypeFont.getVerticalHeader()"})
  void testGetVerticalHeader() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getVerticalHeader());
  }

  /**
   * Test {@link TrueTypeFont#getVerticalMetrics()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getVerticalMetrics()}
   */
  @Test
  @DisplayName("Test getVerticalMetrics()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.fontbox.ttf.VerticalMetricsTable TrueTypeFont.getVerticalMetrics()"
  })
  void testGetVerticalMetrics() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getVerticalMetrics());
  }

  /**
   * Test {@link TrueTypeFont#getVerticalOrigin()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getVerticalOrigin()}
   */
  @Test
  @DisplayName("Test getVerticalOrigin()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.ttf.VerticalOriginTable TrueTypeFont.getVerticalOrigin()"})
  void testGetVerticalOrigin() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getVerticalOrigin());
  }

  /**
   * Test {@link TrueTypeFont#getKerning()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getKerning()}
   */
  @Test
  @DisplayName("Test getKerning()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.ttf.KerningTable TrueTypeFont.getKerning()"})
  void testGetKerning() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getKerning());
  }

  /**
   * Test {@link TrueTypeFont#getGsub()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getGsub()}
   */
  @Test
  @DisplayName("Test getGsub()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.ttf.GlyphSubstitutionTable TrueTypeFont.getGsub()"})
  void testGetGsub() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getGsub());
  }

  /**
   * Test {@link TrueTypeFont#getOriginalData()}.
   *
   * <ul>
   *   <li>Then return read is eight.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getOriginalData()}
   */
  @Test
  @DisplayName("Test getOriginalData(); then return read is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream TrueTypeFont.getOriginalData()"})
  void testGetOriginalData_thenReturnReadIsEight() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, new TrueTypeFont(fontData).getOriginalData().read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TrueTypeFont#getOriginalData()}.
   *
   * <ul>
   *   <li>Then return read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getOriginalData()}
   */
  @Test
  @DisplayName("Test getOriginalData(); then return read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream TrueTypeFont.getOriginalData()"})
  void testGetOriginalData_thenReturnReadIsMinusOne() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3));

    // Act and Assert
    int actualReadResult = new TrueTypeFont(fontData).getOriginalData().read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link TrueTypeFont#getOriginalDataSize()}.
   *
   * <ul>
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getOriginalDataSize()}
   */
  @Test
  @DisplayName("Test getOriginalDataSize(); then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TrueTypeFont.getOriginalDataSize()"})
  void testGetOriginalDataSize_thenReturnEight() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(8L, new TrueTypeFont(fontData).getOriginalDataSize());
  }

  /**
   * Test {@link TrueTypeFont#getOriginalDataSize()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getOriginalDataSize()}
   */
  @Test
  @DisplayName("Test getOriginalDataSize(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TrueTypeFont.getOriginalDataSize()"})
  void testGetOriginalDataSize_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3));

    // Act and Assert
    assertEquals(0L, new TrueTypeFont(fontData).getOriginalDataSize());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   *
   * <p>Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName("Test readTable(TTFTable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    TTFTable table = new TTFTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert that nothing has changed
    assertFalse(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link TTFTable#TTFTable()}.
   *   <li>Then not {@link TTFTable#TTFTable()} Initialized.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName(
      "Test readTable(TTFTable); given 'A'; when TTFTable(); then not TTFTable() Initialized")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable_givenA_whenTTFTable_thenNotTTFTableInitialized() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(randomAccessRead);
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    TTFTable table = new TTFTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert that nothing has changed
    assertFalse(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName(
      "Test readTable(TTFTable); given RandomAccessReadWriteBuffer(int) with definedChunkSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable_givenRandomAccessReadWriteBufferWithDefinedChunkSizeIsZero()
      throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(0));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    TTFTable table = new TTFTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert that nothing has changed
    assertFalse(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link GlyphTable#GlyphTable()} Length is three.
   *   <li>Then {@link GlyphTable#GlyphTable()} Initialized.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName(
      "Test readTable(TTFTable); given three; when GlyphTable() Length is three; then GlyphTable() Initialized")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable_givenThree_whenGlyphTableLengthIsThree_thenGlyphTableInitialized()
      throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);

    GlyphTable table = new GlyphTable();
    table.setLength(3L);

    // Act
    trueTypeFont.readTable(table);

    // Assert
    assertTrue(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   *
   * <ul>
   *   <li>Then not {@link TTFTable#TTFTable()} Initialized.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName("Test readTable(TTFTable); then not TTFTable() Initialized")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable_thenNotTTFTableInitialized() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream fontData =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    TTFTable table = new TTFTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert that nothing has changed
    assertFalse(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   *
   * <ul>
   *   <li>When {@link GlyphTable#GlyphTable()}.
   *   <li>Then {@link GlyphTable#GlyphTable()} Initialized.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName("Test readTable(TTFTable); when GlyphTable(); then GlyphTable() Initialized")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable_whenGlyphTable_thenGlyphTableInitialized() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    GlyphTable table = new GlyphTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert
    assertTrue(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   *
   * <ul>
   *   <li>When {@link TTFTable#TTFTable()}.
   *   <li>Then not {@link TTFTable#TTFTable()} Initialized.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName("Test readTable(TTFTable); when TTFTable(); then not TTFTable() Initialized")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable_whenTTFTable_thenNotTTFTableInitialized() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    TTFTable table = new TTFTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert that nothing has changed
    assertFalse(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#readTableHeaders(String, FontHeaders)}.
   *
   * <p>Method under test: {@link TrueTypeFont#readTableHeaders(String, FontHeaders)}
   */
  @Test
  @DisplayName("Test readTableHeaders(String, FontHeaders)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrueTypeFont.readTableHeaders(String, FontHeaders)"})
  void testReadTableHeaders() throws IOException {
    // Arrange
    CFFTable table = mock(CFFTable.class);
    when(table.getTag()).thenReturn("Tag");
    when(table.getOffset()).thenReturn(1L);
    doNothing()
        .when(table)
        .readHeaders(
            Mockito.<TrueTypeFont>any(), Mockito.<TTFDataStream>any(), Mockito.<FontHeaders>any());
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    trueTypeFont.addTable(table);

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");
    outHeaders.setHeaderMacStyle(1);
    outHeaders.setIsOTFAndPostScript(true);
    outHeaders.setName("Name");
    outHeaders.setNonOtfGcid142("AXAXAXAX".getBytes("UTF-8"));
    outHeaders.setOs2Windows(new OS2WindowsMetricsTable());

    // Act
    trueTypeFont.readTableHeaders("Tag", outHeaders);

    // Assert
    verify(table)
        .readHeaders(isA(TrueTypeFont.class), isA(TTFDataStream.class), isA(FontHeaders.class));
    verify(table).getOffset();
    verify(table).getTag();
  }

  /**
   * Test {@link TrueTypeFont#readTableHeaders(String, FontHeaders)}.
   *
   * <ul>
   *   <li>Then calls {@link TTFDataStream#getCurrentPosition()}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#readTableHeaders(String, FontHeaders)}
   */
  @Test
  @DisplayName("Test readTableHeaders(String, FontHeaders); then calls getCurrentPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrueTypeFont.readTableHeaders(String, FontHeaders)"})
  void testReadTableHeaders_thenCallsGetCurrentPosition() throws IOException {
    // Arrange
    TTFDataStream fontData = mock(TTFDataStream.class);
    when(fontData.getCurrentPosition()).thenReturn(1L);
    doNothing().when(fontData).seek(anyLong());

    CFFTable table = mock(CFFTable.class);
    when(table.getTag()).thenReturn("Tag");
    when(table.getOffset()).thenReturn(1L);
    doNothing()
        .when(table)
        .readHeaders(
            Mockito.<TrueTypeFont>any(), Mockito.<TTFDataStream>any(), Mockito.<FontHeaders>any());

    TrueTypeFont trueTypeFont = new TrueTypeFont(fontData);
    trueTypeFont.addTable(table);

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");
    outHeaders.setHeaderMacStyle(1);
    outHeaders.setIsOTFAndPostScript(true);
    outHeaders.setName("Name");
    outHeaders.setNonOtfGcid142("AXAXAXAX".getBytes("UTF-8"));
    outHeaders.setOs2Windows(new OS2WindowsMetricsTable());

    // Act
    trueTypeFont.readTableHeaders("Tag", outHeaders);

    // Assert
    verify(table)
        .readHeaders(isA(TrueTypeFont.class), isA(TTFDataStream.class), isA(FontHeaders.class));
    verify(fontData).getCurrentPosition();
    verify(fontData, atLeast(1)).seek(1L);
    verify(table).getOffset();
    verify(table).getTag();
  }

  /**
   * Test {@link TrueTypeFont#getNumberOfGlyphs()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getNumberOfGlyphs()}
   */
  @Test
  @DisplayName("Test getNumberOfGlyphs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TrueTypeFont.getNumberOfGlyphs()"})
  void testGetNumberOfGlyphs() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, new TrueTypeFont(fontData).getNumberOfGlyphs());
  }

  /**
   * Test {@link TrueTypeFont#getUnitsPerEm()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getUnitsPerEm()}
   */
  @Test
  @DisplayName("Test getUnitsPerEm()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TrueTypeFont.getUnitsPerEm()"})
  void testGetUnitsPerEm() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, new TrueTypeFont(fontData).getUnitsPerEm());
  }

  /**
   * Test {@link TrueTypeFont#getAdvanceWidth(int)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getAdvanceWidth(int)}
   */
  @Test
  @DisplayName("Test getAdvanceWidth(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TrueTypeFont.getAdvanceWidth(int)"})
  void testGetAdvanceWidth() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(250, new TrueTypeFont(fontData).getAdvanceWidth(1));
  }

  /**
   * Test {@link TrueTypeFont#getAdvanceHeight(int)}.
   *
   * <p>Method under test: {@link TrueTypeFont#getAdvanceHeight(int)}
   */
  @Test
  @DisplayName("Test getAdvanceHeight(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TrueTypeFont.getAdvanceHeight(int)"})
  void testGetAdvanceHeight() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(250, new TrueTypeFont(fontData).getAdvanceHeight(1));
  }

  /**
   * Test {@link TrueTypeFont#getName()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrueTypeFont.getName()"})
  void testGetName() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getName());
  }

  /**
   * Test {@link TrueTypeFont#getUnicodeCmapLookup()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getUnicodeCmapLookup()}
   */
  @Test
  @DisplayName("Test getUnicodeCmapLookup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.ttf.CmapLookup TrueTypeFont.getUnicodeCmapLookup()"})
  void testGetUnicodeCmapLookup() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertThrows(IOException.class, () -> new TrueTypeFont(fontData).getUnicodeCmapLookup());
  }

  /**
   * Test {@link TrueTypeFont#getUnicodeCmapLookup(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getUnicodeCmapLookup(boolean)}
   */
  @Test
  @DisplayName(
      "Test getUnicodeCmapLookup(boolean) with 'boolean'; when 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.fontbox.ttf.CmapLookup TrueTypeFont.getUnicodeCmapLookup(boolean)"
  })
  void testGetUnicodeCmapLookupWithBoolean_whenFalse_thenReturnNull() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNull(new TrueTypeFont(fontData).getUnicodeCmapLookup(false));
  }

  /**
   * Test {@link TrueTypeFont#getUnicodeCmapLookup(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getUnicodeCmapLookup(boolean)}
   */
  @Test
  @DisplayName(
      "Test getUnicodeCmapLookup(boolean) with 'boolean'; when 'true'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.fontbox.ttf.CmapLookup TrueTypeFont.getUnicodeCmapLookup(boolean)"
  })
  void testGetUnicodeCmapLookupWithBoolean_whenTrue_thenThrowIOException() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertThrows(IOException.class, () -> new TrueTypeFont(fontData).getUnicodeCmapLookup(true));
  }

  /**
   * Test {@link TrueTypeFont#nameToGID(String)}.
   *
   * <ul>
   *   <li>When {@code g9}.
   *   <li>Then return {@link OS2WindowsMetricsTable#FAMILY_CLASS_ORNAMENTALS}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#nameToGID(String)}
   */
  @Test
  @DisplayName("Test nameToGID(String); when 'g9'; then return FAMILY_CLASS_ORNAMENTALS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TrueTypeFont.nameToGID(String)"})
  void testNameToGID_whenG9_thenReturnFamily_class_ornamentals() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(
        OS2WindowsMetricsTable.FAMILY_CLASS_ORNAMENTALS,
        new TrueTypeFont(fontData).nameToGID("g9"));
  }

  /**
   * Test {@link TrueTypeFont#nameToGID(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#nameToGID(String)}
   */
  @Test
  @DisplayName("Test nameToGID(String); when 'Name'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TrueTypeFont.nameToGID(String)"})
  void testNameToGID_whenName_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, new TrueTypeFont(fontData).nameToGID("Name"));
  }

  /**
   * Test {@link TrueTypeFont#nameToGID(String)}.
   *
   * <ul>
   *   <li>When {@code uni}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#nameToGID(String)}
   */
  @Test
  @DisplayName("Test nameToGID(String); when 'uni'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TrueTypeFont.nameToGID(String)"})
  void testNameToGID_whenUni_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, new TrueTypeFont(fontData).nameToGID("uni"));
  }

  /**
   * Test {@link TrueTypeFont#getWidth(String)}.
   *
   * <ul>
   *   <li>When {@code g9}.
   *   <li>Then return two hundred fifty.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getWidth(String)}
   */
  @Test
  @DisplayName("Test getWidth(String); when 'g9'; then return two hundred fifty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TrueTypeFont.getWidth(String)"})
  void testGetWidth_whenG9_thenReturnTwoHundredFifty() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(250.0f, new TrueTypeFont(fontData).getWidth("g9"));
  }

  /**
   * Test {@link TrueTypeFont#getWidth(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return two hundred fifty.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getWidth(String)}
   */
  @Test
  @DisplayName("Test getWidth(String); when 'Name'; then return two hundred fifty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TrueTypeFont.getWidth(String)"})
  void testGetWidth_whenName_thenReturnTwoHundredFifty() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(250.0f, new TrueTypeFont(fontData).getWidth("Name"));
  }

  /**
   * Test {@link TrueTypeFont#getWidth(String)}.
   *
   * <ul>
   *   <li>When {@code uni}.
   *   <li>Then return two hundred fifty.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#getWidth(String)}
   */
  @Test
  @DisplayName("Test getWidth(String); when 'uni'; then return two hundred fifty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TrueTypeFont.getWidth(String)"})
  void testGetWidth_whenUni_thenReturnTwoHundredFifty() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(250.0f, new TrueTypeFont(fontData).getWidth("uni"));
  }

  /**
   * Test {@link TrueTypeFont#hasGlyph(String)}.
   *
   * <ul>
   *   <li>When {@code g9}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); when 'g9'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrueTypeFont.hasGlyph(String)"})
  void testHasGlyph_whenG9_thenReturnTrue() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertTrue(new TrueTypeFont(fontData).hasGlyph("g9"));
  }

  /**
   * Test {@link TrueTypeFont#hasGlyph(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); when 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrueTypeFont.hasGlyph(String)"})
  void testHasGlyph_whenName_thenReturnFalse() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertFalse(new TrueTypeFont(fontData).hasGlyph("Name"));
  }

  /**
   * Test {@link TrueTypeFont#hasGlyph(String)}.
   *
   * <ul>
   *   <li>When {@code uni}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); when 'uni'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrueTypeFont.hasGlyph(String)"})
  void testHasGlyph_whenUni_thenReturnFalse() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertFalse(new TrueTypeFont(fontData).hasGlyph("uni"));
  }

  /**
   * Test {@link TrueTypeFont#getFontMatrix()}.
   *
   * <p>Method under test: {@link TrueTypeFont#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TrueTypeFont.getFontMatrix()"})
  void testGetFontMatrix() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    List<Number> actualFontMatrix = new TrueTypeFont(fontData).getFontMatrix();

    // Assert
    assertEquals(6, actualFontMatrix.size());
    assertEquals(0, actualFontMatrix.get(1).intValue());
    assertEquals(0, actualFontMatrix.get(2).intValue());
    assertEquals(0, actualFontMatrix.get(4).intValue());
    assertEquals(0, actualFontMatrix.get(5).intValue());
    assertEquals(Float.POSITIVE_INFINITY, actualFontMatrix.get(0).floatValue());
    assertEquals(Float.POSITIVE_INFINITY, actualFontMatrix.get(3).floatValue());
  }

  /**
   * Test {@link TrueTypeFont#toString()}.
   *
   * <p>Method under test: {@link TrueTypeFont#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrueTypeFont.toString()"})
  void testToString() throws IOException {
    // Arrange
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals("(null)", new TrueTypeFont(fontData).toString());
  }
}
