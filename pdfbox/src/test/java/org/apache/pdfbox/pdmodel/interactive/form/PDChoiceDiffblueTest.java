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
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.Test;

class PDChoiceDiffblueTest {
  /**
   * Method under test: {@link PDChoice#getOptions()}
   */
  @Test
  void testGetOptions() {
    // Arrange, Act and Assert
    assertTrue((new PDComboBox(new PDAcroForm(new PDDocument()))).getOptions().isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#getOptions()}
   */
  @Test
  void testGetOptions2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<String> actualOptions = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getOptions();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualOptions.isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#setOptions(List)}
   */
  @Test
  void testSetOptions() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    ArrayList<String> displayValues = new ArrayList<>();
    displayValues.add("foo");

    // Act
    pdComboBox.setOptions(displayValues);

    // Assert
    List<String> options = pdComboBox.getOptions();
    assertEquals(1, options.size());
    assertEquals("foo", options.get(0));
    List<String> optionsDisplayValues = pdComboBox.getOptionsDisplayValues();
    assertEquals(1, optionsDisplayValues.size());
    assertEquals("foo", optionsDisplayValues.get(0));
    List<String> optionsExportValues = pdComboBox.getOptionsExportValues();
    assertEquals(1, optionsExportValues.size());
    assertEquals("foo", optionsExportValues.get(0));
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDChoice#setOptions(List, List)}
   */
  @Test
  void testSetOptions2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<String> exportValues = new ArrayList<>();
    exportValues.add("foo");

    ArrayList<String> displayValues = new ArrayList<>();
    displayValues.add("foo");
    displayValues.add("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setOptions(exportValues, displayValues));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDChoice#setOptions(List, List)}
   */
  @Test
  void testSetOptions3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    ArrayList<String> exportValues = new ArrayList<>();
    exportValues.add("foo");

    ArrayList<String> displayValues = new ArrayList<>();
    displayValues.add("");

    // Act
    pdComboBox.setOptions(exportValues, displayValues);

    // Assert
    List<String> optionsDisplayValues = pdComboBox.getOptionsDisplayValues();
    assertEquals(1, optionsDisplayValues.size());
    assertEquals("", optionsDisplayValues.get(0));
    List<String> options = pdComboBox.getOptions();
    assertEquals(1, options.size());
    assertEquals("foo", options.get(0));
    List<String> optionsExportValues = pdComboBox.getOptionsExportValues();
    assertEquals(1, optionsExportValues.size());
    assertEquals("foo", optionsExportValues.get(0));
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDChoice#getOptionsDisplayValues()}
   */
  @Test
  void testGetOptionsDisplayValues() {
    // Arrange, Act and Assert
    assertTrue((new PDComboBox(new PDAcroForm(new PDDocument()))).getOptionsDisplayValues().isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#getOptionsDisplayValues()}
   */
  @Test
  void testGetOptionsDisplayValues2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<String> actualOptionsDisplayValues = (new PDComboBox(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getOptionsDisplayValues();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualOptionsDisplayValues.isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#getOptionsExportValues()}
   */
  @Test
  void testGetOptionsExportValues() {
    // Arrange, Act and Assert
    assertTrue((new PDComboBox(new PDAcroForm(new PDDocument()))).getOptionsExportValues().isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#getOptionsExportValues()}
   */
  @Test
  void testGetOptionsExportValues2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<String> actualOptionsExportValues = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getOptionsExportValues();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualOptionsExportValues.isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#getSelectedOptionsIndex()}
   */
  @Test
  void testGetSelectedOptionsIndex() {
    // Arrange, Act and Assert
    assertTrue((new PDComboBox(new PDAcroForm(new PDDocument()))).getSelectedOptionsIndex().isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#getSelectedOptionsIndex()}
   */
  @Test
  void testGetSelectedOptionsIndex2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<Integer> actualSelectedOptionsIndex = (new PDComboBox(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getSelectedOptionsIndex();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualSelectedOptionsIndex.isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#setSelectedOptionsIndex(List)}
   */
  @Test
  void testSetSelectedOptionsIndex() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setSelectedOptionsIndex(values));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDChoice#setSelectedOptionsIndex(List)}
   */
  @Test
  void testSetSelectedOptionsIndex2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<Integer> values = new ArrayList<>();
    values.add(2097152);
    values.add(2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setSelectedOptionsIndex(values));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDChoice#setSelectedOptionsIndex(List)}
   */
  @Test
  void testSetSelectedOptionsIndex3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setSelectedOptionsIndex(values));
  }

  /**
   * Method under test: {@link PDChoice#isSort()}
   */
  @Test
  void testIsSort() {
    // Arrange, Act and Assert
    assertFalse((new PDComboBox(new PDAcroForm(new PDDocument()))).isSort());
  }

  /**
   * Method under test: {@link PDChoice#isSort()}
   */
  @Test
  void testIsSort2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsSortResult = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).isSort();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsSortResult);
  }

  /**
   * Method under test: {@link PDChoice#isSort()}
   */
  @Test
  void testIsSort3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse((new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isSort());
  }

  /**
   * Method under test: {@link PDChoice#isSort()}
   */
  @Test
  void testIsSort4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdComboBox.setFieldFlags(524288);

    // Act
    boolean actualIsSortResult = pdComboBox.isSort();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsSortResult);
  }

  /**
   * Method under test: {@link PDChoice#setSort(boolean)}
   */
  @Test
  void testSetSort() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    // Act
    pdComboBox.setSort(true);

    // Assert
    assertEquals(655360, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isSort());
  }

  /**
   * Method under test: {@link PDChoice#setSort(boolean)}
   */
  @Test
  void testSetSort2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setSort(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(655360, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isSort());
  }

  /**
   * Method under test: {@link PDChoice#setSort(boolean)}
   */
  @Test
  void testSetSort3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setSort(true);

    // Assert
    assertEquals(524288, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isSort());
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDChoice#setSort(boolean)}
   */
  @Test
  void testSetSort4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setSort(false);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(131072, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isSort());
  }

  /**
   * Method under test: {@link PDChoice#setSort(boolean)}
   */
  @Test
  void testSetSort5() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setSort(false);

    // Assert
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isSort());
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDChoice#isMultiSelect()}
   */
  @Test
  void testIsMultiSelect() {
    // Arrange, Act and Assert
    assertFalse((new PDComboBox(new PDAcroForm(new PDDocument()))).isMultiSelect());
  }

  /**
   * Method under test: {@link PDChoice#isMultiSelect()}
   */
  @Test
  void testIsMultiSelect2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsMultiSelectResult = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isMultiSelect();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsMultiSelectResult);
  }

