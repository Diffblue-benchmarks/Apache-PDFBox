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
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

class OTFParserDiffblueTest {
  /**
   * Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  void testParse() throws IOException {
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
   * Method under test: {@link OTFParser#newFont(TTFDataStream)}
   */
  @Test
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
   * Method under test: {@link OTFParser#newFont(TTFDataStream)}
   */
  @Test
  void testNewFont2() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    OpenTypeFont actualNewFontResult = otfParser.newFont(new RandomAccessReadDataStream(inputStream));

    // Assert
    verify(inputStream).readAllBytes();
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
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  void testReadTable() {
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
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  void testReadTable2() {
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
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  void testReadTable3() {
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
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  void testReadTable4() {
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
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  void testReadTable5() {
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
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  void testReadTable6() {
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
   * Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  void testReadTable7() {
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
   * Method under test: {@link OTFParser#allowCFF()}
   */
  @Test
  void testAllowCFF() {
    // Arrange, Act and Assert
    assertTrue((new OTFParser(true)).allowCFF());
  }
}
