package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IndexedTableModelDiffblueTest {
  /**
   * Test {@link IndexedTableModel#IndexedTableModel(IndexedColorant[])}.
   *
   * <p>Method under test: {@link IndexedTableModel#IndexedTableModel(IndexedColorant[])}
   */
  @Test
  @DisplayName("Test new IndexedTableModel(IndexedColorant[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndexedTableModel.<init>(IndexedColorant[])"})
  void testNewIndexedTableModel() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    IndexedColorant[] colorants = new IndexedColorant[] {indexedColorant};

    // Act
    IndexedTableModel actualIndexedTableModel = new IndexedTableModel(colorants);

    // Assert
    assertEquals(0, actualIndexedTableModel.getTableModelListeners().length);
    assertEquals(1, actualIndexedTableModel.getRowCount());
    assertEquals(3, actualIndexedTableModel.getColumnCount());
  }

  /**
   * Test {@link IndexedTableModel#getRowCount()}.
   *
   * <p>Method under test: {@link IndexedTableModel#getRowCount()}
   */
  @Test
  @DisplayName("Test getRowCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IndexedTableModel.getRowCount()"})
  void testGetRowCount() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    IndexedColorant[] colorants = new IndexedColorant[] {indexedColorant};
    IndexedTableModel indexedTableModel = new IndexedTableModel(colorants);

    // Act and Assert
    assertEquals(1, indexedTableModel.getRowCount());
  }

  /**
   * Test {@link IndexedTableModel#getColumnCount()}.
   *
   * <p>Method under test: {@link IndexedTableModel#getColumnCount()}
   */
  @Test
  @DisplayName("Test getColumnCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IndexedTableModel.getColumnCount()"})
  void testGetColumnCount() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    IndexedColorant[] colorants = new IndexedColorant[] {indexedColorant};
    IndexedTableModel indexedTableModel = new IndexedTableModel(colorants);

    // Act and Assert
    assertEquals(3, indexedTableModel.getColumnCount());
  }

  /**
   * Test {@link IndexedTableModel#getValueAt(int, int)}.
   *
   * <ul>
   *   <li>Given {@link IndexedColorant} (default constructor) Index is two.
   *   <li>When one.
   *   <li>Then return {@code 2550, 127, 2550, 127}.
   * </ul>
   *
   * <p>Method under test: {@link IndexedTableModel#getValueAt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getValueAt(int, int); given IndexedColorant (default constructor) Index is two; when one; then return '2550, 127, 2550, 127'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object IndexedTableModel.getValueAt(int, int)"})
  void testGetValueAt_givenIndexedColorantIndexIsTwo_whenOne_thenReturn25501272550127() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    IndexedColorant indexedColorant2 = new IndexedColorant();
    indexedColorant2.setIndex(2);
    indexedColorant2.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    IndexedTableModel indexedTableModel =
        new IndexedTableModel(new IndexedColorant[] {indexedColorant, indexedColorant2});

    // Act and Assert
    assertEquals("2550, 127, 2550, 127 ", indexedTableModel.getValueAt(1, 1));
  }

  /**
   * Test {@link IndexedTableModel#getValueAt(int, int)}.
   *
   * <ul>
   *   <li>Given {@link IndexedColorant} (default constructor) Index is two.
   *   <li>When zero.
   *   <li>Then return intValue is two.
   * </ul>
   *
   * <p>Method under test: {@link IndexedTableModel#getValueAt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getValueAt(int, int); given IndexedColorant (default constructor) Index is two; when zero; then return intValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object IndexedTableModel.getValueAt(int, int)"})
  void testGetValueAt_givenIndexedColorantIndexIsTwo_whenZero_thenReturnIntValueIsTwo() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    IndexedColorant indexedColorant2 = new IndexedColorant();
    indexedColorant2.setIndex(2);
    indexedColorant2.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    IndexedTableModel indexedTableModel =
        new IndexedTableModel(new IndexedColorant[] {indexedColorant, indexedColorant2});

    // Act and Assert
    assertEquals(2, ((Integer) indexedTableModel.getValueAt(1, 0)).intValue());
  }

  /**
   * Test {@link IndexedTableModel#getValueAt(int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IndexedTableModel#getValueAt(int, int)}
   */
  @Test
  @DisplayName("Test getValueAt(int, int); when minus one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object IndexedTableModel.getValueAt(int, int)"})
  void testGetValueAt_whenMinusOne_thenReturnNull() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    IndexedColorant[] colorants = new IndexedColorant[] {indexedColorant};
    IndexedTableModel indexedTableModel = new IndexedTableModel(colorants);

    // Act and Assert
    assertNull(indexedTableModel.getValueAt(1, -1));
  }

  /**
   * Test {@link IndexedTableModel#getColumnName(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code RGB value}.
   * </ul>
   *
   * <p>Method under test: {@link IndexedTableModel#getColumnName(int)}
   */
  @Test
  @DisplayName("Test getColumnName(int); when one; then return 'RGB value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexedTableModel.getColumnName(int)"})
  void testGetColumnName_whenOne_thenReturnRgbValue() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    IndexedColorant[] colorants = new IndexedColorant[] {indexedColorant};
    IndexedTableModel indexedTableModel = new IndexedTableModel(colorants);

    // Act and Assert
    assertEquals("RGB value", indexedTableModel.getColumnName(1));
  }

  /**
   * Test {@link IndexedTableModel#getColumnClass(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when minus one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class IndexedTableModel.getColumnClass(int)"})
  void testGetColumnClass_whenMinusOne_thenReturnNull() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    IndexedColorant[] colorants = new IndexedColorant[] {indexedColorant};
    IndexedTableModel indexedTableModel = new IndexedTableModel(colorants);

    // Act and Assert
    assertNull(indexedTableModel.getColumnClass(-1));
  }

  /**
   * Test {@link IndexedTableModel#getColumnClass(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when one; then return String")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class IndexedTableModel.getColumnClass(int)"})
  void testGetColumnClass_whenOne_thenReturnString() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    IndexedColorant[] colorants = new IndexedColorant[] {indexedColorant};
    IndexedTableModel indexedTableModel = new IndexedTableModel(colorants);

    // Act
    Class<?> actualColumnClass = indexedTableModel.getColumnClass(1);

    // Assert
    Class<String> expectedColumnClass = String.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Test {@link IndexedTableModel#getColumnClass(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@link Color}.
   * </ul>
   *
   * <p>Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when two; then return Color")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class IndexedTableModel.getColumnClass(int)"})
  void testGetColumnClass_whenTwo_thenReturnColor() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    IndexedColorant[] colorants = new IndexedColorant[] {indexedColorant};
    IndexedTableModel indexedTableModel = new IndexedTableModel(colorants);

    // Act
    Class<?> actualColumnClass = indexedTableModel.getColumnClass(2);

    // Assert
    Class<Color> expectedColumnClass = Color.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Test {@link IndexedTableModel#getColumnClass(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@link Integer}.
   * </ul>
   *
   * <p>Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when zero; then return Integer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class IndexedTableModel.getColumnClass(int)"})
  void testGetColumnClass_whenZero_thenReturnInteger() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    IndexedColorant[] colorants = new IndexedColorant[] {indexedColorant};
    IndexedTableModel indexedTableModel = new IndexedTableModel(colorants);

    // Act
    Class<?> actualColumnClass = indexedTableModel.getColumnClass(0);

    // Assert
    Class<Integer> expectedColumnClass = Integer.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }
}
