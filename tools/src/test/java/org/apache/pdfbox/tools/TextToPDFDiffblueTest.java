package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextToPDFDiffblueTest {
  /**
   * Test new {@link TextToPDF} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TextToPDF}
   */
  @Test
  @DisplayName("Test new TextToPDF (default constructor)")
  void testNewTextToPDF() {
    // Arrange and Act
    TextToPDF actualTextToPDF = new TextToPDF();

    // Assert
    PDRectangle mediaBox = actualTextToPDF.getMediaBox();
    COSArray cOSArray = mediaBox.getCOSArray();
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
    assertTrue(mediaBox instanceof PDImmutableRectangle);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertNull(actualTextToPDF.getFont());
    assertEquals(0.0f, mediaBox.getLowerLeftX());
    assertEquals(0.0f, mediaBox.getLowerLeftY());
    assertEquals(10, actualTextToPDF.getFontSize());
    assertEquals(612.0f, mediaBox.getUpperRightX());
    assertEquals(612.0f, mediaBox.getWidth());
    assertEquals(792.0f, mediaBox.getHeight());
    assertEquals(792.0f, mediaBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertFalse(actualTextToPDF.isLandscape());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, mediaBox.getCOSObject());
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(PDDocument, Reader)} with
   * {@code doc}, {@code text}.
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(PDDocument, Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(PDDocument, Reader) with 'doc', 'text'")
  void testCreatePDFFromTextWithDocText() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    // Act
    textToPDF.createPDFFromText(doc, new StringReader("foo"));

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = doc.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    Iterator<PDPage> iteratorResult2 = doc.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    PDStream nextResult3 = contentStreams.next();
    assertEquals(53, nextResult3.getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(53, contentStreams2.next().getLength());
    assertEquals(53L, nextResult3.getCOSObject().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(PDDocument, Reader)} with
   * {@code doc}, {@code text}.
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(PDDocument, Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(PDDocument, Reader) with 'doc', 'text'")
  void testCreatePDFFromTextWithDocText2() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    // Act
    textToPDF.createPDFFromText(doc, new StringReader(""));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDPageTree pages = doc.getPages();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    Iterator<PDPage> iteratorResult2 = doc.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = nextResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing2 = nextResult2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDFont font = textToPDF.getFont();
    assertTrue(font instanceof PDType1Font);
    COSDictionary cOSObject = font.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(nextResult.getResources());
    assertNull(nextResult2.getResources());
    assertEquals(-1, nextResult.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult2.getContents().read(new byte[]{}));
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(2, pages.getCOSObject().toIncrement().getObjects().size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(nextResult.getContentStreams().hasNext());
    assertFalse(nextResult2.getContentStreams().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(nextResult.hasContents());
    assertFalse(nextResult2.hasContents());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(PDDocument, Reader)} with
   * {@code doc}, {@code text}.
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(PDDocument, Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(PDDocument, Reader) with 'doc', 'text'")
  void testCreatePDFFromTextWithDocText3() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setMediaBox(new PDRectangle());
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    // Act
    textToPDF.createPDFFromText(doc, new StringReader("foo"));

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = doc.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    PDRectangle artBox = nextResult.getArtBox();
    List<? extends COSBase> toListResult = artBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertEquals(0.0f, artBox.getHeight());
    Iterator<PDPage> iteratorResult2 = doc.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    PDRectangle artBox2 = nextResult2.getArtBox();
    assertEquals(0.0f, artBox2.getHeight());
    assertEquals(0.0f, artBox.getUpperRightX());
    assertEquals(0.0f, artBox2.getUpperRightX());
    assertEquals(0.0f, artBox.getUpperRightY());
    assertEquals(0.0f, artBox2.getUpperRightY());
    assertEquals(0.0f, artBox.getWidth());
    assertEquals(0.0f, artBox2.getWidth());
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    PDStream nextResult3 = contentStreams.next();
    assertEquals(56, nextResult3.getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(56, contentStreams2.next().getLength());
    assertEquals(56L, nextResult3.getCOSObject().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 -27.862 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 -27.862 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(PDDocument, Reader)} with
   * {@code doc}, {@code text}.
   * <ul>
   *   <li>Then {@link TextToPDF} (default constructor) MediaBox COSArray toList
   * size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(PDDocument, Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(PDDocument, Reader) with 'doc', 'text'; then TextToPDF (default constructor) MediaBox COSArray toList size is four")
  void testCreatePDFFromTextWithDocText_thenTextToPDFMediaBoxCOSArrayToListSizeIsFour() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setLandscape(true);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    // Act
    textToPDF.createPDFFromText(doc, new StringReader("foo"));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDRectangle mediaBox = textToPDF.getMediaBox();
    List<? extends COSBase> toListResult = mediaBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertTrue(mediaBox instanceof PDImmutableRectangle);
    Iterator<PDPage> iteratorResult = doc.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    Iterator<PDPage> iteratorResult2 = doc.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    PDRectangle artBox = nextResult.getArtBox();
    assertEquals(612.0f, artBox.getHeight());
    PDRectangle artBox2 = nextResult2.getArtBox();
    assertEquals(612.0f, artBox2.getHeight());
    assertEquals(612.0f, artBox.getUpperRightY());
    assertEquals(612.0f, artBox2.getUpperRightY());
    assertEquals(792.0f, artBox.getUpperRightX());
    assertEquals(792.0f, artBox2.getUpperRightX());
    assertEquals(792.0f, artBox.getWidth());
    assertEquals(792.0f, artBox2.getWidth());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 584.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 584.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  void testCreatePDFFromTextWithText() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader("foo"));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    assertEquals(52, contentsForRandomAccess.available());
    assertEquals(52, contentsForRandomAccess2.available());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  void testCreatePDFFromTextWithText2() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setFont(new PDMMType1Font(new COSDictionary()));

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader("foo"));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    PDStream nextResult3 = contentStreams.next();
    assertEquals(55, nextResult3.getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(55, contentStreams2.next().getLength());
    assertEquals(55L, nextResult3.getCOSObject().getLength());
    assertEquals(56, contentsForRandomAccess.available());
    assertEquals(56, contentsForRandomAccess2.available());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 766.13501 Td\n0 -14.13501 Td\n(foo) T".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 766.13501 Td\n0 -14.13501 Td\n(foo) T".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  void testCreatePDFFromTextWithText3() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setLandscape(true);

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader("foo"));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    Iterator<PDPage> iteratorResult2 = actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    PDRectangle artBox = nextResult.getArtBox();
    assertEquals(612.0f, artBox.getHeight());
    PDRectangle artBox2 = nextResult2.getArtBox();
    assertEquals(612.0f, artBox2.getHeight());
    assertEquals(612.0f, artBox.getUpperRightY());
    assertEquals(612.0f, artBox2.getUpperRightY());
    assertEquals(792.0f, artBox.getUpperRightX());
    assertEquals(792.0f, artBox2.getUpperRightX());
    assertEquals(792.0f, artBox.getWidth());
    assertEquals(792.0f, artBox2.getWidth());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 584.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 584.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  void testCreatePDFFromTextWithText4() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF
        .createPDFFromText(new StringReader("getFont('%s','%s') returns %s"));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    PDStream nextResult3 = contentStreams.next();
    assertEquals(79, nextResult3.getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(79, contentStreams2.next().getLength());
    assertEquals(79L, nextResult3.getCOSObject().getLength());
    assertEquals(80, contentsForRandomAccess.available());
    assertEquals(80, contentsForRandomAccess2.available());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n(getFont\\('".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n(getFont\\('".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  void testCreatePDFFromTextWithText5() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setFont(new PDMMType1Font(new COSDictionary()));

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader(" "));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    assertEquals(54, contentsForRandomAccess.available());
    assertEquals(54, contentsForRandomAccess2.available());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 766.13501 Td\n0 -14.13501 Td\n( ) Tj\n".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 766.13501 Td\n0 -14.13501 Td\n( ) Tj\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  void testCreatePDFFromTextWithText6() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(1L, 1));
    PDMMType1Font aFont = new PDMMType1Font(fontDictionary);

    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setFont(aFont);

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader("foo"));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    PDStream nextResult3 = contentStreams.next();
    assertEquals(55, nextResult3.getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(55, contentStreams2.next().getLength());
    assertEquals(55L, nextResult3.getCOSObject().getLength());
    assertEquals(56, contentsForRandomAccess.available());
    assertEquals(56, contentsForRandomAccess2.available());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 766.13501 Td\n0 -14.13501 Td\n(foo) T".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 766.13501 Td\n0 -14.13501 Td\n(foo) T".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  void testCreatePDFFromTextWithText7() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setFont(new PDMMType1Font(new COSDictionary()));

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF
        .createPDFFromText(new StringReader("getFont('%s','%s') returns %s"));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    assertEquals(111, contentsForRandomAccess.available());
    assertEquals(111, contentsForRandomAccess2.available());
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    PDStream nextResult3 = contentStreams.next();
    assertEquals(93, nextResult3.getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(93, contentStreams2.next().getLength());
    assertEquals(93L, nextResult3.getCOSObject().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 766.13501 Td\n0 -14.13501 Td\n<676574".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 766.13501 Td\n0 -14.13501 Td\n<676574".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  void testCreatePDFFromTextWithText8() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setMediaBox(null);

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader(" "));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    assertTrue(nextResult.getArtBox() instanceof PDImmutableRectangle);
    byte[] byteArray = new byte[50];
    assertEquals(50, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[50];
    assertEquals(50, nextResult2.getContents().read(byteArray2));
    assertEquals(50, contentsForRandomAccess.available());
    assertEquals(50, contentsForRandomAccess2.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    PDStream nextResult3 = contentStreams.next();
    assertEquals(51, nextResult3.getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(51, contentStreams2.next().getLength());
    assertEquals(51L, nextResult3.getCOSObject().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n( ) Tj\nET\n".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n( ) Tj\nET\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   * <ul>
   *   <li>Then return Pages iterator next Contents read is fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'; then return Pages iterator next Contents read is fifty")
  void testCreatePDFFromTextWithText_thenReturnPagesIteratorNextContentsReadIsFifty() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader(" "));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[50];
    assertEquals(50, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[50];
    assertEquals(50, nextResult2.getContents().read(byteArray2));
    assertEquals(50, contentsForRandomAccess.available());
    assertEquals(50, contentsForRandomAccess2.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    PDStream nextResult3 = contentStreams.next();
    assertEquals(51, nextResult3.getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(51, contentStreams2.next().getLength());
    assertEquals(51L, nextResult3.getCOSObject().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals("/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n( ) Tj\nET\n".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n( ) Tj\nET\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TextToPDF#setFont(PDFont)}
   *   <li>{@link TextToPDF#setFontSize(int)}
   *   <li>{@link TextToPDF#setLandscape(boolean)}
   *   <li>{@link TextToPDF#setMediaBox(PDRectangle)}
   *   <li>{@link TextToPDF#getFont()}
   *   <li>{@link TextToPDF#getFontSize()}
   *   <li>{@link TextToPDF#getMediaBox()}
   *   <li>{@link TextToPDF#isLandscape()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    PDMMType1Font aFont = new PDMMType1Font(new COSDictionary());

    // Act
    textToPDF.setFont(aFont);
    textToPDF.setFontSize(3);
    textToPDF.setLandscape(true);
    PDRectangle mediaBox = new PDRectangle();
    textToPDF.setMediaBox(mediaBox);
    PDFont actualFont = textToPDF.getFont();
    int actualFontSize = textToPDF.getFontSize();
    PDRectangle actualMediaBox = textToPDF.getMediaBox();

    // Assert that nothing has changed
    assertEquals(3, actualFontSize);
    assertTrue(textToPDF.isLandscape());
    assertSame(mediaBox, actualMediaBox);
    assertSame(aFont, actualFont);
  }
}
