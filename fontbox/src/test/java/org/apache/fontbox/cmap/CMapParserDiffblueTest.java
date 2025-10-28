package org.apache.fontbox.cmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;

class CMapParserDiffblueTest {
  /**
   * Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  void testParsePredefined() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new CMapParser()).parsePredefined("Name"));
    assertThrows(IOException.class, () -> (new CMapParser()).parsePredefined("CIDRangeTest.class"));
    assertThrows(IOException.class, () -> (new CMapParser()).parsePredefined("TestCMap.class"));
    assertThrows(IOException.class, () -> (new CMapParser()).parsePredefined("TestCMapParser.class"));
    assertThrows(IOException.class, () -> (new CMapParser()).parsePredefined("TestCodespaceRange.class"));
  }

  /**
   * Method under test: {@link CMapParser#parsePredefined(String)}
   */
  @Test
  void testParsePredefined2() throws IOException {
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
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  void testParse() throws IOException {
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
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  void testParse2() throws IOException {
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
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  void testParse3() throws IOException {
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
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  void testParse4() throws IOException {
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
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  void testParse5() throws IOException {
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
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  void testParse6() throws IOException {
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

  /**
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  void testParse7() throws IOException {
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
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  void testParse8() throws IOException {
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
   * Method under test: {@link CMapParser#parse(RandomAccessRead)}
   */
  @Test
  void testParse9() throws IOException {
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
}
