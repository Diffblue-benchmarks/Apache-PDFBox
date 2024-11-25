package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.interactive.action.PDAnnotationAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTerminalFieldDiffblueTest {
  /**
   * Test {@link PDTerminalField#setActions(PDFormFieldAdditionalActions)}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} Widgets size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTerminalField#setActions(PDFormFieldAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDFormFieldAdditionalActions); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Widgets size is one")
  void testSetActions_thenPDCheckBoxWithAcroFormIsPDAcroFormWidgetsSizeIsOne() {
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
   * Test {@link PDTerminalField#getFieldFlags()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testGetFieldFlags_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act and Assert
    assertEquals(1, pdCheckBox.getFieldFlags());
  }

  /**
   * Test {@link PDTerminalField#getFieldFlags()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  void testGetFieldFlags_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDCheckBox(new PDAcroForm(new PDDocument()))).getFieldFlags());
  }

  /**
   * Test {@link PDTerminalField#getFieldFlags()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testGetFieldFlags_givenPDNonTerminalFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setReadOnly(true);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertEquals(1, (new PDCheckBox(acroForm, new COSDictionary(), parent)).getFieldFlags());
  }

  /**
   * Test {@link PDTerminalField#getFieldFlags()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  void testGetFieldFlags_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals(0,
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getFieldFlags());
  }

  /**
   * Test {@link PDTerminalField#getFieldType()}.
   * <p>
   * Method under test: {@link PDTerminalField#getFieldType()}
   */
  @Test
  @DisplayName("Test getFieldType()")
  void testGetFieldType() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getFieldType());
  }

  /**
   * Test {@link PDTerminalField#getFieldType()}.
   * <p>
   * Method under test: {@link PDTerminalField#getFieldType()}
   */
  @Test
  @DisplayName("Test getFieldType()")
  void testGetFieldType2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertNull((new PDCheckBox(acroForm, new COSDictionary(), null)).getFieldType());
  }

  /**
   * Test {@link PDTerminalField#getFieldType()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code Btn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getFieldType()}
   */
  @Test
  @DisplayName("Test getFieldType(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'Btn'")
  void testGetFieldType_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnBtn() {
    // Arrange, Act and Assert
    assertEquals("Btn", (new PDCheckBox(new PDAcroForm(new PDDocument()))).getFieldType());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField)")
  void testImportFDF() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField)")
  void testImportFDF2() throws IOException {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setReadOnly(true);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testImportFDF_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} COSObject Values size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) COSObject Values size is three")
  void testImportFDF_thenPDCheckBoxWithAcroFormIsPDAcroFormCOSObjectValuesSizeIsThree() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} Value is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is empty string")
  void testImportFDF_thenPDCheckBoxWithAcroFormIsPDAcroFormValueIsEmptyString() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSStream());

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()} ClearFieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() ClearFieldFlags is one")
  void testImportFDF_whenFDFFieldClearFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setClearFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()} ClearWidgetFieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() ClearWidgetFieldFlags is one")
  void testImportFDF_whenFDFFieldClearWidgetFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setClearWidgetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()} FieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() FieldFlags is one")
  void testImportFDF_whenFDFFieldFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()} SetFieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() SetFieldFlags is one")
  void testImportFDF_whenFDFFieldSetFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setSetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()} SetWidgetFieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() SetWidgetFieldFlags is one")
  void testImportFDF_whenFDFFieldSetWidgetFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setSetWidgetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(1, getResult.getAnnotationFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(getResult.isInvisible());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()} WidgetFieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() WidgetFieldFlags is one")
  void testImportFDF_whenFDFFieldWidgetFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setWidgetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(1, getResult.getAnnotationFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(getResult.isInvisible());
  }

  /**
   * Test {@link PDTerminalField#exportFDF()}.
   * <p>
   * Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF()")
  void testExportFDF() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act
    FDFField actualExportFDFResult = (new PDCheckBox(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())))).exportFDF();

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
   * Test {@link PDTerminalField#exportFDF()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testExportFDF_givenPDCheckBoxWithAcroFormIsPDAcroForm() throws IOException {
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
   * Test {@link PDTerminalField#exportFDF()}.
   * <ul>
   *   <li>Then return PartialFieldName is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); then return PartialFieldName is empty string")
  void testExportFDF_thenReturnPartialFieldNameIsEmptyString() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act
    FDFField actualExportFDFResult = pdCheckBox.exportFDF();

    // Assert
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
   * Test {@link PDTerminalField#exportFDF()}.
   * <ul>
   *   <li>Then return PartialFieldName is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); then return PartialFieldName is 'Name'")
  void testExportFDF_thenReturnPartialFieldNameIsName() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Name");

    // Act
    FDFField actualExportFDFResult = pdCheckBox.exportFDF();

    // Assert
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
   * Test {@link PDTerminalField#getWidgets()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getWidgets()}
   */
  @Test
  @DisplayName("Test getWidgets(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetWidgets_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange and Act
    List<PDAnnotationWidget> actualWidgets = (new PDCheckBox(new PDAcroForm(new PDDocument()))).getWidgets();

    // Assert
    assertEquals(1, actualWidgets.size());
    PDAnnotationWidget getResult = actualWidgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getAppearanceState());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getPage());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getOptionalContent());
    assertNull(getResult.getColor());
    assertNull(getResult.getAction());
    assertNull(getResult.getActions());
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
  }

  /**
   * Test {@link PDTerminalField#getWidgets()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} importFDF
   * {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getWidgets()}
   */
  @Test
  @DisplayName("Test getWidgets(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  void testGetWidgets_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.importFDF(new FDFField());

    // Act
    List<PDAnnotationWidget> actualWidgets = pdCheckBox.getWidgets();

    // Assert
    assertEquals(1, actualWidgets.size());
    PDAnnotationWidget getResult = actualWidgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getAppearanceState());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getPage());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getOptionalContent());
    assertNull(getResult.getColor());
    assertNull(getResult.getAction());
    assertNull(getResult.getActions());
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
  }

  /**
   * Test {@link PDTerminalField#getWidgets()}.
   * <ul>
   *   <li>Then return first COSObject is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getWidgets()}
   */
  @Test
  @DisplayName("Test getWidgets(); then return first COSObject is COSDictionary()")
  void testGetWidgets_thenReturnFirstCOSObjectIsCOSDictionary() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act
    List<PDAnnotationWidget> actualWidgets = (new PDCheckBox(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getWidgets();

    // Assert
    assertEquals(1, actualWidgets.size());
    PDAnnotationWidget getResult = actualWidgets.get(0);
    assertEquals(3, getResult.getBorder().toList().size());
    assertSame(field, getResult.getCOSObject());
  }

  /**
   * Test {@link PDTerminalField#setWidgets(List)}.
   * <ul>
   *   <li>Given {@link PDAnnotationWidget#PDAnnotationWidget()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  @DisplayName("Test setWidgets(List); given PDAnnotationWidget(); then ArrayList() size is one")
  void testSetWidgets_givenPDAnnotationWidget_thenArrayListSizeIsOne() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotationWidget> children = new ArrayList<>();
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();
    children.add(pdAnnotationWidget);

    // Act
    pdCheckBox.setWidgets(children);

    // Assert
    assertEquals(1, children.size());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(1, pdCheckBox.getOnValues().size());
    COSDictionary cOSObject = children.get(0).getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(pdAnnotationWidget, widgets.get(0));
  }

  /**
   * Test {@link PDTerminalField#setWidgets(List)}.
   * <ul>
   *   <li>Given {@link PDAnnotationWidget#PDAnnotationWidget()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  @DisplayName("Test setWidgets(List); given PDAnnotationWidget(); then ArrayList() size is two")
  void testSetWidgets_givenPDAnnotationWidget_thenArrayListSizeIsTwo() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotationWidget> children = new ArrayList<>();
    children.add(new PDAnnotationWidget());
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();
    children.add(pdAnnotationWidget);

    // Act
    pdCheckBox.setWidgets(children);

    // Assert
    assertEquals(2, children.size());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(2, widgets.size());
    COSDictionary cOSObject = children.get(1).getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(pdAnnotationWidget, widgets.get(1));
  }

  /**
   * Test {@link PDTerminalField#setWidgets(List)}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  @DisplayName("Test setWidgets(List); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) COSObject Values size is two")
  void testSetWidgets_thenPDCheckBoxWithAcroFormIsPDAcroFormCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.setWidgets(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdCheckBox.getWidgets().isEmpty());
    assertTrue(pdCheckBox.getOnValues().isEmpty());
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSArray getObject(int) return COSDictionary(); then calls getObject(int)")
  void testApplyChange_givenCOSArrayGetObjectReturnCOSDictionary_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).applyChange();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  void testApplyChange_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).applyChange();

    // Assert that nothing has changed
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} return
   * {@code true}.</li>
   *   <li>Then calls {@link COSArray#isEmpty()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSArray isEmpty() return 'true'; then calls isEmpty()")
  void testApplyChange_givenCOSArrayIsEmptyReturnTrue_thenCallsIsEmpty() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).applyChange();

    // Assert that nothing has changed
    verify(cosArray).isEmpty();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSDictionary getCOSArray(COSName) return COSArray(); then calls getCOSArray(COSName)")
  void testApplyChange_givenCOSDictionaryGetCOSArrayReturnCOSArray_thenCallsGetCOSArray() throws IOException {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).applyChange();

    // Assert that nothing has changed
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSDictionary getCOSDictionary(COSName) return COSStream()")
  void testApplyChange_givenCOSDictionaryGetCOSDictionaryReturnCOSStream() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSStream());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).applyChange();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); then calls getCOSDictionary(COSName)")
  void testApplyChange_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).applyChange();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
  }
}
