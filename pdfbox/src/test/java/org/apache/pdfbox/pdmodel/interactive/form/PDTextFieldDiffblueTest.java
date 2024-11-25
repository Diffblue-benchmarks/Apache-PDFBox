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
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTextFieldDiffblueTest {
  /**
   * Test
   * {@link PDTextField#PDTextField(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <p>
   * Method under test:
   * {@link PDTextField#PDTextField(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDTextField(PDAcroForm, COSDictionary, PDNonTerminalField)")
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
  void testNewPDTextField2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDTextField actualPdTextField = new PDTextField(acroForm);

    // Assert
    List<PDAnnotationWidget> widgets = actualPdTextField.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertEquals("", actualPdTextField.getDefaultValue());
    assertEquals("", actualPdTextField.getValue());
    assertEquals("", actualPdTextField.getValueAsString());
    assertEquals("", actualPdTextField.getRichTextValue());
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Tx", actualPdTextField.getFieldType());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(actualPdTextField.getAlternateFieldName());
    assertNull(actualPdTextField.getFullyQualifiedName());
    assertNull(actualPdTextField.getMappingName());
    assertNull(actualPdTextField.getPartialName());
    assertNull(actualPdTextField.getDefaultAppearance());
    assertNull(actualPdTextField.getDefaultStyleString());
    COSDictionary cOSObject = actualPdTextField.getCOSObject();
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
    assertNull(actualPdTextField.getActions());
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertNull(actualPdTextField.getParent());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(-1, actualPdTextField.getMaxLen());
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, actualPdTextField.getFieldFlags());
    assertEquals(0, actualPdTextField.getQ());
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
    assertFalse(actualPdTextField.isNoExport());
    assertFalse(actualPdTextField.isReadOnly());
    assertFalse(actualPdTextField.isRequired());
    assertFalse(actualPdTextField.isComb());
    assertFalse(actualPdTextField.isFileSelect());
    assertFalse(actualPdTextField.isMultiline());
    assertFalse(actualPdTextField.isPassword());
    assertFalse(actualPdTextField.isRichText());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
    assertSame(acroForm, actualPdTextField.getAcroForm());
    assertSame(cOSObject, getResult.getCOSObject());
  }

  /**
   * Test {@link PDTextField#isMultiline()}.
   * <p>
   * Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  @DisplayName("Test isMultiline()")
  void testIsMultiline() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isMultiline());
  }

  /**
   * Test {@link PDTextField#isMultiline()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  @DisplayName("Test isMultiline(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  @DisplayName("Test isMultiline(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
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
  void testIsMultiline_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(4096);

    // Act and Assert
    assertTrue(pdTextField.isMultiline());
  }

  /**
   * Test {@link PDTextField#setMultiline(boolean)}.
   * <p>
   * Method under test: {@link PDTextField#setMultiline(boolean)}
   */
  @Test
  @DisplayName("Test setMultiline(boolean)")
  void testSetMultiline() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDTextField pdTextField = new PDTextField(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdTextField.setMultiline(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(4096), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isMultiline());
  }

  /**
   * Test {@link PDTextField#isPassword()}.
   * <p>
   * Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  @DisplayName("Test isPassword()")
  void testIsPassword() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isPassword());
  }

  /**
   * Test {@link PDTextField#isPassword()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  @DisplayName("Test isPassword(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  @DisplayName("Test isPassword(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
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
  void testIsPassword_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(8192);

    // Act and Assert
    assertTrue(pdTextField.isPassword());
  }

  /**
   * Test {@link PDTextField#setPassword(boolean)}.
   * <p>
   * Method under test: {@link PDTextField#setPassword(boolean)}
   */
  @Test
  @DisplayName("Test setPassword(boolean)")
  void testSetPassword() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDTextField pdTextField = new PDTextField(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdTextField.setPassword(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(8192), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isPassword());
  }

  /**
   * Test {@link PDTextField#isFileSelect()}.
   * <p>
   * Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  @DisplayName("Test isFileSelect()")
  void testIsFileSelect() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isFileSelect());
  }

  /**
   * Test {@link PDTextField#isFileSelect()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  @DisplayName("Test isFileSelect(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  @DisplayName("Test isFileSelect(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
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
  void testIsFileSelect_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(1048576);

    // Act and Assert
    assertTrue(pdTextField.isFileSelect());
  }

  /**
   * Test {@link PDTextField#setFileSelect(boolean)}.
   * <p>
   * Method under test: {@link PDTextField#setFileSelect(boolean)}
   */
  @Test
  @DisplayName("Test setFileSelect(boolean)")
  void testSetFileSelect() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDTextField pdTextField = new PDTextField(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdTextField.setFileSelect(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(1048576), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isFileSelect());
  }

  /**
   * Test {@link PDTextField#doNotSpellCheck()}.
   * <p>
   * Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  @DisplayName("Test doNotSpellCheck()")
  void testDoNotSpellCheck() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).doNotSpellCheck());
  }

  /**
   * Test {@link PDTextField#doNotSpellCheck()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  @DisplayName("Test doNotSpellCheck(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  @DisplayName("Test doNotSpellCheck(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
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
  void testDoNotSpellCheck_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(4194304);

    // Act and Assert
    assertTrue(pdTextField.doNotSpellCheck());
  }

  /**
   * Test {@link PDTextField#setDoNotSpellCheck(boolean)}.
   * <p>
   * Method under test: {@link PDTextField#setDoNotSpellCheck(boolean)}
   */
  @Test
  @DisplayName("Test setDoNotSpellCheck(boolean)")
  void testSetDoNotSpellCheck() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDTextField pdTextField = new PDTextField(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdTextField.setDoNotSpellCheck(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(4194304), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
  }

  /**
   * Test {@link PDTextField#doNotScroll()}.
   * <p>
   * Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  @DisplayName("Test doNotScroll()")
  void testDoNotScroll() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).doNotScroll());
  }

  /**
   * Test {@link PDTextField#doNotScroll()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  @DisplayName("Test doNotScroll(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  @DisplayName("Test doNotScroll(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
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
  void testDoNotScroll_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(8388608);

    // Act and Assert
    assertTrue(pdTextField.doNotScroll());
  }

  /**
   * Test {@link PDTextField#setDoNotScroll(boolean)}.
   * <p>
   * Method under test: {@link PDTextField#setDoNotScroll(boolean)}
   */
  @Test
  @DisplayName("Test setDoNotScroll(boolean)")
  void testSetDoNotScroll() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDTextField pdTextField = new PDTextField(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdTextField.setDoNotScroll(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(8388608), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
  }

  /**
   * Test {@link PDTextField#isComb()}.
   * <p>
   * Method under test: {@link PDTextField#isComb()}
   */
  @Test
  @DisplayName("Test isComb()")
  void testIsComb() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse((new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isComb());
  }

  /**
   * Test {@link PDTextField#isComb()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isComb()}
   */
  @Test
  @DisplayName("Test isComb(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isComb()}
   */
  @Test
  @DisplayName("Test isComb(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
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
  void testIsComb_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(16777216);

    // Act and Assert
    assertTrue(pdTextField.isComb());
  }

  /**
   * Test {@link PDTextField#setComb(boolean)}.
   * <p>
   * Method under test: {@link PDTextField#setComb(boolean)}
   */
  @Test
  @DisplayName("Test setComb(boolean)")
  void testSetComb() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDTextField pdTextField = new PDTextField(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdTextField.setComb(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(16777216), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isComb());
  }

  /**
   * Test {@link PDTextField#isRichText()}.
   * <p>
   * Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  @DisplayName("Test isRichText()")
  void testIsRichText() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isRichText());
  }

  /**
   * Test {@link PDTextField#isRichText()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  @DisplayName("Test isRichText(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  @DisplayName("Test isRichText(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
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
  void testIsRichText_thenReturnTrue() {
    // Arrange
    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument()));
    pdTextField.setFieldFlags(33554432);

    // Act and Assert
    assertTrue(pdTextField.isRichText());
  }

  /**
   * Test {@link PDTextField#setRichText(boolean)}.
   * <p>
   * Method under test: {@link PDTextField#setRichText(boolean)}
   */
  @Test
  @DisplayName("Test setRichText(boolean)")
  void testSetRichText() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDTextField pdTextField = new PDTextField(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdTextField.setRichText(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(33554432), eq(true));
    assertEquals(0, pdTextField.getFieldFlags());
    assertFalse(pdTextField.isRichText());
  }

  /**
   * Test {@link PDTextField#getMaxLen()}.
   * <p>
   * Method under test: {@link PDTextField#getMaxLen()}
   */
  @Test
  @DisplayName("Test getMaxLen()")
  void testGetMaxLen() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals(-1,
        (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getMaxLen());
  }

  /**
   * Test {@link PDTextField#getMaxLen()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getMaxLen()}
   */
  @Test
  @DisplayName("Test getMaxLen(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return minus one")
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
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()} DefaultAppearance is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is '42'")
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
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()} DefaultAppearance is {@code Annot}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is 'Annot'")
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
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()} DefaultAppearance is {@code Da Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is 'Da Value'")
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
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()} DefaultAppearance is {@code Widget}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is 'Widget'")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} PartialName is cr lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is cr lf")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
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
   *   <li>Then {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} Value is cr lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); when cr lf; then PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is cr lf")
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
   *   <li>Then {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} Value is space.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String); when space; then PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is space")
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
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testGetValue_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(doc, new COSDictionary()))).getValue());
  }

  /**
   * Test {@link PDTextField#getValue()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return empty string")
  void testGetValue_givenPDTextFieldWithAcroFormIsPDAcroForm_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(new PDDocument()))).getValue());
  }

  /**
   * Test {@link PDTextField#getDefaultValue()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testGetDefaultValue_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(doc, new COSDictionary()))).getDefaultValue());
  }

  /**
   * Test {@link PDTextField#getDefaultValue()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetDefaultValue_givenPDTextFieldWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(new PDDocument()))).getDefaultValue());
  }

  /**
   * Test {@link PDTextField#getValueAsString()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testGetValueAsString_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(doc, new COSDictionary()))).getValueAsString());
  }

  /**
   * Test {@link PDTextField#getValueAsString()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
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
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetValueAsString_givenPDTextFieldWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDTextField(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("Widget"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDTextField(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances3() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("\r\n"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDTextField(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances4() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("ID"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDTextField(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances5() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("BI"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDTextField(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances6() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSString("\\u000D\\u000A|[\\u000A\\u000B\\u000C\\u000D\\u0085\\u2028\\u2029]"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDTextField(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances7() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSString("widget of field {} has no rectangle, no appearance stream created"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDTextField(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances8() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(), form));
    pdTextField.setPartialName("\r\n");

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances9() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSString("org.apache.logging.log4j.util.StackLocator"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDTextField(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return parseHex
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getDictionaryObject(COSName) return parseHex '42'")
  void testConstructAppearances_givenCOSDictionaryGetDictionaryObjectReturnParseHex42() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("42"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDTextField(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return parseHex cr
   * lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getDictionaryObject(COSName) return parseHex cr lf")
  void testConstructAppearances_givenCOSDictionaryGetDictionaryObjectReturnParseHexCrLf() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("\r\n"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDTextField(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDTextField#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDTextField#PDTextField(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} ReadOnly is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDTextField(PDAcroForm) with acroForm is PDAcroForm(PDDocument, COSDictionary) ReadOnly is 'true'")
  void testConstructAppearances_givenPDTextFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(), form));
    pdTextField.setReadOnly(true);

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }
}
