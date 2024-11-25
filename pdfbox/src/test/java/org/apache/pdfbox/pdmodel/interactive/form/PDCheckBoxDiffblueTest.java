package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDCheckBoxDiffblueTest {
  /**
   * Test
   * {@link PDCheckBox#PDCheckBox(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <p>
   * Method under test:
   * {@link PDCheckBox#PDCheckBox(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDCheckBox(PDAcroForm, COSDictionary, PDNonTerminalField)")
  void testNewPDCheckBox() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDCheckBox actualPdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdCheckBox.getCOSObject());
    assertSame(acroForm, actualPdCheckBox.getAcroForm());
    assertSame(parent, actualPdCheckBox.getParent());
  }

  /**
   * Test {@link PDCheckBox#PDCheckBox(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDCheckBox#PDCheckBox(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDCheckBox(PDAcroForm)")
  void testNewPDCheckBox2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDCheckBox actualPdCheckBox = new PDCheckBox(acroForm);

    // Assert
    List<PDAnnotationWidget> widgets = actualPdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertEquals("", actualPdCheckBox.getDefaultValue());
    assertEquals("", actualPdCheckBox.getOnValue());
    assertEquals("Btn", actualPdCheckBox.getFieldType());
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Off", actualPdCheckBox.getValue());
    assertEquals("Off", actualPdCheckBox.getValueAsString());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(actualPdCheckBox.getAlternateFieldName());
    assertNull(actualPdCheckBox.getFullyQualifiedName());
    assertNull(actualPdCheckBox.getMappingName());
    assertNull(actualPdCheckBox.getPartialName());
    COSDictionary cOSObject = actualPdCheckBox.getCOSObject();
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
    assertNull(actualPdCheckBox.getActions());
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertNull(actualPdCheckBox.getParent());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, actualPdCheckBox.getFieldFlags());
    Set<String> onValues = actualPdCheckBox.getOnValues();
    assertEquals(1, onValues.size());
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
    assertFalse(actualPdCheckBox.isPushButton());
    assertFalse(actualPdCheckBox.isRadioButton());
    assertFalse(actualPdCheckBox.isNoExport());
    assertFalse(actualPdCheckBox.isReadOnly());
    assertFalse(actualPdCheckBox.isRequired());
    assertTrue(actualPdCheckBox.getExportValues().isEmpty());
    assertTrue(onValues.contains(""));
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
    assertSame(acroForm, actualPdCheckBox.getAcroForm());
    assertSame(cOSObject, getResult.getCOSObject());
  }

  /**
   * Test {@link PDCheckBox#isChecked()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#isChecked()}
   */
  @Test
  @DisplayName("Test isChecked(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testIsChecked_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).isChecked());
  }

  /**
   * Test {@link PDCheckBox#isChecked()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} importFDF
   * {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#isChecked()}
   */
  @Test
  @DisplayName("Test isChecked(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  void testIsChecked_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.importFDF(new FDFField());

    // Act and Assert
    assertFalse(pdCheckBox.isChecked());
  }

  /**
   * Test {@link PDCheckBox#isChecked()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#isChecked()}
   */
  @Test
  @DisplayName("Test isChecked(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  void testIsChecked_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isChecked());
  }

  /**
   * Test {@link PDCheckBox#isChecked()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#isChecked()}
   */
  @Test
  @DisplayName("Test isChecked(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  void testIsChecked_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isChecked());
  }

  /**
   * Test {@link PDCheckBox#check()}.
   * <p>
   * Method under test: {@link PDCheckBox#check()}
   */
  @Test
  @DisplayName("Test check()")
  void testCheck() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdCheckBox.check();

    // Assert
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDCheckBox#check()}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} Value is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#check()}
   */
  @Test
  @DisplayName("Test check(); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is empty string")
  void testCheck_thenPDCheckBoxWithAcroFormIsPDAcroFormValueIsEmptyString() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.check();

    // Assert
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDCheckBox#check()}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} Value is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#check()}
   */
  @Test
  @DisplayName("Test check(); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument, COSDictionary) Value is empty string")
  void testCheck_thenPDCheckBoxWithAcroFormIsPDAcroFormValueIsEmptyString2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(doc, new COSDictionary()));

    // Act
    pdCheckBox.check();

    // Assert
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDCheckBox#unCheck()}.
   * <p>
   * Method under test: {@link PDCheckBox#unCheck()}
   */
  @Test
  @DisplayName("Test unCheck()")
  void testUnCheck() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdCheckBox.unCheck();

    // Assert
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDCheckBox#unCheck()}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} COSObject Values size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#unCheck()}
   */
  @Test
  @DisplayName("Test unCheck(); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) COSObject Values size is four")
  void testUnCheck_thenPDCheckBoxWithAcroFormIsPDAcroFormCOSObjectValuesSizeIsFour() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.unCheck();

    // Assert
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDCheckBox#unCheck()}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} COSObject Values
   * size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#unCheck()}
   */
  @Test
  @DisplayName("Test unCheck(); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument, COSDictionary) COSObject Values size is four")
  void testUnCheck_thenPDCheckBoxWithAcroFormIsPDAcroFormCOSObjectValuesSizeIsFour2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(doc, new COSDictionary()));

    // Act
    pdCheckBox.unCheck();

    // Assert
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDCheckBox#getOnValue()}.
   * <p>
   * Method under test: {@link PDCheckBox#getOnValue()}
   */
  @Test
  @DisplayName("Test getOnValue()")
  void testGetOnValue() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("",
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getOnValue());
  }

  /**
   * Test {@link PDCheckBox#getOnValue()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} importFDF
   * {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#getOnValue()}
   */
  @Test
  @DisplayName("Test getOnValue(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  void testGetOnValue_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.importFDF(new FDFField());

    // Act and Assert
    assertEquals("", pdCheckBox.getOnValue());
  }

  /**
   * Test {@link PDCheckBox#getOnValue()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#getOnValue()}
   */
  @Test
  @DisplayName("Test getOnValue(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return empty string")
  void testGetOnValue_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDCheckBox(new PDAcroForm(new PDDocument()))).getOnValue());
  }
}
