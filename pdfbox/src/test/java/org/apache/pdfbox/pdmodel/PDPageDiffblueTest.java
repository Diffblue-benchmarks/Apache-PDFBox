package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.action.PDPageAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.AnnotationFilter;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFreeText;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationInk;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLine;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPolygon;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPolyline;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPopup;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSound;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquare;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationUnknown;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDViewportDictionary;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThreadBead;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransition;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDPageDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then ResourceCache return {@link DefaultResourceCache}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDPage#PDPage(COSDictionary, ResourceCache)}
   *   <li>{@link PDPage#getResourceCache()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then ResourceCache return DefaultResourceCache")
  void testGettersAndSetters_thenResourceCacheReturnDefaultResourceCache() {
    // Arrange
    COSDictionary pageDictionary = new COSDictionary();
    DefaultResourceCache resourceCache = new DefaultResourceCache();

    // Act
    PDPage actualPdPage = new PDPage(pageDictionary, resourceCache);
    ResourceCache actualResourceCache = actualPdPage.getResourceCache();

    // Assert
    assertTrue(actualResourceCache instanceof DefaultResourceCache);
    assertSame(pageDictionary, actualPdPage.getCOSObject());
    assertSame(resourceCache, actualResourceCache);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return ResourceCache is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDPage#PDPage(COSDictionary)}
   *   <li>{@link PDPage#getResourceCache()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when COSDictionary(); then return ResourceCache is 'null'")
  void testGettersAndSetters_whenCOSDictionary_thenReturnResourceCacheIsNull() {
    // Arrange
    COSDictionary pageDictionary = new COSDictionary();

    // Act
    PDPage actualPdPage = new PDPage(pageDictionary);

    // Assert
    assertNull(actualPdPage.getResourceCache());
    assertSame(pageDictionary, actualPdPage.getCOSObject());
  }

  /**
   * Test {@link PDPage#PDPage(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then ArtBox COSArray toList third return {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#PDPage(PDRectangle)}
   */
  @Test
  @DisplayName("Test new PDPage(PDRectangle); when PDRectangle(); then ArtBox COSArray toList third return COSFloat")
  void testNewPDPage_whenPDRectangle_thenArtBoxCOSArrayToListThirdReturnCOSFloat() {
    // Arrange and Act
    PDPage actualPdPage = new PDPage(new PDRectangle());

    // Assert
    PDRectangle artBox = actualPdPage.getArtBox();
    COSArray cOSArray = artBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(0.0f, artBox.getHeight());
    assertEquals(0.0f, artBox.getUpperRightX());
    assertEquals(0.0f, artBox.getUpperRightY());
    assertEquals(0.0f, artBox.getWidth());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    assertSame(artBox, actualPdPage.getBBox());
    assertSame(artBox, actualPdPage.getBleedBox());
    assertSame(artBox, actualPdPage.getCropBox());
    assertSame(artBox, actualPdPage.getMediaBox());
    assertSame(cOSArray, artBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getContentStreams()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName("Test getContentStreams(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  void testGetContentStreams_givenArrayListAddPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    Iterator<PDStream> actualContentStreams = pdPage.getContentStreams();

    // Assert
    PDStream nextResult = actualContentStreams.next();
    assertNull(nextResult.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    COSStream cOSObject = nextResult.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualContentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = nextResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, nextResult.getFilters());
  }

  /**
   * Test {@link PDPage#getContentStreams()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName("Test getContentStreams(); given PDPage() Contents is ArrayList(); then return not hasNext")
  void testGetContentStreams_givenPDPageContentsIsArrayList_thenReturnNotHasNext() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new ArrayList<>());

    // Act and Assert
    assertFalse(pdPage.getContentStreams().hasNext());
  }

  /**
   * Test {@link PDPage#getContentStreams()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName("Test getContentStreams(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  void testGetContentStreams_givenPDPageContentsIsPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new PDStream(new COSDocument()));

    // Act
    Iterator<PDStream> actualContentStreams = pdPage.getContentStreams();

    // Assert
    PDStream nextResult = actualContentStreams.next();
    assertNull(nextResult.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    COSStream cOSObject = nextResult.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualContentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = nextResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, nextResult.getFilters());
  }

  /**
   * Test {@link PDPage#getContentStreams()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName("Test getContentStreams(); given PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  void testGetContentStreams_givenPDPageWithPageDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDPage(new COSDictionary())).getContentStreams().hasNext());
  }

  /**
   * Test {@link PDPage#getContentStreams()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName("Test getContentStreams(); given PDPage(); then return not hasNext")
  void testGetContentStreams_givenPDPage_thenReturnNotHasNext() {
    // Arrange, Act and Assert
    assertFalse((new PDPage()).getContentStreams().hasNext());
  }

  /**
   * Test {@link PDPage#getContents()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.</li>
   *   <li>Then return read is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given ArrayList() add A; then return read is one")
  void testGetContents_givenArrayListAddA_thenReturnReadIsOne() throws IOException {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act and Assert
    byte[] byteArray = new byte[1];
    assertEquals(1, pdPage.getContents().read(byteArray));
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Test {@link PDPage#getContents()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return read is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given ArrayList() add 'null'; then return read is one")
  void testGetContents_givenArrayListAddNull_thenReturnReadIsOne() throws IOException {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act and Assert
    byte[] byteArray = new byte[1];
    assertEquals(1, pdPage.getContents().read(byteArray));
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Test {@link PDPage#getContents()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  void testGetContents_givenArrayListAddPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act and Assert
    assertEquals(-1, pdPage.getContents().read(new byte[]{}));
  }

  /**
   * Test {@link PDPage#getContents()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  void testGetContents_givenArrayListAddPDStreamWithDocumentIsCOSDocument2() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));
    contents.add(new PDStream(new COSDocument()));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act and Assert
    assertEquals(-1, pdPage.getContents().read(new byte[]{}));
  }

  /**
   * Test {@link PDPage#getContents()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDPage() Contents is ArrayList(); then return read is minus one")
  void testGetContents_givenPDPageContentsIsArrayList_thenReturnReadIsMinusOne() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new ArrayList<>());

    // Act and Assert
    assertEquals(-1, pdPage.getContents().read(new byte[]{}));
  }

  /**
   * Test {@link PDPage#getContents()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  void testGetContents_givenPDPageWithPageDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPage(new COSDictionary())).getContents().read(new byte[]{}));
  }

  /**
   * Test {@link PDPage#getContents()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDPage(); then return read is minus one")
  void testGetContents_givenPDPage_thenReturnReadIsMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPage()).getContents().read(new byte[]{}));
  }

  /**
   * Test {@link PDPage#getContents()}.
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()} Filters is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDStream(COSDocument) with document is COSDocument() Filters is ArrayList()")
  void testGetContents_givenPDStreamWithDocumentIsCOSDocumentFiltersIsArrayList() throws IOException {
    // Arrange
    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(new ArrayList<>());

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act and Assert
    byte[] byteArray = new byte[1];
    assertEquals(1, pdPage.getContents().read(byteArray));
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Test {@link PDPage#getContents()}.
   * <ul>
   *   <li>Then return read is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return read is one")
  void testGetContents_thenReturnReadIsOne() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new PDStream(new COSDocument()));

    // Act and Assert
    byte[] byteArray = new byte[1];
    assertEquals(1, pdPage.getContents().read(byteArray));
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Test {@link PDPage#getContentsForStreamParsing()}.
   * <p>
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  @DisplayName("Test getContentsForStreamParsing()")
  void testGetContentsForStreamParsing() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForStreamParsing.available());
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForStreamParsing()}.
   * <p>
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  @DisplayName("Test getContentsForStreamParsing()")
  void testGetContentsForStreamParsing2() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));
    contents.add(new PDStream(new COSDocument()));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForStreamParsing.available());
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForStreamParsing()}.
   * <p>
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  @DisplayName("Test getContentsForStreamParsing()")
  void testGetContentsForStreamParsing3() throws IOException {
    // Arrange
    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(new ArrayList<>());

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertEquals(1, actualContentsForStreamParsing.available());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForStreamParsing()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.</li>
   *   <li>Then return available is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  @DisplayName("Test getContentsForStreamParsing(); given ArrayList() add A; then return available is one")
  void testGetContentsForStreamParsing_givenArrayListAddA_thenReturnAvailableIsOne() throws IOException {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertEquals(1, actualContentsForStreamParsing.available());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForStreamParsing()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return available is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  @DisplayName("Test getContentsForStreamParsing(); given ArrayList() add 'null'; then return available is one")
  void testGetContentsForStreamParsing_givenArrayListAddNull_thenReturnAvailableIsOne() throws IOException {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertEquals(1, actualContentsForStreamParsing.available());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForStreamParsing()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  @DisplayName("Test getContentsForStreamParsing(); given PDPage() Contents is ArrayList()")
  void testGetContentsForStreamParsing_givenPDPageContentsIsArrayList() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new ArrayList<>());

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForStreamParsing.available());
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForStreamParsing()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  @DisplayName("Test getContentsForStreamParsing(); given PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  void testGetContentsForStreamParsing_givenPDPageWithPageDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    RandomAccessRead actualContentsForStreamParsing = (new PDPage(new COSDictionary())).getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForStreamParsing.available());
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForStreamParsing()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return available is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  @DisplayName("Test getContentsForStreamParsing(); given PDPage(); then return available is zero")
  void testGetContentsForStreamParsing_givenPDPage_thenReturnAvailableIsZero() throws IOException {
    // Arrange and Act
    RandomAccessRead actualContentsForStreamParsing = (new PDPage()).getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForStreamParsing.available());
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForStreamParsing()}.
   * <ul>
   *   <li>Then return available is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForStreamParsing()}
   */
  @Test
  @DisplayName("Test getContentsForStreamParsing(); then return available is one")
  void testGetContentsForStreamParsing_thenReturnAvailableIsOne() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new PDStream(new COSDocument()));

    // Act
    RandomAccessRead actualContentsForStreamParsing = pdPage.getContentsForStreamParsing();

    // Assert
    assertTrue(actualContentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForStreamParsing.getPosition());
    assertEquals(1, actualContentsForStreamParsing.available());
    assertFalse(actualContentsForStreamParsing.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForRandomAccess()}.
   * <p>
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess()")
  void testGetContentsForRandomAccess() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForRandomAccess.available());
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForRandomAccess()}.
   * <p>
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess()")
  void testGetContentsForRandomAccess2() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));
    contents.add(new PDStream(new COSDocument()));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForRandomAccess.available());
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForRandomAccess()}.
   * <p>
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess()")
  void testGetContentsForRandomAccess3() throws IOException {
    // Arrange
    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(new ArrayList<>());

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForRandomAccess()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.</li>
   *   <li>Then return available is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess(); given ArrayList() add A; then return available is one")
  void testGetContentsForRandomAccess_givenArrayListAddA_thenReturnAvailableIsOne() throws IOException {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForRandomAccess()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return available is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess(); given ArrayList() add 'null'; then return available is one")
  void testGetContentsForRandomAccess_givenArrayListAddNull_thenReturnAvailableIsOne() throws IOException {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForRandomAccess()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess(); given PDPage() Contents is ArrayList()")
  void testGetContentsForRandomAccess_givenPDPageContentsIsArrayList() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new ArrayList<>());

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForRandomAccess.available());
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForRandomAccess()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess(); given PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  void testGetContentsForRandomAccess_givenPDPageWithPageDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    RandomAccessRead actualContentsForRandomAccess = (new PDPage(new COSDictionary())).getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForRandomAccess.available());
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForRandomAccess()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return available is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess(); given PDPage(); then return available is zero")
  void testGetContentsForRandomAccess_givenPDPage_thenReturnAvailableIsZero() throws IOException {
    // Arrange and Act
    RandomAccessRead actualContentsForRandomAccess = (new PDPage()).getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0, actualContentsForRandomAccess.available());
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDPage#getContentsForRandomAccess()}.
   * <ul>
   *   <li>Then return available is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess(); then return available is one")
  void testGetContentsForRandomAccess_thenReturnAvailableIsOne() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new PDStream(new COSDocument()));

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdPage.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDPage#hasContents()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName("Test hasContents(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  void testHasContents_givenArrayListAddPDStreamWithDocumentIsCOSDocument() {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act and Assert
    assertTrue(pdPage.hasContents());
  }

  /**
   * Test {@link PDPage#hasContents()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName("Test hasContents(); given PDPage() Contents is ArrayList(); then return 'false'")
  void testHasContents_givenPDPageContentsIsArrayList_thenReturnFalse() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new ArrayList<>());

    // Act and Assert
    assertFalse(pdPage.hasContents());
  }

  /**
   * Test {@link PDPage#hasContents()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName("Test hasContents(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  void testHasContents_givenPDPageContentsIsPDStreamWithDocumentIsCOSDocument() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new PDStream(new COSDocument()));

    // Act and Assert
    assertTrue(pdPage.hasContents());
  }

  /**
   * Test {@link PDPage#hasContents()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName("Test hasContents(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return 'false'")
  void testHasContents_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDPage(new COSDictionary())).hasContents());
  }

  /**
   * Test {@link PDPage#hasContents()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName("Test hasContents(); given PDPage(); then return 'false'")
  void testHasContents_givenPDPage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDPage()).hasContents());
  }

  /**
   * Test {@link PDPage#getResources()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return 'null'")
  void testGetResources_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage(new COSDictionary())).getResources());
  }

  /**
   * Test {@link PDPage#getResources()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); given PDPage(); then return 'null'")
  void testGetResources_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getResources());
  }

  /**
   * Test {@link PDPage#setResources(PDResources)}.
   * <p>
   * Method under test: {@link PDPage#setResources(PDResources)}
   */
  @Test
  @DisplayName("Test setResources(PDResources)")
  void testSetResources() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDPage pdPage = new PDPage(pageDictionary);
    PDResources resources = new PDResources();

    // Act
    pdPage.setResources(resources);

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    assertSame(resources, pdPage.getResources());
  }

  /**
   * Test {@link PDPage#setResources(PDResources)}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary} Resources is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setResources(PDResources)}
   */
  @Test
  @DisplayName("Test setResources(PDResources); then PDPage(COSDictionary) with pageDictionary is COSDictionary Resources is 'null'")
  void testSetResources_thenPDPageWithPageDictionaryIsCOSDictionaryResourcesIsNull() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).removeItem(Mockito.<COSName>any());
    PDPage pdPage = new PDPage(pageDictionary);

    // Act
    pdPage.setResources(null);

    // Assert
    verify(pageDictionary).removeItem(isA(COSName.class));
    assertNull(pdPage.getResources());
  }

  /**
   * Test {@link PDPage#getStructParents()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} StructParents is minus one.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getStructParents()}
   */
  @Test
  @DisplayName("Test getStructParents(); given PDPage() StructParents is minus one; then return minus one")
  void testGetStructParents_givenPDPageStructParentsIsMinusOne_thenReturnMinusOne() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setStructParents(-1);

    // Act and Assert
    assertEquals(-1, pdPage.getStructParents());
  }

  /**
   * Test {@link PDPage#getStructParents()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getStructParents()}
   */
  @Test
  @DisplayName("Test getStructParents(); given PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  void testGetStructParents_givenPDPageWithPageDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPage(new COSDictionary())).getStructParents());
  }

  /**
   * Test {@link PDPage#getStructParents()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getStructParents()}
   */
  @Test
  @DisplayName("Test getStructParents(); given PDPage(); then return minus one")
  void testGetStructParents_givenPDPage_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPage()).getStructParents());
  }

  /**
   * Test {@link PDPage#setStructParents(int)}.
   * <p>
   * Method under test: {@link PDPage#setStructParents(int)}
   */
  @Test
  @DisplayName("Test setStructParents(int)")
  void testSetStructParents() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setInt(Mockito.<COSName>any(), anyInt());
    PDPage pdPage = new PDPage(pageDictionary);

    // Act
    pdPage.setStructParents(1);

    // Assert that nothing has changed
    verify(pageDictionary).setInt(isA(COSName.class), eq(1));
    assertEquals(0, pdPage.getStructParents());
  }

  /**
   * Test {@link PDPage#getBBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDPage() CropBox is A0; then return COSArray toList size is four")
  void testGetBBox_givenPDPageCropBoxIsA0_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(PDRectangle.A0);

    // Act
    PDRectangle actualBBox = pdPage.getBBox();

    // Assert
    COSArray cOSArray = actualBBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualBBox.getLowerLeftX());
    assertEquals(0.0f, actualBBox.getLowerLeftY());
    assertEquals(612.0f, actualBBox.getWidth());
    assertEquals(792.0f, actualBBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualBBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getBBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDPage(); then return COSArray toList size is four")
  void testGetBBox_givenPDPage_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualBBox = (new PDPage()).getBBox();

    // Assert
    COSArray cOSArray = actualBBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualBBox.getLowerLeftX());
    assertEquals(0.0f, actualBBox.getLowerLeftY());
    assertEquals(612.0f, actualBBox.getWidth());
    assertEquals(792.0f, actualBBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualBBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getBBox()}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()} ArtBox is
   * {@link PDRectangle#LETTER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  void testGetBBox_thenPDPageWithPageDictionaryIsCOSDictionaryArtBoxIsLetter() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualBBox = pdPage.getBBox();

    // Assert
    PDRectangle pdRectangle = actualBBox.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, actualBBox);
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getBBox()}.
   * <ul>
   *   <li>Then return Height is {@code -2.14748288E9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); then return Height is '-2.14748288E9'")
  void testGetBBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualBBox = pdPage.getBBox();

    // Assert
    assertEquals(-2.14748288E9f, actualBBox.getHeight());
    assertEquals(-2.14748301E9f, actualBBox.getWidth());
    assertEquals(2.14748365E9f, actualBBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualBBox.getLowerLeftY());
  }

  /**
   * Test {@link PDPage#getMatrix()}.
   * <p>
   * Method under test: {@link PDPage#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  void testGetMatrix() {
    // Arrange and Act
    Matrix actualMatrix = (new PDPage()).getMatrix();

    // Assert
    assertEquals(0.0f, actualMatrix.getShearX());
    assertEquals(0.0f, actualMatrix.getShearY());
    assertEquals(0.0f, actualMatrix.getTranslateX());
    assertEquals(0.0f, actualMatrix.getTranslateY());
    assertEquals(1.0f, actualMatrix.getScaleX());
    assertEquals(1.0f, actualMatrix.getScaleY());
    assertEquals(1.0f, actualMatrix.getScalingFactorX());
    assertEquals(1.0f, actualMatrix.getScalingFactorY());
    float[][] values = actualMatrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDPage#getMediaBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getMediaBox()}
   */
  @Test
  @DisplayName("Test getMediaBox(); given PDPage(); then return COSArray toList size is four")
  void testGetMediaBox_givenPDPage_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualMediaBox = (new PDPage()).getMediaBox();

    // Assert
    COSArray cOSArray = actualMediaBox.getCOSArray();
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
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualMediaBox.getLowerLeftX());
    assertEquals(0.0f, actualMediaBox.getLowerLeftY());
    assertEquals(612.0f, actualMediaBox.getUpperRightX());
    assertEquals(612.0f, actualMediaBox.getWidth());
    assertEquals(792.0f, actualMediaBox.getHeight());
    assertEquals(792.0f, actualMediaBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualMediaBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getMediaBox()}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()} ArtBox is
   * {@link PDRectangle#LETTER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getMediaBox()}
   */
  @Test
  @DisplayName("Test getMediaBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  void testGetMediaBox_thenPDPageWithPageDictionaryIsCOSDictionaryArtBoxIsLetter() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualMediaBox = pdPage.getMediaBox();

    // Assert
    PDRectangle pdRectangle = actualMediaBox.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, actualMediaBox);
  }

  /**
   * Test {@link PDPage#setMediaBox(PDRectangle)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then {@link PDPage#PDPage()} ArtBox is {@link PDRectangle#A0}
   * {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMediaBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setMediaBox(PDRectangle); given PDPage(); when A0; then PDPage() ArtBox is A0 A0")
  void testSetMediaBox_givenPDPage_whenA0_thenPDPageArtBoxIsA0A0() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDRectangle mediaBox = PDRectangle.A0;

    // Act
    pdPage.setMediaBox(mediaBox);

    // Assert
    PDRectangle pdRectangle = mediaBox.A0;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#setMediaBox(PDRectangle)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDPage#PDPage()} ArtBox is
   * {@link PDRectangle#PDRectangle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMediaBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setMediaBox(PDRectangle); given PDPage(); when PDRectangle(); then PDPage() ArtBox is PDRectangle()")
  void testSetMediaBox_givenPDPage_whenPDRectangle_thenPDPageArtBoxIsPDRectangle() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDRectangle mediaBox = new PDRectangle();

    // Act
    pdPage.setMediaBox(mediaBox);

    // Assert
    assertSame(mediaBox, pdPage.getArtBox());
    assertSame(mediaBox, pdPage.getBBox());
    assertSame(mediaBox, pdPage.getBleedBox());
    assertSame(mediaBox, pdPage.getCropBox());
    assertSame(mediaBox, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getCropBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  @DisplayName("Test getCropBox(); given PDPage() CropBox is A0; then return COSArray toList size is four")
  void testGetCropBox_givenPDPageCropBoxIsA0_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(PDRectangle.A0);

    // Act
    PDRectangle actualCropBox = pdPage.getCropBox();

    // Assert
    COSArray cOSArray = actualCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualCropBox.getLowerLeftX());
    assertEquals(0.0f, actualCropBox.getLowerLeftY());
    assertEquals(612.0f, actualCropBox.getWidth());
    assertEquals(792.0f, actualCropBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualCropBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getCropBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  @DisplayName("Test getCropBox(); given PDPage(); then return COSArray toList size is four")
  void testGetCropBox_givenPDPage_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualCropBox = (new PDPage()).getCropBox();

    // Assert
    COSArray cOSArray = actualCropBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualCropBox.getLowerLeftX());
    assertEquals(0.0f, actualCropBox.getLowerLeftY());
    assertEquals(612.0f, actualCropBox.getWidth());
    assertEquals(792.0f, actualCropBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualCropBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getCropBox()}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()} ArtBox is
   * {@link PDRectangle#LETTER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  @DisplayName("Test getCropBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  void testGetCropBox_thenPDPageWithPageDictionaryIsCOSDictionaryArtBoxIsLetter() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualCropBox = pdPage.getCropBox();

    // Assert
    PDRectangle pdRectangle = actualCropBox.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, actualCropBox);
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getCropBox()}.
   * <ul>
   *   <li>Then return Height is {@code -2.14748288E9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  @DisplayName("Test getCropBox(); then return Height is '-2.14748288E9'")
  void testGetCropBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualCropBox = pdPage.getCropBox();

    // Assert
    assertEquals(-2.14748288E9f, actualCropBox.getHeight());
    assertEquals(-2.14748301E9f, actualCropBox.getWidth());
    assertEquals(2.14748365E9f, actualCropBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualCropBox.getLowerLeftY());
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then {@link PDPage#PDPage()} BBox UpperRightX is six hundred twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setCropBox(PDRectangle); given PDPage(); when A0; then PDPage() BBox UpperRightX is six hundred twelve")
  void testSetCropBox_givenPDPage_whenA0_thenPDPageBBoxUpperRightXIsSixHundredTwelve() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setCropBox(PDRectangle.A0);

    // Assert
    PDRectangle bBox = pdPage.getBBox();
    assertEquals(612.0f, bBox.getUpperRightX());
    PDRectangle bleedBox = pdPage.getBleedBox();
    assertEquals(612.0f, bleedBox.getUpperRightX());
    PDRectangle cropBox = pdPage.getCropBox();
    assertEquals(612.0f, cropBox.getUpperRightX());
    assertEquals(612.0f, bBox.getWidth());
    assertEquals(612.0f, bleedBox.getWidth());
    assertEquals(612.0f, cropBox.getWidth());
    assertEquals(792.0f, bBox.getHeight());
    assertEquals(792.0f, bleedBox.getHeight());
    assertEquals(792.0f, cropBox.getHeight());
    assertEquals(792.0f, bBox.getUpperRightY());
    assertEquals(792.0f, bleedBox.getUpperRightY());
    assertEquals(792.0f, cropBox.getUpperRightY());
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDPage#PDPage()} ArtBox COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setCropBox(PDRectangle); given PDPage(); when 'null'; then PDPage() ArtBox COSArray toList size is four")
  void testSetCropBox_givenPDPage_whenNull_thenPDPageArtBoxCOSArrayToListSizeIsFour() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setCropBox(null);

    // Assert
    PDRectangle artBox = pdPage.getArtBox();
    assertEquals(4, artBox.getCOSArray().toList().size());
    assertEquals(612.0f, artBox.getUpperRightX());
    assertEquals(612.0f, artBox.getWidth());
    assertEquals(792.0f, artBox.getHeight());
    assertEquals(792.0f, artBox.getUpperRightY());
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDPage#PDPage()} MediaBox COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setCropBox(PDRectangle); when PDRectangle(); then PDPage() MediaBox COSArray toList size is four")
  void testSetCropBox_whenPDRectangle_thenPDPageMediaBoxCOSArrayToListSizeIsFour() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setCropBox(new PDRectangle());

    // Assert
    List<? extends COSBase> toListResult = pdPage.getMediaBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    PDRectangle artBox = pdPage.getArtBox();
    assertEquals(0.0f, artBox.getHeight());
    PDRectangle bBox = pdPage.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bleedBox = pdPage.getBleedBox();
    assertEquals(0.0f, bleedBox.getHeight());
    PDRectangle cropBox = pdPage.getCropBox();
    assertEquals(0.0f, cropBox.getHeight());
    assertEquals(0.0f, artBox.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bleedBox.getUpperRightX());
    assertEquals(0.0f, cropBox.getUpperRightX());
    assertEquals(0.0f, artBox.getUpperRightY());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, bleedBox.getUpperRightY());
    assertEquals(0.0f, cropBox.getUpperRightY());
    assertEquals(0.0f, artBox.getWidth());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bleedBox.getWidth());
    assertEquals(0.0f, cropBox.getWidth());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link PDPage#getBleedBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} BleedBox is {@link PDRectangle#A0}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  @DisplayName("Test getBleedBox(); given PDPage() BleedBox is A0; then return COSArray toList size is four")
  void testGetBleedBox_givenPDPageBleedBoxIsA0_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setBleedBox(PDRectangle.A0);

    // Act
    PDRectangle actualBleedBox = pdPage.getBleedBox();

    // Assert
    COSArray cOSArray = actualBleedBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualBleedBox.getLowerLeftX());
    assertEquals(0.0f, actualBleedBox.getLowerLeftY());
    assertEquals(612.0f, actualBleedBox.getWidth());
    assertEquals(792.0f, actualBleedBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualBleedBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getBleedBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  @DisplayName("Test getBleedBox(); given PDPage() CropBox is A0; then return COSArray toList size is four")
  void testGetBleedBox_givenPDPageCropBoxIsA0_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(PDRectangle.A0);

    // Act
    PDRectangle actualBleedBox = pdPage.getBleedBox();

    // Assert
    COSArray cOSArray = actualBleedBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualBleedBox.getLowerLeftX());
    assertEquals(0.0f, actualBleedBox.getLowerLeftY());
    assertEquals(612.0f, actualBleedBox.getWidth());
    assertEquals(792.0f, actualBleedBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualBleedBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getBleedBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  @DisplayName("Test getBleedBox(); given PDPage(); then return COSArray toList size is four")
  void testGetBleedBox_givenPDPage_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualBleedBox = (new PDPage()).getBleedBox();

    // Assert
    COSArray cOSArray = actualBleedBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualBleedBox.getLowerLeftX());
    assertEquals(0.0f, actualBleedBox.getLowerLeftY());
    assertEquals(612.0f, actualBleedBox.getWidth());
    assertEquals(792.0f, actualBleedBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualBleedBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getBleedBox()}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()} ArtBox is
   * {@link PDRectangle#LETTER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  @DisplayName("Test getBleedBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  void testGetBleedBox_thenPDPageWithPageDictionaryIsCOSDictionaryArtBoxIsLetter() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualBleedBox = pdPage.getBleedBox();

    // Assert
    PDRectangle pdRectangle = actualBleedBox.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, actualBleedBox);
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getBleedBox()}.
   * <ul>
   *   <li>Then return Height is {@code -2.14748288E9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  @DisplayName("Test getBleedBox(); then return Height is '-2.14748288E9'")
  void testGetBleedBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualBleedBox = pdPage.getBleedBox();

    // Assert
    assertEquals(-2.14748288E9f, actualBleedBox.getHeight());
    assertEquals(-2.14748301E9f, actualBleedBox.getWidth());
    assertEquals(2.14748365E9f, actualBleedBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualBleedBox.getLowerLeftY());
  }

  /**
   * Test {@link PDPage#setBleedBox(PDRectangle)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDPage#PDPage()} BleedBox Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setBleedBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBleedBox(PDRectangle); given PDPage(); when PDRectangle(); then PDPage() BleedBox Height is zero")
  void testSetBleedBox_givenPDPage_whenPDRectangle_thenPDPageBleedBoxHeightIsZero() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setBleedBox(new PDRectangle());

    // Assert
    PDRectangle bleedBox = pdPage.getBleedBox();
    assertEquals(0.0f, bleedBox.getHeight());
    assertEquals(0.0f, bleedBox.getUpperRightX());
    assertEquals(0.0f, bleedBox.getUpperRightY());
    assertEquals(0.0f, bleedBox.getWidth());
  }

  /**
   * Test {@link PDPage#setBleedBox(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then {@link PDPage#PDPage()} BleedBox UpperRightX is six hundred
   * twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setBleedBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBleedBox(PDRectangle); when A0; then PDPage() BleedBox UpperRightX is six hundred twelve")
  void testSetBleedBox_whenA0_thenPDPageBleedBoxUpperRightXIsSixHundredTwelve() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setBleedBox(PDRectangle.A0);

    // Assert
    PDRectangle bleedBox = pdPage.getBleedBox();
    assertEquals(612.0f, bleedBox.getUpperRightX());
    assertEquals(612.0f, bleedBox.getWidth());
    assertEquals(792.0f, bleedBox.getHeight());
    assertEquals(792.0f, bleedBox.getUpperRightY());
  }

  /**
   * Test {@link PDPage#getTrimBox()}.
   * <p>
   * Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  @DisplayName("Test getTrimBox()")
  void testGetTrimBox() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());
    pdPage.setTrimBox(PDRectangle.A0);

    // Act
    PDRectangle actualTrimBox = pdPage.getTrimBox();

    // Assert
    COSArray cOSArray = actualTrimBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    PDRectangle artBox = pdPage.getArtBox();
    assertTrue(artBox instanceof PDImmutableRectangle);
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualTrimBox.getCOSObject());
    PDRectangle pdRectangle = actualTrimBox.LETTER;
    assertSame(pdRectangle, artBox);
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getTrimBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} TrimBox is {@link PDRectangle#A0}.</li>
   *   <li>Then return LowerLeftX is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  @DisplayName("Test getTrimBox(); given PDPage() TrimBox is A0; then return LowerLeftX is zero")
  void testGetTrimBox_givenPDPageTrimBoxIsA0_thenReturnLowerLeftXIsZero() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setTrimBox(PDRectangle.A0);

    // Act
    PDRectangle actualTrimBox = pdPage.getTrimBox();

    // Assert
    COSArray cOSArray = actualTrimBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualTrimBox.getLowerLeftX());
    assertEquals(0.0f, actualTrimBox.getLowerLeftY());
    assertEquals(612.0f, actualTrimBox.getWidth());
    assertEquals(792.0f, actualTrimBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualTrimBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getTrimBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  @DisplayName("Test getTrimBox(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return 'null'")
  void testGetTrimBox_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage(new COSDictionary())).getTrimBox());
  }

  /**
   * Test {@link PDPage#getTrimBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  @DisplayName("Test getTrimBox(); given PDPage(); then return 'null'")
  void testGetTrimBox_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getTrimBox());
  }

  /**
   * Test {@link PDPage#getTrimBox()}.
   * <ul>
   *   <li>Then return Height is {@code -2.14748288E9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  @DisplayName("Test getTrimBox(); then return Height is '-2.14748288E9'")
  void testGetTrimBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setTrimBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualTrimBox = pdPage.getTrimBox();

    // Assert
    assertEquals(-2.14748288E9f, actualTrimBox.getHeight());
    assertEquals(-2.14748301E9f, actualTrimBox.getWidth());
    assertEquals(2.14748365E9f, actualTrimBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualTrimBox.getLowerLeftY());
  }

  /**
   * Test {@link PDPage#setTrimBox(PDRectangle)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then {@link PDPage#PDPage()} TrimBox UpperRightX is six hundred
   * twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setTrimBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setTrimBox(PDRectangle); given PDPage(); when A0; then PDPage() TrimBox UpperRightX is six hundred twelve")
  void testSetTrimBox_givenPDPage_whenA0_thenPDPageTrimBoxUpperRightXIsSixHundredTwelve() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setTrimBox(PDRectangle.A0);

    // Assert
    PDRectangle trimBox = pdPage.getTrimBox();
    assertEquals(612.0f, trimBox.getUpperRightX());
    assertEquals(612.0f, trimBox.getWidth());
    assertEquals(792.0f, trimBox.getHeight());
    assertEquals(792.0f, trimBox.getUpperRightY());
  }

  /**
   * Test {@link PDPage#setTrimBox(PDRectangle)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDPage#PDPage()} TrimBox Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setTrimBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setTrimBox(PDRectangle); given PDPage(); when PDRectangle(); then PDPage() TrimBox Height is zero")
  void testSetTrimBox_givenPDPage_whenPDRectangle_thenPDPageTrimBoxHeightIsZero() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setTrimBox(new PDRectangle());

    // Assert
    PDRectangle trimBox = pdPage.getTrimBox();
    assertEquals(0.0f, trimBox.getHeight());
    assertEquals(0.0f, trimBox.getUpperRightX());
    assertEquals(0.0f, trimBox.getUpperRightY());
    assertEquals(0.0f, trimBox.getWidth());
  }

  /**
   * Test {@link PDPage#getArtBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} ArtBox is {@link PDRectangle#A0}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  @DisplayName("Test getArtBox(); given PDPage() ArtBox is A0; then return COSArray toList size is four")
  void testGetArtBox_givenPDPageArtBoxIsA0_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setArtBox(PDRectangle.A0);

    // Act
    PDRectangle actualArtBox = pdPage.getArtBox();

    // Assert
    COSArray cOSArray = actualArtBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualArtBox.getLowerLeftX());
    assertEquals(0.0f, actualArtBox.getLowerLeftY());
    assertEquals(612.0f, actualArtBox.getWidth());
    assertEquals(792.0f, actualArtBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualArtBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getArtBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  @DisplayName("Test getArtBox(); given PDPage() CropBox is A0; then return COSArray toList size is four")
  void testGetArtBox_givenPDPageCropBoxIsA0_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(PDRectangle.A0);

    // Act
    PDRectangle actualArtBox = pdPage.getArtBox();

    // Assert
    COSArray cOSArray = actualArtBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualArtBox.getLowerLeftX());
    assertEquals(0.0f, actualArtBox.getLowerLeftY());
    assertEquals(612.0f, actualArtBox.getWidth());
    assertEquals(792.0f, actualArtBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualArtBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getArtBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@link PDRectangle#LETTER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  @DisplayName("Test getArtBox(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return LETTER")
  void testGetArtBox_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnLetter() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualArtBox = pdPage.getArtBox();

    // Assert
    PDRectangle pdRectangle = actualArtBox.LETTER;
    assertSame(pdRectangle, actualArtBox);
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getArtBox()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  @DisplayName("Test getArtBox(); given PDPage(); then return COSArray toList size is four")
  void testGetArtBox_givenPDPage_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualArtBox = (new PDPage()).getArtBox();

    // Assert
    COSArray cOSArray = actualArtBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(0.0f, actualArtBox.getLowerLeftX());
    assertEquals(0.0f, actualArtBox.getLowerLeftY());
    assertEquals(612.0f, actualArtBox.getWidth());
    assertEquals(792.0f, actualArtBox.getHeight());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualArtBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getArtBox()}.
   * <ul>
   *   <li>Then return Height is {@code -2.14748288E9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  @DisplayName("Test getArtBox(); then return Height is '-2.14748288E9'")
  void testGetArtBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualArtBox = pdPage.getArtBox();

    // Assert
    assertEquals(-2.14748288E9f, actualArtBox.getHeight());
    assertEquals(-2.14748301E9f, actualArtBox.getWidth());
    assertEquals(2.14748365E9f, actualArtBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualArtBox.getLowerLeftY());
  }

  /**
   * Test {@link PDPage#setArtBox(PDRectangle)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDPage#PDPage()} BBox COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setArtBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setArtBox(PDRectangle); given PDPage(); when PDRectangle(); then PDPage() BBox COSArray toList size is four")
  void testSetArtBox_givenPDPage_whenPDRectangle_thenPDPageBBoxCOSArrayToListSizeIsFour() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setArtBox(new PDRectangle());

    // Assert
    List<? extends COSBase> toListResult = pdPage.getBBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    PDRectangle artBox = pdPage.getArtBox();
    assertEquals(0.0f, artBox.getHeight());
    assertEquals(0.0f, artBox.getUpperRightX());
    assertEquals(0.0f, artBox.getUpperRightY());
    assertEquals(0.0f, artBox.getWidth());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link PDPage#getRotation()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is ninety.</li>
   *   <li>Then return ninety.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given PDPage() Rotation is ninety; then return ninety")
  void testGetRotation_givenPDPageRotationIsNinety_thenReturnNinety() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setRotation(90);

    // Act and Assert
    assertEquals(90, pdPage.getRotation());
  }

  /**
   * Test {@link PDPage#getRotation()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given PDPage() Rotation is one; then return zero")
  void testGetRotation_givenPDPageRotationIsOne_thenReturnZero() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setRotation(1);

    // Act and Assert
    assertEquals(0, pdPage.getRotation());
  }

  /**
   * Test {@link PDPage#getRotation()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return zero")
  void testGetRotation_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDPage(new COSDictionary())).getRotation());
  }

  /**
   * Test {@link PDPage#getRotation()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given PDPage(); then return zero")
  void testGetRotation_givenPDPage_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDPage()).getRotation());
  }

  /**
   * Test {@link PDPage#setRotation(int)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setInt(COSName, int)}
   * does nothing.</li>
   *   <li>When one.</li>
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int); given COSDictionary setInt(COSName, int) does nothing; when one; then calls setInt(COSName, int)")
  void testSetRotation_givenCOSDictionarySetIntDoesNothing_whenOne_thenCallsSetInt() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setInt(Mockito.<COSName>any(), anyInt());

    // Act
    (new PDPage(pageDictionary)).setRotation(1);

    // Assert that nothing has changed
    verify(pageDictionary).setInt(isA(COSName.class), eq(1));
  }

  /**
   * Test {@link PDPage#setContents(List)} with {@code List}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage()} ContentStreams next DecodeParms is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setContents(List)}
   */
  @Test
  @DisplayName("Test setContents(List) with 'List'; then PDPage() ContentStreams next DecodeParms is 'null'")
  void testSetContentsWithList_thenPDPageContentStreamsNextDecodeParmsIsNull() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    // Act
    pdPage.setContents(contents);

    // Assert
    Iterator<PDStream> contentStreams = pdPage.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertNull(nextResult.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertFalse(contentStreams.hasNext());
  }

  /**
   * Test {@link PDPage#setContents(PDStream)} with {@code PDStream}.
   * <p>
   * Method under test: {@link PDPage#setContents(PDStream)}
   */
  @Test
  @DisplayName("Test setContents(PDStream) with 'PDStream'")
  void testSetContentsWithPDStream() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setContents(new PDStream(new COSDocument()));

    // Assert
    RandomAccessRead contentsForRandomAccess = pdPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = pdPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    Iterator<PDStream> contentStreams = pdPage.getContentStreams();
    assertEquals(-1, contentStreams.next().getDecodedStreamLength());
    byte[] byteArray = new byte[1];
    assertEquals(1, pdPage.getContents().read(byteArray));
    assertEquals(1, contentsForRandomAccess.available());
    assertEquals(1, contentsForStreamParsing.available());
    assertFalse(contentStreams.hasNext());
    assertTrue(pdPage.hasContents());
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Test {@link PDPage#setContents(PDStream)} with {@code PDStream}.
   * <p>
   * Method under test: {@link PDPage#setContents(PDStream)}
   */
  @Test
  @DisplayName("Test setContents(PDStream) with 'PDStream'")
  void testSetContentsWithPDStream2() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    COSDocument document = mock(COSDocument.class);
    when(document.createCOSStream()).thenReturn(cosStream);

    // Act
    pdPage.setContents(new PDStream(document));

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(document).createCOSStream();
    assertNull(pdPage.getContentsForRandomAccess());
    assertNull(pdPage.getContentsForStreamParsing());
    Iterator<PDStream> contentStreams = pdPage.getContentStreams();
    assertEquals(0, contentStreams.next().getDecodedStreamLength());
    assertFalse(contentStreams.hasNext());
  }

  /**
   * Test {@link PDPage#setContents(PDStream)} with {@code PDStream}.
   * <p>
   * Method under test: {@link PDPage#setContents(PDStream)}
   */
  @Test
  @DisplayName("Test setContents(PDStream) with 'PDStream'")
  void testSetContentsWithPDStream3() throws IOException {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDPage pdPage = new PDPage(pageDictionary);

    // Act
    pdPage.setContents(mock(PDStream.class));

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    RandomAccessRead contentsForRandomAccess = pdPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = pdPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForStreamParsing.available());
    assertFalse(pdPage.getContentStreams().hasNext());
  }

  /**
   * Test {@link PDPage#setContents(PDStream)} with {@code PDStream}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setContents(PDStream)}
   */
  @Test
  @DisplayName("Test setContents(PDStream) with 'PDStream'; given COSStream isDirect() return 'false'; then calls getKey()")
  void testSetContentsWithPDStream_givenCOSStreamIsDirectReturnFalse_thenCallsGetKey() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(false);
    when(cosStream.getKey()).thenReturn(new COSObjectKey(1L, 1));
    COSDocument document = mock(COSDocument.class);
    when(document.createCOSStream()).thenReturn(cosStream);

    // Act
    pdPage.setContents(new PDStream(document));

    // Assert
    verify(cosStream, atLeast(1)).getKey();
    verify(cosStream).isDirect();
    verify(document).createCOSStream();
    assertNull(pdPage.getContentsForRandomAccess());
    assertNull(pdPage.getContentsForStreamParsing());
    Iterator<PDStream> contentStreams = pdPage.getContentStreams();
    assertEquals(0, contentStreams.next().getDecodedStreamLength());
    assertFalse(contentStreams.hasNext());
  }

  /**
   * Test {@link PDPage#setContents(PDStream)} with {@code PDStream}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link COSDocument} {@link COSDocument#createCOSStream()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setContents(PDStream)}
   */
  @Test
  @DisplayName("Test setContents(PDStream) with 'PDStream'; given 'null'; when COSDocument createCOSStream() return 'null'")
  void testSetContentsWithPDStream_givenNull_whenCOSDocumentCreateCOSStreamReturnNull() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    COSDocument document = mock(COSDocument.class);
    when(document.createCOSStream()).thenReturn(null);

    // Act
    pdPage.setContents(new PDStream(document));

    // Assert
    verify(document).createCOSStream();
    RandomAccessRead contentsForRandomAccess = pdPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = pdPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForStreamParsing.available());
    assertFalse(pdPage.getContentStreams().hasNext());
  }

  /**
   * Test {@link PDPage#setContents(PDStream)} with {@code PDStream}.
   * <ul>
   *   <li>Then calls
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setContents(PDStream)}
   */
  @Test
  @DisplayName("Test setContents(PDStream) with 'PDStream'; then calls setOriginDocumentState(COSDocumentState)")
  void testSetContentsWithPDStream_thenCallsSetOriginDocumentState() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument document = mock(COSDocument.class);
    when(document.createCOSStream()).thenReturn(cosStream);

    // Act
    pdPage.setContents(new PDStream(document));

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(document).createCOSStream();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    assertNull(pdPage.getContentsForRandomAccess());
    assertNull(pdPage.getContentsForStreamParsing());
    Iterator<PDStream> contentStreams = pdPage.getContentStreams();
    assertEquals(0, contentStreams.next().getDecodedStreamLength());
    assertFalse(contentStreams.hasNext());
  }

  /**
   * Test {@link PDPage#setContents(PDStream)} with {@code PDStream}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setContents(PDStream)}
   */
  @Test
  @DisplayName("Test setContents(PDStream) with 'PDStream'; then throw IllegalArgumentException")
  void testSetContentsWithPDStream_thenThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDStream contents = mock(PDStream.class);
    when(contents.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setContents(contents));
    verify(contents).getCOSObject();
  }

  /**
   * Test {@link PDPage#setContents(PDStream)} with {@code PDStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setContents(PDStream)}
   */
  @Test
  @DisplayName("Test setContents(PDStream) with 'PDStream'; when 'null'")
  void testSetContentsWithPDStream_whenNull() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setContents((PDStream) null);

    // Assert
    RandomAccessRead contentsForRandomAccess = pdPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = pdPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForStreamParsing.available());
    assertFalse(pdPage.getContentStreams().hasNext());
  }

  /**
   * Test {@link PDPage#getThreadBeads()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName("Test getThreadBeads(); given ArrayList() add 'null'; then return first is 'null'")
  void testGetThreadBeads_givenArrayListAddNull_thenReturnFirstIsNull() {
    // Arrange
    ArrayList<PDThreadBead> beads = new ArrayList<>();
    beads.add(null);

    PDPage pdPage = new PDPage();
    pdPage.setThreadBeads(beads);

    // Act
    List<PDThreadBead> actualThreadBeads = pdPage.getThreadBeads();

    // Assert
    assertEquals(1, actualThreadBeads.size());
    assertNull(actualThreadBeads.get(0));
  }

  /**
   * Test {@link PDPage#getThreadBeads()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} ThreadBeads is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName("Test getThreadBeads(); given PDPage() ThreadBeads is ArrayList(); then return Empty")
  void testGetThreadBeads_givenPDPageThreadBeadsIsArrayList_thenReturnEmpty() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setThreadBeads(new ArrayList<>());

    // Act and Assert
    assertTrue(pdPage.getThreadBeads().isEmpty());
  }

  /**
   * Test {@link PDPage#getThreadBeads()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName("Test getThreadBeads(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return Empty")
  void testGetThreadBeads_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDPage(new COSDictionary())).getThreadBeads().isEmpty());
  }

  /**
   * Test {@link PDPage#getThreadBeads()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName("Test getThreadBeads(); given PDPage(); then return Empty")
  void testGetThreadBeads_givenPDPage_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDPage()).getThreadBeads().isEmpty());
  }

  /**
   * Test {@link PDPage#getThreadBeads()}.
   * <ul>
   *   <li>Then return first COSObject UpdateState OriginDocumentState is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName("Test getThreadBeads(); then return first COSObject UpdateState OriginDocumentState is 'null'")
  void testGetThreadBeads_thenReturnFirstCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    ArrayList<PDThreadBead> beads = new ArrayList<>();
    beads.add(new PDThreadBead());

    PDPage pdPage = new PDPage();
    pdPage.setThreadBeads(beads);

    // Act
    List<PDThreadBead> actualThreadBeads = pdPage.getThreadBeads();

    // Assert
    assertEquals(1, actualThreadBeads.size());
    PDThreadBead getResult = actualThreadBeads.get(0);
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getPage());
    PDThreadBead nextBead = getResult.getNextBead();
    assertNull(nextBead.getPage());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertNull(nextBead2.getPage());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertNull(nextBead3.getPage());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    assertNull(nextBead4.getPage());
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    assertNull(nextBead5.getPage());
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    assertNull(nextBead6.getPage());
    PDThreadBead nextBead7 = nextBead6.getNextBead();
    assertNull(nextBead7.getPage());
    PDThreadBead previousBead = getResult.getPreviousBead();
    PDThreadBead nextBead8 = previousBead.getNextBead();
    PDThreadBead nextBead9 = nextBead8.getNextBead();
    PDThreadBead nextBead10 = nextBead9.getNextBead();
    PDThreadBead nextBead11 = nextBead10.getNextBead();
    PDThreadBead nextBead12 = nextBead11.getNextBead();
    assertNull(nextBead12.getPage());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    PDThreadBead nextBead13 = previousBead2.getNextBead();
    PDThreadBead nextBead14 = nextBead13.getNextBead();
    PDThreadBead nextBead15 = nextBead14.getNextBead();
    PDThreadBead nextBead16 = nextBead15.getNextBead();
    PDThreadBead nextBead17 = nextBead16.getNextBead();
    assertNull(nextBead17.getPage());
    assertNull(nextBead11.getPage());
    assertNull(nextBead16.getPage());
    PDThreadBead previousBead3 = nextBead2.getPreviousBead();
    PDThreadBead nextBead18 = previousBead3.getNextBead();
    PDThreadBead nextBead19 = nextBead18.getNextBead();
    PDThreadBead nextBead20 = nextBead19.getNextBead();
    PDThreadBead nextBead21 = nextBead20.getNextBead();
    assertNull(nextBead21.getPage());
    PDThreadBead previousBead4 = previousBead.getPreviousBead();
    PDThreadBead nextBead22 = previousBead4.getNextBead();
    PDThreadBead nextBead23 = nextBead22.getNextBead();
    PDThreadBead nextBead24 = nextBead23.getNextBead();
    PDThreadBead nextBead25 = nextBead24.getNextBead();
    assertNull(nextBead25.getPage());
    assertNull(nextBead10.getPage());
    assertNull(nextBead15.getPage());
    assertNull(nextBead20.getPage());
    PDThreadBead previousBead5 = nextBead3.getPreviousBead();
    PDThreadBead nextBead26 = previousBead5.getNextBead();
    PDThreadBead nextBead27 = nextBead26.getNextBead();
    PDThreadBead nextBead28 = nextBead27.getNextBead();
    assertNull(nextBead28.getPage());
    PDThreadBead previousBead6 = nextBead8.getPreviousBead();
    PDThreadBead nextBead29 = previousBead6.getNextBead();
    PDThreadBead nextBead30 = nextBead29.getNextBead();
    PDThreadBead nextBead31 = nextBead30.getNextBead();
    assertNull(nextBead31.getPage());
    assertNull(nextBead24.getPage());
    PDThreadBead previousBead7 = previousBead2.getPreviousBead();
    PDThreadBead nextBead32 = previousBead7.getNextBead();
    PDThreadBead nextBead33 = nextBead32.getNextBead();
    PDThreadBead nextBead34 = nextBead33.getNextBead();
    assertNull(nextBead34.getPage());
    PDThreadBead previousBead8 = previousBead3.getPreviousBead();
    PDThreadBead nextBead35 = previousBead8.getNextBead();
    PDThreadBead nextBead36 = nextBead35.getNextBead();
    PDThreadBead nextBead37 = nextBead36.getNextBead();
    assertNull(nextBead37.getPage());
    PDThreadBead previousBead9 = previousBead4.getPreviousBead();
    PDThreadBead nextBead38 = previousBead9.getNextBead();
    PDThreadBead nextBead39 = nextBead38.getNextBead();
    PDThreadBead nextBead40 = nextBead39.getNextBead();
    assertNull(nextBead40.getPage());
    assertNull(nextBead9.getPage());
    assertNull(nextBead14.getPage());
    assertNull(nextBead19.getPage());
    assertNull(nextBead27.getPage());
    PDThreadBead previousBead10 = nextBead4.getPreviousBead();
    PDThreadBead nextBead41 = previousBead10.getNextBead();
    PDThreadBead nextBead42 = nextBead41.getNextBead();
    assertNull(nextBead42.getPage());
    PDThreadBead previousBead11 = nextBead9.getPreviousBead();
    PDThreadBead nextBead43 = previousBead11.getNextBead();
    PDThreadBead nextBead44 = nextBead43.getNextBead();
    assertNull(nextBead44.getPage());
    PDThreadBead previousBead12 = nextBead14.getPreviousBead();
    PDThreadBead nextBead45 = previousBead12.getNextBead();
    PDThreadBead nextBead46 = nextBead45.getNextBead();
    assertNull(nextBead46.getPage());
    assertNull(nextBead30.getPage());
    PDThreadBead previousBead13 = nextBead13.getPreviousBead();
    PDThreadBead nextBead47 = previousBead13.getNextBead();
    PDThreadBead nextBead48 = nextBead47.getNextBead();
    assertNull(nextBead48.getPage());
    PDThreadBead previousBead14 = nextBead18.getPreviousBead();
    PDThreadBead nextBead49 = previousBead14.getNextBead();
    PDThreadBead nextBead50 = nextBead49.getNextBead();
    assertNull(nextBead50.getPage());
    PDThreadBead previousBead15 = nextBead22.getPreviousBead();
    PDThreadBead nextBead51 = previousBead15.getNextBead();
    PDThreadBead nextBead52 = nextBead51.getNextBead();
    assertNull(nextBead52.getPage());
    assertNull(nextBead23.getPage());
    assertNull(nextBead33.getPage());
    assertNull(nextBead36.getPage());
    PDThreadBead previousBead16 = previousBead5.getPreviousBead();
    PDThreadBead nextBead53 = previousBead16.getNextBead();
    PDThreadBead nextBead54 = nextBead53.getNextBead();
    assertNull(nextBead54.getPage());
    PDThreadBead previousBead17 = previousBead6.getPreviousBead();
    PDThreadBead nextBead55 = previousBead17.getNextBead();
    PDThreadBead nextBead56 = nextBead55.getNextBead();
    assertNull(nextBead56.getPage());
    assertNull(nextBead39.getPage());
    PDThreadBead previousBead18 = previousBead7.getPreviousBead();
    PDThreadBead nextBead57 = previousBead18.getNextBead();
    PDThreadBead nextBead58 = nextBead57.getNextBead();
    assertNull(nextBead58.getPage());
    PDThreadBead previousBead19 = previousBead8.getPreviousBead();
    PDThreadBead nextBead59 = previousBead19.getNextBead();
    PDThreadBead nextBead60 = nextBead59.getNextBead();
    assertNull(nextBead60.getPage());
    PDThreadBead previousBead20 = previousBead9.getPreviousBead();
    PDThreadBead nextBead61 = previousBead20.getNextBead();
    PDThreadBead nextBead62 = nextBead61.getNextBead();
    assertNull(nextBead62.getPage());
    assertNull(nextBead8.getPage());
    assertNull(nextBead13.getPage());
    assertNull(nextBead18.getPage());
    assertNull(nextBead26.getPage());
    assertNull(nextBead41.getPage());
    PDThreadBead previousBead21 = nextBead5.getPreviousBead();
    PDThreadBead nextBead63 = previousBead21.getNextBead();
    assertNull(nextBead63.getPage());
    PDThreadBead previousBead22 = nextBead10.getPreviousBead();
    PDThreadBead nextBead64 = previousBead22.getNextBead();
    assertNull(nextBead64.getPage());
    PDThreadBead previousBead23 = nextBead15.getPreviousBead();
    PDThreadBead nextBead65 = previousBead23.getNextBead();
    assertNull(nextBead65.getPage());
    assertNull(nextBead43.getPage());
    assertNull(nextBead45.getPage());
    PDThreadBead previousBead24 = nextBead19.getPreviousBead();
    PDThreadBead nextBead66 = previousBead24.getNextBead();
    assertNull(nextBead66.getPage());
    PDThreadBead previousBead25 = nextBead23.getPreviousBead();
    PDThreadBead nextBead67 = previousBead25.getNextBead();
    assertNull(nextBead67.getPage());
    assertNull(nextBead29.getPage());
    assertNull(nextBead47.getPage());
    assertNull(nextBead49.getPage());
    PDThreadBead previousBead26 = nextBead26.getPreviousBead();
    PDThreadBead nextBead68 = previousBead26.getNextBead();
    assertNull(nextBead68.getPage());
    PDThreadBead previousBead27 = nextBead29.getPreviousBead();
    PDThreadBead nextBead69 = previousBead27.getNextBead();
    assertNull(nextBead69.getPage());
    assertNull(nextBead51.getPage());
    PDThreadBead previousBead28 = nextBead32.getPreviousBead();
    PDThreadBead nextBead70 = previousBead28.getNextBead();
    assertNull(nextBead70.getPage());
    PDThreadBead previousBead29 = nextBead35.getPreviousBead();
    PDThreadBead nextBead71 = previousBead29.getNextBead();
    assertNull(nextBead71.getPage());
    PDThreadBead previousBead30 = nextBead38.getPreviousBead();
    PDThreadBead nextBead72 = previousBead30.getNextBead();
    assertNull(nextBead72.getPage());
    assertNull(nextBead22.getPage());
    assertNull(nextBead32.getPage());
    assertNull(nextBead35.getPage());
    assertNull(nextBead53.getPage());
    PDThreadBead previousBead31 = previousBead10.getPreviousBead();
    PDThreadBead nextBead73 = previousBead31.getNextBead();
    assertNull(nextBead73.getPage());
    PDThreadBead previousBead32 = previousBead11.getPreviousBead();
    PDThreadBead nextBead74 = previousBead32.getNextBead();
    assertNull(nextBead74.getPage());
    assertNull(nextBead55.getPage());
    PDThreadBead previousBead33 = previousBead13.getPreviousBead();
    PDThreadBead nextBead75 = previousBead33.getNextBead();
    assertNull(nextBead75.getPage());
    PDThreadBead previousBead34 = previousBead14.getPreviousBead();
    PDThreadBead nextBead76 = previousBead34.getNextBead();
    assertNull(nextBead76.getPage());
    PDThreadBead previousBead35 = previousBead15.getPreviousBead();
    PDThreadBead nextBead77 = previousBead35.getNextBead();
    assertNull(nextBead77.getPage());
    assertNull(nextBead38.getPage());
    assertNull(nextBead57.getPage());
    assertNull(nextBead59.getPage());
    PDThreadBead previousBead36 = previousBead16.getPreviousBead();
    PDThreadBead nextBead78 = previousBead36.getNextBead();
    assertNull(nextBead78.getPage());
    PDThreadBead previousBead37 = previousBead17.getPreviousBead();
    PDThreadBead nextBead79 = previousBead37.getNextBead();
    assertNull(nextBead79.getPage());
    assertNull(nextBead61.getPage());
    PDThreadBead previousBead38 = previousBead18.getPreviousBead();
    PDThreadBead nextBead80 = previousBead38.getNextBead();
    assertNull(nextBead80.getPage());
    PDThreadBead previousBead39 = previousBead19.getPreviousBead();
    PDThreadBead nextBead81 = previousBead39.getNextBead();
    assertNull(nextBead81.getPage());
    PDThreadBead previousBead40 = previousBead20.getPreviousBead();
    PDThreadBead nextBead82 = previousBead40.getNextBead();
    assertNull(nextBead82.getPage());
    assertNull(previousBead.getPage());
    assertNull(previousBead2.getPage());
    assertNull(previousBead3.getPage());
    assertNull(previousBead5.getPage());
    assertNull(previousBead10.getPage());
    assertNull(previousBead21.getPage());
    PDThreadBead previousBead41 = nextBead6.getPreviousBead();
    assertNull(previousBead41.getPage());
    PDThreadBead previousBead42 = nextBead11.getPreviousBead();
    assertNull(previousBead42.getPage());
    PDThreadBead previousBead43 = nextBead16.getPreviousBead();
    assertNull(previousBead43.getPage());
    assertNull(previousBead22.getPage());
    assertNull(previousBead23.getPage());
    PDThreadBead previousBead44 = nextBead20.getPreviousBead();
    assertNull(previousBead44.getPage());
    PDThreadBead previousBead45 = nextBead24.getPreviousBead();
    assertNull(previousBead45.getPage());
    assertNull(previousBead11.getPage());
    assertNull(previousBead12.getPage());
    assertNull(previousBead24.getPage());
    PDThreadBead previousBead46 = nextBead27.getPreviousBead();
    assertNull(previousBead46.getPage());
    PDThreadBead previousBead47 = nextBead30.getPreviousBead();
    assertNull(previousBead47.getPage());
    assertNull(previousBead25.getPage());
    PDThreadBead previousBead48 = nextBead33.getPreviousBead();
    assertNull(previousBead48.getPage());
    PDThreadBead previousBead49 = nextBead36.getPreviousBead();
    assertNull(previousBead49.getPage());
    PDThreadBead previousBead50 = nextBead39.getPreviousBead();
    assertNull(previousBead50.getPage());
    assertNull(previousBead6.getPage());
    assertNull(previousBead13.getPage());
    assertNull(previousBead14.getPage());
    assertNull(previousBead26.getPage());
    PDThreadBead previousBead51 = nextBead41.getPreviousBead();
    assertNull(previousBead51.getPage());
    PDThreadBead previousBead52 = nextBead43.getPreviousBead();
    assertNull(previousBead52.getPage());
    PDThreadBead previousBead53 = nextBead45.getPreviousBead();
    assertNull(previousBead53.getPage());
    assertNull(previousBead27.getPage());
    PDThreadBead previousBead54 = nextBead47.getPreviousBead();
    assertNull(previousBead54.getPage());
    PDThreadBead previousBead55 = nextBead49.getPreviousBead();
    assertNull(previousBead55.getPage());
    PDThreadBead previousBead56 = nextBead51.getPreviousBead();
    assertNull(previousBead56.getPage());
    assertNull(previousBead15.getPage());
    assertNull(previousBead28.getPage());
    assertNull(previousBead29.getPage());
    PDThreadBead previousBead57 = nextBead53.getPreviousBead();
    assertNull(previousBead57.getPage());
    PDThreadBead previousBead58 = nextBead55.getPreviousBead();
    assertNull(previousBead58.getPage());
    assertNull(previousBead30.getPage());
    PDThreadBead previousBead59 = nextBead57.getPreviousBead();
    assertNull(previousBead59.getPage());
    PDThreadBead previousBead60 = nextBead59.getPreviousBead();
    assertNull(previousBead60.getPage());
    PDThreadBead previousBead61 = nextBead61.getPreviousBead();
    assertNull(previousBead61.getPage());
    assertNull(previousBead4.getPage());
    assertNull(previousBead7.getPage());
    assertNull(previousBead8.getPage());
    assertNull(previousBead16.getPage());
    assertNull(previousBead31.getPage());
    PDThreadBead previousBead62 = previousBead21.getPreviousBead();
    assertNull(previousBead62.getPage());
    PDThreadBead previousBead63 = previousBead22.getPreviousBead();
    assertNull(previousBead63.getPage());
    PDThreadBead previousBead64 = previousBead23.getPreviousBead();
    assertNull(previousBead64.getPage());
    assertNull(previousBead32.getPage());
    PDThreadBead previousBead65 = previousBead12.getPreviousBead();
    assertNull(previousBead65.getPage());
    PDThreadBead previousBead66 = previousBead24.getPreviousBead();
    assertNull(previousBead66.getPage());
    PDThreadBead previousBead67 = previousBead25.getPreviousBead();
    assertNull(previousBead67.getPage());
    assertNull(previousBead17.getPage());
    assertNull(previousBead33.getPage());
    assertNull(previousBead34.getPage());
    PDThreadBead previousBead68 = previousBead26.getPreviousBead();
    assertNull(previousBead68.getPage());
    PDThreadBead previousBead69 = previousBead27.getPreviousBead();
    assertNull(previousBead69.getPage());
    assertNull(previousBead35.getPage());
    PDThreadBead previousBead70 = previousBead28.getPreviousBead();
    assertNull(previousBead70.getPage());
    PDThreadBead previousBead71 = previousBead29.getPreviousBead();
    assertNull(previousBead71.getPage());
    PDThreadBead previousBead72 = previousBead30.getPreviousBead();
    assertNull(previousBead72.getPage());
    assertNull(previousBead9.getPage());
    assertNull(previousBead18.getPage());
    assertNull(previousBead19.getPage());
    assertNull(previousBead36.getPage());
    PDThreadBead previousBead73 = previousBead31.getPreviousBead();
    assertNull(previousBead73.getPage());
    PDThreadBead previousBead74 = previousBead32.getPreviousBead();
    assertNull(previousBead74.getPage());
    assertNull(previousBead37.getPage());
    PDThreadBead previousBead75 = previousBead33.getPreviousBead();
    assertNull(previousBead75.getPage());
    PDThreadBead previousBead76 = previousBead34.getPreviousBead();
    assertNull(previousBead76.getPage());
    PDThreadBead previousBead77 = previousBead35.getPreviousBead();
    assertNull(previousBead77.getPage());
    assertNull(previousBead20.getPage());
    assertNull(previousBead38.getPage());
    assertNull(previousBead39.getPage());
    PDThreadBead previousBead78 = previousBead36.getPreviousBead();
    assertNull(previousBead78.getPage());
    PDThreadBead previousBead79 = previousBead37.getPreviousBead();
    assertNull(previousBead79.getPage());
    assertNull(previousBead40.getPage());
    PDThreadBead previousBead80 = previousBead38.getPreviousBead();
    assertNull(previousBead80.getPage());
    PDThreadBead previousBead81 = previousBead39.getPreviousBead();
    assertNull(previousBead81.getPage());
    PDThreadBead previousBead82 = previousBead40.getPreviousBead();
    assertNull(previousBead82.getPage());
    assertNull(getResult.getRectangle());
    assertNull(nextBead.getRectangle());
    assertNull(nextBead2.getRectangle());
    assertNull(nextBead3.getRectangle());
    assertNull(nextBead4.getRectangle());
    assertNull(nextBead5.getRectangle());
    assertNull(nextBead6.getRectangle());
    assertNull(nextBead7.getRectangle());
    assertNull(nextBead12.getRectangle());
    assertNull(nextBead17.getRectangle());
    assertNull(nextBead11.getRectangle());
    assertNull(nextBead16.getRectangle());
    assertNull(nextBead21.getRectangle());
    assertNull(nextBead25.getRectangle());
    assertNull(nextBead10.getRectangle());
    assertNull(nextBead15.getRectangle());
    assertNull(nextBead20.getRectangle());
    assertNull(nextBead28.getRectangle());
    assertNull(nextBead31.getRectangle());
    assertNull(nextBead24.getRectangle());
    assertNull(nextBead34.getRectangle());
    assertNull(nextBead37.getRectangle());
    assertNull(nextBead40.getRectangle());
    assertNull(nextBead9.getRectangle());
    assertNull(nextBead14.getRectangle());
    assertNull(nextBead19.getRectangle());
    assertNull(nextBead27.getRectangle());
    assertNull(nextBead42.getRectangle());
    assertNull(nextBead44.getRectangle());
    assertNull(nextBead46.getRectangle());
    assertNull(nextBead30.getRectangle());
    assertNull(nextBead48.getRectangle());
    assertNull(nextBead50.getRectangle());
    assertNull(nextBead52.getRectangle());
    assertNull(nextBead23.getRectangle());
    assertNull(nextBead33.getRectangle());
    assertNull(nextBead36.getRectangle());
    assertNull(nextBead54.getRectangle());
    assertNull(nextBead56.getRectangle());
    assertNull(nextBead39.getRectangle());
    assertNull(nextBead58.getRectangle());
    assertNull(nextBead60.getRectangle());
    assertNull(nextBead62.getRectangle());
    assertNull(nextBead8.getRectangle());
    assertNull(nextBead13.getRectangle());
    assertNull(nextBead18.getRectangle());
    assertNull(nextBead26.getRectangle());
    assertNull(nextBead41.getRectangle());
    assertNull(nextBead63.getRectangle());
    assertNull(nextBead64.getRectangle());
    assertNull(nextBead65.getRectangle());
    assertNull(nextBead43.getRectangle());
    assertNull(nextBead45.getRectangle());
    assertNull(nextBead66.getRectangle());
    assertNull(nextBead67.getRectangle());
    assertNull(nextBead29.getRectangle());
    assertNull(nextBead47.getRectangle());
    assertNull(nextBead49.getRectangle());
    assertNull(nextBead68.getRectangle());
    assertNull(nextBead69.getRectangle());
    assertNull(nextBead51.getRectangle());
    assertNull(nextBead70.getRectangle());
    assertNull(nextBead71.getRectangle());
    assertNull(nextBead72.getRectangle());
    assertNull(nextBead22.getRectangle());
    assertNull(nextBead32.getRectangle());
    assertNull(nextBead35.getRectangle());
    assertNull(nextBead53.getRectangle());
    assertNull(nextBead73.getRectangle());
    assertNull(nextBead74.getRectangle());
    assertNull(nextBead55.getRectangle());
    assertNull(nextBead75.getRectangle());
    assertNull(nextBead76.getRectangle());
    assertNull(nextBead77.getRectangle());
    assertNull(nextBead38.getRectangle());
    assertNull(nextBead57.getRectangle());
    assertNull(nextBead59.getRectangle());
    assertNull(nextBead78.getRectangle());
    assertNull(nextBead79.getRectangle());
    assertNull(nextBead61.getRectangle());
    assertNull(nextBead80.getRectangle());
    assertNull(nextBead81.getRectangle());
    assertNull(nextBead82.getRectangle());
    assertNull(previousBead.getRectangle());
    assertNull(previousBead2.getRectangle());
    assertNull(previousBead3.getRectangle());
    assertNull(previousBead5.getRectangle());
    assertNull(previousBead10.getRectangle());
    assertNull(previousBead21.getRectangle());
    assertNull(previousBead41.getRectangle());
    assertNull(previousBead42.getRectangle());
    assertNull(previousBead43.getRectangle());
    assertNull(previousBead22.getRectangle());
    assertNull(previousBead23.getRectangle());
    assertNull(previousBead44.getRectangle());
    assertNull(previousBead45.getRectangle());
    assertNull(previousBead11.getRectangle());
    assertNull(previousBead12.getRectangle());
    assertNull(previousBead24.getRectangle());
    assertNull(previousBead46.getRectangle());
    assertNull(previousBead47.getRectangle());
    assertNull(previousBead25.getRectangle());
    assertNull(previousBead48.getRectangle());
    assertNull(previousBead49.getRectangle());
    assertNull(previousBead50.getRectangle());
    assertNull(previousBead6.getRectangle());
    assertNull(previousBead13.getRectangle());
    assertNull(previousBead14.getRectangle());
    assertNull(previousBead26.getRectangle());
    assertNull(previousBead51.getRectangle());
    assertNull(previousBead52.getRectangle());
    assertNull(previousBead27.getRectangle());
    assertNull(previousBead54.getRectangle());
    assertNull(previousBead55.getRectangle());
    assertNull(previousBead56.getRectangle());
    assertNull(previousBead15.getRectangle());
    assertNull(previousBead28.getRectangle());
    assertNull(previousBead29.getRectangle());
    assertNull(previousBead57.getRectangle());
    assertNull(previousBead58.getRectangle());
    assertNull(previousBead30.getRectangle());
    assertNull(previousBead59.getRectangle());
    assertNull(previousBead60.getRectangle());
    assertNull(previousBead61.getRectangle());
    assertNull(previousBead4.getRectangle());
    assertNull(previousBead7.getRectangle());
    assertNull(previousBead8.getRectangle());
    assertNull(previousBead16.getRectangle());
    assertNull(previousBead31.getRectangle());
    assertNull(previousBead62.getRectangle());
    assertNull(previousBead63.getRectangle());
    assertNull(previousBead64.getRectangle());
    assertNull(previousBead32.getRectangle());
    assertNull(previousBead65.getRectangle());
    assertNull(previousBead66.getRectangle());
    assertNull(previousBead67.getRectangle());
    assertNull(previousBead17.getRectangle());
    assertNull(previousBead33.getRectangle());
    assertNull(previousBead34.getRectangle());
    assertNull(previousBead68.getRectangle());
    assertNull(previousBead69.getRectangle());
    assertNull(previousBead35.getRectangle());
    assertNull(previousBead70.getRectangle());
    assertNull(previousBead71.getRectangle());
    assertNull(previousBead72.getRectangle());
    assertNull(previousBead9.getRectangle());
    assertNull(previousBead18.getRectangle());
    assertNull(previousBead19.getRectangle());
    assertNull(previousBead36.getRectangle());
    assertNull(previousBead73.getRectangle());
    assertNull(previousBead74.getRectangle());
    assertNull(previousBead37.getRectangle());
    assertNull(previousBead75.getRectangle());
    assertNull(previousBead76.getRectangle());
    assertNull(previousBead77.getRectangle());
    assertNull(previousBead20.getRectangle());
    assertNull(previousBead38.getRectangle());
    assertNull(previousBead39.getRectangle());
    assertNull(previousBead78.getRectangle());
    assertNull(previousBead79.getRectangle());
    assertNull(previousBead40.getRectangle());
    assertNull(previousBead80.getRectangle());
    assertNull(previousBead81.getRectangle());
    assertNull(previousBead82.getRectangle());
    assertNull(getResult.getThread());
    assertNull(nextBead.getThread());
    assertNull(nextBead2.getThread());
    assertNull(nextBead3.getThread());
    assertNull(nextBead4.getThread());
    assertNull(nextBead5.getThread());
    assertNull(nextBead6.getThread());
    assertNull(nextBead7.getThread());
    assertNull(nextBead12.getThread());
    assertNull(nextBead17.getThread());
    assertNull(nextBead11.getThread());
    assertNull(nextBead16.getThread());
    assertNull(nextBead21.getThread());
    assertNull(nextBead25.getThread());
    assertNull(nextBead10.getThread());
    assertNull(nextBead15.getThread());
    assertNull(nextBead20.getThread());
    assertNull(nextBead28.getThread());
    assertNull(nextBead31.getThread());
    assertNull(nextBead24.getThread());
    assertNull(nextBead34.getThread());
    assertNull(nextBead37.getThread());
    assertNull(nextBead40.getThread());
    assertNull(nextBead9.getThread());
    assertNull(nextBead14.getThread());
    assertNull(nextBead19.getThread());
    assertNull(nextBead27.getThread());
    assertNull(nextBead42.getThread());
    assertNull(nextBead44.getThread());
    assertNull(nextBead46.getThread());
    assertNull(nextBead30.getThread());
    assertNull(nextBead48.getThread());
    assertNull(nextBead50.getThread());
    assertNull(nextBead52.getThread());
    assertNull(nextBead23.getThread());
    assertNull(nextBead33.getThread());
    assertNull(nextBead36.getThread());
    assertNull(nextBead54.getThread());
    assertNull(nextBead56.getThread());
    assertNull(nextBead39.getThread());
    assertNull(nextBead58.getThread());
    assertNull(nextBead60.getThread());
    assertNull(nextBead62.getThread());
    assertNull(nextBead8.getThread());
    assertNull(nextBead13.getThread());
    assertNull(nextBead18.getThread());
    assertNull(nextBead26.getThread());
    assertNull(nextBead41.getThread());
    assertNull(nextBead63.getThread());
    assertNull(nextBead64.getThread());
    assertNull(nextBead65.getThread());
    assertNull(nextBead43.getThread());
    assertNull(nextBead45.getThread());
    assertNull(nextBead66.getThread());
    assertNull(nextBead67.getThread());
    assertNull(nextBead29.getThread());
    assertNull(nextBead47.getThread());
    assertNull(nextBead49.getThread());
    assertNull(nextBead68.getThread());
    assertNull(nextBead69.getThread());
    assertNull(nextBead51.getThread());
    assertNull(nextBead70.getThread());
    assertNull(nextBead71.getThread());
    assertNull(nextBead72.getThread());
    assertNull(nextBead22.getThread());
    assertNull(nextBead32.getThread());
    assertNull(nextBead35.getThread());
    assertNull(nextBead53.getThread());
    assertNull(nextBead73.getThread());
    assertNull(nextBead74.getThread());
    assertNull(nextBead55.getThread());
    assertNull(nextBead75.getThread());
    assertNull(nextBead76.getThread());
    assertNull(nextBead77.getThread());
    assertNull(nextBead38.getThread());
    assertNull(nextBead57.getThread());
    assertNull(nextBead59.getThread());
    assertNull(nextBead78.getThread());
    assertNull(nextBead79.getThread());
    assertNull(nextBead61.getThread());
    assertNull(nextBead80.getThread());
    assertNull(nextBead81.getThread());
    assertNull(nextBead82.getThread());
    assertNull(previousBead.getThread());
    assertNull(previousBead2.getThread());
    assertNull(previousBead3.getThread());
    assertNull(previousBead5.getThread());
    assertNull(previousBead10.getThread());
    assertNull(previousBead21.getThread());
    assertNull(previousBead41.getThread());
    assertNull(previousBead42.getThread());
    assertNull(previousBead43.getThread());
    assertNull(previousBead22.getThread());
    assertNull(previousBead23.getThread());
    assertNull(previousBead44.getThread());
    assertNull(previousBead45.getThread());
    assertNull(previousBead11.getThread());
    assertNull(previousBead12.getThread());
    assertNull(previousBead24.getThread());
    assertNull(previousBead46.getThread());
    assertNull(previousBead47.getThread());
    assertNull(previousBead25.getThread());
    assertNull(previousBead48.getThread());
    assertNull(previousBead49.getThread());
    assertNull(previousBead50.getThread());
    assertNull(previousBead6.getThread());
    assertNull(previousBead13.getThread());
    assertNull(previousBead14.getThread());
    assertNull(previousBead26.getThread());
    assertNull(previousBead51.getThread());
    assertNull(previousBead52.getThread());
    assertNull(previousBead27.getThread());
    assertNull(previousBead54.getThread());
    assertNull(previousBead55.getThread());
    assertNull(previousBead56.getThread());
    assertNull(previousBead15.getThread());
    assertNull(previousBead28.getThread());
    assertNull(previousBead29.getThread());
    assertNull(previousBead57.getThread());
    assertNull(previousBead58.getThread());
    assertNull(previousBead30.getThread());
    assertNull(previousBead59.getThread());
    assertNull(previousBead60.getThread());
    assertNull(previousBead61.getThread());
    assertNull(previousBead4.getThread());
    assertNull(previousBead7.getThread());
    assertNull(previousBead8.getThread());
    assertNull(previousBead16.getThread());
    assertNull(previousBead31.getThread());
    assertNull(previousBead62.getThread());
    assertNull(previousBead63.getThread());
    assertNull(previousBead64.getThread());
    assertNull(previousBead32.getThread());
    assertNull(previousBead65.getThread());
    assertNull(previousBead66.getThread());
    assertNull(previousBead67.getThread());
    assertNull(previousBead17.getThread());
    assertNull(previousBead33.getThread());
    assertNull(previousBead34.getThread());
    assertNull(previousBead68.getThread());
    assertNull(previousBead69.getThread());
    assertNull(previousBead35.getThread());
    assertNull(previousBead70.getThread());
    assertNull(previousBead71.getThread());
    assertNull(previousBead72.getThread());
    assertNull(previousBead9.getThread());
    assertNull(previousBead18.getThread());
    assertNull(previousBead19.getThread());
    assertNull(previousBead36.getThread());
    assertNull(previousBead73.getThread());
    assertNull(previousBead74.getThread());
    assertNull(previousBead37.getThread());
    assertNull(previousBead75.getThread());
    assertNull(previousBead76.getThread());
    assertNull(previousBead77.getThread());
    assertNull(previousBead20.getThread());
    assertNull(previousBead38.getThread());
    assertNull(previousBead39.getThread());
    assertNull(previousBead78.getThread());
    assertNull(previousBead79.getThread());
    assertNull(previousBead40.getThread());
    assertNull(previousBead80.getThread());
    assertNull(previousBead81.getThread());
    assertNull(previousBead82.getThread());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertSame(cOSObject, nextBead.getCOSObject());
    assertSame(cOSObject, nextBead2.getCOSObject());
    assertSame(cOSObject, nextBead3.getCOSObject());
    assertSame(cOSObject, nextBead4.getCOSObject());
    assertSame(cOSObject, nextBead5.getCOSObject());
    assertSame(cOSObject, nextBead6.getCOSObject());
    assertSame(cOSObject, nextBead7.getCOSObject());
    assertSame(cOSObject, nextBead12.getCOSObject());
    assertSame(cOSObject, nextBead17.getCOSObject());
    assertSame(cOSObject, nextBead11.getCOSObject());
    assertSame(cOSObject, nextBead16.getCOSObject());
    assertSame(cOSObject, nextBead21.getCOSObject());
    assertSame(cOSObject, nextBead25.getCOSObject());
    assertSame(cOSObject, nextBead10.getCOSObject());
    assertSame(cOSObject, nextBead15.getCOSObject());
    assertSame(cOSObject, nextBead20.getCOSObject());
    assertSame(cOSObject, nextBead28.getCOSObject());
    assertSame(cOSObject, nextBead31.getCOSObject());
    assertSame(cOSObject, nextBead24.getCOSObject());
    assertSame(cOSObject, nextBead34.getCOSObject());
    assertSame(cOSObject, nextBead37.getCOSObject());
    assertSame(cOSObject, nextBead40.getCOSObject());
    assertSame(cOSObject, nextBead9.getCOSObject());
    assertSame(cOSObject, nextBead14.getCOSObject());
    assertSame(cOSObject, nextBead19.getCOSObject());
    assertSame(cOSObject, nextBead27.getCOSObject());
    assertSame(cOSObject, nextBead42.getCOSObject());
    assertSame(cOSObject, nextBead44.getCOSObject());
    assertSame(cOSObject, nextBead46.getCOSObject());
    assertSame(cOSObject, nextBead30.getCOSObject());
    assertSame(cOSObject, nextBead48.getCOSObject());
    assertSame(cOSObject, nextBead50.getCOSObject());
    assertSame(cOSObject, nextBead52.getCOSObject());
    assertSame(cOSObject, nextBead23.getCOSObject());
    assertSame(cOSObject, nextBead33.getCOSObject());
    assertSame(cOSObject, nextBead36.getCOSObject());
    assertSame(cOSObject, nextBead54.getCOSObject());
    assertSame(cOSObject, nextBead56.getCOSObject());
    assertSame(cOSObject, nextBead39.getCOSObject());
    assertSame(cOSObject, nextBead58.getCOSObject());
    assertSame(cOSObject, nextBead60.getCOSObject());
    assertSame(cOSObject, nextBead62.getCOSObject());
    assertSame(cOSObject, nextBead8.getCOSObject());
    assertSame(cOSObject, nextBead13.getCOSObject());
    assertSame(cOSObject, nextBead18.getCOSObject());
    assertSame(cOSObject, nextBead26.getCOSObject());
    assertSame(cOSObject, nextBead41.getCOSObject());
    assertSame(cOSObject, nextBead63.getCOSObject());
    assertSame(cOSObject, nextBead64.getCOSObject());
    assertSame(cOSObject, nextBead65.getCOSObject());
    assertSame(cOSObject, nextBead43.getCOSObject());
    assertSame(cOSObject, nextBead45.getCOSObject());
    assertSame(cOSObject, nextBead66.getCOSObject());
    assertSame(cOSObject, nextBead67.getCOSObject());
    assertSame(cOSObject, nextBead29.getCOSObject());
    assertSame(cOSObject, nextBead47.getCOSObject());
    assertSame(cOSObject, nextBead49.getCOSObject());
    assertSame(cOSObject, nextBead68.getCOSObject());
    assertSame(cOSObject, nextBead69.getCOSObject());
    assertSame(cOSObject, nextBead51.getCOSObject());
    assertSame(cOSObject, nextBead70.getCOSObject());
    assertSame(cOSObject, nextBead71.getCOSObject());
    assertSame(cOSObject, nextBead72.getCOSObject());
    assertSame(cOSObject, nextBead22.getCOSObject());
    assertSame(cOSObject, nextBead32.getCOSObject());
    assertSame(cOSObject, nextBead35.getCOSObject());
    assertSame(cOSObject, nextBead53.getCOSObject());
    assertSame(cOSObject, nextBead73.getCOSObject());
    assertSame(cOSObject, nextBead74.getCOSObject());
    assertSame(cOSObject, nextBead55.getCOSObject());
    assertSame(cOSObject, nextBead75.getCOSObject());
    assertSame(cOSObject, nextBead76.getCOSObject());
    assertSame(cOSObject, nextBead77.getCOSObject());
    assertSame(cOSObject, nextBead38.getCOSObject());
    assertSame(cOSObject, nextBead57.getCOSObject());
    assertSame(cOSObject, nextBead59.getCOSObject());
    assertSame(cOSObject, nextBead78.getCOSObject());
    assertSame(cOSObject, nextBead79.getCOSObject());
    assertSame(cOSObject, nextBead61.getCOSObject());
    assertSame(cOSObject, nextBead80.getCOSObject());
    assertSame(cOSObject, nextBead81.getCOSObject());
    assertSame(cOSObject, nextBead82.getCOSObject());
    assertSame(cOSObject, previousBead.getCOSObject());
    assertSame(cOSObject, previousBead2.getCOSObject());
    assertSame(cOSObject, previousBead3.getCOSObject());
    assertSame(cOSObject, previousBead5.getCOSObject());
    assertSame(cOSObject, previousBead10.getCOSObject());
    assertSame(cOSObject, previousBead21.getCOSObject());
    assertSame(cOSObject, previousBead41.getCOSObject());
    assertSame(cOSObject, previousBead42.getCOSObject());
    assertSame(cOSObject, previousBead43.getCOSObject());
    assertSame(cOSObject, previousBead22.getCOSObject());
    assertSame(cOSObject, previousBead23.getCOSObject());
    assertSame(cOSObject, previousBead44.getCOSObject());
    assertSame(cOSObject, previousBead45.getCOSObject());
    assertSame(cOSObject, previousBead11.getCOSObject());
    assertSame(cOSObject, previousBead12.getCOSObject());
    assertSame(cOSObject, previousBead24.getCOSObject());
    assertSame(cOSObject, previousBead46.getCOSObject());
    assertSame(cOSObject, previousBead47.getCOSObject());
    assertSame(cOSObject, previousBead25.getCOSObject());
    assertSame(cOSObject, previousBead48.getCOSObject());
    assertSame(cOSObject, previousBead49.getCOSObject());
    assertSame(cOSObject, previousBead50.getCOSObject());
    assertSame(cOSObject, previousBead6.getCOSObject());
    assertSame(cOSObject, previousBead13.getCOSObject());
    assertSame(cOSObject, previousBead14.getCOSObject());
    assertSame(cOSObject, previousBead26.getCOSObject());
    assertSame(cOSObject, previousBead51.getCOSObject());
    assertSame(cOSObject, previousBead52.getCOSObject());
    assertSame(cOSObject, previousBead53.getCOSObject());
    assertSame(cOSObject, previousBead27.getCOSObject());
    assertSame(cOSObject, previousBead54.getCOSObject());
    assertSame(cOSObject, previousBead55.getCOSObject());
    assertSame(cOSObject, previousBead56.getCOSObject());
    assertSame(cOSObject, previousBead15.getCOSObject());
    assertSame(cOSObject, previousBead28.getCOSObject());
    assertSame(cOSObject, previousBead29.getCOSObject());
    assertSame(cOSObject, previousBead57.getCOSObject());
    assertSame(cOSObject, previousBead58.getCOSObject());
    assertSame(cOSObject, previousBead30.getCOSObject());
    assertSame(cOSObject, previousBead59.getCOSObject());
    assertSame(cOSObject, previousBead60.getCOSObject());
    assertSame(cOSObject, previousBead61.getCOSObject());
    assertSame(cOSObject, previousBead4.getCOSObject());
    assertSame(cOSObject, previousBead7.getCOSObject());
    assertSame(cOSObject, previousBead8.getCOSObject());
    assertSame(cOSObject, previousBead16.getCOSObject());
    assertSame(cOSObject, previousBead31.getCOSObject());
    assertSame(cOSObject, previousBead62.getCOSObject());
    assertSame(cOSObject, previousBead63.getCOSObject());
    assertSame(cOSObject, previousBead64.getCOSObject());
    assertSame(cOSObject, previousBead32.getCOSObject());
    assertSame(cOSObject, previousBead65.getCOSObject());
    assertSame(cOSObject, previousBead66.getCOSObject());
    assertSame(cOSObject, previousBead67.getCOSObject());
    assertSame(cOSObject, previousBead17.getCOSObject());
    assertSame(cOSObject, previousBead33.getCOSObject());
    assertSame(cOSObject, previousBead34.getCOSObject());
    assertSame(cOSObject, previousBead68.getCOSObject());
    assertSame(cOSObject, previousBead69.getCOSObject());
    assertSame(cOSObject, previousBead35.getCOSObject());
    assertSame(cOSObject, previousBead70.getCOSObject());
    assertSame(cOSObject, previousBead71.getCOSObject());
    assertSame(cOSObject, previousBead72.getCOSObject());
    assertSame(cOSObject, previousBead9.getCOSObject());
    assertSame(cOSObject, previousBead18.getCOSObject());
    assertSame(cOSObject, previousBead19.getCOSObject());
    assertSame(cOSObject, previousBead36.getCOSObject());
    assertSame(cOSObject, previousBead73.getCOSObject());
    assertSame(cOSObject, previousBead74.getCOSObject());
    assertSame(cOSObject, previousBead37.getCOSObject());
    assertSame(cOSObject, previousBead75.getCOSObject());
    assertSame(cOSObject, previousBead76.getCOSObject());
    assertSame(cOSObject, previousBead77.getCOSObject());
    assertSame(cOSObject, previousBead20.getCOSObject());
    assertSame(cOSObject, previousBead38.getCOSObject());
    assertSame(cOSObject, previousBead39.getCOSObject());
    assertSame(cOSObject, previousBead78.getCOSObject());
    assertSame(cOSObject, previousBead79.getCOSObject());
    assertSame(cOSObject, previousBead40.getCOSObject());
    assertSame(cOSObject, previousBead80.getCOSObject());
    assertSame(cOSObject, previousBead81.getCOSObject());
    assertSame(cOSObject, previousBead82.getCOSObject());
  }

  /**
   * Test {@link PDPage#setThreadBeads(List)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setThreadBeads(List)}
   */
  @Test
  @DisplayName("Test setThreadBeads(List); then throw IllegalArgumentException")
  void testSetThreadBeads_thenThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDThreadBead pdThreadBead = mock(PDThreadBead.class);
    when(pdThreadBead.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    ArrayList<PDThreadBead> beads = new ArrayList<>();
    beads.add(pdThreadBead);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setThreadBeads(beads));
    verify(pdThreadBead).getCOSObject();
  }

  /**
   * Test {@link PDPage#getMetadata()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return 'null'")
  void testGetMetadata_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage(new COSDictionary())).getMetadata());
  }

  /**
   * Test {@link PDPage#getMetadata()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); given PDPage(); then return 'null'")
  void testGetMetadata_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getMetadata());
  }

  /**
   * Test {@link PDPage#getMetadata()}.
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)}
   * with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetMetadata_thenReturnCOSObjectKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSStream str = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);

    str.setKey(key);
    PDMetadata meta = new PDMetadata(str);

    PDPage pdPage = new PDPage();
    pdPage.setMetadata(meta);

    // Act and Assert
    assertSame(key, pdPage.getMetadata().getCOSObject().getKey());
  }

  /**
   * Test {@link PDPage#getMetadata()}.
   * <ul>
   *   <li>Then return DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); then return DecodeParms is 'null'")
  void testGetMetadata_thenReturnDecodeParmsIsNull() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    COSStream str = new COSStream();
    pdPage.setMetadata(new PDMetadata(str));

    // Act
    PDMetadata actualMetadata = pdPage.getMetadata();

    // Assert
    assertNull(actualMetadata.getDecodeParms());
    assertNull(actualMetadata.getFileDecodeParams());
    assertNull(actualMetadata.getMetadata());
    assertNull(actualMetadata.getFile());
    assertEquals(-1, actualMetadata.getDecodedStreamLength());
    assertEquals(0, actualMetadata.getLength());
    List<String> fileFilters = actualMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualMetadata.getCOSObject());
    assertSame(fileFilters, actualMetadata.getFilters());
  }

  /**
   * Test {@link PDPage#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  void testSetMetadata_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDPage(pageDictionary)).setMetadata(mock(PDMetadata.class));

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDPage#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Given {@link COSUpdateState#COSUpdateState(COSUpdateInfo)} with
   * updateInfo is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given COSUpdateState(COSUpdateInfo) with updateInfo is COSArray()")
  void testSetMetadata_givenCOSUpdateStateWithUpdateInfoIsCOSArray() {
    // Arrange
    PDPage pdPage = new PDPage();
    COSStream str = mock(COSStream.class);
    when(str.isDirect()).thenReturn(true);
    when(str.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    // Act
    pdPage.setMetadata(new PDMetadata(str));

    // Assert
    verify(str).isDirect();
    verify(str).getUpdateState();
    assertEquals(0, pdPage.getMetadata().getDecodedStreamLength());
  }

  /**
   * Test {@link PDPage#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link COSStream} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given 'false'; when COSStream isDirect() return 'false'; then calls getKey()")
  void testSetMetadata_givenFalse_whenCOSStreamIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    PDPage pdPage = new PDPage();
    COSStream str = mock(COSStream.class);
    when(str.isDirect()).thenReturn(false);
    when(str.getKey()).thenReturn(new COSObjectKey(1L, 1));

    // Act
    pdPage.setMetadata(new PDMetadata(str));

    // Assert
    verify(str, atLeast(1)).getKey();
    verify(str).isDirect();
    assertEquals(0, pdPage.getMetadata().getDecodedStreamLength());
  }

  /**
   * Test {@link PDPage#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Then calls
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); then calls setOriginDocumentState(COSDocumentState)")
  void testSetMetadata_thenCallsSetOriginDocumentState() {
    // Arrange
    PDPage pdPage = new PDPage();
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream str = mock(COSStream.class);
    when(str.isDirect()).thenReturn(true);
    when(str.getUpdateState()).thenReturn(cosUpdateState);

    // Act
    pdPage.setMetadata(new PDMetadata(str));

    // Assert
    verify(str).isDirect();
    verify(str).getUpdateState();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    assertEquals(0, pdPage.getMetadata().getDecodedStreamLength());
  }

  /**
   * Test {@link PDPage#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage()} Metadata DecodedStreamLength is minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); then PDPage() Metadata DecodedStreamLength is minus one")
  void testSetMetadata_thenPDPageMetadataDecodedStreamLengthIsMinusOne() {
    // Arrange
    PDPage pdPage = new PDPage();
    COSStream str = new COSStream();

    // Act
    pdPage.setMetadata(new PDMetadata(str));

    // Assert
    PDMetadata metadata = pdPage.getMetadata();
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Test {@link PDPage#getActions()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getActions()}
   */
  @Test
  @DisplayName("Test getActions(); given PDPage()")
  void testGetActions_givenPDPage() {
    // Arrange and Act
    PDPageAdditionalActions actualActions = (new PDPage()).getActions();

    // Assert
    COSDictionary cOSObject = actualActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualActions.getC());
    assertNull(actualActions.getO());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDPage#getActions()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Actions is
   * {@link PDPageAdditionalActions#PDPageAdditionalActions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getActions()}
   */
  @Test
  @DisplayName("Test getActions(); given PDPage() Actions is PDPageAdditionalActions()")
  void testGetActions_givenPDPageActionsIsPDPageAdditionalActions() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setActions(new PDPageAdditionalActions());

    // Act
    PDPageAdditionalActions actualActions = pdPage.getActions();

    // Assert
    COSDictionary cOSObject = actualActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualActions.getC());
    assertNull(actualActions.getO());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDPage#getActions()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getActions()}
   */
  @Test
  @DisplayName("Test getActions(); given PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  void testGetActions_givenPDPageWithPageDictionaryIsCOSDictionary() {
    // Arrange and Act
    PDPageAdditionalActions actualActions = (new PDPage(new COSDictionary())).getActions();

    // Assert
    COSDictionary cOSObject = actualActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualActions.getC());
    assertNull(actualActions.getO());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDPage#setActions(PDPageAdditionalActions)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setActions(PDPageAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDPageAdditionalActions); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  void testSetActions_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDPage(pageDictionary)).setActions(mock(PDPageAdditionalActions.class));

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDPage#setActions(PDPageAdditionalActions)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setActions(PDPageAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDPageAdditionalActions); then throw IllegalArgumentException")
  void testSetActions_thenThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDPageAdditionalActions actions = mock(PDPageAdditionalActions.class);
    when(actions.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setActions(actions));
    verify(actions).getCOSObject();
  }

  /**
   * Test {@link PDPage#getTransition()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Transition is
   * {@link PDTransition#PDTransition()}.</li>
   *   <li>Then return {@link PDTransition#PDTransition()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getTransition()}
   */
  @Test
  @DisplayName("Test getTransition(); given PDPage() Transition is PDTransition(); then return PDTransition()")
  void testGetTransition_givenPDPageTransitionIsPDTransition_thenReturnPDTransition() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDTransition transition = new PDTransition();
    pdPage.setTransition(transition);

    // Act and Assert
    assertEquals(transition, pdPage.getTransition());
  }

  /**
   * Test {@link PDPage#getTransition()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getTransition()}
   */
  @Test
  @DisplayName("Test getTransition(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return 'null'")
  void testGetTransition_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage(new COSDictionary())).getTransition());
  }

  /**
   * Test {@link PDPage#getTransition()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getTransition()}
   */
  @Test
  @DisplayName("Test getTransition(); given PDPage(); then return 'null'")
  void testGetTransition_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getTransition());
  }

  /**
   * Test {@link PDPage#setTransition(PDTransition, float)} with
   * {@code transition}, {@code duration}.
   * <p>
   * Method under test: {@link PDPage#setTransition(PDTransition, float)}
   */
  @Test
  @DisplayName("Test setTransition(PDTransition, float) with 'transition', 'duration'")
  void testSetTransitionWithTransitionDuration() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDPage pdPage = new PDPage(pageDictionary);

    // Act
    pdPage.setTransition(new PDTransition(), 10.0f);

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    assertNull(pdPage.getTransition());
  }

  /**
   * Test {@link PDPage#setTransition(PDTransition)} with {@code transition}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setTransition(PDTransition)}
   */
  @Test
  @DisplayName("Test setTransition(PDTransition) with 'transition'; then calls setItem(COSName, COSObjectable)")
  void testSetTransitionWithTransition_thenCallsSetItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDPage pdPage = new PDPage(pageDictionary);

    // Act
    pdPage.setTransition(new PDTransition());

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'")
  void testGetAnnotationsWithAnnotationFilter() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDPage(new COSDictionary())).getAnnotations(mock(AnnotationFilter.class)).isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add 'null'; then return Empty")
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddNull_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertTrue(pdPage.getAnnotations(mock(AnnotationFilter.class)).isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given 'false'")
  void testGetAnnotationsWithAnnotationFilter_givenFalse() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(false);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertTrue(actualAnnotations.isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given PDPage(); then return Empty")
  void testGetAnnotationsWithAnnotationFilter_givenPDPage_thenReturnEmpty() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDPage()).getAnnotations(mock(AnnotationFilter.class)).isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationCaret}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationCaret")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationCaret() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    annotations.add(pdAnnotationCaret);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationCaret);
    assertEquals(pdAnnotationCaret, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationCircle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationCircle")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationCircle() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    annotations.add(pdAnnotationCircle);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationCircle);
    assertEquals(pdAnnotationCircle, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationFileAttachment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationFileAttachment")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationFileAttachment() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    annotations.add(pdAnnotationFileAttachment);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationFileAttachment);
    assertEquals(pdAnnotationFileAttachment, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationFreeText}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationFreeText")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationFreeText() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    annotations.add(pdAnnotationFreeText);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationFreeText);
    assertEquals(pdAnnotationFreeText, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationHighlight}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationHighlight")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationHighlight() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight();
    annotations.add(pdAnnotationHighlight);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationHighlight);
    assertEquals(pdAnnotationHighlight, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationInk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationInk")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationInk() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    annotations.add(pdAnnotationInk);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationInk);
    assertEquals(pdAnnotationInk, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationLine}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationLine")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationLine() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    annotations.add(pdAnnotationLine);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationLine);
    assertEquals(pdAnnotationLine, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationLink}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationLink")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationLink() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    annotations.add(pdAnnotationLink);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationLink);
    assertEquals(pdAnnotationLink, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationPolygon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationPolygon")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationPolygon() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    annotations.add(pdAnnotationPolygon);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationPolygon);
    assertEquals(pdAnnotationPolygon, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationPolyline}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationPolyline")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationPolyline() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    annotations.add(pdAnnotationPolyline);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationPolyline);
    assertEquals(pdAnnotationPolyline, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationPopup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationPopup")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationPopup() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();
    annotations.add(pdAnnotationPopup);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationPopup);
    assertEquals(pdAnnotationPopup, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationRubberStamp}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationRubberStamp")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationRubberStamp() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationRubberStamp pdAnnotationRubberStamp = new PDAnnotationRubberStamp();
    annotations.add(pdAnnotationRubberStamp);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationRubberStamp);
    assertEquals(pdAnnotationRubberStamp, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationSound")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationSound() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound();
    annotations.add(pdAnnotationSound);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationSound);
    assertEquals(pdAnnotationSound, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationSquare}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationSquare")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationSquare() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationSquare pdAnnotationSquare = new PDAnnotationSquare();
    annotations.add(pdAnnotationSquare);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationSquare);
    assertEquals(pdAnnotationSquare, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationUnknown}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationUnknown")
  void testGetAnnotationsWithAnnotationFilter_thenFirstReturnPDAnnotationUnknown() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());
    annotations.add(pdAnnotationCaret);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations(annotationFilter);

    // Assert
    verify(annotationFilter).accept(isA(PDAnnotation.class));
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationUnknown);
    assertEquals(pdAnnotationCaret, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then throw IllegalArgumentException")
  void testGetAnnotationsWithAnnotationFilter_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);
    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any())).thenThrow(new IllegalArgumentException("Caret"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.getAnnotations(annotationFilter));
    verify(annotationFilter).accept(isA(PDAnnotation.class));
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with
   * {@code AnnotationFilter}.
   * <ul>
   *   <li>When {@link AnnotationFilter}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; when AnnotationFilter; then return Empty")
  void testGetAnnotationsWithAnnotationFilter_whenAnnotationFilter_thenReturnEmpty() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(new ArrayList<>());

    // Act and Assert
    assertTrue(pdPage.getAnnotations(mock(AnnotationFilter.class)).isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given ArrayList() add 'null'; then return Empty")
  void testGetAnnotations_givenArrayListAddNull_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertTrue(pdPage.getAnnotations().isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Annotations is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given PDPage() Annotations is ArrayList(); then return Empty")
  void testGetAnnotations_givenPDPageAnnotationsIsArrayList_thenReturnEmpty() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(new ArrayList<>());

    // Act and Assert
    assertTrue(pdPage.getAnnotations().isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return Empty")
  void testGetAnnotations_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnEmpty() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDPage(new COSDictionary())).getAnnotations().isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given PDPage(); then return Empty")
  void testGetAnnotations_givenPDPage_thenReturnEmpty() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDPage()).getAnnotations().isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationCaret}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationCaret")
  void testGetAnnotations_thenFirstReturnPDAnnotationCaret() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    annotations.add(pdAnnotationCaret);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationCaret);
    assertEquals(pdAnnotationCaret, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationCircle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationCircle")
  void testGetAnnotations_thenFirstReturnPDAnnotationCircle() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    annotations.add(pdAnnotationCircle);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationCircle);
    assertEquals(pdAnnotationCircle, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationFileAttachment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationFileAttachment")
  void testGetAnnotations_thenFirstReturnPDAnnotationFileAttachment() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    annotations.add(pdAnnotationFileAttachment);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationFileAttachment);
    assertEquals(pdAnnotationFileAttachment, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationFreeText}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationFreeText")
  void testGetAnnotations_thenFirstReturnPDAnnotationFreeText() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    annotations.add(pdAnnotationFreeText);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationFreeText);
    assertEquals(pdAnnotationFreeText, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationHighlight}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationHighlight")
  void testGetAnnotations_thenFirstReturnPDAnnotationHighlight() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight();
    annotations.add(pdAnnotationHighlight);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationHighlight);
    assertEquals(pdAnnotationHighlight, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationInk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationInk")
  void testGetAnnotations_thenFirstReturnPDAnnotationInk() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    annotations.add(pdAnnotationInk);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationInk);
    assertEquals(pdAnnotationInk, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationLine}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationLine")
  void testGetAnnotations_thenFirstReturnPDAnnotationLine() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    annotations.add(pdAnnotationLine);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationLine);
    assertEquals(pdAnnotationLine, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationLink}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationLink")
  void testGetAnnotations_thenFirstReturnPDAnnotationLink() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    annotations.add(pdAnnotationLink);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationLink);
    assertEquals(pdAnnotationLink, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationPolygon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationPolygon")
  void testGetAnnotations_thenFirstReturnPDAnnotationPolygon() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    annotations.add(pdAnnotationPolygon);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationPolygon);
    assertEquals(pdAnnotationPolygon, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationPolyline}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationPolyline")
  void testGetAnnotations_thenFirstReturnPDAnnotationPolyline() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    annotations.add(pdAnnotationPolyline);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationPolyline);
    assertEquals(pdAnnotationPolyline, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationPopup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationPopup")
  void testGetAnnotations_thenFirstReturnPDAnnotationPopup() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();
    annotations.add(pdAnnotationPopup);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationPopup);
    assertEquals(pdAnnotationPopup, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationRubberStamp}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationRubberStamp")
  void testGetAnnotations_thenFirstReturnPDAnnotationRubberStamp() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationRubberStamp pdAnnotationRubberStamp = new PDAnnotationRubberStamp();
    annotations.add(pdAnnotationRubberStamp);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationRubberStamp);
    assertEquals(pdAnnotationRubberStamp, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationSound")
  void testGetAnnotations_thenFirstReturnPDAnnotationSound() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound();
    annotations.add(pdAnnotationSound);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationSound);
    assertEquals(pdAnnotationSound, getResult);
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationUnknown}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationUnknown")
  void testGetAnnotations_thenFirstReturnPDAnnotationUnknown() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());
    annotations.add(pdAnnotationCaret);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act
    List<PDAnnotation> actualAnnotations = pdPage.getAnnotations();

    // Assert
    assertEquals(1, actualAnnotations.size());
    PDAnnotation getResult = actualAnnotations.get(0);
    assertTrue(getResult instanceof PDAnnotationUnknown);
    assertEquals(pdAnnotationCaret, getResult);
  }

  /**
   * Test {@link PDPage#setAnnotations(List)}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   *   <li>Then {@link PDPage#PDPage()} Annotations is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setAnnotations(List)}
   */
  @Test
  @DisplayName("Test setAnnotations(List); given PDAnnotationCaret(); then PDPage() Annotations is ArrayList()")
  void testSetAnnotations_givenPDAnnotationCaret_thenPDPageAnnotationsIsArrayList() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    // Act
    pdPage.setAnnotations(annotations);

    // Assert
    assertEquals(annotations, pdPage.getAnnotations());
  }

  /**
   * Test {@link PDPage#setAnnotations(List)}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   *   <li>Then {@link PDPage#PDPage()} Annotations size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setAnnotations(List)}
   */
  @Test
  @DisplayName("Test setAnnotations(List); given PDAnnotationCaret(); then PDPage() Annotations size is two")
  void testSetAnnotations_givenPDAnnotationCaret_thenPDPageAnnotationsSizeIsTwo() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    annotations.add(pdAnnotationCaret);

    // Act
    pdPage.setAnnotations(annotations);

    // Assert
    List<PDAnnotation> annotations2 = pdPage.getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(1);
    assertTrue(getResult instanceof PDAnnotationCaret);
    assertEquals(pdAnnotationCaret, getResult);
  }

  /**
   * Test {@link PDPage#equals(Object)}, and {@link PDPage#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDPage#equals(Object)}
   *   <li>{@link PDPage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act and Assert
    assertEquals(pdPage, pdPage);
    int expectedHashCodeResult = pdPage.hashCode();
    assertEquals(expectedHashCodeResult, pdPage.hashCode());
  }

  /**
   * Test {@link PDPage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act and Assert
    assertNotEquals(pdPage, new PDPage());
  }

  /**
   * Test {@link PDPage#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDPage(), null);
  }

  /**
   * Test {@link PDPage#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDPage(), "Different type to PDPage");
  }

  /**
   * Test {@link PDPage#getViewports()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName("Test getViewports(); given ArrayList() add 'null'; then return Empty")
  void testGetViewports_givenArrayListAddNull_thenReturnEmpty() {
    // Arrange
    ArrayList<PDViewportDictionary> viewports = new ArrayList<>();
    viewports.add(null);

    PDPage pdPage = new PDPage();
    pdPage.setViewports(viewports);

    // Act and Assert
    assertTrue(pdPage.getViewports().isEmpty());
  }

  /**
   * Test {@link PDPage#getViewports()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDViewportDictionary#PDViewportDictionary()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName("Test getViewports(); given ArrayList() add PDViewportDictionary(); then return size is one")
  void testGetViewports_givenArrayListAddPDViewportDictionary_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PDViewportDictionary> viewports = new ArrayList<>();
    viewports.add(new PDViewportDictionary());

    PDPage pdPage = new PDPage();
    pdPage.setViewports(viewports);

    // Act
    List<PDViewportDictionary> actualViewports = pdPage.getViewports();

    // Assert
    assertEquals(1, actualViewports.size());
    PDViewportDictionary getResult = actualViewports.get(0);
    assertEquals("Viewport", getResult.getType());
    assertNull(getResult.getName());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getBBox());
    assertNull(getResult.getMeasure());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDPage#getViewports()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Viewports is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName("Test getViewports(); given PDPage() Viewports is ArrayList(); then return Empty")
  void testGetViewports_givenPDPageViewportsIsArrayList_thenReturnEmpty() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setViewports(new ArrayList<>());

    // Act and Assert
    assertTrue(pdPage.getViewports().isEmpty());
  }

  /**
   * Test {@link PDPage#getViewports()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName("Test getViewports(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return 'null'")
  void testGetViewports_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage(new COSDictionary())).getViewports());
  }

  /**
   * Test {@link PDPage#getViewports()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName("Test getViewports(); given PDPage(); then return 'null'")
  void testGetViewports_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getViewports());
  }

  /**
   * Test {@link PDPage#setViewports(List)}.
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary()}.</li>
   *   <li>Then {@link PDPage#PDPage()} Viewports size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setViewports(List)}
   */
  @Test
  @DisplayName("Test setViewports(List); given PDViewportDictionary(); then PDPage() Viewports size is one")
  void testSetViewports_givenPDViewportDictionary_thenPDPageViewportsSizeIsOne() {
    // Arrange
    PDPage pdPage = new PDPage();

    ArrayList<PDViewportDictionary> viewports = new ArrayList<>();
    viewports.add(new PDViewportDictionary());

    // Act
    pdPage.setViewports(viewports);

    // Assert
    List<PDViewportDictionary> viewports2 = pdPage.getViewports();
    assertEquals(1, viewports2.size());
    PDViewportDictionary getResult = viewports2.get(0);
    assertEquals("Viewport", getResult.getType());
    assertNull(getResult.getName());
    assertNull(getResult.getBBox());
    assertNull(getResult.getMeasure());
  }

  /**
   * Test {@link PDPage#setViewports(List)}.
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary()}.</li>
   *   <li>Then {@link PDPage#PDPage()} Viewports size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setViewports(List)}
   */
  @Test
  @DisplayName("Test setViewports(List); given PDViewportDictionary(); then PDPage() Viewports size is two")
  void testSetViewports_givenPDViewportDictionary_thenPDPageViewportsSizeIsTwo() {
    // Arrange
    PDPage pdPage = new PDPage();

    ArrayList<PDViewportDictionary> viewports = new ArrayList<>();
    viewports.add(new PDViewportDictionary());
    viewports.add(new PDViewportDictionary());

    // Act
    pdPage.setViewports(viewports);

    // Assert
    List<PDViewportDictionary> viewports2 = pdPage.getViewports();
    assertEquals(2, viewports2.size());
    PDViewportDictionary getResult = viewports2.get(1);
    assertEquals("Viewport", getResult.getType());
    assertNull(getResult.getName());
    assertNull(getResult.getBBox());
    assertNull(getResult.getMeasure());
  }

  /**
   * Test {@link PDPage#getUserUnit()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} UserUnit is {@link Float#NaN}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  @DisplayName("Test getUserUnit(); given PDPage() UserUnit is NaN; then return one")
  void testGetUserUnit_givenPDPageUserUnitIsNaN_thenReturnOne() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setUserUnit(Float.NaN);

    // Act and Assert
    assertEquals(1.0f, pdPage.getUserUnit());
  }

  /**
   * Test {@link PDPage#getUserUnit()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} UserUnit is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  @DisplayName("Test getUserUnit(); given PDPage() UserUnit is one; then return one")
  void testGetUserUnit_givenPDPageUserUnitIsOne_thenReturnOne() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setUserUnit(1.0f);

    // Act and Assert
    assertEquals(1.0f, pdPage.getUserUnit());
  }

  /**
   * Test {@link PDPage#getUserUnit()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  @DisplayName("Test getUserUnit(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return one")
  void testGetUserUnit_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDPage(new COSDictionary())).getUserUnit());
  }

  /**
   * Test {@link PDPage#getUserUnit()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  @DisplayName("Test getUserUnit(); given PDPage(); then return one")
  void testGetUserUnit_givenPDPage_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDPage()).getUserUnit());
  }

  /**
   * Test {@link PDPage#setUserUnit(float)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setUserUnit(float)}
   */
  @Test
  @DisplayName("Test setUserUnit(float); given PDPage(); when zero; then throw IllegalArgumentException")
  void testSetUserUnit_givenPDPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDPage()).setUserUnit(0.0f));
  }
}
