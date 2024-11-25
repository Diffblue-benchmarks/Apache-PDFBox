package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CMapManagerDiffblueTest {
  /**
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code % A%AXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with '% A%AXAX' Bytes is 'UTF-8'; then return Name is 'null'")
  void testParseCMap_whenByteArrayInputStreamWithAAxaxBytesIsUtf8_thenReturnNameIsNull() throws IOException {
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

  /**
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code % AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with '% AXAXAX' Bytes is 'UTF-8'; then return Name is 'null'")
  void testParseCMap_whenByteArrayInputStreamWithAxaxaxBytesIsUtf8_thenReturnNameIsNull() throws IOException {
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
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testParseCMap_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
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
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  void testParseCMap_whenByteArrayInputStreamWithXaxaxaxBytesIsUtf8() throws IOException {
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
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  void testParseCMap_whenByteArrayInputStreamWithXaxaxaxBytesIsUtf82() throws IOException {
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
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  void testParseCMap_whenByteArrayInputStreamWithXaxaxaxBytesIsUtf83() throws IOException {
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
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  void testParseCMap_whenByteArrayInputStreamWithXaxaxaxBytesIsUtf84() throws IOException {
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
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code %XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with '%XAXAXAX' Bytes is 'UTF-8'")
  void testParseCMap_whenByteArrayInputStreamWithXaxaxaxBytesIsUtf85() throws IOException {
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
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead); when 'null'; then return 'null'")
  void testParseCMap_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(CMapManager.parseCMap(null));
  }
}
