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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDComboBoxDiffblueTest {
  /**
   * Test {@link PDComboBox#PDComboBox(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <p>
   * Method under test: {@link PDComboBox#PDComboBox(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDComboBox(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDComboBox.<init>(PDAcroForm, COSDictionary, PDNonTerminalField)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDComboBox.<init>(PDAcroForm)"})
  void testNewPDComboBox2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDComboBox actualPdComboBox = new PDComboBox(acroForm);

    // Assert
    assertEquals("", actualPdComboBox.getRichTextValue());
    assertEquals("Ch", actualPdComboBox.getFieldType());
    assertEquals("[]", actualPdComboBox.getValueAsString());
    assertNull(actualPdComboBox.getAlternateFieldName());
    assertNull(actualPdComboBox.getFullyQualifiedName());
    assertNull(actualPdComboBox.getMappingName());
    assertNull(actualPdComboBox.getPartialName());
    assertNull(actualPdComboBox.getDefaultAppearance());
    assertNull(actualPdComboBox.getDefaultStyleString());
    assertNull(actualPdComboBox.getActions());
    assertNull(actualPdComboBox.getParent());
    assertEquals(0, actualPdComboBox.getQ());
    assertEquals(1, actualPdComboBox.getWidgets().size());
    assertEquals(131072, actualPdComboBox.getFieldFlags());
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
    assertTrue(actualPdComboBox.isCombo());
    assertSame(acroForm, actualPdComboBox.getAcroForm());
    assertSame(defaultValue, actualPdComboBox.getOptions());
    assertSame(defaultValue, actualPdComboBox.getOptionsDisplayValues());
    assertSame(defaultValue, actualPdComboBox.getOptionsExportValues());
    assertSame(defaultValue, actualPdComboBox.getSelectedOptionsIndex());
    assertSame(defaultValue, actualPdComboBox.getValue());
  }

  /**
   * Test {@link PDComboBox#isEdit()}.
   * <p>
   * Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  @DisplayName("Test isEdit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDComboBox.isEdit()"})
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
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  @DisplayName("Test isEdit(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDComboBox.isEdit()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDComboBox.isEdit()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDComboBox.setEdit(boolean)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDComboBox.constructAppearances()"})
  void testConstructAppearances() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(field.containsKey(Mockito.<COSName>any())).thenReturn(true);

    // Act
    (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDComboBox.constructAppearances()"})
  void testConstructAppearances2() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(field.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSString("/DA is a required entry. Please set a default appearance first."));
    when(field.containsKey(Mockito.<COSName>any())).thenReturn(true);

    // Act
    (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return COSDictionary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDComboBox.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(field.containsKey(Mockito.<COSName>any())).thenReturn(true);

    // Act
    (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDComboBox.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSDictionaryReturnNull() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(field.containsKey(Mockito.<COSName>any())).thenReturn(true);

    // Act
    (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDComboBox.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSDictionaryReturnNull2() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(field.containsKey(Mockito.<COSName>any())).thenReturn(true);

    // Act
    (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDComboBox#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return parseHex {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getDictionaryObject(COSName) return parseHex '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDComboBox.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetDictionaryObjectReturnParseHex42() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("42"));
    when(field.containsKey(Mockito.<COSName>any())).thenReturn(true);

    // Act
    (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
  }
}
