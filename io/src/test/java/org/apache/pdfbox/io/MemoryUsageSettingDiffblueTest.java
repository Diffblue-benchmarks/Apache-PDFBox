package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class MemoryUsageSettingDiffblueTest {
  /**
   * Method under test: {@link MemoryUsageSetting#setupMainMemoryOnly()}
   */
  @Test
  void testSetupMainMemoryOnly() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMainMemoryOnlyResult = MemoryUsageSetting.setupMainMemoryOnly();

    // Assert
    assertNull(actualSetupMainMemoryOnlyResult.getTempDir());
    assertEquals(-1L, actualSetupMainMemoryOnlyResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMainMemoryOnlyResult.getMaxStorageBytes());
    assertFalse(actualSetupMainMemoryOnlyResult.isMainMemoryRestricted());
    assertFalse(actualSetupMainMemoryOnlyResult.isStorageRestricted());
    assertFalse(actualSetupMainMemoryOnlyResult.useTempFile());
    assertTrue(actualSetupMainMemoryOnlyResult.useMainMemory());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMainMemoryOnly(long)}
   */
  @Test
  void testSetupMainMemoryOnly2() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMainMemoryOnlyResult = MemoryUsageSetting.setupMainMemoryOnly(1L);

    // Assert
    assertNull(actualSetupMainMemoryOnlyResult.getTempDir());
    assertEquals(1L, actualSetupMainMemoryOnlyResult.getMaxMainMemoryBytes());
    assertEquals(1L, actualSetupMainMemoryOnlyResult.getMaxStorageBytes());
    assertFalse(actualSetupMainMemoryOnlyResult.useTempFile());
    assertTrue(actualSetupMainMemoryOnlyResult.isMainMemoryRestricted());
    assertTrue(actualSetupMainMemoryOnlyResult.isStorageRestricted());
    assertTrue(actualSetupMainMemoryOnlyResult.useMainMemory());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMainMemoryOnly(long)}
   */
  @Test
  void testSetupMainMemoryOnly3() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMainMemoryOnlyResult = MemoryUsageSetting.setupMainMemoryOnly(0L);

    // Assert
    assertNull(actualSetupMainMemoryOnlyResult.getTempDir());
    assertEquals(-1L, actualSetupMainMemoryOnlyResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMainMemoryOnlyResult.getMaxStorageBytes());
    assertFalse(actualSetupMainMemoryOnlyResult.isMainMemoryRestricted());
    assertFalse(actualSetupMainMemoryOnlyResult.isStorageRestricted());
    assertFalse(actualSetupMainMemoryOnlyResult.useTempFile());
    assertTrue(actualSetupMainMemoryOnlyResult.useMainMemory());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMainMemoryOnly(long)}
   */
  @Test
  void testSetupMainMemoryOnly4() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMainMemoryOnlyResult = MemoryUsageSetting.setupMainMemoryOnly(-2L);

    // Assert
    assertNull(actualSetupMainMemoryOnlyResult.getTempDir());
    assertEquals(-1L, actualSetupMainMemoryOnlyResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMainMemoryOnlyResult.getMaxStorageBytes());
    assertFalse(actualSetupMainMemoryOnlyResult.isMainMemoryRestricted());
    assertFalse(actualSetupMainMemoryOnlyResult.isStorageRestricted());
    assertFalse(actualSetupMainMemoryOnlyResult.useTempFile());
    assertTrue(actualSetupMainMemoryOnlyResult.useMainMemory());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupTempFileOnly()}
   */
  @Test
  void testSetupTempFileOnly() {
    // Arrange and Act
    MemoryUsageSetting actualSetupTempFileOnlyResult = MemoryUsageSetting.setupTempFileOnly();

    // Assert
    assertNull(actualSetupTempFileOnlyResult.getTempDir());
    assertEquals(-1L, actualSetupTempFileOnlyResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupTempFileOnlyResult.getMaxStorageBytes());
    assertFalse(actualSetupTempFileOnlyResult.isMainMemoryRestricted());
    assertFalse(actualSetupTempFileOnlyResult.isStorageRestricted());
    assertFalse(actualSetupTempFileOnlyResult.useMainMemory());
    assertTrue(actualSetupTempFileOnlyResult.useTempFile());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupTempFileOnly(long)}
   */
  @Test
  void testSetupTempFileOnly2() {
    // Arrange and Act
    MemoryUsageSetting actualSetupTempFileOnlyResult = MemoryUsageSetting.setupTempFileOnly(1L);

    // Assert
    assertNull(actualSetupTempFileOnlyResult.getTempDir());
    assertEquals(-1L, actualSetupTempFileOnlyResult.getMaxMainMemoryBytes());
    assertEquals(1L, actualSetupTempFileOnlyResult.getMaxStorageBytes());
    assertFalse(actualSetupTempFileOnlyResult.isMainMemoryRestricted());
    assertFalse(actualSetupTempFileOnlyResult.useMainMemory());
    assertTrue(actualSetupTempFileOnlyResult.isStorageRestricted());
    assertTrue(actualSetupTempFileOnlyResult.useTempFile());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupTempFileOnly(long)}
   */
  @Test
  void testSetupTempFileOnly3() {
    // Arrange and Act
    MemoryUsageSetting actualSetupTempFileOnlyResult = MemoryUsageSetting.setupTempFileOnly(0L);

    // Assert
    assertNull(actualSetupTempFileOnlyResult.getTempDir());
    assertEquals(-1L, actualSetupTempFileOnlyResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupTempFileOnlyResult.getMaxStorageBytes());
    assertFalse(actualSetupTempFileOnlyResult.isMainMemoryRestricted());
    assertFalse(actualSetupTempFileOnlyResult.isStorageRestricted());
    assertFalse(actualSetupTempFileOnlyResult.useMainMemory());
    assertTrue(actualSetupTempFileOnlyResult.useTempFile());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMixed(long)}
   */
  @Test
  void testSetupMixed() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(1L);

    // Assert
    assertNull(actualSetupMixedResult.getTempDir());
    assertEquals(-1L, actualSetupMixedResult.getMaxStorageBytes());
    assertEquals(1L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertFalse(actualSetupMixedResult.isStorageRestricted());
    assertTrue(actualSetupMixedResult.isMainMemoryRestricted());
    assertTrue(actualSetupMixedResult.useMainMemory());
    assertTrue(actualSetupMixedResult.useTempFile());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMixed(long)}
   */
  @Test
  void testSetupMixed2() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(-2L);

    // Assert
    assertNull(actualSetupMixedResult.getTempDir());
    assertEquals(-1L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMixedResult.getMaxStorageBytes());
    assertFalse(actualSetupMixedResult.isMainMemoryRestricted());
    assertFalse(actualSetupMixedResult.isStorageRestricted());
    assertTrue(actualSetupMixedResult.useMainMemory());
    assertTrue(actualSetupMixedResult.useTempFile());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMixed(long)}
   */
  @Test
  void testSetupMixed3() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(0L);

    // Assert
    assertNull(actualSetupMixedResult.getTempDir());
    assertEquals(-1L, actualSetupMixedResult.getMaxStorageBytes());
    assertEquals(0L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertFalse(actualSetupMixedResult.isStorageRestricted());
    assertFalse(actualSetupMixedResult.useMainMemory());
    assertTrue(actualSetupMixedResult.isMainMemoryRestricted());
    assertTrue(actualSetupMixedResult.useTempFile());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  void testSetupMixed4() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(1L, 1L);

    // Assert
    assertNull(actualSetupMixedResult.getTempDir());
    assertEquals(1L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertEquals(1L, actualSetupMixedResult.getMaxStorageBytes());
    assertTrue(actualSetupMixedResult.isMainMemoryRestricted());
    assertTrue(actualSetupMixedResult.isStorageRestricted());
    assertTrue(actualSetupMixedResult.useMainMemory());
    assertTrue(actualSetupMixedResult.useTempFile());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  void testSetupMixed5() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(-1L, 0L);

    // Assert
    assertNull(actualSetupMixedResult.getTempDir());
    assertEquals(-1L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMixedResult.getMaxStorageBytes());
    assertFalse(actualSetupMixedResult.isMainMemoryRestricted());
    assertFalse(actualSetupMixedResult.isStorageRestricted());
    assertTrue(actualSetupMixedResult.useMainMemory());
    assertTrue(actualSetupMixedResult.useTempFile());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  void testSetupMixed6() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(-1L, 1L);

    // Assert
    assertNull(actualSetupMixedResult.getTempDir());
    assertEquals(-1L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMixedResult.getMaxStorageBytes());
    assertFalse(actualSetupMixedResult.isMainMemoryRestricted());
    assertFalse(actualSetupMixedResult.isStorageRestricted());
    assertTrue(actualSetupMixedResult.useMainMemory());
    assertTrue(actualSetupMixedResult.useTempFile());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  void testSetupMixed7() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(-2L, 0L);

    // Assert
    assertNull(actualSetupMixedResult.getTempDir());
    assertEquals(-1L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMixedResult.getMaxStorageBytes());
    assertFalse(actualSetupMixedResult.isMainMemoryRestricted());
    assertFalse(actualSetupMixedResult.isStorageRestricted());
    assertTrue(actualSetupMixedResult.useMainMemory());
    assertTrue(actualSetupMixedResult.useTempFile());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  void testSetupMixed8() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(0L, 0L);

    // Assert
    assertNull(actualSetupMixedResult.getTempDir());
    assertEquals(-1L, actualSetupMixedResult.getMaxStorageBytes());
    assertEquals(0L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertFalse(actualSetupMixedResult.isStorageRestricted());
    assertFalse(actualSetupMixedResult.useMainMemory());
    assertTrue(actualSetupMixedResult.isMainMemoryRestricted());
    assertTrue(actualSetupMixedResult.useTempFile());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  void testSetupMixed9() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(Long.MAX_VALUE, 1L);

    // Assert
    assertNull(actualSetupMixedResult.getTempDir());
    assertTrue(actualSetupMixedResult.isMainMemoryRestricted());
    assertTrue(actualSetupMixedResult.isStorageRestricted());
    assertTrue(actualSetupMixedResult.useMainMemory());
    assertTrue(actualSetupMixedResult.useTempFile());
    assertEquals(Long.MAX_VALUE, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertEquals(Long.MAX_VALUE, actualSetupMixedResult.getMaxStorageBytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MemoryUsageSetting#setTempDir(File)}
   *   <li>{@link MemoryUsageSetting#getMaxMainMemoryBytes()}
   *   <li>{@link MemoryUsageSetting#getMaxStorageBytes()}
   *   <li>{@link MemoryUsageSetting#getTempDir()}
   *   <li>{@link MemoryUsageSetting#useMainMemory()}
   *   <li>{@link MemoryUsageSetting#useTempFile()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MemoryUsageSetting setupMainMemoryOnlyResult = MemoryUsageSetting.setupMainMemoryOnly(1L);
    File tempDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    MemoryUsageSetting actualSetTempDirResult = setupMainMemoryOnlyResult.setTempDir(tempDir);
    long actualMaxMainMemoryBytes = setupMainMemoryOnlyResult.getMaxMainMemoryBytes();
    long actualMaxStorageBytes = setupMainMemoryOnlyResult.getMaxStorageBytes();
    File actualTempDir = setupMainMemoryOnlyResult.getTempDir();
    boolean actualUseMainMemoryResult = setupMainMemoryOnlyResult.useMainMemory();

    // Assert
    assertEquals(1L, actualMaxMainMemoryBytes);
    assertEquals(1L, actualMaxStorageBytes);
    assertFalse(setupMainMemoryOnlyResult.useTempFile());
    assertTrue(actualUseMainMemoryResult);
    assertSame(tempDir, actualTempDir);
    assertSame(setupMainMemoryOnlyResult, actualSetTempDirResult);
  }

  /**
   * Method under test: {@link MemoryUsageSetting#isMainMemoryRestricted()}
   */
  @Test
  void testIsMainMemoryRestricted() {
    // Arrange, Act and Assert
    assertTrue(MemoryUsageSetting.setupMainMemoryOnly(1L).isMainMemoryRestricted());
    assertFalse(MemoryUsageSetting.setupMainMemoryOnly(0L).isMainMemoryRestricted());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#isStorageRestricted()}
   */
  @Test
  void testIsStorageRestricted() {
    // Arrange, Act and Assert
    assertTrue(MemoryUsageSetting.setupMainMemoryOnly(1L).isStorageRestricted());
    assertFalse(MemoryUsageSetting.setupMainMemoryOnly(0L).isStorageRestricted());
  }

  /**
   * Method under test: {@link MemoryUsageSetting#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Main memory only with max. of 1 bytes", MemoryUsageSetting.setupMainMemoryOnly(1L).toString());
    assertEquals("Main memory only with no size restriction", MemoryUsageSetting.setupMainMemoryOnly(0L).toString());
    assertEquals("Scratch file only with max. of 1 bytes", MemoryUsageSetting.setupTempFileOnly(1L).toString());
    assertEquals("Mixed mode with max. of 1 main memory bytes and max. of 1 storage bytes",
        MemoryUsageSetting.setupMixed(1L, 1L).toString());
    assertEquals("Scratch file only with no size restriction", MemoryUsageSetting.setupTempFileOnly(0L).toString());
    assertEquals("Mixed mode with max. of -1 main memory bytes and unrestricted scratch file size",
        MemoryUsageSetting.setupMixed(-1L, 1L).toString());
  }
}
