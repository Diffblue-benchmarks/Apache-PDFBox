package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFObjectStreamParserDiffblueTest {
  /**
   * Method under test: {@link PDFObjectStreamParser#parseObject(long)}
   */
  @Test
  void testParseObject() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    PDFObjectStreamParser pdfObjectStreamParser = new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    COSBase actualParseObjectResult = pdfObjectStreamParser.parseObject(1L);

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualParseObjectResult);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFObjectStreamParser#parseObject(long)}
   */
  @Test
  void testParseObject2() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(0);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    PDFObjectStreamParser pdfObjectStreamParser = new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    COSBase actualParseObjectResult = pdfObjectStreamParser.parseObject(1L);

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualParseObjectResult);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFObjectStreamParser#parseObject(long)}
   */
  @Test
  void testParseObject3() throws IOException {
    // Arrange
    RandomAccessRead randomAccessRead = mock(RandomAccessRead.class);
    when(randomAccessRead.getPosition()).thenReturn(1L);
    doNothing().when(randomAccessRead).close();
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView()).thenReturn(randomAccessRead);
    PDFObjectStreamParser pdfObjectStreamParser = new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    COSBase actualParseObjectResult = pdfObjectStreamParser.parseObject(1L);

    // Assert
    verify(randomAccessRead).close();
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    verify(randomAccessRead, atLeast(1)).getPosition();
    assertNull(actualParseObjectResult);
    assertNull(pdfObjectStreamParser.document);
  }

  /**
   * Method under test:
   * {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}
   */
  @Test
  void testNewPDFObjectStreamParser() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    PDFObjectStreamParser actualPdfObjectStreamParser = new PDFObjectStreamParser(stream, new COSDocument());

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = actualPdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualPdfObjectStreamParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertEquals(0L, cosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, cosDocument.getStartXref());
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1.4f, cosDocument.getVersion());
    assertEquals(8, randomAccessRead.available());
    assertFalse(cosDocument.isDirect());
    assertFalse(cosDocument.hasHybridXRef());
    assertFalse(cosDocument.isClosed());
    assertFalse(cosDocument.isDecrypted());
    assertFalse(cosDocument.isEncrypted());
    assertFalse(cosDocument.isXRefStream());
    assertFalse(cosDocument.getDocumentState().isAcceptingUpdates());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfObjectStreamParser.isDigit());
    assertFalse(actualPdfObjectStreamParser.isEOF());
    assertFalse(actualPdfObjectStreamParser.isSpace());
    assertFalse(actualPdfObjectStreamParser.isWhitespace());
    assertTrue(cosDocument.getXrefTable().isEmpty());
  }

  /**
   * Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  void testParseAllObjects() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    PDFObjectStreamParser pdfObjectStreamParser = new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<COSObjectKey, COSBase> actualParseAllObjectsResult = pdfObjectStreamParser.parseAllObjects();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualParseAllObjectsResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  void testParseAllObjects2() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(0);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    PDFObjectStreamParser pdfObjectStreamParser = new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<COSObjectKey, COSBase> actualParseAllObjectsResult = pdfObjectStreamParser.parseAllObjects();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualParseAllObjectsResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  void testParseAllObjects3() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView()).thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{})));
    PDFObjectStreamParser pdfObjectStreamParser = new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<COSObjectKey, COSBase> actualParseAllObjectsResult = pdfObjectStreamParser.parseAllObjects();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualParseAllObjectsResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  void testParseAllObjects4() throws IOException {
    // Arrange
    RandomAccessRead randomAccessRead = mock(RandomAccessRead.class);
    when(randomAccessRead.getPosition()).thenReturn(1L);
    doNothing().when(randomAccessRead).close();
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView()).thenReturn(randomAccessRead);
    PDFObjectStreamParser pdfObjectStreamParser = new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<COSObjectKey, COSBase> actualParseAllObjectsResult = pdfObjectStreamParser.parseAllObjects();

    // Assert
    verify(randomAccessRead).close();
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    verify(randomAccessRead, atLeast(1)).getPosition();
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualParseAllObjectsResult.isEmpty());
  }

  /**
   * Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  void testParseAllObjects5() throws IOException {
    // Arrange
    RandomAccessRead randomAccessRead = mock(RandomAccessRead.class);
    when(randomAccessRead.getPosition()).thenReturn(0L);
    doNothing().when(randomAccessRead).close();
    doNothing().when(randomAccessRead).skip(anyInt());
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView()).thenReturn(randomAccessRead);
    PDFObjectStreamParser pdfObjectStreamParser = new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<COSObjectKey, COSBase> actualParseAllObjectsResult = pdfObjectStreamParser.parseAllObjects();

    // Assert
    verify(randomAccessRead).close();
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    verify(randomAccessRead, atLeast(1)).getPosition();
    verify(randomAccessRead).skip(eq(1));
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualParseAllObjectsResult.isEmpty());
  }

  /**
   * Method under test: {@link PDFObjectStreamParser#readObjectNumbers()}
   */
  @Test
  void testReadObjectNumbers() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    PDFObjectStreamParser pdfObjectStreamParser = new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<Long, Integer> actualReadObjectNumbersResult = pdfObjectStreamParser.readObjectNumbers();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualReadObjectNumbersResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFObjectStreamParser#readObjectNumbers()}
   */
  @Test
  void testReadObjectNumbers2() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(0);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    PDFObjectStreamParser pdfObjectStreamParser = new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<Long, Integer> actualReadObjectNumbersResult = pdfObjectStreamParser.readObjectNumbers();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualReadObjectNumbersResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test:
   * {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}
   */
  @Test
  void testNewPDFObjectStreamParser2() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(-1);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFObjectStreamParser(stream, new COSDocument()));

    verify(stream).getInt(isA(COSName.class));
    verify(stream).createView();
  }

  /**
   * Method under test:
   * {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}
   */
  @Test
  void testNewPDFObjectStreamParser3() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(Integer.MIN_VALUE);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFObjectStreamParser(stream, new COSDocument()));

    verify(stream).getInt(isA(COSName.class));
    verify(stream).createView();
  }
}
