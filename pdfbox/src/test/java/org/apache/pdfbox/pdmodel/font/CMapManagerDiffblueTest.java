package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CMapManagerDiffblueTest {
  /**
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

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
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap2() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessRead =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 512L, 3L);

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
    assertEquals(3, randomAccessRead.available());
    assertFalse(actualParseCMapResult.hasCIDMappings());
    assertFalse(actualParseCMapResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap3() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessRead =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 512L, 3L), 512L, 3L);

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
    assertEquals(3, randomAccessRead.available());
    assertFalse(actualParseCMapResult.hasCIDMappings());
    assertFalse(actualParseCMapResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap4() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

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
   *
   * <ul>
   *   <li>Then {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()} available is zero.
   * </ul>
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parseCMap(RandomAccessRead); then RandomAccessReadWriteBuffer() available is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap_thenRandomAccessReadWriteBufferAvailableIsZero() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessRead = new RandomAccessReadWriteBuffer();

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
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(actualParseCMapResult.hasCIDMappings());
    assertFalse(actualParseCMapResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapManager#parseCMap(RandomAccessRead)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte}
   *       with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap_whenByteArrayInputStreamWithArrayOfByteWithAAndMinusOne() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

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
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte}
   *       with {@code %} and cr.
   * </ul>
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with array of byte with '%' and cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap_whenByteArrayInputStreamWithArrayOfByteWithPercentSignAndCr()
      throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'%', '\r', 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

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
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte}
   *       with {@code %} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with array of byte with '%' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap_whenByteArrayInputStreamWithArrayOfByteWithPercentSignAndMinusOne()
      throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'%', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

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
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte}
   *       with tab and cr.
   * </ul>
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with array of byte with tab and cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap_whenByteArrayInputStreamWithArrayOfByteWithTabAndCr() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'\t', '\r', 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

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
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte}
   *       with tab and lf.
   * </ul>
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with array of byte with tab and lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap_whenByteArrayInputStreamWithArrayOfByteWithTabAndLf() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'\t', '\n', 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

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
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte}
   *       with tab and minus one.
   * </ul>
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with array of byte with tab and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap_whenByteArrayInputStreamWithArrayOfByteWithTabAndMinusOne()
      throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

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
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte}
   *       with tab and space.
   * </ul>
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parseCMap(RandomAccessRead); when ByteArrayInputStream(byte[]) with array of byte with tab and space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap_whenByteArrayInputStreamWithArrayOfByteWithTabAndSpace() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'\t', ' ', 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CMapManager#parseCMap(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parseCMap(RandomAccessRead); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapManager.parseCMap(RandomAccessRead)"})
  void testParseCMap_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(CMapManager.parseCMap(null));
  }
}
