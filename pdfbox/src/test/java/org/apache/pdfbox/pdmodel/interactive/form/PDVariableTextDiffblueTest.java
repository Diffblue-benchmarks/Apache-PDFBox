package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
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
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDVariableText.getDefaultAppearance()"})
  void testGetDefaultAppearance_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDComboBox(new PDAcroForm(new PDDocument()))).getDefaultAppearance());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearance()}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDVariableText.getDefaultAppearance()"})
  void testGetDefaultAppearance_thenReturn42() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("42");

    // Act and Assert
    assertEquals("42", (new PDComboBox(acroForm)).getDefaultAppearance());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearance()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDVariableText.getDefaultAppearance()"})
  void testGetDefaultAppearance_thenReturnEmptyString() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultAppearance("");

    // Act and Assert
    assertEquals("", (new PDComboBox(acroForm)).getDefaultAppearance());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearance()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDVariableText.getDefaultAppearance()"})
  void testGetDefaultAppearance_thenReturnNull() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull((new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .getDefaultAppearance());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearanceString()}.
   * <p>
   * Method under test: {@link PDVariableText#getDefaultAppearanceString()}
   */
  @Test
  @DisplayName("Test getDefaultAppearanceString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDefaultAppearanceString PDVariableText.getDefaultAppearanceString()"})
  void testGetDefaultAppearanceString() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("42");

    // Act
    PDDefaultAppearanceString actualDefaultAppearanceString = (new PDComboBox(acroForm)).getDefaultAppearanceString();

    // Assert
    assertNull(actualDefaultAppearanceString.getFontName());
    assertNull(actualDefaultAppearanceString.getFont());
    assertNull(actualDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearanceString()}.
   * <p>
   * Method under test: {@link PDVariableText#getDefaultAppearanceString()}
   */
  @Test
  @DisplayName("Test getDefaultAppearanceString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDefaultAppearanceString PDVariableText.getDefaultAppearanceString()"})
  void testGetDefaultAppearanceString2() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("Da Value");

    // Act
    PDDefaultAppearanceString actualDefaultAppearanceString = (new PDComboBox(acroForm)).getDefaultAppearanceString();

    // Assert
    assertNull(actualDefaultAppearanceString.getFontName());
    assertNull(actualDefaultAppearanceString.getFont());
    assertNull(actualDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearanceString()}.
   * <p>
   * Method under test: {@link PDVariableText#getDefaultAppearanceString()}
   */
  @Test
  @DisplayName("Test getDefaultAppearanceString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDefaultAppearanceString PDVariableText.getDefaultAppearanceString()"})
  void testGetDefaultAppearanceString3() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("java.util.Set");

    // Act
    PDDefaultAppearanceString actualDefaultAppearanceString = (new PDComboBox(acroForm)).getDefaultAppearanceString();

    // Assert
    assertNull(actualDefaultAppearanceString.getFontName());
    assertNull(actualDefaultAppearanceString.getFont());
    assertNull(actualDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDVariableText#getDefaultAppearanceString()}.
   * <p>
   * Method under test: {@link PDVariableText#getDefaultAppearanceString()}
   */
  @Test
  @DisplayName("Test getDefaultAppearanceString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDefaultAppearanceString PDVariableText.getDefaultAppearanceString()"})
  void testGetDefaultAppearanceString4() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setDefaultResources(new PDResources());
    acroForm.setDefaultAppearance("org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation");

    // Act
    PDDefaultAppearanceString actualDefaultAppearanceString = (new PDComboBox(acroForm)).getDefaultAppearanceString();

    // Assert
    assertNull(actualDefaultAppearanceString.getFontName());
    assertNull(actualDefaultAppearanceString.getFont());
    assertNull(actualDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDVariableText#setDefaultAppearance(String)}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#setString(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#setDefaultAppearance(String)}
   */
  @Test
  @DisplayName("Test setDefaultAppearance(String); then calls setString(COSName, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVariableText.setDefaultAppearance(String)"})
  void testSetDefaultAppearance_thenCallsSetString() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setString(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .setDefaultAppearance("42");

    // Assert that nothing has changed
    verify(field).setString(isA(COSName.class), eq("42"));
  }

  /**
   * Test {@link PDVariableText#getDefaultStyleString()}.
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getDefaultStyleString()}
   */
  @Test
  @DisplayName("Test getDefaultStyleString(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDVariableText.getDefaultStyleString()"})
  void testGetDefaultStyleString_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDComboBox(new PDAcroForm(new PDDocument()))).getDefaultStyleString());
  }

  /**
   * Test {@link PDVariableText#setDefaultStyleString(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSBase)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#setDefaultStyleString(String)}
   */
  @Test
  @DisplayName("Test setDefaultStyleString(String); given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVariableText.setDefaultStyleString(String)"})
  void testSetDefaultStyleString_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .setDefaultStyleString("Default Style String");

    // Assert that nothing has changed
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDVariableText#setDefaultStyleString(String)}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#removeItem(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#setDefaultStyleString(String)}
   */
  @Test
  @DisplayName("Test setDefaultStyleString(String); then calls removeItem(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVariableText.setDefaultStyleString(String)"})
  void testSetDefaultStyleString_thenCallsRemoveItem() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).removeItem(Mockito.<COSName>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .setDefaultStyleString(null);

    // Assert that nothing has changed
    verify(field).removeItem(isA(COSName.class));
  }

  /**
   * Test {@link PDVariableText#getQ()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()} Q is five.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getQ()}
   */
  @Test
  @DisplayName("Test getQ(); given PDAcroForm(PDDocument) with doc is PDDocument() Q is five; then return five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDVariableText.getQ()"})
  void testGetQ_givenPDAcroFormWithDocIsPDDocumentQIsFive_thenReturnFive() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setQ(5);

    // Act and Assert
    assertEquals(5, (new PDComboBox(acroForm)).getQ());
  }

  /**
   * Test {@link PDVariableText#getQ()}.
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getQ()}
   */
  @Test
  @DisplayName("Test getQ(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDVariableText.getQ()"})
  void testGetQ_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDComboBox(new PDAcroForm(new PDDocument()))).getQ());
  }

  /**
   * Test {@link PDVariableText#getQ()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getQ()}
   */
  @Test
  @DisplayName("Test getQ(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDVariableText.getQ()"})
  void testGetQ_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals(0, (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getQ());
  }

  /**
   * Test {@link PDVariableText#setQ(int)}.
   * <p>
   * Method under test: {@link PDVariableText#setQ(int)}
   */
  @Test
  @DisplayName("Test setQ(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVariableText.setQ(int)"})
  void testSetQ() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setInt(Mockito.<COSName>any(), anyInt());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setQ(1);

    // Assert that nothing has changed
    verify(field).setInt(isA(COSName.class), eq(1));
    assertEquals(0, pdComboBox.getQ());
  }

  /**
   * Test {@link PDVariableText#getRichTextValue()}.
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getRichTextValue()}
   */
  @Test
  @DisplayName("Test getRichTextValue(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDVariableText.getRichTextValue()"})
  void testGetRichTextValue_givenPDComboBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("", (new PDComboBox(new PDAcroForm(new PDDocument()))).getRichTextValue());
  }

  /**
   * Test {@link PDVariableText#getRichTextValue()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getRichTextValue()}
   */
  @Test
  @DisplayName("Test getRichTextValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDVariableText.getRichTextValue()"})
  void testGetRichTextValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals("",
        (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getRichTextValue());
  }

  /**
   * Test {@link PDVariableText#setRichTextValue(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#removeItem(COSName)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#removeItem(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#setRichTextValue(String)}
   */
  @Test
  @DisplayName("Test setRichTextValue(String); given COSDictionary removeItem(COSName) does nothing; then calls removeItem(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVariableText.setRichTextValue(String)"})
  void testSetRichTextValue_givenCOSDictionaryRemoveItemDoesNothing_thenCallsRemoveItem() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).removeItem(Mockito.<COSName>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setRichTextValue(null);

    // Assert that nothing has changed
    verify(field).removeItem(isA(COSName.class));
    assertEquals("", pdComboBox.getRichTextValue());
  }

  /**
   * Test {@link PDVariableText#setRichTextValue(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSBase)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#setRichTextValue(String)}
   */
  @Test
  @DisplayName("Test setRichTextValue(String); given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVariableText.setRichTextValue(String)"})
  void testSetRichTextValue_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setRichTextValue("42");

    // Assert that nothing has changed
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("", pdComboBox.getRichTextValue());
  }

  /**
   * Test {@link PDVariableText#getStringOrStream(COSBase)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getStringOrStream(COSBase)}
   */
  @Test
  @DisplayName("Test getStringOrStream(COSBase); when COSStream(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDVariableText.getStringOrStream(COSBase)"})
  void testGetStringOrStream_whenCOSStream_thenReturnEmptyString() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertEquals("", pdComboBox.getStringOrStream(new COSStream()));
  }

  /**
   * Test {@link PDVariableText#getStringOrStream(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getStringOrStream(COSBase)}
   */
  @Test
  @DisplayName("Test getStringOrStream(COSBase); when FALSE; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDVariableText.getStringOrStream(COSBase)"})
  void testGetStringOrStream_whenFalse_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDComboBox(new PDAcroForm(new PDDocument()))).getStringOrStream(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDVariableText#getStringOrStream(COSBase)}.
   * <ul>
   *   <li>When parseHex {@code 42}.</li>
   *   <li>Then return {@code B}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getStringOrStream(COSBase)}
   */
  @Test
  @DisplayName("Test getStringOrStream(COSBase); when parseHex '42'; then return 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDVariableText.getStringOrStream(COSBase)"})
  void testGetStringOrStream_whenParseHex42_thenReturnB() throws IOException {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertEquals("B", pdComboBox.getStringOrStream(COSString.parseHex("42")));
  }

  /**
   * Test {@link PDVariableText#getStringOrStream(COSBase)}.
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.</li>
   *   <li>Then return {@code #Eg›«Íï}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVariableText#getStringOrStream(COSBase)}
   */
  @Test
  @DisplayName("Test getStringOrStream(COSBase); when parseHex '0123456789ABCDEF'; then return '#Eg›«Íï'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDVariableText.getStringOrStream(COSBase)"})
  void testGetStringOrStream_whenParseHex0123456789abcdef_thenReturnEg() throws IOException {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertEquals("\u0001#Eg›«Íï", pdComboBox.getStringOrStream(COSString.parseHex("0123456789ABCDEF")));
  }
}
