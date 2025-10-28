package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.fontbox.ttf.FontHeaders;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;

class CFFParserDiffblueTest {
  /**
   * Method under test:
   * {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}
   */
  @Test
  void testParseFirstSubFontROS() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");

    // Act and Assert
    assertThrows(IOException.class, () -> cffParser.parseFirstSubFontROS(randomAccessRead, outHeaders));
  }

  /**
   * Method under test:
   * {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}
   */
  @Test
  void testParseFirstSubFontROS2() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 4, 'A', 'X', 'A', 'X'}));

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");

    // Act and Assert
    assertThrows(IOException.class, () -> cffParser.parseFirstSubFontROS(randomAccessRead, outHeaders));
  }

  /**
   * Method under test:
   * {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}
   */
  @Test
  void testParseFirstSubFontROS3() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'}));

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");

    // Act and Assert
    assertThrows(IOException.class, () -> cffParser.parseFirstSubFontROS(randomAccessRead, outHeaders));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CFFParser}
   *   <li>{@link CFFParser#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("CFFParser[null]", (new CFFParser()).toString());
  }

  /**
   * Method under test: {@link CFFParser#parse(RandomAccessRead)}
   */
  @Test
  void testParse() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();

    // Act and Assert
    assertThrows(IOException.class,
        () -> cffParser.parse(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Method under test: {@link CFFParser#parse(RandomAccessRead)}
   */
  @Test
  void testParse2() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();

    // Act and Assert
    assertThrows(IOException.class, () -> cffParser
        .parse(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'}))));
  }

  /**
   * Method under test: {@link CFFParser#parse(byte[], CFFParser.ByteSource)}
   */
  @Test
  void testParse3() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();

    // Act and Assert
    assertThrows(IOException.class,
        () -> cffParser.parse("AXAXAXAX".getBytes("UTF-8"), mock(CFFParser.ByteSource.class)));
  }

  /**
   * Method under test: {@link CFFParser#parse(byte[], CFFParser.ByteSource)}
   */
  @Test
  void testParse4() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new CFFParser()).parse(new byte[]{'A', 'X', 'A', 4, 'A', 'X', 'A', 'X'},
        mock(CFFParser.ByteSource.class)));
  }

  /**
   * Method under test: {@link CFFParser#parse(byte[], CFFParser.ByteSource)}
   */
  @Test
  void testParse5() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new CFFParser()).parse(new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'},
        mock(CFFParser.ByteSource.class)));
  }

  /**
   * Method under test: {@link CFFParser#parse(byte[], CFFParser.ByteSource)}
   */
  @Test
  void testParse6() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new CFFParser()).parse(new byte[]{'A', 'X', 'A', 4, 'A', 'X', 1, 'X'},
        mock(CFFParser.ByteSource.class)));
  }
}
