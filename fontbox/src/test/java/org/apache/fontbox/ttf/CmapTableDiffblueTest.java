package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CmapTableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CmapTable}
   *   <li>{@link CmapTable#getCmaps()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CmapTable actualCmapTable = new CmapTable();

    // Assert
    assertNull(actualCmapTable.getCmaps());
    assertNull(actualCmapTable.getTag());
    assertEquals(0L, actualCmapTable.getCheckSum());
    assertEquals(0L, actualCmapTable.getLength());
    assertEquals(0L, actualCmapTable.getOffset());
    assertFalse(actualCmapTable.getInitialized());
  }

  /**
   * Test {@link CmapTable#read(TrueTypeFont, TTFDataStream)}.
   * <ul>
   *   <li>Given array of {@code int} with two and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given array of int with two and minus one")
  void testRead_givenArrayOfIntWithTwoAndMinusOne() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{2, -1, 1, -1});
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(8);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(eq(1L));
    verify(data, atLeast(1)).readUnsignedByteArray(eq(8192));
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
   * <ul>
   *   <li>Given array of {@code int} with zero and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given array of int with zero and minus one")
  void testRead_givenArrayOfIntWithZeroAndMinusOne() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{0, -1, 1, -1});
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
    verify(data, atLeast(1)).readUnsignedShortArray(eq(2));
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
   * <ul>
   *   <li>Given eight.</li>
   *   <li>Then first element PlatformEncodingId is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given eight; then first element PlatformEncodingId is eight")
  void testRead_givenEight_thenFirstElementPlatformEncodingIdIsEight() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(8);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(eq(1L));
    verify(data, atLeast(1)).readUnsignedByteArray(eq(8192));
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
   * <ul>
   *   <li>Given {@link Short#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given MIN_VALUE")
  void testRead_givenMin_value() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn(Short.MIN_VALUE);
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(2);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).getCurrentPosition();
    verify(data, atLeast(1)).seek(eq(1L));
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
   * <ul>
   *   <li>Given two.</li>
   *   <li>Then first element PlatformEncodingId is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given two; then first element PlatformEncodingId is two")
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
    verify(data, atLeast(1)).seek(eq(1L));
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
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link TrueTypeFont} {@link TrueTypeFont#getNumberOfGlyphs()} return
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given zero; when TrueTypeFont getNumberOfGlyphs() return zero")
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
    verify(data, atLeast(1)).seek(eq(1L));
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
   * <ul>
   *   <li>Then first element PlatformEncodingId is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then first element PlatformEncodingId is eight")
  void testRead_thenFirstElementPlatformEncodingIdIsEight() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedInt()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(8);

    // Act
    cmapTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(eq(1L));
    verify(data, atLeast(1)).readUnsignedByteArray(eq(8192));
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
   * <ul>
   *   <li>Then first element PlatformEncodingId is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then first element PlatformEncodingId is four")
  void testRead_thenFirstElementPlatformEncodingIdIsFour() throws IOException {
    // Arrange
    CmapTable cmapTable = new CmapTable();
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(CmapTable.ENCODING_WIN_UNICODE_FULL);
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
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
    verify(data, atLeast(1)).readUnsignedShortArray(eq(2));
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
   * <ul>
   *   <li>When {@link TrueTypeFont} {@link TrueTypeFont#getNumberOfGlyphs()} return
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); when TrueTypeFont getNumberOfGlyphs() return two")
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
    verify(data, atLeast(1)).seek(eq(1L));
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
   * <ul>
   *   <li>Given {@link CmapTable#CmapTable()} Cmaps is empty array of
   * {@link CmapSubtable}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapTable#getSubtable(int, int)}
   */
  @Test
  @DisplayName("Test getSubtable(int, int); given CmapTable() Cmaps is empty array of CmapSubtable; then return 'null'")
  void testGetSubtable_givenCmapTableCmapsIsEmptyArrayOfCmapSubtable_thenReturnNull() {
    // Arrange
    CmapTable cmapTable = new CmapTable();
    cmapTable.setCmaps(new CmapSubtable[]{});

    // Act and Assert
    assertNull(cmapTable.getSubtable(1, 1));
  }
}
