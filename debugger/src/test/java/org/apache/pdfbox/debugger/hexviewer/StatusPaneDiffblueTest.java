package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatusPaneDiffblueTest {
  /**
   * Test {@link StatusPane#updateStatus(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then second element Text is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusPane#updateStatus(int)}
   */
  @Test
  @DisplayName("Test updateStatus(int); when minus one; then second element Text is '0'")
  void testUpdateStatus_whenMinusOne_thenSecondElementTextIs0() {
    // Arrange
    StatusPane statusPane = new StatusPane();

    // Act
    statusPane.updateStatus(-1);

    // Assert that nothing has changed
    Component[] components = statusPane.getComponents();
    Component component = components[1];
    assertTrue(component instanceof JLabel);
    Component component2 = components[3];
    assertTrue(component2 instanceof JLabel);
    assertEquals("0", ((JLabel) component).getText());
    assertEquals("0", ((JLabel) component2).getText());
    Dimension minimumSize = statusPane.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(167, size.getSize().width);
    assertEquals(167, size.width);
    assertEquals(167, minimumSize.width);
    assertEquals(167.0d, size.getWidth());
    assertEquals(167.0d, minimumSize.getWidth());
    Dimension preferredSize = statusPane.getPreferredSize();
    Dimension size2 = preferredSize.getSize();
    assertEquals(353, size2.getSize().width);
    assertEquals(353, size2.width);
    assertEquals(353, preferredSize.width);
    assertEquals(353.0d, size2.getWidth());
    assertEquals(353.0d, preferredSize.getWidth());
    assertEquals(6, components.length);
  }

  /**
   * Test {@link StatusPane#updateStatus(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then second element Text is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusPane#updateStatus(int)}
   */
  @Test
  @DisplayName("Test updateStatus(int); when one; then second element Text is '1'")
  void testUpdateStatus_whenOne_thenSecondElementTextIs1() {
    // Arrange
    StatusPane statusPane = new StatusPane();

    // Act
    statusPane.updateStatus(1);

    // Assert that nothing has changed
    Component[] components = statusPane.getComponents();
    Component component = components[1];
    assertTrue(component instanceof JLabel);
    Component component2 = components[3];
    assertTrue(component2 instanceof JLabel);
    assertEquals("1", ((JLabel) component).getText());
    assertEquals("2", ((JLabel) component2).getText());
    Dimension minimumSize = statusPane.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(163, size.getSize().width);
    assertEquals(163, size.width);
    assertEquals(163, minimumSize.width);
    assertEquals(163.0d, size.getWidth());
    assertEquals(163.0d, minimumSize.getWidth());
    Dimension preferredSize = statusPane.getPreferredSize();
    Dimension size2 = preferredSize.getSize();
    assertEquals(349, size2.getSize().width);
    assertEquals(349, size2.width);
    assertEquals(349, preferredSize.width);
    assertEquals(349.0d, size2.getWidth());
    assertEquals(349.0d, preferredSize.getWidth());
    assertEquals(6, components.length);
  }
}
