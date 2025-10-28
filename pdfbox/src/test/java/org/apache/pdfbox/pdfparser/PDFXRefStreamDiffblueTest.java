package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
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
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfparser.xref.FreeXReference;
import org.apache.pdfbox.pdfparser.xref.XReferenceEntry;
import org.junit.jupiter.api.Test;

class PDFXRefStreamDiffblueTest {
  /**
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  void testGetStream() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDFXRefStream(new COSDocument())).getStream());
  }

  /**
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  void testGetStream2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

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
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  void testGetStream3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.setSize(3L);
    pdfxRefStream.addEntry(FreeXReference.NULL_ENTRY);

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
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  void testGetStream4() throws IOException {
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
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  void testGetStream5() throws IOException {
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
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  void testGetStream6() throws IOException {
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
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  void testGetStream7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.setSize(3L);
    pdfxRefStream.addEntry(new FreeXReference(new COSObjectKey(1L, 1), 1L));

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
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  void testGetStream8() throws IOException {
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
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  void testGetStream9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.setSize(3L);
    pdfxRefStream.addEntry(new FreeXReference(new COSObjectKey(3L, 1), 1L));

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
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  void testGetStream10() throws IOException {
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
   * Method under test: {@link PDFXRefStream#addTrailerInfo(COSDictionary)}
   */
  @Test
  void testAddTrailerInfo() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdfxRefStream.addTrailerInfo(new COSDictionary());

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDFXRefStream#addTrailerInfo(COSDictionary)}
   */
  @Test
  void testAddTrailerInfo2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdfxRefStream.addTrailerInfo(new COSStream());

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDFXRefStream#addEntry(XReferenceEntry)}
   */
  @Test
  void testAddEntry() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    (new PDFXRefStream(new COSDocument(streamCacheCreateFunction))).addEntry(FreeXReference.NULL_ENTRY);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDFXRefStream#addEntry(XReferenceEntry)}
   */
  @Test
  void testAddEntry2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument(streamCacheCreateFunction));
    pdfxRefStream.addEntry(FreeXReference.NULL_ENTRY);

    // Act
    pdfxRefStream.addEntry(FreeXReference.NULL_ENTRY);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDFXRefStream#PDFXRefStream(COSDocument)}
   */
  @Test
  void testNewPDFXRefStream() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    new PDFXRefStream(new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
