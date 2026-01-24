package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFParserDiffblueTest {
  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String,
   * StreamCacheCreateFunction)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String,
   * RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName(
      "Test new PDFParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); given IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFParser.<init>(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)"
  })
  void testNewPDFParser_givenIOException() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer source = new RandomAccessReadWriteBuffer();
    ByteArrayInputStream keyStore = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException());

    // Act
    PDFParser actualPdfParser =
        new PDFParser(source, "iloveyou", keyStore, "Alias", streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadWriteBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(randomAccessRead.isClosed());
    assertTrue(actualPdfParser.isEOF());
  }

  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead)}.
   *
   * <ul>
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadView}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#PDFParser(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test new PDFParser(RandomAccessRead); then source return RandomAccessReadView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.<init>(RandomAccessRead)"})
  void testNewPDFParser_thenSourceReturnRandomAccessReadView() throws IOException {
    // Arrange, Act and Assert
    RandomAccessRead randomAccessRead =
        new PDFParser(new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 2048L, 3L))
            .source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(3, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead, String)}.
   *
   * <ul>
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadView}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#PDFParser(RandomAccessRead, String)}
   */
  @Test
  @DisplayName(
      "Test new PDFParser(RandomAccessRead, String); then source return RandomAccessReadView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.<init>(RandomAccessRead, String)"})
  void testNewPDFParser_thenSourceReturnRandomAccessReadView2() throws IOException {
    // Arrange, Act and Assert
    RandomAccessRead randomAccessRead =
        new PDFParser(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 2048L, 3L), "iloveyou")
            .source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(3, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String)}.
   *
   * <ul>
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadView}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new PDFParser(RandomAccessRead, String, InputStream, String); then source return RandomAccessReadView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.<init>(RandomAccessRead, String, InputStream, String)"})
  void testNewPDFParser_thenSourceReturnRandomAccessReadView3() throws IOException {
    // Arrange
    RandomAccessReadView source =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 2048L, 3L);

    // Act
    PDFParser actualPdfParser =
        new PDFParser(
            source, "iloveyou", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Alias");

    // Assert
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(3, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String,
   * StreamCacheCreateFunction)}.
   *
   * <ul>
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadView}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String,
   * RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName(
      "Test new PDFParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); then source return RandomAccessReadView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFParser.<init>(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)"
  })
  void testNewPDFParser_thenSourceReturnRandomAccessReadView4() throws IOException {
    // Arrange
    RandomAccessReadView source =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L);
    ByteArrayInputStream keyStore = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFParser actualPdfParser =
        new PDFParser(
            source, COSParser.SYSPROP_EOFLOOKUPRANGE, keyStore, "Alias", streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(3, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead)}.
   *
   * <ul>
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadWriteBuffer}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#PDFParser(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test new PDFParser(RandomAccessRead); then source return RandomAccessReadWriteBuffer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.<init>(RandomAccessRead)"})
  void testNewPDFParser_thenSourceReturnRandomAccessReadWriteBuffer() throws IOException {
    // Arrange and Act
    PDFParser actualPdfParser = new PDFParser(new RandomAccessReadWriteBuffer());

    // Assert
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadWriteBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(randomAccessRead.isClosed());
    assertTrue(actualPdfParser.isEOF());
  }

  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead, String)}.
   *
   * <ul>
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadWriteBuffer}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#PDFParser(RandomAccessRead, String)}
   */
  @Test
  @DisplayName(
      "Test new PDFParser(RandomAccessRead, String); then source return RandomAccessReadWriteBuffer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.<init>(RandomAccessRead, String)"})
  void testNewPDFParser_thenSourceReturnRandomAccessReadWriteBuffer2() throws IOException {
    // Arrange and Act
    PDFParser actualPdfParser = new PDFParser(new RandomAccessReadWriteBuffer(), "iloveyou");

    // Assert
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadWriteBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(randomAccessRead.isClosed());
    assertTrue(actualPdfParser.isEOF());
  }

  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String)}.
   *
   * <ul>
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadWriteBuffer}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new PDFParser(RandomAccessRead, String, InputStream, String); then source return RandomAccessReadWriteBuffer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.<init>(RandomAccessRead, String, InputStream, String)"})
  void testNewPDFParser_thenSourceReturnRandomAccessReadWriteBuffer3() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer source = new RandomAccessReadWriteBuffer();

    // Act
    PDFParser actualPdfParser =
        new PDFParser(
            source, "iloveyou", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Alias");

    // Assert
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadWriteBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(randomAccessRead.isClosed());
    assertTrue(actualPdfParser.isEOF());
  }

  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String,
   * StreamCacheCreateFunction)}.
   *
   * <ul>
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadWriteBuffer}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String,
   * RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName(
      "Test new PDFParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); then source return RandomAccessReadWriteBuffer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFParser.<init>(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)"
  })
  void testNewPDFParser_thenSourceReturnRandomAccessReadWriteBuffer4() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer source = new RandomAccessReadWriteBuffer();
    ByteArrayInputStream keyStore = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFParser actualPdfParser =
        new PDFParser(source, "iloveyou", keyStore, "Alias", streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadWriteBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(randomAccessRead.isClosed());
    assertTrue(actualPdfParser.isEOF());
  }

  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String,
   * StreamCacheCreateFunction)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadWriteBuffer}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String,
   * RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName(
      "Test new PDFParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); when 'null'; then source return RandomAccessReadWriteBuffer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFParser.<init>(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)"
  })
  void testNewPDFParser_whenNull_thenSourceReturnRandomAccessReadWriteBuffer() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer source = new RandomAccessReadWriteBuffer();

    // Act
    PDFParser actualPdfParser =
        new PDFParser(
            source,
            "iloveyou",
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
            "Alias",
            null);

    // Assert
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadWriteBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(randomAccessRead.isClosed());
    assertTrue(actualPdfParser.isEOF());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   *
   * <p>Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName("Test initialParse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.initialParse()"})
  void testInitialParse() throws IOException {
    // Arrange
    PDFParser pdfParser = new PDFParser(new RandomAccessReadWriteBuffer());
    pdfParser.setLenient(false);

    // Act and Assert
    assertThrows(IOException.class, () -> pdfParser.initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   *
   * <p>Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName("Test initialParse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.initialParse()"})
  void testInitialParse2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new PDFParser(
                    new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), "iloveyou")
                .initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   *
   * <p>Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName("Test initialParse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.initialParse()"})
  void testInitialParse3() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new PDFParser(new RandomAccessReadView(randomAccessRead, 1L, 3L), "iloveyou")
                .initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   *
   * <p>Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName("Test initialParse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.initialParse()"})
  void testInitialParse4() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new PDFParser(
                    new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 2048L),
                    "iloveyou")
                .initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   *
   * <p>Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName("Test initialParse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.initialParse()"})
  void testInitialParse5() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new PDFParser(new RandomAccessReadView(randomAccessRead, 1L, 2048L), "iloveyou")
                .initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   *
   * <ul>
   *   <li>Given {@link PDFParser#PDFParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName(
      "Test initialParse(); given PDFParser(RandomAccessRead) with source is RandomAccessReadBuffer(InputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.initialParse()"})
  void testInitialParse_givenPDFParserWithSourceIsRandomAccessReadBuffer() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFParser(source).initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   *
   * <ul>
   *   <li>Given {@link PDFParser#PDFParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName(
      "Test initialParse(); given PDFParser(RandomAccessRead) with source is RandomAccessReadBuffer(InputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.initialParse()"})
  void testInitialParse_givenPDFParserWithSourceIsRandomAccessReadBuffer2() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 0, -1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFParser(source).initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   *
   * <ul>
   *   <li>Given {@link PDFParser#PDFParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName(
      "Test initialParse(); given PDFParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.initialParse()"})
  void testInitialParse_givenPDFParserWithSourceIsRandomAccessReadWriteBuffer() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new PDFParser(new RandomAccessReadWriteBuffer()).initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer(ByteBuffer)} with input is
   *       wrap {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName(
      "Test initialParse(); given RandomAccessReadBuffer(ByteBuffer) with input is wrap 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.initialParse()"})
  void testInitialParse_givenRandomAccessReadBufferWithInputIsWrapAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    RandomAccessReadBuffer source =
        new RandomAccessReadBuffer(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFParser(source, "iloveyou").initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is three.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName(
      "Test initialParse(); given RandomAccessReadWriteBuffer(int) with definedChunkSize is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.initialParse()"})
  void testInitialParse_givenRandomAccessReadWriteBufferWithDefinedChunkSizeIsThree()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new PDFParser(new RandomAccessReadWriteBuffer(3)).initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName(
      "Test initialParse(); given RandomAccessReadWriteBuffer(int) with definedChunkSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFParser.initialParse()"})
  void testInitialParse_givenRandomAccessReadWriteBufferWithDefinedChunkSizeIsZero()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new PDFParser(new RandomAccessReadWriteBuffer(0)).initialParse());
  }

  /**
   * Test {@link PDFParser#parse()}.
   *
   * <p>Method under test: {@link PDFParser#parse()}
   */
  @Test
  @DisplayName("Test parse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PDFParser.parse()"})
  void testParse() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFParser(source).parse());
  }

  /**
   * Test {@link PDFParser#parse(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link PDFParser#parse(boolean)}
   */
  @Test
  @DisplayName("Test parse(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PDFParser.parse(boolean)"})
  void testParseWithBoolean() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFParser(source).parse(true));
  }

  /**
   * Test {@link PDFParser#parse(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link PDFParser#PDFParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#parse(boolean)}
   */
  @Test
  @DisplayName(
      "Test parse(boolean) with 'boolean'; given PDFParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PDFParser.parse(boolean)"})
  void testParseWithBoolean_givenPDFParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new PDFParser(new RandomAccessReadWriteBuffer()).parse(true));
  }

  /**
   * Test {@link PDFParser#parse(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)} with input is
   *       {@link ByteArrayInputStream#ByteArrayInputStream(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#parse(boolean)}
   */
  @Test
  @DisplayName(
      "Test parse(boolean) with 'boolean'; given RandomAccessReadBuffer(InputStream) with input is ByteArrayInputStream(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PDFParser.parse(boolean)"})
  void testParseWithBoolean_givenRandomAccessReadBufferWithInputIsByteArrayInputStream()
      throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFParser(source).parse(true));
  }

  /**
   * Test {@link PDFParser#parse()}.
   *
   * <ul>
   *   <li>Given {@link PDFParser#PDFParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#parse()}
   */
  @Test
  @DisplayName(
      "Test parse(); given PDFParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PDFParser.parse()"})
  void testParse_givenPDFParserWithSourceIsRandomAccessReadWriteBuffer() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDFParser(new RandomAccessReadWriteBuffer()).parse());
  }

  /**
   * Test {@link PDFParser#parse()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)} with input is
   *       {@link ByteArrayInputStream#ByteArrayInputStream(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link PDFParser#parse()}
   */
  @Test
  @DisplayName(
      "Test parse(); given RandomAccessReadBuffer(InputStream) with input is ByteArrayInputStream(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PDFParser.parse()"})
  void testParse_givenRandomAccessReadBufferWithInputIsByteArrayInputStream() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFParser(source).parse());
  }

  /**
   * Test {@link PDFParser#createDocument()}.
   *
   * <p>Method under test: {@link PDFParser#createDocument()}
   */
  @Test
  @DisplayName("Test createDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PDFParser.createDocument()"})
  void testCreateDocument() throws IOException {
    // Arrange
    PDFParser pdfParser = new PDFParser(new RandomAccessReadWriteBuffer());

    // Act
    PDDocument actualCreateDocumentResult = pdfParser.createDocument();

    // Assert
    assertTrue(actualCreateDocumentResult.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualCreateDocumentResult.getDocumentId());
    assertNull(actualCreateDocumentResult.getEncryption());
    assertFalse(actualCreateDocumentResult.isAllSecurityToBeRemoved());
    assertFalse(actualCreateDocumentResult.isEncrypted());
    assertSame(pdfParser.document, actualCreateDocumentResult.getDocument());
  }

  /**
   * Test {@link PDFParser#createDocument()}.
   *
   * <p>Method under test: {@link PDFParser#createDocument()}
   */
  @Test
  @DisplayName("Test createDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PDFParser.createDocument()"})
  void testCreateDocument2() throws IOException {
    // Arrange
    PDFParser pdfParser = new PDFParser(new RandomAccessReadWriteBuffer(), "iloveyou");

    // Act
    PDDocument actualCreateDocumentResult = pdfParser.createDocument();

    // Assert
    assertTrue(actualCreateDocumentResult.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualCreateDocumentResult.getDocumentId());
    assertNull(actualCreateDocumentResult.getEncryption());
    assertFalse(actualCreateDocumentResult.isAllSecurityToBeRemoved());
    assertFalse(actualCreateDocumentResult.isEncrypted());
    assertSame(pdfParser.document, actualCreateDocumentResult.getDocument());
  }
}
