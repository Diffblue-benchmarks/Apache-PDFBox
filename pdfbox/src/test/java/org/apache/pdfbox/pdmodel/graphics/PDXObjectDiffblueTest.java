package org.apache.pdfbox.pdmodel.graphics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;

class PDXObjectDiffblueTest {
  /**
   * Method under test: {@link PDXObject#createXObject(COSBase, PDResources)}
   */
  @Test
  void testCreateXObject() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDXObject.createXObject(COSBoolean.FALSE, new PDResources()));
    assertNull(PDXObject.createXObject(null, new PDResources()));
  }

  /**
   * Method under test: {@link PDXObject#createXObject(COSBase, PDResources)}
   */
  @Test
  void testCreateXObject2() throws IOException {
    // Arrange
    COSStream base = new COSStream();

    // Act and Assert
    assertThrows(IOException.class, () -> PDXObject.createXObject(base, new PDResources()));
  }

  /**
   * Method under test: {@link PDXObject#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange
    COSStream stream = new COSStream();

    // Act and Assert
    assertSame(stream, (new PDXObject(stream, COSName.A)).getCOSObject());
  }

  /**
   * Method under test: {@link PDXObject#getStream()}
   */
  @Test
  void testGetStream() throws IOException {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDStream actualStream = (new PDXObject(stream, COSName.A)).getStream();

    // Assert
    assertNull(actualStream.getDecodeParms());
    assertNull(actualStream.getFileDecodeParams());
    assertNull(actualStream.getMetadata());
    assertNull(actualStream.getFile());
    assertEquals(-1, actualStream.getDecodedStreamLength());
    assertEquals(0, actualStream.getLength());
    assertTrue(actualStream.getFileFilters().isEmpty());
    assertSame(stream, actualStream.getCOSObject());
  }

  /**
   * Method under test: {@link PDXObject#PDXObject(COSStream, COSName)}
   */
  @Test
  void testNewPDXObject() throws IOException {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDXObject actualPdxObject = new PDXObject(stream, COSName.A);

    // Assert
    PDStream stream2 = actualPdxObject.getStream();
    assertNull(stream2.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream2.getMetadata());
    assertNull(stream2.getFile());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(0, stream2.getLength());
    assertEquals(3, stream.size());
    List<String> fileFilters = stream2.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, actualPdxObject.getCOSObject());
    assertSame(fileFilters, stream2.getFilters());
  }

  /**
   * Method under test: {@link PDXObject#PDXObject(PDDocument, COSName)}
   */
  @Test
  void testNewPDXObject2() throws IOException {
    // Arrange and Act
    PDXObject actualPdxObject = new PDXObject(new PDDocument(), COSName.A);

    // Assert
    PDStream stream = actualPdxObject.getStream();
    assertNull(stream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    COSStream cOSObject = actualPdxObject.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(stream.getMetadata());
    assertNull(stream.getFile());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(0, stream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = stream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, stream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
  }

  /**
   * Method under test: {@link PDXObject#PDXObject(PDDocument, COSName)}
   */
  @Test
  void testNewPDXObject3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDXObject actualPdxObject = new PDXObject(new PDDocument(streamCacheCreateFunction), COSName.A);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDStream stream = actualPdxObject.getStream();
    assertNull(stream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    COSStream cOSObject = actualPdxObject.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(stream.getMetadata());
    assertNull(stream.getFile());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(0, stream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = stream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, stream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
  }

  /**
   * Method under test: {@link PDXObject#PDXObject(PDStream, COSName)}
   */
  @Test
  void testNewPDXObject4() {
    // Arrange
    PDStream stream = new PDStream(new COSDocument());

    // Act
    PDXObject actualPdxObject = new PDXObject(stream, COSName.A);

    // Assert
    COSStream cOSObject = actualPdxObject.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(stream, actualPdxObject.getStream());
  }

  /**
   * Method under test: {@link PDXObject#PDXObject(PDStream, COSName)}
   */
  @Test
  void testNewPDXObject5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    PDXObject actualPdxObject = new PDXObject(stream, COSName.AA);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = actualPdxObject.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(stream, actualPdxObject.getStream());
  }
}
