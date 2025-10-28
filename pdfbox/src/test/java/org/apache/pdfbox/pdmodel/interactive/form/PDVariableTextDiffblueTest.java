package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.Test;

class PDVariableTextDiffblueTest {
  /**
   * Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  void testGetDefaultAppearance() {
    // Arrange, Act and Assert
    assertNull((new PDComboBox(new PDAcroForm(new PDDocument()))).getDefaultAppearance());
  }

  /**
   * Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  void testGetDefaultAppearance2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualDefaultAppearance = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getDefaultAppearance();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDefaultAppearance);
  }

  /**
   * Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  void testGetDefaultAppearance3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull((new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .getDefaultAppearance());
  }

  /**
   * Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  void testGetDefaultAppearance4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");

    // Act
    String actualDefaultAppearance = (new PDComboBox(acroForm)).getDefaultAppearance();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", actualDefaultAppearance);
  }

  /**
   * Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  void testGetDefaultAppearance5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("");

    // Act
    String actualDefaultAppearance = (new PDComboBox(acroForm)).getDefaultAppearance();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualDefaultAppearance);
  }

  /**
   * Method under test: {@link PDVariableText#getDefaultAppearanceString()}
   */
  @Test
  void testGetDefaultAppearanceString() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("42");

    // Act
    PDDefaultAppearanceString actualDefaultAppearanceString = (new PDComboBox(acroForm)).getDefaultAppearanceString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDefaultAppearanceString.getFontName());
    assertNull(actualDefaultAppearanceString.getFont());
    assertNull(actualDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualDefaultAppearanceString.getFontSize());
  }

  /**
   * Method under test: {@link PDVariableText#getDefaultAppearanceString()}
   */
  @Test
  void testGetDefaultAppearanceString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("Da Value");

    // Act
    PDDefaultAppearanceString actualDefaultAppearanceString = (new PDComboBox(acroForm)).getDefaultAppearanceString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDefaultAppearanceString.getFontName());
    assertNull(actualDefaultAppearanceString.getFont());
    assertNull(actualDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualDefaultAppearanceString.getFontSize());
  }

  /**
   * Method under test: {@link PDVariableText#getDefaultAppearanceString()}
   */
  @Test
  void testGetDefaultAppearanceString3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("java.util.Set");

    // Act
    PDDefaultAppearanceString actualDefaultAppearanceString = (new PDComboBox(acroForm)).getDefaultAppearanceString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDefaultAppearanceString.getFontName());
    assertNull(actualDefaultAppearanceString.getFont());
    assertNull(actualDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualDefaultAppearanceString.getFontSize());
  }

  /**
   * Method under test: {@link PDVariableText#getDefaultAppearanceString()}
   */
  @Test
  void testGetDefaultAppearanceString4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation");

    // Act
    PDDefaultAppearanceString actualDefaultAppearanceString = (new PDComboBox(acroForm)).getDefaultAppearanceString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDefaultAppearanceString.getFontName());
    assertNull(actualDefaultAppearanceString.getFont());
    assertNull(actualDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualDefaultAppearanceString.getFontSize());
  }

  /**
   * Method under test: {@link PDVariableText#getDefaultStyleString()}
   */
  @Test
  void testGetDefaultStyleString() {
    // Arrange, Act and Assert
    assertNull((new PDComboBox(new PDAcroForm(new PDDocument()))).getDefaultStyleString());
  }

  /**
   * Method under test: {@link PDVariableText#getDefaultStyleString()}
   */
  @Test
  void testGetDefaultStyleString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualDefaultStyleString = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getDefaultStyleString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDefaultStyleString);
  }

  /**
   * Method under test: {@link PDVariableText#getQ()}
   */
  @Test
  void testGetQ() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDComboBox(new PDAcroForm(new PDDocument()))).getQ());
  }

  /**
   * Method under test: {@link PDVariableText#getQ()}
   */
  @Test
  void testGetQ2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualQ = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getQ();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualQ);
  }

  /**
   * Method under test: {@link PDVariableText#getQ()}
   */
  @Test
  void testGetQ3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals(0, (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getQ());
  }

  /**
   * Method under test: {@link PDVariableText#getQ()}
   */
  @Test
  void testGetQ4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setQ(5);

    // Act
    int actualQ = (new PDComboBox(acroForm)).getQ();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(5, actualQ);
  }

  /**
   * Method under test: {@link PDVariableText#getRichTextValue()}
   */
  @Test
  void testGetRichTextValue() {
    // Arrange, Act and Assert
    assertEquals("", (new PDComboBox(new PDAcroForm(new PDDocument()))).getRichTextValue());
  }

  /**
   * Method under test: {@link PDVariableText#getRichTextValue()}
   */
  @Test
  void testGetRichTextValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualRichTextValue = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getRichTextValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualRichTextValue);
  }

  /**
   * Method under test: {@link PDVariableText#getRichTextValue()}
   */
  @Test
  void testGetRichTextValue3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("",
        (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getRichTextValue());
  }

  /**
   * Method under test: {@link PDVariableText#getStringOrStream(COSBase)}
   */
  @Test
  void testGetStringOrStream() {
    // Arrange, Act and Assert
    assertEquals("", (new PDComboBox(new PDAcroForm(new PDDocument()))).getStringOrStream(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link PDVariableText#getStringOrStream(COSBase)}
   */
  @Test
  void testGetStringOrStream2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualStringOrStream = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getStringOrStream(COSBoolean.FALSE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualStringOrStream);
  }

  /**
   * Method under test: {@link PDVariableText#getStringOrStream(COSBase)}
   */
  @Test
  void testGetStringOrStream3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    String actualStringOrStream = pdComboBox.getStringOrStream(COSString.parseHex("0123456789ABCDEF"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("\u0001#Eg›«Íï", actualStringOrStream);
  }

  /**
   * Method under test: {@link PDVariableText#getStringOrStream(COSBase)}
   */
  @Test
  void testGetStringOrStream4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    String actualStringOrStream = pdComboBox.getStringOrStream(new COSStream());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualStringOrStream);
  }

  /**
   * Method under test: {@link PDVariableText#getStringOrStream(COSBase)}
   */
  @Test
  void testGetStringOrStream5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    String actualStringOrStream = pdComboBox.getStringOrStream(COSString.parseHex("42"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("B", actualStringOrStream);
  }
}
