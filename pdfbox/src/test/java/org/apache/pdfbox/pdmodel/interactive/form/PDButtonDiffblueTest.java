package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDButtonDiffblueTest {
  /**
   * Test {@link PDButton#isPushButton()}.
   * <p>
   * Method under test: {@link PDButton#isPushButton()}
   */
  @Test
  @DisplayName("Test isPushButton()")
  void testIsPushButton() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isPushButton());
  }

  /**
   * Test {@link PDButton#isPushButton()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#isPushButton()}
   */
  @Test
  @DisplayName("Test isPushButton(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testIsPushButton_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act and Assert
    assertFalse(pdCheckBox.isPushButton());
  }

  /**
   * Test {@link PDButton#isPushButton()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#isPushButton()}
   */
  @Test
  @DisplayName("Test isPushButton(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  void testIsPushButton_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isPushButton());
  }

  /**
   * Test {@link PDButton#isPushButton()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#isPushButton()}
   */
  @Test
  @DisplayName("Test isPushButton(); then return 'true'")
  void testIsPushButton_thenReturnTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setFieldFlags(65536);

    // Act and Assert
    assertTrue(pdCheckBox.isPushButton());
  }

  /**
   * Test {@link PDButton#isRadioButton()}.
   * <p>
   * Method under test: {@link PDButton#isRadioButton()}
   */
  @Test
  @DisplayName("Test isRadioButton()")
  void testIsRadioButton() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isRadioButton());
  }

  /**
   * Test {@link PDButton#isRadioButton()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#isRadioButton()}
   */
  @Test
  @DisplayName("Test isRadioButton(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testIsRadioButton_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act and Assert
    assertFalse(pdCheckBox.isRadioButton());
  }

  /**
   * Test {@link PDButton#isRadioButton()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#isRadioButton()}
   */
  @Test
  @DisplayName("Test isRadioButton(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  void testIsRadioButton_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isRadioButton());
  }

  /**
   * Test {@link PDButton#isRadioButton()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#isRadioButton()}
   */
  @Test
  @DisplayName("Test isRadioButton(); then return 'true'")
  void testIsRadioButton_thenReturnTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setFieldFlags(32768);

    // Act and Assert
    assertTrue(pdCheckBox.isRadioButton());
  }

  /**
   * Test {@link PDButton#getValue()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testGetValue_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertEquals("Off", (new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).getValue());
  }

  /**
   * Test {@link PDButton#getValue()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code Off}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'Off'")
  void testGetValue_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnOff() {
    // Arrange, Act and Assert
    assertEquals("Off", (new PDCheckBox(new PDAcroForm(new PDDocument()))).getValue());
  }

  /**
   * Test {@link PDButton#getValue()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code Off}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'Off'")
  void testGetValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnOff() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("Off",
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getValue());
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   * <p>
   * Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName("Test setValue(int) with 'index'")
  void testSetValueWithIndex() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   * <p>
   * Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName("Test setValue(int) with 'index'")
  void testSetValueWithIndex2() throws IOException {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, new COSDictionary(), parent)).setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   * <p>
   * Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName("Test setValue(int) with 'index'")
  void testSetValueWithIndex3() throws IOException {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName("Test setValue(int) with 'index'; given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testSetValueWithIndex_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName("Test setValue(int) with 'index'; given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testSetValueWithIndex_givenPDCheckBoxWithAcroFormIsPDAcroForm() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDCheckBox(new PDAcroForm(new PDDocument()))).setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} PartialName is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName("Test setValue(int) with 'index'; given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is 'Name'")
  void testSetValueWithIndex_givenPDCheckBoxWithAcroFormIsPDAcroFormPartialNameIsName() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName("Test setValue(int) with 'index'; given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testSetValueWithIndex_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   * <p>
   * Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'")
  void testSetValueWithValue() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   * <p>
   * Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'")
  void testSetValueWithValue2() throws IOException {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Widget");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, new COSDictionary(), parent)).setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   * <p>
   * Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'")
  void testSetValueWithValue3() throws IOException {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Widget");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'; given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testSetValueWithValue_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'; given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testSetValueWithValue_givenPDCheckBoxWithAcroFormIsPDAcroForm() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(new PDDocument()))).setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} PartialName is {@code Widget}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'; given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is 'Widget'")
  void testSetValueWithValue_givenPDCheckBoxWithAcroFormIsPDAcroFormPartialNameIsWidget() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'; given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testSetValueWithValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
            .setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} Value is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'; then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is empty string")
  void testSetValueWithValue_thenPDCheckBoxWithAcroFormIsPDAcroFormValueIsEmptyString() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.setValue("");

    // Assert
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDButton#getDefaultValue()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testGetDefaultValue_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertEquals("", (new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).getDefaultValue());
  }

  /**
   * Test {@link PDButton#getDefaultValue()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetDefaultValue_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", (new PDCheckBox(new PDAcroForm(new PDDocument()))).getDefaultValue());
  }

  /**
   * Test {@link PDButton#getDefaultValue()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetDefaultValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("",
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getDefaultValue());
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   * <p>
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String)")
  void testSetDefaultValue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.setDefaultValue("");

    // Assert
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   * <p>
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String)")
  void testSetDefaultValue2() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   * <p>
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String)")
  void testSetDefaultValue3() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Widget");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, new COSDictionary(), parent)).setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   * <p>
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String)")
  void testSetDefaultValue4() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Widget");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testSetDefaultValue_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testSetDefaultValue_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(new PDDocument()))).setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} importFDF
   * {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  void testSetDefaultValue_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.importFDF(new FDFField());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} PartialName is {@code Widget}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is 'Widget'")
  void testSetDefaultValue_givenPDCheckBoxWithAcroFormIsPDAcroFormPartialNameIsWidget() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testSetDefaultValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
            .setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#getValueAsString()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testGetValueAsString_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertEquals("Off", (new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).getValueAsString());
  }

  /**
   * Test {@link PDButton#getValueAsString()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code Off}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'Off'")
  void testGetValueAsString_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnOff() {
    // Arrange, Act and Assert
    assertEquals("Off", (new PDCheckBox(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Test {@link PDButton#getValueAsString()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetValueAsString_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("Off",
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getValueAsString());
  }

  /**
   * Test {@link PDButton#getExportValues()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getExportValues()}
   */
  @Test
  @DisplayName("Test getExportValues(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testGetExportValues_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertTrue((new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).getExportValues().isEmpty());
  }

  /**
   * Test {@link PDButton#getExportValues()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getExportValues()}
   */
  @Test
  @DisplayName("Test getExportValues(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return Empty")
  void testGetExportValues_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDCheckBox(new PDAcroForm(new PDDocument()))).getExportValues().isEmpty());
  }

  /**
   * Test {@link PDButton#getExportValues()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getExportValues()}
   */
  @Test
  @DisplayName("Test getExportValues(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetExportValues_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertTrue(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getExportValues()
            .isEmpty());
  }

  /**
   * Test {@link PDButton#setExportValues(List)}.
   * <p>
   * Method under test: {@link PDButton#setExportValues(List)}
   */
  @Test
  @DisplayName("Test setExportValues(List)")
  void testSetExportValues() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.setExportValues(new ArrayList<>());

    // Assert
    Set<String> onValues = pdCheckBox.getOnValues();
    assertEquals(1, onValues.size());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    List<String> exportValues = pdCheckBox.getExportValues();
    assertTrue(exportValues.isEmpty());
    assertTrue(onValues.contains(""));
    assertSame(exportValues, pdCheckBox.getAcroForm().getCalcOrder());
  }

  /**
   * Test {@link PDButton#constructAppearances()}.
   * <p>
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Annotation has type {}, further mayhem may follow"));
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
            .constructAppearances());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(field).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDButton#constructAppearances()}.
   * <p>
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any()))
        .thenThrow(new NumberFormatException("Annotation has type {}, further mayhem may follow"));
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(cosDictionary3).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary3);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
            .constructAppearances());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(field).getCOSName(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDButton#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray getObject(int) return COSDictionary()")
  void testConstructAppearances_givenCOSArrayGetObjectReturnCOSDictionary() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDButton#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  void testConstructAppearances_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert that nothing has changed
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDButton#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} return
   * {@code true}.</li>
   *   <li>Then calls {@link COSArray#isEmpty()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray isEmpty() return 'true'; then calls isEmpty()")
  void testConstructAppearances_givenCOSArrayIsEmptyReturnTrue_thenCallsIsEmpty() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert that nothing has changed
    verify(cosArray).isEmpty();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDButton#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSArray(COSName) return COSArray()")
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnCOSArray() throws IOException {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert that nothing has changed
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDButton#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return COSStream()")
  void testConstructAppearances_givenCOSDictionaryGetCOSDictionaryReturnCOSStream() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSStream());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
  }

  /**
   * Test {@link PDButton#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)}
   * return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSName(COSName) return A")
  void testConstructAppearances_givenCOSDictionaryGetCOSNameReturnA() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
  }

  /**
   * Test {@link PDButton#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getDictionaryObject(COSName) return COSStream()")
  void testConstructAppearances_givenCOSDictionaryGetDictionaryObjectReturnCOSStream() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSStream());
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
  }

  /**
   * Test {@link PDButton#constructAppearances()}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#containsKey(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls containsKey(COSName)")
  void testConstructAppearances_thenCallsContainsKey() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(cosDictionary3).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary3);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(field, atLeast(1)).getCOSName(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
  }

  /**
   * Test {@link PDButton#getOnValues()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getOnValues()}
   */
  @Test
  @DisplayName("Test getOnValues(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testGetOnValues_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act
    Set<String> actualOnValues = (new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).getOnValues();

    // Assert
    assertEquals(1, actualOnValues.size());
    assertTrue(actualOnValues.contains(""));
  }

  /**
   * Test {@link PDButton#getOnValues()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} importFDF
   * {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getOnValues()}
   */
  @Test
  @DisplayName("Test getOnValues(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  void testGetOnValues_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.importFDF(new FDFField());

    // Act
    Set<String> actualOnValues = pdCheckBox.getOnValues();

    // Assert
    assertEquals(1, actualOnValues.size());
    assertTrue(actualOnValues.contains(""));
  }

  /**
   * Test {@link PDButton#getOnValues()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getOnValues()}
   */
  @Test
  @DisplayName("Test getOnValues(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return size is one")
  void testGetOnValues_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<String> actualOnValues = (new PDCheckBox(new PDAcroForm(new PDDocument()))).getOnValues();

    // Assert
    assertEquals(1, actualOnValues.size());
    assertTrue(actualOnValues.contains(""));
  }

  /**
   * Test {@link PDButton#getOnValues()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#getOnValues()}
   */
  @Test
  @DisplayName("Test getOnValues(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetOnValues_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act
    Set<String> actualOnValues = (new PDCheckBox(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getOnValues();

    // Assert
    assertEquals(1, actualOnValues.size());
    assertTrue(actualOnValues.contains(""));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   * <p>
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName("Test checkValue(String)")
  void testCheckValue() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Widget");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, new COSDictionary(), parent)).checkValue("42"));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   * <p>
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName("Test checkValue(String)")
  void testCheckValue2() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Widget");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.checkValue("42"));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName("Test checkValue(String); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testCheckValue_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).checkValue("42"));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName("Test checkValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testCheckValue_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(new PDDocument()))).checkValue("42"));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} importFDF
   * {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName("Test checkValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  void testCheckValue_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.importFDF(new FDFField());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.checkValue("42"));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} PartialName is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName("Test checkValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is empty string")
  void testCheckValue_givenPDCheckBoxWithAcroFormIsPDAcroFormPartialNameIsEmptyString() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.checkValue("42"));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} PartialName is {@code Widget}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName("Test checkValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is 'Widget'")
  void testCheckValue_givenPDCheckBoxWithAcroFormIsPDAcroFormPartialNameIsWidget() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.checkValue("42"));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName("Test checkValue(String); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testCheckValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
            .checkValue("42"));
  }
}
