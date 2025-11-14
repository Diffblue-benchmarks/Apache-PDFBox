package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GlyphTableDiffblueTest {
  @InjectMocks private GlyphTable glyphTable;

  @Mock private TTFDataStream tTFDataStream;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GlyphTable}
   *   <li>{@link GlyphTable#setGlyphs(GlyphData[])}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphTable.<init>()", "void GlyphTable.setGlyphs(GlyphData[])"})
  void testGettersAndSetters() {
    // Arrange and Act
    GlyphTable actualGlyphTable = new GlyphTable();
    actualGlyphTable.setGlyphs(new GlyphData[] {new GlyphData()});

    // Assert
    assertNull(actualGlyphTable.getTag());
    assertEquals(0L, actualGlyphTable.getCheckSum());
    assertEquals(0L, actualGlyphTable.getLength());
    assertEquals(0L, actualGlyphTable.getOffset());
    assertFalse(actualGlyphTable.getInitialized());
  }

  /**
   * Test {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given {@link GlyphTable#GlyphTable()} Length is three.
   *   <li>Then {@link GlyphTable#GlyphTable()} Initialized.
   * </ul>
   *
   * <p>Method under test: {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given GlyphTable() Length is three; then GlyphTable() Initialized")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenGlyphTableLengthIsThree_thenGlyphTableInitialized() throws IOException {
    // Arrange
    GlyphTable glyphTable = new GlyphTable();
    glyphTable.setLength(3L);
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    // Act
    glyphTable.read(
        ttf,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertTrue(glyphTable.getInitialized());
  }

  /**
   * Test {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given {@link GlyphTable#GlyphTable()} Length is three.
   *   <li>When {@code A}.
   *   <li>Then {@link GlyphTable#GlyphTable()} Initialized.
   * </ul>
   *
   * <p>Method under test: {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given GlyphTable() Length is three; when 'A'; then GlyphTable() Initialized")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenGlyphTableLengthIsThree_whenA_thenGlyphTableInitialized() throws IOException {
    // Arrange
    GlyphTable glyphTable = new GlyphTable();
    glyphTable.setLength(3L);
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    // Act
    glyphTable.read(ttf, new RandomAccessReadUnbufferedDataStream(randomAccessRead));

    // Assert
    assertTrue(glyphTable.getInitialized());
  }

  /**
   * Test {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given {@link GlyphTable#GlyphTable()}.
   *   <li>Then {@link GlyphTable#GlyphTable()} Initialized.
   * </ul>
   *
   * <p>Method under test: {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given GlyphTable(); then GlyphTable() Initialized")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenGlyphTable_thenGlyphTableInitialized() throws IOException {
    // Arrange
    GlyphTable glyphTable = new GlyphTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    // Act
    glyphTable.read(
        ttf,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertTrue(glyphTable.getInitialized());
  }

  /**
   * Test {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given {@link TTFDataStream} {@link TTFDataStream#read(int)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given TTFDataStream read(int) throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenTTFDataStreamReadThrowIOException_thenThrowIOException() throws IOException {
    // Arrange
    when(tTFDataStream.read(anyInt())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        IOException.class, () -> glyphTable.read(new TrueTypeFont(tTFDataStream), tTFDataStream));
    verify(tTFDataStream).read(0);
  }

  /**
   * Test {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Then {@link GlyphTable} Initialized.
   * </ul>
   *
   * <p>Method under test: {@link GlyphTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then GlyphTable Initialized")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenGlyphTableInitialized() throws IOException {
    // Arrange
    when(tTFDataStream.read(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    glyphTable.read(new TrueTypeFont(tTFDataStream), tTFDataStream);

    // Assert
    verify(tTFDataStream).read(0);
    assertTrue(glyphTable.getInitialized());
  }

  /**
   * Test {@link GlyphTable#getGlyph(int, int)} with {@code gid}, {@code level}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link GlyphTable#getGlyph(int, int)}
   */
  @Test
  @DisplayName("Test getGlyph(int, int) with 'gid', 'level'; when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GlyphData GlyphTable.getGlyph(int, int)"})
  void testGetGlyphWithGidLevel_whenMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertNull(new GlyphTable().getGlyph(-1, 1));
  }

  /**
   * Test {@link GlyphTable#getGlyph(int, int)} with {@code gid}, {@code level}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link GlyphTable#getGlyph(int, int)}
   */
  @Test
  @DisplayName("Test getGlyph(int, int) with 'gid', 'level'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GlyphData GlyphTable.getGlyph(int, int)"})
  void testGetGlyphWithGidLevel_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertNull(new GlyphTable().getGlyph(1, 1));
  }

  /**
   * Test {@link GlyphTable#getGlyph(int)} with {@code gid}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link GlyphTable#getGlyph(int)}
   */
  @Test
  @DisplayName("Test getGlyph(int) with 'gid'; when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GlyphData GlyphTable.getGlyph(int)"})
  void testGetGlyphWithGid_whenMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertNull(new GlyphTable().getGlyph(-1));
  }

  /**
   * Test {@link GlyphTable#getGlyph(int)} with {@code gid}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link GlyphTable#getGlyph(int)}
   */
  @Test
  @DisplayName("Test getGlyph(int) with 'gid'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GlyphData GlyphTable.getGlyph(int)"})
  void testGetGlyphWithGid_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertNull(new GlyphTable().getGlyph(1));
  }
}
