package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.DataInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class PostScriptTableDiffblueTest {
  /**
   * Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read32Fixed()).thenReturn(10.0f);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    postScriptTable.read(ttf, data);

    // Assert
    verify(inputStream).readAllBytes();
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
   * Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read32Fixed()).thenReturn(1.0f);
    when(data.getCurrentPosition()).thenReturn(1L);
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    postScriptTable.read(ttf, data);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data).getCurrentPosition();
    verify(data).getOriginalDataSize();
    verify(data, atLeast(1)).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    String[] glyphNames = postScriptTable.getGlyphNames();
    assertEquals(".notdef", glyphNames[0]);
    assertEquals(".null", glyphNames[1]);
    assertEquals("Cacute", glyphNames[253]);
    assertEquals("Ccaron", glyphNames[255]);
    assertEquals("Eth", glyphNames[233]);
    assertEquals("Gbreve", glyphNames[248]);
    assertEquals("Idotaccent", glyphNames[250]);
    assertEquals("Scedilla", glyphNames[251]);
    assertEquals("Thorn", glyphNames[237]);
    assertEquals("Yacute", glyphNames[235]);
    assertEquals("ampersand", glyphNames[OS2WindowsMetricsTable.FAMILY_CLASS_ORNAMENTALS]);
    assertEquals("asterisk", glyphNames[13]);
    assertEquals("cacute", glyphNames[254]);
    assertEquals("ccaron", glyphNames[256]);
    assertEquals("comma", glyphNames[15]);
    assertEquals("dcroat", glyphNames[257]);
    assertEquals("dollar", glyphNames[7]);
    assertEquals("eth", glyphNames[234]);
    assertEquals("exclam", glyphNames[4]);
    assertEquals("five", glyphNames[24]);
    assertEquals("four", glyphNames[23]);
    assertEquals("franc", glyphNames[247]);
    assertEquals("gbreve", glyphNames[249]);
    assertEquals("hyphen", glyphNames[Short.SIZE]);
    assertEquals("minus", glyphNames[239]);
    assertEquals("multiply", glyphNames[240]);
    assertEquals("nonmarkingreturn", glyphNames[2]);
    assertEquals("numbersign", glyphNames[6]);
    assertEquals("one", glyphNames[20]);
    assertEquals("onehalf", glyphNames[244]);
    assertEquals("onequarter", glyphNames[245]);
    assertEquals("onesuperior", glyphNames[241]);
    assertEquals("parenleft", glyphNames[11]);
    assertEquals("parenright", glyphNames[OS2WindowsMetricsTable.FAMILY_CLASS_SYMBOLIC]);
    assertEquals("percent", glyphNames[8]);
    assertEquals("period", glyphNames[17]);
    assertEquals("plus", glyphNames[14]);
    assertEquals("quotedbl", glyphNames[5]);
    assertEquals("quotesingle", glyphNames[CmapTable.ENCODING_WIN_UNICODE_FULL]);
    assertEquals("scedilla", glyphNames[252]);
    assertEquals("slash", glyphNames[18]);
    assertEquals("space", glyphNames[3]);
    assertEquals("thorn", glyphNames[238]);
    assertEquals("three", glyphNames[22]);
    assertEquals("threequarters", glyphNames[246]);
    assertEquals("threesuperior", glyphNames[243]);
    assertEquals("two", glyphNames[21]);
    assertEquals("twosuperior", glyphNames[242]);
    assertEquals("yacute", glyphNames[236]);
    assertEquals("zero", glyphNames[19]);
    assertEquals(1.0f, postScriptTable.getFormatType());
    assertEquals(1.0f, postScriptTable.getItalicAngle());
    assertEquals(1L, postScriptTable.getIsFixedPitch());
    assertEquals(1L, postScriptTable.getMaxMemType1());
    assertEquals(1L, postScriptTable.getMaxMemType42());
    assertEquals(1L, postScriptTable.getMinMemType1());
    assertEquals(1L, postScriptTable.getMinMemType42());
    assertEquals((short) 1, postScriptTable.getUnderlinePosition());
    assertEquals((short) 1, postScriptTable.getUnderlineThickness());
    assertTrue(postScriptTable.getInitialized());
    assertEquals(WGL4Names.NUMBER_OF_MAC_GLYPHS, glyphNames.length);
  }

  /**
   * Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
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
    verify(inputStream).readAllBytes();
    verify(data).getCurrentPosition();
    verify(data).getOriginalDataSize();
    verify(data, atLeast(1)).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
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
    assertArrayEquals(new String[]{".null"}, postScriptTable.getGlyphNames());
  }

  /**
   * Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
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
    verify(inputStream).readAllBytes();
    verify(data).getCurrentPosition();
    verify(data).getOriginalDataSize();
    verify(data, atLeast(1)).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readString(eq(1));
    verify(data).readUnsignedByte();
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    String[] glyphNames = postScriptTable.getGlyphNames();
    assertEquals("String", glyphNames[0]);
    assertEquals("String", glyphNames[1]);
    assertEquals("String", glyphNames[11]);
    assertEquals("String", glyphNames[13]);
    assertEquals("String", glyphNames[14]);
    assertEquals("String", glyphNames[15]);
    assertEquals("String", glyphNames[17]);
    assertEquals("String", glyphNames[18]);
    assertEquals("String", glyphNames[19]);
    assertEquals("String", glyphNames[2]);
    assertEquals("String", glyphNames[20]);
    assertEquals("String", glyphNames[21]);
    assertEquals("String", glyphNames[22]);
    assertEquals("String", glyphNames[23]);
    assertEquals("String", glyphNames[233]);
    assertEquals("String", glyphNames[234]);
    assertEquals("String", glyphNames[235]);
    assertEquals("String", glyphNames[236]);
    assertEquals("String", glyphNames[237]);
    assertEquals("String", glyphNames[238]);
    assertEquals("String", glyphNames[239]);
    assertEquals("String", glyphNames[24]);
    assertEquals("String", glyphNames[240]);
    assertEquals("String", glyphNames[241]);
    assertEquals("String", glyphNames[242]);
    assertEquals("String", glyphNames[243]);
    assertEquals("String", glyphNames[244]);
    assertEquals("String", glyphNames[245]);
    assertEquals("String", glyphNames[246]);
    assertEquals("String", glyphNames[247]);
    assertEquals("String", glyphNames[248]);
    assertEquals("String", glyphNames[249]);
    assertEquals("String", glyphNames[250]);
    assertEquals("String", glyphNames[251]);
    assertEquals("String", glyphNames[252]);
    assertEquals("String", glyphNames[253]);
    assertEquals("String", glyphNames[254]);
    assertEquals("String", glyphNames[255]);
    assertEquals("String", glyphNames[256]);
    assertEquals("String", glyphNames[257]);
    assertEquals("String", glyphNames[3]);
    assertEquals("String", glyphNames[4]);
    assertEquals("String", glyphNames[5]);
    assertEquals("String", glyphNames[6]);
    assertEquals("String", glyphNames[7]);
    assertEquals("String", glyphNames[8]);
    assertEquals("String", glyphNames[Short.SIZE]);
    assertEquals("String", glyphNames[CmapTable.ENCODING_WIN_UNICODE_FULL]);
    assertEquals("String", glyphNames[OS2WindowsMetricsTable.FAMILY_CLASS_ORNAMENTALS]);
    assertEquals("String", glyphNames[OS2WindowsMetricsTable.FAMILY_CLASS_SYMBOLIC]);
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
    assertEquals(WGL4Names.NUMBER_OF_MAC_GLYPHS, glyphNames.length);
  }

  /**
   * Method under test: {@link PostScriptTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read32Fixed()).thenReturn(2.0f);
    when(data.getCurrentPosition()).thenReturn(3L);
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    postScriptTable.read(ttf, data);

    // Assert
    verify(inputStream).readAllBytes();
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
   * Method under test: {@link PostScriptTable#getName(int)}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new PostScriptTable()).getName(1));
  }

  /**
   * Method under test: {@link PostScriptTable#getName(int)}
   */
  @Test
  void testGetName2() {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    postScriptTable.setGlyphNames(null);

    // Act and Assert
    assertNull(postScriptTable.getName(-1));
  }

  /**
   * Method under test: {@link PostScriptTable#getName(int)}
   */
  @Test
  void testGetName3() {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    postScriptTable.setGlyphNames(new String[]{"foo"});

    // Act and Assert
    assertEquals("foo", postScriptTable.getName(0));
  }

  /**
   * Method under test: {@link PostScriptTable#getName(int)}
   */
  @Test
  void testGetName4() {
    // Arrange
    PostScriptTable postScriptTable = new PostScriptTable();
    postScriptTable.setGlyphNames(new String[]{"42"});

    // Act and Assert
    assertNull(postScriptTable.getName(1));
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    PostScriptTable actualPostScriptTable = new PostScriptTable();
    actualPostScriptTable.setFormatType(10.0f);
    String[] glyphNamesValue = new String[]{"42"};
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

    // Assert that nothing has changed
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
    assertArrayEquals(new String[]{"42"}, actualGlyphNames);
  }
}
