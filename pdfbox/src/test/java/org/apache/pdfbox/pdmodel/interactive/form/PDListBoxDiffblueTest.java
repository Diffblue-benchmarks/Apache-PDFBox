package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDListBoxDiffblueTest {
  /**
   * Test {@link PDListBox#PDListBox(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   *
   * <p>Method under test: {@link PDListBox#PDListBox(PDAcroForm, COSDictionary,
   * PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDListBox(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.<init>(PDAcroForm, COSDictionary, PDNonTerminalField)"})
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

  /**
   * Test {@link PDListBox#PDListBox(PDAcroForm)}.
   *
   * <p>Method under test: {@link PDListBox#PDListBox(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDListBox(PDAcroForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDListBox.<init>(PDAcroForm)"})
  void testNewPDListBox2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDListBox actualPdListBox = new PDListBox(acroForm);

    // Assert
    assertEquals("", actualPdListBox.getRichTextValue());
    assertEquals("Ch", actualPdListBox.getFieldType());
    assertEquals("[]", actualPdListBox.getValueAsString());
    assertNull(actualPdListBox.getAlternateFieldName());
    assertNull(actualPdListBox.getFullyQualifiedName());
    assertNull(actualPdListBox.getMappingName());
    assertNull(actualPdListBox.getPartialName());
    assertNull(actualPdListBox.getDefaultAppearance());
    assertNull(actualPdListBox.getDefaultStyleString());
    assertNull(actualPdListBox.getActions());
    assertNull(actualPdListBox.getParent());
    assertEquals(0, actualPdListBox.getTopIndex());
    assertEquals(0, actualPdListBox.getFieldFlags());
    assertEquals(0, actualPdListBox.getQ());
    assertEquals(1, actualPdListBox.getWidgets().size());
    assertFalse(actualPdListBox.isCombo());
    assertFalse(actualPdListBox.isCommitOnSelChange());
    assertFalse(actualPdListBox.isDoNotSpellCheck());
    assertFalse(actualPdListBox.isMultiSelect());
    assertFalse(actualPdListBox.isSort());
    assertFalse(actualPdListBox.isNoExport());
    assertFalse(actualPdListBox.isReadOnly());
    assertFalse(actualPdListBox.isRequired());
    List<String> defaultValue = actualPdListBox.getDefaultValue();
    assertTrue(defaultValue.isEmpty());
    assertSame(acroForm, actualPdListBox.getAcroForm());
    assertSame(defaultValue, actualPdListBox.getOptions());
    assertSame(defaultValue, actualPdListBox.getOptionsDisplayValues());
    assertSame(defaultValue, actualPdListBox.getOptionsExportValues());
    assertSame(defaultValue, actualPdListBox.getSelectedOptionsIndex());
    assertSame(defaultValue, actualPdListBox.getValue());
  }

  /**
   * Test {@link PDListBox#getTopIndex()}.
   *
   * <p>Method under test: {@link PDListBox#getTopIndex()}
   */
  @Test
  @DisplayName("Test getTopIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDListBox.getTopIndex()"})
  void testGetTopIndex() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDListBox pdListBox = new PDListBox(acroForm, field, parent);

    // Act and Assert
    assertEquals(0, pdListBox.getTopIndex());
  }

  /**
   * Test {@link PDListBox#getTopIndex()}.
   *
   * <ul>
   *   <li>Given {@link PDListBox#PDListBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDListBox#getTopIndex()}
   */
  @Test
  @DisplayName(
      "Test getTopIndex(); given PDListBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDListBox.getTopIndex()"})
  void testGetTopIndex_givenPDListBoxWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDListBox(new PDAcroForm(new PDDocument())).getTopIndex());
  }
}
