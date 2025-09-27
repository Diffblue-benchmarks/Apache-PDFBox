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
import java.nio.charset.Charset;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OTFParserDiffblueTest {
  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@code CFF2}.
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readString(int)} return {@code CFF2}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; given 'CFF2'; when RandomAccessReadDataStream readString(int) return 'CFF2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenCff2_whenRandomAccessReadDataStreamReadStringReturnCff2()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn("CFF2");
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(1L);
    verify(raf).read32Fixed();
    verify(raf).readString(4);
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readString(int)} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; given 'foo'; when RandomAccessReadDataStream readString(int) return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenFoo_whenRandomAccessReadDataStreamReadStringReturnFoo()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn("foo");
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(1L);
    verify(raf).read32Fixed();
    verify(raf).readString(4);
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given minus one.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parse(TTFDataStream) with 'raf'; given minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenMinusOne() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getOriginalDataSize()).thenReturn(-1L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(CmapTable.TAG);
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf, atLeast(1)).getOriginalDataSize();
    verify(raf).read32Fixed();
    verify(raf).readString(4);
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@link GlyphTable#TAG}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName("Test parse(TTFDataStream) with 'raf'; given TAG")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenTag() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.read(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(0L);
    when(raf.readString(anyInt())).thenReturn(GlyphTable.TAG);
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(anyLong());
    verify(raf).read(0);
    verify(raf).read32Fixed();
    verify(raf).readString(4);
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@link HeaderTable#TAG}.
   *   <li>Then calls {@link RandomAccessReadDataStream#readInternationalDate()}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; given TAG; then calls readInternationalDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenTag_thenCallsReadInternationalDate() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readInternationalDate()).thenReturn(new GregorianCalendar(1, 1, 1));
    when(raf.readSignedShort()).thenReturn((short) 1);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(HeaderTable.TAG);
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(1L);
    verify(raf, atLeast(1)).read32Fixed();
    verify(raf, atLeast(1)).readInternationalDate();
    verify(raf, atLeast(1)).readSignedShort();
    verify(raf).readString(4);
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@link NamingTable#TAG}.
   *   <li>Then calls {@link RandomAccessReadDataStream#readString(int, Charset)}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; given TAG; then calls readString(int, Charset)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenTag_thenCallsReadString() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readString(anyInt(), Mockito.<Charset>any())).thenReturn(CmapTable.TAG);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(NamingTable.TAG);
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(anyLong());
    verify(raf).read32Fixed();
    verify(raf).readString(4);
    verify(raf).readString(eq(1), isA(Charset.class));
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@link MaximumProfileTable#TAG}.
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readString(int)} return {@link MaximumProfileTable#TAG}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; given TAG; when RandomAccessReadDataStream readString(int) return TAG")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenTag_whenRandomAccessReadDataStreamReadStringReturnTag()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(MaximumProfileTable.TAG);
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(1L);
    verify(raf, atLeast(1)).read32Fixed();
    verify(raf).readString(4);
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@link GlyphTable#TAG}.
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readString(int)} return {@link GlyphTable#TAG}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; given TAG; when RandomAccessReadDataStream readString(int) return TAG")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenTag_whenRandomAccessReadDataStreamReadStringReturnTag2()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.read(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(GlyphTable.TAG);
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(1L);
    verify(raf).read(1);
    verify(raf).read32Fixed();
    verify(raf).readString(4);
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@link HorizontalHeaderTable#TAG}.
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readString(int)} return {@link HorizontalHeaderTable#TAG}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; given TAG; when RandomAccessReadDataStream readString(int) return TAG")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenTag_whenRandomAccessReadDataStreamReadStringReturnTag3()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readSignedShort()).thenReturn((short) 1);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(HorizontalHeaderTable.TAG);
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(1L);
    verify(raf, atLeast(1)).read32Fixed();
    verify(raf, atLeast(1)).readSignedShort();
    verify(raf).readString(4);
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@link OS2WindowsMetricsTable#TAG}.
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readString(int)} return {@link OS2WindowsMetricsTable#TAG}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; given TAG; when RandomAccessReadDataStream readString(int) return TAG")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenTag_whenRandomAccessReadDataStreamReadStringReturnTag4()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readSignedShort()).thenReturn((short) 1);
    when(raf.read(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(OS2WindowsMetricsTable.TAG);
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).getCurrentPosition();
    verify(raf).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(1L);
    verify(raf).read(10);
    verify(raf).read32Fixed();
    verify(raf, atLeast(1)).readSignedShort();
    verify(raf, atLeast(1)).readString(4);
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>Given {@link PostScriptTable#TAG}.
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readString(int)} return {@link PostScriptTable#TAG}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; given TAG; when RandomAccessReadDataStream readString(int) return TAG")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_givenTag_whenRandomAccessReadDataStreamReadStringReturnTag5()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readSignedShort()).thenReturn((short) 1);
    when(raf.getCurrentPosition()).thenReturn(1L);
    doNothing().when(raf).seek(anyLong());
    when(raf.getOriginalDataSize()).thenReturn(3L);
    when(raf.readUnsignedInt()).thenReturn(1L);
    when(raf.readString(anyInt())).thenReturn(PostScriptTable.TAG);
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf, atLeast(1)).getCurrentPosition();
    verify(raf, atLeast(1)).getOriginalDataSize();
    verify(raf, atLeast(1)).seek(1L);
    verify(raf, atLeast(1)).read32Fixed();
    verify(raf, atLeast(1)).readSignedShort();
    verify(raf).readString(4);
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readString(int)} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; when RandomAccessReadDataStream readString(int) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_whenRandomAccessReadDataStreamReadStringThrowIOException()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readString(anyInt())).thenThrow(new IOException());
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).read32Fixed();
    verify(raf).readString(4);
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedInt()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; when RandomAccessReadDataStream readUnsignedInt() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_whenRandomAccessReadDataStreamReadUnsignedIntReturnZero()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readUnsignedInt()).thenReturn(0L);
    when(raf.readString(anyInt())).thenReturn(CmapTable.TAG);
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).read32Fixed();
    verify(raf).readString(4);
    verify(raf, atLeast(1)).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedInt()} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; when RandomAccessReadDataStream readUnsignedInt() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_whenRandomAccessReadDataStreamReadUnsignedIntThrowIOException()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readUnsignedInt()).thenThrow(new IOException());
    when(raf.readString(anyInt())).thenReturn(CmapTable.TAG);
    when(raf.readUnsignedShort()).thenReturn(1);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).read32Fixed();
    verify(raf).readString(4);
    verify(raf).readUnsignedInt();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#parse(TTFDataStream)} with {@code raf}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedShort()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#parse(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test parse(TTFDataStream) with 'raf'; when RandomAccessReadDataStream readUnsignedShort() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.parse(TTFDataStream)"})
  void testParseWithRaf_whenRandomAccessReadDataStreamReadUnsignedShortReturnZero()
      throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    RandomAccessReadDataStream raf = mock(RandomAccessReadDataStream.class);
    when(raf.readUnsignedShort()).thenReturn(0);
    when(raf.read32Fixed()).thenReturn(10.0f);

    // Act and Assert
    assertThrows(IOException.class, () -> otfParser.parse(raf));
    verify(raf).read32Fixed();
    verify(raf, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link OTFParser#newFont(TTFDataStream)}.
   *
   * <p>Method under test: {@link OTFParser#newFont(TTFDataStream)}
   */
  @Test
  @DisplayName("Test newFont(TTFDataStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenTypeFont OTFParser.newFont(TTFDataStream)"})
  void testNewFont() throws IOException {
    // Arrange
    OTFParser otfParser = new OTFParser(true);

    // Act
    OpenTypeFont actualNewFontResult =
        otfParser.newFont(
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
   * Test {@link OTFParser#readTable(String)}.
   *
   * <ul>
   *   <li>When {@code BASE}.
   *   <li>Then return {@link OTLTable}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when 'BASE'; then return OTLTable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable OTFParser.readTable(String)"})
  void testReadTable_whenBase_thenReturnOTLTable() {
    // Arrange and Act
    TTFTable actualReadTableResult = new OTFParser(true).readTable("BASE");

    // Assert
    assertTrue(actualReadTableResult instanceof OTLTable);
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   *
   * <ul>
   *   <li>When {@code GDEF}.
   *   <li>Then return {@link OTLTable}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when 'GDEF'; then return OTLTable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable OTFParser.readTable(String)"})
  void testReadTable_whenGdef_thenReturnOTLTable() {
    // Arrange and Act
    TTFTable actualReadTableResult = new OTFParser(true).readTable("GDEF");

    // Assert
    assertTrue(actualReadTableResult instanceof OTLTable);
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   *
   * <ul>
   *   <li>When {@code GPOS}.
   *   <li>Then return {@link OTLTable}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when 'GPOS'; then return OTLTable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable OTFParser.readTable(String)"})
  void testReadTable_whenGpos_thenReturnOTLTable() {
    // Arrange and Act
    TTFTable actualReadTableResult = new OTFParser(true).readTable("GPOS");

    // Assert
    assertTrue(actualReadTableResult instanceof OTLTable);
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   *
   * <ul>
   *   <li>When {@code Tag}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when 'Tag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable OTFParser.readTable(String)"})
  void testReadTable_whenTag() {
    // Arrange and Act
    TTFTable actualReadTableResult = new OTFParser(true).readTable("Tag");

    // Assert
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   *
   * <ul>
   *   <li>When {@link CFFTable#TAG}.
   *   <li>Then return {@link CFFTable}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when TAG; then return CFFTable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable OTFParser.readTable(String)"})
  void testReadTable_whenTag_thenReturnCFFTable() {
    // Arrange and Act
    TTFTable actualReadTableResult = new OTFParser(true).readTable(CFFTable.TAG);

    // Assert
    assertTrue(actualReadTableResult instanceof CFFTable);
    assertNull(actualReadTableResult.getTag());
    assertNull(((CFFTable) actualReadTableResult).getFont());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#readTable(String)}.
   *
   * <ul>
   *   <li>When {@link GlyphSubstitutionTable#TAG}.
   *   <li>Then return {@link OTLTable}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when TAG; then return OTLTable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable OTFParser.readTable(String)"})
  void testReadTable_whenTag_thenReturnOTLTable() {
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
   * Test {@link OTFParser#readTable(String)}.
   *
   * <ul>
   *   <li>When {@link OTLTable#TAG}.
   *   <li>Then return {@link OTLTable}.
   * </ul>
   *
   * <p>Method under test: {@link OTFParser#readTable(String)}
   */
  @Test
  @DisplayName("Test readTable(String); when TAG; then return OTLTable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TTFTable OTFParser.readTable(String)"})
  void testReadTable_whenTag_thenReturnOTLTable2() {
    // Arrange and Act
    TTFTable actualReadTableResult = new OTFParser(true).readTable(OTLTable.TAG);

    // Assert
    assertTrue(actualReadTableResult instanceof OTLTable);
    assertNull(actualReadTableResult.getTag());
    assertEquals(0L, actualReadTableResult.getCheckSum());
    assertEquals(0L, actualReadTableResult.getLength());
    assertEquals(0L, actualReadTableResult.getOffset());
    assertFalse(actualReadTableResult.getInitialized());
  }

  /**
   * Test {@link OTFParser#allowCFF()}.
   *
   * <p>Method under test: {@link OTFParser#allowCFF()}
   */
  @Test
  @DisplayName("Test allowCFF()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OTFParser.allowCFF()"})
  void testAllowCFF() {
    // Arrange, Act and Assert
    assertTrue(new OTFParser(true).allowCFF());
  }
}
