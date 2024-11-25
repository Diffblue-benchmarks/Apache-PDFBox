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
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFieldDiffblueTest {
  /**
   * Test
   * {@link PDField#fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDField#fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField); when COSDictionary(); then return 'null'")
  void testFromDictionary_whenCOSDictionary_thenReturnNull() {
    // Arrange
    PDAcroForm form = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull(PDField.fromDictionary(form, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))));
  }

  /**
   * Test
   * {@link PDField#fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDField#fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField); when COSStream(); then return 'null'")
  void testFromDictionary_whenCOSStream_thenReturnNull() {
    // Arrange
    PDAcroForm form = new PDAcroForm(new PDDocument());
    COSStream field = new COSStream();

    // Act and Assert
    assertNull(PDField.fromDictionary(form, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))));
  }

  /**
   * Test {@link PDField#getInheritableAttribute(COSName)}.
   * <p>
   * Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  @DisplayName("Test getInheritableAttribute(COSName)")
  void testGetInheritableAttribute() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).getInheritableAttribute(COSName.A));
  }

  /**
   * Test {@link PDField#getInheritableAttribute(COSName)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  @DisplayName("Test getInheritableAttribute(COSName); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetInheritableAttribute_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getInheritableAttribute(COSName.A));
  }

  /**
   * Test {@link PDField#getInheritableAttribute(COSName)}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  @DisplayName("Test getInheritableAttribute(COSName); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetInheritableAttribute_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull((new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .getInheritableAttribute(COSName.A));
  }

  /**
   * Test {@link PDField#setReadOnly(boolean)}.
   * <p>
   * Method under test: {@link PDField#setReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test setReadOnly(boolean)")
  void testSetReadOnly() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdCheckBox.setReadOnly(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(1), eq(true));
    assertEquals(0, pdCheckBox.getFieldFlags());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#isReadOnly()}.
   * <p>
   * Method under test: {@link PDField#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  void testIsReadOnly() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isReadOnly());
  }

  /**
   * Test {@link PDField#isReadOnly()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  void testIsReadOnly_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isReadOnly());
  }

  /**
   * Test {@link PDField#isReadOnly()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly(); then return 'true'")
  void testIsReadOnly_thenReturnTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act and Assert
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#setRequired(boolean)}.
   * <p>
   * Method under test: {@link PDField#setRequired(boolean)}
   */
  @Test
  @DisplayName("Test setRequired(boolean)")
  void testSetRequired() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdCheckBox.setRequired(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(2), eq(true));
    assertEquals(0, pdCheckBox.getFieldFlags());
    assertFalse(pdCheckBox.isRequired());
  }

  /**
   * Test {@link PDField#isRequired()}.
   * <p>
   * Method under test: {@link PDField#isRequired()}
   */
  @Test
  @DisplayName("Test isRequired()")
  void testIsRequired() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isRequired());
  }

  /**
   * Test {@link PDField#isRequired()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#isRequired()}
   */
  @Test
  @DisplayName("Test isRequired(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testIsRequired_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act and Assert
    assertFalse(pdCheckBox.isRequired());
  }

  /**
   * Test {@link PDField#isRequired()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#isRequired()}
   */
  @Test
  @DisplayName("Test isRequired(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  void testIsRequired_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isRequired());
  }

  /**
   * Test {@link PDField#isRequired()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#isRequired()}
   */
  @Test
  @DisplayName("Test isRequired(); then return 'true'")
  void testIsRequired_thenReturnTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setRequired(true);

    // Act and Assert
    assertTrue(pdCheckBox.isRequired());
  }

  /**
   * Test {@link PDField#setNoExport(boolean)}.
   * <p>
   * Method under test: {@link PDField#setNoExport(boolean)}
   */
  @Test
  @DisplayName("Test setNoExport(boolean)")
  void testSetNoExport() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdCheckBox.setNoExport(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(4), eq(true));
    assertEquals(0, pdCheckBox.getFieldFlags());
    assertFalse(pdCheckBox.isNoExport());
  }

  /**
   * Test {@link PDField#isNoExport()}.
   * <p>
   * Method under test: {@link PDField#isNoExport()}
   */
  @Test
  @DisplayName("Test isNoExport()")
  void testIsNoExport() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isNoExport());
  }

  /**
   * Test {@link PDField#isNoExport()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#isNoExport()}
   */
  @Test
  @DisplayName("Test isNoExport(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testIsNoExport_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act and Assert
    assertFalse(pdCheckBox.isNoExport());
  }

  /**
   * Test {@link PDField#isNoExport()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#isNoExport()}
   */
  @Test
  @DisplayName("Test isNoExport(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  void testIsNoExport_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isNoExport());
  }

  /**
   * Test {@link PDField#isNoExport()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#isNoExport()}
   */
  @Test
  @DisplayName("Test isNoExport(); then return 'true'")
  void testIsNoExport_thenReturnTrue() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setNoExport(true);

    // Act and Assert
    assertTrue(pdCheckBox.isNoExport());
  }

  /**
   * Test {@link PDField#setFieldFlags(int)}.
   * <p>
   * Method under test: {@link PDField#setFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setFieldFlags(int)")
  void testSetFieldFlags() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setInt(Mockito.<COSName>any(), anyInt());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdCheckBox.setFieldFlags(1);

    // Assert that nothing has changed
    verify(field).setInt(isA(COSName.class), eq(1));
    assertEquals(0, pdCheckBox.getFieldFlags());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#getActions()}.
   * <p>
   * Method under test: {@link PDField#getActions()}
   */
  @Test
  @DisplayName("Test getActions()")
  void testGetActions() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getActions());
  }

  /**
   * Test {@link PDField#getActions()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getActions()}
   */
  @Test
  @DisplayName("Test getActions(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  void testGetActions_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getActions());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given COSArray() add FALSE; then throw IOException")
  void testImportFDF_givenCOSArrayAddFalse_thenThrowIOException() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) cosArray);

    // Act and Assert
    assertThrows(IOException.class, () -> pdCheckBox.importFDF(fdfField));
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link FDFField#FDFField()} Value is
   * {@link COSArray#COSArray()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given COSArray(); when FDFField() Value is COSArray(); then throw IOException")
  void testImportFDF_givenCOSArray_whenFDFFieldValueIsCOSArray_thenThrowIOException() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSArray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdCheckBox.importFDF(fdfField));
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link FDFField#FDFField()} Value is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given COSStream(); when FDFField() Value is COSStream()")
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
    assertEquals(0, pdCheckBox.getFieldFlags());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link FDFField#FDFField()} Value is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given empty string; when FDFField() Value is empty string")
  void testImportFDF_givenEmptyString_whenFDFFieldValueIsEmptyString() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setValue("");

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    assertEquals(0, pdCheckBox.getFieldFlags());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.</li>
   *   <li>When {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'; when FDFField()")
  void testImportFDF_givenPDCheckBoxWithAcroFormIsPDAcroFormReadOnlyIsTrue_whenFDFField() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setReadOnly(true);

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} COSObject Values size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) COSObject Values size is three")
  void testImportFDF_thenPDCheckBoxWithAcroFormIsPDAcroFormCOSObjectValuesSizeIsThree() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   * <ul>
   *   <li>Then {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} Widgets size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); then PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Widgets size is one")
  void testImportFDF_thenPDCheckBoxWithAcroFormIsPDAcroFormWidgetsSizeIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setWidgetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals(0, pdCheckBox.getFieldFlags());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(1, getResult.getAnnotationFlags());
    assertFalse(pdCheckBox.isReadOnly());
    assertTrue(getResult.isInvisible());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()} ClearFieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() ClearFieldFlags is one")
  void testImportFDF_whenFDFFieldClearFieldFlagsIsOne() throws IOException {
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
   * <ul>
   *   <li>When {@link FDFField#FDFField()} FieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() FieldFlags is one")
  void testImportFDF_whenFDFFieldFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()} SetFieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() SetFieldFlags is one")
  void testImportFDF_whenFDFFieldSetFieldFlagsIsOne() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setSetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Test {@link PDField#getParent()}.
   * <p>
   * Method under test: {@link PDField#getParent()}
   */
  @Test
  @DisplayName("Test getParent()")
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getParent());
  }

  /**
   * Test {@link PDField#findKid(String[], int)}.
   * <p>
   * Method under test: {@link PDField#findKid(String[], int)}
   */
  @Test
  @DisplayName("Test findKid(String[], int)")
  void testFindKid() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull((new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .findKid(new String[]{"Name"}, 1));
  }

  /**
   * Test {@link PDField#findKid(String[], int)}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#findKid(String[], int)}
   */
  @Test
  @DisplayName("Test findKid(String[], int); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  void testFindKid_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).findKid(new String[]{"Name"}, 1));
  }

  /**
   * Test {@link PDField#getAcroForm()}.
   * <p>
   * Method under test: {@link PDField#getAcroForm()}
   */
  @Test
  @DisplayName("Test getAcroForm()")
  void testGetAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertSame(acroForm, (new PDCheckBox(acroForm)).getAcroForm());
  }

  /**
   * Test {@link PDField#getPartialName()}.
   * <p>
   * Method under test: {@link PDField#getPartialName()}
   */
  @Test
  @DisplayName("Test getPartialName()")
  void testGetPartialName() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getPartialName());
  }

  /**
   * Test {@link PDField#getPartialName()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getPartialName()}
   */
  @Test
  @DisplayName("Test getPartialName(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  void testGetPartialName_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getPartialName());
  }

  /**
   * Test {@link PDField#getPartialName()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getPartialName()}
   */
  @Test
  @DisplayName("Test getPartialName(); then return empty string")
  void testGetPartialName_thenReturnEmptyString() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertEquals("", pdCheckBox.getPartialName());
  }

  /**
   * Test {@link PDField#getPartialName()}.
   * <ul>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getPartialName()}
   */
  @Test
  @DisplayName("Test getPartialName(); then return 'Name'")
  void testGetPartialName_thenReturnName() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name", pdCheckBox.getPartialName());
  }

  /**
   * Test {@link PDField#setPartialName(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#setPartialName(String)}
   */
  @Test
  @DisplayName("Test setPartialName(String); when '.'; then throw IllegalArgumentException")
  void testSetPartialName_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(new PDDocument()))).setPartialName("."));
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   * <p>
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName()")
  void testGetFullyQualifiedName() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name", pdCheckBox.getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  void testGetFullyQualifiedName_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName(); then return empty string")
  void testGetFullyQualifiedName_thenReturnEmptyString() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertEquals("", pdCheckBox.getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   * <ul>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName(); then return 'Name'")
  void testGetFullyQualifiedName_thenReturnName() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertEquals("Name", (new PDCheckBox(acroForm, new COSDictionary(), parent)).getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getFullyQualifiedName()}.
   * <ul>
   *   <li>Then return {@code Name.Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName(); then return 'Name.Name'")
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
   * Test {@link PDField#getFullyQualifiedName()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  @DisplayName("Test getFullyQualifiedName(); then return 'null'")
  void testGetFullyQualifiedName_thenReturnNull() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull((new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .getFullyQualifiedName());
  }

  /**
   * Test {@link PDField#getAlternateFieldName()}.
   * <p>
   * Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  @DisplayName("Test getAlternateFieldName()")
  void testGetAlternateFieldName() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull((new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .getAlternateFieldName());
  }

  /**
   * Test {@link PDField#getAlternateFieldName()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  @DisplayName("Test getAlternateFieldName(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  void testGetAlternateFieldName_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getAlternateFieldName());
  }

  /**
   * Test {@link PDField#getAlternateFieldName()}.
   * <ul>
   *   <li>Then return {@code Alternate Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  @DisplayName("Test getAlternateFieldName(); then return 'Alternate Field Name'")
  void testGetAlternateFieldName_thenReturnAlternateFieldName() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setAlternateFieldName("Alternate Field Name");

    // Act and Assert
    assertEquals("Alternate Field Name", pdCheckBox.getAlternateFieldName());
  }

  /**
   * Test {@link PDField#getAlternateFieldName()}.
   * <ul>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  @DisplayName("Test getAlternateFieldName(); then return '.'")
  void testGetAlternateFieldName_thenReturnDot() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setAlternateFieldName(".");

    // Act and Assert
    assertEquals(".", pdCheckBox.getAlternateFieldName());
  }

  /**
   * Test {@link PDField#setAlternateFieldName(String)}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#setString(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#setAlternateFieldName(String)}
   */
  @Test
  @DisplayName("Test setAlternateFieldName(String); then calls setString(COSName, String)")
  void testSetAlternateFieldName_thenCallsSetString() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setString(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .setAlternateFieldName("Alternate Field Name");

    // Assert that nothing has changed
    verify(field).setString(isA(COSName.class), eq("Alternate Field Name"));
  }

  /**
   * Test {@link PDField#getMappingName()}.
   * <p>
   * Method under test: {@link PDField#getMappingName()}
   */
  @Test
  @DisplayName("Test getMappingName()")
  void testGetMappingName() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getMappingName());
  }

  /**
   * Test {@link PDField#getMappingName()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getMappingName()}
   */
  @Test
  @DisplayName("Test getMappingName(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  void testGetMappingName_givenPDCheckBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getMappingName());
  }

  /**
   * Test {@link PDField#getMappingName()}.
   * <ul>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getMappingName()}
   */
  @Test
  @DisplayName("Test getMappingName(); then return '.'")
  void testGetMappingName_thenReturnDot() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setMappingName(".");

    // Act and Assert
    assertEquals(".", pdCheckBox.getMappingName());
  }

  /**
   * Test {@link PDField#getMappingName()}.
   * <ul>
   *   <li>Then return {@code Mapping Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#getMappingName()}
   */
  @Test
  @DisplayName("Test getMappingName(); then return 'Mapping Name'")
  void testGetMappingName_thenReturnMappingName() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setMappingName("Mapping Name");

    // Act and Assert
    assertEquals("Mapping Name", pdCheckBox.getMappingName());
  }

  /**
   * Test {@link PDField#setMappingName(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setString(COSName, String)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setString(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#setMappingName(String)}
   */
  @Test
  @DisplayName("Test setMappingName(String); given COSDictionary setString(COSName, String) does nothing; then calls setString(COSName, String)")
  void testSetMappingName_givenCOSDictionarySetStringDoesNothing_thenCallsSetString() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setString(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .setMappingName("Mapping Name");

    // Assert that nothing has changed
    verify(field).setString(isA(COSName.class), eq("Mapping Name"));
  }

  /**
   * Test {@link PDField#toString()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc
   * is {@link PDDocument#PDDocument()} and form is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  void testToString_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertEquals("null{type: PDCheckBox value: null}",
        (new PDCheckBox(new PDAcroForm(doc, new COSDictionary()))).toString());
  }

  /**
   * Test {@link PDField#toString()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testToString_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("null{type: PDCheckBox value: null}", (new PDCheckBox(new PDAcroForm(new PDDocument()))).toString());
  }

  /**
   * Test {@link PDField#toString()}.
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} PartialName is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument) PartialName is 'Name'")
  void testToString_givenPDCheckBoxWithAcroFormIsPDAcroFormPartialNameIsName() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name{type: PDCheckBox value: null}", pdCheckBox.toString());
  }

  /**
   * Test {@link PDField#toString()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testToString_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("null{type: PDCheckBox value: null}",
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).toString());
  }

  /**
   * Test {@link PDField#toString()}.
   * <ul>
   *   <li>Then return {@code Name.Name{type: PDCheckBox value: null}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Name.Name{type: PDCheckBox value: null}'")
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
   * <ul>
   *   <li>Then return {@code Name{type: PDCheckBox value: null}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Name{type: PDCheckBox value: null}'")
  void testToString_thenReturnNameTypePDCheckBoxValueNull() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertEquals("Name{type: PDCheckBox value: null}",
        (new PDCheckBox(acroForm, new COSDictionary(), parent)).toString());
  }

  /**
   * Test {@link PDField#toString()}.
   * <ul>
   *   <li>Then return {@code {type: PDCheckBox value: null}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDField#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '{type: PDCheckBox value: null}'")
  void testToString_thenReturnTypePDCheckBoxValueNull() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    // Act and Assert
    assertEquals("{type: PDCheckBox value: null}", pdCheckBox.toString());
  }
}
