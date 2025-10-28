package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.Test;

class PDNonTerminalFieldDiffblueTest {
  /**
   * Method under test: {@link PDNonTerminalField#getFieldFlags()}
   */
  @Test
  void testGetFieldFlags() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getFieldFlags());
  }

  /**
   * Method under test: {@link PDNonTerminalField#getFieldFlags()}
   */
  @Test
  void testGetFieldFlags2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualFieldFlags = (new PDNonTerminalField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getFieldFlags();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualFieldFlags);
  }

  /**
   * Method under test: {@link PDNonTerminalField#getFieldFlags()}
   */
  @Test
  void testGetFieldFlags3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdNonTerminalField.setReadOnly(true);

    // Act
    int actualFieldFlags = pdNonTerminalField.getFieldFlags();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualFieldFlags);
  }

  /**
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdNonTerminalField.importFDF(new FDFField());

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertEquals(0, pdNonTerminalField.getFieldFlags());
    assertFalse(pdNonTerminalField.isNoExport());
    assertFalse(pdNonTerminalField.isReadOnly());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdNonTerminalField.setReadOnly(true);

    // Act
    pdNonTerminalField.importFDF(new FDFField());

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdNonTerminalField.getFieldFlags());
    assertFalse(pdNonTerminalField.isNoExport());
    assertTrue(pdNonTerminalField.isReadOnly());
  }

  /**
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setKids(new ArrayList<>());

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdNonTerminalField.getValueAsString());
    assertNull(pdNonTerminalField.getValue());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertEquals(0, pdNonTerminalField.getFieldFlags());
    assertFalse(pdNonTerminalField.isNoExport());
    assertFalse(pdNonTerminalField.isReadOnly());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setValue("Value");

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("COSString{Value}", pdNonTerminalField.getValueAsString());
    assertEquals(0, pdNonTerminalField.getFieldFlags());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdNonTerminalField.isNoExport());
    assertFalse(pdNonTerminalField.isReadOnly());
  }

  /**
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setFieldFlags((Integer) 1);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdNonTerminalField.getValueAsString());
    assertNull(pdNonTerminalField.getValue());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdNonTerminalField.getFieldFlags());
    assertFalse(pdNonTerminalField.isNoExport());
    assertTrue(pdNonTerminalField.isReadOnly());
  }

  /**
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setSetFieldFlags((Integer) 1);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdNonTerminalField.getValueAsString());
    assertNull(pdNonTerminalField.getValue());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdNonTerminalField.getFieldFlags());
    assertFalse(pdNonTerminalField.isNoExport());
    assertTrue(pdNonTerminalField.isReadOnly());
  }

  /**
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setClearFieldFlags((Integer) 1);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdNonTerminalField.getValueAsString());
    assertNull(pdNonTerminalField.getValue());
    assertEquals(0, pdNonTerminalField.getFieldFlags());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdNonTerminalField.isNoExport());
    assertFalse(pdNonTerminalField.isReadOnly());
  }

  /**
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<FDFField> kids = new ArrayList<>();
    kids.add(new FDFField());

    FDFField fdfField = new FDFField();
    fdfField.setKids(kids);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdNonTerminalField.getValueAsString());
    assertNull(pdNonTerminalField.getValue());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertEquals(0, pdNonTerminalField.getFieldFlags());
    assertFalse(pdNonTerminalField.isNoExport());
    assertFalse(pdNonTerminalField.isReadOnly());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    COSArray cosArray = new COSArray();
    fdfField.setValue((Object) cosArray);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("COSArray{[]}", pdNonTerminalField.getValueAsString());
    assertEquals(0, pdNonTerminalField.getFieldFlags());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdNonTerminalField.isNoExport());
    assertFalse(pdNonTerminalField.isReadOnly());
    assertSame(cosArray, pdNonTerminalField.getValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    COSStream cosStream = new COSStream();
    fdfField.setValue((Object) cosStream);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("COSDictionary{Create InputStream called without data being written before to stream.}",
        pdNonTerminalField.getValueAsString());
    assertEquals(0, pdNonTerminalField.getFieldFlags());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdNonTerminalField.isNoExport());
    assertFalse(pdNonTerminalField.isReadOnly());
    assertSame(cosStream, pdNonTerminalField.getValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setValue(COSName.A);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("COSName{A}", pdNonTerminalField.getValueAsString());
    assertEquals(0, pdNonTerminalField.getFieldFlags());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdNonTerminalField.isNoExport());
    assertFalse(pdNonTerminalField.isReadOnly());
  }

  /**
   * Method under test: {@link PDNonTerminalField#exportFDF()}
   */
  @Test
  void testExportFDF() throws IOException {
    // Arrange and Act
    FDFField actualExportFDFResult = (new PDNonTerminalField(new PDAcroForm(new PDDocument()))).exportFDF();

    // Assert
    assertNull(actualExportFDFResult.getClearFieldFlags());
    assertNull(actualExportFDFResult.getClearWidgetFieldFlags());
    assertNull(actualExportFDFResult.getFieldFlags());
    assertNull(actualExportFDFResult.getSetFieldFlags());
    assertNull(actualExportFDFResult.getSetWidgetFieldFlags());
    assertNull(actualExportFDFResult.getWidgetFieldFlags());
    assertNull(actualExportFDFResult.getValue());
    assertNull(actualExportFDFResult.getPartialFieldName());
    assertNull(actualExportFDFResult.getRichText());
    assertNull(actualExportFDFResult.getOptions());
    assertNull(actualExportFDFResult.getCOSValue());
    COSDictionary cOSObject = actualExportFDFResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualExportFDFResult.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#exportFDF()}
   */
  @Test
  void testExportFDF2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    FDFField actualExportFDFResult = (new PDNonTerminalField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .exportFDF();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualExportFDFResult.getClearFieldFlags());
    assertNull(actualExportFDFResult.getClearWidgetFieldFlags());
    assertNull(actualExportFDFResult.getFieldFlags());
    assertNull(actualExportFDFResult.getSetFieldFlags());
    assertNull(actualExportFDFResult.getSetWidgetFieldFlags());
    assertNull(actualExportFDFResult.getWidgetFieldFlags());
    assertNull(actualExportFDFResult.getValue());
    assertNull(actualExportFDFResult.getPartialFieldName());
    assertNull(actualExportFDFResult.getRichText());
    assertNull(actualExportFDFResult.getOptions());
    assertNull(actualExportFDFResult.getCOSValue());
    COSDictionary cOSObject = actualExportFDFResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualExportFDFResult.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#exportFDF()}
   */
  @Test
  void testExportFDF3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdNonTerminalField.setPartialName("Name");

    // Act
    FDFField actualExportFDFResult = pdNonTerminalField.exportFDF();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Name", actualExportFDFResult.getPartialFieldName());
    assertNull(actualExportFDFResult.getClearFieldFlags());
    assertNull(actualExportFDFResult.getClearWidgetFieldFlags());
    assertNull(actualExportFDFResult.getFieldFlags());
    assertNull(actualExportFDFResult.getSetFieldFlags());
    assertNull(actualExportFDFResult.getSetWidgetFieldFlags());
    assertNull(actualExportFDFResult.getWidgetFieldFlags());
    assertNull(actualExportFDFResult.getValue());
    assertNull(actualExportFDFResult.getRichText());
    assertNull(actualExportFDFResult.getOptions());
    assertNull(actualExportFDFResult.getCOSValue());
    COSDictionary cOSObject = actualExportFDFResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualExportFDFResult.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#exportFDF()}
   */
  @Test
  void testExportFDF4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdNonTerminalField.setPartialName("");

    // Act
    FDFField actualExportFDFResult = pdNonTerminalField.exportFDF();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualExportFDFResult.getPartialFieldName());
    assertNull(actualExportFDFResult.getClearFieldFlags());
    assertNull(actualExportFDFResult.getClearWidgetFieldFlags());
    assertNull(actualExportFDFResult.getFieldFlags());
    assertNull(actualExportFDFResult.getSetFieldFlags());
    assertNull(actualExportFDFResult.getSetWidgetFieldFlags());
    assertNull(actualExportFDFResult.getWidgetFieldFlags());
    assertNull(actualExportFDFResult.getValue());
    assertNull(actualExportFDFResult.getRichText());
    assertNull(actualExportFDFResult.getOptions());
    assertNull(actualExportFDFResult.getCOSValue());
    COSDictionary cOSObject = actualExportFDFResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualExportFDFResult.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#getChildren()}
   */
  @Test
  void testGetChildren() {
    // Arrange, Act and Assert
    assertTrue((new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getChildren().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#getChildren()}
   */
  @Test
  void testGetChildren2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<PDField> actualChildren = (new PDNonTerminalField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getChildren();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualChildren.isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  void testSetChildren() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setChildren(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  void testSetChildren2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdNonTerminalField.setChildren(new ArrayList<>());

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdNonTerminalField.getChildren().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  void testSetChildren3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(acroForm);

    ArrayList<PDField> children = new ArrayList<>();
    children.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdNonTerminalField.setChildren(children);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<PDField> children2 = pdNonTerminalField.getChildren();
    assertEquals(1, children2.size());
    PDField getResult = children2.get(0);
    assertTrue(getResult instanceof PDCheckBox);
    assertEquals("", ((PDCheckBox) getResult).getDefaultValue());
    assertEquals("", ((PDCheckBox) getResult).getOnValue());
    assertEquals("Btn", getResult.getFieldType());
    assertEquals("Off", ((PDCheckBox) getResult).getValue());
    assertEquals("Off", getResult.getValueAsString());
    assertNull(getResult.getAlternateFieldName());
    assertNull(getResult.getFullyQualifiedName());
    assertNull(getResult.getMappingName());
    assertNull(getResult.getPartialName());
    assertNull(getResult.getActions());
    assertEquals(0, getResult.getFieldFlags());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> onValues = ((PDCheckBox) getResult).getOnValues();
    assertEquals(1, onValues.size());
    assertEquals(1, cOSObject.size());
    assertFalse(((PDCheckBox) getResult).isPushButton());
    assertFalse(((PDCheckBox) getResult).isRadioButton());
    assertFalse(getResult.isNoExport());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isRequired());
    assertTrue(onValues.contains(""));
    assertSame(acroForm, getResult.getAcroForm());
    assertSame(pdNonTerminalField, getResult.getParent());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  void testSetChildren4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(acroForm);

    ArrayList<PDField> children = new ArrayList<>();
    children.add(new PDCheckBox(new PDAcroForm(new PDDocument())));
    children.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdNonTerminalField.setChildren(children);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<PDField> children2 = pdNonTerminalField.getChildren();
    assertEquals(2, children2.size());
    PDField getResult = children2.get(0);
    assertTrue(getResult instanceof PDCheckBox);
    PDField getResult2 = children2.get(1);
    assertTrue(getResult2 instanceof PDCheckBox);
    assertEquals("", ((PDCheckBox) getResult).getDefaultValue());
    assertEquals("", ((PDCheckBox) getResult2).getDefaultValue());
    assertEquals("", ((PDCheckBox) getResult).getOnValue());
    assertEquals("", ((PDCheckBox) getResult2).getOnValue());
    assertEquals("Btn", getResult.getFieldType());
    assertEquals("Btn", getResult2.getFieldType());
    assertEquals("Off", ((PDCheckBox) getResult).getValue());
    assertEquals("Off", ((PDCheckBox) getResult2).getValue());
    assertEquals("Off", getResult.getValueAsString());
    assertEquals("Off", getResult2.getValueAsString());
    assertNull(getResult.getAlternateFieldName());
    assertNull(getResult2.getAlternateFieldName());
    assertNull(getResult.getFullyQualifiedName());
    assertNull(getResult2.getFullyQualifiedName());
    assertNull(getResult.getMappingName());
    assertNull(getResult2.getMappingName());
    assertNull(getResult.getPartialName());
    assertNull(getResult2.getPartialName());
    assertNull(getResult.getActions());
    assertNull(getResult2.getActions());
    assertEquals(0, getResult.getFieldFlags());
    assertEquals(0, getResult2.getFieldFlags());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> onValues = ((PDCheckBox) getResult).getOnValues();
    assertEquals(1, onValues.size());
    Set<String> onValues2 = ((PDCheckBox) getResult2).getOnValues();
    assertEquals(1, onValues2.size());
    assertEquals(1, cOSObject.size());
    assertFalse(((PDCheckBox) getResult).isPushButton());
    assertFalse(((PDCheckBox) getResult2).isPushButton());
    assertFalse(((PDCheckBox) getResult).isRadioButton());
    assertFalse(((PDCheckBox) getResult2).isRadioButton());
    assertFalse(getResult.isNoExport());
    assertFalse(getResult2.isNoExport());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult2.isReadOnly());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertTrue(onValues.contains(""));
    assertTrue(onValues2.contains(""));
    assertSame(acroForm, getResult.getAcroForm());
    assertSame(acroForm, getResult2.getAcroForm());
    assertSame(pdNonTerminalField, getResult.getParent());
    assertSame(pdNonTerminalField, getResult2.getParent());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  void testSetChildren5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<PDField> children = new ArrayList<>();
    children.add(null);

    // Act
    pdNonTerminalField.setChildren(children);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdNonTerminalField.getChildren().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#getFieldType()}
   */
  @Test
  void testGetFieldType() {
    // Arrange, Act and Assert
    assertNull((new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getFieldType());
  }

  /**
   * Method under test: {@link PDNonTerminalField#getFieldType()}
   */
  @Test
  void testGetFieldType2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualFieldType = (new PDNonTerminalField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getFieldType();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFieldType);
  }

  /**
   * Method under test: {@link PDNonTerminalField#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertNull((new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#getValue()}
   */
  @Test
  void testGetValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualValue = (new PDNonTerminalField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualValue);
  }

  /**
   * Method under test: {@link PDNonTerminalField#getValueAsString()}
   */
  @Test
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Method under test: {@link PDNonTerminalField#getValueAsString()}
   */
  @Test
  void testGetValueAsString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualValueAsString = (new PDNonTerminalField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getValueAsString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualValueAsString);
  }

  /**
   * Method under test: {@link PDNonTerminalField#setValue(String)}
   */
  @Test
  void testSetValue() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setValue("42");

    // Assert
    COSBase value = pdNonTerminalField.getValue();
    assertTrue(value instanceof COSString);
    assertEquals("3432", ((COSString) value).toHexString());
    assertEquals("42", ((COSString) value).getASCII());
    assertEquals("42", ((COSString) value).getString());
    assertEquals("COSString{42}", pdNonTerminalField.getValueAsString());
    assertNull(value.getKey());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(value.isDirect());
    assertFalse(((COSString) value).getForceHexForm());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) value).getBytes());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setValue(String)}
   */
  @Test
  void testSetValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdNonTerminalField.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase value = pdNonTerminalField.getValue();
    assertTrue(value instanceof COSString);
    assertEquals("3432", ((COSString) value).toHexString());
    assertEquals("42", ((COSString) value).getASCII());
    assertEquals("42", ((COSString) value).getString());
    assertEquals("COSString{42}", pdNonTerminalField.getValueAsString());
    assertNull(value.getKey());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(value.isDirect());
    assertFalse(((COSString) value).getForceHexForm());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) value).getBytes());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  void testSetValue3() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdNonTerminalField.setValue(object);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, pdNonTerminalField.getValueAsString());
    COSBoolean expectedValue = object.FALSE;
    assertSame(expectedValue, pdNonTerminalField.getValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  void testSetValue4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdNonTerminalField.setValue(object);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, pdNonTerminalField.getValueAsString());
    COSBoolean expectedValue = object.FALSE;
    assertSame(expectedValue, pdNonTerminalField.getValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  void testSetValue5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    COSDictionary object = new COSDictionary();

    // Act
    pdNonTerminalField.setValue(object);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("COSDictionary{}", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(object, pdNonTerminalField.getValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  void testSetValue6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    COSArray object = new COSArray();

    // Act
    pdNonTerminalField.setValue(object);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("COSArray{[]}", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(object, pdNonTerminalField.getValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  void testSetValue7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdNonTerminalField.setValue((COSBase) null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdNonTerminalField.getValueAsString());
    assertNull(pdNonTerminalField.getValue());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  void testSetValue8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdNonTerminalField.setValue(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, pdNonTerminalField.getValueAsString());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  void testSetValue9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    COSDictionary object = new COSDictionary();
    object.setKey(new COSObjectKey(1L, 1));

    // Act
    pdNonTerminalField.setValue(object);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("COSDictionary{}", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(object, pdNonTerminalField.getValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue() {
    // Arrange, Act and Assert
    assertNull((new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getDefaultValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualDefaultValue = (new PDNonTerminalField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getDefaultValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDefaultValue);
  }

  /**
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  void testSetDefaultValue() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    COSBoolean value = COSBoolean.FALSE;

    // Act
    pdNonTerminalField.setDefaultValue(value);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSBoolean expectedDefaultValue = value.FALSE;
    assertSame(expectedDefaultValue, pdNonTerminalField.getDefaultValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  void testSetDefaultValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    COSBoolean value = COSBoolean.FALSE;

    // Act
    pdNonTerminalField.setDefaultValue(value);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSBoolean expectedDefaultValue = value.FALSE;
    assertSame(expectedDefaultValue, pdNonTerminalField.getDefaultValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  void testSetDefaultValue3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    COSDictionary value = new COSDictionary();

    // Act
    pdNonTerminalField.setDefaultValue(value);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(value, pdNonTerminalField.getDefaultValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  void testSetDefaultValue4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    COSArray value = new COSArray();

    // Act
    pdNonTerminalField.setDefaultValue(value);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(value, pdNonTerminalField.getDefaultValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  void testSetDefaultValue5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdNonTerminalField.setDefaultValue(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(pdNonTerminalField.getDefaultValue());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  void testSetDefaultValue6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdNonTerminalField.setDefaultValue(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  void testSetDefaultValue7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    COSDictionary value = new COSDictionary();
    value.setKey(new COSObjectKey(1L, 1));

    // Act
    pdNonTerminalField.setDefaultValue(value);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(value, pdNonTerminalField.getDefaultValue());
  }

  /**
   * Method under test: {@link PDNonTerminalField#getWidgets()}
   */
  @Test
  void testGetWidgets() {
    // Arrange, Act and Assert
    assertTrue((new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getWidgets().isEmpty());
  }

  /**
   * Method under test: {@link PDNonTerminalField#getWidgets()}
   */
  @Test
  void testGetWidgets2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<PDAnnotationWidget> actualWidgets = (new PDNonTerminalField(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getWidgets();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualWidgets.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  void testNewPDNonTerminalField() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDNonTerminalField actualPdNonTerminalField = new PDNonTerminalField(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdNonTerminalField.getCOSObject());
    assertSame(acroForm, actualPdNonTerminalField.getAcroForm());
    assertSame(parent, actualPdNonTerminalField.getParent());
  }

  /**
   * Method under test: {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)}
   */
  @Test
  void testNewPDNonTerminalField2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDNonTerminalField actualPdNonTerminalField = new PDNonTerminalField(acroForm);

    // Assert
    assertEquals("", actualPdNonTerminalField.getValueAsString());
    assertNull(actualPdNonTerminalField.getAlternateFieldName());
    assertNull(actualPdNonTerminalField.getFullyQualifiedName());
    assertNull(actualPdNonTerminalField.getMappingName());
    assertNull(actualPdNonTerminalField.getPartialName());
    assertNull(actualPdNonTerminalField.getFieldType());
    assertNull(actualPdNonTerminalField.getDefaultValue());
    assertNull(actualPdNonTerminalField.getValue());
    COSDictionary cOSObject = actualPdNonTerminalField.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdNonTerminalField.getActions());
    assertNull(actualPdNonTerminalField.getParent());
    assertEquals(0, cOSObject.size());
    assertEquals(0, actualPdNonTerminalField.getFieldFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdNonTerminalField.isNoExport());
    assertFalse(actualPdNonTerminalField.isReadOnly());
    assertFalse(actualPdNonTerminalField.isRequired());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualPdNonTerminalField.getChildren().isEmpty());
    assertTrue(actualPdNonTerminalField.getWidgets().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(acroForm, actualPdNonTerminalField.getAcroForm());
  }

  /**
   * Method under test: {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)}
   */
  @Test
  void testNewPDNonTerminalField3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    PDNonTerminalField actualPdNonTerminalField = new PDNonTerminalField(acroForm);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualPdNonTerminalField.getValueAsString());
    assertNull(actualPdNonTerminalField.getAlternateFieldName());
    assertNull(actualPdNonTerminalField.getFullyQualifiedName());
    assertNull(actualPdNonTerminalField.getMappingName());
    assertNull(actualPdNonTerminalField.getPartialName());
    assertNull(actualPdNonTerminalField.getFieldType());
    assertNull(actualPdNonTerminalField.getDefaultValue());
    assertNull(actualPdNonTerminalField.getValue());
    COSDictionary cOSObject = actualPdNonTerminalField.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdNonTerminalField.getActions());
    assertNull(actualPdNonTerminalField.getParent());
    assertEquals(0, cOSObject.size());
    assertEquals(0, actualPdNonTerminalField.getFieldFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdNonTerminalField.isNoExport());
    assertFalse(actualPdNonTerminalField.isReadOnly());
    assertFalse(actualPdNonTerminalField.isRequired());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualPdNonTerminalField.getChildren().isEmpty());
    assertTrue(actualPdNonTerminalField.getWidgets().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(acroForm, actualPdNonTerminalField.getAcroForm());
  }
}
