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

class PDListBoxDiffblueTest {
  /**
   * Test {@link PDListBox#PDListBox(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <p>
   * Method under test: {@link PDListBox#PDListBox(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDListBox(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDListBox.<init>(PDAcroForm, COSDictionary, PDNonTerminalField)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDListBox.<init>(PDAcroForm)"})
  void testNewPDListBox2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDListBox actualPdListBox = new PDListBox(acroForm);

    // Assert
    assertEquals("", actualPdListBox.getRichTextValue());
    assertEquals("Ch", actualPdListBox.getFieldType());
    assertEquals("[]", actualPdListBox.getValueAsString());
    assertNull(actualPdListBox.getAlternateFieldName());
    assertNull(actualPdListBox.getFullyQualifiedName());
    assertNull(actualPdListBox.getMappingName());
    assertNull(actualPdListBox.getPartialName());
    assertNull(actualPdListBox.getDefaultAppearance());
    assertNull(actualPdListBox.getDefaultStyleString());
    assertNull(actualPdListBox.getActions());
    assertNull(actualPdListBox.getParent());
    assertEquals(0, actualPdListBox.getTopIndex());
    assertEquals(0, actualPdListBox.getFieldFlags());
    assertEquals(0, actualPdListBox.getQ());
    assertEquals(1, actualPdListBox.getWidgets().size());
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
    assertSame(acroForm, actualPdListBox.getAcroForm());
    assertSame(defaultValue, actualPdListBox.getOptions());
    assertSame(defaultValue, actualPdListBox.getOptionsDisplayValues());
    assertSame(defaultValue, actualPdListBox.getOptionsExportValues());
    assertSame(defaultValue, actualPdListBox.getSelectedOptionsIndex());
    assertSame(defaultValue, actualPdListBox.getValue());
  }

  /**
   * Test {@link PDListBox#getTopIndex()}.
   * <ul>
   *   <li>Given {@link PDListBox#PDListBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDListBox#getTopIndex()}
   */
  @Test
  @DisplayName("Test getTopIndex(); given PDListBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDListBox.getTopIndex()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
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
    (new PDListBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
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
    (new PDListBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return COSDictionary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
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
    (new PDListBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
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
    (new PDListBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
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
    (new PDListBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return parseHex {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getDictionaryObject(COSName) return parseHex '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
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
    (new PDListBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).isEmpty();
    verify(field).containsKey(isA(COSName.class));
    verify(field, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
  }
}
