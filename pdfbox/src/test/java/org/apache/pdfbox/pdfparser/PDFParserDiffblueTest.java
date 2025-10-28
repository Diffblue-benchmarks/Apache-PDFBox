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
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.junit.jupiter.api.Test;

class PDFParserDiffblueTest {
  /**
   * Method under test: {@link PDFParser#initialParse()}
   */
  @Test
  void testInitialParse() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .initialParse());
    assertThrows(IOException.class,
        () -> (new PDFParser(
            new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'}))))
                .initialParse());
    assertThrows(IOException.class,
        () -> (new PDFParser(
            new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0}))))
                .initialParse());
    assertThrows(IOException.class,
        () -> (new PDFParser(new RandomAccessReadBuffer(ByteBuffer.wrap("A\bA\bA\bA\b".getBytes("UTF-8")))))
            .initialParse());
    assertThrows(IOException.class,
        () -> (new PDFParser(new RandomAccessReadBuffer(ByteBuffer.wrap(new byte[]{})))).initialParse());
  }

  /**
   * Method under test: {@link PDFParser#createDocument()}
   */
  @Test
  void testCreateDocument() throws IOException {
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

  /**
   * Method under test: {@link PDFParser#PDFParser(RandomAccessRead)}
   */
  @Test
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
   * Method under test: {@link PDFParser#PDFParser(RandomAccessRead, String)}
   */
  @Test
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
   * Method under test:
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String)}
   */
  @Test
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
   * Method under test:
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  void testNewPDFParser4() throws IOException {
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
   * Method under test:
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  void testNewPDFParser5() throws IOException {
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
   * Method under test:
   * {@link PDFParser#PDFParser(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  void testNewPDFParser6() throws IOException {
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
}
