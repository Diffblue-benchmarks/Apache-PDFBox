package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.function.BiConsumer;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfparser.xref.FreeXReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFXRefStreamDiffblueTest {
  /**
   * Test {@link PDFXRefStream#PDFXRefStream(COSDocument)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>Then calls {@link COSDocument#createCOSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#PDFXRefStream(COSDocument)}
   */
  @Test
  @DisplayName("Test new PDFXRefStream(COSDocument); given COSStream(); then calls createCOSStream()")
  void testNewPDFXRefStream_givenCOSStream_thenCallsCreateCOSStream() {
    // Arrange
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(new COSStream());

    // Act
    new PDFXRefStream(cosDocument);

    // Assert
    verify(cosDocument).createCOSStream();
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream()")
  void testGetStream() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)));

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase filters = actualStream.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    COSUpdateState updateState = actualStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(filters.getKey());
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    COSIncrement toIncrementResult = actualStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualStream.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream()")
  void testGetStream2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)));

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.addEntry(FreeXReference.NULL_ENTRY);
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase filters = actualStream.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    COSUpdateState updateState = actualStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(filters.getKey());
    assertNull(actualStream.getKey());
    assertEquals(12L, actualStream.getLength());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    COSIncrement toIncrementResult = actualStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualStream.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then return Length is twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); given COSObjectKey(long, int) with num is one and gen is one; then return Length is twelve")
  void testGetStream_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnLengthIsTwelve() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.addEntry(new FreeXReference(new COSObjectKey(1L, 1), 1L));
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase filters = actualStream.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    COSUpdateState updateState = actualStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(filters.getKey());
    assertNull(actualStream.getKey());
    assertEquals(12L, actualStream.getLength());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    COSIncrement toIncrementResult = actualStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualStream.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is three and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); given COSObjectKey(long, int) with num is three and gen is one")
  void testGetStream_givenCOSObjectKeyWithNumIsThreeAndGenIsOne() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.addEntry(new FreeXReference(new COSObjectKey(3L, 1), 1L));
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase filters = actualStream.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    COSUpdateState updateState = actualStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(filters.getKey());
    assertNull(actualStream.getKey());
    assertEquals(12L, actualStream.getLength());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    COSIncrement toIncrementResult = actualStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualStream.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <ul>
   *   <li>Given {@link PDFXRefStream#PDFXRefStream(COSDocument)} with cosDocument
   * is {@link COSDocument#COSDocument(StreamCacheCreateFunction)} addEntry
   * {@link FreeXReference#NULL_ENTRY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); given PDFXRefStream(COSDocument) with cosDocument is COSDocument(StreamCacheCreateFunction) addEntry NULL_ENTRY")
  void testGetStream_givenPDFXRefStreamWithCosDocumentIsCOSDocumentAddEntryNull_entry() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.addEntry(FreeXReference.NULL_ENTRY);
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase filters = actualStream.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    COSUpdateState updateState = actualStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(filters.getKey());
    assertNull(actualStream.getKey());
    assertEquals(12L, actualStream.getLength());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    COSIncrement toIncrementResult = actualStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualStream.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <ul>
   *   <li>Given {@link PDFXRefStream#PDFXRefStream(COSDocument)} with cosDocument
   * is {@link COSDocument#COSDocument(StreamCacheCreateFunction)} Size is
   * {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); given PDFXRefStream(COSDocument) with cosDocument is COSDocument(StreamCacheCreateFunction) Size is MAX_VALUE")
  void testGetStream_givenPDFXRefStreamWithCosDocumentIsCOSDocumentSizeIsMax_value() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.setSize(Long.MAX_VALUE);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase filters = actualStream.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    COSUpdateState updateState = actualStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(filters.getKey());
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    COSIncrement toIncrementResult = actualStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualStream.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <ul>
   *   <li>Given {@link PDFXRefStream#PDFXRefStream(COSDocument)} with cosDocument
   * is {@link COSDocument#COSDocument(StreamCacheCreateFunction)} Size is
   * {@link Long#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); given PDFXRefStream(COSDocument) with cosDocument is COSDocument(StreamCacheCreateFunction) Size is MIN_VALUE")
  void testGetStream_givenPDFXRefStreamWithCosDocumentIsCOSDocumentSizeIsMin_value() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.setSize(Long.MIN_VALUE);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase filters = actualStream.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    COSUpdateState updateState = actualStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(filters.getKey());
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    COSIncrement toIncrementResult = actualStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualStream.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <ul>
   *   <li>Given {@link PDFXRefStream#PDFXRefStream(COSDocument)} with cosDocument
   * is {@link COSDocument#COSDocument()} Size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); given PDFXRefStream(COSDocument) with cosDocument is COSDocument() Size is three")
  void testGetStream_givenPDFXRefStreamWithCosDocumentIsCOSDocumentSizeIsThree() throws IOException {
    // Arrange
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument());
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    COSBase filters = actualStream.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    COSUpdateState updateState = actualStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(filters.getKey());
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    COSIncrement toIncrementResult = actualStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualStream.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <ul>
   *   <li>Given {@link StreamCacheCreateFunction}
   * {@link StreamCacheCreateFunction#create()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); given StreamCacheCreateFunction create() return 'null'")
  void testGetStream_givenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase filters = actualStream.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    COSUpdateState updateState = actualStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(filters.getKey());
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    COSIncrement toIncrementResult = actualStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualStream.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); then throw IllegalArgumentException")
  void testGetStream_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDFXRefStream(new COSDocument())).getStream());
  }

  /**
   * Test {@link PDFXRefStream#addTrailerInfo(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary} {@link COSDictionary#forEach(BiConsumer)} does
   * nothing.</li>
   *   <li>Then calls {@link COSDictionary#forEach(BiConsumer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#addTrailerInfo(COSDictionary)}
   */
  @Test
  @DisplayName("Test addTrailerInfo(COSDictionary); when COSDictionary forEach(BiConsumer) does nothing; then calls forEach(BiConsumer)")
  void testAddTrailerInfo_whenCOSDictionaryForEachDoesNothing_thenCallsForEach() {
    // Arrange
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument());
    COSDictionary trailerDict = mock(COSDictionary.class);
    doNothing().when(trailerDict).forEach(Mockito.<BiConsumer<COSName, COSBase>>any());

    // Act
    pdfxRefStream.addTrailerInfo(trailerDict);

    // Assert that nothing has changed
    verify(trailerDict).forEach(isA(BiConsumer.class));
  }
}
