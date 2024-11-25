package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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

class PDListBoxDiffblueTest {
  /**
   * Test
   * {@link PDListBox#PDListBox(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <p>
   * Method under test:
   * {@link PDListBox#PDListBox(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDListBox(PDAcroForm, COSDictionary, PDNonTerminalField)")
  void testNewPDListBox() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDListBox actualPdListBox = new PDListBox(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdListBox.getCOSObject());
    assertSame(acroForm, actualPdListBox.getAcroForm());
    assertSame(parent, actualPdListBox.getParent());
  }

  /**
   * Test {@link PDListBox#PDListBox(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDListBox#PDListBox(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDListBox(PDAcroForm)")
  void testNewPDListBox2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDListBox actualPdListBox = new PDListBox(acroForm);

    // Assert
    List<PDAnnotationWidget> widgets = actualPdListBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertEquals("", actualPdListBox.getRichTextValue());
    assertEquals("Ch", actualPdListBox.getFieldType());
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Widget", getResult.getSubtype());
    assertEquals("[]", actualPdListBox.getValueAsString());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(actualPdListBox.getAlternateFieldName());
    assertNull(actualPdListBox.getFullyQualifiedName());
    assertNull(actualPdListBox.getMappingName());
    assertNull(actualPdListBox.getPartialName());
    assertNull(actualPdListBox.getDefaultAppearance());
    assertNull(actualPdListBox.getDefaultStyleString());
    COSDictionary cOSObject = actualPdListBox.getCOSObject();
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
    assertNull(actualPdListBox.getActions());
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertNull(actualPdListBox.getParent());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, actualPdListBox.getTopIndex());
    assertEquals(0, actualPdListBox.getFieldFlags());
    assertEquals(0, actualPdListBox.getQ());
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
    assertFalse(actualPdListBox.isCombo());
    assertFalse(actualPdListBox.isCommitOnSelChange());
    assertFalse(actualPdListBox.isDoNotSpellCheck());
    assertFalse(actualPdListBox.isMultiSelect());
    assertFalse(actualPdListBox.isSort());
    assertFalse(actualPdListBox.isNoExport());
    assertFalse(actualPdListBox.isReadOnly());
    assertFalse(actualPdListBox.isRequired());
    List<String> defaultValue = actualPdListBox.getDefaultValue();
    assertTrue(defaultValue.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
    assertSame(acroForm, actualPdListBox.getAcroForm());
    assertSame(defaultValue, actualPdListBox.getOptions());
    assertSame(defaultValue, actualPdListBox.getOptionsDisplayValues());
    assertSame(defaultValue, actualPdListBox.getOptionsExportValues());
    assertSame(defaultValue, actualPdListBox.getSelectedOptionsIndex());
    assertSame(defaultValue, actualPdListBox.getValue());
    assertSame(cOSObject, getResult.getCOSObject());
  }

  /**
   * Test {@link PDListBox#getTopIndex()}.
   * <p>
   * Method under test: {@link PDListBox#getTopIndex()}
   */
  @Test
  @DisplayName("Test getTopIndex()")
  void testGetTopIndex() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals(0,
        (new PDListBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getTopIndex());
  }

  /**
   * Test {@link PDListBox#getTopIndex()}.
   * <ul>
   *   <li>Given {@link PDListBox#PDListBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDListBox#getTopIndex()}
   */
  @Test
  @DisplayName("Test getTopIndex(); given PDListBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  void testGetTopIndex_givenPDListBoxWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDListBox(new PDAcroForm(new PDDocument()))).getTopIndex());
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDListBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("Widget"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDListBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances3() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("ID"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDListBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances4() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("BI"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDListBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
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
    (new PDListBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances6() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("42"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDListBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances7() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSString("org.apache.logging.log4j.util.StackLocator"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDListBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances8() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    PDListBox pdListBox = new PDListBox(new PDAcroForm(new PDDocument(), form));
    pdListBox.setPartialName("Widget");

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return parseHex
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getDictionaryObject(COSName) return parseHex '42'")
  void testConstructAppearances_givenCOSDictionaryGetDictionaryObjectReturnParseHex42() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("42"));
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDListBox(new PDAcroForm(new PDDocument(), form))).constructAppearances();

    // Assert
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getDictionaryObject(isA(COSName.class));
  }
}
