package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.Component;
import java.awt.Dimension;
import java.beans.VetoableChangeListener;
import javax.swing.JLabel;
import org.junit.jupiter.api.Test;

class StatusPaneDiffblueTest {
  /**
   * Method under test: {@link StatusPane#updateStatus(int)}
   */
  @Test
  void testUpdateStatus() {
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
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(15, maximumSize.height);
    Dimension minimumSize = statusPane.getMinimumSize();
    assertEquals(194, minimumSize.width);
    assertEquals(194.0d, minimumSize.getWidth());
    Dimension preferredSize = statusPane.getPreferredSize();
    assertEquals(378, preferredSize.width);
    assertEquals(378.0d, preferredSize.getWidth());
    assertEquals(6, components.length);
    assertEquals(8, maximumSize.width);
    assertEquals(maximumSize, component2.getMaximumSize());
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component2.getMinimumSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
  }

  /**
   * Method under test: {@link StatusPane#updateStatus(int)}
   */
  @Test
  void testUpdateStatus2() {
    // Arrange
    StatusPane statusPane = new StatusPane();
    statusPane.addVetoableChangeListener(mock(VetoableChangeListener.class));

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
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(15, maximumSize.height);
    Dimension minimumSize = statusPane.getMinimumSize();
    assertEquals(194, minimumSize.width);
    assertEquals(194.0d, minimumSize.getWidth());
    Dimension preferredSize = statusPane.getPreferredSize();
    assertEquals(378, preferredSize.width);
    assertEquals(378.0d, preferredSize.getWidth());
    assertEquals(6, components.length);
    assertEquals(8, maximumSize.width);
    assertEquals(maximumSize, component2.getMaximumSize());
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component2.getMinimumSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
  }
}
