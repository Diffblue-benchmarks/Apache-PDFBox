package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.action.PDPageAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.AnnotationFilter;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFreeText;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationInk;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLine;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPolygon;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPolyline;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPopup;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSound;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquare;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDViewportDictionary;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThreadBead;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransition;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDPageDiffblueTest {
  /**
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  void testGetContentStreams() {
    // Arrange, Act and Assert
    assertFalse((new PDPage()).getContentStreams().hasNext());
  }

  /**
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  void testGetContentStreams2() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new PDStream(new COSDocument()));

    // Act
    Iterator<PDStream> actualContentStreams = pdPage.getContentStreams();

    // Assert
    PDStream nextResult = actualContentStreams.next();
    assertNull(nextResult.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    COSStream cOSObject = nextResult.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualContentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = nextResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, nextResult.getFilters());
  }

  /**
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  void testGetContentStreams3() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new ArrayList<>());

    // Act and Assert
    assertFalse(pdPage.getContentStreams().hasNext());
  }

  /**
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  void testGetContentStreams4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    Iterator<PDStream> actualContentStreams = pdPage.getContentStreams();

    // Assert
    verify(streamCacheCreateFunction).create();
    PDStream nextResult = actualContentStreams.next();
    assertNull(nextResult.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    COSStream cOSObject = nextResult.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualContentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = nextResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, nextResult.getFilters());
  }

  /**
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  void testGetContents() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPage()).getContents().read(new byte[]{}));
  }

  /**
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  void testGetContents2() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new PDStream(new COSDocument()));

    // Act and Assert
    byte[] byteArray = new byte[1];
    assertEquals(1, pdPage.getContents().read(byteArray));
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  void testGetContents3() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new ArrayList<>());

    // Act and Assert
    assertEquals(-1, pdPage.getContents().read(new byte[]{}));
  }

  /**
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  void testGetContents4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    InputStream actualContents = pdPage.getContents();

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] byteArray = new byte[1];
    assertEquals(1, actualContents.read(byteArray));
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  void testGetContents5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));
    contents.setFilters(new ArrayList<>());

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    InputStream actualContents = pdPage.getContents();

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] byteArray = new byte[1];
    assertEquals(1, actualContents.read(byteArray));
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  void testGetContents6() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    PDDocument doc = new PDDocument();
    pdPage.setContents(new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    new IOException("Create InputStream called without data being written before to stream.");

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdPage.getContents().read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  void testGetContents7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream contents = new PDStream(document);
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    InputStream actualContents = pdPage.getContents();

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] byteArray = new byte[1];
    assertEquals(1, actualContents.read(byteArray));
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  void testGetContents8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream contents = new PDStream(document);
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    InputStream actualContents = pdPage.getContents();

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] byteArray = new byte[1];
    assertEquals(1, actualContents.read(byteArray));
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  void testGetContentsForStreamParsing() throws IOException {
    // Arrange and Act
    RandomAccessRead actualContentsForStreamParsing = (new PDPage()).getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForStreamParsing.available());
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  void testGetContentsForStreamParsing2() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new PDStream(new COSDocument()));

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertEquals(1, actualContentsForStreamParsing.available());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  void testGetContentsForStreamParsing3() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new ArrayList<>());

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForStreamParsing.available());
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  void testGetContentsForStreamParsing4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertEquals(1, actualContentsForStreamParsing.available());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  void testGetContentsForStreamParsing5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));
    contents.setFilters(new ArrayList<>());

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertEquals(1, actualContentsForStreamParsing.available());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  void testGetContentsForStreamParsing6() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    PDDocument doc = new PDDocument();
    pdPage.setContents(new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    new IOException("Create InputStream called without data being written before to stream.");

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertEquals(8, actualContentsForStreamParsing.available());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  void testGetContentsForStreamParsing7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream contents = new PDStream(document);
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertEquals(1, actualContentsForStreamParsing.available());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  void testGetContentsForStreamParsing8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream contents = new PDStream(document);
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertEquals(1, actualContentsForStreamParsing.available());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  void testGetContentsForRandomAccess() throws IOException {
    // Arrange and Act
    RandomAccessRead actualContentsForRandomAccess = (new PDPage()).getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForRandomAccess.available());
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  void testGetContentsForRandomAccess2() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new PDStream(new COSDocument()));

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  void testGetContentsForRandomAccess3() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new ArrayList<>());

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForRandomAccess.available());
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  void testGetContentsForRandomAccess4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  void testGetContentsForRandomAccess5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));
    contents.setFilters(new ArrayList<>());

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  void testGetContentsForRandomAccess6() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    PDDocument doc = new PDDocument();
    pdPage.setContents(new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    new IOException("Create InputStream called without data being written before to stream.");

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(8, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  void testGetContentsForRandomAccess7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream contents = new PDStream(document);
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  void testGetContentsForRandomAccess8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream contents = new PDStream(document);
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  void testHasContents() {
    // Arrange, Act and Assert
    assertFalse((new PDPage()).hasContents());
  }

  /**
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  void testHasContents2() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new PDStream(new COSDocument()));

    // Act and Assert
    assertTrue(pdPage.hasContents());
  }

  /**
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  void testHasContents3() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new ArrayList<>());

    // Act and Assert
    assertFalse(pdPage.hasContents());
  }

  /**
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  void testHasContents4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    boolean actualHasContentsResult = pdPage.hasContents();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualHasContentsResult);
  }

  /**
   * Method under test: {@link PDPage#getResources()}
   */
  @Test
  void testGetResources() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getResources());
  }

  /**
   * Method under test: {@link PDPage#getResources()}
   */
  @Test
  void testGetResources2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    PDResources actualResources = pdPage.getResources();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualResources);
  }

  /**
   * Method under test: {@link PDPage#getStructParents()}
   */
  @Test
  void testGetStructParents() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPage()).getStructParents());
  }

  /**
   * Method under test: {@link PDPage#getStructParents()}
   */
  @Test
  void testGetStructParents2() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setStructParents(-1);

    // Act and Assert
    assertEquals(-1, pdPage.getStructParents());
  }

  /**
   * Method under test: {@link PDPage#getStructParents()}
   */
  @Test
  void testGetStructParents3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    int actualStructParents = pdPage.getStructParents();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-1, actualStructParents);
  }

  /**
   * Method under test: {@link PDPage#setStructParents(int)}
   */
  @Test
  void testSetStructParents() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setInt(Mockito.<COSName>any(), anyInt());

    // Act
    (new PDPage(pageDictionary)).setStructParents(1);

    // Assert that nothing has changed
    verify(pageDictionary).setInt(isA(COSName.class), eq(1));
  }

  /**
   * Method under test: {@link PDPage#getBBox()}
   */
  @Test
  void testGetBBox() {
    // Arrange and Act
    PDRectangle actualBBox = (new PDPage()).getBBox();

    // Assert
    COSArray cOSArray = actualBBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualBBox.getLowerLeftX());
    assertEquals(0.0f, actualBBox.getLowerLeftY());
    assertEquals(612.0f, actualBBox.getUpperRightX());
    assertEquals(612.0f, actualBBox.getWidth());
    assertEquals(792.0f, actualBBox.getHeight());
    assertEquals(792.0f, actualBBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualBBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getBBox()}
   */
  @Test
  void testGetBBox2() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualBBox = pdPage.getBBox();

    // Assert
    PDRectangle pdRectangle = actualBBox.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, actualBBox);
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Method under test: {@link PDPage#getBBox()}
   */
  @Test
  void testGetBBox3() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(PDRectangle.A0);

    // Act
    PDRectangle actualBBox = pdPage.getBBox();

    // Assert
    COSArray cOSArray = actualBBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualBBox.getLowerLeftX());
    assertEquals(0.0f, actualBBox.getLowerLeftY());
    assertEquals(612.0f, actualBBox.getUpperRightX());
    assertEquals(612.0f, actualBBox.getWidth());
    assertEquals(792.0f, actualBBox.getHeight());
    assertEquals(792.0f, actualBBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualBBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getBBox()}
   */
  @Test
  void testGetBBox4() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualBBox = pdPage.getBBox();

    // Assert
    COSArray cOSArray = actualBBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(-2.14748288E9f, actualBBox.getHeight());
    assertEquals(-2.14748301E9f, actualBBox.getWidth());
    assertEquals(2.14748365E9f, actualBBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualBBox.getLowerLeftY());
    assertEquals(612.0f, actualBBox.getUpperRightX());
    assertEquals(792.0f, actualBBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualBBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getBBox()}
   */
  @Test
  void testGetBBox5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    PDRectangle actualBBox = pdPage.getBBox();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSArray cOSArray = actualBBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualBBox.getLowerLeftX());
    assertEquals(0.0f, actualBBox.getLowerLeftY());
    assertEquals(612.0f, actualBBox.getUpperRightX());
    assertEquals(612.0f, actualBBox.getWidth());
    assertEquals(792.0f, actualBBox.getHeight());
    assertEquals(792.0f, actualBBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualBBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getMatrix()}
   */
  @Test
  void testGetMatrix() {
    // Arrange and Act
    Matrix actualMatrix = (new PDPage()).getMatrix();

    // Assert
    assertEquals(0.0f, actualMatrix.getShearX());
    assertEquals(0.0f, actualMatrix.getShearY());
    assertEquals(0.0f, actualMatrix.getTranslateX());
    assertEquals(0.0f, actualMatrix.getTranslateY());
    assertEquals(1.0f, actualMatrix.getScaleX());
    assertEquals(1.0f, actualMatrix.getScaleY());
    assertEquals(1.0f, actualMatrix.getScalingFactorX());
    assertEquals(1.0f, actualMatrix.getScalingFactorY());
    float[][] values = actualMatrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDPage#getMatrix()}
   */
  @Test
  void testGetMatrix2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    Matrix actualMatrix = pdPage.getMatrix();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualMatrix.getShearX());
    assertEquals(0.0f, actualMatrix.getShearY());
    assertEquals(0.0f, actualMatrix.getTranslateX());
    assertEquals(0.0f, actualMatrix.getTranslateY());
    assertEquals(1.0f, actualMatrix.getScaleX());
    assertEquals(1.0f, actualMatrix.getScaleY());
    assertEquals(1.0f, actualMatrix.getScalingFactorX());
    assertEquals(1.0f, actualMatrix.getScalingFactorY());
    float[][] values = actualMatrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDPage#getMediaBox()}
   */
  @Test
  void testGetMediaBox() {
    // Arrange and Act
    PDRectangle actualMediaBox = (new PDPage()).getMediaBox();

    // Assert
    COSArray cOSArray = actualMediaBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualMediaBox.getLowerLeftX());
    assertEquals(0.0f, actualMediaBox.getLowerLeftY());
    assertEquals(612.0f, actualMediaBox.getUpperRightX());
    assertEquals(612.0f, actualMediaBox.getWidth());
    assertEquals(792.0f, actualMediaBox.getHeight());
    assertEquals(792.0f, actualMediaBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualMediaBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getMediaBox()}
   */
  @Test
  void testGetMediaBox2() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualMediaBox = pdPage.getMediaBox();

    // Assert
    PDRectangle pdRectangle = actualMediaBox.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, actualMediaBox);
  }

  /**
   * Method under test: {@link PDPage#getMediaBox()}
   */
  @Test
  void testGetMediaBox3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    PDRectangle actualMediaBox = pdPage.getMediaBox();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSArray cOSArray = actualMediaBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualMediaBox.getLowerLeftX());
    assertEquals(0.0f, actualMediaBox.getLowerLeftY());
    assertEquals(612.0f, actualMediaBox.getUpperRightX());
    assertEquals(612.0f, actualMediaBox.getWidth());
    assertEquals(792.0f, actualMediaBox.getHeight());
    assertEquals(792.0f, actualMediaBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualMediaBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#setMediaBox(PDRectangle)}
   */
  @Test
  void testSetMediaBox() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDRectangle mediaBox = new PDRectangle();

    // Act
    pdPage.setMediaBox(mediaBox);

    // Assert
    boolean actualIsEmptyResult = pdPage.getActions().getCOSObject().toIncrement().getObjects().isEmpty();
    COSDictionary cOSObject = pdPage.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualIsEmptyResult);
    assertSame(mediaBox, pdPage.getArtBox());
    assertSame(mediaBox, pdPage.getBBox());
    assertSame(mediaBox, pdPage.getBleedBox());
    assertSame(mediaBox, pdPage.getCropBox());
    assertSame(mediaBox, pdPage.getMediaBox());
  }

  /**
   * Method under test: {@link PDPage#setMediaBox(PDRectangle)}
   */
  @Test
  void testSetMediaBox2() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setMediaBox(null);

    // Assert
    boolean actualIsEmptyResult = pdPage.getActions().getCOSObject().toIncrement().getObjects().isEmpty();
    PDRectangle artBox = pdPage.getArtBox();
    assertTrue(artBox instanceof PDImmutableRectangle);
    COSDictionary cOSObject = pdPage.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualIsEmptyResult);
    assertSame(artBox, pdPage.getBBox());
    assertSame(artBox, pdPage.getBleedBox());
    assertSame(artBox, pdPage.getCropBox());
    assertSame(artBox, pdPage.getMediaBox());
  }

  /**
   * Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  void testGetCropBox() {
    // Arrange and Act
    PDRectangle actualCropBox = (new PDPage()).getCropBox();

    // Assert
    COSArray cOSArray = actualCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualCropBox.getLowerLeftX());
    assertEquals(0.0f, actualCropBox.getLowerLeftY());
    assertEquals(612.0f, actualCropBox.getUpperRightX());
    assertEquals(612.0f, actualCropBox.getWidth());
    assertEquals(792.0f, actualCropBox.getHeight());
    assertEquals(792.0f, actualCropBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualCropBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  void testGetCropBox2() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualCropBox = pdPage.getCropBox();

    // Assert
    PDRectangle pdRectangle = actualCropBox.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, actualCropBox);
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  void testGetCropBox3() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(PDRectangle.A0);

    // Act
    PDRectangle actualCropBox = pdPage.getCropBox();

    // Assert
    COSArray cOSArray = actualCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualCropBox.getLowerLeftX());
    assertEquals(0.0f, actualCropBox.getLowerLeftY());
    assertEquals(612.0f, actualCropBox.getUpperRightX());
    assertEquals(612.0f, actualCropBox.getWidth());
    assertEquals(792.0f, actualCropBox.getHeight());
    assertEquals(792.0f, actualCropBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualCropBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  void testGetCropBox4() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualCropBox = pdPage.getCropBox();

    // Assert
    COSArray cOSArray = actualCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(-2.14748288E9f, actualCropBox.getHeight());
    assertEquals(-2.14748301E9f, actualCropBox.getWidth());
    assertEquals(2.14748365E9f, actualCropBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualCropBox.getLowerLeftY());
    assertEquals(612.0f, actualCropBox.getUpperRightX());
    assertEquals(792.0f, actualCropBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualCropBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  void testGetCropBox5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    PDRectangle actualCropBox = pdPage.getCropBox();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSArray cOSArray = actualCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualCropBox.getLowerLeftX());
    assertEquals(0.0f, actualCropBox.getLowerLeftY());
    assertEquals(612.0f, actualCropBox.getUpperRightX());
    assertEquals(612.0f, actualCropBox.getWidth());
    assertEquals(792.0f, actualCropBox.getHeight());
    assertEquals(792.0f, actualCropBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualCropBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  void testSetCropBox() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage pdPage = new PDPage(pageDictionary);
    PDRectangle cropBox = mock(PDRectangle.class);
    when(cropBox.getCOSArray()).thenReturn(mock(COSArray.class));

    // Act
    pdPage.setCropBox(cropBox);

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cropBox).getCOSArray();
  }

  /**
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  void testGetBleedBox() {
    // Arrange and Act
    PDRectangle actualBleedBox = (new PDPage()).getBleedBox();

    // Assert
    COSArray cOSArray = actualBleedBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualBleedBox.getLowerLeftX());
    assertEquals(0.0f, actualBleedBox.getLowerLeftY());
    assertEquals(612.0f, actualBleedBox.getUpperRightX());
    assertEquals(612.0f, actualBleedBox.getWidth());
    assertEquals(792.0f, actualBleedBox.getHeight());
    assertEquals(792.0f, actualBleedBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualBleedBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  void testGetBleedBox2() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualBleedBox = pdPage.getBleedBox();

    // Assert
    PDRectangle pdRectangle = actualBleedBox.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, actualBleedBox);
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  void testGetBleedBox3() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(PDRectangle.A0);

    // Act
    PDRectangle actualBleedBox = pdPage.getBleedBox();

    // Assert
    COSArray cOSArray = actualBleedBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualBleedBox.getLowerLeftX());
    assertEquals(0.0f, actualBleedBox.getLowerLeftY());
    assertEquals(612.0f, actualBleedBox.getUpperRightX());
    assertEquals(612.0f, actualBleedBox.getWidth());
    assertEquals(792.0f, actualBleedBox.getHeight());
    assertEquals(792.0f, actualBleedBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualBleedBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  void testGetBleedBox4() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setBleedBox(PDRectangle.A0);

    // Act
    PDRectangle actualBleedBox = pdPage.getBleedBox();

    // Assert
    COSArray cOSArray = actualBleedBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualBleedBox.getLowerLeftX());
    assertEquals(0.0f, actualBleedBox.getLowerLeftY());
    assertEquals(612.0f, actualBleedBox.getUpperRightX());
    assertEquals(612.0f, actualBleedBox.getWidth());
    assertEquals(792.0f, actualBleedBox.getHeight());
    assertEquals(792.0f, actualBleedBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualBleedBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  void testGetBleedBox5() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualBleedBox = pdPage.getBleedBox();

    // Assert
    COSArray cOSArray = actualBleedBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(-2.14748288E9f, actualBleedBox.getHeight());
    assertEquals(-2.14748301E9f, actualBleedBox.getWidth());
    assertEquals(2.14748365E9f, actualBleedBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualBleedBox.getLowerLeftY());
    assertEquals(612.0f, actualBleedBox.getUpperRightX());
    assertEquals(792.0f, actualBleedBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualBleedBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  void testGetBleedBox6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    PDRectangle actualBleedBox = pdPage.getBleedBox();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSArray cOSArray = actualBleedBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualBleedBox.getLowerLeftX());
    assertEquals(0.0f, actualBleedBox.getLowerLeftY());
    assertEquals(612.0f, actualBleedBox.getUpperRightX());
    assertEquals(612.0f, actualBleedBox.getWidth());
    assertEquals(792.0f, actualBleedBox.getHeight());
    assertEquals(792.0f, actualBleedBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualBleedBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#setBleedBox(PDRectangle)}
   */
  @Test
  void testSetBleedBox() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDPage(pageDictionary)).setBleedBox(mock(PDRectangle.class));

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  void testGetTrimBox() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getTrimBox());
  }

  /**
   * Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  void testGetTrimBox2() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setTrimBox(PDRectangle.A0);

    // Act
    PDRectangle actualTrimBox = pdPage.getTrimBox();

    // Assert
    COSArray cOSArray = actualTrimBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualTrimBox.getLowerLeftX());
    assertEquals(0.0f, actualTrimBox.getLowerLeftY());
    assertEquals(612.0f, actualTrimBox.getUpperRightX());
    assertEquals(612.0f, actualTrimBox.getWidth());
    assertEquals(792.0f, actualTrimBox.getHeight());
    assertEquals(792.0f, actualTrimBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualTrimBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  void testGetTrimBox3() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setTrimBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualTrimBox = pdPage.getTrimBox();

    // Assert
    COSArray cOSArray = actualTrimBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(-2.14748288E9f, actualTrimBox.getHeight());
    assertEquals(-2.14748301E9f, actualTrimBox.getWidth());
    assertEquals(2.14748365E9f, actualTrimBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualTrimBox.getLowerLeftY());
    assertEquals(612.0f, actualTrimBox.getUpperRightX());
    assertEquals(792.0f, actualTrimBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualTrimBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  void testGetTrimBox4() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());
    pdPage.setTrimBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualTrimBox = pdPage.getTrimBox();

    // Assert
    COSArray cOSArray = actualTrimBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDRectangle artBox = pdPage.getArtBox();
    assertTrue(artBox instanceof PDImmutableRectangle);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(-2.14748288E9f, actualTrimBox.getHeight());
    assertEquals(-2.14748301E9f, actualTrimBox.getWidth());
    assertEquals(2.14748365E9f, actualTrimBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualTrimBox.getLowerLeftY());
    assertEquals(612.0f, actualTrimBox.getUpperRightX());
    assertEquals(792.0f, actualTrimBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualTrimBox.getCOSObject());
    PDRectangle pdRectangle = actualTrimBox.LETTER;
    assertSame(pdRectangle, artBox);
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  void testGetTrimBox5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    PDRectangle actualTrimBox = pdPage.getTrimBox();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualTrimBox);
  }

  /**
   * Method under test: {@link PDPage#setTrimBox(PDRectangle)}
   */
  @Test
  void testSetTrimBox() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDPage(pageDictionary)).setTrimBox(mock(PDRectangle.class));

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  void testGetArtBox() {
    // Arrange and Act
    PDRectangle actualArtBox = (new PDPage()).getArtBox();

    // Assert
    COSArray cOSArray = actualArtBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualArtBox.getLowerLeftX());
    assertEquals(0.0f, actualArtBox.getLowerLeftY());
    assertEquals(612.0f, actualArtBox.getUpperRightX());
    assertEquals(612.0f, actualArtBox.getWidth());
    assertEquals(792.0f, actualArtBox.getHeight());
    assertEquals(792.0f, actualArtBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualArtBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  void testGetArtBox2() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualArtBox = pdPage.getArtBox();

    // Assert
    PDRectangle pdRectangle = actualArtBox.LETTER;
    assertSame(pdRectangle, actualArtBox);
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  void testGetArtBox3() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(PDRectangle.A0);

    // Act
    PDRectangle actualArtBox = pdPage.getArtBox();

    // Assert
    COSArray cOSArray = actualArtBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualArtBox.getLowerLeftX());
    assertEquals(0.0f, actualArtBox.getLowerLeftY());
    assertEquals(612.0f, actualArtBox.getUpperRightX());
    assertEquals(612.0f, actualArtBox.getWidth());
    assertEquals(792.0f, actualArtBox.getHeight());
    assertEquals(792.0f, actualArtBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualArtBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  void testGetArtBox4() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setArtBox(PDRectangle.A0);

    // Act
    PDRectangle actualArtBox = pdPage.getArtBox();

    // Assert
    COSArray cOSArray = actualArtBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualArtBox.getLowerLeftX());
    assertEquals(0.0f, actualArtBox.getLowerLeftY());
    assertEquals(612.0f, actualArtBox.getUpperRightX());
    assertEquals(612.0f, actualArtBox.getWidth());
    assertEquals(792.0f, actualArtBox.getHeight());
    assertEquals(792.0f, actualArtBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualArtBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  void testGetArtBox5() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualArtBox = pdPage.getArtBox();

    // Assert
    COSArray cOSArray = actualArtBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(-2.14748288E9f, actualArtBox.getHeight());
    assertEquals(-2.14748301E9f, actualArtBox.getWidth());
    assertEquals(2.14748365E9f, actualArtBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualArtBox.getLowerLeftY());
    assertEquals(612.0f, actualArtBox.getUpperRightX());
    assertEquals(792.0f, actualArtBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualArtBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  void testGetArtBox6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    PDRectangle actualArtBox = pdPage.getArtBox();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSArray cOSArray = actualArtBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualArtBox.getLowerLeftX());
    assertEquals(0.0f, actualArtBox.getLowerLeftY());
    assertEquals(612.0f, actualArtBox.getUpperRightX());
    assertEquals(612.0f, actualArtBox.getWidth());
    assertEquals(792.0f, actualArtBox.getHeight());
    assertEquals(792.0f, actualArtBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualArtBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#setArtBox(PDRectangle)}
   */
  @Test
  void testSetArtBox() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDPage(pageDictionary)).setArtBox(mock(PDRectangle.class));

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDPage#getRotation()}
   */
  @Test
  void testGetRotation() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDPage()).getRotation());
  }

  /**
   * Method under test: {@link PDPage#getRotation()}
   */
  @Test
  void testGetRotation2() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setRotation(1);

    // Act and Assert
    assertEquals(0, pdPage.getRotation());
  }

  /**
   * Method under test: {@link PDPage#getRotation()}
   */
  @Test
  void testGetRotation3() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setRotation(90);

    // Act and Assert
    assertEquals(90, pdPage.getRotation());
  }

  /**
   * Method under test: {@link PDPage#getRotation()}
   */
  @Test
  void testGetRotation4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    int actualRotation = pdPage.getRotation();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualRotation);
  }

  /**
   * Method under test: {@link PDPage#setRotation(int)}
   */
  @Test
  void testSetRotation() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setInt(Mockito.<COSName>any(), anyInt());

    // Act
    (new PDPage(pageDictionary)).setRotation(1);

    // Assert that nothing has changed
    verify(pageDictionary).setInt(isA(COSName.class), eq(1));
  }

  /**
   * Method under test: {@link PDPage#setContents(List)}
   */
  @Test
  void testSetContents() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDStream pdStream = mock(PDStream.class);
    when(pdStream.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(pdStream);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setContents(contents));
    verify(pdStream).getCOSObject();
  }

  /**
   * Method under test: {@link PDPage#setContents(PDStream)}
   */
  @Test
  void testSetContents2() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDStream contents = mock(PDStream.class);
    when(contents.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setContents(contents));
    verify(contents).getCOSObject();
  }

  /**
   * Method under test: {@link PDPage#setContents(PDStream)}
   */
  @Test
  void testSetContents3() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDPage(pageDictionary)).setContents(mock(PDStream.class));

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  void testGetThreadBeads() {
    // Arrange, Act and Assert
    assertTrue((new PDPage()).getThreadBeads().isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  void testGetThreadBeads2() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setThreadBeads(new ArrayList<>());

    // Act and Assert
    assertTrue(pdPage.getThreadBeads().isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  void testGetThreadBeads3() {
    // Arrange
    ArrayList<PDThreadBead> beads = new ArrayList<>();
    beads.add(new PDThreadBead());

    PDPage pdPage = new PDPage();
    pdPage.setThreadBeads(beads);

    // Act
    List<PDThreadBead> actualThreadBeads = pdPage.getThreadBeads();

    // Assert
    assertEquals(1, actualThreadBeads.size());
    PDThreadBead getResult = actualThreadBeads.get(0);
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getPage());
    PDThreadBead nextBead = getResult.getNextBead();
    assertNull(nextBead.getPage());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertNull(nextBead2.getPage());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertNull(nextBead3.getPage());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    assertNull(nextBead4.getPage());
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    assertNull(nextBead5.getPage());
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    assertNull(nextBead6.getPage());
    PDThreadBead nextBead7 = nextBead6.getNextBead();
    assertNull(nextBead7.getPage());
    PDThreadBead previousBead = getResult.getPreviousBead();
    PDThreadBead nextBead8 = previousBead.getNextBead();
    PDThreadBead nextBead9 = nextBead8.getNextBead();
    PDThreadBead nextBead10 = nextBead9.getNextBead();
    PDThreadBead nextBead11 = nextBead10.getNextBead();
    PDThreadBead nextBead12 = nextBead11.getNextBead();
    assertNull(nextBead12.getPage());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    PDThreadBead nextBead13 = previousBead2.getNextBead();
    PDThreadBead nextBead14 = nextBead13.getNextBead();
    PDThreadBead nextBead15 = nextBead14.getNextBead();
    PDThreadBead nextBead16 = nextBead15.getNextBead();
    PDThreadBead nextBead17 = nextBead16.getNextBead();
    assertNull(nextBead17.getPage());
    assertNull(nextBead11.getPage());
    assertNull(nextBead16.getPage());
    PDThreadBead previousBead3 = nextBead2.getPreviousBead();
    PDThreadBead nextBead18 = previousBead3.getNextBead();
    PDThreadBead nextBead19 = nextBead18.getNextBead();
    PDThreadBead nextBead20 = nextBead19.getNextBead();
    PDThreadBead nextBead21 = nextBead20.getNextBead();
    assertNull(nextBead21.getPage());
    PDThreadBead previousBead4 = previousBead.getPreviousBead();
    PDThreadBead nextBead22 = previousBead4.getNextBead();
    PDThreadBead nextBead23 = nextBead22.getNextBead();
    PDThreadBead nextBead24 = nextBead23.getNextBead();
    PDThreadBead nextBead25 = nextBead24.getNextBead();
    assertNull(nextBead25.getPage());
    assertNull(nextBead10.getPage());
    assertNull(nextBead15.getPage());
    assertNull(nextBead20.getPage());
    PDThreadBead previousBead5 = nextBead3.getPreviousBead();
    PDThreadBead nextBead26 = previousBead5.getNextBead();
    PDThreadBead nextBead27 = nextBead26.getNextBead();
    PDThreadBead nextBead28 = nextBead27.getNextBead();
    assertNull(nextBead28.getPage());
    PDThreadBead previousBead6 = nextBead8.getPreviousBead();
    PDThreadBead nextBead29 = previousBead6.getNextBead();
    PDThreadBead nextBead30 = nextBead29.getNextBead();
    PDThreadBead nextBead31 = nextBead30.getNextBead();
    assertNull(nextBead31.getPage());
    assertNull(nextBead24.getPage());
    PDThreadBead previousBead7 = previousBead2.getPreviousBead();
    PDThreadBead nextBead32 = previousBead7.getNextBead();
    PDThreadBead nextBead33 = nextBead32.getNextBead();
    PDThreadBead nextBead34 = nextBead33.getNextBead();
    assertNull(nextBead34.getPage());
    PDThreadBead previousBead8 = previousBead3.getPreviousBead();
    PDThreadBead nextBead35 = previousBead8.getNextBead();
    PDThreadBead nextBead36 = nextBead35.getNextBead();
    PDThreadBead nextBead37 = nextBead36.getNextBead();
    assertNull(nextBead37.getPage());
    PDThreadBead previousBead9 = previousBead4.getPreviousBead();
    PDThreadBead nextBead38 = previousBead9.getNextBead();
    PDThreadBead nextBead39 = nextBead38.getNextBead();
    PDThreadBead nextBead40 = nextBead39.getNextBead();
    assertNull(nextBead40.getPage());
    assertNull(nextBead9.getPage());
    assertNull(nextBead14.getPage());
    assertNull(nextBead19.getPage());
    assertNull(nextBead27.getPage());
    PDThreadBead previousBead10 = nextBead4.getPreviousBead();
    PDThreadBead nextBead41 = previousBead10.getNextBead();
    PDThreadBead nextBead42 = nextBead41.getNextBead();
    assertNull(nextBead42.getPage());
    PDThreadBead previousBead11 = nextBead9.getPreviousBead();
    PDThreadBead nextBead43 = previousBead11.getNextBead();
    PDThreadBead nextBead44 = nextBead43.getNextBead();
    assertNull(nextBead44.getPage());
    PDThreadBead previousBead12 = nextBead14.getPreviousBead();
    PDThreadBead nextBead45 = previousBead12.getNextBead();
    PDThreadBead nextBead46 = nextBead45.getNextBead();
    assertNull(nextBead46.getPage());
    assertNull(nextBead30.getPage());
    PDThreadBead previousBead13 = nextBead13.getPreviousBead();
    PDThreadBead nextBead47 = previousBead13.getNextBead();
    PDThreadBead nextBead48 = nextBead47.getNextBead();
    assertNull(nextBead48.getPage());
    PDThreadBead previousBead14 = nextBead18.getPreviousBead();
    PDThreadBead nextBead49 = previousBead14.getNextBead();
    PDThreadBead nextBead50 = nextBead49.getNextBead();
    assertNull(nextBead50.getPage());
    PDThreadBead previousBead15 = nextBead22.getPreviousBead();
    PDThreadBead nextBead51 = previousBead15.getNextBead();
    PDThreadBead nextBead52 = nextBead51.getNextBead();
    assertNull(nextBead52.getPage());
    assertNull(nextBead23.getPage());
    assertNull(nextBead33.getPage());
    assertNull(nextBead36.getPage());
    PDThreadBead previousBead16 = previousBead5.getPreviousBead();
    PDThreadBead nextBead53 = previousBead16.getNextBead();
    PDThreadBead nextBead54 = nextBead53.getNextBead();
    assertNull(nextBead54.getPage());
    PDThreadBead previousBead17 = previousBead6.getPreviousBead();
    PDThreadBead nextBead55 = previousBead17.getNextBead();
    PDThreadBead nextBead56 = nextBead55.getNextBead();
    assertNull(nextBead56.getPage());
    assertNull(nextBead39.getPage());
    PDThreadBead previousBead18 = previousBead7.getPreviousBead();
    PDThreadBead nextBead57 = previousBead18.getNextBead();
    PDThreadBead nextBead58 = nextBead57.getNextBead();
    assertNull(nextBead58.getPage());
    PDThreadBead previousBead19 = previousBead8.getPreviousBead();
    PDThreadBead nextBead59 = previousBead19.getNextBead();
    PDThreadBead nextBead60 = nextBead59.getNextBead();
    assertNull(nextBead60.getPage());
    PDThreadBead previousBead20 = previousBead9.getPreviousBead();
    PDThreadBead nextBead61 = previousBead20.getNextBead();
    PDThreadBead nextBead62 = nextBead61.getNextBead();
    assertNull(nextBead62.getPage());
    assertNull(nextBead8.getPage());
    assertNull(nextBead13.getPage());
    assertNull(nextBead18.getPage());
    assertNull(nextBead26.getPage());
    assertNull(nextBead41.getPage());
    PDThreadBead previousBead21 = nextBead5.getPreviousBead();
    PDThreadBead nextBead63 = previousBead21.getNextBead();
    assertNull(nextBead63.getPage());
    PDThreadBead previousBead22 = nextBead10.getPreviousBead();
    PDThreadBead nextBead64 = previousBead22.getNextBead();
    assertNull(nextBead64.getPage());
    PDThreadBead previousBead23 = nextBead15.getPreviousBead();
    PDThreadBead nextBead65 = previousBead23.getNextBead();
    assertNull(nextBead65.getPage());
    assertNull(nextBead43.getPage());
    assertNull(nextBead45.getPage());
    PDThreadBead previousBead24 = nextBead19.getPreviousBead();
    PDThreadBead nextBead66 = previousBead24.getNextBead();
    assertNull(nextBead66.getPage());
    PDThreadBead previousBead25 = nextBead23.getPreviousBead();
    PDThreadBead nextBead67 = previousBead25.getNextBead();
    assertNull(nextBead67.getPage());
    assertNull(nextBead29.getPage());
    assertNull(nextBead47.getPage());
    assertNull(nextBead49.getPage());
    PDThreadBead previousBead26 = nextBead26.getPreviousBead();
    PDThreadBead nextBead68 = previousBead26.getNextBead();
    assertNull(nextBead68.getPage());
    PDThreadBead previousBead27 = nextBead29.getPreviousBead();
    PDThreadBead nextBead69 = previousBead27.getNextBead();
    assertNull(nextBead69.getPage());
    assertNull(nextBead51.getPage());
    PDThreadBead previousBead28 = nextBead32.getPreviousBead();
    PDThreadBead nextBead70 = previousBead28.getNextBead();
    assertNull(nextBead70.getPage());
    PDThreadBead previousBead29 = nextBead35.getPreviousBead();
    PDThreadBead nextBead71 = previousBead29.getNextBead();
    assertNull(nextBead71.getPage());
    PDThreadBead previousBead30 = nextBead38.getPreviousBead();
    PDThreadBead nextBead72 = previousBead30.getNextBead();
    assertNull(nextBead72.getPage());
    assertNull(nextBead22.getPage());
    assertNull(nextBead32.getPage());
    assertNull(nextBead35.getPage());
    assertNull(nextBead53.getPage());
    PDThreadBead previousBead31 = previousBead10.getPreviousBead();
    PDThreadBead nextBead73 = previousBead31.getNextBead();
    assertNull(nextBead73.getPage());
    PDThreadBead previousBead32 = previousBead11.getPreviousBead();
    PDThreadBead nextBead74 = previousBead32.getNextBead();
    assertNull(nextBead74.getPage());
    assertNull(nextBead55.getPage());
    PDThreadBead previousBead33 = previousBead13.getPreviousBead();
    PDThreadBead nextBead75 = previousBead33.getNextBead();
    assertNull(nextBead75.getPage());
    PDThreadBead previousBead34 = previousBead14.getPreviousBead();
    PDThreadBead nextBead76 = previousBead34.getNextBead();
    assertNull(nextBead76.getPage());
    PDThreadBead previousBead35 = previousBead15.getPreviousBead();
    PDThreadBead nextBead77 = previousBead35.getNextBead();
    assertNull(nextBead77.getPage());
    assertNull(nextBead38.getPage());
    assertNull(nextBead57.getPage());
    assertNull(nextBead59.getPage());
    PDThreadBead previousBead36 = previousBead16.getPreviousBead();
    PDThreadBead nextBead78 = previousBead36.getNextBead();
    assertNull(nextBead78.getPage());
    PDThreadBead previousBead37 = previousBead17.getPreviousBead();
    PDThreadBead nextBead79 = previousBead37.getNextBead();
    assertNull(nextBead79.getPage());
    assertNull(nextBead61.getPage());
    PDThreadBead previousBead38 = previousBead18.getPreviousBead();
    PDThreadBead nextBead80 = previousBead38.getNextBead();
    assertNull(nextBead80.getPage());
    PDThreadBead previousBead39 = previousBead19.getPreviousBead();
    PDThreadBead nextBead81 = previousBead39.getNextBead();
    assertNull(nextBead81.getPage());
    PDThreadBead previousBead40 = previousBead20.getPreviousBead();
    PDThreadBead nextBead82 = previousBead40.getNextBead();
    assertNull(nextBead82.getPage());
    assertNull(previousBead.getPage());
    assertNull(previousBead2.getPage());
    assertNull(previousBead3.getPage());
    assertNull(previousBead5.getPage());
    assertNull(previousBead10.getPage());
    assertNull(previousBead21.getPage());
    PDThreadBead previousBead41 = nextBead6.getPreviousBead();
    assertNull(previousBead41.getPage());
    PDThreadBead previousBead42 = nextBead11.getPreviousBead();
    assertNull(previousBead42.getPage());
    PDThreadBead previousBead43 = nextBead16.getPreviousBead();
    assertNull(previousBead43.getPage());
    assertNull(previousBead22.getPage());
    assertNull(previousBead23.getPage());
    PDThreadBead previousBead44 = nextBead20.getPreviousBead();
    assertNull(previousBead44.getPage());
    PDThreadBead previousBead45 = nextBead24.getPreviousBead();
    assertNull(previousBead45.getPage());
    assertNull(previousBead11.getPage());
    assertNull(previousBead12.getPage());
    assertNull(previousBead24.getPage());
    PDThreadBead previousBead46 = nextBead27.getPreviousBead();
    assertNull(previousBead46.getPage());
    PDThreadBead previousBead47 = nextBead30.getPreviousBead();
    assertNull(previousBead47.getPage());
    assertNull(previousBead25.getPage());
    PDThreadBead previousBead48 = nextBead33.getPreviousBead();
    assertNull(previousBead48.getPage());
    PDThreadBead previousBead49 = nextBead36.getPreviousBead();
    assertNull(previousBead49.getPage());
    PDThreadBead previousBead50 = nextBead39.getPreviousBead();
    assertNull(previousBead50.getPage());
    assertNull(previousBead6.getPage());
    assertNull(previousBead13.getPage());
    assertNull(previousBead14.getPage());
    assertNull(previousBead26.getPage());
    PDThreadBead previousBead51 = nextBead41.getPreviousBead();
    assertNull(previousBead51.getPage());
    PDThreadBead previousBead52 = nextBead43.getPreviousBead();
    assertNull(previousBead52.getPage());
    PDThreadBead previousBead53 = nextBead45.getPreviousBead();
    assertNull(previousBead53.getPage());
    assertNull(previousBead27.getPage());
    PDThreadBead previousBead54 = nextBead47.getPreviousBead();
    assertNull(previousBead54.getPage());
    PDThreadBead previousBead55 = nextBead49.getPreviousBead();
    assertNull(previousBead55.getPage());
    PDThreadBead previousBead56 = nextBead51.getPreviousBead();
    assertNull(previousBead56.getPage());
    assertNull(previousBead15.getPage());
    assertNull(previousBead28.getPage());
    assertNull(previousBead29.getPage());
    PDThreadBead previousBead57 = nextBead53.getPreviousBead();
    assertNull(previousBead57.getPage());
    PDThreadBead previousBead58 = nextBead55.getPreviousBead();
    assertNull(previousBead58.getPage());
    assertNull(previousBead30.getPage());
    PDThreadBead previousBead59 = nextBead57.getPreviousBead();
    assertNull(previousBead59.getPage());
    PDThreadBead previousBead60 = nextBead59.getPreviousBead();
    assertNull(previousBead60.getPage());
    PDThreadBead previousBead61 = nextBead61.getPreviousBead();
    assertNull(previousBead61.getPage());
    assertNull(previousBead4.getPage());
    assertNull(previousBead7.getPage());
    assertNull(previousBead8.getPage());
    assertNull(previousBead16.getPage());
    assertNull(previousBead31.getPage());
    PDThreadBead previousBead62 = previousBead21.getPreviousBead();
    assertNull(previousBead62.getPage());
    PDThreadBead previousBead63 = previousBead22.getPreviousBead();
    assertNull(previousBead63.getPage());
    PDThreadBead previousBead64 = previousBead23.getPreviousBead();
    assertNull(previousBead64.getPage());
    assertNull(previousBead32.getPage());
    PDThreadBead previousBead65 = previousBead12.getPreviousBead();
    assertNull(previousBead65.getPage());
    PDThreadBead previousBead66 = previousBead24.getPreviousBead();
    assertNull(previousBead66.getPage());
    PDThreadBead previousBead67 = previousBead25.getPreviousBead();
    assertNull(previousBead67.getPage());
    assertNull(previousBead17.getPage());
    assertNull(previousBead33.getPage());
    assertNull(previousBead34.getPage());
    PDThreadBead previousBead68 = previousBead26.getPreviousBead();
    assertNull(previousBead68.getPage());
    PDThreadBead previousBead69 = previousBead27.getPreviousBead();
    assertNull(previousBead69.getPage());
    assertNull(previousBead35.getPage());
    PDThreadBead previousBead70 = previousBead28.getPreviousBead();
    assertNull(previousBead70.getPage());
    PDThreadBead previousBead71 = previousBead29.getPreviousBead();
    assertNull(previousBead71.getPage());
    PDThreadBead previousBead72 = previousBead30.getPreviousBead();
    assertNull(previousBead72.getPage());
    assertNull(previousBead9.getPage());
    assertNull(previousBead18.getPage());
    assertNull(previousBead19.getPage());
    assertNull(previousBead36.getPage());
    PDThreadBead previousBead73 = previousBead31.getPreviousBead();
    assertNull(previousBead73.getPage());
    PDThreadBead previousBead74 = previousBead32.getPreviousBead();
    assertNull(previousBead74.getPage());
    assertNull(previousBead37.getPage());
    PDThreadBead previousBead75 = previousBead33.getPreviousBead();
    assertNull(previousBead75.getPage());
    PDThreadBead previousBead76 = previousBead34.getPreviousBead();
    assertNull(previousBead76.getPage());
    PDThreadBead previousBead77 = previousBead35.getPreviousBead();
    assertNull(previousBead77.getPage());
    assertNull(previousBead20.getPage());
    assertNull(previousBead38.getPage());
    assertNull(previousBead39.getPage());
    PDThreadBead previousBead78 = previousBead36.getPreviousBead();
    assertNull(previousBead78.getPage());
    PDThreadBead previousBead79 = previousBead37.getPreviousBead();
    assertNull(previousBead79.getPage());
    assertNull(previousBead40.getPage());
    PDThreadBead previousBead80 = previousBead38.getPreviousBead();
    assertNull(previousBead80.getPage());
    PDThreadBead previousBead81 = previousBead39.getPreviousBead();
    assertNull(previousBead81.getPage());
    PDThreadBead previousBead82 = previousBead40.getPreviousBead();
    assertNull(previousBead82.getPage());
    assertNull(getResult.getRectangle());
    assertNull(nextBead.getRectangle());
    assertNull(nextBead2.getRectangle());
    assertNull(nextBead3.getRectangle());
    assertNull(nextBead4.getRectangle());
    assertNull(nextBead5.getRectangle());
    assertNull(nextBead6.getRectangle());
    assertNull(nextBead7.getRectangle());
    assertNull(nextBead12.getRectangle());
    assertNull(nextBead17.getRectangle());
    assertNull(nextBead11.getRectangle());
    assertNull(nextBead16.getRectangle());
    assertNull(nextBead21.getRectangle());
    assertNull(nextBead25.getRectangle());
    assertNull(nextBead10.getRectangle());
    assertNull(nextBead15.getRectangle());
    assertNull(nextBead20.getRectangle());
    assertNull(nextBead28.getRectangle());
    assertNull(nextBead31.getRectangle());
    assertNull(nextBead24.getRectangle());
    assertNull(nextBead34.getRectangle());
    assertNull(nextBead37.getRectangle());
    assertNull(nextBead40.getRectangle());
    assertNull(nextBead9.getRectangle());
    assertNull(nextBead14.getRectangle());
    assertNull(nextBead19.getRectangle());
    assertNull(nextBead27.getRectangle());
    assertNull(nextBead42.getRectangle());
    assertNull(nextBead44.getRectangle());
    assertNull(nextBead46.getRectangle());
    assertNull(nextBead30.getRectangle());
    assertNull(nextBead48.getRectangle());
    assertNull(nextBead50.getRectangle());
    assertNull(nextBead52.getRectangle());
    assertNull(nextBead23.getRectangle());
    assertNull(nextBead33.getRectangle());
    assertNull(nextBead36.getRectangle());
    assertNull(nextBead54.getRectangle());
    assertNull(nextBead56.getRectangle());
    assertNull(nextBead39.getRectangle());
    assertNull(nextBead58.getRectangle());
    assertNull(nextBead60.getRectangle());
    assertNull(nextBead62.getRectangle());
    assertNull(nextBead8.getRectangle());
    assertNull(nextBead13.getRectangle());
    assertNull(nextBead18.getRectangle());
    assertNull(nextBead26.getRectangle());
    assertNull(nextBead41.getRectangle());
    assertNull(nextBead63.getRectangle());
    assertNull(nextBead64.getRectangle());
    assertNull(nextBead65.getRectangle());
    assertNull(nextBead43.getRectangle());
    assertNull(nextBead45.getRectangle());
    assertNull(nextBead66.getRectangle());
    assertNull(nextBead67.getRectangle());
    assertNull(nextBead29.getRectangle());
    assertNull(nextBead47.getRectangle());
    assertNull(nextBead49.getRectangle());
    assertNull(nextBead68.getRectangle());
    assertNull(nextBead69.getRectangle());
    assertNull(nextBead51.getRectangle());
    assertNull(nextBead70.getRectangle());
    assertNull(nextBead71.getRectangle());
    assertNull(nextBead72.getRectangle());
    assertNull(nextBead22.getRectangle());
    assertNull(nextBead32.getRectangle());
    assertNull(nextBead35.getRectangle());
    assertNull(nextBead53.getRectangle());
    assertNull(nextBead73.getRectangle());
    assertNull(nextBead74.getRectangle());
    assertNull(nextBead55.getRectangle());
    assertNull(nextBead75.getRectangle());
    assertNull(nextBead76.getRectangle());
    assertNull(nextBead77.getRectangle());
    assertNull(nextBead38.getRectangle());
    assertNull(nextBead57.getRectangle());
    assertNull(nextBead59.getRectangle());
    assertNull(nextBead78.getRectangle());
    assertNull(nextBead79.getRectangle());
    assertNull(nextBead61.getRectangle());
    assertNull(nextBead80.getRectangle());
    assertNull(nextBead81.getRectangle());
    assertNull(nextBead82.getRectangle());
    assertNull(previousBead.getRectangle());
    assertNull(previousBead2.getRectangle());
    assertNull(previousBead3.getRectangle());
    assertNull(previousBead5.getRectangle());
    assertNull(previousBead10.getRectangle());
    assertNull(previousBead21.getRectangle());
    assertNull(previousBead41.getRectangle());
    assertNull(previousBead42.getRectangle());
    assertNull(previousBead43.getRectangle());
    assertNull(previousBead22.getRectangle());
    assertNull(previousBead23.getRectangle());
    assertNull(previousBead44.getRectangle());
    assertNull(previousBead45.getRectangle());
    assertNull(previousBead11.getRectangle());
    assertNull(previousBead12.getRectangle());
    assertNull(previousBead24.getRectangle());
    assertNull(previousBead46.getRectangle());
    assertNull(previousBead47.getRectangle());
    assertNull(previousBead25.getRectangle());
    assertNull(previousBead48.getRectangle());
    assertNull(previousBead49.getRectangle());
    assertNull(previousBead50.getRectangle());
    assertNull(previousBead6.getRectangle());
    assertNull(previousBead13.getRectangle());
    assertNull(previousBead14.getRectangle());
    assertNull(previousBead26.getRectangle());
    assertNull(previousBead51.getRectangle());
    assertNull(previousBead52.getRectangle());
    assertNull(previousBead27.getRectangle());
    assertNull(previousBead54.getRectangle());
    assertNull(previousBead55.getRectangle());
    assertNull(previousBead56.getRectangle());
    assertNull(previousBead15.getRectangle());
    assertNull(previousBead28.getRectangle());
    assertNull(previousBead29.getRectangle());
    assertNull(previousBead57.getRectangle());
    assertNull(previousBead58.getRectangle());
    assertNull(previousBead30.getRectangle());
    assertNull(previousBead59.getRectangle());
    assertNull(previousBead60.getRectangle());
    assertNull(previousBead61.getRectangle());
    assertNull(previousBead4.getRectangle());
    assertNull(previousBead7.getRectangle());
    assertNull(previousBead8.getRectangle());
    assertNull(previousBead16.getRectangle());
    assertNull(previousBead31.getRectangle());
    assertNull(previousBead62.getRectangle());
    assertNull(previousBead63.getRectangle());
    assertNull(previousBead64.getRectangle());
    assertNull(previousBead32.getRectangle());
    assertNull(previousBead65.getRectangle());
    assertNull(previousBead66.getRectangle());
    assertNull(previousBead67.getRectangle());
    assertNull(previousBead17.getRectangle());
    assertNull(previousBead33.getRectangle());
    assertNull(previousBead34.getRectangle());
    assertNull(previousBead68.getRectangle());
    assertNull(previousBead69.getRectangle());
    assertNull(previousBead35.getRectangle());
    assertNull(previousBead70.getRectangle());
    assertNull(previousBead71.getRectangle());
    assertNull(previousBead72.getRectangle());
    assertNull(previousBead9.getRectangle());
    assertNull(previousBead18.getRectangle());
    assertNull(previousBead19.getRectangle());
    assertNull(previousBead36.getRectangle());
    assertNull(previousBead73.getRectangle());
    assertNull(previousBead74.getRectangle());
    assertNull(previousBead37.getRectangle());
    assertNull(previousBead75.getRectangle());
    assertNull(previousBead76.getRectangle());
    assertNull(previousBead77.getRectangle());
    assertNull(previousBead20.getRectangle());
    assertNull(previousBead38.getRectangle());
    assertNull(previousBead39.getRectangle());
    assertNull(previousBead78.getRectangle());
    assertNull(previousBead79.getRectangle());
    assertNull(previousBead40.getRectangle());
    assertNull(previousBead80.getRectangle());
    assertNull(previousBead81.getRectangle());
    assertNull(previousBead82.getRectangle());
    assertNull(getResult.getThread());
    assertNull(nextBead.getThread());
    assertNull(nextBead2.getThread());
    assertNull(nextBead3.getThread());
    assertNull(nextBead4.getThread());
    assertNull(nextBead5.getThread());
    assertNull(nextBead6.getThread());
    assertNull(nextBead7.getThread());
    assertNull(nextBead12.getThread());
    assertNull(nextBead17.getThread());
    assertNull(nextBead11.getThread());
    assertNull(nextBead16.getThread());
    assertNull(nextBead21.getThread());
    assertNull(nextBead25.getThread());
    assertNull(nextBead10.getThread());
    assertNull(nextBead15.getThread());
    assertNull(nextBead20.getThread());
    assertNull(nextBead28.getThread());
    assertNull(nextBead31.getThread());
    assertNull(nextBead24.getThread());
    assertNull(nextBead34.getThread());
    assertNull(nextBead37.getThread());
    assertNull(nextBead40.getThread());
    assertNull(nextBead9.getThread());
    assertNull(nextBead14.getThread());
    assertNull(nextBead19.getThread());
    assertNull(nextBead27.getThread());
    assertNull(nextBead42.getThread());
    assertNull(nextBead44.getThread());
    assertNull(nextBead46.getThread());
    assertNull(nextBead30.getThread());
    assertNull(nextBead48.getThread());
    assertNull(nextBead50.getThread());
    assertNull(nextBead52.getThread());
    assertNull(nextBead23.getThread());
    assertNull(nextBead33.getThread());
    assertNull(nextBead36.getThread());
    assertNull(nextBead54.getThread());
    assertNull(nextBead56.getThread());
    assertNull(nextBead39.getThread());
    assertNull(nextBead58.getThread());
    assertNull(nextBead60.getThread());
    assertNull(nextBead62.getThread());
    assertNull(nextBead8.getThread());
    assertNull(nextBead13.getThread());
    assertNull(nextBead18.getThread());
    assertNull(nextBead26.getThread());
    assertNull(nextBead41.getThread());
    assertNull(nextBead63.getThread());
    assertNull(nextBead64.getThread());
    assertNull(nextBead65.getThread());
    assertNull(nextBead43.getThread());
    assertNull(nextBead45.getThread());
    assertNull(nextBead66.getThread());
    assertNull(nextBead67.getThread());
    assertNull(nextBead29.getThread());
    assertNull(nextBead47.getThread());
    assertNull(nextBead49.getThread());
    assertNull(nextBead68.getThread());
    assertNull(nextBead69.getThread());
    assertNull(nextBead51.getThread());
    assertNull(nextBead70.getThread());
    assertNull(nextBead71.getThread());
    assertNull(nextBead72.getThread());
    assertNull(nextBead22.getThread());
    assertNull(nextBead32.getThread());
    assertNull(nextBead35.getThread());
    assertNull(nextBead53.getThread());
    assertNull(nextBead73.getThread());
    assertNull(nextBead74.getThread());
    assertNull(nextBead55.getThread());
    assertNull(nextBead75.getThread());
    assertNull(nextBead76.getThread());
    assertNull(nextBead77.getThread());
    assertNull(nextBead38.getThread());
    assertNull(nextBead57.getThread());
    assertNull(nextBead59.getThread());
    assertNull(nextBead78.getThread());
    assertNull(nextBead79.getThread());
    assertNull(nextBead61.getThread());
    assertNull(nextBead80.getThread());
    assertNull(nextBead81.getThread());
    assertNull(nextBead82.getThread());
    assertNull(previousBead.getThread());
    assertNull(previousBead2.getThread());
    assertNull(previousBead3.getThread());
    assertNull(previousBead5.getThread());
    assertNull(previousBead10.getThread());
    assertNull(previousBead21.getThread());
    assertNull(previousBead41.getThread());
    assertNull(previousBead42.getThread());
    assertNull(previousBead43.getThread());
    assertNull(previousBead22.getThread());
    assertNull(previousBead23.getThread());
    assertNull(previousBead44.getThread());
    assertNull(previousBead45.getThread());
    assertNull(previousBead11.getThread());
    assertNull(previousBead12.getThread());
    assertNull(previousBead24.getThread());
    assertNull(previousBead46.getThread());
    assertNull(previousBead47.getThread());
    assertNull(previousBead25.getThread());
    assertNull(previousBead48.getThread());
    assertNull(previousBead49.getThread());
    assertNull(previousBead50.getThread());
    assertNull(previousBead6.getThread());
    assertNull(previousBead13.getThread());
    assertNull(previousBead14.getThread());
    assertNull(previousBead26.getThread());
    assertNull(previousBead51.getThread());
    assertNull(previousBead52.getThread());
    assertNull(previousBead27.getThread());
    assertNull(previousBead54.getThread());
    assertNull(previousBead55.getThread());
    assertNull(previousBead56.getThread());
    assertNull(previousBead15.getThread());
    assertNull(previousBead28.getThread());
    assertNull(previousBead29.getThread());
    assertNull(previousBead57.getThread());
    assertNull(previousBead58.getThread());
    assertNull(previousBead30.getThread());
    assertNull(previousBead59.getThread());
    assertNull(previousBead60.getThread());
    assertNull(previousBead61.getThread());
    assertNull(previousBead4.getThread());
    assertNull(previousBead7.getThread());
    assertNull(previousBead8.getThread());
    assertNull(previousBead16.getThread());
    assertNull(previousBead31.getThread());
    assertNull(previousBead62.getThread());
    assertNull(previousBead63.getThread());
    assertNull(previousBead64.getThread());
    assertNull(previousBead32.getThread());
    assertNull(previousBead65.getThread());
    assertNull(previousBead66.getThread());
    assertNull(previousBead67.getThread());
    assertNull(previousBead17.getThread());
    assertNull(previousBead33.getThread());
    assertNull(previousBead34.getThread());
    assertNull(previousBead68.getThread());
    assertNull(previousBead69.getThread());
    assertNull(previousBead35.getThread());
    assertNull(previousBead70.getThread());
    assertNull(previousBead71.getThread());
    assertNull(previousBead72.getThread());
    assertNull(previousBead9.getThread());
    assertNull(previousBead18.getThread());
    assertNull(previousBead19.getThread());
    assertNull(previousBead36.getThread());
    assertNull(previousBead73.getThread());
    assertNull(previousBead74.getThread());
    assertNull(previousBead37.getThread());
    assertNull(previousBead75.getThread());
    assertNull(previousBead76.getThread());
    assertNull(previousBead77.getThread());
    assertNull(previousBead20.getThread());
    assertNull(previousBead38.getThread());
    assertNull(previousBead39.getThread());
    assertNull(previousBead78.getThread());
    assertNull(previousBead79.getThread());
    assertNull(previousBead40.getThread());
    assertNull(previousBead80.getThread());
    assertNull(previousBead81.getThread());
    assertNull(previousBead82.getThread());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertSame(cOSObject, nextBead.getCOSObject());
    assertSame(cOSObject, nextBead2.getCOSObject());
    assertSame(cOSObject, nextBead3.getCOSObject());
    assertSame(cOSObject, nextBead4.getCOSObject());
    assertSame(cOSObject, nextBead5.getCOSObject());
    assertSame(cOSObject, nextBead6.getCOSObject());
    assertSame(cOSObject, nextBead7.getCOSObject());
    assertSame(cOSObject, nextBead12.getCOSObject());
    assertSame(cOSObject, nextBead17.getCOSObject());
    assertSame(cOSObject, nextBead11.getCOSObject());
    assertSame(cOSObject, nextBead16.getCOSObject());
    assertSame(cOSObject, nextBead21.getCOSObject());
    assertSame(cOSObject, nextBead25.getCOSObject());
    assertSame(cOSObject, nextBead10.getCOSObject());
    assertSame(cOSObject, nextBead15.getCOSObject());
    assertSame(cOSObject, nextBead20.getCOSObject());
    assertSame(cOSObject, nextBead28.getCOSObject());
    assertSame(cOSObject, nextBead31.getCOSObject());
    assertSame(cOSObject, nextBead24.getCOSObject());
    assertSame(cOSObject, nextBead34.getCOSObject());
    assertSame(cOSObject, nextBead37.getCOSObject());
    assertSame(cOSObject, nextBead40.getCOSObject());
    assertSame(cOSObject, nextBead9.getCOSObject());
    assertSame(cOSObject, nextBead14.getCOSObject());
    assertSame(cOSObject, nextBead19.getCOSObject());
    assertSame(cOSObject, nextBead27.getCOSObject());
    assertSame(cOSObject, nextBead42.getCOSObject());
    assertSame(cOSObject, nextBead44.getCOSObject());
    assertSame(cOSObject, nextBead46.getCOSObject());
    assertSame(cOSObject, nextBead30.getCOSObject());
    assertSame(cOSObject, nextBead48.getCOSObject());
    assertSame(cOSObject, nextBead50.getCOSObject());
    assertSame(cOSObject, nextBead52.getCOSObject());
    assertSame(cOSObject, nextBead23.getCOSObject());
    assertSame(cOSObject, nextBead33.getCOSObject());
    assertSame(cOSObject, nextBead36.getCOSObject());
    assertSame(cOSObject, nextBead54.getCOSObject());
    assertSame(cOSObject, nextBead56.getCOSObject());
    assertSame(cOSObject, nextBead39.getCOSObject());
    assertSame(cOSObject, nextBead58.getCOSObject());
    assertSame(cOSObject, nextBead60.getCOSObject());
    assertSame(cOSObject, nextBead62.getCOSObject());
    assertSame(cOSObject, nextBead8.getCOSObject());
    assertSame(cOSObject, nextBead13.getCOSObject());
    assertSame(cOSObject, nextBead18.getCOSObject());
    assertSame(cOSObject, nextBead26.getCOSObject());
    assertSame(cOSObject, nextBead41.getCOSObject());
    assertSame(cOSObject, nextBead63.getCOSObject());
    assertSame(cOSObject, nextBead64.getCOSObject());
    assertSame(cOSObject, nextBead65.getCOSObject());
    assertSame(cOSObject, nextBead43.getCOSObject());
    assertSame(cOSObject, nextBead45.getCOSObject());
    assertSame(cOSObject, nextBead66.getCOSObject());
    assertSame(cOSObject, nextBead67.getCOSObject());
    assertSame(cOSObject, nextBead29.getCOSObject());
    assertSame(cOSObject, nextBead47.getCOSObject());
    assertSame(cOSObject, nextBead49.getCOSObject());
    assertSame(cOSObject, nextBead68.getCOSObject());
    assertSame(cOSObject, nextBead69.getCOSObject());
    assertSame(cOSObject, nextBead51.getCOSObject());
    assertSame(cOSObject, nextBead70.getCOSObject());
    assertSame(cOSObject, nextBead71.getCOSObject());
    assertSame(cOSObject, nextBead72.getCOSObject());
    assertSame(cOSObject, nextBead22.getCOSObject());
    assertSame(cOSObject, nextBead32.getCOSObject());
    assertSame(cOSObject, nextBead35.getCOSObject());
    assertSame(cOSObject, nextBead53.getCOSObject());
    assertSame(cOSObject, nextBead73.getCOSObject());
    assertSame(cOSObject, nextBead74.getCOSObject());
    assertSame(cOSObject, nextBead55.getCOSObject());
    assertSame(cOSObject, nextBead75.getCOSObject());
    assertSame(cOSObject, nextBead76.getCOSObject());
    assertSame(cOSObject, nextBead77.getCOSObject());
    assertSame(cOSObject, nextBead38.getCOSObject());
    assertSame(cOSObject, nextBead57.getCOSObject());
    assertSame(cOSObject, nextBead59.getCOSObject());
    assertSame(cOSObject, nextBead78.getCOSObject());
    assertSame(cOSObject, nextBead79.getCOSObject());
    assertSame(cOSObject, nextBead61.getCOSObject());
    assertSame(cOSObject, nextBead80.getCOSObject());
    assertSame(cOSObject, nextBead81.getCOSObject());
    assertSame(cOSObject, nextBead82.getCOSObject());
    assertSame(cOSObject, previousBead.getCOSObject());
    assertSame(cOSObject, previousBead2.getCOSObject());
    assertSame(cOSObject, previousBead3.getCOSObject());
    assertSame(cOSObject, previousBead5.getCOSObject());
    assertSame(cOSObject, previousBead10.getCOSObject());
    assertSame(cOSObject, previousBead21.getCOSObject());
    assertSame(cOSObject, previousBead41.getCOSObject());
    assertSame(cOSObject, previousBead42.getCOSObject());
    assertSame(cOSObject, previousBead43.getCOSObject());
    assertSame(cOSObject, previousBead22.getCOSObject());
    assertSame(cOSObject, previousBead23.getCOSObject());
    assertSame(cOSObject, previousBead44.getCOSObject());
    assertSame(cOSObject, previousBead45.getCOSObject());
    assertSame(cOSObject, previousBead11.getCOSObject());
    assertSame(cOSObject, previousBead12.getCOSObject());
    assertSame(cOSObject, previousBead24.getCOSObject());
    assertSame(cOSObject, previousBead46.getCOSObject());
    assertSame(cOSObject, previousBead47.getCOSObject());
    assertSame(cOSObject, previousBead25.getCOSObject());
    assertSame(cOSObject, previousBead48.getCOSObject());
    assertSame(cOSObject, previousBead49.getCOSObject());
    assertSame(cOSObject, previousBead50.getCOSObject());
    assertSame(cOSObject, previousBead6.getCOSObject());
    assertSame(cOSObject, previousBead13.getCOSObject());
    assertSame(cOSObject, previousBead14.getCOSObject());
    assertSame(cOSObject, previousBead26.getCOSObject());
    assertSame(cOSObject, previousBead51.getCOSObject());
    assertSame(cOSObject, previousBead52.getCOSObject());
    assertSame(cOSObject, previousBead53.getCOSObject());
    assertSame(cOSObject, previousBead27.getCOSObject());
    assertSame(cOSObject, previousBead54.getCOSObject());
    assertSame(cOSObject, previousBead55.getCOSObject());
    assertSame(cOSObject, previousBead56.getCOSObject());
    assertSame(cOSObject, previousBead15.getCOSObject());
    assertSame(cOSObject, previousBead28.getCOSObject());
    assertSame(cOSObject, previousBead29.getCOSObject());
    assertSame(cOSObject, previousBead57.getCOSObject());
    assertSame(cOSObject, previousBead58.getCOSObject());
    assertSame(cOSObject, previousBead30.getCOSObject());
    assertSame(cOSObject, previousBead59.getCOSObject());
    assertSame(cOSObject, previousBead60.getCOSObject());
    assertSame(cOSObject, previousBead61.getCOSObject());
    assertSame(cOSObject, previousBead4.getCOSObject());
    assertSame(cOSObject, previousBead7.getCOSObject());
    assertSame(cOSObject, previousBead8.getCOSObject());
    assertSame(cOSObject, previousBead16.getCOSObject());
    assertSame(cOSObject, previousBead31.getCOSObject());
    assertSame(cOSObject, previousBead62.getCOSObject());
    assertSame(cOSObject, previousBead63.getCOSObject());
    assertSame(cOSObject, previousBead64.getCOSObject());
    assertSame(cOSObject, previousBead32.getCOSObject());
    assertSame(cOSObject, previousBead65.getCOSObject());
    assertSame(cOSObject, previousBead66.getCOSObject());
    assertSame(cOSObject, previousBead67.getCOSObject());
    assertSame(cOSObject, previousBead17.getCOSObject());
    assertSame(cOSObject, previousBead33.getCOSObject());
    assertSame(cOSObject, previousBead34.getCOSObject());
    assertSame(cOSObject, previousBead68.getCOSObject());
    assertSame(cOSObject, previousBead69.getCOSObject());
    assertSame(cOSObject, previousBead35.getCOSObject());
    assertSame(cOSObject, previousBead70.getCOSObject());
    assertSame(cOSObject, previousBead71.getCOSObject());
    assertSame(cOSObject, previousBead72.getCOSObject());
    assertSame(cOSObject, previousBead9.getCOSObject());
    assertSame(cOSObject, previousBead18.getCOSObject());
    assertSame(cOSObject, previousBead19.getCOSObject());
    assertSame(cOSObject, previousBead36.getCOSObject());
    assertSame(cOSObject, previousBead73.getCOSObject());
    assertSame(cOSObject, previousBead74.getCOSObject());
    assertSame(cOSObject, previousBead37.getCOSObject());
    assertSame(cOSObject, previousBead75.getCOSObject());
    assertSame(cOSObject, previousBead76.getCOSObject());
    assertSame(cOSObject, previousBead77.getCOSObject());
    assertSame(cOSObject, previousBead20.getCOSObject());
    assertSame(cOSObject, previousBead38.getCOSObject());
    assertSame(cOSObject, previousBead39.getCOSObject());
    assertSame(cOSObject, previousBead78.getCOSObject());
    assertSame(cOSObject, previousBead79.getCOSObject());
    assertSame(cOSObject, previousBead40.getCOSObject());
    assertSame(cOSObject, previousBead80.getCOSObject());
    assertSame(cOSObject, previousBead81.getCOSObject());
    assertSame(cOSObject, previousBead82.getCOSObject());
  }

  /**
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  void testGetThreadBeads4() {
    // Arrange
    ArrayList<PDThreadBead> beads = new ArrayList<>();
    beads.add(null);

    PDPage pdPage = new PDPage();
    pdPage.setThreadBeads(beads);

    // Act
    List<PDThreadBead> actualThreadBeads = pdPage.getThreadBeads();

    // Assert
    assertEquals(1, actualThreadBeads.size());
    assertNull(actualThreadBeads.get(0));
  }

  /**
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  void testGetThreadBeads5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    List<PDThreadBead> actualThreadBeads = pdPage.getThreadBeads();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualThreadBeads.isEmpty());
  }

  /**
   * Method under test: {@link PDPage#setThreadBeads(List)}
   */
  @Test
  void testSetThreadBeads() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDThreadBead pdThreadBead = mock(PDThreadBead.class);
    when(pdThreadBead.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    ArrayList<PDThreadBead> beads = new ArrayList<>();
    beads.add(pdThreadBead);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setThreadBeads(beads));
    verify(pdThreadBead).getCOSObject();
  }

  /**
   * Method under test: {@link PDPage#setThreadBeads(List)}
   */
  @Test
  void testSetThreadBeads2() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage pdPage = new PDPage(pageDictionary);
    PDThreadBead pdThreadBead = mock(PDThreadBead.class);
    when(pdThreadBead.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDThreadBead> beads = new ArrayList<>();
    beads.add(pdThreadBead);

    // Act
    pdPage.setThreadBeads(beads);

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(pdThreadBead).getCOSObject();
  }

  /**
   * Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  void testGetMetadata() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getMetadata());
  }

  /**
   * Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  void testGetMetadata2() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    COSStream str = new COSStream();
    pdPage.setMetadata(new PDMetadata(str));

    // Act
    PDMetadata actualMetadata = pdPage.getMetadata();

    // Assert
    assertNull(actualMetadata.getDecodeParms());
    assertNull(actualMetadata.getFileDecodeParams());
    assertNull(actualMetadata.getMetadata());
    assertNull(actualMetadata.getFile());
    assertEquals(-1, actualMetadata.getDecodedStreamLength());
    assertEquals(0, actualMetadata.getLength());
    List<String> fileFilters = actualMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualMetadata.getCOSObject());
    assertSame(fileFilters, actualMetadata.getFilters());
  }

  /**
   * Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  void testGetMetadata3() throws IOException {
    // Arrange
    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));
    PDMetadata meta = new PDMetadata(str);

    PDPage pdPage = new PDPage();
    pdPage.setMetadata(meta);

    // Act
    PDMetadata actualMetadata = pdPage.getMetadata();

    // Assert
    assertNull(actualMetadata.getDecodeParms());
    assertNull(actualMetadata.getFileDecodeParams());
    assertNull(actualMetadata.getMetadata());
    assertNull(actualMetadata.getFile());
    assertEquals(-1, actualMetadata.getDecodedStreamLength());
    assertEquals(0, actualMetadata.getLength());
    List<String> fileFilters = actualMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualMetadata.getCOSObject());
    assertSame(fileFilters, actualMetadata.getFilters());
  }

  /**
   * Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  void testGetMetadata4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    PDMetadata actualMetadata = pdPage.getMetadata();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualMetadata);
  }

  /**
   * Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  void testSetMetadata() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDPage(pageDictionary)).setMetadata(mock(PDMetadata.class));

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDPage#getActions()}
   */
  @Test
  void testGetActions() {
    // Arrange and Act
    PDPageAdditionalActions actualActions = (new PDPage()).getActions();

    // Assert
    COSDictionary cOSObject = actualActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualActions.getC());
    assertNull(actualActions.getO());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getActions()}
   */
  @Test
  void testGetActions2() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setActions(new PDPageAdditionalActions());

    // Act
    PDPageAdditionalActions actualActions = pdPage.getActions();

    // Assert
    COSDictionary cOSObject = actualActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualActions.getC());
    assertNull(actualActions.getO());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getActions()}
   */
  @Test
  void testGetActions3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    PDPageAdditionalActions actualActions = pdPage.getActions();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = actualActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualActions.getC());
    assertNull(actualActions.getO());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDPage#setActions(PDPageAdditionalActions)}
   */
  @Test
  void testSetActions() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    pdPage.setActions(new PDPageAdditionalActions());

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDPage#getTransition()}
   */
  @Test
  void testGetTransition() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getTransition());
  }

  /**
   * Method under test: {@link PDPage#getTransition()}
   */
  @Test
  void testGetTransition2() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDTransition transition = new PDTransition();
    pdPage.setTransition(transition);

    // Act and Assert
    assertEquals(transition, pdPage.getTransition());
  }

  /**
   * Method under test: {@link PDPage#getTransition()}
   */
  @Test
  void testGetTransition3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    PDTransition actualTransition = pdPage.getTransition();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualTransition);
  }

  /**
   * Method under test: {@link PDPage#setTransition(PDTransition)}
   */
  @Test
  void testSetTransition() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDPage pdPage = new PDPage(pageDictionary);

    // Act
    pdPage.setTransition(new PDTransition());

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDPage#setTransition(PDTransition, float)}
   */
  @Test
  void testSetTransition2() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDPage pdPage = new PDPage(pageDictionary);

    // Act
    pdPage.setTransition(new PDTransition(), 10.0f);

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDPage()).getAnnotations().isEmpty());
    assertTrue((new PDPage()).getAnnotations(mock(AnnotationFilter.class)).isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations2() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(new ArrayList<>());

    // Act and Assert
    assertTrue(pdPage.getAnnotations().isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations3() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations4() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertTrue(pdPage.getAnnotations().isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations5() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret(new COSDictionary()));

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations6() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCircle());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations7() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFileAttachment());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations8() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFreeText());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations9() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationHighlight());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations10() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationInk());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations11() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationLine());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations12() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationLink());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations13() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationPolygon());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations14() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationPolyline());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations15() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationPopup());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations16() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationRubberStamp());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations17() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationSound());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  void testGetAnnotations18() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualAnnotations.isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations19() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(new ArrayList<>());

    // Act and Assert
    assertTrue(pdPage.getAnnotations(mock(AnnotationFilter.class)).isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations20() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations21() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertTrue(pdPage.getAnnotations(mock(AnnotationFilter.class)).isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations22() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret(new COSDictionary()));

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations23() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCircle());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations24() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFileAttachment());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations25() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFreeText());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations26() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(false);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertTrue(actualAnnotations.isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations27() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationHighlight());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations28() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenThrow(new IllegalArgumentException("Caret"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.getAnnotations(annotationFilter));
    verify(annotationFilter).accept(isA(PDAnnotation.class));
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations29() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationInk());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations30() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationLine());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations31() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationLink());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations32() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationPolygon());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations33() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationPolyline());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations34() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationPopup());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations35() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationRubberStamp());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations36() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationSound());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  void testGetAnnotations37() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationSquare());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(annotations, actualAnnotations);
  }

  /**
   * Method under test: {@link PDPage#setAnnotations(List)}
   */
  @Test
  void testSetAnnotations() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDAnnotation pdAnnotation = mock(PDAnnotation.class);
    when(pdAnnotation.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(pdAnnotation);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setAnnotations(annotations));
    verify(pdAnnotation).getCOSObject();
  }

  /**
   * Method under test: {@link PDPage#setAnnotations(List)}
   */
  @Test
  void testSetAnnotations2() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage pdPage = new PDPage(pageDictionary);
    PDAnnotation pdAnnotation = mock(PDAnnotation.class);
    when(pdAnnotation.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(pdAnnotation);

    // Act
    pdPage.setAnnotations(annotations);

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(pdAnnotation).getCOSObject();
  }

  /**
   * Method under test: {@link PDPage#setAnnotations(List)}
   */
  @Test
  void testSetAnnotations3() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage pdPage = new PDPage(pageDictionary);
    PDAnnotation pdAnnotation = mock(PDAnnotation.class);
    when(pdAnnotation.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);
    annotations.add(pdAnnotation);

    // Act
    pdPage.setAnnotations(annotations);

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(pdAnnotation).getCOSObject();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDPage#equals(Object)}
   *   <li>{@link PDPage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act and Assert
    assertEquals(pdPage, pdPage);
    int expectedHashCodeResult = pdPage.hashCode();
    assertEquals(expectedHashCodeResult, pdPage.hashCode());
  }

  /**
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  void testGetViewports() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getViewports());
  }

  /**
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  void testGetViewports2() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setViewports(new ArrayList<>());

    // Act and Assert
    assertTrue(pdPage.getViewports().isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  void testGetViewports3() {
    // Arrange
    ArrayList<PDViewportDictionary> viewports = new ArrayList<>();
    viewports.add(new PDViewportDictionary());

    PDPage pdPage = new PDPage();
    pdPage.setViewports(viewports);

    // Act
    List<PDViewportDictionary> actualViewports = pdPage.getViewports();

    // Assert
    assertEquals(1, actualViewports.size());
    PDViewportDictionary getResult = actualViewports.get(0);
    assertEquals("Viewport", getResult.getType());
    assertNull(getResult.getName());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getBBox());
    assertNull(getResult.getMeasure());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  void testGetViewports4() {
    // Arrange
    ArrayList<PDViewportDictionary> viewports = new ArrayList<>();
    viewports.add(null);

    PDPage pdPage = new PDPage();
    pdPage.setViewports(viewports);

    // Act and Assert
    assertTrue(pdPage.getViewports().isEmpty());
  }

  /**
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  void testGetViewports5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    List<PDViewportDictionary> actualViewports = pdPage.getViewports();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualViewports);
  }

  /**
   * Method under test: {@link PDPage#setViewports(List)}
   */
  @Test
  void testSetViewports() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDViewportDictionary pdViewportDictionary = mock(PDViewportDictionary.class);
    when(pdViewportDictionary.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    ArrayList<PDViewportDictionary> viewports = new ArrayList<>();
    viewports.add(pdViewportDictionary);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setViewports(viewports));
    verify(pdViewportDictionary).getCOSObject();
  }

  /**
   * Method under test: {@link PDPage#setViewports(List)}
   */
  @Test
  void testSetViewports2() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage pdPage = new PDPage(pageDictionary);
    PDViewportDictionary pdViewportDictionary = mock(PDViewportDictionary.class);
    when(pdViewportDictionary.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDViewportDictionary> viewports = new ArrayList<>();
    viewports.add(pdViewportDictionary);

    // Act
    pdPage.setViewports(viewports);

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(pdViewportDictionary).getCOSObject();
  }

  /**
   * Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  void testGetUserUnit() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDPage()).getUserUnit());
  }

  /**
   * Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  void testGetUserUnit2() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setUserUnit(1.0f);

    // Act and Assert
    assertEquals(1.0f, pdPage.getUserUnit());
  }

  /**
   * Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  void testGetUserUnit3() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setUserUnit(Float.NaN);

    // Act and Assert
    assertEquals(1.0f, pdPage.getUserUnit());
  }

  /**
   * Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  void testGetUserUnit4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    float actualUserUnit = pdPage.getUserUnit();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1.0f, actualUserUnit);
  }

  /**
   * Method under test: {@link PDPage#setUserUnit(float)}
   */
  @Test
  void testSetUserUnit() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDPage()).setUserUnit(0.0f));
  }

  /**
   * Method under test: {@link PDPage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act and Assert
    assertNotEquals(pdPage, new PDPage());
  }

  /**
   * Method under test: {@link PDPage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PDPage pdPage = new PDPage(mock(COSDictionary.class));

    // Act and Assert
    assertNotEquals(pdPage, new PDPage());
  }

  /**
   * Method under test: {@link PDPage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDPage(), null);
  }

  /**
   * Method under test: {@link PDPage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDPage(), "Different type to PDPage");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDPage#PDPage(COSDictionary)}
   *   <li>{@link PDPage#getResourceCache()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary pageDictionary = new COSDictionary();

    // Act
    PDPage actualPdPage = new PDPage(pageDictionary);

    // Assert
    assertNull(actualPdPage.getResourceCache());
    assertSame(pageDictionary, actualPdPage.getCOSObject());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDPage#PDPage(COSDictionary, ResourceCache)}
   *   <li>{@link PDPage#getResourceCache()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    COSDictionary pageDictionary = new COSDictionary();
    DefaultResourceCache resourceCache = new DefaultResourceCache();

    // Act
    PDPage actualPdPage = new PDPage(pageDictionary, resourceCache);
    ResourceCache actualResourceCache = actualPdPage.getResourceCache();

    // Assert
    assertTrue(actualResourceCache instanceof DefaultResourceCache);
    assertSame(pageDictionary, actualPdPage.getCOSObject());
    assertSame(resourceCache, actualResourceCache);
  }

  /**
   * Method under test: {@link PDPage#PDPage(PDRectangle)}
   */
  @Test
  void testNewPDPage() throws IOException {
    // Arrange and Act
    PDPage actualPdPage = new PDPage((PDRectangle) null);

    // Assert
    PDRectangle artBox = actualPdPage.getArtBox();
    COSArray cOSArray = artBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    RandomAccessRead contentsForRandomAccess = actualPdPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = actualPdPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertTrue(artBox instanceof PDImmutableRectangle);
    assertNull(actualPdPage.getViewports());
    COSDictionary cOSObject = actualPdPage.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDPageAdditionalActions actions = actualPdPage.getActions();
    COSDictionary cOSObject2 = actions.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(actualPdPage.getResources());
    assertNull(actualPdPage.getResourceCache());
    assertNull(actualPdPage.getMetadata());
    assertNull(actualPdPage.getTrimBox());
    assertNull(actions.getC());
    assertNull(actions.getO());
    assertNull(actualPdPage.getTransition());
    assertEquals(-1, actualPdPage.getContents().read(new byte[]{}));
    assertEquals(-1, actualPdPage.getStructParents());
    assertEquals(0, cOSObject2.size());
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForStreamParsing.available());
    assertEquals(0, actualPdPage.getRotation());
    assertEquals(0.0f, artBox.getLowerLeftX());
    assertEquals(0.0f, artBox.getLowerLeftY());
    Matrix matrix = actualPdPage.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(1.0f, actualPdPage.getUserUnit());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(612.0f, artBox.getUpperRightX());
    assertEquals(612.0f, artBox.getWidth());
    assertEquals(792.0f, artBox.getHeight());
    assertEquals(792.0f, artBox.getUpperRightY());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualPdPage.getContentStreams().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(actualPdPage.hasContents());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(actualPdPage.getAnnotations().isEmpty());
    assertTrue(actualPdPage.getThreadBeads().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, artBox.getCOSObject());
    assertSame(artBox, actualPdPage.getBBox());
    assertSame(artBox, actualPdPage.getBleedBox());
    assertSame(artBox, actualPdPage.getCropBox());
    assertSame(artBox, actualPdPage.getMediaBox());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDPage#PDPage(PDRectangle)}
   */
  @Test
  void testNewPDPage2() throws IOException {
    // Arrange and Act
    PDPage actualPdPage = new PDPage(new PDRectangle());

    // Assert
    PDRectangle artBox = actualPdPage.getArtBox();
    COSArray cOSArray = artBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    RandomAccessRead contentsForRandomAccess = actualPdPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = actualPdPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertNull(actualPdPage.getViewports());
    COSDictionary cOSObject = actualPdPage.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDPageAdditionalActions actions = actualPdPage.getActions();
    COSDictionary cOSObject2 = actions.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(actualPdPage.getResources());
    assertNull(actualPdPage.getResourceCache());
    assertNull(actualPdPage.getMetadata());
    assertNull(actualPdPage.getTrimBox());
    assertNull(actions.getC());
    assertNull(actions.getO());
    assertNull(actualPdPage.getTransition());
    assertEquals(-1, actualPdPage.getContents().read(new byte[]{}));
    assertEquals(-1, actualPdPage.getStructParents());
    assertEquals(0, cOSObject2.size());
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForStreamParsing.available());
    assertEquals(0, actualPdPage.getRotation());
    assertEquals(0.0f, artBox.getHeight());
    assertEquals(0.0f, artBox.getLowerLeftX());
    assertEquals(0.0f, artBox.getLowerLeftY());
    assertEquals(0.0f, artBox.getUpperRightX());
    assertEquals(0.0f, artBox.getUpperRightY());
    assertEquals(0.0f, artBox.getWidth());
    Matrix matrix = actualPdPage.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(1.0f, actualPdPage.getUserUnit());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualPdPage.getContentStreams().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(actualPdPage.hasContents());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(actualPdPage.getAnnotations().isEmpty());
    assertTrue(actualPdPage.getThreadBeads().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(artBox, actualPdPage.getBBox());
    assertSame(artBox, actualPdPage.getBleedBox());
    assertSame(artBox, actualPdPage.getCropBox());
    assertSame(artBox, actualPdPage.getMediaBox());
    assertSame(cOSArray, artBox.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
