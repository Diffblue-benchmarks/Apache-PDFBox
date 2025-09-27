package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
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
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.ttf.model.GsubData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyphSubstitutionTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GlyphSubstitutionTable}
   *   <li>{@link GlyphSubstitutionTable#getGsubData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GlyphSubstitutionTable.<init>()",
    "GsubData GlyphSubstitutionTable.getGsubData()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GlyphSubstitutionTable actualGlyphSubstitutionTable = new GlyphSubstitutionTable();
    GsubData actualGsubData = actualGlyphSubstitutionTable.getGsubData();

    // Assert
    assertNull(actualGlyphSubstitutionTable.getTag());
    assertNull(actualGsubData);
    assertEquals(0L, actualGlyphSubstitutionTable.getCheckSum());
    assertEquals(0L, actualGlyphSubstitutionTable.getLength());
    assertEquals(0L, actualGlyphSubstitutionTable.getOffset());
    assertFalse(actualGlyphSubstitutionTable.getInitialized());
  }

  /**
   * Test {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then calls {@link RandomAccessReadDataStream#readUnsignedInt()}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given IOException(); then calls readUnsignedInt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphSubstitutionTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenIOException_thenCallsReadUnsignedInt() throws IOException {
    // Arrange
    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedInt()).thenThrow(new IOException());
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.getCurrentPosition()).thenReturn(1L);

    // Act and Assert
    assertThrows(IOException.class, () -> glyphSubstitutionTable.read(ttf, data));
    verify(data).getCurrentPosition();
    verify(data).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then {@link GlyphSubstitutionTable#GlyphSubstitutionTable()} SupportedScriptTags Empty.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given zero; then GlyphSubstitutionTable() SupportedScriptTags Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphSubstitutionTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenZero_thenGlyphSubstitutionTableSupportedScriptTagsEmpty() throws IOException {
    // Arrange
    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(0);
    when(data.getCurrentPosition()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());

    // Act
    glyphSubstitutionTable.read(ttf, data);

    // Assert
    verify(data).getCurrentPosition();
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readUnsignedShort();
    assertTrue(glyphSubstitutionTable.getSupportedScriptTags().isEmpty());
    assertTrue(glyphSubstitutionTable.getInitialized());
  }

  /**
   * Test {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Then calls {@link RandomAccessReadDataStream#getOriginalDataSize()}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then calls getOriginalDataSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphSubstitutionTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenCallsGetOriginalDataSize() throws IOException {
    // Arrange
    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readString(anyInt())).thenReturn("String");
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedShort()).thenReturn(4);
    when(data.getCurrentPosition()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());

    // Act and Assert
    assertThrows(IOException.class, () -> glyphSubstitutionTable.read(ttf, data));
    verify(data).getCurrentPosition();
    verify(data, atLeast(1)).getOriginalDataSize();
    verify(data, atLeast(1)).seek(anyLong());
    verify(data, atLeast(1)).readString(4);
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link GlyphSubstitutionTable#GlyphSubstitutionTable()}.
   *   <li>When minus one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  @DisplayName(
      "Test getSubstitution(int, String[], List); given GlyphSubstitutionTable(); when minus one; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getSubstitution(int, String[], List)"})
  void testGetSubstitution_givenGlyphSubstitutionTable_whenMinusOne_thenReturnMinusOne() {
    // Arrange
    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable();

    // Act and Assert
    assertEquals(
        -1, glyphSubstitutionTable.getSubstitution(-1, new String[] {}, new ArrayList<>()));
  }

  /**
   * Test {@link GlyphSubstitutionTable#getUnsubstitution(int)}.
   *
   * <p>Method under test: {@link GlyphSubstitutionTable#getUnsubstitution(int)}
   */
  @Test
  @DisplayName("Test getUnsubstitution(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyphSubstitutionTable.getUnsubstitution(int)"})
  void testGetUnsubstitution() {
    // Arrange, Act and Assert
    assertEquals(1, new GlyphSubstitutionTable().getUnsubstitution(1));
  }
}
