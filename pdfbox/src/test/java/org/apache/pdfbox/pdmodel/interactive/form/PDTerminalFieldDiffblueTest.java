package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTerminalFieldDiffblueTest {
  /**
   * Test {@link PDTerminalField#setActions(PDFormFieldAdditionalActions)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#setActions(PDFormFieldAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDFormFieldAdditionalActions); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.setActions(PDFormFieldAdditionalActions)"})
  void testSetActions_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdCheckBox.setActions(new PDFormFieldAdditionalActions());

    // Assert
    verify(field).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDTerminalField#getFieldFlags()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTerminalField.getFieldFlags()"})
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
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTerminalField.getFieldFlags()"})
  void testGetFieldFlags_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDCheckBox(new PDAcroForm(new PDDocument()))).getFieldFlags());
  }

  /**
   * Test {@link PDTerminalField#getFieldFlags()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTerminalField.getFieldFlags()"})
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
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTerminalField.getFieldFlags()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDTerminalField.getFieldType()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDTerminalField.getFieldType()"})
  void testGetFieldType2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertNull((new PDCheckBox(acroForm, new COSDictionary(), null)).getFieldType());
  }

  /**
   * Test {@link PDTerminalField#getFieldType()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code Btn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getFieldType()}
   */
  @Test
  @DisplayName("Test getFieldType(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'Btn'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDTerminalField.getFieldType()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert that nothing has changed
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF2() throws IOException {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setReadOnly(true);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) COSObject Values size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF_thenPDCheckBoxWithAcroFormIsPDAcroFormCOSObjectValuesSizeIsThree() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} Value is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
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
   * <ul>
   *   <li>Then return PartialFieldName is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); then return PartialFieldName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FDFField PDTerminalField.exportFDF()"})
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
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FDFField PDTerminalField.exportFDF()"})
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
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
  }

  /**
   * Test {@link PDTerminalField#exportFDF()}.
   * <ul>
   *   <li>Then return PartialFieldName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); then return PartialFieldName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FDFField PDTerminalField.exportFDF()"})
  void testExportFDF_thenReturnPartialFieldNameIsNull() throws IOException {
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
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
  }

  /**
   * Test {@link PDTerminalField#getWidgets()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} importFDF {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getWidgets()}
   */
  @Test
  @DisplayName("Test getWidgets(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDTerminalField.getWidgets()"})
  void testGetWidgets_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.importFDF(new FDFField());

    // Act
    List<PDAnnotationWidget> actualWidgets = pdCheckBox.getWidgets();

    // Assert
    assertEquals(1, actualWidgets.size());
    PDAnnotationWidget getResult = actualWidgets.get(0);
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(getResult.getAppearanceState());
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
  }

  /**
   * Test {@link PDTerminalField#getWidgets()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#getWidgets()}
   */
  @Test
  @DisplayName("Test getWidgets(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDTerminalField.getWidgets()"})
  void testGetWidgets_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnSizeIsOne() {
    // Arrange and Act
    List<PDAnnotationWidget> actualWidgets = (new PDCheckBox(new PDAcroForm(new PDDocument()))).getWidgets();

    // Assert
    assertEquals(1, actualWidgets.size());
    PDAnnotationWidget getResult = actualWidgets.get(0);
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(getResult.getAppearanceState());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.setWidgets(List)"})
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
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  @DisplayName("Test setWidgets(List); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.setWidgets(List)"})
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
   * Test {@link PDTerminalField#setWidgets(List)}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} Widgets size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  @DisplayName("Test setWidgets(List); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Widgets size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.setWidgets(List)"})
  void testSetWidgets_thenPDCheckBoxWithAcroFormIsPDAcroFormWidgetsSizeIsTwo() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotationWidget> children = new ArrayList<>();
    children.add(new PDAnnotationWidget());
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();
    children.add(pdAnnotationWidget);

    // Act
    pdCheckBox.setWidgets(children);

    // Assert
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(2, widgets.size());
    assertEquals(pdAnnotationWidget, widgets.get(1));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSArray getObject(int) return COSDictionary(); then calls getObject(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
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
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
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

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} return {@code true}.</li>
   *   <li>Then calls {@link COSArray#isEmpty()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSArray isEmpty() return 'true'; then calls isEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSArrayIsEmptyReturnTrue_thenCallsIsEmpty() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).applyChange();

    // Assert
    verify(cosArray).isEmpty();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link COSArray#COSArray()}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSDictionary getCOSArray(COSName) return COSArray(); then calls getCOSArray(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSDictionaryGetCOSArrayReturnCOSArray_thenCallsGetCOSArray() throws IOException {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).applyChange();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
  }
}
