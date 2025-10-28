package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import java.awt.Color;
import javax.swing.event.TableModelListener;
import org.junit.jupiter.api.Test;

class IndexedTableModelDiffblueTest {
  /**
   * Method under test: {@link IndexedTableModel#getRowCount()}
   */
  @Test
  void testGetRowCount() {
    // Arrange, Act and Assert
    assertEquals(1, (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()})).getRowCount());
  }

  /**
   * Method under test: {@link IndexedTableModel#getRowCount()}
   */
  @Test
  void testGetRowCount2() {
    // Arrange
    IndexedTableModel indexedTableModel = new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()});
    indexedTableModel.addTableModelListener(mock(TableModelListener.class));

    // Act and Assert
    assertEquals(1, indexedTableModel.getRowCount());
  }

  /**
   * Method under test: {@link IndexedTableModel#getColumnCount()}
   */
  @Test
  void testGetColumnCount() {
    // Arrange, Act and Assert
    assertEquals(3, (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()})).getColumnCount());
  }

  /**
   * Method under test: {@link IndexedTableModel#getColumnCount()}
   */
  @Test
  void testGetColumnCount2() {
    // Arrange
    IndexedTableModel indexedTableModel = new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()});
    indexedTableModel.addTableModelListener(mock(TableModelListener.class));

    // Act and Assert
    assertEquals(3, indexedTableModel.getColumnCount());
  }

  /**
   * Method under test: {@link IndexedTableModel#getValueAt(int, int)}
   */
  @Test
  void testGetValueAt() {
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
   * Method under test: {@link IndexedTableModel#getValueAt(int, int)}
   */
  @Test
  void testGetValueAt2() {
    // Arrange, Act and Assert
    assertNull((new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()})).getValueAt(1, -1));
  }

  /**
   * Method under test: {@link IndexedTableModel#getColumnName(int)}
   */
  @Test
  void testGetColumnName() {
    // Arrange, Act and Assert
    assertEquals("RGB value", (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()})).getColumnName(1));
  }

  /**
   * Method under test: {@link IndexedTableModel#getColumnName(int)}
   */
  @Test
  void testGetColumnName2() {
    // Arrange
    IndexedTableModel indexedTableModel = new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()});
    indexedTableModel.addTableModelListener(mock(TableModelListener.class));

    // Act and Assert
    assertEquals("RGB value", indexedTableModel.getColumnName(1));
  }

  /**
   * Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  void testGetColumnClass() {
    // Arrange and Act
    Class<?> actualColumnClass = (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()}))
        .getColumnClass(1);

    // Assert
    Class<String> expectedColumnClass = String.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  void testGetColumnClass2() {
    // Arrange and Act
    Class<?> actualColumnClass = (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()}))
        .getColumnClass(0);

    // Assert
    Class<Integer> expectedColumnClass = Integer.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  void testGetColumnClass3() {
    // Arrange and Act
    Class<?> actualColumnClass = (new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()}))
        .getColumnClass(2);

    // Assert
    Class<Color> expectedColumnClass = Color.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  void testGetColumnClass4() {
    // Arrange
    IndexedTableModel indexedTableModel = new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()});
    indexedTableModel.addTableModelListener(mock(TableModelListener.class));

    // Act
    Class<?> actualColumnClass = indexedTableModel.getColumnClass(1);

    // Assert
    Class<String> expectedColumnClass = String.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Method under test: {@link IndexedTableModel#getColumnClass(int)}
   */
  @Test
  void testGetColumnClass5() {
    // Arrange, Act and Assert
    assertNull((new IndexedTableModel(new IndexedColorant[]{new IndexedColorant()})).getColumnClass(-1));
  }

  /**
   * Method under test:
   * {@link IndexedTableModel#IndexedTableModel(IndexedColorant[])}
   */
  @Test
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
}
