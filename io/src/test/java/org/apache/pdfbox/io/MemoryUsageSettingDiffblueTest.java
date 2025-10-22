package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MemoryUsageSettingDiffblueTest {
  /**
   * Test {@link MemoryUsageSetting#setupMainMemoryOnly()}.
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMainMemoryOnly()}
   */
  @Test
  @DisplayName("Test setupMainMemoryOnly()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMainMemoryOnly()"})
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
   * Test {@link MemoryUsageSetting#setupMainMemoryOnly(long)} with {@code long}.
   * <ul>
   *   <li>When minus two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMainMemoryOnly(long)}
   */
  @Test
  @DisplayName("Test setupMainMemoryOnly(long) with 'long'; when minus two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMainMemoryOnly(long)"})
  void testSetupMainMemoryOnlyWithLong_whenMinusTwo() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMainMemoryOnlyResult = MemoryUsageSetting.setupMainMemoryOnly(-2L);

    // Assert
    assertEquals(-1L, actualSetupMainMemoryOnlyResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMainMemoryOnlyResult.getMaxStorageBytes());
    assertFalse(actualSetupMainMemoryOnlyResult.isMainMemoryRestricted());
    assertFalse(actualSetupMainMemoryOnlyResult.isStorageRestricted());
  }

  /**
   * Test {@link MemoryUsageSetting#setupMainMemoryOnly(long)} with {@code long}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return MaxMainMemoryBytes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMainMemoryOnly(long)}
   */
  @Test
  @DisplayName("Test setupMainMemoryOnly(long) with 'long'; when one; then return MaxMainMemoryBytes is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMainMemoryOnly(long)"})
  void testSetupMainMemoryOnlyWithLong_whenOne_thenReturnMaxMainMemoryBytesIsOne() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMainMemoryOnlyResult = MemoryUsageSetting.setupMainMemoryOnly(1L);

    // Assert
    assertEquals(1L, actualSetupMainMemoryOnlyResult.getMaxMainMemoryBytes());
    assertEquals(1L, actualSetupMainMemoryOnlyResult.getMaxStorageBytes());
    assertTrue(actualSetupMainMemoryOnlyResult.isMainMemoryRestricted());
    assertTrue(actualSetupMainMemoryOnlyResult.isStorageRestricted());
  }

  /**
   * Test {@link MemoryUsageSetting#setupMainMemoryOnly(long)} with {@code long}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return MaxMainMemoryBytes is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMainMemoryOnly(long)}
   */
  @Test
  @DisplayName("Test setupMainMemoryOnly(long) with 'long'; when zero; then return MaxMainMemoryBytes is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMainMemoryOnly(long)"})
  void testSetupMainMemoryOnlyWithLong_whenZero_thenReturnMaxMainMemoryBytesIsMinusOne() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMainMemoryOnlyResult = MemoryUsageSetting.setupMainMemoryOnly(0L);

    // Assert
    assertEquals(-1L, actualSetupMainMemoryOnlyResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMainMemoryOnlyResult.getMaxStorageBytes());
    assertFalse(actualSetupMainMemoryOnlyResult.isMainMemoryRestricted());
    assertFalse(actualSetupMainMemoryOnlyResult.isStorageRestricted());
  }

  /**
   * Test {@link MemoryUsageSetting#setupTempFileOnly()}.
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupTempFileOnly()}
   */
  @Test
  @DisplayName("Test setupTempFileOnly()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupTempFileOnly()"})
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
   * Test {@link MemoryUsageSetting#setupTempFileOnly(long)} with {@code long}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return MaxStorageBytes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupTempFileOnly(long)}
   */
  @Test
  @DisplayName("Test setupTempFileOnly(long) with 'long'; when one; then return MaxStorageBytes is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupTempFileOnly(long)"})
  void testSetupTempFileOnlyWithLong_whenOne_thenReturnMaxStorageBytesIsOne() {
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
   * Test {@link MemoryUsageSetting#setupTempFileOnly(long)} with {@code long}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return MaxStorageBytes is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupTempFileOnly(long)}
   */
  @Test
  @DisplayName("Test setupTempFileOnly(long) with 'long'; when zero; then return MaxStorageBytes is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupTempFileOnly(long)"})
  void testSetupTempFileOnlyWithLong_whenZero_thenReturnMaxStorageBytesIsMinusOne() {
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
   * Test {@link MemoryUsageSetting#setupMixed(long, long)} with {@code maxMainMemoryBytes}, {@code maxStorageBytes}.
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  @DisplayName("Test setupMixed(long, long) with 'maxMainMemoryBytes', 'maxStorageBytes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMixed(long, long)"})
  void testSetupMixedWithMaxMainMemoryBytesMaxStorageBytes() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(1L, 1L);

    // Assert
    assertEquals(1L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertEquals(1L, actualSetupMixedResult.getMaxStorageBytes());
    assertTrue(actualSetupMixedResult.isMainMemoryRestricted());
    assertTrue(actualSetupMixedResult.isStorageRestricted());
  }

  /**
   * Test {@link MemoryUsageSetting#setupMixed(long, long)} with {@code maxMainMemoryBytes}, {@code maxStorageBytes}.
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  @DisplayName("Test setupMixed(long, long) with 'maxMainMemoryBytes', 'maxStorageBytes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMixed(long, long)"})
  void testSetupMixedWithMaxMainMemoryBytesMaxStorageBytes2() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(0L, 0L);

    // Assert
    assertEquals(-1L, actualSetupMixedResult.getMaxStorageBytes());
    assertEquals(0L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertFalse(actualSetupMixedResult.isStorageRestricted());
    assertFalse(actualSetupMixedResult.useMainMemory());
    assertTrue(actualSetupMixedResult.isMainMemoryRestricted());
  }

  /**
   * Test {@link MemoryUsageSetting#setupMixed(long, long)} with {@code maxMainMemoryBytes}, {@code maxStorageBytes}.
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  @DisplayName("Test setupMixed(long, long) with 'maxMainMemoryBytes', 'maxStorageBytes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMixed(long, long)"})
  void testSetupMixedWithMaxMainMemoryBytesMaxStorageBytes3() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(Long.MAX_VALUE, 1L);

    // Assert
    assertTrue(actualSetupMixedResult.isMainMemoryRestricted());
    assertTrue(actualSetupMixedResult.isStorageRestricted());
    assertEquals(Long.MAX_VALUE, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertEquals(Long.MAX_VALUE, actualSetupMixedResult.getMaxStorageBytes());
  }

  /**
   * Test {@link MemoryUsageSetting#setupMixed(long, long)} with {@code maxMainMemoryBytes}, {@code maxStorageBytes}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  @DisplayName("Test setupMixed(long, long) with 'maxMainMemoryBytes', 'maxStorageBytes'; when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMixed(long, long)"})
  void testSetupMixedWithMaxMainMemoryBytesMaxStorageBytes_whenMinusOne() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(-1L, 0L);

    // Assert
    assertEquals(-1L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMixedResult.getMaxStorageBytes());
    assertFalse(actualSetupMixedResult.isMainMemoryRestricted());
    assertFalse(actualSetupMixedResult.isStorageRestricted());
  }

  /**
   * Test {@link MemoryUsageSetting#setupMixed(long, long)} with {@code maxMainMemoryBytes}, {@code maxStorageBytes}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  @DisplayName("Test setupMixed(long, long) with 'maxMainMemoryBytes', 'maxStorageBytes'; when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMixed(long, long)"})
  void testSetupMixedWithMaxMainMemoryBytesMaxStorageBytes_whenMinusOne2() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(-1L, 1L);

    // Assert
    assertEquals(-1L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMixedResult.getMaxStorageBytes());
    assertFalse(actualSetupMixedResult.isMainMemoryRestricted());
    assertFalse(actualSetupMixedResult.isStorageRestricted());
  }

  /**
   * Test {@link MemoryUsageSetting#setupMixed(long, long)} with {@code maxMainMemoryBytes}, {@code maxStorageBytes}.
   * <ul>
   *   <li>When minus two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMixed(long, long)}
   */
  @Test
  @DisplayName("Test setupMixed(long, long) with 'maxMainMemoryBytes', 'maxStorageBytes'; when minus two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMixed(long, long)"})
  void testSetupMixedWithMaxMainMemoryBytesMaxStorageBytes_whenMinusTwo() {
    // Arrange and Act
    MemoryUsageSetting actualSetupMixedResult = MemoryUsageSetting.setupMixed(-2L, 0L);

    // Assert
    assertEquals(-1L, actualSetupMixedResult.getMaxMainMemoryBytes());
    assertEquals(-1L, actualSetupMixedResult.getMaxStorageBytes());
    assertFalse(actualSetupMixedResult.isMainMemoryRestricted());
    assertFalse(actualSetupMixedResult.isStorageRestricted());
  }

  /**
   * Test {@link MemoryUsageSetting#setupMixed(long)} with {@code maxMainMemoryBytes}.
   * <ul>
   *   <li>Then return MaxMainMemoryBytes is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMixed(long)}
   */
  @Test
  @DisplayName("Test setupMixed(long) with 'maxMainMemoryBytes'; then return MaxMainMemoryBytes is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMixed(long)"})
  void testSetupMixedWithMaxMainMemoryBytes_thenReturnMaxMainMemoryBytesIsMinusOne() {
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
   * Test {@link MemoryUsageSetting#setupMixed(long)} with {@code maxMainMemoryBytes}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return MaxMainMemoryBytes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMixed(long)}
   */
  @Test
  @DisplayName("Test setupMixed(long) with 'maxMainMemoryBytes'; when one; then return MaxMainMemoryBytes is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMixed(long)"})
  void testSetupMixedWithMaxMainMemoryBytes_whenOne_thenReturnMaxMainMemoryBytesIsOne() {
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
   * Test {@link MemoryUsageSetting#setupMixed(long)} with {@code maxMainMemoryBytes}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return MaxMainMemoryBytes is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#setupMixed(long)}
   */
  @Test
  @DisplayName("Test setupMixed(long) with 'maxMainMemoryBytes'; when zero; then return MaxMainMemoryBytes is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MemoryUsageSetting MemoryUsageSetting.setupMixed(long)"})
  void testSetupMixedWithMaxMainMemoryBytes_whenZero_thenReturnMaxMainMemoryBytesIsZero() {
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
   * Test {@link MemoryUsageSetting#isMainMemoryRestricted()}.
   * <ul>
   *   <li>Given setupMainMemoryOnly one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#isMainMemoryRestricted()}
   */
  @Test
  @DisplayName("Test isMainMemoryRestricted(); given setupMainMemoryOnly one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MemoryUsageSetting.isMainMemoryRestricted()"})
  void testIsMainMemoryRestricted_givenSetupMainMemoryOnlyOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MemoryUsageSetting.setupMainMemoryOnly(1L).isMainMemoryRestricted());
  }

  /**
   * Test {@link MemoryUsageSetting#isMainMemoryRestricted()}.
   * <ul>
   *   <li>Given setupMainMemoryOnly zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#isMainMemoryRestricted()}
   */
  @Test
  @DisplayName("Test isMainMemoryRestricted(); given setupMainMemoryOnly zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MemoryUsageSetting.isMainMemoryRestricted()"})
  void testIsMainMemoryRestricted_givenSetupMainMemoryOnlyZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MemoryUsageSetting.setupMainMemoryOnly(0L).isMainMemoryRestricted());
  }

  /**
   * Test {@link MemoryUsageSetting#isStorageRestricted()}.
   * <ul>
   *   <li>Given setupMainMemoryOnly one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#isStorageRestricted()}
   */
  @Test
  @DisplayName("Test isStorageRestricted(); given setupMainMemoryOnly one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MemoryUsageSetting.isStorageRestricted()"})
  void testIsStorageRestricted_givenSetupMainMemoryOnlyOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MemoryUsageSetting.setupMainMemoryOnly(1L).isStorageRestricted());
  }

  /**
   * Test {@link MemoryUsageSetting#isStorageRestricted()}.
   * <ul>
   *   <li>Given setupMainMemoryOnly zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#isStorageRestricted()}
   */
  @Test
  @DisplayName("Test isStorageRestricted(); given setupMainMemoryOnly zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MemoryUsageSetting.isStorageRestricted()"})
  void testIsStorageRestricted_givenSetupMainMemoryOnlyZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MemoryUsageSetting.setupMainMemoryOnly(0L).isStorageRestricted());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long MemoryUsageSetting.getMaxMainMemoryBytes()", "long MemoryUsageSetting.getMaxStorageBytes()",
      "File MemoryUsageSetting.getTempDir()", "MemoryUsageSetting MemoryUsageSetting.setTempDir(File)",
      "boolean MemoryUsageSetting.useMainMemory()", "boolean MemoryUsageSetting.useTempFile()"})
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
   * Test {@link MemoryUsageSetting#toString()}.
   * <p>
   * Method under test: {@link MemoryUsageSetting#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MemoryUsageSetting.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Mixed mode with max. of -1 main memory bytes and unrestricted scratch file size",
        MemoryUsageSetting.setupMixed(-1L, 1L).toString());
  }

  /**
   * Test {@link MemoryUsageSetting#toString()}.
   * <ul>
   *   <li>Given setupMainMemoryOnly one.</li>
   *   <li>Then return {@code Main memory only with max. of 1 bytes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#toString()}
   */
  @Test
  @DisplayName("Test toString(); given setupMainMemoryOnly one; then return 'Main memory only with max. of 1 bytes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MemoryUsageSetting.toString()"})
  void testToString_givenSetupMainMemoryOnlyOne_thenReturnMainMemoryOnlyWithMaxOf1Bytes() {
    // Arrange, Act and Assert
    assertEquals("Main memory only with max. of 1 bytes", MemoryUsageSetting.setupMainMemoryOnly(1L).toString());
  }

  /**
   * Test {@link MemoryUsageSetting#toString()}.
   * <ul>
   *   <li>Given setupTempFileOnly one.</li>
   *   <li>Then return {@code Scratch file only with max. of 1 bytes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#toString()}
   */
  @Test
  @DisplayName("Test toString(); given setupTempFileOnly one; then return 'Scratch file only with max. of 1 bytes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MemoryUsageSetting.toString()"})
  void testToString_givenSetupTempFileOnlyOne_thenReturnScratchFileOnlyWithMaxOf1Bytes() {
    // Arrange, Act and Assert
    assertEquals("Scratch file only with max. of 1 bytes", MemoryUsageSetting.setupTempFileOnly(1L).toString());
  }

  /**
   * Test {@link MemoryUsageSetting#toString()}.
   * <ul>
   *   <li>Then return {@code Main memory only with no size restriction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Main memory only with no size restriction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MemoryUsageSetting.toString()"})
  void testToString_thenReturnMainMemoryOnlyWithNoSizeRestriction() {
    // Arrange, Act and Assert
    assertEquals("Main memory only with no size restriction", MemoryUsageSetting.setupMainMemoryOnly(0L).toString());
  }

  /**
   * Test {@link MemoryUsageSetting#toString()}.
   * <ul>
   *   <li>Then return {@code Mixed mode with max. of 1 main memory bytes and max. of 1 storage bytes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Mixed mode with max. of 1 main memory bytes and max. of 1 storage bytes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MemoryUsageSetting.toString()"})
  void testToString_thenReturnMixedModeWithMaxOf1MainMemoryBytesAndMaxOf1StorageBytes() {
    // Arrange, Act and Assert
    assertEquals("Mixed mode with max. of 1 main memory bytes and max. of 1 storage bytes",
        MemoryUsageSetting.setupMixed(1L, 1L).toString());
  }

  /**
   * Test {@link MemoryUsageSetting#toString()}.
   * <ul>
   *   <li>Then return {@code Scratch file only with no size restriction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryUsageSetting#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Scratch file only with no size restriction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MemoryUsageSetting.toString()"})
  void testToString_thenReturnScratchFileOnlyWithNoSizeRestriction() {
    // Arrange, Act and Assert
    assertEquals("Scratch file only with no size restriction", MemoryUsageSetting.setupTempFileOnly(0L).toString());
  }
}
