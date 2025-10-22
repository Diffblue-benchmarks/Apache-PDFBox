package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceNTableModelDiffblueTest {
  /**
   * Test {@link DeviceNTableModel#getRowCount()}.
   * <p>
   * Method under test: {@link DeviceNTableModel#getRowCount()}
   */
  @Test
  @DisplayName("Test getRowCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DeviceNTableModel.getRowCount()"})
  void testGetRowCount() {
    // Arrange, Act and Assert
    assertEquals(1, (new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getRowCount());
  }

  /**
   * Test {@link DeviceNTableModel#getColumnCount()}.
   * <p>
   * Method under test: {@link DeviceNTableModel#getColumnCount()}
   */
  @Test
  @DisplayName("Test getColumnCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DeviceNTableModel.getColumnCount()"})
  void testGetColumnCount() {
    // Arrange, Act and Assert
    assertEquals(3, (new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getColumnCount());
  }

  /**
   * Test {@link DeviceNTableModel#getValueAt(int, int)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceNTableModel#getValueAt(int, int)}
   */
  @Test
  @DisplayName("Test getValueAt(int, int); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object DeviceNTableModel.getValueAt(int, int)"})
  void testGetValueAt_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getValueAt(0, 0));
  }

  /**
   * Test {@link DeviceNTableModel#getValueAt(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceNTableModel#getValueAt(int, int)}
   */
  @Test
  @DisplayName("Test getValueAt(int, int); when minus one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object DeviceNTableModel.getValueAt(int, int)"})
  void testGetValueAt_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getValueAt(1, -1));
  }

  /**
   * Test {@link DeviceNTableModel#getValueAt(int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceNTableModel#getValueAt(int, int)}
   */
  @Test
  @DisplayName("Test getValueAt(int, int); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object DeviceNTableModel.getValueAt(int, int)"})
  void testGetValueAt_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getValueAt(0, 1));
  }

  /**
   * Test {@link DeviceNTableModel#getValueAt(int, int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceNTableModel#getValueAt(int, int)}
   */
  @Test
  @DisplayName("Test getValueAt(int, int); when two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object DeviceNTableModel.getValueAt(int, int)"})
  void testGetValueAt_whenTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getValueAt(0, 2));
  }

  /**
   * Test {@link DeviceNTableModel#getColumnName(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code Maximum}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceNTableModel#getColumnName(int)}
   */
  @Test
  @DisplayName("Test getColumnName(int); when one; then return 'Maximum'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DeviceNTableModel.getColumnName(int)"})
  void testGetColumnName_whenOne_thenReturnMaximum() {
    // Arrange, Act and Assert
    assertEquals("Maximum", (new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getColumnName(1));
  }

  /**
   * Test {@link DeviceNTableModel#getColumnClass(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceNTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when minus one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class DeviceNTableModel.getColumnClass(int)"})
  void testGetColumnClass_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()})).getColumnClass(-1));
  }

  /**
   * Test {@link DeviceNTableModel#getColumnClass(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link Color}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceNTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when one; then return Color")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class DeviceNTableModel.getColumnClass(int)"})
  void testGetColumnClass_whenOne_thenReturnColor() {
    // Arrange and Act
    Class<?> actualColumnClass = (new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()}))
        .getColumnClass(1);

    // Assert
    Class<Color> expectedColumnClass = Color.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }

  /**
   * Test {@link DeviceNTableModel#getColumnClass(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceNTableModel#getColumnClass(int)}
   */
  @Test
  @DisplayName("Test getColumnClass(int); when zero; then return String")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class DeviceNTableModel.getColumnClass(int)"})
  void testGetColumnClass_whenZero_thenReturnString() {
    // Arrange and Act
    Class<?> actualColumnClass = (new DeviceNTableModel(new DeviceNColorant[]{new DeviceNColorant()}))
        .getColumnClass(0);

    // Assert
    Class<String> expectedColumnClass = String.class;
    assertEquals(expectedColumnClass, actualColumnClass);
  }
}
