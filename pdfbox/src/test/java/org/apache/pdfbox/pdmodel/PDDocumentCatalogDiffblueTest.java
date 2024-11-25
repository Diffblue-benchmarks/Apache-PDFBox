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
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentCatalogDiffblueTest {
  /**
   * Test {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument, COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument, COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDocumentCatalog(PDDocument, COSDictionary)")
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
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSBase)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDDocumentCatalog(PDDocument); given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  void testNewPDDocumentCatalog_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.getTrailer()).thenReturn(cosDictionary);
    PDDocument doc = mock(PDDocument.class);
    when(doc.getDocument()).thenReturn(cosDocument);

    // Act
    PDDocumentCatalog actualPdDocumentCatalog = new PDDocumentCatalog(doc);

    // Assert
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument).getTrailer();
    verify(doc).getDocument();
    COSDictionary cOSObject = actualPdDocumentCatalog.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualPdDocumentCatalog.getActions().getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)}.
   * <ul>
   *   <li>Given {@link COSDocument} {@link COSDocument#getTrailer()} return
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDDocumentCatalog(PDDocument); given COSDocument getTrailer() return COSDictionary()")
  void testNewPDDocumentCatalog_givenCOSDocumentGetTrailerReturnCOSDictionary() {
    // Arrange
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.getTrailer()).thenReturn(new COSDictionary());
    PDDocument doc = mock(PDDocument.class);
    when(doc.getDocument()).thenReturn(cosDocument);

    // Act
    PDDocumentCatalog actualPdDocumentCatalog = new PDDocumentCatalog(doc);

    // Assert
    verify(cosDocument).getTrailer();
    verify(doc).getDocument();
    COSDictionary cOSObject = actualPdDocumentCatalog.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualPdDocumentCatalog.getActions().getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#getAcroForm()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm()}
   */
  @Test
  @DisplayName("Test getAcroForm()")
  void testGetAcroForm() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getAcroForm());
  }

  /**
   * Test {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)} with
   * {@code PDDocumentFixup}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)}
   */
  @Test
  @DisplayName("Test getAcroForm(PDDocumentFixup) with 'PDDocumentFixup'")
  void testGetAcroFormWithPDDocumentFixup() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, new COSDictionary());
    PDDocumentFixup acroFormFixup = mock(PDDocumentFixup.class);
    doNothing().when(acroFormFixup).apply();

    // Act
    PDAcroForm actualAcroForm = pdDocumentCatalog.getAcroForm(acroFormFixup);

    // Assert
    verify(acroFormFixup).apply();
    assertNull(actualAcroForm);
  }

  /**
   * Test {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)} with
   * {@code PDDocumentFixup}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)}
   */
  @Test
  @DisplayName("Test getAcroForm(PDDocumentFixup) with 'PDDocumentFixup'; then return 'null'")
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
   * Test {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)} with
   * {@code PDDocumentFixup}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)}
   */
  @Test
  @DisplayName("Test getAcroForm(PDDocumentFixup) with 'PDDocumentFixup'; then throw IllegalArgumentException")
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
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm()}
   */
  @Test
  @DisplayName("Test getAcroForm(); given COSDocument() Trailer is COSDictionary(); then return 'null'")
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
   *   <li>Given {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm()}
   */
  @Test
  @DisplayName("Test getAcroForm(); given PDDocument() addPage PDPage(); then return 'null'")
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
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getAcroForm()}
   */
  @Test
  @DisplayName("Test getAcroForm(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  void testGetAcroForm_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getAcroForm());
  }

  /**
   * Test {@link PDDocumentCatalog#setAcroForm(PDAcroForm)}.
   * <ul>
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()} DefaultAppearance is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setAcroForm(PDAcroForm)}
   */
  @Test
  @DisplayName("Test setAcroForm(PDAcroForm); then PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is empty string")
  void testSetAcroForm_thenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIsEmptyString() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(), rootDictionary);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    pdDocumentCatalog.setAcroForm(acroForm);

    // Assert
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    assertEquals("", acroForm.getDefaultAppearance());
    assertNull(pdDocumentCatalog.getActions().getCOSObject().getUpdateState().getOriginDocumentState());
    COSDictionary cOSObject = acroForm.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject.getUpdateState().isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#getPages()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)}
   * return {@link COSName#A}.</li>
   *   <li>Then return Count is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given COSDictionary getCOSName(COSName) return A; then return Count is zero")
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
   * <p>
   * Method under test: {@link PDDocumentCatalog#getViewerPreferences()}
   */
  @Test
  @DisplayName("Test getViewerPreferences()")
  void testGetViewerPreferences() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getViewerPreferences());
  }

  /**
   * Test {@link PDDocumentCatalog#getViewerPreferences()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getViewerPreferences()}
   */
  @Test
  @DisplayName("Test getViewerPreferences(); given PDDocumentCatalog(PDDocument) with doc is PDDocument()")
  void testGetViewerPreferences_givenPDDocumentCatalogWithDocIsPDDocument() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getViewerPreferences());
  }

  /**
   * Test {@link PDDocumentCatalog#setViewerPreferences(PDViewerPreferences)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#setViewerPreferences(PDViewerPreferences)}
   */
  @Test
  @DisplayName("Test setViewerPreferences(PDViewerPreferences); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
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
   * Method under test:
   * {@link PDDocumentCatalog#setViewerPreferences(PDViewerPreferences)}
   */
  @Test
  @DisplayName("Test setViewerPreferences(PDViewerPreferences); then throw IllegalArgumentException")
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
   * <p>
   * Method under test: {@link PDDocumentCatalog#getDocumentOutline()}
   */
  @Test
  @DisplayName("Test getDocumentOutline()")
  void testGetDocumentOutline() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getDocumentOutline());
  }

  /**
   * Test {@link PDDocumentCatalog#getDocumentOutline()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getDocumentOutline()}
   */
  @Test
  @DisplayName("Test getDocumentOutline(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  void testGetDocumentOutline_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getDocumentOutline());
  }

  /**
   * Test {@link PDDocumentCatalog#getDocumentOutline()}.
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getDocumentOutline()}
   */
  @Test
  @DisplayName("Test getDocumentOutline(); then return COSObject UpdateState OriginDocumentState is 'null'")
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
   * <ul>
   *   <li>Then not {@link PDDocumentOutline#PDDocumentOutline()} COSObject
   * NeedToBeUpdated.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#setDocumentOutline(PDDocumentOutline)}
   */
  @Test
  @DisplayName("Test setDocumentOutline(PDDocumentOutline); then not PDDocumentOutline() COSObject NeedToBeUpdated")
  void testSetDocumentOutline_thenNotPDDocumentOutlineCOSObjectNeedToBeUpdated() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(), rootDictionary);
    PDDocumentOutline outlines = new PDDocumentOutline();

    // Act
    pdDocumentCatalog.setDocumentOutline(outlines);

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    COSDictionary cOSObject = outlines.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject.getUpdateState().isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#getThreads()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getThreads()}
   */
  @Test
  @DisplayName("Test getThreads()")
  void testGetThreads() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertTrue((new PDDocumentCatalog(doc, new COSDictionary())).getThreads().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#getThreads()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()} Threads is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getThreads()}
   */
  @Test
  @DisplayName("Test getThreads(); given PDDocumentCatalog(PDDocument) with doc is PDDocument() Threads is ArrayList()")
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
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getThreads()}
   */
  @Test
  @DisplayName("Test getThreads(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return Empty")
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
  void testSetThreads() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, new COSDictionary());

    // Act
    pdDocumentCatalog.setThreads(new ArrayList<>());

    // Assert
    assertTrue(pdDocumentCatalog.getThreads().isEmpty());
    assertTrue(pdDocumentCatalog.getCOSObject().toIncrement().getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#getMetadata()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata()")
  void testGetMetadata() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getMetadata());
  }

  /**
   * Test {@link PDDocumentCatalog#getMetadata()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  void testGetMetadata_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getMetadata());
  }

  /**
   * Test {@link PDDocumentCatalog#getMetadata()}.
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)}
   * with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
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
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
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
   *   <li>Then return COSObject UpdateState OriginDocumentState is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getActions()}
   */
  @Test
  @DisplayName("Test getActions(); then return COSObject UpdateState OriginDocumentState is 'null'")
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
   * Test
   * {@link PDDocumentCatalog#setActions(PDDocumentCatalogAdditionalActions)}.
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#setActions(PDDocumentCatalogAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDDocumentCatalogAdditionalActions)")
  void testSetActions() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, new COSDictionary());
    PDDocumentCatalogAdditionalActions actions = new PDDocumentCatalogAdditionalActions();

    // Act
    pdDocumentCatalog.setActions(actions);

    // Assert
    COSIncrement toIncrementResult = actions.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test
   * {@link PDDocumentCatalog#setActions(PDDocumentCatalogAdditionalActions)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()} Actions WC is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#setActions(PDDocumentCatalogAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDDocumentCatalogAdditionalActions); when 'null'; then PDDocumentCatalog(PDDocument) with doc is PDDocument() Actions WC is 'null'")
  void testSetActions_whenNull_thenPDDocumentCatalogWithDocIsPDDocumentActionsWcIsNull() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());

    // Act
    pdDocumentCatalog.setActions(null);

    // Assert
    assertNull(pdDocumentCatalog.getActions().getWC());
    assertEquals(2, pdDocumentCatalog.getCOSObject().toIncrement().getObjects().size());
  }

  /**
   * Test {@link PDDocumentCatalog#getNames()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getNames()}
   */
  @Test
  @DisplayName("Test getNames()")
  void testGetNames() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getNames());
  }

  /**
   * Test {@link PDDocumentCatalog#getNames()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getNames()}
   */
  @Test
  @DisplayName("Test getNames(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  void testGetNames_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getNames());
  }

  /**
   * Test {@link PDDocumentCatalog#getDests()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getDests()}
   */
  @Test
  @DisplayName("Test getDests()")
  void testGetDests() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getDests());
  }

  /**
   * Test {@link PDDocumentCatalog#getDests()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getDests()}
   */
  @Test
  @DisplayName("Test getDests(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  void testGetDests_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getDests());
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination)")
  void testFindNamedDestinationPage() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(doc, new COSDictionary());

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination)")
  void testFindNamedDestinationPage2() throws IOException {
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
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is 'null'")
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
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link PDPageFitDestination#PDPageFitDestination()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is PDPageFitDestination()")
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
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link PDPageFitHeightDestination#PDPageFitHeightDestination()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is PDPageFitHeightDestination()")
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
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is PDPageFitRectangleDestination()")
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
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is PDPageFitWidthDestination()")
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
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link PDPageXYZDestination#PDPageXYZDestination()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given HashMap() 'foo' is PDPageXYZDestination()")
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
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); given PDDestinationNameTreeNode() Names is HashMap()")
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
   *   <li>When {@link PDNamedDestination#PDNamedDestination()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); when PDNamedDestination()")
  void testFindNamedDestinationPage_whenPDNamedDestination() throws IOException {
    // Arrange
    PDDocumentNameDictionary names = new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()));
    names.setDests(new PDDestinationNameTreeNode());

    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(names);

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination()));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>When {@link PDNamedDestination#PDNamedDestination(COSName)} with dest is
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); when PDNamedDestination(COSName) with dest is A")
  void testFindNamedDestinationPage_whenPDNamedDestinationWithDestIsA() throws IOException {
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
   *   <li>When {@link PDNamedDestination#PDNamedDestination(String)} with dest is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); when PDNamedDestination(String) with dest is empty string")
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
   *   <li>When {@link PDNamedDestination#PDNamedDestination(String)} with
   * {@code Dest}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); when PDNamedDestination(String) with 'Dest'; then return 'null'")
  void testFindNamedDestinationPage_whenPDNamedDestinationWithDest_thenReturnNull() throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}.
   * <ul>
   *   <li>When {@link PDNamedDestination#PDNamedDestination(String)} with
   * {@code Dest}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#findNamedDestinationPage(PDNamedDestination)}
   */
  @Test
  @DisplayName("Test findNamedDestinationPage(PDNamedDestination); when PDNamedDestination(String) with 'Dest'; then return 'null'")
  void testFindNamedDestinationPage_whenPDNamedDestinationWithDest_thenReturnNull2() throws IOException {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setNames(new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument())));

    // Act and Assert
    assertNull(pdDocumentCatalog.findNamedDestinationPage(new PDNamedDestination("Dest")));
  }

  /**
   * Test {@link PDDocumentCatalog#setNames(PDDocumentNameDictionary)}.
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#setNames(PDDocumentNameDictionary)}
   */
  @Test
  @DisplayName("Test setNames(PDDocumentNameDictionary)")
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
   * <p>
   * Method under test: {@link PDDocumentCatalog#getMarkInfo()}
   */
  @Test
  @DisplayName("Test getMarkInfo()")
  void testGetMarkInfo() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getMarkInfo());
  }

  /**
   * Test {@link PDDocumentCatalog#getMarkInfo()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getMarkInfo()}
   */
  @Test
  @DisplayName("Test getMarkInfo(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  void testGetMarkInfo_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getMarkInfo());
  }

  /**
   * Test {@link PDDocumentCatalog#setMarkInfo(PDMarkInfo)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setMarkInfo(PDMarkInfo)}
   */
  @Test
  @DisplayName("Test setMarkInfo(PDMarkInfo); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
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
  void testGetOutputIntents() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertTrue((new PDDocumentCatalog(doc, new COSDictionary())).getOutputIntents().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#getOutputIntents()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getOutputIntents()}
   */
  @Test
  @DisplayName("Test getOutputIntents()")
  void testGetOutputIntents2() {
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
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getOutputIntents()}
   */
  @Test
  @DisplayName("Test getOutputIntents(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return Empty")
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
  void testSetOutputIntents() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(), rootDictionary);

    // Act
    pdDocumentCatalog.setOutputIntents(new ArrayList<>());

    // Assert
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    assertNull(pdDocumentCatalog.getActions().getCOSObject().getUpdateState().getOriginDocumentState());
    assertTrue(pdDocumentCatalog.getOutputIntents().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#setOutputIntents(List)}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#setOutputIntents(List)}
   */
  @Test
  @DisplayName("Test setOutputIntents(List)")
  void testSetOutputIntents2() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(), rootDictionary);

    ArrayList<PDOutputIntent> outputIntents = new ArrayList<>();
    outputIntents.add(new PDOutputIntent(null));

    // Act
    pdDocumentCatalog.setOutputIntents(outputIntents);

    // Assert
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    assertNull(pdDocumentCatalog.getActions().getCOSObject().getUpdateState().getOriginDocumentState());
    assertTrue(pdDocumentCatalog.getOutputIntents().isEmpty());
  }

  /**
   * Test {@link PDDocumentCatalog#setOutputIntents(List)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setOutputIntents(List)}
   */
  @Test
  @DisplayName("Test setOutputIntents(List); given COSDictionary isDirect() return 'false'; then calls getKey()")
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
   *   <li>Then calls
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setOutputIntents(List)}
   */
  @Test
  @DisplayName("Test setOutputIntents(List); then calls setOriginDocumentState(COSDocumentState)")
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
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageMode()}
   */
  @Test
  @DisplayName("Test getPageMode()")
  void testGetPageMode() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertEquals(PageMode.USE_NONE, (new PDDocumentCatalog(doc, new COSDictionary())).getPageMode());
  }

  /**
   * Test {@link PDDocumentCatalog#getPageMode()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()} PageMode is {@code USE_NONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageMode()}
   */
  @Test
  @DisplayName("Test getPageMode(); given PDDocumentCatalog(PDDocument) with doc is PDDocument() PageMode is 'USE_NONE'")
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
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code USE_NONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageMode()}
   */
  @Test
  @DisplayName("Test getPageMode(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'USE_NONE'")
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
  void testGetPageMode_thenReturnUseOutlines() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setPageMode(PageMode.USE_OUTLINES);

    // Act and Assert
    assertEquals(PageMode.USE_OUTLINES, pdDocumentCatalog.getPageMode());
  }

  /**
   * Test {@link PDDocumentCatalog#setPageMode(PageMode)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setName(COSName, String)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setName(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setPageMode(PageMode)}
   */
  @Test
  @DisplayName("Test setPageMode(PageMode); given COSDictionary setName(COSName, String) does nothing; then calls setName(COSName, String)")
  void testSetPageMode_givenCOSDictionarySetNameDoesNothing_thenCallsSetName() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new PDDocumentCatalog(new PDDocument(), rootDictionary)).setPageMode(PageMode.USE_NONE);

    // Assert that nothing has changed
    verify(rootDictionary).setName(isA(COSName.class), eq("UseNone"));
  }

  /**
   * Test {@link PDDocumentCatalog#getPageLayout()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageLayout()}
   */
  @Test
  @DisplayName("Test getPageLayout()")
  void testGetPageLayout() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertEquals(PageLayout.SINGLE_PAGE, (new PDDocumentCatalog(doc, new COSDictionary())).getPageLayout());
  }

  /**
   * Test {@link PDDocumentCatalog#getPageLayout()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageLayout()}
   */
  @Test
  @DisplayName("Test getPageLayout()")
  void testGetPageLayout2() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument());
    pdDocumentCatalog.setPageLayout(PageLayout.SINGLE_PAGE);

    // Act and Assert
    assertEquals(PageLayout.SINGLE_PAGE, pdDocumentCatalog.getPageLayout());
  }

  /**
   * Test {@link PDDocumentCatalog#getPageLayout()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code SINGLE_PAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageLayout()}
   */
  @Test
  @DisplayName("Test getPageLayout(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'SINGLE_PAGE'")
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
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setName(COSName, String)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setName(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setPageLayout(PageLayout)}
   */
  @Test
  @DisplayName("Test setPageLayout(PageLayout); given COSDictionary setName(COSName, String) does nothing; then calls setName(COSName, String)")
  void testSetPageLayout_givenCOSDictionarySetNameDoesNothing_thenCallsSetName() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new PDDocumentCatalog(new PDDocument(), rootDictionary)).setPageLayout(PageLayout.SINGLE_PAGE);

    // Assert that nothing has changed
    verify(rootDictionary).setName(isA(COSName.class), eq("SinglePage"));
  }

  /**
   * Test {@link PDDocumentCatalog#getURI()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getURI()}
   */
  @Test
  @DisplayName("Test getURI()")
  void testGetURI() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getURI());
  }

  /**
   * Test {@link PDDocumentCatalog#getURI()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getURI()}
   */
  @Test
  @DisplayName("Test getURI(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  void testGetURI_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getURI());
  }

  /**
   * Test {@link PDDocumentCatalog#setURI(PDURIDictionary)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setURI(PDURIDictionary)}
   */
  @Test
  @DisplayName("Test setURI(PDURIDictionary); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
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
   * <p>
   * Method under test: {@link PDDocumentCatalog#getStructureTreeRoot()}
   */
  @Test
  @DisplayName("Test getStructureTreeRoot()")
  void testGetStructureTreeRoot() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getStructureTreeRoot());
  }

  /**
   * Test {@link PDDocumentCatalog#getStructureTreeRoot()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getStructureTreeRoot()}
   */
  @Test
  @DisplayName("Test getStructureTreeRoot(); given PDDocumentCatalog(PDDocument) with doc is PDDocument()")
  void testGetStructureTreeRoot_givenPDDocumentCatalogWithDocIsPDDocument() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getStructureTreeRoot());
  }

  /**
   * Test {@link PDDocumentCatalog#setStructureTreeRoot(PDStructureTreeRoot)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#setStructureTreeRoot(PDStructureTreeRoot)}
   */
  @Test
  @DisplayName("Test setStructureTreeRoot(PDStructureTreeRoot); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  void testSetStructureTreeRoot_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDDocumentCatalog(new PDDocument(), rootDictionary)).setStructureTreeRoot(mock(PDStructureTreeRoot.class));

    // Assert that nothing has changed
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDDocumentCatalog#getLanguage()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage()")
  void testGetLanguage() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getLanguage());
  }

  /**
   * Test {@link PDDocumentCatalog#getLanguage()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
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
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setString(COSName, String)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setString(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setLanguage(String)}
   */
  @Test
  @DisplayName("Test setLanguage(String); given COSDictionary setString(COSName, String) does nothing; then calls setString(COSName, String)")
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
   * <p>
   * Method under test: {@link PDDocumentCatalog#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion()")
  void testGetVersion() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getVersion());
  }

  /**
   * Test {@link PDDocumentCatalog#getVersion()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
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
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setName(COSName, String)} does nothing.</li>
   *   <li>When {@code 1.0.2}.</li>
   *   <li>Then calls {@link COSDictionary#setName(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#setVersion(String)}
   */
  @Test
  @DisplayName("Test setVersion(String); given COSDictionary setName(COSName, String) does nothing; when '1.0.2'; then calls setName(COSName, String)")
  void testSetVersion_givenCOSDictionarySetNameDoesNothing_when102_thenCallsSetName() {
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
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageLabels()}
   */
  @Test
  @DisplayName("Test getPageLabels()")
  void testGetPageLabels() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getPageLabels());
  }

  /**
   * Test {@link PDDocumentCatalog#getPageLabels()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getPageLabels()}
   */
  @Test
  @DisplayName("Test getPageLabels(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  void testGetPageLabels_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getPageLabels());
  }

  /**
   * Test {@link PDDocumentCatalog#getOCProperties()}.
   * <p>
   * Method under test: {@link PDDocumentCatalog#getOCProperties()}
   */
  @Test
  @DisplayName("Test getOCProperties()")
  void testGetOCProperties() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDDocumentCatalog(doc, new COSDictionary())).getOCProperties());
  }

  /**
   * Test {@link PDDocumentCatalog#getOCProperties()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog#PDDocumentCatalog(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentCatalog#getOCProperties()}
   */
  @Test
  @DisplayName("Test getOCProperties(); given PDDocumentCatalog(PDDocument) with doc is PDDocument(); then return 'null'")
  void testGetOCProperties_givenPDDocumentCatalogWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentCatalog(new PDDocument())).getOCProperties());
  }

  /**
   * Test {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}.
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}
   */
  @Test
  @DisplayName("Test setOCProperties(PDOptionalContentProperties)")
  void testSetOCProperties() {
    // Arrange
    COSDictionary rootDictionary = mock(COSDictionary.class);
    doNothing().when(rootDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDDocumentCatalog pdDocumentCatalog = new PDDocumentCatalog(new PDDocument(), rootDictionary);

    // Act
    pdDocumentCatalog.setOCProperties(mock(PDOptionalContentProperties.class));

    // Assert
    verify(rootDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    assertNull(pdDocumentCatalog.getVersion());
  }

  /**
   * Test {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}.
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getVersion()} return
   * {@code 1.4}.</li>
   *   <li>Then calls {@link PDDocument#setVersion(float)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}
   */
  @Test
  @DisplayName("Test setOCProperties(PDOptionalContentProperties); given PDDocument getVersion() return '1.4'; then calls setVersion(float)")
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
   * Method under test:
   * {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}
   */
  @Test
  @DisplayName("Test setOCProperties(PDOptionalContentProperties); given PDDocument getVersion() return ten; then calls getVersion()")
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
   * Method under test:
   * {@link PDDocumentCatalog#setOCProperties(PDOptionalContentProperties)}
   */
  @Test
  @DisplayName("Test setOCProperties(PDOptionalContentProperties); then throw IllegalArgumentException")
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
