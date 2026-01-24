package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceNTableModelDiffblueTest {
  /**
   * Test {@link DeviceNTableModel#getRowCount()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNTableModel#getRowCount()}
   */
  @Test
  @DisplayName("Test getRowCount(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DeviceNTableModel.getRowCount()"})
  void testGetRowCount_thenReturnZero() {
    // Arrange
    DeviceNTableModel deviceNTableModel = new DeviceNTableModel(new DeviceNColorant[] {});

    // Act and Assert
    assertEquals(0, deviceNTableModel.getRowCount());
  }

  /**
   * Test {@link DeviceNTableModel#getColumnCount()}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNTableModel#getColumnCount()}
   */
  @Test
  @DisplayName("Test getColumnCount(); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DeviceNTableModel.getColumnCount()"})
  void testGetColumnCount_thenReturnThree() {
    // Arrange
    DeviceNTableModel deviceNTableModel = new DeviceNTableModel(new DeviceNColorant[] {});

    // Act and Assert
    assertEquals(3, deviceNTableModel.getColumnCount());
  }

  /**
   * Test {@link DeviceNTableModel#getValueAt(int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNTableModel#getValueAt(int, int)}
   */
  @Test
  @DisplayName("Test getValueAt(int, int); when minus one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object DeviceNTableModel.getValueAt(int, int)"})
  void testGetValueAt_whenMinusOne_thenReturnNull() {
    // Arrange
    DeviceNTableModel deviceNTableModel = new DeviceNTableModel(new DeviceNColorant[] {});

    // Act and Assert
    assertNull(deviceNTableModel.getValueAt(1, -1));
  }

  /**
   * Test {@link DeviceNTableModel#getColumnName(int)}.
   *
   * <ul>
   *   <li>Then return {@code Maximum}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNTableModel#getColumnName(int)}
   */
  @Test
  @DisplayName("Test getColumnName(int); then return 'Maximum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeviceNTableModel.getColumnName(int)"})
  void testGetColumnName_thenReturnMaximum() {
    // Arrange
    DeviceNTableModel deviceNTableModel = new DeviceNTableModel(new DeviceNColorant[] {});

    // Act and Assert
    assertEquals("Maximum", deviceNTableModel.getColumnName(1));
  }

  /**
   * Test {@link DeviceNTableModel#getColumnClass(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when minus one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DeviceNTableModel.getColumnClass(int)"})
  void testGetColumnClass_whenMinusOne_thenReturnNull() {
    // Arrange
    DeviceNTableModel deviceNTableModel = new DeviceNTableModel(new DeviceNColorant[] {});

    // Act and Assert
    assertNull(deviceNTableModel.getColumnClass(-1));
  }

  /**
   * Test {@link DeviceNTableModel#getColumnClass(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link Color}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when one; then return Color")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DeviceNTableModel.getColumnClass(int)"})
  void testGetColumnClass_whenOne_thenReturnColor() {
    // Arrange
    DeviceNTableModel deviceNTableModel = new DeviceNTableModel(new DeviceNColorant[] {});

    // Act
    Class<?> actualColumnClass = deviceNTableModel.getColumnClass(1);

    // Assert
    Class<Color> expectedColumnClass = Color.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Test {@link DeviceNTableModel#getColumnClass(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when zero; then return String")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DeviceNTableModel.getColumnClass(int)"})
  void testGetColumnClass_whenZero_thenReturnString() {
    // Arrange
    DeviceNTableModel deviceNTableModel = new DeviceNTableModel(new DeviceNColorant[] {});

    // Act
    Class<?> actualColumnClass = deviceNTableModel.getColumnClass(0);

    // Assert
    Class<String> expectedColumnClass = String.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }
}
