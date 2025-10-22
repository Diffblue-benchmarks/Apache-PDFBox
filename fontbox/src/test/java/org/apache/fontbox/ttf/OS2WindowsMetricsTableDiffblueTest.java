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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OS2WindowsMetricsTableDiffblueTest {
  /**
   * Test {@link OS2WindowsMetricsTable#OS2WindowsMetricsTable()}.
   * <p>
   * Method under test: default or parameterless constructor of {@link OS2WindowsMetricsTable}
   */
  @Test
  @DisplayName("Test new OS2WindowsMetricsTable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OS2WindowsMetricsTable.<init>()"})
  void testNewOS2WindowsMetricsTable() {
    // Arrange and Act
    OS2WindowsMetricsTable actualOs2WindowsMetricsTable = new OS2WindowsMetricsTable();

    // Assert
    assertEquals("XXXX", actualOs2WindowsMetricsTable.getAchVendId());
    assertNull(actualOs2WindowsMetricsTable.getTag());
    assertEquals(0, actualOs2WindowsMetricsTable.getBreakChar());
    assertEquals(0, actualOs2WindowsMetricsTable.getCapHeight());
    assertEquals(0, actualOs2WindowsMetricsTable.getDefaultChar());
    assertEquals(0, actualOs2WindowsMetricsTable.getFamilyClass());
    assertEquals(0, actualOs2WindowsMetricsTable.getFirstCharIndex());
    assertEquals(0, actualOs2WindowsMetricsTable.getFsSelection());
    assertEquals(0, actualOs2WindowsMetricsTable.getHeight());
    assertEquals(0, actualOs2WindowsMetricsTable.getLastCharIndex());
    assertEquals(0, actualOs2WindowsMetricsTable.getMaxContext());
    assertEquals(0, actualOs2WindowsMetricsTable.getTypoAscender());
    assertEquals(0, actualOs2WindowsMetricsTable.getTypoDescender());
    assertEquals(0, actualOs2WindowsMetricsTable.getTypoLineGap());
    assertEquals(0, actualOs2WindowsMetricsTable.getVersion());
    assertEquals(0, actualOs2WindowsMetricsTable.getWeightClass());
    assertEquals(0, actualOs2WindowsMetricsTable.getWidthClass());
    assertEquals(0, actualOs2WindowsMetricsTable.getWinAscent());
    assertEquals(0, actualOs2WindowsMetricsTable.getWinDescent());
    assertEquals(0L, actualOs2WindowsMetricsTable.getCodePageRange1());
    assertEquals(0L, actualOs2WindowsMetricsTable.getCodePageRange2());
    assertEquals(0L, actualOs2WindowsMetricsTable.getUnicodeRange1());
    assertEquals(0L, actualOs2WindowsMetricsTable.getUnicodeRange2());
    assertEquals(0L, actualOs2WindowsMetricsTable.getUnicodeRange3());
    assertEquals(0L, actualOs2WindowsMetricsTable.getUnicodeRange4());
    assertEquals(0L, actualOs2WindowsMetricsTable.getCheckSum());
    assertEquals(0L, actualOs2WindowsMetricsTable.getLength());
    assertEquals(0L, actualOs2WindowsMetricsTable.getOffset());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getAverageCharWidth());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getFsType());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getStrikeoutPosition());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getStrikeoutSize());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getSubscriptXOffset());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getSubscriptXSize());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getSubscriptYOffset());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getSubscriptYSize());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getSuperscriptXOffset());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getSuperscriptXSize());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getSuperscriptYOffset());
    assertEquals((short) 0, actualOs2WindowsMetricsTable.getSuperscriptYSize());
    assertFalse(actualOs2WindowsMetricsTable.getInitialized());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, actualOs2WindowsMetricsTable.getPanose());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OS2WindowsMetricsTable#setAchVendId(String)}
   *   <li>{@link OS2WindowsMetricsTable#setAverageCharWidth(short)}
   *   <li>{@link OS2WindowsMetricsTable#setCodePageRange1(long)}
   *   <li>{@link OS2WindowsMetricsTable#setCodePageRange2(long)}
   *   <li>{@link OS2WindowsMetricsTable#setFamilyClass(int)}
   *   <li>{@link OS2WindowsMetricsTable#setFirstCharIndex(int)}
   *   <li>{@link OS2WindowsMetricsTable#setFsSelection(int)}
   *   <li>{@link OS2WindowsMetricsTable#setFsType(short)}
   *   <li>{@link OS2WindowsMetricsTable#setLastCharIndex(int)}
   *   <li>{@link OS2WindowsMetricsTable#setPanose(byte[])}
   *   <li>{@link OS2WindowsMetricsTable#setStrikeoutPosition(short)}
   *   <li>{@link OS2WindowsMetricsTable#setStrikeoutSize(short)}
   *   <li>{@link OS2WindowsMetricsTable#setSubscriptXOffset(short)}
   *   <li>{@link OS2WindowsMetricsTable#setSubscriptXSize(short)}
   *   <li>{@link OS2WindowsMetricsTable#setSubscriptYOffset(short)}
   *   <li>{@link OS2WindowsMetricsTable#setSubscriptYSize(short)}
   *   <li>{@link OS2WindowsMetricsTable#setSuperscriptXOffset(short)}
   *   <li>{@link OS2WindowsMetricsTable#setSuperscriptXSize(short)}
   *   <li>{@link OS2WindowsMetricsTable#setSuperscriptYOffset(short)}
   *   <li>{@link OS2WindowsMetricsTable#setSuperscriptYSize(short)}
   *   <li>{@link OS2WindowsMetricsTable#setTypoAscender(int)}
   *   <li>{@link OS2WindowsMetricsTable#setTypoDescender(int)}
   *   <li>{@link OS2WindowsMetricsTable#setTypoLineGap(int)}
   *   <li>{@link OS2WindowsMetricsTable#setUnicodeRange1(long)}
   *   <li>{@link OS2WindowsMetricsTable#setUnicodeRange2(long)}
   *   <li>{@link OS2WindowsMetricsTable#setUnicodeRange3(long)}
   *   <li>{@link OS2WindowsMetricsTable#setUnicodeRange4(long)}
   *   <li>{@link OS2WindowsMetricsTable#setVersion(int)}
   *   <li>{@link OS2WindowsMetricsTable#setWeightClass(int)}
   *   <li>{@link OS2WindowsMetricsTable#setWidthClass(int)}
   *   <li>{@link OS2WindowsMetricsTable#setWinAscent(int)}
   *   <li>{@link OS2WindowsMetricsTable#setWinDescent(int)}
   *   <li>{@link OS2WindowsMetricsTable#getAchVendId()}
   *   <li>{@link OS2WindowsMetricsTable#getAverageCharWidth()}
   *   <li>{@link OS2WindowsMetricsTable#getBreakChar()}
   *   <li>{@link OS2WindowsMetricsTable#getCapHeight()}
   *   <li>{@link OS2WindowsMetricsTable#getCodePageRange1()}
   *   <li>{@link OS2WindowsMetricsTable#getCodePageRange2()}
   *   <li>{@link OS2WindowsMetricsTable#getDefaultChar()}
   *   <li>{@link OS2WindowsMetricsTable#getFamilyClass()}
   *   <li>{@link OS2WindowsMetricsTable#getFirstCharIndex()}
   *   <li>{@link OS2WindowsMetricsTable#getFsSelection()}
   *   <li>{@link OS2WindowsMetricsTable#getFsType()}
   *   <li>{@link OS2WindowsMetricsTable#getHeight()}
   *   <li>{@link OS2WindowsMetricsTable#getLastCharIndex()}
   *   <li>{@link OS2WindowsMetricsTable#getMaxContext()}
   *   <li>{@link OS2WindowsMetricsTable#getPanose()}
   *   <li>{@link OS2WindowsMetricsTable#getStrikeoutPosition()}
   *   <li>{@link OS2WindowsMetricsTable#getStrikeoutSize()}
   *   <li>{@link OS2WindowsMetricsTable#getSubscriptXOffset()}
   *   <li>{@link OS2WindowsMetricsTable#getSubscriptXSize()}
   *   <li>{@link OS2WindowsMetricsTable#getSubscriptYOffset()}
   *   <li>{@link OS2WindowsMetricsTable#getSubscriptYSize()}
   *   <li>{@link OS2WindowsMetricsTable#getSuperscriptXOffset()}
   *   <li>{@link OS2WindowsMetricsTable#getSuperscriptXSize()}
   *   <li>{@link OS2WindowsMetricsTable#getSuperscriptYOffset()}
   *   <li>{@link OS2WindowsMetricsTable#getSuperscriptYSize()}
   *   <li>{@link OS2WindowsMetricsTable#getTypoAscender()}
   *   <li>{@link OS2WindowsMetricsTable#getTypoDescender()}
   *   <li>{@link OS2WindowsMetricsTable#getTypoLineGap()}
   *   <li>{@link OS2WindowsMetricsTable#getUnicodeRange1()}
   *   <li>{@link OS2WindowsMetricsTable#getUnicodeRange2()}
   *   <li>{@link OS2WindowsMetricsTable#getUnicodeRange3()}
   *   <li>{@link OS2WindowsMetricsTable#getUnicodeRange4()}
   *   <li>{@link OS2WindowsMetricsTable#getVersion()}
   *   <li>{@link OS2WindowsMetricsTable#getWeightClass()}
   *   <li>{@link OS2WindowsMetricsTable#getWidthClass()}
   *   <li>{@link OS2WindowsMetricsTable#getWinAscent()}
   *   <li>{@link OS2WindowsMetricsTable#getWinDescent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String OS2WindowsMetricsTable.getAchVendId()",
      "short OS2WindowsMetricsTable.getAverageCharWidth()", "int OS2WindowsMetricsTable.getBreakChar()",
      "int OS2WindowsMetricsTable.getCapHeight()", "long OS2WindowsMetricsTable.getCodePageRange1()",
      "long OS2WindowsMetricsTable.getCodePageRange2()", "int OS2WindowsMetricsTable.getDefaultChar()",
      "int OS2WindowsMetricsTable.getFamilyClass()", "int OS2WindowsMetricsTable.getFirstCharIndex()",
      "int OS2WindowsMetricsTable.getFsSelection()", "short OS2WindowsMetricsTable.getFsType()",
      "int OS2WindowsMetricsTable.getHeight()", "int OS2WindowsMetricsTable.getLastCharIndex()",
      "int OS2WindowsMetricsTable.getMaxContext()", "byte[] OS2WindowsMetricsTable.getPanose()",
      "short OS2WindowsMetricsTable.getStrikeoutPosition()", "short OS2WindowsMetricsTable.getStrikeoutSize()",
      "short OS2WindowsMetricsTable.getSubscriptXOffset()", "short OS2WindowsMetricsTable.getSubscriptXSize()",
      "short OS2WindowsMetricsTable.getSubscriptYOffset()", "short OS2WindowsMetricsTable.getSubscriptYSize()",
      "short OS2WindowsMetricsTable.getSuperscriptXOffset()", "short OS2WindowsMetricsTable.getSuperscriptXSize()",
      "short OS2WindowsMetricsTable.getSuperscriptYOffset()", "short OS2WindowsMetricsTable.getSuperscriptYSize()",
      "int OS2WindowsMetricsTable.getTypoAscender()", "int OS2WindowsMetricsTable.getTypoDescender()",
      "int OS2WindowsMetricsTable.getTypoLineGap()", "long OS2WindowsMetricsTable.getUnicodeRange1()",
      "long OS2WindowsMetricsTable.getUnicodeRange2()", "long OS2WindowsMetricsTable.getUnicodeRange3()",
      "long OS2WindowsMetricsTable.getUnicodeRange4()", "int OS2WindowsMetricsTable.getVersion()",
      "int OS2WindowsMetricsTable.getWeightClass()", "int OS2WindowsMetricsTable.getWidthClass()",
      "int OS2WindowsMetricsTable.getWinAscent()", "int OS2WindowsMetricsTable.getWinDescent()",
      "void OS2WindowsMetricsTable.setAchVendId(String)", "void OS2WindowsMetricsTable.setAverageCharWidth(short)",
      "void OS2WindowsMetricsTable.setCodePageRange1(long)", "void OS2WindowsMetricsTable.setCodePageRange2(long)",
      "void OS2WindowsMetricsTable.setFamilyClass(int)", "void OS2WindowsMetricsTable.setFirstCharIndex(int)",
      "void OS2WindowsMetricsTable.setFsSelection(int)", "void OS2WindowsMetricsTable.setFsType(short)",
      "void OS2WindowsMetricsTable.setLastCharIndex(int)", "void OS2WindowsMetricsTable.setPanose(byte[])",
      "void OS2WindowsMetricsTable.setStrikeoutPosition(short)", "void OS2WindowsMetricsTable.setStrikeoutSize(short)",
      "void OS2WindowsMetricsTable.setSubscriptXOffset(short)", "void OS2WindowsMetricsTable.setSubscriptXSize(short)",
      "void OS2WindowsMetricsTable.setSubscriptYOffset(short)", "void OS2WindowsMetricsTable.setSubscriptYSize(short)",
      "void OS2WindowsMetricsTable.setSuperscriptXOffset(short)",
      "void OS2WindowsMetricsTable.setSuperscriptXSize(short)",
      "void OS2WindowsMetricsTable.setSuperscriptYOffset(short)",
      "void OS2WindowsMetricsTable.setSuperscriptYSize(short)", "void OS2WindowsMetricsTable.setTypoAscender(int)",
      "void OS2WindowsMetricsTable.setTypoDescender(int)", "void OS2WindowsMetricsTable.setTypoLineGap(int)",
      "void OS2WindowsMetricsTable.setUnicodeRange1(long)", "void OS2WindowsMetricsTable.setUnicodeRange2(long)",
      "void OS2WindowsMetricsTable.setUnicodeRange3(long)", "void OS2WindowsMetricsTable.setUnicodeRange4(long)",
      "void OS2WindowsMetricsTable.setVersion(int)", "void OS2WindowsMetricsTable.setWeightClass(int)",
      "void OS2WindowsMetricsTable.setWidthClass(int)", "void OS2WindowsMetricsTable.setWinAscent(int)",
      "void OS2WindowsMetricsTable.setWinDescent(int)"})
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    OS2WindowsMetricsTable os2WindowsMetricsTable = new OS2WindowsMetricsTable();

    // Act
    os2WindowsMetricsTable.setAchVendId("42");
    os2WindowsMetricsTable.setAverageCharWidth((short) 1);
    os2WindowsMetricsTable.setCodePageRange1(42L);
    os2WindowsMetricsTable.setCodePageRange2(42L);
    os2WindowsMetricsTable.setFamilyClass(42);
    os2WindowsMetricsTable.setFirstCharIndex(1);
    os2WindowsMetricsTable.setFsSelection(42);
    os2WindowsMetricsTable.setFsType((short) 1);
    os2WindowsMetricsTable.setLastCharIndex(1);
    byte[] panoseValue = "AXAXAXAX".getBytes("UTF-8");
    os2WindowsMetricsTable.setPanose(panoseValue);
    os2WindowsMetricsTable.setStrikeoutPosition((short) 1);
    os2WindowsMetricsTable.setStrikeoutSize((short) 1);
    os2WindowsMetricsTable.setSubscriptXOffset((short) 1);
    os2WindowsMetricsTable.setSubscriptXSize((short) 1);
    os2WindowsMetricsTable.setSubscriptYOffset((short) 1);
    os2WindowsMetricsTable.setSubscriptYSize((short) 1);
    os2WindowsMetricsTable.setSuperscriptXOffset((short) 1);
    os2WindowsMetricsTable.setSuperscriptXSize((short) 1);
    os2WindowsMetricsTable.setSuperscriptYOffset((short) 1);
    os2WindowsMetricsTable.setSuperscriptYSize((short) 1);
    os2WindowsMetricsTable.setTypoAscender(3);
    os2WindowsMetricsTable.setTypoDescender(3);
    os2WindowsMetricsTable.setTypoLineGap(2);
    os2WindowsMetricsTable.setUnicodeRange1(42L);
    os2WindowsMetricsTable.setUnicodeRange2(42L);
    os2WindowsMetricsTable.setUnicodeRange3(42L);
    os2WindowsMetricsTable.setUnicodeRange4(42L);
    os2WindowsMetricsTable.setVersion(42);
    os2WindowsMetricsTable.setWeightClass(3);
    os2WindowsMetricsTable.setWidthClass(1);
    os2WindowsMetricsTable.setWinAscent(42);
    os2WindowsMetricsTable.setWinDescent(42);
    String actualAchVendId = os2WindowsMetricsTable.getAchVendId();
    short actualAverageCharWidth = os2WindowsMetricsTable.getAverageCharWidth();
    int actualBreakChar = os2WindowsMetricsTable.getBreakChar();
    int actualCapHeight = os2WindowsMetricsTable.getCapHeight();
    long actualCodePageRange1 = os2WindowsMetricsTable.getCodePageRange1();
    long actualCodePageRange2 = os2WindowsMetricsTable.getCodePageRange2();
    int actualDefaultChar = os2WindowsMetricsTable.getDefaultChar();
    int actualFamilyClass = os2WindowsMetricsTable.getFamilyClass();
    int actualFirstCharIndex = os2WindowsMetricsTable.getFirstCharIndex();
    int actualFsSelection = os2WindowsMetricsTable.getFsSelection();
    short actualFsType = os2WindowsMetricsTable.getFsType();
    int actualHeight = os2WindowsMetricsTable.getHeight();
    int actualLastCharIndex = os2WindowsMetricsTable.getLastCharIndex();
    int actualMaxContext = os2WindowsMetricsTable.getMaxContext();
    byte[] actualPanose = os2WindowsMetricsTable.getPanose();
    short actualStrikeoutPosition = os2WindowsMetricsTable.getStrikeoutPosition();
    short actualStrikeoutSize = os2WindowsMetricsTable.getStrikeoutSize();
    short actualSubscriptXOffset = os2WindowsMetricsTable.getSubscriptXOffset();
    short actualSubscriptXSize = os2WindowsMetricsTable.getSubscriptXSize();
    short actualSubscriptYOffset = os2WindowsMetricsTable.getSubscriptYOffset();
    short actualSubscriptYSize = os2WindowsMetricsTable.getSubscriptYSize();
    short actualSuperscriptXOffset = os2WindowsMetricsTable.getSuperscriptXOffset();
    short actualSuperscriptXSize = os2WindowsMetricsTable.getSuperscriptXSize();
    short actualSuperscriptYOffset = os2WindowsMetricsTable.getSuperscriptYOffset();
    short actualSuperscriptYSize = os2WindowsMetricsTable.getSuperscriptYSize();
    int actualTypoAscender = os2WindowsMetricsTable.getTypoAscender();
    int actualTypoDescender = os2WindowsMetricsTable.getTypoDescender();
    int actualTypoLineGap = os2WindowsMetricsTable.getTypoLineGap();
    long actualUnicodeRange1 = os2WindowsMetricsTable.getUnicodeRange1();
    long actualUnicodeRange2 = os2WindowsMetricsTable.getUnicodeRange2();
    long actualUnicodeRange3 = os2WindowsMetricsTable.getUnicodeRange3();
    long actualUnicodeRange4 = os2WindowsMetricsTable.getUnicodeRange4();
    int actualVersion = os2WindowsMetricsTable.getVersion();
    int actualWeightClass = os2WindowsMetricsTable.getWeightClass();
    int actualWidthClass = os2WindowsMetricsTable.getWidthClass();
    int actualWinAscent = os2WindowsMetricsTable.getWinAscent();

    // Assert
    assertEquals("42", actualAchVendId);
    assertEquals(0, actualBreakChar);
    assertEquals(0, actualCapHeight);
    assertEquals(0, actualDefaultChar);
    assertEquals(0, actualHeight);
    assertEquals(0, actualMaxContext);
    assertEquals(1, actualFirstCharIndex);
    assertEquals(1, actualLastCharIndex);
    assertEquals(1, actualWidthClass);
    assertEquals((short) 1, actualAverageCharWidth);
    assertEquals((short) 1, actualFsType);
    assertEquals((short) 1, actualStrikeoutPosition);
    assertEquals((short) 1, actualStrikeoutSize);
    assertEquals((short) 1, actualSubscriptXOffset);
    assertEquals((short) 1, actualSubscriptXSize);
    assertEquals((short) 1, actualSubscriptYOffset);
    assertEquals((short) 1, actualSubscriptYSize);
    assertEquals((short) 1, actualSuperscriptXOffset);
    assertEquals((short) 1, actualSuperscriptXSize);
    assertEquals((short) 1, actualSuperscriptYOffset);
    assertEquals((short) 1, actualSuperscriptYSize);
    assertEquals(2, actualTypoLineGap);
    assertEquals(3, actualTypoAscender);
    assertEquals(3, actualTypoDescender);
    assertEquals(3, actualWeightClass);
    assertEquals(42, actualFamilyClass);
    assertEquals(42, actualFsSelection);
    assertEquals(42, actualVersion);
    assertEquals(42, actualWinAscent);
    assertEquals(42, os2WindowsMetricsTable.getWinDescent());
    assertEquals(42L, actualCodePageRange1);
    assertEquals(42L, actualCodePageRange2);
    assertEquals(42L, actualUnicodeRange1);
    assertEquals(42L, actualUnicodeRange2);
    assertEquals(42L, actualUnicodeRange3);
    assertEquals(42L, actualUnicodeRange4);
    assertSame(panoseValue, actualPanose);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPanose);
  }

  /**
   * Test {@link OS2WindowsMetricsTable#read(TrueTypeFont, TTFDataStream)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then {@link OS2WindowsMetricsTable#OS2WindowsMetricsTable()} AchVendId is {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OS2WindowsMetricsTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); given 'AXAXAXAX' Bytes is 'UTF-8'; then OS2WindowsMetricsTable() AchVendId is 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OS2WindowsMetricsTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenAxaxaxaxBytesIsUtf8_thenOS2WindowsMetricsTableAchVendIdIsString() throws IOException {
    // Arrange
    OS2WindowsMetricsTable os2WindowsMetricsTable = new OS2WindowsMetricsTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readString(anyInt())).thenReturn("String");
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    os2WindowsMetricsTable.read(ttf, data);

    // Assert
    verify(data).read(eq(10));
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readString(eq(4));
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    assertEquals("String", os2WindowsMetricsTable.getAchVendId());
    assertEquals(1, os2WindowsMetricsTable.getFamilyClass());
    assertEquals(1, os2WindowsMetricsTable.getFirstCharIndex());
    assertEquals(1, os2WindowsMetricsTable.getFsSelection());
    assertEquals(1, os2WindowsMetricsTable.getLastCharIndex());
    assertEquals(1, os2WindowsMetricsTable.getTypoAscender());
    assertEquals(1, os2WindowsMetricsTable.getTypoDescender());
    assertEquals(1, os2WindowsMetricsTable.getTypoLineGap());
    assertEquals(1, os2WindowsMetricsTable.getVersion());
    assertEquals(1, os2WindowsMetricsTable.getWeightClass());
    assertEquals(1, os2WindowsMetricsTable.getWidthClass());
    assertEquals(1, os2WindowsMetricsTable.getWinAscent());
    assertEquals(1, os2WindowsMetricsTable.getWinDescent());
    assertEquals(1L, os2WindowsMetricsTable.getCodePageRange1());
    assertEquals(1L, os2WindowsMetricsTable.getCodePageRange2());
    assertEquals(1L, os2WindowsMetricsTable.getUnicodeRange1());
    assertEquals(1L, os2WindowsMetricsTable.getUnicodeRange2());
    assertEquals(1L, os2WindowsMetricsTable.getUnicodeRange3());
    assertEquals(1L, os2WindowsMetricsTable.getUnicodeRange4());
    assertEquals((short) 1, os2WindowsMetricsTable.getAverageCharWidth());
    assertEquals((short) 1, os2WindowsMetricsTable.getFsType());
    assertEquals((short) 1, os2WindowsMetricsTable.getStrikeoutPosition());
    assertEquals((short) 1, os2WindowsMetricsTable.getStrikeoutSize());
    assertEquals((short) 1, os2WindowsMetricsTable.getSubscriptXOffset());
    assertEquals((short) 1, os2WindowsMetricsTable.getSubscriptXSize());
    assertEquals((short) 1, os2WindowsMetricsTable.getSubscriptYOffset());
    assertEquals((short) 1, os2WindowsMetricsTable.getSubscriptYSize());
    assertEquals((short) 1, os2WindowsMetricsTable.getSuperscriptXOffset());
    assertEquals((short) 1, os2WindowsMetricsTable.getSuperscriptXSize());
    assertEquals((short) 1, os2WindowsMetricsTable.getSuperscriptYOffset());
    assertEquals((short) 1, os2WindowsMetricsTable.getSuperscriptYSize());
    assertTrue(os2WindowsMetricsTable.getInitialized());
    byte[] expectedPanose = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPanose, os2WindowsMetricsTable.getPanose());
  }
}
