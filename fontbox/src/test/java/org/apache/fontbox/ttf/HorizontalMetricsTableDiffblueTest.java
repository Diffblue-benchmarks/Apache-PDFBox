package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HorizontalMetricsTableDiffblueTest {
  /**
   * Test {@link HorizontalMetricsTable#HorizontalMetricsTable()}.
   * <p>
   * Method under test: default or parameterless constructor of {@link HorizontalMetricsTable}
   */
  @Test
  @DisplayName("Test new HorizontalMetricsTable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HorizontalMetricsTable.<init>()"})
  void testNewHorizontalMetricsTable() {
    // Arrange and Act
    HorizontalMetricsTable actualHorizontalMetricsTable = new HorizontalMetricsTable();

    // Assert
    assertNull(actualHorizontalMetricsTable.getTag());
    assertEquals(0L, actualHorizontalMetricsTable.getCheckSum());
    assertEquals(0L, actualHorizontalMetricsTable.getLength());
    assertEquals(0L, actualHorizontalMetricsTable.getOffset());
    assertFalse(actualHorizontalMetricsTable.getInitialized());
  }

  /**
   * Test {@link HorizontalMetricsTable#read(TrueTypeFont, TTFDataStream)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HorizontalMetricsTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HorizontalMetricsTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenThrowIOException() throws IOException {
    // Arrange
    HorizontalMetricsTable horizontalMetricsTable = new HorizontalMetricsTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> horizontalMetricsTable.read(ttf,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }
}
