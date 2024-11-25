package org.apache.fontbox.cmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CMapParserDiffblueTest {
  /**
   * Test {@link CMapParser#parsePredefined(String)}.
   * <ul>
   *   <li>When {@code CIDRangeTest.class}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  @DisplayName("Test parsePredefined(String); when 'CIDRangeTest.class'; then throw IOException")
  void testParsePredefined_whenCIDRangeTestClass_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new CMapParser()).parsePredefined("CIDRangeTest.class"));
  }

  /**
   * Test {@link CMapParser#parsePredefined(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  @DisplayName("Test parsePredefined(String); when empty string; then return Name is 'null'")
  void testParsePredefined_whenEmptyString_thenReturnNameIsNull() throws IOException {
    // Arrange and Act
    CMap actualParsePredefinedResult = (new CMapParser()).parsePredefined("");

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
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  @DisplayName("Test parsePredefined(String); when 'Name'; then throw IOException")
  void testParsePredefined_whenName_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new CMapParser()).parsePredefined("Name"));
  }

  /**
   * Test {@link CMapParser#parsePredefined(String)}.
   * <ul>
   *   <li>When {@code TestCMapParser.class}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  @DisplayName("Test parsePredefined(String); when 'TestCMapParser.class'; then throw IOException")
  void testParsePredefined_whenTestCMapParserClass_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new CMapParser()).parsePredefined("TestCMapParser.class"));
  }

  /**
   * Test {@link CMapParser#parse(RandomAccessRead)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code % A%AXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead); when ByteArrayInputStream(byte[]) with '% A%AXAX' Bytes is 'UTF-8'; then return Name is 'null'")
  void testParse_whenByteArrayInputStreamWithAAxaxBytesIsUtf8_thenReturnNameIsNull() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadBuffer randomAcccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("%\rA%AXAX".getBytes("UTF-8")));

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
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code % AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead); when ByteArrayInputStream(byte[]) with '% AXAXAX' Bytes is 'UTF-8'; then return Name is 'null'")
  void testParse_whenByteArrayInputStreamWithAxaxaxBytesIsUtf8_thenReturnNameIsNull() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadBuffer randomAcccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("%\rAXAXAX".getBytes("UTF-8")));

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
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code % AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead); when ByteArrayInputStream(byte[]) with '% AXAXAX' Bytes is 'UTF-8'; then return Name is 'null'")
  void testParse_whenByteArrayInputStreamWithAxaxaxBytesIsUtf8_thenReturnNameIsNull2() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadBuffer randomAcccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("%\nAXAXAX".getBytes("UTF-8")));

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
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return Name is 'null'")
  void testParse_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnNameIsNull() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadBuffer randomAcccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

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
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead); when ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'; then return Name is 'null'")
  void testParse_whenByteArrayInputStreamWithXaxaxaxBytesIsUtf8_thenReturnNameIsNull() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadBuffer randomAcccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("\tXAXAXAX".getBytes("UTF-8")));

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
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead); when ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'; then return Name is 'null'")
  void testParse_whenByteArrayInputStreamWithXaxaxaxBytesIsUtf8_thenReturnNameIsNull2() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadBuffer randomAcccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream(" XAXAXAX".getBytes("UTF-8")));

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
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead); when ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'; then return Name is 'null'")
  void testParse_whenByteArrayInputStreamWithXaxaxaxBytesIsUtf8_thenReturnNameIsNull3() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadBuffer randomAcccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("\rXAXAXAX".getBytes("UTF-8")));

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
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead); when ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'; then return Name is 'null'")
  void testParse_whenByteArrayInputStreamWithXaxaxaxBytesIsUtf8_thenReturnNameIsNull4() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadBuffer randomAcccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8")));

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
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code %XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead); when ByteArrayInputStream(byte[]) with '%XAXAXAX' Bytes is 'UTF-8'; then return Name is 'null'")
  void testParse_whenByteArrayInputStreamWithXaxaxaxBytesIsUtf8_thenReturnNameIsNull5() throws IOException {
    // Arrange
    CMapParser cMapParser = new CMapParser();
    RandomAccessReadBuffer randomAcccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("%XAXAXAX".getBytes("UTF-8")));

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
}
