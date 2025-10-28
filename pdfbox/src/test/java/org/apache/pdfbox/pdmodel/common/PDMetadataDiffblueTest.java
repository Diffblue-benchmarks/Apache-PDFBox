package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDMetadataDiffblueTest {
  /**
   * Method under test: {@link PDMetadata#exportXMPMetadata()}
   */
  @Test
  void testExportXMPMetadata() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, (new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).exportXMPMetadata()
        .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDMetadata#exportXMPMetadata()}
   */
  @Test
  void testExportXMPMetadata2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    // Act
    InputStream actualExportXMPMetadataResult = (new PDMetadata(doc,
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).exportXMPMetadata();

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] byteArray = new byte[8];
    assertEquals(8, actualExportXMPMetadataResult.read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDMetadata#exportXMPMetadata()}
   */
  @Test
  void testExportXMPMetadata3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    PDMetadata pdMetadata = new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    pdMetadata.setFilters(new ArrayList<>());

    // Act
    InputStream actualExportXMPMetadataResult = pdMetadata.exportXMPMetadata();

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] byteArray = new byte[8];
    assertEquals(8, actualExportXMPMetadataResult.read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDMetadata#importXMPMetadata(byte[])}
   */
  @Test
  void testImportXMPMetadata() throws IOException {
    // Arrange
    COSStream str = new COSStream();
    PDMetadata pdMetadata = new PDMetadata(str);

    // Act
    pdMetadata.importXMPMetadata("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, pdMetadata.getLength());
    assertSame(str, pdMetadata.getCOSObject());
  }

  /**
   * Method under test: {@link PDMetadata#importXMPMetadata(byte[])}
   */
  @Test
  void testImportXMPMetadata2() throws IOException {
    // Arrange
    COSStream str = new COSStream();

    PDMetadata pdMetadata = new PDMetadata(str);
    pdMetadata.setFilters(new ArrayList<>());

    // Act
    pdMetadata.importXMPMetadata("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, pdMetadata.getLength());
    assertSame(str, pdMetadata.getCOSObject());
  }

  /**
   * Method under test: {@link PDMetadata#importXMPMetadata(byte[])}
   */
  @Test
  void testImportXMPMetadata3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDMetadata pdMetadata = new PDMetadata(doc, new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Act
    pdMetadata.importXMPMetadata("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDMetadata#PDMetadata(COSStream)}
   */
  @Test
  void testNewPDMetadata() {
    // Arrange
    COSStream str = new COSStream();

    // Act and Assert
    assertSame(str, (new PDMetadata(str)).getCOSObject());
  }

  /**
   * Method under test: {@link PDMetadata#PDMetadata(PDDocument)}
   */
  @Test
  void testNewPDMetadata2() throws IOException {
    // Arrange and Act
    PDMetadata actualPdMetadata = new PDMetadata(new PDDocument());

    // Assert
    assertNull(actualPdMetadata.getDecodeParms());
    assertNull(actualPdMetadata.getFileDecodeParams());
    COSStream cOSObject = actualPdMetadata.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdMetadata.getMetadata());
    assertNull(actualPdMetadata.getFile());
    assertEquals(-1, actualPdMetadata.getDecodedStreamLength());
    assertEquals(0, actualPdMetadata.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualPdMetadata.getFilters());
  }

  /**
   * Method under test: {@link PDMetadata#PDMetadata(PDDocument)}
   */
  @Test
  void testNewPDMetadata3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDMetadata actualPdMetadata = new PDMetadata(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdMetadata.getDecodeParms());
    assertNull(actualPdMetadata.getFileDecodeParams());
    COSStream cOSObject = actualPdMetadata.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdMetadata.getMetadata());
    assertNull(actualPdMetadata.getFile());
    assertEquals(-1, actualPdMetadata.getDecodedStreamLength());
    assertEquals(0, actualPdMetadata.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualPdMetadata.getFilters());
  }

  /**
   * Method under test: {@link PDMetadata#PDMetadata(PDDocument, InputStream)}
   */
  @Test
  void testNewPDMetadata4() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream str = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDMetadata actualPdMetadata = new PDMetadata(doc, str);

    // Assert
    assertNull(actualPdMetadata.getDecodeParms());
    assertNull(actualPdMetadata.getFileDecodeParams());
    COSStream cOSObject = actualPdMetadata.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdMetadata.getMetadata());
    assertNull(actualPdMetadata.getFile());
    assertEquals(-1, str.read(new byte[]{}));
    assertEquals(-1, actualPdMetadata.getDecodedStreamLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(8, actualPdMetadata.getLength());
    assertEquals(8L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdMetadata.getFilters());
  }

  /**
   * Method under test: {@link PDMetadata#PDMetadata(PDDocument, InputStream)}
   */
  @Test
  void testNewPDMetadata5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream str = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDMetadata actualPdMetadata = new PDMetadata(doc, str);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdMetadata.getDecodeParms());
    assertNull(actualPdMetadata.getFileDecodeParams());
    COSStream cOSObject = actualPdMetadata.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdMetadata.getMetadata());
    assertNull(actualPdMetadata.getFile());
    assertEquals(-1, str.read(new byte[]{}));
    assertEquals(-1, actualPdMetadata.getDecodedStreamLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(8, actualPdMetadata.getLength());
    assertEquals(8L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdMetadata.getFilters());
  }

  /**
   * Method under test: {@link PDMetadata#PDMetadata(PDDocument, InputStream)}
   */
  @Test
  void testNewPDMetadata6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream str = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDMetadata actualPdMetadata = new PDMetadata(doc, str);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdMetadata.getDecodeParms());
    assertNull(actualPdMetadata.getFileDecodeParams());
    COSStream cOSObject = actualPdMetadata.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdMetadata.getMetadata());
    assertNull(actualPdMetadata.getFile());
    assertEquals(-1, str.read(new byte[]{}));
    assertEquals(-1, actualPdMetadata.getDecodedStreamLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(8, actualPdMetadata.getLength());
    assertEquals(8L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdMetadata.getFilters());
  }

  /**
   * Method under test: {@link PDMetadata#PDMetadata(PDDocument, InputStream)}
   */
  @Test
  void testNewPDMetadata7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException("Metadata"));
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    DataInputStream str = mock(DataInputStream.class);
    when(str.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    doNothing().when(str).close();

    // Act
    PDMetadata actualPdMetadata = new PDMetadata(doc, str);

    // Assert
    verify(str).close();
    verify(str).transferTo(isA(OutputStream.class));
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdMetadata.getDecodeParms());
    assertNull(actualPdMetadata.getFileDecodeParams());
    COSStream cOSObject = actualPdMetadata.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdMetadata.getMetadata());
    assertNull(actualPdMetadata.getFile());
    assertEquals(-1, actualPdMetadata.getDecodedStreamLength());
    assertEquals(0, actualPdMetadata.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdMetadata.getFilters());
  }
}
