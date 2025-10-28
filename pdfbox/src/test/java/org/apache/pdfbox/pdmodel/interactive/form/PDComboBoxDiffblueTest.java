package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.Test;

class PDComboBoxDiffblueTest {
  /**
   * Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  void testIsEdit() {
    // Arrange, Act and Assert
    assertFalse((new PDComboBox(new PDAcroForm(new PDDocument()))).isEdit());
  }

  /**
   * Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  void testIsEdit2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsEditResult = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).isEdit();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsEditResult);
  }

  /**
   * Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  void testIsEdit3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse((new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isEdit());
  }

  /**
   * Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  void testIsEdit4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdComboBox.setFieldFlags(262144);

    // Act
    boolean actualIsEditResult = pdComboBox.isEdit();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsEditResult);
  }

  /**
   * Method under test: {@link PDComboBox#setEdit(boolean)}
   */
  @Test
  void testSetEdit() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    // Act
    pdComboBox.setEdit(true);

    // Assert
    assertEquals(393216, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isEdit());
  }

  /**
   * Method under test: {@link PDComboBox#setEdit(boolean)}
   */
  @Test
  void testSetEdit2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setEdit(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(393216, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isEdit());
  }

  /**
   * Method under test: {@link PDComboBox#setEdit(boolean)}
   */
  @Test
  void testSetEdit3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setEdit(true);

    // Assert
    assertEquals(262144, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isEdit());
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDComboBox#setEdit(boolean)}
   */
  @Test
  void testSetEdit4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setEdit(false);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(131072, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isEdit());
  }

  /**
   * Method under test: {@link PDComboBox#setEdit(boolean)}
   */
  @Test
  void testSetEdit5() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setEdit(false);

    // Assert
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isEdit());
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  void testConstructAppearances() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  void testConstructAppearances2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("Annot");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  void testConstructAppearances3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("Widget");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  void testConstructAppearances4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("widget of field {} has no rectangle, no appearance stream created");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  void testConstructAppearances5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("org.apache.logging.log4j.util.StackLocator");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  void testConstructAppearances6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.setPartialName("Annot");
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDComboBox#constructAppearances()}
   */
  @Test
  void testConstructAppearances7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    FDFField fdfField = new FDFField();
    fdfField.setValue("Value");

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(fdfField);

    // Act
    pdComboBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDComboBox#PDComboBox(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
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
}
