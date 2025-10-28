package org.apache.pdfbox.debugger.treestatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionListener;
import org.junit.jupiter.api.Test;

class TreeStatusPaneDiffblueTest {
  /**
   * Method under test: {@link TreeStatusPane#updateTreeStatus(TreeStatus)}
   */
  @Test
  void testUpdateTreeStatus() {
    // Arrange
    TreeStatusPane treeStatusPane = new TreeStatusPane(new JTree());

    // Act
    treeStatusPane.updateTreeStatus(new TreeStatus("Root Node"));

    // Assert
    JPanel panel = treeStatusPane.getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Component[] components = panel.getComponents();
    Component component = components[0];
    assertTrue(component instanceof JTextField);
    assertTrue(((JTextField) component).getBorder() instanceof BevelBorder);
    assertEquals(1, components.length);
    assertTrue(component.isCursorSet());
    assertTrue(((JTextField) component).isEditable());
    assertEquals(boundsResult, panel.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, panel.getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
  }

  /**
   * Method under test: {@link TreeStatusPane#updateTreeStatus(TreeStatus)}
   */
  @Test
  void testUpdateTreeStatus2() {
    // Arrange
    JTree targetTree = new JTree();
    targetTree.addTreeSelectionListener(mock(TreeSelectionListener.class));
    TreeStatusPane treeStatusPane = new TreeStatusPane(targetTree);

    // Act
    treeStatusPane.updateTreeStatus(new TreeStatus("Root Node"));

    // Assert
    JPanel panel = treeStatusPane.getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Component[] components = panel.getComponents();
    Component component = components[0];
    assertTrue(component instanceof JTextField);
    assertTrue(((JTextField) component).getBorder() instanceof BevelBorder);
    assertEquals(1, components.length);
    assertTrue(component.isCursorSet());
    assertTrue(((JTextField) component).isEditable());
    assertEquals(boundsResult, panel.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, panel.getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
  }
}
