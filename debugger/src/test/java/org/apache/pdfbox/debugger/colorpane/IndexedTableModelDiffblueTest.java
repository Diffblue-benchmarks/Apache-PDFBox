package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexedTableModelDiffblueTest {
  /**
   * Test {@link IndexedTableModel#IndexedTableModel(IndexedColorant[])}.
   * <p>
   * Method under test:
   * {@link IndexedTableModel#IndexedTableModel(IndexedColorant[])}
   */
  @Test
  @DisplayName("Test new IndexedTableModel(IndexedColorant[])")
  void testNewIndexedTableModel() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    IndexedTableModel actualIndexedTableModel = new IndexedTableModel(new IndexedColorant[]{indexedColorant});

    // Assert
    assertEquals(0, actualIndexedTableModel.getTableModelListeners().length);
    assertEquals(1, actualIndexedTableModel.getRowCount());
    assertEquals(3, actualIndexedTableModel.getColumnCount());
  }

  /**
   * Test {@link IndexedTableModel#getRowCount()}.
   * <p>
   * Method under test: {@link IndexedTableModel#getRowCount()}
   */
  @Test
  @DisplayName("Test getRowCount()")
  void testGetRowCount() {
    // Arrange, Act and Assert
    assertEquals(1, (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()})).getRowCount());
  }

  /**
   * Test {@link IndexedTableModel#getColumnCount()}.
   * <p>
   * Method under test: {@link IndexedTableModel#getColumnCount()}
   */
  @Test
  @DisplayName("Test getColumnCount()")
  void testGetColumnCount() {
    // Arrange, Act and Assert
    assertEquals(3, (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()})).getColumnCount());
  }

  /**
   * Test {@link IndexedTableModel#getValueAt(int, int)}.
   * <ul>
   *   <li>Given {@link IndexedColorant} (default constructor) Index is one.</li>
   *   <li>When one.</li>
   *   <li>Then return {@code 2550, 127, 2550, 127}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexedTableModel#getValueAt(int, int)}
   */
  @Test
  @DisplayName("Test getValueAt(int, int); given IndexedColorant (default constructor) Index is one; when one; then return '2550, 127, 2550, 127'")
  void testGetValueAt_givenIndexedColorantIndexIsOne_whenOne_thenReturn25501272550127() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    IndexedColorant indexedColorant2 = new IndexedColorant();
    indexedColorant2.setIndex(2);
    indexedColorant2.setRgbValues(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertEquals("2550, 127, 2550, 127 ",
        (new IndexedTableModel(new IndexedColorant[]{indexedColorant, indexedColorant2})).getValueAt(1, 1));
  }

  /**
   * Test {@link IndexedTableModel#getValueAt(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexedTableModel#getValueAt(int, int)}
   */
  @Test
  @DisplayName("Test getValueAt(int, int); when minus one; then return 'null'")
  void testGetValueAt_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()})).getValueAt(1, -1));
  }

  /**
   * Test {@link IndexedTableModel#getColumnName(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code RGB value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexedTableModel#getColumnName(int)}
   */
  @Test
  @DisplayName("Test getColumnName(int); when one; then return 'RGB value'")
  void testGetColumnName_whenOne_thenReturnRgbValue() {
    // Arrange, Act and Assert
    assertEquals("RGB value", (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()})).getColumnName(1));
  }

  /**
   * Test {@link IndexedTableModel#getColumnClass(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when minus one; then return 'null'")
  void testGetColumnClass_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()})).getColumnClass(-1));
  }

  /**
   * Test {@link IndexedTableModel#getColumnClass(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when one; then return String")
  void testGetColumnClass_whenOne_thenReturnString() {
    // Arrange and Act
    Class<?> actualColumnClass = (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()}))
        .getColumnClass(1);

    // Assert
    Class<String> expectedColumnClass = String.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Test {@link IndexedTableModel#getColumnClass(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@link Color}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when two; then return Color")
  void testGetColumnClass_whenTwo_thenReturnColor() {
    // Arrange and Act
    Class<?> actualColumnClass = (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()}))
        .getColumnClass(2);

    // Assert
    Class<Color> expectedColumnClass = Color.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Test {@link IndexedTableModel#getColumnClass(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@link Integer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when zero; then return Integer")
  void testGetColumnClass_whenZero_thenReturnInteger() {
    // Arrange and Act
    Class<?> actualColumnClass = (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()}))
        .getColumnClass(0);

    // Assert
    Class<Integer> expectedColumnClass = Integer.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }
}
