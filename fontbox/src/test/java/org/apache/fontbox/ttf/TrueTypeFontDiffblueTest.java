package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TrueTypeFontDiffblueTest {
  /**
   * Test {@link TrueTypeFont#TrueTypeFont(TTFDataStream)}.
   * <p>
   * Method under test: {@link TrueTypeFont#TrueTypeFont(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new TrueTypeFont(TTFDataStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrueTypeFont.<init>(TTFDataStream)"})
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
   * <p>
   * Method under test: {@link TrueTypeFont#addTable(TTFTable)}
   */
  @Test
  @DisplayName("Test addTable(TTFTable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrueTypeFont.addTable(TTFTable)"})
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
   * Test {@link TrueTypeFont#getTables()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getTables()}
   */
  @Test
  @DisplayName("Test getTables()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Collection TrueTypeFont.getTables()"})
  void testGetTables() throws IOException {
    // Arrange, Act and Assert
    assertTrue(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getTables()
            .isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TrueTypeFont.getTableMap()", "float TrueTypeFont.getVersion()",
      "boolean TrueTypeFont.isEnableGsub()", "void TrueTypeFont.setEnableGsub(boolean)",
      "void TrueTypeFont.setVersion(float)"})
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

    // Assert
    assertEquals(10.0f, actualVersion);
    assertTrue(actualTableMap.isEmpty());
    assertTrue(actualIsEnableGsubResult);
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   * <p>
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName("Test getTableBytes(TTFTable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")))));

    // Act and Assert
    assertArrayEquals(new byte[]{}, trueTypeFont.getTableBytes(new TTFTable()));
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   * <ul>
   *   <li>Then return A backspace A Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName("Test getTableBytes(TTFTable); then return A backspace A Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes_thenReturnABackspaceABytesIsUtf8() throws IOException {
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
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   * <ul>
   *   <li>Then return {@code AXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName("Test getTableBytes(TTFTable); then return 'AXA' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes_thenReturnAxaBytesIsUtf8() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    TTFTable table = new TTFTable();
    table.setLength(3L);

    // Act
    byte[] actualTableBytes = trueTypeFont.getTableBytes(table);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), actualTableBytes);
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName("Test getTableBytes(TTFTable); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertArrayEquals(new byte[]{}, trueTypeFont.getTableBytes(new TTFTable()));
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName("Test getTableBytes(TTFTable); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes_thenReturnEmptyArrayOfByte2() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{})));

    // Act and Assert
    assertArrayEquals(new byte[]{}, trueTypeFont.getTableBytes(new TTFTable()));
  }

  /**
   * Test {@link TrueTypeFont#getTableBytes(TTFTable)}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getTableBytes(TTFTable)}
   */
  @Test
  @DisplayName("Test getTableBytes(TTFTable); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableBytes(TTFTable)"})
  void testGetTableBytes_thenReturnEmptyArrayOfByte3() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))));

    // Act and Assert
    assertArrayEquals(new byte[]{}, trueTypeFont.getTableBytes(new TTFTable()));
  }

  /**
   * Test {@link TrueTypeFont#getTable(String)}.
   * <p>
   * Method under test: {@link TrueTypeFont#getTable(String)}
   */
  @Test
  @DisplayName("Test getTable(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TTFTable TrueTypeFont.getTable(String)"})
  void testGetTable() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getTable("Tag"));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   * <p>
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName("Test getTableNBytes(TTFTable, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")))));

    // Act and Assert
    assertArrayEquals(new byte[]{}, trueTypeFont.getTableNBytes(new TTFTable(), 1));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName("Test getTableNBytes(TTFTable, int); then return array of byte with 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes_thenReturnArrayOfByteWithA() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    TTFTable table = new TTFTable();
    table.setLength(3L);

    // Act and Assert
    assertArrayEquals(new byte[]{'A'}, trueTypeFont.getTableNBytes(table, 1));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName("Test getTableNBytes(TTFTable, int); then return array of byte with 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes_thenReturnArrayOfByteWithA2() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")))));

    TTFTable table = new TTFTable();
    table.setLength(3L);

    // Act and Assert
    assertArrayEquals(new byte[]{'A'}, trueTypeFont.getTableNBytes(table, 1));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName("Test getTableNBytes(TTFTable, int); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertArrayEquals(new byte[]{}, trueTypeFont.getTableNBytes(new TTFTable(), 1));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName("Test getTableNBytes(TTFTable, int); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes_thenReturnEmptyArrayOfByte2() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{})));

    // Act and Assert
    assertArrayEquals(new byte[]{}, trueTypeFont.getTableNBytes(new TTFTable(), 1));
  }

  /**
   * Test {@link TrueTypeFont#getTableNBytes(TTFTable, int)}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getTableNBytes(TTFTable, int)}
   */
  @Test
  @DisplayName("Test getTableNBytes(TTFTable, int); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TrueTypeFont.getTableNBytes(TTFTable, int)"})
  void testGetTableNBytes_thenReturnEmptyArrayOfByte3() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))));

    // Act and Assert
    assertArrayEquals(new byte[]{}, trueTypeFont.getTableNBytes(new TTFTable(), 1));
  }

  /**
   * Test {@link TrueTypeFont#getNaming()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getNaming()}
   */
  @Test
  @DisplayName("Test getNaming()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.NamingTable TrueTypeFont.getNaming()"})
  void testGetNaming() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getNaming());
  }

  /**
   * Test {@link TrueTypeFont#getPostScript()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getPostScript()}
   */
  @Test
  @DisplayName("Test getPostScript()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.PostScriptTable TrueTypeFont.getPostScript()"})
  void testGetPostScript() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getPostScript());
  }

  /**
   * Test {@link TrueTypeFont#getOS2Windows()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getOS2Windows()}
   */
  @Test
  @DisplayName("Test getOS2Windows()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OS2WindowsMetricsTable TrueTypeFont.getOS2Windows()"})
  void testGetOS2Windows() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getOS2Windows());
  }

  /**
   * Test {@link TrueTypeFont#getMaximumProfile()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getMaximumProfile()}
   */
  @Test
  @DisplayName("Test getMaximumProfile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.MaximumProfileTable TrueTypeFont.getMaximumProfile()"})
  void testGetMaximumProfile() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getMaximumProfile());
  }

  /**
   * Test {@link TrueTypeFont#getHeader()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getHeader()}
   */
  @Test
  @DisplayName("Test getHeader()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.HeaderTable TrueTypeFont.getHeader()"})
  void testGetHeader() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getHeader());
  }

  /**
   * Test {@link TrueTypeFont#getHorizontalHeader()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getHorizontalHeader()}
   */
  @Test
  @DisplayName("Test getHorizontalHeader()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.HorizontalHeaderTable TrueTypeFont.getHorizontalHeader()"})
  void testGetHorizontalHeader() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getHorizontalHeader());
  }

  /**
   * Test {@link TrueTypeFont#getHorizontalMetrics()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getHorizontalMetrics()}
   */
  @Test
  @DisplayName("Test getHorizontalMetrics()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.HorizontalMetricsTable TrueTypeFont.getHorizontalMetrics()"})
  void testGetHorizontalMetrics() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getHorizontalMetrics());
  }

  /**
   * Test {@link TrueTypeFont#getIndexToLocation()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getIndexToLocation()}
   */
  @Test
  @DisplayName("Test getIndexToLocation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.IndexToLocationTable TrueTypeFont.getIndexToLocation()"})
  void testGetIndexToLocation() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getIndexToLocation());
  }

  /**
   * Test {@link TrueTypeFont#getGlyph()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getGlyph()}
   */
  @Test
  @DisplayName("Test getGlyph()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GlyphTable TrueTypeFont.getGlyph()"})
  void testGetGlyph() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getGlyph());
  }

  /**
   * Test {@link TrueTypeFont#getCmap()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getCmap()}
   */
  @Test
  @DisplayName("Test getCmap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.CmapTable TrueTypeFont.getCmap()"})
  void testGetCmap() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getCmap());
  }

  /**
   * Test {@link TrueTypeFont#getVerticalHeader()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getVerticalHeader()}
   */
  @Test
  @DisplayName("Test getVerticalHeader()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.VerticalHeaderTable TrueTypeFont.getVerticalHeader()"})
  void testGetVerticalHeader() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getVerticalHeader());
  }

  /**
   * Test {@link TrueTypeFont#getVerticalMetrics()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getVerticalMetrics()}
   */
  @Test
  @DisplayName("Test getVerticalMetrics()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.VerticalMetricsTable TrueTypeFont.getVerticalMetrics()"})
  void testGetVerticalMetrics() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getVerticalMetrics());
  }

  /**
   * Test {@link TrueTypeFont#getVerticalOrigin()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getVerticalOrigin()}
   */
  @Test
  @DisplayName("Test getVerticalOrigin()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.VerticalOriginTable TrueTypeFont.getVerticalOrigin()"})
  void testGetVerticalOrigin() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getVerticalOrigin());
  }

  /**
   * Test {@link TrueTypeFont#getKerning()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getKerning()}
   */
  @Test
  @DisplayName("Test getKerning()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.KerningTable TrueTypeFont.getKerning()"})
  void testGetKerning() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getKerning());
  }

  /**
   * Test {@link TrueTypeFont#getGsub()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getGsub()}
   */
  @Test
  @DisplayName("Test getGsub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.GlyphSubstitutionTable TrueTypeFont.getGsub()"})
  void testGetGsub() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getGsub());
  }

  /**
   * Test {@link TrueTypeFont#getOriginalData()}.
   * <ul>
   *   <li>Then return read is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getOriginalData()}
   */
  @Test
  @DisplayName("Test getOriginalData(); then return read is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream TrueTypeFont.getOriginalData()"})
  void testGetOriginalData_thenReturnReadIsEight() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getOriginalData()
            .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TrueTypeFont#getOriginalDataSize()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getOriginalDataSize()}
   */
  @Test
  @DisplayName("Test getOriginalDataSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TrueTypeFont.getOriginalDataSize()"})
  void testGetOriginalDataSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8L,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getOriginalDataSize());
  }

  /**
   * Test {@link TrueTypeFont#getOriginalDataSize()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getOriginalDataSize()}
   */
  @Test
  @DisplayName("Test getOriginalDataSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TrueTypeFont.getOriginalDataSize()"})
  void testGetOriginalDataSize2() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8L,
        (new TrueTypeFont(new RandomAccessReadUnbufferedDataStream(
            new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
                .getOriginalDataSize());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   * <p>
   * Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName("Test readTable(TTFTable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")))));
    TTFTable table = new TTFTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert that nothing has changed
    assertFalse(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName("Test readTable(TTFTable); given ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable_givenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{})));
    TTFTable table = new TTFTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert that nothing has changed
    assertFalse(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName("Test readTable(TTFTable); given ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable_givenByteArrayInputStreamWithEmptyArrayOfByte2() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))));
    TTFTable table = new TTFTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert that nothing has changed
    assertFalse(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   * <ul>
   *   <li>When {@link GlyphTable#GlyphTable()}.</li>
   *   <li>Then {@link GlyphTable#GlyphTable()} Initialized.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName("Test readTable(TTFTable); when GlyphTable(); then GlyphTable() Initialized")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable_whenGlyphTable_thenGlyphTableInitialized() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    GlyphTable table = new GlyphTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert
    assertTrue(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#readTable(TTFTable)}.
   * <ul>
   *   <li>When {@link TTFTable#TTFTable()}.</li>
   *   <li>Then not {@link TTFTable#TTFTable()} Initialized.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#readTable(TTFTable)}
   */
  @Test
  @DisplayName("Test readTable(TTFTable); when TTFTable(); then not TTFTable() Initialized")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrueTypeFont.readTable(TTFTable)"})
  void testReadTable_whenTTFTable_thenNotTTFTableInitialized() throws IOException {
    // Arrange
    TrueTypeFont trueTypeFont = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    TTFTable table = new TTFTable();

    // Act
    trueTypeFont.readTable(table);

    // Assert that nothing has changed
    assertFalse(table.getInitialized());
  }

  /**
   * Test {@link TrueTypeFont#getNumberOfGlyphs()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getNumberOfGlyphs()}
   */
  @Test
  @DisplayName("Test getNumberOfGlyphs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TrueTypeFont.getNumberOfGlyphs()"})
  void testGetNumberOfGlyphs() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getNumberOfGlyphs());
  }

  /**
   * Test {@link TrueTypeFont#getUnitsPerEm()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getUnitsPerEm()}
   */
  @Test
  @DisplayName("Test getUnitsPerEm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TrueTypeFont.getUnitsPerEm()"})
  void testGetUnitsPerEm() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getUnitsPerEm());
  }

  /**
   * Test {@link TrueTypeFont#getAdvanceWidth(int)}.
   * <p>
   * Method under test: {@link TrueTypeFont#getAdvanceWidth(int)}
   */
  @Test
  @DisplayName("Test getAdvanceWidth(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TrueTypeFont.getAdvanceWidth(int)"})
  void testGetAdvanceWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getAdvanceWidth(1));
  }

  /**
   * Test {@link TrueTypeFont#getAdvanceHeight(int)}.
   * <p>
   * Method under test: {@link TrueTypeFont#getAdvanceHeight(int)}
   */
  @Test
  @DisplayName("Test getAdvanceHeight(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TrueTypeFont.getAdvanceHeight(int)"})
  void testGetAdvanceHeight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getAdvanceHeight(1));
  }

  /**
   * Test {@link TrueTypeFont#getName()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TrueTypeFont.getName()"})
  void testGetName() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getName());
  }

  /**
   * Test {@link TrueTypeFont#getUnicodeCmapLookup()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getUnicodeCmapLookup()}
   */
  @Test
  @DisplayName("Test getUnicodeCmapLookup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.CmapLookup TrueTypeFont.getUnicodeCmapLookup()"})
  void testGetUnicodeCmapLookup() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getUnicodeCmapLookup());
  }

  /**
   * Test {@link TrueTypeFont#getUnicodeCmapLookup(boolean)} with {@code boolean}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getUnicodeCmapLookup(boolean)}
   */
  @Test
  @DisplayName("Test getUnicodeCmapLookup(boolean) with 'boolean'; when 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.CmapLookup TrueTypeFont.getUnicodeCmapLookup(boolean)"})
  void testGetUnicodeCmapLookupWithBoolean_whenFalse_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getUnicodeCmapLookup(false));
  }

  /**
   * Test {@link TrueTypeFont#getUnicodeCmapLookup(boolean)} with {@code boolean}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getUnicodeCmapLookup(boolean)}
   */
  @Test
  @DisplayName("Test getUnicodeCmapLookup(boolean) with 'boolean'; when 'true'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.CmapLookup TrueTypeFont.getUnicodeCmapLookup(boolean)"})
  void testGetUnicodeCmapLookupWithBoolean_whenTrue_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getUnicodeCmapLookup(true));
  }

  /**
   * Test {@link TrueTypeFont#nameToGID(String)}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then return {@link OS2WindowsMetricsTable#FAMILY_CLASS_ORNAMENTALS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#nameToGID(String)}
   */
  @Test
  @DisplayName("Test nameToGID(String); when 'g9'; then return FAMILY_CLASS_ORNAMENTALS")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TrueTypeFont.nameToGID(String)"})
  void testNameToGID_whenG9_thenReturnFamily_class_ornamentals() throws IOException {
    // Arrange, Act and Assert
    assertEquals(OS2WindowsMetricsTable.FAMILY_CLASS_ORNAMENTALS,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .nameToGID("g9"));
  }

  /**
   * Test {@link TrueTypeFont#nameToGID(String)}.
   * <ul>
   *   <li>When {@code g942}.</li>
   *   <li>Then return nine hundred forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#nameToGID(String)}
   */
  @Test
  @DisplayName("Test nameToGID(String); when 'g942'; then return nine hundred forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TrueTypeFont.nameToGID(String)"})
  void testNameToGID_whenG942_thenReturnNineHundredFortyTwo() throws IOException {
    // Arrange, Act and Assert
    assertEquals(942,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .nameToGID("g942"));
  }

  /**
   * Test {@link TrueTypeFont#nameToGID(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#nameToGID(String)}
   */
  @Test
  @DisplayName("Test nameToGID(String); when 'Name'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TrueTypeFont.nameToGID(String)"})
  void testNameToGID_whenName_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .nameToGID("Name"));
  }

  /**
   * Test {@link TrueTypeFont#nameToGID(String)}.
   * <ul>
   *   <li>When {@code uni}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#nameToGID(String)}
   */
  @Test
  @DisplayName("Test nameToGID(String); when 'uni'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TrueTypeFont.nameToGID(String)"})
  void testNameToGID_whenUni_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .nameToGID("uni"));
  }

  /**
   * Test {@link TrueTypeFont#getWidth(String)}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then return two hundred fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getWidth(String)}
   */
  @Test
  @DisplayName("Test getWidth(String); when 'g9'; then return two hundred fifty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float TrueTypeFont.getWidth(String)"})
  void testGetWidth_whenG9_thenReturnTwoHundredFifty() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getWidth("g9"));
  }

  /**
   * Test {@link TrueTypeFont#getWidth(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return two hundred fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getWidth(String)}
   */
  @Test
  @DisplayName("Test getWidth(String); when 'Name'; then return two hundred fifty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float TrueTypeFont.getWidth(String)"})
  void testGetWidth_whenName_thenReturnTwoHundredFifty() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getWidth("Name"));
  }

  /**
   * Test {@link TrueTypeFont#getWidth(String)}.
   * <ul>
   *   <li>When {@code uni}.</li>
   *   <li>Then return two hundred fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#getWidth(String)}
   */
  @Test
  @DisplayName("Test getWidth(String); when 'uni'; then return two hundred fifty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float TrueTypeFont.getWidth(String)"})
  void testGetWidth_whenUni_thenReturnTwoHundredFifty() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f,
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getWidth("uni"));
  }

  /**
   * Test {@link TrueTypeFont#hasGlyph(String)}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); when 'g9'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TrueTypeFont.hasGlyph(String)"})
  void testHasGlyph_whenG9_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .hasGlyph("g9"));
  }

  /**
   * Test {@link TrueTypeFont#hasGlyph(String)}.
   * <ul>
   *   <li>When {@code g942}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); when 'g942'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TrueTypeFont.hasGlyph(String)"})
  void testHasGlyph_whenG942_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .hasGlyph("g942"));
  }

  /**
   * Test {@link TrueTypeFont#hasGlyph(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); when 'Name'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TrueTypeFont.hasGlyph(String)"})
  void testHasGlyph_whenName_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .hasGlyph("Name"));
  }

  /**
   * Test {@link TrueTypeFont#hasGlyph(String)}.
   * <ul>
   *   <li>When {@code uni}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); when 'uni'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TrueTypeFont.hasGlyph(String)"})
  void testHasGlyph_whenUni_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .hasGlyph("uni"));
  }

  /**
   * Test {@link TrueTypeFont#getFontMatrix()}.
   * <p>
   * Method under test: {@link TrueTypeFont#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TrueTypeFont.getFontMatrix()"})
  void testGetFontMatrix() throws IOException {
    // Arrange and Act
    List<Number> actualFontMatrix = (new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).getFontMatrix();

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
   * <p>
   * Method under test: {@link TrueTypeFont#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TrueTypeFont.toString()"})
  void testToString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("(null)",
        (new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .toString());
  }
}
