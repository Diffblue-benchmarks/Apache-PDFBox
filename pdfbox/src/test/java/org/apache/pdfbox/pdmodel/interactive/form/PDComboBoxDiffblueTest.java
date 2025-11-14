package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDComboBoxDiffblueTest {
  /**
   * Test {@link PDComboBox#PDComboBox(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   *
   * <p>Method under test: {@link PDComboBox#PDComboBox(PDAcroForm, COSDictionary,
   * PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDComboBox(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComboBox.<init>(PDAcroForm, COSDictionary, PDNonTerminalField)"})
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

  /**
   * Test {@link PDComboBox#PDComboBox(PDAcroForm)}.
   *
   * <p>Method under test: {@link PDComboBox#PDComboBox(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDComboBox(PDAcroForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComboBox.<init>(PDAcroForm)"})
  void testNewPDComboBox2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDComboBox actualPdComboBox = new PDComboBox(acroForm);

    // Assert
    assertEquals("", actualPdComboBox.getRichTextValue());
    assertEquals("Ch", actualPdComboBox.getFieldType());
    assertEquals("[]", actualPdComboBox.getValueAsString());
    assertNull(actualPdComboBox.getAlternateFieldName());
    assertNull(actualPdComboBox.getFullyQualifiedName());
    assertNull(actualPdComboBox.getMappingName());
    assertNull(actualPdComboBox.getPartialName());
    assertNull(actualPdComboBox.getDefaultAppearance());
    assertNull(actualPdComboBox.getDefaultStyleString());
    assertNull(actualPdComboBox.getActions());
    assertNull(actualPdComboBox.getParent());
    assertEquals(0, actualPdComboBox.getQ());
    assertEquals(1, actualPdComboBox.getWidgets().size());
    assertEquals(131072, actualPdComboBox.getFieldFlags());
    assertFalse(actualPdComboBox.isCommitOnSelChange());
    assertFalse(actualPdComboBox.isDoNotSpellCheck());
    assertFalse(actualPdComboBox.isMultiSelect());
    assertFalse(actualPdComboBox.isSort());
    assertFalse(actualPdComboBox.isEdit());
    assertFalse(actualPdComboBox.isNoExport());
    assertFalse(actualPdComboBox.isReadOnly());
    assertFalse(actualPdComboBox.isRequired());
    List<String> defaultValue = actualPdComboBox.getDefaultValue();
    assertTrue(defaultValue.isEmpty());
    assertTrue(actualPdComboBox.isCombo());
    assertSame(acroForm, actualPdComboBox.getAcroForm());
    assertSame(defaultValue, actualPdComboBox.getOptions());
    assertSame(defaultValue, actualPdComboBox.getOptionsDisplayValues());
    assertSame(defaultValue, actualPdComboBox.getOptionsExportValues());
    assertSame(defaultValue, actualPdComboBox.getSelectedOptionsIndex());
    assertSame(defaultValue, actualPdComboBox.getValue());
  }

  /**
   * Test {@link PDComboBox#isEdit()}.
   *
   * <p>Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  @DisplayName("Test isEdit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDComboBox.isEdit()"})
  void testIsEdit() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdComboBox.isEdit());
  }

  /**
   * Test {@link PDComboBox#isEdit()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  @DisplayName(
      "Test isEdit(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDComboBox.isEdit()"})
  void testIsEdit_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDComboBox(new PDAcroForm(new PDDocument())).isEdit());
  }

  /**
   * Test {@link PDComboBox#isEdit()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDComboBox#isEdit()}
   */
  @Test
  @DisplayName("Test isEdit(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDComboBox.isEdit()"})
  void testIsEdit_thenReturnTrue() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));
    pdComboBox.setFieldFlags(262144);

    // Act and Assert
    assertTrue(pdComboBox.isEdit());
  }

  /**
   * Test {@link PDComboBox#setEdit(boolean)}.
   *
   * <p>Method under test: {@link PDComboBox#setEdit(boolean)}
   */
  @Test
  @DisplayName("Test setEdit(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComboBox.setEdit(boolean)"})
  void testSetEdit() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act
    pdComboBox.setEdit(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(262144), eq(true));
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isEdit());
  }
}
