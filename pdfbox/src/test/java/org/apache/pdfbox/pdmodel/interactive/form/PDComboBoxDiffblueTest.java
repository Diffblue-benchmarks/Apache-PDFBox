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
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDComboBoxDiffblueTest {
  /**
   * Test
   * {@link PDComboBox#PDComboBox(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <p>
   * Method under test:
   * {@link PDComboBox#PDComboBox(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDComboBox(PDAcroForm, COSDictionary, PDNonTerminalField)")
  void testNewPDComboBox() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDComboBox actualPdComboBox = new PDComboBox(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdComboBox.getCOSObject());
    assertSame(acroForm, actualPdComboBox.getAcroForm());
    assertSame(parent, actualPdComboBox.getParent());
  }

  /**
   * Test {@link PDComboBox#PDComboBox(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDComboBox#PDComboBox(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDComboBox(PDAcroForm)")
  void testNewPDComboBox2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDComboBox actualPdComboBox = new PDComboBox(acroForm);

    // Assert
    List<PDAnnotationWidget> widgets = actualPdComboBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertEquals("", actualPdComboBox.getRichTextValue());
    assertEquals("Ch", actualPdComboBox.getFieldType());
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Widget", getResult.getSubtype());
    assertEquals("[]", actualPdComboBox.getValueAsString());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(actualPdComboBox.getAlternateFieldName());
    assertNull(actualPdComboBox.getFullyQualifiedName());
    assertNull(actualPdComboBox.getMappingName());
    assertNull(actualPdComboBox.getPartialName());
    assertNull(actualPdComboBox.getDefaultAppearance());
    assertNull(actualPdComboBox.getDefaultStyleString());
    COSDictionary cOSObject = actualPdComboBox.getCOSObject();
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
    assertNull(actualPdComboBox.getActions());
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertNull(actualPdComboBox.getParent());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, actualPdComboBox.getQ());
    assertEquals(131072, actualPdComboBox.getFieldFlags());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
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
    assertFalse(actualPdComboBox.isCommitOnSelChange());
    assertFalse(actualPdComboBox.isDoNotSpellCheck());
    assertFalse(actualPdComboBox.isMultiSelect());
    assertFalse(actualPdComboBox.isSort());
    assertFalse(actualPdComboBox.isEdit());
    assertFalse(actualPdComboBox.isNoExport());
    assertFalse(actualPdComboBox.isReadOnly());
    assertFalse(actualPdComboBox.isRequired());
    List<String> defaultValue = actualPdComboBox.getDefaultValue();
    assertTrue(defaultValue.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
    assertTrue(actualPdComboBox.isCombo());
    assertSame(acroForm, actualPdComboBox.getAcroForm());
    assertSame(defaultValue, actualPdComboBox.getOptions());
    assertSame(defaultValue, actualPdComboBox.getOptionsDisplayValues());
    assertSame(defaultValue, actualPdComboBox.getOptionsExportValues());
    assertSame(defaultValue, actualPdComboBox.getSelectedOptionsIndex());
    assertSame(defaultValue, actualPdComboBox.getValue());
    assertSame(cOSObject, getResult.getCOSObject());
  }

  /**
   * Test {@link PDComboBox#isEdit()}.
   * <p>
   * Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  @DisplayName("Test isEdit()")
  void testIsEdit() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse((new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isEdit());
  }

  /**
   * Test {@link PDComboBox#isEdit()}.
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  @DisplayName("Test isEdit(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  void testIsEdit_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDComboBox(new PDAcroForm(new PDDocument()))).isEdit());
  }

  /**
   * Test {@link PDComboBox#isEdit()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  @DisplayName("Test isEdit(); then return 'true'")
  void testIsEdit_thenReturnTrue() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));
    pdComboBox.setFieldFlags(262144);

    // Act and Assert
    assertTrue(pdComboBox.isEdit());
  }

  /**
   * Test {@link PDComboBox#setEdit(boolean)}.
   * <p>
   * Method under test: {@link PDComboBox#setEdit(boolean)}
   */
  @Test
  @DisplayName("Test setEdit(boolean)")
  void testSetEdit() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setEdit(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(262144), eq(true));
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isEdit());
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDComboBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("Widget"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDComboBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances3() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("ID"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDComboBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances4() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("BI"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDComboBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances5() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSString("widget of field {} has no rectangle, no appearance stream created"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDComboBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances6() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("org.apache.pdfbox.cos.COSString"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDComboBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances7() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("42"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDComboBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances8() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSString("org.apache.logging.log4j.util.StackLocator"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDComboBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances9() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(), form));
    pdComboBox.setPartialName("Widget");

    // Act
    pdComboBox.constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return parseHex
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getDictionaryObject(COSName) return parseHex '42'")
  void testConstructAppearances_givenCOSDictionaryGetDictionaryObjectReturnParseHex42() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("42"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDComboBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }
}
