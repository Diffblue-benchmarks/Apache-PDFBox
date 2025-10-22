package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDCheckBoxDiffblueTest {
  /**
   * Test {@link PDCheckBox#PDCheckBox(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <p>
   * Method under test: {@link PDCheckBox#PDCheckBox(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDCheckBox(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCheckBox.<init>(PDAcroForm, COSDictionary, PDNonTerminalField)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCheckBox.<init>(PDAcroForm)"})
  void testNewPDCheckBox2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDCheckBox actualPdCheckBox = new PDCheckBox(acroForm);

    // Assert
    assertEquals("", actualPdCheckBox.getDefaultValue());
    assertEquals("", actualPdCheckBox.getOnValue());
    assertEquals("Btn", actualPdCheckBox.getFieldType());
    assertEquals("Off", actualPdCheckBox.getValue());
    assertEquals("Off", actualPdCheckBox.getValueAsString());
    assertNull(actualPdCheckBox.getAlternateFieldName());
    assertNull(actualPdCheckBox.getFullyQualifiedName());
    assertNull(actualPdCheckBox.getMappingName());
    assertNull(actualPdCheckBox.getPartialName());
    assertNull(actualPdCheckBox.getActions());
    assertNull(actualPdCheckBox.getParent());
    assertEquals(0, actualPdCheckBox.getFieldFlags());
    assertEquals(1, actualPdCheckBox.getWidgets().size());
    assertEquals(1, actualPdCheckBox.getOnValues().size());
    assertFalse(actualPdCheckBox.isPushButton());
    assertFalse(actualPdCheckBox.isRadioButton());
    assertFalse(actualPdCheckBox.isNoExport());
    assertFalse(actualPdCheckBox.isReadOnly());
    assertFalse(actualPdCheckBox.isRequired());
    assertTrue(actualPdCheckBox.getExportValues().isEmpty());
    assertSame(acroForm, actualPdCheckBox.getAcroForm());
  }

  /**
   * Test {@link PDCheckBox#isChecked()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} importFDF {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#isChecked()}
   */
  @Test
  @DisplayName("Test isChecked(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDCheckBox.isChecked()"})
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
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#isChecked()}
   */
  @Test
  @DisplayName("Test isChecked(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDCheckBox.isChecked()"})
  void testIsChecked_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isChecked());
  }

  /**
   * Test {@link PDCheckBox#isChecked()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#isChecked()}
   */
  @Test
  @DisplayName("Test isChecked(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDCheckBox.isChecked()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCheckBox.check()"})
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
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} Value is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#check()}
   */
  @Test
  @DisplayName("Test check(); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCheckBox.check()"})
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
   * Test {@link PDCheckBox#unCheck()}.
   * <p>
   * Method under test: {@link PDCheckBox#unCheck()}
   */
  @Test
  @DisplayName("Test unCheck()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCheckBox.unCheck()"})
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
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} COSObject Values size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#unCheck()}
   */
  @Test
  @DisplayName("Test unCheck(); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) COSObject Values size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCheckBox.unCheck()"})
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
   * Test {@link PDCheckBox#getOnValue()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} importFDF {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#getOnValue()}
   */
  @Test
  @DisplayName("Test getOnValue(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDCheckBox.getOnValue()"})
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
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCheckBox#getOnValue()}
   */
  @Test
  @DisplayName("Test getOnValue(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDCheckBox.getOnValue()"})
  void testGetOnValue_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDCheckBox(new PDAcroForm(new PDDocument()))).getOnValue());
  }
}
