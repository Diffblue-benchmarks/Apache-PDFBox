package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TTFParserDiffblueTest {
  /**
   * Test {@link TTFParser#parse(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with
   * {@link CFFTable#TAG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parse(TTFDataStream) with 'raf'; given IOException(String) with TAG")
  void testParseWithRaf_givenIOExceptionWithTag() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getCurrentPosition()).thenThrow(new IOException(CFFTable.TAG));
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn("String");
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ttfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link TTFParser#parse(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parse(TTFDataStream) with 'raf'; given 'String'")
  void testParseWithRaf_givenString() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(-1L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn("String");
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ttfParser.parse(raf));
    verify(raf, atLeast(1)).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link TTFParser#parse(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>Then calls {@link RandomAccessReadDataStream#seek(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parse(TTFDataStream) with 'raf'; given 'String'; then calls seek(long)")
  void testParseWithRaf_givenString_thenCallsSeek() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn("String");
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ttfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(eq(1L));
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link TTFParser#parse(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@link HorizontalHeaderTable#TAG}.</li>
   *   <li>When {@link RandomAccessReadDataStream}
   * {@link TTFDataStream#readString(int)} return
   * {@link HorizontalHeaderTable#TAG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parse(TTFDataStream) with 'raf'; given TAG; when RandomAccessReadDataStream readString(int) return TAG")
  void testParseWithRaf_givenTag_whenRandomAccessReadDataStreamReadStringReturnTag() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readSignedShort()).thenReturn((short) 1);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(HorizontalHeaderTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ttfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(eq(1L));
    verify(raf, atLeast(1)).read32Fixed();
    verify(raf, atLeast(1)).readSignedShort();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link TTFParser#parse(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parse(TTFDataStream) with 'raf'; given zero")
  void testParseWithRaf_givenZero() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readUnsignedInt()).thenReturn(0L);
    when(raf.readString(anyInt())).thenReturn("String");
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ttfParser.parse(raf));
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link TTFParser#parse(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Then calls {@link TTFDataStream#readInternationalDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parse(TTFDataStream) with 'raf'; then calls readInternationalDate()")
  void testParseWithRaf_thenCallsReadInternationalDate() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readInternationalDate()).thenReturn(new GregorianCalendar(1, 1, 1));
    when(raf.readSignedShort()).thenReturn((short) 1);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(HeaderTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ttfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(eq(1L));
    verify(raf, atLeast(1)).read32Fixed();
    verify(raf, atLeast(1)).readInternationalDate();
    verify(raf, atLeast(1)).readSignedShort();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link TTFParser#parse(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream}
   * {@link TTFDataStream#readUnsignedShort()} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parse(TTFDataStream) with 'raf'; when RandomAccessReadDataStream readUnsignedShort() return minus one")
  void testParseWithRaf_whenRandomAccessReadDataStreamReadUnsignedShortReturnMinusOne() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(-1);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).read32Fixed();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'")
  void testParseTableHeadersWithRaf() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(CFFTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("True Type fonts using CFF outlines are not supported", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given four.</li>
   *   <li>Then return OS2Windows CapHeight is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given four; then return OS2Windows CapHeight is one")
  void testParseTableHeadersWithRaf_givenFour_thenReturnOS2WindowsCapHeightIsOne() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.read(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(raf.readSignedShort()).thenReturn((short) 1);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(OS2WindowsMetricsTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(4);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getCurrentPosition();
    verify(raf, atLeast(1)).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(eq(1L));
    verify(raf).read(eq(10));
    verify(raf).read32Fixed();
    verify(raf, atLeast(1)).readSignedShort();
    verify(raf, atLeast(1)).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    OS2WindowsMetricsTable oS2Windows = actualParseTableHeadersResult.getOS2Windows();
    assertEquals(1, oS2Windows.getCapHeight());
    assertEquals(1, oS2Windows.getHeight());
    assertEquals(4, oS2Windows.getBreakChar());
    assertEquals(4, oS2Windows.getDefaultChar());
    assertEquals(4, oS2Windows.getFirstCharIndex());
    assertEquals(4, oS2Windows.getFsSelection());
    assertEquals(4, oS2Windows.getLastCharIndex());
    assertEquals(4, oS2Windows.getMaxContext());
    assertEquals(4, oS2Windows.getVersion());
    assertEquals(4, oS2Windows.getWeightClass());
    assertEquals(4, oS2Windows.getWidthClass());
    assertEquals(4, oS2Windows.getWinAscent());
    assertEquals(4, oS2Windows.getWinDescent());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@code gcid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given 'gcid'")
  void testParseTableHeadersWithRaf_givenGcid() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn("gcid");
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given minus one")
  void testParseTableHeadersWithRaf_givenMinusOne() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(-1L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn("String");
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf, atLeast(1)).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given 'String'")
  void testParseTableHeadersWithRaf_givenString() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn("String");
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@link TTFParser#TTFParser(boolean)} with isEmbedded is
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given TTFParser(boolean) with isEmbedded is 'false'")
  void testParseTableHeadersWithRaf_givenTTFParserWithIsEmbeddedIsFalse() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(false);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn("String");
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@link NamingTable#TAG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given TAG")
  void testParseTableHeadersWithRaf_givenTag() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(NamingTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(eq(1L));
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@link HorizontalHeaderTable#TAG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given TAG")
  void testParseTableHeadersWithRaf_givenTag2() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(HorizontalHeaderTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@link MaximumProfileTable#TAG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given TAG")
  void testParseTableHeadersWithRaf_givenTag3() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(MaximumProfileTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@link IndexToLocationTable#TAG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given TAG")
  void testParseTableHeadersWithRaf_givenTag4() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(IndexToLocationTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@link GlyphTable#TAG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given TAG")
  void testParseTableHeadersWithRaf_givenTag5() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(GlyphTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@link HorizontalMetricsTable#TAG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given TAG")
  void testParseTableHeadersWithRaf_givenTag6() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(HorizontalMetricsTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given {@link HeaderTable#TAG}.</li>
   *   <li>Then return Error is {@code 'hhea' table is mandatory}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given TAG; then return Error is ''hhea' table is mandatory'")
  void testParseTableHeadersWithRaf_givenTag_thenReturnErrorIsHheaTableIsMandatory() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(HeaderTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf, atLeast(1)).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(anyLong());
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'hhea' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertEquals(1, actualParseTableHeadersResult.getHeaderMacStyle().intValue());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; given zero")
  void testParseTableHeadersWithRaf_givenZero() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readUnsignedInt()).thenReturn(0L);
    when(raf.readString(anyInt())).thenReturn("String");
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).read32Fixed();
    verify(raf).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertNull(actualParseTableHeadersResult.getOS2Windows());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   * <ul>
   *   <li>Then return OS2Windows BreakChar is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(TTFDataStream) with 'raf'; then return OS2Windows BreakChar is zero")
  void testParseTableHeadersWithRaf_thenReturnOS2WindowsBreakCharIsZero() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.read(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(raf.readSignedShort()).thenReturn((short) 1);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(OS2WindowsMetricsTable.TAG);
    when(raf.read32Fixed()).thenReturn(10.0f);
    when(raf.readUnsignedShort()).thenReturn(1);
    doNothing().when(raf).close();

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(raf);

    // Assert
    verify(raf).close();
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(eq(1L));
    verify(raf).read(eq(10));
    verify(raf).read32Fixed();
    verify(raf, atLeast(1)).readSignedShort();
    verify(raf, atLeast(1)).readString(eq(4));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
    OS2WindowsMetricsTable oS2Windows = actualParseTableHeadersResult.getOS2Windows();
    assertEquals(0, oS2Windows.getBreakChar());
    assertEquals(0, oS2Windows.getCapHeight());
    assertEquals(0, oS2Windows.getDefaultChar());
    assertEquals(0, oS2Windows.getHeight());
    assertEquals(0, oS2Windows.getMaxContext());
    assertEquals(1, oS2Windows.getFirstCharIndex());
    assertEquals(1, oS2Windows.getFsSelection());
    assertEquals(1, oS2Windows.getLastCharIndex());
    assertEquals(1, oS2Windows.getVersion());
    assertEquals(1, oS2Windows.getWeightClass());
    assertEquals(1, oS2Windows.getWidthClass());
    assertEquals(1, oS2Windows.getWinAscent());
    assertEquals(1, oS2Windows.getWinDescent());
  }

  /**
   * Test {@link TTFParser#newFont(TTFDataStream)}.
   * <ul>
   *   <li>Given {@link OTFParser#OTFParser(boolean)} with isEmbedded is
   * {@code true}.</li>
   *   <li>Then return {@link OpenTypeFont}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#newFont(TTFDataStream)}
   */
  @Test
  @DisplayName("Test newFont(TTFDataStream); given OTFParser(boolean) with isEmbedded is 'true'; then return OpenTypeFont")
  void testNewFont_givenOTFParserWithIsEmbeddedIsTrue_thenReturnOpenTypeFont() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    // Act
    OpenTypeFont actualNewFontResult = otfParser
        .newFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertTrue(actualNewFontResult instanceof OpenTypeFont);
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
   * Test {@link TTFParser#newFont(TTFDataStream)}.
   * <ul>
   *   <li>Given {@link TTFParser#TTFParser(boolean)} with isEmbedded is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#newFont(TTFDataStream)}
   */
  @Test
  @DisplayName("Test newFont(TTFDataStream); given TTFParser(boolean) with isEmbedded is 'true'")
  void testNewFont_givenTTFParserWithIsEmbeddedIsTrue() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);

    // Act
    TrueTypeFont actualNewFontResult = ttfParser
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
   * Test {@link TTFParser#allowCFF()}.
   * <ul>
   *   <li>Given {@link OTFParser#OTFParser(boolean)} with isEmbedded is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#allowCFF()}
   */
  @Test
  @DisplayName("Test allowCFF(); given OTFParser(boolean) with isEmbedded is 'true'; then return 'true'")
  void testAllowCFF_givenOTFParserWithIsEmbeddedIsTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new OTFParser(true)).allowCFF());
  }

  /**
   * Test {@link TTFParser#allowCFF()}.
   * <ul>
   *   <li>Given {@link TTFParser#TTFParser(boolean)} with isEmbedded is
   * {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#allowCFF()}
   */
  @Test
  @DisplayName("Test allowCFF(); given TTFParser(boolean) with isEmbedded is 'true'; then return 'false'")
  void testAllowCFF_givenTTFParserWithIsEmbeddedIsTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TTFParser(true)).allowCFF());
  }

  /**
   * Test {@link TTFParser#readTable(String)}.
   * <ul>
   *   <li>Given {@link OTFParser#OTFParser(boolean)} with isEmbedded is
   * {@code true}.</li>
   *   <li>When {@link GlyphSubstitutionTable#TAG}.</li>
   *   <li>Then return {@link OTLTable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); given OTFParser(boolean) with isEmbedded is 'true'; when TAG; then return OTLTable")
  void testReadTable_givenOTFParserWithIsEmbeddedIsTrue_whenTag_thenReturnOTLTable() {
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
   * Test {@link TTFParser#readTable(String)}.
   * <ul>
   *   <li>Given {@link TTFParser#TTFParser(boolean)} with isEmbedded is
   * {@code true}.</li>
   *   <li>When {@code Tag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); given TTFParser(boolean) with isEmbedded is 'true'; when 'Tag'")
  void testReadTable_givenTTFParserWithIsEmbeddedIsTrue_whenTag() {
    // Arrange and Act
    TTFTable actualReadTableResult = (new TTFParser(true)).readTable("Tag");

    // Assert
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }
}
