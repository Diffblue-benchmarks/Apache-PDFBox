package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.encryption.ProtectionPolicy;
import org.apache.pdfbox.pdmodel.encryption.SecurityHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class COSParserDiffblueTest {
  /**
   * Test {@link COSParser#COSParser(RandomAccessRead)}.
   * <p>
   * Method under test: {@link COSParser#COSParser(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test new COSParser(RandomAccessRead)")
  void testNewCOSParser() throws IOException {
    // Arrange and Act
    COSParser actualCosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    RandomAccessRead randomAccessRead = actualCosParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualCosParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertNull(actualCosParser.getAccessPermission());
    assertNull(actualCosParser.getEncryption());
    assertNull(actualCosParser.getSecurityHandler());
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
    assertFalse(actualCosParser.isDigit());
    assertFalse(actualCosParser.isEOF());
    assertFalse(actualCosParser.isSpace());
    assertFalse(actualCosParser.isWhitespace());
    BruteForceParser bruteForceParser = actualCosParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertFalse(actualCosParser.initialParseDone);
    assertTrue(cosDocument.getXrefTable().isEmpty());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualCosParser.isLenient());
  }

  /**
   * Test
   * {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String)}.
   * <p>
   * Method under test:
   * {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String)}
   */
  @Test
  @DisplayName("Test new COSParser(RandomAccessRead, String, InputStream, String)")
  void testNewCOSParser2() throws IOException {
    // Arrange
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    COSParser actualCosParser = new COSParser(source, "iloveyou",
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Key Alias");

    // Assert
    RandomAccessRead randomAccessRead = actualCosParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualCosParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertNull(actualCosParser.getAccessPermission());
    assertNull(actualCosParser.getEncryption());
    assertNull(actualCosParser.getSecurityHandler());
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
    assertFalse(actualCosParser.isDigit());
    assertFalse(actualCosParser.isEOF());
    assertFalse(actualCosParser.isSpace());
    assertFalse(actualCosParser.isWhitespace());
    BruteForceParser bruteForceParser = actualCosParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertFalse(actualCosParser.initialParseDone);
    assertTrue(cosDocument.getXrefTable().isEmpty());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualCosParser.isLenient());
  }

  /**
   * Test
   * {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction)}.
   * <ul>
   *   <li>Given {@link RandomAccessStreamCacheImpl} (default constructor).</li>
   *   <li>Then calls {@link StreamCacheCreateFunction#create()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName("Test new COSParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); given RandomAccessStreamCacheImpl (default constructor); then calls create()")
  void testNewCOSParser_givenRandomAccessStreamCacheImpl_thenCallsCreate() throws IOException {
    // Arrange
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    ByteArrayInputStream keyStore = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSParser actualCosParser = new COSParser(source, "iloveyou", keyStore, "Key Alias", streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = actualCosParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualCosParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertNull(actualCosParser.getAccessPermission());
    assertNull(actualCosParser.getEncryption());
    assertNull(actualCosParser.getSecurityHandler());
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
    assertFalse(actualCosParser.isDigit());
    assertFalse(actualCosParser.isEOF());
    assertFalse(actualCosParser.isSpace());
    assertFalse(actualCosParser.isWhitespace());
    BruteForceParser bruteForceParser = actualCosParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertFalse(actualCosParser.initialParseDone);
    assertTrue(cosDocument.getXrefTable().isEmpty());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualCosParser.isLenient());
  }

  /**
   * Test
   * {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link BaseParser#source} return
   * {@link RandomAccessReadBuffer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName("Test new COSParser(RandomAccessRead, String, InputStream, String, StreamCacheCreateFunction); when 'null'; then source return RandomAccessReadBuffer")
  void testNewCOSParser_whenNull_thenSourceReturnRandomAccessReadBuffer() throws IOException {
    // Arrange
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    COSParser actualCosParser = new COSParser(source, "iloveyou",
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Key Alias", null);

    // Assert
    RandomAccessRead randomAccessRead = actualCosParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualCosParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertNull(actualCosParser.getAccessPermission());
    assertNull(actualCosParser.getEncryption());
    assertNull(actualCosParser.getSecurityHandler());
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
    assertFalse(actualCosParser.isDigit());
    assertFalse(actualCosParser.isEOF());
    assertFalse(actualCosParser.isSpace());
    assertFalse(actualCosParser.isWhitespace());
    BruteForceParser bruteForceParser = actualCosParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertFalse(actualCosParser.initialParseDone);
    assertTrue(cosDocument.getXrefTable().isEmpty());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualCosParser.isLenient());
  }

  /**
   * Test {@link COSParser#retrieveTrailer()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#retrieveTrailer()}
   */
  @Test
  @DisplayName("Test retrieveTrailer(); given 'A'")
  void testRetrieveTrailer_givenA() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'})));

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
   * Test {@link COSParser#retrieveTrailer()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#retrieveTrailer()}
   */
  @Test
  @DisplayName("Test retrieveTrailer(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testRetrieveTrailer_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

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
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#dereferenceCOSObject(COSObject)}
   */
  @Test
  @DisplayName("Test dereferenceCOSObject(COSObject); given 'A'; then return 'null'")
  void testDereferenceCOSObject_givenA_thenReturnNull() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'})));

    // Act and Assert
    assertNull(cosParser.dereferenceCOSObject(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Test {@link COSParser#dereferenceCOSObject(COSObject)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#dereferenceCOSObject(COSObject)}
   */
  @Test
  @DisplayName("Test dereferenceCOSObject(COSObject); when COSObjectKey(long, int) with num is one and gen is one; then return 'null'")
  void testDereferenceCOSObject_whenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnNull() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertNull(cosParser.dereferenceCOSObject(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Test {@link COSParser#createRandomAccessReadView(long, long)}.
   * <p>
   * Method under test: {@link COSParser#createRandomAccessReadView(long, long)}
   */
  @Test
  @DisplayName("Test createRandomAccessReadView(long, long)")
  void testCreateRandomAccessReadView() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualCreateRandomAccessReadViewResult = (new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
        .createRandomAccessReadView(1L, 3L);

    // Assert
    assertEquals(0L, actualCreateRandomAccessReadViewResult.getPosition());
    assertEquals(3, actualCreateRandomAccessReadViewResult.available());
    assertFalse(actualCreateRandomAccessReadViewResult.isClosed());
  }

  /**
   * Test {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}.
   * <p>
   * Method under test:
   * {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}
   */
  @Test
  @DisplayName("Test parseObjectStreamObject(long, COSObjectKey)")
  void testParseObjectStreamObject() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, new COSObjectKey(1L, 1)));
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Test {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}.
   * <p>
   * Method under test:
   * {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}
   */
  @Test
  @DisplayName("Test parseObjectStreamObject(long, COSObjectKey)")
  void testParseObjectStreamObject2() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    cosParser.setLenient(false);

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, new COSObjectKey(1L, 1)));
    assertFalse(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Test {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}
   */
  @Test
  @DisplayName("Test parseObjectStreamObject(long, COSObjectKey); given 'A'")
  void testParseObjectStreamObject_givenA() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'})));

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, new COSObjectKey(1L, 1)));
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Test {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}
   */
  @Test
  @DisplayName("Test parseObjectStreamObject(long, COSObjectKey); when 'null'")
  void testParseObjectStreamObject_whenNull() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, null));
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Test {@link COSParser#parseCOSStream(COSDictionary)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName("Test parseCOSStream(COSDictionary); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'")
  void testParseCOSStream_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#parseCOSStream(COSDictionary)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName("Test parseCOSStream(COSDictionary); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'")
  void testParseCOSStream_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf82() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("A\rAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#parseCOSStream(COSDictionary)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * array of {@code byte} with {@code A} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName("Test parseCOSStream(COSDictionary); given ByteArrayInputStream(byte[]) with array of byte with 'A' and zero")
  void testParseCOSStream_givenByteArrayInputStreamWithArrayOfByteWithAAndZero() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'})));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#parseCOSStream(COSDictionary)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName("Test parseCOSStream(COSDictionary); given ByteArrayInputStream(byte[]) with array of byte with zero and 'X'")
  void testParseCOSStream_givenByteArrayInputStreamWithArrayOfByteWithZeroAndX() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#parseCOSStream(COSDictionary)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName("Test parseCOSStream(COSDictionary); given ByteArrayInputStream(byte[]) with 'AXAXAXA' Bytes is 'UTF-8'")
  void testParseCOSStream_givenByteArrayInputStreamWithAxaxaxaBytesIsUtf8() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXA\r".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#parseCOSStream(COSDictionary)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName("Test parseCOSStream(COSDictionary); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testParseCOSStream_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#parseCOSStream(COSDictionary)}.
   * <ul>
   *   <li>Given lf.</li>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName("Test parseCOSStream(COSDictionary); given lf; when COSDictionary(); then throw IOException")
  void testParseCOSStream_givenLf_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', '\n'})));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#parseCOSStream(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName("Test parseCOSStream(COSDictionary); when COSStream()")
  void testParseCOSStream_whenCOSStream() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSStream()));
  }

  /**
   * Test {@link COSParser#getBruteForceParser()}.
   * <p>
   * Method under test: {@link COSParser#getBruteForceParser()}
   */
  @Test
  @DisplayName("Test getBruteForceParser()")
  void testGetBruteForceParser() throws IOException {
    // Arrange and Act
    BruteForceParser actualBruteForceParser = (new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).getBruteForceParser();

    // Assert
    assertTrue(actualBruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualBruteForceParser.bfSearchTriggered());
  }

  /**
   * Test {@link COSParser#checkPages(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#checkPages(COSDictionary)}
   */
  @Test
  @DisplayName("Test checkPages(COSDictionary); when COSDictionary(); then throw IOException")
  void testCheckPages_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.checkPages(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#checkPages(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#checkPages(COSDictionary)}
   */
  @Test
  @DisplayName("Test checkPages(COSDictionary); when COSStream(); then throw IOException")
  void testCheckPages_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.checkPages(new COSStream()));
  }

  /**
   * Test {@link COSParser#isString(char[])} with {@code char[]}.
   * <ul>
   *   <li>When {@code AFAF} toCharArray.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#isString(char[])}
   */
  @Test
  @DisplayName("Test isString(char[]) with 'char[]'; when 'AFAF' toCharArray; then return 'false'")
  void testIsStringWithChar_whenAfafToCharArray_thenReturnFalse() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertFalse(cosParser.isString("AFAF".toCharArray()));
  }

  /**
   * Test {@link COSParser#isString(char[])} with {@code char[]}.
   * <ul>
   *   <li>When empty array of {@code char}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#isString(char[])}
   */
  @Test
  @DisplayName("Test isString(char[]) with 'char[]'; when empty array of char; then return 'true'")
  void testIsStringWithChar_whenEmptyArrayOfChar_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
        .isString(new char[]{}));
  }

  /**
   * Test {@link COSParser#readObjectMarker()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSParser#readObjectMarker()}
   */
  @Test
  @DisplayName("Test readObjectMarker(); then throw IllegalArgumentException")
  void testReadObjectMarker_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    RandomAccessRead source = mock(RandomAccessRead.class);
    doThrow(new IllegalArgumentException("foo")).when(source).rewind(anyInt());
    when(source.read()).thenReturn(1);
    when(source.length()).thenReturn(3L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new COSParser(source)).readObjectMarker());
    verify(source).length();
    verify(source).read();
    verify(source).rewind(eq(1));
  }

  /**
   * Test {@link COSParser#getEncryption()}.
   * <p>
   * Method under test: {@link COSParser#getEncryption()}
   */
  @Test
  @DisplayName("Test getEncryption()")
  void testGetEncryption() throws IOException {
    // Arrange, Act and Assert
    assertNull((new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
        .getEncryption());
  }

  /**
   * Test {@link COSParser#getAccessPermission()}.
   * <p>
   * Method under test: {@link COSParser#getAccessPermission()}
   */
  @Test
  @DisplayName("Test getAccessPermission()")
  void testGetAccessPermission() throws IOException {
    // Arrange, Act and Assert
    assertNull((new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
        .getAccessPermission());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSParser#getSecurityHandler()}
   *   <li>{@link COSParser#isLenient()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    SecurityHandler<ProtectionPolicy> actualSecurityHandler = cosParser.getSecurityHandler();

    // Assert
    assertNull(actualSecurityHandler);
    assertTrue(cosParser.isLenient());
  }
}
