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
import java.io.DataInputStream;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.Test;

class TTFParserDiffblueTest {
  /**
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  void testParse() throws IOException {
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
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  void testParse2() throws IOException {
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
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  void testParse3() throws IOException {
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
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  void testParse4() throws IOException {
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
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  void testParse5() throws IOException {
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
   * Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  void testParse6() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders2() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders3() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders4() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders5() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders6() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders7() throws IOException {
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
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    OS2WindowsMetricsTable oS2Windows = actualParseTableHeadersResult.getOS2Windows();
    assertEquals(0, oS2Windows.getBreakChar());
    assertEquals(0, oS2Windows.getCapHeight());
    assertEquals(0, oS2Windows.getDefaultChar());
    assertEquals(0, oS2Windows.getHeight());
    assertEquals(0, oS2Windows.getMaxContext());
    assertEquals(1, oS2Windows.getFamilyClass());
    assertEquals(1, oS2Windows.getFirstCharIndex());
    assertEquals(1, oS2Windows.getFsSelection());
    assertEquals(1, oS2Windows.getLastCharIndex());
    assertEquals(1, oS2Windows.getTypoAscender());
    assertEquals(1, oS2Windows.getTypoDescender());
    assertEquals(1, oS2Windows.getTypoLineGap());
    assertEquals(1, oS2Windows.getVersion());
    assertEquals(1, oS2Windows.getWeightClass());
    assertEquals(1, oS2Windows.getWidthClass());
    assertEquals(1, oS2Windows.getWinAscent());
    assertEquals(1, oS2Windows.getWinDescent());
    assertEquals(1L, oS2Windows.getCodePageRange1());
    assertEquals(1L, oS2Windows.getCodePageRange2());
    assertEquals(1L, oS2Windows.getUnicodeRange1());
    assertEquals(1L, oS2Windows.getUnicodeRange2());
    assertEquals(1L, oS2Windows.getUnicodeRange3());
    assertEquals(1L, oS2Windows.getUnicodeRange4());
    assertEquals(1L, oS2Windows.getCheckSum());
    assertEquals(1L, oS2Windows.getLength());
    assertEquals(1L, oS2Windows.getOffset());
    assertEquals((short) 1, oS2Windows.getAverageCharWidth());
    assertEquals((short) 1, oS2Windows.getFsType());
    assertEquals((short) 1, oS2Windows.getStrikeoutPosition());
    assertEquals((short) 1, oS2Windows.getStrikeoutSize());
    assertEquals((short) 1, oS2Windows.getSubscriptXOffset());
    assertEquals((short) 1, oS2Windows.getSubscriptXSize());
    assertEquals((short) 1, oS2Windows.getSubscriptYOffset());
    assertEquals((short) 1, oS2Windows.getSubscriptYSize());
    assertEquals((short) 1, oS2Windows.getSuperscriptXOffset());
    assertEquals((short) 1, oS2Windows.getSuperscriptXSize());
    assertEquals((short) 1, oS2Windows.getSuperscriptYOffset());
    assertEquals((short) 1, oS2Windows.getSuperscriptYSize());
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
    assertTrue(oS2Windows.getInitialized());
    assertEquals(OS2WindowsMetricsTable.TAG, oS2Windows.getAchVendId());
    assertEquals(OS2WindowsMetricsTable.TAG, oS2Windows.getTag());
    byte[] expectedPanose = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPanose, oS2Windows.getPanose());
  }

  /**
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders8() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders9() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders10() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders11() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders12() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders13() throws IOException {
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
    assertEquals("'head' table is mandatory", actualParseTableHeadersResult.getError());
    assertNull(actualParseTableHeadersResult.getNonOtfTableGCID142());
    assertNull(actualParseTableHeadersResult.getHeaderMacStyle());
    assertNull(actualParseTableHeadersResult.getFontFamily());
    assertNull(actualParseTableHeadersResult.getFontSubFamily());
    assertNull(actualParseTableHeadersResult.getName());
    assertNull(actualParseTableHeadersResult.getOtfOrdering());
    assertNull(actualParseTableHeadersResult.getOtfRegistry());
    assertEquals(0, actualParseTableHeadersResult.getOtfSupplement());
    OS2WindowsMetricsTable oS2Windows = actualParseTableHeadersResult.getOS2Windows();
    assertEquals(1, oS2Windows.getCapHeight());
    assertEquals(1, oS2Windows.getFamilyClass());
    assertEquals(1, oS2Windows.getHeight());
    assertEquals(1, oS2Windows.getTypoAscender());
    assertEquals(1, oS2Windows.getTypoDescender());
    assertEquals(1, oS2Windows.getTypoLineGap());
    assertEquals(1L, oS2Windows.getCodePageRange1());
    assertEquals(1L, oS2Windows.getCodePageRange2());
    assertEquals(1L, oS2Windows.getUnicodeRange1());
    assertEquals(1L, oS2Windows.getUnicodeRange2());
    assertEquals(1L, oS2Windows.getUnicodeRange3());
    assertEquals(1L, oS2Windows.getUnicodeRange4());
    assertEquals(1L, oS2Windows.getCheckSum());
    assertEquals(1L, oS2Windows.getLength());
    assertEquals(1L, oS2Windows.getOffset());
    assertEquals((short) 1, oS2Windows.getAverageCharWidth());
    assertEquals((short) 1, oS2Windows.getFsType());
    assertEquals((short) 1, oS2Windows.getStrikeoutPosition());
    assertEquals((short) 1, oS2Windows.getStrikeoutSize());
    assertEquals((short) 1, oS2Windows.getSubscriptXOffset());
    assertEquals((short) 1, oS2Windows.getSubscriptXSize());
    assertEquals((short) 1, oS2Windows.getSubscriptYOffset());
    assertEquals((short) 1, oS2Windows.getSubscriptYSize());
    assertEquals((short) 1, oS2Windows.getSuperscriptXOffset());
    assertEquals((short) 1, oS2Windows.getSuperscriptXSize());
    assertEquals((short) 1, oS2Windows.getSuperscriptYOffset());
    assertEquals((short) 1, oS2Windows.getSuperscriptYSize());
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
    assertFalse(actualParseTableHeadersResult.isOpenTypePostScript());
    assertTrue(oS2Windows.getInitialized());
    assertEquals(OS2WindowsMetricsTable.TAG, oS2Windows.getAchVendId());
    assertEquals(OS2WindowsMetricsTable.TAG, oS2Windows.getTag());
    byte[] expectedPanose = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPanose, oS2Windows.getPanose());
  }

  /**
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders14() throws IOException {
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
   * Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  void testParseTableHeaders15() throws IOException {
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
   * Method under test: {@link TTFParser#newFont(TTFDataStream)}
   */
  @Test
  void testNewFont() throws IOException {
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
   * Method under test: {@link TTFParser#newFont(TTFDataStream)}
   */
  @Test
  void testNewFont2() throws IOException {
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
   * Method under test: {@link TTFParser#newFont(TTFDataStream)}
   */
  @Test
  void testNewFont3() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TrueTypeFont actualNewFontResult = ttfParser.newFont(new RandomAccessReadDataStream(inputStream));

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
   * Method under test: {@link TTFParser#allowCFF()}
   */
  @Test
  void testAllowCFF() {
    // Arrange, Act and Assert
    assertFalse((new TTFParser(true)).allowCFF());
    assertTrue((new OTFParser(true)).allowCFF());
  }

  /**
   * Method under test: {@link TTFParser#readTable(String)}
   */
  @Test
  void testReadTable() {
    // Arrange and Act
    TTFTable actualReadTableResult = (new TTFParser(true)).readTable("Tag");

    // Assert
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Method under test: {@link TTFParser#readTable(String)}
   */
  @Test
  void testReadTable2() {
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
}
