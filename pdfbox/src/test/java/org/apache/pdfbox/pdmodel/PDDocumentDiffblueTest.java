package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.encryption.PDEncryption;
import org.apache.pdfbox.pdmodel.encryption.PublicKeyProtectionPolicy;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFreeText;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentDiffblueTest {
  /**
   * Test {@link PDDocument#PDDocument()}.
   *
   * <p>Method under test: {@link PDDocument#PDDocument()}
   */
  @Test
  @DisplayName("Test new PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.<init>()"})
  void testNewPDDocument() {
    // Arrange and Act
    PDDocument actualPdDocument = new PDDocument();

    // Assert
    assertTrue(actualPdDocument.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualPdDocument.getDocumentId());
    assertNull(actualPdDocument.getEncryption());
    assertNull(actualPdDocument.getLastSignatureDictionary());
    assertEquals(0, actualPdDocument.getNumberOfPages());
    assertEquals(1.4f, actualPdDocument.getVersion());
    assertFalse(actualPdDocument.isAllSecurityToBeRemoved());
    assertFalse(actualPdDocument.isEncrypted());
    assertTrue(actualPdDocument.getSignatureDictionaries().isEmpty());
    assertTrue(actualPdDocument.getSignatureFields().isEmpty());
    assertTrue(actualPdDocument.getFontsToSubset().isEmpty());
  }

  /**
   * Test {@link PDDocument#PDDocument(COSDocument)}.
   *
   * <ul>
   *   <li>When {@link COSDocument#COSDocument()}.
   *   <li>Then ResourceCache return {@link DefaultResourceCache}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#PDDocument(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDDocument(COSDocument); when COSDocument(); then ResourceCache return DefaultResourceCache")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.<init>(COSDocument)"})
  void testNewPDDocument_whenCOSDocument_thenResourceCacheReturnDefaultResourceCache() {
    // Arrange
    COSDocument doc = new COSDocument();

    // Act
    PDDocument actualPdDocument = new PDDocument(doc);

    // Assert
    assertTrue(actualPdDocument.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualPdDocument.getDocumentId());
    assertNull(actualPdDocument.getEncryption());
    assertFalse(actualPdDocument.isAllSecurityToBeRemoved());
    assertFalse(actualPdDocument.isEncrypted());
    assertTrue(actualPdDocument.getFontsToSubset().isEmpty());
    assertSame(doc, actualPdDocument.getDocument());
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage() throws IOException {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(cosDictionary.getKey()).thenReturn(new COSObjectKey(1L, 1));
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    doNothing().when(doc).setHighestXRefObjectNumber(anyLong());
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    // Act
    pdDocument.addPage(new PDPage());

    // Assert
    verify(cosDictionary).getKey();
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(cosDictionary).setInt(isA(COSName.class), eq(2));
    verify(doc).getDocumentState();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getTrailer();
    verify(doc).setHighestXRefObjectNumber(1L);
    PDDocumentCatalog documentCatalog = pdDocument.getDocumentCatalog();
    List<PDNameTreeNode<PDPageDestination>> kids = documentCatalog.getNames().getDests().getKids();
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult.getNames());
    assertNull(getResult.getParent());
    assertTrue(getResult.isRootNode());
    assertArrayEquals(new String[] {null}, documentCatalog.getOCProperties().getGroupNames());
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage2() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    COSArray updateInfo = mock(COSArray.class);
    when(updateInfo.iterator()).thenThrow(new IllegalStateException());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(updateInfo));

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(cosArray);

    COSArray updateInfo2 = mock(COSArray.class);
    when(updateInfo2.iterator()).thenReturn(cosBaseList.iterator());
    COSUpdateState cosUpdateState = new COSUpdateState(updateInfo2);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(page));
    verify(cosArray).getUpdateState();
    verify(updateInfo2).iterator();
    verify(updateInfo).iterator();
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#add(COSBase)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test addPage(PDPage); given COSArray add(COSBase) throw IllegalStateException(); then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSArrayAddThrowIllegalStateException_thenCallsAdd() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSArray cosArray = mock(COSArray.class);
    doThrow(new IllegalStateException()).when(cosArray).add(Mockito.<COSBase>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    doNothing().when(cosDictionary4).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary4);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(page));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary4).setItem(isA(COSName.class), isA(COSBase.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getUpdateState()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test addPage(PDPage); given COSArray getUpdateState() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSArrayGetUpdateStateThrowIllegalStateException() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getUpdateState()).thenThrow(new IllegalStateException());

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(cosArray);

    COSArray updateInfo = mock(COSArray.class);
    when(updateInfo.iterator()).thenReturn(cosBaseList.iterator());
    COSUpdateState cosUpdateState = new COSUpdateState(updateInfo);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(page));
    verify(cosArray).getUpdateState();
    verify(updateInfo).iterator();
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#iterator()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link COSDictionary#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test addPage(PDPage); given COSArray iterator() throw IllegalStateException(); then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSArrayIteratorThrowIllegalStateException_thenCallsGetKey() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    COSArray updateInfo = mock(COSArray.class);
    when(updateInfo.iterator()).thenThrow(new IllegalStateException());
    COSUpdateState cosUpdateState = new COSUpdateState(updateInfo);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(false);
    when(cosDictionary.getKey()).thenReturn(new COSObjectKey(1L, 1));
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(page));
    verify(updateInfo).iterator();
    verify(cosDictionary, atLeast(1)).getKey();
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#iterator()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link COSArray#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test addPage(PDPage); given COSArray iterator() throw IllegalStateException(); then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSArrayIteratorThrowIllegalStateException_thenCallsIterator() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    COSArray updateInfo = mock(COSArray.class);
    when(updateInfo.iterator()).thenThrow(new IllegalStateException());
    COSUpdateState cosUpdateState = new COSUpdateState(updateInfo);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(page));
    verify(updateInfo).iterator();
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test addPage(PDPage); given COSDictionary getCOSArray(COSName) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSDictionaryGetCOSArrayThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenThrow(new IllegalStateException());
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(new PDPage()));
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName, COSName)}
   *       throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test addPage(PDPage); given COSDictionary getCOSDictionary(COSName, COSName) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSDictionaryGetCOSDictionaryThrowIllegalStateException() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new IllegalStateException());
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(page));
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test addPage(PDPage); given COSDictionary getCOSName(COSName) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSDictionaryGetCOSNameThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenThrow(new IllegalStateException());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(new PDPage()));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link COSDictionary#getInt(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test addPage(PDPage); given COSDictionary getInt(COSName) throw IllegalStateException(); then calls getInt(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSDictionaryGetIntThrowIllegalStateException_thenCallsGetInt() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenThrow(new IllegalStateException());
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(new PDPage()));
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSDocument} {@link COSDocument#getTrailer()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); given COSDocument getTrailer() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSDocumentGetTrailerThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenThrow(new IllegalStateException());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(new PDPage()));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSUpdateState} {@link
   *       COSUpdateState#setOriginDocumentState(COSDocumentState)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test addPage(PDPage); given COSUpdateState setOriginDocumentState(COSDocumentState) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSUpdateStateSetOriginDocumentStateDoesNothing() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    doThrow(new IllegalStateException()).when(cosArray).add(Mockito.<COSBase>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(new PDPage()));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    verify(cosUpdateState).setOriginDocumentState(isNull());
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSUpdateState} {@link
   *       COSUpdateState#setOriginDocumentState(COSDocumentState)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test addPage(PDPage); given COSUpdateState setOriginDocumentState(COSDocumentState) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSUpdateStateSetOriginDocumentStateThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doThrow(new IllegalStateException())
        .when(cosUpdateState)
        .setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(new COSDictionary());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addPage(page));
    verify(cosDictionary).isDirect();
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject);

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    assertEquals(1, iteratorResult.next().getAnnotations().size());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject},
   * {@code options}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    assertEquals(1, iteratorResult.next().getAnnotations().size());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject},
   * {@code options}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenArrayListAddNull() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject},
   * {@code options}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCaret#PDAnnotationCaret()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenArrayListAddPDAnnotationCaret()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject},
   * {@code options}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCircle#PDAnnotationCircle()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add PDAnnotationCircle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenArrayListAddPDAnnotationCircle()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCircle());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject},
   * {@code options}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDAnnotationFileAttachment#PDAnnotationFileAttachment()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add PDAnnotationFileAttachment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenArrayListAddPDAnnotationFileAttachment()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFileAttachment());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject},
   * {@code options}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDAnnotationFreeText#PDAnnotationFreeText()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add PDAnnotationFreeText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenArrayListAddPDAnnotationFreeText()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFreeText());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject},
   * {@code options}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given three; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenThree_thenThrowIllegalStateException()
      throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDSignature sigObject = new PDSignature();

    SignatureOptions options = new SignatureOptions();
    options.setPreferredSignatureSize(3);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(sigObject, options));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject},
   * {@code options}.
   *
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} SignatureFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; then PDDocument() SignatureFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_thenPDDocumentSignatureFieldsSizeIsOne()
      throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject},
   * {@code options}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDSignature sigObject = new PDSignature();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> pdDocument.addSignature(sigObject, new SignatureOptions()));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject},
   * {@code signatureInterface}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface)"})
  void testAddSignatureWithSigObjectSignatureInterface() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, mock(SignatureInterface.class));

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject},
   * {@code signatureInterface}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface)"})
  void testAddSignatureWithSigObjectSignatureInterface2() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, mock(SignatureInterface.class));

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    assertEquals(1, iteratorResult.next().getAnnotations().size());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject},
   * {@code signatureInterface}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface)"})
  void testAddSignatureWithSigObjectSignatureInterface3() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, mock(SignatureInterface.class));

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject},
   * {@code signatureInterface}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface)"})
  void testAddSignatureWithSigObjectSignatureInterface4() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCircle());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, mock(SignatureInterface.class));

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject},
   * {@code signatureInterface}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface)"})
  void testAddSignatureWithSigObjectSignatureInterface5() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFileAttachment());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, mock(SignatureInterface.class));

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject},
   * {@code signatureInterface}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface)"})
  void testAddSignatureWithSigObjectSignatureInterface6() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFreeText());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, mock(SignatureInterface.class));

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject},
   * {@code signatureInterface}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface)"})
  void testAddSignatureWithSigObjectSignatureInterface7() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationHighlight());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, mock(SignatureInterface.class));

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with
   * {@code sigObject}, {@code signatureInterface}, {@code options}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface,
   * SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"
  })
  void testAddSignatureWithSigObjectSignatureInterfaceOptions() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions()));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with
   * {@code sigObject}, {@code signatureInterface}, {@code options}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface,
   * SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"
  })
  void testAddSignatureWithSigObjectSignatureInterfaceOptions2() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with
   * {@code sigObject}, {@code signatureInterface}, {@code options}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface,
   * SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"
  })
  void testAddSignatureWithSigObjectSignatureInterfaceOptions3() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    SignatureOptions options = new SignatureOptions();
    options.setPreferredSignatureSize(3);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> pdDocument.addSignature(sigObject, signatureInterface, options));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with
   * {@code sigObject}, {@code signatureInterface}, {@code options}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface,
   * SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"
  })
  void testAddSignatureWithSigObjectSignatureInterfaceOptions4() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    assertEquals(1, iteratorResult.next().getAnnotations().size());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with
   * {@code sigObject}, {@code signatureInterface}, {@code options}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface,
   * SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"
  })
  void testAddSignatureWithSigObjectSignatureInterfaceOptions5() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with
   * {@code sigObject}, {@code signatureInterface}, {@code options}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface,
   * SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"
  })
  void testAddSignatureWithSigObjectSignatureInterfaceOptions6() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCircle());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with
   * {@code sigObject}, {@code signatureInterface}, {@code options}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface,
   * SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"
  })
  void testAddSignatureWithSigObjectSignatureInterfaceOptions7() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFileAttachment());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with
   * {@code sigObject}, {@code signatureInterface}, {@code options}.
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface,
   * SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"
  })
  void testAddSignatureWithSigObjectSignatureInterfaceOptions8() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFreeText());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with
   * {@code sigObject}, {@code signatureInterface}, {@code options}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface,
   * SignatureOptions)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'; given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"
  })
  void testAddSignatureWithSigObjectSignatureInterfaceOptions_givenArrayListAddNull()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject},
   * {@code signatureInterface}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'; given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface)"})
  void testAddSignatureWithSigObjectSignatureInterface_givenArrayListAddNull() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, mock(SignatureInterface.class));

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject},
   * {@code signatureInterface}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface)"})
  void testAddSignatureWithSigObjectSignatureInterface_thenThrowIllegalStateException()
      throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> pdDocument.addSignature(new PDSignature(), mock(SignatureInterface.class)));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_givenArrayListAddNull() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject);

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCaret#PDAnnotationCaret()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_givenArrayListAddPDAnnotationCaret() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject);

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCircle#PDAnnotationCircle()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add PDAnnotationCircle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_givenArrayListAddPDAnnotationCircle() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCircle());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject);

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDAnnotationFileAttachment#PDAnnotationFileAttachment()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add PDAnnotationFileAttachment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_givenArrayListAddPDAnnotationFileAttachment()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFileAttachment());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject);

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDAnnotationFreeText#PDAnnotationFreeText()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add PDAnnotationFreeText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_givenArrayListAddPDAnnotationFreeText() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFreeText());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject);

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDAnnotationHighlight#PDAnnotationHighlight()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add PDAnnotationHighlight()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_givenArrayListAddPDAnnotationHighlight() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationHighlight());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject);

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature) with 'sigObject'; given PDDocument(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_givenPDDocument_thenThrowIllegalStateException()
      throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(new PDSignature()));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   *
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} SignatureFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName(
      "Test addSignature(PDSignature) with 'sigObject'; then PDDocument() SignatureFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_thenPDDocumentSignatureFieldsSizeIsOne() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject);

    // Assert
    List<PDSignature> signatureDictionaries = pdDocument.getSignatureDictionaries();
    assertEquals(1, signatureDictionaries.size());
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#removePage(int)} with {@code pageNumber}.
   *
   * <p>Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName("Test removePage(int) with 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(int)"})
  void testRemovePageWithPageNumber() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenThrow(new IllegalStateException());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).removePage(10));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#removePage(int)} with {@code pageNumber}.
   *
   * <p>Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName("Test removePage(int) with 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(int)"})
  void testRemovePageWithPageNumber2() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenThrow(new IllegalStateException());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).removePage(10));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#removePage(int)} with {@code pageNumber}.
   *
   * <p>Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName("Test removePage(int) with 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(int)"})
  void testRemovePageWithPageNumber3() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenThrow(new IllegalStateException());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(11);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).removePage(10));
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#removePage(int)} with {@code pageNumber}.
   *
   * <p>Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName("Test removePage(int) with 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(int)"})
  void testRemovePageWithPageNumber4() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenThrow(new IllegalStateException());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    cosArray.add(mock(COSObjectable.class));

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(11);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary3);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary4);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).removePage(10));
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(cosDictionary2).getCOSArray(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#removePage(int)} with {@code pageNumber}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName(
      "Test removePage(int) with 'pageNumber'; given COSArray getObject(int) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(int)"})
  void testRemovePageWithPageNumber_givenCOSArrayGetObjectThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenThrow(new IllegalStateException());
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    cosArray.add(mock(COSObjectable.class));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(11);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).removePage(10));
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray).getObject(0);
    verify(cosArray).size();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#removePage(int)} with {@code pageNumber}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName(
      "Test removePage(int) with 'pageNumber'; given COSDictionary getInt(COSName, int) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(int)"})
  void testRemovePageWithPageNumber_givenCOSDictionaryGetIntThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt()))
        .thenThrow(new IllegalStateException());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).removePage(10));
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#removePage(int)} with {@code pageNumber}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName(
      "Test removePage(int) with 'pageNumber'; given COSDictionary getInt(COSName, int) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(int)"})
  void testRemovePageWithPageNumber_givenCOSDictionaryGetIntThrowIllegalStateException2() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt()))
        .thenThrow(new IllegalStateException());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    cosArray.add(mock(COSObjectable.class));

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(11);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary3);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary4);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).removePage(10));
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary2).getCOSArray(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test removePage(PDPage) with 'page'; given COSArray() add FALSE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_givenCOSArrayAddFalse_thenCallsGetCOSArray() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    COSDictionary cosDictionary5 = mock(COSDictionary.class);
    when(cosDictionary5.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary4);

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary5);

    // Act
    pdDocument.removePage(page);

    // Assert
    verify(cosDictionary4).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary5).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test removePage(PDPage) with 'page'; given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    COSDictionary cosDictionary5 = mock(COSDictionary.class);
    when(cosDictionary5.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary4);

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary5);

    // Act
    pdDocument.removePage(page);

    // Assert
    verify(cosDictionary4).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary5).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)} return {@link
   *       COSName#AA}.
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test removePage(PDPage) with 'page'; given COSDictionary getCOSName(COSName) return AA; then calls setInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_givenCOSDictionaryGetCOSNameReturnAa_thenCallsSetInt() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.AA);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary4.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    doNothing().when(cosDictionary4).setInt(Mockito.<COSName>any(), anyInt());
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    COSDictionary cosDictionary5 = mock(COSDictionary.class);
    when(cosDictionary5.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary4);

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary5);

    // Act
    pdDocument.removePage(page);

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosDictionary4).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary5, atLeast(1)).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary4).getInt(isA(COSName.class));
    verify(cosDictionary4).setInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test removePage(PDPage) with 'page'; given COSDictionary getCOSName(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_givenCOSDictionaryGetCOSNameReturnNull() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(null);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    COSDictionary cosDictionary5 = mock(COSDictionary.class);
    when(cosDictionary5.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary4);

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary5);

    // Act
    pdDocument.removePage(page);

    // Assert
    verify(cosDictionary4).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary5).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test removePage(PDPage) with 'page'; given COSDictionary getCOSName(COSName) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_givenCOSDictionaryGetCOSNameThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenThrow(new IllegalStateException());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.removePage(new PDPage()));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName)} return one.
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test removePage(PDPage) with 'page'; given COSDictionary getInt(COSName) return one; then calls setInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_givenCOSDictionaryGetIntReturnOne_thenCallsSetInt() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary4.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    doNothing().when(cosDictionary4).setInt(Mockito.<COSName>any(), anyInt());
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    COSDictionary cosDictionary5 = mock(COSDictionary.class);
    when(cosDictionary5.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary4);

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary5);

    // Act
    pdDocument.removePage(page);

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosDictionary4).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary5, atLeast(1)).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary4).getInt(isA(COSName.class));
    verify(cosDictionary4).setInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test removePage(PDPage) with 'page'; given COSDictionary getInt(COSName) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_givenCOSDictionaryGetIntThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getInt(Mockito.<COSName>any())).thenThrow(new IllegalStateException());
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    COSDictionary cosDictionary5 = mock(COSDictionary.class);
    when(cosDictionary5.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary4);

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary5);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.removePage(page));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosDictionary4).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary5, atLeast(1)).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary4).getInt(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link COSDocument} {@link COSDocument#getTrailer()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test removePage(PDPage) with 'page'; given COSDocument getTrailer() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_givenCOSDocumentGetTrailerThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenThrow(new IllegalStateException());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    PDDocument pdDocument = new PDDocument(doc);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.removePage(new PDPage()));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test removePage(PDPage) with 'page'; given PDDocument(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_givenPDDocument_thenCallsGetCOSArray() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary);

    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary2);

    // Act
    pdDocument.removePage(page);

    // Assert
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#getDocumentInformation()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then return Author is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getDocumentInformation()}
   */
  @Test
  @DisplayName("Test getDocumentInformation(); given PDDocument(); then return Author is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocumentInformation PDDocument.getDocumentInformation()"})
  void testGetDocumentInformation_givenPDDocument_thenReturnAuthorIsNull() {
    // Arrange and Act
    PDDocumentInformation actualDocumentInformation = new PDDocument().getDocumentInformation();

    // Assert
    assertNull(actualDocumentInformation.getAuthor());
    assertNull(actualDocumentInformation.getCreator());
    assertNull(actualDocumentInformation.getKeywords());
    assertNull(actualDocumentInformation.getProducer());
    assertNull(actualDocumentInformation.getSubject());
    assertNull(actualDocumentInformation.getTitle());
    assertNull(actualDocumentInformation.getTrapped());
    assertNull(actualDocumentInformation.getCreationDate());
    assertNull(actualDocumentInformation.getModificationDate());
    assertTrue(actualDocumentInformation.getMetadataKeys().isEmpty());
  }

  /**
   * Test {@link PDDocument#getDocumentInformation()}.
   *
   * <ul>
   *   <li>Then return {@link PDDocumentInformation#PDDocumentInformation()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getDocumentInformation()}
   */
  @Test
  @DisplayName("Test getDocumentInformation(); then return PDDocumentInformation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocumentInformation PDDocument.getDocumentInformation()"})
  void testGetDocumentInformation_thenReturnPDDocumentInformation() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDDocumentInformation info = new PDDocumentInformation();
    pdDocument.setDocumentInformation(info);

    // Act and Assert
    assertSame(info, pdDocument.getDocumentInformation());
  }

  /**
   * Test {@link PDDocument#setDocumentInformation(PDDocumentInformation)}.
   *
   * <p>Method under test: {@link PDDocument#setDocumentInformation(PDDocumentInformation)}
   */
  @Test
  @DisplayName("Test setDocumentInformation(PDDocumentInformation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.setDocumentInformation(PDDocumentInformation)"})
  void testSetDocumentInformation() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDDocumentInformation info = new PDDocumentInformation();

    // Act
    pdDocument.setDocumentInformation(info);

    // Assert
    COSDictionary cOSObject = info.getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(info, pdDocument.getDocumentInformation());
    assertSame(cOSObject, actualNextResult);
  }

  /**
   * Test {@link PDDocument#setDocumentInformation(PDDocumentInformation)}.
   *
   * <ul>
   *   <li>Given {@code Dr}.
   *   <li>When {@link PDDocumentInformation#PDDocumentInformation()} Title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#setDocumentInformation(PDDocumentInformation)}
   */
  @Test
  @DisplayName(
      "Test setDocumentInformation(PDDocumentInformation); given 'Dr'; when PDDocumentInformation() Title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.setDocumentInformation(PDDocumentInformation)"})
  void testSetDocumentInformation_givenDr_whenPDDocumentInformationTitleIsDr() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    PDDocumentInformation info = new PDDocumentInformation();
    info.setTitle("Dr");

    // Act
    pdDocument.setDocumentInformation(info);

    // Assert
    COSDictionary cOSObject = info.getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(info, pdDocument.getDocumentInformation());
    assertSame(cOSObject, actualNextResult);
  }

  /**
   * Test {@link PDDocument#setDocumentInformation(PDDocumentInformation)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#setDocumentInformation(PDDocumentInformation)}
   */
  @Test
  @DisplayName("Test setDocumentInformation(PDDocumentInformation); given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.setDocumentInformation(PDDocumentInformation)"})
  void testSetDocumentInformation_givenFalse() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(false);
    dic.setKey(new COSObjectKey(1L, 1));
    PDDocumentInformation info = new PDDocumentInformation(dic);

    // Act
    pdDocument.setDocumentInformation(info);

    // Assert
    Iterator<COSBase> iteratorResult = info.getCOSObject().toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(dic, actualNextResult);
    assertSame(info, pdDocument.getDocumentInformation());
  }

  /**
   * Test {@link PDDocument#setDocumentInformation(PDDocumentInformation)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#setDocumentInformation(PDDocumentInformation)}
   */
  @Test
  @DisplayName("Test setDocumentInformation(PDDocumentInformation); given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.setDocumentInformation(PDDocumentInformation)"})
  void testSetDocumentInformation_givenTrue() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(true);
    dic.setKey(new COSObjectKey(1L, 1));
    PDDocumentInformation info = new PDDocumentInformation(dic);

    // Act
    pdDocument.setDocumentInformation(info);

    // Assert
    Iterator<COSBase> iteratorResult = info.getCOSObject().toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(dic, actualNextResult);
    assertSame(info, pdDocument.getDocumentInformation());
  }

  /**
   * Test {@link PDDocument#setDocumentInformation(PDDocumentInformation)}.
   *
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} Document Trailer Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#setDocumentInformation(PDDocumentInformation)}
   */
  @Test
  @DisplayName(
      "Test setDocumentInformation(PDDocumentInformation); then PDDocument() Document Trailer Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.setDocumentInformation(PDDocumentInformation)"})
  void testSetDocumentInformation_thenPDDocumentDocumentTrailerValuesSizeIsOne() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDDocumentInformation info = new PDDocumentInformation(null);

    // Act
    pdDocument.setDocumentInformation(info);

    // Assert
    COSDictionary trailer = pdDocument.getDocument().getTrailer();
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, trailer.size());
    assertSame(info, pdDocument.getDocumentInformation());
  }

  /**
   * Test {@link PDDocument#getDocumentCatalog()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getDocumentCatalog()}
   */
  @Test
  @DisplayName("Test getDocumentCatalog(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocumentCatalog PDDocument.getDocumentCatalog()"})
  void testGetDocumentCatalog_thenThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenThrow(new IllegalStateException());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).getDocumentCatalog());
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#isEncrypted()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} protect {@link PublicKeyProtectionPolicy} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#isEncrypted()}
   */
  @Test
  @DisplayName(
      "Test isEncrypted(); given PDDocument() protect PublicKeyProtectionPolicy (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDDocument.isEncrypted()"})
  void testIsEncrypted_givenPDDocumentProtectPublicKeyProtectionPolicy_thenReturnTrue()
      throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.protect(new PublicKeyProtectionPolicy());
    pdDocument.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    // Act and Assert
    assertTrue(pdDocument.isEncrypted());
  }

  /**
   * Test {@link PDDocument#isEncrypted()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument(COSDocument)} with doc is {@link
   *       COSDocument#COSDocument()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#isEncrypted()}
   */
  @Test
  @DisplayName(
      "Test isEncrypted(); given PDDocument(COSDocument) with doc is COSDocument(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDDocument.isEncrypted()"})
  void testIsEncrypted_givenPDDocumentWithDocIsCOSDocument_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDDocument(new COSDocument()).isEncrypted());
  }

  /**
   * Test {@link PDDocument#isEncrypted()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given PDDocument(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDDocument.isEncrypted()"})
  void testIsEncrypted_givenPDDocument_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDDocument().isEncrypted());
  }

  /**
   * Test {@link PDDocument#getEncryption()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument(COSDocument)} with doc is {@link
   *       COSDocument#COSDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getEncryption()}
   */
  @Test
  @DisplayName(
      "Test getEncryption(); given PDDocument(COSDocument) with doc is COSDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEncryption PDDocument.getEncryption()"})
  void testGetEncryption_givenPDDocumentWithDocIsCOSDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDDocument(new COSDocument()).getEncryption());
  }

  /**
   * Test {@link PDDocument#getEncryption()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getEncryption()}
   */
  @Test
  @DisplayName("Test getEncryption(); given PDDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEncryption PDDocument.getEncryption()"})
  void testGetEncryption_givenPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDDocument().getEncryption());
  }

  /**
   * Test {@link PDDocument#getEncryption()}.
   *
   * <ul>
   *   <li>Then return {@link PDEncryption#PDEncryption()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getEncryption()}
   */
  @Test
  @DisplayName("Test getEncryption(); then return PDEncryption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEncryption PDDocument.getEncryption()"})
  void testGetEncryption_thenReturnPDEncryption() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDEncryption encryption = new PDEncryption();
    pdDocument.setEncryptionDictionary(encryption);

    // Act and Assert
    assertSame(encryption, pdDocument.getEncryption());
  }

  /**
   * Test {@link PDDocument#getLastSignatureDictionary()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  @DisplayName("Test getLastSignatureDictionary(); given COSDocument() Trailer is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature PDDocument.getLastSignatureDictionary()"})
  void testGetLastSignatureDictionary_givenCOSDocumentTrailerIsCOSDictionary() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertNull(new PDDocument(doc).getLastSignatureDictionary());
  }

  /**
   * Test {@link PDDocument#getLastSignatureDictionary()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  @DisplayName(
      "Test getLastSignatureDictionary(); given PDDocument() addPage PDPage(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature PDDocument.getLastSignatureDictionary()"})
  void testGetLastSignatureDictionary_givenPDDocumentAddPagePDPage_thenReturnNull() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());

    // Act and Assert
    assertNull(pdDocument.getLastSignatureDictionary());
  }

  /**
   * Test {@link PDDocument#getLastSignatureDictionary()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  @DisplayName("Test getLastSignatureDictionary(); given PDDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature PDDocument.getLastSignatureDictionary()"})
  void testGetLastSignatureDictionary_givenPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDDocument().getLastSignatureDictionary());
  }

  /**
   * Test {@link PDDocument#getLastSignatureDictionary()}.
   *
   * <ul>
   *   <li>Then return ContactInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  @DisplayName("Test getLastSignatureDictionary(); then return ContactInfo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature PDDocument.getLastSignatureDictionary()"})
  void testGetLastSignatureDictionary_thenReturnContactInfoIsNull() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    pdDocument.addSignature(new PDSignature());
    pdDocument.addPage(new PDPage());

    // Act
    PDSignature actualLastSignatureDictionary = pdDocument.getLastSignatureDictionary();

    // Assert
    assertNull(actualLastSignatureDictionary.getContactInfo());
    assertNull(actualLastSignatureDictionary.getFilter());
    assertNull(actualLastSignatureDictionary.getLocation());
    assertNull(actualLastSignatureDictionary.getName());
    assertNull(actualLastSignatureDictionary.getReason());
    assertNull(actualLastSignatureDictionary.getSubFilter());
    assertNull(actualLastSignatureDictionary.getSignDate());
    assertNull(actualLastSignatureDictionary.getPropBuild());
    assertEquals(9472, actualLastSignatureDictionary.getContents().length);
    assertArrayEquals(
        new int[] {0, 1000000000, 1000000000, 1000000000},
        actualLastSignatureDictionary.getByteRange());
  }

  /**
   * Test {@link PDDocument#getSignatureFields()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  @DisplayName(
      "Test getSignatureFields(); given COSDocument() Trailer is COSDictionary(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDDocument.getSignatureFields()"})
  void testGetSignatureFields_givenCOSDocumentTrailerIsCOSDictionary_thenReturnEmpty() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertTrue(new PDDocument(doc).getSignatureFields().isEmpty());
  }

  /**
   * Test {@link PDDocument#getSignatureFields()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  @DisplayName("Test getSignatureFields(); given PDDocument() addPage PDPage(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDDocument.getSignatureFields()"})
  void testGetSignatureFields_givenPDDocumentAddPagePDPage_thenReturnEmpty() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());

    // Act and Assert
    assertTrue(pdDocument.getSignatureFields().isEmpty());
  }

  /**
   * Test {@link PDDocument#getSignatureFields()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  @DisplayName("Test getSignatureFields(); given PDDocument(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDDocument.getSignatureFields()"})
  void testGetSignatureFields_givenPDDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDDocument().getSignatureFields().isEmpty());
  }

  /**
   * Test {@link PDDocument#getSignatureFields()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  @DisplayName("Test getSignatureFields(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDDocument.getSignatureFields()"})
  void testGetSignatureFields_thenReturnSizeIsOne() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    pdDocument.addSignature(new PDSignature());
    pdDocument.addPage(new PDPage());

    // Act
    List<PDSignatureField> actualSignatureFields = pdDocument.getSignatureFields();

    // Assert
    assertEquals(1, actualSignatureFields.size());
    PDSignatureField getResult = actualSignatureFields.get(0);
    assertEquals("Sig", getResult.getFieldType());
    assertEquals("Signature1", getResult.getFullyQualifiedName());
    assertEquals("Signature1", getResult.getPartialName());
    assertNull(getResult.getAlternateFieldName());
    assertNull(getResult.getMappingName());
    assertNull(getResult.getActions());
    assertNull(getResult.getSeedValue());
    assertNull(getResult.getDefaultValue());
    assertNull(getResult.getParent());
    assertEquals(0, getResult.getFieldFlags());
    assertEquals(1, getResult.getWidgets().size());
    assertFalse(getResult.isNoExport());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isRequired());
  }

  /**
   * Test {@link PDDocument#getSignatureDictionaries()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  @DisplayName("Test getSignatureDictionaries(); given COSDocument() Trailer is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDDocument.getSignatureDictionaries()"})
  void testGetSignatureDictionaries_givenCOSDocumentTrailerIsCOSDictionary() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertTrue(new PDDocument(doc).getSignatureDictionaries().isEmpty());
  }

  /**
   * Test {@link PDDocument#getSignatureDictionaries()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  @DisplayName(
      "Test getSignatureDictionaries(); given PDDocument() addPage PDPage(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDDocument.getSignatureDictionaries()"})
  void testGetSignatureDictionaries_givenPDDocumentAddPagePDPage_thenReturnEmpty() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());

    // Act and Assert
    assertTrue(pdDocument.getSignatureDictionaries().isEmpty());
  }

  /**
   * Test {@link PDDocument#getSignatureDictionaries()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  @DisplayName("Test getSignatureDictionaries(); given PDDocument(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDDocument.getSignatureDictionaries()"})
  void testGetSignatureDictionaries_givenPDDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDDocument().getSignatureDictionaries().isEmpty());
  }

  /**
   * Test {@link PDDocument#getSignatureDictionaries()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  @DisplayName("Test getSignatureDictionaries(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDDocument.getSignatureDictionaries()"})
  void testGetSignatureDictionaries_thenReturnSizeIsOne() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    pdDocument.addSignature(new PDSignature());
    pdDocument.addPage(new PDPage());

    // Act
    List<PDSignature> actualSignatureDictionaries = pdDocument.getSignatureDictionaries();

    // Assert
    assertEquals(1, actualSignatureDictionaries.size());
    PDSignature getResult = actualSignatureDictionaries.get(0);
    assertNull(getResult.getContactInfo());
    assertNull(getResult.getFilter());
    assertNull(getResult.getLocation());
    assertNull(getResult.getName());
    assertNull(getResult.getReason());
    assertNull(getResult.getSubFilter());
    assertNull(getResult.getSignDate());
    assertNull(getResult.getPropBuild());
    assertEquals(9472, getResult.getContents().length);
    assertArrayEquals(new int[] {0, 1000000000, 1000000000, 1000000000}, getResult.getByteRange());
  }

  /**
   * Test {@link PDDocument#save(OutputStream, CompressParameters)} with {@code output}, {@code
   * compressParameters}.
   *
   * <ul>
   *   <li>Then array length is four hundred sixty-seven.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream, CompressParameters) with 'output', 'compressParameters'; then array length is four hundred sixty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.save(OutputStream, CompressParameters)"})
  void testSaveWithOutputCompressParameters_thenArrayLengthIsFourHundredSixtySeven()
      throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    pdDocument.save(output, CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    assertEquals(467, output.toByteArray().length);
  }

  /**
   * Test {@link PDDocument#save(OutputStream, CompressParameters)} with {@code output}, {@code
   * compressParameters}.
   *
   * <ul>
   *   <li>Then array length is three hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream, CompressParameters) with 'output', 'compressParameters'; then array length is three hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.save(OutputStream, CompressParameters)"})
  void testSaveWithOutputCompressParameters_thenArrayLengthIsThreeHundredTwentyNine()
      throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    pdDocument.save(output, null);

    // Assert
    assertEquals(329, output.toByteArray().length);
  }

  /**
   * Test {@link PDDocument#save(OutputStream, CompressParameters)} with {@code output}, {@code
   * compressParameters}.
   *
   * <ul>
   *   <li>Then array length is three hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream, CompressParameters) with 'output', 'compressParameters'; then array length is three hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.save(OutputStream, CompressParameters)"})
  void testSaveWithOutputCompressParameters_thenArrayLengthIsThreeHundredTwentyNine2()
      throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    pdDocument.save(output, CompressParameters.NO_COMPRESSION);

    // Assert
    assertEquals(329, output.toByteArray().length);
  }

  /**
   * Test {@link PDDocument#save(OutputStream)} with {@code output}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then array length is four hundred sixty-seven.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#save(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream) with 'output'; given PDDocument(); then array length is four hundred sixty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.save(OutputStream)"})
  void testSaveWithOutput_givenPDDocument_thenArrayLengthIsFourHundredSixtySeven()
      throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    pdDocument.save(output);

    // Assert
    assertEquals(467, output.toByteArray().length);
  }

  /**
   * Test {@link PDDocument#saveIncremental(OutputStream)} with {@code output}.
   *
   * <p>Method under test: {@link PDDocument#saveIncremental(OutputStream)}
   */
  @Test
  @DisplayName("Test saveIncremental(OutputStream) with 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.saveIncremental(OutputStream)"})
  void testSaveIncrementalWithOutput() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> pdDocument.saveIncremental(new ByteArrayOutputStream()));
  }

  /**
   * Test {@link PDDocument#saveIncremental(OutputStream, Set)} with {@code output}, {@code
   * objectsToWrite}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  @DisplayName(
      "Test saveIncremental(OutputStream, Set) with 'output', 'objectsToWrite'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.saveIncremental(OutputStream, Set)"})
  void testSaveIncrementalWithOutputObjectsToWrite_givenCOSDictionary() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    HashSet<COSDictionary> objectsToWrite = new HashSet<>();
    objectsToWrite.add(new COSDictionary());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> pdDocument.saveIncremental(output, objectsToWrite));
  }

  /**
   * Test {@link PDDocument#saveIncremental(OutputStream, Set)} with {@code output}, {@code
   * objectsToWrite}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  @DisplayName(
      "Test saveIncremental(OutputStream, Set) with 'output', 'objectsToWrite'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.saveIncremental(OutputStream, Set)"})
  void testSaveIncrementalWithOutputObjectsToWrite_givenCOSDictionary2() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    HashSet<COSDictionary> objectsToWrite = new HashSet<>();
    objectsToWrite.add(new COSDictionary());
    objectsToWrite.add(new COSDictionary());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> pdDocument.saveIncremental(output, objectsToWrite));
  }

  /**
   * Test {@link PDDocument#saveIncremental(OutputStream, Set)} with {@code output}, {@code
   * objectsToWrite}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  @DisplayName(
      "Test saveIncremental(OutputStream, Set) with 'output', 'objectsToWrite'; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.saveIncremental(OutputStream, Set)"})
  void testSaveIncrementalWithOutputObjectsToWrite_whenHashSet() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> pdDocument.saveIncremental(output, new HashSet<>()));
  }

  /**
   * Test {@link PDDocument#saveIncrementalForExternalSigning(OutputStream)}.
   *
   * <p>Method under test: {@link PDDocument#saveIncrementalForExternalSigning(OutputStream)}
   */
  @Test
  @DisplayName("Test saveIncrementalForExternalSigning(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.interactive.digitalsignature.ExternalSigningSupport PDDocument.saveIncrementalForExternalSigning(OutputStream)"
  })
  void testSaveIncrementalForExternalSigning() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> pdDocument.saveIncrementalForExternalSigning(new ByteArrayOutputStream()));
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link COSArray#add(COSObjectable)}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName(
      "Test getPage(int); given COSArray getObject(int) throw IllegalStateException(); then calls add(COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenCOSArrayGetObjectThrowIllegalStateException_thenCallsAdd() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenThrow(new IllegalStateException());
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    cosArray.add(mock(COSObjectable.class));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(2);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).getPage(1));
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray).getObject(0);
    verify(cosArray).size();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName(
      "Test getPage(int); given COSDictionary getCOSArray(COSName) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenCOSDictionaryGetCOSArrayThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenThrow(new IllegalStateException());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(2);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).getPage(1));
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName(
      "Test getPage(int); given COSDictionary getCOSName(COSName) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenCOSDictionaryGetCOSNameThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenThrow(new IllegalStateException());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).getPage(1));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link COSArray#add(COSObjectable)}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName(
      "Test getPage(int); given COSDictionary getCOSName(COSName) throw IllegalStateException(); then calls add(COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenCOSDictionaryGetCOSNameThrowIllegalStateException_thenCallsAdd() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenThrow(new IllegalStateException());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    cosArray.add(mock(COSObjectable.class));

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(2);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary3);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary4);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).getPage(1));
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(cosDictionary2).getCOSArray(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName(
      "Test getPage(int); given COSDictionary getInt(COSName, int) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenCOSDictionaryGetIntThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt()))
        .thenThrow(new IllegalStateException());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).getPage(1));
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link COSArray#add(COSObjectable)}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName(
      "Test getPage(int); given COSDictionary getInt(COSName, int) throw IllegalStateException(); then calls add(COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenCOSDictionaryGetIntThrowIllegalStateException_thenCallsAdd() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt()))
        .thenThrow(new IllegalStateException());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    cosArray.add(mock(COSObjectable.class));

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(2);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary3);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary4);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).getPage(1));
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary2).getCOSArray(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDocument} {@link COSDocument#getTrailer()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); given COSDocument getTrailer() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenCOSDocumentGetTrailerThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenThrow(new IllegalStateException());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDDocument(doc).getPage(1));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); given PDDocument() addPage PDPage(); then return PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenPDDocumentAddPagePDPage_thenReturnPDPage() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    PDPage page = new PDPage();
    pdDocument.addPage(page);

    // Act and Assert
    assertEquals(page, pdDocument.getPage(1));
  }

  /**
   * Test {@link PDDocument#getPages()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return Count is one.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given PDDocument() addPage PDPage(); then return Count is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPageTree PDDocument.getPages()"})
  void testGetPages_givenPDDocumentAddPagePDPage_thenReturnCountIsOne() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDPage page = new PDPage();
    pdDocument.addPage(page);

    // Act
    PDPageTree actualPages = pdDocument.getPages();

    // Assert
    assertEquals(1, actualPages.getCount());
    Iterator<PDPage> iteratorResult = actualPages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals(page, actualNextResult);
  }

  /**
   * Test {@link PDDocument#getNumberOfPages()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getNumberOfPages()}
   */
  @Test
  @DisplayName("Test getNumberOfPages(); given PDDocument() addPage PDPage(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDDocument.getNumberOfPages()"})
  void testGetNumberOfPages_givenPDDocumentAddPagePDPage_thenReturnOne() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());

    // Act and Assert
    assertEquals(1, pdDocument.getNumberOfPages());
  }

  /**
   * Test {@link PDDocument#getNumberOfPages()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getNumberOfPages()}
   */
  @Test
  @DisplayName("Test getNumberOfPages(); given PDDocument(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDDocument.getNumberOfPages()"})
  void testGetNumberOfPages_givenPDDocument_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDDocument().getNumberOfPages());
  }

  /**
   * Test {@link PDDocument#close()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then {@link PDDocument#PDDocument()} Document Closed.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given PDDocument(); then PDDocument() Document Closed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.close()"})
  void testClose_givenPDDocument_thenPDDocumentDocumentClosed() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act
    pdDocument.close();

    // Assert
    assertTrue(pdDocument.getDocument().isClosed());
  }

  /**
   * Test {@link PDDocument#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@code 1.4}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getVersion()}
   */
  @Test
  @DisplayName(
      "Test getVersion(); given COSDocument() Trailer is COSDictionary(); then return '1.4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDDocument.getVersion()"})
  void testGetVersion_givenCOSDocumentTrailerIsCOSDictionary_thenReturn14() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertEquals(1.4f, new PDDocument(doc).getVersion());
  }

  /**
   * Test {@link PDDocument#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return {@code 1.4}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDDocument() addPage PDPage(); then return '1.4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDDocument.getVersion()"})
  void testGetVersion_givenPDDocumentAddPagePDPage_thenReturn14() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());

    // Act and Assert
    assertEquals(1.4f, pdDocument.getVersion());
  }

  /**
   * Test {@link PDDocument#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>Then return {@code 1.4}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDDocument(); then return '1.4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDDocument.getVersion()"})
  void testGetVersion_givenPDDocument_thenReturn14() {
    // Arrange, Act and Assert
    assertEquals(1.4f, new PDDocument().getVersion());
  }

  /**
   * Test {@link PDDocument#setVersion(float)}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.
   *   <li>When ten.
   *   <li>Then {@link PDDocument#PDDocument()} DocumentCatalog Version is {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocument#setVersion(float)}
   */
  @Test
  @DisplayName(
      "Test setVersion(float); given PDDocument(); when ten; then PDDocument() DocumentCatalog Version is '10.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocument.setVersion(float)"})
  void testSetVersion_givenPDDocument_whenTen_thenPDDocumentDocumentCatalogVersionIs100() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act
    pdDocument.setVersion(10.0f);

    // Assert
    assertEquals("10.0", pdDocument.getDocumentCatalog().getVersion());
    assertEquals(10.0f, pdDocument.getVersion());
  }
}
