package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class HorizontalMetricsTableDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link HorizontalMetricsTable}
   */
  @Test
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
   * Method under test:
   * {@link HorizontalMetricsTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    HorizontalMetricsTable horizontalMetricsTable = new HorizontalMetricsTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> horizontalMetricsTable.read(ttf,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }
}
