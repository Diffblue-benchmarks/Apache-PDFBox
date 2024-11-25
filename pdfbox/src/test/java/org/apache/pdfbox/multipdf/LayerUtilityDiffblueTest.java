package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LayerUtilityDiffblueTest {
  /**
   * Test {@link LayerUtility#LayerUtility(PDDocument)}.
   * <p>
   * Method under test: {@link LayerUtility#LayerUtility(PDDocument)}
   */
  @Test
  @DisplayName("Test new LayerUtility(PDDocument)")
  void testNewLayerUtility() {
    // Arrange
    PDDocument targetDoc = new PDDocument();

    // Act and Assert
    assertSame(targetDoc, (new LayerUtility(targetDoc)).getDocument());
  }

  /**
   * Test {@link LayerUtility#getDocument()}.
   * <p>
   * Method under test: {@link LayerUtility#getDocument()}
   */
  @Test
  @DisplayName("Test getDocument()")
  void testGetDocument() {
    // Arrange
    PDDocument targetDoc = new PDDocument();

    // Act and Assert
    assertSame(targetDoc, (new LayerUtility(targetDoc)).getDocument());
  }

  /**
   * Test {@link LayerUtility#wrapInSaveRestore(PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link PDPage#PDPage()} Contents is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LayerUtility#wrapInSaveRestore(PDPage)}
   */
  @Test
  @DisplayName("Test wrapInSaveRestore(PDPage); given ArrayList(); when PDPage() Contents is ArrayList()")
  void testWrapInSaveRestore_givenArrayList_whenPDPageContentsIsArrayList() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    // Act
    layerUtility.wrapInSaveRestore(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDStream> contentStreams = page.getContentStreams();
    PDStream nextResult = contentStreams.next();
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
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDStream nextResult2 = contentStreams.next();
    assertEquals(2, nextResult2.getLength());
    COSStream cOSObject2 = nextResult2.getCOSObject();
    assertEquals(2L, cOSObject2.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(contentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = nextResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject2.hasData());
    assertTrue(page.hasContents());
    assertSame(fileFilters, nextResult.getFilters());
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with
   * {@code sourceDoc}, {@code page}.
   * <p>
   * Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'")
  void testImportPageAsFormWithSourceDocPage() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));
    PDDocument sourceDoc = new PDDocument();

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, new PDPage());

    // Assert
    verify(streamCacheCreateFunction).create();
    PDRectangle bBox = actualImportPageAsFormResult.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    List<COSName> filters = actualImportPageAsFormResult.getContentStream().getFilters();
    assertEquals(1, filters.size());
    assertEquals(toListResult.get(0), getResult);
    assertEquals(filters, actualImportPageAsFormResult.getStream().getFilters());
    assertSame(cOSArray, bBox.getCOSObject());
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with
   * {@code sourceDoc}, {@code page}.
   * <ul>
   *   <li>Given {@link LayerUtility#LayerUtility(PDDocument)} with targetDoc is
   * {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; given LayerUtility(PDDocument) with targetDoc is PDDocument()")
  void testImportPageAsFormWithSourceDocPage_givenLayerUtilityWithTargetDocIsPDDocument() throws IOException {
    // Arrange
    LayerUtility layerUtility = new LayerUtility(new PDDocument());
    PDDocument sourceDoc = new PDDocument();

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, new PDPage());

    // Assert
    PDRectangle bBox = actualImportPageAsFormResult.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    List<COSName> filters = actualImportPageAsFormResult.getContentStream().getFilters();
    assertEquals(1, filters.size());
    assertEquals(toListResult.get(0), getResult);
    assertEquals(filters, actualImportPageAsFormResult.getStream().getFilters());
    assertSame(cOSArray, bBox.getCOSObject());
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with
   * {@code sourceDoc}, {@code page}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; given PDPage(); when PDDocument() addPage PDPage()")
  void testImportPageAsFormWithSourceDocPage_givenPDPage_whenPDDocumentAddPagePDPage() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, new PDPage());

    // Assert
    verify(streamCacheCreateFunction).create();
    PDRectangle bBox = actualImportPageAsFormResult.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    List<COSName> filters = actualImportPageAsFormResult.getContentStream().getFilters();
    assertEquals(1, filters.size());
    assertEquals(toListResult.get(0), getResult);
    assertEquals(filters, actualImportPageAsFormResult.getStream().getFilters());
    assertSame(cOSArray, bBox.getCOSObject());
  }

  /**
   * Test
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   * <p>
   * Method under test:
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)")
  void testAppendFormAsLayer() throws IOException {
    // Arrange
    LayerUtility layerUtility = new LayerUtility(new PDDocument());
    PDPage targetPage = new PDPage();
    PDFormXObject form = new PDFormXObject(new COSStream());

    // Act and Assert
    COSDictionary cOSObject = layerUtility.appendFormAsLayer(targetPage, form, new AffineTransform(), "Layer Name")
        .getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    COSDictionary cOSObject2 = layerUtility.getDocument().getDocumentCatalog().getOCProperties().getCOSObject();
    Iterator<COSBase> iteratorResult2 = cOSObject2.toIncrement().iterator();
    assertTrue(iteratorResult2.hasNext());
    assertSame(cOSObject, actualNextResult);
    assertSame(cOSObject2, iteratorResult2.next());
  }

  /**
   * Test
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   * <p>
   * Method under test:
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)")
  void testAppendFormAsLayer2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));
    PDPage targetPage = new PDPage();
    PDFormXObject form = new PDFormXObject(new COSStream());
    layerUtility.appendFormAsLayer(targetPage, form, new AffineTransform(), "Top");
    PDPage targetPage2 = new PDPage();
    PDFormXObject form2 = new PDFormXObject(new COSStream());

    // Act
    layerUtility.appendFormAsLayer(targetPage2, form2, new AffineTransform(), "Layer Name");

    // Assert
    verify(streamCacheCreateFunction).create();
    PDOptionalContentProperties oCProperties = layerUtility.getDocument().getDocumentCatalog().getOCProperties();
    Collection<PDOptionalContentGroup> optionalContentGroups = oCProperties.getOptionalContentGroups();
    assertEquals(2, optionalContentGroups.size());
    assertTrue(optionalContentGroups instanceof List);
    assertEquals("Layer Name", ((List<PDOptionalContentGroup>) optionalContentGroups).get(1).getName());
    String[] groupNames = oCProperties.getGroupNames();
    assertEquals("Layer Name", groupNames[1]);
    assertEquals(2, groupNames.length);
    assertEquals(4, oCProperties.getCOSObject().toIncrement().getObjects().size());
  }

  /**
   * Test
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   * <p>
   * Method under test:
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)")
  void testAppendFormAsLayer3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    targetDoc.save(output, CompressParameters.DEFAULT_COMPRESSION);
    PDFormXObject form = new PDFormXObject(new COSStream());
    AffineTransform transform = new AffineTransform();
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    // Act and Assert
    COSDictionary cOSObject = layerUtility.appendFormAsLayer(new PDPage(), form, transform, "Layer Name")
        .getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    verify(streamCacheCreateFunction).create();
    PDDocument document = layerUtility.getDocument();
    assertEquals("1.6", document.getDocumentCatalog().getVersion());
    assertEquals(1.6f, document.getVersion());
    assertFalse(actualHasNextResult);
    assertSame(cOSObject, actualNextResult);
  }

  /**
   * Test
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link PDPage#PDPage()} Contents is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String); given ArrayList(); when PDPage() Contents is ArrayList()")
  void testAppendFormAsLayer_givenArrayList_whenPDPageContentsIsArrayList() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));

    PDPage targetPage = new PDPage();
    targetPage.setContents(new ArrayList<>());
    PDFormXObject form = new PDFormXObject(new COSStream());

    // Act and Assert
    COSDictionary cOSObject = layerUtility.appendFormAsLayer(targetPage, form, new AffineTransform(), "Layer Name")
        .getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasNextResult);
    assertSame(cOSObject, actualNextResult);
  }

  /**
   * Test
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String); given COSObjectKey(long, int) with num is one and gen is one")
  void testAppendFormAsLayer_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSStream stream = new COSStream();
    stream.setKey(key);
    PDFormXObject form = new PDFormXObject(stream);
    AffineTransform transform = new AffineTransform();

    // Act and Assert
    COSDictionary cOSObject = layerUtility.appendFormAsLayer(new PDPage(), form, transform, "Layer Name")
        .getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasNextResult);
    assertSame(cOSObject, actualNextResult);
  }

  /**
   * Test
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   * <ul>
   *   <li>Given {@link StreamCacheCreateFunction}
   * {@link StreamCacheCreateFunction#create()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String); given StreamCacheCreateFunction create() return 'null'")
  void testAppendFormAsLayer_givenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));
    PDFormXObject form = new PDFormXObject(new COSStream());
    AffineTransform transform = new AffineTransform();

    // Act and Assert
    COSDictionary cOSObject = layerUtility.appendFormAsLayer(new PDPage(), form, transform, "Layer Name")
        .getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasNextResult);
    assertSame(cOSObject, actualNextResult);
  }

  /**
   * Test
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   * <ul>
   *   <li>Then return not COSObject toIncrement iterator hasNext.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String); then return not COSObject toIncrement iterator hasNext")
  void testAppendFormAsLayer_thenReturnNotCOSObjectToIncrementIteratorHasNext() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));
    PDFormXObject form = new PDFormXObject(new COSStream());
    AffineTransform transform = new AffineTransform();

    // Act and Assert
    COSDictionary cOSObject = layerUtility.appendFormAsLayer(new PDPage(), form, transform, "Layer Name")
        .getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasNextResult);
    assertSame(cOSObject, actualNextResult);
  }

  /**
   * Test
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String); then throw IllegalArgumentException")
  void testAppendFormAsLayer_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    LayerUtility layerUtility = new LayerUtility(new PDDocument(streamCacheCreateFunction));
    PDPage targetPage = new PDPage();
    PDFormXObject form = new PDFormXObject(new COSStream());
    layerUtility.appendFormAsLayer(targetPage, form, new AffineTransform(), "Layer Name");
    PDPage targetPage2 = new PDPage();
    PDFormXObject form2 = new PDFormXObject(new COSStream());
    layerUtility.appendFormAsLayer(targetPage2, form2, new AffineTransform(), "Top");
    PDPage targetPage3 = new PDPage();
    PDFormXObject form3 = new PDFormXObject(new COSStream());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> layerUtility.appendFormAsLayer(targetPage3, form3, new AffineTransform(), "Layer Name"));
    verify(streamCacheCreateFunction).create();
  }
}
