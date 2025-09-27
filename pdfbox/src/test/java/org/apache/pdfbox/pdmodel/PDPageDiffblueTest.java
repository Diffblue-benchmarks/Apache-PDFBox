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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.apache.pdfbox.pdmodel.common.COSArrayList;
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
   *
   * <ul>
   *   <li>Then ResourceCache return {@link DefaultResourceCache}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDPage#PDPage(COSDictionary, ResourceCache)}
   *   <li>{@link PDPage#getResourceCache()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then ResourceCache return DefaultResourceCache")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDPage.<init>(COSDictionary)",
    "void PDPage.<init>(COSDictionary, ResourceCache)",
    "ResourceCache PDPage.getResourceCache()"
  })
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
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return ResourceCache is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDPage#PDPage(COSDictionary)}
   *   <li>{@link PDPage#getResourceCache()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when COSDictionary(); then return ResourceCache is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDPage.<init>(COSDictionary)",
    "void PDPage.<init>(COSDictionary, ResourceCache)",
    "ResourceCache PDPage.getResourceCache()"
  })
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
   *
   * <ul>
   *   <li>When {@link PDRectangle#A0}.
   *   <li>Then return ArtBox UpperRightX is {@code 2383.937}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#PDPage(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test new PDPage(PDRectangle); when A0; then return ArtBox UpperRightX is '2383.937'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link PDPage#getContentStreams()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName(
      "Test getContentStreams(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PDPage.getContentStreams()"})
  void testGetContentStreams_givenArrayListAddPDStreamWithDocumentIsCOSDocument()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName(
      "Test getContentStreams(); given PDPage() Contents is ArrayList(); then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName(
      "Test getContentStreams(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PDPage.getContentStreams()"})
  void testGetContentStreams_givenPDPageContentsIsPDStreamWithDocumentIsCOSDocument()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContentStreams()}
   */
  @Test
  @DisplayName("Test getContentStreams(); given PDPage(); then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PDPage.getContentStreams()"})
  void testGetContentStreams_givenPDPage_thenReturnNotHasNext() {
    // Arrange, Act and Assert
    assertFalse(new PDPage().getContentStreams().hasNext());
  }

  /**
   * Test {@link PDPage#getContents()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then return read is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given ArrayList() add A; then return read is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertArrayEquals(new byte[] {'\n'}, byteArray);
  }

  /**
   * Test {@link PDPage#getContents()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return read is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given ArrayList() add 'null'; then return read is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertArrayEquals(new byte[] {'\n'}, byteArray);
  }

  /**
   * Test {@link PDPage#getContents()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName(
      "Test getContents(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
  void testGetContents_givenArrayListAddPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act and Assert
    int actualReadResult = pdPage.getContents().read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link PDPage#getContents()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName(
      "Test getContents(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
  void testGetContents_givenArrayListAddPDStreamWithDocumentIsCOSDocument2() throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));
    contents.add(new PDStream(new COSDocument()));

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act and Assert
    int actualReadResult = pdPage.getContents().read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link PDPage#getContents()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   *   <li>Then return read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName(
      "Test getContents(); given PDPage() Contents is ArrayList(); then return read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
  void testGetContents_givenPDPageContentsIsArrayList_thenReturnReadIsMinusOne()
      throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new ArrayList<>());

    // Act and Assert
    int actualReadResult = pdPage.getContents().read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link PDPage#getContents()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDPage(); then return read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
  void testGetContents_givenPDPage_thenReturnReadIsMinusOne() throws IOException {
    // Arrange, Act and Assert
    int actualReadResult = new PDPage().getContents().read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link PDPage#getContents()}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} Filters is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName(
      "Test getContents(); given PDStream(COSDocument) with document is COSDocument() Filters is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
  void testGetContents_givenPDStreamWithDocumentIsCOSDocumentFiltersIsArrayList()
      throws IOException {
    // Arrange
    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(new ArrayList<>());

    PDPage pdPage = new PDPage();
    pdPage.setContents(contents);

    // Act and Assert
    byte[] byteArray = new byte[1];
    assertEquals(1, pdPage.getContents().read(byteArray));
    assertArrayEquals(new byte[] {'\n'}, byteArray);
  }

  /**
   * Test {@link PDPage#getContents()}.
   *
   * <ul>
   *   <li>Then return read is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return read is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream PDPage.getContents()"})
  void testGetContents_thenReturnReadIsOne() throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setContents(new PDStream(new COSDocument()));

    // Act and Assert
    byte[] byteArray = new byte[1];
    assertEquals(1, pdPage.getContents().read(byteArray));
    assertArrayEquals(new byte[] {'\n'}, byteArray);
  }

  /**
   * Test {@link PDPage#hasContents()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName(
      "Test hasContents(); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName("Test hasContents(); given PDPage() Contents is ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName(
      "Test hasContents(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#hasContents()}
   */
  @Test
  @DisplayName("Test hasContents(); given PDPage(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPage.hasContents()"})
  void testHasContents_givenPDPage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDPage().hasContents());
  }

  /**
   * Test {@link PDPage#getResources()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); given PDPage(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDResources PDPage.getResources()"})
  void testGetResources_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPage().getResources());
  }

  /**
   * Test {@link PDPage#setResources(PDResources)}.
   *
   * <p>Method under test: {@link PDPage#setResources(PDResources)}
   */
  @Test
  @DisplayName("Test setResources(PDResources)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setResources(PDResources)"})
  void testSetResources() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDPage pdPage = new PDPage(pageDictionary);
    PDResources resources = mock(PDResources.class);

    // Act
    pdPage.setResources(resources);

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    assertSame(resources, pdPage.getResources());
  }

  /**
   * Test {@link PDPage#setResources(PDResources)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#isDirect()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setResources(PDResources)}
   */
  @Test
  @DisplayName(
      "Test setResources(PDResources); given COSDictionary isDirect() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setResources(PDResources)"})
  void testSetResources_givenCOSDictionaryIsDirectThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenThrow(new IllegalArgumentException());

    PDResources resources = mock(PDResources.class);
    when(resources.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setResources(resources));
    verify(cosDictionary).isDirect();
    verify(resources).getCOSObject();
  }

  /**
   * Test {@link PDPage#setResources(PDResources)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setResources(PDResources)}
   */
  @Test
  @DisplayName("Test setResources(PDResources); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setResources(PDResources)"})
  void testSetResources_givenIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    PDResources resources = mock(PDResources.class);
    when(resources.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setResources(resources));
    verify(resources).getCOSObject();
  }

  /**
   * Test {@link PDPage#getStructParents()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} StructParents is minus one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getStructParents()}
   */
  @Test
  @DisplayName(
      "Test getStructParents(); given PDPage() StructParents is minus one; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getStructParents()}
   */
  @Test
  @DisplayName("Test getStructParents(); given PDPage(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPage.getStructParents()"})
  void testGetStructParents_givenPDPage_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPage().getStructParents());
  }

  /**
   * Test {@link PDPage#setStructParents(int)}.
   *
   * <p>Method under test: {@link PDPage#setStructParents(int)}
   */
  @Test
  @DisplayName("Test setStructParents(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getBBox()}
   */
  @Test
  @DisplayName(
      "Test getBBox(); given PDPage() CropBox is A0; then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDPage(); then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getBBox()"})
  void testGetBBox_givenPDPage_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualBBox = new PDPage().getBBox();

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
   *
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link
   *       COSDictionary#COSDictionary()} ArtBox is {@link PDRectangle#LETTER}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getBBox()}
   */
  @Test
  @DisplayName(
      "Test getBBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getBBox()"})
  void testGetBBox_thenPDPageWithPageDictionaryIsCOSDictionaryArtBoxIsLetter() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualBBox = pdPage.getBBox();

    // Assert
    PDRectangle pdRectangle = PDRectangle.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, actualBBox);
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getBBox()}.
   *
   * <ul>
   *   <li>Then return Height is {@code -2.14748288E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); then return Height is '-2.14748288E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getBBox()"})
  void testGetBBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDRectangle cropBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    pdPage.setCropBox(cropBox);

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
   *
   * <p>Method under test: {@link PDPage#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDPage.getMatrix()"})
  void testGetMatrix() {
    // Arrange and Act
    Matrix actualMatrix = new PDPage().getMatrix();

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
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDPage#getMediaBox()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getMediaBox()}
   */
  @Test
  @DisplayName("Test getMediaBox(); given PDPage(); then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getMediaBox()"})
  void testGetMediaBox_givenPDPage_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualMediaBox = new PDPage().getMediaBox();

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
   *
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link
   *       COSDictionary#COSDictionary()} ArtBox is {@link PDRectangle#LETTER}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getMediaBox()}
   */
  @Test
  @DisplayName(
      "Test getMediaBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getMediaBox()"})
  void testGetMediaBox_thenPDPageWithPageDictionaryIsCOSDictionaryArtBoxIsLetter() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualMediaBox = pdPage.getMediaBox();

    // Assert
    PDRectangle pdRectangle = PDRectangle.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, actualMediaBox);
  }

  /**
   * Test {@link PDPage#setMediaBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDRectangle#A0}.
   *   <li>Then {@link PDPage#PDPage()} ArtBox is {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setMediaBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setMediaBox(PDRectangle); given PDPage(); when A0; then PDPage() ArtBox is A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setMediaBox(PDRectangle)"})
  void testSetMediaBox_givenPDPage_whenA0_thenPDPageArtBoxIsA0() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setMediaBox(PDRectangle.A0);

    // Assert
    PDRectangle pdRectangle = PDRectangle.A0;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#setMediaBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDRectangle#LETTER}.
   *   <li>Then {@link PDPage#PDPage()} ArtBox is {@link PDRectangle#LETTER}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setMediaBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setMediaBox(PDRectangle); given PDPage(); when LETTER; then PDPage() ArtBox is LETTER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setMediaBox(PDRectangle)"})
  void testSetMediaBox_givenPDPage_whenLetter_thenPDPageArtBoxIsLetter() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setMediaBox(PDRectangle.LETTER);

    // Assert
    PDRectangle pdRectangle = PDRectangle.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getCropBox()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  @DisplayName(
      "Test getCropBox(); given PDPage() CropBox is A0; then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  @DisplayName("Test getCropBox(); given PDPage(); then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getCropBox()"})
  void testGetCropBox_givenPDPage_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualCropBox = new PDPage().getCropBox();

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
   *
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link
   *       COSDictionary#COSDictionary()} ArtBox is {@link PDRectangle#LETTER}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  @DisplayName(
      "Test getCropBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getCropBox()"})
  void testGetCropBox_thenPDPageWithPageDictionaryIsCOSDictionaryArtBoxIsLetter() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualCropBox = pdPage.getCropBox();

    // Assert
    PDRectangle pdRectangle = PDRectangle.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, actualCropBox);
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getCropBox()}.
   *
   * <ul>
   *   <li>Then return Height is {@code -2.14748288E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getCropBox()}
   */
  @Test
  @DisplayName("Test getCropBox(); then return Height is '-2.14748288E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getCropBox()"})
  void testGetCropBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDRectangle cropBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    pdPage.setCropBox(cropBox);

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
   *
   * <p>Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setCropBox(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setCropBox(PDRectangle)"})
  void testSetCropBox() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setDirect(false);
    cosArray.setKey(new COSObjectKey(1L, 1));

    PDRectangle cropBox = mock(PDRectangle.class);
    when(cropBox.getCOSArray()).thenReturn(cosArray);

    // Act
    pdPage.setCropBox(cropBox);

    // Assert
    verify(cropBox).getCOSArray();
    PDRectangle artBox = pdPage.getArtBox();
    assertEquals(0.0f, artBox.getHeight());
    PDRectangle bBox = pdPage.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bleedBox = pdPage.getBleedBox();
    assertEquals(0.0f, bleedBox.getHeight());
    PDRectangle cropBox2 = pdPage.getCropBox();
    assertEquals(0.0f, cropBox2.getHeight());
    assertEquals(0.0f, artBox.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bleedBox.getUpperRightX());
    assertEquals(0.0f, cropBox2.getUpperRightX());
    assertEquals(0.0f, artBox.getUpperRightY());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, bleedBox.getUpperRightY());
    assertEquals(0.0f, cropBox2.getUpperRightY());
    assertEquals(0.0f, artBox.getWidth());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bleedBox.getWidth());
    assertEquals(0.0f, cropBox2.getWidth());
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   *
   * <p>Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setCropBox(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setCropBox(PDRectangle)"})
  void testSetCropBox2() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(cosArray).setDirect(anyBoolean());
    doNothing().when(cosArray).setKey(Mockito.<COSObjectKey>any());
    cosArray.setDirect(false);
    cosArray.setKey(null);

    PDRectangle cropBox = mock(PDRectangle.class);
    when(cropBox.getCOSArray()).thenReturn(cosArray);

    // Act
    pdPage.setCropBox(cropBox);

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosArray).setDirect(false);
    verify(cosArray).setKey(isNull());
    verify(cropBox).getCOSArray();
    List<? extends COSBase> toListResult = pdPage.getMediaBox().getCOSArray().toList();
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
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   *
   * <p>Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setCropBox(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setCropBox(PDRectangle)"})
  void testSetCropBox3() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage pdPage = new PDPage(pageDictionary);

    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).setDirect(anyBoolean());
    doNothing().when(cosArray).setKey(Mockito.<COSObjectKey>any());
    cosArray.setDirect(false);
    cosArray.setKey(null);

    PDRectangle cropBox = mock(PDRectangle.class);
    when(cropBox.getCOSArray()).thenReturn(cosArray);

    // Act
    pdPage.setCropBox(cropBox);

    // Assert that nothing has changed
    verify(cosArray).setDirect(false);
    verify(cosArray).setKey(isNull());
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cropBox).getCOSArray();
    PDRectangle artBox = pdPage.getArtBox();
    assertTrue(artBox instanceof PDImmutableRectangle);
    assertEquals(612.0f, artBox.getUpperRightX());
    assertEquals(612.0f, artBox.getWidth());
    assertEquals(792.0f, artBox.getHeight());
    assertEquals(792.0f, artBox.getUpperRightY());
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setCropBox(PDRectangle); given COSArray(List) with cosObjectables is ArrayList() Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setCropBox(PDRectangle)"})
  void testSetCropBox_givenCOSArrayWithCosObjectablesIsArrayListKeyIsNull() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setDirect(false);
    cosArray.setKey(null);

    PDRectangle cropBox = mock(PDRectangle.class);
    when(cropBox.getCOSArray()).thenReturn(cosArray);

    // Act
    pdPage.setCropBox(cropBox);

    // Assert
    verify(cropBox).getCOSArray();
    PDRectangle artBox = pdPage.getArtBox();
    assertEquals(0.0f, artBox.getHeight());
    PDRectangle bBox = pdPage.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bleedBox = pdPage.getBleedBox();
    assertEquals(0.0f, bleedBox.getHeight());
    PDRectangle cropBox2 = pdPage.getCropBox();
    assertEquals(0.0f, cropBox2.getHeight());
    assertEquals(0.0f, artBox.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bleedBox.getUpperRightX());
    assertEquals(0.0f, cropBox2.getUpperRightX());
    assertEquals(0.0f, artBox.getUpperRightY());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, bleedBox.getUpperRightY());
    assertEquals(0.0f, cropBox2.getUpperRightY());
    assertEquals(0.0f, artBox.getWidth());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bleedBox.getWidth());
    assertEquals(0.0f, cropBox2.getWidth());
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setCropBox(PDRectangle); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setCropBox(PDRectangle)"})
  void testSetCropBox_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    PDRectangle cropBox = mock(PDRectangle.class);
    when(cropBox.getCOSArray()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setCropBox(cropBox));
    verify(cropBox).getCOSArray();
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setCropBox(PDRectangle); given 'null'; when PDRectangle getCOSArray() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setCropBox(PDRectangle)"})
  void testSetCropBox_givenNull_whenPDRectangleGetCOSArrayReturnNull() {
    // Arrange
    PDPage pdPage = new PDPage();

    PDRectangle cropBox = mock(PDRectangle.class);
    when(cropBox.getCOSArray()).thenReturn(null);

    // Act
    pdPage.setCropBox(cropBox);

    // Assert that nothing has changed
    verify(cropBox).getCOSArray();
    PDRectangle artBox = pdPage.getArtBox();
    assertEquals(612.0f, artBox.getUpperRightX());
    assertEquals(612.0f, artBox.getWidth());
    assertEquals(792.0f, artBox.getHeight());
    assertEquals(792.0f, artBox.getUpperRightY());
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDRectangle#A0}.
   *   <li>Then {@link PDPage#PDPage()} BBox COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setCropBox(PDRectangle); given PDPage(); when A0; then PDPage() BBox COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setCropBox(PDRectangle)"})
  void testSetCropBox_givenPDPage_whenA0_thenPDPageBBoxCOSArrayToListSizeIsFour() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setCropBox(PDRectangle.A0);

    // Assert
    List<? extends COSBase> toListResult = pdPage.getBBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    List<? extends COSBase> toListResult2 = pdPage.getBleedBox().getCOSArray().toList();
    assertEquals(4, toListResult2.size());
    assertTrue(toListResult2.get(0) instanceof COSFloat);
    assertTrue(toListResult2.get(1) instanceof COSFloat);
    List<? extends COSBase> toListResult3 = pdPage.getCropBox().getCOSArray().toList();
    assertEquals(4, toListResult3.size());
    assertTrue(toListResult3.get(0) instanceof COSFloat);
    assertTrue(toListResult3.get(1) instanceof COSFloat);
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setCropBox(PDRectangle); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setCropBox(PDRectangle)"})
  void testSetCropBox_thenCallsSetOriginDocumentState() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    doNothing().when(cosArray).setDirect(anyBoolean());
    doNothing().when(cosArray).setKey(Mockito.<COSObjectKey>any());
    cosArray.setDirect(false);
    cosArray.setKey(null);

    PDRectangle cropBox = mock(PDRectangle.class);
    when(cropBox.getCOSArray()).thenReturn(cosArray);

    // Act
    pdPage.setCropBox(cropBox);

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosArray).setDirect(false);
    verify(cosArray).setKey(isNull());
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(cropBox).getCOSArray();
    List<? extends COSBase> toListResult = pdPage.getMediaBox().getCOSArray().toList();
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
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link PDPage#setCropBox(PDRectangle)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDPage#PDPage()} ArtBox UpperRightX is six hundred twelve.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setCropBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setCropBox(PDRectangle); when 'null'; then PDPage() ArtBox UpperRightX is six hundred twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} BleedBox is {@link PDRectangle#A0}.
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  @DisplayName(
      "Test getBleedBox(); given PDPage() BleedBox is A0; then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  @DisplayName(
      "Test getBleedBox(); given PDPage() CropBox is A0; then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  @DisplayName("Test getBleedBox(); given PDPage(); then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getBleedBox()"})
  void testGetBleedBox_givenPDPage_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualBleedBox = new PDPage().getBleedBox();

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
   *
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link
   *       COSDictionary#COSDictionary()} ArtBox is {@link PDRectangle#LETTER}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  @DisplayName(
      "Test getBleedBox(); then PDPage(COSDictionary) with pageDictionary is COSDictionary() ArtBox is LETTER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getBleedBox()"})
  void testGetBleedBox_thenPDPageWithPageDictionaryIsCOSDictionaryArtBoxIsLetter() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act
    PDRectangle actualBleedBox = pdPage.getBleedBox();

    // Assert
    PDRectangle pdRectangle = PDRectangle.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, actualBleedBox);
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getBleedBox()}.
   *
   * <ul>
   *   <li>Then return Height is {@code -2.14748288E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getBleedBox()}
   */
  @Test
  @DisplayName("Test getBleedBox(); then return Height is '-2.14748288E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getBleedBox()"})
  void testGetBleedBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDRectangle cropBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    pdPage.setCropBox(cropBox);

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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#isDirect()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setBleedBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setBleedBox(PDRectangle); given COSDictionary isDirect() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setBleedBox(PDRectangle)"})
  void testSetBleedBox_givenCOSDictionaryIsDirectThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenThrow(new IllegalArgumentException());

    PDRectangle bleedBox = mock(PDRectangle.class);
    when(bleedBox.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setBleedBox(bleedBox));
    verify(cosDictionary).isDirect();
    verify(bleedBox).getCOSObject();
  }

  /**
   * Test {@link PDPage#setBleedBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does
   *       nothing.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setBleedBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setBleedBox(PDRectangle); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setBleedBox(PDRectangle)"})
  void testSetBleedBox_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    new PDPage(pageDictionary).setBleedBox(mock(PDRectangle.class));

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDPage#setBleedBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setBleedBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBleedBox(PDRectangle); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setBleedBox(PDRectangle)"})
  void testSetBleedBox_givenIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    PDRectangle bleedBox = mock(PDRectangle.class);
    when(bleedBox.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setBleedBox(bleedBox));
    verify(bleedBox).getCOSObject();
  }

  /**
   * Test {@link PDPage#setBleedBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDRectangle#A0}.
   *   <li>Then {@link PDPage#PDPage()} BleedBox LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setBleedBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setBleedBox(PDRectangle); given PDPage(); when A0; then PDPage() BleedBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setBleedBox(PDRectangle)"})
  void testSetBleedBox_givenPDPage_whenA0_thenPDPageBleedBoxLowerLeftXIsZero() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setBleedBox(PDRectangle.A0);

    // Assert
    PDRectangle bleedBox = pdPage.getBleedBox();
    assertEquals(0.0f, bleedBox.getLowerLeftX());
    assertEquals(0.0f, bleedBox.getLowerLeftY());
    assertEquals(612.0f, bleedBox.getUpperRightX());
    assertEquals(612.0f, bleedBox.getWidth());
    assertEquals(792.0f, bleedBox.getHeight());
    assertEquals(792.0f, bleedBox.getUpperRightY());
    COSArray expectedCOSObject = bleedBox.getCOSArray();
    assertSame(expectedCOSObject, bleedBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#setBleedBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDRectangle#LETTER}.
   *   <li>Then {@link PDPage#PDPage()} BleedBox LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setBleedBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setBleedBox(PDRectangle); given PDPage(); when LETTER; then PDPage() BleedBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setBleedBox(PDRectangle)"})
  void testSetBleedBox_givenPDPage_whenLetter_thenPDPageBleedBoxLowerLeftXIsZero() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setBleedBox(PDRectangle.LETTER);

    // Assert
    PDRectangle bleedBox = pdPage.getBleedBox();
    assertEquals(0.0f, bleedBox.getLowerLeftX());
    assertEquals(0.0f, bleedBox.getLowerLeftY());
    assertEquals(612.0f, bleedBox.getUpperRightX());
    assertEquals(612.0f, bleedBox.getWidth());
    assertEquals(792.0f, bleedBox.getHeight());
    assertEquals(792.0f, bleedBox.getUpperRightY());
    COSArray expectedCOSObject = bleedBox.getCOSArray();
    assertSame(expectedCOSObject, bleedBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getTrimBox()}.
   *
   * <p>Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  @DisplayName("Test getTrimBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getTrimBox()"})
  void testGetTrimBox() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDRectangle trimBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    pdPage.setTrimBox(trimBox);

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
   * Test {@link PDPage#getTrimBox()}.
   *
   * <p>Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  @DisplayName("Test getTrimBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getTrimBox()"})
  void testGetTrimBox2() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());
    PDRectangle trimBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    pdPage.setTrimBox(trimBox);

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
   * Test {@link PDPage#getTrimBox()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} TrimBox is {@link PDRectangle#A0}.
   *   <li>Then return LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  @DisplayName("Test getTrimBox(); given PDPage() TrimBox is A0; then return LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getTrimBox()}
   */
  @Test
  @DisplayName("Test getTrimBox(); given PDPage(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getTrimBox()"})
  void testGetTrimBox_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPage().getTrimBox());
  }

  /**
   * Test {@link PDPage#setTrimBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#isDirect()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setTrimBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setTrimBox(PDRectangle); given COSDictionary isDirect() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setTrimBox(PDRectangle)"})
  void testSetTrimBox_givenCOSDictionaryIsDirectThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenThrow(new IllegalArgumentException());

    PDRectangle trimBox = mock(PDRectangle.class);
    when(trimBox.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setTrimBox(trimBox));
    verify(cosDictionary).isDirect();
    verify(trimBox).getCOSObject();
  }

  /**
   * Test {@link PDPage#setTrimBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does
   *       nothing.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setTrimBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setTrimBox(PDRectangle); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setTrimBox(PDRectangle)"})
  void testSetTrimBox_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    new PDPage(pageDictionary).setTrimBox(mock(PDRectangle.class));

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDPage#setTrimBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setTrimBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setTrimBox(PDRectangle); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setTrimBox(PDRectangle)"})
  void testSetTrimBox_givenIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    PDRectangle trimBox = mock(PDRectangle.class);
    when(trimBox.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setTrimBox(trimBox));
    verify(trimBox).getCOSObject();
  }

  /**
   * Test {@link PDPage#setTrimBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDRectangle#A0}.
   *   <li>Then {@link PDPage#PDPage()} TrimBox LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setTrimBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setTrimBox(PDRectangle); given PDPage(); when A0; then PDPage() TrimBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setTrimBox(PDRectangle)"})
  void testSetTrimBox_givenPDPage_whenA0_thenPDPageTrimBoxLowerLeftXIsZero() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setTrimBox(PDRectangle.A0);

    // Assert
    PDRectangle trimBox = pdPage.getTrimBox();
    assertEquals(0.0f, trimBox.getLowerLeftX());
    assertEquals(0.0f, trimBox.getLowerLeftY());
    assertEquals(612.0f, trimBox.getUpperRightX());
    assertEquals(612.0f, trimBox.getWidth());
    assertEquals(792.0f, trimBox.getHeight());
    assertEquals(792.0f, trimBox.getUpperRightY());
    COSArray expectedCOSObject = trimBox.getCOSArray();
    assertSame(expectedCOSObject, trimBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#setTrimBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDRectangle#LETTER}.
   *   <li>Then {@link PDPage#PDPage()} TrimBox LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setTrimBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setTrimBox(PDRectangle); given PDPage(); when LETTER; then PDPage() TrimBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setTrimBox(PDRectangle)"})
  void testSetTrimBox_givenPDPage_whenLetter_thenPDPageTrimBoxLowerLeftXIsZero() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setTrimBox(PDRectangle.LETTER);

    // Assert
    PDRectangle trimBox = pdPage.getTrimBox();
    assertEquals(0.0f, trimBox.getLowerLeftX());
    assertEquals(0.0f, trimBox.getLowerLeftY());
    assertEquals(612.0f, trimBox.getUpperRightX());
    assertEquals(612.0f, trimBox.getWidth());
    assertEquals(792.0f, trimBox.getHeight());
    assertEquals(792.0f, trimBox.getUpperRightY());
    COSArray expectedCOSObject = trimBox.getCOSArray();
    assertSame(expectedCOSObject, trimBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#getArtBox()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} ArtBox is {@link PDRectangle#A0}.
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  @DisplayName(
      "Test getArtBox(); given PDPage() ArtBox is A0; then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  @DisplayName(
      "Test getArtBox(); given PDPage() CropBox is A0; then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@link PDRectangle#LETTER}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  @DisplayName(
      "Test getArtBox(); given PDPage(COSDictionary) with pageDictionary is COSDictionary(); then return LETTER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getArtBox()"})
  void testGetArtBox_givenPDPageWithPageDictionaryIsCOSDictionary_thenReturnLetter() {
    // Arrange
    PDPage pdPage = new PDPage(new COSDictionary());

    // Act and Assert
    PDRectangle pdRectangle = PDRectangle.LETTER;
    assertSame(pdRectangle, pdPage.getArtBox());
    assertSame(pdRectangle, pdPage.getBBox());
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getArtBox()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  @DisplayName("Test getArtBox(); given PDPage(); then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getArtBox()"})
  void testGetArtBox_givenPDPage_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualArtBox = new PDPage().getArtBox();

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
   *
   * <ul>
   *   <li>Then return Height is {@code -2.14748288E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getArtBox()}
   */
  @Test
  @DisplayName("Test getArtBox(); then return Height is '-2.14748288E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDPage.getArtBox()"})
  void testGetArtBox_thenReturnHeightIs214748288e9() {
    // Arrange
    PDPage pdPage = new PDPage();
    PDRectangle cropBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    pdPage.setCropBox(cropBox);

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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#isDirect()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setArtBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setArtBox(PDRectangle); given COSDictionary isDirect() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setArtBox(PDRectangle)"})
  void testSetArtBox_givenCOSDictionaryIsDirectThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenThrow(new IllegalArgumentException());

    PDRectangle artBox = mock(PDRectangle.class);
    when(artBox.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setArtBox(artBox));
    verify(cosDictionary).isDirect();
    verify(artBox).getCOSObject();
  }

  /**
   * Test {@link PDPage#setArtBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setArtBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setArtBox(PDRectangle); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setArtBox(PDRectangle)"})
  void testSetArtBox_givenIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    PDRectangle artBox = mock(PDRectangle.class);
    when(artBox.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setArtBox(artBox));
    verify(artBox).getCOSObject();
  }

  /**
   * Test {@link PDPage#setArtBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDRectangle#A0}.
   *   <li>Then {@link PDPage#PDPage()} BBox LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setArtBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setArtBox(PDRectangle); given PDPage(); when A0; then PDPage() BBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setArtBox(PDRectangle)"})
  void testSetArtBox_givenPDPage_whenA0_thenPDPageBBoxLowerLeftXIsZero() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setArtBox(PDRectangle.A0);

    // Assert
    PDRectangle bBox = pdPage.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(612.0f, bBox.getUpperRightX());
    assertEquals(612.0f, bBox.getWidth());
    assertEquals(792.0f, bBox.getHeight());
    assertEquals(792.0f, bBox.getUpperRightY());
    assertSame(bBox, pdPage.getBleedBox());
    assertSame(bBox, pdPage.getCropBox());
    assertSame(bBox, pdPage.getMediaBox());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#setArtBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDRectangle#LETTER}.
   *   <li>Then {@link PDPage#PDPage()} BBox LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setArtBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setArtBox(PDRectangle); given PDPage(); when LETTER; then PDPage() BBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setArtBox(PDRectangle)"})
  void testSetArtBox_givenPDPage_whenLetter_thenPDPageBBoxLowerLeftXIsZero() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act
    pdPage.setArtBox(PDRectangle.LETTER);

    // Assert
    PDRectangle bBox = pdPage.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(612.0f, bBox.getUpperRightX());
    assertEquals(612.0f, bBox.getWidth());
    assertEquals(792.0f, bBox.getHeight());
    assertEquals(792.0f, bBox.getUpperRightY());
    assertSame(bBox, pdPage.getBleedBox());
    assertSame(bBox, pdPage.getCropBox());
    assertSame(bBox, pdPage.getMediaBox());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
  }

  /**
   * Test {@link PDPage#setArtBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link COSDictionary}
   *       BleedBox is {@link PDRectangle#LETTER}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setArtBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setArtBox(PDRectangle); then PDPage(COSDictionary) with pageDictionary is COSDictionary BleedBox is LETTER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setArtBox(PDRectangle)"})
  void testSetArtBox_thenPDPageWithPageDictionaryIsCOSDictionaryBleedBoxIsLetter() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDPage pdPage = new PDPage(pageDictionary);

    // Act
    pdPage.setArtBox(mock(PDRectangle.class));

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    PDRectangle pdRectangle = PDRectangle.LETTER;
    assertSame(pdRectangle, pdPage.getBleedBox());
    assertSame(pdRectangle, pdPage.getCropBox());
    assertSame(pdRectangle, pdPage.getMediaBox());
  }

  /**
   * Test {@link PDPage#getRotation()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is ninety.
   *   <li>Then return ninety.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given PDPage() Rotation is ninety; then return ninety")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given PDPage() Rotation is one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given PDPage(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPage.getRotation()"})
  void testGetRotation_givenPDPage_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDPage().getRotation());
  }

  /**
   * Test {@link PDPage#setRotation(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setInt(COSName, int)} does nothing.
   *   <li>When one.
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setRotation(int)}
   */
  @Test
  @DisplayName(
      "Test setRotation(int); given COSDictionary setInt(COSName, int) does nothing; when one; then calls setInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setRotation(int)"})
  void testSetRotation_givenCOSDictionarySetIntDoesNothing_whenOne_thenCallsSetInt() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setInt(Mockito.<COSName>any(), anyInt());

    // Act
    new PDPage(pageDictionary).setRotation(1);

    // Assert
    verify(pageDictionary).setInt(isA(COSName.class), eq(1));
  }

  /**
   * Test {@link PDPage#setContents(List)} with {@code List}.
   *
   * <ul>
   *   <li>Then {@link PDPage#PDPage()} ContentStreams next DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setContents(List)}
   */
  @Test
  @DisplayName(
      "Test setContents(List) with 'List'; then PDPage() ContentStreams next DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link PDPage#setContents(PDStream)} with {@code PDStream}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setContents(PDStream)}
   */
  @Test
  @DisplayName("Test setContents(PDStream) with 'PDStream'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setContents(PDStream)"})
  void testSetContentsWithPDStream_thenThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    PDStream contents = mock(PDStream.class);
    when(contents.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setContents(contents));
    verify(contents).getCOSObject();
  }

  /**
   * Test {@link PDPage#getThreadBeads()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName("Test getThreadBeads(); given ArrayList() add 'null'; then return first is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} ThreadBeads is {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName(
      "Test getThreadBeads(); given PDPage() ThreadBeads is ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName("Test getThreadBeads(); given PDPage(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getThreadBeads()"})
  void testGetThreadBeads_givenPDPage_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDPage().getThreadBeads().isEmpty());
  }

  /**
   * Test {@link PDPage#getThreadBeads()}.
   *
   * <ul>
   *   <li>Then return first COSObject Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getThreadBeads()}
   */
  @Test
  @DisplayName("Test getThreadBeads(); then return first COSObject Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link COSDictionary}
   *       ThreadBeads Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setThreadBeads(List)}
   */
  @Test
  @DisplayName(
      "Test setThreadBeads(List); then PDPage(COSDictionary) with pageDictionary is COSDictionary ThreadBeads Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setThreadBeads(List)"})
  void testSetThreadBeads_thenPDPageWithPageDictionaryIsCOSDictionaryThreadBeadsEmpty() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage pdPage = new PDPage(pageDictionary);

    // Act
    pdPage.setThreadBeads(new ArrayList<>());

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    assertTrue(pdPage.getThreadBeads().isEmpty());
  }

  /**
   * Test {@link PDPage#setThreadBeads(List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setThreadBeads(List)}
   */
  @Test
  @DisplayName("Test setThreadBeads(List); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setThreadBeads(List)"})
  void testSetThreadBeads_thenThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    PDThreadBead pdThreadBead = mock(PDThreadBead.class);
    when(pdThreadBead.getCOSObject()).thenThrow(new IllegalArgumentException());

    ArrayList<PDThreadBead> beads = new ArrayList<>();
    beads.add(pdThreadBead);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setThreadBeads(beads));
    verify(pdThreadBead).getCOSObject();
  }

  /**
   * Test {@link PDPage#getMetadata()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); given PDPage(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDMetadata PDPage.getMetadata()"})
  void testGetMetadata_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPage().getMetadata());
  }

  /**
   * Test {@link PDPage#getMetadata()}.
   *
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one
   *       and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  @DisplayName(
      "Test getMetadata(); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); then return DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does
   *       nothing.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(PDMetadata); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setMetadata(PDMetadata)"})
  void testSetMetadata_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDPage pdPage = new PDPage(pageDictionary);

    // Act
    pdPage.setMetadata(new PDMetadata(mock(COSStream.class)));

    // Assert
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDPage#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(PDMetadata); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setMetadata(PDMetadata)"})
  void testSetMetadata_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   *
   * <ul>
   *   <li>Given {@link COSUpdateState#COSUpdateState(COSUpdateInfo)} with updateInfo is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(PDMetadata); given COSUpdateState(COSUpdateInfo) with updateInfo is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setMetadata(PDMetadata)"})
  void testSetMetadata_givenCOSUpdateStateWithUpdateInfoIsCOSArray() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSStream str = mock(COSStream.class);
    when(str.isDirect()).thenReturn(false);
    when(str.getKey()).thenReturn(null);
    when(str.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    // Act
    pdPage.setMetadata(new PDMetadata(str));

    // Assert
    verify(str).getKey();
    verify(str).isDirect();
    verify(str).getUpdateState();
    assertEquals(0, pdPage.getMetadata().getDecodedStreamLength());
  }

  /**
   * Test {@link PDPage#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(PDMetadata); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setMetadata(PDMetadata)"})
  void testSetMetadata_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSStream str = mock(COSStream.class);
    when(str.isDirect()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setMetadata(new PDMetadata(str)));
    verify(str).isDirect();
  }

  /**
   * Test {@link PDPage#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream} {@link COSStream#isDirect()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(PDMetadata); given 'true'; when COSStream isDirect() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setMetadata(PDMetadata)"})
  void testSetMetadata_givenTrue_whenCOSStreamIsDirectReturnTrue() {
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
   *
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setMetadata(PDMetadata)"})
  void testSetMetadata_thenCallsSetOriginDocumentState() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSStream str = mock(COSStream.class);
    when(str.isDirect()).thenReturn(false);
    when(str.getKey()).thenReturn(null);
    when(str.getUpdateState()).thenReturn(cosUpdateState);

    // Act
    pdPage.setMetadata(new PDMetadata(str));

    // Assert
    verify(str).getKey();
    verify(str).isDirect();
    verify(str).getUpdateState();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    assertEquals(0, pdPage.getMetadata().getDecodedStreamLength());
  }

  /**
   * Test {@link PDPage#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>Then {@link PDPage#PDPage()} Metadata DecodedStreamLength is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(PDMetadata); then PDPage() Metadata DecodedStreamLength is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getActions()}
   */
  @Test
  @DisplayName("Test getActions(); given PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPageAdditionalActions PDPage.getActions()"})
  void testGetActions_givenPDPage() {
    // Arrange and Act
    PDPageAdditionalActions actualActions = new PDPage().getActions();

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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Actions is {@link
   *       PDPageAdditionalActions#PDPageAdditionalActions()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getActions()}
   */
  @Test
  @DisplayName("Test getActions(); given PDPage() Actions is PDPageAdditionalActions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setActions(PDPageAdditionalActions)}
   */
  @Test
  @DisplayName(
      "Test setActions(PDPageAdditionalActions); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setActions(PDPageAdditionalActions)"})
  void testSetActions_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));

    // Act
    pdPage.setActions(new PDPageAdditionalActions(a));

    // Assert
    assertSame(a, pdPage.getActions().getCOSObject());
  }

  /**
   * Test {@link PDPage#setActions(PDPageAdditionalActions)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setActions(PDPageAdditionalActions)}
   */
  @Test
  @DisplayName(
      "Test setActions(PDPageAdditionalActions); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setActions(PDPageAdditionalActions)"})
  void testSetActions_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSDictionary a = new COSDictionary();
    a.setDirect(true);

    // Act
    pdPage.setActions(new PDPageAdditionalActions(a));

    // Assert
    assertSame(a, pdPage.getActions().getCOSObject());
  }

  /**
   * Test {@link PDPage#getTransition()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Transition is {@link PDTransition#PDTransition()}.
   *   <li>Then return {@link PDTransition#PDTransition()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getTransition()}
   */
  @Test
  @DisplayName(
      "Test getTransition(); given PDPage() Transition is PDTransition(); then return PDTransition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getTransition()}
   */
  @Test
  @DisplayName("Test getTransition(); given PDPage(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTransition PDPage.getTransition()"})
  void testGetTransition_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPage().getTransition());
  }

  /**
   * Test {@link PDPage#setTransition(PDTransition, float)} with {@code transition}, {@code
   * duration}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setTransition(PDTransition, float)}
   */
  @Test
  @DisplayName(
      "Test setTransition(PDTransition, float) with 'transition', 'duration'; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setTransition(PDTransition, float)"})
  void testSetTransitionWithTransitionDuration_thenCallsSetItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    new PDPage(pageDictionary).setTransition(mock(PDTransition.class), 10.0f);

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDPage#setTransition(PDTransition, float)} with {@code transition}, {@code
   * duration}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setTransition(PDTransition, float)}
   */
  @Test
  @DisplayName(
      "Test setTransition(PDTransition, float) with 'transition', 'duration'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setTransition(PDTransition, float)"})
  void testSetTransitionWithTransitionDuration_thenThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    PDTransition transition = mock(PDTransition.class);
    when(transition.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setTransition(transition, 10.0f));
    verify(transition).getCOSObject();
  }

  /**
   * Test {@link PDPage#setTransition(PDTransition)} with {@code transition}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setTransition(PDTransition)}
   */
  @Test
  @DisplayName(
      "Test setTransition(PDTransition) with 'transition'; then calls setItem(COSName, COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setTransition(PDTransition)"})
  void testSetTransitionWithTransition_thenCallsSetItem() {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    new PDPage(pageDictionary).setTransition(mock(PDTransition.class));

    // Assert that nothing has changed
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDPage#setTransition(PDTransition)} with {@code transition}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setTransition(PDTransition)}
   */
  @Test
  @DisplayName(
      "Test setTransition(PDTransition) with 'transition'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setTransition(PDTransition)"})
  void testSetTransitionWithTransition_thenThrowIllegalArgumentException() {
    // Arrange
    PDPage pdPage = new PDPage();

    PDTransition transition = mock(PDTransition.class);
    when(transition.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.setTransition(transition));
    verify(transition).getCOSObject();
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret(new COSDictionary()));

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
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName("Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter2() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFileAttachment());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCaret#PDAnnotationCaret()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationCaret()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCircle#PDAnnotationCircle()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationCircle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationCircle()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCircle());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDAnnotationFreeText#PDAnnotationFreeText()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationFreeText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationFreeText()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFreeText());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDAnnotationHighlight#PDAnnotationHighlight()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationHighlight()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationHighlight()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationHighlight());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationInk#PDAnnotationInk()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationInk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationInk()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationInk());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationLine#PDAnnotationLine()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationLine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationLine()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationLine());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationLink#PDAnnotationLink()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationLink()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationLink()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationLink());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDAnnotationPolygon#PDAnnotationPolygon()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationPolygon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationPolygon()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationPolygon());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDAnnotationPolyline#PDAnnotationPolyline()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationPolyline()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationPolyline()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationPolyline());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationPopup#PDAnnotationPopup()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationPopup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationPopup()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationPopup());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDAnnotationRubberStamp#PDAnnotationRubberStamp()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationRubberStamp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationRubberStamp()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationRubberStamp());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationSound#PDAnnotationSound()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationSound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationSound()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationSound());

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationSquare#PDAnnotationSquare()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given ArrayList() add PDAnnotationSquare()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenArrayListAddPDAnnotationSquare()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationSquare());

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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link AnnotationFilter}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given PDPage(); when AnnotationFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenPDPage_whenAnnotationFilter()
      throws IOException {
    // Arrange, Act and Assert
    assertTrue(new PDPage().getAnnotations(mock(AnnotationFilter.class)).isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; given 'true'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_givenTrue_thenReturnSizeIsOne() throws IOException {
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_thenThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(annotations);

    AnnotationFilter annotationFilter = mock(AnnotationFilter.class);
    when(annotationFilter.accept(Mockito.<PDAnnotation>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPage.getAnnotations(annotationFilter));
    verify(annotationFilter).accept(isA(PDAnnotation.class));
  }

  /**
   * Test {@link PDPage#getAnnotations(AnnotationFilter)} with {@code AnnotationFilter}.
   *
   * <ul>
   *   <li>When {@link AnnotationFilter}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations(AnnotationFilter)}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(AnnotationFilter) with 'AnnotationFilter'; when AnnotationFilter; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations(AnnotationFilter)"})
  void testGetAnnotationsWithAnnotationFilter_whenAnnotationFilter_thenReturnEmpty()
      throws IOException {
    // Arrange
    PDPage pdPage = new PDPage();
    pdPage.setAnnotations(new ArrayList<>());

    // Act and Assert
    assertTrue(pdPage.getAnnotations(mock(AnnotationFilter.class)).isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given ArrayList() add 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Annotations is {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName(
      "Test getAnnotations(); given PDPage() Annotations is ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); given PDPage(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getAnnotations()"})
  void testGetAnnotations_givenPDPage_thenReturnEmpty() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new PDPage().getAnnotations().isEmpty());
  }

  /**
   * Test {@link PDPage#getAnnotations()}.
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationCaret}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationCaret")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationCircle}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationCircle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationFileAttachment}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationFileAttachment")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationFreeText}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationFreeText")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationHighlight}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationHighlight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationInk}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationInk")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationLine}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationLine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationLink}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationLink")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationPolygon}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationPolygon")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationPolyline}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationPolyline")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationPopup}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationPopup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationRubberStamp}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationRubberStamp")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link PDAnnotationUnknown}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getAnnotations()}
   */
  @Test
  @DisplayName("Test getAnnotations(); then first return PDAnnotationUnknown")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *   <li>Then {@link PDPage#PDPage()} Annotations size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setAnnotations(List)}
   */
  @Test
  @DisplayName(
      "Test setAnnotations(List); given PDAnnotationCaret(); then PDPage() Annotations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setAnnotations(List)"})
  void testSetAnnotations_givenPDAnnotationCaret_thenPDPageAnnotationsSizeIsOne()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *   <li>Then {@link PDPage#PDPage()} Annotations size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setAnnotations(List)}
   */
  @Test
  @DisplayName(
      "Test setAnnotations(List); given PDAnnotationCaret(); then PDPage() Annotations size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setAnnotations(List)"})
  void testSetAnnotations_givenPDAnnotationCaret_thenPDPageAnnotationsSizeIsTwo()
      throws IOException {
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
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDPage#equals(Object)}
   *   <li>{@link PDPage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPage.equals(Object)", "int PDPage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PDPage pdPage = new PDPage();

    // Act and Assert
    assertNotEquals(pdPage, new PDPage());
  }

  /**
   * Test {@link PDPage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPage.equals(Object)", "int PDPage.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDPage(), null);
  }

  /**
   * Test {@link PDPage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPage.equals(Object)", "int PDPage.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDPage(), "Different type to PDPage");
  }

  /**
   * Test {@link PDPage#getViewports()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName("Test getViewports(); given ArrayList() add 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDViewportDictionary#PDViewportDictionary()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName(
      "Test getViewports(); given ArrayList() add PDViewportDictionary(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Viewports is {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName("Test getViewports(); given PDPage() Viewports is ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getViewports()}
   */
  @Test
  @DisplayName("Test getViewports(); given PDPage(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDPage.getViewports()"})
  void testGetViewports_givenPDPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPage().getViewports());
  }

  /**
   * Test {@link PDPage#setViewports(List)}.
   *
   * <ul>
   *   <li>Then {@link PDPage#PDPage()} Viewports size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setViewports(List)}
   */
  @Test
  @DisplayName("Test setViewports(List); then PDPage() Viewports size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setViewports(List)"})
  void testSetViewports_thenPDPageViewportsSizeIsOne() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSArrayList<PDViewportDictionary> viewports = new COSArrayList<>();
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
   *
   * <ul>
   *   <li>Then {@link PDPage#PDPage()} Viewports size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setViewports(List)}
   */
  @Test
  @DisplayName("Test setViewports(List); then PDPage() Viewports size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setViewports(List)"})
  void testSetViewports_thenPDPageViewportsSizeIsTwo() {
    // Arrange
    PDPage pdPage = new PDPage();

    COSArrayList<PDViewportDictionary> viewports = new COSArrayList<>();
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
   * Test {@link PDPage#setViewports(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link
   *       PDViewportDictionary#PDViewportDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setViewports(List)}
   */
  @Test
  @DisplayName("Test setViewports(List); when ArrayList() add PDViewportDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setViewports(List)"})
  void testSetViewports_whenArrayListAddPDViewportDictionary() {
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
   * Test {@link PDPage#getUserUnit()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} UserUnit is {@link Float#NaN}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  @DisplayName("Test getUserUnit(); given PDPage() UserUnit is NaN; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} UserUnit is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  @DisplayName("Test getUserUnit(); given PDPage() UserUnit is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#getUserUnit()}
   */
  @Test
  @DisplayName("Test getUserUnit(); given PDPage(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDPage.getUserUnit()"})
  void testGetUserUnit_givenPDPage_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDPage().getUserUnit());
  }

  /**
   * Test {@link PDPage#setUserUnit(float)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDPage#setUserUnit(float)}
   */
  @Test
  @DisplayName(
      "Test setUserUnit(float); given PDPage(); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPage.setUserUnit(float)"})
  void testSetUserUnit_givenPDPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDPage().setUserUnit(0.0f));
  }
}
