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
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.filter.DecodeOptions;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDStreamDiffblueTest {
  /**
   * Method under test: {@link PDStream#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSStream actualCOSObject = (new PDStream(new COSDocument())).getCOSObject();

    // Assert
    assertNull(actualCOSObject.getFilters());
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0L, actualCOSObject.getLength());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.hasData());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSStream actualCOSObject = (new PDStream(new COSDocument(streamCacheCreateFunction))).getCOSObject();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCOSObject.getFilters());
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0L, actualCOSObject.getLength());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.hasData());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#createOutputStream()}
   */
  @Test
  void testCreateOutputStream() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.createOutputStream();

    // Assert
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Method under test: {@link PDStream#createOutputStream()}
   */
  @Test
  void testCreateOutputStream2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.createOutputStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Method under test: {@link PDStream#createOutputStream()}
   */
  @Test
  void testCreateOutputStream3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.createOutputStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Method under test: {@link PDStream#createOutputStream()}
   */
  @Test
  void testCreateOutputStream4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    pdStream.setFilters(new ArrayList<>());

    // Act
    pdStream.createOutputStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Method under test: {@link PDStream#createOutputStream()}
   */
  @Test
  void testCreateOutputStream5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(4096L)));
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.createOutputStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Method under test: {@link PDStream#createOutputStream(COSName)}
   */
  @Test
  void testCreateOutputStream6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.createOutputStream(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Method under test: {@link PDStream#createOutputStream(COSName)}
   */
  @Test
  void testCreateOutputStream7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    pdStream.setFilters(new ArrayList<>());

    // Act
    pdStream.createOutputStream(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Method under test: {@link PDStream#createInputStream()}
   */
  @Test
  void testCreateInputStream() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, (new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).createInputStream()
        .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDStream#createInputStream()}
   */
  @Test
  void testCreateInputStream2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    PDMetadata pdMetadata = new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    pdMetadata.setFilters(new ArrayList<>());

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdMetadata.createInputStream().read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDStream#createInputStream(List)}
   */
  @Test
  void testCreateInputStream3() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDMetadata pdMetadata = new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdMetadata.createInputStream(new ArrayList<>()).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDStream#createInputStream(List)}
   */
  @Test
  void testCreateInputStream4() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    PDMetadata pdMetadata = new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    pdMetadata.setFilters(new ArrayList<>());

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdMetadata.createInputStream(new ArrayList<>()).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDStream#createInputStream(DecodeOptions)}
   */
  @Test
  void testCreateInputStream5() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        (new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .createInputStream(DecodeOptions.DEFAULT)
            .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDStream#createInputStream(DecodeOptions)}
   */
  @Test
  void testCreateInputStream6() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    PDMetadata pdMetadata = new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    pdMetadata.setFilters(new ArrayList<>());

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdMetadata.createInputStream(DecodeOptions.DEFAULT).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDStream#getLength()}
   */
  @Test
  void testGetLength() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDStream(new COSDocument())).getLength());
  }

  /**
   * Method under test: {@link PDStream#getLength()}
   */
  @Test
  void testGetLength2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualLength = (new PDStream(new COSDocument(streamCacheCreateFunction))).getLength();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualLength);
  }

  /**
   * Method under test: {@link PDStream#getFilters()}
   */
  @Test
  void testGetFilters() {
    // Arrange, Act and Assert
    assertTrue((new PDStream(new COSDocument())).getFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#getFilters()}
   */
  @Test
  void testGetFilters2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<COSName> actualFilters = (new PDStream(new COSDocument(streamCacheCreateFunction))).getFilters();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualFilters.isEmpty());
  }

  /**
   * Method under test: {@link PDStream#getFilters()}
   */
  @Test
  void testGetFilters3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    pdStream.setFilters(new ArrayList<>());

    // Act
    List<COSName> actualFilters = pdStream.getFilters();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualFilters.isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFilters(List)}
   */
  @Test
  void testSetFilters() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFilters(new ArrayList<>());

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSArray);
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((COSArray) filters).toList().isEmpty());
    assertTrue(pdStream.getFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFilters(List)}
   */
  @Test
  void testSetFilters2() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    // Act
    pdStream.setFilters(filters);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    COSBase filters2 = cOSObject.getFilters();
    assertTrue(filters2 instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) filters2).toList();
    assertEquals(1, toListResult.size());
    assertNull(toListResult.get(0));
    List<COSName> filters3 = pdStream.getFilters();
    assertEquals(1, filters3.size());
    assertNull(filters3.get(0));
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStream#setFilters(List)}
   */
  @Test
  void testSetFilters3() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    // Act
    pdStream.setFilters(filters);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    COSBase filters2 = cOSObject.getFilters();
    assertTrue(filters2 instanceof COSArray);
    assertEquals(1, ((COSArray) filters2).toList().size());
    assertEquals(1, pdStream.getFilters().size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStream#setFilters(List)}
   */
  @Test
  void testSetFilters4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.setFilters(new ArrayList<>());

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSArray);
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((COSArray) filters).toList().isEmpty());
    assertTrue(pdStream.getFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFilters(List)}
   */
  @Test
  void testSetFilters5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);
    filters.add(COSName.A);

    // Act
    pdStream.setFilters(filters);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    COSBase filters2 = cOSObject.getFilters();
    assertTrue(filters2 instanceof COSArray);
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(filters, ((COSArray) filters2).toList());
    assertEquals(filters, pdStream.getFilters());
  }

  /**
   * Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  void testGetDecodeParms() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDStream(new COSDocument())).getDecodeParms());
  }

  /**
   * Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  void testGetDecodeParms2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<Object> actualDecodeParms = (new PDStream(new COSDocument(streamCacheCreateFunction))).getDecodeParms();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDecodeParms);
  }

  /**
   * Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  void testGetDecodeParms3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    pdStream.setDecodeParms(new ArrayList<>());

    // Act
    List<Object> actualDecodeParms = pdStream.getDecodeParms();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualDecodeParms.isEmpty());
  }

  /**
   * Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  void testGetDecodeParms4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");

    PDStream pdStream = new PDStream(document);
    pdStream.setDecodeParms(decodeParams);

    // Act
    List<Object> actualDecodeParms = pdStream.getDecodeParms();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualDecodeParms.isEmpty());
  }

  /**
   * Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  void testGetFileDecodeParams() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDStream(new COSDocument())).getFileDecodeParams());
  }

  /**
   * Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  void testGetFileDecodeParams2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<Object> actualFileDecodeParams = (new PDStream(new COSDocument(streamCacheCreateFunction)))
        .getFileDecodeParams();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFileDecodeParams);
  }

  /**
   * Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  void testGetFileDecodeParams3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    pdStream.setFileDecodeParams(new ArrayList<>());

    // Act
    List<Object> actualFileDecodeParams = pdStream.getFileDecodeParams();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualFileDecodeParams.isEmpty());
  }

  /**
   * Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  void testGetFileDecodeParams4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");

    PDStream pdStream = new PDStream(document);
    pdStream.setFileDecodeParams(decodeParams);

    // Act
    List<Object> actualFileDecodeParams = pdStream.getFileDecodeParams();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualFileDecodeParams.isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  void testSetDecodeParms() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setDecodeParms(new ArrayList<>());

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  void testSetDecodeParms2() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<?> decodeParams = new ArrayList<>();
    decodeParams.add(null);

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  void testSetDecodeParms3() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setDecodeParms(null);

    // Assert
    assertNull(pdStream.getDecodeParms());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  void testSetDecodeParms4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.setDecodeParms(new ArrayList<>());

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  void testSetDecodeParms5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add("42");

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  void testSetDecodeParms6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add(2);

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  void testSetDecodeParms7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add(new COSDictionary());

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<Object> decodeParms = pdStream.getDecodeParms();
    assertEquals(1, decodeParms.size());
    Object getResult = decodeParms.get(0);
    assertTrue(getResult instanceof Map);
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileFilters().isEmpty());
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  void testSetDecodeParms8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add(new COSArray());

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  void testSetDecodeParms9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  void testSetDecodeParms10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(10.0d);
    decodeParams.add(2);

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  void testSetDecodeParms11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(10.0f);
    decodeParams.add(2);

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#getFile()}
   */
  @Test
  void testGetFile() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDStream(new COSDocument())).getFile());
  }

  /**
   * Method under test: {@link PDStream#getFile()}
   */
  @Test
  void testGetFile2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFileSpecification actualFile = (new PDStream(new COSDocument(streamCacheCreateFunction))).getFile();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFile);
  }

  /**
   * Method under test: {@link PDStream#getFile()}
   */
  @Test
  void testGetFile3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    pdStream.setFile(new PDComplexFileSpecification());

    // Act
    PDFileSpecification actualFile = pdStream.getFile();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualFile instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) actualFile).getFileDescription());
    assertNull(((PDComplexFileSpecification) actualFile).getFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getFileUnix());
    assertNull(((PDComplexFileSpecification) actualFile).getFilename());
    assertNull(actualFile.getFile());
    COSBase cOSObject = actualFile.getCOSObject();
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnix());
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDComplexFileSpecification) actualFile).isVolatile());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#getFile()}
   */
  @Test
  void testGetFile4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    pdStream.setFile(new PDSimpleFileSpecification());

    // Act
    PDFileSpecification actualFile = pdStream.getFile();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase cOSObject = actualFile.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertTrue(actualFile instanceof PDSimpleFileSpecification);
    assertEquals("", ((COSString) cOSObject).getASCII());
    assertEquals("", ((COSString) cOSObject).getString());
    assertEquals("", ((COSString) cOSObject).toHexString());
    assertEquals("", actualFile.getFile());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((COSString) cOSObject).getBytes().length);
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
  }

  /**
   * Method under test: {@link PDStream#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdStream.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link PDStream#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.setFile(new PDComplexFileSpecification());

    // Assert
    verify(streamCacheCreateFunction).create();
    PDFileSpecification file = pdStream.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link PDStream#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.setFile(new PDSimpleFileSpecification());

    // Assert
    verify(streamCacheCreateFunction).create();
    PDFileSpecification file = pdStream.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStream#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.setFile(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(pdStream.getFile());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStream#getFileFilters()}
   */
  @Test
  void testGetFileFilters() {
    // Arrange, Act and Assert
    assertTrue((new PDStream(new COSDocument())).getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#getFileFilters()}
   */
  @Test
  void testGetFileFilters2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<String> actualFileFilters = (new PDStream(new COSDocument(streamCacheCreateFunction))).getFileFilters();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualFileFilters.isEmpty());
  }

  /**
   * Method under test: {@link PDStream#getFileFilters()}
   */
  @Test
  void testGetFileFilters3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    pdStream.setFileFilters(new ArrayList<>());

    // Act
    List<String> actualFileFilters = pdStream.getFileFilters();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualFileFilters.isEmpty());
  }

  /**
   * Method under test: {@link PDStream#getFileFilters()}
   */
  @Test
  void testGetFileFilters4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<String> filters = new ArrayList<>();
    filters.add("foo");

    PDStream pdStream = new PDStream(document);
    pdStream.setFileFilters(filters);

    // Act
    List<String> actualFileFilters = pdStream.getFileFilters();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualFileFilters.size());
    assertEquals("foo", actualFileFilters.get(0));
  }

  /**
   * Method under test: {@link PDStream#getFileFilters()}
   */
  @Test
  void testGetFileFilters5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<String> filters = new ArrayList<>();
    filters.add("42");
    filters.add("foo");

    PDStream pdStream = new PDStream(document);
    pdStream.setFileFilters(filters);

    // Act
    List<String> actualFileFilters = pdStream.getFileFilters();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(filters, actualFileFilters);
  }

  /**
   * Method under test: {@link PDStream#setFileFilters(List)}
   */
  @Test
  void testSetFileFilters() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFileFilters(new ArrayList<>());

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileFilters(List)}
   */
  @Test
  void testSetFileFilters2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.setFileFilters(new ArrayList<>());

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileFilters().isEmpty());
    assertTrue(pdStream.getFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileFilters(List)}
   */
  @Test
  void testSetFileFilters3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<String> filters = new ArrayList<>();
    filters.add("foo");

    // Act
    pdStream.setFileFilters(filters);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<String> fileFilters = pdStream.getFileFilters();
    assertEquals(1, fileFilters.size());
    assertEquals("foo", fileFilters.get(0));
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileFilters(List)}
   */
  @Test
  void testSetFileFilters4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<String> filters = new ArrayList<>();
    filters.add("42");
    filters.add("foo");

    // Act
    pdStream.setFileFilters(filters);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFilters().isEmpty());
    assertEquals(filters, pdStream.getFileFilters());
  }

  /**
   * Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  void testSetFileDecodeParams() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFileDecodeParams(new ArrayList<>());

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  void testSetFileDecodeParams2() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<?> decodeParams = new ArrayList<>();
    decodeParams.add(null);

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  void testSetFileDecodeParams3() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFileDecodeParams(null);

    // Assert
    assertNull(pdStream.getFileDecodeParams());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  void testSetFileDecodeParams4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.setFileDecodeParams(new ArrayList<>());

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  void testSetFileDecodeParams5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add("42");

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  void testSetFileDecodeParams6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add(2);

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  void testSetFileDecodeParams7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add(new COSDictionary());

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<Object> fileDecodeParams = pdStream.getFileDecodeParams();
    assertEquals(1, fileDecodeParams.size());
    Object getResult = fileDecodeParams.get(0);
    assertTrue(getResult instanceof Map);
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileFilters().isEmpty());
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  void testSetFileDecodeParams8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add(new COSArray());

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  void testSetFileDecodeParams9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  void testSetFileDecodeParams10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(10.0d);
    decodeParams.add(2);

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  void testSetFileDecodeParams11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(10.0f);
    decodeParams.add(2);

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDStream#toByteArray()}
   */
  @Test
  void testToByteArray() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act
    byte[] actualToByteArrayResult = (new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
        .toByteArray();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToByteArrayResult);
  }

  /**
   * Method under test: {@link PDStream#toByteArray()}
   */
  @Test
  void testToByteArray2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    PDMetadata pdMetadata = new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    pdMetadata.setFilters(new ArrayList<>());

    // Act
    byte[] actualToByteArrayResult = pdMetadata.toByteArray();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToByteArrayResult);
  }

  /**
   * Method under test: {@link PDStream#getMetadata()}
   */
  @Test
  void testGetMetadata() {
    // Arrange, Act and Assert
    assertNull((new PDStream(new COSDocument())).getMetadata());
  }

  /**
   * Method under test: {@link PDStream#getMetadata()}
   */
  @Test
  void testGetMetadata2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDMetadata actualMetadata = (new PDStream(new COSDocument(streamCacheCreateFunction))).getMetadata();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualMetadata);
  }

  /**
   * Method under test: {@link PDStream#getMetadata()}
   */
  @Test
  void testGetMetadata3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    COSStream str = new COSStream();
    pdStream.setMetadata(new PDMetadata(str));

    // Act
    PDMetadata actualMetadata = pdStream.getMetadata();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualMetadata.getDecodeParms());
    assertNull(actualMetadata.getFileDecodeParams());
    assertNull(actualMetadata.getFile());
    assertEquals(-1, actualMetadata.getDecodedStreamLength());
    assertEquals(0, actualMetadata.getLength());
    List<String> fileFilters = actualMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualMetadata.getCOSObject());
    assertSame(fileFilters, actualMetadata.getFilters());
  }

  /**
   * Method under test: {@link PDStream#getMetadata()}
   */
  @Test
  void testGetMetadata4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));
    PDMetadata meta = new PDMetadata(str);

    PDStream pdStream = new PDStream(document);
    pdStream.setMetadata(meta);

    // Act
    PDMetadata actualMetadata = pdStream.getMetadata();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualMetadata.getDecodeParms());
    assertNull(actualMetadata.getFileDecodeParams());
    assertNull(actualMetadata.getFile());
    assertEquals(-1, actualMetadata.getDecodedStreamLength());
    assertEquals(0, actualMetadata.getLength());
    List<String> fileFilters = actualMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualMetadata.getCOSObject());
    assertSame(fileFilters, actualMetadata.getFilters());
  }

  /**
   * Method under test: {@link PDStream#setMetadata(PDMetadata)}
   */
  @Test
  void testSetMetadata() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());
    COSStream str = new COSStream();

    // Act
    pdStream.setMetadata(new PDMetadata(str));

    // Assert
    PDMetadata metadata = pdStream.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Method under test: {@link PDStream#setMetadata(PDMetadata)}
   */
  @Test
  void testSetMetadata2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    COSStream str = new COSStream();

    // Act
    pdStream.setMetadata(new PDMetadata(str));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDMetadata metadata = pdStream.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Method under test: {@link PDStream#setMetadata(PDMetadata)}
   */
  @Test
  void testSetMetadata3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.setMetadata(new PDMetadata((COSStream) null));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(pdStream.getMetadata());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStream#setMetadata(PDMetadata)}
   */
  @Test
  void testSetMetadata4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.setMetadata(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(pdStream.getMetadata());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStream#setMetadata(PDMetadata)}
   */
  @Test
  void testSetMetadata5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    COSStream str = new COSStream();
    str.setDirect(true);

    // Act
    pdStream.setMetadata(new PDMetadata(str));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDMetadata metadata = pdStream.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Method under test: {@link PDStream#setMetadata(PDMetadata)}
   */
  @Test
  void testSetMetadata6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));

    // Act
    pdStream.setMetadata(new PDMetadata(str));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDMetadata metadata = pdStream.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Method under test: {@link PDStream#getDecodedStreamLength()}
   */
  @Test
  void testGetDecodedStreamLength() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDStream(new COSDocument())).getDecodedStreamLength());
  }

  /**
   * Method under test: {@link PDStream#getDecodedStreamLength()}
   */
  @Test
  void testGetDecodedStreamLength2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualDecodedStreamLength = (new PDStream(new COSDocument(streamCacheCreateFunction))).getDecodedStreamLength();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-1, actualDecodedStreamLength);
  }

  /**
   * Method under test: {@link PDStream#getDecodedStreamLength()}
   */
  @Test
  void testGetDecodedStreamLength3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    pdStream.setDecodedStreamLength(3);

    // Act
    int actualDecodedStreamLength = pdStream.getDecodedStreamLength();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(3, actualDecodedStreamLength);
  }

  /**
   * Method under test: {@link PDStream#setDecodedStreamLength(int)}
   */
  @Test
  void testSetDecodedStreamLength() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setDecodedStreamLength(3);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(3, pdStream.getDecodedStreamLength());
  }

  /**
   * Method under test: {@link PDStream#setDecodedStreamLength(int)}
   */
  @Test
  void testSetDecodedStreamLength2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.setDecodedStreamLength(3);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(3, pdStream.getDecodedStreamLength());
  }

  /**
   * Method under test: {@link PDStream#setDecodedStreamLength(int)}
   */
  @Test
  void testSetDecodedStreamLength3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream pdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Act
    pdStream.setDecodedStreamLength(Integer.MIN_VALUE);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdStream.getDecodedStreamLength());
  }

  /**
   * Method under test: {@link PDStream#PDStream(COSStream)}
   */
  @Test
  void testNewPDStream() {
    // Arrange
    COSStream str = new COSStream();

    // Act and Assert
    assertSame(str, (new PDStream(str)).getCOSObject());
  }

  /**
   * Method under test: {@link PDStream#PDStream(COSDocument)}
   */
  @Test
  void testNewPDStream2() throws IOException {
    // Arrange and Act
    PDStream actualPdStream = new PDStream(new COSDocument());

    // Assert
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(0, actualPdStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualPdStream.getFilters());
  }

  /**
   * Method under test: {@link PDStream#PDStream(COSDocument)}
   */
  @Test
  void testNewPDStream3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDStream actualPdStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(0, actualPdStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualPdStream.getFilters());
  }

  /**
   * Method under test: {@link PDStream#PDStream(PDDocument)}
   */
  @Test
  void testNewPDStream4() throws IOException {
    // Arrange and Act
    PDStream actualPdStream = new PDStream(new PDDocument());

    // Assert
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(0, actualPdStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualPdStream.getFilters());
  }

  /**
   * Method under test: {@link PDStream#PDStream(PDDocument)}
   */
  @Test
  void testNewPDStream5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDStream actualPdStream = new PDStream(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(0, actualPdStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualPdStream.getFilters());
  }

  /**
   * Method under test: {@link PDStream#PDStream(PDDocument, InputStream)}
   */
  @Test
  void testNewPDStream6() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDStream actualPdStream = new PDStream(doc, input);

    // Assert
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdStream.getFilters());
  }

  /**
   * Method under test: {@link PDStream#PDStream(PDDocument, InputStream)}
   */
  @Test
  void testNewPDStream7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDStream actualPdStream = new PDStream(doc, input);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdStream.getFilters());
  }

  /**
   * Method under test: {@link PDStream#PDStream(PDDocument, InputStream)}
   */
  @Test
  void testNewPDStream8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDStream actualPdStream = new PDStream(doc, input);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdStream.getFilters());
  }

  /**
   * Method under test: {@link PDStream#PDStream(PDDocument, InputStream)}
   */
  @Test
  void testNewPDStream9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    PDStream actualPdStream = new PDStream(doc, input);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(0, actualPdStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdStream.getFilters());
  }

  /**
   * Method under test: {@link PDStream#PDStream(PDDocument, InputStream)}
   */
  @Test
  void testNewPDStream10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException("foo"));
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    doNothing().when(input).close();

    // Act
    PDStream actualPdStream = new PDStream(doc, input);

    // Assert
    verify(input).close();
    verify(input).transferTo(isA(OutputStream.class));
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(0, actualPdStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdStream.getFilters());
  }

  /**
   * Method under test:
   * {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}
   */
  @Test
  void testNewPDStream11() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    COSArray filters = new COSArray();

    // Act
    PDStream actualPdStream = new PDStream(doc, input, filters);

    // Assert
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdStream.getFileFilters().isEmpty());
    assertTrue(actualPdStream.getFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(filters, cOSObject.getFilters());
  }

  /**
   * Method under test:
   * {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}
   */
  @Test
  void testNewPDStream12() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    COSArray filters = new COSArray();

    // Act
    PDStream actualPdStream = new PDStream(doc, input, filters);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdStream.getFileFilters().isEmpty());
    assertTrue(actualPdStream.getFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(filters, cOSObject.getFilters());
  }

  /**
   * Method under test:
   * {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}
   */
  @Test
  void testNewPDStream13() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    COSArray filters = new COSArray();

    // Act
    PDStream actualPdStream = new PDStream(doc, input, filters);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdStream.getFileFilters().isEmpty());
    assertTrue(actualPdStream.getFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(filters, cOSObject.getFilters());
  }

  /**
   * Method under test:
   * {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}
   */
  @Test
  void testNewPDStream14() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});
    COSArray filters = new COSArray();

    // Act
    PDStream actualPdStream = new PDStream(doc, input, filters);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(0, actualPdStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdStream.getFileFilters().isEmpty());
    assertTrue(actualPdStream.getFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(filters, cOSObject.getFilters());
  }

  /**
   * Method under test:
   * {@link PDStream#PDStream(PDDocument, InputStream, COSName)}
   */
  @Test
  void testNewPDStream15() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDStream actualPdStream = new PDStream(doc, input, (COSName) null);

    // Assert
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    COSStream cOSObject = actualPdStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdStream.getFilters());
  }
}
