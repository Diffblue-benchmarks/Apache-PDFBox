package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFieldDiffblueTest {
  /**
   * Test {@link PDField#fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#fromDictionary(PDAcroForm, COSDictionary,
   * PDNonTerminalField)}
   */
  @Test
  @DisplayName(
      "Test fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField); when COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDField PDField.fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField)"
  })
  void testFromDictionary_whenCOSDictionary_thenReturnNull() {
    // Arrange
    PDAcroForm form = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act
    PDField actualFromDictionaryResult =
        PDField.fromDictionary(
            form, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Assert
    assertNull(actualFromDictionaryResult);
  }

  /**
   * Test {@link PDField#getInheritableAttribute(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  @DisplayName(
      "Test getInheritableAttribute(COSName); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSBase PDField.getInheritableAttribute(COSName)"})
  void testGetInheritableAttribute_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertNull(new PDCheckBox(new PDAcroForm(new PDDocument())).getInheritableAttribute(COSName.A));
  }

  /**
   * Test {@link PDField#getInheritableAttribute(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  @DisplayName(
      "Test getInheritableAttribute(COSName); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSBase PDField.getInheritableAttribute(COSName)"})
  void testGetInheritableAttribute_givenPDCheckBoxWithAcroFormIsPDAcroForm_whenNull() {
    // Arrange, Act and Assert
    assertNull(new PDCheckBox(new PDAcroForm(new PDDocument())).getInheritableAttribute(null));
  }

  /**
   * Test {@link PDField#getInheritableAttribute(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  @DisplayName(
      "Test getInheritableAttribute(COSName); given PDDocument() addPage PDPage(); when A; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSBase PDField.getInheritableAttribute(COSName)"})
  void testGetInheritableAttribute_givenPDDocumentAddPagePDPage_whenA_thenReturnNull()
      throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());
    PDSignature sigObject = new PDSignature();
    SignatureInterface signatureInterface = mock(SignatureInterface.class);

    doc.addSignature(sigObject, signatureInterface, new SignatureOptions());

    // Act and Assert
    assertNull(new PDCheckBox(new PDAcroForm(doc)).getInheritableAttribute(COSName.A));
  }

  /**
   * Test {@link PDField#getInheritableAttribute(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  @DisplayName(
      "Test getInheritableAttribute(COSName); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSBase PDField.getInheritableAttribute(COSName)"})
  void testGetInheritableAttribute_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertNull(pdCheckBox.getInheritableAttribute(COSName.A));
  }

  /**
   * Test {@link PDField#setReadOnly(boolean)}.
   *
   * <p>Method under test: {@link PDField#setReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test setReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.setReadOnly(boolean)"})
  void testSetReadOnly() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.setReadOnly(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(1), eq(true));
    assertEquals(0, pdCheckBox.getFieldFlags());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#isReadOnly()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#isReadOnly()}
   */
  @Test
  @DisplayName(
      "Test isReadOnly(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDField.isReadOnly()"})
  void testIsReadOnly_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDCheckBox(new PDAcroForm(new PDDocument())).isReadOnly());
  }

  /**
   * Test {@link PDField#isReadOnly()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDField.isReadOnly()"})
  void testIsReadOnly_thenReturnTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act and Assert
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#setRequired(boolean)}.
   *
   * <p>Method under test: {@link PDField#setRequired(boolean)}
   */
  @Test
  @DisplayName("Test setRequired(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.setRequired(boolean)"})
  void testSetRequired() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.setRequired(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(2), eq(true));
    assertEquals(0, pdCheckBox.getFieldFlags());
    assertFalse(pdCheckBox.isRequired());
  }

  /**
   * Test {@link PDField#isRequired()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#isRequired()}
   */
  @Test
  @DisplayName(
      "Test isRequired(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDField.isRequired()"})
  void testIsRequired_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act and Assert
    assertFalse(pdCheckBox.isRequired());
  }

  /**
   * Test {@link PDField#isRequired()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#isRequired()}
   */
  @Test
  @DisplayName(
      "Test isRequired(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDField.isRequired()"})
  void testIsRequired_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDCheckBox(new PDAcroForm(new PDDocument())).isRequired());
  }

  /**
   * Test {@link PDField#isRequired()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#isRequired()}
   */
  @Test
  @DisplayName("Test isRequired(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDField.isRequired()"})
  void testIsRequired_thenReturnTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setRequired(true);

    // Act and Assert
    assertTrue(pdCheckBox.isRequired());
  }

  /**
   * Test {@link PDField#setNoExport(boolean)}.
   *
   * <p>Method under test: {@link PDField#setNoExport(boolean)}
   */
  @Test
  @DisplayName("Test setNoExport(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.setNoExport(boolean)"})
  void testSetNoExport() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.setNoExport(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(4), eq(true));
    assertEquals(0, pdCheckBox.getFieldFlags());
    assertFalse(pdCheckBox.isNoExport());
  }

  /**
   * Test {@link PDField#isNoExport()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#isNoExport()}
   */
  @Test
  @DisplayName(
      "Test isNoExport(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDField.isNoExport()"})
  void testIsNoExport_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act and Assert
    assertFalse(pdCheckBox.isNoExport());
  }

  /**
   * Test {@link PDField#isNoExport()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#isNoExport()}
   */
  @Test
  @DisplayName(
      "Test isNoExport(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDField.isNoExport()"})
  void testIsNoExport_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDCheckBox(new PDAcroForm(new PDDocument())).isNoExport());
  }

  /**
   * Test {@link PDField#isNoExport()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#isNoExport()}
   */
  @Test
  @DisplayName("Test isNoExport(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDField.isNoExport()"})
  void testIsNoExport_thenReturnTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setNoExport(true);

    // Act and Assert
    assertTrue(pdCheckBox.isNoExport());
  }

  /**
   * Test {@link PDField#setFieldFlags(int)}.
   *
   * <p>Method under test: {@link PDField#setFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setFieldFlags(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.setFieldFlags(int)"})
  void testSetFieldFlags() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setInt(Mockito.<COSName>any(), anyInt());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.setFieldFlags(1);

    // Assert that nothing has changed
    verify(field).setInt(isA(COSName.class), eq(1));
    assertEquals(0, pdCheckBox.getFieldFlags());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#getActions()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getActions()}
   */
  @Test
  @DisplayName(
      "Test getActions(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions PDField.getActions()"
  })
  void testGetActions_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDCheckBox(new PDAcroForm(new PDDocument())).getActions());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link FDFField#FDFField()} Value is {@link COSArray#COSArray()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); given COSArray(); when FDFField() Value is COSArray(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_givenCOSArray_whenFDFFieldValueIsCOSArray_thenThrowIOException()
      throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSArray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdCheckBox.importFDF(fdfField));
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link FDFField#FDFField()} Value is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given COSStream(); when FDFField() Value is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_givenCOSStream_whenFDFFieldValueIsCOSStream() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSStream());

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link FDFField#FDFField()} ClearFieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given one; when FDFField() ClearFieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_givenOne_whenFDFFieldClearFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setClearFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   *   <li>When {@link FDFField#FDFField()}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'; when FDFField()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue_whenFDFField()
      throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} FieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) FieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_thenPDCheckBoxWithAcroFormIsPDAcroFormFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setSetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} Widgets size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Widgets size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_thenPDCheckBoxWithAcroFormIsPDAcroFormWidgetsSizeIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setWidgetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(1, getResult.getAnnotationFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(getResult.isInvisible());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>When {@link FDFField#FDFField()}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_whenFDFField() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>When {@link FDFField#FDFField()} FieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() FieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_whenFDFFieldFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#getParent()}.
   *
   * <p>Method under test: {@link PDField#getParent()}
   */
  @Test
  @DisplayName("Test getParent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDNonTerminalField PDField.getParent()"})
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull(new PDCheckBox(new PDAcroForm(new PDDocument())).getParent());
  }

  /**
   * Test {@link PDField#findKid(String[], int)}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#findKid(String[], int)}
   */
  @Test
  @DisplayName(
      "Test findKid(String[], int); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDField PDField.findKid(String[], int)"})
  void testFindKid_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDCheckBox(new PDAcroForm(new PDDocument())).findKid(new String[] {"Name"}, 1));
  }

  /**
   * Test {@link PDField#getAcroForm()}.
   *
   * <p>Method under test: {@link PDField#getAcroForm()}
   */
  @Test
  @DisplayName("Test getAcroForm()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAcroForm PDField.getAcroForm()"})
  void testGetAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertSame(acroForm, new PDCheckBox(acroForm).getAcroForm());
  }

  /**
   * Test {@link PDField#getPartialName()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getPartialName()}
   */
  @Test
  @DisplayName(
      "Test getPartialName(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getPartialName()"})
  void testGetPartialName_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDCheckBox(new PDAcroForm(new PDDocument())).getPartialName());
  }

  /**
   * Test {@link PDField#getPartialName()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument(COSDocument)} with doc is {@link
   *       COSDocument#COSDocument()}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getPartialName()}
   */
  @Test
  @DisplayName(
      "Test getPartialName(); given PDDocument(COSDocument) with doc is COSDocument(); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getPartialName()"})
  void testGetPartialName_givenPDDocumentWithDocIsCOSDocument_thenReturnName() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument(new COSDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm);
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name", pdCheckBox.getPartialName());
  }

  /**
   * Test {@link PDField#getPartialName()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getPartialName()}
   */
  @Test
  @DisplayName("Test getPartialName(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getPartialName()"})
  void testGetPartialName_thenReturnEmptyString() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertEquals("", pdCheckBox.getPartialName());
  }

  /**
   * Test {@link PDField#getPartialName()}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getPartialName()}
   */
  @Test
  @DisplayName("Test getPartialName(); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getPartialName()"})
  void testGetPartialName_thenReturnName() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name", pdCheckBox.getPartialName());
  }

  /**
   * Test {@link PDField#setPartialName(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#setPartialName(String)}
   */
  @Test
  @DisplayName("Test setPartialName(String); when '.'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.setPartialName(String)"})
  void testSetPartialName_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDCheckBox(new PDAcroForm(new PDDocument())).setPartialName("."));
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   *
   * <p>Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getFullyQualifiedName()"})
  void testGetFullyQualifiedName() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertNull(pdCheckBox.getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   *
   * <p>Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getFullyQualifiedName()"})
  void testGetFullyQualifiedName2() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name", pdCheckBox.getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   *
   * <p>Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getFullyQualifiedName()"})
  void testGetFullyQualifiedName3() {
    // Arrange
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(null, field, parent);

    // Act and Assert
    assertNull(pdCheckBox.getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName(
      "Test getFullyQualifiedName(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getFullyQualifiedName()"})
  void testGetFullyQualifiedName_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDCheckBox(new PDAcroForm(new PDDocument())).getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getFullyQualifiedName()"})
  void testGetFullyQualifiedName_thenReturnEmptyString() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertEquals("", pdCheckBox.getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName(); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getFullyQualifiedName()"})
  void testGetFullyQualifiedName_thenReturnName() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);

    // Act and Assert
    assertEquals("Name", pdCheckBox.getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   *
   * <ul>
   *   <li>Then return {@code Name.Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName(); then return 'Name.Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getFullyQualifiedName()"})
  void testGetFullyQualifiedName_thenReturnNameName() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name.Name", pdCheckBox.getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getAlternateFieldName()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  @DisplayName(
      "Test getAlternateFieldName(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getAlternateFieldName()"})
  void testGetAlternateFieldName_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDCheckBox(new PDAcroForm(new PDDocument())).getAlternateFieldName());
  }

  /**
   * Test {@link PDField#getAlternateFieldName()}.
   *
   * <ul>
   *   <li>Then return {@code Alternate Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  @DisplayName("Test getAlternateFieldName(); then return 'Alternate Field Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getAlternateFieldName()"})
  void testGetAlternateFieldName_thenReturnAlternateFieldName() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setAlternateFieldName("Alternate Field Name");

    // Act and Assert
    assertEquals("Alternate Field Name", pdCheckBox.getAlternateFieldName());
  }

  /**
   * Test {@link PDField#getAlternateFieldName()}.
   *
   * <ul>
   *   <li>Then return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  @DisplayName("Test getAlternateFieldName(); then return '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getAlternateFieldName()"})
  void testGetAlternateFieldName_thenReturnDot() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setAlternateFieldName(".");

    // Act and Assert
    assertEquals(".", pdCheckBox.getAlternateFieldName());
  }

  /**
   * Test {@link PDField#setAlternateFieldName(String)}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#setString(COSName, String)}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#setAlternateFieldName(String)}
   */
  @Test
  @DisplayName("Test setAlternateFieldName(String); then calls setString(COSName, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.setAlternateFieldName(String)"})
  void testSetAlternateFieldName_thenCallsSetString() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setString(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.setAlternateFieldName("Alternate Field Name");

    // Assert that nothing has changed
    verify(field).setString(isA(COSName.class), eq("Alternate Field Name"));
  }

  /**
   * Test {@link PDField#getMappingName()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getMappingName()}
   */
  @Test
  @DisplayName(
      "Test getMappingName(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getMappingName()"})
  void testGetMappingName_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDCheckBox(new PDAcroForm(new PDDocument())).getMappingName());
  }

  /**
   * Test {@link PDField#getMappingName()}.
   *
   * <ul>
   *   <li>Then return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getMappingName()}
   */
  @Test
  @DisplayName("Test getMappingName(); then return '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getMappingName()"})
  void testGetMappingName_thenReturnDot() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setMappingName(".");

    // Act and Assert
    assertEquals(".", pdCheckBox.getMappingName());
  }

  /**
   * Test {@link PDField#getMappingName()}.
   *
   * <ul>
   *   <li>Then return {@code Mapping Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#getMappingName()}
   */
  @Test
  @DisplayName("Test getMappingName(); then return 'Mapping Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getMappingName()"})
  void testGetMappingName_thenReturnMappingName() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setMappingName("Mapping Name");

    // Act and Assert
    assertEquals("Mapping Name", pdCheckBox.getMappingName());
  }

  /**
   * Test {@link PDField#setMappingName(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setString(COSName, String)} does
   *       nothing.
   *   <li>Then calls {@link COSDictionary#setString(COSName, String)}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#setMappingName(String)}
   */
  @Test
  @DisplayName(
      "Test setMappingName(String); given COSDictionary setString(COSName, String) does nothing; then calls setString(COSName, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.setMappingName(String)"})
  void testSetMappingName_givenCOSDictionarySetStringDoesNothing_thenCallsSetString() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setString(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act
    pdCheckBox.setMappingName("Mapping Name");

    // Assert that nothing has changed
    verify(field).setString(isA(COSName.class), eq("Mapping Name"));
  }

  /**
   * Test {@link PDField#toString()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.toString()"})
  void testToString_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals(
        "null{type: PDCheckBox value: null}",
        new PDCheckBox(new PDAcroForm(new PDDocument())).toString());
  }

  /**
   * Test {@link PDField#toString()}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} PartialName is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.toString()"})
  void testToString_givenPDCheckBoxWithAcroFormIsPDAcroFormPartialNameIsName() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name{type: PDCheckBox value: null}", pdCheckBox.toString());
  }

  /**
   * Test {@link PDField#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Name.Name{type: PDCheckBox value: null}}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Name.Name{type: PDCheckBox value: null}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.toString()"})
  void testToString_thenReturnNameNameTypePDCheckBoxValueNull() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name.Name{type: PDCheckBox value: null}", pdCheckBox.toString());
  }

  /**
   * Test {@link PDField#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Name{type: PDCheckBox value: null}}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Name{type: PDCheckBox value: null}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.toString()"})
  void testToString_thenReturnNameTypePDCheckBoxValueNull() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);

    // Act and Assert
    assertEquals("Name{type: PDCheckBox value: null}", pdCheckBox.toString());
  }

  /**
   * Test {@link PDField#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null{type: PDCheckBox value: null}}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'null{type: PDCheckBox value: null}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.toString()"})
  void testToString_thenReturnNullTypePDCheckBoxValueNull() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertEquals("null{type: PDCheckBox value: null}", pdCheckBox.toString());
  }

  /**
   * Test {@link PDField#toString()}.
   *
   * <ul>
   *   <li>Then return {@code {type: PDCheckBox value: null}}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '{type: PDCheckBox value: null}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.toString()"})
  void testToString_thenReturnTypePDCheckBoxValueNull() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertEquals("{type: PDCheckBox value: null}", pdCheckBox.toString());
  }
}
