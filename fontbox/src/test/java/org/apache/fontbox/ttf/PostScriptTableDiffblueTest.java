package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
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

class PostScriptTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PostScriptTable}
   *   <li>{@link PostScriptTable#setFormatType(float)}
   *   <li>{@link PostScriptTable#setGlyphNames(String[])}
   *   <li>{@link PostScriptTable#setIsFixedPitch(long)}
   *   <li>{@link PostScriptTable#setItalicAngle(float)}
   *   <li>{@link PostScriptTable#setMaxMemType1(long)}
   *   <li>{@link PostScriptTable#setMaxMemType42(long)}
   *   <li>{@link PostScriptTable#setMimMemType1(long)}
   *   <li>{@link PostScriptTable#setMinMemType42(long)}
   *   <li>{@link PostScriptTable#setUnderlinePosition(short)}
   *   <li>{@link PostScriptTable#setUnderlineThickness(short)}
   *   <li>{@link PostScriptTable#getFormatType()}
   *   <li>{@link PostScriptTable#getGlyphNames()}
   *   <li>{@link PostScriptTable#getIsFixedPitch()}
   *   <li>{@link PostScriptTable#getItalicAngle()}
   *   <li>{@link PostScriptTable#getMaxMemType1()}
   *   <li>{@link PostScriptTable#getMaxMemType42()}
   *   <li>{@link PostScriptTable#getMinMemType1()}
   *   <li>{@link PostScriptTable#getMinMemType42()}
   *   <li>{@link PostScriptTable#getUnderlinePosition()}
   *   <li>{@link PostScriptTable#getUnderlineThickness()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PostScriptTable.<init>()",
    "float PostScriptTable.getFormatType()",
    "String[] PostScriptTable.getGlyphNames()",
    "long PostScriptTable.getIsFixedPitch()",
    "float PostScriptTable.getItalicAngle()",
    "long PostScriptTable.getMaxMemType1()",
    "long PostScriptTable.getMaxMemType42()",
    "long PostScriptTable.getMinMemType1()",
    "long PostScriptTable.getMinMemType42()",
    "short PostScriptTable.getUnderlinePosition()",
    "short PostScriptTable.getUnderlineThickness()",
    "void PostScriptTable.setFormatType(float)",
    "void PostScriptTable.setGlyphNames(String[])",
    "void PostScriptTable.setIsFixedPitch(long)",
    "void PostScriptTable.setItalicAngle(float)",
    "void PostScriptTable.setMaxMemType1(long)",
    "void PostScriptTable.setMaxMemType42(long)",
    "void PostScriptTable.setMimMemType1(long)",
    "void PostScriptTable.setMinMemType42(long)",
    "void PostScriptTable.setUnderlinePosition(short)",
    "void PostScriptTable.setUnderlineThickness(short)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PostScriptTable actualPostScriptTable = new PostScriptTable();
    actualPostScriptTable.setFormatType(10.0f);
    String[] glyphNamesValue = new String[] {"42"};
    actualPostScriptTable.setGlyphNames(glyphNamesValue);
    actualPostScriptTable.setIsFixedPitch(42L);
    actualPostScriptTable.setItalicAngle(10.0f);
    actualPostScriptTable.setMaxMemType1(42L);
    actualPostScriptTable.setMaxMemType42(42L);
    actualPostScriptTable.setMimMemType1(42L);
    actualPostScriptTable.setMinMemType42(42L);
    actualPostScriptTable.setUnderlinePosition((short) 1);
    actualPostScriptTable.setUnderlineThickness((short) 1);
    float actualFormatType = actualPostScriptTable.getFormatType();
    String[] actualGlyphNames = actualPostScriptTable.getGlyphNames();
    long actualIsFixedPitch = actualPostScriptTable.getIsFixedPitch();
    float actualItalicAngle = actualPostScriptTable.getItalicAngle();
    long actualMaxMemType1 = actualPostScriptTable.getMaxMemType1();
    long actualMaxMemType42 = actualPostScriptTable.getMaxMemType42();
    long actualMinMemType1 = actualPostScriptTable.getMinMemType1();
    long actualMinMemType42 = actualPostScriptTable.getMinMemType42();
    short actualUnderlinePosition = actualPostScriptTable.getUnderlinePosition();
    short actualUnderlineThickness = actualPostScriptTable.getUnderlineThickness();

    // Assert
    assertNull(actualPostScriptTable.getTag());
    assertEquals(0L, actualPostScriptTable.getCheckSum());
    assertEquals(0L, actualPostScriptTable.getLength());
    assertEquals(0L, actualPostScriptTable.getOffset());
    assertEquals(10.0f, actualFormatType);
    assertEquals(10.0f, actualItalicAngle);
    assertEquals((short) 1, actualUnderlinePosition);
    assertEquals((short) 1, actualUnderlineThickness);
    assertEquals(42L, actualIsFixedPitch);
    assertEquals(42L, actualMaxMemType1);
    assertEquals(42L, actualMaxMemType42);
    assertEquals(42L, actualMinMemType1);
    assertEquals(42L, actualMinMemType42);
    assertFalse(actualPostScriptTable.getInitialized());
    assertSame(glyphNamesValue, actualGlyphNames);
    assertArrayEquals(new String[] {"42"}, actualGlyphNames);
  }

  /**
   * Test {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link RandomAccessReadDataStream#readString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given 'String'; then calls readString(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostScriptTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenString_thenCallsReadString() throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByte()).thenReturn(1);
    when(data.readString(anyInt())).thenReturn("String");
    when(data.readUnsignedShort()).thenReturn(WGL4Names.NUMBER_OF_MAC_GLYPHS);
    when(data.read32Fixed()).thenReturn(2.0f);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    postScriptTable.read(ttf, data);

    // Assert
    verify(data).getCurrentPosition();
    verify(data).getOriginalDataSize();
    verify(data, atLeast(1)).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readString(1);
    verify(data).readUnsignedByte();
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    assertEquals(WGL4Names.NUMBER_OF_MAC_GLYPHS, postScriptTable.getGlyphNames().length);
  }

  /**
   * Test {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then {@link PostScriptTable#PostScriptTable()} FormatType is ten.
   * </ul>
   *
   * <p>Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given ten; then PostScriptTable() FormatType is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostScriptTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenTen_thenPostScriptTableFormatTypeIsTen() throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read32Fixed()).thenReturn(10.0f);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    postScriptTable.read(ttf, data);

    // Assert
    verify(data).getCurrentPosition();
    verify(data).getOriginalDataSize();
    verify(data, atLeast(1)).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    assertNull(postScriptTable.getGlyphNames());
    assertEquals(10.0f, postScriptTable.getFormatType());
    assertEquals(10.0f, postScriptTable.getItalicAngle());
    assertEquals(1L, postScriptTable.getIsFixedPitch());
    assertEquals(1L, postScriptTable.getMaxMemType1());
    assertEquals(1L, postScriptTable.getMaxMemType42());
    assertEquals(1L, postScriptTable.getMinMemType1());
    assertEquals(1L, postScriptTable.getMinMemType42());
    assertEquals((short) 1, postScriptTable.getUnderlinePosition());
    assertEquals((short) 1, postScriptTable.getUnderlineThickness());
    assertTrue(postScriptTable.getInitialized());
  }

  /**
   * Test {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Then {@link PostScriptTable#PostScriptTable()} FormatType is one.
   * </ul>
   *
   * <p>Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then PostScriptTable() FormatType is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostScriptTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenPostScriptTableFormatTypeIsOne() throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read32Fixed()).thenReturn(1.0f);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    postScriptTable.read(ttf, data);

    // Assert
    verify(data).getCurrentPosition();
    verify(data).getOriginalDataSize();
    verify(data, atLeast(1)).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    assertEquals(1.0f, postScriptTable.getFormatType());
    assertEquals(1.0f, postScriptTable.getItalicAngle());
    assertEquals(WGL4Names.NUMBER_OF_MAC_GLYPHS, postScriptTable.getGlyphNames().length);
  }

  /**
   * Test {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Then {@link PostScriptTable#PostScriptTable()} GlyphNames is array of {@link String} with
   *       {@code .null}.
   * </ul>
   *
   * <p>Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); then PostScriptTable() GlyphNames is array of String with '.null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostScriptTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenPostScriptTableGlyphNamesIsArrayOfStringWithNull() throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.read32Fixed()).thenReturn(2.0f);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    postScriptTable.read(ttf, data);

    // Assert
    verify(data).getCurrentPosition();
    verify(data).getOriginalDataSize();
    verify(data, atLeast(1)).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    assertEquals(2.0f, postScriptTable.getFormatType());
    assertEquals(2.0f, postScriptTable.getItalicAngle());
    assertArrayEquals(new String[] {".null"}, postScriptTable.getGlyphNames());
  }

  /**
   * Test {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Then {@link PostScriptTable#PostScriptTable()} GlyphNames is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); then PostScriptTable() GlyphNames is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostScriptTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenPostScriptTableGlyphNamesIsNull() throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read32Fixed()).thenReturn(2.0f);
    when(data.getCurrentPosition()).thenReturn(3L);
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    postScriptTable.read(ttf, data);

    // Assert
    verify(data).getCurrentPosition();
    verify(data).getOriginalDataSize();
    verify(data, atLeast(1)).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    assertNull(postScriptTable.getGlyphNames());
    assertEquals(1L, postScriptTable.getIsFixedPitch());
    assertEquals(1L, postScriptTable.getMaxMemType1());
    assertEquals(1L, postScriptTable.getMaxMemType42());
    assertEquals(1L, postScriptTable.getMinMemType1());
    assertEquals(1L, postScriptTable.getMinMemType42());
    assertEquals((short) 1, postScriptTable.getUnderlinePosition());
    assertEquals((short) 1, postScriptTable.getUnderlineThickness());
    assertEquals(2.0f, postScriptTable.getFormatType());
    assertEquals(2.0f, postScriptTable.getItalicAngle());
    assertTrue(postScriptTable.getInitialized());
  }

  /**
   * Test {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedByte()} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); when RandomAccessReadDataStream readUnsignedByte() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostScriptTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_whenRandomAccessReadDataStreamReadUnsignedByteThrowIOException()
      throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByte()).thenThrow(new IOException());
    when(data.readUnsignedShort()).thenReturn(WGL4Names.NUMBER_OF_MAC_GLYPHS);
    when(data.read32Fixed()).thenReturn(2.0f);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act and Assert
    assertThrows(IOException.class, () -> postScriptTable.read(ttf, data));
    verify(data).getCurrentPosition();
    verify(data).getOriginalDataSize();
    verify(data, atLeast(1)).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedByte();
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedShort()} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); when RandomAccessReadDataStream readUnsignedShort() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostScriptTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_whenRandomAccessReadDataStreamReadUnsignedShortThrowIOException()
      throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenThrow(new IOException());
    when(data.read32Fixed()).thenReturn(2.0f);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act and Assert
    assertThrows(IOException.class, () -> postScriptTable.read(ttf, data));
    verify(data).getCurrentPosition();
    verify(data).getOriginalDataSize();
    verify(data, atLeast(1)).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data).readUnsignedShort();
  }

  /**
   * Test {@link PostScriptTable#getName(int)}.
   *
   * <ul>
   *   <li>Given {@link PostScriptTable#PostScriptTable()} GlyphNames is array of {@link String}
   *       with {@code 42}.
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link PostScriptTable#getName(int)}
   */
  @Test
  @DisplayName(
      "Test getName(int); given PostScriptTable() GlyphNames is array of String with '42'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PostScriptTable.getName(int)"})
  void testGetName_givenPostScriptTableGlyphNamesIsArrayOfStringWith42_whenOne() {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    postScriptTable.setGlyphNames(new String[] {"42"});

    // Act and Assert
    assertNull(postScriptTable.getName(1));
  }

  /**
   * Test {@link PostScriptTable#getName(int)}.
   *
   * <ul>
   *   <li>Given {@link PostScriptTable#PostScriptTable()} GlyphNames is array of {@link String}
   *       with {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PostScriptTable#getName(int)}
   */
  @Test
  @DisplayName(
      "Test getName(int); given PostScriptTable() GlyphNames is array of String with 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PostScriptTable.getName(int)"})
  void testGetName_givenPostScriptTableGlyphNamesIsArrayOfStringWithFoo_thenReturnFoo() {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    postScriptTable.setGlyphNames(new String[] {"foo"});

    // Act and Assert
    assertEquals("foo", postScriptTable.getName(0));
  }

  /**
   * Test {@link PostScriptTable#getName(int)}.
   *
   * <ul>
   *   <li>Given {@link PostScriptTable#PostScriptTable()} GlyphNames is {@code null}.
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PostScriptTable#getName(int)}
   */
  @Test
  @DisplayName(
      "Test getName(int); given PostScriptTable() GlyphNames is 'null'; when minus one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PostScriptTable.getName(int)"})
  void testGetName_givenPostScriptTableGlyphNamesIsNull_whenMinusOne_thenReturnNull() {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    postScriptTable.setGlyphNames(null);

    // Act and Assert
    assertNull(postScriptTable.getName(-1));
  }

  /**
   * Test {@link PostScriptTable#getName(int)}.
   *
   * <ul>
   *   <li>Given {@link PostScriptTable#PostScriptTable()}.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PostScriptTable#getName(int)}
   */
  @Test
  @DisplayName("Test getName(int); given PostScriptTable(); when one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PostScriptTable.getName(int)"})
  void testGetName_givenPostScriptTable_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PostScriptTable().getName(1));
  }
}
