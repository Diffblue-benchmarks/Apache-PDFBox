package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class KerningTableDiffblueTest {
  /**
   * Method under test: {@link KerningTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead() throws IOException {
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
   * Method under test: {@link KerningTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    KerningTable kerningTable = new KerningTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));

    // Act
    kerningTable.read(ttf, new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    verify(inputStream).readAllBytes();
    assertTrue(kerningTable.getInitialized());
  }

  /**
   * Method under test: {@link KerningTable#getHorizontalKerningSubtable()}
   */
  @Test
  void testGetHorizontalKerningSubtable() {
    // Arrange, Act and Assert
    assertNull((new KerningTable()).getHorizontalKerningSubtable());
    assertNull((new KerningTable()).getHorizontalKerningSubtable(true));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link KerningTable}
   */
  @Test
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
}
