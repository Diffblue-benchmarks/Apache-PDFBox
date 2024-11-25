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
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CmapSubtableDiffblueTest {
  /**
   * Test {@link CmapSubtable#initData(TTFDataStream)}.
   * <ul>
   *   <li>Then {@link CmapSubtable} (default constructor) PlatformEncodingId is
   * {@code 16728}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#initData(TTFDataStream)}
   */
  @Test
  @DisplayName("Test initData(TTFDataStream); then CmapSubtable (default constructor) PlatformEncodingId is '16728'")
  void testInitData_thenCmapSubtablePlatformEncodingIdIs16728() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();

    // Act
    cmapSubtable.initData(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertEquals(16728, cmapSubtable.getPlatformEncodingId());
    assertEquals(16728, cmapSubtable.getPlatformId());
  }

  /**
   * Test {@link CmapSubtable#initSubtable(CmapTable, int, TTFDataStream)}.
   * <p>
   * Method under test:
   * {@link CmapSubtable#initSubtable(CmapTable, int, TTFDataStream)}
   */
  @Test
  @DisplayName("Test initSubtable(CmapTable, int, TTFDataStream)")
  void testInitSubtable() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    CmapTable cmap = new CmapTable();

    // Act and Assert
    assertThrows(IOException.class, () -> cmapSubtable.initSubtable(cmap, CmapTable.ENCODING_WIN_UNICODE_FULL,
        new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")))));
  }

  /**
   * Test {@link CmapSubtable#initSubtable(CmapTable, int, TTFDataStream)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array
   * of {@code byte} with zero and {@link GlyfDescript#ON_CURVE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CmapSubtable#initSubtable(CmapTable, int, TTFDataStream)}
   */
  @Test
  @DisplayName("Test initSubtable(CmapTable, int, TTFDataStream); when ByteArrayInputStream(byte[]) with array of byte with zero and ON_CURVE")
  void testInitSubtable_whenByteArrayInputStreamWithArrayOfByteWithZeroAndOn_curve() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    CmapTable cmap = new CmapTable();

    // Act and Assert
    assertThrows(IOException.class,
        () -> cmapSubtable.initSubtable(cmap, CmapTable.ENCODING_WIN_UNICODE_FULL,
            new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{0, GlyfDescript.ON_CURVE, 'A', '\b', 'A',
                '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b'}))));
  }

  /**
   * Test {@link CmapSubtable#processSubtype8(TTFDataStream, int)}.
   * <ul>
   *   <li>Given {@code 2147483647}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype8(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype8(TTFDataStream, int); given '2147483647'")
  void testProcessSubtype8_given2147483647() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedInt()).thenReturn(2147483647L);

    // Act and Assert
    assertThrows(IOException.class, () -> cmapSubtable.processSubtype8(data, CmapTable.ENCODING_WIN_UNICODE_FULL));
    verify(data).readUnsignedByteArray(eq(8192));
    verify(data).readUnsignedInt();
  }

  /**
   * Test {@link CmapSubtable#processSubtype8(TTFDataStream, int)}.
   * <ul>
   *   <li>Given array of {@code int} with minus one and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype8(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype8(TTFDataStream, int); given array of int with minus one and minus one")
  void testProcessSubtype8_givenArrayOfIntWithMinusOneAndMinusOne() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{-1, -1, 1, -1});
    when(data.readUnsignedInt()).thenReturn(1L);

    // Act
    cmapSubtable.processSubtype8(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(data).readUnsignedByteArray(eq(8192));
    verify(data, atLeast(1)).readUnsignedInt();
  }

  /**
   * Test {@link CmapSubtable#processSubtype8(TTFDataStream, int)}.
   * <ul>
   *   <li>Given empty array of {@code int}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype8(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype8(TTFDataStream, int); given empty array of int")
  void testProcessSubtype8_givenEmptyArrayOfInt() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{});
    when(data.readUnsignedInt()).thenReturn(1L);

    // Act and Assert
    assertThrows(IOException.class, () -> cmapSubtable.processSubtype8(data, CmapTable.ENCODING_WIN_UNICODE_FULL));
    verify(data).readUnsignedByteArray(eq(8192));
    verify(data, atLeast(1)).readUnsignedInt();
  }

  /**
   * Test {@link CmapSubtable#processSubtype8(TTFDataStream, int)}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype8(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype8(TTFDataStream, int); given one")
  void testProcessSubtype8_givenOne() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedInt()).thenReturn(1L);

    // Act
    cmapSubtable.processSubtype8(data, CmapTable.ENCODING_WIN_UNICODE_FULL);

    // Assert
    verify(data).readUnsignedByteArray(eq(8192));
    verify(data, atLeast(1)).readUnsignedInt();
  }

  /**
   * Test {@link CmapSubtable#processSubtype8(TTFDataStream, int)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When zero.</li>
   *   <li>Then calls {@link TTFDataStream#readUnsignedByteArray(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype8(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype8(TTFDataStream, int); given one; when zero; then calls readUnsignedByteArray(int)")
  void testProcessSubtype8_givenOne_whenZero_thenCallsReadUnsignedByteArray() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedInt()).thenReturn(1L);

    // Act
    cmapSubtable.processSubtype8(data, 0);

    // Assert
    verify(data).readUnsignedByteArray(eq(8192));
    verify(data).readUnsignedInt();
  }

  /**
   * Test {@link CmapSubtable#processSubtype8(TTFDataStream, int)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype8(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype8(TTFDataStream, int); given ten; when one; then throw IOException")
  void testProcessSubtype8_givenTen_whenOne_thenThrowIOException() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedInt()).thenReturn(10L);

    // Act and Assert
    assertThrows(IOException.class, () -> cmapSubtable.processSubtype8(data, 1));
    verify(data).readUnsignedByteArray(eq(8192));
    verify(data, atLeast(1)).readUnsignedInt();
  }

  /**
   * Test {@link CmapSubtable#processSubtype10(TTFDataStream, int)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype10(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype10(TTFDataStream, int); when 'A'; then throw IOException")
  void testProcessSubtype10_whenA_thenThrowIOException() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();

    // Act and Assert
    assertThrows(IOException.class,
        () -> cmapSubtable.processSubtype10(
            new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', -1, 'X', 'A', 'X'})),
            CmapTable.ENCODING_WIN_UNICODE_FULL));
  }

  /**
   * Test {@link CmapSubtable#processSubtype10(TTFDataStream, int)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype10(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype10(TTFDataStream, int); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testProcessSubtype10_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();

    // Act and Assert
    assertThrows(IOException.class,
        () -> cmapSubtable.processSubtype10(
            new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))),
            CmapTable.ENCODING_WIN_UNICODE_FULL));
  }

  /**
   * Test {@link CmapSubtable#processSubtype12(TTFDataStream, int)}.
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype12(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype12(TTFDataStream, int)")
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
   * Test {@link CmapSubtable#processSubtype12(TTFDataStream, int)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype12(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype12(TTFDataStream, int); when 'A'; then throw IOException")
  void testProcessSubtype12_whenA_thenThrowIOException() throws IOException {
    // Arrange
    CmapSubtable cmapSubtable = new CmapSubtable();

    // Act and Assert
    assertThrows(IOException.class,
        () -> cmapSubtable.processSubtype12(
            new RandomAccessReadDataStream(new ByteArrayInputStream(
                new byte[]{'A', '\b', 'A', '\b', 0, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b'})),
            CmapTable.ENCODING_WIN_UNICODE_FULL));
  }

  /**
   * Test {@link CmapSubtable#processSubtype13(TTFDataStream, int)}.
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype13(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype13(TTFDataStream, int)")
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
   * Test {@link CmapSubtable#processSubtype6(TTFDataStream, int)}.
   * <ul>
   *   <li>Given minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype6(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype6(TTFDataStream, int); given minus one")
  void testProcessSubtype6_givenMinusOne() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype6(TTFDataStream, int)}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype6(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype6(TTFDataStream, int); given zero")
  void testProcessSubtype6_givenZero() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype6(TTFDataStream, int)}.
   * <ul>
   *   <li>Then calls {@link TTFDataStream#readUnsignedShortArray(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype6(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype6(TTFDataStream, int); then calls readUnsignedShortArray(int)")
  void testProcessSubtype6_thenCallsReadUnsignedShortArray() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype4(TTFDataStream, int)}.
   * <ul>
   *   <li>Given array of {@code int} with {@code 65535} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype4(TTFDataStream, int); given array of int with '65535' and minus one")
  void testProcessSubtype4_givenArrayOfIntWith65535AndMinusOne() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype4(TTFDataStream, int)}.
   * <ul>
   *   <li>Given array of {@code int} with zero and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype4(TTFDataStream, int); given array of int with zero and minus one")
  void testProcessSubtype4_givenArrayOfIntWithZeroAndMinusOne() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype4(TTFDataStream, int)}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype4(TTFDataStream, int); given four")
  void testProcessSubtype4_givenFour() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype4(TTFDataStream, int)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype4(TTFDataStream, int); given IOException(String) with 'foo'; then throw IOException")
  void testProcessSubtype4_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype4(TTFDataStream, int)}.
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream}
   * {@link TTFDataStream#readUnsignedShort()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype4(TTFDataStream, int); when RandomAccessReadDataStream readUnsignedShort() return one")
  void testProcessSubtype4_whenRandomAccessReadDataStreamReadUnsignedShortReturnOne() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype4(TTFDataStream, int)}.
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream}
   * {@link RandomAccessReadDataStream#seek(long)} does nothing.</li>
   *   <li>Then calls {@link RandomAccessReadDataStream#seek(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype4(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype4(TTFDataStream, int); when RandomAccessReadDataStream seek(long) does nothing; then calls seek(long)")
  void testProcessSubtype4_whenRandomAccessReadDataStreamSeekDoesNothing_thenCallsSeek() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype2(TTFDataStream, int)}.
   * <ul>
   *   <li>Given {@link CmapSubtable} (default constructor).</li>
   *   <li>When zero.</li>
   *   <li>Then calls {@link RandomAccessReadDataStream#getCurrentPosition()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype2(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype2(TTFDataStream, int); given CmapSubtable (default constructor); when zero; then calls getCurrentPosition()")
  void testProcessSubtype2_givenCmapSubtable_whenZero_thenCallsGetCurrentPosition() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype2(TTFDataStream, int)}.
   * <ul>
   *   <li>Given {@link Short#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype2(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype2(TTFDataStream, int); given MIN_VALUE")
  void testProcessSubtype2_givenMin_value() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype2(TTFDataStream, int)}.
   * <ul>
   *   <li>Then calls {@link RandomAccessReadDataStream#seek(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype2(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test processSubtype2(TTFDataStream, int); then calls seek(long)")
  void testProcessSubtype2_thenCallsSeek() throws IOException {
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
   * Test {@link CmapSubtable#processSubtype0(TTFDataStream)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then calls {@link TTFDataStream#read(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#processSubtype0(TTFDataStream)}
   */
  @Test
  @DisplayName("Test processSubtype0(TTFDataStream); given 'AXAXAXAX' Bytes is 'UTF-8'; then calls read(int)")
  void testProcessSubtype0_givenAxaxaxaxBytesIsUtf8_thenCallsRead() throws IOException {
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test {@link CmapSubtable#getGlyphId(int)}.
   * <p>
   * Method under test: {@link CmapSubtable#getGlyphId(int)}
   */
  @Test
  @DisplayName("Test getGlyphId(int)")
  void testGetGlyphId() {
    // Arrange, Act and Assert
    assertEquals(0, (new CmapSubtable()).getGlyphId(1));
  }

  /**
   * Test {@link CmapSubtable#getCharCodes(int)}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#getCharCodes(int)}
   */
  @Test
  @DisplayName("Test getCharCodes(int); when minus one")
  void testGetCharCodes_whenMinusOne() {
    // Arrange, Act and Assert
    assertNull((new CmapSubtable()).getCharCodes(-1));
  }

  /**
   * Test {@link CmapSubtable#getCharCodes(int)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmapSubtable#getCharCodes(int)}
   */
  @Test
  @DisplayName("Test getCharCodes(int); when one")
  void testGetCharCodes_whenOne() {
    // Arrange, Act and Assert
    assertNull((new CmapSubtable()).getCharCodes(1));
  }

  /**
   * Test new {@link CmapSubtable} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CmapSubtable}
   */
  @Test
  @DisplayName("Test new CmapSubtable (default constructor)")
  void testNewCmapSubtable() {
    // Arrange and Act
    CmapSubtable actualCmapSubtable = new CmapSubtable();

    // Assert
    assertEquals(0, actualCmapSubtable.getPlatformEncodingId());
    assertEquals(0, actualCmapSubtable.getPlatformId());
  }
}
