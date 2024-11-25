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

class RandomAccessReadBufferedFileDiffblueTest {
  /**
   * Test {@link RandomAccessReadBufferedFile#RandomAccessReadBufferedFile(File)}.
   * <ul>
   *   <li>Then return available is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RandomAccessReadBufferedFile#RandomAccessReadBufferedFile(File)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadBufferedFile(File); then return available is zero")
  void testNewRandomAccessReadBufferedFile_thenReturnAvailableIsZero() throws IOException {
    // Arrange and Act
    RandomAccessReadBufferedFile actualRandomAccessReadBufferedFile = new RandomAccessReadBufferedFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    assertEquals(0, actualRandomAccessReadBufferedFile.available());
    assertEquals(0L, actualRandomAccessReadBufferedFile.getPosition());
    assertEquals(0L, actualRandomAccessReadBufferedFile.length());
    assertFalse(actualRandomAccessReadBufferedFile.isClosed());
    assertTrue(actualRandomAccessReadBufferedFile.isEOF());
  }

  /**
   * Test {@link RandomAccessReadBufferedFile#RandomAccessReadBufferedFile(Path)}.
   * <ul>
   *   <li>Then return available is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RandomAccessReadBufferedFile#RandomAccessReadBufferedFile(Path)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadBufferedFile(Path); then return available is zero")
  void testNewRandomAccessReadBufferedFile_thenReturnAvailableIsZero2() throws IOException {
    // Arrange and Act
    RandomAccessReadBufferedFile actualRandomAccessReadBufferedFile = new RandomAccessReadBufferedFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Assert
    assertEquals(0, actualRandomAccessReadBufferedFile.available());
    assertEquals(0L, actualRandomAccessReadBufferedFile.getPosition());
    assertEquals(0L, actualRandomAccessReadBufferedFile.length());
    assertFalse(actualRandomAccessReadBufferedFile.isClosed());
    assertTrue(actualRandomAccessReadBufferedFile.isEOF());
  }

  /**
   * Test {@link RandomAccessReadBufferedFile#getPosition()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBufferedFile#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition(); then return zero")
  void testGetPosition_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new RandomAccessReadBufferedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getPosition());
  }

  /**
   * Test {@link RandomAccessReadBufferedFile#seek(long)}.
   * <ul>
   *   <li>When {@code -4096}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBufferedFile#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long); when '-4096'; then throw IOException")
  void testSeek_when4096_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new RandomAccessReadBufferedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .seek(-4096L));
  }

  /**
   * Test {@link RandomAccessReadBufferedFile#read(byte[], int, int)} with
   * {@code b}, {@code off}, {@code len}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RandomAccessReadBufferedFile#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then return minus one")
  void testReadWithBOffLen_thenReturnMinusOne() throws IOException {
    // Arrange
    RandomAccessReadBufferedFile randomAccessReadBufferedFile = new RandomAccessReadBufferedFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertEquals(-1, randomAccessReadBufferedFile.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link RandomAccessReadBufferedFile#read()}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBufferedFile#read()}
   */
  @Test
  @DisplayName("Test read(); then return minus one")
  void testRead_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1,
        (new RandomAccessReadBufferedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .read());
  }

  /**
   * Test {@link RandomAccessReadBufferedFile#length()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBufferedFile#length()}
   */
  @Test
  @DisplayName("Test length(); then return zero")
  void testLength_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new RandomAccessReadBufferedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .length());
  }

  /**
   * Test {@link RandomAccessReadBufferedFile#close()}.
   * <p>
   * Method under test: {@link RandomAccessReadBufferedFile#close()}
   */
  @Test
  @DisplayName("Test close()")
  void testClose() throws IOException {
    // Arrange
    RandomAccessReadBufferedFile randomAccessReadBufferedFile = new RandomAccessReadBufferedFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    randomAccessReadBufferedFile.close();

    // Assert
    assertTrue(randomAccessReadBufferedFile.isClosed());
  }

  /**
   * Test {@link RandomAccessReadBufferedFile#isEOF()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBufferedFile#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF(); then return 'true'")
  void testIsEOF_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new RandomAccessReadBufferedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
        .isEOF());
  }

  /**
   * Test {@link RandomAccessReadBufferedFile#createView(long, long)}.
   * <ul>
   *   <li>Then return Position is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RandomAccessReadBufferedFile#createView(long, long)}
   */
  @Test
  @DisplayName("Test createView(long, long); then return Position is zero")
  void testCreateView_thenReturnPositionIsZero() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualCreateViewResult = (new RandomAccessReadBufferedFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())).createView(1L, 3L);

    // Assert
    assertEquals(0L, actualCreateViewResult.getPosition());
    assertEquals(3, actualCreateViewResult.available());
    assertFalse(actualCreateViewResult.isClosed());
  }
}
