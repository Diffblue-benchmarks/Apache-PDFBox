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
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Document;

class FDFDocumentDiffblueTest {
  /**
   * Method under test: {@link FDFDocument#writeXML(Writer)}
   */
  @Test
  void testWriteXML() throws IOException {
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
   * Method under test: {@link FDFDocument#getCatalog()}
   */
  @Test
  void testGetCatalog() throws IOException {
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
    FDFDictionary fDF = actualCatalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    assertNull(actualCatalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getFields());
    assertNull(fDF.getPages());
    assertNull(fDF.getID());
    COSDictionary cOSObject = actualCatalog.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualCatalog.getSignature());
    assertEquals(0, cOSObject2.size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDocument#getCatalog()}
   */
  @Test
  void testGetCatalog2() throws IOException {
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
    FDFDictionary fDF = actualCatalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    assertNull(actualCatalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getFields());
    assertNull(fDF.getPages());
    assertNull(fDF.getID());
    COSDictionary cOSObject = fDF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualCatalog.getSignature());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(cosDictionary2, actualCatalog.getCOSObject());
  }

  /**
   * Method under test: {@link FDFDocument#getCatalog()}
   */
  @Test
  void testGetCatalog3() throws IOException {
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
    FDFDictionary fDF = actualCatalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    assertNull(actualCatalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getFields());
    assertNull(fDF.getPages());
    assertNull(fDF.getID());
    COSDictionary cOSObject = actualCatalog.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualCatalog.getSignature());
    assertEquals(0, cOSObject2.size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  void testSave() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    fdfDocument.save(output);

    // Assert
    COSObjectKey key = fdfDocument.getCatalog().getCOSObject().getKey();
    assertEquals(-1, key.getStreamIndex());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -10, toByteArrayResult[10]);
    assertEquals((byte) -28, toByteArrayResult[11]);
    assertEquals((byte) -33, toByteArrayResult[13]);
    assertEquals((byte) -4, toByteArrayResult[12]);
    assertEquals(0, key.getGeneration());
    assertEquals(138, toByteArrayResult.length);
    assertEquals(1L, key.getNumber());
    COSDictionary trailer = fdfDocument.getDocument().getTrailer();
    assertEquals(2, trailer.getValues().size());
    assertEquals(2, trailer.size());
    assertEquals(65536L, key.getInternalHash());
    assertEquals(' ', toByteArrayResult[113]);
    assertEquals(' ', toByteArrayResult[18]);
    assertEquals(' ', toByteArrayResult[Short.SIZE]);
    assertEquals('%', toByteArrayResult[0]);
    assertEquals('%', toByteArrayResult[132]);
    assertEquals('%', toByteArrayResult[133]);
    assertEquals('%', toByteArrayResult[9]);
    assertEquals('-', toByteArrayResult[4]);
    assertEquals('.', toByteArrayResult[6]);
    assertEquals('0', toByteArrayResult[17]);
    assertEquals('1', toByteArrayResult[15]);
    assertEquals('1', toByteArrayResult[5]);
    assertEquals('2', toByteArrayResult[114]);
    assertEquals('2', toByteArrayResult[7]);
    assertEquals('3', toByteArrayResult[129]);
    assertEquals('6', toByteArrayResult[130]);
    assertEquals('<', toByteArrayResult[23]);
    assertEquals('<', toByteArrayResult[24]);
    assertEquals('>', toByteArrayResult[116]);
    assertEquals('>', toByteArrayResult[117]);
    assertEquals('D', toByteArrayResult[2]);
    assertEquals('E', toByteArrayResult[134]);
    assertEquals('F', toByteArrayResult[1]);
    assertEquals('F', toByteArrayResult[136]);
    assertEquals('F', toByteArrayResult[3]);
    assertEquals('O', toByteArrayResult[135]);
    assertEquals('\n', toByteArrayResult[115]);
    assertEquals('\n', toByteArrayResult[118]);
    assertEquals('\n', toByteArrayResult[128]);
    assertEquals('\n', toByteArrayResult[131]);
    assertEquals('\n', toByteArrayResult[137]);
    assertEquals('\n', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[22]);
    assertEquals('\n', toByteArrayResult[8]);
    assertEquals('a', toByteArrayResult[121]);
    assertEquals('b', toByteArrayResult[20]);
    assertEquals('e', toByteArrayResult[126]);
    assertEquals('f', toByteArrayResult[Float.MAX_EXPONENT]);
    assertEquals('j', toByteArrayResult[21]);
    assertEquals('o', toByteArrayResult[19]);
    assertEquals('r', toByteArrayResult[122]);
    assertEquals('r', toByteArrayResult[125]);
    assertEquals('s', toByteArrayResult[119]);
    assertEquals('t', toByteArrayResult[120]);
    assertEquals('t', toByteArrayResult[123]);
    assertEquals('x', toByteArrayResult[124]);
  }

  /**
   * Method under test: {@link FDFDocument#saveXFDF(Writer)}
   */
  @Test
  void testSaveXFDF() throws IOException {
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
   * Method under test: {@link FDFDocument#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    // Act
    fdfDocument.close();

    // Assert
    assertTrue(fdfDocument.getDocument().isClosed());
  }

  /**
   * Method under test: {@link FDFDocument#close()}
   */
  @Test
  void testClose2() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    FDFDocument fdfDocument = new FDFDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    // Act
    fdfDocument.close();

    // Assert
    COSDocument document = fdfDocument.getDocument();
    assertTrue(document.isClosed());
    assertSame(doc, document);
  }

  /**
   * Method under test:
   * {@link FDFDocument#FDFDocument(COSDocument, RandomAccessRead)}
   */
  @Test
  void testNewFDFDocument() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();

    // Act and Assert
    assertSame(doc,
        (new FDFDocument(doc, new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getDocument());
  }

  /**
   * Method under test:
   * {@link FDFDocument#FDFDocument(COSDocument, RandomAccessRead)}
   */
  @Test
  void testNewFDFDocument2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument doc = new COSDocument(streamCacheCreateFunction);

    // Act
    FDFDocument actualFdfDocument = new FDFDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(doc, actualFdfDocument.getDocument());
  }

  /**
   * Method under test: {@link FDFDocument#FDFDocument(Document)}
   */
  @Test
  void testNewFDFDocument3() throws IOException {
    // Arrange
    Document doc = mock(Document.class);
    when(doc.getDocumentElement()).thenReturn(new IIOMetadataNode("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> new FDFDocument(doc));
    verify(doc).getDocumentElement();
  }
}
