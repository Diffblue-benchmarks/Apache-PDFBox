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

class VerticalHeaderTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link VerticalHeaderTable}
   *   <li>{@link VerticalHeaderTable#getAdvanceHeightMax()}
   *   <li>{@link VerticalHeaderTable#getAscender()}
   *   <li>{@link VerticalHeaderTable#getCaretOffset()}
   *   <li>{@link VerticalHeaderTable#getCaretSlopeRise()}
   *   <li>{@link VerticalHeaderTable#getCaretSlopeRun()}
   *   <li>{@link VerticalHeaderTable#getDescender()}
   *   <li>{@link VerticalHeaderTable#getLineGap()}
   *   <li>{@link VerticalHeaderTable#getMetricDataFormat()}
   *   <li>{@link VerticalHeaderTable#getMinBottomSideBearing()}
   *   <li>{@link VerticalHeaderTable#getMinTopSideBearing()}
   *   <li>{@link VerticalHeaderTable#getNumberOfVMetrics()}
   *   <li>{@link VerticalHeaderTable#getReserved1()}
   *   <li>{@link VerticalHeaderTable#getReserved2()}
   *   <li>{@link VerticalHeaderTable#getReserved3()}
   *   <li>{@link VerticalHeaderTable#getReserved4()}
   *   <li>{@link VerticalHeaderTable#getVersion()}
   *   <li>{@link VerticalHeaderTable#getYMaxExtent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VerticalHeaderTable.<init>()",
    "int VerticalHeaderTable.getAdvanceHeightMax()",
    "short VerticalHeaderTable.getAscender()",
    "short VerticalHeaderTable.getCaretOffset()",
    "short VerticalHeaderTable.getCaretSlopeRise()",
    "short VerticalHeaderTable.getCaretSlopeRun()",
    "short VerticalHeaderTable.getDescender()",
    "short VerticalHeaderTable.getLineGap()",
    "short VerticalHeaderTable.getMetricDataFormat()",
    "short VerticalHeaderTable.getMinBottomSideBearing()",
    "short VerticalHeaderTable.getMinTopSideBearing()",
    "int VerticalHeaderTable.getNumberOfVMetrics()",
    "short VerticalHeaderTable.getReserved1()",
    "short VerticalHeaderTable.getReserved2()",
    "short VerticalHeaderTable.getReserved3()",
    "short VerticalHeaderTable.getReserved4()",
    "float VerticalHeaderTable.getVersion()",
    "short VerticalHeaderTable.getYMaxExtent()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    VerticalHeaderTable actualVerticalHeaderTable = new VerticalHeaderTable();
    int actualAdvanceHeightMax = actualVerticalHeaderTable.getAdvanceHeightMax();
    short actualAscender = actualVerticalHeaderTable.getAscender();
    short actualCaretOffset = actualVerticalHeaderTable.getCaretOffset();
    short actualCaretSlopeRise = actualVerticalHeaderTable.getCaretSlopeRise();
    short actualCaretSlopeRun = actualVerticalHeaderTable.getCaretSlopeRun();
    short actualDescender = actualVerticalHeaderTable.getDescender();
    short actualLineGap = actualVerticalHeaderTable.getLineGap();
    short actualMetricDataFormat = actualVerticalHeaderTable.getMetricDataFormat();
    short actualMinBottomSideBearing = actualVerticalHeaderTable.getMinBottomSideBearing();
    short actualMinTopSideBearing = actualVerticalHeaderTable.getMinTopSideBearing();
    int actualNumberOfVMetrics = actualVerticalHeaderTable.getNumberOfVMetrics();
    short actualReserved1 = actualVerticalHeaderTable.getReserved1();
    short actualReserved2 = actualVerticalHeaderTable.getReserved2();
    short actualReserved3 = actualVerticalHeaderTable.getReserved3();
    short actualReserved4 = actualVerticalHeaderTable.getReserved4();
    float actualVersion = actualVerticalHeaderTable.getVersion();
    short actualYMaxExtent = actualVerticalHeaderTable.getYMaxExtent();

    // Assert
    assertNull(actualVerticalHeaderTable.getTag());
    assertEquals(0, actualAdvanceHeightMax);
    assertEquals(0, actualNumberOfVMetrics);
    assertEquals(0.0f, actualVersion);
    assertEquals(0L, actualVerticalHeaderTable.getCheckSum());
    assertEquals(0L, actualVerticalHeaderTable.getLength());
    assertEquals(0L, actualVerticalHeaderTable.getOffset());
    assertEquals((short) 0, actualAscender);
    assertEquals((short) 0, actualCaretOffset);
    assertEquals((short) 0, actualCaretSlopeRise);
    assertEquals((short) 0, actualCaretSlopeRun);
    assertEquals((short) 0, actualDescender);
    assertEquals((short) 0, actualLineGap);
    assertEquals((short) 0, actualMetricDataFormat);
    assertEquals((short) 0, actualMinBottomSideBearing);
    assertEquals((short) 0, actualMinTopSideBearing);
    assertEquals((short) 0, actualReserved1);
    assertEquals((short) 0, actualReserved2);
    assertEquals((short) 0, actualReserved3);
    assertEquals((short) 0, actualReserved4);
    assertEquals((short) 0, actualYMaxExtent);
    assertFalse(actualVerticalHeaderTable.getInitialized());
  }

  /**
   * Test {@link VerticalHeaderTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then {@link VerticalHeaderTable#VerticalHeaderTable()} AdvanceHeightMax is one.
   * </ul>
   *
   * <p>Method under test: {@link VerticalHeaderTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given ten; then VerticalHeaderTable() AdvanceHeightMax is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VerticalHeaderTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenTen_thenVerticalHeaderTableAdvanceHeightMaxIsOne() throws IOException {
    // Arrange
    VerticalHeaderTable verticalHeaderTable = new VerticalHeaderTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read32Fixed()).thenReturn(10.0f);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    verticalHeaderTable.read(ttf, data);

    // Assert
    verify(data).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedShort();
    assertEquals(1, verticalHeaderTable.getAdvanceHeightMax());
    assertEquals(1, verticalHeaderTable.getNumberOfVMetrics());
    assertEquals(10.0f, verticalHeaderTable.getVersion());
    assertEquals((short) 1, verticalHeaderTable.getAscender());
    assertEquals((short) 1, verticalHeaderTable.getCaretOffset());
    assertEquals((short) 1, verticalHeaderTable.getCaretSlopeRise());
    assertEquals((short) 1, verticalHeaderTable.getCaretSlopeRun());
    assertEquals((short) 1, verticalHeaderTable.getDescender());
    assertEquals((short) 1, verticalHeaderTable.getLineGap());
    assertEquals((short) 1, verticalHeaderTable.getMetricDataFormat());
    assertEquals((short) 1, verticalHeaderTable.getMinBottomSideBearing());
    assertEquals((short) 1, verticalHeaderTable.getMinTopSideBearing());
    assertEquals((short) 1, verticalHeaderTable.getReserved1());
    assertEquals((short) 1, verticalHeaderTable.getReserved2());
    assertEquals((short) 1, verticalHeaderTable.getReserved3());
    assertEquals((short) 1, verticalHeaderTable.getReserved4());
    assertEquals((short) 1, verticalHeaderTable.getYMaxExtent());
    assertTrue(verticalHeaderTable.getInitialized());
  }
}
