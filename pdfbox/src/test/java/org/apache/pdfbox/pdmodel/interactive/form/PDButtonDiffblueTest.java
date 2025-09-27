package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDButtonDiffblueTest {
  /**
   * Test {@link PDButton#isPushButton()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#isPushButton()}
   */
  @Test
  @DisplayName(
      "Test isPushButton(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDButton.isPushButton()"})
  void testIsPushButton_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act and Assert
    assertFalse(pdCheckBox.isPushButton());
  }

  /**
   * Test {@link PDButton#isPushButton()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#isPushButton()}
   */
  @Test
  @DisplayName(
      "Test isPushButton(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDButton.isPushButton()"})
  void testIsPushButton_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDCheckBox(new PDAcroForm(new PDDocument())).isPushButton());
  }

  /**
   * Test {@link PDButton#isPushButton()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#isPushButton()}
   */
  @Test
  @DisplayName("Test isPushButton(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDButton.isPushButton()"})
  void testIsPushButton_thenReturnTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setFieldFlags(65536);

    // Act and Assert
    assertTrue(pdCheckBox.isPushButton());
  }

  /**
   * Test {@link PDButton#isRadioButton()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#isRadioButton()}
   */
  @Test
  @DisplayName(
      "Test isRadioButton(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDButton.isRadioButton()"})
  void testIsRadioButton_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act and Assert
    assertFalse(pdCheckBox.isRadioButton());
  }

  /**
   * Test {@link PDButton#isRadioButton()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#isRadioButton()}
   */
  @Test
  @DisplayName(
      "Test isRadioButton(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDButton.isRadioButton()"})
  void testIsRadioButton_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDCheckBox(new PDAcroForm(new PDDocument())).isRadioButton());
  }

  /**
   * Test {@link PDButton#isRadioButton()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#isRadioButton()}
   */
  @Test
  @DisplayName("Test isRadioButton(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDButton.isRadioButton()"})
  void testIsRadioButton_thenReturnTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setFieldFlags(32768);

    // Act and Assert
    assertTrue(pdCheckBox.isRadioButton());
  }

  /**
   * Test {@link PDButton#getValue()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code Off}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'Off'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDButton.getValue()"})
  void testGetValue_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnOff() {
    // Arrange, Act and Assert
    assertEquals("Off", new PDCheckBox(new PDAcroForm(new PDDocument())).getValue());
  }

  /**
   * Test {@link PDButton#getValue()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code Off}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'Off'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDButton.getValue()"})
  void testGetValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnOff() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertEquals("Off", pdCheckBox.getValue());
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   *
   * <p>Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName("Test setValue(int) with 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(int)"})
  void testSetValueWithIndex() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   *
   * <p>Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName("Test setValue(int) with 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(int)"})
  void testSetValueWithIndex2() throws IOException {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   *
   * <p>Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName("Test setValue(int) with 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(int)"})
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
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName(
      "Test setValue(int) with 'index'; given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(int)"})
  void testSetValueWithIndex_givenPDCheckBoxWithAcroFormIsPDAcroForm() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDCheckBox(new PDAcroForm(new PDDocument())).setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} PartialName is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName(
      "Test setValue(int) with 'index'; given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(int)"})
  void testSetValueWithIndex_givenPDCheckBoxWithAcroFormIsPDAcroFormPartialNameIsName()
      throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  @DisplayName(
      "Test setValue(int) with 'index'; given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(int)"})
  void testSetValueWithIndex_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue(1));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   *
   * <p>Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(String)"})
  void testSetValueWithValue() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   *
   * <p>Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(String)"})
  void testSetValueWithValue2() throws IOException {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Widget");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   *
   * <p>Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(String)"})
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
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String) with 'value'; given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(String)"})
  void testSetValueWithValue_givenPDCheckBoxWithAcroFormIsPDAcroForm() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDCheckBox(new PDAcroForm(new PDDocument())).setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} importFDF {@link FDFField#FDFField()}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String) with 'value'; given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(String)"})
  void testSetValueWithValue_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField()
      throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.importFDF(new FDFField());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} PartialName is {@code Widget}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String) with 'value'; given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is 'Widget'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(String)"})
  void testSetValueWithValue_givenPDCheckBoxWithAcroFormIsPDAcroFormPartialNameIsWidget()
      throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String) with 'value'; given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(String)"})
  void testSetValueWithValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue("42"));
  }

  /**
   * Test {@link PDButton#setValue(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} Value is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  @DisplayName(
      "Test setValue(String) with 'value'; then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setValue(String)"})
  void testSetValueWithValue_thenPDCheckBoxWithAcroFormIsPDAcroFormValueIsEmptyString()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#getDefaultValue()}
   */
  @Test
  @DisplayName(
      "Test getDefaultValue(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDButton.getDefaultValue()"})
  void testGetDefaultValue_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", new PDCheckBox(new PDAcroForm(new PDDocument())).getDefaultValue());
  }

  /**
   * Test {@link PDButton#getDefaultValue()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDButton.getDefaultValue()"})
  void testGetDefaultValue_thenReturnEmptyString() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertEquals("", pdCheckBox.getDefaultValue());
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   *
   * <p>Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setDefaultValue(String)"})
  void testSetDefaultValue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   *
   * <p>Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setDefaultValue(String)"})
  void testSetDefaultValue2() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Widget");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   *
   * <p>Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setDefaultValue(String)"})
  void testSetDefaultValue3() {
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
   *
   * <p>Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName("Test setDefaultValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setDefaultValue(String)"})
  void testSetDefaultValue4() {
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
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setDefaultValue(String)"})
  void testSetDefaultValue_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDCheckBox(new PDAcroForm(new PDDocument())).setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} importFDF {@link FDFField#FDFField()}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setDefaultValue(String)"})
  void testSetDefaultValue_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField()
      throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.importFDF(new FDFField());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} PartialName is {@code Widget}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is 'Widget'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setDefaultValue(String)"})
  void testSetDefaultValue_givenPDCheckBoxWithAcroFormIsPDAcroFormPartialNameIsWidget() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#setDefaultValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultValue(String); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.setDefaultValue(String)"})
  void testSetDefaultValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setDefaultValue("42"));
  }

  /**
   * Test {@link PDButton#getValueAsString()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code Off}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#getValueAsString()}
   */
  @Test
  @DisplayName(
      "Test getValueAsString(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'Off'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDButton.getValueAsString()"})
  void testGetValueAsString_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnOff() {
    // Arrange, Act and Assert
    assertEquals("Off", new PDCheckBox(new PDAcroForm(new PDDocument())).getValueAsString());
  }

  /**
   * Test {@link PDButton#getValueAsString()}.
   *
   * <ul>
   *   <li>Then return {@code Off}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); then return 'Off'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDButton.getValueAsString()"})
  void testGetValueAsString_thenReturnOff() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertEquals("Off", pdCheckBox.getValueAsString());
  }

  /**
   * Test {@link PDButton#getExportValues()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#getExportValues()}
   */
  @Test
  @DisplayName(
      "Test getExportValues(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PDButton.getExportValues()"})
  void testGetExportValues_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDCheckBox(new PDAcroForm(new PDDocument())).getExportValues().isEmpty());
  }

  /**
   * Test {@link PDButton#getExportValues()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#getExportValues()}
   */
  @Test
  @DisplayName("Test getExportValues(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PDButton.getExportValues()"})
  void testGetExportValues_thenReturnEmpty() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertTrue(pdCheckBox.getExportValues().isEmpty());
  }

  /**
   * Test {@link PDButton#getOnValues()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} importFDF {@link FDFField#FDFField()}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#getOnValues()}
   */
  @Test
  @DisplayName(
      "Test getOnValues(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PDButton.getOnValues()"})
  void testGetOnValues_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#getOnValues()}
   */
  @Test
  @DisplayName(
      "Test getOnValues(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PDButton.getOnValues()"})
  void testGetOnValues_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<String> actualOnValues = new PDCheckBox(new PDAcroForm(new PDDocument())).getOnValues();

    // Assert
    assertEquals(1, actualOnValues.size());
    assertTrue(actualOnValues.contains(""));
  }

  /**
   * Test {@link PDButton#getOnValues()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#getOnValues()}
   */
  @Test
  @DisplayName(
      "Test getOnValues(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PDButton.getOnValues()"})
  void testGetOnValues_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    Set<String> actualOnValues = pdCheckBox.getOnValues();

    // Assert
    assertEquals(1, actualOnValues.size());
    assertTrue(actualOnValues.contains(""));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName(
      "Test checkValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.checkValue(String)"})
  void testCheckValue_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDCheckBox(new PDAcroForm(new PDDocument())).checkValue("42"));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} importFDF {@link FDFField#FDFField()}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName(
      "Test checkValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.checkValue(String)"})
  void testCheckValue_givenPDCheckBoxWithAcroFormIsPDAcroFormImportFDFFDFField()
      throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.importFDF(new FDFField());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.checkValue("42"));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} PartialName is {@code Widget}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName(
      "Test checkValue(String); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is 'Widget'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.checkValue(String)"})
  void testCheckValue_givenPDCheckBoxWithAcroFormIsPDAcroFormPartialNameIsWidget() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.checkValue("42"));
  }

  /**
   * Test {@link PDButton#checkValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  @DisplayName(
      "Test checkValue(String); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDButton.checkValue(String)"})
  void testCheckValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.checkValue("42"));
  }
}
