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
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDMarkInfo;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
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
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return {@link
   *       PDPageTree#PDPageTree(COSDictionary)} with root is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDDocument getPages() return PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDDocumentGetPagesReturnPDPageTreeWithRootIsCOSDictionary()
      throws IOException {
    // Arrange
    when(pDDocument.getPages()).thenReturn(new PDPageTree(new COSDictionary()));

    // Act
    List<PDDocument> actualSplitResult = splitter.split(pDDocument);

    // Assert
    verify(pDDocument).getPages();
    assertTrue(actualSplitResult.isEmpty());
    assertSame(pDDocument, splitter.getSourceDocument());
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
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDPage(); when PDDocument() addPage PDPage(); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDPage_whenPDDocumentAddPagePDPage_thenReturnArrayLengthIsThree()
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
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test split(PDDocument); given PDPage(); when PDDocument() addPage PDPage(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenPDPage_whenPDDocumentAddPagePDPage_thenReturnSizeIsTwo() throws IOException {
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
   *   <li>Then return first DocumentCatalog Metadata is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument); then return first DocumentCatalog Metadata is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_thenReturnFirstDocumentCatalogMetadataIsNull() throws IOException {
    // Arrange
    when(pDDocument.getVersion()).thenReturn(10.0f);

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getLanguage()).thenReturn("en");
    when(pdDocumentCatalog.getMetadata()).thenReturn(null);
    when(pdDocumentCatalog.getMarkInfo()).thenReturn(new PDMarkInfo());
    when(pdDocumentCatalog.getStructureTreeRoot()).thenReturn(new PDStructureTreeRoot());
    when(pdDocumentCatalog.getViewerPreferences()).thenReturn(new PDViewerPreferences());
    when(pDDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(pDDocument.getDocumentInformation()).thenReturn(new PDDocumentInformation());

    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());
    when(pDDocument.getPages()).thenReturn(pdPageTree);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(pDDocument);

    // Assert
    assertEquals(1, actualSplitResult.size());
    PDDocument getResult = actualSplitResult.get(0);
    assertNull(getResult.getDocumentCatalog().getMetadata());
    Iterator<PDPage> iteratorResult = getResult.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    PDStream nextResult2 = contentStreams.next();
    assertFalse(contentStreams.hasNext());
    assertTrue(nextResult2.getFileFilters().isEmpty());
    float[][] values = nextResult.getMatrix().getValues();
    assertEquals(3, values.length);
    float[] actualFloatArray = values[0];
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, actualFloatArray, 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    verify(pDDocument).getVersion();
    verify(pDDocument, atLeast(1)).getDocumentCatalog();
    verify(pDDocument).getDocumentInformation();
    verify(pDDocument).getPages();
    verify(pdDocumentCatalog).getLanguage();
    verify(pdDocumentCatalog).getMetadata();
    verify(pdDocumentCatalog).getMarkInfo();
    verify(pdDocumentCatalog).getStructureTreeRoot();
    verify(pdDocumentCatalog).getViewerPreferences();
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
   * <p>Method under test: {@link Splitter#splitAtPage(int)}
   */
  @Test
  @DisplayName("Test splitAtPage(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Splitter.splitAtPage(int)"})
  void testSplitAtPage() {
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
