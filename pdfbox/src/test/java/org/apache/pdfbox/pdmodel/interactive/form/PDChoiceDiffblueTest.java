package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDChoiceDiffblueTest {
  /**
   * Test {@link PDChoice#getOptions()}.
   *
   * <p>Method under test: {@link PDChoice#getOptions()}
   */
  @Test
  @DisplayName("Test getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getOptions()"})
  void testGetOptions() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertTrue(pdComboBox.getOptions().isEmpty());
  }

  /**
   * Test {@link PDChoice#getOptions()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#getOptions()}
   */
  @Test
  @DisplayName(
      "Test getOptions(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getOptions()"})
  void testGetOptions_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDComboBox(new PDAcroForm(new PDDocument())).getOptions().isEmpty());
  }

  /**
   * Test {@link PDChoice#setOptions(List)} with {@code displayValues}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#getFlag(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List) with 'displayValues'; then calls getFlag(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDChoice.setOptions(List)"})
  void testSetOptionsWithDisplayValues_thenCallsGetFlag() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    when(field.getFlag(Mockito.<COSName>any(), anyInt())).thenReturn(false);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    ArrayList<String> displayValues = new ArrayList<>();
    displayValues.add("foo");

    // Act
    pdComboBox.setOptions(displayValues);

    // Assert that nothing has changed
    verify(field).getFlag(isA(COSName.class), eq(524288));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDChoice#setOptions(List, List)} with {@code exportValues}, {@code displayValues}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#setOptions(List, List)}
   */
  @Test
  @DisplayName(
      "Test setOptions(List, List) with 'exportValues', 'displayValues'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDChoice.setOptions(List, List)"})
  void testSetOptionsWithExportValuesDisplayValues_thenThrowIllegalArgumentException() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    ArrayList<String> exportValues = new ArrayList<>();
    exportValues.add("foo");

    ArrayList<String> displayValues = new ArrayList<>();
    displayValues.add("42");
    displayValues.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdComboBox.setOptions(exportValues, displayValues));
  }

  /**
   * Test {@link PDChoice#getOptionsDisplayValues()}.
   *
   * <p>Method under test: {@link PDChoice#getOptionsDisplayValues()}
   */
  @Test
  @DisplayName("Test getOptionsDisplayValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getOptionsDisplayValues()"})
  void testGetOptionsDisplayValues() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertTrue(pdComboBox.getOptionsDisplayValues().isEmpty());
  }

  /**
   * Test {@link PDChoice#getOptionsDisplayValues()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#getOptionsDisplayValues()}
   */
  @Test
  @DisplayName(
      "Test getOptionsDisplayValues(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getOptionsDisplayValues()"})
  void testGetOptionsDisplayValues_givenPDComboBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertTrue(
        new PDComboBox(new PDAcroForm(new PDDocument())).getOptionsDisplayValues().isEmpty());
  }

  /**
   * Test {@link PDChoice#getOptionsExportValues()}.
   *
   * <p>Method under test: {@link PDChoice#getOptionsExportValues()}
   */
  @Test
  @DisplayName("Test getOptionsExportValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getOptionsExportValues()"})
  void testGetOptionsExportValues() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertTrue(pdComboBox.getOptionsExportValues().isEmpty());
  }

  /**
   * Test {@link PDChoice#getOptionsExportValues()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#getOptionsExportValues()}
   */
  @Test
  @DisplayName(
      "Test getOptionsExportValues(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getOptionsExportValues()"})
  void testGetOptionsExportValues_givenPDComboBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertTrue(new PDComboBox(new PDAcroForm(new PDDocument())).getOptionsExportValues().isEmpty());
  }

  /**
   * Test {@link PDChoice#getSelectedOptionsIndex()}.
   *
   * <p>Method under test: {@link PDChoice#getSelectedOptionsIndex()}
   */
  @Test
  @DisplayName("Test getSelectedOptionsIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getSelectedOptionsIndex()"})
  void testGetSelectedOptionsIndex() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertTrue(pdComboBox.getSelectedOptionsIndex().isEmpty());
  }

  /**
   * Test {@link PDChoice#getSelectedOptionsIndex()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#getSelectedOptionsIndex()}
   */
  @Test
  @DisplayName(
      "Test getSelectedOptionsIndex(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getSelectedOptionsIndex()"})
  void testGetSelectedOptionsIndex_givenPDComboBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertTrue(
        new PDComboBox(new PDAcroForm(new PDDocument())).getSelectedOptionsIndex().isEmpty());
  }

  /**
   * Test {@link PDChoice#setSelectedOptionsIndex(List)}.
   *
   * <ul>
   *   <li>Given {@code 2097152}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 2097152}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#setSelectedOptionsIndex(List)}
   */
  @Test
  @DisplayName(
      "Test setSelectedOptionsIndex(List); given '2097152'; when ArrayList() add '2097152'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDChoice.setSelectedOptionsIndex(List)"})
  void testSetSelectedOptionsIndex_given2097152_whenArrayListAdd2097152() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    ArrayList<Integer> values = new ArrayList<>();
    values.add(2097152);
    values.add(2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setSelectedOptionsIndex(values));
  }

  /**
   * Test {@link PDChoice#setSelectedOptionsIndex(List)}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#setSelectedOptionsIndex(List)}
   */
  @Test
  @DisplayName(
      "Test setSelectedOptionsIndex(List); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDChoice.setSelectedOptionsIndex(List)"})
  void testSetSelectedOptionsIndex_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setSelectedOptionsIndex(values));
  }

  /**
   * Test {@link PDChoice#setSelectedOptionsIndex(List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#setSelectedOptionsIndex(List)}
   */
  @Test
  @DisplayName("Test setSelectedOptionsIndex(List); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDChoice.setSelectedOptionsIndex(List)"})
  void testSetSelectedOptionsIndex_thenThrowIllegalArgumentException() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setSelectedOptionsIndex(values));
  }

  /**
   * Test {@link PDChoice#isSort()}.
   *
   * <p>Method under test: {@link PDChoice#isSort()}
   */
  @Test
  @DisplayName("Test isSort()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isSort()"})
  void testIsSort() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdComboBox.isSort());
  }

  /**
   * Test {@link PDChoice#isSort()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#isSort()}
   */
  @Test
  @DisplayName(
      "Test isSort(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isSort()"})
  void testIsSort_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDComboBox(new PDAcroForm(new PDDocument())).isSort());
  }

  /**
   * Test {@link PDChoice#isSort()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#isSort()}
   */
  @Test
  @DisplayName("Test isSort(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isSort()"})
  void testIsSort_thenReturnTrue() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));
    pdComboBox.setFieldFlags(524288);

    // Act and Assert
    assertTrue(pdComboBox.isSort());
  }

  /**
   * Test {@link PDChoice#setSort(boolean)}.
   *
   * <p>Method under test: {@link PDChoice#setSort(boolean)}
   */
  @Test
  @DisplayName("Test setSort(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDChoice.setSort(boolean)"})
  void testSetSort() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act
    pdComboBox.setSort(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(524288), eq(true));
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isSort());
  }

  /**
   * Test {@link PDChoice#isMultiSelect()}.
   *
   * <p>Method under test: {@link PDChoice#isMultiSelect()}
   */
  @Test
  @DisplayName("Test isMultiSelect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isMultiSelect()"})
  void testIsMultiSelect() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdComboBox.isMultiSelect());
  }

  /**
   * Test {@link PDChoice#isMultiSelect()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#isMultiSelect()}
   */
  @Test
  @DisplayName(
      "Test isMultiSelect(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isMultiSelect()"})
  void testIsMultiSelect_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDComboBox(new PDAcroForm(new PDDocument())).isMultiSelect());
  }

  /**
   * Test {@link PDChoice#isMultiSelect()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#isMultiSelect()}
   */
  @Test
  @DisplayName("Test isMultiSelect(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isMultiSelect()"})
  void testIsMultiSelect_thenReturnTrue() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));
    pdComboBox.setFieldFlags(2097152);

    // Act and Assert
    assertTrue(pdComboBox.isMultiSelect());
  }

  /**
   * Test {@link PDChoice#setMultiSelect(boolean)}.
   *
   * <p>Method under test: {@link PDChoice#setMultiSelect(boolean)}
   */
  @Test
  @DisplayName("Test setMultiSelect(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDChoice.setMultiSelect(boolean)"})
  void testSetMultiSelect() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act
    pdComboBox.setMultiSelect(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(2097152), eq(true));
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isMultiSelect());
  }

  /**
   * Test {@link PDChoice#isDoNotSpellCheck()}.
   *
   * <p>Method under test: {@link PDChoice#isDoNotSpellCheck()}
   */
  @Test
  @DisplayName("Test isDoNotSpellCheck()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isDoNotSpellCheck()"})
  void testIsDoNotSpellCheck() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdComboBox.isDoNotSpellCheck());
  }

  /**
   * Test {@link PDChoice#isDoNotSpellCheck()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#isDoNotSpellCheck()}
   */
  @Test
  @DisplayName(
      "Test isDoNotSpellCheck(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isDoNotSpellCheck()"})
  void testIsDoNotSpellCheck_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDComboBox(new PDAcroForm(new PDDocument())).isDoNotSpellCheck());
  }

  /**
   * Test {@link PDChoice#isDoNotSpellCheck()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#isDoNotSpellCheck()}
   */
  @Test
  @DisplayName("Test isDoNotSpellCheck(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isDoNotSpellCheck()"})
  void testIsDoNotSpellCheck_thenReturnTrue() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));
    pdComboBox.setFieldFlags(4194304);

    // Act and Assert
    assertTrue(pdComboBox.isDoNotSpellCheck());
  }

  /**
   * Test {@link PDChoice#setDoNotSpellCheck(boolean)}.
   *
   * <p>Method under test: {@link PDChoice#setDoNotSpellCheck(boolean)}
   */
  @Test
  @DisplayName("Test setDoNotSpellCheck(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDChoice.setDoNotSpellCheck(boolean)"})
  void testSetDoNotSpellCheck() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act
    pdComboBox.setDoNotSpellCheck(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(4194304), eq(true));
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isDoNotSpellCheck());
  }

  /**
   * Test {@link PDChoice#isCommitOnSelChange()}.
   *
   * <p>Method under test: {@link PDChoice#isCommitOnSelChange()}
   */
  @Test
  @DisplayName("Test isCommitOnSelChange()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isCommitOnSelChange()"})
  void testIsCommitOnSelChange() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdComboBox.isCommitOnSelChange());
  }

  /**
   * Test {@link PDChoice#isCommitOnSelChange()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#isCommitOnSelChange()}
   */
  @Test
  @DisplayName(
      "Test isCommitOnSelChange(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isCommitOnSelChange()"})
  void testIsCommitOnSelChange_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDComboBox(new PDAcroForm(new PDDocument())).isCommitOnSelChange());
  }

  /**
   * Test {@link PDChoice#isCommitOnSelChange()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#isCommitOnSelChange()}
   */
  @Test
  @DisplayName("Test isCommitOnSelChange(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isCommitOnSelChange()"})
  void testIsCommitOnSelChange_thenReturnTrue() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));
    pdComboBox.setFieldFlags(67108864);

    // Act and Assert
    assertTrue(pdComboBox.isCommitOnSelChange());
  }

  /**
   * Test {@link PDChoice#setCommitOnSelChange(boolean)}.
   *
   * <p>Method under test: {@link PDChoice#setCommitOnSelChange(boolean)}
   */
  @Test
  @DisplayName("Test setCommitOnSelChange(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDChoice.setCommitOnSelChange(boolean)"})
  void testSetCommitOnSelChange() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act
    pdComboBox.setCommitOnSelChange(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(67108864), eq(true));
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isCommitOnSelChange());
  }

  /**
   * Test {@link PDChoice#isCombo()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#isCombo()}
   */
  @Test
  @DisplayName(
      "Test isCombo(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isCombo()"})
  void testIsCombo_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PDComboBox(new PDAcroForm(new PDDocument())).isCombo());
  }

  /**
   * Test {@link PDChoice#isCombo()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#isCombo()}
   */
  @Test
  @DisplayName("Test isCombo(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDChoice.isCombo()"})
  void testIsCombo_thenReturnFalse() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdComboBox.isCombo());
  }

  /**
   * Test {@link PDChoice#setCombo(boolean)}.
   *
   * <p>Method under test: {@link PDChoice#setCombo(boolean)}
   */
  @Test
  @DisplayName("Test setCombo(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDChoice.setCombo(boolean)"})
  void testSetCombo() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act
    pdComboBox.setCombo(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(131072), eq(true));
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isCombo());
  }

  /**
   * Test {@link PDChoice#setValue(List)} with {@code values}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#setValue(List)}
   */
  @Test
  @DisplayName("Test setValue(List) with 'values'; given '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDChoice.setValue(List)"})
  void testSetValueWithValues_given42_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    ArrayList<String> values = new ArrayList<>();
    values.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setValue(values));
  }

  /**
   * Test {@link PDChoice#getValue()}.
   *
   * <p>Method under test: {@link PDChoice#getValue()}
   */
  @Test
  @DisplayName("Test getValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getValue()"})
  void testGetValue() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertTrue(pdComboBox.getValue().isEmpty());
  }

  /**
   * Test {@link PDChoice#getValue()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getValue()"})
  void testGetValue_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDComboBox(new PDAcroForm(new PDDocument())).getValue().isEmpty());
  }

  /**
   * Test {@link PDChoice#getDefaultValue()}.
   *
   * <p>Method under test: {@link PDChoice#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getDefaultValue()"})
  void testGetDefaultValue() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertTrue(pdComboBox.getDefaultValue().isEmpty());
  }

  /**
   * Test {@link PDChoice#getDefaultValue()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#getDefaultValue()}
   */
  @Test
  @DisplayName(
      "Test getDefaultValue(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDChoice.getDefaultValue()"})
  void testGetDefaultValue_givenPDComboBoxWithAcroFormIsPDAcroForm_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDComboBox(new PDAcroForm(new PDDocument())).getDefaultValue().isEmpty());
  }

  /**
   * Test {@link PDChoice#getValueAsString()}.
   *
   * <p>Method under test: {@link PDChoice#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDChoice.getValueAsString()"})
  void testGetValueAsString() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDComboBox pdComboBox = new PDComboBox(acroForm, field, parent);

    // Act and Assert
    assertEquals("[]", pdComboBox.getValueAsString());
  }

  /**
   * Test {@link PDChoice#getValueAsString()}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox#PDComboBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDChoice#getValueAsString()}
   */
  @Test
  @DisplayName(
      "Test getValueAsString(); given PDComboBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDChoice.getValueAsString()"})
  void testGetValueAsString_givenPDComboBoxWithAcroFormIsPDAcroForm() {
    // Arrange, Act and Assert
    assertEquals("[]", new PDComboBox(new PDAcroForm(new PDDocument())).getValueAsString());
  }
}
