package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class CmapSubtableDiffblueTest {
  /**
   * Method under test: {@link CmapSubtable#initData(TTFDataStream)}
   */
  @Test
  void testInitData() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();

    // Act
    cmapSubtable.initData(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertEquals(16728, cmapSubtable.getPlatformEncodingId());
    assertEquals(16728, cmapSubtable.getPlatformId());
  }

  /**
   * Method under test: {@link CmapSubtable#initData(TTFDataStream)}
   */
  @Test
  void testInitData2() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    cmapSubtable.initData(new RandomAccessReadDataStream(inputStream));

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(16728, cmapSubtable.getPlatformEncodingId());
    assertEquals(16728, cmapSubtable.getPlatformId());
  }

  /**
   * Method under test:
   * {@link CmapSubtable#initSubtable(CmapTable, int, TTFDataStream)}
   */
  @Test
  void testInitSubtable() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    CmapTable cmap = new CmapTable();

    // Act and Assert
    assertThrows(IOException.class, () -> cmapSubtable.initSubtable(cmap, CmapTable.ENCODING_WIN_UNICODE_FULL,
        new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")))));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype10(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype10() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();

    // Act and Assert
    assertThrows(IOException.class,
        () -> cmapSubtable.processSubtype10(
            new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))),
            CmapTable.ENCODING_WIN_UNICODE_FULL));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype10(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype102() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();

    // Act and Assert
    assertThrows(IOException.class,
        () -> cmapSubtable.processSubtype10(
            new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', -1, 'X', 'A', 'X'})),
            CmapTable.ENCODING_WIN_UNICODE_FULL));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype12(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype12() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();

    // Act and Assert
    assertThrows(IOException.class,
        () -> cmapSubtable.processSubtype12(
            new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"))),
            CmapTable.ENCODING_WIN_UNICODE_FULL));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype12(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype122() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    cmapSubtable.processSubtype12(new RandomAccessReadDataStream(inputStream), 0);

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype13(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype13() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = new RandomAccessReadDataStream(
        new ByteArrayInputStream("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));

    // Act
    cmapSubtable.processSubtype13(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    assertEquals(-72340168543109377L, data.readLong());
    assertEquals(16L, data.getCurrentPosition());
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype13(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype132() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    cmapSubtable.processSubtype13(new RandomAccessReadDataStream(inputStream), 0);

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype14(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype14() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    cmapSubtable.processSubtype14(new RandomAccessReadDataStream(inputStream), CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype6(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype6() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedShort()).thenReturn(1);

    // Act
    cmapSubtable.processSubtype6(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data).readUnsignedShortArray(eq(1));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype6(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype62() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedShort()).thenReturn(-1);

    // Act
    cmapSubtable.processSubtype6(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data).readUnsignedShortArray(eq(-1));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype6(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype63() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(0);

    // Act
    cmapSubtable.processSubtype6(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert that nothing has changed
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype4() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.getCurrentPosition()).thenReturn(1L);

    // Act
    cmapSubtable.processSubtype4(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(data).getCurrentPosition();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data, atLeast(1)).readUnsignedShortArray(eq(0));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype42() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(2);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.getCurrentPosition()).thenReturn(1L);

    // Act
    cmapSubtable.processSubtype4(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(data).getCurrentPosition();
    verify(data).seek(eq(2L));
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data, atLeast(1)).readUnsignedShortArray(eq(1));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype43() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(4);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.getCurrentPosition()).thenReturn(1L);

    // Act
    cmapSubtable.processSubtype4(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(data).getCurrentPosition();
    verify(data, atLeast(1)).seek(eq(2L));
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data, atLeast(1)).readUnsignedShortArray(eq(2));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype44() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(2);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{65535, -1, 1, -1});
    when(data.getCurrentPosition()).thenReturn(1L);

    // Act
    cmapSubtable.processSubtype4(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(data).getCurrentPosition();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data, atLeast(1)).readUnsignedShortArray(eq(1));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype45() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(2);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{0, -1, 1, -1});
    when(data.getCurrentPosition()).thenReturn(1L);

    // Act
    cmapSubtable.processSubtype4(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(data).getCurrentPosition();
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data, atLeast(1)).readUnsignedShortArray(eq(1));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype46() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    doThrow(new IOException("foo")).when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(2);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.getCurrentPosition()).thenReturn(1L);

    // Act and Assert
    assertThrows(IOException.class, () -> cmapSubtable.processSubtype4(data, CmapTable.ENCODING_WIN_UNICODE_FULL));
    verify(data).getCurrentPosition();
    verify(data).seek(eq(2L));
    verify(data, atLeast(1)).readUnsignedShort();
    verify(data, atLeast(1)).readUnsignedShortArray(eq(1));
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype2(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype2() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);
    doNothing().when(data).seek(anyLong());

    // Act
    cmapSubtable.processSubtype2(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(data).getCurrentPosition();
    verify(data).seek(eq(0L));
    verify(data).readSignedShort();
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype2(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype22() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn(Short.MIN_VALUE);
    doNothing().when(data).seek(anyLong());

    // Act
    cmapSubtable.processSubtype2(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(data).getCurrentPosition();
    verify(data).seek(eq(0L));
    verify(data).readSignedShort();
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype2(TTFDataStream, int)}
   */
  @Test
  void testProcessSubtype23() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    cmapSubtable.processSubtype2(data, 0);

    // Assert
    verify(data).getCurrentPosition();
    verify(data).readSignedShort();
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Method under test: {@link CmapSubtable#processSubtype0(TTFDataStream)}
   */
  @Test
  void testProcessSubtype0() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    cmapSubtable.processSubtype0(data);

    // Assert
    verify(data).read(eq(256));
  }

  /**
   * Method under test: {@link CmapSubtable#getGlyphId(int)}
   */
  @Test
  void testGetGlyphId() {
    // Arrange, Act and Assert
    assertEquals(0, (new CmapSubtable()).getGlyphId(1));
  }

  /**
   * Method under test: {@link CmapSubtable#getCharCodes(int)}
   */
  @Test
  void testGetCharCodes() {
    // Arrange, Act and Assert
    assertNull((new CmapSubtable()).getCharCodes(1));
    assertNull((new CmapSubtable()).getCharCodes(-1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CmapSubtable#setPlatformEncodingId(int)}
   *   <li>{@link CmapSubtable#setPlatformId(int)}
   *   <li>{@link CmapSubtable#toString()}
   *   <li>{@link CmapSubtable#getPlatformEncodingId()}
   *   <li>{@link CmapSubtable#getPlatformId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();

    // Act
    cmapSubtable.setPlatformEncodingId(1);
    cmapSubtable.setPlatformId(1);
    String actualToStringResult = cmapSubtable.toString();
    int actualPlatformEncodingId = cmapSubtable.getPlatformEncodingId();

    // Assert that nothing has changed
    assertEquals("{1 1}", actualToStringResult);
    assertEquals(1, actualPlatformEncodingId);
    assertEquals(1, cmapSubtable.getPlatformId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CmapSubtable}
   */
  @Test
  void testNewCmapSubtable() {
    // Arrange and Act
    CmapSubtable actualCmapSubtable = new CmapSubtable();

    // Assert
    assertEquals(0, actualCmapSubtable.getPlatformEncodingId());
    assertEquals(0, actualCmapSubtable.getPlatformId());
  }
}
