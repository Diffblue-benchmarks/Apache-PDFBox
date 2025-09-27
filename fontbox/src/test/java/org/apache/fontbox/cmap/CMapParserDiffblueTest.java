package org.apache.fontbox.cmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CMapParserDiffblueTest {
  /**
   * Test {@link CMapParser#parsePredefined(String)}.
   *
   * <ul>
   *   <li>When {@code CIDRangeTest.class}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  @DisplayName("Test parsePredefined(String); when 'CIDRangeTest.class'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parsePredefined(String)"})
  void testParsePredefined_whenCIDRangeTestClass_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new CMapParser().parsePredefined("CIDRangeTest.class"));
  }

  /**
   * Test {@link CMapParser#parsePredefined(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  @DisplayName("Test parsePredefined(String); when empty string; then return Name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parsePredefined(String)"})
  void testParsePredefined_whenEmptyString_thenReturnNameIsNull() throws IOException {
    // Arrange and Act
    CMap actualParsePredefinedResult = new CMapParser().parsePredefined("");

    // Assert
    assertNull(actualParsePredefinedResult.getName());
    assertNull(actualParsePredefinedResult.getOrdering());
    assertNull(actualParsePredefinedResult.getRegistry());
    assertNull(actualParsePredefinedResult.getVersion());
    assertNull(actualParsePredefinedResult.toString());
    assertEquals(-1, actualParsePredefinedResult.getSpaceMapping());
    assertEquals(-1, actualParsePredefinedResult.getType());
    assertEquals(0, actualParsePredefinedResult.getSupplement());
    assertEquals(0, actualParsePredefinedResult.getWMode());
    assertFalse(actualParsePredefinedResult.hasCIDMappings());
    assertFalse(actualParsePredefinedResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapParser#parsePredefined(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  @DisplayName("Test parsePredefined(String); when 'Name'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parsePredefined(String)"})
  void testParsePredefined_whenName_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new CMapParser().parsePredefined("Name"));
  }

  /**
   * Test {@link CMapParser#parsePredefined(String)}.
   *
   * <ul>
   *   <li>When {@code TestCMap.class}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  @DisplayName("Test parsePredefined(String); when 'TestCMap.class'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parsePredefined(String)"})
  void testParsePredefined_whenTestCMapClass_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new CMapParser().parsePredefined("TestCMap.class"));
  }

  /**
   * Test {@link CMapParser#parsePredefined(String)}.
   *
   * <ul>
   *   <li>When {@code TestCMapParser.class}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  @DisplayName("Test parsePredefined(String); when 'TestCMapParser.class'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parsePredefined(String)"})
  void testParsePredefined_whenTestCMapParserClass_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new CMapParser().parsePredefined("TestCMapParser.class"));
  }

  /**
   * Test {@link CMapParser#parsePredefined(String)}.
   *
   * <ul>
   *   <li>When {@code TestCodespaceRange.class}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  @DisplayName(
      "Test parsePredefined(String); when 'TestCodespaceRange.class'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parsePredefined(String)"})
  void testParsePredefined_whenTestCodespaceRangeClass_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new CMapParser().parsePredefined("TestCodespaceRange.class"));
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parse(RandomAccessRead)"})
  void testParse() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadWriteBuffer randomAcccessRead = new RandomAccessReadWriteBuffer(3);

    // Act
    CMap actualParseResult = cMapParser.parse(randomAcccessRead);

    // Assert
    assertNull(actualParseResult.getName());
    assertNull(actualParseResult.getOrdering());
    assertNull(actualParseResult.getRegistry());
    assertNull(actualParseResult.getVersion());
    assertNull(actualParseResult.toString());
    assertEquals(-1, actualParseResult.getSpaceMapping());
    assertEquals(-1, actualParseResult.getType());
    assertEquals(0, actualParseResult.getSupplement());
    assertEquals(0, actualParseResult.getWMode());
    assertEquals(0, randomAcccessRead.available());
    assertEquals(0L, randomAcccessRead.getPosition());
    assertFalse(actualParseResult.hasCIDMappings());
    assertFalse(actualParseResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parse(RandomAccessRead)"})
  void testParse2() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    NonSeekableRandomAccessReadInputStream randomAcccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act
    CMap actualParseResult = cMapParser.parse(randomAcccessRead);

    // Assert
    assertNull(actualParseResult.getName());
    assertNull(actualParseResult.getOrdering());
    assertNull(actualParseResult.getRegistry());
    assertNull(actualParseResult.getVersion());
    assertNull(actualParseResult.toString());
    assertEquals(-1, actualParseResult.getSpaceMapping());
    assertEquals(-1, actualParseResult.getType());
    assertEquals(0, actualParseResult.getSupplement());
    assertEquals(0, actualParseResult.getWMode());
    assertEquals(0, randomAcccessRead.available());
    assertEquals(8L, randomAcccessRead.getPosition());
    assertFalse(actualParseResult.hasCIDMappings());
    assertFalse(actualParseResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parse(RandomAccessRead)"})
  void testParse3() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAcccessRead = new RandomAccessReadBuffer(input);

    // Act
    CMap actualParseResult = cMapParser.parse(randomAcccessRead);

    // Assert
    assertNull(actualParseResult.getName());
    assertNull(actualParseResult.getOrdering());
    assertNull(actualParseResult.getRegistry());
    assertNull(actualParseResult.getVersion());
    assertNull(actualParseResult.toString());
    assertEquals(-1, actualParseResult.getSpaceMapping());
    assertEquals(-1, actualParseResult.getType());
    assertEquals(0, actualParseResult.getSupplement());
    assertEquals(0, actualParseResult.getWMode());
    assertEquals(0, randomAcccessRead.available());
    assertEquals(8L, randomAcccessRead.getPosition());
    assertFalse(actualParseResult.hasCIDMappings());
    assertFalse(actualParseResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parse(RandomAccessRead)"})
  void testParse4() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadView randomAcccessRead =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(3), 4L, 3L);

    // Act
    CMap actualParseResult = cMapParser.parse(randomAcccessRead);

    // Assert
    assertNull(actualParseResult.getName());
    assertNull(actualParseResult.getOrdering());
    assertNull(actualParseResult.getRegistry());
    assertNull(actualParseResult.getVersion());
    assertNull(actualParseResult.toString());
    assertEquals(-1, actualParseResult.getSpaceMapping());
    assertEquals(-1, actualParseResult.getType());
    assertEquals(0, actualParseResult.getSupplement());
    assertEquals(0, actualParseResult.getWMode());
    assertEquals(0L, randomAcccessRead.getPosition());
    assertEquals(3, randomAcccessRead.available());
    assertFalse(actualParseResult.hasCIDMappings());
    assertFalse(actualParseResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parse(RandomAccessRead)"})
  void testParse5() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadView randomAcccessRead =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(3), -1L, -1L);

    // Act
    CMap actualParseResult = cMapParser.parse(randomAcccessRead);

    // Assert
    assertNull(actualParseResult.getName());
    assertNull(actualParseResult.getOrdering());
    assertNull(actualParseResult.getRegistry());
    assertNull(actualParseResult.getVersion());
    assertNull(actualParseResult.toString());
    assertEquals(-1, actualParseResult.getSpaceMapping());
    assertEquals(-1, actualParseResult.getType());
    assertEquals(-1, randomAcccessRead.available());
    assertEquals(0, actualParseResult.getSupplement());
    assertEquals(0, actualParseResult.getWMode());
    assertEquals(0L, randomAcccessRead.getPosition());
    assertFalse(actualParseResult.hasCIDMappings());
    assertFalse(actualParseResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parse(RandomAccessRead)"})
  void testParse6() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);
    RandomAccessReadView randomAcccessRead = new RandomAccessReadView(randomAccessRead, -1L, -1L);

    // Act
    CMap actualParseResult = cMapParser.parse(randomAcccessRead);

    // Assert
    assertNull(actualParseResult.getName());
    assertNull(actualParseResult.getOrdering());
    assertNull(actualParseResult.getRegistry());
    assertNull(actualParseResult.getVersion());
    assertNull(actualParseResult.toString());
    assertEquals(-1, actualParseResult.getSpaceMapping());
    assertEquals(-1, actualParseResult.getType());
    assertEquals(-1, randomAcccessRead.available());
    assertEquals(0, actualParseResult.getSupplement());
    assertEquals(0, actualParseResult.getWMode());
    assertEquals(0L, randomAcccessRead.getPosition());
    assertFalse(actualParseResult.hasCIDMappings());
    assertFalse(actualParseResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parse(RandomAccessRead)"})
  void testParse7() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadView randomAcccessRead =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadWriteBuffer(3), -1L, 3L), 4L, 3L);

    // Act
    CMap actualParseResult = cMapParser.parse(randomAcccessRead);

    // Assert
    assertNull(actualParseResult.getName());
    assertNull(actualParseResult.getOrdering());
    assertNull(actualParseResult.getRegistry());
    assertNull(actualParseResult.getVersion());
    assertNull(actualParseResult.toString());
    assertEquals(-1, actualParseResult.getSpaceMapping());
    assertEquals(-1, actualParseResult.getType());
    assertEquals(0, actualParseResult.getSupplement());
    assertEquals(0, actualParseResult.getWMode());
    assertEquals(0L, randomAcccessRead.getPosition());
    assertEquals(3, randomAcccessRead.available());
    assertFalse(actualParseResult.hasCIDMappings());
    assertFalse(actualParseResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parse(RandomAccessRead)"})
  void testParse8() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    RandomAccessReadView randomAcccessRead = new RandomAccessReadView(randomAccessRead, 4L, 3L);

    // Act
    CMap actualParseResult = cMapParser.parse(randomAcccessRead);

    // Assert
    assertNull(actualParseResult.getName());
    assertNull(actualParseResult.getOrdering());
    assertNull(actualParseResult.getRegistry());
    assertNull(actualParseResult.getVersion());
    assertNull(actualParseResult.toString());
    assertEquals(-1, actualParseResult.getSpaceMapping());
    assertEquals(-1, actualParseResult.getType());
    assertEquals(0, actualParseResult.getSupplement());
    assertEquals(0, actualParseResult.getWMode());
    assertEquals(0, randomAcccessRead.available());
    assertEquals(3L, randomAcccessRead.getPosition());
    assertFalse(actualParseResult.hasCIDMappings());
    assertFalse(actualParseResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   *
   * <p>Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parse(RandomAccessRead)"})
  void testParse9() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadView randomAcccessRead =
        new RandomAccessReadView(
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(3), -1L, 3L), 4L, 3L),
            0L,
            3L);

    // Act
    CMap actualParseResult = cMapParser.parse(randomAcccessRead);

    // Assert
    assertNull(actualParseResult.getName());
    assertNull(actualParseResult.getOrdering());
    assertNull(actualParseResult.getRegistry());
    assertNull(actualParseResult.getVersion());
    assertNull(actualParseResult.toString());
    assertEquals(-1, actualParseResult.getSpaceMapping());
    assertEquals(-1, actualParseResult.getType());
    assertEquals(0, actualParseResult.getSupplement());
    assertEquals(0, actualParseResult.getWMode());
    assertEquals(0L, randomAcccessRead.getPosition());
    assertEquals(3, randomAcccessRead.available());
    assertFalse(actualParseResult.hasCIDMappings());
    assertFalse(actualParseResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte}
   *       with tab and minus one.
   * </ul>
   *
   * <p>Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parse(RandomAccessRead); when ByteArrayInputStream(byte[]) with array of byte with tab and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parse(RandomAccessRead)"})
  void testParse_whenByteArrayInputStreamWithArrayOfByteWithTabAndMinusOne() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAcccessRead = new RandomAccessReadBuffer(input);

    // Act
    CMap actualParseResult = cMapParser.parse(randomAcccessRead);

    // Assert
    assertNull(actualParseResult.getName());
    assertNull(actualParseResult.getOrdering());
    assertNull(actualParseResult.getRegistry());
    assertNull(actualParseResult.getVersion());
    assertNull(actualParseResult.toString());
    assertEquals(-1, actualParseResult.getSpaceMapping());
    assertEquals(-1, actualParseResult.getType());
    assertEquals(0, actualParseResult.getSupplement());
    assertEquals(0, actualParseResult.getWMode());
    assertEquals(0, randomAcccessRead.available());
    assertEquals(8L, randomAcccessRead.getPosition());
    assertFalse(actualParseResult.hasCIDMappings());
    assertFalse(actualParseResult.hasUnicodeMappings());
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parse(RandomAccessRead); when RandomAccessReadWriteBuffer(int) with definedChunkSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CMap CMapParser.parse(RandomAccessRead)"})
  void testParse_whenRandomAccessReadWriteBufferWithDefinedChunkSizeIsZero() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadView randomAcccessRead =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(0), 4L, 3L);

    // Act
    CMap actualParseResult = cMapParser.parse(randomAcccessRead);

    // Assert
    assertNull(actualParseResult.getName());
    assertNull(actualParseResult.getOrdering());
    assertNull(actualParseResult.getRegistry());
    assertNull(actualParseResult.getVersion());
    assertNull(actualParseResult.toString());
    assertEquals(-1, actualParseResult.getSpaceMapping());
    assertEquals(-1, actualParseResult.getType());
    assertEquals(0, actualParseResult.getSupplement());
    assertEquals(0, actualParseResult.getWMode());
    assertEquals(0L, randomAcccessRead.getPosition());
    assertEquals(3, randomAcccessRead.available());
    assertFalse(actualParseResult.hasCIDMappings());
    assertFalse(actualParseResult.hasUnicodeMappings());
  }
}
