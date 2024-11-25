package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomAccessReadMemoryMappedFileDiffblueTest {
  /**
   * Test
   * {@link RandomAccessReadMemoryMappedFile#RandomAccessReadMemoryMappedFile(File)}.
   * <ul>
   *   <li>Then return available is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RandomAccessReadMemoryMappedFile#RandomAccessReadMemoryMappedFile(File)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadMemoryMappedFile(File); then return available is zero")
  void testNewRandomAccessReadMemoryMappedFile_thenReturnAvailableIsZero() throws IOException {
    // Arrange and Act
    RandomAccessReadMemoryMappedFile actualRandomAccessReadMemoryMappedFile = new RandomAccessReadMemoryMappedFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    assertEquals(0, actualRandomAccessReadMemoryMappedFile.available());
    assertEquals(0L, actualRandomAccessReadMemoryMappedFile.getPosition());
    assertFalse(actualRandomAccessReadMemoryMappedFile.isClosed());
  }

  /**
   * Test
   * {@link RandomAccessReadMemoryMappedFile#RandomAccessReadMemoryMappedFile(Path)}.
   * <ul>
   *   <li>Then return available is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RandomAccessReadMemoryMappedFile#RandomAccessReadMemoryMappedFile(Path)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadMemoryMappedFile(Path); then return available is zero")
  void testNewRandomAccessReadMemoryMappedFile_thenReturnAvailableIsZero2() throws IOException {
    // Arrange and Act
    RandomAccessReadMemoryMappedFile actualRandomAccessReadMemoryMappedFile = new RandomAccessReadMemoryMappedFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Assert
    assertEquals(0, actualRandomAccessReadMemoryMappedFile.available());
    assertEquals(0L, actualRandomAccessReadMemoryMappedFile.getPosition());
    assertFalse(actualRandomAccessReadMemoryMappedFile.isClosed());
  }

  /**
   * Test {@link RandomAccessReadMemoryMappedFile#close()}.
   * <p>
   * Method under test: {@link RandomAccessReadMemoryMappedFile#close()}
   */
  @Test
  @DisplayName("Test close()")
  void testClose() throws IOException {
    // Arrange
    RandomAccessReadMemoryMappedFile randomAccessReadMemoryMappedFile = new RandomAccessReadMemoryMappedFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    randomAccessReadMemoryMappedFile.close();

    // Assert
    assertTrue(randomAccessReadMemoryMappedFile.isClosed());
  }

  /**
   * Test {@link RandomAccessReadMemoryMappedFile#seek(long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadMemoryMappedFile#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long); when minus one; then throw IOException")
  void testSeek_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new RandomAccessReadMemoryMappedFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())).seek(-1L));
  }

  /**
   * Test {@link RandomAccessReadMemoryMappedFile#getPosition()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadMemoryMappedFile#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition(); then return zero")
  void testGetPosition_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new RandomAccessReadMemoryMappedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getPosition());
  }

  /**
   * Test {@link RandomAccessReadMemoryMappedFile#read(byte[], int, int)} with
   * {@code b}, {@code offset}, {@code length}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RandomAccessReadMemoryMappedFile#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'offset', 'length'; then return minus one")
  void testReadWithBOffsetLength_thenReturnMinusOne() throws IOException {
    // Arrange
    RandomAccessReadMemoryMappedFile randomAccessReadMemoryMappedFile = new RandomAccessReadMemoryMappedFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertEquals(-1, randomAccessReadMemoryMappedFile.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link RandomAccessReadMemoryMappedFile#read()}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadMemoryMappedFile#read()}
   */
  @Test
  @DisplayName("Test read(); then return minus one")
  void testRead_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1,
        (new RandomAccessReadMemoryMappedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .read());
  }

  /**
   * Test {@link RandomAccessReadMemoryMappedFile#length()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadMemoryMappedFile#length()}
   */
  @Test
  @DisplayName("Test length(); then return zero")
  void testLength_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new RandomAccessReadMemoryMappedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .length());
  }

  /**
   * Test {@link RandomAccessReadMemoryMappedFile#isClosed()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadMemoryMappedFile#isClosed()}
   */
  @Test
  @DisplayName("Test isClosed(); then return 'false'")
  void testIsClosed_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        (new RandomAccessReadMemoryMappedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .isClosed());
  }

  /**
   * Test {@link RandomAccessReadMemoryMappedFile#isEOF()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadMemoryMappedFile#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF(); then return 'true'")
  void testIsEOF_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(
        (new RandomAccessReadMemoryMappedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .isEOF());
  }

  /**
   * Test {@link RandomAccessReadMemoryMappedFile#createView(long, long)}.
   * <ul>
   *   <li>Then return Position is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RandomAccessReadMemoryMappedFile#createView(long, long)}
   */
  @Test
  @DisplayName("Test createView(long, long); then return Position is zero")
  void testCreateView_thenReturnPositionIsZero() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualCreateViewResult = (new RandomAccessReadMemoryMappedFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())).createView(1L, 3L);

    // Assert
    assertEquals(0L, actualCreateViewResult.getPosition());
    assertEquals(3, actualCreateViewResult.available());
    assertFalse(actualCreateViewResult.isClosed());
  }
}
