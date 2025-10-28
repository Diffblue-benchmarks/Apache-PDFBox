package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;

class CMapManagerDiffblueTest {
  /**
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  void testParseCMap() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    CMap actualParseCMapResult = CMapManager.parseCMap(randomAccessRead);

    // Assert
    assertNull(actualParseCMapResult.getName());
    assertNull(actualParseCMapResult.getOrdering());
    assertNull(actualParseCMapResult.getRegistry());
    assertNull(actualParseCMapResult.getVersion());
    assertNull(actualParseCMapResult.toString());
    assertEquals(-1, actualParseCMapResult.getSpaceMapping());
    assertEquals(-1, actualParseCMapResult.getType());
    assertEquals(0, actualParseCMapResult.getSupplement());
    assertEquals(0, actualParseCMapResult.getWMode());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(actualParseCMapResult.hasCIDMappings());
    assertFalse(actualParseCMapResult.hasUnicodeMappings());
  }

  /**
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  void testParseCMap2() throws IOException {
    // Arrange, Act and Assert
    assertNull(CMapManager.parseCMap(null));
  }

  /**
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  void testParseCMap3() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("\tXAXAXAX".getBytes("UTF-8")));

    // Act
    CMap actualParseCMapResult = CMapManager.parseCMap(randomAccessRead);

    // Assert
    assertNull(actualParseCMapResult.getName());
    assertNull(actualParseCMapResult.getOrdering());
    assertNull(actualParseCMapResult.getRegistry());
    assertNull(actualParseCMapResult.getVersion());
    assertNull(actualParseCMapResult.toString());
    assertEquals(-1, actualParseCMapResult.getSpaceMapping());
    assertEquals(-1, actualParseCMapResult.getType());
    assertEquals(0, actualParseCMapResult.getSupplement());
    assertEquals(0, actualParseCMapResult.getWMode());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(actualParseCMapResult.hasCIDMappings());
    assertFalse(actualParseCMapResult.hasUnicodeMappings());
  }

  /**
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  void testParseCMap4() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream(" XAXAXAX".getBytes("UTF-8")));

    // Act
    CMap actualParseCMapResult = CMapManager.parseCMap(randomAccessRead);

    // Assert
    assertNull(actualParseCMapResult.getName());
    assertNull(actualParseCMapResult.getOrdering());
    assertNull(actualParseCMapResult.getRegistry());
    assertNull(actualParseCMapResult.getVersion());
    assertNull(actualParseCMapResult.toString());
    assertEquals(-1, actualParseCMapResult.getSpaceMapping());
    assertEquals(-1, actualParseCMapResult.getType());
    assertEquals(0, actualParseCMapResult.getSupplement());
    assertEquals(0, actualParseCMapResult.getWMode());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(actualParseCMapResult.hasCIDMappings());
    assertFalse(actualParseCMapResult.hasUnicodeMappings());
  }

  /**
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  void testParseCMap5() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("\rXAXAXAX".getBytes("UTF-8")));

    // Act
    CMap actualParseCMapResult = CMapManager.parseCMap(randomAccessRead);

    // Assert
    assertNull(actualParseCMapResult.getName());
    assertNull(actualParseCMapResult.getOrdering());
    assertNull(actualParseCMapResult.getRegistry());
    assertNull(actualParseCMapResult.getVersion());
    assertNull(actualParseCMapResult.toString());
    assertEquals(-1, actualParseCMapResult.getSpaceMapping());
    assertEquals(-1, actualParseCMapResult.getType());
    assertEquals(0, actualParseCMapResult.getSupplement());
    assertEquals(0, actualParseCMapResult.getWMode());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(actualParseCMapResult.hasCIDMappings());
    assertFalse(actualParseCMapResult.hasUnicodeMappings());
  }

  /**
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  void testParseCMap6() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8")));

    // Act
    CMap actualParseCMapResult = CMapManager.parseCMap(randomAccessRead);

    // Assert
    assertNull(actualParseCMapResult.getName());
    assertNull(actualParseCMapResult.getOrdering());
    assertNull(actualParseCMapResult.getRegistry());
    assertNull(actualParseCMapResult.getVersion());
    assertNull(actualParseCMapResult.toString());
    assertEquals(-1, actualParseCMapResult.getSpaceMapping());
    assertEquals(-1, actualParseCMapResult.getType());
    assertEquals(0, actualParseCMapResult.getSupplement());
    assertEquals(0, actualParseCMapResult.getWMode());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(actualParseCMapResult.hasCIDMappings());
    assertFalse(actualParseCMapResult.hasUnicodeMappings());
  }

  /**
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  void testParseCMap7() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("%XAXAXAX".getBytes("UTF-8")));

    // Act
    CMap actualParseCMapResult = CMapManager.parseCMap(randomAccessRead);

    // Assert
    assertNull(actualParseCMapResult.getName());
    assertNull(actualParseCMapResult.getOrdering());
    assertNull(actualParseCMapResult.getRegistry());
    assertNull(actualParseCMapResult.getVersion());
    assertNull(actualParseCMapResult.toString());
    assertEquals(-1, actualParseCMapResult.getSpaceMapping());
    assertEquals(-1, actualParseCMapResult.getType());
    assertEquals(0, actualParseCMapResult.getSupplement());
    assertEquals(0, actualParseCMapResult.getWMode());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(actualParseCMapResult.hasCIDMappings());
    assertFalse(actualParseCMapResult.hasUnicodeMappings());
  }

  /**
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  void testParseCMap8() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("%\rAXAXAX".getBytes("UTF-8")));

    // Act
    CMap actualParseCMapResult = CMapManager.parseCMap(randomAccessRead);

    // Assert
    assertNull(actualParseCMapResult.getName());
    assertNull(actualParseCMapResult.getOrdering());
    assertNull(actualParseCMapResult.getRegistry());
    assertNull(actualParseCMapResult.getVersion());
    assertNull(actualParseCMapResult.toString());
    assertEquals(-1, actualParseCMapResult.getSpaceMapping());
    assertEquals(-1, actualParseCMapResult.getType());
    assertEquals(0, actualParseCMapResult.getSupplement());
    assertEquals(0, actualParseCMapResult.getWMode());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(actualParseCMapResult.hasCIDMappings());
    assertFalse(actualParseCMapResult.hasUnicodeMappings());
  }

  /**
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  void testParseCMap9() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("%\rA%AXAX".getBytes("UTF-8")));

    // Act
    CMap actualParseCMapResult = CMapManager.parseCMap(randomAccessRead);

    // Assert
    assertNull(actualParseCMapResult.getName());
    assertNull(actualParseCMapResult.getOrdering());
    assertNull(actualParseCMapResult.getRegistry());
    assertNull(actualParseCMapResult.getVersion());
    assertNull(actualParseCMapResult.toString());
    assertEquals(-1, actualParseCMapResult.getSpaceMapping());
    assertEquals(-1, actualParseCMapResult.getType());
    assertEquals(0, actualParseCMapResult.getSupplement());
    assertEquals(0, actualParseCMapResult.getWMode());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(actualParseCMapResult.hasCIDMappings());
    assertFalse(actualParseCMapResult.hasUnicodeMappings());
  }
}
