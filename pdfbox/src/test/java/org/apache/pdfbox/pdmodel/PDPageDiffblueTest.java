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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
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
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.<init>(COSDictionary)", "void PDPage.<init>(COSDictionary, ResourceCache)",
      "ResourceCache PDPage.getResourceCache()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.<init>(COSDictionary)", "void PDPage.<init>(COSDictionary, ResourceCache)",
      "ResourceCache PDPage.getResourceCache()"})
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
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then return ArtBox UpperRightX is {@code 2383.937}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#PDPage(PDRectangle)}
   */
  @Test
  @DisplayName("Test new PDPage(PDRectangle); when A0; then return ArtBox UpperRightX is '2383.937'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.<init>(PDRectangle)"})
  void testNewPDPage_whenA0_thenReturnArtBoxUpperRightXIs2383937() {
    // Arrange and Act
    PDPage actualPdPage = new PDPage(PDRectangle.A0);

    // Assert
    PDRectangle artBox = actualPdPage.getArtBox();
    assertEquals(2383.937f, artBox.getUpperRightX());
    assertEquals(2383.937f, artBox.getWidth());
    assertEquals(3370.3938f, artBox.getHeight());
    assertEquals(3370.3938f, artBox.getUpperRightY());
    assertSame(artBox, actualPdPage.getBBox());
    assertSame(artBox, actualPdPage.getBleedBox());
    assertSame(artBox, actualPdPage.getCropBox());
    assertSame(artBox, actualPdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#PDPage(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then return ArtBox Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#PDPage(PDRectangle)}
   */
  @Test
  @DisplayName("Test new PDPage(PDRectangle); when PDRectangle(); then return ArtBox Height is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.<init>(PDRectangle)"})
  void testNewPDPage_whenPDRectangle_thenReturnArtBoxHeightIsZero() {
    // Arrange and Act
    PDPage actualPdPage = new PDPage(new PDRectangle());

    // Assert
    PDRectangle artBox = actualPdPage.getArtBox();
    assertEquals(0.0f, artBox.getHeight());
    assertEquals(0.0f, artBox.getUpperRightX());
    assertEquals(0.0f, artBox.getUpperRightY());
    assertEquals(0.0f, artBox.getWidth());
    assertSame(artBox, actualPdPage.getBBox());
    assertSame(artBox, actualPdPage.getBleedBox());
    assertSame(artBox, actualPdPage.getCropBox());
    assertSame(artBox, actualPdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getContentStreams()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName("Test getContentStreams(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator PDPage.getContentStreams()"})
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
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertFalse(actualContentStreams.hasNext());
    List<String> fileFilters = nextResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, nextResult.getFilters());
  }

  /**
   * Test {@link PDPage#getContentStreams()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName("Test getContentStreams(); given PDPage() Contents is ArrayList(); then return not hasNext")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator PDPage.getContentStreams()"})
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
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName("Test getContentStreams(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator PDPage.getContentStreams()"})
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
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertFalse(actualContentStreams.hasNext());
    List<String> fileFilters = nextResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, nextResult.getFilters());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator PDPage.getContentStreams()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
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
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
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
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
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
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDPage() Contents is ArrayList(); then return read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
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
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDPage(); then return read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
  void testGetContents_givenPDPage_thenReturnReadIsMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPage()).getContents().read(new byte[]{}));
  }

  /**
   * Test {@link PDPage#getContents()}.
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()} Filters is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDStream(COSDocument) with document is COSDocument() Filters is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
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
   *   <li>Then return read is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return read is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
  void testGetContents_thenReturnReadIsEight() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    PDDocument doc = new PDDocument();
    pdPage.setContents(new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdPage.getContents().read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
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
   * Test {@link PDPage#hasContents()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName("Test hasContents(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPage.hasContents()"})
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
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName("Test hasContents(); given PDPage() Contents is ArrayList(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPage.hasContents()"})
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
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName("Test hasContents(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPage.hasContents()"})
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
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName("Test hasContents(); given PDPage(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPage.hasContents()"})
  void testHasContents_givenPDPage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDPage()).hasContents());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDResources PDPage.getResources()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setResources(PDResources)"})
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#removeItem(COSName)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#removeItem(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setResources(PDResources)}
   */
  @Test
  @DisplayName("Test setResources(PDResources); given COSDictionary removeItem(COSName) does nothing; then calls removeItem(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setResources(PDResources)"})
  void testSetResources_givenCOSDictionaryRemoveItemDoesNothing_thenCallsRemoveItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).removeItem(Mockito.<COSName>any());

    // Act
    (new PDPage(pageDictionary)).setResources(null);

    // Assert that nothing has changed
    verify(pageDictionary).removeItem(isA(COSName.class));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDPage.getStructParents()"})
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
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getStructParents()}
   */
  @Test
  @DisplayName("Test getStructParents(); given PDPage(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDPage.getStructParents()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setStructParents(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getBBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getBBox()"})
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
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link COSDictionary#COSDictionary()} ArtBox is {@link PDRectangle#LETTER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getBBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getBBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Matrix PDPage.getMatrix()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getMediaBox()"})
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
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertEquals(0.0f, actualMediaBox.getLowerLeftX());
    assertEquals(0.0f, actualMediaBox.getLowerLeftY());
    assertEquals(612.0f, actualMediaBox.getUpperRightX());
    assertEquals(612.0f, actualMediaBox.getWidth());
    assertEquals(792.0f, actualMediaBox.getHeight());
    assertEquals(792.0f, actualMediaBox.getUpperRightY());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualMediaBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getMediaBox()}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link COSDictionary#COSDictionary()} ArtBox is {@link PDRectangle#LETTER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getMediaBox()}
   */
  @Test
  @DisplayName("Test getMediaBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getMediaBox()"})
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
   *   <li>Then {@link PDPage#PDPage()} ArtBox is {@link PDRectangle#A0} {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMediaBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setMediaBox(PDRectangle); given PDPage(); when A0; then PDPage() ArtBox is A0 A0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setMediaBox(PDRectangle)"})
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
   *   <li>Then {@link PDPage#PDPage()} ArtBox is {@link PDRectangle#PDRectangle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMediaBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setMediaBox(PDRectangle); given PDPage(); when PDRectangle(); then PDPage() ArtBox is PDRectangle()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setMediaBox(PDRectangle)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getCropBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getCropBox()"})
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
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link COSDictionary#COSDictionary()} ArtBox is {@link PDRectangle#LETTER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  @DisplayName("Test getCropBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getCropBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getCropBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setCropBox(PDRectangle)"})
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
   *   <li>When {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDPage#PDPage()} ArtBox Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setCropBox(PDRectangle); given PDPage(); when PDRectangle(); then PDPage() ArtBox Height is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setCropBox(PDRectangle)"})
  void testSetCropBox_givenPDPage_whenPDRectangle_thenPDPageArtBoxHeightIsZero() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setCropBox(new PDRectangle());

    // Assert
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
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDPage#PDPage()} ArtBox UpperRightX is six hundred twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setCropBox(PDRectangle); when 'null'; then PDPage() ArtBox UpperRightX is six hundred twelve")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setCropBox(PDRectangle)"})
  void testSetCropBox_whenNull_thenPDPageArtBoxUpperRightXIsSixHundredTwelve() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setCropBox(null);

    // Assert that nothing has changed
    PDRectangle artBox = pdPage.getArtBox();
    assertEquals(612.0f, artBox.getUpperRightX());
    assertEquals(612.0f, artBox.getWidth());
    assertEquals(792.0f, artBox.getHeight());
    assertEquals(792.0f, artBox.getUpperRightY());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getBleedBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getBleedBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getBleedBox()"})
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
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link COSDictionary#COSDictionary()} ArtBox is {@link PDRectangle#LETTER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  @DisplayName("Test getBleedBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getBleedBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getBleedBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setBleedBox(PDRectangle)"})
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
   *   <li>Then {@link PDPage#PDPage()} BleedBox UpperRightX is six hundred twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setBleedBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBleedBox(PDRectangle); when A0; then PDPage() BleedBox UpperRightX is six hundred twelve")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setBleedBox(PDRectangle)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getTrimBox()"})
  void testGetTrimBox() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());
    pdPage.setTrimBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getTrimBox()"})
  void testGetTrimBox_givenPDPageTrimBoxIsA0_thenReturnLowerLeftXIsZero() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setTrimBox(PDRectangle.A0);

    // Act
    PDRectangle actualTrimBox = pdPage.getTrimBox();

    // Assert
    assertEquals(0.0f, actualTrimBox.getLowerLeftX());
    assertEquals(0.0f, actualTrimBox.getLowerLeftY());
    assertEquals(612.0f, actualTrimBox.getWidth());
    assertEquals(792.0f, actualTrimBox.getHeight());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getTrimBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getTrimBox()"})
  void testGetTrimBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setTrimBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualTrimBox = pdPage.getTrimBox();

    // Assert
    COSArray cOSArray = actualTrimBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(-2.14748288E9f, actualTrimBox.getHeight());
    assertEquals(-2.14748301E9f, actualTrimBox.getWidth());
    assertEquals(2.14748365E9f, actualTrimBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualTrimBox.getLowerLeftY());
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, actualTrimBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#setTrimBox(PDRectangle)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then {@link PDPage#PDPage()} TrimBox UpperRightX is six hundred twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setTrimBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setTrimBox(PDRectangle); given PDPage(); when A0; then PDPage() TrimBox UpperRightX is six hundred twelve")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setTrimBox(PDRectangle)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setTrimBox(PDRectangle)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getArtBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getArtBox()"})
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
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@link PDRectangle#LETTER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  @DisplayName("Test getArtBox(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return LETTER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getArtBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getArtBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDPage.getArtBox()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setArtBox(PDRectangle)"})
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
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    PDRectangle artBox = pdPage.getArtBox();
    assertEquals(0.0f, artBox.getHeight());
    assertEquals(0.0f, artBox.getUpperRightX());
    assertEquals(0.0f, artBox.getUpperRightY());
    assertEquals(0.0f, artBox.getWidth());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDPage.getRotation()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDPage.getRotation()"})
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
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given PDPage(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDPage.getRotation()"})
  void testGetRotation_givenPDPage_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDPage()).getRotation());
  }

  /**
   * Test {@link PDPage#setRotation(int)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setInt(COSName, int)} does nothing.</li>
   *   <li>When one.</li>
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int); given COSDictionary setInt(COSName, int) does nothing; when one; then calls setInt(COSName, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setRotation(int)"})
  void testSetRotation_givenCOSDictionarySetIntDoesNothing_whenOne_thenCallsSetInt() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setInt(Mockito.<COSName>any(), anyInt());

    // Act
    (new PDPage(pageDictionary)).setRotation(1);

    // Assert
    verify(pageDictionary).setInt(isA(COSName.class), eq(1));
  }

  /**
   * Test {@link PDPage#setContents(List)} with {@code List}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage()} ContentStreams next DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setContents(List)}
   */
  @Test
  @DisplayName("Test setContents(List) with 'List'; then PDPage() ContentStreams next DecodeParms is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setContents(List)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getThreadBeads()"})
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
   *   <li>Given {@link PDPage#PDPage()} ThreadBeads is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName("Test getThreadBeads(); given PDPage() ThreadBeads is ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getThreadBeads()"})
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
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName("Test getThreadBeads(); given PDPage(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getThreadBeads()"})
  void testGetThreadBeads_givenPDPage_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDPage()).getThreadBeads().isEmpty());
  }

  /**
   * Test {@link PDPage#getThreadBeads()}.
   * <ul>
   *   <li>Then return first COSObject Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName("Test getThreadBeads(); then return first COSObject Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getThreadBeads()"})
  void testGetThreadBeads_thenReturnFirstCOSObjectKeyIsNull() {
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
    assertNull(cOSObject.getKey());
    assertNull(getResult.getPage());
    PDThreadBead nextBead = getResult.getNextBead();
    assertNull(nextBead.getPage());
    PDThreadBead previousBead = getResult.getPreviousBead();
    assertNull(previousBead.getPage());
    assertNull(getResult.getRectangle());
    assertNull(nextBead.getRectangle());
    assertNull(previousBead.getRectangle());
    assertNull(getResult.getThread());
    assertNull(nextBead.getThread());
    assertNull(previousBead.getThread());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertSame(cOSObject, nextBead.getCOSObject());
    assertSame(cOSObject, previousBead.getCOSObject());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setThreadBeads(List)"})
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
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); given PDPage(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDMetadata PDPage.getMetadata()"})
  void testGetMetadata_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getMetadata());
  }

  /**
   * Test {@link PDPage#getMetadata()}.
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDMetadata PDPage.getMetadata()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDMetadata PDPage.getMetadata()"})
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setMetadata(PDMetadata)"})
  void testSetMetadata_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDPage(pageDictionary)).setMetadata(mock(PDMetadata.class));

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDPage#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Given {@link COSUpdateState#COSUpdateState(COSUpdateInfo)} with updateInfo is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given COSUpdateState(COSUpdateInfo) with updateInfo is COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setMetadata(PDMetadata)"})
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
   *   <li>When {@link COSStream} {@link COSBase#isDirect()} return {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given 'false'; when COSStream isDirect() return 'false'; then calls getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setMetadata(PDMetadata)"})
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
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setMetadata(PDMetadata)"})
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
   *   <li>Then {@link PDPage#PDPage()} Metadata DecodedStreamLength is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); then PDPage() Metadata DecodedStreamLength is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setMetadata(PDMetadata)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageAdditionalActions PDPage.getActions()"})
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
   *   <li>Given {@link PDPage#PDPage()} Actions is {@link PDPageAdditionalActions#PDPageAdditionalActions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getActions()}
   */
  @Test
  @DisplayName("Test getActions(); given PDPage() Actions is PDPageAdditionalActions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageAdditionalActions PDPage.getActions()"})
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
   * Test {@link PDPage#setActions(PDPageAdditionalActions)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setActions(PDPageAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDPageAdditionalActions); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setActions(PDPageAdditionalActions)"})
  void testSetActions_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDPage(pageDictionary)).setActions(mock(PDPageAdditionalActions.class));

    // Assert
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setActions(PDPageAdditionalActions)"})
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
   *   <li>Given {@link PDPage#PDPage()} Transition is {@link PDTransition#PDTransition()}.</li>
   *   <li>Then return {@link PDTransition#PDTransition()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getTransition()}
   */
  @Test
  @DisplayName("Test getTransition(); given PDPage() Transition is PDTransition(); then return PDTransition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDTransition PDPage.getTransition()"})
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
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getTransition()}
   */
  @Test
  @DisplayName("Test getTransition(); given PDPage(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDTransition PDPage.getTransition()"})
  void testGetTransition_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPage()).getTransition());
  }

  /**
   * Test {@link PDPage#setTransition(PDTransition, float)} with {@code transition}, {@code duration}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setTransition(PDTransition, float)}
   */
  @Test
  @DisplayName("Test setTransition(PDTransition, float) with 'transition', 'duration'; then calls setItem(COSName, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setTransition(PDTransition, float)"})
  void testSetTransitionWithTransitionDuration_thenCallsSetItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDPage pdPage = new PDPage(pageDictionary);

    // Act
    pdPage.setTransition(new PDTransition(), 10.0f);

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setTransition(PDTransition)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddNull() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    // Act and Assert
    assertTrue(pdPage.getAnnotations(mock(AnnotationFilter.class)).isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link AnnotationFilter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given PDPage(); when AnnotationFilter")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenPDPage_whenAnnotationFilter() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDPage()).getAnnotations(mock(AnnotationFilter.class)).isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationCaret}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationCaret")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationCircle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationCircle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationFileAttachment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationFileAttachment")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationFreeText}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationFreeText")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationHighlight}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationHighlight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationInk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationInk")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationLine}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationLine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationLink}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationLink")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationPolygon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationPolygon")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationPolyline}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationPolyline")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationPopup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationPopup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationRubberStamp}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationRubberStamp")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationSound")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationSquare}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationSquare")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then first return {@link PDAnnotationUnknown}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then first return PDAnnotationUnknown")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   * <ul>
   *   <li>When {@link AnnotationFilter}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; when AnnotationFilter; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
   *   <li>Given {@link PDPage#PDPage()} Annotations is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given PDPage() Annotations is ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given PDPage(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
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
   *   <li>Then {@link PDPage#PDPage()} Annotations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#setAnnotations(List)}
   */
  @Test
  @DisplayName("Test setAnnotations(List); given PDAnnotationCaret(); then PDPage() Annotations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setAnnotations(List)"})
  void testSetAnnotations_givenPDAnnotationCaret_thenPDPageAnnotationsSizeIsOne() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    annotations.add(pdAnnotationCaret);

    // Act
    pdPage.setAnnotations(annotations);

    // Assert
    List<PDAnnotation> annotations2 = pdPage.getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationCaret);
    assertEquals(pdAnnotationCaret, getResult);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setAnnotations(List)"})
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
    assertTrue(annotations2.get(0) instanceof PDAnnotationCaret);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPage.equals(Object)", "int PDPage.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPage.equals(Object)", "int PDPage.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPage.equals(Object)", "int PDPage.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPage.equals(Object)", "int PDPage.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getViewports()"})
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
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDViewportDictionary#PDViewportDictionary()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName("Test getViewports(); given ArrayList() add PDViewportDictionary(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getViewports()"})
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
    assertNull(cOSObject.getKey());
    assertNull(getResult.getBBox());
    assertNull(getResult.getMeasure());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDPage#getViewports()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Viewports is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName("Test getViewports(); given PDPage() Viewports is ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getViewports()"})
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
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName("Test getViewports(); given PDPage(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPage.getViewports()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setViewports(List)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setViewports(List)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDPage.getUserUnit()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDPage.getUserUnit()"})
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
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  @DisplayName("Test getUserUnit(); given PDPage(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDPage.getUserUnit()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPage.setUserUnit(float)"})
  void testSetUserUnit_givenPDPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDPage()).setUserUnit(0.0f));
  }
}
