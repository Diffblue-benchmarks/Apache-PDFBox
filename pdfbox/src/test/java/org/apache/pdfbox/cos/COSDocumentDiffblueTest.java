package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class COSDocumentDiffblueTest {
  /**
   * Test {@link COSDocument#COSDocument()}.
   * <p>
   * Method under test: {@link COSDocument#COSDocument()}
   */
  @Test
  @DisplayName("Test new COSDocument()")
  void testNewCOSDocument() {
    // Arrange and Act
    COSDocument actualCosDocument = new COSDocument();

    // Assert
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertFalse(actualCosDocument.getDocumentState().isAcceptingUpdates());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(ICOSParser)}.
   * <p>
   * Method under test: {@link COSDocument#COSDocument(ICOSParser)}
   */
  @Test
  @DisplayName("Test new COSDocument(ICOSParser)")
  void testNewCOSDocument2() throws IOException {
    // Arrange and Act
    COSDocument actualCosDocument = new COSDocument(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Assert
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertFalse(actualCosDocument.getDocumentState().isAcceptingUpdates());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName("Test new COSDocument(StreamCacheCreateFunction); given IOException(String) with 'foo'")
  void testNewCOSDocument_givenIOExceptionWithFoo() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException("foo"));

    // Act
    COSDocument actualCosDocument = new COSDocument(streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertFalse(actualCosDocument.getDocumentState().isAcceptingUpdates());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction, ICOSParser)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction, ICOSParser)}
   */
  @Test
  @DisplayName("Test new COSDocument(StreamCacheCreateFunction, ICOSParser); given IOException(String) with 'foo'")
  void testNewCOSDocument_givenIOExceptionWithFoo2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException("foo"));

    // Act
    COSDocument actualCosDocument = new COSDocument(streamCacheCreateFunction,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertFalse(actualCosDocument.getDocumentState().isAcceptingUpdates());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction)}.
   * <ul>
   *   <li>Given {@link RandomAccessStreamCacheImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName("Test new COSDocument(StreamCacheCreateFunction); given RandomAccessStreamCacheImpl (default constructor)")
  void testNewCOSDocument_givenRandomAccessStreamCacheImpl() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSDocument actualCosDocument = new COSDocument(streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertFalse(actualCosDocument.getDocumentState().isAcceptingUpdates());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction, ICOSParser)}.
   * <ul>
   *   <li>Given {@link RandomAccessStreamCacheImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction, ICOSParser)}
   */
  @Test
  @DisplayName("Test new COSDocument(StreamCacheCreateFunction, ICOSParser); given RandomAccessStreamCacheImpl (default constructor)")
  void testNewCOSDocument_givenRandomAccessStreamCacheImpl2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSDocument actualCosDocument = new COSDocument(streamCacheCreateFunction,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertFalse(actualCosDocument.getDocumentState().isAcceptingUpdates());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName("Test new COSDocument(StreamCacheCreateFunction); when 'null'")
  void testNewCOSDocument_whenNull() {
    // Arrange and Act
    COSDocument actualCosDocument = new COSDocument((RandomAccessStreamCache.StreamCacheCreateFunction) null);

    // Assert
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertFalse(actualCosDocument.getDocumentState().isAcceptingUpdates());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction, ICOSParser)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction, ICOSParser)}
   */
  @Test
  @DisplayName("Test new COSDocument(StreamCacheCreateFunction, ICOSParser); when 'null'")
  void testNewCOSDocument_whenNull2() throws IOException {
    // Arrange and Act
    COSDocument actualCosDocument = new COSDocument(null,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Assert
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertFalse(actualCosDocument.getDocumentState().isAcceptingUpdates());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#createCOSStream()}.
   * <p>
   * Method under test: {@link COSDocument#createCOSStream()}
   */
  @Test
  @DisplayName("Test createCOSStream()")
  void testCreateCOSStream() {
    // Arrange and Act
    COSStream actualCreateCOSStreamResult = (new COSDocument()).createCOSStream();

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(0L, actualCreateCOSStreamResult.getLength());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.hasData());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDocument#createCOSStream(COSDictionary, long, long)} with
   * {@code COSDictionary}, {@code long}, {@code long}.
   * <ul>
   *   <li>Then return Length is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDocument#createCOSStream(COSDictionary, long, long)}
   */
  @Test
  @DisplayName("Test createCOSStream(COSDictionary, long, long) with 'COSDictionary', 'long', 'long'; then return Length is three")
  void testCreateCOSStreamWithCOSDictionaryLongLong_thenReturnLengthIsThree() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Act
    COSStream actualCreateCOSStreamResult = cosDocument.createCOSStream(new COSDictionary(), 1L, 3L);

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    assertEquals(3L, actualCreateCOSStreamResult.getLength());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(actualCreateCOSStreamResult.hasData());
  }

  /**
   * Test {@link COSDocument#createCOSStream(COSDictionary, long, long)} with
   * {@code COSDictionary}, {@code long}, {@code long}.
   * <ul>
   *   <li>Then return Length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDocument#createCOSStream(COSDictionary, long, long)}
   */
  @Test
  @DisplayName("Test createCOSStream(COSDictionary, long, long) with 'COSDictionary', 'long', 'long'; then return Length is zero")
  void testCreateCOSStreamWithCOSDictionaryLongLong_thenReturnLengthIsZero() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Act
    COSStream actualCreateCOSStreamResult = cosDocument.createCOSStream(new COSStream(), 1L, 3L);

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(0L, actualCreateCOSStreamResult.getLength());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(actualCreateCOSStreamResult.hasData());
  }

  /**
   * Test {@link COSDocument#createCOSStream(COSDictionary, long, long)} with
   * {@code COSDictionary}, {@code long}, {@code long}.
   * <ul>
   *   <li>When {@code 4096}.</li>
   *   <li>Then return Length is {@code 4096}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDocument#createCOSStream(COSDictionary, long, long)}
   */
  @Test
  @DisplayName("Test createCOSStream(COSDictionary, long, long) with 'COSDictionary', 'long', 'long'; when '4096'; then return Length is '4096'")
  void testCreateCOSStreamWithCOSDictionaryLongLong_when4096_thenReturnLengthIs4096() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Act
    COSStream actualCreateCOSStreamResult = cosDocument.createCOSStream(new COSDictionary(), 1L, 4096L);

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    assertEquals(4096L, actualCreateCOSStreamResult.getLength());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(actualCreateCOSStreamResult.hasData());
  }

  /**
   * Test {@link COSDocument#getLinearizedDictionary()}.
   * <p>
   * Method under test: {@link COSDocument#getLinearizedDictionary()}
   */
  @Test
  @DisplayName("Test getLinearizedDictionary()")
  void testGetLinearizedDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDocument()).getLinearizedDictionary());
  }

  /**
   * Test {@link COSDocument#getObjectsByType(COSName)} with {@code type}.
   * <p>
   * Method under test: {@link COSDocument#getObjectsByType(COSName)}
   */
  @Test
  @DisplayName("Test getObjectsByType(COSName) with 'type'")
  void testGetObjectsByTypeWithType() {
    // Arrange, Act and Assert
    assertTrue((new COSDocument()).getObjectsByType(COSName.A).isEmpty());
  }

  /**
   * Test {@link COSDocument#getObjectsByType(COSName, COSName)} with
   * {@code type1}, {@code type2}.
   * <p>
   * Method under test: {@link COSDocument#getObjectsByType(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getObjectsByType(COSName, COSName) with 'type1', 'type2'")
  void testGetObjectsByTypeWithType1Type2() {
    // Arrange, Act and Assert
    assertTrue((new COSDocument()).getObjectsByType(COSName.A, COSName.A).isEmpty());
  }

  /**
   * Test {@link COSDocument#isEncrypted()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given COSDocument()")
  void testIsEncrypted_givenCOSDocument() {
    // Arrange, Act and Assert
    assertFalse((new COSDocument()).isEncrypted());
  }

  /**
   * Test {@link COSDocument#isEncrypted()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given COSDocument() Trailer is COSDictionary()")
  void testIsEncrypted_givenCOSDocumentTrailerIsCOSDictionary() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act and Assert
    assertFalse(cosDocument.isEncrypted());
  }

  /**
   * Test {@link COSDocument#isEncrypted()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given COSDocument() Trailer is COSStream()")
  void testIsEncrypted_givenCOSDocumentTrailerIsCOSStream() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSStream());

    // Act and Assert
    assertFalse(cosDocument.isEncrypted());
  }

  /**
   * Test {@link COSDocument#getEncryptionDictionary()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#getEncryptionDictionary()}
   */
  @Test
  @DisplayName("Test getEncryptionDictionary(); given COSDocument() Trailer is COSDictionary()")
  void testGetEncryptionDictionary_givenCOSDocumentTrailerIsCOSDictionary() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act and Assert
    assertNull(cosDocument.getEncryptionDictionary());
  }

  /**
   * Test {@link COSDocument#getEncryptionDictionary()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#getEncryptionDictionary()}
   */
  @Test
  @DisplayName("Test getEncryptionDictionary(); given COSDocument() Trailer is COSStream(); then return 'null'")
  void testGetEncryptionDictionary_givenCOSDocumentTrailerIsCOSStream_thenReturnNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSStream());

    // Act and Assert
    assertNull(cosDocument.getEncryptionDictionary());
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   * <p>
   * Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary)")
  void testSetEncryptionDictionary() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSDictionary encDictionary = new COSDictionary();

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   * <p>
   * Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary)")
  void testSetEncryptionDictionary2() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSStream encDictionary = new COSStream();

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(originDocumentState, trailer.getUpdateState().getOriginDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetEncryptionDictionary_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);

    COSDictionary encDictionary = new COSDictionary();
    encDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetEncryptionDictionary_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);

    COSDictionary encDictionary = new COSDictionary();
    encDictionary.setDirect(true);

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDocument#COSDocument()} EncryptionDictionary is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary); when 'null'; then COSDocument() EncryptionDictionary is 'null'")
  void testSetEncryptionDictionary_whenNull_thenCOSDocumentEncryptionDictionaryIsNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act
    cosDocument.setEncryptionDictionary(null);

    // Assert
    assertNull(cosDocument.getEncryptionDictionary());
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertFalse(cosDocument.isEncrypted());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#getDocumentID()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#getDocumentID()}
   */
  @Test
  @DisplayName("Test getDocumentID(); given COSDocument() Trailer is COSDictionary(); then return 'null'")
  void testGetDocumentID_givenCOSDocumentTrailerIsCOSDictionary_thenReturnNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act and Assert
    assertNull(cosDocument.getDocumentID());
  }

  /**
   * Test {@link COSDocument#getDocumentID()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#getDocumentID()}
   */
  @Test
  @DisplayName("Test getDocumentID(); given COSDocument() Trailer is COSStream(); then return 'null'")
  void testGetDocumentID_givenCOSDocumentTrailerIsCOSStream_thenReturnNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSStream());

    // Act and Assert
    assertNull(cosDocument.getDocumentID());
  }

  /**
   * Test {@link COSDocument#setDocumentID(COSArray)}.
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} DocumentID is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setDocumentID(COSArray)}
   */
  @Test
  @DisplayName("Test setDocumentID(COSArray); then COSDocument() DocumentID is COSArray()")
  void testSetDocumentID_thenCOSDocumentDocumentIDIsCOSArray() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSArray id = new COSArray();

    // Act
    cosDocument.setDocumentID(id);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(id, cosDocument.getDocumentID());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setDocumentID(COSArray)}.
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} DocumentID is {@link COSArray}
   * with floats is ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setDocumentID(COSArray)}
   */
  @Test
  @DisplayName("Test setDocumentID(COSArray); then COSDocument() DocumentID is COSArray with floats is ten and '0.5'")
  void testSetDocumentID_thenCOSDocumentDocumentIDIsCOSArrayWithFloatsIsTenAnd05() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSArray id = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    cosDocument.setDocumentID(id);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(id, cosDocument.getDocumentID());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setDocumentID(COSArray)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDocument#COSDocument()} DocumentID is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setDocumentID(COSArray)}
   */
  @Test
  @DisplayName("Test setDocumentID(COSArray); when 'null'; then COSDocument() DocumentID is 'null'")
  void testSetDocumentID_whenNull_thenCOSDocumentDocumentIDIsNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act
    cosDocument.setDocumentID(null);

    // Assert
    assertNull(cosDocument.getDocumentID());
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#setTrailer(COSDictionary)}.
   * <p>
   * Method under test: {@link COSDocument#setTrailer(COSDictionary)}
   */
  @Test
  @DisplayName("Test setTrailer(COSDictionary)")
  void testSetTrailer() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();

    // Act
    cosDocument.setTrailer(newTrailer);

    // Assert
    assertNull(cosDocument.getDocumentID());
    assertNull(cosDocument.getEncryptionDictionary());
    COSDocumentState originDocumentState = newTrailer.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertSame(newTrailer, cosDocument.getTrailer());
    assertSame(originDocumentState, cosDocument.getDocumentState());
  }

  /**
   * Test {@link COSDocument#setTrailer(COSDictionary)}.
   * <ul>
   *   <li>Then not {@link COSStream#COSStream()} UpdateState OriginDocumentState
   * AcceptingUpdates.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setTrailer(COSDictionary)}
   */
  @Test
  @DisplayName("Test setTrailer(COSDictionary); then not COSStream() UpdateState OriginDocumentState AcceptingUpdates")
  void testSetTrailer_thenNotCOSStreamUpdateStateOriginDocumentStateAcceptingUpdates() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSStream newTrailer = new COSStream();

    // Act
    cosDocument.setTrailer(newTrailer);

    // Assert
    assertNull(cosDocument.getDocumentID());
    assertNull(cosDocument.getEncryptionDictionary());
    COSDocumentState originDocumentState = newTrailer.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertSame(newTrailer, cosDocument.getTrailer());
    assertSame(originDocumentState, cosDocument.getDocumentState());
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} Trailer Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); then COSDocument() Trailer Values size is one")
  void testAccept_thenCOSDocumentTrailerValuesSizeIsOne() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);

    // Act
    cosDocument.accept(new COSWriter(new ByteArrayOutputStream(1)));

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#close()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()}.</li>
   *   <li>Then {@link COSDocument#COSDocument()} Closed.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given COSDocument(); then COSDocument() Closed")
  void testClose_givenCOSDocument_thenCOSDocumentClosed() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act
    cosDocument.close();

    // Assert
    assertTrue(cosDocument.isClosed());
  }

  /**
   * Test {@link COSDocument#close()}.
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument(StreamCacheCreateFunction)} with
   * {@link StreamCacheCreateFunction} Closed.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#close()}
   */
  @Test
  @DisplayName("Test close(); then COSDocument(StreamCacheCreateFunction) with StreamCacheCreateFunction Closed")
  void testClose_thenCOSDocumentWithStreamCacheCreateFunctionClosed() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    // Act
    cosDocument.close();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(cosDocument.isClosed());
  }

  /**
   * Test {@link COSDocument#getObjectFromPool(COSObjectKey)}.
   * <ul>
   *   <li>Then return Object is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#getObjectFromPool(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObjectFromPool(COSObjectKey); then return Object is 'null'")
  void testGetObjectFromPool_thenReturnObjectIsNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObject actualObjectFromPool = cosDocument.getObjectFromPool(key);

    // Assert
    assertNull(actualObjectFromPool.getObject());
    COSUpdateState updateState = actualObjectFromPool.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = actualObjectFromPool.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualObjectFromPool.isDirect());
    assertFalse(actualObjectFromPool.isDereferenced());
    assertFalse(actualObjectFromPool.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(actualObjectFromPool.isObjectNull());
    assertSame(key, actualObjectFromPool.getKey());
  }

  /**
   * Test {@link COSDocument#getObjectFromPool(COSObjectKey)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#getObjectFromPool(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObjectFromPool(COSObjectKey); when 'null'; then return 'null'")
  void testGetObjectFromPool_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new COSDocument()).getObjectFromPool(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSDocument#setHighestXRefObjectNumber(long)}
   *   <li>{@link COSDocument#setIsXRefStream(boolean)}
   *   <li>{@link COSDocument#setStartXref(long)}
   *   <li>{@link COSDocument#setVersion(float)}
   *   <li>{@link COSDocument#setDecrypted()}
   *   <li>{@link COSDocument#setHasHybridXRef()}
   *   <li>{@link COSDocument#getDocumentState()}
   *   <li>{@link COSDocument#getHighestXRefObjectNumber()}
   *   <li>{@link COSDocument#getStartXref()}
   *   <li>{@link COSDocument#getTrailer()}
   *   <li>{@link COSDocument#getVersion()}
   *   <li>{@link COSDocument#getXrefTable()}
   *   <li>{@link COSDocument#hasHybridXRef()}
   *   <li>{@link COSDocument#isClosed()}
   *   <li>{@link COSDocument#isDecrypted()}
   *   <li>{@link COSDocument#isXRefStream()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act
    cosDocument.setHighestXRefObjectNumber(1L);
    cosDocument.setIsXRefStream(true);
    cosDocument.setStartXref(42L);
    cosDocument.setVersion(10.0f);
    cosDocument.setDecrypted();
    cosDocument.setHasHybridXRef();
    COSDocumentState actualDocumentState = cosDocument.getDocumentState();
    long actualHighestXRefObjectNumber = cosDocument.getHighestXRefObjectNumber();
    long actualStartXref = cosDocument.getStartXref();
    cosDocument.getTrailer();
    float actualVersion = cosDocument.getVersion();
    Map<COSObjectKey, Long> actualXrefTable = cosDocument.getXrefTable();
    boolean actualHasHybridXRefResult = cosDocument.hasHybridXRef();
    boolean actualIsClosedResult = cosDocument.isClosed();
    boolean actualIsDecryptedResult = cosDocument.isDecrypted();
    boolean actualIsXRefStreamResult = cosDocument.isXRefStream();

    // Assert that nothing has changed
    assertEquals(10.0f, actualVersion);
    assertEquals(1L, actualHighestXRefObjectNumber);
    assertEquals(42L, actualStartXref);
    assertFalse(actualIsClosedResult);
    assertFalse(actualDocumentState.isAcceptingUpdates());
    assertTrue(actualXrefTable.isEmpty());
    assertTrue(actualHasHybridXRefResult);
    assertTrue(actualIsDecryptedResult);
    assertTrue(actualIsXRefStreamResult);
  }
}
