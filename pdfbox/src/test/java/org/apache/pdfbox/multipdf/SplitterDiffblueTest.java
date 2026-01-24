package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDMarkInfo;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationUnknown;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SplitterDiffblueTest {
  @Mock private PDDocument pDDocument;

  @InjectMocks private Splitter splitter;

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(0L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit2() throws IOException {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getViewerPreferences()).thenThrow(new IllegalArgumentException());
    when(pDDocument.getVersion()).thenReturn(10.0f);
    when(pDDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(pDDocument.getDocumentInformation()).thenReturn(new PDDocumentInformation());
    when(pDDocument.getPages()).thenReturn(pdPageTree);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> splitter.split(pDDocument));
    verify(pDDocument).getDocumentCatalog();
    verify(pDDocument).getDocumentInformation();
    verify(pDDocument).getPages();
    verify(pDDocument).getVersion();
    verify(pdDocumentCatalog).getViewerPreferences();
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit3() throws IOException {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getLanguage()).thenReturn("en");
    when(pdDocumentCatalog.getMetadata()).thenReturn(new PDMetadata(new COSStream()));
    when(pdDocumentCatalog.getMarkInfo()).thenReturn(new PDMarkInfo());
    when(pdDocumentCatalog.getStructureTreeRoot()).thenReturn(pdStructureTreeRoot);
    when(pdDocumentCatalog.getViewerPreferences()).thenReturn(new PDViewerPreferences());
    when(pDDocument.getVersion()).thenReturn(10.0f);
    when(pDDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(pDDocument.getDocumentInformation()).thenReturn(new PDDocumentInformation());
    when(pDDocument.getPages()).thenReturn(pdPageTree);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(pDDocument);

    // Assert
    verify(pDDocument, atLeast(1)).getDocumentCatalog();
    verify(pDDocument).getDocumentInformation();
    verify(pDDocument).getPages();
    verify(pDDocument).getVersion();
    verify(pdDocumentCatalog).getLanguage();
    verify(pdDocumentCatalog).getMarkInfo();
    verify(pdDocumentCatalog).getMetadata();
    verify(pdDocumentCatalog).getStructureTreeRoot();
    verify(pdDocumentCatalog).getViewerPreferences();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit4() throws IOException {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getLanguage()).thenReturn("en");
    when(pdDocumentCatalog.getMetadata()).thenReturn(new PDMetadata(new COSStream()));
    when(pdDocumentCatalog.getMarkInfo()).thenReturn(new PDMarkInfo());
    when(pdDocumentCatalog.getStructureTreeRoot()).thenReturn(pdStructureTreeRoot);
    when(pdDocumentCatalog.getViewerPreferences()).thenReturn(new PDViewerPreferences());
    when(pDDocument.getVersion()).thenReturn(10.0f);
    when(pDDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(pDDocument.getDocumentInformation()).thenReturn(new PDDocumentInformation());
    when(pDDocument.getPages()).thenReturn(pdPageTree);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(pDDocument);

    // Assert
    verify(pDDocument, atLeast(1)).getDocumentCatalog();
    verify(pDDocument).getDocumentInformation();
    verify(pDDocument).getPages();
    verify(pDDocument).getVersion();
    verify(pdDocumentCatalog).getLanguage();
    verify(pdDocumentCatalog).getMarkInfo();
    verify(pdDocumentCatalog).getMetadata();
    verify(pdDocumentCatalog).getStructureTreeRoot();
    verify(pdDocumentCatalog).getViewerPreferences();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit5() throws IOException {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    COSStream str = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);
    str.setKey(key);
    PDMetadata pdMetadata = new PDMetadata(str);

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getLanguage()).thenReturn("en");
    when(pdDocumentCatalog.getMetadata()).thenReturn(pdMetadata);
    when(pdDocumentCatalog.getMarkInfo()).thenReturn(new PDMarkInfo());
    when(pdDocumentCatalog.getStructureTreeRoot()).thenReturn(new PDStructureTreeRoot());
    when(pdDocumentCatalog.getViewerPreferences()).thenReturn(new PDViewerPreferences());
    when(pDDocument.getVersion()).thenReturn(10.0f);
    when(pDDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(pDDocument.getDocumentInformation()).thenReturn(new PDDocumentInformation());
    when(pDDocument.getPages()).thenReturn(pdPageTree);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(pDDocument);

    // Assert
    verify(pDDocument, atLeast(1)).getDocumentCatalog();
    verify(pDDocument).getDocumentInformation();
    verify(pDDocument).getPages();
    verify(pDDocument).getVersion();
    verify(pdDocumentCatalog).getLanguage();
    verify(pdDocumentCatalog).getMarkInfo();
    verify(pdDocumentCatalog).getMetadata();
    verify(pdDocumentCatalog).getStructureTreeRoot();
    verify(pdDocumentCatalog).getViewerPreferences();
    assertEquals(1, actualSplitResult.size());
    PDDocument getResult = actualSplitResult.get(0);
    Iterator<PDPage> iteratorResult = getResult.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertSame(key, getResult.getDocumentCatalog().getMetadata().getCOSObject().getKey());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given ArrayList() add 'null'; when PDDocument() addPage PDPage(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenArrayListAddNull_whenPDDocumentAddPagePDPage_thenCallsCreate()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given ArrayList() add PDStream(COSDocument) with document is COSDocument(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenArrayListAddPDStreamWithDocumentIsCOSDocument_thenCallsCreate()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given ArrayList() add PDStream(COSDocument) with document is COSDocument(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenArrayListAddPDStreamWithDocumentIsCOSDocument_thenCallsCreate2()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then return first Document Version is {@code 1.6}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given ByteArrayOutputStream(); then return first Document Version is '1.6'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenByteArrayOutputStream_thenReturnFirstDocumentVersionIs16()
      throws IOException {
    // Arrange
    Splitter splitter = new Splitter();

    PDDocument document = new PDDocument();
    document.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    document.addPage(new PDPage());

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    assertEquals(1, actualSplitResult.size());
    PDDocument getResult = actualSplitResult.get(0);
    assertEquals(1.6f, getResult.getDocument().getVersion());
    assertEquals(1.6f, getResult.getVersion());
    Iterator<PDPage> iteratorResult = getResult.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(mock(StreamCacheCreateFunction.class));

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act and Assert
    assertTrue(splitter.split(document).isEmpty());
    assertSame(document, splitter.getSourceDocument());
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDDocumentCatalog} {@link PDDocumentCatalog#getLanguage()} return {@code
   *       en}.
   *   <li>Then calls {@link PDDocumentCatalog#getLanguage()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDDocumentCatalog getLanguage() return 'en'; then calls getLanguage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDDocumentCatalogGetLanguageReturnEn_thenCallsGetLanguage()
      throws IOException {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getLanguage()).thenReturn("en");
    when(pdDocumentCatalog.getMetadata()).thenReturn(new PDMetadata(new COSStream()));
    when(pdDocumentCatalog.getMarkInfo()).thenReturn(new PDMarkInfo());
    when(pdDocumentCatalog.getStructureTreeRoot()).thenReturn(new PDStructureTreeRoot());
    when(pdDocumentCatalog.getViewerPreferences()).thenReturn(new PDViewerPreferences());
    when(pDDocument.getVersion()).thenReturn(10.0f);
    when(pDDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(pDDocument.getDocumentInformation()).thenReturn(new PDDocumentInformation());
    when(pDDocument.getPages()).thenReturn(pdPageTree);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(pDDocument);

    // Assert
    verify(pDDocument, atLeast(1)).getDocumentCatalog();
    verify(pDDocument).getDocumentInformation();
    verify(pDDocument).getPages();
    verify(pDDocument).getVersion();
    verify(pdDocumentCatalog).getLanguage();
    verify(pdDocumentCatalog).getMarkInfo();
    verify(pdDocumentCatalog).getMetadata();
    verify(pdDocumentCatalog).getStructureTreeRoot();
    verify(pdDocumentCatalog).getViewerPreferences();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getDocumentInformation()} return {@code null}.
   *   <li>Then calls {@link PDDocumentCatalog#getLanguage()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDDocument getDocumentInformation() return 'null'; then calls getLanguage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDDocumentGetDocumentInformationReturnNull_thenCallsGetLanguage()
      throws IOException {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getLanguage()).thenReturn("en");
    when(pdDocumentCatalog.getMetadata()).thenReturn(new PDMetadata(new COSStream()));
    when(pdDocumentCatalog.getMarkInfo()).thenReturn(new PDMarkInfo());
    when(pdDocumentCatalog.getStructureTreeRoot()).thenReturn(new PDStructureTreeRoot());
    when(pdDocumentCatalog.getViewerPreferences()).thenReturn(new PDViewerPreferences());
    when(pDDocument.getVersion()).thenReturn(10.0f);
    when(pDDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(pDDocument.getDocumentInformation()).thenReturn(null);
    when(pDDocument.getPages()).thenReturn(pdPageTree);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(pDDocument);

    // Assert
    verify(pDDocument, atLeast(1)).getDocumentCatalog();
    verify(pDDocument).getDocumentInformation();
    verify(pDDocument).getPages();
    verify(pDDocument).getVersion();
    verify(pdDocumentCatalog).getLanguage();
    verify(pdDocumentCatalog).getMarkInfo();
    verify(pdDocumentCatalog).getMetadata();
    verify(pdDocumentCatalog).getStructureTreeRoot();
    verify(pdDocumentCatalog).getViewerPreferences();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDDocument getPages() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDDocumentGetPagesThrowIllegalArgumentException() throws IOException {
    // Arrange
    when(pDDocument.getPages()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> splitter.split(pDDocument));
    verify(pDDocument).getPages();
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Annotations is {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDPage() Annotations is ArrayList(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDPageAnnotationsIsArrayList_thenCallsCreate() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDPage() Contents is ArrayList(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDPageContentsIsArrayList_thenCallsCreate() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDPage() CropBox is A0; when PDDocument() addPage PDPage(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDPageCropBoxIsA0_whenPDDocumentAddPagePDPage_thenCallsCreate()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is one.
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDPage() Rotation is one; when PDDocument() addPage PDPage(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDPageRotationIsOne_whenPDDocumentAddPagePDPage_thenCallsCreate()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setRotation(1);

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is zero.
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDPage() Rotation is zero; when PDDocument() addPage PDPage(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDPageRotationIsZero_whenPDDocumentAddPagePDPage_thenCallsCreate()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setRotation(0);

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} ThreadBeads is {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDPage() ThreadBeads is ArrayList(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDPageThreadBeadsIsArrayList_thenCallsCreate() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setThreadBeads(new ArrayList<>());

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDPageWithPageDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(mock(StreamCacheCreateFunction.class));

    PDDocument document = new PDDocument();
    document.addPage(new PDPage(new COSDictionary()));

    // Act and Assert
    assertTrue(splitter.split(document).isEmpty());
    assertSame(document, splitter.getSourceDocument());
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDPage(); when PDDocument() addPage PDPage(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDPage_whenPDDocumentAddPagePDPage_thenCallsCreate() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()} appendKid {@link
   *       PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDStructureTreeRoot() appendKid PDStructureElement(COSDictionary) with dic is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDStructureTreeRootAppendKidPDStructureElementWithDicIsCOSStream()
      throws IOException {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSStream()));

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getLanguage()).thenReturn("en");
    when(pdDocumentCatalog.getMetadata()).thenReturn(new PDMetadata(new COSStream()));
    when(pdDocumentCatalog.getMarkInfo()).thenReturn(new PDMarkInfo());
    when(pdDocumentCatalog.getStructureTreeRoot()).thenReturn(pdStructureTreeRoot);
    when(pdDocumentCatalog.getViewerPreferences()).thenReturn(new PDViewerPreferences());
    when(pDDocument.getVersion()).thenReturn(10.0f);
    when(pDDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(pDDocument.getDocumentInformation()).thenReturn(new PDDocumentInformation());
    when(pDDocument.getPages()).thenReturn(pdPageTree);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(pDDocument);

    // Assert
    verify(pDDocument, atLeast(1)).getDocumentCatalog();
    verify(pDDocument).getDocumentInformation();
    verify(pDDocument).getPages();
    verify(pDDocument).getVersion();
    verify(pdDocumentCatalog).getLanguage();
    verify(pdDocumentCatalog).getMarkInfo();
    verify(pdDocumentCatalog).getMetadata();
    verify(pdDocumentCatalog).getStructureTreeRoot();
    verify(pdDocumentCatalog).getViewerPreferences();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link Splitter} (default constructor).
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given Splitter (default constructor); when PDDocument() addPage PDPage(); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenSplitter_whenPDDocumentAddPagePDPage_thenReturnArrayLengthIsThree()
      throws IOException {
    // Arrange
    Splitter splitter = new Splitter();

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link Splitter} (default constructor).
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given Splitter (default constructor); when PDDocument() addPage PDPage(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenSplitter_whenPDDocumentAddPagePDPage_thenReturnSizeIsTwo()
      throws IOException {
    // Arrange
    Splitter splitter = new Splitter();

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    assertEquals(2, actualSplitResult.size());
    PDDocument getResult = actualSplitResult.get(1);
    assertTrue(getResult.getResourceCache() instanceof DefaultResourceCache);
    assertNull(getResult.getDocumentId());
    assertNull(getResult.getEncryption());
    assertNull(getResult.getLastSignatureDictionary());
    assertEquals(1, getResult.getNumberOfPages());
    assertEquals(1.4f, getResult.getVersion());
    assertFalse(getResult.isAllSecurityToBeRemoved());
    assertFalse(getResult.isEncrypted());
    assertTrue(getResult.getSignatureDictionaries().isEmpty());
    assertTrue(getResult.getSignatureFields().isEmpty());
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link Splitter} (default constructor).
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then {@link Splitter} (default constructor) SourceDocument is {@link
   *       PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given Splitter (default constructor); when PDDocument(); then Splitter (default constructor) SourceDocument is PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenSplitter_whenPDDocument_thenSplitterSourceDocumentIsPDDocument()
      throws IOException {
    // Arrange
    Splitter splitter = new Splitter();
    PDDocument document = new PDDocument();

    // Act and Assert
    assertTrue(splitter.split(document).isEmpty());
    assertSame(document, splitter.getSourceDocument());
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessStreamCache.StreamCacheCreateFunction} {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction#create()} return {@code null}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given StreamCacheCreateFunction create() return 'null'; then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenStreamCacheCreateFunctionCreateReturnNull_thenCallsCreate()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessStreamCache.StreamCacheCreateFunction} {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction#create()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given StreamCacheCreateFunction create() throw IOException(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenStreamCacheCreateFunctionCreateThrowIOException_thenCallsCreate()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Then first Pages iterator next Annotations first return {@link PDAnnotationCaret}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); then first Pages iterator next Annotations first return PDAnnotationCaret")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_thenFirstPagesIteratorNextAnnotationsFirstReturnPDAnnotationCaret()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    PDDocument getResult = actualSplitResult.get(0);
    Iterator<PDPage> iteratorResult = getResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    List<PDAnnotation> annotations2 = nextResult.getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult2 = annotations2.get(0);
    assertTrue(getResult2 instanceof PDAnnotationCaret);
    Iterator<PDPage> iteratorResult2 = getResult.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult2.next().getAnnotations();
    assertEquals(1, annotations3.size());
    assertTrue(annotations3.get(0) instanceof PDAnnotationCaret);
    assertEquals("Caret", getResult2.getSubtype());
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(new float[] {}, ((PDAnnotationCaret) getResult2).getRectDifferences(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Then first Pages iterator next Annotations first return {@link PDAnnotationCircle}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); then first Pages iterator next Annotations first return PDAnnotationCircle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_thenFirstPagesIteratorNextAnnotationsFirstReturnPDAnnotationCircle()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCircle());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    PDDocument getResult = actualSplitResult.get(0);
    Iterator<PDPage> iteratorResult = getResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    List<PDAnnotation> annotations2 = nextResult.getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult2 = annotations2.get(0);
    assertTrue(getResult2 instanceof PDAnnotationCircle);
    Iterator<PDPage> iteratorResult2 = getResult.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult2.next().getAnnotations();
    assertEquals(1, annotations3.size());
    assertTrue(annotations3.get(0) instanceof PDAnnotationCircle);
    assertEquals("Circle", getResult2.getSubtype());
    assertNull(((PDAnnotationCircle) getResult2).getRectDifference());
    assertNull(((PDAnnotationCircle) getResult2).getInteriorColor());
    assertNull(((PDAnnotationCircle) getResult2).getBorderEffect());
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(new float[] {}, ((PDAnnotationCircle) getResult2).getRectDifferences(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Then first Pages iterator next Annotations first return {@link PDAnnotationUnknown}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); then first Pages iterator next Annotations first return PDAnnotationUnknown")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_thenFirstPagesIteratorNextAnnotationsFirstReturnPDAnnotationUnknown()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(streamCacheCreateFunction);

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret(new COSDictionary()));

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument document = new PDDocument();
    document.addPage(page);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSplitResult.size());
    PDDocument getResult = actualSplitResult.get(0);
    Iterator<PDPage> iteratorResult = getResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    List<PDAnnotation> annotations2 = nextResult.getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult2 = annotations2.get(0);
    assertTrue(getResult2 instanceof PDAnnotationUnknown);
    Iterator<PDPage> iteratorResult2 = getResult.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult2.next().getAnnotations();
    assertEquals(1, annotations3.size());
    assertTrue(annotations3.get(0) instanceof PDAnnotationUnknown);
    assertNull(getResult2.getSubtype());
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Then return first DocumentInformation Title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument); then return first DocumentInformation Title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_thenReturnFirstDocumentInformationTitleIsDr() throws IOException {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getLanguage()).thenReturn("en");
    when(pdDocumentCatalog.getMetadata()).thenReturn(new PDMetadata(new COSStream()));
    when(pdDocumentCatalog.getMarkInfo()).thenReturn(new PDMarkInfo());
    when(pdDocumentCatalog.getStructureTreeRoot()).thenReturn(new PDStructureTreeRoot());
    when(pdDocumentCatalog.getViewerPreferences()).thenReturn(new PDViewerPreferences());

    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setTitle("Dr");
    when(pDDocument.getVersion()).thenReturn(10.0f);
    when(pDDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(pDDocument.getDocumentInformation()).thenReturn(pdDocumentInformation);
    when(pDDocument.getPages()).thenReturn(pdPageTree);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(pDDocument);

    // Assert
    verify(pDDocument, atLeast(1)).getDocumentCatalog();
    verify(pDDocument).getDocumentInformation();
    verify(pDDocument).getPages();
    verify(pDDocument).getVersion();
    verify(pdDocumentCatalog).getLanguage();
    verify(pdDocumentCatalog).getMarkInfo();
    verify(pdDocumentCatalog).getMetadata();
    verify(pdDocumentCatalog).getStructureTreeRoot();
    verify(pdDocumentCatalog).getViewerPreferences();
    assertEquals(1, actualSplitResult.size());
    PDDocument getResult = actualSplitResult.get(0);
    PDDocumentInformation documentInformation = getResult.getDocumentInformation();
    assertEquals("Dr", documentInformation.getTitle());
    COSDictionary cOSObject = documentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = documentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    Iterator<PDPage> iteratorResult = getResult.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertTrue(metadataKeys.contains("Title"));
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Then return first Pages iterator next StructParents is one.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument); then return first Pages iterator next StructParents is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_thenReturnFirstPagesIteratorNextStructParentsIsOne() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setStructParents(1);

    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(page);

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getLanguage()).thenReturn("en");
    when(pdDocumentCatalog.getMetadata()).thenReturn(new PDMetadata(new COSStream()));
    when(pdDocumentCatalog.getMarkInfo()).thenReturn(new PDMarkInfo());
    when(pdDocumentCatalog.getStructureTreeRoot()).thenReturn(new PDStructureTreeRoot());
    when(pdDocumentCatalog.getViewerPreferences()).thenReturn(new PDViewerPreferences());
    when(pDDocument.getVersion()).thenReturn(10.0f);
    when(pDDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(pDDocument.getDocumentInformation()).thenReturn(new PDDocumentInformation());
    when(pDDocument.getPages()).thenReturn(pdPageTree);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(pDDocument);

    // Assert
    verify(pDDocument, atLeast(1)).getDocumentCatalog();
    verify(pDDocument).getDocumentInformation();
    verify(pDDocument).getPages();
    verify(pDDocument).getVersion();
    verify(pdDocumentCatalog).getLanguage();
    verify(pdDocumentCatalog).getMarkInfo();
    verify(pdDocumentCatalog).getMetadata();
    verify(pdDocumentCatalog).getStructureTreeRoot();
    verify(pdDocumentCatalog).getViewerPreferences();
    assertEquals(1, actualSplitResult.size());
    PDDocument getResult = actualSplitResult.get(0);
    Iterator<PDPage> iteratorResult = getResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    assertEquals(1, nextResult.getStructParents());
    Iterator<PDPage> iteratorResult2 = getResult.getDocumentCatalog().getPages().iterator();
    assertEquals(1, iteratorResult2.next().getStructParents());
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   *
   * <ul>
   *   <li>Then {@link Splitter} SourceDocument is {@link PDDocument}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument); then Splitter SourceDocument is PDDocument")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_thenSplitterSourceDocumentIsPDDocument() throws IOException {
    // Arrange
    when(pDDocument.getPages()).thenReturn(new PDPageTree());

    // Act
    List<PDDocument> actualSplitResult = splitter.split(pDDocument);

    // Assert
    verify(pDDocument).getPages();
    assertTrue(actualSplitResult.isEmpty());
    assertSame(pDDocument, splitter.getSourceDocument());
  }

  /**
   * Test {@link Splitter#setSplitAtPage(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#setSplitAtPage(int)}
   */
  @Test
  @DisplayName("Test setSplitAtPage(int); when one; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Splitter.setSplitAtPage(int)"})
  void testSetSplitAtPage_whenOne_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new Splitter().setSplitAtPage(1));
  }

  /**
   * Test {@link Splitter#setSplitAtPage(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#setSplitAtPage(int)}
   */
  @Test
  @DisplayName("Test setSplitAtPage(int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Splitter.setSplitAtPage(int)"})
  void testSetSplitAtPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Splitter().setSplitAtPage(0));
  }

  /**
   * Test {@link Splitter#setStartPage(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#setStartPage(int)}
   */
  @Test
  @DisplayName("Test setStartPage(int); when one; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Splitter.setStartPage(int)"})
  void testSetStartPage_whenOne_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new Splitter().setStartPage(1));
  }

  /**
   * Test {@link Splitter#setStartPage(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#setStartPage(int)}
   */
  @Test
  @DisplayName("Test setStartPage(int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Splitter.setStartPage(int)"})
  void testSetStartPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Splitter().setStartPage(0));
  }

  /**
   * Test {@link Splitter#setEndPage(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#setEndPage(int)}
   */
  @Test
  @DisplayName("Test setEndPage(int); when three; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Splitter.setEndPage(int)"})
  void testSetEndPage_whenThree_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new Splitter().setEndPage(3));
  }

  /**
   * Test {@link Splitter#setEndPage(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#setEndPage(int)}
   */
  @Test
  @DisplayName("Test setEndPage(int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Splitter.setEndPage(int)"})
  void testSetEndPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Splitter().setEndPage(0));
  }

  /**
   * Test {@link Splitter#splitAtPage(int)}.
   *
   * <ul>
   *   <li>Given {@link Splitter} (default constructor) SplitAtPage is {@link Integer#MAX_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#splitAtPage(int)}
   */
  @Test
  @DisplayName(
      "Test splitAtPage(int); given Splitter (default constructor) SplitAtPage is MAX_VALUE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Splitter.splitAtPage(int)"})
  void testSplitAtPage_givenSplitterSplitAtPageIsMax_value_thenReturnFalse() {
    // Arrange
    Splitter splitter = new Splitter();
    splitter.setSplitAtPage(Integer.MAX_VALUE);

    // Act and Assert
    assertFalse(splitter.splitAtPage(10));
  }

  /**
   * Test {@link Splitter#splitAtPage(int)}.
   *
   * <ul>
   *   <li>Given {@link Splitter} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#splitAtPage(int)}
   */
  @Test
  @DisplayName("Test splitAtPage(int); given Splitter (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Splitter.splitAtPage(int)"})
  void testSplitAtPage_givenSplitter_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Splitter().splitAtPage(10));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Splitter}
   *   <li>{@link
   *       Splitter#setStreamCacheCreateFunction(RandomAccessStreamCache.StreamCacheCreateFunction)}
   *   <li>{@link Splitter#getDestinationDocument()}
   *   <li>{@link Splitter#getSourceDocument()}
   *   <li>{@link Splitter#getStreamCacheCreateFunction()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Splitter.<init>()",
    "PDDocument Splitter.getDestinationDocument()",
    "PDDocument Splitter.getSourceDocument()",
    "RandomAccessStreamCache.StreamCacheCreateFunction Splitter.getStreamCacheCreateFunction()",
    "void Splitter.setStreamCacheCreateFunction(RandomAccessStreamCache.StreamCacheCreateFunction)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Splitter actualSplitter = new Splitter();
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    actualSplitter.setStreamCacheCreateFunction(streamCacheCreateFunction);
    PDDocument actualDestinationDocument = actualSplitter.getDestinationDocument();
    PDDocument actualSourceDocument = actualSplitter.getSourceDocument();

    // Assert
    assertNull(actualDestinationDocument);
    assertNull(actualSourceDocument);
    assertSame(streamCacheCreateFunction, actualSplitter.getStreamCacheCreateFunction());
  }
}
