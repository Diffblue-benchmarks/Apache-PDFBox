package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KerningTableDiffblueTest {
  /**
   * Test {@link KerningTable#KerningTable()}.
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link KerningTable}
   */
  @Test
  @DisplayName("Test new KerningTable()")
  void testNewKerningTable() {
    // Arrange and Act
    KerningTable actualKerningTable = new KerningTable();

    // Assert
    assertNull(actualKerningTable.getTag());
    assertEquals(0L, actualKerningTable.getCheckSum());
    assertEquals(0L, actualKerningTable.getLength());
    assertEquals(0L, actualKerningTable.getOffset());
    assertFalse(actualKerningTable.getInitialized());
  }

  /**
   * Test {@link KerningTable#read(TrueTypeFont, TTFDataStream)}.
   * <ul>
   *   <li>Then {@link KerningTable#KerningTable()} Initialized.</li>
   * </ul>
   * <p>
   * Method under test: {@link KerningTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then KerningTable() Initialized")
  void testRead_thenKerningTableInitialized() throws IOException {
    // Arrange
    KerningTable kerningTable = new KerningTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    kerningTable.read(ttf, new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertTrue(kerningTable.getInitialized());
  }

  /**
   * Test {@link KerningTable#getHorizontalKerningSubtable()}.
   * <p>
   * Method under test: {@link KerningTable#getHorizontalKerningSubtable()}
   */
  @Test
  @DisplayName("Test getHorizontalKerningSubtable()")
  void testGetHorizontalKerningSubtable() {
    // Arrange, Act and Assert
    assertNull((new KerningTable()).getHorizontalKerningSubtable());
  }

  /**
   * Test {@link KerningTable#getHorizontalKerningSubtable(boolean)} with
   * {@code boolean}.
   * <p>
   * Method under test: {@link KerningTable#getHorizontalKerningSubtable(boolean)}
   */
  @Test
  @DisplayName("Test getHorizontalKerningSubtable(boolean) with 'boolean'")
  void testGetHorizontalKerningSubtableWithBoolean() {
    // Arrange, Act and Assert
    assertNull((new KerningTable()).getHorizontalKerningSubtable(true));
  }
}
