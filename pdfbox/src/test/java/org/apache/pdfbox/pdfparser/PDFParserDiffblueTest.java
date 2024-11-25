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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFParserDiffblueTest {
  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead)}.
   * <p>
   * Method under test: {@link PDFParser#PDFParser(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test new PDFParser(RandomAccessRead)")
  void testNewPDFParser() throws IOException {
    // Arrange and Act
    PDFParser actualPdfParser = new PDFParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualPdfParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertNull(actualPdfParser.getAccessPermission());
    assertNull(actualPdfParser.getEncryption());
    assertNull(actualPdfParser.getSecurityHandler());
    assertEquals(0L, cosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, cosDocument.getStartXref());
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1.4f, cosDocument.getVersion());
    assertEquals(8, randomAccessRead.available());
    assertFalse(cosDocument.isDirect());
    assertFalse(cosDocument.hasHybridXRef());
    assertFalse(cosDocument.isClosed());
    assertFalse(cosDocument.isDecrypted());
    assertFalse(cosDocument.isEncrypted());
    assertFalse(cosDocument.isXRefStream());
    assertFalse(cosDocument.getDocumentState().isAcceptingUpdates());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfParser.isDigit());
    assertFalse(actualPdfParser.isEOF());
    assertFalse(actualPdfParser.isSpace());
    assertFalse(actualPdfParser.isWhitespace());
    BruteForceParser bruteForceParser = actualPdfParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertFalse(actualPdfParser.initialParseDone);
    assertTrue(cosDocument.getXrefTable().isEmpty());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualPdfParser.isLenient());
  }

  /**
   * Test {@link PDFParser#PDFParser(RandomAccessRead, String)}.
   * <p>
   * Method under test: {@link PDFParser#PDFParser(RandomAccessRead, String)}
   */
  @Test
  @DisplayName("Test new PDFParser(RandomAccessRead, String)")
  void testNewPDFParser2() throws IOException {
    // Arrange and Act
    PDFParser actualPdfParser = new PDFParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), "iloveyou");

    // Assert
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualPdfParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertNull(actualPdfParser.getAccessPermission());
    assertNull(actualPdfParser.getEncryption());
    assertNull(actualPdfParser.getSecurityHandler());
    assertEquals(0L, cosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, cosDocument.getStartXref());
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1.4f, cosDocument.getVersion());
    assertEquals(8, randomAccessRead.available());
    assertFalse(cosDocument.isDirect());
    assertFalse(cosDocument.hasHybridXRef());
    assertFalse(cosDocument.isClosed());
    assertFalse(cosDocument.isDecrypted());
    assertFalse(cosDocument.isEncrypted());
    assertFalse(cosDocument.isXRefStream());
    assertFalse(cosDocument.getDocumentState().isAcceptingUpdates());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfParser.isDigit());
    assertFalse(actualPdfParser.isEOF());
    assertFalse(actualPdfParser.isSpace());
    assertFalse(actualPdfParser.isWhitespace());
    BruteForceParser bruteForceParser = actualPdfParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertFalse(actualPdfParser.initialParseDone);
    assertTrue(cosDocument.getXrefTable().isEmpty());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualPdfParser.isLenient());
  }

  /**
   * Test
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String)}.
   * <p>
   * Method under test:
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String)}
   */
  @Test
  @DisplayName("Test new PDFParser(RandomAccessRead, String, InputStream, String)")
  void testNewPDFParser3() throws IOException {
    // Arrange
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    PDFParser actualPdfParser = new PDFParser(source, "iloveyou",
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Alias");

    // Assert
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualPdfParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertNull(actualPdfParser.getAccessPermission());
    assertNull(actualPdfParser.getEncryption());
    assertNull(actualPdfParser.getSecurityHandler());
    assertEquals(0L, cosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, cosDocument.getStartXref());
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1.4f, cosDocument.getVersion());
    assertEquals(8, randomAccessRead.available());
    assertFalse(cosDocument.isDirect());
    assertFalse(cosDocument.hasHybridXRef());
    assertFalse(cosDocument.isClosed());
    assertFalse(cosDocument.isDecrypted());
    assertFalse(cosDocument.isEncrypted());
    assertFalse(cosDocument.isXRefStream());
    assertFalse(cosDocument.getDocumentState().isAcceptingUpdates());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfParser.isDigit());
    assertFalse(actualPdfParser.isEOF());
    assertFalse(actualPdfParser.isSpace());
    assertFalse(actualPdfParser.isWhitespace());
    BruteForceParser bruteForceParser = actualPdfParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertFalse(actualPdfParser.initialParseDone);
    assertTrue(cosDocument.getXrefTable().isEmpty());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualPdfParser.isLenient());
  }

  /**
   * Test
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with
   * {@link COSParser#SYSPROP_EOFLOOKUPRANGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName("Test new PDFParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); given IOException(String) with SYSPROP_EOFLOOKUPRANGE")
  void testNewPDFParser_givenIOExceptionWithSysprop_eoflookuprange() throws IOException {
    // Arrange
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    ByteArrayInputStream keyStore = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException(COSParser.SYSPROP_EOFLOOKUPRANGE));

    // Act
    PDFParser actualPdfParser = new PDFParser(source, "iloveyou", keyStore, "Alias", streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualPdfParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertNull(actualPdfParser.getAccessPermission());
    assertNull(actualPdfParser.getEncryption());
    assertNull(actualPdfParser.getSecurityHandler());
    assertEquals(0L, cosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, cosDocument.getStartXref());
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1.4f, cosDocument.getVersion());
    assertEquals(8, randomAccessRead.available());
    assertFalse(cosDocument.isDirect());
    assertFalse(cosDocument.hasHybridXRef());
    assertFalse(cosDocument.isClosed());
    assertFalse(cosDocument.isDecrypted());
    assertFalse(cosDocument.isEncrypted());
    assertFalse(cosDocument.isXRefStream());
    assertFalse(cosDocument.getDocumentState().isAcceptingUpdates());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfParser.isDigit());
    assertFalse(actualPdfParser.isEOF());
    assertFalse(actualPdfParser.isSpace());
    assertFalse(actualPdfParser.isWhitespace());
    BruteForceParser bruteForceParser = actualPdfParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertFalse(actualPdfParser.initialParseDone);
    assertTrue(cosDocument.getXrefTable().isEmpty());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualPdfParser.isLenient());
  }

  /**
   * Test
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction)}.
   * <ul>
   *   <li>Given {@link RandomAccessStreamCacheImpl} (default constructor).</li>
   *   <li>Then calls {@link StreamCacheCreateFunction#create()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName("Test new PDFParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); given RandomAccessStreamCacheImpl (default constructor); then calls create()")
  void testNewPDFParser_givenRandomAccessStreamCacheImpl_thenCallsCreate() throws IOException {
    // Arrange
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    ByteArrayInputStream keyStore = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFParser actualPdfParser = new PDFParser(source, "iloveyou", keyStore, "Alias", streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualPdfParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertNull(actualPdfParser.getAccessPermission());
    assertNull(actualPdfParser.getEncryption());
    assertNull(actualPdfParser.getSecurityHandler());
    assertEquals(0L, cosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, cosDocument.getStartXref());
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1.4f, cosDocument.getVersion());
    assertEquals(8, randomAccessRead.available());
    assertFalse(cosDocument.isDirect());
    assertFalse(cosDocument.hasHybridXRef());
    assertFalse(cosDocument.isClosed());
    assertFalse(cosDocument.isDecrypted());
    assertFalse(cosDocument.isEncrypted());
    assertFalse(cosDocument.isXRefStream());
    assertFalse(cosDocument.getDocumentState().isAcceptingUpdates());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfParser.isDigit());
    assertFalse(actualPdfParser.isEOF());
    assertFalse(actualPdfParser.isSpace());
    assertFalse(actualPdfParser.isWhitespace());
    BruteForceParser bruteForceParser = actualPdfParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertFalse(actualPdfParser.initialParseDone);
    assertTrue(cosDocument.getXrefTable().isEmpty());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualPdfParser.isLenient());
  }

  /**
   * Test
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link BaseParser#source} return
   * {@link RandomAccessReadBuffer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName("Test new PDFParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); when 'null'; then source return RandomAccessReadBuffer")
  void testNewPDFParser_whenNull_thenSourceReturnRandomAccessReadBuffer() throws IOException {
    // Arrange
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    PDFParser actualPdfParser = new PDFParser(source, "iloveyou",
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Alias", null);

    // Assert
    RandomAccessRead randomAccessRead = actualPdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualPdfParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertNull(actualPdfParser.getAccessPermission());
    assertNull(actualPdfParser.getEncryption());
    assertNull(actualPdfParser.getSecurityHandler());
    assertEquals(0L, cosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, cosDocument.getStartXref());
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1.4f, cosDocument.getVersion());
    assertEquals(8, randomAccessRead.available());
    assertFalse(cosDocument.isDirect());
    assertFalse(cosDocument.hasHybridXRef());
    assertFalse(cosDocument.isClosed());
    assertFalse(cosDocument.isDecrypted());
    assertFalse(cosDocument.isEncrypted());
    assertFalse(cosDocument.isXRefStream());
    assertFalse(cosDocument.getDocumentState().isAcceptingUpdates());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfParser.isDigit());
    assertFalse(actualPdfParser.isEOF());
    assertFalse(actualPdfParser.isSpace());
    assertFalse(actualPdfParser.isWhitespace());
    BruteForceParser bruteForceParser = actualPdfParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertFalse(actualPdfParser.initialParseDone);
    assertTrue(cosDocument.getXrefTable().isEmpty());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualPdfParser.isLenient());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   * <p>
   * Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName("Test initialParse()")
  void testInitialParse() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFParser(new RandomAccessReadBuffer(ByteBuffer.wrap("A\bA\bA\bA\b".getBytes("UTF-8")))))
            .initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName("Test initialParse(); given 'A'; then throw IOException")
  void testInitialParse_givenA_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFParser(
            new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'}))))
            .initialParse());
    assertThrows(IOException.class,
        () -> (new PDFParser(
            new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0}))))
            .initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName("Test initialParse(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testInitialParse_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .initialParse());
  }

  /**
   * Test {@link PDFParser#initialParse()}.
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer(ByteBuffer)}
   * with input is wrap empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  @DisplayName("Test initialParse(); given RandomAccessReadBuffer(ByteBuffer) with input is wrap empty array of byte")
  void testInitialParse_givenRandomAccessReadBufferWithInputIsWrapEmptyArrayOfByte() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFParser(new RandomAccessReadBuffer(ByteBuffer.wrap(new byte[]{})))).initialParse());
  }

  /**
   * Test {@link PDFParser#createDocument()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFParser#createDocument()}
   */
  @Test
  @DisplayName("Test createDocument(); given 'A'")
  void testCreateDocument_givenA() throws IOException {
    // Arrange
    PDFParser pdfParser = new PDFParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));

    // Act
    PDDocument actualCreateDocumentResult = pdfParser.createDocument();

    // Assert
    assertTrue(actualCreateDocumentResult.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualCreateDocumentResult.getDocumentId());
    assertNull(actualCreateDocumentResult.getEncryption());
    AccessPermission currentAccessPermission = actualCreateDocumentResult.getCurrentAccessPermission();
    assertEquals(3901, currentAccessPermission.getPermissionBytesForPublicKey());
    assertFalse(actualCreateDocumentResult.isAllSecurityToBeRemoved());
    assertFalse(actualCreateDocumentResult.isEncrypted());
    assertFalse(currentAccessPermission.isReadOnly());
    COSDocument expectedDocument = pdfParser.document;
    assertSame(expectedDocument, actualCreateDocumentResult.getDocument());
  }

  /**
   * Test {@link PDFParser#createDocument()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFParser#createDocument()}
   */
  @Test
  @DisplayName("Test createDocument(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testCreateDocument_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDFParser pdfParser = new PDFParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    PDDocument actualCreateDocumentResult = pdfParser.createDocument();

    // Assert
    assertTrue(actualCreateDocumentResult.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualCreateDocumentResult.getDocumentId());
    assertNull(actualCreateDocumentResult.getEncryption());
    AccessPermission currentAccessPermission = actualCreateDocumentResult.getCurrentAccessPermission();
    assertEquals(3901, currentAccessPermission.getPermissionBytesForPublicKey());
    assertFalse(actualCreateDocumentResult.isAllSecurityToBeRemoved());
    assertFalse(actualCreateDocumentResult.isEncrypted());
    assertFalse(currentAccessPermission.isReadOnly());
    COSDocument expectedDocument = pdfParser.document;
    assertSame(expectedDocument, actualCreateDocumentResult.getDocument());
  }
}
