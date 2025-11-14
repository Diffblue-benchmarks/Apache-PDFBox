package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.pdfbox.cos.COSDictionary;
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
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-100L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream = new PDPageContentStream(document, sourcePage);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(sourcePage.hasContents());
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
  void testNewPDPageContentStream2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPage sourcePage = new PDPage(new COSDictionary());

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
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPage sourcePage = new PDPage(new COSDictionary());

    // Act
    PDPageContentStream actualPdPageContentStream =
        new PDPageContentStream(document, sourcePage, AppendMode.OVERWRITE, true, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    assertEquals(1, contentStreams.next().getFilters().size());
    assertFalse(contentStreams.hasNext());
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
  void testNewPDPageContentStream5() throws IOException {
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
  void testNewPDPageContentStream6() throws IOException {
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
    PDPageContentStream actualPdPageContentStream = new PDPageContentStream(document, sourcePage);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(sourcePage.hasContents());
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
    PDPageContentStream actualPdPageContentStream = new PDPageContentStream(document, sourcePage);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(sourcePage.hasContents());
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
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   *
   * <ul>
   *   <li>When {@code APPEND}.
   *   <li>Then {@link PDPage#PDPage()} Resources is {@link PDAbstractContentStream#resources}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); when 'APPEND'; then PDPage() Resources is resources")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean)"})
  void testNewPDPageContentStream_whenAppend_thenPDPageResourcesIsResources() throws IOException {
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
   *   <li>Then {@link PDPage#PDPage()} Resources is {@link PDAbstractContentStream#resources}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); when 'APPEND'; then PDPage() Resources is resources")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean, boolean)"
  })
  void testNewPDPageContentStream_whenAppend_thenPDPageResourcesIsResources2() throws IOException {
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
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then {@link PDPage#PDPage()} Resources is {@link PDAbstractContentStream#resources}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage); when PDDocument(); then PDPage() Resources is resources")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage)"})
  void testNewPDPageContentStream_whenPDDocument_thenPDPageResourcesIsResources()
      throws IOException {
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
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then {@link PDPage#PDPage()} Resources is {@link PDAbstractContentStream#resources}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); when PDDocument(); then PDPage() Resources is resources")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean)"})
  void testNewPDPageContentStream_whenPDDocument_thenPDPageResourcesIsResources2()
      throws IOException {
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
   *   <li>Then {@link PDPage#PDPage()} Resources is {@link PDAbstractContentStream#resources}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage,
   * AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); when PDDocument(); then PDPage() Resources is resources")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean, boolean)"
  })
  void testNewPDPageContentStream_whenPDDocument_thenPDPageResourcesIsResources3()
      throws IOException {
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
}
