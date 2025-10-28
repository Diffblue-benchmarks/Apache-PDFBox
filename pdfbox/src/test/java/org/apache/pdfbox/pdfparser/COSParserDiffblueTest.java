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
import org.apache.pdfbox.cos.COSBase;
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
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.encryption.ProtectionPolicy;
import org.apache.pdfbox.pdmodel.encryption.SecurityHandler;
import org.junit.jupiter.api.Test;

class COSParserDiffblueTest {
  /**
   * Method under test: {@link COSParser#retrieveTrailer()}
   */
  @Test
  void testRetrieveTrailer() throws IOException {
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
   * Method under test: {@link COSParser#retrieveTrailer()}
   */
  @Test
  void testRetrieveTrailer2() throws IOException {
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
   * Method under test: {@link COSParser#retrieveTrailer()}
   */
  @Test
  void testRetrieveTrailer3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")));
    COSParser cosParser = new COSParser(source, "iloveyou", new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")),
        "Missing end of file marker '{}'", streamCacheCreateFunction);

    // Act
    COSDictionary actualRetrieveTrailerResult = cosParser.retrieveTrailer();

    // Assert
    verify(streamCacheCreateFunction).create();
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
   * Method under test: {@link COSParser#dereferenceCOSObject(COSObject)}
   */
  @Test
  void testDereferenceCOSObject() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertNull(cosParser.dereferenceCOSObject(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Method under test: {@link COSParser#dereferenceCOSObject(COSObject)}
   */
  @Test
  void testDereferenceCOSObject2() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'})));

    // Act and Assert
    assertNull(cosParser.dereferenceCOSObject(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Method under test: {@link COSParser#dereferenceCOSObject(COSObject)}
   */
  @Test
  void testDereferenceCOSObject3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    COSParser cosParser = new COSParser(source, "iloveyou",
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "ndo", streamCacheCreateFunction);

    // Act
    COSBase actualDereferenceCOSObjectResult = cosParser
        .dereferenceCOSObject(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDereferenceCOSObjectResult);
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Method under test: {@link COSParser#createRandomAccessReadView(long, long)}
   */
  @Test
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
   * Method under test: {@link COSParser#createRandomAccessReadView(long, long)}
   */
  @Test
  void testCreateRandomAccessReadView2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Act
    RandomAccessReadView actualCreateRandomAccessReadViewResult = (new COSParser(source, "iloveyou",
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "Key Alias", streamCacheCreateFunction))
            .createRandomAccessReadView(1L, 3L);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0L, actualCreateRandomAccessReadViewResult.getPosition());
    assertEquals(3, actualCreateRandomAccessReadViewResult.available());
    assertFalse(actualCreateRandomAccessReadViewResult.isClosed());
  }

  /**
   * Method under test:
   * {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}
   */
  @Test
  void testParseObjectStreamObject() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, new COSObjectKey(1L, 1)));
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Method under test:
   * {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}
   */
  @Test
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
   * Method under test:
   * {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}
   */
  @Test
  void testParseObjectStreamObject3() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'})));

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, new COSObjectKey(1L, 1)));
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Method under test:
   * {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}
   */
  @Test
  void testParseObjectStreamObject4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    COSParser cosParser = new COSParser(source, "iloveyou",
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "ndo", streamCacheCreateFunction);

    // Act
    COSBase actualParseObjectStreamObjectResult = cosParser.parseObjectStreamObject(1L, new COSObjectKey(1L, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualParseObjectStreamObjectResult);
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Method under test:
   * {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}
   */
  @Test
  void testParseObjectStreamObject5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    COSParser cosParser = new COSParser(source, "iloveyou",
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "ndo", streamCacheCreateFunction);

    // Act
    COSBase actualParseObjectStreamObjectResult = cosParser.parseObjectStreamObject(1L, null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualParseObjectStreamObjectResult);
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  void testParseCOSStream() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  void testParseCOSStream2() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  void testParseCOSStream3() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'})));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  void testParseCOSStream4() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
  }

  /**
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  void testParseCOSStream5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")));
    COSParser cosParser = new COSParser(source, "iloveyou", new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")),
        "The stream doesn't provide any stream length, using fallback readUntilEnd, at offset {}",
        streamCacheCreateFunction);

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSStream()));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  void testParseCOSStream6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream("A\rA\bA\bA\b".getBytes("UTF-8")));
    COSParser cosParser = new COSParser(source, "iloveyou", new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")),
        "The stream doesn't provide any stream length, using fallback readUntilEnd, at offset {}",
        streamCacheCreateFunction);

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  void testParseCOSStream7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream("A\bA\bA\bA\r".getBytes("UTF-8")));
    COSParser cosParser = new COSParser(source, "iloveyou", new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")),
        "The stream doesn't provide any stream length, using fallback readUntilEnd, at offset {}",
        streamCacheCreateFunction);

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSDictionary()));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link COSParser#getBruteForceParser()}
   */
  @Test
  void testGetBruteForceParser() throws IOException {
    // Arrange and Act
    BruteForceParser actualBruteForceParser = (new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).getBruteForceParser();

    // Assert
    assertTrue(actualBruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualBruteForceParser.bfSearchTriggered());
  }

  /**
   * Method under test: {@link COSParser#checkPages(COSDictionary)}
   */
  @Test
  void testCheckPages() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.checkPages(new COSDictionary()));
  }

  /**
   * Method under test: {@link COSParser#isString(char[])}
   */
  @Test
  void testIsString() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertFalse(cosParser.isString("AFAF".toCharArray()));
  }

  /**
   * Method under test: {@link COSParser#isString(char[])}
   */
  @Test
  void testIsString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    COSParser cosParser = new COSParser(source, "iloveyou",
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "Key Alias", streamCacheCreateFunction);

    // Act
    boolean actualIsStringResult = cosParser.isString("AFAF".toCharArray());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsStringResult);
  }

  /**
   * Method under test: {@link COSParser#isString(char[])}
   */
  @Test
  void testIsString3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Act
    boolean actualIsStringResult = (new COSParser(source, "iloveyou",
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "Key Alias", streamCacheCreateFunction))
            .isString(new char[]{});

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsStringResult);
  }

  /**
   * Method under test: {@link COSParser#readObjectMarker()}
   */
  @Test
  void testReadObjectMarker() throws IOException {
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
   * Method under test: {@link COSParser#getEncryption()}
   */
  @Test
  void testGetEncryption() throws IOException {
    // Arrange, Act and Assert
    assertNull((new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
        .getEncryption());
  }

  /**
   * Method under test: {@link COSParser#getAccessPermission()}
   */
  @Test
  void testGetAccessPermission() throws IOException {
    // Arrange, Act and Assert
    assertNull((new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
        .getAccessPermission());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSParser#getSecurityHandler()}
   *   <li>{@link COSParser#isLenient()}
   * </ul>
   */
  @Test
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

  /**
   * Method under test: {@link COSParser#COSParser(RandomAccessRead)}
   */
  @Test
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
   * Method under test:
   * {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String)}
   */
  @Test
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
   * Method under test:
   * {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  void testNewCOSParser3() throws IOException {
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
   * Method under test:
   * {@link COSParser#COSParser(RandomAccessRead, String, InputStream, String, RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  void testNewCOSParser4() throws IOException {
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
}
