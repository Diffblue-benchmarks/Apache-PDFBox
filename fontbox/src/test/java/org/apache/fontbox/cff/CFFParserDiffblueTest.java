package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.fontbox.cff.CFFParser.ByteSource;
import org.apache.fontbox.ttf.FontHeaders;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CFFParserDiffblueTest {
  /**
   * Test {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}
   */
  @Test
  @DisplayName("Test parseFirstSubFontROS(RandomAccessRead, FontHeaders); when 'A'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFParser.parseFirstSubFontROS(RandomAccessRead, FontHeaders)"})
  void testParseFirstSubFontROS_whenA_thenThrowIOException() throws IOException {
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
   * Test {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}
   */
  @Test
  @DisplayName("Test parseFirstSubFontROS(RandomAccessRead, FontHeaders); when 'A'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFParser.parseFirstSubFontROS(RandomAccessRead, FontHeaders)"})
  void testParseFirstSubFontROS_whenA_thenThrowIOException2() throws IOException {
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
   * Test {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}
   */
  @Test
  @DisplayName("Test parseFirstSubFontROS(RandomAccessRead, FontHeaders); when 'A'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFParser.parseFirstSubFontROS(RandomAccessRead, FontHeaders)"})
  void testParseFirstSubFontROS_whenA_thenThrowIOException3() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 4, 'A', 'X', 1, 'X'}));

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");

    // Act and Assert
    assertThrows(IOException.class, () -> cffParser.parseFirstSubFontROS(randomAccessRead, outHeaders));
  }

  /**
   * Test {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}
   */
  @Test
  @DisplayName("Test parseFirstSubFontROS(RandomAccessRead, FontHeaders); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFParser.parseFirstSubFontROS(RandomAccessRead, FontHeaders)"})
  void testParseFirstSubFontROS_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
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
   * Test {@link CFFParser#parse(byte[], ByteSource)} with {@code bytes}, {@code source}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFParser#parse(byte[], ByteSource)}
   */
  @Test
  @DisplayName("Test parse(byte[], ByteSource) with 'bytes', 'source'; when 'A'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List CFFParser.parse(byte[], ByteSource)"})
  void testParseWithBytesSource_whenA_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new CFFParser()).parse(new byte[]{'A', 'X', 'A', 4, 'A', 'X', 'A', 'X'}, mock(ByteSource.class)));
  }

  /**
   * Test {@link CFFParser#parse(byte[], ByteSource)} with {@code bytes}, {@code source}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFParser#parse(byte[], ByteSource)}
   */
  @Test
  @DisplayName("Test parse(byte[], ByteSource) with 'bytes', 'source'; when 'A'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List CFFParser.parse(byte[], ByteSource)"})
  void testParseWithBytesSource_whenA_thenThrowIOException2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new CFFParser()).parse(new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'}, mock(ByteSource.class)));
  }

  /**
   * Test {@link CFFParser#parse(byte[], ByteSource)} with {@code bytes}, {@code source}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFParser#parse(byte[], ByteSource)}
   */
  @Test
  @DisplayName("Test parse(byte[], ByteSource) with 'bytes', 'source'; when 'A'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List CFFParser.parse(byte[], ByteSource)"})
  void testParseWithBytesSource_whenA_thenThrowIOException3() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new CFFParser()).parse(new byte[]{'A', 'X', 'A', 4, 'A', 'X', 1, 'X'}, mock(ByteSource.class)));
  }

  /**
   * Test {@link CFFParser#parse(byte[], ByteSource)} with {@code bytes}, {@code source}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFParser#parse(byte[], ByteSource)}
   */
  @Test
  @DisplayName("Test parse(byte[], ByteSource) with 'bytes', 'source'; when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List CFFParser.parse(byte[], ByteSource)"})
  void testParseWithBytesSource_whenAxaxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();

    // Act and Assert
    assertThrows(IOException.class, () -> cffParser.parse("AXAXAXAX".getBytes("UTF-8"), mock(ByteSource.class)));
  }

  /**
   * Test {@link CFFParser#parse(RandomAccessRead)} with {@code randomAccessRead}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead) with 'randomAccessRead'; when 'A'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List CFFParser.parse(RandomAccessRead)"})
  void testParseWithRandomAccessRead_whenA_thenThrowIOException() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();

    // Act and Assert
    assertThrows(IOException.class, () -> cffParser
        .parse(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'}))));
  }

  /**
   * Test {@link CFFParser#parse(RandomAccessRead)} with {@code randomAccessRead}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test parse(RandomAccessRead) with 'randomAccessRead'; when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List CFFParser.parse(RandomAccessRead)"})
  void testParseWithRandomAccessRead_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();

    // Act and Assert
    assertThrows(IOException.class,
        () -> cffParser.parse(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CFFParser}
   *   <li>{@link CFFParser#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFParser.<init>()", "java.lang.String CFFParser.toString()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("CFFParser[null]", (new CFFParser()).toString());
  }
}
