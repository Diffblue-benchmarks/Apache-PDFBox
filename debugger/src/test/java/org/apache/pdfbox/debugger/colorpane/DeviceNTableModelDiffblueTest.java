package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import java.awt.Color;
import javax.swing.event.TableModelListener;
import org.junit.jupiter.api.Test;

class DeviceNTableModelDiffblueTest {
  /**
   * Method under test: {@link DeviceNTableModel#getRowCount()}
   */
  @Test
  void testGetRowCount() {
    // Arrange, Act and Assert
    assertEquals(1, (new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getRowCount());
  }

  /**
   * Method under test: {@link DeviceNTableModel#getRowCount()}
   */
  @Test
  void testGetRowCount2() {
    // Arrange
    DeviceNTableModel deviceNTableModel = new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()});
    deviceNTableModel.addTableModelListener(mock(TableModelListener.class));

    // Act and Assert
    assertEquals(1, deviceNTableModel.getRowCount());
  }

  /**
   * Method under test: {@link DeviceNTableModel#getColumnCount()}
   */
  @Test
  void testGetColumnCount() {
    // Arrange, Act and Assert
    assertEquals(3, (new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getColumnCount());
  }

  /**
   * Method under test: {@link DeviceNTableModel#getColumnCount()}
   */
  @Test
  void testGetColumnCount2() {
    // Arrange
    DeviceNTableModel deviceNTableModel = new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()});
    deviceNTableModel.addTableModelListener(mock(TableModelListener.class));

    // Act and Assert
    assertEquals(3, deviceNTableModel.getColumnCount());
  }

  /**
   * Method under test: {@link DeviceNTableModel#getValueAt(int, int)}
   */
  @Test
  void testGetValueAt() {
    // Arrange, Act and Assert
    assertNull((new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getValueAt(0, 1));
    assertNull((new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getValueAt(1, -1));
    assertNull((new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getValueAt(0, 2));
    assertNull((new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getValueAt(0, 0));
  }

  /**
   * Method under test: {@link DeviceNTableModel#getColumnName(int)}
   */
  @Test
  void testGetColumnName() {
    // Arrange, Act and Assert
    assertEquals("Maximum", (new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getColumnName(1));
  }

  /**
   * Method under test: {@link DeviceNTableModel#getColumnName(int)}
   */
  @Test
  void testGetColumnName2() {
    // Arrange
    DeviceNTableModel deviceNTableModel = new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()});
    deviceNTableModel.addTableModelListener(mock(TableModelListener.class));

    // Act and Assert
    assertEquals("Maximum", deviceNTableModel.getColumnName(1));
  }

  /**
   * Method under test: {@link DeviceNTableModel#getColumnClass(int)}
   */
  @Test
  void testGetColumnClass() {
    // Arrange and Act
    Class<?> actualColumnClass = (new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()}))
        .getColumnClass(1);

    // Assert
    Class<Color> expectedColumnClass = Color.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Method under test: {@link DeviceNTableModel#getColumnClass(int)}
   */
  @Test
  void testGetColumnClass2() {
    // Arrange and Act
    Class<?> actualColumnClass = (new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()}))
        .getColumnClass(0);

    // Assert
    Class<String> expectedColumnClass = String.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Method under test: {@link DeviceNTableModel#getColumnClass(int)}
   */
  @Test
  void testGetColumnClass3() {
    // Arrange
    DeviceNTableModel deviceNTableModel = new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()});
    deviceNTableModel.addTableModelListener(mock(TableModelListener.class));

    // Act
    Class<?> actualColumnClass = deviceNTableModel.getColumnClass(1);

    // Assert
    Class<Color> expectedColumnClass = Color.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Method under test: {@link DeviceNTableModel#getColumnClass(int)}
   */
  @Test
  void testGetColumnClass4() {
    // Arrange, Act and Assert
    assertNull((new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getColumnClass(-1));
  }
}
