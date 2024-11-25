package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GlyphTableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GlyphTable}
   *   <li>{@link GlyphTable#setGlyphs(GlyphData[])}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    GlyphTable actualGlyphTable = new GlyphTable();
    actualGlyphTable.setGlyphs(new GlyphData[]{new GlyphData()});

    // Assert
    assertNull(actualGlyphTable.getTag());
    assertEquals(0L, actualGlyphTable.getCheckSum());
    assertEquals(0L, actualGlyphTable.getLength());
    assertEquals(0L, actualGlyphTable.getOffset());
    assertFalse(actualGlyphTable.getInitialized());
  }

  /**
   * Test {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}.
   * <ul>
   *   <li>Given {@link GlyphTable#GlyphTable()} Length is three.</li>
   *   <li>Then {@link GlyphTable#GlyphTable()} Initialized.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given GlyphTable() Length is three; then GlyphTable() Initialized")
  void testRead_givenGlyphTableLengthIsThree_thenGlyphTableInitialized() throws IOException {
    // Arrange
    GlyphTable glyphTable = new GlyphTable();
    glyphTable.setLength(3L);
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    glyphTable.read(ttf, new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertTrue(glyphTable.getInitialized());
  }

  /**
   * Test {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}.
   * <ul>
   *   <li>Given {@link GlyphTable#GlyphTable()} Length is three.</li>
   *   <li>When {@code A}.</li>
   *   <li>Then {@link GlyphTable#GlyphTable()} Initialized.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given GlyphTable() Length is three; when 'A'; then GlyphTable() Initialized")
  void testRead_givenGlyphTableLengthIsThree_whenA_thenGlyphTableInitialized() throws IOException {
    // Arrange
    GlyphTable glyphTable = new GlyphTable();
    glyphTable.setLength(3L);
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    glyphTable.read(ttf, new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}))));

    // Assert
    assertTrue(glyphTable.getInitialized());
  }

  /**
   * Test {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}.
   * <ul>
   *   <li>Given {@link GlyphTable#GlyphTable()}.</li>
   *   <li>Then {@link GlyphTable#GlyphTable()} Initialized.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given GlyphTable(); then GlyphTable() Initialized")
  void testRead_givenGlyphTable_thenGlyphTableInitialized() throws IOException {
    // Arrange
    GlyphTable glyphTable = new GlyphTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    glyphTable.read(ttf, new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertTrue(glyphTable.getInitialized());
  }

  /**
   * Test {@link GlyphTable#getGlyph(int, int)} with {@code gid}, {@code level}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphTable#getGlyph(int, int)}
   */
  @Test
  @DisplayName("Test getGlyph(int, int) with 'gid', 'level'; when minus one")
  void testGetGlyphWithGidLevel_whenMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertNull((new GlyphTable()).getGlyph(-1, 1));
  }

  /**
   * Test {@link GlyphTable#getGlyph(int, int)} with {@code gid}, {@code level}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphTable#getGlyph(int, int)}
   */
  @Test
  @DisplayName("Test getGlyph(int, int) with 'gid', 'level'; when one")
  void testGetGlyphWithGidLevel_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertNull((new GlyphTable()).getGlyph(1, 1));
  }

  /**
   * Test {@link GlyphTable#getGlyph(int)} with {@code gid}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphTable#getGlyph(int)}
   */
  @Test
  @DisplayName("Test getGlyph(int) with 'gid'; when minus one")
  void testGetGlyphWithGid_whenMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertNull((new GlyphTable()).getGlyph(-1));
  }

  /**
   * Test {@link GlyphTable#getGlyph(int)} with {@code gid}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphTable#getGlyph(int)}
   */
  @Test
  @DisplayName("Test getGlyph(int) with 'gid'; when one")
  void testGetGlyphWithGid_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertNull((new GlyphTable()).getGlyph(1));
  }
}
