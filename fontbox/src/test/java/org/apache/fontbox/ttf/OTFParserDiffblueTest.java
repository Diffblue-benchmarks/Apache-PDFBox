package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OTFParserDiffblueTest {
  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with
   * {@link CFFTable#TAG}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parse(TTFDataStream) with 'raf'; given IOException(String) with TAG; then throw IOException")
  void testParseWithRaf_givenIOExceptionWithTag_thenThrowIOException() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getCurrentPosition()).thenThrow(new IOException(CFFTable.TAG));
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn("String");
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#newFont(TTFDataStream)}.
   * <p>
   * Method under test: {@link OTFParser#newFont(TTFDataStream)}
   */
  @Test
  @DisplayName("Test newFont(TTFDataStream)")
  void testNewFont() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    // Act
    OpenTypeFont actualNewFontResult = otfParser
        .newFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertNull(actualNewFontResult.getName());
    assertNull(actualNewFontResult.getCmap());
    assertNull(actualNewFontResult.getGsub());
    assertNull(actualNewFontResult.getGlyph());
    assertNull(actualNewFontResult.getHeader());
    assertNull(actualNewFontResult.getHorizontalHeader());
    assertNull(actualNewFontResult.getHorizontalMetrics());
    assertNull(actualNewFontResult.getIndexToLocation());
    assertNull(actualNewFontResult.getKerning());
    assertNull(actualNewFontResult.getMaximumProfile());
    assertNull(actualNewFontResult.getNaming());
    assertNull(actualNewFontResult.getOS2Windows());
    assertNull(actualNewFontResult.getPostScript());
    assertNull(actualNewFontResult.getVerticalHeader());
    assertNull(actualNewFontResult.getVerticalMetrics());
    assertNull(actualNewFontResult.getVerticalOrigin());
    assertEquals(0, actualNewFontResult.getNumberOfGlyphs());
    assertEquals(0, actualNewFontResult.getUnitsPerEm());
    assertEquals(0.0f, actualNewFontResult.getVersion());
    List<Number> fontMatrix = actualNewFontResult.getFontMatrix();
    assertEquals(6, fontMatrix.size());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualNewFontResult.getOriginalData().read(byteArray));
    assertEquals(8L, actualNewFontResult.getOriginalDataSize());
    assertTrue(actualNewFontResult.getTables().isEmpty());
    assertTrue(actualNewFontResult.getTableMap().isEmpty());
    assertTrue(actualNewFontResult.isEnableGsub());
    assertEquals(Float.POSITIVE_INFINITY, fontMatrix.get(0).floatValue());
    assertEquals(Float.POSITIVE_INFINITY, fontMatrix.get(3).floatValue());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   * <ul>
   *   <li>When {@code BASE}.</li>
   *   <li>Then return {@link OTLTable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when 'BASE'; then return OTLTable")
  void testReadTable_whenBase_thenReturnOTLTable() {
    // Arrange and Act
    TTFTable actualReadTableResult = (new OTFParser(true)).readTable("BASE");

    // Assert
    assertTrue(actualReadTableResult instanceof OTLTable);
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   * <ul>
   *   <li>When {@code GDEF}.</li>
   *   <li>Then return {@link OTLTable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when 'GDEF'; then return OTLTable")
  void testReadTable_whenGdef_thenReturnOTLTable() {
    // Arrange and Act
    TTFTable actualReadTableResult = (new OTFParser(true)).readTable("GDEF");

    // Assert
    assertTrue(actualReadTableResult instanceof OTLTable);
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   * <ul>
   *   <li>When {@code GPOS}.</li>
   *   <li>Then return {@link OTLTable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when 'GPOS'; then return OTLTable")
  void testReadTable_whenGpos_thenReturnOTLTable() {
    // Arrange and Act
    TTFTable actualReadTableResult = (new OTFParser(true)).readTable("GPOS");

    // Assert
    assertTrue(actualReadTableResult instanceof OTLTable);
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   * <ul>
   *   <li>When {@code Tag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when 'Tag'")
  void testReadTable_whenTag() {
    // Arrange and Act
    TTFTable actualReadTableResult = (new OTFParser(true)).readTable("Tag");

    // Assert
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   * <ul>
   *   <li>When {@link CFFTable#TAG}.</li>
   *   <li>Then return {@link CFFTable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when TAG; then return CFFTable")
  void testReadTable_whenTag_thenReturnCFFTable() {
    // Arrange and Act
    TTFTable actualReadTableResult = (new OTFParser(true)).readTable(CFFTable.TAG);

    // Assert
    assertTrue(actualReadTableResult instanceof CFFTable);
    assertNull(actualReadTableResult.getTag());
    assertNull(((CFFTable) actualReadTableResult).getFont());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   * <ul>
   *   <li>When {@link GlyphSubstitutionTable#TAG}.</li>
   *   <li>Then return {@link OTLTable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when TAG; then return OTLTable")
  void testReadTable_whenTag_thenReturnOTLTable() {
    // Arrange and Act
    TTFTable actualReadTableResult = (new OTFParser(true)).readTable(GlyphSubstitutionTable.TAG);

    // Assert
    assertTrue(actualReadTableResult instanceof OTLTable);
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   * <ul>
   *   <li>When {@link OTLTable#TAG}.</li>
   *   <li>Then return {@link OTLTable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when TAG; then return OTLTable")
  void testReadTable_whenTag_thenReturnOTLTable2() {
    // Arrange and Act
    TTFTable actualReadTableResult = (new OTFParser(true)).readTable(OTLTable.TAG);

    // Assert
    assertTrue(actualReadTableResult instanceof OTLTable);
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#allowCFF()}.
   * <p>
   * Method under test: {@link OTFParser#allowCFF()}
   */
  @Test
  @DisplayName("Test allowCFF()")
  void testAllowCFF() {
    // Arrange, Act and Assert
    assertTrue((new OTFParser(true)).allowCFF());
  }
}
