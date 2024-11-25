package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScratchFileDiffblueTest {
  /**
   * Test {@link ScratchFile#ScratchFile(MemoryUsageSetting)}.
   * <p>
   * Method under test: {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   */
  @Test
  @DisplayName("Test new ScratchFile(MemoryUsageSetting)")
  void testNewScratchFile() throws IOException {
    // Arrange
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupTempFileOnly(3L);
    memUsageSetting.setTempDir(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile());

    // Act and Assert
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, (new ScratchFile(memUsageSetting)).getPageSize());
  }

  /**
   * Test {@link ScratchFile#ScratchFile(File)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#ScratchFile(File)}
   */
  @Test
  @DisplayName("Test new ScratchFile(File); then throw IOException")
  void testNewScratchFile_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link ScratchFile#ScratchFile(MemoryUsageSetting)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   */
  @Test
  @DisplayName("Test new ScratchFile(MemoryUsageSetting); then throw IOException")
  void testNewScratchFile_thenThrowIOException2() throws IOException {
    // Arrange
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupTempFileOnly(3L);
    memUsageSetting.setTempDir(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(IOException.class, () -> new ScratchFile(memUsageSetting));
  }

  /**
   * Test {@link ScratchFile#ScratchFile(MemoryUsageSetting)}.
   * <ul>
   *   <li>When setupMainMemoryOnly one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   */
  @Test
  @DisplayName("Test new ScratchFile(MemoryUsageSetting); when setupMainMemoryOnly one")
  void testNewScratchFile_whenSetupMainMemoryOnlyOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        (new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(1L))).getPageSize());
  }

  /**
   * Test {@link ScratchFile#ScratchFile(MemoryUsageSetting)}.
   * <ul>
   *   <li>When setupTempFileOnly three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   */
  @Test
  @DisplayName("Test new ScratchFile(MemoryUsageSetting); when setupTempFileOnly three")
  void testNewScratchFile_whenSetupTempFileOnlyThree() throws IOException {
    // Arrange, Act and Assert
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        (new ScratchFile(MemoryUsageSetting.setupTempFileOnly(3L))).getPageSize());
  }

  /**
   * Test {@link ScratchFile#getMainMemoryOnlyInstance(long)} with {@code long}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#getMainMemoryOnlyInstance(long)}
   */
  @Test
  @DisplayName("Test getMainMemoryOnlyInstance(long) with 'long'; when one")
  void testGetMainMemoryOnlyInstanceWithLong_whenOne() {
    // Arrange, Act and Assert
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        ScratchFile.getMainMemoryOnlyInstance(1L).getPageSize());
  }

  /**
   * Test {@link ScratchFile#getNewPage()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#getNewPage()}
   */
  @Test
  @DisplayName("Test getNewPage(); then return zero")
  void testGetNewPage_thenReturnZero() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertEquals(0, (new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L))).getNewPage());
  }

  /**
   * Test {@link ScratchFile#getNewPage()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#getNewPage()}
   */
  @Test
  @DisplayName("Test getNewPage(); then throw IOException")
  void testGetNewPage_thenThrowIOException() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertThrows(IOException.class, () -> (new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(1L))).getNewPage());
  }

  /**
   * Test {@link ScratchFile#getPageSize()}.
   * <ul>
   *   <li>Then return {@link RandomAccessReadBuffer#DEFAULT_CHUNK_SIZE_4KB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#getPageSize()}
   */
  @Test
  @DisplayName("Test getPageSize(); then return DEFAULT_CHUNK_SIZE_4KB")
  void testGetPageSize_thenReturnDefault_chunk_size_4kb() throws IOException {
    // Arrange, Act and Assert
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        (new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())).getPageSize());
  }

  /**
   * Test {@link ScratchFile#readPage(int)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#readPage(int)}
   */
  @Test
  @DisplayName("Test readPage(int); then throw IOException")
  void testReadPage_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())).readPage(1));
  }

  /**
   * Test {@link ScratchFile#readPage(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#readPage(int)}
   */
  @Test
  @DisplayName("Test readPage(int); when minus one; then throw IOException")
  void testReadPage_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())).readPage(-1));
  }

  /**
   * Test {@link ScratchFile#writePage(int, byte[])}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#writePage(int, byte[])}
   */
  @Test
  @DisplayName("Test writePage(int, byte[]); then throw IOException")
  void testWritePage_thenThrowIOException() throws IOException {
    // Arrange
    ScratchFile scratchFile = new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile());

    // Act and Assert
    assertThrows(IOException.class, () -> scratchFile.writePage(1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ScratchFile#writePage(int, byte[])}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#writePage(int, byte[])}
   */
  @Test
  @DisplayName("Test writePage(int, byte[]); when minus one; then throw IOException")
  void testWritePage_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange
    ScratchFile scratchFile = new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile());

    // Act and Assert
    assertThrows(IOException.class, () -> scratchFile.writePage(-1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ScratchFile#createBuffer()}.
   * <ul>
   *   <li>Given {@link ScratchFile#ScratchFile(MemoryUsageSetting)} with
   * memUsageSetting is setupMainMemoryOnly {@code 4096}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#createBuffer()}
   */
  @Test
  @DisplayName("Test createBuffer(); given ScratchFile(MemoryUsageSetting) with memUsageSetting is setupMainMemoryOnly '4096'")
  void testCreateBuffer_givenScratchFileWithMemUsageSettingIsSetupMainMemoryOnly4096() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act
    RandomAccess actualCreateBufferResult = (new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(4096L)))
        .createBuffer();

    // Assert
    assertTrue(actualCreateBufferResult instanceof ScratchFileBuffer);
    assertEquals(0, actualCreateBufferResult.available());
    assertEquals(0L, actualCreateBufferResult.getPosition());
    assertEquals(0L, actualCreateBufferResult.length());
    assertFalse(actualCreateBufferResult.isClosed());
  }

  /**
   * Test {@link ScratchFile#createBuffer()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFile#createBuffer()}
   */
  @Test
  @DisplayName("Test createBuffer(); then throw IOException")
  void testCreateBuffer_thenThrowIOException() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertThrows(IOException.class, () -> (new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(1L))).createBuffer());
  }
}
