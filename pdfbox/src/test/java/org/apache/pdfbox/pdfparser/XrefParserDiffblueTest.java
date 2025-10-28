package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class XrefParserDiffblueTest {
  /**
   * Method under test: {@link XrefParser#getXrefTable()}
   */
  @Test
  void testGetXrefTable() throws IOException {
    // Arrange, Act and Assert
    assertNull((new XrefParser(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
            .getXrefTable());
  }

  /**
   * Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  void testParseXref() throws IOException {
    // Arrange
    XrefParser xrefParser = new XrefParser(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  void testParseXref2() throws IOException {
    // Arrange
    XrefParser xrefParser = new XrefParser(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("\tXAXAXAX".getBytes("UTF-8")))));
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  void testParseXref3() throws IOException {
    // Arrange
    XrefParser xrefParser = new XrefParser(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AsAXAXAX".getBytes("UTF-8")))));
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  void testParseXref4() throws IOException {
    // Arrange
    XrefParser xrefParser = new XrefParser(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))));
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  void testParseXref5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    XrefParser xrefParser = new XrefParser(
        new COSParser(source, "iloveyou", new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}),
            "Did not found XRef object at specified startxref position {}", streamCacheCreateFunction));
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link XrefParser#XrefParser(COSParser)}
   */
  @Test
  void testNewXrefParser() throws IOException {
    // Arrange, Act and Assert
    assertNull((new XrefParser(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
            .getXrefTable());
  }
}
