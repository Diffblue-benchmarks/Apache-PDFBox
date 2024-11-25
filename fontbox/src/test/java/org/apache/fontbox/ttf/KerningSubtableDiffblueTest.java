package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KerningSubtableDiffblueTest {
  /**
   * Test {@link KerningSubtable#KerningSubtable()}.
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link KerningSubtable}
   */
  @Test
  @DisplayName("Test new KerningSubtable()")
  void testNewKerningSubtable() {
    // Arrange, Act and Assert
    assertFalse((new KerningSubtable()).isHorizontalKerning());
  }

  /**
   * Test {@link KerningSubtable#read(TTFDataStream, int)}.
   * <ul>
   *   <li>When {@link OS2WindowsMetricsTable#WEIGHT_CLASS_NORMAL}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KerningSubtable#read(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test read(TTFDataStream, int); when WEIGHT_CLASS_NORMAL; then throw IllegalStateException")
  void testRead_whenWeight_class_normal_thenThrowIllegalStateException() throws IOException {
    // Arrange
    KerningSubtable kerningSubtable = new KerningSubtable();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> kerningSubtable.read(
            new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))),
            OS2WindowsMetricsTable.WEIGHT_CLASS_NORMAL));
  }

  /**
   * Test {@link KerningSubtable#isHorizontalKerning()}.
   * <p>
   * Method under test: {@link KerningSubtable#isHorizontalKerning()}
   */
  @Test
  @DisplayName("Test isHorizontalKerning()")
  void testIsHorizontalKerning() {
    // Arrange, Act and Assert
    assertFalse((new KerningSubtable()).isHorizontalKerning());
  }

  /**
   * Test {@link KerningSubtable#isHorizontalKerning(boolean)} with
   * {@code boolean}.
   * <p>
   * Method under test: {@link KerningSubtable#isHorizontalKerning(boolean)}
   */
  @Test
  @DisplayName("Test isHorizontalKerning(boolean) with 'boolean'")
  void testIsHorizontalKerningWithBoolean() {
    // Arrange, Act and Assert
    assertFalse((new KerningSubtable()).isHorizontalKerning(true));
  }

  /**
   * Test {@link KerningSubtable#getKerning(int[])} with {@code glyphs}.
   * <p>
   * Method under test: {@link KerningSubtable#getKerning(int[])}
   */
  @Test
  @DisplayName("Test getKerning(int[]) with 'glyphs'")
  void testGetKerningWithGlyphs() {
    // Arrange, Act and Assert
    assertNull((new KerningSubtable()).getKerning(new int[]{1, 0, 1, 0}));
  }

  /**
   * Test {@link KerningSubtable#getKerning(int, int)} with {@code l}, {@code r}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link KerningSubtable#getKerning(int, int)}
   */
  @Test
  @DisplayName("Test getKerning(int, int) with 'l', 'r'; when one")
  void testGetKerningWithLR_whenOne() {
    // Arrange, Act and Assert
    assertEquals(0, (new KerningSubtable()).getKerning(1, 3));
  }

  /**
   * Test {@link KerningSubtable#getKerning(int, int)} with {@code l}, {@code r}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test: {@link KerningSubtable#getKerning(int, int)}
   */
  @Test
  @DisplayName("Test getKerning(int, int) with 'l', 'r'; when three")
  void testGetKerningWithLR_whenThree() {
    // Arrange, Act and Assert
    assertEquals(0, (new KerningSubtable()).getKerning(3, 3));
  }

  /**
   * Test {@link KerningSubtable#getKerning(int, int)} with {@code l}, {@code r}.
   * <ul>
   *   <li>When {@link OS2WindowsMetricsTable#WEIGHT_CLASS_LIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KerningSubtable#getKerning(int, int)}
   */
  @Test
  @DisplayName("Test getKerning(int, int) with 'l', 'r'; when WEIGHT_CLASS_LIGHT")
  void testGetKerningWithLR_whenWeight_class_light() {
    // Arrange, Act and Assert
    assertEquals(0, (new KerningSubtable()).getKerning(OS2WindowsMetricsTable.WEIGHT_CLASS_LIGHT, 3));
  }

  /**
   * Test {@link KerningSubtable#getKerning(int, int)} with {@code l}, {@code r}.
   * <ul>
   *   <li>When {@link OS2WindowsMetricsTable#WEIGHT_CLASS_NORMAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KerningSubtable#getKerning(int, int)}
   */
  @Test
  @DisplayName("Test getKerning(int, int) with 'l', 'r'; when WEIGHT_CLASS_NORMAL")
  void testGetKerningWithLR_whenWeight_class_normal() {
    // Arrange, Act and Assert
    assertEquals(0, (new KerningSubtable()).getKerning(OS2WindowsMetricsTable.WEIGHT_CLASS_NORMAL, 3));
  }
}
