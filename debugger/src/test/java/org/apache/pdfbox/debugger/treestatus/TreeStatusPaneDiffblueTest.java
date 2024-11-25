package org.apache.pdfbox.debugger.treestatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TreeStatusPaneDiffblueTest {
  /**
   * Test {@link TreeStatusPane#updateTreeStatus(TreeStatus)}.
   * <p>
   * Method under test: {@link TreeStatusPane#updateTreeStatus(TreeStatus)}
   */
  @Test
  @DisplayName("Test updateTreeStatus(TreeStatus)")
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
    Rectangle bounds = panel.getBounds();
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle bounds2 = boundsResult.getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    Rectangle bounds3 = bounds.getBounds();
    assertTrue(bounds3.getBounds2D() instanceof Rectangle);
    Rectangle bounds4 = bounds2.getBounds();
    assertTrue(bounds4.getBounds2D() instanceof Rectangle);
    Rectangle bounds5 = bounds3.getBounds();
    assertTrue(bounds5.getBounds2D() instanceof Rectangle);
    Rectangle visibleRect = panel.getVisibleRect();
    Rectangle bounds6 = visibleRect.getBounds();
    assertTrue(bounds6.getBounds2D() instanceof Rectangle);
    assertTrue(visibleRect.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D2.getBounds2D() instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame.getBounds2D() instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds.getFrame();
    assertTrue(frame2.getBounds2D() instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(bounds2.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds4.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds5.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds6.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2D.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2D2.getFrame() instanceof Rectangle2D.Double);
    assertTrue(frame.getFrame() instanceof Rectangle2D.Double);
    assertTrue(frame2.getFrame() instanceof Rectangle2D.Double);
    assertTrue(visibleRect.getFrame() instanceof Rectangle2D.Double);
    Component[] components = panel.getComponents();
    Component component = components[0];
    assertTrue(component instanceof JTextField);
    assertTrue(((JTextField) component).getBorder() instanceof BevelBorder);
    assertEquals(1, components.length);
    assertTrue(component.isCursorSet());
    assertTrue(((JTextField) component).isEditable());
  }
}
