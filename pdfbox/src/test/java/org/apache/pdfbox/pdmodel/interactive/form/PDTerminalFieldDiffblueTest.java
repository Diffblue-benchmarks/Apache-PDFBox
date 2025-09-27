package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does
   *       nothing.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#setActions(PDFormFieldAdditionalActions)}
   */
  @Test
  @DisplayName(
      "Test setActions(PDFormFieldAdditionalActions); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.setActions(PDFormFieldAdditionalActions)"})
  void testSetActions_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.setActions(new PDFormFieldAdditionalActions());

    // Assert
    verify(field).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDTerminalField#getFieldFlags()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName(
      "Test getFieldFlags(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName(
      "Test getFieldFlags(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTerminalField.getFieldFlags()"})
  void testGetFieldFlags_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDCheckBox(new PDAcroForm(new PDDocument())).getFieldFlags());
  }

  /**
   * Test {@link PDTerminalField#getFieldFlags()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName(
      "Test getFieldFlags(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTerminalField.getFieldFlags()"})
  void testGetFieldFlags_givenPDNonTerminalFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setReadOnly(true);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);

    // Act and Assert
    assertEquals(1, pdCheckBox.getFieldFlags());
  }

  /**
   * Test {@link PDTerminalField#getFieldFlags()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName(
      "Test getFieldFlags(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTerminalField.getFieldFlags()"})
  void testGetFieldFlags_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertEquals(0, pdCheckBox.getFieldFlags());
  }

  /**
   * Test {@link PDTerminalField#getFieldType()}.
   *
   * <p>Method under test: {@link PDTerminalField#getFieldType()}
   */
  @Test
  @DisplayName("Test getFieldType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTerminalField.getFieldType()"})
  void testGetFieldType() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertNull(pdCheckBox.getFieldType());
  }

  /**
   * Test {@link PDTerminalField#getFieldType()}.
   *
   * <p>Method under test: {@link PDTerminalField#getFieldType()}
   */
  @Test
  @DisplayName("Test getFieldType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTerminalField.getFieldType()"})
  void testGetFieldType2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), null);

    // Act and Assert
    assertNull(pdCheckBox.getFieldType());
  }

  /**
   * Test {@link PDTerminalField#getFieldType()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code Btn}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#getFieldType()}
   */
  @Test
  @DisplayName(
      "Test getFieldType(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'Btn'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTerminalField.getFieldType()"})
  void testGetFieldType_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnBtn() {
    // Arrange, Act and Assert
    assertEquals("Btn", new PDCheckBox(new PDAcroForm(new PDDocument())).getFieldType());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link FDFField#FDFField()} Value is {@link COSArray#COSArray()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); given COSArray(); when FDFField() Value is COSArray(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF_givenCOSArray_whenFDFFieldValueIsCOSArray_thenThrowIOException()
      throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSArray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdCheckBox.importFDF(fdfField));
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link FDFField#FDFField()} Value is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given COSStream(); when FDFField() Value is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF_givenCOSStream_whenFDFFieldValueIsCOSStream() throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   *   <li>When {@link FDFField#FDFField()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'; when FDFField()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue_whenFDFField()
      throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF_givenPDNonTerminalFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue()
      throws IOException {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setReadOnly(true);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF_thenPDCheckBoxWithAcroFormIsPDAcroFormCOSObjectValuesSizeIsThree()
      throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} FieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) FieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF_thenPDCheckBoxWithAcroFormIsPDAcroFormFieldFlagsIsOne() throws IOException {
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
   *
   * <ul>
   *   <li>When {@link FDFField#FDFField()} ClearFieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() ClearFieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF_whenFDFFieldClearFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setClearFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>When {@link FDFField#FDFField()} ClearWidgetFieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() ClearWidgetFieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.importFDF(FDFField)"})
  void testImportFDF_whenFDFFieldClearWidgetFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setClearWidgetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTerminalField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>When {@link FDFField#FDFField()} SetFieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() SetFieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link FDFField#FDFField()} SetWidgetFieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() SetWidgetFieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link FDFField#FDFField()} WidgetFieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() WidgetFieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return PartialFieldName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); then return PartialFieldName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return PartialFieldName is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); then return PartialFieldName is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return PartialFieldName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); then return PartialFieldName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFField PDTerminalField.exportFDF()"})
  void testExportFDF_thenReturnPartialFieldNameIsNull() throws IOException {
    // Arrange and Act
    FDFField actualExportFDFResult = new PDCheckBox(new PDAcroForm(new PDDocument())).exportFDF();

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
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} importFDF {@link FDFField#FDFField()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#getWidgets()}
   */
  @Test
  @DisplayName(
      "Test getWidgets(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDTerminalField.getWidgets()"})
  void testGetWidgets_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#getWidgets()}
   */
  @Test
  @DisplayName(
      "Test getWidgets(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDTerminalField.getWidgets()"})
  void testGetWidgets_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnSizeIsOne() {
    // Arrange and Act
    List<PDAnnotationWidget> actualWidgets =
        new PDCheckBox(new PDAcroForm(new PDDocument())).getWidgets();

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
   *
   * <ul>
   *   <li>Given {@link PDAnnotationWidget#PDAnnotationWidget()}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  @DisplayName("Test setWidgets(List); given PDAnnotationWidget(); then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  @DisplayName(
      "Test setWidgets(List); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} Widgets size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#setWidgets(List)}
   */
  @Test
  @DisplayName(
      "Test setWidgets(List); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Widgets size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName(
      "Test applyChange(); given COSArray getObject(int) return COSDictionary(); then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSArrayGetObjectReturnCOSDictionary_thenCallsGetObject()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName(
      "Test applyChange(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} return {@code true}.
   *   <li>Then calls {@link COSArray#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSArray isEmpty() return 'true'; then calls isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSArrayIsEmptyReturnTrue_thenCallsIsEmpty() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

    // Assert
    verify(cosArray).isEmpty();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName(
      "Test applyChange(); given COSDictionary getCOSArray(COSName) return COSArray(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSDictionaryGetCOSArrayReturnCOSArray_thenCallsGetCOSArray()
      throws IOException {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSDictionaryGetCOSDictionaryReturnNull() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSDictionaryGetCOSDictionaryReturnNull2() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)} return {@code
   *       null}.
   *   <li>Then calls {@link COSDictionary#getCOSName(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName(
      "Test applyChange(); given COSDictionary getCOSName(COSName) return 'null'; then calls getCOSName(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSDictionaryGetCOSNameReturnNull_thenCallsGetCOSName()
      throws IOException {
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
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(null);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSName#A}.
   *   <li>Then calls {@link COSDictionary#getCOSName(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName(
      "Test applyChange(); given COSDictionary getDictionaryObject(COSName) return A; then calls getCOSName(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSDictionaryGetDictionaryObjectReturnA_thenCallsGetCOSName()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName(
      "Test applyChange(); given COSDictionary getDictionaryObject(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSDictionaryGetDictionaryObjectReturnCOSDictionary()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@code null}.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName(
      "Test applyChange(); given COSDictionary getDictionaryObject(COSName) return 'null'; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSDictionaryGetDictionaryObjectReturnNull_thenCallsSetItem()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDictionary2, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
  }

  /**
   * Test {@link PDTerminalField#applyChange()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSDictionary getDictionaryObject(COSName) return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSDictionaryGetDictionaryObjectReturnOne() throws IOException {
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
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDTerminalField#applyChange()}
   */
  @Test
  @DisplayName("Test applyChange(); given COSDictionary getDictionaryObject(COSName) return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTerminalField.applyChange()"})
  void testApplyChange_givenCOSDictionaryGetDictionaryObjectReturnOne2() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSInteger.ONE);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.applyChange();

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
