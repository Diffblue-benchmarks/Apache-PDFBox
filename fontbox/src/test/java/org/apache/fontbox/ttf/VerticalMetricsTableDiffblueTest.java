package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class VerticalMetricsTableDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link VerticalMetricsTable}
   */
  @Test
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
   * Method under test:
   * {@link VerticalMetricsTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    VerticalMetricsTable verticalMetricsTable = new VerticalMetricsTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> verticalMetricsTable.read(ttf,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }
}
