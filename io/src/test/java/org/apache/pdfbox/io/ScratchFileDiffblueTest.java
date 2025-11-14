package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ScratchFileDiffblueTest {
  /**
   * Test {@link ScratchFile#ScratchFile(MemoryUsageSetting)}.
   *
   * <p>Method under test: {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   */
  @Test
  @DisplayName("Test new ScratchFile(MemoryUsageSetting)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFile.<init>(MemoryUsageSetting)"})
  void testNewScratchFile() throws IOException {
    // Arrange
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupTempFileOnly(3L);
    memUsageSetting.setTempDir(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile());

    // Act and Assert
    assertEquals(
        RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        new ScratchFile(memUsageSetting).getPageSize());
  }

  /**
   * Test {@link ScratchFile#ScratchFile(File)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#ScratchFile(File)}
   */
  @Test
  @DisplayName("Test new ScratchFile(File); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFile.<init>(File)"})
  void testNewScratchFile_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link ScratchFile#ScratchFile(MemoryUsageSetting)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   */
  @Test
  @DisplayName("Test new ScratchFile(MemoryUsageSetting); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFile.<init>(MemoryUsageSetting)"})
  void testNewScratchFile_thenThrowIOException2() throws IOException {
    // Arrange
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupTempFileOnly(3L);
    memUsageSetting.setTempDir(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(IOException.class, () -> new ScratchFile(memUsageSetting));
  }

  /**
   * Test {@link ScratchFile#ScratchFile(MemoryUsageSetting)}.
   *
   * <ul>
   *   <li>When setupMainMemoryOnly one.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   */
  @Test
  @DisplayName("Test new ScratchFile(MemoryUsageSetting); when setupMainMemoryOnly one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFile.<init>(MemoryUsageSetting)"})
  void testNewScratchFile_whenSetupMainMemoryOnlyOne() throws IOException {
    // Arrange
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(1L);

    // Act and Assert
    assertEquals(
        RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        new ScratchFile(memUsageSetting).getPageSize());
  }

  /**
   * Test {@link ScratchFile#ScratchFile(MemoryUsageSetting)}.
   *
   * <ul>
   *   <li>When setupTempFileOnly three.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   */
  @Test
  @DisplayName("Test new ScratchFile(MemoryUsageSetting); when setupTempFileOnly three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFile.<init>(MemoryUsageSetting)"})
  void testNewScratchFile_whenSetupTempFileOnlyThree() throws IOException {
    // Arrange
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupTempFileOnly(3L);

    // Act and Assert
    assertEquals(
        RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        new ScratchFile(memUsageSetting).getPageSize());
  }

  /**
   * Test {@link ScratchFile#getMainMemoryOnlyInstance(long)} with {@code long}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#getMainMemoryOnlyInstance(long)}
   */
  @Test
  @DisplayName("Test getMainMemoryOnlyInstance(long) with 'long'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ScratchFile ScratchFile.getMainMemoryOnlyInstance(long)"})
  void testGetMainMemoryOnlyInstanceWithLong_whenOne() {
    // Arrange and Act
    ScratchFile actualMainMemoryOnlyInstance = ScratchFile.getMainMemoryOnlyInstance(1L);

    // Assert
    assertEquals(
        RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualMainMemoryOnlyInstance.getPageSize());
  }

  /**
   * Test {@link ScratchFile#getNewPage()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#getNewPage()}
   */
  @Test
  @DisplayName("Test getNewPage(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScratchFile.getNewPage()"})
  void testGetNewPage_thenReturnZero() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);

    // Act and Assert
    assertEquals(0, new ScratchFile(memUsageSetting).getNewPage());
  }

  /**
   * Test {@link ScratchFile#getNewPage()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#getNewPage()}
   */
  @Test
  @DisplayName("Test getNewPage(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScratchFile.getNewPage()"})
  void testGetNewPage_thenThrowIOException() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(1L);

    // Act and Assert
    assertThrows(IOException.class, () -> new ScratchFile(memUsageSetting).getNewPage());
  }

  /**
   * Test {@link ScratchFile#getPageSize()}.
   *
   * <ul>
   *   <li>Then return {@link RandomAccessReadBuffer#DEFAULT_CHUNK_SIZE_4KB}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#getPageSize()}
   */
  @Test
  @DisplayName("Test getPageSize(); then return DEFAULT_CHUNK_SIZE_4KB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScratchFile.getPageSize()"})
  void testGetPageSize_thenReturnDefault_chunk_size_4kb() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())
            .getPageSize());
  }

  /**
   * Test {@link ScratchFile#readPage(int)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#readPage(int)}
   */
  @Test
  @DisplayName("Test readPage(int); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ScratchFile.readPage(int)"})
  void testReadPage_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())
                .readPage(1));
  }

  /**
   * Test {@link ScratchFile#readPage(int)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#readPage(int)}
   */
  @Test
  @DisplayName("Test readPage(int); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ScratchFile.readPage(int)"})
  void testReadPage_thenThrowIOException2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())
                .readPage(-1));
  }

  /**
   * Test {@link ScratchFile#writePage(int, byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#writePage(int, byte[])}
   */
  @Test
  @DisplayName("Test writePage(int, byte[]); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFile.writePage(int, byte[])"})
  void testWritePage_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())
                .writePage(1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ScratchFile#writePage(int, byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#writePage(int, byte[])}
   */
  @Test
  @DisplayName("Test writePage(int, byte[]); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFile.writePage(int, byte[])"})
  void testWritePage_thenThrowIOException2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())
                .writePage(-1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ScratchFile#createBuffer()}.
   *
   * <ul>
   *   <li>Given {@link ScratchFile#ScratchFile(MemoryUsageSetting)} with memUsageSetting is
   *       setupMainMemoryOnly {@code 4096}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#createBuffer()}
   */
  @Test
  @DisplayName(
      "Test createBuffer(); given ScratchFile(MemoryUsageSetting) with memUsageSetting is setupMainMemoryOnly '4096'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccess ScratchFile.createBuffer()"})
  void testCreateBuffer_givenScratchFileWithMemUsageSettingIsSetupMainMemoryOnly4096()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(4096L);

    // Act
    RandomAccess actualCreateBufferResult = new ScratchFile(memUsageSetting).createBuffer();

    // Assert
    assertTrue(actualCreateBufferResult instanceof ScratchFileBuffer);
    assertEquals(0, actualCreateBufferResult.available());
    assertEquals(0L, actualCreateBufferResult.getPosition());
    assertEquals(0L, actualCreateBufferResult.length());
    assertFalse(actualCreateBufferResult.isClosed());
  }

  /**
   * Test {@link ScratchFile#createBuffer()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFile#createBuffer()}
   */
  @Test
  @DisplayName("Test createBuffer(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccess ScratchFile.createBuffer()"})
  void testCreateBuffer_thenThrowIOException() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(1L);

    // Act and Assert
    assertThrows(IOException.class, () -> new ScratchFile(memUsageSetting).createBuffer());
  }
}
