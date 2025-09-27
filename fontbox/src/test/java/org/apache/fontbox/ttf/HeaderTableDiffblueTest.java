package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HeaderTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link HeaderTable}
   *   <li>{@link HeaderTable#setCheckSumAdjustment(long)}
   *   <li>{@link HeaderTable#setCreated(Calendar)}
   *   <li>{@link HeaderTable#setFlags(int)}
   *   <li>{@link HeaderTable#setFontDirectionHint(short)}
   *   <li>{@link HeaderTable#setFontRevision(float)}
   *   <li>{@link HeaderTable#setGlyphDataFormat(short)}
   *   <li>{@link HeaderTable#setIndexToLocFormat(short)}
   *   <li>{@link HeaderTable#setLowestRecPPEM(int)}
   *   <li>{@link HeaderTable#setMacStyle(int)}
   *   <li>{@link HeaderTable#setMagicNumber(long)}
   *   <li>{@link HeaderTable#setModified(Calendar)}
   *   <li>{@link HeaderTable#setUnitsPerEm(int)}
   *   <li>{@link HeaderTable#setVersion(float)}
   *   <li>{@link HeaderTable#setXMax(short)}
   *   <li>{@link HeaderTable#setXMin(short)}
   *   <li>{@link HeaderTable#setYMax(short)}
   *   <li>{@link HeaderTable#setYMin(short)}
   *   <li>{@link HeaderTable#getCheckSumAdjustment()}
   *   <li>{@link HeaderTable#getCreated()}
   *   <li>{@link HeaderTable#getFlags()}
   *   <li>{@link HeaderTable#getFontDirectionHint()}
   *   <li>{@link HeaderTable#getFontRevision()}
   *   <li>{@link HeaderTable#getGlyphDataFormat()}
   *   <li>{@link HeaderTable#getIndexToLocFormat()}
   *   <li>{@link HeaderTable#getLowestRecPPEM()}
   *   <li>{@link HeaderTable#getMacStyle()}
   *   <li>{@link HeaderTable#getMagicNumber()}
   *   <li>{@link HeaderTable#getModified()}
   *   <li>{@link HeaderTable#getUnitsPerEm()}
   *   <li>{@link HeaderTable#getVersion()}
   *   <li>{@link HeaderTable#getXMax()}
   *   <li>{@link HeaderTable#getXMin()}
   *   <li>{@link HeaderTable#getYMax()}
   *   <li>{@link HeaderTable#getYMin()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HeaderTable.<init>()",
    "long HeaderTable.getCheckSumAdjustment()",
    "Calendar HeaderTable.getCreated()",
    "int HeaderTable.getFlags()",
    "short HeaderTable.getFontDirectionHint()",
    "float HeaderTable.getFontRevision()",
    "short HeaderTable.getGlyphDataFormat()",
    "short HeaderTable.getIndexToLocFormat()",
    "int HeaderTable.getLowestRecPPEM()",
    "int HeaderTable.getMacStyle()",
    "long HeaderTable.getMagicNumber()",
    "Calendar HeaderTable.getModified()",
    "int HeaderTable.getUnitsPerEm()",
    "float HeaderTable.getVersion()",
    "short HeaderTable.getXMax()",
    "short HeaderTable.getXMin()",
    "short HeaderTable.getYMax()",
    "short HeaderTable.getYMin()",
    "void HeaderTable.setCheckSumAdjustment(long)",
    "void HeaderTable.setCreated(Calendar)",
    "void HeaderTable.setFlags(int)",
    "void HeaderTable.setFontDirectionHint(short)",
    "void HeaderTable.setFontRevision(float)",
    "void HeaderTable.setGlyphDataFormat(short)",
    "void HeaderTable.setIndexToLocFormat(short)",
    "void HeaderTable.setLowestRecPPEM(int)",
    "void HeaderTable.setMacStyle(int)",
    "void HeaderTable.setMagicNumber(long)",
    "void HeaderTable.setModified(Calendar)",
    "void HeaderTable.setUnitsPerEm(int)",
    "void HeaderTable.setVersion(float)",
    "void HeaderTable.setXMax(short)",
    "void HeaderTable.setXMin(short)",
    "void HeaderTable.setYMax(short)",
    "void HeaderTable.setYMin(short)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    HeaderTable actualHeaderTable = new HeaderTable();
    actualHeaderTable.setCheckSumAdjustment(42L);
    GregorianCalendar createdValue = new GregorianCalendar(1, 1, 1);
    actualHeaderTable.setCreated(createdValue);
    actualHeaderTable.setFlags(42);
    actualHeaderTable.setFontDirectionHint((short) 1);
    actualHeaderTable.setFontRevision(10.0f);
    actualHeaderTable.setGlyphDataFormat((short) 1);
    actualHeaderTable.setIndexToLocFormat((short) 1);
    actualHeaderTable.setLowestRecPPEM(42);
    actualHeaderTable.setMacStyle(42);
    actualHeaderTable.setMagicNumber(42L);
    GregorianCalendar modifiedValue = new GregorianCalendar(1, 1, 1);
    actualHeaderTable.setModified(modifiedValue);
    actualHeaderTable.setUnitsPerEm(42);
    actualHeaderTable.setVersion(10.0f);
    actualHeaderTable.setXMax((short) 1);
    actualHeaderTable.setXMin((short) 1);
    actualHeaderTable.setYMax((short) 1);
    actualHeaderTable.setYMin((short) 1);
    long actualCheckSumAdjustment = actualHeaderTable.getCheckSumAdjustment();
    Calendar actualCreated = actualHeaderTable.getCreated();
    int actualFlags = actualHeaderTable.getFlags();
    short actualFontDirectionHint = actualHeaderTable.getFontDirectionHint();
    float actualFontRevision = actualHeaderTable.getFontRevision();
    short actualGlyphDataFormat = actualHeaderTable.getGlyphDataFormat();
    short actualIndexToLocFormat = actualHeaderTable.getIndexToLocFormat();
    int actualLowestRecPPEM = actualHeaderTable.getLowestRecPPEM();
    int actualMacStyle = actualHeaderTable.getMacStyle();
    long actualMagicNumber = actualHeaderTable.getMagicNumber();
    Calendar actualModified = actualHeaderTable.getModified();
    int actualUnitsPerEm = actualHeaderTable.getUnitsPerEm();
    float actualVersion = actualHeaderTable.getVersion();
    short actualXMax = actualHeaderTable.getXMax();
    short actualXMin = actualHeaderTable.getXMin();
    short actualYMax = actualHeaderTable.getYMax();
    short actualYMin = actualHeaderTable.getYMin();

    // Assert
    assertNull(actualHeaderTable.getTag());
    assertEquals(0L, actualHeaderTable.getCheckSum());
    assertEquals(0L, actualHeaderTable.getLength());
    assertEquals(0L, actualHeaderTable.getOffset());
    assertEquals(10.0f, actualFontRevision);
    assertEquals(10.0f, actualVersion);
    assertEquals((short) 1, actualFontDirectionHint);
    assertEquals((short) 1, actualGlyphDataFormat);
    assertEquals((short) 1, actualIndexToLocFormat);
    assertEquals((short) 1, actualXMax);
    assertEquals((short) 1, actualXMin);
    assertEquals((short) 1, actualYMax);
    assertEquals((short) 1, actualYMin);
    assertEquals(42, actualFlags);
    assertEquals(42, actualLowestRecPPEM);
    assertEquals(42, actualMacStyle);
    assertEquals(42, actualUnitsPerEm);
    assertEquals(42L, actualCheckSumAdjustment);
    assertEquals(42L, actualMagicNumber);
    assertFalse(actualHeaderTable.getInitialized());
    assertSame(createdValue, actualCreated);
    assertSame(modifiedValue, actualModified);
  }

  /**
   * Test {@link HeaderTable#readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)}.
   *
   * <ul>
   *   <li>Then {@link HeaderTable#HeaderTable()} MacStyle is one.
   * </ul>
   *
   * <p>Method under test: {@link HeaderTable#readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)}
   */
  @Test
  @DisplayName(
      "Test readHeaders(TrueTypeFont, TTFDataStream, FontHeaders); then HeaderTable() MacStyle is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HeaderTable.readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)"})
  void testReadHeaders_thenHeaderTableMacStyleIsOne() throws IOException {
    // Arrange
    HeaderTable headerTable = new HeaderTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.getCurrentPosition()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");
    outHeaders.setHeaderMacStyle(1);
    outHeaders.setIsOTFAndPostScript(true);
    outHeaders.setName("Name");
    outHeaders.setNonOtfGcid142("AXAXAXAX".getBytes("UTF-8"));
    outHeaders.setOs2Windows(new OS2WindowsMetricsTable());

    // Act
    headerTable.readHeaders(ttf, data, outHeaders);

    // Assert
    verify(data).getCurrentPosition();
    verify(data).seek(45L);
    verify(data).readUnsignedShort();
    assertEquals(1, headerTable.getMacStyle());
  }

  /**
   * Test {@link HeaderTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then {@link HeaderTable#HeaderTable()} Created {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link HeaderTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given ten; then HeaderTable() Created GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HeaderTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenTen_thenHeaderTableCreatedGregorianCalendar() throws IOException {
    // Arrange
    HeaderTable headerTable = new HeaderTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read32Fixed()).thenReturn(10.0f);
    when(data.readUnsignedShort()).thenReturn(1);
    GregorianCalendar gregorianCalendar = new GregorianCalendar(1, 1, 1);
    when(data.readInternationalDate()).thenReturn(gregorianCalendar);
    when(data.readUnsignedInt()).thenReturn(1L);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    headerTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).read32Fixed();
    verify(data, atLeast(1)).readInternationalDate();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedInt();
    verify(data, atLeast(1)).readUnsignedShort();
    Calendar created = headerTable.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    assertEquals(1, headerTable.getFlags());
    assertEquals(1, headerTable.getLowestRecPPEM());
    assertEquals(1, headerTable.getMacStyle());
    assertEquals(1, headerTable.getUnitsPerEm());
    assertEquals(10.0f, headerTable.getFontRevision());
    assertEquals(10.0f, headerTable.getVersion());
    assertEquals(1L, headerTable.getCheckSumAdjustment());
    assertEquals(1L, headerTable.getMagicNumber());
    assertEquals((short) 1, headerTable.getFontDirectionHint());
    assertEquals((short) 1, headerTable.getGlyphDataFormat());
    assertEquals((short) 1, headerTable.getIndexToLocFormat());
    assertEquals((short) 1, headerTable.getXMax());
    assertEquals((short) 1, headerTable.getXMin());
    assertEquals((short) 1, headerTable.getYMax());
    assertEquals((short) 1, headerTable.getYMin());
    assertTrue(headerTable.getInitialized());
    assertSame(gregorianCalendar, created);
    assertSame(gregorianCalendar, headerTable.getModified());
  }
}
