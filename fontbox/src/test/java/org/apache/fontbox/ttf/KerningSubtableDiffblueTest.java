package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class KerningSubtableDiffblueTest {
  /**
   * Method under test: {@link KerningSubtable#read(TTFDataStream, int)}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    KerningSubtable kerningSubtable = new KerningSubtable();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> kerningSubtable.read(
            new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))),
            OS2WindowsMetricsTable.WEIGHT_CLASS_NORMAL));
  }

  /**
   * Method under test: {@link KerningSubtable#read(TTFDataStream, int)}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    KerningSubtable kerningSubtable = new KerningSubtable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    kerningSubtable.read(new RandomAccessReadDataStream(inputStream), 1);

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link KerningSubtable#isHorizontalKerning()}
   */
  @Test
  void testIsHorizontalKerning() {
    // Arrange, Act and Assert
    assertFalse((new KerningSubtable()).isHorizontalKerning());
    assertFalse((new KerningSubtable()).isHorizontalKerning(true));
  }

  /**
   * Method under test: {@link KerningSubtable#getKerning(int, int)}
   */
  @Test
  void testGetKerning() {
    // Arrange, Act and Assert
    assertEquals(0, (new KerningSubtable()).getKerning(3, 3));
    assertEquals(0, (new KerningSubtable()).getKerning(OS2WindowsMetricsTable.WEIGHT_CLASS_LIGHT, 3));
    assertEquals(0, (new KerningSubtable()).getKerning(OS2WindowsMetricsTable.WEIGHT_CLASS_NORMAL, 3));
    assertEquals(0, (new KerningSubtable()).getKerning(1, 3));
    assertNull((new KerningSubtable()).getKerning(new int[]{1, 0, 1, 0}));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link KerningSubtable}
   */
  @Test
  void testNewKerningSubtable() {
    // Arrange, Act and Assert
    assertFalse((new KerningSubtable()).isHorizontalKerning());
  }
}