  /**
   * Method under test: {@link PDChoice#isMultiSelect()}
   */
  @Test
  void testIsMultiSelect3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse(
        (new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isMultiSelect());
  }

  /**
   * Method under test: {@link PDChoice#isMultiSelect()}
   */
  @Test
  void testIsMultiSelect4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdComboBox.setFieldFlags(2097152);

    // Act
    boolean actualIsMultiSelectResult = pdComboBox.isMultiSelect();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsMultiSelectResult);
  }

  /**
   * Method under test: {@link PDChoice#setMultiSelect(boolean)}
   */
  @Test
  void testSetMultiSelect() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    // Act
    pdComboBox.setMultiSelect(true);

    // Assert
    assertEquals(2228224, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isMultiSelect());
  }

  /**
   * Method under test: {@link PDChoice#setMultiSelect(boolean)}
   */
  @Test
  void testSetMultiSelect2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setMultiSelect(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(2228224, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isMultiSelect());
  }

  /**
   * Method under test: {@link PDChoice#setMultiSelect(boolean)}
   */
  @Test
  void testSetMultiSelect3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setMultiSelect(true);

    // Assert
    assertEquals(2097152, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isMultiSelect());
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDChoice#setMultiSelect(boolean)}
   */
  @Test
  void testSetMultiSelect4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setMultiSelect(false);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(131072, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isMultiSelect());
  }

  /**
   * Method under test: {@link PDChoice#setMultiSelect(boolean)}
   */
  @Test
  void testSetMultiSelect5() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setMultiSelect(false);

    // Assert
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isMultiSelect());
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDChoice#isDoNotSpellCheck()}
   */
  @Test
  void testIsDoNotSpellCheck() {
    // Arrange, Act and Assert
    assertFalse((new PDComboBox(new PDAcroForm(new PDDocument()))).isDoNotSpellCheck());
  }

  /**
   * Method under test: {@link PDChoice#isDoNotSpellCheck()}
   */
  @Test
  void testIsDoNotSpellCheck2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsDoNotSpellCheckResult = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .isDoNotSpellCheck();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsDoNotSpellCheckResult);
  }

  /**
   * Method under test: {@link PDChoice#isDoNotSpellCheck()}
   */
  @Test
  void testIsDoNotSpellCheck3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse((new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .isDoNotSpellCheck());
  }

  /**
   * Method under test: {@link PDChoice#isDoNotSpellCheck()}
   */
  @Test
  void testIsDoNotSpellCheck4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdComboBox.setFieldFlags(4194304);

    // Act
    boolean actualIsDoNotSpellCheckResult = pdComboBox.isDoNotSpellCheck();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsDoNotSpellCheckResult);
  }

  /**
   * Method under test: {@link PDChoice#setDoNotSpellCheck(boolean)}
   */
  @Test
  void testSetDoNotSpellCheck() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    // Act
    pdComboBox.setDoNotSpellCheck(true);

    // Assert
    assertEquals(4325376, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isDoNotSpellCheck());
  }

  /**
   * Method under test: {@link PDChoice#setDoNotSpellCheck(boolean)}
   */
  @Test
  void testSetDoNotSpellCheck2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setDoNotSpellCheck(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(4325376, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isDoNotSpellCheck());
  }

  /**
   * Method under test: {@link PDChoice#setDoNotSpellCheck(boolean)}
   */
  @Test
  void testSetDoNotSpellCheck3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setDoNotSpellCheck(true);

    // Assert
    assertEquals(4194304, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isDoNotSpellCheck());
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDChoice#setDoNotSpellCheck(boolean)}
   */
  @Test
  void testSetDoNotSpellCheck4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setDoNotSpellCheck(false);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(131072, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isDoNotSpellCheck());
  }

  /**
   * Method under test: {@link PDChoice#setDoNotSpellCheck(boolean)}
   */
  @Test
  void testSetDoNotSpellCheck5() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setDoNotSpellCheck(false);

    // Assert
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isDoNotSpellCheck());
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDChoice#isCommitOnSelChange()}
   */
  @Test
  void testIsCommitOnSelChange() {
    // Arrange, Act and Assert
    assertFalse((new PDComboBox(new PDAcroForm(new PDDocument()))).isCommitOnSelChange());
  }

  /**
   * Method under test: {@link PDChoice#isCommitOnSelChange()}
   */
  @Test
  void testIsCommitOnSelChange2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsCommitOnSelChangeResult = (new PDComboBox(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).isCommitOnSelChange();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsCommitOnSelChangeResult);
  }

  /**
   * Method under test: {@link PDChoice#isCommitOnSelChange()}
   */
  @Test
  void testIsCommitOnSelChange3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse((new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .isCommitOnSelChange());
  }

  /**
   * Method under test: {@link PDChoice#isCommitOnSelChange()}
   */
  @Test
  void testIsCommitOnSelChange4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdComboBox.setFieldFlags(67108864);

    // Act
    boolean actualIsCommitOnSelChangeResult = pdComboBox.isCommitOnSelChange();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsCommitOnSelChangeResult);
  }

  /**
   * Method under test: {@link PDChoice#setCommitOnSelChange(boolean)}
   */
  @Test
  void testSetCommitOnSelChange() {
    // Arrange
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument()));

    // Act
    pdComboBox.setCommitOnSelChange(true);

    // Assert
    assertEquals(67239936, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isCommitOnSelChange());
  }

  /**
   * Method under test: {@link PDChoice#setCommitOnSelChange(boolean)}
   */
  @Test
  void testSetCommitOnSelChange2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setCommitOnSelChange(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(67239936, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isCommitOnSelChange());
  }

  /**
   * Method under test: {@link PDChoice#setCommitOnSelChange(boolean)}
   */
  @Test
  void testSetCommitOnSelChange3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setCommitOnSelChange(true);

    // Assert
    assertEquals(67108864, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isCommitOnSelChange());
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDChoice#setCommitOnSelChange(boolean)}
   */
  @Test
  void testSetCommitOnSelChange4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setCommitOnSelChange(false);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(131072, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isCommitOnSelChange());
  }

  /**
   * Method under test: {@link PDChoice#setCommitOnSelChange(boolean)}
   */
  @Test
  void testSetCommitOnSelChange5() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setCommitOnSelChange(false);

    // Assert
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isCommitOnSelChange());
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDChoice#isCombo()}
   */
  @Test
  void testIsCombo() {
    // Arrange, Act and Assert
    assertTrue((new PDComboBox(new PDAcroForm(new PDDocument()))).isCombo());
  }

  /**
   * Method under test: {@link PDChoice#isCombo()}
   */
  @Test
  void testIsCombo2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsComboResult = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).isCombo();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualIsComboResult);
  }

  /**
   * Method under test: {@link PDChoice#isCombo()}
   */
  @Test
  void testIsCombo3() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse((new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())))).isCombo());
  }

  /**
   * Method under test: {@link PDChoice#setCombo(boolean)}
   */
  @Test
  void testSetCombo() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setCombo(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(131072, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isCombo());
  }

  /**
   * Method under test: {@link PDChoice#setCombo(boolean)}
   */
  @Test
  void testSetCombo2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdComboBox.setCombo(true);

    // Assert
    assertEquals(131072, pdComboBox.getFieldFlags());
    assertTrue(pdComboBox.isCombo());
    assertSame(field, pdComboBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDChoice#setCombo(boolean)}
   */
  @Test
  void testSetCombo3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdComboBox.setCombo(false);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, pdComboBox.getFieldFlags());
    assertFalse(pdComboBox.isCombo());
  }

  /**
   * Method under test: {@link PDChoice#setValue(String)}
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

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    List<String> value = pdComboBox.getValue();
    assertEquals(1, value.size());
    assertEquals("42", value.get(0));
    assertEquals("[42]", pdComboBox.getValueAsString());
    COSDictionary cOSObject = pdComboBox.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDChoice#setValue(String)}
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

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    List<String> value = pdComboBox.getValue();
    assertEquals(1, value.size());
    assertEquals("42", value.get(0));
    assertEquals("[42]", pdComboBox.getValueAsString());
    COSDictionary cOSObject = pdComboBox.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDChoice#setValue(String)}
   */
  @Test
  void testSetValue3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("org.apache.logging.log4j.util.StackLocator");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    List<String> value = pdComboBox.getValue();
    assertEquals(1, value.size());
    assertEquals("42", value.get(0));
    assertEquals("[42]", pdComboBox.getValueAsString());
    COSDictionary cOSObject = pdComboBox.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDChoice#setValue(String)}
   */
  @Test
  void testSetValue4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.setValue((String) null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("[]", pdComboBox.getValueAsString());
    COSDictionary cOSObject = pdComboBox.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDChoice#setValue(String)}
   */
  @Test
  void testSetValue5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.setValue("");

    // Assert
    verify(streamCacheCreateFunction).create();
    List<String> value = pdComboBox.getValue();
    assertEquals(1, value.size());
    assertEquals("", value.get(0));
    assertEquals("[]", pdComboBox.getValueAsString());
    COSDictionary cOSObject = pdComboBox.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDChoice#setValue(String)}
   */
  @Test
  void testSetValue6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.setPartialName("Annot");
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.setValue("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    List<String> value = pdComboBox.getValue();
    assertEquals(1, value.size());
    assertEquals("42", value.get(0));
    assertEquals("[42]", pdComboBox.getValueAsString());
    COSDictionary cOSObject = pdComboBox.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
  }

  /**
   * Method under test: {@link PDChoice#setValue(List)}
   */
  @Test
  void testSetValue7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<String> values = new ArrayList<>();
    values.add("/DA is a required entry. Please set a default appearance first.");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setValue(values));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDChoice#setValue(List)}
   */
  @Test
  void testSetValue8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<String> values = new ArrayList<>();
    values.add("foo");
    values.add("/DA is a required entry. Please set a default appearance first.");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setValue(values));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDChoice#setValue(List)}
   */
  @Test
  void testSetValue9() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDComboBox pdComboBox = new PDComboBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    ArrayList<String> values = new ArrayList<>();
    values.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setValue(values));
  }

  /**
   * Method under test: {@link PDChoice#setValue(List)}
   */
  @Test
  void testSetValue10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDComboBox pdComboBox = new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    pdComboBox.setFieldFlags(2097152);

    ArrayList<String> values = new ArrayList<>();
    values.add("/DA is a required entry. Please set a default appearance first.");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdComboBox.setValue(values));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDChoice#setValue(List)}
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

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.setValue(new ArrayList<>());

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDChoice#setValue(List)}
   */
  @Test
  void testSetValue12() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("Annot");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox pdComboBox = new PDComboBox(acroForm);
    pdComboBox.importFDF(new FDFField());

    // Act
    pdComboBox.setValue(new ArrayList<>());

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDChoice#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertTrue((new PDComboBox(new PDAcroForm(new PDDocument()))).getValue().isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#getValue()}
   */
  @Test
  void testGetValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<String> actualValue = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).getValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualValue.isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue() {
    // Arrange, Act and Assert
    assertTrue((new PDComboBox(new PDAcroForm(new PDDocument()))).getDefaultValue().isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<String> actualDefaultValue = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getDefaultValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualDefaultValue.isEmpty());
  }

  /**
   * Method under test: {@link PDChoice#getValueAsString()}
   */
  @Test
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("[]", (new PDComboBox(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Method under test: {@link PDChoice#getValueAsString()}
   */
  @Test
  void testGetValueAsString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualValueAsString = (new PDComboBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getValueAsString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("[]", actualValueAsString);
  }
}
