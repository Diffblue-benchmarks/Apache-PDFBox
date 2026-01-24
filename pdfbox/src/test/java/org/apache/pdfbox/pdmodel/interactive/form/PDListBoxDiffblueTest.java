package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
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
   *
   * <p>Method under test: {@link PDListBox#PDListBox(PDAcroForm, COSDictionary,
   * PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDListBox(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link PDListBox#PDListBox(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDListBox(PDAcroForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDListBox#PDListBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDListBox#getTopIndex()}
   */
  @Test
  @DisplayName(
      "Test getTopIndex(); given PDListBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDListBox.getTopIndex()"})
  void testGetTopIndex_givenPDListBoxWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDListBox(new PDAcroForm(new PDDocument())).getTopIndex());
  }

  /**
   * Test {@link PDListBox#setTopIndex(Integer)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#removeItem(COSName)} does nothing.
   *   <li>Then calls {@link COSDictionary#removeItem(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDListBox#setTopIndex(Integer)}
   */
  @Test
  @DisplayName(
      "Test setTopIndex(Integer); given COSDictionary removeItem(COSName) does nothing; then calls removeItem(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.setTopIndex(Integer)"})
  void testSetTopIndex_givenCOSDictionaryRemoveItemDoesNothing_thenCallsRemoveItem() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).removeItem(Mockito.<COSName>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDListBox pdListBox = new PDListBox(acroForm, field, parent);

    // Act
    pdListBox.setTopIndex(null);

    // Assert that nothing has changed
    verify(field).removeItem(isA(COSName.class));
    assertEquals(0, pdListBox.getTopIndex());
  }

  /**
   * Test {@link PDListBox#setTopIndex(Integer)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setInt(COSName, int)} does nothing.
   *   <li>When one.
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDListBox#setTopIndex(Integer)}
   */
  @Test
  @DisplayName(
      "Test setTopIndex(Integer); given COSDictionary setInt(COSName, int) does nothing; when one; then calls setInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.setTopIndex(Integer)"})
  void testSetTopIndex_givenCOSDictionarySetIntDoesNothing_whenOne_thenCallsSetInt() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setInt(Mockito.<COSName>any(), anyInt());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDListBox pdListBox = new PDListBox(acroForm, field, parent);

    // Act
    pdListBox.setTopIndex(1);

    // Assert that nothing has changed
    verify(field).setInt(isA(COSName.class), eq(1));
    assertEquals(0, pdListBox.getTopIndex());
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   *
   * <p>Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
  void testConstructAppearances() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    // Act
    new PDListBox(acroForm).constructAppearances();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(acroForm).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   *
   * <p>Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
  void testConstructAppearances2() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.setPartialName("Widget");

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(acroForm).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   *
   * <p>Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
  void testConstructAppearances3() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSString("Widget"));

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.setPartialName("Widget");

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(acroForm).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   *
   * <p>Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
  void testConstructAppearances4() throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.setPartialName("");

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosString).getBytes();
    verify(acroForm).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSString} {@link COSString#getBytes()} return array of {@code byte} with
   *       {@code A} and zero.
   * </ul>
   *
   * <p>Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSString getBytes() return array of byte with 'A' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
  void testConstructAppearances_givenCOSStringGetBytesReturnArrayOfByteWithAAndZero()
      throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getBytes()).thenReturn(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.setPartialName("Widget");

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosString).getBytes();
    verify(acroForm).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSString} {@link COSString#getBytes()} return array of {@code byte} with
   *       one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSString getBytes() return array of byte with one and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
  void testConstructAppearances_givenCOSStringGetBytesReturnArrayOfByteWithOneAndX()
      throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getBytes()).thenReturn(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.setPartialName("Widget");

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosString).getBytes();
    verify(acroForm).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSString} {@link COSString#getBytes()} return array of {@code byte} with
   *       one and zero.
   * </ul>
   *
   * <p>Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSString getBytes() return array of byte with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
  void testConstructAppearances_givenCOSStringGetBytesReturnArrayOfByteWithOneAndZero()
      throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getBytes()).thenReturn(new byte[] {1, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.setPartialName("Widget");

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosString).getBytes();
    verify(acroForm).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSString} {@link COSString#getBytes()} return {@code AXAX?XAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSString getBytes() return 'AXAX?XAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
  void testConstructAppearances_givenCOSStringGetBytesReturnAxaxXaxBytesIsUtf8()
      throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getBytes()).thenReturn("AXAX?XAX".getBytes("UTF-8"));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.setPartialName("Widget");

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosString).getBytes();
    verify(acroForm).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }

  /**
   * Test {@link PDListBox#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSString} {@link COSString#getBytes()} return {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDListBox#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSString getBytes() return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.constructAppearances()"})
  void testConstructAppearances_givenCOSStringGetBytesReturnAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.setPartialName("Widget");

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosString).getBytes();
    verify(acroForm).getCOSObject();
    verify(acroForm, atLeast(1)).getDefaultResources();
  }
}
