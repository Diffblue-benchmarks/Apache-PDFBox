package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CmapTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CmapTable}
   *   <li>{@link CmapTable#getCmaps()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CmapTable.<init>()",
    "CmapSubtable[] CmapTable.getCmaps()",
    "void CmapTable.setCmaps(CmapSubtable[])"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CmapTable actualCmapTable = new CmapTable();
    CmapSubtable[] actualCmaps = actualCmapTable.getCmaps();

    // Assert
    assertNull(actualCmapTable.getTag());
    assertNull(actualCmaps);
    assertEquals(0L, actualCmapTable.getCheckSum());
    assertEquals(0L, actualCmapTable.getLength());
    assertEquals(0L, actualCmapTable.getOffset());
    assertFalse(actualCmapTable.getInitialized());
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given array of {@code int} with four and one.
   *   <li>Then first element PlatformEncodingId is six.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given array of int with four and one; then first element PlatformEncodingId is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenArrayOfIntWithFourAndOne_thenFirstElementPlatformEncodingIdIsSix()
      throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[] {4, 1, 4, 1, 4, 1, 4, 1});
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(6);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data, atLeast(1)).readUnsignedShortArray(6);
    verify(ttf).getNumberOfGlyphs();
    CmapSubtable[] cmaps = cmapTable.getCmaps();
    CmapSubtable cmapSubtable = cmaps[0];
    assertEquals(6, cmapSubtable.getPlatformEncodingId());
    CmapSubtable cmapSubtable2 = cmaps[1];
    assertEquals(6, cmapSubtable2.getPlatformEncodingId());
    CmapSubtable cmapSubtable3 = cmaps[2];
    assertEquals(6, cmapSubtable3.getPlatformEncodingId());
    CmapSubtable cmapSubtable4 = cmaps[3];
    assertEquals(6, cmapSubtable4.getPlatformEncodingId());
    CmapSubtable cmapSubtable5 = cmaps[4];
    assertEquals(6, cmapSubtable5.getPlatformEncodingId());
    CmapSubtable cmapSubtable6 = cmaps[5];
    assertEquals(6, cmapSubtable6.getPlatformEncodingId());
    assertEquals(6, cmapSubtable.getPlatformId());
    assertEquals(6, cmapSubtable2.getPlatformId());
    assertEquals(6, cmapSubtable3.getPlatformId());
    assertEquals(6, cmapSubtable4.getPlatformId());
    assertEquals(6, cmapSubtable5.getPlatformId());
    assertEquals(6, cmapSubtable6.getPlatformId());
    assertEquals(6, cmaps.length);
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given array of {@code int} with two and minus one.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given array of int with two and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenArrayOfIntWithTwoAndMinusOne() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[] {2, -1, 1, -1});
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(8);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readUnsignedByteArray(8192);
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(ttf).getNumberOfGlyphs();
    CmapSubtable[] cmaps = cmapTable.getCmaps();
    CmapSubtable cmapSubtable = cmaps[0];
    assertEquals(8, cmapSubtable.getPlatformEncodingId());
    CmapSubtable cmapSubtable2 = cmaps[1];
    assertEquals(8, cmapSubtable2.getPlatformEncodingId());
    CmapSubtable cmapSubtable3 = cmaps[2];
    assertEquals(8, cmapSubtable3.getPlatformEncodingId());
    CmapSubtable cmapSubtable4 = cmaps[3];
    assertEquals(8, cmapSubtable4.getPlatformEncodingId());
    CmapSubtable cmapSubtable5 = cmaps[4];
    assertEquals(8, cmapSubtable5.getPlatformEncodingId());
    CmapSubtable cmapSubtable6 = cmaps[5];
    assertEquals(8, cmapSubtable6.getPlatformEncodingId());
    CmapSubtable cmapSubtable7 = cmaps[6];
    assertEquals(8, cmapSubtable7.getPlatformEncodingId());
    CmapSubtable cmapSubtable8 = cmaps[7];
    assertEquals(8, cmapSubtable8.getPlatformEncodingId());
    assertEquals(8, cmapSubtable.getPlatformId());
    assertEquals(8, cmapSubtable2.getPlatformId());
    assertEquals(8, cmapSubtable3.getPlatformId());
    assertEquals(8, cmapSubtable4.getPlatformId());
    assertEquals(8, cmapSubtable5.getPlatformId());
    assertEquals(8, cmapSubtable6.getPlatformId());
    assertEquals(8, cmapSubtable7.getPlatformId());
    assertEquals(8, cmapSubtable8.getPlatformId());
    assertEquals(8, cmaps.length);
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given array of {@code int} with zero and minus one.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given array of int with zero and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenArrayOfIntWithZeroAndMinusOne() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[] {0, -1, 1, -1});
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(4);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).getCurrentPosition();
    verify(data, atLeast(1)).seek(anyLong());
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data, atLeast(1)).readUnsignedShortArray(2);
    verify(ttf).getNumberOfGlyphs();
    CmapSubtable[] cmaps = cmapTable.getCmaps();
    CmapSubtable cmapSubtable = cmaps[0];
    assertEquals(4, cmapSubtable.getPlatformEncodingId());
    CmapSubtable cmapSubtable2 = cmaps[1];
    assertEquals(4, cmapSubtable2.getPlatformEncodingId());
    CmapSubtable cmapSubtable3 = cmaps[2];
    assertEquals(4, cmapSubtable3.getPlatformEncodingId());
    CmapSubtable cmapSubtable4 = cmaps[3];
    assertEquals(4, cmapSubtable4.getPlatformEncodingId());
    assertEquals(4, cmapSubtable.getPlatformId());
    assertEquals(4, cmapSubtable2.getPlatformId());
    assertEquals(4, cmapSubtable3.getPlatformId());
    assertEquals(4, cmapSubtable4.getPlatformId());
    assertEquals(4, cmaps.length);
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given eight.
   *   <li>Then first element PlatformEncodingId is eight.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given eight; then first element PlatformEncodingId is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenEight_thenFirstElementPlatformEncodingIdIsEight() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(8);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readUnsignedByteArray(8192);
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(ttf).getNumberOfGlyphs();
    CmapSubtable[] cmaps = cmapTable.getCmaps();
    CmapSubtable cmapSubtable = cmaps[0];
    assertEquals(8, cmapSubtable.getPlatformEncodingId());
    CmapSubtable cmapSubtable2 = cmaps[1];
    assertEquals(8, cmapSubtable2.getPlatformEncodingId());
    CmapSubtable cmapSubtable3 = cmaps[2];
    assertEquals(8, cmapSubtable3.getPlatformEncodingId());
    CmapSubtable cmapSubtable4 = cmaps[3];
    assertEquals(8, cmapSubtable4.getPlatformEncodingId());
    CmapSubtable cmapSubtable5 = cmaps[4];
    assertEquals(8, cmapSubtable5.getPlatformEncodingId());
    CmapSubtable cmapSubtable6 = cmaps[5];
    assertEquals(8, cmapSubtable6.getPlatformEncodingId());
    CmapSubtable cmapSubtable7 = cmaps[6];
    assertEquals(8, cmapSubtable7.getPlatformEncodingId());
    CmapSubtable cmapSubtable8 = cmaps[7];
    assertEquals(8, cmapSubtable8.getPlatformEncodingId());
    assertEquals(8, cmapSubtable.getPlatformId());
    assertEquals(8, cmapSubtable2.getPlatformId());
    assertEquals(8, cmapSubtable3.getPlatformId());
    assertEquals(8, cmapSubtable4.getPlatformId());
    assertEquals(8, cmapSubtable5.getPlatformId());
    assertEquals(8, cmapSubtable6.getPlatformId());
    assertEquals(8, cmapSubtable7.getPlatformId());
    assertEquals(8, cmapSubtable8.getPlatformId());
    assertEquals(8, cmaps.length);
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given {@link OS2WindowsMetricsTable#FAMILY_CLASS_SYMBOLIC}.
   *   <li>Then array length is {@link OS2WindowsMetricsTable#FAMILY_CLASS_SYMBOLIC}.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given FAMILY_CLASS_SYMBOLIC; then array length is FAMILY_CLASS_SYMBOLIC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenFamily_class_symbolic_thenArrayLengthIsFamily_class_symbolic()
      throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(OS2WindowsMetricsTable.FAMILY_CLASS_SYMBOLIC);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(ttf).getNumberOfGlyphs();
    assertEquals(OS2WindowsMetricsTable.FAMILY_CLASS_SYMBOLIC, cmapTable.getCmaps().length);
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given thirteen.
   *   <li>Then array length is thirteen.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given thirteen; then array length is thirteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenThirteen_thenArrayLengthIsThirteen() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(13);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(ttf).getNumberOfGlyphs();
    assertEquals(13, cmapTable.getCmaps().length);
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then first element PlatformEncodingId is two.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given two; then first element PlatformEncodingId is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenTwo_thenFirstElementPlatformEncodingIdIsTwo() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(2);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).getCurrentPosition();
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(ttf).getNumberOfGlyphs();
    CmapSubtable[] cmaps = cmapTable.getCmaps();
    CmapSubtable cmapSubtable = cmaps[0];
    assertEquals(2, cmapSubtable.getPlatformEncodingId());
    CmapSubtable cmapSubtable2 = cmaps[1];
    assertEquals(2, cmapSubtable2.getPlatformEncodingId());
    assertEquals(2, cmapSubtable.getPlatformId());
    assertEquals(2, cmapSubtable2.getPlatformId());
    assertEquals(2, cmaps.length);
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link TrueTypeFont} {@link TrueTypeFont#getNumberOfGlyphs()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given zero; when TrueTypeFont getNumberOfGlyphs() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenZero_whenTrueTypeFontGetNumberOfGlyphsReturnZero() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(0);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(2);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).getCurrentPosition();
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(ttf).getNumberOfGlyphs();
    CmapSubtable[] cmaps = cmapTable.getCmaps();
    CmapSubtable cmapSubtable = cmaps[0];
    assertEquals(2, cmapSubtable.getPlatformEncodingId());
    CmapSubtable cmapSubtable2 = cmaps[1];
    assertEquals(2, cmapSubtable2.getPlatformEncodingId());
    assertEquals(2, cmapSubtable.getPlatformId());
    assertEquals(2, cmapSubtable2.getPlatformId());
    assertEquals(2, cmaps.length);
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Then first element PlatformEncodingId is eight.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); then first element PlatformEncodingId is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenFirstElementPlatformEncodingIdIsEight() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(8);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readUnsignedByteArray(8192);
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    CmapSubtable[] cmaps = cmapTable.getCmaps();
    CmapSubtable cmapSubtable = cmaps[0];
    assertEquals(8, cmapSubtable.getPlatformEncodingId());
    CmapSubtable cmapSubtable2 = cmaps[1];
    assertEquals(8, cmapSubtable2.getPlatformEncodingId());
    CmapSubtable cmapSubtable3 = cmaps[2];
    assertEquals(8, cmapSubtable3.getPlatformEncodingId());
    CmapSubtable cmapSubtable4 = cmaps[3];
    assertEquals(8, cmapSubtable4.getPlatformEncodingId());
    CmapSubtable cmapSubtable5 = cmaps[4];
    assertEquals(8, cmapSubtable5.getPlatformEncodingId());
    CmapSubtable cmapSubtable6 = cmaps[5];
    assertEquals(8, cmapSubtable6.getPlatformEncodingId());
    CmapSubtable cmapSubtable7 = cmaps[6];
    assertEquals(8, cmapSubtable7.getPlatformEncodingId());
    CmapSubtable cmapSubtable8 = cmaps[7];
    assertEquals(8, cmapSubtable8.getPlatformEncodingId());
    assertEquals(8, cmapSubtable.getPlatformId());
    assertEquals(8, cmapSubtable2.getPlatformId());
    assertEquals(8, cmapSubtable3.getPlatformId());
    assertEquals(8, cmapSubtable4.getPlatformId());
    assertEquals(8, cmapSubtable5.getPlatformId());
    assertEquals(8, cmapSubtable6.getPlatformId());
    assertEquals(8, cmapSubtable7.getPlatformId());
    assertEquals(8, cmapSubtable8.getPlatformId());
    assertEquals(8, cmaps.length);
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Then first element PlatformEncodingId is {@link CmapTable#ENCODING_WIN_UNICODE_FULL}.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); then first element PlatformEncodingId is ENCODING_WIN_UNICODE_FULL")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenFirstElementPlatformEncodingIdIsEncoding_win_unicode_full() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(ttf).getNumberOfGlyphs();
    CmapSubtable[] cmaps = cmapTable.getCmaps();
    CmapSubtable cmapSubtable = cmaps[0];
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable.getPlatformEncodingId());
    CmapSubtable cmapSubtable2 = cmaps[1];
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable2.getPlatformEncodingId());
    CmapSubtable cmapSubtable3 = cmaps[2];
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable3.getPlatformEncodingId());
    CmapSubtable cmapSubtable4 = cmaps[3];
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable4.getPlatformEncodingId());
    CmapSubtable cmapSubtable5 = cmaps[4];
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable5.getPlatformEncodingId());
    CmapSubtable cmapSubtable6 = cmaps[5];
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable6.getPlatformEncodingId());
    CmapSubtable cmapSubtable7 = cmaps[6];
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable7.getPlatformEncodingId());
    CmapSubtable cmapSubtable8 = cmaps[7];
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable8.getPlatformEncodingId());
    CmapSubtable cmapSubtable9 = cmaps[8];
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable9.getPlatformEncodingId());
    CmapSubtable cmapSubtable10 = cmaps[OS2WindowsMetricsTable.FAMILY_CLASS_ORNAMENTALS];
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable10.getPlatformEncodingId());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable.getPlatformId());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable2.getPlatformId());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable3.getPlatformId());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable4.getPlatformId());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable5.getPlatformId());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable6.getPlatformId());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable7.getPlatformId());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable8.getPlatformId());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable9.getPlatformId());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmapSubtable10.getPlatformId());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, cmaps.length);
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Then first element PlatformEncodingId is four.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); then first element PlatformEncodingId is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenFirstElementPlatformEncodingIdIsFour() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(4);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).getCurrentPosition();
    verify(data, atLeast(1)).seek(anyLong());
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data, atLeast(1)).readUnsignedShortArray(2);
    verify(ttf).getNumberOfGlyphs();
    CmapSubtable[] cmaps = cmapTable.getCmaps();
    CmapSubtable cmapSubtable = cmaps[0];
    assertEquals(4, cmapSubtable.getPlatformEncodingId());
    CmapSubtable cmapSubtable2 = cmaps[1];
    assertEquals(4, cmapSubtable2.getPlatformEncodingId());
    CmapSubtable cmapSubtable3 = cmaps[2];
    assertEquals(4, cmapSubtable3.getPlatformEncodingId());
    CmapSubtable cmapSubtable4 = cmaps[3];
    assertEquals(4, cmapSubtable4.getPlatformEncodingId());
    assertEquals(4, cmapSubtable.getPlatformId());
    assertEquals(4, cmapSubtable2.getPlatformId());
    assertEquals(4, cmapSubtable3.getPlatformId());
    assertEquals(4, cmapSubtable4.getPlatformId());
    assertEquals(4, cmaps.length);
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readSignedShort()} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); when RandomAccessReadDataStream readSignedShort() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_whenRandomAccessReadDataStreamReadSignedShortThrowIOException() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readSignedShort()).thenThrow(new IOException());
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(2);

    // Act and Assert
    assertThrows(IOException.class, () -> cmapTable.read(ttf, data));
    verify(data).seek(1L);
    verify(data).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(ttf).getNumberOfGlyphs();
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedByteArray(int)} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); when RandomAccessReadDataStream readUnsignedByteArray(int) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_whenRandomAccessReadDataStreamReadUnsignedByteArrayThrowIOException()
      throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenThrow(new IOException());
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(8);

    // Act and Assert
    assertThrows(IOException.class, () -> cmapTable.read(ttf, data));
    verify(data).seek(1L);
    verify(data).readUnsignedByteArray(8192);
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedShortArray(int)} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); when RandomAccessReadDataStream readUnsignedShortArray(int) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_whenRandomAccessReadDataStreamReadUnsignedShortArrayThrowIOException()
      throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenThrow(new IOException());
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(4);

    // Act and Assert
    assertThrows(IOException.class, () -> cmapTable.read(ttf, data));
    verify(data).seek(1L);
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data).readUnsignedShortArray(2);
    verify(ttf).getNumberOfGlyphs();
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedShortArray(int)} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); when RandomAccessReadDataStream readUnsignedShortArray(int) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_whenRandomAccessReadDataStreamReadUnsignedShortArrayThrowIOException2()
      throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenThrow(new IOException());
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(6);

    // Act and Assert
    assertThrows(IOException.class, () -> cmapTable.read(ttf, data));
    verify(data).seek(1L);
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data).readUnsignedShortArray(6);
    verify(ttf).getNumberOfGlyphs();
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>When {@link TrueTypeFont} {@link TrueTypeFont#getNumberOfGlyphs()} return two.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); when TrueTypeFont getNumberOfGlyphs() return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CmapTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_whenTrueTypeFontGetNumberOfGlyphsReturnTwo() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(2);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(2);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).getCurrentPosition();
    verify(data, atLeast(1)).seek(1L);
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(ttf).getNumberOfGlyphs();
    CmapSubtable[] cmaps = cmapTable.getCmaps();
    CmapSubtable cmapSubtable = cmaps[0];
    assertEquals(2, cmapSubtable.getPlatformEncodingId());
    CmapSubtable cmapSubtable2 = cmaps[1];
    assertEquals(2, cmapSubtable2.getPlatformEncodingId());
    assertEquals(2, cmapSubtable.getPlatformId());
    assertEquals(2, cmapSubtable2.getPlatformId());
    assertEquals(2, cmaps.length);
  }

  /**
   * Test {@link CmapTable#getSubtable(int, int)}.
   *
   * <ul>
   *   <li>Given {@link CmapTable#CmapTable()} Cmaps is empty array of {@link CmapSubtable}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CmapTable#getSubtable(int, int)}
   */
  @Test
  @DisplayName(
      "Test getSubtable(int, int); given CmapTable() Cmaps is empty array of CmapSubtable; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CmapSubtable CmapTable.getSubtable(int, int)"})
  void testGetSubtable_givenCmapTableCmapsIsEmptyArrayOfCmapSubtable_thenReturnNull() {
    // Arrange
    CmapTable cmapTable = new CmapTable();
    cmapTable.setCmaps(new CmapSubtable[] {});

    // Act and Assert
    assertNull(cmapTable.getSubtable(1, 1));
  }
}
