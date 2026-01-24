package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFStreamParserDiffblueTest {
  /**
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(PDContentStream)"})
  void testNewPDFStreamParser() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream str =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    pdContentstream.setContents(new PDStream(str));

    // Act and Assert
    RandomAccessRead randomAccessRead = new PDFStreamParser(pdContentstream).source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(3, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(PDContentStream)"})
  void testNewPDFStreamParser2() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();

    COSStream str =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    str.setKey(new COSObjectKey(1L, 1));
    PDStream contents = new PDStream(str);

    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(contents);

    // Act and Assert
    RandomAccessRead randomAccessRead = new PDFStreamParser(pdContentstream).source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(3, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(PDContentStream)"})
  void testNewPDFStreamParser3() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    PDDocument doc = new PDDocument();
    PDMetadata contents =
        new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    pdContentstream.setContents(contents);

    // Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(pdContentstream);

    // Assert
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(8, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isEOF());
    assertFalse(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(PDContentStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(PDContentStream)"})
  void testNewPDFStreamParser4() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage(new COSDictionary());
    PDDocument doc = new PDDocument();
    PDMetadata contents =
        new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    pdContentstream.setContents(contents);

    // Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(pdContentstream);

    // Assert
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(8, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isEOF());
    assertFalse(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#PDFStreamParser(byte[])}.
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(byte[])}
   */
  @Test
  @DisplayName("Test new PDFStreamParser(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(byte[])"})
  void testNewPDFStreamParser5() throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then return {@link BaseParser#source} available is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName(
      "Test new PDFStreamParser(PDContentStream); given ArrayList() add A; then return source available is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(PDContentStream)"})
  void testNewPDFStreamParser_givenArrayListAddA_thenReturnSourceAvailableIsOne()
      throws IOException {
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
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isEOF());
    assertTrue(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then return {@link BaseParser#source} available is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName(
      "Test new PDFStreamParser(PDContentStream); given ArrayList() add A; then return source available is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(PDContentStream)"})
  void testNewPDFStreamParser_givenArrayListAddA_thenReturnSourceAvailableIsOne2()
      throws IOException {
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
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isEOF());
    assertTrue(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@link BaseParser#source} available is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName(
      "Test new PDFStreamParser(PDContentStream); given ArrayList() add 'null'; then return source available is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(PDContentStream)"})
  void testNewPDFStreamParser_givenArrayListAddNull_thenReturnSourceAvailableIsOne()
      throws IOException {
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
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isEOF());
    assertTrue(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName(
      "Test new PDFStreamParser(PDContentStream); given ArrayList(); when PDPage() Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(PDContentStream)"})
  void testNewPDFStreamParser_givenArrayList_whenPDPageContentsIsArrayList() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new ArrayList<>());

    // Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(pdContentstream);

    // Assert
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isWhitespace());
    assertTrue(actualPdfStreamParser.isEOF());
  }

  /**
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName(
      "Test new PDFStreamParser(PDContentStream); given PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(PDContentStream)"})
  void testNewPDFStreamParser_givenPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new PDStream(new COSDocument()));

    // Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(pdContentstream);

    // Assert
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isEOF());
    assertTrue(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} Filters is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName(
      "Test new PDFStreamParser(PDContentStream); given PDStream(COSDocument) with document is COSDocument() Filters is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(PDContentStream)"})
  void testNewPDFStreamParser_givenPDStreamWithDocumentIsCOSDocumentFiltersIsArrayList()
      throws IOException {
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
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1, randomAccessRead.available());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isEOF());
    assertTrue(actualPdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#PDFStreamParser(PDContentStream)}.
   *
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.
   *   <li>Then return {@link BaseParser#source} available is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#PDFStreamParser(PDContentStream)}
   */
  @Test
  @DisplayName(
      "Test new PDFStreamParser(PDContentStream); when PDPage(); then return source available is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.<init>(PDContentStream)"})
  void testNewPDFStreamParser_whenPDPage_thenReturnSourceAvailableIsZero() throws IOException {
    // Arrange and Act
    PDFStreamParser actualPdfStreamParser = new PDFStreamParser(new PDPage());

    // Assert
    RandomAccessRead randomAccessRead = actualPdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualPdfStreamParser.isWhitespace());
    assertTrue(actualPdfStreamParser.isEOF());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFStreamParser.parse()"})
  void testParse() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertTrue(actualParseResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFStreamParser.parse()"})
  void testParse2() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 100L, -1L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertTrue(actualParseResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFStreamParser.parse()"})
  void testParse3() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AdAdAdAd".getBytes("UTF-8")));
    COSStream dictionary =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 100L, -1L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

    // Assert
    RandomAccessRead randomAccessRead2 = pdfStreamParser.source;
    assertTrue(randomAccessRead2 instanceof RandomAccessReadView);
    assertTrue(actualParseResult.isEmpty());
    assertTrue(randomAccessRead2.isClosed());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFStreamParser.parse()"})
  void testParse4() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 100L, 3L), 100L, 3L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertFalse(randomAccessRead.isClosed());
    assertTrue(actualParseResult.isEmpty());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with one and {@code d}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName(
      "Test parse(); given PDFStreamParser(byte[]) with bytes is array of byte with one and 'd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFStreamParser.parse()"})
  void testParse_givenPDFStreamParserWithBytesIsArrayOfByteWithOneAndD() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {1, 'd', 'A', 'd', 'A', 'd', 'A', 'd'});

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

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
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with zero and {@code d}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName(
      "Test parse(); given PDFStreamParser(byte[]) with bytes is array of byte with zero and 'd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFStreamParser.parse()"})
  void testParse_givenPDFStreamParserWithBytesIsArrayOfByteWithZeroAndD() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {0, 'd', 'A', 'd', 'A', 'd', 'A', 'd'});

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

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
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is {@code dAdAdAd} Bytes
   *       is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName(
      "Test parse(); given PDFStreamParser(byte[]) with bytes is 'dAdAdAd' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFStreamParser.parse()"})
  void testParse_givenPDFStreamParserWithBytesIsDAdAdAdBytesIsUtf8() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult = new PDFStreamParser("\bdAdAdAd".getBytes("UTF-8")).parse();

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
   *
   * <ul>
   *   <li>Then not {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is
   *       {@link PDTilingPattern#PDTilingPattern(COSDictionary)} {@link BaseParser#source} Closed.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName(
      "Test parse(); then not PDFStreamParser(PDContentStream) with pdContentstream is PDTilingPattern(COSDictionary) source Closed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFStreamParser.parse()"})
  void testParse_thenNotPDFStreamParserWithPdContentstreamIsPDTilingPatternSourceClosed()
      throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 100L, 3L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertFalse(randomAccessRead.isClosed());
    assertTrue(actualParseResult.isEmpty());
  }

  /**
   * Test {@link PDFStreamParser#parse()}.
   *
   * <ul>
   *   <li>Then return first Name is {@code AdAdAdAd}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); then return first Name is 'AdAdAdAd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFStreamParser.parse()"})
  void testParse_thenReturnFirstNameIsAdAdAdAd() throws IOException {
    // Arrange and Act
    List<Object> actualParseResult = new PDFStreamParser("AdAdAdAd".getBytes("UTF-8")).parse();

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
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDFStreamParser.parse()"})
  void testParse_thenReturnSizeIsTwo() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', 0, 'A', 'd', 'A', 'd', 'A', 'd'});

    // Act
    List<Object> actualParseResult = pdfStreamParser.parse();

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
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(actualParseNextTokenResult);
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("AÿAÿAÿAÿ", ((Operator) actualParseNextTokenResult).getName());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\b', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("ÿAÿAÿAÿ", ((Operator) actualParseNextTokenResult).getName());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {1, -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("ÿAÿAÿAÿ", ((Operator) actualParseNextTokenResult).getName());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("ÿAÿAÿAÿ", ((Operator) actualParseNextTokenResult).getName());
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken6() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', '\t', 'A', -1, 'A', -1, 'A', -1});

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
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken7() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertNull(actualParseNextTokenResult);
    assertEquals(3, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken8() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream dictionary =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead2 = pdfStreamParser.source;
    assertTrue(randomAccessRead2 instanceof RandomAccessReadView);
    assertEquals("A", ((Operator) actualParseNextTokenResult).getName());
    assertEquals(0, randomAccessRead2.available());
    assertEquals(3L, randomAccessRead2.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken9() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, -1L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertNull(actualParseNextTokenResult);
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken10() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);
    COSStream dictionary =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, -1L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    RandomAccessRead randomAccessRead2 = pdfStreamParser.source;
    assertTrue(randomAccessRead2 instanceof RandomAccessReadView);
    assertNull(actualParseNextTokenResult);
    assertTrue(randomAccessRead2.isClosed());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName("Test parseNextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken11() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 3L, 3L), 3L, 3L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertNull(actualParseNextTokenResult);
    assertEquals(3, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link PDFStreamParser#parseNextToken()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with {@code A} and zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#parseNextToken()}
   */
  @Test
  @DisplayName(
      "Test parseNextToken(); given ByteArrayInputStream(byte[]) with array of byte with 'A' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFStreamParser.parseNextToken()"})
  void testParseNextToken_givenByteArrayInputStreamWithArrayOfByteWithAAndZero()
      throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 0, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream dictionary =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    Object actualParseNextTokenResult = pdfStreamParser.parseNextToken();

    // Assert
    assertTrue(actualParseNextTokenResult instanceof Operator);
    RandomAccessRead randomAccessRead2 = pdfStreamParser.source;
    assertTrue(randomAccessRead2 instanceof RandomAccessReadView);
    assertEquals("A", ((Operator) actualParseNextTokenResult).getName());
    assertEquals(0, randomAccessRead2.available());
    assertEquals(3L, randomAccessRead2.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link PDFStreamParser#close()}.
   *
   * <p>Method under test: {@link PDFStreamParser#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.close()"})
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
   * Test {@link PDFStreamParser#close()}.
   *
   * <p>Method under test: {@link PDFStreamParser#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.close()"})
  void testClose2() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    pdfStreamParser.close();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFStreamParser#close()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDFStreamParser#close()}
   */
  @Test
  @DisplayName("Test close(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFStreamParser.close()"})
  void testClose_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSStream dictionary =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDTilingPattern(dictionary));

    // Act
    pdfStreamParser.close();

    // Assert
    RandomAccessRead randomAccessRead2 = pdfStreamParser.source;
    assertTrue(randomAccessRead2 instanceof RandomAccessReadView);
    assertTrue(randomAccessRead2.isClosed());
  }
}
