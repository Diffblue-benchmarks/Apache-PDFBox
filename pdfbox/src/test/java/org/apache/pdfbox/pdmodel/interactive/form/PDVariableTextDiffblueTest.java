package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDVariableTextDiffblueTest {
  /**
   * Test {@link PDVariableText#getDefaultAppearance()}.
   *
   * <p>Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDVariableText.getDefaultAppearance()"})
  void testGetDefaultAppearance() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertNull(new PDComboBox(acroForm).getDefaultAppearance());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  @DisplayName(
      "Test getDefaultAppearance(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDVariableText.getDefaultAppearance()"})
  void testGetDefaultAppearance_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComboBox(new PDAcroForm(new PDDocument())).getDefaultAppearance());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  @DisplayName(
      "Test getDefaultAppearance(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDVariableText.getDefaultAppearance()"})
  void testGetDefaultAppearance_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertNull(pdComboBox.getDefaultAppearance());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearance()}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDVariableText.getDefaultAppearance()"})
  void testGetDefaultAppearance_thenReturn42() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("42");

    // Act and Assert
    assertEquals("42", new PDComboBox(acroForm).getDefaultAppearance());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearance()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDVariableText.getDefaultAppearance()"})
  void testGetDefaultAppearance_thenReturnEmptyString() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("");

    // Act and Assert
    assertEquals("", new PDComboBox(acroForm).getDefaultAppearance());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearanceString()}.
   *
   * <p>Method under test: {@link PDVariableText#getDefaultAppearanceString()}
   */
  @Test
  @DisplayName("Test getDefaultAppearanceString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDefaultAppearanceString PDVariableText.getDefaultAppearanceString()"})
  void testGetDefaultAppearanceString() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);

    // Act
    PDDefaultAppearanceString actualDefaultAppearanceString =
        new PDComboBox(acroForm).getDefaultAppearanceString();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(acroForm).getCOSObject();
    verify(acroForm).getDefaultResources();
    assertNull(actualDefaultAppearanceString.getFontName());
    assertNull(actualDefaultAppearanceString.getFont());
    assertNull(actualDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearanceString()}.
   *
   * <p>Method under test: {@link PDVariableText#getDefaultAppearanceString()}
   */
  @Test
  @DisplayName("Test getDefaultAppearanceString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDefaultAppearanceString PDVariableText.getDefaultAppearanceString()"})
  void testGetDefaultAppearanceString2() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(
            new COSString("/DA is a required entry. Please set a default appearance first."));

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);

    // Act
    PDDefaultAppearanceString actualDefaultAppearanceString =
        new PDComboBox(acroForm).getDefaultAppearanceString();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(acroForm).getCOSObject();
    verify(acroForm).getDefaultResources();
    assertNull(actualDefaultAppearanceString.getFontName());
    assertNull(actualDefaultAppearanceString.getFont());
    assertNull(actualDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearanceString()}.
   *
   * <ul>
   *   <li>Then calls {@link COSString#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getDefaultAppearanceString()}
   */
  @Test
  @DisplayName("Test getDefaultAppearanceString(); then calls getBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDefaultAppearanceString PDVariableText.getDefaultAppearanceString()"})
  void testGetDefaultAppearanceString_thenCallsGetBytes() throws IOException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getDefaultResources()).thenReturn(new PDResources());
    when(acroForm.getCOSObject()).thenReturn(cosDictionary);

    // Act
    PDDefaultAppearanceString actualDefaultAppearanceString =
        new PDComboBox(acroForm).getDefaultAppearanceString();

    // Assert
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosString).getBytes();
    verify(acroForm).getCOSObject();
    verify(acroForm).getDefaultResources();
    assertNull(actualDefaultAppearanceString.getFontName());
    assertNull(actualDefaultAppearanceString.getFont());
    assertNull(actualDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDVariableText#getDefaultStyleString()}.
   *
   * <p>Method under test: {@link PDVariableText#getDefaultStyleString()}
   */
  @Test
  @DisplayName("Test getDefaultStyleString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDVariableText.getDefaultStyleString()"})
  void testGetDefaultStyleString() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertNull(pdComboBox.getDefaultStyleString());
  }

  /**
   * Test {@link PDVariableText#getDefaultStyleString()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getDefaultStyleString()}
   */
  @Test
  @DisplayName(
      "Test getDefaultStyleString(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDVariableText.getDefaultStyleString()"})
  void testGetDefaultStyleString_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComboBox(new PDAcroForm(new PDDocument())).getDefaultStyleString());
  }

  /**
   * Test {@link PDVariableText#getQ()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary#COSDictionary()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getQ()}
   */
  @Test
  @DisplayName(
      "Test getQ(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDVariableText.getQ()"})
  void testGetQ_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary_thenReturnZero() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertEquals(0, new PDComboBox(acroForm).getQ());
  }

  /**
   * Test {@link PDVariableText#getQ()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} Q is five.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getQ()}
   */
  @Test
  @DisplayName(
      "Test getQ(); given PDAcroForm(PDDocument) with doc is PDDocument() Q is five; then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDVariableText.getQ()"})
  void testGetQ_givenPDAcroFormWithDocIsPDDocumentQIsFive_thenReturnFive() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setQ(5);

    // Act and Assert
    assertEquals(5, new PDComboBox(acroForm).getQ());
  }

  /**
   * Test {@link PDVariableText#getQ()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getQ()}
   */
  @Test
  @DisplayName(
      "Test getQ(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDVariableText.getQ()"})
  void testGetQ_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDComboBox(new PDAcroForm(new PDDocument())).getQ());
  }

  /**
   * Test {@link PDVariableText#getQ()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getQ()}
   */
  @Test
  @DisplayName(
      "Test getQ(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDVariableText.getQ()"})
  void testGetQ_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertEquals(0, pdComboBox.getQ());
  }

  /**
   * Test {@link PDVariableText#getRichTextValue()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getRichTextValue()}
   */
  @Test
  @DisplayName(
      "Test getRichTextValue(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDVariableText.getRichTextValue()"})
  void testGetRichTextValue_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertEquals("", new PDComboBox(acroForm).getRichTextValue());
  }

  /**
   * Test {@link PDVariableText#getRichTextValue()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getRichTextValue()}
   */
  @Test
  @DisplayName(
      "Test getRichTextValue(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDVariableText.getRichTextValue()"})
  void testGetRichTextValue_givenPDComboBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", new PDComboBox(new PDAcroForm(new PDDocument())).getRichTextValue());
  }

  /**
   * Test {@link PDVariableText#getRichTextValue()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDVariableText#getRichTextValue()}
   */
  @Test
  @DisplayName(
      "Test getRichTextValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDVariableText.getRichTextValue()"})
  void testGetRichTextValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertEquals("", pdComboBox.getRichTextValue());
  }

  /**
   * Test {@link PDVariableText#getStringOrStream(COSBase)}.
   *
   * <p>Method under test: {@link PDVariableText#getStringOrStream(COSBase)}
   */
  @Test
  @DisplayName("Test getStringOrStream(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDVariableText.getStringOrStream(COSBase)"})
  void testGetStringOrStream() {
    // Arrange, Act and Assert
    assertEquals(
        "", new PDComboBox(new PDAcroForm(new PDDocument())).getStringOrStream(COSBoolean.FALSE));
  }
}
