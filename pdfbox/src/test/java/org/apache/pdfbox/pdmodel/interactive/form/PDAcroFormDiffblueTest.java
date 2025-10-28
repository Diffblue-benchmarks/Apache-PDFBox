package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.fdf.FDFCatalog;
import org.apache.pdfbox.pdmodel.fdf.FDFDictionary;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAcroFormDiffblueTest {
  /**
   * Method under test: {@link PDAcroForm#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDAcroForm(new PDDocument())).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSDictionary actualCOSObject = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).getCOSObject();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#importFDF(FDFDocument)}
   */
  @Test
  void testImportFDF() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.importFDF(new FDFDocument());

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAcroForm#exportFDF()}
   */
  @Test
  void testExportFDF() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    COSDictionary cosDictionary3 = new COSDictionary();
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary3);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    FDFDocument actualExportFDFResult = pdAcroForm.exportFDF();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    List<PDField> calcOrder = pdAcroForm.getCalcOrder();
    assertEquals(3, calcOrder.size());
    PDField getResult = calcOrder.get(0);
    assertTrue(getResult instanceof PDNonTerminalField);
    FDFCatalog catalog = actualExportFDFResult.getCatalog();
    FDFDictionary fDF = catalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    List<FDFField> fields = fDF.getFields();
    assertEquals(3, fields.size());
    FDFField getResult2 = fields.get(0);
    assertEquals("String", getResult2.getPartialFieldName());
    FDFField getResult3 = fields.get(1);
    assertEquals("String", getResult3.getPartialFieldName());
    FDFField getResult4 = fields.get(2);
    assertEquals("String", getResult4.getPartialFieldName());
    assertNull(getResult2.getClearFieldFlags());
    assertNull(getResult3.getClearFieldFlags());
    assertNull(getResult4.getClearFieldFlags());
    assertNull(getResult2.getClearWidgetFieldFlags());
    assertNull(getResult3.getClearWidgetFieldFlags());
    assertNull(getResult4.getClearWidgetFieldFlags());
    assertNull(getResult2.getFieldFlags());
    assertNull(getResult3.getFieldFlags());
    assertNull(getResult4.getFieldFlags());
    assertNull(getResult2.getSetFieldFlags());
    assertNull(getResult3.getSetFieldFlags());
    assertNull(getResult4.getSetFieldFlags());
    assertNull(getResult2.getSetWidgetFieldFlags());
    assertNull(getResult3.getSetWidgetFieldFlags());
    assertNull(getResult4.getSetWidgetFieldFlags());
    assertNull(getResult2.getWidgetFieldFlags());
    assertNull(getResult3.getWidgetFieldFlags());
    assertNull(getResult4.getWidgetFieldFlags());
    assertNull(catalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(getResult2.getRichText());
    assertNull(getResult3.getRichText());
    assertNull(getResult4.getRichText());
    assertNull(getResult2.getOptions());
    assertNull(getResult3.getOptions());
    assertNull(getResult4.getOptions());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getPages());
    COSDocument document = actualExportFDFResult.getDocument();
    assertNull(document.getDocumentID());
    assertNull(fDF.getID());
    assertNull(document.getEncryptionDictionary());
    assertNull(document.getLinearizedDictionary());
    COSDictionary trailer = document.getTrailer();
    assertNull(trailer.getKey());
    COSDictionary cOSObject = catalog.getCOSObject();
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    assertNull(cOSObject2.getKey());
    assertNull(document.getKey());
    COSDictionary cOSObject3 = getResult2.getCOSObject();
    assertNull(cOSObject3.getKey());
    COSDictionary cOSObject4 = getResult3.getCOSObject();
    assertNull(cOSObject4.getKey());
    COSDictionary cOSObject5 = getResult4.getCOSObject();
    assertNull(cOSObject5.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(getResult2.getIconFit());
    assertNull(getResult3.getIconFit());
    assertNull(getResult4.getIconFit());
    assertNull(fDF.getJavaScript());
    assertNull(getResult2.getAppearanceStreamReference());
    assertNull(getResult3.getAppearanceStreamReference());
    assertNull(getResult4.getAppearanceStreamReference());
    assertNull(getResult2.getAction());
    assertNull(getResult3.getAction());
    assertNull(getResult4.getAction());
    assertNull(getResult2.getAdditionalActions());
    assertNull(getResult3.getAdditionalActions());
    assertNull(getResult4.getAdditionalActions());
    assertNull(getResult2.getAppearanceDictionary());
    assertNull(getResult3.getAppearanceDictionary());
    assertNull(getResult4.getAppearanceDictionary());
    assertNull(catalog.getSignature());
    assertEquals(0L, document.getHighestXRefObjectNumber());
    assertEquals(0L, document.getStartXref());
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, cOSObject2.size());
    assertEquals(1.2f, document.getVersion());
    COSIncrement toIncrementResult = cOSObject3.toIncrement();
    assertEquals(2, toIncrementResult.getObjects().size());
    COSIncrement toIncrementResult2 = cOSObject4.toIncrement();
    assertEquals(2, toIncrementResult2.getObjects().size());
    COSIncrement toIncrementResult3 = cOSObject5.toIncrement();
    assertEquals(2, toIncrementResult3.getObjects().size());
    assertEquals(3, cOSObject3.getValues().size());
    assertEquals(3, cOSObject4.getValues().size());
    assertEquals(3, cOSObject5.getValues().size());
    assertEquals(3, cOSObject3.size());
    assertEquals(3, cOSObject4.size());
    assertEquals(3, cOSObject5.size());
    COSIncrement toIncrementResult4 = cOSObject2.toIncrement();
    assertEquals(5, toIncrementResult4.getObjects().size());
    COSIncrement toIncrementResult5 = cOSObject.toIncrement();
    assertEquals(6, toIncrementResult5.getObjects().size());
    COSIncrement toIncrementResult6 = trailer.toIncrement();
    assertEquals(7, toIncrementResult6.getObjects().size());
    assertFalse(trailer.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(document.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject4.isDirect());
    assertFalse(cOSObject5.isDirect());
    assertFalse(document.hasHybridXRef());
    assertFalse(document.isClosed());
    assertFalse(document.isDecrypted());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    Iterator<COSBase> iteratorResult = toIncrementResult6.iterator();
    assertTrue(iteratorResult.hasNext());
    Iterator<COSBase> iteratorResult2 = toIncrementResult5.iterator();
    assertTrue(iteratorResult2.hasNext());
    Iterator<COSBase> iteratorResult3 = toIncrementResult4.iterator();
    assertTrue(iteratorResult3.hasNext());
    Iterator<COSBase> iteratorResult4 = toIncrementResult.iterator();
    assertTrue(iteratorResult4.hasNext());
    Iterator<COSBase> iteratorResult5 = toIncrementResult2.iterator();
    assertTrue(iteratorResult5.hasNext());
    Iterator<COSBase> iteratorResult6 = toIncrementResult3.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(getResult2.getKids().isEmpty());
    assertTrue(getResult3.getKids().isEmpty());
    assertTrue(getResult4.getKids().isEmpty());
    assertTrue(document.getXrefTable().isEmpty());
    COSDocumentState documentState = document.getDocumentState();
    assertTrue(documentState.isAcceptingUpdates());
    assertTrue(trailer.isNeedToBeUpdated());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject2.isNeedToBeUpdated());
    assertTrue(cOSObject3.isNeedToBeUpdated());
    assertTrue(cOSObject4.isNeedToBeUpdated());
    assertTrue(cOSObject5.isNeedToBeUpdated());
    COSUpdateState updateState = trailer.getUpdateState();
    assertTrue(updateState.isUpdated());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertTrue(updateState2.isUpdated());
    COSUpdateState updateState3 = cOSObject2.getUpdateState();
    assertTrue(updateState3.isUpdated());
    COSUpdateState updateState4 = cOSObject3.getUpdateState();
    assertTrue(updateState4.isUpdated());
    COSUpdateState updateState5 = cOSObject4.getUpdateState();
    assertTrue(updateState5.isUpdated());
    COSUpdateState updateState6 = cOSObject5.getUpdateState();
    assertTrue(updateState6.isUpdated());
    assertSame(cosDictionary3, ((PDNonTerminalField) getResult).getDefaultValue());
    assertSame(documentState, updateState.getOriginDocumentState());
    assertSame(documentState, updateState2.getOriginDocumentState());
    assertSame(documentState, updateState3.getOriginDocumentState());
    assertSame(documentState, updateState4.getOriginDocumentState());
    assertSame(documentState, updateState5.getOriginDocumentState());
    assertSame(documentState, updateState6.getOriginDocumentState());
    assertSame(trailer, iteratorResult.next());
    assertSame(cOSObject, iteratorResult.next());
    assertSame(cOSObject, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult3.next());
    assertSame(cOSObject3, iteratorResult4.next());
    assertSame(cOSObject4, iteratorResult5.next());
    assertSame(cOSObject5, iteratorResult6.next());
  }

  /**
   * Method under test: {@link PDAcroForm#exportFDF()}
   */
  @Test
  void testExportFDF2() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.isDirect()).thenReturn(true);
    when(cosDictionary2.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary3.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary3.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary3.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary3);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    FDFDocument actualExportFDFResult = pdAcroForm.exportFDF();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(cosDictionary2, atLeast(1)).isDirect();
    verify(cosDictionary3, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getUpdateState();
    List<PDField> calcOrder = pdAcroForm.getCalcOrder();
    assertEquals(3, calcOrder.size());
    assertTrue(calcOrder.get(0) instanceof PDNonTerminalField);
    FDFCatalog catalog = actualExportFDFResult.getCatalog();
    FDFDictionary fDF = catalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    List<FDFField> fields = fDF.getFields();
    assertEquals(3, fields.size());
    FDFField getResult = fields.get(0);
    assertEquals("String", getResult.getPartialFieldName());
    FDFField getResult2 = fields.get(1);
    assertEquals("String", getResult2.getPartialFieldName());
    FDFField getResult3 = fields.get(2);
    assertEquals("String", getResult3.getPartialFieldName());
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult2.getClearFieldFlags());
    assertNull(getResult3.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult2.getClearWidgetFieldFlags());
    assertNull(getResult3.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult2.getFieldFlags());
    assertNull(getResult3.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult2.getSetFieldFlags());
    assertNull(getResult3.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult2.getSetWidgetFieldFlags());
    assertNull(getResult3.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult2.getWidgetFieldFlags());
    assertNull(getResult3.getWidgetFieldFlags());
    assertNull(catalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(getResult.getRichText());
    assertNull(getResult2.getRichText());
    assertNull(getResult3.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult2.getOptions());
    assertNull(getResult3.getOptions());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getPages());
    COSDocument document = actualExportFDFResult.getDocument();
    assertNull(document.getDocumentID());
    assertNull(fDF.getID());
    assertNull(document.getEncryptionDictionary());
    assertNull(document.getLinearizedDictionary());
    COSDictionary trailer = document.getTrailer();
    assertNull(trailer.getKey());
    COSDictionary cOSObject = catalog.getCOSObject();
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    assertNull(cOSObject2.getKey());
    assertNull(document.getKey());
    COSDictionary cOSObject3 = getResult.getCOSObject();
    assertNull(cOSObject3.getKey());
    COSDictionary cOSObject4 = getResult2.getCOSObject();
    assertNull(cOSObject4.getKey());
    COSDictionary cOSObject5 = getResult3.getCOSObject();
    assertNull(cOSObject5.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(getResult.getIconFit());
    assertNull(getResult2.getIconFit());
    assertNull(getResult3.getIconFit());
    assertNull(fDF.getJavaScript());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult2.getAppearanceStreamReference());
    assertNull(getResult3.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult2.getAction());
    assertNull(getResult3.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult2.getAdditionalActions());
    assertNull(getResult3.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
    assertNull(getResult2.getAppearanceDictionary());
    assertNull(getResult3.getAppearanceDictionary());
    assertNull(catalog.getSignature());
    assertEquals(0L, document.getHighestXRefObjectNumber());
    assertEquals(0L, document.getStartXref());
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, cOSObject2.size());
    assertEquals(1.2f, document.getVersion());
    COSIncrement toIncrementResult = cOSObject3.toIncrement();
    assertEquals(2, toIncrementResult.getObjects().size());
    COSIncrement toIncrementResult2 = cOSObject4.toIncrement();
    assertEquals(2, toIncrementResult2.getObjects().size());
    COSIncrement toIncrementResult3 = cOSObject5.toIncrement();
    assertEquals(2, toIncrementResult3.getObjects().size());
    assertEquals(3, cOSObject3.getValues().size());
    assertEquals(3, cOSObject4.getValues().size());
    assertEquals(3, cOSObject5.getValues().size());
    assertEquals(3, cOSObject3.size());
    assertEquals(3, cOSObject4.size());
    assertEquals(3, cOSObject5.size());
    COSIncrement toIncrementResult4 = cOSObject2.toIncrement();
    assertEquals(5, toIncrementResult4.getObjects().size());
    COSIncrement toIncrementResult5 = cOSObject.toIncrement();
    assertEquals(6, toIncrementResult5.getObjects().size());
    COSIncrement toIncrementResult6 = trailer.toIncrement();
    assertEquals(7, toIncrementResult6.getObjects().size());
    assertFalse(trailer.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(document.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject4.isDirect());
    assertFalse(cOSObject5.isDirect());
    assertFalse(document.hasHybridXRef());
    assertFalse(document.isClosed());
    assertFalse(document.isDecrypted());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    Iterator<COSBase> iteratorResult = toIncrementResult6.iterator();
    assertTrue(iteratorResult.hasNext());
    Iterator<COSBase> iteratorResult2 = toIncrementResult5.iterator();
    assertTrue(iteratorResult2.hasNext());
    Iterator<COSBase> iteratorResult3 = toIncrementResult4.iterator();
    assertTrue(iteratorResult3.hasNext());
    Iterator<COSBase> iteratorResult4 = toIncrementResult.iterator();
    assertTrue(iteratorResult4.hasNext());
    Iterator<COSBase> iteratorResult5 = toIncrementResult2.iterator();
    assertTrue(iteratorResult5.hasNext());
    Iterator<COSBase> iteratorResult6 = toIncrementResult3.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(getResult.getKids().isEmpty());
    assertTrue(getResult2.getKids().isEmpty());
    assertTrue(getResult3.getKids().isEmpty());
    assertTrue(document.getXrefTable().isEmpty());
    COSDocumentState documentState = document.getDocumentState();
    assertTrue(documentState.isAcceptingUpdates());
    assertTrue(trailer.isNeedToBeUpdated());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject2.isNeedToBeUpdated());
    assertTrue(cOSObject3.isNeedToBeUpdated());
    assertTrue(cOSObject4.isNeedToBeUpdated());
    assertTrue(cOSObject5.isNeedToBeUpdated());
    COSUpdateState updateState = trailer.getUpdateState();
    assertTrue(updateState.isUpdated());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertTrue(updateState2.isUpdated());
    COSUpdateState updateState3 = cOSObject2.getUpdateState();
    assertTrue(updateState3.isUpdated());
    COSUpdateState updateState4 = cOSObject3.getUpdateState();
    assertTrue(updateState4.isUpdated());
    COSUpdateState updateState5 = cOSObject4.getUpdateState();
    assertTrue(updateState5.isUpdated());
    COSUpdateState updateState6 = cOSObject5.getUpdateState();
    assertTrue(updateState6.isUpdated());
    assertSame(documentState, updateState.getOriginDocumentState());
    assertSame(documentState, updateState2.getOriginDocumentState());
    assertSame(documentState, updateState3.getOriginDocumentState());
    assertSame(documentState, updateState4.getOriginDocumentState());
    assertSame(documentState, updateState5.getOriginDocumentState());
    assertSame(documentState, updateState6.getOriginDocumentState());
    assertSame(trailer, iteratorResult.next());
    assertSame(cOSObject, iteratorResult.next());
    assertSame(cOSObject, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult3.next());
    assertSame(cOSObject3, iteratorResult4.next());
    assertSame(cOSObject4, iteratorResult5.next());
    assertSame(cOSObject5, iteratorResult6.next());
  }

  /**
   * Method under test: {@link PDAcroForm#exportFDF()}
   */
  @Test
  void testExportFDF3() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.isDirect()).thenReturn(true);
    when(cosDictionary2.getUpdateState()).thenReturn(new COSUpdateState(null));
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary3.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary3.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary3.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary3);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    FDFDocument actualExportFDFResult = pdAcroForm.exportFDF();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(cosDictionary2, atLeast(1)).isDirect();
    verify(cosDictionary3, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getUpdateState();
    List<PDField> calcOrder = pdAcroForm.getCalcOrder();
    assertEquals(3, calcOrder.size());
    assertTrue(calcOrder.get(0) instanceof PDNonTerminalField);
    FDFCatalog catalog = actualExportFDFResult.getCatalog();
    FDFDictionary fDF = catalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    List<FDFField> fields = fDF.getFields();
    assertEquals(3, fields.size());
    FDFField getResult = fields.get(0);
    assertEquals("String", getResult.getPartialFieldName());
    FDFField getResult2 = fields.get(1);
    assertEquals("String", getResult2.getPartialFieldName());
    FDFField getResult3 = fields.get(2);
    assertEquals("String", getResult3.getPartialFieldName());
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult2.getClearFieldFlags());
    assertNull(getResult3.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult2.getClearWidgetFieldFlags());
    assertNull(getResult3.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult2.getFieldFlags());
    assertNull(getResult3.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult2.getSetFieldFlags());
    assertNull(getResult3.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult2.getSetWidgetFieldFlags());
    assertNull(getResult3.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult2.getWidgetFieldFlags());
    assertNull(getResult3.getWidgetFieldFlags());
    assertNull(catalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(getResult.getRichText());
    assertNull(getResult2.getRichText());
    assertNull(getResult3.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult2.getOptions());
    assertNull(getResult3.getOptions());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getPages());
    COSDocument document = actualExportFDFResult.getDocument();
    assertNull(document.getDocumentID());
    assertNull(fDF.getID());
    assertNull(document.getEncryptionDictionary());
    assertNull(document.getLinearizedDictionary());
    COSDictionary trailer = document.getTrailer();
    assertNull(trailer.getKey());
    COSDictionary cOSObject = catalog.getCOSObject();
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    assertNull(cOSObject2.getKey());
    assertNull(document.getKey());
    COSDictionary cOSObject3 = getResult.getCOSObject();
    assertNull(cOSObject3.getKey());
    COSDictionary cOSObject4 = getResult2.getCOSObject();
    assertNull(cOSObject4.getKey());
    COSDictionary cOSObject5 = getResult3.getCOSObject();
    assertNull(cOSObject5.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(getResult.getIconFit());
    assertNull(getResult2.getIconFit());
    assertNull(getResult3.getIconFit());
    assertNull(fDF.getJavaScript());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult2.getAppearanceStreamReference());
    assertNull(getResult3.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult2.getAction());
    assertNull(getResult3.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult2.getAdditionalActions());
    assertNull(getResult3.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
    assertNull(getResult2.getAppearanceDictionary());
    assertNull(getResult3.getAppearanceDictionary());
    assertNull(catalog.getSignature());
    assertEquals(0L, document.getHighestXRefObjectNumber());
    assertEquals(0L, document.getStartXref());
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, cOSObject2.size());
    assertEquals(1.2f, document.getVersion());
    COSIncrement toIncrementResult = cOSObject3.toIncrement();
    assertEquals(2, toIncrementResult.getObjects().size());
    COSIncrement toIncrementResult2 = cOSObject4.toIncrement();
    assertEquals(2, toIncrementResult2.getObjects().size());
    COSIncrement toIncrementResult3 = cOSObject5.toIncrement();
    assertEquals(2, toIncrementResult3.getObjects().size());
    assertEquals(3, cOSObject3.getValues().size());
    assertEquals(3, cOSObject4.getValues().size());
    assertEquals(3, cOSObject5.getValues().size());
    assertEquals(3, cOSObject3.size());
    assertEquals(3, cOSObject4.size());
    assertEquals(3, cOSObject5.size());
    COSIncrement toIncrementResult4 = cOSObject2.toIncrement();
    assertEquals(5, toIncrementResult4.getObjects().size());
    COSIncrement toIncrementResult5 = cOSObject.toIncrement();
    assertEquals(6, toIncrementResult5.getObjects().size());
    COSIncrement toIncrementResult6 = trailer.toIncrement();
    assertEquals(7, toIncrementResult6.getObjects().size());
    assertFalse(trailer.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(document.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject4.isDirect());
    assertFalse(cOSObject5.isDirect());
    assertFalse(document.hasHybridXRef());
    assertFalse(document.isClosed());
    assertFalse(document.isDecrypted());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    Iterator<COSBase> iteratorResult = toIncrementResult6.iterator();
    assertTrue(iteratorResult.hasNext());
    Iterator<COSBase> iteratorResult2 = toIncrementResult5.iterator();
    assertTrue(iteratorResult2.hasNext());
    Iterator<COSBase> iteratorResult3 = toIncrementResult4.iterator();
    assertTrue(iteratorResult3.hasNext());
    Iterator<COSBase> iteratorResult4 = toIncrementResult.iterator();
    assertTrue(iteratorResult4.hasNext());
    Iterator<COSBase> iteratorResult5 = toIncrementResult2.iterator();
    assertTrue(iteratorResult5.hasNext());
    Iterator<COSBase> iteratorResult6 = toIncrementResult3.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(getResult.getKids().isEmpty());
    assertTrue(getResult2.getKids().isEmpty());
    assertTrue(getResult3.getKids().isEmpty());
    assertTrue(document.getXrefTable().isEmpty());
    COSDocumentState documentState = document.getDocumentState();
    assertTrue(documentState.isAcceptingUpdates());
    assertTrue(trailer.isNeedToBeUpdated());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject2.isNeedToBeUpdated());
    assertTrue(cOSObject3.isNeedToBeUpdated());
    assertTrue(cOSObject4.isNeedToBeUpdated());
    assertTrue(cOSObject5.isNeedToBeUpdated());
    COSUpdateState updateState = trailer.getUpdateState();
    assertTrue(updateState.isUpdated());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertTrue(updateState2.isUpdated());
    COSUpdateState updateState3 = cOSObject2.getUpdateState();
    assertTrue(updateState3.isUpdated());
    COSUpdateState updateState4 = cOSObject3.getUpdateState();
    assertTrue(updateState4.isUpdated());
    COSUpdateState updateState5 = cOSObject4.getUpdateState();
    assertTrue(updateState5.isUpdated());
    COSUpdateState updateState6 = cOSObject5.getUpdateState();
    assertTrue(updateState6.isUpdated());
    assertSame(documentState, updateState.getOriginDocumentState());
    assertSame(documentState, updateState2.getOriginDocumentState());
    assertSame(documentState, updateState3.getOriginDocumentState());
    assertSame(documentState, updateState4.getOriginDocumentState());
    assertSame(documentState, updateState5.getOriginDocumentState());
    assertSame(documentState, updateState6.getOriginDocumentState());
    assertSame(trailer, iteratorResult.next());
    assertSame(cOSObject, iteratorResult.next());
    assertSame(cOSObject, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult3.next());
    assertSame(cOSObject3, iteratorResult4.next());
    assertSame(cOSObject4, iteratorResult5.next());
    assertSame(cOSObject5, iteratorResult6.next());
  }

  /**
   * Method under test: {@link PDAcroForm#exportFDF()}
   */
  @Test
  void testExportFDF4() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary updateInfo = mock(COSDictionary.class);
    when(updateInfo.getValues()).thenReturn(new ArrayList<>());
    COSUpdateState cosUpdateState = new COSUpdateState(updateInfo);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.isDirect()).thenReturn(true);
    when(cosDictionary2.getUpdateState()).thenReturn(cosUpdateState);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary3.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary3.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary3.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary3);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    FDFDocument actualExportFDFResult = pdAcroForm.exportFDF();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(cosDictionary2, atLeast(1)).isDirect();
    verify(cosDictionary3, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getUpdateState();
    verify(updateInfo).getValues();
    List<PDField> calcOrder = pdAcroForm.getCalcOrder();
    assertEquals(3, calcOrder.size());
    assertTrue(calcOrder.get(0) instanceof PDNonTerminalField);
    FDFCatalog catalog = actualExportFDFResult.getCatalog();
    FDFDictionary fDF = catalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    List<FDFField> fields = fDF.getFields();
    assertEquals(3, fields.size());
    FDFField getResult = fields.get(0);
    assertEquals("String", getResult.getPartialFieldName());
    FDFField getResult2 = fields.get(1);
    assertEquals("String", getResult2.getPartialFieldName());
    FDFField getResult3 = fields.get(2);
    assertEquals("String", getResult3.getPartialFieldName());
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult2.getClearFieldFlags());
    assertNull(getResult3.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult2.getClearWidgetFieldFlags());
    assertNull(getResult3.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult2.getFieldFlags());
    assertNull(getResult3.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult2.getSetFieldFlags());
    assertNull(getResult3.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult2.getSetWidgetFieldFlags());
    assertNull(getResult3.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult2.getWidgetFieldFlags());
    assertNull(getResult3.getWidgetFieldFlags());
    assertNull(catalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(getResult.getRichText());
    assertNull(getResult2.getRichText());
    assertNull(getResult3.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult2.getOptions());
    assertNull(getResult3.getOptions());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getPages());
    COSDocument document = actualExportFDFResult.getDocument();
    assertNull(document.getDocumentID());
    assertNull(fDF.getID());
    assertNull(document.getEncryptionDictionary());
    assertNull(document.getLinearizedDictionary());
    COSDictionary trailer = document.getTrailer();
    assertNull(trailer.getKey());
    COSDictionary cOSObject = catalog.getCOSObject();
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    assertNull(cOSObject2.getKey());
    assertNull(document.getKey());
    COSDictionary cOSObject3 = getResult.getCOSObject();
    assertNull(cOSObject3.getKey());
    COSDictionary cOSObject4 = getResult2.getCOSObject();
    assertNull(cOSObject4.getKey());
    COSDictionary cOSObject5 = getResult3.getCOSObject();
    assertNull(cOSObject5.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(getResult.getIconFit());
    assertNull(getResult2.getIconFit());
    assertNull(getResult3.getIconFit());
    assertNull(fDF.getJavaScript());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult2.getAppearanceStreamReference());
    assertNull(getResult3.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult2.getAction());
    assertNull(getResult3.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult2.getAdditionalActions());
    assertNull(getResult3.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
    assertNull(getResult2.getAppearanceDictionary());
    assertNull(getResult3.getAppearanceDictionary());
    assertNull(catalog.getSignature());
    assertEquals(0L, document.getHighestXRefObjectNumber());
    assertEquals(0L, document.getStartXref());
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, cOSObject2.size());
    assertEquals(1.2f, document.getVersion());
    COSIncrement toIncrementResult = cOSObject3.toIncrement();
    assertEquals(2, toIncrementResult.getObjects().size());
    COSIncrement toIncrementResult2 = cOSObject4.toIncrement();
    assertEquals(2, toIncrementResult2.getObjects().size());
    COSIncrement toIncrementResult3 = cOSObject5.toIncrement();
    assertEquals(2, toIncrementResult3.getObjects().size());
    assertEquals(3, cOSObject3.getValues().size());
    assertEquals(3, cOSObject4.getValues().size());
    assertEquals(3, cOSObject5.getValues().size());
    assertEquals(3, cOSObject3.size());
    assertEquals(3, cOSObject4.size());
    assertEquals(3, cOSObject5.size());
    COSIncrement toIncrementResult4 = cOSObject2.toIncrement();
    assertEquals(5, toIncrementResult4.getObjects().size());
    COSIncrement toIncrementResult5 = cOSObject.toIncrement();
    assertEquals(6, toIncrementResult5.getObjects().size());
    COSIncrement toIncrementResult6 = trailer.toIncrement();
    assertEquals(7, toIncrementResult6.getObjects().size());
    assertFalse(trailer.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(document.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject4.isDirect());
    assertFalse(cOSObject5.isDirect());
    assertFalse(document.hasHybridXRef());
    assertFalse(document.isClosed());
    assertFalse(document.isDecrypted());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    Iterator<COSBase> iteratorResult = toIncrementResult6.iterator();
    assertTrue(iteratorResult.hasNext());
    Iterator<COSBase> iteratorResult2 = toIncrementResult5.iterator();
    assertTrue(iteratorResult2.hasNext());
    Iterator<COSBase> iteratorResult3 = toIncrementResult4.iterator();
    assertTrue(iteratorResult3.hasNext());
    Iterator<COSBase> iteratorResult4 = toIncrementResult.iterator();
    assertTrue(iteratorResult4.hasNext());
    Iterator<COSBase> iteratorResult5 = toIncrementResult2.iterator();
    assertTrue(iteratorResult5.hasNext());
    Iterator<COSBase> iteratorResult6 = toIncrementResult3.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(getResult.getKids().isEmpty());
    assertTrue(getResult2.getKids().isEmpty());
    assertTrue(getResult3.getKids().isEmpty());
    assertTrue(document.getXrefTable().isEmpty());
    COSDocumentState documentState = document.getDocumentState();
    assertTrue(documentState.isAcceptingUpdates());
    assertTrue(trailer.isNeedToBeUpdated());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject2.isNeedToBeUpdated());
    assertTrue(cOSObject3.isNeedToBeUpdated());
    assertTrue(cOSObject4.isNeedToBeUpdated());
    assertTrue(cOSObject5.isNeedToBeUpdated());
    COSUpdateState updateState = trailer.getUpdateState();
    assertTrue(updateState.isUpdated());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertTrue(updateState2.isUpdated());
    COSUpdateState updateState3 = cOSObject2.getUpdateState();
    assertTrue(updateState3.isUpdated());
    COSUpdateState updateState4 = cOSObject3.getUpdateState();
    assertTrue(updateState4.isUpdated());
    COSUpdateState updateState5 = cOSObject4.getUpdateState();
    assertTrue(updateState5.isUpdated());
    COSUpdateState updateState6 = cOSObject5.getUpdateState();
    assertTrue(updateState6.isUpdated());
    assertSame(documentState, updateState.getOriginDocumentState());
    assertSame(documentState, updateState2.getOriginDocumentState());
    assertSame(documentState, updateState3.getOriginDocumentState());
    assertSame(documentState, updateState4.getOriginDocumentState());
    assertSame(documentState, updateState5.getOriginDocumentState());
    assertSame(documentState, updateState6.getOriginDocumentState());
    assertSame(trailer, iteratorResult.next());
    assertSame(cOSObject, iteratorResult.next());
    assertSame(cOSObject, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult3.next());
    assertSame(cOSObject3, iteratorResult4.next());
    assertSame(cOSObject4, iteratorResult5.next());
    assertSame(cOSObject5, iteratorResult6.next());
  }

  /**
   * Method under test: {@link PDAcroForm#exportFDF()}
   */
  @Test
  void testExportFDF5() throws IOException {
    // Arrange
    COSArray updateInfo = mock(COSArray.class);

    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    when(updateInfo.iterator()).thenReturn(cosBaseList.iterator());
    COSUpdateState cosUpdateState = new COSUpdateState(updateInfo);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    when(cosDictionary2.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSUpdateState cosUpdateState2 = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState2).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.isDirect()).thenReturn(true);
    when(cosDictionary3.getUpdateState()).thenReturn(cosUpdateState2);
    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary4.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary3);
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary4.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary4.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary4);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    FDFDocument actualExportFDFResult = pdAcroForm.exportFDF();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(updateInfo).iterator();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary2, atLeast(1)).getCOSObject();
    verify(cosDictionary3, atLeast(1)).isDirect();
    verify(cosDictionary, atLeast(1)).isDirect();
    verify(cosDictionary4, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary2, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getUpdateState();
    verify(cosDictionary, atLeast(1)).getUpdateState();
    verify(cosUpdateState2, atLeast(1)).setOriginDocumentState(isNull());
    List<PDField> calcOrder = pdAcroForm.getCalcOrder();
    assertEquals(3, calcOrder.size());
    assertTrue(calcOrder.get(0) instanceof PDNonTerminalField);
    FDFCatalog catalog = actualExportFDFResult.getCatalog();
    FDFDictionary fDF = catalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    List<FDFField> fields = fDF.getFields();
    assertEquals(3, fields.size());
    FDFField getResult = fields.get(0);
    assertEquals("String", getResult.getPartialFieldName());
    FDFField getResult2 = fields.get(1);
    assertEquals("String", getResult2.getPartialFieldName());
    FDFField getResult3 = fields.get(2);
    assertEquals("String", getResult3.getPartialFieldName());
    List<FDFField> kids = getResult.getKids();
    assertEquals(3, kids.size());
    FDFField getResult4 = kids.get(0);
    assertEquals("String", getResult4.getPartialFieldName());
    FDFField getResult5 = kids.get(1);
    assertEquals("String", getResult5.getPartialFieldName());
    FDFField getResult6 = kids.get(2);
    assertEquals("String", getResult6.getPartialFieldName());
    List<FDFField> kids2 = getResult2.getKids();
    assertEquals(3, kids2.size());
    FDFField getResult7 = kids2.get(0);
    assertEquals("String", getResult7.getPartialFieldName());
    FDFField getResult8 = kids2.get(1);
    assertEquals("String", getResult8.getPartialFieldName());
    FDFField getResult9 = kids2.get(2);
    assertEquals("String", getResult9.getPartialFieldName());
    List<FDFField> kids3 = getResult3.getKids();
    assertEquals(3, kids3.size());
    FDFField getResult10 = kids3.get(0);
    assertEquals("String", getResult10.getPartialFieldName());
    FDFField getResult11 = kids3.get(1);
    assertEquals("String", getResult11.getPartialFieldName());
    FDFField getResult12 = kids3.get(2);
    assertEquals("String", getResult12.getPartialFieldName());
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult2.getClearFieldFlags());
    assertNull(getResult3.getClearFieldFlags());
    assertNull(getResult4.getClearFieldFlags());
    assertNull(getResult5.getClearFieldFlags());
    assertNull(getResult6.getClearFieldFlags());
    assertNull(getResult7.getClearFieldFlags());
    assertNull(getResult8.getClearFieldFlags());
    assertNull(getResult9.getClearFieldFlags());
    assertNull(getResult10.getClearFieldFlags());
    assertNull(getResult11.getClearFieldFlags());
    assertNull(getResult12.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult2.getClearWidgetFieldFlags());
    assertNull(getResult3.getClearWidgetFieldFlags());
    assertNull(getResult4.getClearWidgetFieldFlags());
    assertNull(getResult5.getClearWidgetFieldFlags());
    assertNull(getResult6.getClearWidgetFieldFlags());
    assertNull(getResult7.getClearWidgetFieldFlags());
    assertNull(getResult8.getClearWidgetFieldFlags());
    assertNull(getResult9.getClearWidgetFieldFlags());
    assertNull(getResult10.getClearWidgetFieldFlags());
    assertNull(getResult11.getClearWidgetFieldFlags());
    assertNull(getResult12.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult2.getFieldFlags());
    assertNull(getResult3.getFieldFlags());
    assertNull(getResult4.getFieldFlags());
    assertNull(getResult5.getFieldFlags());
    assertNull(getResult6.getFieldFlags());
    assertNull(getResult7.getFieldFlags());
    assertNull(getResult8.getFieldFlags());
    assertNull(getResult9.getFieldFlags());
    assertNull(getResult10.getFieldFlags());
    assertNull(getResult11.getFieldFlags());
    assertNull(getResult12.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult2.getSetFieldFlags());
    assertNull(getResult3.getSetFieldFlags());
    assertNull(getResult4.getSetFieldFlags());
    assertNull(getResult5.getSetFieldFlags());
    assertNull(getResult6.getSetFieldFlags());
    assertNull(getResult7.getSetFieldFlags());
    assertNull(getResult8.getSetFieldFlags());
    assertNull(getResult9.getSetFieldFlags());
    assertNull(getResult10.getSetFieldFlags());
    assertNull(getResult11.getSetFieldFlags());
    assertNull(getResult12.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult2.getSetWidgetFieldFlags());
    assertNull(getResult3.getSetWidgetFieldFlags());
    assertNull(getResult4.getSetWidgetFieldFlags());
    assertNull(getResult5.getSetWidgetFieldFlags());
    assertNull(getResult6.getSetWidgetFieldFlags());
    assertNull(getResult7.getSetWidgetFieldFlags());
    assertNull(getResult8.getSetWidgetFieldFlags());
    assertNull(getResult9.getSetWidgetFieldFlags());
    assertNull(getResult10.getSetWidgetFieldFlags());
    assertNull(getResult11.getSetWidgetFieldFlags());
    assertNull(getResult12.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult2.getWidgetFieldFlags());
    assertNull(getResult3.getWidgetFieldFlags());
    assertNull(getResult4.getWidgetFieldFlags());
    assertNull(getResult5.getWidgetFieldFlags());
    assertNull(getResult6.getWidgetFieldFlags());
    assertNull(getResult7.getWidgetFieldFlags());
    assertNull(getResult8.getWidgetFieldFlags());
    assertNull(getResult9.getWidgetFieldFlags());
    assertNull(getResult10.getWidgetFieldFlags());
    assertNull(getResult11.getWidgetFieldFlags());
    assertNull(getResult12.getWidgetFieldFlags());
    assertNull(catalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(getResult.getRichText());
    assertNull(getResult2.getRichText());
    assertNull(getResult3.getRichText());
    assertNull(getResult4.getRichText());
    assertNull(getResult5.getRichText());
    assertNull(getResult6.getRichText());
    assertNull(getResult7.getRichText());
    assertNull(getResult8.getRichText());
    assertNull(getResult9.getRichText());
    assertNull(getResult10.getRichText());
    assertNull(getResult11.getRichText());
    assertNull(getResult12.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult2.getOptions());
    assertNull(getResult3.getOptions());
    assertNull(getResult4.getOptions());
    assertNull(getResult5.getOptions());
    assertNull(getResult6.getOptions());
    assertNull(getResult7.getOptions());
    assertNull(getResult8.getOptions());
    assertNull(getResult9.getOptions());
    assertNull(getResult10.getOptions());
    assertNull(getResult11.getOptions());
    assertNull(getResult12.getOptions());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(getResult4.getKids());
    assertNull(getResult5.getKids());
    assertNull(getResult6.getKids());
    assertNull(getResult7.getKids());
    assertNull(getResult8.getKids());
    assertNull(getResult9.getKids());
    assertNull(getResult10.getKids());
    assertNull(getResult11.getKids());
    assertNull(getResult12.getKids());
    assertNull(fDF.getPages());
    COSDocument document = actualExportFDFResult.getDocument();
    assertNull(document.getDocumentID());
    assertNull(fDF.getID());
    assertNull(document.getEncryptionDictionary());
    assertNull(document.getLinearizedDictionary());
    COSDictionary trailer = document.getTrailer();
    assertNull(trailer.getKey());
    COSDictionary cOSObject = catalog.getCOSObject();
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    assertNull(cOSObject2.getKey());
    assertNull(document.getKey());
    COSDictionary cOSObject3 = getResult.getCOSObject();
    assertNull(cOSObject3.getKey());
    COSDictionary cOSObject4 = getResult2.getCOSObject();
    assertNull(cOSObject4.getKey());
    COSDictionary cOSObject5 = getResult3.getCOSObject();
    assertNull(cOSObject5.getKey());
    COSDictionary cOSObject6 = getResult4.getCOSObject();
    assertNull(cOSObject6.getKey());
    COSDictionary cOSObject7 = getResult5.getCOSObject();
    assertNull(cOSObject7.getKey());
    COSDictionary cOSObject8 = getResult6.getCOSObject();
    assertNull(cOSObject8.getKey());
    COSDictionary cOSObject9 = getResult7.getCOSObject();
    assertNull(cOSObject9.getKey());
    COSDictionary cOSObject10 = getResult8.getCOSObject();
    assertNull(cOSObject10.getKey());
    COSDictionary cOSObject11 = getResult9.getCOSObject();
    assertNull(cOSObject11.getKey());
    COSDictionary cOSObject12 = getResult10.getCOSObject();
    assertNull(cOSObject12.getKey());
    COSDictionary cOSObject13 = getResult11.getCOSObject();
    assertNull(cOSObject13.getKey());
    COSDictionary cOSObject14 = getResult12.getCOSObject();
    assertNull(cOSObject14.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(getResult.getIconFit());
    assertNull(getResult2.getIconFit());
    assertNull(getResult3.getIconFit());
    assertNull(getResult4.getIconFit());
    assertNull(getResult5.getIconFit());
    assertNull(getResult6.getIconFit());
    assertNull(getResult7.getIconFit());
    assertNull(getResult8.getIconFit());
    assertNull(getResult9.getIconFit());
    assertNull(getResult10.getIconFit());
    assertNull(getResult11.getIconFit());
    assertNull(getResult12.getIconFit());
    assertNull(fDF.getJavaScript());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult2.getAppearanceStreamReference());
    assertNull(getResult3.getAppearanceStreamReference());
    assertNull(getResult4.getAppearanceStreamReference());
    assertNull(getResult5.getAppearanceStreamReference());
    assertNull(getResult6.getAppearanceStreamReference());
    assertNull(getResult7.getAppearanceStreamReference());
    assertNull(getResult8.getAppearanceStreamReference());
    assertNull(getResult9.getAppearanceStreamReference());
    assertNull(getResult10.getAppearanceStreamReference());
    assertNull(getResult11.getAppearanceStreamReference());
    assertNull(getResult12.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult2.getAction());
    assertNull(getResult3.getAction());
    assertNull(getResult4.getAction());
    assertNull(getResult5.getAction());
    assertNull(getResult6.getAction());
    assertNull(getResult7.getAction());
    assertNull(getResult8.getAction());
    assertNull(getResult9.getAction());
    assertNull(getResult10.getAction());
    assertNull(getResult11.getAction());
    assertNull(getResult12.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult2.getAdditionalActions());
    assertNull(getResult3.getAdditionalActions());
    assertNull(getResult4.getAdditionalActions());
    assertNull(getResult5.getAdditionalActions());
    assertNull(getResult6.getAdditionalActions());
    assertNull(getResult7.getAdditionalActions());
    assertNull(getResult8.getAdditionalActions());
    assertNull(getResult9.getAdditionalActions());
    assertNull(getResult10.getAdditionalActions());
    assertNull(getResult11.getAdditionalActions());
    assertNull(getResult12.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
    assertNull(getResult2.getAppearanceDictionary());
    assertNull(getResult3.getAppearanceDictionary());
    assertNull(getResult4.getAppearanceDictionary());
    assertNull(getResult5.getAppearanceDictionary());
    assertNull(getResult6.getAppearanceDictionary());
    assertNull(getResult7.getAppearanceDictionary());
    assertNull(getResult8.getAppearanceDictionary());
    assertNull(getResult9.getAppearanceDictionary());
    assertNull(getResult10.getAppearanceDictionary());
    assertNull(getResult11.getAppearanceDictionary());
    assertNull(getResult12.getAppearanceDictionary());
    assertNull(catalog.getSignature());
    assertEquals(0L, document.getHighestXRefObjectNumber());
    assertEquals(0L, document.getStartXref());
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, cOSObject2.size());
    assertEquals(1.2f, document.getVersion());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertEquals(14, toIncrementResult.getObjects().size());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertEquals(15, toIncrementResult2.getObjects().size());
    assertEquals(2, cOSObject6.getValues().size());
    assertEquals(2, cOSObject7.getValues().size());
    assertEquals(2, cOSObject8.getValues().size());
    assertEquals(2, cOSObject9.getValues().size());
    assertEquals(2, cOSObject10.getValues().size());
    assertEquals(2, cOSObject11.getValues().size());
    assertEquals(2, cOSObject12.getValues().size());
    assertEquals(2, cOSObject13.getValues().size());
    assertEquals(2, cOSObject14.getValues().size());
    assertEquals(2, cOSObject6.size());
    assertEquals(2, cOSObject7.size());
    assertEquals(2, cOSObject8.size());
    assertEquals(2, cOSObject9.size());
    assertEquals(2, cOSObject10.size());
    assertEquals(2, cOSObject11.size());
    assertEquals(2, cOSObject12.size());
    assertEquals(2, cOSObject13.size());
    assertEquals(2, cOSObject14.size());
    assertEquals(3, cOSObject3.getValues().size());
    assertEquals(3, cOSObject4.getValues().size());
    assertEquals(3, cOSObject5.getValues().size());
    assertEquals(3, cOSObject3.size());
    assertEquals(3, cOSObject4.size());
    assertEquals(3, cOSObject5.size());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertEquals(5, toIncrementResult3.getObjects().size());
    COSIncrement toIncrementResult4 = cOSObject4.toIncrement();
    assertEquals(5, toIncrementResult4.getObjects().size());
    COSIncrement toIncrementResult5 = cOSObject5.toIncrement();
    assertEquals(5, toIncrementResult5.getObjects().size());
    assertFalse(trailer.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(document.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject4.isDirect());
    assertFalse(cOSObject5.isDirect());
    assertFalse(cOSObject6.isDirect());
    assertFalse(cOSObject7.isDirect());
    assertFalse(cOSObject8.isDirect());
    assertFalse(cOSObject9.isDirect());
    assertFalse(cOSObject10.isDirect());
    assertFalse(cOSObject11.isDirect());
    assertFalse(cOSObject12.isDirect());
    assertFalse(cOSObject13.isDirect());
    assertFalse(cOSObject14.isDirect());
    assertFalse(document.hasHybridXRef());
    assertFalse(document.isClosed());
    assertFalse(document.isDecrypted());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    COSIncrement toIncrementResult6 = trailer.toIncrement();
    Iterator<COSBase> iteratorResult = toIncrementResult6.iterator();
    assertTrue(iteratorResult.hasNext());
    Iterator<COSBase> iteratorResult2 = toIncrementResult2.iterator();
    assertTrue(iteratorResult2.hasNext());
    Iterator<COSBase> iteratorResult3 = toIncrementResult.iterator();
    assertTrue(iteratorResult3.hasNext());
    Iterator<COSBase> iteratorResult4 = toIncrementResult3.iterator();
    assertTrue(iteratorResult4.hasNext());
    Iterator<COSBase> iteratorResult5 = toIncrementResult4.iterator();
    assertTrue(iteratorResult5.hasNext());
    Iterator<COSBase> iteratorResult6 = toIncrementResult5.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(cOSObject6.toIncrement().iterator().hasNext());
    Iterator<COSBase> iteratorResult7 = cOSObject7.toIncrement().iterator();
    assertTrue(iteratorResult7.hasNext());
    Iterator<COSBase> iteratorResult8 = cOSObject8.toIncrement().iterator();
    assertTrue(iteratorResult8.hasNext());
    Iterator<COSBase> iteratorResult9 = cOSObject9.toIncrement().iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(cOSObject10.toIncrement().iterator().hasNext());
    Iterator<COSBase> iteratorResult10 = cOSObject11.toIncrement().iterator();
    assertTrue(iteratorResult10.hasNext());
    Iterator<COSBase> iteratorResult11 = cOSObject12.toIncrement().iterator();
    assertTrue(iteratorResult11.hasNext());
    Iterator<COSBase> iteratorResult12 = cOSObject13.toIncrement().iterator();
    assertTrue(iteratorResult12.hasNext());
    assertTrue(cOSObject14.toIncrement().iterator().hasNext());
    assertTrue(document.getXrefTable().isEmpty());
    COSDocumentState documentState = document.getDocumentState();
    assertTrue(documentState.isAcceptingUpdates());
    assertTrue(trailer.isNeedToBeUpdated());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject2.isNeedToBeUpdated());
    assertTrue(cOSObject3.isNeedToBeUpdated());
    assertTrue(cOSObject4.isNeedToBeUpdated());
    assertTrue(cOSObject5.isNeedToBeUpdated());
    assertTrue(cOSObject6.isNeedToBeUpdated());
    assertTrue(cOSObject7.isNeedToBeUpdated());
    assertTrue(cOSObject8.isNeedToBeUpdated());
    assertTrue(cOSObject9.isNeedToBeUpdated());
    assertTrue(cOSObject10.isNeedToBeUpdated());
    assertTrue(cOSObject11.isNeedToBeUpdated());
    assertTrue(cOSObject12.isNeedToBeUpdated());
    assertTrue(cOSObject13.isNeedToBeUpdated());
    assertTrue(cOSObject14.isNeedToBeUpdated());
    COSUpdateState updateState = trailer.getUpdateState();
    assertTrue(updateState.isUpdated());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertTrue(updateState2.isUpdated());
    COSUpdateState updateState3 = cOSObject2.getUpdateState();
    assertTrue(updateState3.isUpdated());
    COSUpdateState updateState4 = cOSObject3.getUpdateState();
    assertTrue(updateState4.isUpdated());
    COSUpdateState updateState5 = cOSObject4.getUpdateState();
    assertTrue(updateState5.isUpdated());
    COSUpdateState updateState6 = cOSObject5.getUpdateState();
    assertTrue(updateState6.isUpdated());
    COSUpdateState updateState7 = cOSObject6.getUpdateState();
    assertTrue(updateState7.isUpdated());
    COSUpdateState updateState8 = cOSObject7.getUpdateState();
    assertTrue(updateState8.isUpdated());
    COSUpdateState updateState9 = cOSObject8.getUpdateState();
    assertTrue(updateState9.isUpdated());
    COSUpdateState updateState10 = cOSObject9.getUpdateState();
    assertTrue(updateState10.isUpdated());
    COSUpdateState updateState11 = cOSObject10.getUpdateState();
    assertTrue(updateState11.isUpdated());
    COSUpdateState updateState12 = cOSObject11.getUpdateState();
    assertTrue(updateState12.isUpdated());
    COSUpdateState updateState13 = cOSObject12.getUpdateState();
    assertTrue(updateState13.isUpdated());
    COSUpdateState updateState14 = cOSObject13.getUpdateState();
    assertTrue(updateState14.isUpdated());
    COSUpdateState updateState15 = cOSObject14.getUpdateState();
    assertTrue(updateState15.isUpdated());
    assertEquals(Short.SIZE, toIncrementResult6.getObjects().size());
    assertSame(documentState, updateState.getOriginDocumentState());
    assertSame(documentState, updateState2.getOriginDocumentState());
    assertSame(documentState, updateState3.getOriginDocumentState());
    assertSame(documentState, updateState4.getOriginDocumentState());
    assertSame(documentState, updateState5.getOriginDocumentState());
    assertSame(documentState, updateState6.getOriginDocumentState());
    assertSame(documentState, updateState7.getOriginDocumentState());
    assertSame(documentState, updateState8.getOriginDocumentState());
    assertSame(documentState, updateState9.getOriginDocumentState());
    assertSame(documentState, updateState10.getOriginDocumentState());
    assertSame(documentState, updateState11.getOriginDocumentState());
    assertSame(documentState, updateState12.getOriginDocumentState());
    assertSame(documentState, updateState13.getOriginDocumentState());
    assertSame(documentState, updateState14.getOriginDocumentState());
    assertSame(documentState, updateState15.getOriginDocumentState());
    assertSame(trailer, iteratorResult.next());
    assertSame(cOSObject, iteratorResult.next());
    assertSame(cOSObject, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult3.next());
    assertSame(cOSObject3, iteratorResult4.next());
    assertSame(cOSObject4, iteratorResult5.next());
    assertSame(cOSObject5, iteratorResult6.next());
    assertSame(cOSObject7, iteratorResult7.next());
    assertSame(cOSObject8, iteratorResult8.next());
    assertSame(cOSObject9, iteratorResult9.next());
    assertSame(cOSObject11, iteratorResult10.next());
    assertSame(cOSObject12, iteratorResult11.next());
    assertSame(cOSObject13, iteratorResult12.next());
  }

  /**
   * Method under test: {@link PDAcroForm#exportFDF()}
   */
  @Test
  void testExportFDF6() throws IOException {
    // Arrange
    ArrayList<COSBase> cosBaseList = new ArrayList<>();
    cosBaseList.add(COSBoolean.FALSE);
    COSArray updateInfo = mock(COSArray.class);
    when(updateInfo.iterator()).thenReturn(cosBaseList.iterator());
    COSUpdateState cosUpdateState = new COSUpdateState(updateInfo);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    when(cosDictionary2.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSUpdateState cosUpdateState2 = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState2).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.isDirect()).thenReturn(true);
    when(cosDictionary3.getUpdateState()).thenReturn(cosUpdateState2);
    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary4.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary3);
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary4.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary4.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary4);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    FDFDocument actualExportFDFResult = pdAcroForm.exportFDF();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(updateInfo).iterator();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary2, atLeast(1)).getCOSObject();
    verify(cosDictionary3, atLeast(1)).isDirect();
    verify(cosDictionary, atLeast(1)).isDirect();
    verify(cosDictionary4, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary2, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getUpdateState();
    verify(cosDictionary, atLeast(1)).getUpdateState();
    verify(cosUpdateState2, atLeast(1)).setOriginDocumentState(isNull());
    List<PDField> calcOrder = pdAcroForm.getCalcOrder();
    assertEquals(3, calcOrder.size());
    assertTrue(calcOrder.get(0) instanceof PDNonTerminalField);
    FDFCatalog catalog = actualExportFDFResult.getCatalog();
    FDFDictionary fDF = catalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    List<FDFField> fields = fDF.getFields();
    assertEquals(3, fields.size());
    FDFField getResult = fields.get(0);
    assertEquals("String", getResult.getPartialFieldName());
    FDFField getResult2 = fields.get(1);
    assertEquals("String", getResult2.getPartialFieldName());
    FDFField getResult3 = fields.get(2);
    assertEquals("String", getResult3.getPartialFieldName());
    List<FDFField> kids = getResult.getKids();
    assertEquals(3, kids.size());
    FDFField getResult4 = kids.get(0);
    assertEquals("String", getResult4.getPartialFieldName());
    FDFField getResult5 = kids.get(1);
    assertEquals("String", getResult5.getPartialFieldName());
    FDFField getResult6 = kids.get(2);
    assertEquals("String", getResult6.getPartialFieldName());
    List<FDFField> kids2 = getResult2.getKids();
    assertEquals(3, kids2.size());
    FDFField getResult7 = kids2.get(0);
    assertEquals("String", getResult7.getPartialFieldName());
    FDFField getResult8 = kids2.get(1);
    assertEquals("String", getResult8.getPartialFieldName());
    FDFField getResult9 = kids2.get(2);
    assertEquals("String", getResult9.getPartialFieldName());
    List<FDFField> kids3 = getResult3.getKids();
    assertEquals(3, kids3.size());
    FDFField getResult10 = kids3.get(0);
    assertEquals("String", getResult10.getPartialFieldName());
    FDFField getResult11 = kids3.get(1);
    assertEquals("String", getResult11.getPartialFieldName());
    FDFField getResult12 = kids3.get(2);
    assertEquals("String", getResult12.getPartialFieldName());
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult2.getClearFieldFlags());
    assertNull(getResult3.getClearFieldFlags());
    assertNull(getResult4.getClearFieldFlags());
    assertNull(getResult5.getClearFieldFlags());
    assertNull(getResult6.getClearFieldFlags());
    assertNull(getResult7.getClearFieldFlags());
    assertNull(getResult8.getClearFieldFlags());
    assertNull(getResult9.getClearFieldFlags());
    assertNull(getResult10.getClearFieldFlags());
    assertNull(getResult11.getClearFieldFlags());
    assertNull(getResult12.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult2.getClearWidgetFieldFlags());
    assertNull(getResult3.getClearWidgetFieldFlags());
    assertNull(getResult4.getClearWidgetFieldFlags());
    assertNull(getResult5.getClearWidgetFieldFlags());
    assertNull(getResult6.getClearWidgetFieldFlags());
    assertNull(getResult7.getClearWidgetFieldFlags());
    assertNull(getResult8.getClearWidgetFieldFlags());
    assertNull(getResult9.getClearWidgetFieldFlags());
    assertNull(getResult10.getClearWidgetFieldFlags());
    assertNull(getResult11.getClearWidgetFieldFlags());
    assertNull(getResult12.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult2.getFieldFlags());
    assertNull(getResult3.getFieldFlags());
    assertNull(getResult4.getFieldFlags());
    assertNull(getResult5.getFieldFlags());
    assertNull(getResult6.getFieldFlags());
    assertNull(getResult7.getFieldFlags());
    assertNull(getResult8.getFieldFlags());
    assertNull(getResult9.getFieldFlags());
    assertNull(getResult10.getFieldFlags());
    assertNull(getResult11.getFieldFlags());
    assertNull(getResult12.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult2.getSetFieldFlags());
    assertNull(getResult3.getSetFieldFlags());
    assertNull(getResult4.getSetFieldFlags());
    assertNull(getResult5.getSetFieldFlags());
    assertNull(getResult6.getSetFieldFlags());
    assertNull(getResult7.getSetFieldFlags());
    assertNull(getResult8.getSetFieldFlags());
    assertNull(getResult9.getSetFieldFlags());
    assertNull(getResult10.getSetFieldFlags());
    assertNull(getResult11.getSetFieldFlags());
    assertNull(getResult12.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult2.getSetWidgetFieldFlags());
    assertNull(getResult3.getSetWidgetFieldFlags());
    assertNull(getResult4.getSetWidgetFieldFlags());
    assertNull(getResult5.getSetWidgetFieldFlags());
    assertNull(getResult6.getSetWidgetFieldFlags());
    assertNull(getResult7.getSetWidgetFieldFlags());
    assertNull(getResult8.getSetWidgetFieldFlags());
    assertNull(getResult9.getSetWidgetFieldFlags());
    assertNull(getResult10.getSetWidgetFieldFlags());
    assertNull(getResult11.getSetWidgetFieldFlags());
    assertNull(getResult12.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult2.getWidgetFieldFlags());
    assertNull(getResult3.getWidgetFieldFlags());
    assertNull(getResult4.getWidgetFieldFlags());
    assertNull(getResult5.getWidgetFieldFlags());
    assertNull(getResult6.getWidgetFieldFlags());
    assertNull(getResult7.getWidgetFieldFlags());
    assertNull(getResult8.getWidgetFieldFlags());
    assertNull(getResult9.getWidgetFieldFlags());
    assertNull(getResult10.getWidgetFieldFlags());
    assertNull(getResult11.getWidgetFieldFlags());
    assertNull(getResult12.getWidgetFieldFlags());
    assertNull(catalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(getResult.getRichText());
    assertNull(getResult2.getRichText());
    assertNull(getResult3.getRichText());
    assertNull(getResult4.getRichText());
    assertNull(getResult5.getRichText());
    assertNull(getResult6.getRichText());
    assertNull(getResult7.getRichText());
    assertNull(getResult8.getRichText());
    assertNull(getResult9.getRichText());
    assertNull(getResult10.getRichText());
    assertNull(getResult11.getRichText());
    assertNull(getResult12.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult2.getOptions());
    assertNull(getResult3.getOptions());
    assertNull(getResult4.getOptions());
    assertNull(getResult5.getOptions());
    assertNull(getResult6.getOptions());
    assertNull(getResult7.getOptions());
    assertNull(getResult8.getOptions());
    assertNull(getResult9.getOptions());
    assertNull(getResult10.getOptions());
    assertNull(getResult11.getOptions());
    assertNull(getResult12.getOptions());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(getResult4.getKids());
    assertNull(getResult5.getKids());
    assertNull(getResult6.getKids());
    assertNull(getResult7.getKids());
    assertNull(getResult8.getKids());
    assertNull(getResult9.getKids());
    assertNull(getResult10.getKids());
    assertNull(getResult11.getKids());
    assertNull(getResult12.getKids());
    assertNull(fDF.getPages());
    COSDocument document = actualExportFDFResult.getDocument();
    assertNull(document.getDocumentID());
    assertNull(fDF.getID());
    assertNull(document.getEncryptionDictionary());
    assertNull(document.getLinearizedDictionary());
    COSDictionary trailer = document.getTrailer();
    assertNull(trailer.getKey());
    COSDictionary cOSObject = catalog.getCOSObject();
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    assertNull(cOSObject2.getKey());
    assertNull(document.getKey());
    COSDictionary cOSObject3 = getResult.getCOSObject();
    assertNull(cOSObject3.getKey());
    COSDictionary cOSObject4 = getResult2.getCOSObject();
    assertNull(cOSObject4.getKey());
    COSDictionary cOSObject5 = getResult3.getCOSObject();
    assertNull(cOSObject5.getKey());
    COSDictionary cOSObject6 = getResult4.getCOSObject();
    assertNull(cOSObject6.getKey());
    COSDictionary cOSObject7 = getResult5.getCOSObject();
    assertNull(cOSObject7.getKey());
    COSDictionary cOSObject8 = getResult6.getCOSObject();
    assertNull(cOSObject8.getKey());
    COSDictionary cOSObject9 = getResult7.getCOSObject();
    assertNull(cOSObject9.getKey());
    COSDictionary cOSObject10 = getResult8.getCOSObject();
    assertNull(cOSObject10.getKey());
    COSDictionary cOSObject11 = getResult9.getCOSObject();
    assertNull(cOSObject11.getKey());
    COSDictionary cOSObject12 = getResult10.getCOSObject();
    assertNull(cOSObject12.getKey());
    COSDictionary cOSObject13 = getResult11.getCOSObject();
    assertNull(cOSObject13.getKey());
    COSDictionary cOSObject14 = getResult12.getCOSObject();
    assertNull(cOSObject14.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(getResult.getIconFit());
    assertNull(getResult2.getIconFit());
    assertNull(getResult3.getIconFit());
    assertNull(getResult4.getIconFit());
    assertNull(getResult5.getIconFit());
    assertNull(getResult6.getIconFit());
    assertNull(getResult7.getIconFit());
    assertNull(getResult8.getIconFit());
    assertNull(getResult9.getIconFit());
    assertNull(getResult10.getIconFit());
    assertNull(getResult11.getIconFit());
    assertNull(getResult12.getIconFit());
    assertNull(fDF.getJavaScript());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult2.getAppearanceStreamReference());
    assertNull(getResult3.getAppearanceStreamReference());
    assertNull(getResult4.getAppearanceStreamReference());
    assertNull(getResult5.getAppearanceStreamReference());
    assertNull(getResult6.getAppearanceStreamReference());
    assertNull(getResult7.getAppearanceStreamReference());
    assertNull(getResult8.getAppearanceStreamReference());
    assertNull(getResult9.getAppearanceStreamReference());
    assertNull(getResult10.getAppearanceStreamReference());
    assertNull(getResult11.getAppearanceStreamReference());
    assertNull(getResult12.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult2.getAction());
    assertNull(getResult3.getAction());
    assertNull(getResult4.getAction());
    assertNull(getResult5.getAction());
    assertNull(getResult6.getAction());
    assertNull(getResult7.getAction());
    assertNull(getResult8.getAction());
    assertNull(getResult9.getAction());
    assertNull(getResult10.getAction());
    assertNull(getResult11.getAction());
    assertNull(getResult12.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult2.getAdditionalActions());
    assertNull(getResult3.getAdditionalActions());
    assertNull(getResult4.getAdditionalActions());
    assertNull(getResult5.getAdditionalActions());
    assertNull(getResult6.getAdditionalActions());
    assertNull(getResult7.getAdditionalActions());
    assertNull(getResult8.getAdditionalActions());
    assertNull(getResult9.getAdditionalActions());
    assertNull(getResult10.getAdditionalActions());
    assertNull(getResult11.getAdditionalActions());
    assertNull(getResult12.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
    assertNull(getResult2.getAppearanceDictionary());
    assertNull(getResult3.getAppearanceDictionary());
    assertNull(getResult4.getAppearanceDictionary());
    assertNull(getResult5.getAppearanceDictionary());
    assertNull(getResult6.getAppearanceDictionary());
    assertNull(getResult7.getAppearanceDictionary());
    assertNull(getResult8.getAppearanceDictionary());
    assertNull(getResult9.getAppearanceDictionary());
    assertNull(getResult10.getAppearanceDictionary());
    assertNull(getResult11.getAppearanceDictionary());
    assertNull(getResult12.getAppearanceDictionary());
    assertNull(catalog.getSignature());
    assertEquals(0L, document.getHighestXRefObjectNumber());
    assertEquals(0L, document.getStartXref());
    assertEquals(1, trailer.getValues().size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, trailer.size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, cOSObject2.size());
    assertEquals(1.2f, document.getVersion());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertEquals(14, toIncrementResult.getObjects().size());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertEquals(15, toIncrementResult2.getObjects().size());
    assertEquals(2, cOSObject6.getValues().size());
    assertEquals(2, cOSObject7.getValues().size());
    assertEquals(2, cOSObject8.getValues().size());
    assertEquals(2, cOSObject9.getValues().size());
    assertEquals(2, cOSObject10.getValues().size());
    assertEquals(2, cOSObject11.getValues().size());
    assertEquals(2, cOSObject12.getValues().size());
    assertEquals(2, cOSObject13.getValues().size());
    assertEquals(2, cOSObject14.getValues().size());
    assertEquals(2, cOSObject6.size());
    assertEquals(2, cOSObject7.size());
    assertEquals(2, cOSObject8.size());
    assertEquals(2, cOSObject9.size());
    assertEquals(2, cOSObject10.size());
    assertEquals(2, cOSObject11.size());
    assertEquals(2, cOSObject12.size());
    assertEquals(2, cOSObject13.size());
    assertEquals(2, cOSObject14.size());
    assertEquals(3, cOSObject3.getValues().size());
    assertEquals(3, cOSObject4.getValues().size());
    assertEquals(3, cOSObject5.getValues().size());
    assertEquals(3, cOSObject3.size());
    assertEquals(3, cOSObject4.size());
    assertEquals(3, cOSObject5.size());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertEquals(5, toIncrementResult3.getObjects().size());
    COSIncrement toIncrementResult4 = cOSObject4.toIncrement();
    assertEquals(5, toIncrementResult4.getObjects().size());
    COSIncrement toIncrementResult5 = cOSObject5.toIncrement();
    assertEquals(5, toIncrementResult5.getObjects().size());
    assertFalse(trailer.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(document.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject4.isDirect());
    assertFalse(cOSObject5.isDirect());
    assertFalse(cOSObject6.isDirect());
    assertFalse(cOSObject7.isDirect());
    assertFalse(cOSObject8.isDirect());
    assertFalse(cOSObject9.isDirect());
    assertFalse(cOSObject10.isDirect());
    assertFalse(cOSObject11.isDirect());
    assertFalse(cOSObject12.isDirect());
    assertFalse(cOSObject13.isDirect());
    assertFalse(cOSObject14.isDirect());
    assertFalse(document.hasHybridXRef());
    assertFalse(document.isClosed());
    assertFalse(document.isDecrypted());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    COSIncrement toIncrementResult6 = trailer.toIncrement();
    Iterator<COSBase> iteratorResult = toIncrementResult6.iterator();
    assertTrue(iteratorResult.hasNext());
    Iterator<COSBase> iteratorResult2 = toIncrementResult2.iterator();
    assertTrue(iteratorResult2.hasNext());
    Iterator<COSBase> iteratorResult3 = toIncrementResult.iterator();
    assertTrue(iteratorResult3.hasNext());
    Iterator<COSBase> iteratorResult4 = toIncrementResult3.iterator();
    assertTrue(iteratorResult4.hasNext());
    Iterator<COSBase> iteratorResult5 = toIncrementResult4.iterator();
    assertTrue(iteratorResult5.hasNext());
    Iterator<COSBase> iteratorResult6 = toIncrementResult5.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(cOSObject6.toIncrement().iterator().hasNext());
    Iterator<COSBase> iteratorResult7 = cOSObject7.toIncrement().iterator();
    assertTrue(iteratorResult7.hasNext());
    Iterator<COSBase> iteratorResult8 = cOSObject8.toIncrement().iterator();
    assertTrue(iteratorResult8.hasNext());
    Iterator<COSBase> iteratorResult9 = cOSObject9.toIncrement().iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(cOSObject10.toIncrement().iterator().hasNext());
    Iterator<COSBase> iteratorResult10 = cOSObject11.toIncrement().iterator();
    assertTrue(iteratorResult10.hasNext());
    Iterator<COSBase> iteratorResult11 = cOSObject12.toIncrement().iterator();
    assertTrue(iteratorResult11.hasNext());
    Iterator<COSBase> iteratorResult12 = cOSObject13.toIncrement().iterator();
    assertTrue(iteratorResult12.hasNext());
    assertTrue(cOSObject14.toIncrement().iterator().hasNext());
    assertTrue(document.getXrefTable().isEmpty());
    COSDocumentState documentState = document.getDocumentState();
    assertTrue(documentState.isAcceptingUpdates());
    assertTrue(trailer.isNeedToBeUpdated());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject2.isNeedToBeUpdated());
    assertTrue(cOSObject3.isNeedToBeUpdated());
    assertTrue(cOSObject4.isNeedToBeUpdated());
    assertTrue(cOSObject5.isNeedToBeUpdated());
    assertTrue(cOSObject6.isNeedToBeUpdated());
    assertTrue(cOSObject7.isNeedToBeUpdated());
    assertTrue(cOSObject8.isNeedToBeUpdated());
    assertTrue(cOSObject9.isNeedToBeUpdated());
    assertTrue(cOSObject10.isNeedToBeUpdated());
    assertTrue(cOSObject11.isNeedToBeUpdated());
    assertTrue(cOSObject12.isNeedToBeUpdated());
    assertTrue(cOSObject13.isNeedToBeUpdated());
    assertTrue(cOSObject14.isNeedToBeUpdated());
    COSUpdateState updateState = trailer.getUpdateState();
    assertTrue(updateState.isUpdated());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertTrue(updateState2.isUpdated());
    COSUpdateState updateState3 = cOSObject2.getUpdateState();
    assertTrue(updateState3.isUpdated());
    COSUpdateState updateState4 = cOSObject3.getUpdateState();
    assertTrue(updateState4.isUpdated());
    COSUpdateState updateState5 = cOSObject4.getUpdateState();
    assertTrue(updateState5.isUpdated());
    COSUpdateState updateState6 = cOSObject5.getUpdateState();
    assertTrue(updateState6.isUpdated());
    COSUpdateState updateState7 = cOSObject6.getUpdateState();
    assertTrue(updateState7.isUpdated());
    COSUpdateState updateState8 = cOSObject7.getUpdateState();
    assertTrue(updateState8.isUpdated());
    COSUpdateState updateState9 = cOSObject8.getUpdateState();
    assertTrue(updateState9.isUpdated());
    COSUpdateState updateState10 = cOSObject9.getUpdateState();
    assertTrue(updateState10.isUpdated());
    COSUpdateState updateState11 = cOSObject10.getUpdateState();
    assertTrue(updateState11.isUpdated());
    COSUpdateState updateState12 = cOSObject11.getUpdateState();
    assertTrue(updateState12.isUpdated());
    COSUpdateState updateState13 = cOSObject12.getUpdateState();
    assertTrue(updateState13.isUpdated());
    COSUpdateState updateState14 = cOSObject13.getUpdateState();
    assertTrue(updateState14.isUpdated());
    COSUpdateState updateState15 = cOSObject14.getUpdateState();
    assertTrue(updateState15.isUpdated());
    assertEquals(Short.SIZE, toIncrementResult6.getObjects().size());
    assertSame(documentState, updateState.getOriginDocumentState());
    assertSame(documentState, updateState2.getOriginDocumentState());
    assertSame(documentState, updateState3.getOriginDocumentState());
    assertSame(documentState, updateState4.getOriginDocumentState());
    assertSame(documentState, updateState5.getOriginDocumentState());
    assertSame(documentState, updateState6.getOriginDocumentState());
    assertSame(documentState, updateState7.getOriginDocumentState());
    assertSame(documentState, updateState8.getOriginDocumentState());
    assertSame(documentState, updateState9.getOriginDocumentState());
    assertSame(documentState, updateState10.getOriginDocumentState());
    assertSame(documentState, updateState11.getOriginDocumentState());
    assertSame(documentState, updateState12.getOriginDocumentState());
    assertSame(documentState, updateState13.getOriginDocumentState());
    assertSame(documentState, updateState14.getOriginDocumentState());
    assertSame(documentState, updateState15.getOriginDocumentState());
    assertSame(trailer, iteratorResult.next());
    assertSame(cOSObject, iteratorResult.next());
    assertSame(cOSObject, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult2.next());
    assertSame(cOSObject2, iteratorResult3.next());
    assertSame(cOSObject3, iteratorResult4.next());
    assertSame(cOSObject4, iteratorResult5.next());
    assertSame(cOSObject5, iteratorResult6.next());
    assertSame(cOSObject7, iteratorResult7.next());
    assertSame(cOSObject8, iteratorResult8.next());
    assertSame(cOSObject9, iteratorResult9.next());
    assertSame(cOSObject11, iteratorResult10.next());
    assertSame(cOSObject12, iteratorResult11.next());
    assertSame(cOSObject13, iteratorResult12.next());
  }

  /**
   * Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  void testFlatten() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).flatten();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  void testFlatten2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setXFA(new PDXFAResource(COSBoolean.FALSE));

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  void testFlatten3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm pdAcroForm = new PDAcroForm(doc);

    // Act
    pdAcroForm.flatten(new ArrayList<>(), true);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    PDDocument document = pdAcroForm.getDocument();
    assertFalse(document.getPages().iterator().hasNext());
    assertSame(doc, document);
  }

  /**
   * Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  void testFlatten4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm pdAcroForm = new PDAcroForm(doc);

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.flatten(fields, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDDocument document = pdAcroForm.getDocument();
    assertFalse(document.getPages().iterator().hasNext());
    assertSame(doc, document);
  }

  /**
   * Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  void testFlatten5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm pdAcroForm = new PDAcroForm(doc);

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.flatten(fields, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDDocument document = pdAcroForm.getDocument();
    assertFalse(document.getPages().iterator().hasNext());
    assertSame(doc, document);
  }

  /**
   * Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  void testFlatten6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());
    PDAcroForm pdAcroForm = new PDAcroForm(doc);

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.flatten(fields, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(doc, pdAcroForm.getDocument());
  }

  /**
   * Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  void testFlatten7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm pdAcroForm = new PDAcroForm(doc);

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.flatten(fields, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDDocument document = pdAcroForm.getDocument();
    assertFalse(document.getPages().iterator().hasNext());
    assertSame(doc, document);
  }

  /**
   * Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  void testFlatten8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm pdAcroForm = new PDAcroForm(doc);

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDPushButton(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.flatten(fields, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDDocument document = pdAcroForm.getDocument();
    assertFalse(document.getPages().iterator().hasNext());
    assertSame(doc, document);
  }

  /**
   * Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  void testFlatten9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm pdAcroForm = new PDAcroForm(doc);

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.flatten(fields, false);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDDocument document = pdAcroForm.getDocument();
    assertFalse(document.getPages().iterator().hasNext());
    assertSame(doc, document);
  }

  /**
   * Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  void testFlatten10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage(new COSDictionary()));
    PDAcroForm pdAcroForm = new PDAcroForm(doc);

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.flatten(fields, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDDocument document = pdAcroForm.getDocument();
    assertFalse(document.getPages().iterator().hasNext());
    assertSame(doc, document);
  }

  /**
   * Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  void testFlatten11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    PDAcroForm pdAcroForm = new PDAcroForm(doc);
    pdAcroForm.setXFA(new PDXFAResource(COSBoolean.FALSE));

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.flatten(fields, true);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDDocument document = pdAcroForm.getDocument();
    assertFalse(document.getPages().iterator().hasNext());
    assertSame(doc, document);
  }

  /**
   * Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  void testRefreshAppearances() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).refreshAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAcroForm#refreshAppearances(List)}
   */
  @Test
  void testRefreshAppearances2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.refreshAppearances(new ArrayList<>());

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAcroForm#refreshAppearances(List)}
   */
  @Test
  void testRefreshAppearances3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.refreshAppearances(fields);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAcroForm#refreshAppearances(List)}
   */
  @Test
  void testRefreshAppearances4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(null);
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.refreshAppearances(fields);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAcroForm#refreshAppearances(List)}
   */
  @Test
  void testRefreshAppearances5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDPushButton(new PDAcroForm(new PDDocument())));
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.refreshAppearances(fields);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAcroForm#refreshAppearances(List)}
   */
  @Test
  void testRefreshAppearances6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDSignatureField(new PDAcroForm(new PDDocument())));
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.refreshAppearances(fields);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAcroForm#getFields()}
   */
  @Test
  void testGetFields() {
    // Arrange, Act and Assert
    assertTrue((new PDAcroForm(new PDDocument())).getFields().isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#getFields()}
   */
  @Test
  void testGetFields2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<PDField> actualFields = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).getFields();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualFields.isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#getFields()}
   */
  @Test
  void testGetFields3() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertTrue((new PDAcroForm(doc, new COSDictionary())).getFields().isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#setFields(List)}
   */
  @Test
  void testSetFields() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setFields(new ArrayList<>());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(pdAcroForm.getFieldIterator().hasNext());
    assertFalse(pdAcroForm.getFieldTree().iterator().hasNext());
    assertTrue(pdAcroForm.getFields().isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#setFields(List)}
   */
  @Test
  void testSetFields2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.setFields(fields);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDField> fieldIterator = pdAcroForm.getFieldIterator();
    PDField nextResult = fieldIterator.next();
    assertTrue(nextResult instanceof PDCheckBox);
    Iterator<PDField> iteratorResult = pdAcroForm.getFieldTree().iterator();
    PDField nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof PDCheckBox);
    List<PDField> fields2 = pdAcroForm.getFields();
    assertEquals(1, fields2.size());
    PDField getResult = fields2.get(0);
    assertTrue(getResult instanceof PDCheckBox);
    assertEquals("", ((PDCheckBox) nextResult).getDefaultValue());
    assertEquals("", ((PDCheckBox) nextResult2).getDefaultValue());
    assertEquals("", ((PDCheckBox) getResult).getDefaultValue());
    assertEquals("", ((PDCheckBox) nextResult).getOnValue());
    assertEquals("", ((PDCheckBox) nextResult2).getOnValue());
    assertEquals("", ((PDCheckBox) getResult).getOnValue());
    assertEquals("Btn", nextResult.getFieldType());
    assertEquals("Btn", nextResult2.getFieldType());
    assertEquals("Btn", getResult.getFieldType());
    assertEquals("Off", ((PDCheckBox) nextResult).getValue());
    assertEquals("Off", ((PDCheckBox) nextResult2).getValue());
    assertEquals("Off", ((PDCheckBox) getResult).getValue());
    assertEquals("Off", nextResult.getValueAsString());
    assertEquals("Off", nextResult2.getValueAsString());
    assertEquals("Off", getResult.getValueAsString());
    assertNull(nextResult.getAlternateFieldName());
    assertNull(nextResult2.getAlternateFieldName());
    assertNull(getResult.getAlternateFieldName());
    assertNull(nextResult.getFullyQualifiedName());
    assertNull(nextResult2.getFullyQualifiedName());
    assertNull(getResult.getFullyQualifiedName());
    assertNull(nextResult.getMappingName());
    assertNull(nextResult2.getMappingName());
    assertNull(getResult.getMappingName());
    assertNull(nextResult.getPartialName());
    assertNull(nextResult2.getPartialName());
    assertNull(getResult.getPartialName());
    assertNull(nextResult.getActions());
    assertNull(nextResult2.getActions());
    assertNull(getResult.getActions());
    assertNull(nextResult.getParent());
    assertNull(nextResult2.getParent());
    assertNull(getResult.getParent());
    assertEquals(0, nextResult.getFieldFlags());
    assertEquals(0, nextResult2.getFieldFlags());
    assertEquals(0, getResult.getFieldFlags());
    Set<String> onValues = ((PDCheckBox) nextResult).getOnValues();
    assertEquals(1, onValues.size());
    Set<String> onValues2 = ((PDCheckBox) nextResult2).getOnValues();
    assertEquals(1, onValues2.size());
    Set<String> onValues3 = ((PDCheckBox) getResult).getOnValues();
    assertEquals(1, onValues3.size());
    assertFalse(fieldIterator.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(((PDCheckBox) nextResult).isPushButton());
    assertFalse(((PDCheckBox) nextResult2).isPushButton());
    assertFalse(((PDCheckBox) getResult).isPushButton());
    assertFalse(((PDCheckBox) nextResult).isRadioButton());
    assertFalse(((PDCheckBox) nextResult2).isRadioButton());
    assertFalse(((PDCheckBox) getResult).isRadioButton());
    assertFalse(nextResult.isNoExport());
    assertFalse(nextResult2.isNoExport());
    assertFalse(getResult.isNoExport());
    assertFalse(nextResult.isReadOnly());
    assertFalse(nextResult2.isReadOnly());
    assertFalse(getResult.isReadOnly());
    assertFalse(nextResult.isRequired());
    assertFalse(nextResult2.isRequired());
    assertFalse(getResult.isRequired());
    assertTrue(onValues.contains(""));
    assertTrue(onValues2.contains(""));
    assertTrue(onValues3.contains(""));
    assertSame(pdAcroForm, nextResult.getAcroForm());
    assertSame(pdAcroForm, nextResult2.getAcroForm());
    assertSame(pdAcroForm, getResult.getAcroForm());
  }

  /**
   * Method under test: {@link PDAcroForm#setFields(List)}
   */
  @Test
  void testSetFields3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.setFields(fields);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDField> fieldIterator = pdAcroForm.getFieldIterator();
    PDField nextResult = fieldIterator.next();
    assertTrue(nextResult instanceof PDCheckBox);
    PDField nextResult2 = fieldIterator.next();
    assertTrue(nextResult2 instanceof PDCheckBox);
    Iterator<PDField> iteratorResult = pdAcroForm.getFieldTree().iterator();
    PDField nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof PDCheckBox);
    PDField nextResult4 = iteratorResult.next();
    assertTrue(nextResult4 instanceof PDCheckBox);
    List<PDField> fields2 = pdAcroForm.getFields();
    assertEquals(2, fields2.size());
    PDField getResult = fields2.get(0);
    assertTrue(getResult instanceof PDCheckBox);
    PDField getResult2 = fields2.get(1);
    assertTrue(getResult2 instanceof PDCheckBox);
    assertEquals("", ((PDCheckBox) nextResult).getDefaultValue());
    assertEquals("", ((PDCheckBox) nextResult2).getDefaultValue());
    assertEquals("", ((PDCheckBox) nextResult3).getDefaultValue());
    assertEquals("", ((PDCheckBox) nextResult4).getDefaultValue());
    assertEquals("", ((PDCheckBox) getResult).getDefaultValue());
    assertEquals("", ((PDCheckBox) getResult2).getDefaultValue());
    assertEquals("", ((PDCheckBox) nextResult).getOnValue());
    assertEquals("", ((PDCheckBox) nextResult2).getOnValue());
    assertEquals("", ((PDCheckBox) nextResult3).getOnValue());
    assertEquals("", ((PDCheckBox) nextResult4).getOnValue());
    assertEquals("", ((PDCheckBox) getResult).getOnValue());
    assertEquals("", ((PDCheckBox) getResult2).getOnValue());
    assertEquals("Btn", nextResult.getFieldType());
    assertEquals("Btn", nextResult2.getFieldType());
    assertEquals("Btn", nextResult3.getFieldType());
    assertEquals("Btn", nextResult4.getFieldType());
    assertEquals("Btn", getResult.getFieldType());
    assertEquals("Btn", getResult2.getFieldType());
    assertEquals("Off", ((PDCheckBox) nextResult).getValue());
    assertEquals("Off", ((PDCheckBox) nextResult2).getValue());
    assertEquals("Off", ((PDCheckBox) nextResult3).getValue());
    assertEquals("Off", ((PDCheckBox) nextResult4).getValue());
    assertEquals("Off", ((PDCheckBox) getResult).getValue());
    assertEquals("Off", ((PDCheckBox) getResult2).getValue());
    assertEquals("Off", nextResult.getValueAsString());
    assertEquals("Off", nextResult2.getValueAsString());
    assertEquals("Off", nextResult3.getValueAsString());
    assertEquals("Off", nextResult4.getValueAsString());
    assertEquals("Off", getResult.getValueAsString());
    assertEquals("Off", getResult2.getValueAsString());
    assertNull(nextResult.getAlternateFieldName());
    assertNull(nextResult2.getAlternateFieldName());
    assertNull(nextResult3.getAlternateFieldName());
    assertNull(nextResult4.getAlternateFieldName());
    assertNull(getResult.getAlternateFieldName());
    assertNull(getResult2.getAlternateFieldName());
    assertNull(nextResult.getFullyQualifiedName());
    assertNull(nextResult2.getFullyQualifiedName());
    assertNull(nextResult3.getFullyQualifiedName());
    assertNull(nextResult4.getFullyQualifiedName());
    assertNull(getResult.getFullyQualifiedName());
    assertNull(getResult2.getFullyQualifiedName());
    assertNull(nextResult.getMappingName());
    assertNull(nextResult2.getMappingName());
    assertNull(nextResult3.getMappingName());
    assertNull(nextResult4.getMappingName());
    assertNull(getResult.getMappingName());
    assertNull(getResult2.getMappingName());
    assertNull(nextResult.getPartialName());
    assertNull(nextResult2.getPartialName());
    assertNull(nextResult3.getPartialName());
    assertNull(nextResult4.getPartialName());
    assertNull(getResult.getPartialName());
    assertNull(getResult2.getPartialName());
    assertNull(nextResult.getActions());
    assertNull(nextResult2.getActions());
    assertNull(nextResult3.getActions());
    assertNull(nextResult4.getActions());
    assertNull(getResult.getActions());
    assertNull(getResult2.getActions());
    assertNull(nextResult.getParent());
    assertNull(nextResult2.getParent());
    assertNull(nextResult3.getParent());
    assertNull(nextResult4.getParent());
    assertNull(getResult.getParent());
    assertNull(getResult2.getParent());
    assertEquals(0, nextResult.getFieldFlags());
    assertEquals(0, nextResult2.getFieldFlags());
    assertEquals(0, nextResult3.getFieldFlags());
    assertEquals(0, nextResult4.getFieldFlags());
    assertEquals(0, getResult.getFieldFlags());
    assertEquals(0, getResult2.getFieldFlags());
    Set<String> onValues = ((PDCheckBox) nextResult).getOnValues();
    assertEquals(1, onValues.size());
    Set<String> onValues2 = ((PDCheckBox) nextResult2).getOnValues();
    assertEquals(1, onValues2.size());
    Set<String> onValues3 = ((PDCheckBox) nextResult3).getOnValues();
    assertEquals(1, onValues3.size());
    Set<String> onValues4 = ((PDCheckBox) nextResult4).getOnValues();
    assertEquals(1, onValues4.size());
    Set<String> onValues5 = ((PDCheckBox) getResult).getOnValues();
    assertEquals(1, onValues5.size());
    Set<String> onValues6 = ((PDCheckBox) getResult2).getOnValues();
    assertEquals(1, onValues6.size());
    assertFalse(fieldIterator.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(((PDCheckBox) nextResult).isPushButton());
    assertFalse(((PDCheckBox) nextResult2).isPushButton());
    assertFalse(((PDCheckBox) nextResult3).isPushButton());
    assertFalse(((PDCheckBox) nextResult4).isPushButton());
    assertFalse(((PDCheckBox) getResult).isPushButton());
    assertFalse(((PDCheckBox) getResult2).isPushButton());
    assertFalse(((PDCheckBox) nextResult).isRadioButton());
    assertFalse(((PDCheckBox) nextResult2).isRadioButton());
    assertFalse(((PDCheckBox) nextResult3).isRadioButton());
    assertFalse(((PDCheckBox) nextResult4).isRadioButton());
    assertFalse(((PDCheckBox) getResult).isRadioButton());
    assertFalse(((PDCheckBox) getResult2).isRadioButton());
    assertFalse(nextResult.isNoExport());
    assertFalse(nextResult2.isNoExport());
    assertFalse(nextResult3.isNoExport());
    assertFalse(nextResult4.isNoExport());
    assertFalse(getResult.isNoExport());
    assertFalse(getResult2.isNoExport());
    assertFalse(nextResult.isReadOnly());
    assertFalse(nextResult2.isReadOnly());
    assertFalse(nextResult3.isReadOnly());
    assertFalse(nextResult4.isReadOnly());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult2.isReadOnly());
    assertFalse(nextResult.isRequired());
    assertFalse(nextResult2.isRequired());
    assertFalse(nextResult3.isRequired());
    assertFalse(nextResult4.isRequired());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertTrue(onValues.contains(""));
    assertTrue(onValues2.contains(""));
    assertTrue(onValues3.contains(""));
    assertTrue(onValues4.contains(""));
    assertTrue(onValues5.contains(""));
    assertTrue(onValues6.contains(""));
    assertSame(pdAcroForm, nextResult.getAcroForm());
    assertSame(pdAcroForm, nextResult2.getAcroForm());
    assertSame(pdAcroForm, nextResult3.getAcroForm());
    assertSame(pdAcroForm, nextResult4.getAcroForm());
    assertSame(pdAcroForm, getResult.getAcroForm());
    assertSame(pdAcroForm, getResult2.getAcroForm());
  }

  /**
   * Method under test: {@link PDAcroForm#setFields(List)}
   */
  @Test
  void testSetFields4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(null);

    // Act
    pdAcroForm.setFields(fields);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(pdAcroForm.getFieldIterator().hasNext());
    assertFalse(pdAcroForm.getFieldTree().iterator().hasNext());
    assertTrue(pdAcroForm.getFields().isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#getFieldIterator()}
   */
  @Test
  void testGetFieldIterator() {
    // Arrange, Act and Assert
    assertFalse((new PDAcroForm(new PDDocument())).getFieldIterator().hasNext());
  }

  /**
   * Method under test: {@link PDAcroForm#getFieldIterator()}
   */
  @Test
  void testGetFieldIterator2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    Iterator<PDField> actualFieldIterator = (new PDAcroForm(new PDDocument(streamCacheCreateFunction)))
        .getFieldIterator();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualFieldIterator.hasNext());
  }

  /**
   * Method under test: {@link PDAcroForm#getFieldIterator()}
   */
  @Test
  void testGetFieldIterator3() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertFalse((new PDAcroForm(doc, new COSDictionary())).getFieldIterator().hasNext());
  }

  /**
   * Method under test: {@link PDAcroForm#getFieldTree()}
   */
  @Test
  void testGetFieldTree() {
    // Arrange, Act and Assert
    assertFalse((new PDAcroForm(new PDDocument())).getFieldTree().iterator().hasNext());
  }

  /**
   * Method under test: {@link PDAcroForm#getFieldTree()}
   */
  @Test
  void testGetFieldTree2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    Iterator<PDField> actualIteratorResult = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).getFieldTree()
        .iterator();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link PDAcroForm#getFieldTree()}
   */
  @Test
  void testGetFieldTree3() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertFalse((new PDAcroForm(doc, new COSDictionary())).getFieldTree().iterator().hasNext());
  }

  /**
   * Method under test: {@link PDAcroForm#setCacheFields(boolean)}
   */
  @Test
  void testSetCacheFields() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setCacheFields(true);

    // Assert
    assertTrue(pdAcroForm.isCachingFields());
  }

  /**
   * Method under test: {@link PDAcroForm#setCacheFields(boolean)}
   */
  @Test
  void testSetCacheFields2() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setCacheFields(false);

    // Assert
    assertFalse(pdAcroForm.isCachingFields());
  }

  /**
   * Method under test: {@link PDAcroForm#setCacheFields(boolean)}
   */
  @Test
  void testSetCacheFields3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setCacheFields(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(pdAcroForm.isCachingFields());
  }

  /**
   * Method under test: {@link PDAcroForm#setCacheFields(boolean)}
   */
  @Test
  void testSetCacheFields4() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm pdAcroForm = new PDAcroForm(doc, new COSDictionary());

    // Act
    pdAcroForm.setCacheFields(true);

    // Assert
    assertTrue(pdAcroForm.isCachingFields());
  }

  /**
   * Method under test: {@link PDAcroForm#isCachingFields()}
   */
  @Test
  void testIsCachingFields() {
    // Arrange, Act and Assert
    assertFalse((new PDAcroForm(new PDDocument())).isCachingFields());
  }

  /**
   * Method under test: {@link PDAcroForm#isCachingFields()}
   */
  @Test
  void testIsCachingFields2() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setCacheFields(true);

    // Act and Assert
    assertTrue(pdAcroForm.isCachingFields());
  }

  /**
   * Method under test: {@link PDAcroForm#isCachingFields()}
   */
  @Test
  void testIsCachingFields3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsCachingFieldsResult = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).isCachingFields();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsCachingFieldsResult);
  }

  /**
   * Method under test: {@link PDAcroForm#getField(String)}
   */
  @Test
  void testGetField() {
    // Arrange, Act and Assert
    assertNull((new PDAcroForm(new PDDocument())).getField("Dr Jane Doe"));
  }

  /**
   * Method under test: {@link PDAcroForm#getField(String)}
   */
  @Test
  void testGetField2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDField actualField = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).getField("Dr Jane Doe");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualField);
  }

  /**
   * Method under test: {@link PDAcroForm#getField(String)}
   */
  @Test
  void testGetField3() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDAcroForm(doc, new COSDictionary())).getField("Dr Jane Doe"));
  }

  /**
   * Method under test: {@link PDAcroForm#getField(String)}
   */
  @Test
  void testGetField4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setCacheFields(true);

    // Act
    PDField actualField = pdAcroForm.getField("Dr Jane Doe");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualField);
  }

  /**
   * Method under test: {@link PDAcroForm#getDefaultAppearance()}
   */
  @Test
  void testGetDefaultAppearance() {
    // Arrange, Act and Assert
    assertEquals("", (new PDAcroForm(new PDDocument())).getDefaultAppearance());
  }

  /**
   * Method under test: {@link PDAcroForm#getDefaultAppearance()}
   */
  @Test
  void testGetDefaultAppearance2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualDefaultAppearance = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).getDefaultAppearance();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualDefaultAppearance);
  }

  /**
   * Method under test: {@link PDAcroForm#getDefaultAppearance()}
   */
  @Test
  void testGetDefaultAppearance3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setDefaultAppearance("42");

    // Act
    String actualDefaultAppearance = pdAcroForm.getDefaultAppearance();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", actualDefaultAppearance);
  }

  /**
   * Method under test: {@link PDAcroForm#getDefaultAppearance()}
   */
  @Test
  void testGetDefaultAppearance4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setDefaultAppearance("");

    // Act
    String actualDefaultAppearance = pdAcroForm.getDefaultAppearance();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualDefaultAppearance);
  }

  /**
   * Method under test: {@link PDAcroForm#setDefaultAppearance(String)}
   */
  @Test
  void testSetDefaultAppearance() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setDefaultAppearance("42");

    // Assert
    assertEquals("42", pdAcroForm.getDefaultAppearance());
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAcroForm#setDefaultAppearance(String)}
   */
  @Test
  void testSetDefaultAppearance2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setDefaultAppearance("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", pdAcroForm.getDefaultAppearance());
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAcroForm#getNeedAppearances()}
   */
  @Test
  void testGetNeedAppearances() {
    // Arrange, Act and Assert
    assertFalse((new PDAcroForm(new PDDocument())).getNeedAppearances());
  }

  /**
   * Method under test: {@link PDAcroForm#getNeedAppearances()}
   */
  @Test
  void testGetNeedAppearances2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualNeedAppearances = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).getNeedAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualNeedAppearances);
  }

  /**
   * Method under test: {@link PDAcroForm#getNeedAppearances()}
   */
  @Test
  void testGetNeedAppearances3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setNeedAppearances(true);

    // Act
    boolean actualNeedAppearances = pdAcroForm.getNeedAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualNeedAppearances);
  }

  /**
   * Method under test: {@link PDAcroForm#getNeedAppearances()}
   */
  @Test
  void testGetNeedAppearances4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setNeedAppearances(false);

    // Act
    boolean actualNeedAppearances = pdAcroForm.getNeedAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualNeedAppearances);
  }

  /**
   * Method under test: {@link PDAcroForm#setNeedAppearances(Boolean)}
   */
  @Test
  void testSetNeedAppearances() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setNeedAppearances(true);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.getNeedAppearances());
  }

  /**
   * Method under test: {@link PDAcroForm#setNeedAppearances(Boolean)}
   */
  @Test
  void testSetNeedAppearances2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setNeedAppearances(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.getNeedAppearances());
  }

  /**
   * Method under test: {@link PDAcroForm#setNeedAppearances(Boolean)}
   */
  @Test
  void testSetNeedAppearances3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setNeedAppearances(false);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdAcroForm.getNeedAppearances());
  }

  /**
   * Method under test: {@link PDAcroForm#getDefaultResources()}
   */
  @Test
  void testGetDefaultResources() {
    // Arrange, Act and Assert
    assertNull((new PDAcroForm(new PDDocument())).getDefaultResources());
  }

  /**
   * Method under test: {@link PDAcroForm#getDefaultResources()}
   */
  @Test
  void testGetDefaultResources2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDResources actualDefaultResources = (new PDAcroForm(new PDDocument(streamCacheCreateFunction)))
        .getDefaultResources();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDefaultResources);
  }

  /**
   * Method under test: {@link PDAcroForm#getDefaultResources()}
   */
  @Test
  void testGetDefaultResources3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setDefaultResources(new PDResources());

    // Act
    PDResources actualDefaultResources = pdAcroForm.getDefaultResources();

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterable<COSName> colorSpaceNames = actualDefaultResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    assertTrue(actualDefaultResources.getResourceCache() instanceof DefaultResourceCache);
    COSDictionary cOSObject = actualDefaultResources.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, actualDefaultResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualDefaultResources.getFontNames());
    assertSame(colorSpaceNames, actualDefaultResources.getPatternNames());
    assertSame(colorSpaceNames, actualDefaultResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualDefaultResources.getShadingNames());
    assertSame(colorSpaceNames, actualDefaultResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDAcroForm#setDefaultResources(PDResources)}
   */
  @Test
  void testSetDefaultResources() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm pdAcroForm = new PDAcroForm(doc);

    // Act
    pdAcroForm.setDefaultResources(new PDResources());

    // Assert
    ResourceCache resourceCache = pdAcroForm.getDefaultResources().getResourceCache();
    assertTrue(resourceCache instanceof DefaultResourceCache);
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    PDDocument document = pdAcroForm.getDocument();
    assertSame(doc, document);
    assertSame(resourceCache, document.getResourceCache());
  }

  /**
   * Method under test: {@link PDAcroForm#setDefaultResources(PDResources)}
   */
  @Test
  void testSetDefaultResources2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm pdAcroForm = new PDAcroForm(doc);

    // Act
    pdAcroForm.setDefaultResources(new PDResources());

    // Assert
    verify(streamCacheCreateFunction).create();
    ResourceCache resourceCache = pdAcroForm.getDefaultResources().getResourceCache();
    assertTrue(resourceCache instanceof DefaultResourceCache);
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    PDDocument document = pdAcroForm.getDocument();
    assertSame(doc, document);
    assertSame(resourceCache, document.getResourceCache());
  }

  /**
   * Method under test: {@link PDAcroForm#setDefaultResources(PDResources)}
   */
  @Test
  void testSetDefaultResources3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm pdAcroForm = new PDAcroForm(doc);

    // Act
    pdAcroForm.setDefaultResources(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDDocument document = pdAcroForm.getDocument();
    assertTrue(document.getResourceCache() instanceof DefaultResourceCache);
    assertNull(pdAcroForm.getDefaultResources());
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(doc, document);
  }

  /**
   * Method under test: {@link PDAcroForm#hasXFA()}
   */
  @Test
  void testHasXFA() {
    // Arrange, Act and Assert
    assertFalse((new PDAcroForm(new PDDocument())).hasXFA());
  }

  /**
   * Method under test: {@link PDAcroForm#hasXFA()}
   */
  @Test
  void testHasXFA2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualHasXFAResult = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).hasXFA();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasXFAResult);
  }

  /**
   * Method under test: {@link PDAcroForm#hasXFA()}
   */
  @Test
  void testHasXFA3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setXFA(new PDXFAResource(COSBoolean.FALSE));

    // Act
    boolean actualHasXFAResult = pdAcroForm.hasXFA();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualHasXFAResult);
  }

  /**
   * Method under test: {@link PDAcroForm#xfaIsDynamic()}
   */
  @Test
  void testXfaIsDynamic() {
    // Arrange, Act and Assert
    assertFalse((new PDAcroForm(new PDDocument())).xfaIsDynamic());
  }

  /**
   * Method under test: {@link PDAcroForm#xfaIsDynamic()}
   */
  @Test
  void testXfaIsDynamic2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualXfaIsDynamicResult = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).xfaIsDynamic();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualXfaIsDynamicResult);
  }

  /**
   * Method under test: {@link PDAcroForm#xfaIsDynamic()}
   */
  @Test
  void testXfaIsDynamic3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setXFA(new PDXFAResource(COSBoolean.FALSE));

    // Act
    boolean actualXfaIsDynamicResult = pdAcroForm.xfaIsDynamic();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualXfaIsDynamicResult);
  }

  /**
   * Method under test: {@link PDAcroForm#xfaIsDynamic()}
   */
  @Test
  void testXfaIsDynamic4() {
    // Arrange
    PDDocument doc = new PDDocument();

    PDAcroForm pdAcroForm = new PDAcroForm(doc, new COSDictionary());
    pdAcroForm.setXFA(new PDXFAResource(COSBoolean.FALSE));

    // Act and Assert
    assertTrue(pdAcroForm.xfaIsDynamic());
  }

  /**
   * Method under test: {@link PDAcroForm#getXFA()}
   */
  @Test
  void testGetXFA() {
    // Arrange, Act and Assert
    assertNull((new PDAcroForm(new PDDocument())).getXFA());
  }

  /**
   * Method under test: {@link PDAcroForm#getXFA()}
   */
  @Test
  void testGetXFA2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDXFAResource actualXFA = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).getXFA();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualXFA);
  }

  /**
   * Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  void testSetXFA() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setXFA(new PDXFAResource(COSBoolean.FALSE));

    // Assert
    assertEquals(0, pdAcroForm.getXFA().getBytes().length);
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  void testSetXFA2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setXFA(new PDXFAResource(COSBoolean.FALSE));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, pdAcroForm.getXFA().getBytes().length);
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  void testSetXFA3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    COSDictionary xfaBase = new COSDictionary();

    // Act
    pdAcroForm.setXFA(new PDXFAResource(xfaBase));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDXFAResource xFA = pdAcroForm.getXFA();
    assertEquals(0, xFA.getBytes().length);
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(xfaBase, xFA.getCOSObject());
  }

  /**
   * Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  void testSetXFA4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    COSArray xfaBase = new COSArray();

    // Act
    pdAcroForm.setXFA(new PDXFAResource(xfaBase));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDXFAResource xFA = pdAcroForm.getXFA();
    assertEquals(0, xFA.getBytes().length);
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(xfaBase, xFA.getCOSObject());
  }

  /**
   * Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  void testSetXFA5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setXFA(new PDXFAResource(null));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(pdAcroForm.getXFA());
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  void testSetXFA6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setXFA(new PDXFAResource(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, pdAcroForm.getXFA().getBytes().length);
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  void testSetXFA7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setXFA(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(pdAcroForm.getXFA());
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  void testSetXFA8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    COSDictionary xfaBase = new COSDictionary();
    xfaBase.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAcroForm.setXFA(new PDXFAResource(xfaBase));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDXFAResource xFA = pdAcroForm.getXFA();
    assertEquals(0, xFA.getBytes().length);
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(xfaBase, xFA.getCOSObject());
  }

  /**
   * Method under test: {@link PDAcroForm#getQ()}
   */
  @Test
  void testGetQ() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAcroForm(new PDDocument())).getQ());
  }

  /**
   * Method under test: {@link PDAcroForm#getQ()}
   */
  @Test
  void testGetQ2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualQ = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).getQ();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualQ);
  }

  /**
   * Method under test: {@link PDAcroForm#getQ()}
   */
  @Test
  void testGetQ3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setQ(1);

    // Act
    int actualQ = pdAcroForm.getQ();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualQ);
  }

  /**
   * Method under test: {@link PDAcroForm#setQ(int)}
   */
  @Test
  void testSetQ() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setQ(1);

    // Assert
    assertEquals(1, pdAcroForm.getQ());
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAcroForm#setQ(int)}
   */
  @Test
  void testSetQ2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setQ(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, pdAcroForm.getQ());
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAcroForm#setQ(int)}
   */
  @Test
  void testSetQ3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setQ(Integer.MIN_VALUE);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdAcroForm.getQ());
  }

  /**
   * Method under test: {@link PDAcroForm#isSignaturesExist()}
   */
  @Test
  void testIsSignaturesExist() {
    // Arrange, Act and Assert
    assertFalse((new PDAcroForm(new PDDocument())).isSignaturesExist());
  }

  /**
   * Method under test: {@link PDAcroForm#isSignaturesExist()}
   */
  @Test
  void testIsSignaturesExist2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsSignaturesExistResult = (new PDAcroForm(new PDDocument(streamCacheCreateFunction)))
        .isSignaturesExist();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsSignaturesExistResult);
  }

  /**
   * Method under test: {@link PDAcroForm#isSignaturesExist()}
   */
  @Test
  void testIsSignaturesExist3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setSignaturesExist(true);

    // Act
    boolean actualIsSignaturesExistResult = pdAcroForm.isSignaturesExist();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsSignaturesExistResult);
  }

  /**
   * Method under test: {@link PDAcroForm#setSignaturesExist(boolean)}
   */
  @Test
  void testSetSignaturesExist() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setSignaturesExist(true);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.isSignaturesExist());
  }

  /**
   * Method under test: {@link PDAcroForm#setSignaturesExist(boolean)}
   */
  @Test
  void testSetSignaturesExist2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setSignaturesExist(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.isSignaturesExist());
  }

  /**
   * Method under test: {@link PDAcroForm#setSignaturesExist(boolean)}
   */
  @Test
  void testSetSignaturesExist3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setSignaturesExist(false);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdAcroForm.isSignaturesExist());
  }

  /**
   * Method under test: {@link PDAcroForm#setSignaturesExist(boolean)}
   */
  @Test
  void testSetSignaturesExist4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setAppendOnly(true);

    // Act
    pdAcroForm.setSignaturesExist(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.isSignaturesExist());
  }

  /**
   * Method under test: {@link PDAcroForm#isAppendOnly()}
   */
  @Test
  void testIsAppendOnly() {
    // Arrange, Act and Assert
    assertFalse((new PDAcroForm(new PDDocument())).isAppendOnly());
  }

  /**
   * Method under test: {@link PDAcroForm#isAppendOnly()}
   */
  @Test
  void testIsAppendOnly2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsAppendOnlyResult = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).isAppendOnly();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsAppendOnlyResult);
  }

  /**
   * Method under test: {@link PDAcroForm#isAppendOnly()}
   */
  @Test
  void testIsAppendOnly3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setSignaturesExist(true);

    // Act
    boolean actualIsAppendOnlyResult = pdAcroForm.isAppendOnly();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsAppendOnlyResult);
  }

  /**
   * Method under test: {@link PDAcroForm#isAppendOnly()}
   */
  @Test
  void testIsAppendOnly4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setAppendOnly(true);

    // Act
    boolean actualIsAppendOnlyResult = pdAcroForm.isAppendOnly();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsAppendOnlyResult);
  }

  /**
   * Method under test: {@link PDAcroForm#setAppendOnly(boolean)}
   */
  @Test
  void testSetAppendOnly() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setAppendOnly(true);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.isAppendOnly());
  }

  /**
   * Method under test: {@link PDAcroForm#setAppendOnly(boolean)}
   */
  @Test
  void testSetAppendOnly2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setAppendOnly(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.isAppendOnly());
  }

  /**
   * Method under test: {@link PDAcroForm#setAppendOnly(boolean)}
   */
  @Test
  void testSetAppendOnly3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setAppendOnly(false);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdAcroForm.isAppendOnly());
  }

  /**
   * Method under test: {@link PDAcroForm#setAppendOnly(boolean)}
   */
  @Test
  void testSetAppendOnly4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setSignaturesExist(true);

    // Act
    pdAcroForm.setAppendOnly(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.isAppendOnly());
  }

  /**
   * Method under test: {@link PDAcroForm#getCalcOrder()}
   */
  @Test
  void testGetCalcOrder() {
    // Arrange, Act and Assert
    assertTrue((new PDAcroForm(new PDDocument())).getCalcOrder().isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#getCalcOrder()}
   */
  @Test
  void testGetCalcOrder2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<PDField> actualCalcOrder = (new PDAcroForm(new PDDocument(streamCacheCreateFunction))).getCalcOrder();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCalcOrder.isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#getCalcOrder()}
   */
  @Test
  void testGetCalcOrder3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    pdAcroForm.setCalcOrder(new ArrayList<>());

    // Act
    List<PDField> actualCalcOrder = pdAcroForm.getCalcOrder();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCalcOrder.isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#getCalcOrder()}
   */
  @Test
  void testGetCalcOrder4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    PDAcroForm pdAcroForm = new PDAcroForm(doc);
    pdAcroForm.setCalcOrder(fields);

    // Act
    List<PDField> actualCalcOrder = pdAcroForm.getCalcOrder();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCalcOrder.isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#getCalcOrder()}
   */
  @Test
  void testGetCalcOrder5() {
    // Arrange
    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));
    PDDocument doc = new PDDocument();

    PDAcroForm pdAcroForm = new PDAcroForm(doc, new COSDictionary());
    pdAcroForm.setCalcOrder(fields);

    // Act and Assert
    assertTrue(pdAcroForm.getCalcOrder().isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#getCalcOrder()}
   */
  @Test
  void testGetCalcOrder6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    PDAcroForm pdAcroForm = new PDAcroForm(doc);
    pdAcroForm.setCacheFields(true);
    pdAcroForm.setCalcOrder(fields);

    // Act
    List<PDField> actualCalcOrder = pdAcroForm.getCalcOrder();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCalcOrder.isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#setCalcOrder(List)}
   */
  @Test
  void testSetCalcOrder() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setCalcOrder(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAcroForm#setCalcOrder(List)}
   */
  @Test
  void testSetCalcOrder2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    pdAcroForm.setCalcOrder(new ArrayList<>());

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.getCalcOrder().isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#setCalcOrder(List)}
   */
  @Test
  void testSetCalcOrder3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.setCalcOrder(fields);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.getCalcOrder().isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#setCalcOrder(List)}
   */
  @Test
  void testSetCalcOrder4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.setCalcOrder(fields);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.getCalcOrder().isEmpty());
  }

  /**
   * Method under test: {@link PDAcroForm#setCalcOrder(List)}
   */
  @Test
  void testSetCalcOrder5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(null);

    // Act
    pdAcroForm.setCalcOrder(fields);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.getCalcOrder().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)}
   *   <li>{@link PDAcroForm#setScriptingHandler(ScriptingHandler)}
   *   <li>{@link PDAcroForm#getDocument()}
   *   <li>{@link PDAcroForm#getScriptingHandler()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary form = new COSDictionary();

    // Act
    PDAcroForm actualPdAcroForm = new PDAcroForm(doc, form);
    ScriptingHandler scriptingHandler = mock(ScriptingHandler.class);
    actualPdAcroForm.setScriptingHandler(scriptingHandler);
    PDDocument actualDocument = actualPdAcroForm.getDocument();
    ScriptingHandler actualScriptingHandler = actualPdAcroForm.getScriptingHandler();

    // Assert that nothing has changed
    assertSame(form, actualPdAcroForm.getCOSObject());
    assertSame(doc, actualDocument);
    assertSame(scriptingHandler, actualScriptingHandler);
  }

  /**
   * Method under test: {@link PDAcroForm#PDAcroForm(PDDocument)}
   */
  @Test
  void testNewPDAcroForm() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act
    PDAcroForm actualPdAcroForm = new PDAcroForm(doc);

    // Assert
    assertEquals("", actualPdAcroForm.getDefaultAppearance());
    COSDictionary cOSObject = actualPdAcroForm.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAcroForm.getDefaultResources());
    assertNull(actualPdAcroForm.getXFA());
    assertNull(actualPdAcroForm.getScriptingHandler());
    assertEquals(0, actualPdAcroForm.getQ());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualPdAcroForm.getFieldIterator().hasNext());
    assertFalse(actualPdAcroForm.getFieldTree().iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAcroForm.getNeedAppearances());
    assertFalse(actualPdAcroForm.isAppendOnly());
    assertFalse(actualPdAcroForm.isCachingFields());
    assertFalse(actualPdAcroForm.isSignaturesExist());
    assertTrue(actualPdAcroForm.getCalcOrder().isEmpty());
    assertTrue(actualPdAcroForm.getFields().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(doc, actualPdAcroForm.getDocument());
  }

  /**
   * Method under test: {@link PDAcroForm#PDAcroForm(PDDocument)}
   */
  @Test
  void testNewPDAcroForm2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    // Act
    PDAcroForm actualPdAcroForm = new PDAcroForm(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualPdAcroForm.getDefaultAppearance());
    COSDictionary cOSObject = actualPdAcroForm.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAcroForm.getDefaultResources());
    assertNull(actualPdAcroForm.getXFA());
    assertNull(actualPdAcroForm.getScriptingHandler());
    assertEquals(0, actualPdAcroForm.getQ());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualPdAcroForm.getFieldIterator().hasNext());
    assertFalse(actualPdAcroForm.getFieldTree().iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAcroForm.getNeedAppearances());
    assertFalse(actualPdAcroForm.isAppendOnly());
    assertFalse(actualPdAcroForm.isCachingFields());
    assertFalse(actualPdAcroForm.isSignaturesExist());
    assertTrue(actualPdAcroForm.getCalcOrder().isEmpty());
    assertTrue(actualPdAcroForm.getFields().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(doc, actualPdAcroForm.getDocument());
  }
}
