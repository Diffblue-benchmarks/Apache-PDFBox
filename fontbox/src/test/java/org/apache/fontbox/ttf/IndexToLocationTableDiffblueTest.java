package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexToLocationTableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexToLocationTable}
   *   <li>{@link IndexToLocationTable#setOffsets(long[])}
   *   <li>{@link IndexToLocationTable#getOffsets()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    IndexToLocationTable actualIndexToLocationTable = new IndexToLocationTable();
    long[] offsetsValue = new long[]{42L, 1L, 42L, 1L};
    actualIndexToLocationTable.setOffsets(offsetsValue);
    long[] actualOffsets = actualIndexToLocationTable.getOffsets();

    // Assert that nothing has changed
    assertEquals(0L, actualIndexToLocationTable.getCheckSum());
    assertEquals(0L, actualIndexToLocationTable.getLength());
    assertEquals(0L, actualIndexToLocationTable.getOffset());
    assertFalse(actualIndexToLocationTable.getInitialized());
    assertSame(offsetsValue, actualOffsets);
  }

  /**
   * Test {@link IndexToLocationTable#read(TrueTypeFont, TTFDataStream)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexToLocationTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then throw IOException")
  void testRead_thenThrowIOException() throws IOException {
    // Arrange
    IndexToLocationTable indexToLocationTable = new IndexToLocationTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> indexToLocationTable.read(ttf,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }
}
