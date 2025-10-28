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

class PDTextFieldDiffblueTest {
  /**
   * Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  void testIsMultiline() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).isMultiline());
  }

  /**
   * Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  void testIsMultiline2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsMultilineResult = (new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isMultiline();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsMultilineResult);
  }

  /**
   * Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  void testIsMultiline3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setReadOnly(true);

    // Act
    boolean actualIsMultilineResult = pdTextField.isMultiline();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsMultilineResult);
  }

  /**
   * Method under test: {@link PDTextField#isMultiline()}
   */
  @Test
  void testIsMultiline4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setFieldFlags(4096);

    // Act
    boolean actualIsMultilineResult = pdTextField.isMultiline();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsMultilineResult);
  }

  /**
   * Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  void testIsPassword() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).isPassword());
  }

  /**
   * Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  void testIsPassword2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsPasswordResult = (new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isPassword();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsPasswordResult);
  }

  /**
   * Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  void testIsPassword3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setReadOnly(true);

    // Act
    boolean actualIsPasswordResult = pdTextField.isPassword();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsPasswordResult);
  }

  /**
   * Method under test: {@link PDTextField#isPassword()}
   */
  @Test
  void testIsPassword4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setFieldFlags(8192);

    // Act
    boolean actualIsPasswordResult = pdTextField.isPassword();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsPasswordResult);
  }

  /**
   * Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  void testIsFileSelect() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).isFileSelect());
  }

  /**
   * Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  void testIsFileSelect2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsFileSelectResult = (new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isFileSelect();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsFileSelectResult);
  }

  /**
   * Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  void testIsFileSelect3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setReadOnly(true);

    // Act
    boolean actualIsFileSelectResult = pdTextField.isFileSelect();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsFileSelectResult);
  }

  /**
   * Method under test: {@link PDTextField#isFileSelect()}
   */
  @Test
  void testIsFileSelect4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setFieldFlags(1048576);

    // Act
    boolean actualIsFileSelectResult = pdTextField.isFileSelect();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsFileSelectResult);
  }

  /**
   * Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  void testDoNotSpellCheck() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).doNotSpellCheck());
  }

  /**
   * Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  void testDoNotSpellCheck2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualDoNotSpellCheckResult = (new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .doNotSpellCheck();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualDoNotSpellCheckResult);
  }

  /**
   * Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  void testDoNotSpellCheck3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setReadOnly(true);

    // Act
    boolean actualDoNotSpellCheckResult = pdTextField.doNotSpellCheck();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualDoNotSpellCheckResult);
  }

  /**
   * Method under test: {@link PDTextField#doNotSpellCheck()}
   */
  @Test
  void testDoNotSpellCheck4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setFieldFlags(4194304);

    // Act
    boolean actualDoNotSpellCheckResult = pdTextField.doNotSpellCheck();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualDoNotSpellCheckResult);
  }

  /**
   * Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  void testDoNotScroll() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).doNotScroll());
  }

  /**
   * Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  void testDoNotScroll2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualDoNotScrollResult = (new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .doNotScroll();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualDoNotScrollResult);
  }

  /**
   * Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  void testDoNotScroll3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setReadOnly(true);

    // Act
    boolean actualDoNotScrollResult = pdTextField.doNotScroll();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualDoNotScrollResult);
  }

  /**
   * Method under test: {@link PDTextField#doNotScroll()}
   */
  @Test
  void testDoNotScroll4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setFieldFlags(8388608);

    // Act
    boolean actualDoNotScrollResult = pdTextField.doNotScroll();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualDoNotScrollResult);
  }

  /**
   * Method under test: {@link PDTextField#isComb()}
   */
  @Test
  void testIsComb() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).isComb());
  }

  /**
   * Method under test: {@link PDTextField#isComb()}
   */
  @Test
  void testIsComb2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsCombResult = (new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).isComb();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsCombResult);
  }

  /**
   * Method under test: {@link PDTextField#isComb()}
   */
  @Test
  void testIsComb3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setReadOnly(true);

    // Act
    boolean actualIsCombResult = pdTextField.isComb();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsCombResult);
  }

  /**
   * Method under test: {@link PDTextField#isComb()}
   */
  @Test
  void testIsComb4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setFieldFlags(16777216);

    // Act
    boolean actualIsCombResult = pdTextField.isComb();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsCombResult);
  }

  /**
   * Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  void testIsRichText() {
    // Arrange, Act and Assert
    assertFalse((new PDTextField(new PDAcroForm(new PDDocument()))).isRichText());
  }

  /**
   * Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  void testIsRichText2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsRichTextResult = (new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isRichText();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsRichTextResult);
  }

  /**
   * Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  void testIsRichText3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setReadOnly(true);

    // Act
    boolean actualIsRichTextResult = pdTextField.isRichText();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsRichTextResult);
  }

  /**
   * Method under test: {@link PDTextField#isRichText()}
   */
  @Test
  void testIsRichText4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDTextField pdTextField = new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdTextField.setFieldFlags(33554432);

    // Act
    boolean actualIsRichTextResult = pdTextField.isRichText();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsRichTextResult);
  }

  /**
   * Method under test: {@link PDTextField#getMaxLen()}
   */
  @Test
  void testGetMaxLen() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDTextField(new PDAcroForm(new PDDocument()))).getMaxLen());
  }

  /**
   * Method under test: {@link PDTextField#getMaxLen()}
   */
  @Test
  void testGetMaxLen2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualMaxLen = (new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getMaxLen();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-1, actualMaxLen);
  }

  /**
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  void testSetValue() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  void testSetValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("Annot");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  void testSetValue3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("Widget");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  void testSetValue4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("\\u000D\\u000A|[\\u000A\\u000B\\u000C\\u000D\\u0085\\u2028\\u2029]");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  void testSetValue5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("Da Value");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  void testSetValue6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("widget of field {} has no rectangle, no appearance stream created");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  void testSetValue7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("org.apache.logging.log4j.util.StackLocator");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  void testSetValue8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("\r\n");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("\r\n", pdTextField.getValue());
    assertEquals("\r\n", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  void testSetValue9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue(" ");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(" ", pdTextField.getValue());
    assertEquals(" ", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  void testSetValue10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setReadOnly(true);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTextField#setValue(String)}
   */
  @Test
  void testSetValue11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setPartialName("\r\n");
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("42", pdTextField.getValue());
    assertEquals("42", pdTextField.getValueAsString());
    COSDictionary cOSObject = pdTextField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTextField#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(new PDDocument()))).getValue());
  }

  /**
   * Method under test: {@link PDTextField#getValue()}
   */
  @Test
  void testGetValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualValue = (new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualValue);
  }

  /**
   * Method under test: {@link PDTextField#getValue()}
   */
  @Test
  void testGetValue3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("",
        (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getValue());
  }

  /**
   * Method under test: {@link PDTextField#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue() {
    // Arrange, Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(new PDDocument()))).getDefaultValue());
  }

  /**
   * Method under test: {@link PDTextField#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualDefaultValue = (new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getDefaultValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualDefaultValue);
  }

  /**
   * Method under test: {@link PDTextField#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("",
        (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getDefaultValue());
  }

  /**
   * Method under test: {@link PDTextField#getValueAsString()}
   */
  @Test
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDTextField(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Method under test: {@link PDTextField#getValueAsString()}
   */
  @Test
  void testGetValueAsString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualValueAsString = (new PDTextField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getValueAsString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualValueAsString);
  }

  /**
   * Method under test: {@link PDTextField#getValueAsString()}
   */
  @Test
  void testGetValueAsString3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("", (new PDTextField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .getValueAsString());
  }

  /**
   * Method under test: {@link PDTextField#constructAppearances()}
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

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDTextField#constructAppearances()}
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

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDTextField#constructAppearances()}
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

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  void testConstructAppearances4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("\\u000D\\u000A|[\\u000A\\u000B\\u000C\\u000D\\u0085\\u2028\\u2029]");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  void testConstructAppearances5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("Da Value");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  void testConstructAppearances6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("java.util.Set");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  void testConstructAppearances7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("widget of field {} has no rectangle, no appearance stream created");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  void testConstructAppearances8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("org.apache.logging.log4j.util.StackLocator");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  void testConstructAppearances9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setReadOnly(true);
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  void testConstructAppearances10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.setPartialName("\r\n");
    pdTextField.importFDF(new FDFField());

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDTextField#constructAppearances()}
   */
  @Test
  void testConstructAppearances11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    FDFField fdfField = new FDFField();
    fdfField.setValue("Value");

    PDTextField pdTextField = new PDTextField(acroForm);
    pdTextField.importFDF(fdfField);

    // Act
    pdTextField.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDTextField#PDTextField(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  void testNewPDTextField() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDTextField actualPdTextField = new PDTextField(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdTextField.getCOSObject());
    assertSame(acroForm, actualPdTextField.getAcroForm());
    assertSame(parent, actualPdTextField.getParent());
  }
}
