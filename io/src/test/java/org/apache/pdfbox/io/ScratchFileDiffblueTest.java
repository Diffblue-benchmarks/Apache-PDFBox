package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class ScratchFileDiffblueTest {
  /**
   * Method under test: {@link ScratchFile#getMainMemoryOnlyInstance(long)}
   */
  @Test
  void testGetMainMemoryOnlyInstance() {
    // Arrange, Act and Assert
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        ScratchFile.getMainMemoryOnlyInstance(1L).getPageSize());
  }

  /**
   * Method under test: {@link ScratchFile#getNewPage()}
   */
  @Test
  void testGetNewPage() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertThrows(IOException.class, () -> (new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(1L))).getNewPage());
  }

  /**
   * Method under test: {@link ScratchFile#getNewPage()}
   */
  @Test
  void testGetNewPage2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertEquals(0, (new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L))).getNewPage());
  }

  /**
   * Method under test: {@link ScratchFile#getPageSize()}
   */
  @Test
  void testGetPageSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        (new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())).getPageSize());
  }

  /**
   * Method under test: {@link ScratchFile#readPage(int)}
   */
  @Test
  void testReadPage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())).readPage(1));
    assertThrows(IOException.class,
        () -> (new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())).readPage(-1));
  }

  /**
   * Method under test: {@link ScratchFile#writePage(int, byte[])}
   */
  @Test
  void testWritePage() throws IOException {
    // Arrange
    ScratchFile scratchFile = new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile());

    // Act and Assert
    assertThrows(IOException.class, () -> scratchFile.writePage(1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ScratchFile#writePage(int, byte[])}
   */
  @Test
  void testWritePage2() throws IOException {
    // Arrange
    ScratchFile scratchFile = new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile());

    // Act and Assert
    assertThrows(IOException.class, () -> scratchFile.writePage(-1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ScratchFile#createBuffer()}
   */
  @Test
  void testCreateBuffer() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertThrows(IOException.class, () -> (new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(1L))).createBuffer());
  }

  /**
   * Method under test: {@link ScratchFile#createBuffer()}
   */
  @Test
  void testCreateBuffer2() throws IOException {
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
   * Method under test: {@link ScratchFile#ScratchFile(File)}
   */
  @Test
  void testNewScratchFile() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        (new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(1L))).getPageSize());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        (new ScratchFile(MemoryUsageSetting.setupTempFileOnly(3L))).getPageSize());
  }

  /**
   * Method under test: {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   */
  @Test
  void testNewScratchFile2() throws IOException {
    // Arrange
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupTempFileOnly(3L);
    memUsageSetting.setTempDir(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(IOException.class, () -> new ScratchFile(memUsageSetting));
  }

  /**
   * Method under test: {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   */
  @Test
  void testNewScratchFile3() throws IOException {
    // Arrange
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupTempFileOnly(3L);
    memUsageSetting.setTempDir(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile());

    // Act and Assert
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, (new ScratchFile(memUsageSetting)).getPageSize());
  }
}
