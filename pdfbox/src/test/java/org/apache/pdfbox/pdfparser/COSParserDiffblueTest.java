package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
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
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
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
import org.mockito.Mockito;

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
   * Test {@link COSParser#retrieveTrailer()}.
   *
   * <p>Method under test: {@link COSParser#retrieveTrailer()}
   */
  @Test
  @DisplayName("Test retrieveTrailer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSParser.retrieveTrailer()"})
  void testRetrieveTrailer2() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

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
   *
   * <p>Method under test: {@link COSParser#retrieveTrailer()}
   */
  @Test
  @DisplayName("Test retrieveTrailer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSParser.retrieveTrailer()"})
  void testRetrieveTrailer3() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 0, -1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

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
   *
   * <p>Method under test: {@link COSParser#retrieveTrailer()}
   */
  @Test
  @DisplayName("Test retrieveTrailer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSParser.retrieveTrailer()"})
  void testRetrieveTrailer4() throws IOException {
    // Arrange
    RandomAccessReadView source =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L);
    ByteArrayInputStream keyStore =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    COSParser cosParser =
        new COSParser(source, "iloveyou", keyStore, "Missing end of file marker '{}'");

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
   *
   * <p>Method under test: {@link COSParser#retrieveTrailer()}
   */
  @Test
  @DisplayName("Test retrieveTrailer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSParser.retrieveTrailer()"})
  void testRetrieveTrailer5() throws IOException {
    // Arrange
    RandomAccessReadView source =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 2048L);
    ByteArrayInputStream keyStore =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    COSParser cosParser =
        new COSParser(source, "iloveyou", keyStore, "Missing end of file marker '{}'");

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
   *
   * <p>Method under test: {@link COSParser#retrieveTrailer()}
   */
  @Test
  @DisplayName("Test retrieveTrailer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSParser.retrieveTrailer()"})
  void testRetrieveTrailer6() throws IOException {
    // Arrange
    RandomAccessReadView source =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(), -1L, Long.MIN_VALUE);
    ByteArrayInputStream keyStore =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    COSParser cosParser =
        new COSParser(source, "iloveyou", keyStore, "Missing end of file marker '{}'");

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
   * <p>Method under test: {@link COSParser#dereferenceCOSObject(COSObject)}
   */
  @Test
  @DisplayName("Test dereferenceCOSObject(COSObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSParser.dereferenceCOSObject(COSObject)"})
  void testDereferenceCOSObject() throws IOException {
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
   * Test {@link COSParser#dereferenceCOSObject(COSObject)}.
   *
   * <p>Method under test: {@link COSParser#dereferenceCOSObject(COSObject)}
   */
  @Test
  @DisplayName("Test dereferenceCOSObject(COSObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSParser.dereferenceCOSObject(COSObject)"})
  void testDereferenceCOSObject2() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);
    COSObject obj = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    COSBase actualDereferenceCOSObjectResult = cosParser.dereferenceCOSObject(obj);

    // Assert
    assertNull(actualDereferenceCOSObjectResult);
    assertTrue(cosParser.getBruteForceParser().bfSearchTriggered());
  }

  /**
   * Test {@link COSParser#dereferenceCOSObject(COSObject)}.
   *
   * <p>Method under test: {@link COSParser#dereferenceCOSObject(COSObject)}
   */
  @Test
  @DisplayName("Test dereferenceCOSObject(COSObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSParser.dereferenceCOSObject(COSObject)"})
  void testDereferenceCOSObject3() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 0, 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);
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
   * <ul>
   *   <li>Then return Position is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#createRandomAccessReadView(long, long)}
   */
  @Test
  @DisplayName("Test createRandomAccessReadView(long, long); then return Position is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessReadView COSParser.createRandomAccessReadView(long, long)"})
  void testCreateRandomAccessReadView_thenReturnPositionIsZero() throws IOException {
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
    BruteForceParser bruteForceParser = cosParser.getBruteForceParser();
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(bruteForceParser.bfSearchTriggered());
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
  void testParseObjectStreamObject2() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, new COSObjectKey(1L, 1)));
    BruteForceParser bruteForceParser = cosParser.getBruteForceParser();
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(bruteForceParser.bfSearchTriggered());
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
  void testParseObjectStreamObject3() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 0, 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, new COSObjectKey(1L, 1)));
    BruteForceParser bruteForceParser = cosParser.getBruteForceParser();
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(bruteForceParser.bfSearchTriggered());
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
  void testParseObjectStreamObject4() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    ByteArrayInputStream keyStore =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    COSParser cosParser = new COSParser(source, "iloveyou", keyStore, "ndo");

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, new COSObjectKey(1L, 1)));
    BruteForceParser bruteForceParser = cosParser.getBruteForceParser();
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(bruteForceParser.bfSearchTriggered());
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
  void testParseObjectStreamObject5() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer());
    cosParser.setLenient(false);

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, new COSObjectKey(1L, 1)));
    BruteForceParser bruteForceParser = cosParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
  }

  /**
   * Test {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parseObjectStreamObject(long, COSObjectKey)}
   */
  @Test
  @DisplayName("Test parseObjectStreamObject(long, COSObjectKey); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSParser.parseObjectStreamObject(long, COSObjectKey)"})
  void testParseObjectStreamObject_whenNull() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer());

    // Act and Assert
    assertNull(cosParser.parseObjectStreamObject(1L, null));
    BruteForceParser bruteForceParser = cosParser.getBruteForceParser();
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(bruteForceParser.bfSearchTriggered());
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
  @MethodsUnderTest({"COSStream COSParser.parseCOSStream(COSDictionary)"})
  void testParseCOSStream() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);
    COSParser cosParser = new COSParser(source);
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dic =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 5L, 3L));

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(dic));
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
  @MethodsUnderTest({"COSStream COSParser.parseCOSStream(COSDictionary)"})
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
   * Test {@link COSParser#parseCOSStream(COSDictionary)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName("Test parseCOSStream(COSDictionary); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSParser.parseCOSStream(COSDictionary)"})
  void testParseCOSStream_thenThrowIOException() throws IOException {
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
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parseCOSStream(COSDictionary)}
   */
  @Test
  @DisplayName("Test parseCOSStream(COSDictionary); when COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSParser.parseCOSStream(COSDictionary)"})
  void testParseCOSStream_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);
    COSParser cosParser = new COSParser(source);

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.parseCOSStream(new COSStream()));
  }

  /**
   * Test {@link COSParser#checkPages(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#checkPages(COSDictionary)}
   */
  @Test
  @DisplayName("Test checkPages(COSDictionary); when COSDictionary(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSParser.checkPages(COSDictionary)"})
  void testCheckPages_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer());

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.checkPages(new COSDictionary()));
  }

  /**
   * Test {@link COSParser#isString(char[])} with {@code char[]}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)} with input is
   *       {@link ByteArrayInputStream#ByteArrayInputStream(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#isString(char[])}
   */
  @Test
  @DisplayName(
      "Test isString(char[]) with 'char[]'; given RandomAccessReadBuffer(InputStream) with input is ByteArrayInputStream(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.isString(char[])"})
  void testIsStringWithChar_givenRandomAccessReadBufferWithInputIsByteArrayInputStream()
      throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    // Act
    boolean actualIsStringResult = cosParser.isString("AFAF".toCharArray());

    // Assert
    assertFalse(actualIsStringResult);
  }

  /**
   * Test {@link COSParser#isString(char[])} with {@code char[]}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#isString(char[])}
   */
  @Test
  @DisplayName("Test isString(char[]) with 'char[]'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.isString(char[])"})
  void testIsStringWithChar_thenReturnFalse() throws IOException {
    // Arrange
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer());

    // Act
    boolean actualIsStringResult = cosParser.isString("AFAF".toCharArray());

    // Assert
    assertFalse(actualIsStringResult);
  }

  /**
   * Test {@link COSParser#isString(char[])} with {@code char[]}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#isString(char[])}
   */
  @Test
  @DisplayName("Test isString(char[]) with 'char[]'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.isString(char[])"})
  void testIsStringWithChar_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException());
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);
    ByteArrayInputStream keyStore =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    COSParser cosParser = new COSParser(source, "iloveyou", keyStore, "Key Alias");

    // Act and Assert
    assertThrows(IOException.class, () -> cosParser.isString("AFAF".toCharArray()));
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link COSParser#isString(char[])} with {@code char[]}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#isString(char[])}
   */
  @Test
  @DisplayName("Test isString(char[]) with 'char[]'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.isString(char[])"})
  void testIsStringWithChar_thenThrowNumberFormatException() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new NumberFormatException());
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);
    ByteArrayInputStream keyStore =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    COSParser cosParser = new COSParser(source, "iloveyou", keyStore, "Key Alias");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> cosParser.isString("AFAF".toCharArray()));
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link COSParser#isString(char[])} with {@code char[]}.
   *
   * <ul>
   *   <li>When empty array of {@code char}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#isString(char[])}
   */
  @Test
  @DisplayName("Test isString(char[]) with 'char[]'; when empty array of char; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.isString(char[])"})
  void testIsStringWithChar_whenEmptyArrayOfChar_thenReturnTrue() throws IOException {
    // Arrange and Act
    boolean actualIsStringResult =
        new COSParser(new RandomAccessReadWriteBuffer()).isString(new char[] {});

    // Assert
    assertTrue(actualIsStringResult);
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
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parsePDFHeader()}
   */
  @Test
  @DisplayName("Test parsePDFHeader(); given 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parsePDFHeader()"})
  void testParsePDFHeader_givenA_thenThrowIOException() throws IOException {
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
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read(byte[])} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#read(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parsePDFHeader()}
   */
  @Test
  @DisplayName(
      "Test parsePDFHeader(); given DataInputStream read(byte[]) throw IOException(); then calls read(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parsePDFHeader()"})
  void testParsePDFHeader_givenDataInputStreamReadThrowIOException_thenCallsRead()
      throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException());
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(IOException.class, () -> new COSParser(source).parsePDFHeader());
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link COSParser#parsePDFHeader()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parsePDFHeader()}
   */
  @Test
  @DisplayName("Test parsePDFHeader(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parsePDFHeader()"})
  void testParsePDFHeader_thenThrowNumberFormatException() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new NumberFormatException());
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> new COSParser(source).parsePDFHeader());
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link COSParser#parseFDFHeader()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parseFDFHeader()}
   */
  @Test
  @DisplayName("Test parseFDFHeader(); given 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parseFDFHeader()"})
  void testParseFDFHeader_givenA_thenThrowIOException() throws IOException {
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
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read(byte[])} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#read(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parseFDFHeader()}
   */
  @Test
  @DisplayName(
      "Test parseFDFHeader(); given DataInputStream read(byte[]) throw IOException(); then calls read(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parseFDFHeader()"})
  void testParseFDFHeader_givenDataInputStreamReadThrowIOException_thenCallsRead()
      throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException());
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(IOException.class, () -> new COSParser(source).parseFDFHeader());
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link COSParser#parseFDFHeader()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link COSParser#parseFDFHeader()}
   */
  @Test
  @DisplayName("Test parseFDFHeader(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSParser.parseFDFHeader()"})
  void testParseFDFHeader_thenThrowNumberFormatException() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new NumberFormatException());
    NonSeekableRandomAccessReadInputStream source =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> new COSParser(source).parseFDFHeader());
    verify(inputStream).read(isA(byte[].class));
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
