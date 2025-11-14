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
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
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
   * Test {@link PDField#fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#fromDictionary(PDAcroForm, COSDictionary,
   * PDNonTerminalField)}
   */
  @Test
  @DisplayName(
      "Test fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField); when COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDField PDField.fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField)"
  })
  void testFromDictionary_whenCOSStream_thenReturnNull() {
    // Arrange
    PDAcroForm form = new PDAcroForm(new PDDocument());
    COSStream field = new COSStream();

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
   * <p>Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  @DisplayName("Test getInheritableAttribute(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSBase PDField.getInheritableAttribute(COSName)"})
  void testGetInheritableAttribute() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertNull(new PDCheckBox(acroForm).getInheritableAttribute(COSName.A));
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
   * <p>Method under test: {@link PDField#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDField.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
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
   * <p>Method under test: {@link PDField#isRequired()}
   */
  @Test
  @DisplayName("Test isRequired()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDField.isRequired()"})
  void testIsRequired() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
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
   * <p>Method under test: {@link PDField#isNoExport()}
   */
  @Test
  @DisplayName("Test isNoExport()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDField.isNoExport()"})
  void testIsNoExport() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
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
   * Test {@link PDField#getActions()}.
   *
   * <p>Method under test: {@link PDField#getActions()}
   */
  @Test
  @DisplayName("Test getActions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions PDField.getActions()"
  })
  void testGetActions() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertNull(pdCheckBox.getActions());
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
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject cosObject = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    fdfField.setValue((Object) cosObject);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert that nothing has changed
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdCheckBox.isReadOnly());
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
   *       PDAcroForm#PDAcroForm(PDDocument)} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_thenPDCheckBoxWithAcroFormIsPDAcroFormCOSObjectValuesSizeIsThree()
      throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} Value is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_thenPDCheckBoxWithAcroFormIsPDAcroFormValueIsEmptyString() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm acroForm = new PDAcroForm(doc);
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm);

    FDFField fdfField = new FDFField();
    fdfField.setValue("");

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
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
   *   <li>When {@link FDFField#FDFField()} ClearFieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() ClearFieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_whenFDFFieldClearFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setClearFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(pdCheckBox.isReadOnly());
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
   * Test {@link PDField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>When {@link FDFField#FDFField()} SetFieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() SetFieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDField.importFDF(FDFField)"})
  void testImportFDF_whenFDFFieldSetFieldFlagsIsOne() throws IOException {
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
   * <p>Method under test: {@link PDField#findKid(String[], int)}
   */
  @Test
  @DisplayName("Test findKid(String[], int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDField PDField.findKid(String[], int)"})
  void testFindKid() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertNull(pdCheckBox.findKid(new String[] {"Name"}, 1));
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
   * <p>Method under test: {@link PDField#getPartialName()}
   */
  @Test
  @DisplayName("Test getPartialName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getPartialName()"})
  void testGetPartialName() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertNull(pdCheckBox.getPartialName());
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
  void testGetPartialName_thenReturnEmptyString() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm acroForm = new PDAcroForm(doc);

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm);
    pdCheckBox.setPartialName("");

    // Act
    String actualPartialName = pdCheckBox.getPartialName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualPartialName);
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
  void testGetFullyQualifiedName_thenReturnEmptyString() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm acroForm = new PDAcroForm(doc);

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm);
    pdCheckBox.setPartialName("");

    // Act
    String actualFullyQualifiedName = pdCheckBox.getFullyQualifiedName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualFullyQualifiedName);
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
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name", pdCheckBox.getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getAlternateFieldName()}.
   *
   * <p>Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  @DisplayName("Test getAlternateFieldName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getAlternateFieldName()"})
  void testGetAlternateFieldName() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertNull(pdCheckBox.getAlternateFieldName());
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
   * Test {@link PDField#getMappingName()}.
   *
   * <p>Method under test: {@link PDField#getMappingName()}
   */
  @Test
  @DisplayName("Test getMappingName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.getMappingName()"})
  void testGetMappingName() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Act and Assert
    assertNull(pdCheckBox.getMappingName());
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
   * Test {@link PDField#toString()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.toString()"})
  void testToString_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertEquals("null{type: PDCheckBox value: null}", new PDCheckBox(acroForm).toString());
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
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDField.toString()"})
  void testToString_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
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
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name{type: PDCheckBox value: null}", pdCheckBox.toString());
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
  void testToString_thenReturnTypePDCheckBoxValueNull() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    PDAcroForm acroForm = new PDAcroForm(doc);

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm);
    pdCheckBox.setPartialName("");

    // Act
    String actualToStringResult = pdCheckBox.toString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("{type: PDCheckBox value: null}", actualToStringResult);
  }
}
