package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class GlyphTableDiffblueTest {
  /**
   * Method under test: {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead() throws IOException {
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
   * Method under test: {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead2() throws IOException {
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
   * Method under test: {@link GlyphTable#getGlyph(int)}
   */
  @Test
  void testGetGlyph() throws IOException {
    // Arrange, Act and Assert
    assertNull((new GlyphTable()).getGlyph(1));
    assertNull((new GlyphTable()).getGlyph(-1));
    assertNull((new GlyphTable()).getGlyph(1, 1));
    assertNull((new GlyphTable()).getGlyph(-1, 1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GlyphTable}
   *   <li>{@link GlyphTable#setGlyphs(GlyphData[])}
   * </ul>
   */
  @Test
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
}
