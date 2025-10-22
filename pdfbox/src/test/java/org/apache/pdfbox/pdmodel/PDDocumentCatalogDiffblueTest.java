package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDMarkInfo;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
import org.apache.pdfbox.pdmodel.fixup.PDDocumentFixup;
import org.apache.pdfbox.pdmodel.graphics.color.PDOutputIntent;
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
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageXYZDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThread;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentCatalogDiffblueTest {
  /**
   * Test {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument, COSDictionary)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument, COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDocumentCatalog(PDDocument, COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.<init>(PDDocument, COSDictionary)"})
  void testNewPDDocumentCatalog() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();

    // Act and Assert
    assertSame(rootDictionary, (new PDDocumentCatalog(doc, rootDictionary)).getCOSObject());
  }

  /**
   * Test {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Language is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDDocumentCatalog(PDDocument); when PDDocument(); then return Language is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.<init>(PDDocument)"})
  void testNewPDDocumentCatalog_whenPDDocument_thenReturnLanguageIsNull() throws IOException {
    // Arrange and Act
    PDDocumentCatalog actualPdDocumentCatalog = new PDDocumentCatalog(new PDDocument());

    // Assert
    assertNull(actualPdDocumentCatalog.getLanguage());
    assertNull(actualPdDocumentCatalog.getVersion());
    assertNull(actualPdDocumentCatalog.getDests());
    assertNull(actualPdDocumentCatalog.getNames());
    assertNull(actualPdDocumentCatalog.getOpenAction());
    assertNull(actualPdDocumentCatalog.getMetadata());
    assertNull(actualPdDocumentCatalog.getPageLabels());
    assertNull(actualPdDocumentCatalog.getMarkInfo());
    assertNull(actualPdDocumentCatalog.getStructureTreeRoot());
    assertNull(actualPdDocumentCatalog.getOCProperties());
    assertNull(actualPdDocumentCatalog.getURI());
    assertNull(actualPdDocumentCatalog.getDocumentOutline());
    assertNull(actualPdDocumentCatalog.getAcroForm());
    assertNull(actualPdDocumentCatalog.getViewerPreferences());
    assertEquals(PageLayout.SINGLE_PAGE, actualPdDocumentCatalog.getPageLayout());
    assertEquals(PageMode.USE_NONE, actualPdDocumentCatalog.getPageMode());
    assertTrue(actualPdDocumentCatalog.getOutputIntents().isEmpty());
    assertTrue(actualPdDocumentCatalog.getThreads().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)} with {@code PDDocumentFixup}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)}
   */
  @Test
  @DisplayName("Test getAcroForm(PDDocumentFixup) with 'PDDocumentFixup'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAcroForm PDDocumentCatalog.getAcroForm(PDDocumentFixup)"})
  void testGetAcroFormWithPDDocumentFixup_thenReturnNull() {
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
   * Test {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)} with {@code PDDocumentFixup}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)}
   */
  @Test
  @DisplayName("Test getAcroForm(PDDocumentFixup) with 'PDDocumentFixup'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAcroForm PDDocumentCatalog.getAcroForm(PDDocumentFixup)"})
  void testGetAcroFormWithPDDocumentFixup_thenThrowIllegalArgumentException() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    PDDocumentFixup acroFormFixup = mock(PDDocumentFixup.class);
    doThrow(new IllegalArgumentException("foo")).when(acroFormFixup).apply();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentCatalog.getAcroForm(acroFormFixup));
    verify(acroFormFixup).apply();
  }

  /**
   * Test {@link PDDocumentCatalog#getAcroForm()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm()}
   */
  @Test
  @DisplayName("Test getAcroForm(); given COSDocument() Trailer is COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAcroForm PDDocumentCatalog.getAcroForm()"})
  void testGetAcroForm_givenCOSDocumentTrailerIsCOSDictionary_thenReturnNull() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());
    PDDocument doc2 = new PDDocument(doc);

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc2, new COSDictionary())).getAcroForm());
  }

  /**
   * Test {@link PDDocumentCatalog#getAcroForm()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm()}
   */
  @Test
  @DisplayName("Test getAcroForm(); given PDDocument() addPage PDPage(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAcroForm PDDocumentCatalog.getAcroForm()"})
  void testGetAcroForm_givenPDDocumentAddPagePDPage_thenReturnNull() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());
    doc.addSignature(new PDSignature());

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc)).getAcroForm());
  }

  /**
   * Test {@link PDDocumentCatalog#getAcroForm()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm()}
   */
  @Test
  @DisplayName("Test getAcroForm(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAcroForm PDDocumentCatalog.getAcroForm()"})
  void testGetAcroForm_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getAcroForm());
  }

  /**
   * Test {@link PDDocumentCatalog#setAcroForm(PDAcroForm)}.
   * <ul>
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()} DefaultAppearance is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setAcroForm(PDAcroForm)}
   */
  @Test
  @DisplayName("Test setAcroForm(PDAcroForm); then PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setAcroForm(PDAcroForm)"})
  void testSetAcroForm_thenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIsEmptyString() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(), rootDictionary);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    pdDocumentCatalog.setAcroForm(acroForm);

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    assertEquals("", acroForm.getDefaultAppearance());
    COSDictionary cOSObject = acroForm.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isNeedToBeUpdated());
  }

  /**
   * Test {@link PDDocumentCatalog#getPages()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)} return {@link COSName#A}.</li>
   *   <li>Then return Count is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given COSDictionary getCOSName(COSName) return A; then return Count is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageTree PDDocumentCatalog.getPages()"})
  void testGetPages_givenCOSDictionaryGetCOSNameReturnA_thenReturnCountIsZero() {
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
   * Test {@link PDDocumentCatalog#getPages()}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); then return COSObject is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageTree PDDocumentCatalog.getPages()"})
  void testGetPages_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(rootDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    PDPageTree actualPages = (new PDDocumentCatalog(new PDDocument(), rootDictionary)).getPages();

    // Assert
    verify(rootDictionary).getCOSDictionary(isA(COSName.class));
    assertSame(cosDictionary, actualPages.getCOSObject());
  }

  /**
   * Test {@link PDDocumentCatalog#getPages()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageTree PDDocumentCatalog.getPages()"})
  void testGetPages_thenThrowIllegalArgumentException() {
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
   * Test {@link PDDocumentCatalog#getViewerPreferences()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getViewerPreferences()}
   */
  @Test
  @DisplayName("Test getViewerPreferences(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDViewerPreferences PDDocumentCatalog.getViewerPreferences()"})
  void testGetViewerPreferences_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getViewerPreferences());
  }

  /**
   * Test {@link PDDocumentCatalog#getViewerPreferences()}.
   * <ul>
   *   <li>Then return PrintScaling is {@code AppDefault}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getViewerPreferences()}
   */
  @Test
  @DisplayName("Test getViewerPreferences(); then return PrintScaling is 'AppDefault'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDViewerPreferences PDDocumentCatalog.getViewerPreferences()"})
  void testGetViewerPreferences_thenReturnPrintScalingIsAppDefault() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setViewerPreferences(new PDViewerPreferences());

    // Act
    PDViewerPreferences actualViewerPreferences = pdDocumentCatalog.getViewerPreferences();

    // Assert
    assertEquals("AppDefault", actualViewerPreferences.getPrintScaling());
    assertEquals("CropBox", actualViewerPreferences.getPrintArea());
    assertEquals("CropBox", actualViewerPreferences.getPrintClip());
    assertEquals("CropBox", actualViewerPreferences.getViewArea());
    assertEquals("CropBox", actualViewerPreferences.getViewClip());
    assertEquals("L2R", actualViewerPreferences.getReadingDirection());
    assertEquals("UseNone", actualViewerPreferences.getNonFullScreenPageMode());
    assertNull(actualViewerPreferences.getDuplex());
    COSDictionary cOSObject = actualViewerPreferences.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(cOSObject.isNeedToBeUpdated());
  }

  /**
   * Test {@link PDDocumentCatalog#setViewerPreferences(PDViewerPreferences)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setViewerPreferences(PDViewerPreferences)}
   */
  @Test
  @DisplayName("Test setViewerPreferences(PDViewerPreferences); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setViewerPreferences(PDViewerPreferences)"})
  void testSetViewerPreferences_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDDocumentCatalog(new PDDocument(), rootDictionary)).setViewerPreferences(mock(PDViewerPreferences.class));

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDDocumentCatalog#setViewerPreferences(PDViewerPreferences)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setViewerPreferences(PDViewerPreferences)}
   */
  @Test
  @DisplayName("Test setViewerPreferences(PDViewerPreferences); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setViewerPreferences(PDViewerPreferences)"})
  void testSetViewerPreferences_thenThrowIllegalArgumentException() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    PDViewerPreferences prefs = mock(PDViewerPreferences.class);
    when(prefs.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentCatalog.setViewerPreferences(prefs));
    verify(prefs).getCOSObject();
  }

  /**
   * Test {@link PDDocumentCatalog#getDocumentOutline()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getDocumentOutline()}
   */
  @Test
  @DisplayName("Test getDocumentOutline(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDocumentOutline PDDocumentCatalog.getDocumentOutline()"})
  void testGetDocumentOutline_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getDocumentOutline());
  }

  /**
   * Test {@link PDDocumentCatalog#getDocumentOutline()}.
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getDocumentOutline()}
   */
  @Test
  @DisplayName("Test getDocumentOutline(); then return COSObject UpdateState OriginDocumentState is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDocumentOutline PDDocumentCatalog.getDocumentOutline()"})
  void testGetDocumentOutline_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    PDDocument doc = new PDDocument();

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, new COSDictionary());
    pdDocumentCatalog.setDocumentOutline(new PDDocumentOutline());

    // Act and Assert
    COSDictionary cOSObject = pdDocumentCatalog.getDocumentOutline().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#setDocumentOutline(PDDocumentOutline)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#setDocumentOutline(PDDocumentOutline)}
   */
  @Test
  @DisplayName("Test setDocumentOutline(PDDocumentOutline)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setDocumentOutline(PDDocumentOutline)"})
  void testSetDocumentOutline() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());

    PDDocumentOutline outlines = new PDDocumentOutline();
    PDOutlineItem newChild = new PDOutlineItem();
    outlines.addLast(newChild);

    // Act
    pdDocumentCatalog.setDocumentOutline(outlines);

    // Assert
    PDDocumentOutline documentOutline = pdDocumentCatalog.getDocumentOutline();
    assertEquals(1, documentOutline.getOpenCount());
    assertTrue(documentOutline.hasChildren());
    assertEquals(newChild, documentOutline.getFirstChild());
    assertEquals(newChild, documentOutline.getLastChild());
  }

  /**
   * Test {@link PDDocumentCatalog#getThreads()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getThreads()}
   */
  @Test
  @DisplayName("Test getThreads()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDocumentCatalog.getThreads()"})
  void testGetThreads() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertTrue((new PDDocumentCatalog(doc, new COSDictionary())).getThreads().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#getThreads()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()} Threads is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getThreads()}
   */
  @Test
  @DisplayName("Test getThreads(); given PDDocumentCatalog(PDDocument) with doc is PDDocument() Threads is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDocumentCatalog.getThreads()"})
  void testGetThreads_givenPDDocumentCatalogWithDocIsPDDocumentThreadsIsArrayList() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setThreads(new ArrayList<>());

    // Act and Assert
    assertTrue(pdDocumentCatalog.getThreads().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#getThreads()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getThreads()}
   */
  @Test
  @DisplayName("Test getThreads(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDocumentCatalog.getThreads()"})
  void testGetThreads_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDDocumentCatalog(new PDDocument())).getThreads().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#setThreads(List)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#setThreads(List)}
   */
  @Test
  @DisplayName("Test setThreads(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setThreads(List)"})
  void testSetThreads() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, new COSDictionary());

    // Act
    pdDocumentCatalog.setThreads(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(pdDocumentCatalog.getThreads().isEmpty());
    assertTrue(pdDocumentCatalog.getCOSObject().toIncrement().getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#setThreads(List)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#setThreads(List)}
   */
  @Test
  @DisplayName("Test setThreads(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setThreads(List)"})
  void testSetThreads2() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());

    PDThread pdThread = new PDThread();
    pdThread.setThreadInfo(new PDDocumentInformation());

    ArrayList<PDThread> threads = new ArrayList<>();
    threads.add(pdThread);

    // Act
    pdDocumentCatalog.setThreads(threads);

    // Assert
    List<PDThread> threads2 = pdDocumentCatalog.getThreads();
    assertEquals(1, threads2.size());
    PDDocumentInformation threadInfo = threads2.get(0).getThreadInfo();
    assertNull(threadInfo.getAuthor());
    assertNull(threadInfo.getCreator());
    assertNull(threadInfo.getKeywords());
    assertNull(threadInfo.getProducer());
    assertNull(threadInfo.getSubject());
    assertNull(threadInfo.getTitle());
    assertNull(threadInfo.getTrapped());
    assertNull(threadInfo.getCreationDate());
    assertNull(threadInfo.getModificationDate());
    assertEquals(1, threads.size());
    assertTrue(threadInfo.getMetadataKeys().isEmpty());
    COSDictionary cOSObject = threads.get(0).getThreadInfo().getCOSObject();
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertSame(cOSObject, threadInfo.getCOSObject());
  }

  /**
   * Test {@link PDDocumentCatalog#getMetadata()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDMetadata PDDocumentCatalog.getMetadata()"})
  void testGetMetadata_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getMetadata());
  }

  /**
   * Test {@link PDDocumentCatalog#getMetadata()}.
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDMetadata PDDocumentCatalog.getMetadata()"})
  void testGetMetadata_thenReturnCOSObjectKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSStream str = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);

    str.setKey(key);
    PDMetadata meta = new PDMetadata(str);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setMetadata(meta);

    // Act and Assert
    assertSame(key, pdDocumentCatalog.getMetadata().getCOSObject().getKey());
  }

  /**
   * Test {@link PDDocumentCatalog#getMetadata()}.
   * <ul>
   *   <li>Then return DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); then return DecodeParms is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDMetadata PDDocumentCatalog.getMetadata()"})
  void testGetMetadata_thenReturnDecodeParmsIsNull() throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    COSStream str = new COSStream();
    pdDocumentCatalog.setMetadata(new PDMetadata(str));

    // Act
    PDMetadata actualMetadata = pdDocumentCatalog.getMetadata();

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
   * Test {@link PDDocumentCatalog#setMetadata(PDMetadata)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setMetadata(PDMetadata)"})
  void testSetMetadata() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    PDMetadata meta = mock(PDMetadata.class);
    when(meta.getCOSObject()).thenReturn(new COSStream());

    // Act
    pdDocumentCatalog.setMetadata(meta);

    // Assert
    verify(meta).getCOSObject();
    PDMetadata metadata = pdDocumentCatalog.getMetadata();
    COSStream cOSObject = metadata.getCOSObject();
    assertNull(cOSObject.getFilters());
    assertNull(cOSObject.getKey());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    List<String> fileFilters = metadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertSame(fileFilters, metadata.getFilters());
  }

  /**
   * Test {@link PDDocumentCatalog#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setMetadata(PDMetadata)"})
  void testSetMetadata_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDDocumentCatalog(new PDDocument(), rootDictionary)).setMetadata(mock(PDMetadata.class));

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDDocumentCatalog#getActions()}.
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getActions()}
   */
  @Test
  @DisplayName("Test getActions(); then return COSObject UpdateState OriginDocumentState is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDocumentCatalogAdditionalActions PDDocumentCatalog.getActions()"})
  void testGetActions_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    COSDictionary cOSObject = (new PDDocumentCatalog(doc, new COSDictionary())).getActions().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#setActions(PDDocumentCatalogAdditionalActions)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#setActions(PDDocumentCatalogAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDDocumentCatalogAdditionalActions)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setActions(PDDocumentCatalogAdditionalActions)"})
  void testSetActions() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, new COSDictionary());
    PDDocumentCatalogAdditionalActions actions = new PDDocumentCatalogAdditionalActions();

    // Act
    pdDocumentCatalog.setActions(actions);

    // Assert that nothing has changed
    COSIncrement toIncrementResult = actions.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#getNames()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getNames()}
   */
  @Test
  @DisplayName("Test getNames(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDocumentNameDictionary PDDocumentCatalog.getNames()"})
  void testGetNames_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getNames());
  }

  /**
   * Test {@link PDDocumentCatalog#getDests()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getDests()}
   */
  @Test
  @DisplayName("Test getDests(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDocumentNameDestinationDictionary PDDocumentCatalog.getDests()"})
  void testGetDests_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getDests());
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_givenHashMapFooIsNull() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", null);

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names2);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link PDPageFitDestination#PDPageFitDestination()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is PDPageFitDestination()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_givenHashMapFooIsPDPageFitDestination() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names2);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link PDPageFitHeightDestination#PDPageFitHeightDestination()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is PDPageFitHeightDestination()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_givenHashMapFooIsPDPageFitHeightDestination() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitHeightDestination());

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names2);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is PDPageFitRectangleDestination()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_givenHashMapFooIsPDPageFitRectangleDestination() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitRectangleDestination());

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names2);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is PDPageFitWidthDestination()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_givenHashMapFooIsPDPageFitWidthDestination() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitWidthDestination());

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names2);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link PDPageXYZDestination#PDPageXYZDestination()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is PDPageXYZDestination()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_givenHashMapFooIsPDPageXYZDestination() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageXYZDestination());

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names2);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given PDDestinationNameTreeNode() Names is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_givenPDDestinationNameTreeNodeNamesIsHashMap() throws IOException {
    // Arrange
    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(new HashMap<>());

    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} FitBoundingBox is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given PDPageFitDestination() FitBoundingBox is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_givenPDPageFitDestinationFitBoundingBoxIsTrue() throws IOException {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    pdPageFitDestination.setFitBoundingBox(true);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names2.setDests(dests);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names2);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>When {@link PDNamedDestination#PDNamedDestination(COSName)} with dest is {@link COSName#A}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); when PDNamedDestination(COSName) with dest is A; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_whenPDNamedDestinationWithDestIsA_thenReturnNull() throws IOException {
    // Arrange
    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names.setDests(new PDDestinationNameTreeNode());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination(COSName.A)));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>When {@link PDNamedDestination#PDNamedDestination(String)} with dest is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); when PDNamedDestination(String) with dest is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_whenPDNamedDestinationWithDestIsEmptyString() throws IOException {
    // Arrange
    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names.setDests(new PDDestinationNameTreeNode());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>When {@link PDNamedDestination#PDNamedDestination(String)} with {@code Dest}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); when PDNamedDestination(String) with 'Dest'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_whenPDNamedDestinationWithDest_thenReturnNull() throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>When {@link PDNamedDestination#PDNamedDestination(String)} with {@code Dest}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); when PDNamedDestination(String) with 'Dest'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_whenPDNamedDestinationWithDest_thenReturnNull2() throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument())));

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>When {@link PDNamedDestination#PDNamedDestination(String)} with {@code Dest}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); when PDNamedDestination(String) with 'Dest'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_whenPDNamedDestinationWithDest_thenReturnNull3() throws IOException {
    // Arrange
    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names.setDests(new PDDestinationNameTreeNode());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>When {@link PDNamedDestination#PDNamedDestination()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); when PDNamedDestination(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageDestination PDDocumentCatalog.findNamedDestinationPage(PDNamedDestination)"})
  void testFindNamedDestinationPage_whenPDNamedDestination_thenReturnNull() throws IOException {
    // Arrange
    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names.setDests(new PDDestinationNameTreeNode());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination()));
  }

  /**
   * Test {@link PDDocumentCatalog#setNames(PDDocumentNameDictionary)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#setNames(PDDocumentNameDictionary)}
   */
  @Test
  @DisplayName("Test setNames(PDDocumentNameDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setNames(PDDocumentNameDictionary)"})
  void testSetNames() throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);
    PDDocument doc = new PDDocument();

    PDDocumentNameDictionary names2 = new PDDocumentNameDictionary(new PDDocumentCatalog(doc, new COSDictionary()));
    names2.setDests(dests);

    // Act
    pdDocumentCatalog.setNames(names2);

    // Assert
    Map<String, PDPageDestination> names3 = pdDocumentCatalog.getNames().getDests().getNames();
    assertEquals(1, names3.size());
    PDPageDestination getResult = names3.get("foo");
    assertTrue(getResult instanceof PDPageFitDestination);
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
  }

  /**
   * Test {@link PDDocumentCatalog#getMarkInfo()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getMarkInfo()}
   */
  @Test
  @DisplayName("Test getMarkInfo(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDMarkInfo PDDocumentCatalog.getMarkInfo()"})
  void testGetMarkInfo_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getMarkInfo());
  }

  /**
   * Test {@link PDDocumentCatalog#setMarkInfo(PDMarkInfo)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setMarkInfo(PDMarkInfo)}
   */
  @Test
  @DisplayName("Test setMarkInfo(PDMarkInfo); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setMarkInfo(PDMarkInfo)"})
  void testSetMarkInfo_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDDocumentCatalog(new PDDocument(), rootDictionary)).setMarkInfo(mock(PDMarkInfo.class));

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDDocumentCatalog#setMarkInfo(PDMarkInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setMarkInfo(PDMarkInfo)}
   */
  @Test
  @DisplayName("Test setMarkInfo(PDMarkInfo); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setMarkInfo(PDMarkInfo)"})
  void testSetMarkInfo_thenThrowIllegalArgumentException() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    PDMarkInfo markInfo = mock(PDMarkInfo.class);
    when(markInfo.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentCatalog.setMarkInfo(markInfo));
    verify(markInfo).getCOSObject();
  }

  /**
   * Test {@link PDDocumentCatalog#getOutputIntents()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getOutputIntents()}
   */
  @Test
  @DisplayName("Test getOutputIntents()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDocumentCatalog.getOutputIntents()"})
  void testGetOutputIntents() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    dictionary.setKey(key);
    PDOutputIntent outputIntent = new PDOutputIntent(dictionary);

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.addOutputIntent(outputIntent);

    // Act
    List<PDOutputIntent> actualOutputIntents = pdDocumentCatalog.getOutputIntents();

    // Assert
    assertEquals(1, actualOutputIntents.size());
    assertSame(key, actualOutputIntents.get(0).getCOSObject().getKey());
  }

  /**
   * Test {@link PDDocumentCatalog#getOutputIntents()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getOutputIntents()}
   */
  @Test
  @DisplayName("Test getOutputIntents(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDocumentCatalog.getOutputIntents()"})
  void testGetOutputIntents_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDDocumentCatalog(new PDDocument())).getOutputIntents().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#getOutputIntents()}.
   * <ul>
   *   <li>Then return first Info is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getOutputIntents()}
   */
  @Test
  @DisplayName("Test getOutputIntents(); then return first Info is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDocumentCatalog.getOutputIntents()"})
  void testGetOutputIntents_thenReturnFirstInfoIsNull() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    COSDictionary dictionary = new COSDictionary();
    pdDocumentCatalog.addOutputIntent(new PDOutputIntent(dictionary));

    // Act
    List<PDOutputIntent> actualOutputIntents = pdDocumentCatalog.getOutputIntents();

    // Assert
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
   * Test {@link PDDocumentCatalog#setOutputIntents(List)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#setOutputIntents(List)}
   */
  @Test
  @DisplayName("Test setOutputIntents(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setOutputIntents(List)"})
  void testSetOutputIntents() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(), rootDictionary);

    // Act
    pdDocumentCatalog.setOutputIntents(new ArrayList<>());

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    assertTrue(pdDocumentCatalog.getOutputIntents().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#setOutputIntents(List)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#setOutputIntents(List)}
   */
  @Test
  @DisplayName("Test setOutputIntents(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setOutputIntents(List)"})
  void testSetOutputIntents2() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(), rootDictionary);

    ArrayList<PDOutputIntent> outputIntents = new ArrayList<>();
    outputIntents.add(new PDOutputIntent(null));

    // Act
    pdDocumentCatalog.setOutputIntents(outputIntents);

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    assertTrue(pdDocumentCatalog.getOutputIntents().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#setOutputIntents(List)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSBase#isDirect()} return {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setOutputIntents(List)}
   */
  @Test
  @DisplayName("Test setOutputIntents(List); given COSDictionary isDirect() return 'false'; then calls getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setOutputIntents(List)"})
  void testSetOutputIntents_givenCOSDictionaryIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.isDirect()).thenReturn(false);
    when(dictionary.getKey()).thenReturn(new COSObjectKey(1L, 1));
    when(dictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDOutputIntent pdOutputIntent = new PDOutputIntent(dictionary);

    ArrayList<PDOutputIntent> outputIntents = new ArrayList<>();
    outputIntents.add(pdOutputIntent);

    // Act
    pdDocumentCatalog.setOutputIntents(outputIntents);

    // Assert
    verify(dictionary, atLeast(1)).getKey();
    verify(dictionary).isDirect();
    verify(dictionary).getUpdateState();
    List<PDOutputIntent> outputIntents2 = pdDocumentCatalog.getOutputIntents();
    assertEquals(1, outputIntents2.size());
    PDOutputIntent getResult = outputIntents2.get(0);
    assertNull(getResult.getInfo());
    assertNull(getResult.getOutputCondition());
    assertNull(getResult.getOutputConditionIdentifier());
    assertNull(getResult.getRegistryName());
    assertNull(getResult.getDestOutputIntent());
  }

  /**
   * Test {@link PDDocumentCatalog#setOutputIntents(List)}.
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setOutputIntents(List)}
   */
  @Test
  @DisplayName("Test setOutputIntents(List); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setOutputIntents(List)"})
  void testSetOutputIntents_thenCallsSetOriginDocumentState() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.isDirect()).thenReturn(true);
    when(dictionary.getUpdateState()).thenReturn(cosUpdateState);
    PDOutputIntent pdOutputIntent = new PDOutputIntent(dictionary);

    ArrayList<PDOutputIntent> outputIntents = new ArrayList<>();
    outputIntents.add(pdOutputIntent);

    // Act
    pdDocumentCatalog.setOutputIntents(outputIntents);

    // Assert
    verify(dictionary).isDirect();
    verify(dictionary, atLeast(1)).getUpdateState();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    List<PDOutputIntent> outputIntents2 = pdDocumentCatalog.getOutputIntents();
    assertEquals(1, outputIntents2.size());
    PDOutputIntent getResult = outputIntents2.get(0);
    assertNull(getResult.getInfo());
    assertNull(getResult.getOutputCondition());
    assertNull(getResult.getOutputConditionIdentifier());
    assertNull(getResult.getRegistryName());
    assertNull(getResult.getDestOutputIntent());
  }

  /**
   * Test {@link PDDocumentCatalog#getPageMode()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()} PageMode is {@code USE_NONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageMode()}
   */
  @Test
  @DisplayName("Test getPageMode(); given PDDocumentCatalog(PDDocument) with doc is PDDocument() PageMode is 'USE_NONE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageMode PDDocumentCatalog.getPageMode()"})
  void testGetPageMode_givenPDDocumentCatalogWithDocIsPDDocumentPageModeIsUseNone() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setPageMode(PageMode.USE_NONE);

    // Act and Assert
    assertEquals(PageMode.USE_NONE, pdDocumentCatalog.getPageMode());
  }

  /**
   * Test {@link PDDocumentCatalog#getPageMode()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code USE_NONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageMode()}
   */
  @Test
  @DisplayName("Test getPageMode(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'USE_NONE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageMode PDDocumentCatalog.getPageMode()"})
  void testGetPageMode_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnUseNone() {
    // Arrange, Act and Assert
    assertEquals(PageMode.USE_NONE, (new PDDocumentCatalog(new PDDocument())).getPageMode());
  }

  /**
   * Test {@link PDDocumentCatalog#getPageMode()}.
   * <ul>
   *   <li>Then return {@code USE_OUTLINES}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageMode()}
   */
  @Test
  @DisplayName("Test getPageMode(); then return 'USE_OUTLINES'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageMode PDDocumentCatalog.getPageMode()"})
  void testGetPageMode_thenReturnUseOutlines() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setPageMode(PageMode.USE_OUTLINES);

    // Act and Assert
    assertEquals(PageMode.USE_OUTLINES, pdDocumentCatalog.getPageMode());
  }

  /**
   * Test {@link PDDocumentCatalog#setPageMode(PageMode)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#setPageMode(PageMode)}
   */
  @Test
  @DisplayName("Test setPageMode(PageMode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setPageMode(PageMode)"})
  void testSetPageMode() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(), rootDictionary);

    // Act
    pdDocumentCatalog.setPageMode(PageMode.USE_NONE);

    // Assert that nothing has changed
    verify(rootDictionary).setName(isA(COSName.class), eq("UseNone"));
    assertEquals(PageMode.USE_NONE, pdDocumentCatalog.getPageMode());
  }

  /**
   * Test {@link PDDocumentCatalog#getPageLayout()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageLayout()}
   */
  @Test
  @DisplayName("Test getPageLayout()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLayout PDDocumentCatalog.getPageLayout()"})
  void testGetPageLayout() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setPageLayout(PageLayout.SINGLE_PAGE);

    // Act and Assert
    assertEquals(PageLayout.SINGLE_PAGE, pdDocumentCatalog.getPageLayout());
  }

  /**
   * Test {@link PDDocumentCatalog#getPageLayout()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code SINGLE_PAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageLayout()}
   */
  @Test
  @DisplayName("Test getPageLayout(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'SINGLE_PAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLayout PDDocumentCatalog.getPageLayout()"})
  void testGetPageLayout_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnSinglePage() {
    // Arrange, Act and Assert
    assertEquals(PageLayout.SINGLE_PAGE, (new PDDocumentCatalog(new PDDocument())).getPageLayout());
  }

  /**
   * Test {@link PDDocumentCatalog#getPageLayout()}.
   * <ul>
   *   <li>Then return {@code ONE_COLUMN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageLayout()}
   */
  @Test
  @DisplayName("Test getPageLayout(); then return 'ONE_COLUMN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLayout PDDocumentCatalog.getPageLayout()"})
  void testGetPageLayout_thenReturnOneColumn() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setPageLayout(PageLayout.ONE_COLUMN);

    // Act and Assert
    assertEquals(PageLayout.ONE_COLUMN, pdDocumentCatalog.getPageLayout());
  }

  /**
   * Test {@link PDDocumentCatalog#setPageLayout(PageLayout)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setName(COSName, String)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setName(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setPageLayout(PageLayout)}
   */
  @Test
  @DisplayName("Test setPageLayout(PageLayout); given COSDictionary setName(COSName, String) does nothing; then calls setName(COSName, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setPageLayout(PageLayout)"})
  void testSetPageLayout_givenCOSDictionarySetNameDoesNothing_thenCallsSetName() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new PDDocumentCatalog(new PDDocument(), rootDictionary)).setPageLayout(PageLayout.SINGLE_PAGE);

    // Assert
    verify(rootDictionary).setName(isA(COSName.class), eq("SinglePage"));
  }

  /**
   * Test {@link PDDocumentCatalog#getURI()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getURI()}
   */
  @Test
  @DisplayName("Test getURI(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDURIDictionary PDDocumentCatalog.getURI()"})
  void testGetURI_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getURI());
  }

  /**
   * Test {@link PDDocumentCatalog#setURI(PDURIDictionary)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setURI(PDURIDictionary)}
   */
  @Test
  @DisplayName("Test setURI(PDURIDictionary); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setURI(PDURIDictionary)"})
  void testSetURI_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDDocumentCatalog(new PDDocument(), rootDictionary)).setURI(mock(PDURIDictionary.class));

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDDocumentCatalog#setURI(PDURIDictionary)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setURI(PDURIDictionary)}
   */
  @Test
  @DisplayName("Test setURI(PDURIDictionary); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setURI(PDURIDictionary)"})
  void testSetURI_thenThrowIllegalArgumentException() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    PDURIDictionary uri = mock(PDURIDictionary.class);
    when(uri.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentCatalog.setURI(uri));
    verify(uri).getCOSObject();
  }

  /**
   * Test {@link PDDocumentCatalog#getStructureTreeRoot()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getStructureTreeRoot()}
   */
  @Test
  @DisplayName("Test getStructureTreeRoot(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDStructureTreeRoot PDDocumentCatalog.getStructureTreeRoot()"})
  void testGetStructureTreeRoot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getStructureTreeRoot());
  }

  /**
   * Test {@link PDDocumentCatalog#getStructureTreeRoot()}.
   * <ul>
   *   <li>Then return Type is {@code StructTreeRoot}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getStructureTreeRoot()}
   */
  @Test
  @DisplayName("Test getStructureTreeRoot(); then return Type is 'StructTreeRoot'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDStructureTreeRoot PDDocumentCatalog.getStructureTreeRoot()"})
  void testGetStructureTreeRoot_thenReturnTypeIsStructTreeRoot() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setStructureTreeRoot(new PDStructureTreeRoot());

    // Act
    PDStructureTreeRoot actualStructureTreeRoot = pdDocumentCatalog.getStructureTreeRoot();

    // Assert
    assertEquals("StructTreeRoot", actualStructureTreeRoot.getType());
    assertNull(actualStructureTreeRoot.getK());
    COSDictionary cOSObject = actualStructureTreeRoot.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualStructureTreeRoot.getIDTree());
    assertNull(actualStructureTreeRoot.getParentTree());
    assertEquals(-1, actualStructureTreeRoot.getParentTreeNextKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertTrue(actualStructureTreeRoot.getKids().isEmpty());
    assertTrue(actualStructureTreeRoot.getClassMap().isEmpty());
    assertTrue(actualStructureTreeRoot.getRoleMap().isEmpty());
    assertTrue(cOSObject.isNeedToBeUpdated());
  }

  /**
   * Test {@link PDDocumentCatalog#setStructureTreeRoot(PDStructureTreeRoot)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setStructureTreeRoot(PDStructureTreeRoot)}
   */
  @Test
  @DisplayName("Test setStructureTreeRoot(PDStructureTreeRoot); then PDStructureTreeRoot() K COSArray")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setStructureTreeRoot(PDStructureTreeRoot)"})
  void testSetStructureTreeRoot_thenPDStructureTreeRootKCOSArray() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());

    PDStructureTreeRoot treeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    treeRoot.appendKid(new PDStructureElement(dic));
    treeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdDocumentCatalog.setStructureTreeRoot(treeRoot);

    // Assert
    COSBase k = treeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = treeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    List<Object> kids2 = pdDocumentCatalog.getStructureTreeRoot().getKids();
    assertEquals(2, kids2.size());
    assertTrue(kids2.get(1) instanceof PDStructureElement);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertSame(dic, toListResult.get(0));
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDDocumentCatalog#getLanguage()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentCatalog.getLanguage()"})
  void testGetLanguage_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getLanguage());
  }

  /**
   * Test {@link PDDocumentCatalog#getLanguage()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentCatalog.getLanguage()"})
  void testGetLanguage_thenReturnEmptyString() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setLanguage("");

    // Act and Assert
    assertEquals("", pdDocumentCatalog.getLanguage());
  }

  /**
   * Test {@link PDDocumentCatalog#getLanguage()}.
   * <ul>
   *   <li>Then return {@code en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage(); then return 'en'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentCatalog.getLanguage()"})
  void testGetLanguage_thenReturnEn() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setLanguage("en");

    // Act and Assert
    assertEquals("en", pdDocumentCatalog.getLanguage());
  }

  /**
   * Test {@link PDDocumentCatalog#setLanguage(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setString(COSName, String)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setString(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setLanguage(String)}
   */
  @Test
  @DisplayName("Test setLanguage(String); given COSDictionary setString(COSName, String) does nothing; then calls setString(COSName, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setLanguage(String)"})
  void testSetLanguage_givenCOSDictionarySetStringDoesNothing_thenCallsSetString() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setString(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new PDDocumentCatalog(new PDDocument(), rootDictionary)).setLanguage("en");

    // Assert that nothing has changed
    verify(rootDictionary).setString(isA(COSName.class), eq("en"));
  }

  /**
   * Test {@link PDDocumentCatalog#getVersion()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentCatalog.getVersion()"})
  void testGetVersion_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getVersion());
  }

  /**
   * Test {@link PDDocumentCatalog#getVersion()}.
   * <ul>
   *   <li>Then return {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); then return '1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentCatalog.getVersion()"})
  void testGetVersion_thenReturn102() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setVersion("1.0.2");

    // Act and Assert
    assertEquals("1.0.2", pdDocumentCatalog.getVersion());
  }

  /**
   * Test {@link PDDocumentCatalog#setVersion(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setName(COSName, String)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setName(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setVersion(String)}
   */
  @Test
  @DisplayName("Test setVersion(String); given COSDictionary setName(COSName, String) does nothing; then calls setName(COSName, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setVersion(String)"})
  void testSetVersion_givenCOSDictionarySetNameDoesNothing_thenCallsSetName() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new PDDocumentCatalog(new PDDocument(), rootDictionary)).setVersion("1.0.2");

    // Assert that nothing has changed
    verify(rootDictionary).setName(isA(COSName.class), eq("1.0.2"));
  }

  /**
   * Test {@link PDDocumentCatalog#getPageLabels()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageLabels()}
   */
  @Test
  @DisplayName("Test getPageLabels(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.common.PDPageLabels PDDocumentCatalog.getPageLabels()"})
  void testGetPageLabels_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getPageLabels());
  }

  /**
   * Test {@link PDDocumentCatalog#getOCProperties()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getOCProperties()}
   */
  @Test
  @DisplayName("Test getOCProperties(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDOptionalContentProperties PDDocumentCatalog.getOCProperties()"})
  void testGetOCProperties_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getOCProperties());
  }

  /**
   * Test {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}
   */
  @Test
  @DisplayName("Test setOCProperties(PDOptionalContentProperties)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setOCProperties(PDOptionalContentProperties)"})
  void testSetOCProperties() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDDocumentCatalog(new PDDocument(), rootDictionary)).setOCProperties(mock(PDOptionalContentProperties.class));

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}.
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getVersion()} return {@code 1.4}.</li>
   *   <li>Then calls {@link PDDocument#setVersion(float)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}
   */
  @Test
  @DisplayName("Test setOCProperties(PDOptionalContentProperties); given PDDocument getVersion() return '1.4'; then calls setVersion(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setOCProperties(PDOptionalContentProperties)"})
  void testSetOCProperties_givenPDDocumentGetVersionReturn14_thenCallsSetVersion() {
    // Arrange
    PDDocument doc = mock(PDDocument.class);
    when(doc.getVersion()).thenReturn(1.4f);
    doNothing().when(doc).setVersion(anyFloat());
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDDocumentCatalog(doc, rootDictionary)).setOCProperties(mock(PDOptionalContentProperties.class));

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    verify(doc).getVersion();
    verify(doc).setVersion(eq(1.5f));
  }

  /**
   * Test {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}.
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getVersion()} return ten.</li>
   *   <li>Then calls {@link PDDocument#getVersion()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}
   */
  @Test
  @DisplayName("Test setOCProperties(PDOptionalContentProperties); given PDDocument getVersion() return ten; then calls getVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setOCProperties(PDOptionalContentProperties)"})
  void testSetOCProperties_givenPDDocumentGetVersionReturnTen_thenCallsGetVersion() {
    // Arrange
    PDDocument doc = mock(PDDocument.class);
    when(doc.getVersion()).thenReturn(10.0f);
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDDocumentCatalog(doc, rootDictionary)).setOCProperties(mock(PDOptionalContentProperties.class));

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    verify(doc).getVersion();
  }

  /**
   * Test {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}
   */
  @Test
  @DisplayName("Test setOCProperties(PDOptionalContentProperties); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentCatalog.setOCProperties(PDOptionalContentProperties)"})
  void testSetOCProperties_thenThrowIllegalArgumentException() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    PDOptionalContentProperties ocProperties = mock(PDOptionalContentProperties.class);
    when(ocProperties.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentCatalog.setOCProperties(ocProperties));
    verify(ocProperties).getCOSObject();
  }
}
