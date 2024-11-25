package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Document;

class FDFDocumentDiffblueTest {
  /**
   * Test {@link FDFDocument#FDFDocument(Document)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#FDFDocument(Document)}
   */
  @Test
  @DisplayName("Test new FDFDocument(Document); given IIOMetadataNode(String) with 'foo'; then throw IOException")
  void testNewFDFDocument_givenIIOMetadataNodeWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    Document doc = mock(Document.class);
    when(doc.getDocumentElement()).thenReturn(new IIOMetadataNode("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> new FDFDocument(doc));
    verify(doc).getDocumentElement();
  }

  /**
   * Test {@link FDFDocument#FDFDocument(COSDocument, RandomAccessRead)}.
   * <ul>
   *   <li>When {@link COSDocument#COSDocument()}.</li>
   *   <li>Then return Document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFDocument#FDFDocument(COSDocument, RandomAccessRead)}
   */
  @Test
  @DisplayName("Test new FDFDocument(COSDocument, RandomAccessRead); when COSDocument(); then return Document is COSDocument()")
  void testNewFDFDocument_whenCOSDocument_thenReturnDocumentIsCOSDocument() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();

    // Act and Assert
    assertSame(doc,
        (new FDFDocument(doc, new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getDocument());
  }

  /**
   * Test {@link FDFDocument#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.</li>
   *   <li>When {@link StringWriter#StringWriter()}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFDocument(); when StringWriter(); then StringWriter() toString is a string")
  void testWriteXML_givenFDFDocument_whenStringWriter_thenStringWriterToStringIsAString() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    StringWriter output = new StringWriter();

    // Act
    fdfDocument.writeXML(output);

    // Assert
    assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n" + "</xfdf>\n", output.toString());
  }

  /**
   * Test {@link FDFDocument#getCatalog()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#getCatalog()}
   */
  @Test
  @DisplayName("Test getCatalog(); given COSDictionary getCOSDictionary(COSName) return 'null'; then calls setItem(COSName, COSObjectable)")
  void testGetCatalog_givenCOSDictionaryGetCOSDictionaryReturnNull_thenCallsSetItem() throws IOException {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    FDFCatalog actualCatalog = (new FDFDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})))).getCatalog();

    // Assert
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    verify(doc).getDocumentState();
    verify(doc, atLeast(1)).getTrailer();
    COSDictionary cOSObject = actualCatalog.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualCatalog.getFDF().getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFDocument#getCatalog()}.
   * <ul>
   *   <li>Given {@link COSDocument} {@link COSDocument#getTrailer()} return
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#getCatalog()}
   */
  @Test
  @DisplayName("Test getCatalog(); given COSDocument getTrailer() return COSDictionary()")
  void testGetCatalog_givenCOSDocumentGetTrailerReturnCOSDictionary() throws IOException {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    FDFCatalog actualCatalog = (new FDFDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})))).getCatalog();

    // Assert
    verify(doc).getDocumentState();
    verify(doc, atLeast(1)).getTrailer();
    COSDictionary cOSObject = actualCatalog.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualCatalog.getFDF().getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFDocument#getCatalog()}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#getCatalog()}
   */
  @Test
  @DisplayName("Test getCatalog(); then return COSObject is COSDictionary()")
  void testGetCatalog_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSDictionary cosDictionary2 = new COSDictionary();
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    FDFCatalog actualCatalog = (new FDFDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})))).getCatalog();

    // Assert
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    COSDictionary cOSObject = actualCatalog.getFDF().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(cosDictionary2, actualCatalog.getCOSObject());
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   * <ul>
   *   <li>Then array length is eighty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'OutputStream'; then array length is eighty-five")
  void testSaveWithOutputStream_thenArrayLengthIsEightyFive() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());
    FDFDocument fdfDocument = new FDFDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    fdfDocument.save(output);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(85, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[60]);
    assertEquals('%', toByteArrayResult[79]);
    assertEquals('%', toByteArrayResult[80]);
    assertEquals('1', toByteArrayResult[61]);
    assertEquals('1', toByteArrayResult[76]);
    assertEquals('5', toByteArrayResult[77]);
    assertEquals('>', toByteArrayResult[63]);
    assertEquals('>', toByteArrayResult[Double.SIZE]);
    assertEquals('E', toByteArrayResult[81]);
    assertEquals('F', toByteArrayResult[83]);
    assertEquals('O', toByteArrayResult[82]);
    assertEquals('\n', toByteArrayResult[62]);
    assertEquals('\n', toByteArrayResult[65]);
    assertEquals('\n', toByteArrayResult[75]);
    assertEquals('\n', toByteArrayResult[78]);
    assertEquals('\n', toByteArrayResult[84]);
    assertEquals('a', toByteArrayResult[68]);
    assertEquals('e', toByteArrayResult[73]);
    assertEquals('f', toByteArrayResult[74]);
    assertEquals('r', toByteArrayResult[69]);
    assertEquals('r', toByteArrayResult[72]);
    assertEquals('s', toByteArrayResult[66]);
    assertEquals('t', toByteArrayResult[67]);
    assertEquals('t', toByteArrayResult[70]);
    assertEquals('x', toByteArrayResult[71]);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   * <ul>
   *   <li>Then {@link FDFDocument#FDFDocument()} Catalog COSObject Key StreamIndex
   * is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'OutputStream'; then FDFDocument() Catalog COSObject Key StreamIndex is minus one")
  void testSaveWithOutputStream_thenFDFDocumentCatalogCOSObjectKeyStreamIndexIsMinusOne() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    fdfDocument.save(output);

    // Assert
    COSObjectKey key = fdfDocument.getCatalog().getCOSObject().getKey();
    assertEquals(-1, key.getStreamIndex());
    assertEquals(0, key.getGeneration());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(138, toByteArrayResult.length);
    assertEquals(1L, key.getNumber());
    assertEquals(65536L, key.getInternalHash());
    assertEquals(' ', toByteArrayResult[113]);
    assertEquals('%', toByteArrayResult[132]);
    assertEquals('%', toByteArrayResult[133]);
    assertEquals('2', toByteArrayResult[114]);
    assertEquals('2', toByteArrayResult[7]);
    assertEquals('3', toByteArrayResult[129]);
    assertEquals('6', toByteArrayResult[130]);
    assertEquals('>', toByteArrayResult[116]);
    assertEquals('>', toByteArrayResult[117]);
    assertEquals('E', toByteArrayResult[134]);
    assertEquals('F', toByteArrayResult[136]);
    assertEquals('O', toByteArrayResult[135]);
    assertEquals('\n', toByteArrayResult[115]);
    assertEquals('\n', toByteArrayResult[118]);
    assertEquals('\n', toByteArrayResult[128]);
    assertEquals('\n', toByteArrayResult[131]);
    assertEquals('\n', toByteArrayResult[137]);
    assertEquals('a', toByteArrayResult[121]);
    assertEquals('e', toByteArrayResult[126]);
    assertEquals('f', toByteArrayResult[Float.MAX_EXPONENT]);
    assertEquals('r', toByteArrayResult[122]);
    assertEquals('r', toByteArrayResult[125]);
    assertEquals('s', toByteArrayResult[119]);
    assertEquals('t', toByteArrayResult[120]);
    assertEquals('t', toByteArrayResult[123]);
    assertEquals('x', toByteArrayResult[124]);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   * <ul>
   *   <li>When {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'OutputStream'; when ByteArrayOutputStream(int) with three")
  void testSaveWithOutputStream_whenByteArrayOutputStreamWithThree() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(3);

    // Act
    fdfDocument.save(output);

    // Assert
    COSObjectKey key = fdfDocument.getCatalog().getCOSObject().getKey();
    assertEquals(-1, key.getStreamIndex());
    assertEquals(0, key.getGeneration());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(138, toByteArrayResult.length);
    assertEquals(1L, key.getNumber());
    assertEquals(65536L, key.getInternalHash());
    assertEquals(' ', toByteArrayResult[113]);
    assertEquals('%', toByteArrayResult[132]);
    assertEquals('%', toByteArrayResult[133]);
    assertEquals('2', toByteArrayResult[114]);
    assertEquals('2', toByteArrayResult[7]);
    assertEquals('3', toByteArrayResult[129]);
    assertEquals('6', toByteArrayResult[130]);
    assertEquals('>', toByteArrayResult[116]);
    assertEquals('>', toByteArrayResult[117]);
    assertEquals('E', toByteArrayResult[134]);
    assertEquals('F', toByteArrayResult[136]);
    assertEquals('O', toByteArrayResult[135]);
    assertEquals('\n', toByteArrayResult[115]);
    assertEquals('\n', toByteArrayResult[118]);
    assertEquals('\n', toByteArrayResult[128]);
    assertEquals('\n', toByteArrayResult[131]);
    assertEquals('\n', toByteArrayResult[137]);
    assertEquals('a', toByteArrayResult[121]);
    assertEquals('e', toByteArrayResult[126]);
    assertEquals('f', toByteArrayResult[Float.MAX_EXPONENT]);
    assertEquals('r', toByteArrayResult[122]);
    assertEquals('r', toByteArrayResult[125]);
    assertEquals('s', toByteArrayResult[119]);
    assertEquals('t', toByteArrayResult[120]);
    assertEquals('t', toByteArrayResult[123]);
    assertEquals('x', toByteArrayResult[124]);
  }

  /**
   * Test {@link FDFDocument#saveXFDF(Writer)} with {@code Writer}.
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#saveXFDF(Writer)}
   */
  @Test
  @DisplayName("Test saveXFDF(Writer) with 'Writer'; given FDFDocument(); then StringWriter() toString is a string")
  void testSaveXFDFWithWriter_givenFDFDocument_thenStringWriterToStringIsAString() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    StringWriter output = new StringWriter();

    // Act
    fdfDocument.saveXFDF(output);

    // Assert
    assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n" + "</xfdf>\n", output.toString());
  }

  /**
   * Test {@link FDFDocument#close()}.
   * <p>
   * Method under test: {@link FDFDocument#close()}
   */
  @Test
  @DisplayName("Test close()")
  void testClose() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    FDFDocument fdfDocument = new FDFDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    // Act
    fdfDocument.close();

    // Assert
    assertTrue(fdfDocument.getDocument().isClosed());
  }

  /**
   * Test {@link FDFDocument#close()}.
   * <p>
   * Method under test: {@link FDFDocument#close()}
   */
  @Test
  @DisplayName("Test close()")
  void testClose2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    COSDocument doc = new COSDocument(streamCacheCreateFunction);
    FDFDocument fdfDocument = new FDFDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    // Act
    fdfDocument.close();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(fdfDocument.getDocument().isClosed());
  }

  /**
   * Test {@link FDFDocument#close()}.
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.</li>
   *   <li>Then {@link FDFDocument#FDFDocument()} Document Closed.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given FDFDocument(); then FDFDocument() Document Closed")
  void testClose_givenFDFDocument_thenFDFDocumentDocumentClosed() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    // Act
    fdfDocument.close();

    // Assert
    assertTrue(fdfDocument.getDocument().isClosed());
  }
}
