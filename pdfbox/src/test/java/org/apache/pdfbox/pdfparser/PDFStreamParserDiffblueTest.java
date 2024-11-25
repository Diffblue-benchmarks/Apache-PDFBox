package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFStreamParserDiffblueTest {
  /**
   * Test {@link PDFStreamParser#PDFStreamParser(byte[])}.
   * <p>
   * Method under test: {@link PDFStreamParser#PDFStreamParser(byte[])}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(byte[])")
  void testNewPDFStreamParser() throws IOException {
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

  /**
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.</li>
   *   <li>Then return {@link BaseParser#source} available is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream); given ArrayList() add A; then return source available is one")
  void testNewPDFStreamParser_givenArrayListAddA_thenReturnSourceAvailableIsOne() throws IOException {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(contents);

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
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.</li>
   *   <li>Then return {@link BaseParser#source} available is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream); given ArrayList() add A; then return source available is one")
  void testNewPDFStreamParser_givenArrayListAddA_thenReturnSourceAvailableIsOne2() throws IOException {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);
    filters.add(COSName.A);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(contents);

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
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@link BaseParser#source} available is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream); given ArrayList() add 'null'; then return source available is one")
  void testNewPDFStreamParser_givenArrayListAddNull_thenReturnSourceAvailableIsOne() throws IOException {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(contents);

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
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link PDPage#PDPage()} Contents is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream); given ArrayList(); when PDPage() Contents is ArrayList()")
  void testNewPDFStreamParser_givenArrayList_whenPDPageContentsIsArrayList() throws IOException {
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
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream); given PDStream(COSDocument) with document is COSDocument()")
  void testNewPDFStreamParser_givenPDStreamWithDocumentIsCOSDocument() throws IOException {
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
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()} Filters is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream); given PDStream(COSDocument) with document is COSDocument() Filters is ArrayList()")
  void testNewPDFStreamParser_givenPDStreamWithDocumentIsCOSDocumentFiltersIsArrayList() throws IOException {
    // Arrange
    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(new ArrayList<>());

    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(contents);

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
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   * <ul>
   *   <li>When {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream); when PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  void testNewPDFStreamParser_whenPDPageWithPageDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(new PDPage(new COSDictionary()));

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
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@link BaseParser#source} available is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream); when PDPage(); then return source available is zero")
  void testNewPDFStreamParser_whenPDPage_thenReturnSourceAvailableIsZero() throws IOException {
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
   * Test {@link PDFStreamParser#parse()}.
   * <p>
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse()")
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
   * Test {@link PDFStreamParser#parse()}.
   * <p>
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse()")
  void testParse2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'\b', 0, 'A', 'd', 'A', 'd', 'A', 'd'});

    // Act
    pdfStreamParser.parse();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertTrue(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   * <p>
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse()")
  void testParse3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser("%dAdAdAd".getBytes("UTF-8"));

    // Act and Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertTrue(pdfStreamParser.parse().isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array
   * of {@code byte} with one and {@code d}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); given PDFStreamParser(byte[]) with bytes is array of byte with one and 'd'")
  void testParse_givenPDFStreamParserWithBytesIsArrayOfByteWithOneAndD() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult = (new PDFStreamParser(new byte[]{1, 'd', 'A', 'd', 'A', 'd', 'A', 'd'})).parse();

    // Assert
    assertEquals(1, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof Operator);
    assertEquals("dAdAdAd", ((Operator) getResult).getName());
    assertNull(((Operator) getResult).getImageData());
    assertNull(((Operator) getResult).getImageParameters());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is
   * {@code dAdAdAd} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); given PDFStreamParser(byte[]) with bytes is 'dAdAdAd' Bytes is 'UTF-8'")
  void testParse_givenPDFStreamParserWithBytesIsDAdAdAdBytesIsUtf8() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult = (new PDFStreamParser("\bdAdAdAd".getBytes("UTF-8"))).parse();

    // Assert
    assertEquals(1, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof Operator);
    assertEquals("dAdAdAd", ((Operator) getResult).getName());
    assertNull(((Operator) getResult).getImageData());
    assertNull(((Operator) getResult).getImageParameters());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  void testParse_givenPDPageContentsIsPDStreamWithDocumentIsCOSDocument() throws IOException {
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
   * Test {@link PDFStreamParser#parse()}.
   * <ul>
   *   <li>Then return first Name is {@code AdAdAd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); then return first Name is 'AdAdAd'")
  void testParse_thenReturnFirstNameIsAdAdAd() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult = (new PDFStreamParser("%\nAdAdAd".getBytes("UTF-8"))).parse();

    // Assert
    assertEquals(1, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof Operator);
    assertEquals("AdAdAd", ((Operator) getResult).getName());
    assertNull(((Operator) getResult).getImageData());
    assertNull(((Operator) getResult).getImageParameters());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   * <ul>
   *   <li>Then return first Name is {@code AdAdAd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); then return first Name is 'AdAdAd'")
  void testParse_thenReturnFirstNameIsAdAdAd2() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult = (new PDFStreamParser("%\rAdAdAd".getBytes("UTF-8"))).parse();

    // Assert
    assertEquals(1, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof Operator);
    assertEquals("AdAdAd", ((Operator) getResult).getName());
    assertNull(((Operator) getResult).getImageData());
    assertNull(((Operator) getResult).getImageParameters());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   * <ul>
   *   <li>Then return first Name is {@code AdAdAdAd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); then return first Name is 'AdAdAdAd'")
  void testParse_thenReturnFirstNameIsAdAdAdAd() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult = (new PDFStreamParser("AdAdAdAd".getBytes("UTF-8"))).parse();

    // Assert
    assertEquals(1, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof Operator);
    assertEquals("AdAdAdAd", ((Operator) getResult).getName());
    assertNull(((Operator) getResult).getImageData());
    assertNull(((Operator) getResult).getImageParameters());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); then return size is two")
  void testParse_thenReturnSizeIsTwo() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult = (new PDFStreamParser(new byte[]{'A', 0, 'A', 'd', 'A', 'd', 'A', 'd'})).parse();

    // Assert
    assertEquals(2, actualParseResult.size());
    Object getResult = actualParseResult.get(0);
    assertTrue(getResult instanceof Operator);
    Object getResult2 = actualParseResult.get(1);
    assertTrue(getResult2 instanceof Operator);
    assertEquals("A", ((Operator) getResult).getName());
    assertEquals("AdAdAd", ((Operator) getResult2).getName());
    assertNull(((Operator) getResult2).getImageData());
    assertNull(((Operator) getResult2).getImageParameters());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   * <p>
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
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
   * Test {@link PDFStreamParser#parseNextToken()}.
   * <p>
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  void testParseNextToken2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'A', '\t', 'A', -1, 'A', -1, 'A', -1});

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("A", ((Operator) actualParseNextTokenResult).getName());
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertTrue(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   * <p>
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  void testParseNextToken3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'\b', '\t', 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.parseNextToken();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertTrue(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   * <p>
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  void testParseNextToken4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'%', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(pdfStreamParser.parseNextToken());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   * <p>
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  void testParseNextToken5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'A', '%', 'A', -1, 'A', -1, 'A', -1});

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("A", ((Operator) actualParseNextTokenResult).getName());
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  void testParseNextToken_givenPDPageContentsIsPDStreamWithDocumentIsCOSDocument() throws IOException {
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
   * Test {@link PDFStreamParser#close()}.
   * <p>
   * Method under test: {@link PDFStreamParser#close()}
   */
  @Test
  @DisplayName("Test close()")
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
}
