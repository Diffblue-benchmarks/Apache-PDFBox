package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.encryption.ProtectionPolicy;
import org.apache.pdfbox.pdmodel.encryption.SecurityHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSParserDiffblueTest {
  /**
   * Test {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String,
   * StreamCacheCreateFunction)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String,
   * RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName(
      "Test new COSParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); given IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void COSParser.<init>(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)"
  })
  void testNewCOSParser_givenIOException() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer source = new RandomAccessReadWriteBuffer();
    ByteArrayInputStream keyStore = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException());

    // Act
    COSParser actualCosParser =
        new COSParser(source, "iloveyou", keyStore, "Key Alias", streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCosParser.source instanceof RandomAccessReadWriteBuffer);
    assertNull(actualCosParser.getAccessPermission());
    assertNull(actualCosParser.getEncryption());
    assertNull(actualCosParser.getSecurityHandler());
    assertFalse(actualCosParser.isDigit());
    assertFalse(actualCosParser.isSpace());
    assertFalse(actualCosParser.isWhitespace());
    assertFalse(actualCosParser.initialParseDone);
    assertTrue(actualCosParser.isEOF());
    assertTrue(actualCosParser.isLenient());
  }

  /**
   * Test {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String,
   * StreamCacheCreateFunction)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessStreamCacheImpl} (default constructor).
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String,
   * RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName(
      "Test new COSParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); given RandomAccessStreamCacheImpl (default constructor); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void COSParser.<init>(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)"
  })
  void testNewCOSParser_givenRandomAccessStreamCacheImpl_thenCallsCreate() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer source = new RandomAccessReadWriteBuffer();
    ByteArrayInputStream keyStore = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSParser actualCosParser =
        new COSParser(source, "iloveyou", keyStore, "Key Alias", streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCosParser.source instanceof RandomAccessReadWriteBuffer);
    assertNull(actualCosParser.getAccessPermission());
    assertNull(actualCosParser.getEncryption());
    assertNull(actualCosParser.getSecurityHandler());
    assertFalse(actualCosParser.isDigit());
    assertFalse(actualCosParser.isSpace());
    assertFalse(actualCosParser.isWhitespace());
    assertFalse(actualCosParser.initialParseDone);
    assertTrue(actualCosParser.isEOF());
    assertTrue(actualCosParser.isLenient());
  }

  /**
   * Test {@link COSParser#COSParser(RandomAccessRead)}.
   *
   * <ul>
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadWriteBuffer}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#COSParser(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test new COSParser(RandomAccessRead); then source return RandomAccessReadWriteBuffer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSParser.<init>(RandomAccessRead)"})
  void testNewCOSParser_thenSourceReturnRandomAccessReadWriteBuffer() throws IOException {
    // Arrange and Act
    COSParser actualCosParser = new COSParser(new RandomAccessReadWriteBuffer());

    // Assert
    assertTrue(actualCosParser.source instanceof RandomAccessReadWriteBuffer);
    assertNull(actualCosParser.getAccessPermission());
    assertNull(actualCosParser.getEncryption());
    assertNull(actualCosParser.getSecurityHandler());
    assertFalse(actualCosParser.isDigit());
    assertFalse(actualCosParser.isSpace());
    assertFalse(actualCosParser.isWhitespace());
    assertFalse(actualCosParser.initialParseDone);
    assertTrue(actualCosParser.isEOF());
    assertTrue(actualCosParser.isLenient());
  }

  /**
   * Test {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String)}.
   *
   * <ul>
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadWriteBuffer}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#COSParser(RandomAccessRead, String, InputStream,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new COSParser(RandomAccessRead, String, InputStream, String); then source return RandomAccessReadWriteBuffer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSParser.<init>(RandomAccessRead, String, InputStream, String)"})
  void testNewCOSParser_thenSourceReturnRandomAccessReadWriteBuffer2() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer source = new RandomAccessReadWriteBuffer();

    // Act
    COSParser actualCosParser =
        new COSParser(
            source,
            "iloveyou",
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
            "Key Alias");

    // Assert
    assertTrue(actualCosParser.source instanceof RandomAccessReadWriteBuffer);
    assertNull(actualCosParser.getAccessPermission());
    assertNull(actualCosParser.getEncryption());
    assertNull(actualCosParser.getSecurityHandler());
    assertFalse(actualCosParser.isDigit());
    assertFalse(actualCosParser.isSpace());
    assertFalse(actualCosParser.isWhitespace());
    assertFalse(actualCosParser.initialParseDone);
    assertTrue(actualCosParser.isEOF());
    assertTrue(actualCosParser.isLenient());
  }

  /**
   * Test {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String,
   * StreamCacheCreateFunction)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link BaseParser#source} return {@link RandomAccessReadWriteBuffer}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String,
   * RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName(
      "Test new COSParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); when 'null'; then source return RandomAccessReadWriteBuffer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void COSParser.<init>(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)"
  })
  void testNewCOSParser_whenNull_thenSourceReturnRandomAccessReadWriteBuffer() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer source = new RandomAccessReadWriteBuffer();

    // Act
    COSParser actualCosParser =
        new COSParser(
            source,
            "iloveyou",
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
            "Key Alias",
            null);

    // Assert
    assertTrue(actualCosParser.source instanceof RandomAccessReadWriteBuffer);
    assertNull(actualCosParser.getAccessPermission());
    assertNull(actualCosParser.getEncryption());
    assertNull(actualCosParser.getSecurityHandler());
    assertFalse(actualCosParser.isDigit());
    assertFalse(actualCosParser.isSpace());
    assertFalse(actualCosParser.isWhitespace());
    assertFalse(actualCosParser.initialParseDone);
    assertTrue(actualCosParser.isEOF());
    assertTrue(actualCosParser.isLenient());
  }

  /**
   * Test {@link COSParser#retrieveTrailer()}.
   *
   * <p>Method under test: {@link COSParser#retrieveTrailer()}
   */
  @Test
  @DisplayName("Test retrieveTrailer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSParser.retrieveTrailer()"})
  void testRetrieveTrailer() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer());

    // Act
    COSDictionary actualRetrieveTrailerResult = cosParser.retrieveTrailer();

    // Assert
    COSDocument cosDocument = cosParser.document;
    assertNull(cosDocument.getDocumentID());
    assertNull(cosDocument.getEncryptionDictionary());
    assertNull(actualRetrieveTrailerResult.getKey());
    assertEquals(0, actualRetrieveTrailerResult.size());
    COSIncrement toIncrementResult = actualRetrieveTrailerResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualRetrieveTrailerResult.isDirect());
    COSUpdateState updateState = actualRetrieveTrailerResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualRetrieveTrailerResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualRetrieveTrailerResult.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Test {@link COSParser#dereferenceCOSObject(COSObject)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#dereferenceCOSObject(COSObject)}
   */
  @Test
  @DisplayName(
      "Test dereferenceCOSObject(COSObject); when COSObjectKey(long, int) with num is one and gen is one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSParser.dereferenceCOSObject(COSObject)"})
  void testDereferenceCOSObject_whenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnNull()
      throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer());
    COSObject obj = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    COSBase actualDereferenceCOSObjectResult = cosParser.dereferenceCOSObject(obj);

    // Assert
    assertNull(actualDereferenceCOSObjectResult);
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Test {@link COSParser#createRandomAccessReadView(long, long)}.
   *
   * <p>Method under test: {@link COSParser#createRandomAccessReadView(long, long)}
   */
  @Test
  @DisplayName("Test createRandomAccessReadView(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessReadView COSParser.createRandomAccessReadView(long, long)"})
  void testCreateRandomAccessReadView() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualCreateRandomAccessReadViewResult =
        new COSParser(new RandomAccessReadWriteBuffer()).createRandomAccessReadView(1L, 3L);

    // Assert
    assertEquals(0L, actualCreateRandomAccessReadViewResult.getPosition());
    assertEquals(3, actualCreateRandomAccessReadViewResult.available());
    assertFalse(actualCreateRandomAccessReadViewResult.isClosed());
  }

  /**
   * Test {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}.
   *
   * <p>Method under test: {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}
   */
  @Test
  @DisplayName("Test parseObjectStreamObject(long, COSObjectKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSParser.parseObjectStreamObject(long, COSObjectKey)"})
  void testParseObjectStreamObject() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer());

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, new COSObjectKey(1L, 1)));
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Test {@link COSParser#parseCOSStream(COSDictionary)}.
   *
   * <p>Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName("Test parseCOSStream(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSStream COSParser.parseCOSStream(COSDictionary)"})
  void testParseCOSStream() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);
    COSParser cosParser = new COSParser(source);

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#parseCOSStream(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)} with input is
   *       {@link ByteArrayInputStream#ByteArrayInputStream(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test parseCOSStream(COSDictionary); given RandomAccessReadBuffer(InputStream) with input is ByteArrayInputStream(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSStream COSParser.parseCOSStream(COSDictionary)"})
  void testParseCOSStream_givenRandomAccessReadBufferWithInputIsByteArrayInputStream()
      throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#checkPages(COSDictionary)}.
   *
   * <p>Method under test: {@link COSParser#checkPages(COSDictionary)}
   */
  @Test
  @DisplayName("Test checkPages(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSParser.checkPages(COSDictionary)"})
  void testCheckPages() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer());

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.checkPages(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#isString(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link COSParser#isString(char[])}
   */
  @Test
  @DisplayName("Test isString(char[]) with 'char[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.isString(char[])"})
  void testIsStringWithChar() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer());

    // Act
    boolean actualIsStringResult = cosParser.isString("AFAF".toCharArray());

    // Assert
    assertFalse(actualIsStringResult);
  }

  /**
   * Test {@link COSParser#readObjectMarker()}.
   *
   * <p>Method under test: {@link COSParser#readObjectMarker()}
   */
  @Test
  @DisplayName("Test readObjectMarker()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSParser.readObjectMarker()"})
  void testReadObjectMarker() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(IOException.class, () -> new COSParser(source).readObjectMarker());
  }

  /**
   * Test {@link COSParser#readObjectMarker()}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#readObjectMarker()}
   */
  @Test
  @DisplayName(
      "Test readObjectMarker(); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSParser.readObjectMarker()"})
  void testReadObjectMarker_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new COSParser(new RandomAccessReadWriteBuffer()).readObjectMarker());
  }

  /**
   * Test {@link COSParser#readObjectMarker()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)} with input is
   *       {@link ByteArrayInputStream#ByteArrayInputStream(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#readObjectMarker()}
   */
  @Test
  @DisplayName(
      "Test readObjectMarker(); given RandomAccessReadBuffer(InputStream) with input is ByteArrayInputStream(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSParser.readObjectMarker()"})
  void testReadObjectMarker_givenRandomAccessReadBufferWithInputIsByteArrayInputStream()
      throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);

    // Act and Assert
    assertThrows(IOException.class, () -> new COSParser(source).readObjectMarker());
  }

  /**
   * Test {@link COSParser#parsePDFHeader()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parsePDFHeader()}
   */
  @Test
  @DisplayName("Test parsePDFHeader(); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parsePDFHeader()"})
  void testParsePDFHeader_givenA() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(IOException.class, () -> new COSParser(source).parsePDFHeader());
  }

  /**
   * Test {@link COSParser#parsePDFHeader()}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parsePDFHeader()}
   */
  @Test
  @DisplayName(
      "Test parsePDFHeader(); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parsePDFHeader()"})
  void testParsePDFHeader_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new COSParser(new RandomAccessReadWriteBuffer()).parsePDFHeader());
  }

  /**
   * Test {@link COSParser#parsePDFHeader()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadBufferedFile#RandomAccessReadBufferedFile(String)} with
   *       filename is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parsePDFHeader()}
   */
  @Test
  @DisplayName(
      "Test parsePDFHeader(); given RandomAccessReadBufferedFile(String) with filename is 'foo.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parsePDFHeader()"})
  void testParsePDFHeader_givenRandomAccessReadBufferedFileWithFilenameIsFooTxt()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new COSParser(new RandomAccessReadBufferedFile("foo.txt")).parsePDFHeader());
  }

  /**
   * Test {@link COSParser#parseFDFHeader()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parseFDFHeader()}
   */
  @Test
  @DisplayName("Test parseFDFHeader(); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parseFDFHeader()"})
  void testParseFDFHeader_givenA() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(IOException.class, () -> new COSParser(source).parseFDFHeader());
  }

  /**
   * Test {@link COSParser#parseFDFHeader()}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parseFDFHeader()}
   */
  @Test
  @DisplayName(
      "Test parseFDFHeader(); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parseFDFHeader()"})
  void testParseFDFHeader_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new COSParser(new RandomAccessReadWriteBuffer()).parseFDFHeader());
  }

  /**
   * Test {@link COSParser#parseFDFHeader()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadBufferedFile#RandomAccessReadBufferedFile(String)} with
   *       filename is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parseFDFHeader()}
   */
  @Test
  @DisplayName(
      "Test parseFDFHeader(); given RandomAccessReadBufferedFile(String) with filename is 'foo.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parseFDFHeader()"})
  void testParseFDFHeader_givenRandomAccessReadBufferedFileWithFilenameIsFooTxt()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new COSParser(new RandomAccessReadBufferedFile("foo.txt")).parseFDFHeader());
  }

  /**
   * Test {@link COSParser#getEncryption()}.
   *
   * <p>Method under test: {@link COSParser#getEncryption()}
   */
  @Test
  @DisplayName("Test getEncryption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.encryption.PDEncryption COSParser.getEncryption()"})
  void testGetEncryption() throws IOException {
    // Arrange, Act and Assert
    assertNull(new COSParser(new RandomAccessReadWriteBuffer()).getEncryption());
  }

  /**
   * Test {@link COSParser#getAccessPermission()}.
   *
   * <p>Method under test: {@link COSParser#getAccessPermission()}
   */
  @Test
  @DisplayName("Test getAccessPermission()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.encryption.AccessPermission COSParser.getAccessPermission()"
  })
  void testGetAccessPermission() throws IOException {
    // Arrange, Act and Assert
    assertNull(new COSParser(new RandomAccessReadWriteBuffer()).getAccessPermission());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSParser#getSecurityHandler()}
   *   <li>{@link COSParser#isLenient()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityHandler COSParser.getSecurityHandler()",
    "boolean COSParser.isLenient()"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer());

    // Act
    SecurityHandler<ProtectionPolicy> actualSecurityHandler = cosParser.getSecurityHandler();

    // Assert
    assertNull(actualSecurityHandler);
    assertTrue(cosParser.isLenient());
  }
}
