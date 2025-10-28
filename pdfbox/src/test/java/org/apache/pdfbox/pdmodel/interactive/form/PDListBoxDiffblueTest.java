package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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

class PDListBoxDiffblueTest {
  /**
   * Method under test: {@link PDListBox#getTopIndex()}
   */
  @Test
  void testGetTopIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDListBox(new PDAcroForm(new PDDocument()))).getTopIndex());
  }

  /**
   * Method under test: {@link PDListBox#getTopIndex()}
   */
  @Test
  void testGetTopIndex2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualTopIndex = (new PDListBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getTopIndex();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualTopIndex);
  }

  /**
   * Method under test: {@link PDListBox#constructAppearances()}
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

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.importFDF(new FDFField());

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDListBox#constructAppearances()}
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

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.importFDF(new FDFField());

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDListBox#constructAppearances()}
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

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.importFDF(new FDFField());

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDListBox#constructAppearances()}
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

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.importFDF(new FDFField());

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDListBox#constructAppearances()}
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

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.importFDF(new FDFField());

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDListBox#constructAppearances()}
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

    PDListBox pdListBox = new PDListBox(acroForm);
    pdListBox.setPartialName("Annot");
    pdListBox.importFDF(new FDFField());

    // Act
    pdListBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDListBox#PDListBox(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
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
}
