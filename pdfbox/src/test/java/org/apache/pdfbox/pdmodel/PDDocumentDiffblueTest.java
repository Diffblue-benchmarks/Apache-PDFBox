package org.apache.pdfbox.pdmodel;

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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.PDEncryption;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentDiffblueTest {
  /**
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  void testAddPage() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
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
    verify(streamCacheCreateFunction).create();
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  void testAddPage2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
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
    verify(streamCacheCreateFunction).create();
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  void testAddPage3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
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
    verify(streamCacheCreateFunction).create();
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  void testAddPage4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
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
    verify(streamCacheCreateFunction).create();
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  void testAddPage5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
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
    verify(streamCacheCreateFunction).create();
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  void testAddPage6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
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
    verify(streamCacheCreateFunction).create();
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  void testAddPage7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

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
    verify(streamCacheCreateFunction).create();
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  void testAddPage8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
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
    verify(streamCacheCreateFunction).create();
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDDocument#addPage(PDPage)}
   */
  @Test
  void testAddPage9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
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
    verify(streamCacheCreateFunction).create();
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDDocument#addSignature(PDSignature)}
   */
  @Test
  void testAddSignature() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(new PDSignature()));
  }

  /**
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface)}
   */
  @Test
  void testAddSignature2() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdDocument.addSignature(new PDSignature(), mock(SignatureInterface.class)));
  }

  /**
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  void testAddSignature3() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdDocument.addSignature(sigObject, signatureInterface, new SignatureOptions()));
  }

  /**
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureInterface, SignatureOptions)}
   */
  @Test
  void testAddSignature4() throws IOException {
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
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  void testAddSignature5() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    PDSignature sigObject = new PDSignature();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(sigObject, new SignatureOptions()));
  }

  /**
   * Method under test:
   * {@link PDDocument#addSignature(PDSignature, SignatureOptions)}
   */
  @Test
  void testAddSignature6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    PDSignature sigObject = new PDSignature();

    SignatureOptions options = new SignatureOptions();
    options.setPreferredSignatureSize(3);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.addSignature(sigObject, options));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  void testRemovePage() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
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
    verify(streamCacheCreateFunction).create();
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  void testRemovePage2() throws IOException {
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
   * Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  void testRemovePage3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
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
    verify(streamCacheCreateFunction).create();
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDDocument#removePage(PDPage)}
   */
  @Test
  void testRemovePage4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
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
   * Method under test: {@link PDDocument#getDocumentInformation()}
   */
  @Test
  void testGetDocumentInformation() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    PDDocumentInformation info = new PDDocumentInformation();
    pdDocument.setDocumentInformation(info);

    // Act
    PDDocumentInformation actualDocumentInformation = pdDocument.getDocumentInformation();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(info, actualDocumentInformation);
  }

  /**
   * Method under test:
   * {@link PDDocument#setDocumentInformation(PDDocumentInformation)}
   */
  @Test
  void testSetDocumentInformation() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    PDDocumentInformation info = mock(PDDocumentInformation.class);
    when(info.getCOSObject()).thenReturn(null);

    // Act
    pdDocument.setDocumentInformation(info);

    // Assert
    verify(streamCacheCreateFunction).create();
    verify(info).getCOSObject();
    COSDictionary trailer = pdDocument.getDocument().getTrailer();
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, trailer.size());
    assertSame(info, pdDocument.getDocumentInformation());
  }

  /**
   * Method under test: {@link PDDocument#isEncrypted()}
   */
  @Test
  void testIsEncrypted() {
    // Arrange, Act and Assert
    assertFalse((new PDDocument()).isEncrypted());
    assertFalse((new PDDocument(new COSDocument())).isEncrypted());
  }

  /**
   * Method under test: {@link PDDocument#isEncrypted()}
   */
  @Test
  void testIsEncrypted2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsEncryptedResult = (new PDDocument(streamCacheCreateFunction)).isEncrypted();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsEncryptedResult);
  }

  /**
   * Method under test: {@link PDDocument#getEncryption()}
   */
  @Test
  void testGetEncryption() {
    // Arrange, Act and Assert
    assertNull((new PDDocument()).getEncryption());
    assertNull((new PDDocument(new COSDocument())).getEncryption());
  }

  /**
   * Method under test: {@link PDDocument#getEncryption()}
   */
  @Test
  void testGetEncryption2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDEncryption actualEncryption = (new PDDocument(streamCacheCreateFunction)).getEncryption();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualEncryption);
  }

  /**
   * Method under test: {@link PDDocument#getEncryption()}
   */
  @Test
  void testGetEncryption3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    PDEncryption encryption = new PDEncryption();
    pdDocument.setEncryptionDictionary(encryption);

    // Act
    PDEncryption actualEncryption = pdDocument.getEncryption();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(encryption, actualEncryption);
  }

  /**
   * Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  void testGetLastSignatureDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDDocument()).getLastSignatureDictionary());
  }

  /**
   * Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  void testGetLastSignatureDictionary2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDSignature actualLastSignatureDictionary = (new PDDocument(streamCacheCreateFunction))
        .getLastSignatureDictionary();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualLastSignatureDictionary);
  }

  /**
   * Method under test: {@link PDDocument#getLastSignatureDictionary()}
   */
  @Test
  void testGetLastSignatureDictionary3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.addPage(new PDPage());

    // Act
    PDSignature actualLastSignatureDictionary = pdDocument.getLastSignatureDictionary();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualLastSignatureDictionary);
  }

  /**
   * Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  void testGetSignatureFields() {
    // Arrange, Act and Assert
    assertTrue((new PDDocument()).getSignatureFields().isEmpty());
  }

  /**
   * Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  void testGetSignatureFields2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<PDSignatureField> actualSignatureFields = (new PDDocument(streamCacheCreateFunction)).getSignatureFields();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualSignatureFields.isEmpty());
  }

  /**
   * Method under test: {@link PDDocument#getSignatureFields()}
   */
  @Test
  void testGetSignatureFields3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.addPage(new PDPage());

    // Act
    List<PDSignatureField> actualSignatureFields = pdDocument.getSignatureFields();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualSignatureFields.isEmpty());
  }

  /**
   * Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  void testGetSignatureDictionaries() {
    // Arrange, Act and Assert
    assertTrue((new PDDocument()).getSignatureDictionaries().isEmpty());
  }

  /**
   * Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  void testGetSignatureDictionaries2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<PDSignature> actualSignatureDictionaries = (new PDDocument(streamCacheCreateFunction))
        .getSignatureDictionaries();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualSignatureDictionaries.isEmpty());
  }

  /**
   * Method under test: {@link PDDocument#getSignatureDictionaries()}
   */
  @Test
  void testGetSignatureDictionaries3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.addPage(new PDPage());

    // Act
    List<PDSignature> actualSignatureDictionaries = pdDocument.getSignatureDictionaries();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualSignatureDictionaries.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDDocument#registerTrueTypeFontForClosing(TrueTypeFont)}
   */
  @Test
  void testRegisterTrueTypeFontForClosing() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    (new PDDocument(streamCacheCreateFunction)).registerTrueTypeFontForClosing(null);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDDocument#save(OutputStream)}
   */
  @Test
  void testSave() throws IOException {
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
    COSDocument document = pdDocument.getDocument();
    List<? extends COSBase> toListResult = document.getDocumentID().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    PDDocumentCatalog documentCatalog = pdDocument.getDocumentCatalog();
    assertEquals("1.6", documentCatalog.getVersion());
    assertNull(document.getEncryptionDictionary());
    assertNull(getResult.getKey());
    assertNull(pdDocument.getDocumentInformation().getCOSObject().getKey());
    assertNull(pdDocument.getEncryption());
    COSObjectKey key = documentCatalog.getCOSObject().getKey();
    assertEquals(-1, key.getStreamIndex());
    PDPageTree pages = pdDocument.getPages();
    COSObjectKey key2 = pages.getCOSObject().getKey();
    assertEquals(-1, key2.getStreamIndex());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -10, toByteArrayResult[10]);
    assertEquals((byte) -28, toByteArrayResult[11]);
    assertEquals((byte) -33, toByteArrayResult[13]);
    assertEquals((byte) -4, toByteArrayResult[12]);
    assertEquals(0, key.getGeneration());
    assertEquals(0, key2.getGeneration());
    assertEquals(1.6f, document.getVersion());
    assertEquals(1.6f, pdDocument.getVersion());
    assertEquals(131072L, key2.getInternalHash());
    assertEquals(1L, key.getNumber());
    assertEquals(2L, key2.getNumber());
    COSDictionary trailer = document.getTrailer();
    assertEquals(3, trailer.getValues().size());
    assertEquals(3, trailer.size());
    assertEquals(467, toByteArrayResult.length);
    assertEquals(4L, document.getHighestXRefObjectNumber());
    assertEquals(65536L, key.getInternalHash());
    assertFalse(pages.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(document.isEncrypted());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertFalse(pdDocument.isEncrypted());
    assertTrue(document.isXRefStream());
    assertEquals(Short.SIZE, ((COSString) getResult).getBytes().length);
    assertEquals(' ', toByteArrayResult[18]);
    assertEquals(' ', toByteArrayResult[Short.SIZE]);
    assertEquals('%', toByteArrayResult[0]);
    assertEquals('%', toByteArrayResult[461]);
    assertEquals('%', toByteArrayResult[462]);
    assertEquals('%', toByteArrayResult[9]);
    assertEquals('-', toByteArrayResult[4]);
    assertEquals('.', toByteArrayResult[6]);
    assertEquals('0', toByteArrayResult[17]);
    assertEquals('1', toByteArrayResult[15]);
    assertEquals('1', toByteArrayResult[5]);
    assertEquals('2', toByteArrayResult[457]);
    assertEquals('2', toByteArrayResult[458]);
    assertEquals('6', toByteArrayResult[459]);
    assertEquals('6', toByteArrayResult[7]);
    assertEquals('<', toByteArrayResult[23]);
    assertEquals('<', toByteArrayResult[24]);
    assertEquals('D', toByteArrayResult[2]);
    assertEquals('E', toByteArrayResult[463]);
    assertEquals('F', toByteArrayResult[3]);
    assertEquals('F', toByteArrayResult[465]);
    assertEquals('O', toByteArrayResult[464]);
    assertEquals('P', toByteArrayResult[1]);
    assertEquals('\n', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[22]);
    assertEquals('\n', toByteArrayResult[446]);
    assertEquals('\n', toByteArrayResult[456]);
    assertEquals('\n', toByteArrayResult[460]);
    assertEquals('\n', toByteArrayResult[466]);
    assertEquals('\n', toByteArrayResult[8]);
    assertEquals('a', toByteArrayResult[449]);
    assertEquals('b', toByteArrayResult[20]);
    assertEquals('b', toByteArrayResult[444]);
    assertEquals('d', toByteArrayResult[442]);
    assertEquals('e', toByteArrayResult[454]);
    assertEquals('f', toByteArrayResult[455]);
    assertEquals('j', toByteArrayResult[21]);
    assertEquals('j', toByteArrayResult[445]);
    assertEquals('o', toByteArrayResult[19]);
    assertEquals('o', toByteArrayResult[443]);
    assertEquals('r', toByteArrayResult[450]);
    assertEquals('r', toByteArrayResult[453]);
    assertEquals('s', toByteArrayResult[447]);
    assertEquals('t', toByteArrayResult[448]);
    assertEquals('t', toByteArrayResult[451]);
    assertEquals('x', toByteArrayResult[452]);
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Method under test: {@link PDDocument#save(OutputStream)}
   */
  @Test
  void testSave2() throws IOException {
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
    COSDocument document = pdDocument.getDocument();
    List<? extends COSBase> toListResult = document.getDocumentID().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    PDDocumentCatalog documentCatalog = pdDocument.getDocumentCatalog();
    assertEquals("1.6", documentCatalog.getVersion());
    assertNull(document.getEncryptionDictionary());
    assertNull(getResult.getKey());
    assertNull(pdDocument.getDocumentInformation().getCOSObject().getKey());
    assertNull(pdDocument.getEncryption());
    COSObjectKey key = documentCatalog.getCOSObject().getKey();
    assertEquals(-1, key.getStreamIndex());
    PDPageTree pages = pdDocument.getPages();
    COSObjectKey key2 = pages.getCOSObject().getKey();
    assertEquals(-1, key2.getStreamIndex());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -10, toByteArrayResult[10]);
    assertEquals((byte) -28, toByteArrayResult[11]);
    assertEquals((byte) -33, toByteArrayResult[13]);
    assertEquals((byte) -4, toByteArrayResult[12]);
    assertEquals(0, key.getGeneration());
    assertEquals(0, key2.getGeneration());
    assertEquals(1.6f, document.getVersion());
    assertEquals(1.6f, pdDocument.getVersion());
    assertEquals(131072L, key2.getInternalHash());
    assertEquals(1L, key.getNumber());
    assertEquals(2L, key2.getNumber());
    COSDictionary trailer = document.getTrailer();
    assertEquals(3, trailer.getValues().size());
    assertEquals(3, trailer.size());
    assertEquals(467, toByteArrayResult.length);
    assertEquals(4L, document.getHighestXRefObjectNumber());
    assertEquals(65536L, key.getInternalHash());
    assertFalse(pages.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(document.isEncrypted());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertFalse(pdDocument.isEncrypted());
    assertTrue(document.isXRefStream());
    assertEquals(Short.SIZE, ((COSString) getResult).getBytes().length);
    assertEquals(' ', toByteArrayResult[18]);
    assertEquals(' ', toByteArrayResult[Short.SIZE]);
    assertEquals('%', toByteArrayResult[0]);
    assertEquals('%', toByteArrayResult[461]);
    assertEquals('%', toByteArrayResult[462]);
    assertEquals('%', toByteArrayResult[9]);
    assertEquals('-', toByteArrayResult[4]);
    assertEquals('.', toByteArrayResult[6]);
    assertEquals('0', toByteArrayResult[17]);
    assertEquals('1', toByteArrayResult[15]);
    assertEquals('1', toByteArrayResult[5]);
    assertEquals('2', toByteArrayResult[457]);
    assertEquals('2', toByteArrayResult[458]);
    assertEquals('6', toByteArrayResult[459]);
    assertEquals('6', toByteArrayResult[7]);
    assertEquals('<', toByteArrayResult[23]);
    assertEquals('<', toByteArrayResult[24]);
    assertEquals('D', toByteArrayResult[2]);
    assertEquals('E', toByteArrayResult[463]);
    assertEquals('F', toByteArrayResult[3]);
    assertEquals('F', toByteArrayResult[465]);
    assertEquals('O', toByteArrayResult[464]);
    assertEquals('P', toByteArrayResult[1]);
    assertEquals('\n', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[22]);
    assertEquals('\n', toByteArrayResult[446]);
    assertEquals('\n', toByteArrayResult[456]);
    assertEquals('\n', toByteArrayResult[460]);
    assertEquals('\n', toByteArrayResult[466]);
    assertEquals('\n', toByteArrayResult[8]);
    assertEquals('a', toByteArrayResult[449]);
    assertEquals('b', toByteArrayResult[20]);
    assertEquals('b', toByteArrayResult[444]);
    assertEquals('d', toByteArrayResult[442]);
    assertEquals('e', toByteArrayResult[454]);
    assertEquals('f', toByteArrayResult[455]);
    assertEquals('j', toByteArrayResult[21]);
    assertEquals('j', toByteArrayResult[445]);
    assertEquals('o', toByteArrayResult[19]);
    assertEquals('o', toByteArrayResult[443]);
    assertEquals('r', toByteArrayResult[450]);
    assertEquals('r', toByteArrayResult[453]);
    assertEquals('s', toByteArrayResult[447]);
    assertEquals('t', toByteArrayResult[448]);
    assertEquals('t', toByteArrayResult[451]);
    assertEquals('x', toByteArrayResult[452]);
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  void testSave3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    pdDocument.save(output, CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDocument document = pdDocument.getDocument();
    List<? extends COSBase> toListResult = document.getDocumentID().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    PDDocumentCatalog documentCatalog = pdDocument.getDocumentCatalog();
    assertEquals("1.6", documentCatalog.getVersion());
    assertNull(document.getEncryptionDictionary());
    assertNull(getResult.getKey());
    assertNull(pdDocument.getDocumentInformation().getCOSObject().getKey());
    assertNull(pdDocument.getEncryption());
    COSObjectKey key = documentCatalog.getCOSObject().getKey();
    assertEquals(-1, key.getStreamIndex());
    PDPageTree pages = pdDocument.getPages();
    COSObjectKey key2 = pages.getCOSObject().getKey();
    assertEquals(-1, key2.getStreamIndex());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -10, toByteArrayResult[10]);
    assertEquals((byte) -28, toByteArrayResult[11]);
    assertEquals((byte) -33, toByteArrayResult[13]);
    assertEquals((byte) -4, toByteArrayResult[12]);
    assertEquals(0, key.getGeneration());
    assertEquals(0, key2.getGeneration());
    assertEquals(1.6f, document.getVersion());
    assertEquals(1.6f, pdDocument.getVersion());
    assertEquals(131072L, key2.getInternalHash());
    assertEquals(1L, key.getNumber());
    assertEquals(2L, key2.getNumber());
    COSDictionary trailer = document.getTrailer();
    assertEquals(3, trailer.getValues().size());
    assertEquals(3, trailer.size());
    assertEquals(467, toByteArrayResult.length);
    assertEquals(4L, document.getHighestXRefObjectNumber());
    assertEquals(65536L, key.getInternalHash());
    assertFalse(pages.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(document.isEncrypted());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertFalse(pdDocument.isEncrypted());
    assertTrue(document.isXRefStream());
    assertEquals(Short.SIZE, ((COSString) getResult).getBytes().length);
    assertEquals(' ', toByteArrayResult[18]);
    assertEquals(' ', toByteArrayResult[Short.SIZE]);
    assertEquals('%', toByteArrayResult[0]);
    assertEquals('%', toByteArrayResult[461]);
    assertEquals('%', toByteArrayResult[462]);
    assertEquals('%', toByteArrayResult[9]);
    assertEquals('-', toByteArrayResult[4]);
    assertEquals('.', toByteArrayResult[6]);
    assertEquals('0', toByteArrayResult[17]);
    assertEquals('1', toByteArrayResult[15]);
    assertEquals('1', toByteArrayResult[5]);
    assertEquals('2', toByteArrayResult[457]);
    assertEquals('2', toByteArrayResult[458]);
    assertEquals('6', toByteArrayResult[459]);
    assertEquals('6', toByteArrayResult[7]);
    assertEquals('<', toByteArrayResult[23]);
    assertEquals('<', toByteArrayResult[24]);
    assertEquals('D', toByteArrayResult[2]);
    assertEquals('E', toByteArrayResult[463]);
    assertEquals('F', toByteArrayResult[3]);
    assertEquals('F', toByteArrayResult[465]);
    assertEquals('O', toByteArrayResult[464]);
    assertEquals('P', toByteArrayResult[1]);
    assertEquals('\n', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[22]);
    assertEquals('\n', toByteArrayResult[446]);
    assertEquals('\n', toByteArrayResult[456]);
    assertEquals('\n', toByteArrayResult[460]);
    assertEquals('\n', toByteArrayResult[466]);
    assertEquals('\n', toByteArrayResult[8]);
    assertEquals('a', toByteArrayResult[449]);
    assertEquals('b', toByteArrayResult[20]);
    assertEquals('b', toByteArrayResult[444]);
    assertEquals('d', toByteArrayResult[442]);
    assertEquals('e', toByteArrayResult[454]);
    assertEquals('f', toByteArrayResult[455]);
    assertEquals('j', toByteArrayResult[21]);
    assertEquals('j', toByteArrayResult[445]);
    assertEquals('o', toByteArrayResult[19]);
    assertEquals('o', toByteArrayResult[443]);
    assertEquals('r', toByteArrayResult[450]);
    assertEquals('r', toByteArrayResult[453]);
    assertEquals('s', toByteArrayResult[447]);
    assertEquals('t', toByteArrayResult[448]);
    assertEquals('t', toByteArrayResult[451]);
    assertEquals('x', toByteArrayResult[452]);
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  void testSave4() throws IOException {
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
    COSDocument document = pdDocument.getDocument();
    List<? extends COSBase> toListResult = document.getDocumentID().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    PDDocumentCatalog documentCatalog = pdDocument.getDocumentCatalog();
    assertEquals("1.6", documentCatalog.getVersion());
    assertNull(document.getEncryptionDictionary());
    assertNull(getResult.getKey());
    assertNull(pdDocument.getDocumentInformation().getCOSObject().getKey());
    assertNull(pdDocument.getEncryption());
    COSObjectKey key = documentCatalog.getCOSObject().getKey();
    assertEquals(-1, key.getStreamIndex());
    PDPageTree pages = pdDocument.getPages();
    COSObjectKey key2 = pages.getCOSObject().getKey();
    assertEquals(-1, key2.getStreamIndex());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -10, toByteArrayResult[10]);
    assertEquals((byte) -28, toByteArrayResult[11]);
    assertEquals((byte) -33, toByteArrayResult[13]);
    assertEquals((byte) -4, toByteArrayResult[12]);
    assertEquals(0, key.getGeneration());
    assertEquals(0, key2.getGeneration());
    assertEquals(1.6f, document.getVersion());
    assertEquals(1.6f, pdDocument.getVersion());
    assertEquals(131072L, key2.getInternalHash());
    assertEquals(1L, key.getNumber());
    assertEquals(2L, key2.getNumber());
    COSDictionary trailer = document.getTrailer();
    assertEquals(3, trailer.getValues().size());
    assertEquals(3, trailer.size());
    assertEquals(467, toByteArrayResult.length);
    assertEquals(4L, document.getHighestXRefObjectNumber());
    assertEquals(65536L, key.getInternalHash());
    assertFalse(pages.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(document.isEncrypted());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertFalse(pdDocument.isEncrypted());
    assertTrue(document.isXRefStream());
    assertEquals(Short.SIZE, ((COSString) getResult).getBytes().length);
    assertEquals(' ', toByteArrayResult[18]);
    assertEquals(' ', toByteArrayResult[Short.SIZE]);
    assertEquals('%', toByteArrayResult[0]);
    assertEquals('%', toByteArrayResult[461]);
    assertEquals('%', toByteArrayResult[462]);
    assertEquals('%', toByteArrayResult[9]);
    assertEquals('-', toByteArrayResult[4]);
    assertEquals('.', toByteArrayResult[6]);
    assertEquals('0', toByteArrayResult[17]);
    assertEquals('1', toByteArrayResult[15]);
    assertEquals('1', toByteArrayResult[5]);
    assertEquals('2', toByteArrayResult[457]);
    assertEquals('2', toByteArrayResult[458]);
    assertEquals('6', toByteArrayResult[459]);
    assertEquals('6', toByteArrayResult[7]);
    assertEquals('<', toByteArrayResult[23]);
    assertEquals('<', toByteArrayResult[24]);
    assertEquals('D', toByteArrayResult[2]);
    assertEquals('E', toByteArrayResult[463]);
    assertEquals('F', toByteArrayResult[3]);
    assertEquals('F', toByteArrayResult[465]);
    assertEquals('O', toByteArrayResult[464]);
    assertEquals('P', toByteArrayResult[1]);
    assertEquals('\n', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[22]);
    assertEquals('\n', toByteArrayResult[446]);
    assertEquals('\n', toByteArrayResult[456]);
    assertEquals('\n', toByteArrayResult[460]);
    assertEquals('\n', toByteArrayResult[466]);
    assertEquals('\n', toByteArrayResult[8]);
    assertEquals('a', toByteArrayResult[449]);
    assertEquals('b', toByteArrayResult[20]);
    assertEquals('b', toByteArrayResult[444]);
    assertEquals('d', toByteArrayResult[442]);
    assertEquals('e', toByteArrayResult[454]);
    assertEquals('f', toByteArrayResult[455]);
    assertEquals('j', toByteArrayResult[21]);
    assertEquals('j', toByteArrayResult[445]);
    assertEquals('o', toByteArrayResult[19]);
    assertEquals('o', toByteArrayResult[443]);
    assertEquals('r', toByteArrayResult[450]);
    assertEquals('r', toByteArrayResult[453]);
    assertEquals('s', toByteArrayResult[447]);
    assertEquals('t', toByteArrayResult[448]);
    assertEquals('t', toByteArrayResult[451]);
    assertEquals('x', toByteArrayResult[452]);
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  void testSave5() throws IOException {
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
    COSDocument document = pdDocument.getDocument();
    List<? extends COSBase> toListResult = document.getDocumentID().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    PDDocumentCatalog documentCatalog = pdDocument.getDocumentCatalog();
    assertEquals("1.4", documentCatalog.getVersion());
    assertNull(document.getEncryptionDictionary());
    assertNull(getResult.getKey());
    assertNull(pdDocument.getDocumentInformation().getCOSObject().getKey());
    assertNull(pdDocument.getEncryption());
    COSObjectKey key = documentCatalog.getCOSObject().getKey();
    assertEquals(-1, key.getStreamIndex());
    PDPageTree pages = pdDocument.getPages();
    COSObjectKey key2 = pages.getCOSObject().getKey();
    assertEquals(-1, key2.getStreamIndex());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -10, toByteArrayResult[10]);
    assertEquals((byte) -28, toByteArrayResult[11]);
    assertEquals((byte) -33, toByteArrayResult[13]);
    assertEquals((byte) -4, toByteArrayResult[12]);
    assertEquals(0, key.getGeneration());
    assertEquals(0, key2.getGeneration());
    assertEquals(1.4f, document.getVersion());
    assertEquals(1.4f, pdDocument.getVersion());
    assertEquals(131072L, key2.getInternalHash());
    assertEquals(1L, key.getNumber());
    assertEquals(2L, document.getHighestXRefObjectNumber());
    assertEquals(2L, key2.getNumber());
    assertEquals(329, toByteArrayResult.length);
    COSDictionary trailer = document.getTrailer();
    assertEquals(4, trailer.getValues().size());
    assertEquals(4, trailer.size());
    assertEquals(65536L, key.getInternalHash());
    assertFalse(pages.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertFalse(pdDocument.isEncrypted());
    assertEquals(Short.SIZE, ((COSString) getResult).getBytes().length);
    assertEquals(' ', toByteArrayResult[18]);
    assertEquals(' ', toByteArrayResult[Short.SIZE]);
    assertEquals('%', toByteArrayResult[0]);
    assertEquals('%', toByteArrayResult[323]);
    assertEquals('%', toByteArrayResult[324]);
    assertEquals('%', toByteArrayResult[9]);
    assertEquals('-', toByteArrayResult[4]);
    assertEquals('.', toByteArrayResult[6]);
    assertEquals('0', toByteArrayResult[17]);
    assertEquals('0', toByteArrayResult[321]);
    assertEquals('1', toByteArrayResult[15]);
    assertEquals('1', toByteArrayResult[319]);
    assertEquals('1', toByteArrayResult[5]);
    assertEquals('3', toByteArrayResult[304]);
    assertEquals('3', toByteArrayResult[320]);
    assertEquals('4', toByteArrayResult[7]);
    assertEquals('<', toByteArrayResult[23]);
    assertEquals('<', toByteArrayResult[24]);
    assertEquals('>', toByteArrayResult[306]);
    assertEquals('>', toByteArrayResult[307]);
    assertEquals('D', toByteArrayResult[2]);
    assertEquals('E', toByteArrayResult[325]);
    assertEquals('F', toByteArrayResult[3]);
    assertEquals('F', toByteArrayResult[327]);
    assertEquals('O', toByteArrayResult[326]);
    assertEquals('P', toByteArrayResult[1]);
    assertEquals('\n', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[22]);
    assertEquals('\n', toByteArrayResult[305]);
    assertEquals('\n', toByteArrayResult[308]);
    assertEquals('\n', toByteArrayResult[318]);
    assertEquals('\n', toByteArrayResult[322]);
    assertEquals('\n', toByteArrayResult[328]);
    assertEquals('\n', toByteArrayResult[8]);
    assertEquals('a', toByteArrayResult[311]);
    assertEquals('b', toByteArrayResult[20]);
    assertEquals('e', toByteArrayResult[316]);
    assertEquals('f', toByteArrayResult[317]);
    assertEquals('j', toByteArrayResult[21]);
    assertEquals('o', toByteArrayResult[19]);
    assertEquals('r', toByteArrayResult[312]);
    assertEquals('r', toByteArrayResult[315]);
    assertEquals('s', toByteArrayResult[309]);
    assertEquals('t', toByteArrayResult[310]);
    assertEquals('t', toByteArrayResult[313]);
    assertEquals('x', toByteArrayResult[314]);
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Method under test: {@link PDDocument#save(OutputStream, CompressParameters)}
   */
  @Test
  void testSave6() throws IOException {
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
    COSDocument document = pdDocument.getDocument();
    List<? extends COSBase> toListResult = document.getDocumentID().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    PDDocumentCatalog documentCatalog = pdDocument.getDocumentCatalog();
    assertEquals("1.4", documentCatalog.getVersion());
    assertNull(document.getEncryptionDictionary());
    assertNull(getResult.getKey());
    assertNull(pdDocument.getDocumentInformation().getCOSObject().getKey());
    assertNull(pdDocument.getEncryption());
    COSObjectKey key = documentCatalog.getCOSObject().getKey();
    assertEquals(-1, key.getStreamIndex());
    PDPageTree pages = pdDocument.getPages();
    COSObjectKey key2 = pages.getCOSObject().getKey();
    assertEquals(-1, key2.getStreamIndex());
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -10, toByteArrayResult[10]);
    assertEquals((byte) -28, toByteArrayResult[11]);
    assertEquals((byte) -33, toByteArrayResult[13]);
    assertEquals((byte) -4, toByteArrayResult[12]);
    assertEquals(0, key.getGeneration());
    assertEquals(0, key2.getGeneration());
    assertEquals(1.4f, document.getVersion());
    assertEquals(1.4f, pdDocument.getVersion());
    assertEquals(131072L, key2.getInternalHash());
    assertEquals(1L, key.getNumber());
    assertEquals(2L, document.getHighestXRefObjectNumber());
    assertEquals(2L, key2.getNumber());
    assertEquals(329, toByteArrayResult.length);
    COSDictionary trailer = document.getTrailer();
    assertEquals(4, trailer.getValues().size());
    assertEquals(4, trailer.size());
    assertEquals(65536L, key.getInternalHash());
    assertFalse(pages.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertFalse(pdDocument.isEncrypted());
    assertEquals(Short.SIZE, ((COSString) getResult).getBytes().length);
    assertEquals(' ', toByteArrayResult[18]);
    assertEquals(' ', toByteArrayResult[Short.SIZE]);
    assertEquals('%', toByteArrayResult[0]);
    assertEquals('%', toByteArrayResult[323]);
    assertEquals('%', toByteArrayResult[324]);
    assertEquals('%', toByteArrayResult[9]);
    assertEquals('-', toByteArrayResult[4]);
    assertEquals('.', toByteArrayResult[6]);
    assertEquals('0', toByteArrayResult[17]);
    assertEquals('0', toByteArrayResult[321]);
    assertEquals('1', toByteArrayResult[15]);
    assertEquals('1', toByteArrayResult[319]);
    assertEquals('1', toByteArrayResult[5]);
    assertEquals('3', toByteArrayResult[304]);
    assertEquals('3', toByteArrayResult[320]);
    assertEquals('4', toByteArrayResult[7]);
    assertEquals('<', toByteArrayResult[23]);
    assertEquals('<', toByteArrayResult[24]);
    assertEquals('>', toByteArrayResult[306]);
    assertEquals('>', toByteArrayResult[307]);
    assertEquals('D', toByteArrayResult[2]);
    assertEquals('E', toByteArrayResult[325]);
    assertEquals('F', toByteArrayResult[3]);
    assertEquals('F', toByteArrayResult[327]);
    assertEquals('O', toByteArrayResult[326]);
    assertEquals('P', toByteArrayResult[1]);
    assertEquals('\n', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[22]);
    assertEquals('\n', toByteArrayResult[305]);
    assertEquals('\n', toByteArrayResult[308]);
    assertEquals('\n', toByteArrayResult[318]);
    assertEquals('\n', toByteArrayResult[322]);
    assertEquals('\n', toByteArrayResult[328]);
    assertEquals('\n', toByteArrayResult[8]);
    assertEquals('a', toByteArrayResult[311]);
    assertEquals('b', toByteArrayResult[20]);
    assertEquals('e', toByteArrayResult[316]);
    assertEquals('f', toByteArrayResult[317]);
    assertEquals('j', toByteArrayResult[21]);
    assertEquals('o', toByteArrayResult[19]);
    assertEquals('r', toByteArrayResult[312]);
    assertEquals('r', toByteArrayResult[315]);
    assertEquals('s', toByteArrayResult[309]);
    assertEquals('t', toByteArrayResult[310]);
    assertEquals('t', toByteArrayResult[313]);
    assertEquals('x', toByteArrayResult[314]);
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Method under test: {@link PDDocument#saveIncremental(OutputStream)}
   */
  @Test
  void testSaveIncremental() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.saveIncremental(new ByteArrayOutputStream(1)));
  }

  /**
   * Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  void testSaveIncremental2() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.saveIncremental(output, new HashSet<>()));
  }

  /**
   * Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  void testSaveIncremental3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    HashSet<COSDictionary> objectsToWrite = new HashSet<>();
    objectsToWrite.add(new COSDictionary());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.saveIncremental(output, objectsToWrite));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDDocument#saveIncremental(OutputStream, Set)}
   */
  @Test
  void testSaveIncremental4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    HashSet<COSDictionary> objectsToWrite = new HashSet<>();
    objectsToWrite.add(new COSDictionary());
    objectsToWrite.add(new COSDictionary());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdDocument.saveIncremental(output, objectsToWrite));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDDocument#saveIncrementalForExternalSigning(OutputStream)}
   */
  @Test
  void testSaveIncrementalForExternalSigning() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> pdDocument.saveIncrementalForExternalSigning(new ByteArrayOutputStream(1)));
  }

  /**
   * Method under test: {@link PDDocument#getNumberOfPages()}
   */
  @Test
  void testGetNumberOfPages() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDDocument()).getNumberOfPages());
  }

  /**
   * Method under test: {@link PDDocument#getNumberOfPages()}
   */
  @Test
  void testGetNumberOfPages2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualNumberOfPages = (new PDDocument(streamCacheCreateFunction)).getNumberOfPages();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualNumberOfPages);
  }

  /**
   * Method under test: {@link PDDocument#getNumberOfPages()}
   */
  @Test
  void testGetNumberOfPages3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.addPage(new PDPage());

    // Act
    int actualNumberOfPages = pdDocument.getNumberOfPages();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualNumberOfPages);
  }

  /**
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act
    pdDocument.close();

    // Assert
    assertTrue(pdDocument.getDocument().isClosed());
  }

  /**
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  void testClose2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);

    // Act
    pdDocument.close();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdDocument.getDocument().isClosed());
  }

  /**
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  void testClose3() throws IOException {
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
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  void testClose4() throws IOException {
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
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  void testClose5() throws IOException {
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
   * Method under test: {@link PDDocument#close()}
   */
  @Test
  void testClose6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

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
   * Method under test: {@link PDDocument#getVersion()}
   */
  @Test
  void testGetVersion() {
    // Arrange, Act and Assert
    assertEquals(1.4f, (new PDDocument()).getVersion());
  }

  /**
   * Method under test: {@link PDDocument#getVersion()}
   */
  @Test
  void testGetVersion2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    float actualVersion = (new PDDocument(streamCacheCreateFunction)).getVersion();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1.4f, actualVersion);
  }

  /**
   * Method under test: {@link PDDocument#getVersion()}
   */
  @Test
  void testGetVersion3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdDocument = new PDDocument(streamCacheCreateFunction);
    pdDocument.addPage(new PDPage());

    // Act
    float actualVersion = pdDocument.getVersion();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1.4f, actualVersion);
  }

  /**
   * Method under test: {@link PDDocument#setVersion(float)}
   */
  @Test
  void testSetVersion() {
    // Arrange
    PDDocument pdDocument = new PDDocument();

    // Act
    pdDocument.setVersion(10.0f);

    // Assert
    assertEquals("10.0", pdDocument.getDocumentCatalog().getVersion());
    assertEquals(10.0f, pdDocument.getVersion());
  }

  /**
   * Method under test: {@link PDDocument#setVersion(float)}
   */
  @Test
  void testSetVersion2() throws IOException {
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
   * Method under test: {@link PDDocument#setVersion(float)}
   */
  @Test
  void testSetVersion3() throws IOException {
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
   * Method under test: {@link PDDocument#setVersion(float)}
   */
  @Test
  void testSetVersion4() throws IOException {
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

  /**
   * Method under test: {@link PDDocument#PDDocument(COSDocument)}
   */
  @Test
  void testNewPDDocument() {
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
   * Method under test: {@link PDDocument#PDDocument(COSDocument)}
   */
  @Test
  void testNewPDDocument2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument doc = new COSDocument(streamCacheCreateFunction);

    // Act
    PDDocument actualPdDocument = new PDDocument(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
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
   * Method under test:
   * {@link PDDocument#PDDocument(COSDocument, RandomAccessRead)}
   */
  @Test
  void testNewPDDocument3() throws IOException {
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
   * Method under test:
   * {@link PDDocument#PDDocument(COSDocument, RandomAccessRead)}
   */
  @Test
  void testNewPDDocument4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument doc = new COSDocument(streamCacheCreateFunction);

    // Act
    PDDocument actualPdDocument = new PDDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    verify(streamCacheCreateFunction).create();
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
   * Method under test:
   * {@link PDDocument#PDDocument(COSDocument, RandomAccessRead, AccessPermission)}
   */
  @Test
  void testNewPDDocument5() throws IOException {
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
   * Method under test:
   * {@link PDDocument#PDDocument(COSDocument, RandomAccessRead, AccessPermission)}
   */
  @Test
  void testNewPDDocument6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument doc = new COSDocument(streamCacheCreateFunction);
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    AccessPermission permission = AccessPermission.getOwnerAccessPermission();

    // Act
    PDDocument actualPdDocument = new PDDocument(doc, source, permission);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualPdDocument.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualPdDocument.getDocumentId());
    assertNull(actualPdDocument.getEncryption());
    assertFalse(actualPdDocument.isAllSecurityToBeRemoved());
    assertFalse(actualPdDocument.isEncrypted());
    assertTrue(actualPdDocument.getFontsToSubset().isEmpty());
    assertSame(doc, actualPdDocument.getDocument());
    assertSame(permission, actualPdDocument.getCurrentAccessPermission());
  }
}
