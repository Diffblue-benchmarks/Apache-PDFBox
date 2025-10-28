package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.Test;

class PDRadioButtonDiffblueTest {
  /**
   * Method under test: {@link PDRadioButton#setRadiosInUnison(boolean)}
   */
  @Test
  void testSetRadiosInUnison() {
    // Arrange
    PDRadioButton pdRadioButton = new PDRadioButton(new PDAcroForm(new PDDocument()));

    // Act
    pdRadioButton.setRadiosInUnison(true);

    // Assert
    assertEquals(33587200, pdRadioButton.getFieldFlags());
    assertTrue(pdRadioButton.isRadiosInUnison());
  }

  /**
   * Method under test: {@link PDRadioButton#setRadiosInUnison(boolean)}
   */
  @Test
  void testSetRadiosInUnison2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDRadioButton pdRadioButton = new PDRadioButton(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdRadioButton.setRadiosInUnison(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(33587200, pdRadioButton.getFieldFlags());
    assertTrue(pdRadioButton.isRadiosInUnison());
  }

  /**
   * Method under test: {@link PDRadioButton#setRadiosInUnison(boolean)}
   */
  @Test
  void testSetRadiosInUnison3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDRadioButton pdRadioButton = new PDRadioButton(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdRadioButton.setRadiosInUnison(true);

    // Assert
    assertEquals(33554432, pdRadioButton.getFieldFlags());
    assertTrue(pdRadioButton.isRadiosInUnison());
    assertSame(field, pdRadioButton.getCOSObject());
  }

  /**
   * Method under test: {@link PDRadioButton#setRadiosInUnison(boolean)}
   */
  @Test
  void testSetRadiosInUnison4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDRadioButton pdRadioButton = new PDRadioButton(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdRadioButton.setRadiosInUnison(false);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(32768, pdRadioButton.getFieldFlags());
    assertFalse(pdRadioButton.isRadiosInUnison());
  }

  /**
   * Method under test: {@link PDRadioButton#setRadiosInUnison(boolean)}
   */
  @Test
  void testSetRadiosInUnison5() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDRadioButton pdRadioButton = new PDRadioButton(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdRadioButton.setRadiosInUnison(false);

    // Assert
    assertEquals(0, pdRadioButton.getFieldFlags());
    assertFalse(pdRadioButton.isRadiosInUnison());
    assertSame(field, pdRadioButton.getCOSObject());
  }

  /**
   * Method under test: {@link PDRadioButton#isRadiosInUnison()}
   */
  @Test
  void testIsRadiosInUnison() {
    // Arrange, Act and Assert
    assertFalse((new PDRadioButton(new PDAcroForm(new PDDocument()))).isRadiosInUnison());
  }

  /**
   * Method under test: {@link PDRadioButton#isRadiosInUnison()}
   */
  @Test
  void testIsRadiosInUnison2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsRadiosInUnisonResult = (new PDRadioButton(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).isRadiosInUnison();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsRadiosInUnisonResult);
  }

  /**
   * Method under test: {@link PDRadioButton#isRadiosInUnison()}
   */
  @Test
  void testIsRadiosInUnison3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse((new PDRadioButton(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .isRadiosInUnison());
  }

  /**
   * Method under test: {@link PDRadioButton#isRadiosInUnison()}
   */
  @Test
  void testIsRadiosInUnison4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDRadioButton pdRadioButton = new PDRadioButton(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdRadioButton.setFieldFlags(33554432);

    // Act
    boolean actualIsRadiosInUnisonResult = pdRadioButton.isRadiosInUnison();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsRadiosInUnisonResult);
  }

  /**
   * Method under test: {@link PDRadioButton#getSelectedIndex()}
   */
  @Test
  void testGetSelectedIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDRadioButton(new PDAcroForm(new PDDocument()))).getSelectedIndex());
  }

  /**
   * Method under test: {@link PDRadioButton#getSelectedIndex()}
   */
  @Test
  void testGetSelectedIndex2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualSelectedIndex = (new PDRadioButton(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getSelectedIndex();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualSelectedIndex);
  }

  /**
   * Method under test: {@link PDRadioButton#getSelectedIndex()}
   */
  @Test
  void testGetSelectedIndex3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDRadioButton pdRadioButton = new PDRadioButton(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdRadioButton.importFDF(new FDFField());

    // Act
    int actualSelectedIndex = pdRadioButton.getSelectedIndex();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualSelectedIndex);
  }

  /**
   * Method under test: {@link PDRadioButton#getSelectedExportValues()}
   */
  @Test
  void testGetSelectedExportValues() {
    // Arrange and Act
    List<String> actualSelectedExportValues = (new PDRadioButton(new PDAcroForm(new PDDocument())))
        .getSelectedExportValues();

    // Assert
    assertEquals(1, actualSelectedExportValues.size());
    assertEquals("Off", actualSelectedExportValues.get(0));
  }

  /**
   * Method under test: {@link PDRadioButton#getSelectedExportValues()}
   */
  @Test
  void testGetSelectedExportValues2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<String> actualSelectedExportValues = (new PDRadioButton(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getSelectedExportValues();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualSelectedExportValues.size());
    assertEquals("Off", actualSelectedExportValues.get(0));
  }

  /**
   * Method under test: {@link PDRadioButton#getSelectedExportValues()}
   */
  @Test
  void testGetSelectedExportValues3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act
    List<String> actualSelectedExportValues = (new PDRadioButton(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getSelectedExportValues();

    // Assert
    assertEquals(1, actualSelectedExportValues.size());
    assertEquals("Off", actualSelectedExportValues.get(0));
  }

  /**
   * Method under test:
   * {@link PDRadioButton#PDRadioButton(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  void testNewPDRadioButton() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDRadioButton actualPdRadioButton = new PDRadioButton(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdRadioButton.getCOSObject());
    assertSame(acroForm, actualPdRadioButton.getAcroForm());
    assertSame(parent, actualPdRadioButton.getParent());
  }
}
