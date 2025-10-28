package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class OS2WindowsMetricsTableDiffblueTest {
  /**
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

    // Assert that nothing has changed
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
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link OS2WindowsMetricsTable}
   */
  @Test
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
}
