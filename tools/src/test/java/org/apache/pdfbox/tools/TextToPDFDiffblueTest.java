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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TextToPDFDiffblueTest {
  /**
   * Test new {@link TextToPDF} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TextToPDF}
   */
  @Test
  @DisplayName("Test new TextToPDF (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextToPDF.<init>()"})
  void testNewTextToPDF() {
    // Arrange and Act
    TextToPDF actualTextToPDF = new TextToPDF();

    // Assert
    PDRectangle mediaBox = actualTextToPDF.getMediaBox();
    assertTrue(mediaBox instanceof PDImmutableRectangle);
    assertNull(actualTextToPDF.getFont());
    assertEquals(0.0f, mediaBox.getLowerLeftX());
    assertEquals(0.0f, mediaBox.getLowerLeftY());
    assertEquals(10, actualTextToPDF.getFontSize());
    COSArray cOSArray = mediaBox.getCOSArray();
    assertEquals(4, cOSArray.toList().size());
    assertEquals(612.0f, mediaBox.getUpperRightX());
    assertEquals(612.0f, mediaBox.getWidth());
    assertEquals(792.0f, mediaBox.getHeight());
    assertEquals(792.0f, mediaBox.getUpperRightY());
    assertFalse(actualTextToPDF.isLandscape());
    assertSame(cOSArray, mediaBox.getCOSObject());
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(PDDocument, Reader)} with {@code doc}, {@code text}.
   *
   * <ul>
   *   <li>Then second element is array of {@code float} with zero and one.
   * </ul>
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(PDDocument, Reader)}
   */
  @Test
  @DisplayName(
      "Test createPDFFromText(PDDocument, Reader) with 'doc', 'text'; then second element is array of float with zero and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextToPDF.createPDFFromText(PDDocument, Reader)"})
  void testCreatePDFFromTextWithDocText_thenSecondElementIsArrayOfFloatWithZeroAndOne()
      throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    // Act
    textToPDF.createPDFFromText(doc, new StringReader("foo"));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDFont font = textToPDF.getFont();
    assertTrue(font instanceof PDType1Font);
    Iterator<PDPage> iteratorResult = doc.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    float[][] values2 = font.getFontMatrix().getValues();
    assertEquals(3, values2.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values2[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values2[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values2[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(PDDocument, Reader)} with {@code doc}, {@code text}.
   *
   * <ul>
   *   <li>Then {@link TextToPDF} (default constructor) MediaBox COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(PDDocument, Reader)}
   */
  @Test
  @DisplayName(
      "Test createPDFFromText(PDDocument, Reader) with 'doc', 'text'; then TextToPDF (default constructor) MediaBox COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextToPDF.createPDFFromText(PDDocument, Reader)"})
  void testCreatePDFFromTextWithDocText_thenTextToPDFMediaBoxCOSArrayToListSizeIsFour()
      throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setLandscape(true);

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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
    PDFont font = textToPDF.getFont();
    assertTrue(font instanceof PDType1Font);
    float[][] values = font.getFontMatrix().getValues();
    assertEquals(3, values.length);
    Iterator<PDPage> iteratorResult = doc.getPages().iterator();
    byte[] byteArray = new byte[51];
    assertEquals(51, iteratorResult.next().getContents().read(byteArray));
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 584.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setFont(new PDMMType1Font(new COSDictionary()));

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader("foo"));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    Iterator<PDPage> iteratorResult2 =
        actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    byte[] byteArray2 = new byte[51];
    assertEquals(51, iteratorResult2.next().getContents().read(byteArray2));
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(55, contentStreams.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 765.48901 Td\n0 -13.48901 Td\n(foo) T".getBytes("UTF-8"), byteArray2);
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 765.48901 Td\n0 -13.48901 Td\n(foo) T".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText2() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setLandscape(true);

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader("foo"));

    // Assert
    PDFont font = textToPDF.getFont();
    assertTrue(font instanceof PDType1Font);
    float[][] values = font.getFontMatrix().getValues();
    assertEquals(3, values.length);
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    Iterator<PDPage> iteratorResult2 =
        actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    byte[] byteArray2 = new byte[51];
    assertEquals(51, iteratorResult2.next().getContents().read(byteArray2));
    PDRectangle artBox = nextResult.getArtBox();
    assertEquals(612.0f, artBox.getHeight());
    assertEquals(612.0f, artBox.getUpperRightY());
    assertEquals(792.0f, artBox.getUpperRightX());
    assertEquals(792.0f, artBox.getWidth());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 584.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray2);
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 584.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText3() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setFont(new PDTrueTypeFont(new COSDictionary()));

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader("foo"));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    Iterator<PDPage> iteratorResult2 =
        actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    byte[] byteArray2 = new byte[51];
    assertEquals(51, iteratorResult2.next().getContents().read(byteArray2));
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(55, contentStreams.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 765.48901 Td\n0 -13.48901 Td\n(foo) T".getBytes("UTF-8"), byteArray2);
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 765.48901 Td\n0 -13.48901 Td\n(foo) T".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText4() throws IOException {
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
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    Iterator<PDPage> iteratorResult2 =
        actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    byte[] byteArray2 = new byte[51];
    assertEquals(51, iteratorResult2.next().getContents().read(byteArray2));
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(55, contentStreams.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 765.48901 Td\n0 -13.48901 Td\n(foo) T".getBytes("UTF-8"), byteArray2);
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 765.48901 Td\n0 -13.48901 Td\n(foo) T".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText5() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setMediaBox(new PDRectangle());
    textToPDF.setFont(new PDTrueTypeFont(new COSDictionary()));

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader("foo"));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(4, nextResult.getArtBox().getCOSArray().toList().size());
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    Iterator<PDPage> iteratorResult2 =
        actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    byte[] byteArray2 = new byte[51];
    assertEquals(51, iteratorResult2.next().getContents().read(byteArray2));
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(60, contentStreams.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 -26.51099 Td\n0 -13.48901 Td\n(foo) T".getBytes("UTF-8"), byteArray2);
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 -26.51099 Td\n0 -13.48901 Td\n(foo) T".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText6() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setMediaBox(null);
    textToPDF.setFont(new PDTrueTypeFont(new COSDictionary()));

    // Act and Assert
    Iterator<PDPage> iteratorResult =
        textToPDF.createPDFFromText(new StringReader("foo")).getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    assertTrue(nextResult.getArtBox() instanceof PDImmutableRectangle);
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText7() throws IOException {
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
    Iterator<PDPage> iteratorResult2 =
        actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    assertEquals(54, contentsForRandomAccess.available());
    assertEquals(54, contentsForRandomAccess2.available());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 765.48901 Td\n0 -13.48901 Td\n( ) Tj\n".getBytes("UTF-8"), byteArray2);
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 765.48901 Td\n0 -13.48901 Td\n( ) Tj\n".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText8() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setFont(new PDMMType1Font(new COSDictionary()));

    // Act
    PDDocument actualCreatePDFFromTextResult =
        textToPDF.createPDFFromText(new StringReader("getFont('%s','%s') returns %s"));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 =
        actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    assertTrue(nextResult2.getContentsForRandomAccess() instanceof RandomAccessReadWriteBuffer);
    assertEquals(111, contentsForRandomAccess.available());
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, nextResult2.getContents().read(byteArray2));
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 765.48901 Td\n0 -13.48901 Td\n<676574".getBytes("UTF-8"), byteArray2);
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 765.48901 Td\n0 -13.48901 Td\n<676574".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName("Test createPDFFromText(Reader) with 'text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText9() throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();
    textToPDF.setFont(new PDType3Font(new COSDictionary()));

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader("\n"));

    // Assert
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 =
        actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    assertTrue(nextResult2.getContentsForRandomAccess() instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[39];
    assertEquals(39, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[39];
    assertEquals(39, nextResult2.getContents().read(byteArray2));
    assertEquals(39, contentsForRandomAccess.available());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 752 Td\n0 0 Td\n() Tj\nET\n".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("/F1 10 Tf\nBT\n40 752 Td\n0 0 Td\n() Tj\nET\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <ul>
   *   <li>Then {@code /F1 10 Tf BT 40 764.138 Td 0 -12.138 Td (foo) Tj ET} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName(
      "Test createPDFFromText(Reader) with 'text'; then '/F1 10 Tf BT 40 764.138 Td 0 -12.138 Td (foo) Tj ET' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText_thenF110TfBt40764138Td012138TdFooTjEtBytesIsUtf8()
      throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader("foo"));

    // Assert
    PDFont font = textToPDF.getFont();
    assertTrue(font instanceof PDType1Font);
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    float[][] values2 = font.getFontMatrix().getValues();
    assertEquals(3, values2.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, nextResult.getContents().read(byteArray));
    Iterator<PDPage> iteratorResult2 =
        actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    byte[] byteArray2 = new byte[51];
    assertEquals(51, iteratorResult2.next().getContents().read(byteArray2));
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray2);
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n(foo) Tj\nET".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values2[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values2[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values2[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <ul>
   *   <li>Then {@code /F1 10 Tf BT 40 764.138 Td 0 -12.138 Td (getFont\('} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName(
      "Test createPDFFromText(Reader) with 'text'; then '/F1 10 Tf BT 40 764.138 Td 0 -12.138 Td (getFont\\('' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText_thenF110TfBt40764138Td012138TdGetFontBytesIsUtf8()
      throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();

    // Act
    PDDocument actualCreatePDFFromTextResult =
        textToPDF.createPDFFromText(new StringReader("getFont('%s','%s') returns %s"));

    // Assert
    PDFont font = textToPDF.getFont();
    assertTrue(font instanceof PDType1Font);
    float[][] values = font.getFontMatrix().getValues();
    assertEquals(3, values.length);
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    byte[] byteArray = new byte[51];
    assertEquals(51, iteratorResult.next().getContents().read(byteArray));
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n(getFont\\('".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <ul>
   *   <li>Then not {@link TextToPDF} (default constructor) Font COSObject NeedToBeUpdated.
   * </ul>
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName(
      "Test createPDFFromText(Reader) with 'text'; then not TextToPDF (default constructor) Font COSObject NeedToBeUpdated")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText_thenNotTextToPDFFontCOSObjectNeedToBeUpdated()
      throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();

    // Act
    textToPDF.createPDFFromText(new StringReader(""));

    // Assert
    PDFont font = textToPDF.getFont();
    assertTrue(font instanceof PDType1Font);
    assertEquals(3, font.getFontMatrix().getValues().length);
    assertFalse(font.getCOSObject().isNeedToBeUpdated());
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <ul>
   *   <li>Then return Pages iterator next Contents read is fifty.
   * </ul>
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName(
      "Test createPDFFromText(Reader) with 'text'; then return Pages iterator next Contents read is fifty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText_thenReturnPagesIteratorNextContentsReadIsFifty()
      throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader(" "));

    // Assert
    PDFont font = textToPDF.getFont();
    assertTrue(font instanceof PDType1Font);
    float[][] values = font.getFontMatrix().getValues();
    assertEquals(3, values.length);
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    byte[] byteArray = new byte[50];
    assertEquals(50, iteratorResult.next().getContents().read(byteArray));
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n( ) Tj\nET\n".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link TextToPDF#createPDFFromText(Reader)} with {@code text}.
   *
   * <ul>
   *   <li>Then return Pages iterator next Contents read is forty-nine.
   * </ul>
   *
   * <p>Method under test: {@link TextToPDF#createPDFFromText(Reader)}
   */
  @Test
  @DisplayName(
      "Test createPDFFromText(Reader) with 'text'; then return Pages iterator next Contents read is forty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument TextToPDF.createPDFFromText(Reader)"})
  void testCreatePDFFromTextWithText_thenReturnPagesIteratorNextContentsReadIsFortyNine()
      throws IOException {
    // Arrange
    TextToPDF textToPDF = new TextToPDF();

    // Act
    PDDocument actualCreatePDFFromTextResult = textToPDF.createPDFFromText(new StringReader("\n"));

    // Assert
    PDFont font = textToPDF.getFont();
    assertTrue(font instanceof PDType1Font);
    float[][] values = font.getFontMatrix().getValues();
    assertEquals(3, values.length);
    Iterator<PDPage> iteratorResult = actualCreatePDFFromTextResult.getPages().iterator();
    byte[] byteArray = new byte[49];
    assertEquals(49, iteratorResult.next().getContents().read(byteArray));
    Iterator<PDPage> iteratorResult2 =
        actualCreatePDFFromTextResult.getDocumentCatalog().getPages().iterator();
    byte[] byteArray2 = new byte[49];
    assertEquals(49, iteratorResult2.next().getContents().read(byteArray2));
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n() Tj\nET\n".getBytes("UTF-8"), byteArray2);
    assertArrayEquals(
        "/F1 10 Tf\nBT\n40 764.138 Td\n0 -12.138 Td\n() Tj\nET\n".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDFont TextToPDF.getFont()",
    "int TextToPDF.getFontSize()",
    "PDRectangle TextToPDF.getMediaBox()",
    "boolean TextToPDF.isLandscape()",
    "void TextToPDF.setFont(PDFont)",
    "void TextToPDF.setFontSize(int)",
    "void TextToPDF.setLandscape(boolean)",
    "void TextToPDF.setMediaBox(PDRectangle)"
  })
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

    // Assert
    assertEquals(3, actualFontSize);
    assertTrue(textToPDF.isLandscape());
    assertSame(mediaBox, actualMediaBox);
    assertSame(aFont, actualFont);
  }
}
