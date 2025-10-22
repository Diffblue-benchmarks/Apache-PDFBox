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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.encryption.PDEncryption;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFreeText;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationInk;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentDiffblueTest {
  /**
   * Test {@link PDDocument#PDDocument()}.
   * <p>
   * Method under test: {@link PDDocument#PDDocument()}
   */
  @Test
  @DisplayName("Test new PDDocument()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link COSDocument#COSDocument()}.</li>
   *   <li>Then ResourceCache return {@link DefaultResourceCache}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#PDDocument(COSDocument)}
   */
  @Test
  @DisplayName("Test new PDDocument(COSDocument); when COSDocument(); then ResourceCache return DefaultResourceCache")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Page"));
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> pdDocument.addPage(page));
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage2() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenThrow(new NumberFormatException("Page"));
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Page"));
    doThrow(new NumberFormatException("Page")).when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.isDirect()).thenReturn(true);
    when(cosDictionary3.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(cosDictionary3).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary3);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> pdDocument.addPage(page));
    verify(cosDictionary3).isDirect();
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary3).getUpdateState();
    verify(cosDictionary2).setInt(isA(COSName.class), eq(2));
    verify(cosDictionary3).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage3() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenThrow(new NumberFormatException("Page"));
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Page"));
    doThrow(new NumberFormatException("Page")).when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.isDirect()).thenReturn(true);
    when(cosDictionary3.getUpdateState()).thenReturn(new COSUpdateState(null));
    doNothing().when(cosDictionary3).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary3);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> pdDocument.addPage(page));
    verify(cosDictionary3).isDirect();
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary3).getUpdateState();
    verify(cosDictionary2).setInt(isA(COSName.class), eq(2));
    verify(cosDictionary3).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSArray#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); given ArrayList() add FALSE; then calls iterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenArrayListAddFalse_thenCallsIterator() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(COSBoolean.FALSE);
    COSArray updateInfo = mock(COSArray.class);
    when(updateInfo.iterator()).thenReturn(cosBaseList.iterator());
    COSUpdateState cosUpdateState = new COSUpdateState(updateInfo);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenThrow(new NumberFormatException("Page"));
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Page"));
    doThrow(new NumberFormatException("Page")).when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.isDirect()).thenReturn(true);
    when(cosDictionary3.getUpdateState()).thenReturn(cosUpdateState);
    doNothing().when(cosDictionary3).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary3);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> pdDocument.addPage(page));
    verify(updateInfo).iterator();
    verify(cosDictionary3).isDirect();
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary3).getUpdateState();
    verify(cosDictionary2).setInt(isA(COSName.class), eq(2));
    verify(cosDictionary3).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#iterator()} return {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link COSArray#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); given COSArray iterator() return ArrayList() iterator; then calls iterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSArrayIteratorReturnArrayListIterator_thenCallsIterator() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    COSArray updateInfo = mock(COSArray.class);

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    when(updateInfo.iterator()).thenReturn(cosBaseList.iterator());
    COSUpdateState cosUpdateState = new COSUpdateState(updateInfo);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenThrow(new NumberFormatException("Page"));
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Page"));
    doThrow(new NumberFormatException("Page")).when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.isDirect()).thenReturn(true);
    when(cosDictionary3.getUpdateState()).thenReturn(cosUpdateState);
    doNothing().when(cosDictionary3).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary3);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> pdDocument.addPage(page));
    verify(updateInfo).iterator();
    verify(cosDictionary3).isDirect();
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary3).getUpdateState();
    verify(cosDictionary2).setInt(isA(COSName.class), eq(2));
    verify(cosDictionary3).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSBase#isDirect()} return {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); given COSDictionary isDirect() return 'false'; then calls getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSDictionaryIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenThrow(new NumberFormatException("Page"));
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Page"));
    doThrow(new NumberFormatException("Page")).when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.isDirect()).thenReturn(false);
    when(cosDictionary3.getKey()).thenReturn(new COSObjectKey(1L, 1));
    when(cosDictionary3.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(cosDictionary3).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary3);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> pdDocument.addPage(page));
    verify(cosDictionary3, atLeast(1)).getKey();
    verify(cosDictionary3).isDirect();
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary3).getUpdateState();
    verify(cosDictionary2).setInt(isA(COSName.class), eq(2));
    verify(cosDictionary3).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSBase#isDirect()} return {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); given COSDictionary isDirect() return 'false'; then calls getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSDictionaryIsDirectReturnFalse_thenCallsGetKey2() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenThrow(new NumberFormatException("Page"));
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Page"));
    doThrow(new NumberFormatException("Page")).when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.isDirect()).thenReturn(false);
    when(cosDictionary3.getKey()).thenReturn(new COSObjectKey(1L, 1));
    when(cosDictionary3.getUpdateState()).thenReturn(mock(COSUpdateState.class));
    doNothing().when(cosDictionary3).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary3);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> pdDocument.addPage(page));
    verify(cosDictionary3, atLeast(1)).getKey();
    verify(cosDictionary3).isDirect();
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary3).getUpdateState();
    verify(cosDictionary2).setInt(isA(COSName.class), eq(2));
    verify(cosDictionary3).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenThrow(new NumberFormatException("Page"));
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Page"));
    doThrow(new NumberFormatException("Page")).when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.isDirect()).thenReturn(true);
    when(cosDictionary3.getUpdateState())
        .thenReturn(new COSUpdateState(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
    doNothing().when(cosDictionary3).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary3);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> pdDocument.addPage(page));
    verify(cosDictionary3).isDirect();
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary3).getUpdateState();
    verify(cosDictionary2).setInt(isA(COSName.class), eq(2));
    verify(cosDictionary3).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addPage(PDPage)"})
  void testAddPage_thenCallsSetOriginDocumentState() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenThrow(new NumberFormatException("Page"));
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Page"));
    doThrow(new NumberFormatException("Page")).when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.isDirect()).thenReturn(true);
    when(cosDictionary3.getUpdateState()).thenReturn(cosUpdateState);
    doNothing().when(cosDictionary3).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary3);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> pdDocument.addPage(page));
    verify(cosDictionary3).isDirect();
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary3).getUpdateState();
    verify(cosDictionary2).setInt(isA(COSName.class), eq(2));
    verify(cosDictionary3).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosUpdateState).setOriginDocumentState(isA(COSDocumentState.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject}, {@code options}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add PDAnnotationCaret()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenArrayListAddPDAnnotationCaret() throws IOException {
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCircle#PDAnnotationCircle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add PDAnnotationCircle()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenArrayListAddPDAnnotationCircle() throws IOException {
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add PDAnnotationFileAttachment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenArrayListAddPDAnnotationFileAttachment() throws IOException {
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationFreeText#PDAnnotationFreeText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add PDAnnotationFreeText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenArrayListAddPDAnnotationFreeText() throws IOException {
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationHighlight#PDAnnotationHighlight()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add PDAnnotationHighlight()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenArrayListAddPDAnnotationHighlight() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationHighlight());

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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given three; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_givenThree_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDSignature sigObject = new PDSignature();

    SignatureOptions options = new SignatureOptions();
    options.setPreferredSignatureSize(3);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(sigObject, options));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} SignatureFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; then PDDocument() SignatureFields size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_thenPDDocumentSignatureFieldsSizeIsOne() throws IOException {
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureOptions)"})
  void testAddSignatureWithSigObjectOptions_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDSignature sigObject = new PDSignature();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(sigObject, new SignatureOptions()));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"})
  void testAddSignatureWithSigObjectSignatureInterfaceOptions() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions()));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"})
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"})
  void testAddSignatureWithSigObjectSignatureInterfaceOptions3() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    SignatureOptions options = new SignatureOptions();
    options.setPreferredSignatureSize(3);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(sigObject, signatureInterface, options));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"})
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"})
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"})
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"})
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"})
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"})
  void testAddSignatureWithSigObjectSignatureInterfaceOptions9() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationHighlight());

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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)} with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'; given ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface, SignatureOptions)"})
  void testAddSignatureWithSigObjectSignatureInterfaceOptions_givenArrayListAddNull() throws IOException {
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject}, {@code signatureInterface}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'; given ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject}, {@code signatureInterface}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationInk#PDAnnotationInk()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'; given ArrayList() add PDAnnotationInk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface)"})
  void testAddSignatureWithSigObjectSignatureInterface_givenArrayListAddPDAnnotationInk() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationInk());

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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with {@code sigObject}, {@code signatureInterface}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature, SignatureInterface)"})
  void testAddSignatureWithSigObjectSignatureInterface_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdDocument.addSignature(new PDSignature(), mock(SignatureInterface.class)));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add PDAnnotationCaret()")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCircle#PDAnnotationCircle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add PDAnnotationCircle()")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add PDAnnotationFileAttachment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_givenArrayListAddPDAnnotationFileAttachment() throws IOException {
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationFreeText#PDAnnotationFreeText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add PDAnnotationFreeText()")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationHighlight#PDAnnotationHighlight()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add PDAnnotationHighlight()")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationInk#PDAnnotationInk()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; given ArrayList() add PDAnnotationInk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_givenArrayListAddPDAnnotationInk() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationInk());

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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addSignature {@link PDSignature#PDSignature()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; given PDDocument() addSignature PDSignature()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_givenPDDocumentAddSignaturePDSignature() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    pdDocument.addSignature(new PDSignature());
    pdDocument.addPage(new PDPage());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(new PDSignature()));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; given PDDocument(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.addSignature(PDSignature)"})
  void testAddSignatureWithSigObject_givenPDDocument_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(new PDSignature()));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} SignatureFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; then PDDocument() SignatureFields size is one")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, sigObject.getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, signatureDictionaries.get(0).getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000},
        pdDocument.getLastSignatureDictionary().getByteRange());
    PDSignatureField getResult = signatureFields.get(0);
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getSignature().getByteRange());
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getValue().getByteRange());
  }

  /**
   * Test {@link PDDocument#removePage(int)} with {@code pageNumber}.
   * <p>
   * Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName("Test removePage(int) with 'pageNumber'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.removePage(int)"})
  void testRemovePageWithPageNumber() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenThrow(new IllegalStateException("foo"));
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDDocument(doc)).removePage(10));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#removePage(int)} with {@code pageNumber}.
   * <p>
   * Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName("Test removePage(int) with 'pageNumber'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.removePage(int)"})
  void testRemovePageWithPageNumber2() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenThrow(new IllegalStateException("Page"));
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
    assertThrows(IllegalStateException.class, () -> (new PDDocument(doc)).removePage(10));
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
   * <ul>
   *   <li>Then calls {@link COSArray#add(COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName("Test removePage(int) with 'pageNumber'; then calls add(COSObjectable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.removePage(int)"})
  void testRemovePageWithPageNumber_thenCallsAdd() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenThrow(new IllegalStateException("Page"));
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
    assertThrows(IllegalStateException.class, () -> (new PDDocument(doc)).removePage(10));
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
   * Test {@link PDDocument#removePage(int)} with {@code pageNumber}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName("Test removePage(int) with 'pageNumber'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.removePage(int)"})
  void testRemovePageWithPageNumber_thenThrowNumberFormatException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenThrow(new NumberFormatException("Page"));
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
    assertThrows(NumberFormatException.class, () -> (new PDDocument(doc)).removePage(10));
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray).getObject(eq(0));
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
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName("Test removePage(PDPage) with 'page'; given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
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
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName)} return one.</li>
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName("Test removePage(PDPage) with 'page'; given COSDictionary getInt(COSName) return one; then calls setInt(COSName, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_givenCOSDictionaryGetIntReturnOne_thenCallsSetInt() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary2);

    // Act
    pdDocument.removePage(page);

    // Assert
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary).setInt(isA(COSName.class), eq(0));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#removePage(PDPage)} with {@code page}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName("Test removePage(PDPage) with 'page'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.removePage(PDPage)"})
  void testRemovePageWithPage_thenThrowNumberFormatException() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenThrow(new NumberFormatException("Page"));
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Page"));
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary2);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> pdDocument.removePage(page));
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDDocument#getDocumentInformation()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Author is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getDocumentInformation()}
   */
  @Test
  @DisplayName("Test getDocumentInformation(); given PDDocument(); then return Author is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDocumentInformation PDDocument.getDocumentInformation()"})
  void testGetDocumentInformation_givenPDDocument_thenReturnAuthorIsNull() {
    // Arrange and Act
    PDDocumentInformation actualDocumentInformation = (new PDDocument()).getDocumentInformation();

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
   * <ul>
   *   <li>Then return {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getDocumentInformation()}
   */
  @Test
  @DisplayName("Test getDocumentInformation(); then return PDDocumentInformation()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} Document Trailer Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#setDocumentInformation(PDDocumentInformation)}
   */
  @Test
  @DisplayName("Test setDocumentInformation(PDDocumentInformation); then PDDocument() Document Trailer Values size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getDocumentCatalog()}
   */
  @Test
  @DisplayName("Test getDocumentCatalog(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDocumentCatalog PDDocument.getDocumentCatalog()"})
  void testGetDocumentCatalog_thenThrowIllegalStateException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenThrow(new IllegalStateException("foo"));
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDDocument(doc)).getDocumentCatalog());
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#isEncrypted()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given PDDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDDocument.isEncrypted()"})
  void testIsEncrypted_givenPDDocument() {
    // Arrange, Act and Assert
    assertFalse((new PDDocument()).isEncrypted());
  }

  /**
   * Test {@link PDDocument#isEncrypted()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument(COSDocument)} with doc is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given PDDocument(COSDocument) with doc is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDDocument.isEncrypted()"})
  void testIsEncrypted_givenPDDocumentWithDocIsCOSDocument() {
    // Arrange, Act and Assert
    assertFalse((new PDDocument(new COSDocument())).isEncrypted());
  }

  /**
   * Test {@link PDDocument#getEncryption()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument(COSDocument)} with doc is {@link COSDocument#COSDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getEncryption()}
   */
  @Test
  @DisplayName("Test getEncryption(); given PDDocument(COSDocument) with doc is COSDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDEncryption PDDocument.getEncryption()"})
  void testGetEncryption_givenPDDocumentWithDocIsCOSDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocument(new COSDocument())).getEncryption());
  }

  /**
   * Test {@link PDDocument#getEncryption()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getEncryption()}
   */
  @Test
  @DisplayName("Test getEncryption(); given PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDEncryption PDDocument.getEncryption()"})
  void testGetEncryption_givenPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocument()).getEncryption());
  }

  /**
   * Test {@link PDDocument#getEncryption()}.
   * <ul>
   *   <li>Then return {@link PDEncryption#PDEncryption()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getEncryption()}
   */
  @Test
  @DisplayName("Test getEncryption(); then return PDEncryption()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  @DisplayName("Test getLastSignatureDictionary(); given COSDocument() Trailer is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSignature PDDocument.getLastSignatureDictionary()"})
  void testGetLastSignatureDictionary_givenCOSDocumentTrailerIsCOSDictionary() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertNull((new PDDocument(doc)).getLastSignatureDictionary());
  }

  /**
   * Test {@link PDDocument#getLastSignatureDictionary()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  @DisplayName("Test getLastSignatureDictionary(); given PDDocument() addPage PDPage(); then return 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  @DisplayName("Test getLastSignatureDictionary(); given PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSignature PDDocument.getLastSignatureDictionary()"})
  void testGetLastSignatureDictionary_givenPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocument()).getLastSignatureDictionary());
  }

  /**
   * Test {@link PDDocument#getLastSignatureDictionary()}.
   * <ul>
   *   <li>Then return ContactInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  @DisplayName("Test getLastSignatureDictionary(); then return ContactInfo is 'null'")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, actualLastSignatureDictionary.getByteRange());
  }

  /**
   * Test {@link PDDocument#getSignatureFields()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  @DisplayName("Test getSignatureFields(); given COSDocument() Trailer is COSDictionary(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDocument.getSignatureFields()"})
  void testGetSignatureFields_givenCOSDocumentTrailerIsCOSDictionary_thenReturnEmpty() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertTrue((new PDDocument(doc)).getSignatureFields().isEmpty());
  }

  /**
   * Test {@link PDDocument#getSignatureFields()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  @DisplayName("Test getSignatureFields(); given PDDocument() addPage PDPage(); then return Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  @DisplayName("Test getSignatureFields(); given PDDocument(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDocument.getSignatureFields()"})
  void testGetSignatureFields_givenPDDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDDocument()).getSignatureFields().isEmpty());
  }

  /**
   * Test {@link PDDocument#getSignatureFields()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  @DisplayName("Test getSignatureFields(); then return size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  @DisplayName("Test getSignatureDictionaries(); given COSDocument() Trailer is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDocument.getSignatureDictionaries()"})
  void testGetSignatureDictionaries_givenCOSDocumentTrailerIsCOSDictionary() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertTrue((new PDDocument(doc)).getSignatureDictionaries().isEmpty());
  }

  /**
   * Test {@link PDDocument#getSignatureDictionaries()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  @DisplayName("Test getSignatureDictionaries(); given PDDocument() addPage PDPage(); then return Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  @DisplayName("Test getSignatureDictionaries(); given PDDocument(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDocument.getSignatureDictionaries()"})
  void testGetSignatureDictionaries_givenPDDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDDocument()).getSignatureDictionaries().isEmpty());
  }

  /**
   * Test {@link PDDocument#getSignatureDictionaries()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  @DisplayName("Test getSignatureDictionaries(); then return size is one")
  @Tag("MaintainedByDiffblue")
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
    assertArrayEquals(new int[]{0, 1000000000, 1000000000, 1000000000}, getResult.getByteRange());
  }

  /**
   * Test {@link PDDocument#save(OutputStream, CompressParameters)} with {@code output}, {@code compressParameters}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test save(OutputStream, CompressParameters) with 'output', 'compressParameters'; given PDDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.save(OutputStream, CompressParameters)"})
  void testSaveWithOutputCompressParameters_givenPDDocument() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output, CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    assertEquals(467, output.toByteArray().length);
  }

  /**
   * Test {@link PDDocument#save(OutputStream)} with {@code output}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>Then array length is four hundred sixty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'output'; given PDDocument(); then array length is four hundred sixty-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.save(OutputStream)"})
  void testSaveWithOutput_givenPDDocument_thenArrayLengthIsFourHundredSixtySeven() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output);

    // Assert
    assertEquals(467, output.toByteArray().length);
  }

  /**
   * Test {@link PDDocument#saveIncremental(OutputStream)} with {@code output}.
   * <p>
   * Method under test: {@link PDDocument#saveIncremental(OutputStream)}
   */
  @Test
  @DisplayName("Test saveIncremental(OutputStream) with 'output'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.saveIncremental(OutputStream)"})
  void testSaveIncrementalWithOutput() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.saveIncremental(new ByteArrayOutputStream(1)));
  }

  /**
   * Test {@link PDDocument#saveIncremental(OutputStream, Set)} with {@code output}, {@code objectsToWrite}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  @DisplayName("Test saveIncremental(OutputStream, Set) with 'output', 'objectsToWrite'; given COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.saveIncremental(OutputStream, Set)"})
  void testSaveIncrementalWithOutputObjectsToWrite_givenCOSDictionary() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    HashSet<COSDictionary> objectsToWrite = new HashSet<>();
    objectsToWrite.add(new COSDictionary());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.saveIncremental(output, objectsToWrite));
  }

  /**
   * Test {@link PDDocument#saveIncremental(OutputStream, Set)} with {@code output}, {@code objectsToWrite}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  @DisplayName("Test saveIncremental(OutputStream, Set) with 'output', 'objectsToWrite'; given COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.saveIncremental(OutputStream, Set)"})
  void testSaveIncrementalWithOutputObjectsToWrite_givenCOSDictionary2() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    HashSet<COSDictionary> objectsToWrite = new HashSet<>();
    objectsToWrite.add(new COSDictionary());
    objectsToWrite.add(new COSDictionary());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.saveIncremental(output, objectsToWrite));
  }

  /**
   * Test {@link PDDocument#saveIncremental(OutputStream, Set)} with {@code output}, {@code objectsToWrite}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  @DisplayName("Test saveIncremental(OutputStream, Set) with 'output', 'objectsToWrite'; when HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocument.saveIncremental(OutputStream, Set)"})
  void testSaveIncrementalWithOutputObjectsToWrite_whenHashSet() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.saveIncremental(output, new HashSet<>()));
  }

  /**
   * Test {@link PDDocument#saveIncrementalForExternalSigning(OutputStream)}.
   * <p>
   * Method under test: {@link PDDocument#saveIncrementalForExternalSigning(OutputStream)}
   */
  @Test
  @DisplayName("Test saveIncrementalForExternalSigning(OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.interactive.digitalsignature.ExternalSigningSupport PDDocument.saveIncrementalForExternalSigning(OutputStream)"})
  void testSaveIncrementalForExternalSigning() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdDocument.saveIncrementalForExternalSigning(new ByteArrayOutputStream(1)));
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} throw {@link IllegalStateException#IllegalStateException(String)} with {@code Page}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); given COSDictionary getCOSArray(COSName) throw IllegalStateException(String) with 'Page'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenCOSDictionaryGetCOSArrayThrowIllegalStateExceptionWithPage() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenThrow(new IllegalStateException("Page"));
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
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
    assertThrows(IllegalStateException.class, () -> (new PDDocument(doc)).getPage(1));
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} throw {@link IllegalStateException#IllegalStateException(String)} with {@code Page}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); given COSDictionary getInt(COSName, int) throw IllegalStateException(String) with 'Page'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenCOSDictionaryGetIntThrowIllegalStateExceptionWithPage() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenThrow(new IllegalStateException("Page"));
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
    assertThrows(IllegalStateException.class, () -> (new PDDocument(doc)).getPage(1));
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
   * <ul>
   *   <li>Given {@link COSDocument} {@link COSDocument#getTrailer()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); given COSDocument getTrailer() throw IllegalStateException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenCOSDocumentGetTrailerThrowIllegalStateExceptionWithFoo() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenThrow(new IllegalStateException("foo"));
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDDocument(doc)).getPage(1));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); given PDDocument() addPage PDPage(); when one; then return PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_givenPDDocumentAddPagePDPage_whenOne_thenReturnPDPage() {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    PDPage page = new PDPage();
    pdDocument.addPage(page);

    // Act and Assert
    assertEquals(page, pdDocument.getPage(1));
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPage PDDocument.getPage(int)"})
  void testGetPage_thenThrowNumberFormatException() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenThrow(new NumberFormatException("Page"));
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
    assertThrows(NumberFormatException.class, () -> (new PDDocument(doc)).getPage(1));
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray).getObject(eq(0));
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
   * Test {@link PDDocument#getPages()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)} return {@link COSName#A}.</li>
   *   <li>Then return Count is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given COSDictionary getCOSName(COSName) return A; then return Count is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageTree PDDocument.getPages()"})
  void testGetPages_givenCOSDictionaryGetCOSNameReturnA_thenReturnCountIsZero() {
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

    // Act
    PDPageTree actualPages = (new PDDocument(doc)).getPages();

    // Assert
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    assertEquals(0, actualPages.getCount());
    assertFalse(actualPages.iterator().hasNext());
  }

  /**
   * Test {@link PDDocument#getPages()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)} throw {@link IllegalStateException#IllegalStateException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given COSDictionary getCOSName(COSName) throw IllegalStateException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageTree PDDocument.getPages()"})
  void testGetPages_givenCOSDictionaryGetCOSNameThrowIllegalStateExceptionWithFoo() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenThrow(new IllegalStateException("foo"));
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDDocument(doc)).getPages());
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#getPages()}.
   * <ul>
   *   <li>Given {@link COSDocument} {@link COSDocument#getTrailer()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given COSDocument getTrailer() throw IllegalStateException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageTree PDDocument.getPages()"})
  void testGetPages_givenCOSDocumentGetTrailerThrowIllegalStateExceptionWithFoo() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenThrow(new IllegalStateException("foo"));
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDDocument(doc)).getPages());
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
  }

  /**
   * Test {@link PDDocument#getPages()}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); then return COSObject is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageTree PDDocument.getPages()"})
  void testGetPages_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSDictionary cosDictionary2 = new COSDictionary();
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary3);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    PDPageTree actualPages = (new PDDocument(doc)).getPages();

    // Assert
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    assertSame(cosDictionary2, actualPages.getCOSObject());
  }

  /**
   * Test {@link PDDocument#getNumberOfPages()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getNumberOfPages()}
   */
  @Test
  @DisplayName("Test getNumberOfPages(); given PDDocument() addPage PDPage(); then return one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getNumberOfPages()}
   */
  @Test
  @DisplayName("Test getNumberOfPages(); given PDDocument(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDDocument.getNumberOfPages()"})
  void testGetNumberOfPages_givenPDDocument_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDDocument()).getNumberOfPages());
  }

  /**
   * Test {@link PDDocument#close()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>Then {@link PDDocument#PDDocument()} Document Closed.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given PDDocument(); then PDDocument() Document Closed")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code 1.4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given COSDocument() Trailer is COSDictionary(); then return '1.4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDDocument.getVersion()"})
  void testGetVersion_givenCOSDocumentTrailerIsCOSDictionary_thenReturn14() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertEquals(1.4f, (new PDDocument(doc)).getVersion());
  }

  /**
   * Test {@link PDDocument#getVersion()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code 1.4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDDocument() addPage PDPage(); then return '1.4'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code 1.4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDDocument(); then return '1.4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDDocument.getVersion()"})
  void testGetVersion_givenPDDocument_thenReturn14() {
    // Arrange, Act and Assert
    assertEquals(1.4f, (new PDDocument()).getVersion());
  }

  /**
   * Test {@link PDDocument#setVersion(float)}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>When ten.</li>
   *   <li>Then {@link PDDocument#PDDocument()} DocumentCatalog Version is {@code 10.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#setVersion(float)}
   */
  @Test
  @DisplayName("Test setVersion(float); given PDDocument(); when ten; then PDDocument() DocumentCatalog Version is '10.0'")
  @Tag("MaintainedByDiffblue")
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
