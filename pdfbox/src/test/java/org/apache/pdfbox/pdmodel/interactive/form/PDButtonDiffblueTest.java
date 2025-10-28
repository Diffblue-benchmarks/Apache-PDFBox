package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.Test;

class PDButtonDiffblueTest {
  /**
   * Method under test: {@link PDButton#isPushButton()}
   */
  @Test
  void testIsPushButton() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isPushButton());
  }

  /**
   * Method under test: {@link PDButton#isPushButton()}
   */
  @Test
  void testIsPushButton2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsPushButtonResult = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isPushButton();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsPushButtonResult);
  }

  /**
   * Method under test: {@link PDButton#isPushButton()}
   */
  @Test
  void testIsPushButton3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setReadOnly(true);

    // Act
    boolean actualIsPushButtonResult = pdCheckBox.isPushButton();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsPushButtonResult);
  }

  /**
   * Method under test: {@link PDButton#isPushButton()}
   */
  @Test
  void testIsPushButton4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setFieldFlags(65536);

    // Act
    boolean actualIsPushButtonResult = pdCheckBox.isPushButton();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsPushButtonResult);
  }

  /**
   * Method under test: {@link PDButton#isRadioButton()}
   */
  @Test
  void testIsRadioButton() {
    // Arrange, Act and Assert
    assertFalse((new PDCheckBox(new PDAcroForm(new PDDocument()))).isRadioButton());
  }

  /**
   * Method under test: {@link PDButton#isRadioButton()}
   */
  @Test
  void testIsRadioButton2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsRadioButtonResult = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isRadioButton();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsRadioButtonResult);
  }

  /**
   * Method under test: {@link PDButton#isRadioButton()}
   */
  @Test
  void testIsRadioButton3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setReadOnly(true);

    // Act
    boolean actualIsRadioButtonResult = pdCheckBox.isRadioButton();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsRadioButtonResult);
  }

  /**
   * Method under test: {@link PDButton#isRadioButton()}
   */
  @Test
  void testIsRadioButton4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setFieldFlags(32768);

    // Act
    boolean actualIsRadioButtonResult = pdCheckBox.isRadioButton();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsRadioButtonResult);
  }

  /**
   * Method under test: {@link PDButton#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals("Off", (new PDCheckBox(new PDAcroForm(new PDDocument()))).getValue());
  }

  /**
   * Method under test: {@link PDButton#getValue()}
   */
  @Test
  void testGetValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualValue = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", actualValue);
  }

  /**
   * Method under test: {@link PDButton#getValue()}
   */
  @Test
  void testGetValue3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("Off",
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getValue());
  }

  /**
   * Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  void testSetValue() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDCheckBox(new PDAcroForm(new PDDocument()))).setValue(1));
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(new PDDocument()))).setValue("42"));
  }

  /**
   * Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  void testSetValue2() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).setValue(1));
  }

  /**
   * Method under test: {@link PDButton#setValue(int)}
   */
  @Test
  void testSetValue3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue(1));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  void testSetValue4() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
            .setValue("42"));
  }

  /**
   * Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  void testSetValue5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdCheckBox.setValue("");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", pdCheckBox.getValue());
    assertEquals("", pdCheckBox.getValueAsString());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDButton#setValue(String)}
   */
  @Test
  void testSetValue6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setValue("42"));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDButton#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue() {
    // Arrange, Act and Assert
    assertEquals("", (new PDCheckBox(new PDAcroForm(new PDDocument()))).getDefaultValue());
  }

  /**
   * Method under test: {@link PDButton#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualDefaultValue = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getDefaultValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualDefaultValue);
  }

  /**
   * Method under test: {@link PDButton#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("",
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getDefaultValue());
  }

  /**
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  void testSetDefaultValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(new PDDocument()))).setDefaultValue("42"));
  }

  /**
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  void testSetDefaultValue2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
            .setDefaultValue("42"));
  }

  /**
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  void testSetDefaultValue3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdCheckBox.setDefaultValue("");

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  void testSetDefaultValue4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.importFDF(new FDFField());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setDefaultValue("42"));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDButton#setDefaultValue(String)}
   */
  @Test
  void testSetDefaultValue5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.setDefaultValue("42"));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDButton#getValueAsString()}
   */
  @Test
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("Off", (new PDCheckBox(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Method under test: {@link PDButton#getValueAsString()}
   */
  @Test
  void testGetValueAsString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualValueAsString = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getValueAsString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Off", actualValueAsString);
  }

  /**
   * Method under test: {@link PDButton#getValueAsString()}
   */
  @Test
  void testGetValueAsString3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("Off",
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getValueAsString());
  }

  /**
   * Method under test: {@link PDButton#getExportValues()}
   */
  @Test
  void testGetExportValues() {
    // Arrange, Act and Assert
    assertTrue((new PDCheckBox(new PDAcroForm(new PDDocument()))).getExportValues().isEmpty());
  }

  /**
   * Method under test: {@link PDButton#getExportValues()}
   */
  @Test
  void testGetExportValues2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<String> actualExportValues = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getExportValues();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualExportValues.isEmpty());
  }

  /**
   * Method under test: {@link PDButton#getExportValues()}
   */
  @Test
  void testGetExportValues3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertTrue(
        (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getExportValues()
            .isEmpty());
  }

  /**
   * Method under test: {@link PDButton#setExportValues(List)}
   */
  @Test
  void testSetExportValues() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    PDCheckBox pdCheckBox = new PDCheckBox(acroForm);

    // Act
    pdCheckBox.setExportValues(new ArrayList<>());

    // Assert
    verify(streamCacheCreateFunction).create();
    Set<String> onValues = pdCheckBox.getOnValues();
    assertEquals(1, onValues.size());
    COSDictionary cOSObject = pdCheckBox.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdCheckBox.getExportValues().isEmpty());
    assertTrue(onValues.contains(""));
    assertSame(acroForm, pdCheckBox.getAcroForm());
  }

  /**
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  void testConstructAppearances() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDButton#constructAppearances()}
   */
  @Test
  void testConstructAppearances2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.importFDF(new FDFField());

    // Act
    pdCheckBox.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDButton#getOnValues()}
   */
  @Test
  void testGetOnValues() {
    // Arrange and Act
    Set<String> actualOnValues = (new PDCheckBox(new PDAcroForm(new PDDocument()))).getOnValues();

    // Assert
    assertEquals(1, actualOnValues.size());
    assertTrue(actualOnValues.contains(""));
  }

  /**
   * Method under test: {@link PDButton#getOnValues()}
   */
  @Test
  void testGetOnValues2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    Set<String> actualOnValues = (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getOnValues();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualOnValues.size());
    assertTrue(actualOnValues.contains(""));
  }

  /**
   * Method under test: {@link PDButton#getOnValues()}
   */
  @Test
  void testGetOnValues3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act
    Set<String> actualOnValues = (new PDCheckBox(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getOnValues();

    // Assert
    assertEquals(1, actualOnValues.size());
    assertTrue(actualOnValues.contains(""));
  }

  /**
   * Method under test: {@link PDButton#getOnValues()}
   */
  @Test
  void testGetOnValues4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.importFDF(new FDFField());

    // Act
    Set<String> actualOnValues = pdCheckBox.getOnValues();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualOnValues.size());
    assertTrue(actualOnValues.contains(""));
  }

  /**
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  void testCheckValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(new PDAcroForm(new PDDocument()))).checkValue("42"));
  }

  /**
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  void testCheckValue2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
            .checkValue("42"));
  }

  /**
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  void testCheckValue3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    (new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).checkValue("");

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  void testCheckValue4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.importFDF(new FDFField());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.checkValue("42"));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDButton#checkValue(String)}
   */
  @Test
  void testCheckValue5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdCheckBox.setPartialName("Widget");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdCheckBox.checkValue("42"));
    verify(streamCacheCreateFunction).create();
  }
}
