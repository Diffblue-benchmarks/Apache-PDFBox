package org.apache.pdfbox.pdmodel;

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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPageContentStreamDiffblueTest {
  /**
   * Test AppendMode {@link AppendMode#isOverwrite()}.
   *
   * <ul>
   *   <li>Given {@code APPEND}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AppendMode#isOverwrite()}
   */
  @Test
  @DisplayName("Test AppendMode isOverwrite(); given 'APPEND'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppendMode.isOverwrite()"})
  void testAppendModeIsOverwrite_givenAppend_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AppendMode.APPEND.isOverwrite());
  }

  /**
   * Test AppendMode {@link AppendMode#isOverwrite()}.
   *
   * <ul>
   *   <li>Given {@code OVERWRITE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AppendMode#isOverwrite()}
   */
  @Test
  @DisplayName("Test AppendMode isOverwrite(); given 'OVERWRITE'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppendMode.isOverwrite()"})
  void testAppendModeIsOverwrite_givenOverwrite_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AppendMode.OVERWRITE.isOverwrite());
  }

  /**
   * Test AppendMode {@link AppendMode#isPrepend()}.
   *
   * <ul>
   *   <li>Given {@code OVERWRITE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AppendMode#isPrepend()}
   */
  @Test
  @DisplayName("Test AppendMode isPrepend(); given 'OVERWRITE'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppendMode.isPrepend()"})
  void testAppendModeIsPrepend_givenOverwrite_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AppendMode.OVERWRITE.isPrepend());
  }

  /**
   * Test AppendMode {@link AppendMode#isPrepend()}.
   *
   * <ul>
   *   <li>Given {@link AppendMode#PREPEND}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AppendMode#isPrepend()}
   */
  @Test
  @DisplayName("Test AppendMode isPrepend(); given PREPEND; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppendMode.isPrepend()"})
  void testAppendModeIsPrepend_givenPrepend_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AppendMode.PREPEND.isPrepend());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}.
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage)"})
  void testNewPDPageContentStream() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream = new PDPageContentStream(document, sourcePage);

    // Assert
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    assertSame(actualPdPageContentStream.resources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}.
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage)"})
  void testNewPDPageContentStream2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-100L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPage sourcePage = new PDPage();

    // Act
    new PDPageContentStream(document, sourcePage);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertNull(nextResult.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    COSStream cOSObject = nextResult.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(nextResult.getFileFilters().isEmpty());
    assertTrue(sourcePage.hasContents());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean)"})
  void testNewPDPageContentStream3() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-100L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(document, sourcePage, AppendMode.OVERWRITE, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    assertSame(actualPdPageContentStream.resources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean, boolean)"
  })
  void testNewPDPageContentStream4() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-100L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(document, sourcePage, AppendMode.OVERWRITE, true, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    assertSame(actualPdPageContentStream.resources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDAppearanceStream)}.
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDAppearanceStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDAppearanceStream)"})
  void testNewPDPageContentStream5() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(4096L);
    ScratchFile streamCache = new ScratchFile(memUsageSetting);
    COSStream stream = new COSStream(streamCache);
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    PDPageContentStream actualPdPageContentStream = new PDPageContentStream(doc, appearance);

    // Assert
    PDDocument pdDocument = actualPdPageContentStream.document;
    assertSame(
        pdDocument.getPages().getCOSObject(),
        pdDocument.getDocumentCatalog().getPages().getCOSObject());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDAppearanceStream,
   * OutputStream)}.
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument,
   * PDAppearanceStream, OutputStream)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDAppearanceStream, OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDPageContentStream.<init>(PDDocument, PDAppearanceStream, OutputStream)"
  })
  void testNewPDPageContentStream6() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(doc, appearance, new ByteArrayOutputStream());

    // Assert
    PDDocument pdDocument = actualPdPageContentStream.document;
    assertTrue(pdDocument.getResourceCache() instanceof DefaultResourceCache);
    assertNull(pdDocument.getDocumentId());
    assertNull(actualPdPageContentStream.resources);
    assertNull(pdDocument.getEncryption());
    assertNull(pdDocument.getLastSignatureDictionary());
    assertEquals(0, pdDocument.getNumberOfPages());
    assertEquals(1.4f, pdDocument.getVersion());
    assertFalse(pdDocument.isAllSecurityToBeRemoved());
    assertFalse(pdDocument.isEncrypted());
    assertFalse(actualPdPageContentStream.inTextMode);
    assertTrue(actualPdPageContentStream.fontStack.isEmpty());
    assertTrue(actualPdPageContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdPageContentStream.strokingColorSpaceStack.isEmpty());
    assertTrue(pdDocument.getSignatureDictionaries().isEmpty());
    assertTrue(pdDocument.getSignatureFields().isEmpty());
    assertTrue(pdDocument.getFontsToSubset().isEmpty());
    assertArrayEquals(
        new byte[] {},
        ((ByteArrayOutputStream) actualPdPageContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage)"})
  void testNewPDPageContentStream_givenArrayListAddPDStreamWithDocumentIsCOSDocument()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage sourcePage = new PDPage();
    sourcePage.setContents(contents);

    // Act
    new PDPageContentStream(document, sourcePage);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertFalse(contentStreams.hasNext());
    COSStream cOSObject = nextResult.getCOSObject();
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(nextResult.getFileFilters().isEmpty());
    assertTrue(sourcePage.hasContents());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage); given ArrayList(); when PDPage() Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage)"})
  void testNewPDPageContentStream_givenArrayList_whenPDPageContentsIsArrayList()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    PDPage sourcePage = new PDPage();
    sourcePage.setContents(new ArrayList<>());

    // Act
    new PDPageContentStream(document, sourcePage);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertNull(nextResult.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    COSStream cOSObject = nextResult.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(nextResult.getFileFilters().isEmpty());
    assertTrue(sourcePage.hasContents());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); given ArrayList(); when PDPage() Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean)"})
  void testNewPDPageContentStream_givenArrayList_whenPDPageContentsIsArrayList2()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    PDPage sourcePage = new PDPage();
    sourcePage.setContents(new ArrayList<>());

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(document, sourcePage, AppendMode.OVERWRITE, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    assertSame(actualPdPageContentStream.resources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given ArrayList(); when PDPage() Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean, boolean)"
  })
  void testNewPDPageContentStream_givenArrayList_whenPDPageContentsIsArrayList3()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    PDPage sourcePage = new PDPage();
    sourcePage.setContents(new ArrayList<>());

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(document, sourcePage, AppendMode.OVERWRITE, true, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    assertSame(actualPdPageContentStream.resources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage)"})
  void testNewPDPageContentStream_givenNull() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPage sourcePage = new PDPage();

    // Act
    new PDPageContentStream(document, sourcePage);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertNull(nextResult.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    COSStream cOSObject = nextResult.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(nextResult.getFileFilters().isEmpty());
    assertTrue(sourcePage.hasContents());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean)"})
  void testNewPDPageContentStream_givenNull2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(document, sourcePage, AppendMode.OVERWRITE, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    assertSame(actualPdPageContentStream.resources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean, boolean)"
  })
  void testNewPDPageContentStream_givenNull3() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(document, sourcePage, AppendMode.OVERWRITE, true, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    assertSame(actualPdPageContentStream.resources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage); given PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage)"})
  void testNewPDPageContentStream_givenPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    PDPage sourcePage = new PDPage();
    sourcePage.setContents(new PDStream(new COSDocument()));

    // Act
    new PDPageContentStream(document, sourcePage);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    assertFalse(contentStreams.hasNext());
    COSStream cOSObject = nextResult.getCOSObject();
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(nextResult.getFileFilters().isEmpty());
    assertTrue(sourcePage.hasContents());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   *
   * <ul>
   *   <li>When {@code APPEND}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); when 'APPEND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean)"})
  void testNewPDPageContentStream_whenAppend() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(document, sourcePage, AppendMode.APPEND, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    assertSame(actualPdPageContentStream.resources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code APPEND}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); when 'APPEND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean, boolean)"
  })
  void testNewPDPageContentStream_whenAppend2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(document, sourcePage, AppendMode.APPEND, true, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    assertSame(actualPdPageContentStream.resources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDAppearanceStream)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceStream#PDAppearanceStream(COSStream)} with stream is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument,
   * PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDAppearanceStream); when PDAppearanceStream(COSStream) with stream is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDAppearanceStream)"})
  void testNewPDPageContentStream_whenPDAppearanceStreamWithStreamIsCOSStream() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(doc, new PDAppearanceStream(new COSStream()));

    // Assert
    PDDocument pdDocument = actualPdPageContentStream.document;
    assertSame(
        pdDocument.getPages().getCOSObject(),
        pdDocument.getDocumentCatalog().getPages().getCOSObject());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); when PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean)"})
  void testNewPDPageContentStream_whenPDDocument() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(document, sourcePage, AppendMode.OVERWRITE, true);

    // Assert
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    assertSame(actualPdPageContentStream.resources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); when PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean, boolean)"
  })
  void testNewPDPageContentStream_whenPDDocument2() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(document, sourcePage, AppendMode.OVERWRITE, true, true);

    // Assert
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    assertSame(actualPdPageContentStream.resources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#appendRawCommands(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link PDPageContentStream#appendRawCommands(byte[])}
   */
  @Test
  @DisplayName("Test appendRawCommands(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.appendRawCommands(byte[])"})
  void testAppendRawCommandsWithByte() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    PDPageContentStream pdPageContentStream =
        new PDPageContentStream(doc, appearance, new ByteArrayOutputStream());

    // Act
    pdPageContentStream.appendRawCommands("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdPageContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDPageContentStream#appendRawCommands(double)} with {@code double}.
   *
   * <p>Method under test: {@link PDPageContentStream#appendRawCommands(double)}
   */
  @Test
  @DisplayName("Test appendRawCommands(double) with 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.appendRawCommands(double)"})
  void testAppendRawCommandsWithDouble() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    PDPageContentStream pdPageContentStream =
        new PDPageContentStream(doc, appearance, new ByteArrayOutputStream());

    // Act
    pdPageContentStream.appendRawCommands(10.0d);

    // Assert
    byte[] expectedToByteArrayResult = "10 ".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdPageContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDPageContentStream#appendRawCommands(double)} with {@code double}.
   *
   * <p>Method under test: {@link PDPageContentStream#appendRawCommands(double)}
   */
  @Test
  @DisplayName("Test appendRawCommands(double) with 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.appendRawCommands(double)"})
  void testAppendRawCommandsWithDouble2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    PDPageContentStream pdPageContentStream =
        new PDPageContentStream(doc, appearance, new ByteArrayOutputStream());
    pdPageContentStream.setMaximumFractionDigits(10);

    // Act
    pdPageContentStream.appendRawCommands(10.0d);

    // Assert
    byte[] expectedToByteArrayResult = "10 ".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdPageContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDPageContentStream#appendRawCommands(float)} with {@code float}.
   *
   * <p>Method under test: {@link PDPageContentStream#appendRawCommands(float)}
   */
  @Test
  @DisplayName("Test appendRawCommands(float) with 'float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.appendRawCommands(float)"})
  void testAppendRawCommandsWithFloat() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    PDPageContentStream pdPageContentStream =
        new PDPageContentStream(doc, appearance, new ByteArrayOutputStream());

    // Act
    pdPageContentStream.appendRawCommands(10.0f);

    // Assert
    byte[] expectedToByteArrayResult = "10 ".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdPageContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDPageContentStream#appendRawCommands(float)} with {@code float}.
   *
   * <p>Method under test: {@link PDPageContentStream#appendRawCommands(float)}
   */
  @Test
  @DisplayName("Test appendRawCommands(float) with 'float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.appendRawCommands(float)"})
  void testAppendRawCommandsWithFloat2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    PDPageContentStream pdPageContentStream =
        new PDPageContentStream(doc, appearance, new ByteArrayOutputStream());
    pdPageContentStream.setMaximumFractionDigits(10);

    // Act
    pdPageContentStream.appendRawCommands(10.0f);

    // Assert
    byte[] expectedToByteArrayResult = "10 ".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdPageContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDPageContentStream#appendRawCommands(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDPageContentStream#appendRawCommands(int)}
   */
  @Test
  @DisplayName("Test appendRawCommands(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.appendRawCommands(int)"})
  void testAppendRawCommandsWithInt() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    PDPageContentStream pdPageContentStream =
        new PDPageContentStream(doc, appearance, new ByteArrayOutputStream());

    // Act
    pdPageContentStream.appendRawCommands(1);

    // Assert
    assertArrayEquals(
        new byte[] {'1', ' '},
        ((ByteArrayOutputStream) pdPageContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDPageContentStream#appendRawCommands(String)} with {@code String}.
   *
   * <p>Method under test: {@link PDPageContentStream#appendRawCommands(String)}
   */
  @Test
  @DisplayName("Test appendRawCommands(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.appendRawCommands(String)"})
  void testAppendRawCommandsWithString() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    PDPageContentStream pdPageContentStream =
        new PDPageContentStream(doc, appearance, new ByteArrayOutputStream());

    // Act
    pdPageContentStream.appendRawCommands("Commands");

    // Assert
    byte[] expectedToByteArrayResult = "Commands".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdPageContentStream.outputStream).toByteArray());
  }
}
