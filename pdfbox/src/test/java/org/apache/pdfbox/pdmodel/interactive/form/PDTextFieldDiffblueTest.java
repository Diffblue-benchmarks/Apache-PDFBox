package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTextFieldDiffblueTest {
  /**
   * Test {@link PDTextField#PDTextField(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   *
   * <p>Method under test: {@link PDTextField#PDTextField(PDAcroForm, COSDictionary,
   * PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDTextField(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link PDTextField#PDTextField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDTextField(PDAcroForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  @DisplayName(
      "Test isMultiline(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  @DisplayName(
      "Test isMultiline(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isMultiline()"})
  void testIsMultiline_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDTextField(new PDAcroForm(new PDDocument())).isMultiline());
  }

  /**
   * Test {@link PDTextField#isMultiline()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  @DisplayName("Test isMultiline(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isMultiline()"})
  void testIsMultiline_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(4096);

    // Act and Assert
    assertTrue(pdTextField.isMultiline());
  }

  /**
   * Test {@link PDTextField#setMultiline(boolean)}.
   *
   * <p>Method under test: {@link PDTextField#setMultiline(boolean)}
   */
  @Test
  @DisplayName("Test setMultiline(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setMultiline(boolean)"})
  void testSetMultiline() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act
    pdTextField.setMultiline(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(4096), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isMultiline());
  }

  /**
   * Test {@link PDTextField#setMultiline(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#setMultiline(boolean)}
   */
  @Test
  @DisplayName(
      "Test setMultiline(boolean); given PDNonTerminalField(PDAcroForm) with acroForm is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setMultiline(boolean)"})
  void testSetMultiline_givenPDNonTerminalFieldWithAcroFormIsNull() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDTextField pdTextField = new PDTextField(acroForm, field, new PDNonTerminalField(null));
    pdTextField.setRequired(true);

    // Act
    pdTextField.setMultiline(false);

    // Assert that nothing has changed
    verify(field, atLeast(1)).setFlag(isA(COSName.class), anyInt(), anyBoolean());
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isMultiline());
  }

  /**
   * Test {@link PDTextField#isPassword()}.
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  @DisplayName(
      "Test isPassword(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  @DisplayName(
      "Test isPassword(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isPassword()"})
  void testIsPassword_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDTextField(new PDAcroForm(new PDDocument())).isPassword());
  }

  /**
   * Test {@link PDTextField#isPassword()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  @DisplayName("Test isPassword(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isPassword()"})
  void testIsPassword_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(8192);

    // Act and Assert
    assertTrue(pdTextField.isPassword());
  }

  /**
   * Test {@link PDTextField#setPassword(boolean)}.
   *
   * <p>Method under test: {@link PDTextField#setPassword(boolean)}
   */
  @Test
  @DisplayName("Test setPassword(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setPassword(boolean)"})
  void testSetPassword() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act
    pdTextField.setPassword(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(8192), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isPassword());
  }

  /**
   * Test {@link PDTextField#setPassword(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} Q is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#setPassword(boolean)}
   */
  @Test
  @DisplayName(
      "Test setPassword(boolean); given PDAcroForm(PDDocument) with doc is PDDocument() Q is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setPassword(boolean)"})
  void testSetPassword_givenPDAcroFormWithDocIsPDDocumentQIsOne() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setQ(1);

    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);
    pdTextField.setRequired(true);

    // Act
    pdTextField.setPassword(false);

    // Assert that nothing has changed
    verify(field, atLeast(1)).setFlag(isA(COSName.class), anyInt(), anyBoolean());
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isPassword());
  }

  /**
   * Test {@link PDTextField#isFileSelect()}.
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  @DisplayName(
      "Test isFileSelect(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  @DisplayName(
      "Test isFileSelect(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isFileSelect()"})
  void testIsFileSelect_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDTextField(new PDAcroForm(new PDDocument())).isFileSelect());
  }

  /**
   * Test {@link PDTextField#isFileSelect()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  @DisplayName("Test isFileSelect(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isFileSelect()"})
  void testIsFileSelect_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(1048576);

    // Act and Assert
    assertTrue(pdTextField.isFileSelect());
  }

  /**
   * Test {@link PDTextField#setFileSelect(boolean)}.
   *
   * <p>Method under test: {@link PDTextField#setFileSelect(boolean)}
   */
  @Test
  @DisplayName("Test setFileSelect(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setFileSelect(boolean)"})
  void testSetFileSelect() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act
    pdTextField.setFileSelect(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(1048576), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isFileSelect());
  }

  /**
   * Test {@link PDTextField#doNotSpellCheck()}.
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  @DisplayName(
      "Test doNotSpellCheck(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  @DisplayName(
      "Test doNotSpellCheck(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.doNotSpellCheck()"})
  void testDoNotSpellCheck_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDTextField(new PDAcroForm(new PDDocument())).doNotSpellCheck());
  }

  /**
   * Test {@link PDTextField#doNotSpellCheck()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  @DisplayName("Test doNotSpellCheck(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.doNotSpellCheck()"})
  void testDoNotSpellCheck_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(4194304);

    // Act and Assert
    assertTrue(pdTextField.doNotSpellCheck());
  }

  /**
   * Test {@link PDTextField#setDoNotSpellCheck(boolean)}.
   *
   * <p>Method under test: {@link PDTextField#setDoNotSpellCheck(boolean)}
   */
  @Test
  @DisplayName("Test setDoNotSpellCheck(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setDoNotSpellCheck(boolean)"})
  void testSetDoNotSpellCheck() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act
    pdTextField.setDoNotSpellCheck(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(4194304), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
  }

  /**
   * Test {@link PDTextField#setDoNotSpellCheck(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument(COSDocument)} with doc is {@link
   *       COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#setDoNotSpellCheck(boolean)}
   */
  @Test
  @DisplayName(
      "Test setDoNotSpellCheck(boolean); given PDDocument(COSDocument) with doc is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setDoNotSpellCheck(boolean)"})
  void testSetDoNotSpellCheck_givenPDDocumentWithDocIsCOSDocument() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDAcroForm acroForm2 = new PDAcroForm(new PDDocument(new COSDocument()));
    PDNonTerminalField parent = new PDNonTerminalField(acroForm2);

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);
    pdTextField.setRequired(true);

    // Act
    pdTextField.setDoNotSpellCheck(false);

    // Assert that nothing has changed
    verify(field, atLeast(1)).setFlag(isA(COSName.class), anyInt(), anyBoolean());
    assertEquals(0, pdTextField.getFieldFlags());
  }

  /**
   * Test {@link PDTextField#doNotScroll()}.
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  @DisplayName(
      "Test doNotScroll(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  @DisplayName(
      "Test doNotScroll(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.doNotScroll()"})
  void testDoNotScroll_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDTextField(new PDAcroForm(new PDDocument())).doNotScroll());
  }

  /**
   * Test {@link PDTextField#doNotScroll()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  @DisplayName("Test doNotScroll(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.doNotScroll()"})
  void testDoNotScroll_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(8388608);

    // Act and Assert
    assertTrue(pdTextField.doNotScroll());
  }

  /**
   * Test {@link PDTextField#setDoNotScroll(boolean)}.
   *
   * <p>Method under test: {@link PDTextField#setDoNotScroll(boolean)}
   */
  @Test
  @DisplayName("Test setDoNotScroll(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setDoNotScroll(boolean)"})
  void testSetDoNotScroll() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act
    pdTextField.setDoNotScroll(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(8388608), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
  }

  /**
   * Test {@link PDTextField#isComb()}.
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isComb()}
   */
  @Test
  @DisplayName(
      "Test isComb(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isComb()}
   */
  @Test
  @DisplayName(
      "Test isComb(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isComb()"})
  void testIsComb_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDTextField(new PDAcroForm(new PDDocument())).isComb());
  }

  /**
   * Test {@link PDTextField#isComb()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isComb()}
   */
  @Test
  @DisplayName("Test isComb(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isComb()"})
  void testIsComb_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(16777216);

    // Act and Assert
    assertTrue(pdTextField.isComb());
  }

  /**
   * Test {@link PDTextField#setComb(boolean)}.
   *
   * <p>Method under test: {@link PDTextField#setComb(boolean)}
   */
  @Test
  @DisplayName("Test setComb(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setComb(boolean)"})
  void testSetComb() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act
    pdTextField.setComb(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(16777216), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isComb());
  }

  /**
   * Test {@link PDTextField#isRichText()}.
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  @DisplayName(
      "Test isRichText(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  @DisplayName(
      "Test isRichText(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isRichText()"})
  void testIsRichText_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDTextField(new PDAcroForm(new PDDocument())).isRichText());
  }

  /**
   * Test {@link PDTextField#isRichText()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  @DisplayName("Test isRichText(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isRichText()"})
  void testIsRichText_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(33554432);

    // Act and Assert
    assertTrue(pdTextField.isRichText());
  }

  /**
   * Test {@link PDTextField#setRichText(boolean)}.
   *
   * <p>Method under test: {@link PDTextField#setRichText(boolean)}
   */
  @Test
  @DisplayName("Test setRichText(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setRichText(boolean)"})
  void testSetRichText() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act
    pdTextField.setRichText(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(33554432), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isRichText());
  }

  /**
   * Test {@link PDTextField#getMaxLen()}.
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#getMaxLen()}
   */
  @Test
  @DisplayName(
      "Test getMaxLen(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTextField.getMaxLen()"})
  void testGetMaxLen_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDTextField(new PDAcroForm(new PDDocument())).getMaxLen());
  }

  /**
   * Test {@link PDTextField#setMaxLen(int)}.
   *
   * <p>Method under test: {@link PDTextField#setMaxLen(int)}
   */
  @Test
  @DisplayName("Test setMaxLen(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setMaxLen(int)"})
  void testSetMaxLen() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setInt(Mockito.<COSName>any(), anyInt());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act
    pdTextField.setMaxLen(3);

    // Assert that nothing has changed
    verify(field).setInt(isA(COSName.class), eq(3));
    assertEquals(0, pdTextField.getMaxLen());
  }

  /**
   * Test {@link PDTextField#setValue(String)}.
   *
   * <p>Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance(
        "\\u000D\\u000A|[\\u000A\\u000B\\u000C\\u000D\\u0085\\u2028\\u2029]");
    PDTextField pdTextField = new PDTextField(acroForm);

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
   *
   * <p>Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue2() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance(
        "widget of field {} has no rectangle, no appearance stream created");
    PDTextField pdTextField = new PDTextField(acroForm);

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
   *
   * <p>Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue3() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("org.apache.logging.log4j.util.StackLocator");
    PDTextField pdTextField = new PDTextField(acroForm);

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
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} DefaultAppearance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIs42() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("42");
    PDTextField pdTextField = new PDTextField(acroForm);

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
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} DefaultAppearance is {@code Da Value}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is 'Da Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIsDaValue()
      throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("Da Value");
    PDTextField pdTextField = new PDTextField(acroForm);

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
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} DefaultAppearance is {@code Widget}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is 'Widget'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIsWidget()
      throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("Widget");
    PDTextField pdTextField = new PDTextField(acroForm);

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
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} PartialName is cr lf.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is cr lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDTextFieldWithAcroFormIsPDAcroFormPartialNameIsCrLf() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("42");

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setPartialName("\r\n");

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
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} PartialName is space.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDTextFieldWithAcroFormIsPDAcroFormPartialNameIsSpace()
      throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("42");

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setPartialName(" ");

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
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_givenPDTextFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("42");

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setReadOnly(true);

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
   *
   * <ul>
   *   <li>When cr lf.
   *   <li>Then {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} Value is cr lf.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String); when cr lf; then PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is cr lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setValue(String)"})
  void testSetValue_whenCrLf_thenPDTextFieldWithAcroFormIsPDAcroFormValueIsCrLf()
      throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("42");
    PDTextField pdTextField = new PDTextField(acroForm);

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
   * Test {@link PDTextField#setDefaultValue(String)}.
   *
   * <p>Method under test: {@link PDTextField#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setDefaultValue(String)"})
  void testSetDefaultValue() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setString(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act
    pdTextField.setDefaultValue("42");

    // Assert that nothing has changed
    verify(field).setString(isA(COSName.class), eq("42"));
    assertEquals("", pdTextField.getDefaultValue());
  }

  /**
   * Test {@link PDTextField#setDefaultValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setFlag(COSName, int, boolean)} does
   *       nothing.
   *   <li>Then calls {@link COSDictionary#setFlag(COSName, int, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#setDefaultValue(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultValue(String); given COSDictionary setFlag(COSName, int, boolean) does nothing; then calls setFlag(COSName, int, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.setDefaultValue(String)"})
  void testSetDefaultValue_givenCOSDictionarySetFlagDoesNothing_thenCallsSetFlag() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    doNothing().when(field).setString(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);
    pdTextField.setReadOnly(true);

    // Act
    pdTextField.setDefaultValue("ValueValue");

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(1), eq(true));
    verify(field).setString(isA(COSName.class), eq("ValueValue"));
    assertEquals("", pdTextField.getDefaultValue());
  }

  /**
   * Test {@link PDTextField#getValue()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTextField.getValue()"})
  void testGetValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act and Assert
    assertEquals("", pdTextField.getValue());
  }

  /**
   * Test {@link PDTextField#getValue()}.
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTextField.getValue()"})
  void testGetValue_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new PDTextField(new PDAcroForm(new PDDocument())).getValue());
  }

  /**
   * Test {@link PDTextField#getDefaultValue()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#getDefaultValue()}
   */
  @Test
  @DisplayName(
      "Test getDefaultValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTextField.getDefaultValue()"})
  void testGetDefaultValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act and Assert
    assertEquals("", pdTextField.getDefaultValue());
  }

  /**
   * Test {@link PDTextField#getDefaultValue()}.
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#getDefaultValue()}
   */
  @Test
  @DisplayName(
      "Test getDefaultValue(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTextField.getDefaultValue()"})
  void testGetDefaultValue_givenPDTextFieldWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", new PDTextField(new PDAcroForm(new PDDocument())).getDefaultValue());
  }

  /**
   * Test {@link PDTextField#getValueAsString()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#getValueAsString()}
   */
  @Test
  @DisplayName(
      "Test getValueAsString(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTextField.getValueAsString()"})
  void testGetValueAsString_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act and Assert
    assertEquals("", pdTextField.getValueAsString());
  }

  /**
   * Test {@link PDTextField#getValueAsString()}.
   *
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#getValueAsString()}
   */
  @Test
  @DisplayName(
      "Test getValueAsString(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTextField.getValueAsString()"})
  void testGetValueAsString_givenPDTextFieldWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", new PDTextField(new PDAcroForm(new PDDocument())).getValueAsString());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   *
   * <p>Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.constructAppearances()"})
  void testConstructAppearances() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    // Act
    new PDTextField(acroForm).constructAppearances();

    // Assert
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(acroForm, atLeast(1)).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   *
   * <p>Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.constructAppearances()"})
  void testConstructAppearances2() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setReadOnly(true);

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(acroForm, atLeast(1)).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   *
   * <p>Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.constructAppearances()"})
  void testConstructAppearances3() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setPartialName("\r\n");

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(acroForm, atLeast(1)).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   *
   * <p>Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.constructAppearances()"})
  void testConstructAppearances4() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSString("\r\n"));

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setReadOnly(true);

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(acroForm, atLeast(1)).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSString} {@link COSString#getBytes()} return array of {@code byte} with
   *       {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSString getBytes() return array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.constructAppearances()"})
  void testConstructAppearances_givenCOSStringGetBytesReturnArrayOfByteWithAAndX()
      throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getString()).thenReturn("String");
    when(cosString.getBytes()).thenReturn(new byte[] {'A', 'X', 0, 'X', 'A', 'X', 'A', 'X'});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setReadOnly(true);

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosString).getBytes();
    verify(cosString).getString();
    verify(acroForm, atLeast(1)).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSString} {@link COSString#getBytes()} return array of {@code byte} with
   *       {@code A} and zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSString getBytes() return array of byte with 'A' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.constructAppearances()"})
  void testConstructAppearances_givenCOSStringGetBytesReturnArrayOfByteWithAAndZero()
      throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getString()).thenReturn("String");
    when(cosString.getBytes()).thenReturn(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setReadOnly(true);

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosString).getBytes();
    verify(cosString).getString();
    verify(acroForm, atLeast(1)).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSString} {@link COSString#getBytes()} return array of {@code byte} with
   *       one and zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSString getBytes() return array of byte with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.constructAppearances()"})
  void testConstructAppearances_givenCOSStringGetBytesReturnArrayOfByteWithOneAndZero()
      throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getString()).thenReturn("String");
    when(cosString.getBytes()).thenReturn(new byte[] {1, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setReadOnly(true);

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosString).getBytes();
    verify(cosString).getString();
    verify(acroForm, atLeast(1)).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSString} {@link COSString#getBytes()} return array of {@code byte} with
   *       {@code X} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSString getBytes() return array of byte with 'X' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.constructAppearances()"})
  void testConstructAppearances_givenCOSStringGetBytesReturnArrayOfByteWithXAndX()
      throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getString()).thenReturn("String");
    when(cosString.getBytes()).thenReturn(new byte[] {'X', 'X', 0, 'X', 'A', 'X', 'A', 'X'});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setReadOnly(true);

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosString).getBytes();
    verify(cosString).getString();
    verify(acroForm, atLeast(1)).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSString} {@link COSString#getBytes()} return {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSString getBytes() return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTextField.constructAppearances()"})
  void testConstructAppearances_givenCOSStringGetBytesReturnAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getString()).thenReturn("String");
    when(cosString.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setReadOnly(true);

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosString).getBytes();
    verify(cosString).getString();
    verify(acroForm, atLeast(1)).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }
}
