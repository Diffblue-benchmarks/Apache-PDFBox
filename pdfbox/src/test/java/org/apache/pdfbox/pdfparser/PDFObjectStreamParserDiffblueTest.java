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
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFObjectStreamParserDiffblueTest {
  /**
   * Test
   * {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}.
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.</li>
   *   <li>When {@link COSStream} {@link COSDictionary#getInt(COSName)} return
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}
   */
  @Test
  @DisplayName("Test new PDFObjectStreamParser(COSStream, COSDocument); given MIN_VALUE; when COSStream getInt(COSName) return MIN_VALUE")
  void testNewPDFObjectStreamParser_givenMin_value_whenCOSStreamGetIntReturnMin_value() throws IOException {
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

  /**
   * Test
   * {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>When {@link COSStream} {@link COSDictionary#getInt(COSName)} return minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}
   */
  @Test
  @DisplayName("Test new PDFObjectStreamParser(COSStream, COSDocument); given minus one; when COSStream getInt(COSName) return minus one")
  void testNewPDFObjectStreamParser_givenMinusOne_whenCOSStreamGetIntReturnMinusOne() throws IOException {
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
   * Test
   * {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then {@link BaseParser#source} return
   * {@link RandomAccessReadBuffer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}
   */
  @Test
  @DisplayName("Test new PDFObjectStreamParser(COSStream, COSDocument); given one; then source return RandomAccessReadBuffer")
  void testNewPDFObjectStreamParser_givenOne_thenSourceReturnRandomAccessReadBuffer() throws IOException {
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
   * Test {@link PDFObjectStreamParser#parseObject(long)}.
   * <p>
   * Method under test: {@link PDFObjectStreamParser#parseObject(long)}
   */
  @Test
  @DisplayName("Test parseObject(long)")
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
   * Test {@link PDFObjectStreamParser#parseObject(long)}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSDictionary#getInt(COSName)} return
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFObjectStreamParser#parseObject(long)}
   */
  @Test
  @DisplayName("Test parseObject(long); given COSStream getInt(COSName) return zero")
  void testParseObject_givenCOSStreamGetIntReturnZero() throws IOException {
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
   * Test {@link PDFObjectStreamParser#parseObject(long)}.
   * <ul>
   *   <li>Given {@link RandomAccessRead} {@link RandomAccessRead#getPosition()}
   * return one.</li>
   *   <li>Then calls {@link Closeable#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFObjectStreamParser#parseObject(long)}
   */
  @Test
  @DisplayName("Test parseObject(long); given RandomAccessRead getPosition() return one; then calls close()")
  void testParseObject_givenRandomAccessReadGetPositionReturnOne_thenCallsClose() throws IOException {
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
   * Test {@link PDFObjectStreamParser#parseAllObjects()}.
   * <p>
   * Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  @DisplayName("Test parseAllObjects()")
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
   * Test {@link PDFObjectStreamParser#parseAllObjects()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  @DisplayName("Test parseAllObjects(); given ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseAllObjects_givenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
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
   * Test {@link PDFObjectStreamParser#parseAllObjects()}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSDictionary#getInt(COSName)} return
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  @DisplayName("Test parseAllObjects(); given COSStream getInt(COSName) return zero")
  void testParseAllObjects_givenCOSStreamGetIntReturnZero() throws IOException {
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
   * Test {@link PDFObjectStreamParser#parseAllObjects()}.
   * <ul>
   *   <li>Given {@link RandomAccessRead} {@link RandomAccessRead#getPosition()}
   * return one.</li>
   *   <li>Then calls {@link Closeable#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  @DisplayName("Test parseAllObjects(); given RandomAccessRead getPosition() return one; then calls close()")
  void testParseAllObjects_givenRandomAccessReadGetPositionReturnOne_thenCallsClose() throws IOException {
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
   * Test {@link PDFObjectStreamParser#parseAllObjects()}.
   * <ul>
   *   <li>Given {@link RandomAccessRead} {@link RandomAccessRead#getPosition()}
   * return zero.</li>
   *   <li>Then calls {@link RandomAccessRead#skip(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  @DisplayName("Test parseAllObjects(); given RandomAccessRead getPosition() return zero; then calls skip(int)")
  void testParseAllObjects_givenRandomAccessReadGetPositionReturnZero_thenCallsSkip() throws IOException {
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
   * Test {@link PDFObjectStreamParser#readObjectNumbers()}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSDictionary#getInt(COSName)} return
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFObjectStreamParser#readObjectNumbers()}
   */
  @Test
  @DisplayName("Test readObjectNumbers(); given COSStream getInt(COSName) return one")
  void testReadObjectNumbers_givenCOSStreamGetIntReturnOne() throws IOException {
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
   * Test {@link PDFObjectStreamParser#readObjectNumbers()}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSDictionary#getInt(COSName)} return
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFObjectStreamParser#readObjectNumbers()}
   */
  @Test
  @DisplayName("Test readObjectNumbers(); given COSStream getInt(COSName) return zero")
  void testReadObjectNumbers_givenCOSStreamGetIntReturnZero() throws IOException {
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
}
