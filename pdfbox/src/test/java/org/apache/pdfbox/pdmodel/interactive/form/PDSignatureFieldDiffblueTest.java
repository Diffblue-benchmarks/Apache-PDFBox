package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSeedValue;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDSignatureFieldDiffblueTest {
  /**
   * Test {@link PDSignatureField#PDSignatureField(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   *
   * <p>Method under test: {@link PDSignatureField#PDSignatureField(PDAcroForm, COSDictionary,
   * PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDSignatureField(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.<init>(PDAcroForm, COSDictionary, PDNonTerminalField)"})
  void testNewPDSignatureField() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDSignatureField actualPdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdSignatureField.getCOSObject());
    assertSame(acroForm, actualPdSignatureField.getAcroForm());
    assertSame(parent, actualPdSignatureField.getParent());
  }

  /**
   * Test {@link PDSignatureField#PDSignatureField(PDAcroForm)}.
   *
   * <p>Method under test: {@link PDSignatureField#PDSignatureField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDSignatureField(PDAcroForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.<init>(PDAcroForm)"})
  void testNewPDSignatureField2() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act
    PDSignatureField actualPdSignatureField = new PDSignatureField(acroForm);

    // Assert
    List<PDAnnotationWidget> widgets = actualPdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(3, widgets.get(0).getBorder().toList().size());
    assertSame(acroForm, actualPdSignatureField.getAcroForm());
  }

  /**
   * Test {@link PDSignatureField#PDSignatureField(PDAcroForm)}.
   *
   * <ul>
   *   <li>Then return AcroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignatureField#PDSignatureField(PDAcroForm)}
   */
  @Test
  @DisplayName(
      "Test new PDSignatureField(PDAcroForm); then return AcroForm is PDAcroForm(PDDocument) with doc is PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.<init>(PDAcroForm)"})
  void testNewPDSignatureField_thenReturnAcroFormIsPDAcroFormWithDocIsPDDocument() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDSignatureField actualPdSignatureField = new PDSignatureField(acroForm);

    // Assert
    List<PDAnnotationWidget> widgets = actualPdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(3, widgets.get(0).getBorder().toList().size());
    assertSame(acroForm, actualPdSignatureField.getAcroForm());
  }

  /**
   * Test {@link PDSignatureField#getSignature()}.
   *
   * <p>Method under test: {@link PDSignatureField#getSignature()}
   */
  @Test
  @DisplayName("Test getSignature()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature PDSignatureField.getSignature()"})
  void testGetSignature() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDSignatureField pdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Act and Assert
    assertNull(pdSignatureField.getSignature());
  }

  /**
   * Test {@link PDSignatureField#getSignature()}.
   *
   * <ul>
   *   <li>Given {@link PDSignatureField#PDSignatureField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignatureField#getSignature()}
   */
  @Test
  @DisplayName(
      "Test getSignature(); given PDSignatureField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature PDSignatureField.getSignature()"})
  void testGetSignature_givenPDSignatureFieldWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignatureField(new PDAcroForm(new PDDocument())).getSignature());
  }

  /**
   * Test {@link PDSignatureField#setValue(PDSignature)} with {@code PDSignature}.
   *
   * <p>Method under test: {@link PDSignatureField#setValue(PDSignature)}
   */
  @Test
  @DisplayName("Test setValue(PDSignature) with 'PDSignature'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.setValue(PDSignature)"})
  void testSetValueWithPDSignature() throws IOException {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setValue(new PDSignature());

    // Assert
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[] {}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[] {}, value.getContents());
    assertArrayEquals(new int[] {}, signature.getByteRange());
    assertArrayEquals(new int[] {}, value.getByteRange());
  }

  /**
   * Test {@link PDSignatureField#setValue(PDSignature)} with {@code PDSignature}.
   *
   * <p>Method under test: {@link PDSignatureField#setValue(PDSignature)}
   */
  @Test
  @DisplayName("Test setValue(PDSignature) with 'PDSignature'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.setValue(PDSignature)"})
  void testSetValueWithPDSignature2() throws IOException {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setValue((PDSignature) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDSignatureField#setValue(PDSignature)} with {@code PDSignature}.
   *
   * <p>Method under test: {@link PDSignatureField#setValue(PDSignature)}
   */
  @Test
  @DisplayName("Test setValue(PDSignature) with 'PDSignature'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.setValue(PDSignature)"})
  void testSetValueWithPDSignature3() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDSignatureField pdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Act
    pdSignatureField.setValue(new PDSignature());

    // Assert
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[] {}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[] {}, value.getContents());
    assertArrayEquals(new int[] {}, signature.getByteRange());
    assertArrayEquals(new int[] {}, value.getByteRange());
  }

  /**
   * Test {@link PDSignatureField#setValue(PDSignature)} with {@code PDSignature}.
   *
   * <p>Method under test: {@link PDSignatureField#setValue(PDSignature)}
   */
  @Test
  @DisplayName("Test setValue(PDSignature) with 'PDSignature'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.setValue(PDSignature)"})
  void testSetValueWithPDSignature4() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDSignatureField pdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Act
    pdSignatureField.setValue((PDSignature) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSignatureField#setValue(String)} with {@code String}.
   *
   * <p>Method under test: {@link PDSignatureField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.setValue(String)"})
  void testSetValueWithString() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDSignatureField(new PDAcroForm(new PDDocument())).setValue("42"));
  }

  /**
   * Test {@link PDSignatureField#setDefaultValue(PDSignature)}.
   *
   * <p>Method under test: {@link PDSignatureField#setDefaultValue(PDSignature)}
   */
  @Test
  @DisplayName("Test setDefaultValue(PDSignature)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.setDefaultValue(PDSignature)"})
  void testSetDefaultValue() {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setDefaultValue(new PDSignature());

    // Assert
    PDSignature defaultValue = pdSignatureField.getDefaultValue();
    assertNull(defaultValue.getContactInfo());
    assertNull(defaultValue.getFilter());
    assertNull(defaultValue.getLocation());
    assertNull(defaultValue.getName());
    assertNull(defaultValue.getReason());
    assertNull(defaultValue.getSubFilter());
    assertNull(defaultValue.getSignDate());
    assertNull(defaultValue.getPropBuild());
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new byte[] {}, defaultValue.getContents());
    assertArrayEquals(new int[] {}, defaultValue.getByteRange());
  }

  /**
   * Test {@link PDSignatureField#setDefaultValue(PDSignature)}.
   *
   * <p>Method under test: {@link PDSignatureField#setDefaultValue(PDSignature)}
   */
  @Test
  @DisplayName("Test setDefaultValue(PDSignature)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.setDefaultValue(PDSignature)"})
  void testSetDefaultValue2() {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setDefaultValue(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDSignatureField#getValue()}.
   *
   * <p>Method under test: {@link PDSignatureField#getValue()}
   */
  @Test
  @DisplayName("Test getValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature PDSignatureField.getValue()"})
  void testGetValue() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDSignatureField pdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Act and Assert
    assertNull(pdSignatureField.getValue());
  }

  /**
   * Test {@link PDSignatureField#getValue()}.
   *
   * <ul>
   *   <li>Given {@link PDSignatureField#PDSignatureField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignatureField#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given PDSignatureField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature PDSignatureField.getValue()"})
  void testGetValue_givenPDSignatureFieldWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignatureField(new PDAcroForm(new PDDocument())).getValue());
  }

  /**
   * Test {@link PDSignatureField#getDefaultValue()}.
   *
   * <p>Method under test: {@link PDSignatureField#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature PDSignatureField.getDefaultValue()"})
  void testGetDefaultValue() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDSignatureField pdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Act and Assert
    assertNull(pdSignatureField.getDefaultValue());
  }

  /**
   * Test {@link PDSignatureField#getDefaultValue()}.
   *
   * <ul>
   *   <li>Given {@link PDSignatureField#PDSignatureField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignatureField#getDefaultValue()}
   */
  @Test
  @DisplayName(
      "Test getDefaultValue(); given PDSignatureField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature PDSignatureField.getDefaultValue()"})
  void testGetDefaultValue_givenPDSignatureFieldWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignatureField(new PDAcroForm(new PDDocument())).getDefaultValue());
  }

  /**
   * Test {@link PDSignatureField#getValueAsString()}.
   *
   * <p>Method under test: {@link PDSignatureField#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignatureField.getValueAsString()"})
  void testGetValueAsString() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDSignatureField pdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Act and Assert
    assertEquals("", pdSignatureField.getValueAsString());
  }

  /**
   * Test {@link PDSignatureField#getValueAsString()}.
   *
   * <ul>
   *   <li>Given {@link PDSignatureField#PDSignatureField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignatureField#getValueAsString()}
   */
  @Test
  @DisplayName(
      "Test getValueAsString(); given PDSignatureField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignatureField.getValueAsString()"})
  void testGetValueAsString_givenPDSignatureFieldWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", new PDSignatureField(new PDAcroForm(new PDDocument())).getValueAsString());
  }

  /**
   * Test {@link PDSignatureField#getSeedValue()}.
   *
   * <p>Method under test: {@link PDSignatureField#getSeedValue()}
   */
  @Test
  @DisplayName("Test getSeedValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSeedValue PDSignatureField.getSeedValue()"})
  void testGetSeedValue() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDSignatureField pdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Act and Assert
    assertNull(pdSignatureField.getSeedValue());
  }

  /**
   * Test {@link PDSignatureField#getSeedValue()}.
   *
   * <ul>
   *   <li>Given {@link PDSignatureField#PDSignatureField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignatureField#getSeedValue()}
   */
  @Test
  @DisplayName(
      "Test getSeedValue(); given PDSignatureField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSeedValue PDSignatureField.getSeedValue()"})
  void testGetSeedValue_givenPDSignatureFieldWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignatureField(new PDAcroForm(new PDDocument())).getSeedValue());
  }

  /**
   * Test {@link PDSignatureField#setSeedValue(PDSeedValue)}.
   *
   * <p>Method under test: {@link PDSignatureField#setSeedValue(PDSeedValue)}
   */
  @Test
  @DisplayName("Test setSeedValue(PDSeedValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.setSeedValue(PDSeedValue)"})
  void testSetSeedValue() {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setSeedValue(new PDSeedValue());

    // Assert
    PDSeedValue seedValue = pdSignatureField.getSeedValue();
    assertNull(seedValue.getFilter());
    assertNull(seedValue.getSeedValueCertificate());
    assertNull(seedValue.getMDP());
    assertNull(seedValue.getTimeStamp());
    assertEquals(-1.0f, seedValue.getV());
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertFalse(seedValue.isAddRevInfoRequired());
    assertFalse(seedValue.isDigestMethodRequired());
    assertFalse(seedValue.isFilterRequired());
    assertFalse(seedValue.isLegalAttestationRequired());
    assertFalse(seedValue.isReasonRequired());
    assertFalse(seedValue.isSubFilterRequired());
    assertFalse(seedValue.isVRequired());
  }

  /**
   * Test {@link PDSignatureField#setSeedValue(PDSeedValue)}.
   *
   * <p>Method under test: {@link PDSignatureField#setSeedValue(PDSeedValue)}
   */
  @Test
  @DisplayName("Test setSeedValue(PDSeedValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.setSeedValue(PDSeedValue)"})
  void testSetSeedValue2() {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setSeedValue(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   *
   * <p>Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDSignatureField pdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Act and Assert
    assertDoesNotThrow(() -> pdSignatureField.constructAppearances());
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDSignatureField#PDSignatureField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given PDSignatureField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_givenPDSignatureFieldWithAcroFormIsPDAcroForm() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new PDSignatureField(new PDAcroForm(new PDDocument())).constructAppearances());
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenThrow(new UnsupportedOperationException());

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDSignatureField pdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> pdSignatureField.constructAppearances());
    verify(cosArray).isEmpty();
    verify(field).getCOSArray(isA(COSName.class));
  }
}
