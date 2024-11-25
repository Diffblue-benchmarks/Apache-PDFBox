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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
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
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.PDEncryption;
import org.apache.pdfbox.pdmodel.interactive.action.PDPageAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationInk;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationUnknown;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentDiffblueTest {
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
  void testNewPDDocument_whenCOSDocument_thenResourceCacheReturnDefaultResourceCache() {
    // Arrange
    COSDocument doc = new COSDocument();

    // Act
    PDDocument actualPdDocument = new PDDocument(doc);

    // Assert
    assertTrue(actualPdDocument.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualPdDocument.getDocumentId());
    assertNull(actualPdDocument.getEncryption());
    AccessPermission currentAccessPermission = actualPdDocument.getCurrentAccessPermission();
    assertEquals(3901, currentAccessPermission.getPermissionBytesForPublicKey());
    assertFalse(actualPdDocument.isAllSecurityToBeRemoved());
    assertFalse(actualPdDocument.isEncrypted());
    assertFalse(currentAccessPermission.isReadOnly());
    assertTrue(actualPdDocument.getFontsToSubset().isEmpty());
    assertSame(doc, actualPdDocument.getDocument());
  }

  /**
   * Test {@link PDDocument#PDDocument(COSDocument, RandomAccessRead)}.
   * <ul>
   *   <li>When {@link COSDocument#COSDocument()}.</li>
   *   <li>Then ResourceCache return {@link DefaultResourceCache}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocument#PDDocument(COSDocument, RandomAccessRead)}
   */
  @Test
  @DisplayName("Test new PDDocument(COSDocument, RandomAccessRead); when COSDocument(); then ResourceCache return DefaultResourceCache")
  void testNewPDDocument_whenCOSDocument_thenResourceCacheReturnDefaultResourceCache2() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();

    // Act
    PDDocument actualPdDocument = new PDDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertTrue(actualPdDocument.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualPdDocument.getDocumentId());
    assertNull(actualPdDocument.getEncryption());
    AccessPermission currentAccessPermission = actualPdDocument.getCurrentAccessPermission();
    assertEquals(3901, currentAccessPermission.getPermissionBytesForPublicKey());
    assertFalse(actualPdDocument.isAllSecurityToBeRemoved());
    assertFalse(actualPdDocument.isEncrypted());
    assertFalse(currentAccessPermission.isReadOnly());
    assertTrue(actualPdDocument.getFontsToSubset().isEmpty());
    assertSame(doc, actualPdDocument.getDocument());
  }

  /**
   * Test
   * {@link PDDocument#PDDocument(COSDocument, RandomAccessRead, AccessPermission)}.
   * <ul>
   *   <li>When {@link COSDocument#COSDocument()}.</li>
   *   <li>Then ResourceCache return {@link DefaultResourceCache}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocument#PDDocument(COSDocument, RandomAccessRead, AccessPermission)}
   */
  @Test
  @DisplayName("Test new PDDocument(COSDocument, RandomAccessRead, AccessPermission); when COSDocument(); then ResourceCache return DefaultResourceCache")
  void testNewPDDocument_whenCOSDocument_thenResourceCacheReturnDefaultResourceCache3() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    AccessPermission permission = AccessPermission.getOwnerAccessPermission();

    // Act
    PDDocument actualPdDocument = new PDDocument(doc, source, permission);

    // Assert
    assertTrue(actualPdDocument.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualPdDocument.getDocumentId());
    assertNull(actualPdDocument.getEncryption());
    assertFalse(actualPdDocument.isAllSecurityToBeRemoved());
    assertFalse(actualPdDocument.isEncrypted());
    assertTrue(actualPdDocument.getFontsToSubset().isEmpty());
    assertSame(doc, actualPdDocument.getDocument());
    assertSame(permission, actualPdDocument.getCurrentAccessPermission());
  }

  /**
   * Test {@link PDDocument#addPage(PDPage)}.
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage)")
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
   *   <li>Given {@link COSArray} {@link COSArray#iterator()} return
   * {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link COSArray#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); given COSArray iterator() return ArrayList() iterator; then calls iterator()")
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
   *   <li>Given {@link COSDictionary} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); given COSDictionary isDirect() return 'false'; then calls getKey()")
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
   *   <li>Given {@link COSDictionary} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); given COSDictionary isDirect() return 'false'; then calls getKey()")
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
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); given COSObjectKey(long, int) with num is one and gen is one")
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
   *   <li>Then calls
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  @DisplayName("Test addPage(PDPage); then calls setOriginDocumentState(COSDocumentState)")
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
  void testAddSignatureWithSigObject() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature());

    // Assert
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations = iteratorResult.next().getAnnotations();
    assertEquals(1, annotations.size());
    PDAnnotation getResult = annotations.get(0);
    assertTrue(getResult instanceof PDAnnotationWidget);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations2 = iteratorResult2.next().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult2 = annotations2.get(0);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertEquals(page, getResult.getPage());
    assertEquals(page, getResult2.getPage());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'")
  void testAddSignatureWithSigObject2() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    annotations.add(pdAnnotationCaret);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationCaret);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationCaret, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'")
  void testAddSignatureWithSigObject3() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());
    annotations.add(pdAnnotationCaret);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature());

    // Assert
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations2 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(1);
    PDPage page2 = getResult.getPage();
    assertTrue(page2.getContentsForRandomAccess() instanceof RandomAccessReadBuffer);
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations3 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationUnknown);
    assertTrue(getResult instanceof PDAnnotationWidget);
    PDAppearanceStream normalAppearanceStream = getResult.getNormalAppearanceStream();
    assertNull(normalAppearanceStream.getResources());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertEquals(-1, page2.getContents().read(new byte[]{}));
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertFalse(page2.getContentStreams().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertEquals(pdAnnotationCaret, getResult2);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'")
  void testAddSignatureWithSigObject4() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    annotations.add(pdAnnotationCircle);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationCircle);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationCircle, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'")
  void testAddSignatureWithSigObject5() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    annotations.add(pdAnnotationFileAttachment);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationFileAttachment);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationFileAttachment, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'")
  void testAddSignatureWithSigObject6() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight();
    annotations.add(pdAnnotationHighlight);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationHighlight);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationHighlight, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'")
  void testAddSignatureWithSigObject7() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    annotations.add(pdAnnotationInk);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationInk);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationInk, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with
   * {@code sigObject}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'")
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
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations = iteratorResult.next().getAnnotations();
    assertEquals(1, annotations.size());
    PDAnnotation getResult = annotations.get(0);
    assertTrue(getResult instanceof PDAnnotationWidget);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations2 = iteratorResult2.next().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult2 = annotations2.get(0);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertEquals(page, getResult.getPage());
    assertEquals(page, getResult2.getPage());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with
   * {@code sigObject}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'")
  void testAddSignatureWithSigObjectOptions2() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    annotations.add(pdAnnotationCaret);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationCaret);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isNoRotate());
    assertFalse(getResult2.isNoView());
    assertFalse(getResult2.isNoZoom());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationCaret, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with
   * {@code sigObject}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'")
  void testAddSignatureWithSigObjectOptions3() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());
    annotations.add(pdAnnotationCaret);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationUnknown);
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    PDAppearanceStream normalAppearanceStream = getResult2.getNormalAppearanceStream();
    assertNull(normalAppearanceStream.getResources());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertFalse(iteratorResult.hasNext());
    assertEquals(pdAnnotationCaret, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with
   * {@code sigObject}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'")
  void testAddSignatureWithSigObjectOptions4() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    annotations.add(pdAnnotationCircle);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationCircle);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isNoRotate());
    assertFalse(getResult2.isNoView());
    assertFalse(getResult2.isNoZoom());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationCircle, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with
   * {@code sigObject}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'")
  void testAddSignatureWithSigObjectOptions5() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    annotations.add(pdAnnotationFileAttachment);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationFileAttachment);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isNoRotate());
    assertFalse(getResult2.isNoView());
    assertFalse(getResult2.isNoZoom());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationFileAttachment, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with
   * {@code sigObject}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'")
  void testAddSignatureWithSigObjectOptions6() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight();
    annotations.add(pdAnnotationHighlight);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();

    // Act
    pdDocument.addSignature(sigObject, new SignatureOptions());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationHighlight);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isNoRotate());
    assertFalse(getResult2.isNoView());
    assertFalse(getResult2.isNoZoom());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationHighlight, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with
   * {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given ArrayList() add 'null'")
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
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations2 = iteratorResult.next().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationWidget);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult2.next().getAnnotations();
    assertEquals(1, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertEquals(page, getResult.getPage());
    assertEquals(page, getResult2.getPage());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with
   * {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; given three; then throw IllegalStateException")
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
   * Test {@link PDDocument#addSignature(PDSignature, SignatureOptions)} with
   * {@code sigObject}, {@code options}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureOptions) with 'sigObject', 'options'; then throw IllegalStateException")
  void testAddSignatureWithSigObjectOptions_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDSignature sigObject = new PDSignature();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(sigObject, new SignatureOptions()));
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with
   * {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  void testAddSignatureWithSigObjectSignatureInterface() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature(), mock(SignatureInterface.class));

    // Assert
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations = iteratorResult.next().getAnnotations();
    assertEquals(1, annotations.size());
    PDAnnotation getResult = annotations.get(0);
    assertTrue(getResult instanceof PDAnnotationWidget);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations2 = iteratorResult2.next().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult2 = annotations2.get(0);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertEquals(page, getResult.getPage());
    assertEquals(page, getResult2.getPage());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with
   * {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  void testAddSignatureWithSigObjectSignatureInterface2() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    annotations.add(pdAnnotationCaret);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature(), mock(SignatureInterface.class));

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationCaret);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationCaret, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with
   * {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  void testAddSignatureWithSigObjectSignatureInterface3() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());
    annotations.add(pdAnnotationCaret);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature(), mock(SignatureInterface.class));

    // Assert
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations2 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(1);
    PDPage page2 = getResult.getPage();
    assertTrue(page2.getContentsForRandomAccess() instanceof RandomAccessReadBuffer);
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations3 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationUnknown);
    assertTrue(getResult instanceof PDAnnotationWidget);
    PDAppearanceStream normalAppearanceStream = getResult.getNormalAppearanceStream();
    assertNull(normalAppearanceStream.getResources());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertEquals(-1, page2.getContents().read(new byte[]{}));
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertFalse(page2.getContentStreams().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertEquals(pdAnnotationCaret, getResult2);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with
   * {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  void testAddSignatureWithSigObjectSignatureInterface4() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    annotations.add(pdAnnotationCircle);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature(), mock(SignatureInterface.class));

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationCircle);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationCircle, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with
   * {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  void testAddSignatureWithSigObjectSignatureInterface5() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    annotations.add(pdAnnotationFileAttachment);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature(), mock(SignatureInterface.class));

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationFileAttachment);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationFileAttachment, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with
   * {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  void testAddSignatureWithSigObjectSignatureInterface6() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight();
    annotations.add(pdAnnotationHighlight);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature(), mock(SignatureInterface.class));

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationHighlight);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationHighlight, getResult);
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with
   * {@code sigObject}, {@code signatureInterface}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'")
  void testAddSignatureWithSigObjectSignatureInterface7() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    annotations.add(pdAnnotationInk);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature(), mock(SignatureInterface.class));

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationInk);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationInk, getResult);
  }

  /**
   * Test
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   * with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
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
   * Test
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   * with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  void testAddSignatureWithSigObjectSignatureInterfaceOptions2() throws IOException {
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
   * Test
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   * with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  void testAddSignatureWithSigObjectSignatureInterfaceOptions3() throws IOException {
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
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations = iteratorResult.next().getAnnotations();
    assertEquals(1, annotations.size());
    PDAnnotation getResult = annotations.get(0);
    assertTrue(getResult instanceof PDAnnotationWidget);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations2 = iteratorResult2.next().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult2 = annotations2.get(0);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertEquals(page, getResult.getPage());
    assertEquals(page, getResult2.getPage());
  }

  /**
   * Test
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   * with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  void testAddSignatureWithSigObjectSignatureInterfaceOptions4() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    annotations.add(pdAnnotationCaret);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationCaret);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isNoRotate());
    assertFalse(getResult2.isNoView());
    assertFalse(getResult2.isNoZoom());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationCaret, getResult);
  }

  /**
   * Test
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   * with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  void testAddSignatureWithSigObjectSignatureInterfaceOptions5() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());
    annotations.add(pdAnnotationCaret);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationUnknown);
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    PDAppearanceStream normalAppearanceStream = getResult2.getNormalAppearanceStream();
    assertNull(normalAppearanceStream.getResources());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertFalse(iteratorResult.hasNext());
    assertEquals(pdAnnotationCaret, getResult);
  }

  /**
   * Test
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   * with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  void testAddSignatureWithSigObjectSignatureInterfaceOptions6() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    annotations.add(pdAnnotationCircle);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationCircle);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isNoRotate());
    assertFalse(getResult2.isNoView());
    assertFalse(getResult2.isNoZoom());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationCircle, getResult);
  }

  /**
   * Test
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   * with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  void testAddSignatureWithSigObjectSignatureInterfaceOptions7() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    annotations.add(pdAnnotationFileAttachment);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationFileAttachment);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isNoRotate());
    assertFalse(getResult2.isNoView());
    assertFalse(getResult2.isNoZoom());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationFileAttachment, getResult);
  }

  /**
   * Test
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   * with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'")
  void testAddSignatureWithSigObjectSignatureInterfaceOptions8() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight();
    annotations.add(pdAnnotationHighlight);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act
    pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Assert
    List<PDSignatureField> signatureFields = pdDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    List<PDAnnotationWidget> widgets = signatureFields.get(0).getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationHighlight);
    Iterator<PDPage> iteratorResult = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult.next().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(1);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isNoRotate());
    assertFalse(getResult2.isNoView());
    assertFalse(getResult2.isNoZoom());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult2.isToggleNoView());
    assertTrue(getResult2.isPrinted());
    assertEquals(pdAnnotationHighlight, getResult);
  }

  /**
   * Test
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   * with {@code sigObject}, {@code signatureInterface}, {@code options}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface, SignatureOptions) with 'sigObject', 'signatureInterface', 'options'; given ArrayList() add 'null'")
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
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations2 = iteratorResult.next().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationWidget);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult2.next().getAnnotations();
    assertEquals(1, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertEquals(page, getResult.getPage());
    assertEquals(page, getResult2.getPage());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with
   * {@code sigObject}, {@code signatureInterface}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'; given ArrayList() add 'null'")
  void testAddSignatureWithSigObjectSignatureInterface_givenArrayListAddNull() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature(), mock(SignatureInterface.class));

    // Assert
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations2 = iteratorResult.next().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationWidget);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult2.next().getAnnotations();
    assertEquals(1, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertEquals(page, getResult.getPage());
    assertEquals(page, getResult2.getPage());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature, SignatureInterface)} with
   * {@code sigObject}, {@code signatureInterface}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature, SignatureInterface) with 'sigObject', 'signatureInterface'; then throw IllegalStateException")
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
  void testAddSignatureWithSigObject_givenArrayListAddNull() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdDocument.addSignature(new PDSignature());

    // Assert
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    List<PDAnnotation> annotations2 = iteratorResult.next().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult = annotations2.get(0);
    assertTrue(getResult instanceof PDAnnotationWidget);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    List<PDAnnotation> annotations3 = iteratorResult2.next().getAnnotations();
    assertEquals(1, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertEquals(page, getResult.getPage());
    assertEquals(page, getResult2.getPage());
  }

  /**
   * Test {@link PDDocument#addSignature(PDSignature)} with {@code sigObject}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addSignature
   * {@link PDSignature#PDSignature()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test addSignature(PDSignature) with 'sigObject'; given PDDocument() addSignature PDSignature()")
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
  void testAddSignatureWithSigObject_givenPDDocument_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(new PDSignature()));
  }

  /**
   * Test {@link PDDocument#removePage(int)} with {@code pageNumber}.
   * <p>
   * Method under test: {@link PDDocument#removePage(int)}
   */
  @Test
  @DisplayName("Test removePage(int) with 'pageNumber'")
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName("Test removePage(PDPage) with 'page'; given COSDictionary getCOSArray(COSName) return COSArray()")
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName)} return
   * one.</li>
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName("Test removePage(PDPage) with 'page'; given COSDictionary getInt(COSName) return one; then calls setInt(COSName, int)")
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
   *   <li>Then calls {@link StreamCacheCreateFunction#create()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  @DisplayName("Test removePage(PDPage) with 'page'; then calls create()")
  void testRemovePageWithPage_thenCallsCreate() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
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
    verify(streamCacheCreateFunction).create();
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
   * Test {@link PDDocument#importPage(PDPage)}.
   * <p>
   * Method under test: {@link PDDocument#importPage(PDPage)}
   */
  @Test
  @DisplayName("Test importPage(PDPage)")
  void testImportPage() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(0L)));
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    // Act
    pdDocument.importPage(new PDPage());

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, nextResult.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult2.getContents().read(new byte[]{}));
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(8, contentStreams.next().getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(8, contentStreams2.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
  }

  /**
   * Test {@link PDDocument#importPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.</li>
   *   <li>When {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#importPage(PDPage)}
   */
  @Test
  @DisplayName("Test importPage(PDPage); given A0; when PDPage() CropBox is A0")
  void testImportPage_givenA0_whenPDPageCropBoxIsA0() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    // Act
    pdDocument.importPage(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, nextResult.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult2.getContents().read(new byte[]{}));
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(8, contentStreams.next().getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(8, contentStreams2.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
  }

  /**
   * Test {@link PDDocument#importPage(PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#importPage(PDPage)}
   */
  @Test
  @DisplayName("Test importPage(PDPage); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  void testImportPage_givenArrayListAddPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    pdDocument.importPage(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, nextResult.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult2.getContents().read(new byte[]{}));
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(8, contentStreams.next().getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(8, contentStreams2.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
  }

  /**
   * Test {@link PDDocument#importPage(PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#importPage(PDPage)}
   */
  @Test
  @DisplayName("Test importPage(PDPage); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  void testImportPage_givenArrayListAddPDStreamWithDocumentIsCOSDocument2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    pdDocument.importPage(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, nextResult.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult2.getContents().read(new byte[]{}));
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(8, contentStreams.next().getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(8, contentStreams2.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
  }

  /**
   * Test {@link PDDocument#importPage(PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link PDPage#PDPage()} Contents is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#importPage(PDPage)}
   */
  @Test
  @DisplayName("Test importPage(PDPage); given ArrayList(); when PDPage() Contents is ArrayList()")
  void testImportPage_givenArrayList_whenPDPageContentsIsArrayList() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    // Act
    pdDocument.importPage(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, nextResult.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult2.getContents().read(new byte[]{}));
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(8, contentStreams.next().getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(8, contentStreams2.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
  }

  /**
   * Test {@link PDDocument#importPage(PDPage)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PDPage#PDPage()} Rotation is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#importPage(PDPage)}
   */
  @Test
  @DisplayName("Test importPage(PDPage); given one; when PDPage() Rotation is one")
  void testImportPage_givenOne_whenPDPageRotationIsOne() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setRotation(1);

    // Act
    pdDocument.importPage(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, nextResult.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult2.getContents().read(new byte[]{}));
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(8, contentStreams.next().getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(8, contentStreams2.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
  }

  /**
   * Test {@link PDDocument#importPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#importPage(PDPage)}
   */
  @Test
  @DisplayName("Test importPage(PDPage); given PDStream(COSDocument) with document is COSDocument()")
  void testImportPage_givenPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    PDPage actualImportPageResult = pdDocument.importPage(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = actualImportPageResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[1];
    assertEquals(1, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[1];
    assertEquals(1, nextResult2.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[1];
    assertEquals(1, actualImportPageResult.getContents().read(byteArray3));
    assertEquals(1, contentsForRandomAccess.available());
    assertEquals(1, contentsForRandomAccess2.available());
    assertEquals(1, contentsForRandomAccess3.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(9, contentStreams.next().getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(9, contentStreams2.next().getLength());
    Iterator<PDStream> contentStreams3 = actualImportPageResult.getContentStreams();
    PDStream nextResult3 = contentStreams3.next();
    assertEquals(9, nextResult3.getLength());
    assertEquals(9L, nextResult3.getCOSObject().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(contentStreams3.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(new byte[]{'\n'}, byteArray3);
    assertArrayEquals(new byte[]{'\n'}, byteArray2);
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Test {@link PDDocument#importPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()} Filters is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#importPage(PDPage)}
   */
  @Test
  @DisplayName("Test importPage(PDPage); given PDStream(COSDocument) with document is COSDocument() Filters is ArrayList()")
  void testImportPage_givenPDStreamWithDocumentIsCOSDocumentFiltersIsArrayList() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(new ArrayList<>());

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    PDPage actualImportPageResult = pdDocument.importPage(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = actualImportPageResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    byte[] byteArray = new byte[1];
    assertEquals(1, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[1];
    assertEquals(1, nextResult2.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[1];
    assertEquals(1, actualImportPageResult.getContents().read(byteArray3));
    assertEquals(1, contentsForRandomAccess.available());
    assertEquals(1, contentsForRandomAccess2.available());
    assertEquals(1, contentsForRandomAccess3.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(9, contentStreams.next().getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(9, contentStreams2.next().getLength());
    Iterator<PDStream> contentStreams3 = actualImportPageResult.getContentStreams();
    PDStream nextResult3 = contentStreams3.next();
    assertEquals(9, nextResult3.getLength());
    assertEquals(9L, nextResult3.getCOSObject().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(contentStreams3.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertArrayEquals(new byte[]{'\n'}, byteArray3);
    assertArrayEquals(new byte[]{'\n'}, byteArray2);
    assertArrayEquals(new byte[]{'\n'}, byteArray);
  }

  /**
   * Test {@link PDDocument#importPage(PDPage)}.
   * <ul>
   *   <li>Given {@link StreamCacheCreateFunction}
   * {@link StreamCacheCreateFunction#create()} return {@code null}.</li>
   *   <li>When {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#importPage(PDPage)}
   */
  @Test
  @DisplayName("Test importPage(PDPage); given StreamCacheCreateFunction create() return 'null'; when PDPage()")
  void testImportPage_givenStreamCacheCreateFunctionCreateReturnNull_whenPDPage() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    // Act
    pdDocument.importPage(new PDPage());

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, nextResult.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult2.getContents().read(new byte[]{}));
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(8, contentStreams.next().getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(8, contentStreams2.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
  }

  /**
   * Test {@link PDDocument#importPage(PDPage)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link PDPage#PDPage()} Rotation is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#importPage(PDPage)}
   */
  @Test
  @DisplayName("Test importPage(PDPage); given zero; when PDPage() Rotation is zero")
  void testImportPage_givenZero_whenPDPageRotationIsZero() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setRotation(0);

    // Act
    pdDocument.importPage(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, nextResult.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult2.getContents().read(new byte[]{}));
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    Iterator<PDStream> contentStreams = nextResult.getContentStreams();
    assertEquals(8, contentStreams.next().getLength());
    Iterator<PDStream> contentStreams2 = nextResult2.getContentStreams();
    assertEquals(8, contentStreams2.next().getLength());
    assertFalse(contentStreams.hasNext());
    assertFalse(contentStreams2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
  }

  /**
   * Test {@link PDDocument#importPage(PDPage)}.
   * <ul>
   *   <li>Then ArtBox COSArray toList third return {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#importPage(PDPage)}
   */
  @Test
  @DisplayName("Test importPage(PDPage); then ArtBox COSArray toList third return COSFloat")
  void testImportPage_thenArtBoxCOSArrayToListThirdReturnCOSFloat() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDPage actualImportPageResult = pdDocument.importPage(page);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDRectangle artBox = actualImportPageResult.getArtBox();
    List<? extends COSBase> toListResult = artBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    List<? extends COSBase> toListResult2 = actualImportPageResult.getMediaBox().getCOSArray().toList();
    assertEquals(4, toListResult2.size());
    COSBase getResult4 = toListResult2.get(0);
    assertTrue(getResult4 instanceof COSFloat);
    COSBase getResult5 = toListResult2.get(1);
    assertTrue(getResult5 instanceof COSFloat);
    COSBase getResult6 = toListResult2.get(2);
    assertTrue(getResult6 instanceof COSFloat);
    COSBase getResult7 = toListResult2.get(3);
    assertTrue(getResult7 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult4.getKey());
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    PDRectangle artBox2 = nextResult.getArtBox();
    assertEquals(0.0f, artBox2.getHeight());
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult2 = iteratorResult2.next();
    PDRectangle artBox3 = nextResult2.getArtBox();
    assertEquals(0.0f, artBox3.getHeight());
    assertEquals(0.0f, artBox.getHeight());
    PDRectangle bBox = nextResult.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bBox2 = nextResult2.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    PDRectangle bBox3 = actualImportPageResult.getBBox();
    assertEquals(0.0f, bBox3.getHeight());
    PDRectangle bleedBox = nextResult.getBleedBox();
    assertEquals(0.0f, bleedBox.getHeight());
    PDRectangle bleedBox2 = nextResult2.getBleedBox();
    assertEquals(0.0f, bleedBox2.getHeight());
    PDRectangle bleedBox3 = actualImportPageResult.getBleedBox();
    assertEquals(0.0f, bleedBox3.getHeight());
    PDRectangle cropBox = nextResult.getCropBox();
    assertEquals(0.0f, cropBox.getHeight());
    PDRectangle cropBox2 = nextResult2.getCropBox();
    assertEquals(0.0f, cropBox2.getHeight());
    PDRectangle cropBox3 = actualImportPageResult.getCropBox();
    assertEquals(0.0f, cropBox3.getHeight());
    assertEquals(0.0f, artBox2.getWidth());
    assertEquals(0.0f, artBox3.getWidth());
    assertEquals(0.0f, artBox.getWidth());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(0.0f, bleedBox.getWidth());
    assertEquals(0.0f, bleedBox2.getWidth());
    assertEquals(0.0f, bleedBox3.getWidth());
    assertEquals(0.0f, cropBox.getWidth());
    assertEquals(0.0f, cropBox2.getWidth());
    assertEquals(0.0f, cropBox3.getWidth());
    assertEquals(612.0f, artBox2.getLowerLeftX());
    assertEquals(612.0f, artBox3.getLowerLeftX());
    assertEquals(612.0f, artBox.getLowerLeftX());
    assertEquals(612.0f, bBox.getLowerLeftX());
    assertEquals(612.0f, bBox2.getLowerLeftX());
    assertEquals(612.0f, bBox3.getLowerLeftX());
    assertEquals(612.0f, bleedBox.getLowerLeftX());
    assertEquals(612.0f, bleedBox2.getLowerLeftX());
    assertEquals(612.0f, bleedBox3.getLowerLeftX());
    assertEquals(612.0f, cropBox.getLowerLeftX());
    assertEquals(612.0f, cropBox2.getLowerLeftX());
    assertEquals(612.0f, cropBox3.getLowerLeftX());
    assertEquals(792.0f, artBox2.getLowerLeftY());
    assertEquals(792.0f, artBox3.getLowerLeftY());
    assertEquals(792.0f, artBox.getLowerLeftY());
    assertEquals(792.0f, bBox.getLowerLeftY());
    assertEquals(792.0f, bBox2.getLowerLeftY());
    assertEquals(792.0f, bBox3.getLowerLeftY());
    assertEquals(792.0f, bleedBox.getLowerLeftY());
    assertEquals(792.0f, bleedBox2.getLowerLeftY());
    assertEquals(792.0f, bleedBox3.getLowerLeftY());
    assertEquals(792.0f, cropBox.getLowerLeftY());
    assertEquals(792.0f, cropBox2.getLowerLeftY());
    assertEquals(792.0f, cropBox3.getLowerLeftY());
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult4.isDirect());
    COSBase getResult8 = toListResult.get(0);
    assertEquals(getResult8, getResult2);
    assertEquals(getResult8, getResult6);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult7);
    assertEquals(getResult4, getResult5);
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
   *   <li>Then {@link PDDocument#PDDocument()} Document Trailer Values size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDDocument#setDocumentInformation(PDDocumentInformation)}
   */
  @Test
  @DisplayName("Test setDocumentInformation(PDDocumentInformation); then PDDocument() Document Trailer Values size is one")
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
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given COSDocument() Trailer is COSDictionary()")
  void testIsEncrypted_givenCOSDocumentTrailerIsCOSDictionary() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertFalse((new PDDocument(doc)).isEncrypted());
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
  void testIsEncrypted_givenPDDocument() {
    // Arrange, Act and Assert
    assertFalse((new PDDocument()).isEncrypted());
  }

  /**
   * Test {@link PDDocument#isEncrypted()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument(COSDocument)} with doc is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given PDDocument(COSDocument) with doc is COSDocument()")
  void testIsEncrypted_givenPDDocumentWithDocIsCOSDocument() {
    // Arrange, Act and Assert
    assertFalse((new PDDocument(new COSDocument())).isEncrypted());
  }

  /**
   * Test {@link PDDocument#getEncryption()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getEncryption()}
   */
  @Test
  @DisplayName("Test getEncryption(); given COSDocument() Trailer is COSDictionary(); then return 'null'")
  void testGetEncryption_givenCOSDocumentTrailerIsCOSDictionary_thenReturnNull() {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act and Assert
    assertNull((new PDDocument(doc)).getEncryption());
  }

  /**
   * Test {@link PDDocument#getEncryption()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument(COSDocument)} with doc is
   * {@link COSDocument#COSDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getEncryption()}
   */
  @Test
  @DisplayName("Test getEncryption(); given PDDocument(COSDocument) with doc is COSDocument(); then return 'null'")
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
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  @DisplayName("Test getLastSignatureDictionary(); given COSDocument() Trailer is COSDictionary()")
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
   *   <li>Given {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  @DisplayName("Test getLastSignatureDictionary(); given PDDocument() addPage PDPage(); then return 'null'")
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
  void testGetLastSignatureDictionary_givenPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocument()).getLastSignatureDictionary());
  }

  /**
   * Test {@link PDDocument#getSignatureFields()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  @DisplayName("Test getSignatureFields(); given COSDocument() Trailer is COSDictionary(); then return Empty")
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
   *   <li>Given {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  @DisplayName("Test getSignatureFields(); given PDDocument() addPage PDPage(); then return Empty")
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
  void testGetSignatureFields_givenPDDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDDocument()).getSignatureFields().isEmpty());
  }

  /**
   * Test {@link PDDocument#getSignatureDictionaries()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  @DisplayName("Test getSignatureDictionaries(); given COSDocument() Trailer is COSDictionary()")
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
   *   <li>Given {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  @DisplayName("Test getSignatureDictionaries(); given PDDocument() addPage PDPage(); then return Empty")
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
  void testGetSignatureDictionaries_givenPDDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDDocument()).getSignatureDictionaries().isEmpty());
  }

  /**
   * Test {@link PDDocument#save(OutputStream)} with {@code output}.
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'output'")
  void testSaveWithOutput() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output);

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(467, toByteArrayResult.length);
    assertEquals(4L, pdDocument.getDocument().getHighestXRefObjectNumber());
    assertEquals('%', toByteArrayResult[461]);
    assertEquals('%', toByteArrayResult[462]);
    assertEquals('2', toByteArrayResult[457]);
    assertEquals('2', toByteArrayResult[458]);
    assertEquals('6', toByteArrayResult[459]);
    assertEquals('E', toByteArrayResult[463]);
    assertEquals('F', toByteArrayResult[465]);
    assertEquals('O', toByteArrayResult[464]);
    assertEquals('\n', toByteArrayResult[446]);
    assertEquals('\n', toByteArrayResult[456]);
    assertEquals('\n', toByteArrayResult[460]);
    assertEquals('\n', toByteArrayResult[466]);
    assertEquals('a', toByteArrayResult[449]);
    assertEquals('b', toByteArrayResult[444]);
    assertEquals('d', toByteArrayResult[442]);
    assertEquals('e', toByteArrayResult[454]);
    assertEquals('f', toByteArrayResult[455]);
    assertEquals('j', toByteArrayResult[445]);
    assertEquals('o', toByteArrayResult[443]);
    assertEquals('r', toByteArrayResult[450]);
    assertEquals('r', toByteArrayResult[453]);
    assertEquals('s', toByteArrayResult[447]);
    assertEquals('t', toByteArrayResult[448]);
    assertEquals('t', toByteArrayResult[451]);
    assertEquals('x', toByteArrayResult[452]);
  }

  /**
   * Test {@link PDDocument#save(OutputStream)} with {@code output}.
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'output'")
  void testSaveWithOutput2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.setDocumentInformation(new PDDocumentInformation());
    pdDocument.addPage(new PDPage());
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSObjectKey key = pdDocument.getDocumentInformation().getCOSObject().getKey();
    assertEquals(-1, key.getStreamIndex());
    assertEquals(0, key.getGeneration());
    assertEquals(262144L, key.getInternalHash());
    assertEquals(4L, key.getNumber());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(546, toByteArrayResult.length);
    assertEquals('%', toByteArrayResult[540]);
    assertEquals('%', toByteArrayResult[541]);
    assertEquals('2', toByteArrayResult[536]);
    assertEquals('5', toByteArrayResult[538]);
    assertEquals('8', toByteArrayResult[537]);
    assertEquals('E', toByteArrayResult[542]);
    assertEquals('F', toByteArrayResult[544]);
    assertEquals('O', toByteArrayResult[543]);
    assertEquals('\n', toByteArrayResult[525]);
    assertEquals('\n', toByteArrayResult[535]);
    assertEquals('\n', toByteArrayResult[539]);
    assertEquals('\n', toByteArrayResult[545]);
    assertEquals('a', toByteArrayResult[528]);
    assertEquals('b', toByteArrayResult[523]);
    assertEquals('d', toByteArrayResult[521]);
    assertEquals('e', toByteArrayResult[533]);
    assertEquals('f', toByteArrayResult[534]);
    assertEquals('j', toByteArrayResult[524]);
    assertEquals('o', toByteArrayResult[522]);
    assertEquals('r', toByteArrayResult[529]);
    assertEquals('r', toByteArrayResult[532]);
    assertEquals('s', toByteArrayResult[526]);
    assertEquals('t', toByteArrayResult[527]);
    assertEquals('t', toByteArrayResult[530]);
    assertEquals('x', toByteArrayResult[531]);
  }

  /**
   * Test {@link PDDocument#save(OutputStream)} with {@code output}.
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'output'")
  void testSaveWithOutput3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.setAllSecurityToBeRemoved(true);
    pdDocument.addPage(new PDPage());
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output);

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(522, toByteArrayResult.length);
    assertEquals(5L, pdDocument.getDocument().getHighestXRefObjectNumber());
    assertEquals('%', toByteArrayResult[516]);
    assertEquals('%', toByteArrayResult[517]);
    assertEquals('2', toByteArrayResult[512]);
    assertEquals('6', toByteArrayResult[514]);
    assertEquals('7', toByteArrayResult[513]);
    assertEquals('E', toByteArrayResult[518]);
    assertEquals('F', toByteArrayResult[520]);
    assertEquals('O', toByteArrayResult[519]);
    assertEquals('\n', toByteArrayResult[501]);
    assertEquals('\n', toByteArrayResult[511]);
    assertEquals('\n', toByteArrayResult[515]);
    assertEquals('\n', toByteArrayResult[521]);
    assertEquals('a', toByteArrayResult[504]);
    assertEquals('b', toByteArrayResult[499]);
    assertEquals('d', toByteArrayResult[497]);
    assertEquals('e', toByteArrayResult[509]);
    assertEquals('f', toByteArrayResult[510]);
    assertEquals('j', toByteArrayResult[500]);
    assertEquals('o', toByteArrayResult[498]);
    assertEquals('r', toByteArrayResult[505]);
    assertEquals('r', toByteArrayResult[508]);
    assertEquals('s', toByteArrayResult[502]);
    assertEquals('t', toByteArrayResult[503]);
    assertEquals('t', toByteArrayResult[506]);
    assertEquals('x', toByteArrayResult[507]);
  }

  /**
   * Test {@link PDDocument#save(OutputStream, CompressParameters)} with
   * {@code output}, {@code compressParameters}.
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test save(OutputStream, CompressParameters) with 'output', 'compressParameters'")
  void testSaveWithOutputCompressParameters() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output, CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    COSDocument document = pdDocument.getDocument();
    List<? extends COSBase> toListResult = document.getDocumentID().toList();
    assertEquals(2, toListResult.size());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(467, toByteArrayResult.length);
    assertEquals(4L, document.getHighestXRefObjectNumber());
    assertEquals('%', toByteArrayResult[461]);
    assertEquals('%', toByteArrayResult[462]);
    assertEquals('2', toByteArrayResult[457]);
    assertEquals('2', toByteArrayResult[458]);
    assertEquals('6', toByteArrayResult[459]);
    assertEquals('E', toByteArrayResult[463]);
    assertEquals('F', toByteArrayResult[465]);
    assertEquals('O', toByteArrayResult[464]);
    assertEquals('\n', toByteArrayResult[446]);
    assertEquals('\n', toByteArrayResult[456]);
    assertEquals('\n', toByteArrayResult[460]);
    assertEquals('\n', toByteArrayResult[466]);
    assertEquals('a', toByteArrayResult[449]);
    assertEquals('b', toByteArrayResult[444]);
    assertEquals('d', toByteArrayResult[442]);
    assertEquals('e', toByteArrayResult[454]);
    assertEquals('f', toByteArrayResult[455]);
    assertEquals('j', toByteArrayResult[445]);
    assertEquals('o', toByteArrayResult[443]);
    assertEquals('r', toByteArrayResult[450]);
    assertEquals('r', toByteArrayResult[453]);
    assertEquals('s', toByteArrayResult[447]);
    assertEquals('t', toByteArrayResult[448]);
    assertEquals('t', toByteArrayResult[451]);
    assertEquals('x', toByteArrayResult[452]);
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDDocument#save(OutputStream, CompressParameters)} with
   * {@code output}, {@code compressParameters}.
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test save(OutputStream, CompressParameters) with 'output', 'compressParameters'")
  void testSaveWithOutputCompressParameters2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output, CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(467, toByteArrayResult.length);
    assertEquals(4L, pdDocument.getDocument().getHighestXRefObjectNumber());
    assertEquals('%', toByteArrayResult[461]);
    assertEquals('%', toByteArrayResult[462]);
    assertEquals('2', toByteArrayResult[457]);
    assertEquals('2', toByteArrayResult[458]);
    assertEquals('6', toByteArrayResult[459]);
    assertEquals('E', toByteArrayResult[463]);
    assertEquals('F', toByteArrayResult[465]);
    assertEquals('O', toByteArrayResult[464]);
    assertEquals('\n', toByteArrayResult[446]);
    assertEquals('\n', toByteArrayResult[456]);
    assertEquals('\n', toByteArrayResult[460]);
    assertEquals('\n', toByteArrayResult[466]);
    assertEquals('a', toByteArrayResult[449]);
    assertEquals('b', toByteArrayResult[444]);
    assertEquals('d', toByteArrayResult[442]);
    assertEquals('e', toByteArrayResult[454]);
    assertEquals('f', toByteArrayResult[455]);
    assertEquals('j', toByteArrayResult[445]);
    assertEquals('o', toByteArrayResult[443]);
    assertEquals('r', toByteArrayResult[450]);
    assertEquals('r', toByteArrayResult[453]);
    assertEquals('s', toByteArrayResult[447]);
    assertEquals('t', toByteArrayResult[448]);
    assertEquals('t', toByteArrayResult[451]);
    assertEquals('x', toByteArrayResult[452]);
  }

  /**
   * Test {@link PDDocument#save(OutputStream, CompressParameters)} with
   * {@code output}, {@code compressParameters}.
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test save(OutputStream, CompressParameters) with 'output', 'compressParameters'")
  void testSaveWithOutputCompressParameters3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.setDocumentInformation(new PDDocumentInformation());
    pdDocument.addPage(new PDPage());
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output, CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSObjectKey key = pdDocument.getDocumentInformation().getCOSObject().getKey();
    assertEquals(-1, key.getStreamIndex());
    assertEquals(0, key.getGeneration());
    assertEquals(262144L, key.getInternalHash());
    assertEquals(4L, key.getNumber());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(546, toByteArrayResult.length);
    assertEquals('%', toByteArrayResult[540]);
    assertEquals('%', toByteArrayResult[541]);
    assertEquals('2', toByteArrayResult[536]);
    assertEquals('5', toByteArrayResult[538]);
    assertEquals('8', toByteArrayResult[537]);
    assertEquals('E', toByteArrayResult[542]);
    assertEquals('F', toByteArrayResult[544]);
    assertEquals('O', toByteArrayResult[543]);
    assertEquals('\n', toByteArrayResult[525]);
    assertEquals('\n', toByteArrayResult[535]);
    assertEquals('\n', toByteArrayResult[539]);
    assertEquals('\n', toByteArrayResult[545]);
    assertEquals('a', toByteArrayResult[528]);
    assertEquals('b', toByteArrayResult[523]);
    assertEquals('d', toByteArrayResult[521]);
    assertEquals('e', toByteArrayResult[533]);
    assertEquals('f', toByteArrayResult[534]);
    assertEquals('j', toByteArrayResult[524]);
    assertEquals('o', toByteArrayResult[522]);
    assertEquals('r', toByteArrayResult[529]);
    assertEquals('r', toByteArrayResult[532]);
    assertEquals('s', toByteArrayResult[526]);
    assertEquals('t', toByteArrayResult[527]);
    assertEquals('t', toByteArrayResult[530]);
    assertEquals('x', toByteArrayResult[531]);
  }

  /**
   * Test {@link PDDocument#save(OutputStream, CompressParameters)} with
   * {@code output}, {@code compressParameters}.
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test save(OutputStream, CompressParameters) with 'output', 'compressParameters'")
  void testSaveWithOutputCompressParameters4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.setAllSecurityToBeRemoved(true);
    pdDocument.addPage(new PDPage());
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output, CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(522, toByteArrayResult.length);
    assertEquals(5L, pdDocument.getDocument().getHighestXRefObjectNumber());
    assertEquals('%', toByteArrayResult[516]);
    assertEquals('%', toByteArrayResult[517]);
    assertEquals('2', toByteArrayResult[512]);
    assertEquals('6', toByteArrayResult[514]);
    assertEquals('7', toByteArrayResult[513]);
    assertEquals('E', toByteArrayResult[518]);
    assertEquals('F', toByteArrayResult[520]);
    assertEquals('O', toByteArrayResult[519]);
    assertEquals('\n', toByteArrayResult[501]);
    assertEquals('\n', toByteArrayResult[511]);
    assertEquals('\n', toByteArrayResult[515]);
    assertEquals('\n', toByteArrayResult[521]);
    assertEquals('a', toByteArrayResult[504]);
    assertEquals('b', toByteArrayResult[499]);
    assertEquals('d', toByteArrayResult[497]);
    assertEquals('e', toByteArrayResult[509]);
    assertEquals('f', toByteArrayResult[510]);
    assertEquals('j', toByteArrayResult[500]);
    assertEquals('o', toByteArrayResult[498]);
    assertEquals('r', toByteArrayResult[505]);
    assertEquals('r', toByteArrayResult[508]);
    assertEquals('s', toByteArrayResult[502]);
    assertEquals('t', toByteArrayResult[503]);
    assertEquals('t', toByteArrayResult[506]);
    assertEquals('x', toByteArrayResult[507]);
  }

  /**
   * Test {@link PDDocument#save(OutputStream, CompressParameters)} with
   * {@code output}, {@code compressParameters}.
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test save(OutputStream, CompressParameters) with 'output', 'compressParameters'")
  void testSaveWithOutputCompressParameters5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output, null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(2L, pdDocument.getDocument().getHighestXRefObjectNumber());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(329, toByteArrayResult.length);
    assertEquals('%', toByteArrayResult[323]);
    assertEquals('%', toByteArrayResult[324]);
    assertEquals('0', toByteArrayResult[321]);
    assertEquals('1', toByteArrayResult[319]);
    assertEquals('3', toByteArrayResult[304]);
    assertEquals('3', toByteArrayResult[320]);
    assertEquals('4', toByteArrayResult[7]);
    assertEquals('>', toByteArrayResult[306]);
    assertEquals('>', toByteArrayResult[307]);
    assertEquals('E', toByteArrayResult[325]);
    assertEquals('F', toByteArrayResult[327]);
    assertEquals('O', toByteArrayResult[326]);
    assertEquals('\n', toByteArrayResult[305]);
    assertEquals('\n', toByteArrayResult[308]);
    assertEquals('\n', toByteArrayResult[318]);
    assertEquals('\n', toByteArrayResult[322]);
    assertEquals('\n', toByteArrayResult[328]);
    assertEquals('a', toByteArrayResult[311]);
    assertEquals('e', toByteArrayResult[316]);
    assertEquals('f', toByteArrayResult[317]);
    assertEquals('r', toByteArrayResult[312]);
    assertEquals('r', toByteArrayResult[315]);
    assertEquals('s', toByteArrayResult[309]);
    assertEquals('t', toByteArrayResult[310]);
    assertEquals('t', toByteArrayResult[313]);
    assertEquals('x', toByteArrayResult[314]);
  }

  /**
   * Test {@link PDDocument#save(OutputStream, CompressParameters)} with
   * {@code output}, {@code compressParameters}.
   * <ul>
   *   <li>Then array length is five hundred twenty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test save(OutputStream, CompressParameters) with 'output', 'compressParameters'; then array length is five hundred twenty-two")
  void testSaveWithOutputCompressParameters_thenArrayLengthIsFiveHundredTwentyTwo() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.addPage(new PDPage());
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output, CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(522, toByteArrayResult.length);
    assertEquals(5L, pdDocument.getDocument().getHighestXRefObjectNumber());
    assertEquals('%', toByteArrayResult[516]);
    assertEquals('%', toByteArrayResult[517]);
    assertEquals('2', toByteArrayResult[512]);
    assertEquals('6', toByteArrayResult[514]);
    assertEquals('7', toByteArrayResult[513]);
    assertEquals('E', toByteArrayResult[518]);
    assertEquals('F', toByteArrayResult[520]);
    assertEquals('O', toByteArrayResult[519]);
    assertEquals('\n', toByteArrayResult[501]);
    assertEquals('\n', toByteArrayResult[511]);
    assertEquals('\n', toByteArrayResult[515]);
    assertEquals('\n', toByteArrayResult[521]);
    assertEquals('a', toByteArrayResult[504]);
    assertEquals('b', toByteArrayResult[499]);
    assertEquals('d', toByteArrayResult[497]);
    assertEquals('e', toByteArrayResult[509]);
    assertEquals('f', toByteArrayResult[510]);
    assertEquals('j', toByteArrayResult[500]);
    assertEquals('o', toByteArrayResult[498]);
    assertEquals('r', toByteArrayResult[505]);
    assertEquals('r', toByteArrayResult[508]);
    assertEquals('s', toByteArrayResult[502]);
    assertEquals('t', toByteArrayResult[503]);
    assertEquals('t', toByteArrayResult[506]);
    assertEquals('x', toByteArrayResult[507]);
  }

  /**
   * Test {@link PDDocument#save(OutputStream, CompressParameters)} with
   * {@code output}, {@code compressParameters}.
   * <ul>
   *   <li>When {@link CompressParameters#NO_COMPRESSION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test save(OutputStream, CompressParameters) with 'output', 'compressParameters'; when NO_COMPRESSION")
  void testSaveWithOutputCompressParameters_whenNo_compression() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output, CompressParameters.NO_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(2L, pdDocument.getDocument().getHighestXRefObjectNumber());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(329, toByteArrayResult.length);
    assertEquals('%', toByteArrayResult[323]);
    assertEquals('%', toByteArrayResult[324]);
    assertEquals('0', toByteArrayResult[321]);
    assertEquals('1', toByteArrayResult[319]);
    assertEquals('3', toByteArrayResult[304]);
    assertEquals('3', toByteArrayResult[320]);
    assertEquals('4', toByteArrayResult[7]);
    assertEquals('>', toByteArrayResult[306]);
    assertEquals('>', toByteArrayResult[307]);
    assertEquals('E', toByteArrayResult[325]);
    assertEquals('F', toByteArrayResult[327]);
    assertEquals('O', toByteArrayResult[326]);
    assertEquals('\n', toByteArrayResult[305]);
    assertEquals('\n', toByteArrayResult[308]);
    assertEquals('\n', toByteArrayResult[318]);
    assertEquals('\n', toByteArrayResult[322]);
    assertEquals('\n', toByteArrayResult[328]);
    assertEquals('a', toByteArrayResult[311]);
    assertEquals('e', toByteArrayResult[316]);
    assertEquals('f', toByteArrayResult[317]);
    assertEquals('r', toByteArrayResult[312]);
    assertEquals('r', toByteArrayResult[315]);
    assertEquals('s', toByteArrayResult[309]);
    assertEquals('t', toByteArrayResult[310]);
    assertEquals('t', toByteArrayResult[313]);
    assertEquals('x', toByteArrayResult[314]);
  }

  /**
   * Test {@link PDDocument#save(OutputStream)} with {@code output}.
   * <ul>
   *   <li>Given {@link StreamCacheCreateFunction}
   * {@link StreamCacheCreateFunction#create()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'output'; given StreamCacheCreateFunction create() return 'null'")
  void testSaveWithOutput_givenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output);

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(467, toByteArrayResult.length);
    assertEquals(4L, pdDocument.getDocument().getHighestXRefObjectNumber());
    assertEquals('%', toByteArrayResult[461]);
    assertEquals('%', toByteArrayResult[462]);
    assertEquals('2', toByteArrayResult[457]);
    assertEquals('2', toByteArrayResult[458]);
    assertEquals('6', toByteArrayResult[459]);
    assertEquals('E', toByteArrayResult[463]);
    assertEquals('F', toByteArrayResult[465]);
    assertEquals('O', toByteArrayResult[464]);
    assertEquals('\n', toByteArrayResult[446]);
    assertEquals('\n', toByteArrayResult[456]);
    assertEquals('\n', toByteArrayResult[460]);
    assertEquals('\n', toByteArrayResult[466]);
    assertEquals('a', toByteArrayResult[449]);
    assertEquals('b', toByteArrayResult[444]);
    assertEquals('d', toByteArrayResult[442]);
    assertEquals('e', toByteArrayResult[454]);
    assertEquals('f', toByteArrayResult[455]);
    assertEquals('j', toByteArrayResult[445]);
    assertEquals('o', toByteArrayResult[443]);
    assertEquals('r', toByteArrayResult[450]);
    assertEquals('r', toByteArrayResult[453]);
    assertEquals('s', toByteArrayResult[447]);
    assertEquals('t', toByteArrayResult[448]);
    assertEquals('t', toByteArrayResult[451]);
    assertEquals('x', toByteArrayResult[452]);
  }

  /**
   * Test {@link PDDocument#save(OutputStream)} with {@code output}.
   * <ul>
   *   <li>Then array length is five hundred twenty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'output'; then array length is five hundred twenty-two")
  void testSaveWithOutput_thenArrayLengthIsFiveHundredTwentyTwo() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.addPage(new PDPage());
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output);

    // Assert
    verify(streamCacheCreateFunction).create();
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(522, toByteArrayResult.length);
    assertEquals(5L, pdDocument.getDocument().getHighestXRefObjectNumber());
    assertEquals('%', toByteArrayResult[516]);
    assertEquals('%', toByteArrayResult[517]);
    assertEquals('2', toByteArrayResult[512]);
    assertEquals('6', toByteArrayResult[514]);
    assertEquals('7', toByteArrayResult[513]);
    assertEquals('E', toByteArrayResult[518]);
    assertEquals('F', toByteArrayResult[520]);
    assertEquals('O', toByteArrayResult[519]);
    assertEquals('\n', toByteArrayResult[501]);
    assertEquals('\n', toByteArrayResult[511]);
    assertEquals('\n', toByteArrayResult[515]);
    assertEquals('\n', toByteArrayResult[521]);
    assertEquals('a', toByteArrayResult[504]);
    assertEquals('b', toByteArrayResult[499]);
    assertEquals('d', toByteArrayResult[497]);
    assertEquals('e', toByteArrayResult[509]);
    assertEquals('f', toByteArrayResult[510]);
    assertEquals('j', toByteArrayResult[500]);
    assertEquals('o', toByteArrayResult[498]);
    assertEquals('r', toByteArrayResult[505]);
    assertEquals('r', toByteArrayResult[508]);
    assertEquals('s', toByteArrayResult[502]);
    assertEquals('t', toByteArrayResult[503]);
    assertEquals('t', toByteArrayResult[506]);
    assertEquals('x', toByteArrayResult[507]);
  }

  /**
   * Test {@link PDDocument#save(OutputStream)} with {@code output}.
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} Document DocumentID toList size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'output'; then PDDocument() Document DocumentID toList size is two")
  void testSaveWithOutput_thenPDDocumentDocumentDocumentIDToListSizeIsTwo() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output);

    // Assert
    COSDocument document = pdDocument.getDocument();
    List<? extends COSBase> toListResult = document.getDocumentID().toList();
    assertEquals(2, toListResult.size());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(467, toByteArrayResult.length);
    assertEquals(4L, document.getHighestXRefObjectNumber());
    assertEquals('%', toByteArrayResult[461]);
    assertEquals('%', toByteArrayResult[462]);
    assertEquals('2', toByteArrayResult[457]);
    assertEquals('2', toByteArrayResult[458]);
    assertEquals('6', toByteArrayResult[459]);
    assertEquals('E', toByteArrayResult[463]);
    assertEquals('F', toByteArrayResult[465]);
    assertEquals('O', toByteArrayResult[464]);
    assertEquals('\n', toByteArrayResult[446]);
    assertEquals('\n', toByteArrayResult[456]);
    assertEquals('\n', toByteArrayResult[460]);
    assertEquals('\n', toByteArrayResult[466]);
    assertEquals('a', toByteArrayResult[449]);
    assertEquals('b', toByteArrayResult[444]);
    assertEquals('d', toByteArrayResult[442]);
    assertEquals('e', toByteArrayResult[454]);
    assertEquals('f', toByteArrayResult[455]);
    assertEquals('j', toByteArrayResult[445]);
    assertEquals('o', toByteArrayResult[443]);
    assertEquals('r', toByteArrayResult[450]);
    assertEquals('r', toByteArrayResult[453]);
    assertEquals('s', toByteArrayResult[447]);
    assertEquals('t', toByteArrayResult[448]);
    assertEquals('t', toByteArrayResult[451]);
    assertEquals('x', toByteArrayResult[452]);
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDDocument#saveIncremental(OutputStream)} with {@code output}.
   * <p>
   * Method under test: {@link PDDocument#saveIncremental(OutputStream)}
   */
  @Test
  @DisplayName("Test saveIncremental(OutputStream) with 'output'")
  void testSaveIncrementalWithOutput() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.saveIncremental(new ByteArrayOutputStream(1)));
  }

  /**
   * Test {@link PDDocument#saveIncremental(OutputStream, Set)} with
   * {@code output}, {@code objectsToWrite}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  @DisplayName("Test saveIncremental(OutputStream, Set) with 'output', 'objectsToWrite'; given COSDictionary()")
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
   * Test {@link PDDocument#saveIncremental(OutputStream, Set)} with
   * {@code output}, {@code objectsToWrite}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  @DisplayName("Test saveIncremental(OutputStream, Set) with 'output', 'objectsToWrite'; given COSDictionary()")
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
   * Test {@link PDDocument#saveIncremental(OutputStream, Set)} with
   * {@code output}, {@code objectsToWrite}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  @DisplayName("Test saveIncremental(OutputStream, Set) with 'output', 'objectsToWrite'; when HashSet()")
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
   * Method under test:
   * {@link PDDocument#saveIncrementalForExternalSigning(OutputStream)}
   */
  @Test
  @DisplayName("Test saveIncrementalForExternalSigning(OutputStream)")
  void testSaveIncrementalForExternalSigning() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdDocument.saveIncrementalForExternalSigning(new ByteArrayOutputStream(1)));
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   * <p>
   * Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int)")
  void testGetPage() throws IOException {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSArray cosArray = mock(COSArray.class);
    COSDictionary cosDictionary = new COSDictionary();
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
    PDDocument pdDocument = new PDDocument(doc);

    // Act
    PDPage actualPage = pdDocument.getPage(1);

    // Assert
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(cosDictionary2).getCOSArray(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    PDPage nextResult2 = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess2 = nextResult2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    PDPage nextResult3 = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess3 = nextResult3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    Iterator<PDPage> iteratorResult2 = pdDocument.getDocumentCatalog().getPages().iterator();
    PDPage nextResult4 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess4 = nextResult4.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDPage nextResult5 = iteratorResult2.next();
    RandomAccessRead contentsForRandomAccess5 = nextResult5.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess5 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = nextResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing2 = nextResult2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing3 = nextResult3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing4 = nextResult4.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing5 = nextResult5.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing5 instanceof RandomAccessReadBuffer);
    assertNull(nextResult.getViewports());
    assertNull(nextResult2.getViewports());
    assertNull(nextResult3.getViewports());
    assertNull(nextResult4.getViewports());
    assertNull(nextResult5.getViewports());
    assertNull(nextResult.getResources());
    assertNull(nextResult2.getResources());
    assertNull(nextResult3.getResources());
    assertNull(nextResult4.getResources());
    assertNull(nextResult5.getResources());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult2.getMetadata());
    assertNull(nextResult3.getMetadata());
    assertNull(nextResult4.getMetadata());
    assertNull(nextResult5.getMetadata());
    assertNull(nextResult.getTrimBox());
    assertNull(nextResult2.getTrimBox());
    assertNull(nextResult3.getTrimBox());
    assertNull(nextResult4.getTrimBox());
    assertNull(nextResult5.getTrimBox());
    PDPageAdditionalActions actions = nextResult.getActions();
    assertNull(actions.getC());
    PDPageAdditionalActions actions2 = nextResult2.getActions();
    assertNull(actions2.getC());
    PDPageAdditionalActions actions3 = nextResult3.getActions();
    assertNull(actions3.getC());
    PDPageAdditionalActions actions4 = nextResult4.getActions();
    assertNull(actions4.getC());
    PDPageAdditionalActions actions5 = nextResult5.getActions();
    assertNull(actions5.getC());
    assertNull(actions.getO());
    assertNull(actions2.getO());
    assertNull(actions3.getO());
    assertNull(actions4.getO());
    assertNull(actions5.getO());
    assertNull(nextResult.getTransition());
    assertNull(nextResult2.getTransition());
    assertNull(nextResult3.getTransition());
    assertNull(nextResult4.getTransition());
    assertNull(nextResult5.getTransition());
    assertEquals(-1, nextResult.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult2.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult3.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult4.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult5.getContents().read(new byte[]{}));
    assertEquals(-1, nextResult.getStructParents());
    assertEquals(-1, nextResult2.getStructParents());
    assertEquals(-1, nextResult3.getStructParents());
    assertEquals(-1, nextResult4.getStructParents());
    assertEquals(-1, nextResult5.getStructParents());
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    assertEquals(0, contentsForRandomAccess3.available());
    assertEquals(0, contentsForRandomAccess4.available());
    assertEquals(0, contentsForRandomAccess5.available());
    assertEquals(0, contentsForStreamParsing.available());
    assertEquals(0, contentsForStreamParsing2.available());
    assertEquals(0, contentsForStreamParsing3.available());
    assertEquals(0, contentsForStreamParsing4.available());
    assertEquals(0, contentsForStreamParsing5.available());
    assertEquals(0, nextResult.getRotation());
    assertEquals(0, nextResult2.getRotation());
    assertEquals(0, nextResult3.getRotation());
    assertEquals(0, nextResult4.getRotation());
    assertEquals(0, nextResult5.getRotation());
    Matrix matrix = nextResult.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    Matrix matrix2 = nextResult2.getMatrix();
    assertEquals(0.0f, matrix2.getShearX());
    Matrix matrix3 = nextResult3.getMatrix();
    assertEquals(0.0f, matrix3.getShearX());
    Matrix matrix4 = nextResult4.getMatrix();
    assertEquals(0.0f, matrix4.getShearX());
    Matrix matrix5 = nextResult5.getMatrix();
    assertEquals(0.0f, matrix5.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix2.getShearY());
    assertEquals(0.0f, matrix3.getShearY());
    assertEquals(0.0f, matrix4.getShearY());
    assertEquals(0.0f, matrix5.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix2.getTranslateX());
    assertEquals(0.0f, matrix3.getTranslateX());
    assertEquals(0.0f, matrix4.getTranslateX());
    assertEquals(0.0f, matrix5.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0.0f, matrix2.getTranslateY());
    assertEquals(0.0f, matrix3.getTranslateY());
    assertEquals(0.0f, matrix4.getTranslateY());
    assertEquals(0.0f, matrix5.getTranslateY());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForRandomAccess2.getPosition());
    assertEquals(0L, contentsForRandomAccess3.getPosition());
    assertEquals(0L, contentsForRandomAccess4.getPosition());
    assertEquals(0L, contentsForRandomAccess5.getPosition());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(0L, contentsForStreamParsing3.getPosition());
    assertEquals(0L, contentsForStreamParsing4.getPosition());
    assertEquals(0L, contentsForStreamParsing5.getPosition());
    assertEquals(1.0f, nextResult.getUserUnit());
    assertEquals(1.0f, nextResult2.getUserUnit());
    assertEquals(1.0f, nextResult3.getUserUnit());
    assertEquals(1.0f, nextResult4.getUserUnit());
    assertEquals(1.0f, nextResult5.getUserUnit());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix2.getScaleX());
    assertEquals(1.0f, matrix3.getScaleX());
    assertEquals(1.0f, matrix4.getScaleX());
    assertEquals(1.0f, matrix5.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix2.getScaleY());
    assertEquals(1.0f, matrix3.getScaleY());
    assertEquals(1.0f, matrix4.getScaleY());
    assertEquals(1.0f, matrix5.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix2.getScalingFactorX());
    assertEquals(1.0f, matrix3.getScalingFactorX());
    assertEquals(1.0f, matrix4.getScalingFactorX());
    assertEquals(1.0f, matrix5.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(1.0f, matrix2.getScalingFactorY());
    assertEquals(1.0f, matrix3.getScalingFactorY());
    assertEquals(1.0f, matrix4.getScalingFactorY());
    assertEquals(1.0f, matrix5.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    float[][] values2 = matrix2.getValues();
    assertEquals(3, values2.length);
    float[][] values3 = matrix3.getValues();
    assertEquals(3, values3.length);
    float[][] values4 = matrix4.getValues();
    assertEquals(3, values4.length);
    float[][] values5 = matrix5.getValues();
    assertEquals(3, values5.length);
    assertFalse(nextResult.getContentStreams().hasNext());
    assertFalse(nextResult2.getContentStreams().hasNext());
    assertFalse(nextResult3.getContentStreams().hasNext());
    assertFalse(nextResult4.getContentStreams().hasNext());
    assertFalse(nextResult5.getContentStreams().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForRandomAccess2.isClosed());
    assertFalse(contentsForRandomAccess3.isClosed());
    assertFalse(contentsForRandomAccess4.isClosed());
    assertFalse(contentsForRandomAccess5.isClosed());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(contentsForStreamParsing3.isClosed());
    assertFalse(contentsForStreamParsing4.isClosed());
    assertFalse(contentsForStreamParsing5.isClosed());
    assertFalse(nextResult.hasContents());
    assertFalse(nextResult2.hasContents());
    assertFalse(nextResult3.hasContents());
    assertFalse(nextResult4.hasContents());
    assertFalse(nextResult5.hasContents());
    assertTrue(iteratorResult2.hasNext());
    assertTrue(nextResult.getAnnotations().isEmpty());
    assertTrue(nextResult2.getAnnotations().isEmpty());
    assertTrue(nextResult3.getAnnotations().isEmpty());
    assertTrue(nextResult4.getAnnotations().isEmpty());
    assertTrue(nextResult5.getAnnotations().isEmpty());
    assertTrue(nextResult.getThreadBeads().isEmpty());
    assertTrue(nextResult2.getThreadBeads().isEmpty());
    assertTrue(nextResult3.getThreadBeads().isEmpty());
    assertTrue(nextResult4.getThreadBeads().isEmpty());
    assertTrue(nextResult5.getThreadBeads().isEmpty());
    assertSame(cosDictionary, nextResult.getCOSObject());
    assertSame(cosDictionary, nextResult2.getCOSObject());
    assertSame(cosDictionary, nextResult3.getCOSObject());
    assertSame(cosDictionary, nextResult4.getCOSObject());
    assertSame(cosDictionary, nextResult5.getCOSObject());
    assertSame(cosDictionary, actualPage.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values2[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values3[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values4[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values5[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values2[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values3[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values4[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values5[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values2[0], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values3[0], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values4[0], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values5[0], 0.0f);
  }

  /**
   * Test {@link PDDocument#getPage(int)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * throw {@link IllegalStateException#IllegalStateException(String)} with
   * {@code Page}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); given COSDictionary getCOSArray(COSName) throw IllegalStateException(String) with 'Page'")
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * throw {@link IllegalStateException#IllegalStateException(String)} with
   * {@code Page}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); given COSDictionary getInt(COSName, int) throw IllegalStateException(String) with 'Page'")
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
   *   <li>Given {@link COSDocument} {@link COSDocument#getTrailer()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); given COSDocument getTrailer() throw IllegalStateException(String) with 'foo'")
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
   *   <li>Given {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); given PDDocument() addPage PDPage(); when one; then return PDPage()")
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
   *   <li>Then return ArtBox COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); then return ArtBox COSArray toList size is four")
  void testGetPage_thenReturnArtBoxCOSArrayToListSizeIsFour() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(null);
    doNothing().when(cosArray).set(anyInt(), Mockito.<COSBase>any());
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

    // Act
    PDPage actualPage = (new PDDocument(doc)).getPage(1);

    // Assert
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).set(anyInt(), Mockito.<COSBase>any());
    verify(cosArray).size();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    PDRectangle artBox = actualPage.getArtBox();
    COSArray cOSArray = artBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertTrue(artBox instanceof PDImmutableRectangle);
    COSDictionary cOSObject = actualPage.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualPage.getActions().getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
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
    assertEquals(toListResult.get(0), getResult);
    assertSame(cOSArray, artBox.getCOSObject());
    assertSame(artBox, actualPage.getBBox());
    assertSame(artBox, actualPage.getBleedBox());
    assertSame(artBox, actualPage.getCropBox());
    assertSame(artBox, actualPage.getMediaBox());
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)}
   * return {@link COSName#A}.</li>
   *   <li>Then return Count is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given COSDictionary getCOSName(COSName) return A; then return Count is zero")
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)}
   * throw {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given COSDictionary getCOSName(COSName) throw IllegalStateException(String) with 'foo'")
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
   *   <li>Given {@link COSDocument} {@link COSDocument#getTrailer()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getPages()}
   */
  @Test
  @DisplayName("Test getPages(); given COSDocument getTrailer() throw IllegalStateException(String) with 'foo'")
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
   *   <li>Given {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getNumberOfPages()}
   */
  @Test
  @DisplayName("Test getNumberOfPages(); given PDDocument() addPage PDPage(); then return one")
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
  void testGetNumberOfPages_givenPDDocument_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDDocument()).getNumberOfPages());
  }

  /**
   * Test {@link PDDocument#close()}.
   * <p>
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  @DisplayName("Test close()")
  void testClose() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create())
        .thenReturn(new ScratchFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile()));

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.save(new ByteArrayOutputStream(3), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    pdDocument.close();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdDocument.getDocument().isClosed());
  }

  /**
   * Test {@link PDDocument#close()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument(StreamCacheCreateFunction)} with
   * {@link StreamCacheCreateFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given PDDocument(StreamCacheCreateFunction) with StreamCacheCreateFunction")
  void testClose_givenPDDocumentWithStreamCacheCreateFunction() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    // Act
    pdDocument.close();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdDocument.getDocument().isClosed());
  }

  /**
   * Test {@link PDDocument#close()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument(StreamCacheCreateFunction)} with
   * {@link StreamCacheCreateFunction} addPage {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given PDDocument(StreamCacheCreateFunction) with StreamCacheCreateFunction addPage PDPage()")
  void testClose_givenPDDocumentWithStreamCacheCreateFunctionAddPagePDPage() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.addPage(new PDPage());
    pdDocument.addSignature(new PDSignature());

    // Act
    pdDocument.close();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdDocument.getDocument().isClosed());
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
  void testClose_givenPDDocument_thenPDDocumentDocumentClosed() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act
    pdDocument.close();

    // Assert
    assertTrue(pdDocument.getDocument().isClosed());
  }

  /**
   * Test {@link PDDocument#close()}.
   * <ul>
   *   <li>Given {@link StreamCacheCreateFunction}
   * {@link StreamCacheCreateFunction#create()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given StreamCacheCreateFunction create() return 'null'")
  void testClose_givenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.save(new ByteArrayOutputStream(3), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    pdDocument.close();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdDocument.getDocument().isClosed());
  }

  /**
   * Test {@link PDDocument#close()}.
   * <ul>
   *   <li>Given {@link StreamCacheCreateFunction}
   * {@link StreamCacheCreateFunction#create()} return
   * {@link RandomAccessStreamCacheImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given StreamCacheCreateFunction create() return RandomAccessStreamCacheImpl (default constructor)")
  void testClose_givenStreamCacheCreateFunctionCreateReturnRandomAccessStreamCacheImpl() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.save(new ByteArrayOutputStream(3), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    pdDocument.close();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdDocument.getDocument().isClosed());
  }

  /**
   * Test {@link PDDocument#getVersion()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code 1.4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given COSDocument() Trailer is COSDictionary(); then return '1.4'")
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
   *   <li>Given {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code 1.4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDDocument() addPage PDPage(); then return '1.4'")
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
  void testGetVersion_givenPDDocument_thenReturn14() {
    // Arrange, Act and Assert
    assertEquals(1.4f, (new PDDocument()).getVersion());
  }

  /**
   * Test {@link PDDocument#setVersion(float)}.
   * <p>
   * Method under test: {@link PDDocument#setVersion(float)}
   */
  @Test
  @DisplayName("Test setVersion(float)")
  void testSetVersion() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    // Act
    pdDocument.setVersion(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("10.0", pdDocument.getDocumentCatalog().getVersion());
    assertEquals(10.0f, pdDocument.getVersion());
  }

  /**
   * Test {@link PDDocument#setVersion(float)}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()}.</li>
   *   <li>When ten.</li>
   *   <li>Then {@link PDDocument#PDDocument()} DocumentCatalog Version is
   * {@code 10.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#setVersion(float)}
   */
  @Test
  @DisplayName("Test setVersion(float); given PDDocument(); when ten; then PDDocument() DocumentCatalog Version is '10.0'")
  void testSetVersion_givenPDDocument_whenTen_thenPDDocumentDocumentCatalogVersionIs100() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act
    pdDocument.setVersion(10.0f);

    // Assert
    assertEquals("10.0", pdDocument.getDocumentCatalog().getVersion());
    assertEquals(10.0f, pdDocument.getVersion());
  }

  /**
   * Test {@link PDDocument#setVersion(float)}.
   * <ul>
   *   <li>When {@code 1.4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#setVersion(float)}
   */
  @Test
  @DisplayName("Test setVersion(float); when '1.4'")
  void testSetVersion_when14() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    // Act
    pdDocument.setVersion(1.4f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("1.4", pdDocument.getDocumentCatalog().getVersion());
    assertEquals(1.4f, pdDocument.getVersion());
  }

  /**
   * Test {@link PDDocument#setVersion(float)}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocument#setVersion(float)}
   */
  @Test
  @DisplayName("Test setVersion(float); when minus one")
  void testSetVersion_whenMinusOne() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    // Act
    pdDocument.setVersion(-1.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("1.4", pdDocument.getDocumentCatalog().getVersion());
    assertEquals(1.4f, pdDocument.getVersion());
  }
}
