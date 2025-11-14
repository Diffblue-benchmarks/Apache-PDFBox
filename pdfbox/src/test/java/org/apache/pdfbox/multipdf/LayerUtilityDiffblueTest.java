package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessInputStream;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LayerUtilityDiffblueTest {
  /**
   * Test {@link LayerUtility#LayerUtility(PDDocument)}.
   *
   * <ul>
   *   <li>Then return Document is {@link PDDocument#PDDocument(COSDocument)} with doc is {@link
   *       COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#LayerUtility(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new LayerUtility(PDDocument); then return Document is PDDocument(COSDocument) with doc is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LayerUtility.<init>(PDDocument)"})
  void testNewLayerUtility_thenReturnDocumentIsPDDocumentWithDocIsCOSDocument() {
    // Arrange
    PDDocument targetDoc = new PDDocument(new COSDocument());

    // Act and Assert
    assertSame(targetDoc, new LayerUtility(targetDoc).getDocument());
  }

  /**
   * Test {@link LayerUtility#LayerUtility(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return Document is {@link PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#LayerUtility(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new LayerUtility(PDDocument); when PDDocument(); then return Document is PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LayerUtility.<init>(PDDocument)"})
  void testNewLayerUtility_whenPDDocument_thenReturnDocumentIsPDDocument() {
    // Arrange
    PDDocument targetDoc = new PDDocument();

    // Act and Assert
    assertSame(targetDoc, new LayerUtility(targetDoc).getDocument());
  }

  /**
   * Test {@link LayerUtility#wrapInSaveRestore(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#wrapInSaveRestore(PDPage)}
   */
  @Test
  @DisplayName(
      "Test wrapInSaveRestore(PDPage); given ArrayList(); when PDPage() Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LayerUtility.wrapInSaveRestore(PDPage)"})
  void testWrapInSaveRestore_givenArrayList_whenPDPageContentsIsArrayList() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

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
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(2, contentStreams.next().getLength());
    assertFalse(contentStreams.hasNext());
    List<String> fileFilters = nextResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(page.hasContents());
    assertSame(fileFilters, nextResult.getFilters());
  }

  /**
   * Test {@link LayerUtility#wrapInSaveRestore(PDPage)}.
   *
   * <ul>
   *   <li>Then {@link PDPage#PDPage()} ContentStreams next Length is zero.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#wrapInSaveRestore(PDPage)}
   */
  @Test
  @DisplayName("Test wrapInSaveRestore(PDPage); then PDPage() ContentStreams next Length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LayerUtility.wrapInSaveRestore(PDPage)"})
  void testWrapInSaveRestore_thenPDPageContentStreamsNextLengthIsZero() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    layerUtility.wrapInSaveRestore(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDStream> contentStreams = page.getContentStreams();
    PDStream nextResult = contentStreams.next();
    PDStream nextResult2 = contentStreams.next();
    PDStream nextResult3 = contentStreams.next();
    assertFalse(contentStreams.hasNext());
    assertNull(nextResult.getDecodeParms());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertNull(nextResult.getFile());
    assertNull(nextResult.getFileDecodeParams());
    List<String> fileFilters = nextResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, nextResult.getFilters());
    assertNull(nextResult.getMetadata());
    assertEquals(0, nextResult2.getLength());
    assertNull(nextResult3.getDecodeParms());
    assertEquals(-1, nextResult3.getDecodedStreamLength());
    assertNull(nextResult3.getFile());
    assertNull(nextResult3.getFileDecodeParams());
    assertSame(fileFilters, nextResult3.getFileFilters());
    assertSame(fileFilters, nextResult3.getFilters());
    assertEquals(2, nextResult3.getLength());
    assertNull(nextResult3.getMetadata());
    assertTrue(page.hasContents());
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(new PDOptionalContentProperties());

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 10);

    // Assert
    verify(streamCacheCreateFunction).create();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    assertEquals(
        2, layerUtility.getDocument().getDocumentCatalog().getOCProperties().getCOSObject().size());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(null);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 10);

    // Assert
    verify(streamCacheCreateFunction).create();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
    PDDocument document = layerUtility.getDocument();
    assertEquals("1.5", document.getDocumentCatalog().getVersion());
    assertEquals(1.5f, document.getVersion());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber3() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosStream);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 10);

    // Assert
    verify(streamCacheCreateFunction).create();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
    COSDictionary cOSObject =
        layerUtility.getDocument().getDocumentCatalog().getOCProperties().getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertNull(((COSStream) cOSObject).getFilters());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(3L, ((COSStream) cOSObject).getLength());
    assertTrue(((COSStream) cOSObject).hasData());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber4() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    HashSet<Entry<COSName, COSBase>> entrySet = new HashSet<>();
    when(cosDictionary.entrySet()).thenReturn(entrySet);

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosDictionary);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 10);

    // Assert
    verify(cosDictionary).entrySet();
    verify(streamCacheCreateFunction).create();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(entrySet, actualImportPageAsFormResult.getResources().getColorSpaceNames());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber5() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.entrySet()).thenThrow(new IllegalArgumentException());

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosDictionary);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> layerUtility.importPageAsForm(sourceDoc, 10));
    verify(cosDictionary).entrySet();
    verify(streamCacheCreateFunction).create();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber6() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);

    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDPage targetPage = new PDPage();
    PDFormXObject form = new PDFormXObject(new COSStream());

    layerUtility.appendFormAsLayer(
        targetPage, form, new AffineTransform(), "org.apache.pdfbox.filter.deflatelevel");

    COSDictionary cosDictionary = mock(COSDictionary.class);
    HashSet<Entry<COSName, COSBase>> entrySet = new HashSet<>();
    when(cosDictionary.entrySet()).thenReturn(entrySet);

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosDictionary);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 10);

    // Assert
    verify(cosDictionary).entrySet();
    verify(streamCacheCreateFunction).create();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(entrySet, actualImportPageAsFormResult.getResources().getColorSpaceNames());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber7() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    HashSet<Entry<COSName, COSBase>> entrySet = new HashSet<>();
    when(cosDictionary.entrySet()).thenReturn(entrySet);

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosDictionary);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage(new COSDictionary()));

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 10);

    // Assert
    verify(cosDictionary).entrySet();
    verify(streamCacheCreateFunction).create();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(entrySet, actualImportPageAsFormResult.getResources().getColorSpaceNames());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber8() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);

    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDPage targetPage = new PDPage();
    PDFormXObject form = new PDFormXObject(new COSStream());

    layerUtility.appendFormAsLayer(targetPage, form, new AffineTransform(), "LastModified");

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.entrySet()).thenThrow(new IllegalArgumentException());

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosDictionary);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> layerUtility.importPageAsForm(sourceDoc, 10));
    verify(cosDictionary).entrySet();
    verify(streamCacheCreateFunction).create();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber9() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    targetDoc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    HashSet<Entry<COSName, COSBase>> entrySet = new HashSet<>();
    when(cosDictionary.entrySet()).thenReturn(entrySet);

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosDictionary);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 10);

    // Assert
    verify(cosDictionary).entrySet();
    verify(streamCacheCreateFunction).create();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(entrySet, actualImportPageAsFormResult.getResources().getColorSpaceNames());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber10() throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(new PDOptionalContentProperties());

    PDDocument targetDoc = mock(PDDocument.class);
    when(targetDoc.getDocument()).thenReturn(new COSDocument());
    when(targetDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.entrySet()).thenReturn(new HashSet<>());

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosDictionary);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog2 = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog2.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog2);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 10);

    // Assert
    verify(cosDictionary).entrySet();
    verify(targetDoc).getDocument();
    verify(targetDoc).getDocumentCatalog();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdDocumentCatalog2).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
    List<COSName> filters = actualImportPageAsFormResult.getContentStream().getFilters();
    assertEquals(1, filters.size());
    assertEquals(filters, actualImportPageAsFormResult.getStream().getFilters());
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber11() throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(new PDOptionalContentProperties());

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosStream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(cosStream).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    doNothing().when(cosStream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosStream.createOutputStream(Mockito.<COSBase>any()))
        .thenReturn(new ByteArrayOutputStream());

    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);

    PDDocument targetDoc = mock(PDDocument.class);
    when(targetDoc.getDocument()).thenReturn(cosDocument);
    when(targetDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.entrySet()).thenReturn(new HashSet<>());

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosDictionary);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog2 = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog2.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog2);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 10);

    // Assert
    verify(cosDictionary).entrySet();
    verify(cosStream).getDictionaryObject(isA(COSName.class));
    verify(cosStream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosStream).setItem(isA(COSName.class), isA(COSObjectable.class));
    verify(cosStream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(targetDoc).getDocument();
    verify(targetDoc).getDocumentCatalog();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdDocumentCatalog2).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
    assertTrue(actualImportPageAsFormResult.getContents() instanceof RandomAccessInputStream);
    assertNull(actualImportPageAsFormResult.getContentsForStreamParsing());
    assertNull(actualImportPageAsFormResult.getContentsForRandomAccess());
    assertNull(actualImportPageAsFormResult.getResources());
    assertNull(actualImportPageAsFormResult.getBBox());
    PDStream stream = actualImportPageAsFormResult.getStream();
    assertEquals(0, stream.getDecodedStreamLength());
    PDStream contentStream = actualImportPageAsFormResult.getContentStream();
    assertEquals(0, contentStream.getDecodedStreamLength());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(0, actualImportPageAsFormResult.getFormType());
    assertEquals(0, actualImportPageAsFormResult.getStructParents());
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber12() throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(new PDOptionalContentProperties());

    COSStream cosStream = mock(COSStream.class);
    doThrow(new IllegalArgumentException())
        .when(cosStream)
        .setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosStream.createOutputStream(Mockito.<COSBase>any()))
        .thenReturn(new ByteArrayOutputStream());

    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);

    PDDocument targetDoc = mock(PDDocument.class);
    when(targetDoc.getDocument()).thenReturn(cosDocument);
    when(targetDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.entrySet()).thenReturn(new HashSet<>());

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosDictionary);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog2 = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog2.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog2);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> layerUtility.importPageAsForm(sourceDoc, 10));
    verify(cosDictionary).entrySet();
    verify(cosStream).setName(isA(COSName.class), eq("XObject"));
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(targetDoc).getDocument();
    verify(targetDoc).getDocumentCatalog();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdDocumentCatalog2).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <ul>
   *   <li>Then calls {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'; then calls setOCProperties(PDOptionalContentProperties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber_thenCallsSetOCProperties() throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(null);
    doNothing().when(pdDocumentCatalog).setOCProperties(Mockito.<PDOptionalContentProperties>any());

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosStream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(cosStream).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    doNothing().when(cosStream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosStream.createOutputStream(Mockito.<COSBase>any()))
        .thenReturn(new ByteArrayOutputStream());

    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);

    PDDocument targetDoc = mock(PDDocument.class);
    when(targetDoc.getDocument()).thenReturn(cosDocument);
    when(targetDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.entrySet()).thenReturn(new HashSet<>());

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosDictionary);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog2 = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog2.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog2);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 10);

    // Assert
    verify(cosDictionary).entrySet();
    verify(cosStream).getDictionaryObject(isA(COSName.class));
    verify(cosStream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosStream).setItem(isA(COSName.class), isA(COSObjectable.class));
    verify(cosStream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(targetDoc).getDocument();
    verify(targetDoc).getDocumentCatalog();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdDocumentCatalog2).getOCProperties();
    verify(pdDocumentCatalog).setOCProperties(isA(PDOptionalContentProperties.class));
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
    assertTrue(actualImportPageAsFormResult.getContents() instanceof RandomAccessInputStream);
    assertNull(actualImportPageAsFormResult.getContentsForStreamParsing());
    assertNull(actualImportPageAsFormResult.getContentsForRandomAccess());
    assertNull(actualImportPageAsFormResult.getResources());
    assertNull(actualImportPageAsFormResult.getBBox());
    PDStream stream = actualImportPageAsFormResult.getStream();
    assertEquals(0, stream.getDecodedStreamLength());
    PDStream contentStream = actualImportPageAsFormResult.getContentStream();
    assertEquals(0, contentStream.getDecodedStreamLength());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(0, actualImportPageAsFormResult.getFormType());
    assertEquals(0, actualImportPageAsFormResult.getStructParents());
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <ul>
   *   <li>Then return Stream COSObject is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'; then return Stream COSObject is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber_thenReturnStreamCOSObjectIsCOSStream()
      throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getOCProperties()).thenReturn(new PDOptionalContentProperties());

    COSDocument cosDocument = mock(COSDocument.class);
    COSStream cosStream = new COSStream();
    when(cosDocument.createCOSStream()).thenReturn(cosStream);

    PDDocument targetDoc = mock(PDDocument.class);
    when(targetDoc.getDocument()).thenReturn(cosDocument);
    when(targetDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.entrySet()).thenReturn(new HashSet<>());

    PDOptionalContentProperties pdOptionalContentProperties =
        mock(PDOptionalContentProperties.class);
    when(pdOptionalContentProperties.getCOSObject()).thenReturn(cosDictionary);
    doNothing().when(pdOptionalContentProperties).addGroup(Mockito.<PDOptionalContentGroup>any());
    pdOptionalContentProperties.addGroup(
        new PDOptionalContentGroup("org.apache.pdfbox.filter.deflatelevel"));

    PDDocumentCatalog pdDocumentCatalog2 = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog2.getOCProperties()).thenReturn(pdOptionalContentProperties);

    PDDocument sourceDoc = mock(PDDocument.class);
    when(sourceDoc.getDocumentCatalog()).thenReturn(pdDocumentCatalog2);
    when(sourceDoc.getPage(anyInt())).thenReturn(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 10);

    // Assert
    verify(cosDictionary).entrySet();
    verify(cosDocument).createCOSStream();
    verify(targetDoc).getDocument();
    verify(targetDoc).getDocumentCatalog();
    verify(sourceDoc).getDocumentCatalog();
    verify(sourceDoc).getPage(10);
    verify(pdDocumentCatalog).getOCProperties();
    verify(pdDocumentCatalog2).getOCProperties();
    verify(pdOptionalContentProperties).addGroup(isA(PDOptionalContentGroup.class));
    verify(pdOptionalContentProperties).getCOSObject();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(cosStream, actualImportPageAsFormResult.getStream().getCOSObject());
    assertSame(cosStream, actualImportPageAsFormResult.getContentStream().getCOSObject());
    assertSame(cosStream, actualImportPageAsFormResult.getCOSObject());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; given PDPage(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage_givenPDPage_thenCallsCreate() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(new PDPage());

    // Act
    layerUtility.importPageAsForm(sourceDoc, new PDPage());

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   *
   * <p>Method under test: {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject,
   * AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDOptionalContentGroup LayerUtility.appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)"
  })
  void testAppendFormAsLayer() throws IOException {
    // Arrange
    LayerUtility layerUtility = new LayerUtility(new PDDocument());
    PDPage targetPage = new PDPage();
    PDFormXObject form = new PDFormXObject(new COSStream());

    // Act and Assert
    COSDictionary cOSObject =
        layerUtility
            .appendFormAsLayer(targetPage, form, new AffineTransform(), "Layer Name")
            .getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    COSDictionary cOSObject2 =
        layerUtility.getDocument().getDocumentCatalog().getOCProperties().getCOSObject();
    Iterator<COSBase> iteratorResult2 = cOSObject2.toIncrement().iterator();
    assertTrue(iteratorResult2.hasNext());
    assertSame(cOSObject, actualNextResult);
    assertSame(cOSObject2, iteratorResult2.next());
  }

  /**
   * Test {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   *
   * <p>Method under test: {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject,
   * AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDOptionalContentGroup LayerUtility.appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)"
  })
  void testAppendFormAsLayer2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);

    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDPage targetPage = new PDPage();
    PDFormXObject form = new PDFormXObject(new COSStream());

    layerUtility.appendFormAsLayer(targetPage, form, new AffineTransform(), "Top");
    PDPage targetPage2 = new PDPage();
    PDFormXObject form2 = new PDFormXObject(new COSStream());

    // Act
    layerUtility.appendFormAsLayer(targetPage2, form2, new AffineTransform(), "Layer Name");

    // Assert
    verify(streamCacheCreateFunction).create();
    PDOptionalContentProperties oCProperties =
        layerUtility.getDocument().getDocumentCatalog().getOCProperties();
    Collection<PDOptionalContentGroup> optionalContentGroups =
        oCProperties.getOptionalContentGroups();
    assertEquals(2, optionalContentGroups.size());
    assertTrue(optionalContentGroups instanceof List);
    String[] groupNames = oCProperties.getGroupNames();
    assertEquals("Layer Name", groupNames[1]);
    assertEquals(2, groupNames.length);
  }

  /**
   * Test {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   *
   * <p>Method under test: {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject,
   * AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDOptionalContentGroup LayerUtility.appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)"
  })
  void testAppendFormAsLayer3() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    targetDoc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    PDFormXObject form = new PDFormXObject(new COSStream());
    AffineTransform transform = new AffineTransform();
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    // Act and Assert
    COSDictionary cOSObject =
        layerUtility.appendFormAsLayer(new PDPage(), form, transform, "Layer Name").getCOSObject();
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
   * Test {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject,
   * AffineTransform, String)}
   */
  @Test
  @DisplayName(
      "Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String); given ArrayList(); when PDPage() Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDOptionalContentGroup LayerUtility.appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)"
  })
  void testAppendFormAsLayer_givenArrayList_whenPDPageContentsIsArrayList() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDPage targetPage = new PDPage();
    targetPage.setContents(new ArrayList<>());
    PDFormXObject form = new PDFormXObject(new COSStream());

    // Act and Assert
    COSDictionary cOSObject =
        layerUtility
            .appendFormAsLayer(targetPage, form, new AffineTransform(), "Layer Name")
            .getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasNextResult);
    assertSame(cOSObject, actualNextResult);
  }

  /**
   * Test {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject,
   * AffineTransform, String)}
   */
  @Test
  @DisplayName(
      "Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDOptionalContentGroup LayerUtility.appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)"
  })
  void testAppendFormAsLayer_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSStream stream = new COSStream();
    stream.setKey(key);
    PDFormXObject form = new PDFormXObject(stream);
    AffineTransform transform = new AffineTransform();

    // Act and Assert
    COSDictionary cOSObject =
        layerUtility.appendFormAsLayer(new PDPage(), form, transform, "Layer Name").getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasNextResult);
    assertSame(cOSObject, actualNextResult);
  }

  /**
   * Test {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessStreamCache.StreamCacheCreateFunction} {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction#create()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject,
   * AffineTransform, String)}
   */
  @Test
  @DisplayName(
      "Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String); given StreamCacheCreateFunction create() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDOptionalContentGroup LayerUtility.appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)"
  })
  void testAppendFormAsLayer_givenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDFormXObject form = new PDFormXObject(new COSStream());
    AffineTransform transform = new AffineTransform();

    // Act and Assert
    COSDictionary cOSObject =
        layerUtility.appendFormAsLayer(new PDPage(), form, transform, "Layer Name").getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasNextResult);
    assertSame(cOSObject, actualNextResult);
  }

  /**
   * Test {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   *
   * <ul>
   *   <li>Then return not COSObject toIncrement iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject,
   * AffineTransform, String)}
   */
  @Test
  @DisplayName(
      "Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String); then return not COSObject toIncrement iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDOptionalContentGroup LayerUtility.appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)"
  })
  void testAppendFormAsLayer_thenReturnNotCOSObjectToIncrementIteratorHasNext() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDFormXObject form = new PDFormXObject(new COSStream());
    AffineTransform transform = new AffineTransform();

    // Act and Assert
    COSDictionary cOSObject =
        layerUtility.appendFormAsLayer(new PDPage(), form, transform, "Layer Name").getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasNextResult);
    assertSame(cOSObject, actualNextResult);
  }

  /**
   * Test {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject,
   * AffineTransform, String)}
   */
  @Test
  @DisplayName(
      "Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDOptionalContentGroup LayerUtility.appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)"
  })
  void testAppendFormAsLayer_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);

    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDPage targetPage = new PDPage();
    PDFormXObject form = new PDFormXObject(new COSStream());

    layerUtility.appendFormAsLayer(targetPage, form, new AffineTransform(), "Layer Name");
    PDPage targetPage2 = new PDPage();
    PDFormXObject form2 = new PDFormXObject(new COSStream());

    layerUtility.appendFormAsLayer(targetPage2, form2, new AffineTransform(), "Top");
    PDPage targetPage3 = new PDPage();
    PDFormXObject form3 = new PDFormXObject(new COSStream());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            layerUtility.appendFormAsLayer(
                targetPage3, form3, new AffineTransform(), "Layer Name"));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject,
   * AffineTransform, String)}
   */
  @Test
  @DisplayName(
      "Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String); when 'null'; then return COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDOptionalContentGroup LayerUtility.appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)"
  })
  void testAppendFormAsLayer_whenNull_thenReturnCOSObjectValuesSizeIsOne() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDPage targetPage = new PDPage();
    PDFormXObject form = new PDFormXObject(new COSStream());

    // Act
    PDOptionalContentGroup actualAppendFormAsLayerResult =
        layerUtility.appendFormAsLayer(targetPage, form, new AffineTransform(), null);

    // Assert
    COSDictionary cOSObject = actualAppendFormAsLayerResult.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    assertNull(actualAppendFormAsLayerResult.getName());
    verify(streamCacheCreateFunction).create();
    PDOptionalContentProperties oCProperties =
        layerUtility.getDocument().getDocumentCatalog().getOCProperties();
    assertArrayEquals(new String[] {null}, oCProperties.getGroupNames());
    Collection<PDOptionalContentGroup> optionalContentGroups =
        oCProperties.getOptionalContentGroups();
    assertTrue(optionalContentGroups instanceof List);
    assertEquals(1, optionalContentGroups.size());
    assertNull(((List<PDOptionalContentGroup>) optionalContentGroups).get(0).getName());
  }
}
