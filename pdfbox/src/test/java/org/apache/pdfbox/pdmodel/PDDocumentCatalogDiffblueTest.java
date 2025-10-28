package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.PDDestinationOrAction;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDPageLabels;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDMarkInfo;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
import org.apache.pdfbox.pdmodel.fixup.PDDocumentFixup;
import org.apache.pdfbox.pdmodel.graphics.color.PDOutputIntent;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties;
import org.apache.pdfbox.pdmodel.interactive.action.PDDocumentCatalogAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.action.PDURIDictionary;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitHeightDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitRectangleDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitWidthDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThread;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThreadBead;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentCatalogDiffblueTest {
  /**
   * Method under test: {@link PDDocumentCatalog#getAcroForm()}
   */
  @Test
  void testGetAcroForm() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getAcroForm());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getAcroForm()}
   */
  @Test
  void testGetAcroForm2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDAcroForm actualAcroForm = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction))).getAcroForm();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualAcroForm);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getAcroForm()}
   */
  @Test
  void testGetAcroForm3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());
    doc.addSignature(new PDSignature());

    // Act
    PDAcroForm actualAcroForm = (new PDDocumentCatalog(doc)).getAcroForm();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualAcroForm);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getAcroForm()}
   */
  @Test
  void testGetAcroForm4() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());
    PDDocument doc2 = new PDDocument(doc);

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc2, new COSDictionary())).getAcroForm());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)}
   */
  @Test
  void testGetAcroForm5() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    PDDocumentFixup acroFormFixup = mock(PDDocumentFixup.class);
    doNothing().when(acroFormFixup).apply();

    // Act
    PDAcroForm actualAcroForm = pdDocumentCatalog.getAcroForm(acroFormFixup);

    // Assert
    verify(acroFormFixup).apply();
    assertNull(actualAcroForm);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)}
   */
  @Test
  void testGetAcroForm6() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    PDDocumentFixup acroFormFixup = mock(PDDocumentFixup.class);
    doThrow(new IllegalArgumentException("foo")).when(acroFormFixup).apply();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentCatalog.getAcroForm(acroFormFixup));
    verify(acroFormFixup).apply();
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setAcroForm(PDAcroForm)}
   */
  @Test
  void testSetAcroForm() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    pdDocumentCatalog.setAcroForm(acroForm);

    // Assert
    assertEquals("", acroForm.getDefaultAppearance());
    PDAcroForm acroForm2 = pdDocumentCatalog.getAcroForm();
    assertEquals("", acroForm2.getDefaultAppearance());
    COSDictionary cOSObject = acroForm.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(acroForm.getDefaultResources());
    assertNull(acroForm2.getDefaultResources());
    assertNull(acroForm2.getXFA());
    assertNull(acroForm2.getScriptingHandler());
    assertEquals(0, acroForm2.getQ());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(acroForm2.getFieldIterator().hasNext());
    assertFalse(acroForm2.getFieldTree().iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(acroForm2.getNeedAppearances());
    assertFalse(acroForm2.isAppendOnly());
    assertFalse(acroForm2.isCachingFields());
    assertFalse(acroForm2.isSignaturesExist());
    assertTrue(acroForm2.getFields().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
    assertSame(cOSObject, acroForm2.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPages()}
   */
  @Test
  void testGetPages() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(rootDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    PDPageTree actualPages = (new PDDocumentCatalog(new PDDocument(), rootDictionary)).getPages();

    // Assert
    verify(rootDictionary).getCOSDictionary(isA(COSName.class));
    assertEquals(0, actualPages.getCount());
    assertFalse(actualPages.iterator().hasNext());
    assertSame(cosDictionary, actualPages.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPages()}
   */
  @Test
  void testGetPages2() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary rootDictionary = mock(COSDictionary.class);
    when(rootDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    PDPageTree actualPages = (new PDDocumentCatalog(new PDDocument(), rootDictionary)).getPages();

    // Assert
    verify(rootDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    assertEquals(0, actualPages.getCount());
    assertFalse(actualPages.iterator().hasNext());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPages()}
   */
  @Test
  void testGetPages3() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException("foo"));
    COSDictionary rootDictionary = mock(COSDictionary.class);
    when(rootDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDDocumentCatalog(new PDDocument(), rootDictionary)).getPages());
    verify(rootDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getViewerPreferences()}
   */
  @Test
  void testGetViewerPreferences() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getViewerPreferences());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getViewerPreferences()}
   */
  @Test
  void testGetViewerPreferences2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDViewerPreferences actualViewerPreferences = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction)))
        .getViewerPreferences();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualViewerPreferences);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#setViewerPreferences(PDViewerPreferences)}
   */
  @Test
  void testSetViewerPreferences() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    PDViewerPreferences prefs = new PDViewerPreferences();

    // Act
    pdDocumentCatalog.setViewerPreferences(prefs);

    // Assert
    PDViewerPreferences viewerPreferences = pdDocumentCatalog.getViewerPreferences();
    assertEquals("AppDefault", viewerPreferences.getPrintScaling());
    assertEquals("CropBox", viewerPreferences.getPrintArea());
    assertEquals("CropBox", viewerPreferences.getPrintClip());
    assertEquals("CropBox", viewerPreferences.getViewArea());
    assertEquals("CropBox", viewerPreferences.getViewClip());
    assertEquals("L2R", viewerPreferences.getReadingDirection());
    assertEquals("UseNone", viewerPreferences.getNonFullScreenPageMode());
    assertNull(viewerPreferences.getDuplex());
    COSDictionary cOSObject = prefs.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
    assertSame(cOSObject, viewerPreferences.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getDocumentOutline()}
   */
  @Test
  void testGetDocumentOutline() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getDocumentOutline());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getDocumentOutline()}
   */
  @Test
  void testGetDocumentOutline2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDDocumentOutline actualDocumentOutline = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction)))
        .getDocumentOutline();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDocumentOutline);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getDocumentOutline()}
   */
  @Test
  void testGetDocumentOutline3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    PDDocumentOutline outlines = new PDDocumentOutline();
    pdDocumentCatalog.setDocumentOutline(outlines);

    // Act
    PDDocumentOutline actualDocumentOutline = pdDocumentCatalog.getDocumentOutline();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(outlines, actualDocumentOutline);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getDocumentOutline()}
   */
  @Test
  void testGetDocumentOutline4() {
    // Arrange
    PDDocument doc = new PDDocument();

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, new COSDictionary());
    PDDocumentOutline outlines = new PDDocumentOutline();
    pdDocumentCatalog.setDocumentOutline(outlines);

    // Act and Assert
    assertEquals(outlines, pdDocumentCatalog.getDocumentOutline());
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#setDocumentOutline(PDDocumentOutline)}
   */
  @Test
  void testSetDocumentOutline() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    PDDocumentOutline outlines = new PDDocumentOutline();

    // Act
    pdDocumentCatalog.setDocumentOutline(outlines);

    // Assert
    COSDictionary cOSObject = outlines.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(outlines.getFirstChild());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(outlines, pdDocumentCatalog.getDocumentOutline());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getThreads()}
   */
  @Test
  void testGetThreads() {
    // Arrange, Act and Assert
    assertTrue((new PDDocumentCatalog(new PDDocument())).getThreads().isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getThreads()}
   */
  @Test
  void testGetThreads2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<PDThread> actualThreads = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction))).getThreads();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualThreads.isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getThreads()}
   */
  @Test
  void testGetThreads3() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertTrue((new PDDocumentCatalog(doc, new COSDictionary())).getThreads().isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getThreads()}
   */
  @Test
  void testGetThreads4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    pdDocumentCatalog.setThreads(new ArrayList<>());

    // Act
    List<PDThread> actualThreads = pdDocumentCatalog.getThreads();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualThreads.isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setThreads(List)}
   */
  @Test
  void testSetThreads() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    ArrayList<PDThread> threads = new ArrayList<>();

    // Act
    pdDocumentCatalog.setThreads(threads);

    // Assert
    assertTrue(threads.isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setThreads(List)}
   */
  @Test
  void testSetThreads2() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, new COSDictionary());
    ArrayList<PDThread> threads = new ArrayList<>();

    // Act
    pdDocumentCatalog.setThreads(threads);

    // Assert
    assertTrue(threads.isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setThreads(List)}
   */
  @Test
  void testSetThreads3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));

    PDThread pdThread = new PDThread();
    pdThread.setFirstBead(new PDThreadBead());

    ArrayList<PDThread> threads = new ArrayList<>();
    threads.add(pdThread);

    // Act
    pdDocumentCatalog.setThreads(threads);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, threads.size());
    assertSame(pdThread, threads.get(0));
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setThreads(List)}
   */
  @Test
  void testSetThreads4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));

    PDThreadBead bead = new PDThreadBead();
    bead.setPage(new PDPage());

    PDThread pdThread = new PDThread();
    pdThread.setFirstBead(bead);

    ArrayList<PDThread> threads = new ArrayList<>();
    threads.add(pdThread);

    // Act
    pdDocumentCatalog.setThreads(threads);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, threads.size());
    assertSame(pdThread, threads.get(0));
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getMetadata()}
   */
  @Test
  void testGetMetadata() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getMetadata());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getMetadata()}
   */
  @Test
  void testGetMetadata2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDMetadata actualMetadata = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction))).getMetadata();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualMetadata);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getMetadata()}
   */
  @Test
  void testGetMetadata3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    COSStream str = new COSStream();
    pdDocumentCatalog.setMetadata(new PDMetadata(str));

    // Act
    PDMetadata actualMetadata = pdDocumentCatalog.getMetadata();

    // Assert
    verify(streamCacheCreateFunction).create();
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
   * Method under test: {@link PDDocumentCatalog#getMetadata()}
   */
  @Test
  void testGetMetadata4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));
    PDMetadata meta = new PDMetadata(str);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.setMetadata(meta);

    // Act
    PDMetadata actualMetadata = pdDocumentCatalog.getMetadata();

    // Assert
    verify(streamCacheCreateFunction).create();
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
   * Method under test: {@link PDDocumentCatalog#setMetadata(PDMetadata)}
   */
  @Test
  void testSetMetadata() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    COSStream str = new COSStream();
    PDMetadata meta = new PDMetadata(str);

    // Act
    pdDocumentCatalog.setMetadata(meta);

    // Assert
    PDMetadata metadata = pdDocumentCatalog.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(meta.getFile());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
    assertSame(str, meta.getCOSObject());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#setOpenAction(PDDestinationOrAction)}
   */
  @Test
  void testSetOpenAction() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    PDDestinationOrAction action = mock(PDDestinationOrAction.class);
    when(action.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdDocumentCatalog.setOpenAction(action);

    // Assert
    verify(action).getCOSObject();
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#setOpenAction(PDDestinationOrAction)}
   */
  @Test
  void testSetOpenAction2() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    PDDestinationOrAction action = mock(PDDestinationOrAction.class);
    when(action.getCOSObject()).thenReturn(new COSArray());

    // Act
    pdDocumentCatalog.setOpenAction(action);

    // Assert
    verify(action).getCOSObject();
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getActions()}
   */
  @Test
  void testGetActions() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act
    PDDocumentCatalogAdditionalActions actualActions = (new PDDocumentCatalog(doc, new COSDictionary())).getActions();

    // Assert
    COSDictionary cOSObject = actualActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualActions.getDP());
    assertNull(actualActions.getDS());
    assertNull(actualActions.getWC());
    assertNull(actualActions.getWP());
    assertNull(actualActions.getWS());
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
   * Method under test:
   * {@link PDDocumentCatalog#setActions(PDDocumentCatalogAdditionalActions)}
   */
  @Test
  void testSetActions() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, new COSDictionary());
    PDDocumentCatalogAdditionalActions actions = new PDDocumentCatalogAdditionalActions();

    // Act
    pdDocumentCatalog.setActions(actions);

    // Assert
    COSDictionary cOSObject = actions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actions.getWC());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(cOSObject, pdDocumentCatalog.getActions().getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getNames()}
   */
  @Test
  void testGetNames() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getNames());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getNames()}
   */
  @Test
  void testGetNames2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDDocumentNameDictionary actualNames = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction)))
        .getNames();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualNames);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getDests()}
   */
  @Test
  void testGetDests() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getDests());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getDests()}
   */
  @Test
  void testGetDests2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDDocumentNameDestinationDictionary actualDests = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction)))
        .getDests();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDests);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage() throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination("Dest"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    pdDocumentCatalog.setNames(new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument())));

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination("Dest"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names.setDests(new PDDestinationNameTreeNode());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.setNames(names);

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination("Dest"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names.setDests(new PDDestinationNameTreeNode());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.setNames(names);

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination(""));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names.setDests(new PDDestinationNameTreeNode());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.setNames(names);

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names.setDests(new PDDestinationNameTreeNode());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.setNames(names);

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination(COSName.A));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(new HashMap<>());

    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.setNames(names);

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination("Dest"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.setNames(names2);

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination("Dest"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", null);

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.setNames(names2);

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination("Dest"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitHeightDestination());

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.setNames(names2);

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination("Dest"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage12() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitRectangleDestination());

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.setNames(names2);

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination("Dest"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  void testFindNamedDestinationPage13() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitWidthDestination());

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.setNames(names2);

    // Act
    PDPageDestination actualFindNamedDestinationPageResult = pdDocumentCatalog
        .findNamedDestinationPage(new PDNamedDestination("Dest"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindNamedDestinationPageResult);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#setNames(PDDocumentNameDictionary)}
   */
  @Test
  void testSetNames() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);

    // Act
    pdDocumentCatalog.setNames(new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument())));

    // Assert
    PDDocumentNameDictionary names = pdDocumentCatalog.getNames();
    assertNull(names.getDests());
    assertNull(names.getEmbeddedFiles());
    assertNull(names.getJavaScript());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#setNames(PDDocumentNameDictionary)}
   */
  @Test
  void testSetNames2() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    PDDocument doc2 = new PDDocument();
    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(doc2, new COSDictionary()));

    // Act
    pdDocumentCatalog.setNames(names);

    // Assert
    COSDictionary cOSObject = names.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(names.getDests());
    PDDocumentNameDictionary names2 = pdDocumentCatalog.getNames();
    assertNull(names2.getDests());
    assertNull(names2.getEmbeddedFiles());
    assertNull(names2.getJavaScript());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
    assertSame(cOSObject, names2.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getMarkInfo()}
   */
  @Test
  void testGetMarkInfo() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getMarkInfo());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getMarkInfo()}
   */
  @Test
  void testGetMarkInfo2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDMarkInfo actualMarkInfo = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction))).getMarkInfo();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualMarkInfo);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setMarkInfo(PDMarkInfo)}
   */
  @Test
  void testSetMarkInfo() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    PDMarkInfo markInfo = new PDMarkInfo();

    // Act
    pdDocumentCatalog.setMarkInfo(markInfo);

    // Assert
    COSDictionary cOSObject = markInfo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    PDMarkInfo markInfo2 = pdDocumentCatalog.getMarkInfo();
    assertFalse(markInfo2.isMarked());
    assertFalse(markInfo2.isSuspect());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
    assertSame(cOSObject, markInfo2.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getOutputIntents()}
   */
  @Test
  void testGetOutputIntents() {
    // Arrange, Act and Assert
    assertTrue((new PDDocumentCatalog(new PDDocument())).getOutputIntents().isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getOutputIntents()}
   */
  @Test
  void testGetOutputIntents2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<PDOutputIntent> actualOutputIntents = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction)))
        .getOutputIntents();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualOutputIntents.isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getOutputIntents()}
   */
  @Test
  void testGetOutputIntents3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    COSDictionary dictionary = new COSDictionary();
    pdDocumentCatalog.addOutputIntent(new PDOutputIntent(dictionary));

    // Act
    List<PDOutputIntent> actualOutputIntents = pdDocumentCatalog.getOutputIntents();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualOutputIntents.size());
    PDOutputIntent getResult = actualOutputIntents.get(0);
    assertNull(getResult.getInfo());
    assertNull(getResult.getOutputCondition());
    assertNull(getResult.getOutputConditionIdentifier());
    assertNull(getResult.getRegistryName());
    assertNull(getResult.getDestOutputIntent());
    assertSame(dictionary, getResult.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getOutputIntents()}
   */
  @Test
  void testGetOutputIntents4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDOutputIntent outputIntent = new PDOutputIntent(dictionary);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc);
    pdDocumentCatalog.addOutputIntent(outputIntent);

    // Act
    List<PDOutputIntent> actualOutputIntents = pdDocumentCatalog.getOutputIntents();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualOutputIntents.size());
    PDOutputIntent getResult = actualOutputIntents.get(0);
    assertNull(getResult.getInfo());
    assertNull(getResult.getOutputCondition());
    assertNull(getResult.getOutputConditionIdentifier());
    assertNull(getResult.getRegistryName());
    assertNull(getResult.getDestOutputIntent());
    assertSame(dictionary, getResult.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#addOutputIntent(PDOutputIntent)}
   */
  @Test
  void testAddOutputIntent() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    COSDictionary dictionary = new COSDictionary();
    PDOutputIntent outputIntent = new PDOutputIntent(dictionary);

    // Act
    pdDocumentCatalog.addOutputIntent(outputIntent);

    // Assert
    List<PDOutputIntent> outputIntents = pdDocumentCatalog.getOutputIntents();
    assertEquals(1, outputIntents.size());
    PDOutputIntent getResult = outputIntents.get(0);
    assertNull(getResult.getInfo());
    assertNull(getResult.getOutputCondition());
    assertNull(getResult.getOutputConditionIdentifier());
    assertNull(getResult.getRegistryName());
    assertNull(getResult.getDestOutputIntent());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
    assertSame(dictionary, outputIntent.getCOSObject());
    assertSame(dictionary, getResult.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setOutputIntents(List)}
   */
  @Test
  void testSetOutputIntents() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    ArrayList<PDOutputIntent> outputIntents = new ArrayList<>();

    // Act
    pdDocumentCatalog.setOutputIntents(outputIntents);

    // Assert
    assertTrue(outputIntents.isEmpty());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPageMode()}
   */
  @Test
  void testGetPageMode() {
    // Arrange, Act and Assert
    assertEquals(PageMode.USE_NONE, (new PDDocumentCatalog(new PDDocument())).getPageMode());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPageMode()}
   */
  @Test
  void testGetPageMode2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PageMode actualPageMode = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction))).getPageMode();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(PageMode.USE_NONE, actualPageMode);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPageMode()}
   */
  @Test
  void testGetPageMode3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    pdDocumentCatalog.setPageMode(PageMode.USE_NONE);

    // Act
    PageMode actualPageMode = pdDocumentCatalog.getPageMode();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(PageMode.USE_NONE, actualPageMode);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPageMode()}
   */
  @Test
  void testGetPageMode4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    pdDocumentCatalog.setPageMode(PageMode.USE_OUTLINES);

    // Act
    PageMode actualPageMode = pdDocumentCatalog.getPageMode();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(PageMode.USE_OUTLINES, actualPageMode);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setPageMode(PageMode)}
   */
  @Test
  void testSetPageMode() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);

    // Act
    pdDocumentCatalog.setPageMode(PageMode.USE_NONE);

    // Assert
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPageLayout()}
   */
  @Test
  void testGetPageLayout() {
    // Arrange, Act and Assert
    assertEquals(PageLayout.SINGLE_PAGE, (new PDDocumentCatalog(new PDDocument())).getPageLayout());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPageLayout()}
   */
  @Test
  void testGetPageLayout2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PageLayout actualPageLayout = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction))).getPageLayout();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(PageLayout.SINGLE_PAGE, actualPageLayout);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPageLayout()}
   */
  @Test
  void testGetPageLayout3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    pdDocumentCatalog.setPageLayout(PageLayout.SINGLE_PAGE);

    // Act
    PageLayout actualPageLayout = pdDocumentCatalog.getPageLayout();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(PageLayout.SINGLE_PAGE, actualPageLayout);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPageLayout()}
   */
  @Test
  void testGetPageLayout4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    pdDocumentCatalog.setPageLayout(PageLayout.ONE_COLUMN);

    // Act
    PageLayout actualPageLayout = pdDocumentCatalog.getPageLayout();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(PageLayout.ONE_COLUMN, actualPageLayout);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setPageLayout(PageLayout)}
   */
  @Test
  void testSetPageLayout() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);

    // Act
    pdDocumentCatalog.setPageLayout(PageLayout.SINGLE_PAGE);

    // Assert
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getURI()}
   */
  @Test
  void testGetURI() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getURI());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getURI()}
   */
  @Test
  void testGetURI2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDURIDictionary actualURI = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction))).getURI();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualURI);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setURI(PDURIDictionary)}
   */
  @Test
  void testSetURI() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    PDURIDictionary uri = new PDURIDictionary();

    // Act
    pdDocumentCatalog.setURI(uri);

    // Assert
    PDURIDictionary uRI = pdDocumentCatalog.getURI();
    assertNull(uRI.getBase());
    COSDictionary cOSObject = uri.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
    assertSame(cOSObject, uRI.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getStructureTreeRoot()}
   */
  @Test
  void testGetStructureTreeRoot() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getStructureTreeRoot());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getStructureTreeRoot()}
   */
  @Test
  void testGetStructureTreeRoot2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDStructureTreeRoot actualStructureTreeRoot = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction)))
        .getStructureTreeRoot();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualStructureTreeRoot);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#setStructureTreeRoot(PDStructureTreeRoot)}
   */
  @Test
  void testSetStructureTreeRoot() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    PDStructureTreeRoot treeRoot = new PDStructureTreeRoot();

    // Act
    pdDocumentCatalog.setStructureTreeRoot(treeRoot);

    // Assert
    PDStructureTreeRoot structureTreeRoot = pdDocumentCatalog.getStructureTreeRoot();
    assertEquals("StructTreeRoot", structureTreeRoot.getType());
    assertNull(treeRoot.getK());
    assertNull(structureTreeRoot.getK());
    COSDictionary cOSObject = treeRoot.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(structureTreeRoot.getIDTree());
    assertNull(structureTreeRoot.getParentTree());
    assertEquals(-1, structureTreeRoot.getParentTreeNextKey());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(treeRoot.getKids().isEmpty());
    assertTrue(structureTreeRoot.getKids().isEmpty());
    assertTrue(structureTreeRoot.getClassMap().isEmpty());
    assertTrue(structureTreeRoot.getRoleMap().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
    assertSame(cOSObject, structureTreeRoot.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getLanguage()}
   */
  @Test
  void testGetLanguage() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getLanguage());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getLanguage()}
   */
  @Test
  void testGetLanguage2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualLanguage = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction))).getLanguage();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualLanguage);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getLanguage()}
   */
  @Test
  void testGetLanguage3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    pdDocumentCatalog.setLanguage("en");

    // Act
    String actualLanguage = pdDocumentCatalog.getLanguage();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("en", actualLanguage);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getLanguage()}
   */
  @Test
  void testGetLanguage4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    pdDocumentCatalog.setLanguage("");

    // Act
    String actualLanguage = pdDocumentCatalog.getLanguage();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualLanguage);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setLanguage(String)}
   */
  @Test
  void testSetLanguage() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);

    // Act
    pdDocumentCatalog.setLanguage("en");

    // Assert
    assertEquals("en", pdDocumentCatalog.getLanguage());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getVersion()}
   */
  @Test
  void testGetVersion() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getVersion());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getVersion()}
   */
  @Test
  void testGetVersion2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualVersion = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction))).getVersion();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualVersion);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getVersion()}
   */
  @Test
  void testGetVersion3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction));
    pdDocumentCatalog.setVersion("1.0.2");

    // Act
    String actualVersion = pdDocumentCatalog.getVersion();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("1.0.2", actualVersion);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#setVersion(String)}
   */
  @Test
  void testSetVersion() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);

    // Act
    pdDocumentCatalog.setVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", pdDocumentCatalog.getVersion());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPageLabels()}
   */
  @Test
  void testGetPageLabels() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getPageLabels());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getPageLabels()}
   */
  @Test
  void testGetPageLabels2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDPageLabels actualPageLabels = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction))).getPageLabels();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPageLabels);
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getOCProperties()}
   */
  @Test
  void testGetOCProperties() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getOCProperties());
  }

  /**
   * Method under test: {@link PDDocumentCatalog#getOCProperties()}
   */
  @Test
  void testGetOCProperties2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDOptionalContentProperties actualOCProperties = (new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction)))
        .getOCProperties();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualOCProperties);
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}
   */
  @Test
  void testSetOCProperties() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, rootDictionary);
    PDOptionalContentProperties ocProperties = new PDOptionalContentProperties();

    // Act
    pdDocumentCatalog.setOCProperties(ocProperties);

    // Assert
    Collection<PDOptionalContentGroup> optionalContentGroups = ocProperties.getOptionalContentGroups();
    assertTrue(optionalContentGroups instanceof List);
    PDOptionalContentProperties oCProperties = pdDocumentCatalog.getOCProperties();
    Collection<PDOptionalContentGroup> optionalContentGroups2 = oCProperties.getOptionalContentGroups();
    assertTrue(optionalContentGroups2 instanceof List);
    COSDictionary cOSObject = ocProperties.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertEquals(0, oCProperties.getGroupNames().length);
    assertEquals(PDOptionalContentProperties.BaseState.ON, oCProperties.getBaseState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(optionalContentGroups.isEmpty());
    assertTrue(optionalContentGroups2.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(rootDictionary, pdDocumentCatalog.getCOSObject());
    assertSame(cOSObject, oCProperties.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument, COSDictionary)}
   */
  @Test
  void testNewPDDocumentCatalog() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();

    // Act and Assert
    assertSame(rootDictionary, (new PDDocumentCatalog(doc, rootDictionary)).getCOSObject());
  }
}
