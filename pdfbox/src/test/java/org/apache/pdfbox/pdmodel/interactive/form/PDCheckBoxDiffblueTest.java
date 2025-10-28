package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.Test;

class PDCheckBoxDiffblueTest {
  /**
   * Method under test: {@link PDCheckBox#isChecked()}
   */
  @Test
  void testIsChecked() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isChecked());
  }

  /**
   * Method under test: {@link PDCheckBox#isChecked()}
   */
  @Test
  void testIsChecked2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsCheckedResult = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isChecked();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsCheckedResult);
  }

  /**
   * Method under test: {@link PDCheckBox#isChecked()}
   */
  @Test
  void testIsChecked3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isChecked());
  }

  /**
   * Method under test: {@link PDCheckBox#isChecked()}
   */
  @Test
  void testIsChecked4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.importFDF(new FDFField());

    // Act
    boolean actualIsCheckedResult = pdCheckBox.isChecked();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsCheckedResult);
  }

  /**
   * Method under test: {@link PDCheckBox#check()}
   */
  @Test
  void testCheck() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.check();

    // Assert
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDCheckBox#check()}
   */
  @Test
  void testCheck2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdCheckBox.check();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDCheckBox#check()}
   */
  @Test
  void testCheck3() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdCheckBox.check();

    // Assert
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    assertSame(field, pdCheckBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDCheckBox#unCheck()}
   */
  @Test
  void testUnCheck() throws IOException {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));

    // Act
    pdCheckBox.unCheck();

    // Assert
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDCheckBox#unCheck()}
   */
  @Test
  void testUnCheck2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdCheckBox.unCheck();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDCheckBox#unCheck()}
   */
  @Test
  void testUnCheck3() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdCheckBox.unCheck();

    // Assert
    assertSame(field, pdCheckBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDCheckBox#getOnValue()}
   */
  @Test
  void testGetOnValue() {
    // Arrange, Act and Assert
    assertEquals("", (new PDCheckBox(new PDAcroForm(new PDDocument()))).getOnValue());
  }

  /**
   * Method under test: {@link PDCheckBox#getOnValue()}
   */
  @Test
  void testGetOnValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualOnValue = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getOnValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualOnValue);
  }

  /**
   * Method under test: {@link PDCheckBox#getOnValue()}
   */
  @Test
  void testGetOnValue3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.importFDF(new FDFField());

    // Act
    String actualOnValue = pdCheckBox.getOnValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualOnValue);
  }

  /**
   * Method under test:
   * {@link PDCheckBox#PDCheckBox(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  void testNewPDCheckBox() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDCheckBox actualPdCheckBox = new PDCheckBox(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdCheckBox.getCOSObject());
    assertSame(acroForm, actualPdCheckBox.getAcroForm());
    assertSame(parent, actualPdCheckBox.getParent());
  }
}
