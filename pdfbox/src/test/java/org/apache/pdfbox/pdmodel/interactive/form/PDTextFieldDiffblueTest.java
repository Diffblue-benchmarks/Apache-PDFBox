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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
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
   * <p>Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  @DisplayName("Test isMultiline()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isMultiline()"})
  void testIsMultiline() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdTextField.isMultiline());
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
   * Test {@link PDTextField#isPassword()}.
   *
   * <p>Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  @DisplayName("Test isPassword()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isPassword()"})
  void testIsPassword() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdTextField.isPassword());
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
   * Test {@link PDTextField#isFileSelect()}.
   *
   * <p>Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  @DisplayName("Test isFileSelect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isFileSelect()"})
  void testIsFileSelect() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdTextField.isFileSelect());
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
   * <p>Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  @DisplayName("Test doNotSpellCheck()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.doNotSpellCheck()"})
  void testDoNotSpellCheck() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdTextField.doNotSpellCheck());
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
   * Test {@link PDTextField#doNotScroll()}.
   *
   * <p>Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  @DisplayName("Test doNotScroll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.doNotScroll()"})
  void testDoNotScroll() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdTextField.doNotScroll());
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
   * <p>Method under test: {@link PDTextField#isComb()}
   */
  @Test
  @DisplayName("Test isComb()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isComb()"})
  void testIsComb() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdTextField.isComb());
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
   * <p>Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  @DisplayName("Test isRichText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTextField.isRichText()"})
  void testIsRichText() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdTextField.isRichText());
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
   * <p>Method under test: {@link PDTextField#getMaxLen()}
   */
  @Test
  @DisplayName("Test getMaxLen()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTextField.getMaxLen()"})
  void testGetMaxLen() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDTextField pdTextField = new PDTextField(acroForm, field, parent);

    // Act and Assert
    assertEquals(-1, pdTextField.getMaxLen());
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
   * Test {@link PDTextField#getValue()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDTextField.getValue()"})
  void testGetValue_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertEquals("", new PDTextField(acroForm).getValue());
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
  @MethodsUnderTest({"java.lang.String PDTextField.getValue()"})
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
  @MethodsUnderTest({"java.lang.String PDTextField.getValue()"})
  void testGetValue_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new PDTextField(new PDAcroForm(new PDDocument())).getValue());
  }

  /**
   * Test {@link PDTextField#getDefaultValue()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#getDefaultValue()}
   */
  @Test
  @DisplayName(
      "Test getDefaultValue(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDTextField.getDefaultValue()"})
  void testGetDefaultValue_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertEquals("", new PDTextField(acroForm).getDefaultValue());
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
  @MethodsUnderTest({"java.lang.String PDTextField.getDefaultValue()"})
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
  @MethodsUnderTest({"java.lang.String PDTextField.getDefaultValue()"})
  void testGetDefaultValue_givenPDTextFieldWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", new PDTextField(new PDAcroForm(new PDDocument())).getDefaultValue());
  }

  /**
   * Test {@link PDTextField#getValueAsString()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTextField#getValueAsString()}
   */
  @Test
  @DisplayName(
      "Test getValueAsString(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDTextField.getValueAsString()"})
  void testGetValueAsString_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertEquals("", new PDTextField(acroForm).getValueAsString());
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
  @MethodsUnderTest({"java.lang.String PDTextField.getValueAsString()"})
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
  @MethodsUnderTest({"java.lang.String PDTextField.getValueAsString()"})
  void testGetValueAsString_givenPDTextFieldWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", new PDTextField(new PDAcroForm(new PDDocument())).getValueAsString());
  }
}
