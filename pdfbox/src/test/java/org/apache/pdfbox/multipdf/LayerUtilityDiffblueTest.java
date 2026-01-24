package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
   * <p>Method under test: {@link LayerUtility#wrapInSaveRestore(PDPage)}
   */
  @Test
  @DisplayName("Test wrapInSaveRestore(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LayerUtility.wrapInSaveRestore(PDPage)"})
  void testWrapInSaveRestore() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-100L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
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
   *   <li>Given {@link RandomAccessStreamCache.StreamCacheCreateFunction} {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction#create()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#wrapInSaveRestore(PDPage)}
   */
  @Test
  @DisplayName(
      "Test wrapInSaveRestore(PDPage); given StreamCacheCreateFunction create() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LayerUtility.wrapInSaveRestore(PDPage)"})
  void testWrapInSaveRestore_givenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
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
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    // Act
    layerUtility.importPageAsForm(sourceDoc, new PDPage(new COSDictionary()));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    // Act
    PDFormXObject actualImportPageAsFormResult =
        layerUtility.importPageAsForm(sourceDoc, new PDPage());

    // Assert
    verify(streamCacheCreateFunction).create();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage3() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage4() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage5() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    PDPage page = new PDPage();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream str =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    page.setMetadata(new PDMetadata(str));

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDMetadata metadata = actualImportPageAsFormResult.getContentStream().getMetadata();
    COSStream cOSObject = metadata.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(3, actualImportPageAsFormResult.getStream().getMetadata().getLength());
    assertEquals(3, metadata.getLength());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(3L, cOSObject.getLength());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage6() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    PDPage page = new PDPage();
    PDDocument doc = new PDDocument();
    ByteArrayInputStream str =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PDMetadata meta = new PDMetadata(doc, str);
    page.setMetadata(meta);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDMetadata metadata = actualImportPageAsFormResult.getContentStream().getMetadata();
    COSStream cOSObject = metadata.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(8, actualImportPageAsFormResult.getStream().getMetadata().getLength());
    assertEquals(8, metadata.getLength());
    assertEquals(8L, cOSObject.getLength());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage7() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(new ArrayList<>());

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead contentsForStreamParsing =
        actualImportPageAsFormResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess =
        actualImportPageAsFormResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[1];
    assertEquals(1, actualImportPageAsFormResult.getContents().read(byteArray));
    assertEquals(1, contentsForStreamParsing.available());
    assertEquals(1, contentsForRandomAccess.available());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(9, actualImportPageAsFormResult.getStream().getLength());
    assertEquals(9, actualImportPageAsFormResult.getContentStream().getLength());
    assertEquals(9L, actualImportPageAsFormResult.getCOSObject().getLength());
    assertArrayEquals(new byte[] {'\n'}, byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage8() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    PDPage page = new PDPage();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream str = new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));
    page.setMetadata(new PDMetadata(str));

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDMetadata metadata = actualImportPageAsFormResult.getContentStream().getMetadata();
    COSStream cOSObject = metadata.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(3, actualImportPageAsFormResult.getStream().getMetadata().getLength());
    assertEquals(3, metadata.getLength());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(3L, cOSObject.getLength());
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
  void testImportPageAsFormWithSourceDocPageNumber() throws IOException {
    // Arrange
    LayerUtility layerUtility = new LayerUtility(new PDDocument());

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 0);

    // Assert
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
  void testImportPageAsFormWithSourceDocPageNumber2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 0);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualImportPageAsFormResult.getStream().getMetadata());
    assertNull(actualImportPageAsFormResult.getContentStream().getMetadata());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
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

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(page);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 0);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead contentsForStreamParsing =
        actualImportPageAsFormResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess =
        actualImportPageAsFormResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[1];
    assertEquals(1, actualImportPageAsFormResult.getContents().read(byteArray));
    assertEquals(1, contentsForStreamParsing.available());
    assertEquals(1, contentsForRandomAccess.available());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(9, actualImportPageAsFormResult.getStream().getLength());
    assertEquals(9, actualImportPageAsFormResult.getContentStream().getLength());
    assertEquals(9L, actualImportPageAsFormResult.getCOSObject().getLength());
    assertArrayEquals(new byte[] {'\n'}, byteArray);
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

    PDPage page = new PDPage();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream str =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    page.setMetadata(new PDMetadata(str));

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(page);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 0);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(3, actualImportPageAsFormResult.getMatrix().getValues().length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
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

    PDDocument sourceDoc = new PDDocument();
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(key);
    sourceDoc.addPage(new PDPage(pageDictionary));

    // Act and Assert
    float[][] values = layerUtility.importPageAsForm(sourceDoc, 0).getMatrix().getValues();
    assertEquals(3, values.length);
    float[] actualFloatArray = values[0];
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, actualFloatArray, 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = sourceDoc.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(key, nextResult.getCOSObject().getKey());
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
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();

    COSStream str =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    str.setKey(new COSObjectKey(1L, 1));
    PDMetadata meta = new PDMetadata(str);

    PDPage page = new PDPage();
    page.setMetadata(meta);

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(page);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 0);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(3, actualImportPageAsFormResult.getMatrix().getValues().length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName("Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'; given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber_givenA() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDPage page = new PDPage();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream str = new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));
    page.setMetadata(new PDMetadata(str));

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(page);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 0);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(3, actualImportPageAsFormResult.getMatrix().getValues().length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'; given ByteArrayOutputStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber_givenByteArrayOutputStream() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    sourceDoc.addPage(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 0);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualImportPageAsFormResult.getStream().getMetadata());
    assertNull(actualImportPageAsFormResult.getContentStream().getMetadata());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'; given PDPage() Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber_givenPDPageContentsIsArrayList()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(page);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 0);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualImportPageAsFormResult.getStream().getMetadata());
    assertNull(actualImportPageAsFormResult.getContentStream().getMetadata());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'; given PDPage() CropBox is A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber_givenPDPageCropBoxIsA0() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(page);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 0);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualImportPageAsFormResult.getStream().getMetadata());
    assertNull(actualImportPageAsFormResult.getContentStream().getMetadata());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, int)} with {@code sourceDoc}, {@code
   * pageNumber}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is one.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, int)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, int) with 'sourceDoc', 'pageNumber'; given PDPage() Rotation is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, int)"})
  void testImportPageAsFormWithSourceDocPageNumber_givenPDPageRotationIsOne() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDPage page = new PDPage();
    page.setRotation(1);

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(page);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, 0);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualImportPageAsFormResult.getStream().getMetadata());
    assertNull(actualImportPageAsFormResult.getContentStream().getMetadata());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.
   *   <li>When {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; given A0; when PDPage() CropBox is A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage_givenA0_whenPDPageCropBoxIsA0() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage_givenArrayList() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage_givenCOSDictionary() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());
    PDDocument sourceDoc = new PDDocument(doc);

    // Act
    layerUtility.importPageAsForm(sourceDoc, new PDPage());

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <ul>
   *   <li>Given ninety.
   *   <li>Then return Matrix ScaleX is {@code -0.0}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; given ninety; then return Matrix ScaleX is '-0.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage_givenNinety_thenReturnMatrixScaleXIs00()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    PDPage page = new PDPage();
    page.setRotation(90);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Matrix matrix = actualImportPageAsFormResult.getMatrix();
    assertEquals(-0.0f, matrix.getScaleX());
    assertEquals(-1.2941177f, matrix.getShearY());
    assertEquals(0.0f, matrix.getScaleY());
    assertEquals(0.77272725f, matrix.getScalingFactorY());
    assertEquals(0.77272725f, matrix.getShearX());
    assertEquals(1.2941177f, matrix.getScalingFactorX());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(792.0f, matrix.getTranslateY());
    assertArrayEquals(new float[] {-0.0f, -1.2941177f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 792.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.77272725f, 0.0f, 0.0f}, values[1], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PDPage#PDPage()} Rotation is one.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; given one; when PDPage() Rotation is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage_givenOne_whenPDPageRotationIsOne() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    PDPage page = new PDPage();
    page.setRotation(1);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
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
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; given PDPage(); when PDDocument() addPage PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage_givenPDPage_whenPDDocumentAddPagePDPage()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);

    PDDocument sourceDoc = new PDDocument();
    sourceDoc.addPage(new PDPage());

    // Act
    PDFormXObject actualImportPageAsFormResult =
        layerUtility.importPageAsForm(sourceDoc, new PDPage());

    // Assert
    verify(streamCacheCreateFunction).create();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; given PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage_givenPDStreamWithDocumentIsCOSDocument()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    RandomAccessRead contentsForStreamParsing =
        actualImportPageAsFormResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess =
        actualImportPageAsFormResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[1];
    assertEquals(1, actualImportPageAsFormResult.getContents().read(byteArray));
    assertEquals(1, contentsForStreamParsing.available());
    assertEquals(1, contentsForRandomAccess.available());
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(9, actualImportPageAsFormResult.getStream().getLength());
    assertEquals(9, actualImportPageAsFormResult.getContentStream().getLength());
    assertEquals(9L, actualImportPageAsFormResult.getCOSObject().getLength());
    assertArrayEquals(new byte[] {'\n'}, byteArray);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link PDPage#PDPage()} Rotation is zero.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; given zero; when PDPage() Rotation is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage_givenZero_whenPDPageRotationIsZero()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    PDPage page = new PDPage();
    page.setRotation(0);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    float[][] values = actualImportPageAsFormResult.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = actualImportPageAsFormResult.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link LayerUtility#importPageAsForm(PDDocument, PDPage)} with {@code sourceDoc}, {@code
   * page}.
   *
   * <ul>
   *   <li>Then return Matrix TranslateX is minus two.
   * </ul>
   *
   * <p>Method under test: {@link LayerUtility#importPageAsForm(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test importPageAsForm(PDDocument, PDPage) with 'sourceDoc', 'page'; then return Matrix TranslateX is minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFormXObject LayerUtility.importPageAsForm(PDDocument, PDPage)"})
  void testImportPageAsFormWithSourceDocPage_thenReturnMatrixTranslateXIsMinusTwo()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument targetDoc = new PDDocument(streamCacheCreateFunction);
    LayerUtility layerUtility = new LayerUtility(targetDoc);
    PDDocument sourceDoc = new PDDocument();

    PDPage page = new PDPage();
    PDRectangle cropBox = new PDRectangle(1.0f, 1.0f, 1.0f, 1.0f);
    page.setCropBox(cropBox);

    // Act
    PDFormXObject actualImportPageAsFormResult = layerUtility.importPageAsForm(sourceDoc, page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Matrix matrix = actualImportPageAsFormResult.getMatrix();
    assertEquals(-2.0f, matrix.getTranslateX());
    assertEquals(-2.0f, matrix.getTranslateY());
    PDRectangle bBox = actualImportPageAsFormResult.getBBox();
    assertEquals(1.0f, bBox.getHeight());
    assertEquals(1.0f, bBox.getLowerLeftX());
    assertEquals(1.0f, bBox.getLowerLeftY());
    assertEquals(1.0f, bBox.getWidth());
    assertEquals(2.0f, bBox.getUpperRightX());
    assertEquals(2.0f, bBox.getUpperRightY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(4, bBox.getCOSArray().toList().size());
    assertArrayEquals(new float[] {-2.0f, -2.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
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
    assertEquals(1.6f, layerUtility.getDocument().getVersion());
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
