package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class XrefParserDiffblueTest {
  /**
   * Test {@link XrefParser#XrefParser(COSParser)}.
   * <p>
   * Method under test: {@link XrefParser#XrefParser(COSParser)}
   */
  @Test
  @DisplayName("Test new XrefParser(COSParser)")
  void testNewXrefParser() throws IOException {
    // Arrange, Act and Assert
    assertNull((new XrefParser(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
        .getXrefTable());
  }

  /**
   * Test {@link XrefParser#getXrefTable()}.
   * <p>
   * Method under test: {@link XrefParser#getXrefTable()}
   */
  @Test
  @DisplayName("Test getXrefTable()")
  void testGetXrefTable() throws IOException {
    // Arrange, Act and Assert
    assertNull((new XrefParser(
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
        .getXrefTable());
  }

  /**
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AsAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName("Test parseXref(COSDocument, long); given ByteArrayInputStream(byte[]) with 'AsAXAXAX' Bytes is 'UTF-8'")
  void testParseXref_givenByteArrayInputStreamWithAsAXAXAXBytesIsUtf8() throws IOException {
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
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName("Test parseXref(COSDocument, long); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testParseXref_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
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
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName("Test parseXref(COSDocument, long); given ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseXref_givenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
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
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName("Test parseXref(COSDocument, long); given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  void testParseXref_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf8() throws IOException {
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
}
