package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class PDObjectStreamDiffblueTest {
  /**
   * Method under test: {@link PDObjectStream#createStream(PDDocument)}
   */
  @Test
  void testCreateStream() throws IOException {
    // Arrange and Act
    PDObjectStream actualCreateStreamResult = PDObjectStream.createStream(new PDDocument());

    // Assert
    assertEquals("ObjStm", actualCreateStreamResult.getType());
    assertNull(actualCreateStreamResult.getDecodeParms());
    assertNull(actualCreateStreamResult.getFileDecodeParams());
    COSStream cOSObject = actualCreateStreamResult.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualCreateStreamResult.getMetadata());
    assertNull(actualCreateStreamResult.getExtends());
    assertNull(actualCreateStreamResult.getFile());
    assertEquals(-1, actualCreateStreamResult.getDecodedStreamLength());
    assertEquals(0, actualCreateStreamResult.getFirstByteOffset());
    assertEquals(0, actualCreateStreamResult.getNumberOfObjects());
    assertEquals(0, actualCreateStreamResult.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualCreateStreamResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualCreateStreamResult.getFilters());
  }

  /**
   * Method under test: {@link PDObjectStream#createStream(PDDocument)}
   */
  @Test
  void testCreateStream2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDObjectStream actualCreateStreamResult = PDObjectStream.createStream(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("ObjStm", actualCreateStreamResult.getType());
    assertNull(actualCreateStreamResult.getDecodeParms());
    assertNull(actualCreateStreamResult.getFileDecodeParams());
    COSStream cOSObject = actualCreateStreamResult.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualCreateStreamResult.getMetadata());
    assertNull(actualCreateStreamResult.getExtends());
    assertNull(actualCreateStreamResult.getFile());
    assertEquals(-1, actualCreateStreamResult.getDecodedStreamLength());
    assertEquals(0, actualCreateStreamResult.getFirstByteOffset());
    assertEquals(0, actualCreateStreamResult.getNumberOfObjects());
    assertEquals(0, actualCreateStreamResult.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualCreateStreamResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualCreateStreamResult.getFilters());
  }

  /**
   * Method under test: {@link PDObjectStream#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("ObjStm", PDObjectStream.createStream(new PDDocument()).getType());
    assertNull((new PDObjectStream(new COSStream())).getType());
  }

  /**
   * Method under test: {@link PDObjectStream#getType()}
   */
  @Test
  void testGetType2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualType = PDObjectStream.createStream(new PDDocument(streamCacheCreateFunction)).getType();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("ObjStm", actualType);
  }

  /**
   * Method under test: {@link PDObjectStream#getNumberOfObjects()}
   */
  @Test
  void testGetNumberOfObjects() {
    // Arrange, Act and Assert
    assertEquals(0, PDObjectStream.createStream(new PDDocument()).getNumberOfObjects());
  }

  /**
   * Method under test: {@link PDObjectStream#getNumberOfObjects()}
   */
  @Test
  void testGetNumberOfObjects2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualNumberOfObjects = PDObjectStream.createStream(new PDDocument(streamCacheCreateFunction))
        .getNumberOfObjects();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualNumberOfObjects);
  }

  /**
   * Method under test: {@link PDObjectStream#setNumberOfObjects(int)}
   */
  @Test
  void testSetNumberOfObjects() {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());

    // Act
    createStreamResult.setNumberOfObjects(1);

    // Assert
    assertEquals(1, createStreamResult.getNumberOfObjects());
    COSStream cOSObject = createStreamResult.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDObjectStream#setNumberOfObjects(int)}
   */
  @Test
  void testSetNumberOfObjects2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument(streamCacheCreateFunction));

    // Act
    createStreamResult.setNumberOfObjects(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, createStreamResult.getNumberOfObjects());
    COSStream cOSObject = createStreamResult.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDObjectStream#getFirstByteOffset()}
   */
  @Test
  void testGetFirstByteOffset() {
    // Arrange, Act and Assert
    assertEquals(0, PDObjectStream.createStream(new PDDocument()).getFirstByteOffset());
  }

  /**
   * Method under test: {@link PDObjectStream#getFirstByteOffset()}
   */
  @Test
  void testGetFirstByteOffset2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualFirstByteOffset = PDObjectStream.createStream(new PDDocument(streamCacheCreateFunction))
        .getFirstByteOffset();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualFirstByteOffset);
  }

  /**
   * Method under test: {@link PDObjectStream#setFirstByteOffset(int)}
   */
  @Test
  void testSetFirstByteOffset() {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());

    // Act
    createStreamResult.setFirstByteOffset(1);

    // Assert
    assertEquals(1, createStreamResult.getFirstByteOffset());
    COSStream cOSObject = createStreamResult.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDObjectStream#setFirstByteOffset(int)}
   */
  @Test
  void testSetFirstByteOffset2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument(streamCacheCreateFunction));

    // Act
    createStreamResult.setFirstByteOffset(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, createStreamResult.getFirstByteOffset());
    COSStream cOSObject = createStreamResult.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDObjectStream#getExtends()}
   */
  @Test
  void testGetExtends() {
    // Arrange, Act and Assert
    assertNull(PDObjectStream.createStream(new PDDocument()).getExtends());
  }

  /**
   * Method under test: {@link PDObjectStream#getExtends()}
   */
  @Test
  void testGetExtends2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDObjectStream actualExtends = PDObjectStream.createStream(new PDDocument(streamCacheCreateFunction)).getExtends();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualExtends);
  }

  /**
   * Method under test: {@link PDObjectStream#setExtends(PDObjectStream)}
   */
  @Test
  void testSetExtends() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument(streamCacheCreateFunction));

    // Act
    createStreamResult.setExtends(PDObjectStream.createStream(new PDDocument()));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDObjectStream resultExtends = createStreamResult.getExtends();
    assertEquals("ObjStm", resultExtends.getType());
    assertNull(resultExtends.getDecodeParms());
    assertNull(resultExtends.getFileDecodeParams());
    assertNull(resultExtends.getMetadata());
    assertNull(resultExtends.getExtends());
    assertNull(resultExtends.getFile());
    assertEquals(-1, resultExtends.getDecodedStreamLength());
    assertEquals(0, resultExtends.getFirstByteOffset());
    assertEquals(0, resultExtends.getNumberOfObjects());
    assertEquals(0, resultExtends.getLength());
    COSStream cOSObject = createStreamResult.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDObjectStream#setExtends(PDObjectStream)}
   */
  @Test
  void testSetExtends2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument(streamCacheCreateFunction));

    // Act
    createStreamResult.setExtends(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(createStreamResult.getExtends());
    COSStream cOSObject = createStreamResult.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDObjectStream#PDObjectStream(COSStream)}
   */
  @Test
  void testNewPDObjectStream() {
    // Arrange
    COSStream str = new COSStream();

    // Act and Assert
    assertSame(str, (new PDObjectStream(str)).getCOSObject());
  }
}
