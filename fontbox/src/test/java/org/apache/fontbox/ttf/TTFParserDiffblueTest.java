package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TTFParserDiffblueTest {
  /**
   * Test {@link TTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>When {@link DataInputStream} {@link DataInputStream#read(byte[])} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; given IOException(); when DataInputStream read(byte[]) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TrueTypeFont TTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenIOException_whenDataInputStreamReadThrowIOException()
      throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);

    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException());
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> ttfParser.parse(new RandomAccessReadUnbufferedDataStream(randomAccessRead)));
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link TTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link DataInputStream} {@link DataInputStream#read(byte[])} return one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; given one; when DataInputStream read(byte[]) return one; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TrueTypeFont TTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenOne_whenDataInputStreamReadReturnOne_thenThrowIOException()
      throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);

    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> ttfParser.parse(new RandomAccessReadUnbufferedDataStream(randomAccessRead)));
    verify(inputStream, atLeast(1)).read(Mockito.<byte[]>any());
  }

  /**
   * Test {@link TTFParser#parse(RandomAccessRead)} with {@code randomAccessRead}.
   *
   * <ul>
   *   <li>Given two hundred fifty-five.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parse(RandomAccessRead) with 'randomAccessRead'; given two hundred fifty-five; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TrueTypeFont TTFParser.parse(RandomAccessRead)"})
  void testParseWithRandomAccessRead_givenTwoHundredFiftyFive_thenThrowIOException()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    NonSeekableRandomAccessReadInputStream randomAccessRead =
        mock(NonSeekableRandomAccessReadInputStream.class);
    when(randomAccessRead.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(-1);
    when(randomAccessRead.length()).thenReturn(255L);
    doNothing().when(randomAccessRead).close();

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(randomAccessRead));
    verify(randomAccessRead).close();
    verify(randomAccessRead).length();
    verify(randomAccessRead).read(isA(byte[].class), eq(0), eq(255));
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@link OTFParser#OTFParser(boolean)} with isEmbedded is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parseTableHeaders(TTFDataStream) with 'raf'; given OTFParser(boolean) with isEmbedded is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontHeaders TTFParser.parseTableHeaders(TTFDataStream)"})
  void testParseTableHeadersWithRaf_givenOTFParserWithIsEmbeddedIsTrue() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    DataInputStream inputStream = mock(DataInputStream.class);
    doThrow(new IOException()).when(inputStream).close();
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            otfParser.parseTableHeaders(
                new RandomAccessReadUnbufferedDataStream(randomAccessRead)));
    verify(inputStream, atLeast(1)).read(Mockito.<byte[]>any());
    verify(inputStream).close();
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@link TTFParser#TTFParser(boolean)} with isEmbedded is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parseTableHeaders(TTFDataStream) with 'raf'; given TTFParser(boolean) with isEmbedded is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontHeaders TTFParser.parseTableHeaders(TTFDataStream)"})
  void testParseTableHeadersWithRaf_givenTTFParserWithIsEmbeddedIsFalse() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(false);

    DataInputStream inputStream = mock(DataInputStream.class);
    doNothing().when(inputStream).close();
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act
    FontHeaders actualParseTableHeadersResult =
        ttfParser.parseTableHeaders(new RandomAccessReadUnbufferedDataStream(randomAccessRead));

    // Assert
    verify(inputStream, atLeast(1)).read(Mockito.<byte[]>any());
    verify(inputStream).close();
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
   *
   * <ul>
   *   <li>Then return Error is {@code 'head' table is mandatory}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parseTableHeaders(TTFDataStream) with 'raf'; then return Error is ''head' table is mandatory'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontHeaders TTFParser.parseTableHeaders(TTFDataStream)"})
  void testParseTableHeadersWithRaf_thenReturnErrorIsHeadTableIsMandatory() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);

    DataInputStream inputStream = mock(DataInputStream.class);
    doNothing().when(inputStream).close();
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act
    FontHeaders actualParseTableHeadersResult =
        ttfParser.parseTableHeaders(new RandomAccessReadUnbufferedDataStream(randomAccessRead));

    // Assert
    verify(inputStream, atLeast(1)).read(Mockito.<byte[]>any());
    verify(inputStream).close();
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
   *
   * <ul>
   *   <li>When {@link DataInputStream} {@link DataInputStream#close()} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parseTableHeaders(TTFDataStream) with 'raf'; when DataInputStream close() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontHeaders TTFParser.parseTableHeaders(TTFDataStream)"})
  void testParseTableHeadersWithRaf_whenDataInputStreamCloseThrowIOException() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);

    DataInputStream inputStream = mock(DataInputStream.class);
    doThrow(new IOException()).when(inputStream).close();
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            ttfParser.parseTableHeaders(
                new RandomAccessReadUnbufferedDataStream(randomAccessRead)));
    verify(inputStream, atLeast(1)).read(Mockito.<byte[]>any());
    verify(inputStream).close();
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>When {@link DataInputStream} {@link DataInputStream#read(byte[])} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parseTableHeaders(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parseTableHeaders(TTFDataStream) with 'raf'; when DataInputStream read(byte[]) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontHeaders TTFParser.parseTableHeaders(TTFDataStream)"})
  void testParseTableHeadersWithRaf_whenDataInputStreamReadThrowIOException() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);

    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException());
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            ttfParser.parseTableHeaders(
                new RandomAccessReadUnbufferedDataStream(randomAccessRead)));
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(RandomAccessRead)} with {@code randomAccessRead}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parseTableHeaders(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parseTableHeaders(RandomAccessRead) with 'randomAccessRead'; given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontHeaders TTFParser.parseTableHeaders(RandomAccessRead)"})
  void testParseTableHeadersWithRandomAccessRead_givenIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);

    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException());
    doThrow(new IOException()).when(inputStream).close();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> ttfParser.parseTableHeaders(new NonSeekableRandomAccessReadInputStream(inputStream)));
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream).close();
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(RandomAccessRead)} with {@code randomAccessRead}.
   *
   * <ul>
   *   <li>Given {@link OTFParser#OTFParser(boolean)} with isEmbedded is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parseTableHeaders(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parseTableHeaders(RandomAccessRead) with 'randomAccessRead'; given OTFParser(boolean) with isEmbedded is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontHeaders TTFParser.parseTableHeaders(RandomAccessRead)"})
  void testParseTableHeadersWithRandomAccessRead_givenOTFParserWithIsEmbeddedIsTrue()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(5);
    doNothing().when(inputStream).close();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act
    FontHeaders actualParseTableHeadersResult = otfParser.parseTableHeaders(randomAccessRead);

    // Assert
    verify(inputStream, atLeast(1)).read(Mockito.<byte[]>any());
    verify(inputStream, atLeast(1)).close();
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
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(RandomAccessRead)} with {@code randomAccessRead}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parseTableHeaders(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseTableHeaders(RandomAccessRead) with 'randomAccessRead'; given one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontHeaders TTFParser.parseTableHeaders(RandomAccessRead)"})
  void testParseTableHeadersWithRandomAccessRead_givenOne() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);

    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    doNothing().when(inputStream).close();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(randomAccessRead);

    // Assert
    verify(inputStream, atLeast(1)).read(Mockito.<byte[]>any());
    verify(inputStream, atLeast(1)).close();
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
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link TTFParser#parseTableHeaders(RandomAccessRead)} with {@code randomAccessRead}.
   *
   * <ul>
   *   <li>Given {@link TTFParser#TTFParser(boolean)} with isEmbedded is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#parseTableHeaders(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parseTableHeaders(RandomAccessRead) with 'randomAccessRead'; given TTFParser(boolean) with isEmbedded is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontHeaders TTFParser.parseTableHeaders(RandomAccessRead)"})
  void testParseTableHeadersWithRandomAccessRead_givenTTFParserWithIsEmbeddedIsFalse()
      throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(false);

    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    doNothing().when(inputStream).close();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act
    FontHeaders actualParseTableHeadersResult = ttfParser.parseTableHeaders(randomAccessRead);

    // Assert
    verify(inputStream, atLeast(1)).read(Mockito.<byte[]>any());
    verify(inputStream, atLeast(1)).close();
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
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link TTFParser#newFont(TTFDataStream)}.
   *
   * <ul>
   *   <li>Given {@link OTFParser#OTFParser(boolean)} with isEmbedded is {@code true}.
   *   <li>Then return {@link OpenTypeFont}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#newFont(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test newFont(TTFDataStream); given OTFParser(boolean) with isEmbedded is 'true'; then return OpenTypeFont")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TrueTypeFont TTFParser.newFont(TTFDataStream)"})
  void testNewFont_givenOTFParserWithIsEmbeddedIsTrue_thenReturnOpenTypeFont() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    // Act
    OpenTypeFont actualNewFontResult =
        otfParser.newFont(
            new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

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
    assertEquals(6, actualNewFontResult.getFontMatrix().size());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualNewFontResult.getOriginalData().read(byteArray));
    assertEquals(8L, actualNewFontResult.getOriginalDataSize());
    assertTrue(actualNewFontResult.getTables().isEmpty());
    assertTrue(actualNewFontResult.getTableMap().isEmpty());
    assertTrue(actualNewFontResult.isEnableGsub());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TTFParser#newFont(TTFDataStream)}.
   *
   * <ul>
   *   <li>Given {@link TTFParser#TTFParser(boolean)} with isEmbedded is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#newFont(TTFDataStream)}
   */
  @Test
  @DisplayName("Test newFont(TTFDataStream); given TTFParser(boolean) with isEmbedded is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TrueTypeFont TTFParser.newFont(TTFDataStream)"})
  void testNewFont_givenTTFParserWithIsEmbeddedIsTrue() throws IOException {
    // Arrange
    TTFParser ttfParser = new TTFParser(true);

    // Act
    TrueTypeFont actualNewFontResult =
        ttfParser.newFont(
            new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

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
    assertEquals(6, actualNewFontResult.getFontMatrix().size());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualNewFontResult.getOriginalData().read(byteArray));
    assertEquals(8L, actualNewFontResult.getOriginalDataSize());
    assertTrue(actualNewFontResult.getTables().isEmpty());
    assertTrue(actualNewFontResult.getTableMap().isEmpty());
    assertTrue(actualNewFontResult.isEnableGsub());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TTFParser#allowCFF()}.
   *
   * <ul>
   *   <li>Given {@link OTFParser#OTFParser(boolean)} with isEmbedded is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#allowCFF()}
   */
  @Test
  @DisplayName(
      "Test allowCFF(); given OTFParser(boolean) with isEmbedded is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TTFParser.allowCFF()"})
  void testAllowCFF_givenOTFParserWithIsEmbeddedIsTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new OTFParser(true).allowCFF());
  }

  /**
   * Test {@link TTFParser#allowCFF()}.
   *
   * <ul>
   *   <li>Given {@link TTFParser#TTFParser(boolean)} with isEmbedded is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#allowCFF()}
   */
  @Test
  @DisplayName(
      "Test allowCFF(); given TTFParser(boolean) with isEmbedded is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TTFParser.allowCFF()"})
  void testAllowCFF_givenTTFParserWithIsEmbeddedIsTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TTFParser(true).allowCFF());
  }

  /**
   * Test {@link TTFParser#readTable(String)}.
   *
   * <ul>
   *   <li>Given {@link OTFParser#OTFParser(boolean)} with isEmbedded is {@code true}.
   *   <li>When {@link GlyphSubstitutionTable#TAG}.
   *   <li>Then return {@link OTLTable}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#readTable(String)}
   */
  @Test
  @DisplayName(
      "Test readTable(String); given OTFParser(boolean) with isEmbedded is 'true'; when TAG; then return OTLTable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable TTFParser.readTable(String)"})
  void testReadTable_givenOTFParserWithIsEmbeddedIsTrue_whenTag_thenReturnOTLTable() {
    // Arrange and Act
    TTFTable actualReadTableResult = new OTFParser(true).readTable(GlyphSubstitutionTable.TAG);

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
   *
   * <ul>
   *   <li>Given {@link TTFParser#TTFParser(boolean)} with isEmbedded is {@code true}.
   *   <li>When {@code Tag}.
   * </ul>
   *
   * <p>Method under test: {@link TTFParser#readTable(String)}
   */
  @Test
  @DisplayName(
      "Test readTable(String); given TTFParser(boolean) with isEmbedded is 'true'; when 'Tag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable TTFParser.readTable(String)"})
  void testReadTable_givenTTFParserWithIsEmbeddedIsTrue_whenTag() {
    // Arrange and Act
    TTFTable actualReadTableResult = new TTFParser(true).readTable("Tag");

    // Assert
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }
}
