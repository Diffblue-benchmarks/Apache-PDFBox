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
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;

class PDFStreamParserDiffblueTest {
  /**
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  void testParse() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act and Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertTrue(pdfStreamParser.parse().isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  void testParse2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser("AdAdAdAd".getBytes("UTF-8"));

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

    // Assert
    assertEquals(1, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("AdAdAdAd", ((Operator) getResult).getName());
    assertNull(((Operator) getResult).getImageData());
    assertNull(((Operator) getResult).getImageParameters());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  void testParse3() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new PDStream(new COSDocument()));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(pdContentstream);

    // Act and Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertTrue(pdfStreamParser.parse().isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  void testParse4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser("\bdAdAdAd".getBytes("UTF-8"));

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

    // Assert
    assertEquals(1, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("dAdAdAd", ((Operator) getResult).getName());
    assertNull(((Operator) getResult).getImageData());
    assertNull(((Operator) getResult).getImageParameters());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  void testParse5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{1, 'd', 'A', 'd', 'A', 'd', 'A', 'd'});

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

    // Assert
    assertEquals(1, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("dAdAdAd", ((Operator) getResult).getName());
    assertNull(((Operator) getResult).getImageData());
    assertNull(((Operator) getResult).getImageParameters());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  void testParse6() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'A', 0, 'A', 'd', 'A', 'd', 'A', 'd'});

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

    // Assert
    assertEquals(2, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof Operator);
    Object getResult2 = actualParseResult.get(1);
    assertTrue(getResult2 instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("A", ((Operator) getResult).getName());
    assertEquals("AdAdAd", ((Operator) getResult2).getName());
    assertNull(((Operator) getResult).getImageData());
    assertNull(((Operator) getResult2).getImageData());
    assertNull(((Operator) getResult).getImageParameters());
    assertNull(((Operator) getResult2).getImageParameters());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  void testParse7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(contents);
    PDFStreamParser pdfStreamParser = new PDFStreamParser(pdContentstream);

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertTrue(actualParseResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  void testParseNextToken() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act and Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(pdfStreamParser.parseNextToken());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  void testParseNextToken2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("AÿAÿAÿAÿ", ((Operator) actualParseNextTokenResult).getName());
    assertNull(((Operator) actualParseNextTokenResult).getImageData());
    assertNull(((Operator) actualParseNextTokenResult).getImageParameters());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  void testParseNextToken3() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new PDStream(new COSDocument()));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(pdContentstream);

    // Act and Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(pdfStreamParser.parseNextToken());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  void testParseNextToken4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'\b', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("ÿAÿAÿAÿ", ((Operator) actualParseNextTokenResult).getName());
    assertNull(((Operator) actualParseNextTokenResult).getImageData());
    assertNull(((Operator) actualParseNextTokenResult).getImageParameters());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  void testParseNextToken5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{1, -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("ÿAÿAÿAÿ", ((Operator) actualParseNextTokenResult).getName());
    assertNull(((Operator) actualParseNextTokenResult).getImageData());
    assertNull(((Operator) actualParseNextTokenResult).getImageParameters());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  void testParseNextToken6() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'A', '\t', 'A', -1, 'A', -1, 'A', -1});

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("A", ((Operator) actualParseNextTokenResult).getName());
    assertNull(((Operator) actualParseNextTokenResult).getImageData());
    assertNull(((Operator) actualParseNextTokenResult).getImageParameters());
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertTrue(pdfStreamParser.isWhitespace());
  }

  /**
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  void testParseNextToken7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(contents);
    PDFStreamParser pdfStreamParser = new PDFStreamParser(pdContentstream);

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualParseNextTokenResult);
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFStreamParser#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act
    pdfStreamParser.close();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  void testNewPDFStreamParser() throws IOException {
    // Arrange and Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(new PDPage());

    // Assert
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualPdfStreamParser.document);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isDigit());
    assertFalse(actualPdfStreamParser.isSpace());
    assertFalse(actualPdfStreamParser.isWhitespace());
    assertTrue(actualPdfStreamParser.isEOF());
  }

  /**
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  void testNewPDFStreamParser2() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new PDStream(new COSDocument()));

    // Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(pdContentstream);

    // Assert
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualPdfStreamParser.document);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isDigit());
    assertFalse(actualPdfStreamParser.isEOF());
    assertFalse(actualPdfStreamParser.isSpace());
    assertTrue(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  void testNewPDFStreamParser3() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new ArrayList<>());

    // Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(pdContentstream);

    // Assert
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualPdfStreamParser.document);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isDigit());
    assertFalse(actualPdfStreamParser.isSpace());
    assertFalse(actualPdfStreamParser.isWhitespace());
    assertTrue(actualPdfStreamParser.isEOF());
  }

  /**
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  void testNewPDFStreamParser4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(contents);

    // Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(pdContentstream);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualPdfStreamParser.document);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isDigit());
    assertFalse(actualPdfStreamParser.isEOF());
    assertFalse(actualPdfStreamParser.isSpace());
    assertTrue(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  void testNewPDFStreamParser5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));
    contents.setFilters(new ArrayList<>());

    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(contents);

    // Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(pdContentstream);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualPdfStreamParser.document);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isDigit());
    assertFalse(actualPdfStreamParser.isEOF());
    assertFalse(actualPdfStreamParser.isSpace());
    assertTrue(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  void testNewPDFStreamParser6() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    PDDocument doc = new PDDocument();
    pdContentstream.setContents(new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    new IOException("Create InputStream called without data being written before to stream.");

    // Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(pdContentstream);

    // Assert
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualPdfStreamParser.document);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(8, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isDigit());
    assertFalse(actualPdfStreamParser.isEOF());
    assertFalse(actualPdfStreamParser.isSpace());
    assertFalse(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  void testNewPDFStreamParser7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream contents = new PDStream(document);
    contents.setFilters(filters);

    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(contents);

    // Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(pdContentstream);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualPdfStreamParser.document);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isDigit());
    assertFalse(actualPdfStreamParser.isEOF());
    assertFalse(actualPdfStreamParser.isSpace());
    assertTrue(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  void testNewPDFStreamParser8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument document = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream contents = new PDStream(document);
    contents.setFilters(filters);

    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(contents);

    // Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(pdContentstream);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualPdfStreamParser.document);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isDigit());
    assertFalse(actualPdfStreamParser.isEOF());
    assertFalse(actualPdfStreamParser.isSpace());
    assertTrue(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Method under test: {@link PDFStreamParser#PDFStreamParser(byte[])}
   */
  @Test
  void testNewPDFStreamParser9() throws IOException {
    // Arrange and Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualPdfStreamParser.document);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(8, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isDigit());
    assertFalse(actualPdfStreamParser.isEOF());
    assertFalse(actualPdfStreamParser.isSpace());
    assertFalse(actualPdfStreamParser.isWhitespace());
  }
}
