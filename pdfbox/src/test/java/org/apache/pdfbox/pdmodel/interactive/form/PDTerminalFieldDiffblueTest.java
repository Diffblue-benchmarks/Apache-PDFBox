package org.apache.pdfbox.pdmodel.interactive.form;

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
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.interactive.action.PDAnnotationAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.Test;

class PDTerminalFieldDiffblueTest {
  /**
   * Method under test:
   * {@link PDTerminalField#setActions(PDFormFieldAdditionalActions)}
   */
  @Test
  void testSetActions() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.setActions(new PDFormFieldAdditionalActions());

    // Assert
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationAdditionalActions actions = widgets.get(0).getActions();
    assertNull(actions.getBl());
    assertNull(actions.getD());
    assertNull(actions.getE());
    assertNull(actions.getFo());
    assertNull(actions.getPC());
    assertNull(actions.getPI());
    assertNull(actions.getPO());
    assertNull(actions.getPV());
    assertNull(actions.getU());
    assertNull(actions.getX());
    PDFormFieldAdditionalActions actions2 = pdCheckBox.getActions();
    assertNull(actions2.getC());
    assertNull(actions2.getF());
    assertNull(actions2.getK());
    assertNull(actions2.getV());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDTerminalField#setActions(PDFormFieldAdditionalActions)}
   */
  @Test
  void testSetActions2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdCheckBox.setActions(new PDFormFieldAdditionalActions());

    // Assert
    verify(streamCacheCreateFunction).create();
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationAdditionalActions actions = widgets.get(0).getActions();
    assertNull(actions.getBl());
    assertNull(actions.getD());
    assertNull(actions.getE());
    assertNull(actions.getFo());
    assertNull(actions.getPC());
    assertNull(actions.getPI());
    assertNull(actions.getPO());
    assertNull(actions.getPV());
    assertNull(actions.getU());
    assertNull(actions.getX());
    PDFormFieldAdditionalActions actions2 = pdCheckBox.getActions();
    assertNull(actions2.getC());
    assertNull(actions2.getF());
    assertNull(actions2.getK());
    assertNull(actions2.getV());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDTerminalField#setActions(PDFormFieldAdditionalActions)}
   */
  @Test
  void testSetActions3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdCheckBox.setActions(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    assertNull(widgets.get(0).getActions());
    assertNull(pdCheckBox.getActions());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  void testGetFieldFlags() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDCheckBox(new PDAcroForm(new PDDocument()))).getFieldFlags());
  }

  /**
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  void testGetFieldFlags2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualFieldFlags = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getFieldFlags();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualFieldFlags);
  }

  /**
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  void testGetFieldFlags3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals(0,
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getFieldFlags());
  }

  /**
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  void testGetFieldFlags4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setReadOnly(true);

    // Act
    int actualFieldFlags = pdCheckBox.getFieldFlags();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualFieldFlags);
  }

  /**
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  void testGetFieldFlags5() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setReadOnly(true);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertEquals(1, (new PDCheckBox(acroForm, new COSDictionary(), parent)).getFieldFlags());
  }

  /**
   * Method under test: {@link PDTerminalField#getFieldType()}
   */
  @Test
  void testGetFieldType() {
    // Arrange, Act and Assert
    assertEquals("Btn", (new PDCheckBox(new PDAcroForm(new PDDocument()))).getFieldType());
  }

  /**
   * Method under test: {@link PDTerminalField#getFieldType()}
   */
  @Test
  void testGetFieldType2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualFieldType = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getFieldType();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Btn", actualFieldType);
  }

  /**
   * Method under test: {@link PDTerminalField#getFieldType()}
   */
  @Test
  void testGetFieldType3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getFieldType());
  }

  /**
   * Method under test: {@link PDTerminalField#getFieldType()}
   */
  @Test
  void testGetFieldType4() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertNull((new PDCheckBox(acroForm, new COSDictionary(), null)).getFieldType());
  }

  /**
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setReadOnly(true);

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setSetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setClearFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setWidgetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    assertEquals(0, pdCheckBox.getFieldFlags());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(1, getResult.getAnnotationFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertFalse(pdCheckBox.isReadOnly());
    assertTrue(getResult.isInvisible());
  }

  /**
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setSetWidgetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    assertEquals(0, pdCheckBox.getFieldFlags());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(1, getResult.getAnnotationFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertFalse(pdCheckBox.isReadOnly());
    assertTrue(getResult.isInvisible());
  }

  /**
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setClearWidgetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSStream());

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  void testExportFDF() throws IOException {
    // Arrange and Act
    FDFField actualExportFDFResult = (new PDCheckBox(new PDAcroForm(new PDDocument()))).exportFDF();

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
    assertNull(actualExportFDFResult.getKids());
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
   * Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  void testExportFDF2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    FDFField actualExportFDFResult = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
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
    assertNull(actualExportFDFResult.getKids());
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
   * Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  void testExportFDF3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("Name");

    // Act
    FDFField actualExportFDFResult = pdCheckBox.exportFDF();

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
    assertNull(actualExportFDFResult.getKids());
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
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  void testExportFDF4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("");

    // Act
    FDFField actualExportFDFResult = pdCheckBox.exportFDF();

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
    assertNull(actualExportFDFResult.getKids());
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
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  void testSetWidgets() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm);
    ArrayList<PDAnnotationWidget> children = new ArrayList<>();

    // Act
    pdCheckBox.setWidgets(children);

    // Assert
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(children.isEmpty());
    assertTrue(pdCheckBox.getWidgets().isEmpty());
    assertTrue(cOSObject.toIncrement().getObjects().isEmpty());
    assertTrue(pdCheckBox.getOnValues().isEmpty());
    assertSame(acroForm, pdCheckBox.getAcroForm());
  }

  /**
   * Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  void testSetWidgets2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm);

    ArrayList<PDAnnotationWidget> children = new ArrayList<>();
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();
    children.add(pdAnnotationWidget);

    // Act
    pdCheckBox.setWidgets(children);

    // Assert
    assertEquals(1, children.size());
    assertEquals(1, pdCheckBox.getOnValues().size());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(children, pdCheckBox.getWidgets());
    assertSame(pdAnnotationWidget, children.get(0));
    assertSame(acroForm, pdCheckBox.getAcroForm());
  }

  /**
   * Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  void testSetWidgets3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm);
    ArrayList<PDAnnotationWidget> children = new ArrayList<>();

    // Act
    pdCheckBox.setWidgets(children);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(children.isEmpty());
    assertTrue(pdCheckBox.getWidgets().isEmpty());
    assertTrue(cOSObject.toIncrement().getObjects().isEmpty());
    assertTrue(pdCheckBox.getOnValues().isEmpty());
    assertSame(acroForm, pdCheckBox.getAcroForm());
  }

  /**
   * Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  void testSetWidgets4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm);

    ArrayList<PDAnnotationWidget> children = new ArrayList<>();
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();
    children.add(pdAnnotationWidget);
    PDAnnotationWidget pdAnnotationWidget2 = new PDAnnotationWidget();
    children.add(pdAnnotationWidget2);

    // Act
    pdCheckBox.setWidgets(children);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, pdCheckBox.getOnValues().size());
    assertEquals(2, children.size());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(children, pdCheckBox.getWidgets());
    assertSame(pdAnnotationWidget, children.get(0));
    assertSame(pdAnnotationWidget2, children.get(1));
    assertSame(acroForm, pdCheckBox.getAcroForm());
  }

  /**
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  void testApplyChange() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).applyChange();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  void testApplyChange2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.importFDF(new FDFField());

    // Act
    pdCheckBox.applyChange();

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
