package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class HorizontalHeaderTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link HorizontalHeaderTable}
   *   <li>{@link HorizontalHeaderTable#setAdvanceWidthMax(int)}
   *   <li>{@link HorizontalHeaderTable#setAscender(short)}
   *   <li>{@link HorizontalHeaderTable#setCaretSlopeRise(short)}
   *   <li>{@link HorizontalHeaderTable#setCaretSlopeRun(short)}
   *   <li>{@link HorizontalHeaderTable#setDescender(short)}
   *   <li>{@link HorizontalHeaderTable#setLineGap(short)}
   *   <li>{@link HorizontalHeaderTable#setMetricDataFormat(short)}
   *   <li>{@link HorizontalHeaderTable#setMinLeftSideBearing(short)}
   *   <li>{@link HorizontalHeaderTable#setMinRightSideBearing(short)}
   *   <li>{@link HorizontalHeaderTable#setNumberOfHMetrics(int)}
   *   <li>{@link HorizontalHeaderTable#setReserved1(short)}
   *   <li>{@link HorizontalHeaderTable#setReserved2(short)}
   *   <li>{@link HorizontalHeaderTable#setReserved3(short)}
   *   <li>{@link HorizontalHeaderTable#setReserved4(short)}
   *   <li>{@link HorizontalHeaderTable#setReserved5(short)}
   *   <li>{@link HorizontalHeaderTable#setVersion(float)}
   *   <li>{@link HorizontalHeaderTable#setXMaxExtent(short)}
   *   <li>{@link HorizontalHeaderTable#getAdvanceWidthMax()}
   *   <li>{@link HorizontalHeaderTable#getAscender()}
   *   <li>{@link HorizontalHeaderTable#getCaretSlopeRise()}
   *   <li>{@link HorizontalHeaderTable#getCaretSlopeRun()}
   *   <li>{@link HorizontalHeaderTable#getDescender()}
   *   <li>{@link HorizontalHeaderTable#getLineGap()}
   *   <li>{@link HorizontalHeaderTable#getMetricDataFormat()}
   *   <li>{@link HorizontalHeaderTable#getMinLeftSideBearing()}
   *   <li>{@link HorizontalHeaderTable#getMinRightSideBearing()}
   *   <li>{@link HorizontalHeaderTable#getNumberOfHMetrics()}
   *   <li>{@link HorizontalHeaderTable#getReserved1()}
   *   <li>{@link HorizontalHeaderTable#getReserved2()}
   *   <li>{@link HorizontalHeaderTable#getReserved3()}
   *   <li>{@link HorizontalHeaderTable#getReserved4()}
   *   <li>{@link HorizontalHeaderTable#getReserved5()}
   *   <li>{@link HorizontalHeaderTable#getVersion()}
   *   <li>{@link HorizontalHeaderTable#getXMaxExtent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HorizontalHeaderTable.<init>()",
    "int HorizontalHeaderTable.getAdvanceWidthMax()",
    "short HorizontalHeaderTable.getAscender()",
    "short HorizontalHeaderTable.getCaretSlopeRise()",
    "short HorizontalHeaderTable.getCaretSlopeRun()",
    "short HorizontalHeaderTable.getDescender()",
    "short HorizontalHeaderTable.getLineGap()",
    "short HorizontalHeaderTable.getMetricDataFormat()",
    "short HorizontalHeaderTable.getMinLeftSideBearing()",
    "short HorizontalHeaderTable.getMinRightSideBearing()",
    "int HorizontalHeaderTable.getNumberOfHMetrics()",
    "short HorizontalHeaderTable.getReserved1()",
    "short HorizontalHeaderTable.getReserved2()",
    "short HorizontalHeaderTable.getReserved3()",
    "short HorizontalHeaderTable.getReserved4()",
    "short HorizontalHeaderTable.getReserved5()",
    "float HorizontalHeaderTable.getVersion()",
    "short HorizontalHeaderTable.getXMaxExtent()",
    "void HorizontalHeaderTable.setAdvanceWidthMax(int)",
    "void HorizontalHeaderTable.setAscender(short)",
    "void HorizontalHeaderTable.setCaretSlopeRise(short)",
    "void HorizontalHeaderTable.setCaretSlopeRun(short)",
    "void HorizontalHeaderTable.setDescender(short)",
    "void HorizontalHeaderTable.setLineGap(short)",
    "void HorizontalHeaderTable.setMetricDataFormat(short)",
    "void HorizontalHeaderTable.setMinLeftSideBearing(short)",
    "void HorizontalHeaderTable.setMinRightSideBearing(short)",
    "void HorizontalHeaderTable.setNumberOfHMetrics(int)",
    "void HorizontalHeaderTable.setReserved1(short)",
    "void HorizontalHeaderTable.setReserved2(short)",
    "void HorizontalHeaderTable.setReserved3(short)",
    "void HorizontalHeaderTable.setReserved4(short)",
    "void HorizontalHeaderTable.setReserved5(short)",
    "void HorizontalHeaderTable.setVersion(float)",
    "void HorizontalHeaderTable.setXMaxExtent(short)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    HorizontalHeaderTable actualHorizontalHeaderTable = new HorizontalHeaderTable();
    actualHorizontalHeaderTable.setAdvanceWidthMax(1);
    actualHorizontalHeaderTable.setAscender((short) 1);
    actualHorizontalHeaderTable.setCaretSlopeRise((short) 1);
    actualHorizontalHeaderTable.setCaretSlopeRun((short) 1);
    actualHorizontalHeaderTable.setDescender((short) 1);
    actualHorizontalHeaderTable.setLineGap((short) 1);
    actualHorizontalHeaderTable.setMetricDataFormat((short) 1);
    actualHorizontalHeaderTable.setMinLeftSideBearing((short) 1);
    actualHorizontalHeaderTable.setMinRightSideBearing((short) 1);
    actualHorizontalHeaderTable.setNumberOfHMetrics(CmapTable.ENCODING_WIN_UNICODE_FULL);
    actualHorizontalHeaderTable.setReserved1((short) 1);
    actualHorizontalHeaderTable.setReserved2((short) 1);
    actualHorizontalHeaderTable.setReserved3((short) 1);
    actualHorizontalHeaderTable.setReserved4((short) 1);
    actualHorizontalHeaderTable.setReserved5((short) 1);
    actualHorizontalHeaderTable.setVersion(10.0f);
    actualHorizontalHeaderTable.setXMaxExtent((short) 1);
    int actualAdvanceWidthMax = actualHorizontalHeaderTable.getAdvanceWidthMax();
    short actualAscender = actualHorizontalHeaderTable.getAscender();
    short actualCaretSlopeRise = actualHorizontalHeaderTable.getCaretSlopeRise();
    short actualCaretSlopeRun = actualHorizontalHeaderTable.getCaretSlopeRun();
    short actualDescender = actualHorizontalHeaderTable.getDescender();
    short actualLineGap = actualHorizontalHeaderTable.getLineGap();
    short actualMetricDataFormat = actualHorizontalHeaderTable.getMetricDataFormat();
    short actualMinLeftSideBearing = actualHorizontalHeaderTable.getMinLeftSideBearing();
    short actualMinRightSideBearing = actualHorizontalHeaderTable.getMinRightSideBearing();
    int actualNumberOfHMetrics = actualHorizontalHeaderTable.getNumberOfHMetrics();
    short actualReserved1 = actualHorizontalHeaderTable.getReserved1();
    short actualReserved2 = actualHorizontalHeaderTable.getReserved2();
    short actualReserved3 = actualHorizontalHeaderTable.getReserved3();
    short actualReserved4 = actualHorizontalHeaderTable.getReserved4();
    short actualReserved5 = actualHorizontalHeaderTable.getReserved5();
    float actualVersion = actualHorizontalHeaderTable.getVersion();
    short actualXMaxExtent = actualHorizontalHeaderTable.getXMaxExtent();

    // Assert
    assertNull(actualHorizontalHeaderTable.getTag());
    assertEquals(0L, actualHorizontalHeaderTable.getCheckSum());
    assertEquals(0L, actualHorizontalHeaderTable.getLength());
    assertEquals(0L, actualHorizontalHeaderTable.getOffset());
    assertEquals(1, actualAdvanceWidthMax);
    assertEquals(10.0f, actualVersion);
    assertEquals((short) 1, actualAscender);
    assertEquals((short) 1, actualCaretSlopeRise);
    assertEquals((short) 1, actualCaretSlopeRun);
    assertEquals((short) 1, actualDescender);
    assertEquals((short) 1, actualLineGap);
    assertEquals((short) 1, actualMetricDataFormat);
    assertEquals((short) 1, actualMinLeftSideBearing);
    assertEquals((short) 1, actualMinRightSideBearing);
    assertEquals((short) 1, actualReserved1);
    assertEquals((short) 1, actualReserved2);
    assertEquals((short) 1, actualReserved3);
    assertEquals((short) 1, actualReserved4);
    assertEquals((short) 1, actualReserved5);
    assertEquals((short) 1, actualXMaxExtent);
    assertFalse(actualHorizontalHeaderTable.getInitialized());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, actualNumberOfHMetrics);
  }

  /**
   * Test {@link HorizontalHeaderTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then {@link HorizontalHeaderTable#HorizontalHeaderTable()} AdvanceWidthMax is one.
   * </ul>
   *
   * <p>Method under test: {@link HorizontalHeaderTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given ten; then HorizontalHeaderTable() AdvanceWidthMax is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HorizontalHeaderTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenTen_thenHorizontalHeaderTableAdvanceWidthMaxIsOne() throws IOException {
    // Arrange
    HorizontalHeaderTable horizontalHeaderTable = new HorizontalHeaderTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read32Fixed()).thenReturn(10.0f);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    horizontalHeaderTable.read(ttf, data);

    // Assert
    verify(data).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedShort();
    assertEquals(1, horizontalHeaderTable.getAdvanceWidthMax());
    assertEquals(1, horizontalHeaderTable.getNumberOfHMetrics());
    assertEquals(10.0f, horizontalHeaderTable.getVersion());
    assertEquals((short) 1, horizontalHeaderTable.getAscender());
    assertEquals((short) 1, horizontalHeaderTable.getCaretSlopeRise());
    assertEquals((short) 1, horizontalHeaderTable.getCaretSlopeRun());
    assertEquals((short) 1, horizontalHeaderTable.getDescender());
    assertEquals((short) 1, horizontalHeaderTable.getLineGap());
    assertEquals((short) 1, horizontalHeaderTable.getMetricDataFormat());
    assertEquals((short) 1, horizontalHeaderTable.getMinLeftSideBearing());
    assertEquals((short) 1, horizontalHeaderTable.getMinRightSideBearing());
    assertEquals((short) 1, horizontalHeaderTable.getReserved1());
    assertEquals((short) 1, horizontalHeaderTable.getReserved2());
    assertEquals((short) 1, horizontalHeaderTable.getReserved3());
    assertEquals((short) 1, horizontalHeaderTable.getReserved4());
    assertEquals((short) 1, horizontalHeaderTable.getReserved5());
    assertEquals((short) 1, horizontalHeaderTable.getXMaxExtent());
    assertTrue(horizontalHeaderTable.getInitialized());
  }
}
