package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VerticalMetricsTableDiffblueTest {
  /**
   * Test {@link VerticalMetricsTable#VerticalMetricsTable()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link VerticalMetricsTable}
   */
  @Test
  @DisplayName("Test new VerticalMetricsTable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VerticalMetricsTable.<init>()"})
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
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link VerticalMetricsTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VerticalMetricsTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenThrowIOException() throws IOException {
    // Arrange
    VerticalMetricsTable verticalMetricsTable = new VerticalMetricsTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            verticalMetricsTable.read(
                ttf,
                new RandomAccessReadDataStream(
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }
}
