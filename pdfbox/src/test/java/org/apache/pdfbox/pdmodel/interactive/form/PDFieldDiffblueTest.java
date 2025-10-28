package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.Test;

class PDFieldDiffblueTest {
  /**
   * Method under test:
   * {@link PDField#fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  void testFromDictionary() {
    // Arrange
    PDAcroForm form = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull(PDField.fromDictionary(form, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))));
  }

  /**
   * Method under test:
   * {@link PDField#fromDictionary(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  void testFromDictionary2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm form = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    COSDictionary field = new COSDictionary();

    // Act
    PDField actualFromDictionaryResult = PDField.fromDictionary(form, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFromDictionaryResult);
  }

  /**
   * Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  void testGetInheritableAttribute() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getInheritableAttribute(COSName.A));
  }

  /**
   * Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  void testGetInheritableAttribute2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualInheritableAttribute = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getInheritableAttribute(COSName.A);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualInheritableAttribute);
  }

  /**
   * Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  void testGetInheritableAttribute3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull((new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .getInheritableAttribute(COSName.A));
  }

  /**
   * Method under test: {@link PDField#getInheritableAttribute(COSName)}
   */
  @Test
  void testGetInheritableAttribute4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualInheritableAttribute = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getInheritableAttribute(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualInheritableAttribute);
  }

  /**
   * Method under test: {@link PDField#isReadOnly()}
   */
  @Test
  void testIsReadOnly() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isReadOnly());
  }

  /**
   * Method under test: {@link PDField#isReadOnly()}
   */
  @Test
  void testIsReadOnly2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsReadOnlyResult = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isReadOnly();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsReadOnlyResult);
  }

  /**
   * Method under test: {@link PDField#isReadOnly()}
   */
  @Test
  void testIsReadOnly3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setReadOnly(true);

    // Act
    boolean actualIsReadOnlyResult = pdCheckBox.isReadOnly();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsReadOnlyResult);
  }

  /**
   * Method under test: {@link PDField#isRequired()}
   */
  @Test
  void testIsRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isRequired());
  }

  /**
   * Method under test: {@link PDField#isRequired()}
   */
  @Test
  void testIsRequired2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsRequiredResult = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isRequired();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsRequiredResult);
  }

  /**
   * Method under test: {@link PDField#isRequired()}
   */
  @Test
  void testIsRequired3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setReadOnly(true);

    // Act
    boolean actualIsRequiredResult = pdCheckBox.isRequired();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsRequiredResult);
  }

  /**
   * Method under test: {@link PDField#isRequired()}
   */
  @Test
  void testIsRequired4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setRequired(true);

    // Act
    boolean actualIsRequiredResult = pdCheckBox.isRequired();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsRequiredResult);
  }

  /**
   * Method under test: {@link PDField#isNoExport()}
   */
  @Test
  void testIsNoExport() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isNoExport());
  }

  /**
   * Method under test: {@link PDField#isNoExport()}
   */
  @Test
  void testIsNoExport2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsNoExportResult = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isNoExport();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsNoExportResult);
  }

  /**
   * Method under test: {@link PDField#isNoExport()}
   */
  @Test
  void testIsNoExport3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setReadOnly(true);

    // Act
    boolean actualIsNoExportResult = pdCheckBox.isNoExport();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsNoExportResult);
  }

  /**
   * Method under test: {@link PDField#isNoExport()}
   */
  @Test
  void testIsNoExport4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setNoExport(true);

    // Act
    boolean actualIsNoExportResult = pdCheckBox.isNoExport();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsNoExportResult);
  }

  /**
   * Method under test: {@link PDField#getActions()}
   */
  @Test
  void testGetActions() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getActions());
  }

  /**
   * Method under test: {@link PDField#getActions()}
   */
  @Test
  void testGetActions2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFormFieldAdditionalActions actualActions = (new PDCheckBox(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getActions();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualActions);
  }

  /**
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setReadOnly(true);

    // Act
    pdCheckBox.importFDF(new FDFField());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setSetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(1, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertTrue(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setClearFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setWidgetFieldFlags((Integer) 1);

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", pdCheckBox.getValue());
    assertEquals("Off", pdCheckBox.getValueAsString());
    assertEquals(0, pdCheckBox.getFieldFlags());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(1, getResult.getAnnotationFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertFalse(pdCheckBox.isReadOnly());
    assertTrue(getResult.isInvisible());
  }

  /**
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSArray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdCheckBox.importFDF(fdfField));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSStream());

    // Act
    pdCheckBox.importFDF(fdfField);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    List<PDAnnotationWidget> widgets = pdCheckBox.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, pdCheckBox.getFieldFlags());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(getResult.isInvisible());
    assertFalse(pdCheckBox.isRadioButton());
    assertFalse(pdCheckBox.isNoExport());
    assertFalse(pdCheckBox.isReadOnly());
  }

  /**
   * Method under test: {@link PDField#importFDF(FDFField)}
   */
  @Test
  void testImportFDF9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) cosArray);

    // Act and Assert
    assertThrows(IOException.class, () -> pdCheckBox.importFDF(fdfField));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDField#getParent()}
   */
  @Test
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getParent());
  }

  /**
   * Method under test: {@link PDField#getParent()}
   */
  @Test
  void testGetParent2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDNonTerminalField actualParent = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getParent();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualParent);
  }

  /**
   * Method under test: {@link PDField#findKid(String[], int)}
   */
  @Test
  void testFindKid() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).findKid(new String[]{"Name"}, 1));
  }

  /**
   * Method under test: {@link PDField#findKid(String[], int)}
   */
  @Test
  void testFindKid2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDField actualFindKidResult = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .findKid(new String[]{"Name"}, 1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindKidResult);
  }

  /**
   * Method under test: {@link PDField#getAcroForm()}
   */
  @Test
  void testGetAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertSame(acroForm, (new PDCheckBox(acroForm)).getAcroForm());
  }

  /**
   * Method under test: {@link PDField#getAcroForm()}
   */
  @Test
  void testGetAcroForm2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));

    // Act
    PDAcroForm actualAcroForm = (new PDCheckBox(acroForm)).getAcroForm();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(acroForm, actualAcroForm);
  }

  /**
   * Method under test: {@link PDField#getPartialName()}
   */
  @Test
  void testGetPartialName() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getPartialName());
  }

  /**
   * Method under test: {@link PDField#getPartialName()}
   */
  @Test
  void testGetPartialName2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualPartialName = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getPartialName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPartialName);
  }

  /**
   * Method under test: {@link PDField#getPartialName()}
   */
  @Test
  void testGetPartialName3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("Name");

    // Act
    String actualPartialName = pdCheckBox.getPartialName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Name", actualPartialName);
  }

  /**
   * Method under test: {@link PDField#getPartialName()}
   */
  @Test
  void testGetPartialName4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("");

    // Act
    String actualPartialName = pdCheckBox.getPartialName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualPartialName);
  }

  /**
   * Method under test: {@link PDField#setPartialName(String)}
   */
  @Test
  void testSetPartialName() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).setPartialName("."));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  void testGetFullyQualifiedName() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getFullyQualifiedName());
  }

  /**
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  void testGetFullyQualifiedName2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualFullyQualifiedName = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getFullyQualifiedName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFullyQualifiedName);
  }

  /**
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  void testGetFullyQualifiedName3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull((new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .getFullyQualifiedName());
  }

  /**
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  void testGetFullyQualifiedName4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("Name");

    // Act
    String actualFullyQualifiedName = pdCheckBox.getFullyQualifiedName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Name", actualFullyQualifiedName);
  }

  /**
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  void testGetFullyQualifiedName5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("");

    // Act
    String actualFullyQualifiedName = pdCheckBox.getFullyQualifiedName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualFullyQualifiedName);
  }

  /**
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  void testGetFullyQualifiedName6() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertEquals("Name", (new PDCheckBox(acroForm, new COSDictionary(), parent)).getFullyQualifiedName());
  }

  /**
   * Method under test: {@link PDField#getFullyQualifiedName()}
   */
  @Test
  void testGetFullyQualifiedName7() {
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
   * Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  void testGetAlternateFieldName() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getAlternateFieldName());
  }

  /**
   * Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  void testGetAlternateFieldName2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualAlternateFieldName = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getAlternateFieldName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualAlternateFieldName);
  }

  /**
   * Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  void testGetAlternateFieldName3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setAlternateFieldName("Alternate Field Name");

    // Act
    String actualAlternateFieldName = pdCheckBox.getAlternateFieldName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Alternate Field Name", actualAlternateFieldName);
  }

  /**
   * Method under test: {@link PDField#getAlternateFieldName()}
   */
  @Test
  void testGetAlternateFieldName4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setAlternateFieldName(".");

    // Act
    String actualAlternateFieldName = pdCheckBox.getAlternateFieldName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(".", actualAlternateFieldName);
  }

  /**
   * Method under test: {@link PDField#getMappingName()}
   */
  @Test
  void testGetMappingName() {
    // Arrange, Act and Assert
    assertNull((new PDCheckBox(new PDAcroForm(new PDDocument()))).getMappingName());
  }

  /**
   * Method under test: {@link PDField#getMappingName()}
   */
  @Test
  void testGetMappingName2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualMappingName = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getMappingName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualMappingName);
  }

  /**
   * Method under test: {@link PDField#getMappingName()}
   */
  @Test
  void testGetMappingName3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setMappingName("Mapping Name");

    // Act
    String actualMappingName = pdCheckBox.getMappingName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Mapping Name", actualMappingName);
  }

  /**
   * Method under test: {@link PDField#getMappingName()}
   */
  @Test
  void testGetMappingName4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setMappingName(".");

    // Act
    String actualMappingName = pdCheckBox.getMappingName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(".", actualMappingName);
  }

  /**
   * Method under test: {@link PDField#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("null{type: PDCheckBox value: null}", (new PDCheckBox(new PDAcroForm(new PDDocument()))).toString());
  }

  /**
   * Method under test: {@link PDField#toString()}
   */
  @Test
  void testToString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualToStringResult = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .toString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("null{type: PDCheckBox value: null}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDField#toString()}
   */
  @Test
  void testToString3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("null{type: PDCheckBox value: null}",
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).toString());
  }

  /**
   * Method under test: {@link PDField#toString()}
   */
  @Test
  void testToString4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("Name");

    // Act
    String actualToStringResult = pdCheckBox.toString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Name{type: PDCheckBox value: null}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDField#toString()}
   */
  @Test
  void testToString5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("");

    // Act
    String actualToStringResult = pdCheckBox.toString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("{type: PDCheckBox value: null}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDField#toString()}
   */
  @Test
  void testToString6() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertEquals("Name{type: PDCheckBox value: null}",
        (new PDCheckBox(acroForm, new COSDictionary(), parent)).toString());
  }

  /**
   * Method under test: {@link PDField#toString()}
   */
  @Test
  void testToString7() {
    // Arrange
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    parent.setPartialName("Name");
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, new COSDictionary(), parent);
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertEquals("Name.Name{type: PDCheckBox value: null}", pdCheckBox.toString());
  }
}
