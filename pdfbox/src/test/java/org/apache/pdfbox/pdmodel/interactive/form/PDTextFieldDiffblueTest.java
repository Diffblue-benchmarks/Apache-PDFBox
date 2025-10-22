package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTextFieldDiffblueTest {
  /**
   * Test {@link PDTextField#PDTextField(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <p>
   * Method under test: {@link PDTextField#PDTextField(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDTextField(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.<init>(PDAcroForm, COSDictionary, PDNonTerminalField)"})
  void testNewPDTextField() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDTextField actualPdTextField = new PDTextField(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdTextField.getCOSObject());
    assertSame(acroForm, actualPdTextField.getAcroForm());
    assertSame(parent, actualPdTextField.getParent());
  }

  /**
   * Test {@link PDTextField#PDTextField(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDTextField#PDTextField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDTextField(PDAcroForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.<init>(PDAcroForm)"})
  void testNewPDTextField2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDTextField actualPdTextField = new PDTextField(acroForm);

    // Assert
    assertEquals("", actualPdTextField.getDefaultValue());
    assertEquals("", actualPdTextField.getValue());
    assertEquals("", actualPdTextField.getValueAsString());
    assertEquals("", actualPdTextField.getRichTextValue());
    assertEquals("Tx", actualPdTextField.getFieldType());
    assertNull(actualPdTextField.getAlternateFieldName());
    assertNull(actualPdTextField.getFullyQualifiedName());
    assertNull(actualPdTextField.getMappingName());
    assertNull(actualPdTextField.getPartialName());
    assertNull(actualPdTextField.getDefaultAppearance());
    assertNull(actualPdTextField.getDefaultStyleString());
    assertNull(actualPdTextField.getActions());
    assertNull(actualPdTextField.getParent());
    assertEquals(-1, actualPdTextField.getMaxLen());
    assertEquals(0, actualPdTextField.getFieldFlags());
    assertEquals(0, actualPdTextField.getQ());
    assertEquals(1, actualPdTextField.getWidgets().size());
    assertFalse(actualPdTextField.isNoExport());
    assertFalse(actualPdTextField.isReadOnly());
    assertFalse(actualPdTextField.isRequired());
    assertFalse(actualPdTextField.isComb());
    assertFalse(actualPdTextField.isFileSelect());
    assertFalse(actualPdTextField.isMultiline());
    assertFalse(actualPdTextField.isPassword());
    assertFalse(actualPdTextField.isRichText());
    assertSame(acroForm, actualPdTextField.getAcroForm());
  }

  /**
   * Test {@link PDTextField#isMultiline()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  @DisplayName("Test isMultiline(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isMultiline()"})
  void testIsMultiline_givenPDTextFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setReadOnly(true);

    // Act and Assert
    assertFalse(pdTextField.isMultiline());
  }

  /**
   * Test {@link PDTextField#isMultiline()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  @DisplayName("Test isMultiline(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isMultiline()"})
  void testIsMultiline_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).isMultiline());
  }

  /**
   * Test {@link PDTextField#isMultiline()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  @DisplayName("Test isMultiline(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isMultiline()"})
  void testIsMultiline_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(4096);

    // Act and Assert
    assertTrue(pdTextField.isMultiline());
  }

  /**
   * Test {@link PDTextField#isPassword()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  @DisplayName("Test isPassword(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isPassword()"})
  void testIsPassword_givenPDTextFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setReadOnly(true);

    // Act and Assert
    assertFalse(pdTextField.isPassword());
  }

  /**
   * Test {@link PDTextField#isPassword()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  @DisplayName("Test isPassword(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isPassword()"})
  void testIsPassword_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).isPassword());
  }

  /**
   * Test {@link PDTextField#isPassword()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  @DisplayName("Test isPassword(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isPassword()"})
  void testIsPassword_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(8192);

    // Act and Assert
    assertTrue(pdTextField.isPassword());
  }

  /**
   * Test {@link PDTextField#isFileSelect()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  @DisplayName("Test isFileSelect(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isFileSelect()"})
  void testIsFileSelect_givenPDTextFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setReadOnly(true);

    // Act and Assert
    assertFalse(pdTextField.isFileSelect());
  }

  /**
   * Test {@link PDTextField#isFileSelect()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  @DisplayName("Test isFileSelect(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isFileSelect()"})
  void testIsFileSelect_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).isFileSelect());
  }

  /**
   * Test {@link PDTextField#isFileSelect()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  @DisplayName("Test isFileSelect(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isFileSelect()"})
  void testIsFileSelect_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(1048576);

    // Act and Assert
    assertTrue(pdTextField.isFileSelect());
  }

  /**
   * Test {@link PDTextField#doNotSpellCheck()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  @DisplayName("Test doNotSpellCheck(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.doNotSpellCheck()"})
  void testDoNotSpellCheck_givenPDTextFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setReadOnly(true);

    // Act and Assert
    assertFalse(pdTextField.doNotSpellCheck());
  }

  /**
   * Test {@link PDTextField#doNotSpellCheck()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  @DisplayName("Test doNotSpellCheck(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.doNotSpellCheck()"})
  void testDoNotSpellCheck_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).doNotSpellCheck());
  }

  /**
   * Test {@link PDTextField#doNotSpellCheck()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  @DisplayName("Test doNotSpellCheck(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.doNotSpellCheck()"})
  void testDoNotSpellCheck_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(4194304);

    // Act and Assert
    assertTrue(pdTextField.doNotSpellCheck());
  }

  /**
   * Test {@link PDTextField#doNotScroll()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  @DisplayName("Test doNotScroll(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.doNotScroll()"})
  void testDoNotScroll_givenPDTextFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setReadOnly(true);

    // Act and Assert
    assertFalse(pdTextField.doNotScroll());
  }

  /**
   * Test {@link PDTextField#doNotScroll()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  @DisplayName("Test doNotScroll(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.doNotScroll()"})
  void testDoNotScroll_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).doNotScroll());
  }

  /**
   * Test {@link PDTextField#doNotScroll()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  @DisplayName("Test doNotScroll(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.doNotScroll()"})
  void testDoNotScroll_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(8388608);

    // Act and Assert
    assertTrue(pdTextField.doNotScroll());
  }

  /**
   * Test {@link PDTextField#isComb()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isComb()}
   */
  @Test
  @DisplayName("Test isComb(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isComb()"})
  void testIsComb_givenPDTextFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setReadOnly(true);

    // Act and Assert
    assertFalse(pdTextField.isComb());
  }

  /**
   * Test {@link PDTextField#isComb()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isComb()}
   */
  @Test
  @DisplayName("Test isComb(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isComb()"})
  void testIsComb_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).isComb());
  }

  /**
   * Test {@link PDTextField#isComb()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isComb()}
   */
  @Test
  @DisplayName("Test isComb(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isComb()"})
  void testIsComb_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(16777216);

    // Act and Assert
    assertTrue(pdTextField.isComb());
  }

  /**
   * Test {@link PDTextField#isRichText()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  @DisplayName("Test isRichText(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isRichText()"})
  void testIsRichText_givenPDTextFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setReadOnly(true);

    // Act and Assert
    assertFalse(pdTextField.isRichText());
  }

  /**
   * Test {@link PDTextField#isRichText()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  @DisplayName("Test isRichText(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isRichText()"})
  void testIsRichText_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).isRichText());
  }

  /**
   * Test {@link PDTextField#isRichText()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  @DisplayName("Test isRichText(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTextField.isRichText()"})
  void testIsRichText_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(33554432);

    // Act and Assert
    assertTrue(pdTextField.isRichText());
  }

  /**
   * Test {@link PDTextField#getMaxLen()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getMaxLen()}
   */
  @Test
  @DisplayName("Test getMaxLen(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTextField.getMaxLen()"})
  void testGetMaxLen_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDTextField(new PDAcroForm(new PDDocument()))).getMaxLen());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("\\u000D\\u000A|[\\u000A\\u000B\\u000C\\u000D\\u0085\\u2028\\u2029]");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue2() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("widget of field {} has no rectangle, no appearance stream created");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue3() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("org.apache.logging.log4j.util.StackLocator");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()} DefaultAppearance is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIs42() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()} DefaultAppearance is {@code Annot}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is 'Annot'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIsAnnot() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("Annot");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()} DefaultAppearance is {@code Da Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is 'Da Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIsDaValue() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("Da Value");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()} DefaultAppearance is {@code Widget}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is 'Widget'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIsWidget() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("Widget");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} PartialName is cr lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is cr lf")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDTextFieldWithAcroFormIsPDAcroFormPartialNameIsCrLf() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setPartialName("\r\n");
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDTextFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setReadOnly(true);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   * <ul>
   *   <li>When cr lf.</li>
   *   <li>Then {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} Value is cr lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); when cr lf; then PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is cr lf")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_whenCrLf_thenPDTextFieldWithAcroFormIsPDAcroFormValueIsCrLf() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("\r\n");

    // Assert
    assertEquals("\r\n", pdTextField.getValue());
    assertEquals("\r\n", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} Value is space.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); when space; then PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_whenSpace_thenPDTextFieldWithAcroFormIsPDAcroFormValueIsSpace() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue(" ");

    // Assert
    assertEquals(" ", pdTextField.getValue());
    assertEquals(" ", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTextField#setDefaultValue(String)}.
   * <p>
   * Method under test: {@link PDTextField#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTextField.setDefaultValue(String)"})
  void testSetDefaultValue() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setString(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDTextField pdTextField = new PDTextField(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdTextField.setDefaultValue("42");

    // Assert that nothing has changed
    verify(field).setString(isA(COSName.class), eq("42"));
    assertEquals("", pdTextField.getDefaultValue());
  }

  /**
   * Test {@link PDTextField#getValue()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDTextField.getValue()"})
  void testGetValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("",
        (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getValue());
  }

  /**
   * Test {@link PDTextField#getValue()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDTextField.getValue()"})
  void testGetValue_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(new PDDocument()))).getValue());
  }

  /**
   * Test {@link PDTextField#getDefaultValue()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDTextField.getDefaultValue()"})
  void testGetDefaultValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("",
        (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getDefaultValue());
  }

  /**
   * Test {@link PDTextField#getDefaultValue()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDTextField.getDefaultValue()"})
  void testGetDefaultValue_givenPDTextFieldWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(new PDDocument()))).getDefaultValue());
  }

  /**
   * Test {@link PDTextField#getValueAsString()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDTextField.getValueAsString()"})
  void testGetValueAsString_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("", (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .getValueAsString());
  }

  /**
   * Test {@link PDTextField#getValueAsString()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDTextField.getValueAsString()"})
  void testGetValueAsString_givenPDTextFieldWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(new PDDocument()))).getValueAsString());
  }
}
