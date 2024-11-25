package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VerticalMetricsTableDiffblueTest {
  /**
   * Test {@link VerticalMetricsTable#VerticalMetricsTable()}.
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link VerticalMetricsTable}
   */
  @Test
  @DisplayName("Test new VerticalMetricsTable()")
  void testNewVerticalMetricsTable() {
    // Arrange and Act
    VerticalMetricsTable actualVerticalMetricsTable = new VerticalMetricsTable();

    // Assert
    assertNull(actualVerticalMetricsTable.getTag());
    assertEquals(0L, actualVerticalMetricsTable.getCheckSum());
    assertEquals(0L, actualVerticalMetricsTable.getLength());
    assertEquals(0L, actualVerticalMetricsTable.getOffset());
    assertFalse(actualVerticalMetricsTable.getInitialized());
  }

  /**
   * Test {@link VerticalMetricsTable#read(TrueTypeFont, TTFDataStream)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link VerticalMetricsTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then throw IOException")
  void testRead_thenThrowIOException() throws IOException {
    // Arrange
    VerticalMetricsTable verticalMetricsTable = new VerticalMetricsTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> verticalMetricsTable.read(ttf,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }
}
