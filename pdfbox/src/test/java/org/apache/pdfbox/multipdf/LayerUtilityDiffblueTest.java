package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.SequenceRandomAccessRead;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.junit.jupiter.api.Test;

class LayerUtilityDiffblueTest {
  /**
   * Method under test: {@link LayerUtility#getDocument()}
   */
  @Test
  void testGetDocument() {
    // Arrange
    PDDocument targetDoc = new PDDocument();

    // Act and Assert
    assertSame(targetDoc, (new LayerUtility(targetDoc)).getDocument());
  }

  /**
   * Method under test: {@link LayerUtility#wrapInSaveRestore(PDPage)}
   */
  @Test
  void testWrapInSaveRestore() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    layerUtility.wrapInSaveRestore(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead contentsForRandomAccess = page.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof SequenceRandomAccessRead);
    RandomAccessRead contentsForStreamParsing = page.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof SequenceRandomAccessRead);
    Iterator<PDStream> contentStreams = page.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertNull(nextResult.getDecodeParms());
    PDStream nextResult2 = contentStreams.next();
    assertNull(nextResult2.getDecodeParms());
    PDStream nextResult3 = contentStreams.next();
    assertNull(nextResult3.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    assertNull(nextResult2.getFileDecodeParams());
    assertNull(nextResult3.getFileDecodeParams());
    COSStream cOSObject = nextResult.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSStream cOSObject2 = nextResult2.getCOSObject();
    assertNull(cOSObject2.getFilters());
    COSStream cOSObject3 = nextResult3.getCOSObject();
    assertNull(cOSObject3.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult2.getMetadata());
    assertNull(nextResult3.getMetadata());
    assertNull(nextResult.getFile());
    assertNull(nextResult2.getFile());
    assertNull(nextResult3.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(-1, nextResult2.getDecodedStreamLength());
    assertEquals(-1, nextResult3.getDecodedStreamLength());
    assertEquals(0, nextResult2.getLength());
    assertEquals(0L, cOSObject2.getLength());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, cOSObject2.size());
    assertEquals(1, cOSObject3.size());
    assertEquals(2, nextResult.getLength());
    assertEquals(2, nextResult3.getLength());
    assertEquals(2L, cOSObject.getLength());
    assertEquals(2L, cOSObject3.getLength());
    byte[] byteArray = new byte[6];
    assertEquals(6, page.getContents().read(byteArray));
    assertEquals(6, contentsForRandomAccess.available());
    assertEquals(6, contentsForStreamParsing.available());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(contentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject2.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForStreamParsing.isClosed());
    List<String> fileFilters = nextResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(cOSObject3.hasData());
    assertTrue(page.hasContents());
    assertSame(fileFilters, nextResult2.getFileFilters());
    assertSame(fileFilters, nextResult3.getFileFilters());
    assertSame(fileFilters, nextResult.getFilters());
    assertSame(fileFilters, nextResult2.getFilters());
    assertSame(fileFilters, nextResult3.getFilters());
    assertArrayEquals("q\n\nQ\n\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link LayerUtility#wrapInSaveRestore(PDPage)}
   */
  @Test
  void testWrapInSaveRestore2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    // Act
    layerUtility.wrapInSaveRestore(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead contentsForRandomAccess = page.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof SequenceRandomAccessRead);
    RandomAccessRead contentsForStreamParsing = page.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof SequenceRandomAccessRead);
    Iterator<PDStream> contentStreams = page.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertNull(nextResult.getDecodeParms());
    PDStream nextResult2 = contentStreams.next();
    assertNull(nextResult2.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    assertNull(nextResult2.getFileDecodeParams());
    COSStream cOSObject = nextResult.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSStream cOSObject2 = nextResult2.getCOSObject();
    assertNull(cOSObject2.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult2.getMetadata());
    assertNull(nextResult.getFile());
    assertNull(nextResult2.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(-1, nextResult2.getDecodedStreamLength());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, cOSObject2.size());
    assertEquals(2, nextResult.getLength());
    assertEquals(2, nextResult2.getLength());
    assertEquals(2L, cOSObject.getLength());
    assertEquals(2L, cOSObject2.getLength());
    byte[] byteArray = new byte[6];
    assertEquals(6, page.getContents().read(byteArray));
    assertEquals(6, contentsForRandomAccess.available());
    assertEquals(6, contentsForStreamParsing.available());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(contentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForStreamParsing.isClosed());
    List<String> fileFilters = nextResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(cOSObject2.hasData());
    assertTrue(page.hasContents());
    assertSame(fileFilters, nextResult2.getFileFilters());
    assertSame(fileFilters, nextResult.getFilters());
    assertSame(fileFilters, nextResult2.getFilters());
    assertArrayEquals("q\n\nQ\n\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}
   */
  @Test
  void testAppendFormAsLayer() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));
    PDPage targetPage = new PDPage();
    PDFormXObject form = new PDFormXObject(new COSStream());
    layerUtility.appendFormAsLayer(targetPage, form, new AffineTransform(), "Layer Name");
    PDPage targetPage2 = new PDPage();
    PDFormXObject form2 = new PDFormXObject(new COSStream());
    layerUtility.appendFormAsLayer(targetPage2, form2, new AffineTransform(), "Top");
    PDPage targetPage3 = new PDPage();
    PDFormXObject form3 = new PDFormXObject(new COSStream());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> layerUtility.appendFormAsLayer(targetPage3, form3, new AffineTransform(), "Layer Name"));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link LayerUtility#LayerUtility(PDDocument)}
   */
  @Test
  void testNewLayerUtility() {
    // Arrange
    PDDocument targetDoc = new PDDocument();

    // Act and Assert
    assertSame(targetDoc, (new LayerUtility(targetDoc)).getDocument());
  }

  /**
   * Method under test: {@link LayerUtility#LayerUtility(PDDocument)}
   */
  @Test
  void testNewLayerUtility2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);

    // Act
    LayerUtility actualLayerUtility = new LayerUtility(targetDoc);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(targetDoc, actualLayerUtility.getDocument());
  }
}
