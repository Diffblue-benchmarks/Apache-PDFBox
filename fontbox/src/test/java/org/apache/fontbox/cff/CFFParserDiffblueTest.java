package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}
   */
  @Test
  @DisplayName(
      "Test parseFirstSubFontROS(RandomAccessRead, FontHeaders); when 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CFFParser.parseFirstSubFontROS(RandomAccessRead, FontHeaders)"})
  void testParseFirstSubFontROS_whenA_thenThrowIOException() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");

    // Act and Assert
    assertThrows(
        IOException.class, () -> cffParser.parseFirstSubFontROS(randomAccessRead, outHeaders));
  }

  /**
   * Test {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}
   */
  @Test
  @DisplayName(
      "Test parseFirstSubFontROS(RandomAccessRead, FontHeaders); when 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CFFParser.parseFirstSubFontROS(RandomAccessRead, FontHeaders)"})
  void testParseFirstSubFontROS_whenA_thenThrowIOException2() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 'A', 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");

    // Act and Assert
    assertThrows(
        IOException.class, () -> cffParser.parseFirstSubFontROS(randomAccessRead, outHeaders));
  }

  /**
   * Test {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}
   */
  @Test
  @DisplayName(
      "Test parseFirstSubFontROS(RandomAccessRead, FontHeaders); when 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CFFParser.parseFirstSubFontROS(RandomAccessRead, FontHeaders)"})
  void testParseFirstSubFontROS_whenA_thenThrowIOException3() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 0, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");

    // Act and Assert
    assertThrows(
        IOException.class, () -> cffParser.parseFirstSubFontROS(randomAccessRead, outHeaders));
  }

  /**
   * Test {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parseFirstSubFontROS(RandomAccessRead, FontHeaders)}
   */
  @Test
  @DisplayName(
      "Test parseFirstSubFontROS(RandomAccessRead, FontHeaders); when 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CFFParser.parseFirstSubFontROS(RandomAccessRead, FontHeaders)"})
  void testParseFirstSubFontROS_whenA_thenThrowIOException4() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 1, 'A'});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");

    // Act and Assert
    assertThrows(
        IOException.class, () -> cffParser.parseFirstSubFontROS(randomAccessRead, outHeaders));
  }

  /**
   * Test {@link CFFParser#parse(byte[], ByteSource)} with {@code bytes}, {@code source}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and four.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parse(byte[], ByteSource)}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], ByteSource) with 'bytes', 'source'; when array of byte with 'A' and four; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List CFFParser.parse(byte[], ByteSource)"})
  void testParseWithBytesSource_whenArrayOfByteWithAAndFour_thenThrowIOException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new CFFParser()
                .parse(
                    new byte[] {'A', 4, 'A', 4, 'A', 4, 'A', 4, 'A', 4, 'A', 4, 'A', 4, 'A', 4},
                    mock(ByteSource.class)));
  }

  /**
   * Test {@link CFFParser#parse(byte[], ByteSource)} with {@code bytes}, {@code source}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and four.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parse(byte[], ByteSource)}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], ByteSource) with 'bytes', 'source'; when array of byte with 'A' and four; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List CFFParser.parse(byte[], ByteSource)"})
  void testParseWithBytesSource_whenArrayOfByteWithAAndFour_thenThrowIOException2()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new CFFParser()
                .parse(
                    new byte[] {'A', 4, 'A', 4, 'A', 4, 4, 4, 'A', 4, 'A', 4, 'A', 4, 'A', 4},
                    mock(ByteSource.class)));
  }

  /**
   * Test {@link CFFParser#parse(byte[], ByteSource)} with {@code bytes}, {@code source}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and four.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parse(byte[], ByteSource)}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], ByteSource) with 'bytes', 'source'; when array of byte with 'A' and four; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List CFFParser.parse(byte[], ByteSource)"})
  void testParseWithBytesSource_whenArrayOfByteWithAAndFour_thenThrowIOException3()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new CFFParser()
                .parse(
                    new byte[] {'A', 4, 'A', 4, 'A', 4, 1, 4, 'A', 4, 'A', 4, 'A', 4, 'A', 4},
                    mock(ByteSource.class)));
  }

  /**
   * Test {@link CFFParser#parse(byte[], ByteSource)} with {@code bytes}, {@code source}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parse(byte[], ByteSource)}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], ByteSource) with 'bytes', 'source'; when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List CFFParser.parse(byte[], ByteSource)"})
  void testParseWithBytesSource_whenAxaxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new CFFParser().parse("AXAXAXAX".getBytes("UTF-8"), mock(ByteSource.class)));
  }

  /**
   * Test {@link CFFParser#parse(byte[], ByteSource)} with {@code bytes}, {@code source}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parse(byte[], ByteSource)}
   */
  @Test
  @DisplayName(
      "Test parse(byte[], ByteSource) with 'bytes', 'source'; when 'X'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List CFFParser.parse(byte[], ByteSource)"})
  void testParseWithBytesSource_whenX_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new CFFParser()
                .parse(new byte[] {'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'}, mock(ByteSource.class)));
  }

  /**
   * Test {@link CFFParser#parse(RandomAccessRead)} with {@code randomAccessRead}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parse(RandomAccessRead) with 'randomAccessRead'; when 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List CFFParser.parse(RandomAccessRead)"})
  void testParseWithRandomAccessRead_whenA_thenThrowIOException() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act and Assert
    assertThrows(IOException.class, () -> cffParser.parse(new RandomAccessReadBuffer(input)));
  }

  /**
   * Test {@link CFFParser#parse(RandomAccessRead)} with {@code randomAccessRead}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parse(RandomAccessRead) with 'randomAccessRead'; when 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List CFFParser.parse(RandomAccessRead)"})
  void testParseWithRandomAccessRead_whenA_thenThrowIOException2() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 'A', 'A', 3, 'A', 3});

    // Act and Assert
    assertThrows(IOException.class, () -> cffParser.parse(new RandomAccessReadBuffer(input)));
  }

  /**
   * Test {@link CFFParser#parse(RandomAccessRead)} with {@code randomAccessRead}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CFFParser#parse(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test parse(RandomAccessRead) with 'randomAccessRead'; when 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List CFFParser.parse(RandomAccessRead)"})
  void testParseWithRandomAccessRead_whenA_thenThrowIOException3() throws IOException {
    // Arrange
    CFFParser cffParser = new CFFParser();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 0, 'A', 3, 'A', 3});

    // Act and Assert
    assertThrows(IOException.class, () -> cffParser.parse(new RandomAccessReadBuffer(input)));
  }
}
