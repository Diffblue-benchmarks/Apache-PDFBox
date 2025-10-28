package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.UnsupportedEncodingException;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.junit.jupiter.api.Test;

class HexViewDiffblueTest {
  /**
   * Method under test: {@link HexView#changeData(byte[])}
   */
  @Test
  void testChangeData() throws UnsupportedEncodingException {
    // Arrange
    HexView hexView = new HexView();

    // Act
    hexView.changeData("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    JComponent pane = hexView.getPane();
    Component[] components = pane.getComponents();
    Component component = components[0];
    LayoutManager layout = ((HexEditor) component).getLayout();
    assertTrue(layout instanceof GridBagLayout);
    Rectangle boundsResult = pane.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(pane instanceof JPanel);
    Component[] components2 = ((HexEditor) component).getComponents();
    assertTrue(components2[1] instanceof JScrollPane);
    assertTrue(component instanceof HexEditor);
    assertTrue(components2[2] instanceof StatusPane);
    assertTrue(components2[0] instanceof UpperPane);
    assertEquals("PanelUI", ((HexEditor) component).getUIClassID());
    assertNull(((GridBagLayout) layout).columnWeights);
    assertNull(((GridBagLayout) layout).rowWeights);
    assertNull(((GridBagLayout) layout).columnWidths);
    assertNull(((GridBagLayout) layout).rowHeights);
    assertNull(((HexEditor) component).getNextFocusableComponent());
    assertNull(component.getFocusCycleRootAncestor());
    assertNull(((HexEditor) component).getTopLevelAncestor());
    assertNull(((HexEditor) component).getFocusTraversalPolicy());
    assertNull(component.getGraphics());
    assertNull(component.getGraphicsConfiguration());
    assertNull(component.getDropTarget());
    assertNull(component.getInputContext());
    assertNull(component.getInputMethodRequests());
    assertNull(component.getName());
    assertNull(((HexEditor) component).getToolTipText());
    assertNull(((HexEditor) component).getInputVerifier());
    assertNull(((HexEditor) component).getComponentPopupMenu());
    assertNull(((HexEditor) component).getRootPane());
    assertNull(((HexEditor) component).getTransferHandler());
    assertNull(((HexEditor) component).getBorder());
    assertEquals(0, component.getHeight());
    assertEquals(0, component.getWidth());
    assertEquals(0, component.getX());
    assertEquals(0, component.getY());
    assertEquals(0, ((HexEditor) component).getDebugGraphicsOptions());
    assertEquals(0, component.getComponentListeners().length);
    assertEquals(0, component.getFocusListeners().length);
    assertEquals(0, component.getHierarchyBoundsListeners().length);
    assertEquals(0, component.getHierarchyListeners().length);
    assertEquals(0, component.getInputMethodListeners().length);
    assertEquals(0, component.getKeyListeners().length);
    assertEquals(0, component.getMouseListeners().length);
    assertEquals(0, component.getMouseMotionListeners().length);
    assertEquals(0, component.getMouseWheelListeners().length);
    assertEquals(0, component.getPropertyChangeListeners().length);
    assertEquals(0, ((HexEditor) component).getContainerListeners().length);
    assertEquals(0, ((HexEditor) component).getAncestorListeners().length);
    assertEquals(0, ((HexEditor) component).getVetoableChangeListeners().length);
    assertEquals(0.5f, component.getAlignmentX());
    assertEquals(0.5f, component.getAlignmentY());
    assertEquals(1, pane.getComponentCount());
    assertEquals(1, components.length);
    assertEquals(1, ((HexEditor) component).getRegisteredKeyStrokes().length);
    Dimension minimumSize = pane.getMinimumSize();
    assertEquals(170, minimumSize.width);
    assertEquals(170.0d, minimumSize.getWidth());
    assertEquals(3, ((HexEditor) component).getComponentCount());
    assertEquals(3, components2.length);
    assertEquals(59, minimumSize.height);
    assertEquals(59.0d, minimumSize.getHeight());
    Dimension preferredSize = pane.getPreferredSize();
    assertEquals(92, preferredSize.height);
    assertEquals(92.0d, preferredSize.getHeight());
    assertEquals(992, preferredSize.width);
    assertEquals(992.0d, preferredSize.getWidth());
    assertEquals(Component.BaselineResizeBehavior.OTHER, component.getBaselineResizeBehavior());
    assertFalse(component.getIgnoreRepaint());
    assertFalse(component.hasFocus());
    assertFalse(component.isCursorSet());
    assertFalse(component.isDisplayable());
    assertFalse(component.isFocusOwner());
    assertFalse(component.isLightweight());
    assertFalse(component.isMaximumSizeSet());
    assertFalse(component.isMinimumSizeSet());
    assertFalse(component.isPreferredSizeSet());
    assertFalse(component.isShowing());
    assertFalse(component.isValid());
    assertFalse(((HexEditor) component).isFocusCycleRoot());
    assertFalse(((HexEditor) component).isFocusTraversalPolicyProvider());
    assertFalse(((HexEditor) component).isFocusTraversalPolicySet());
    assertFalse(((HexEditor) component).getAutoscrolls());
    assertFalse(((HexEditor) component).getInheritsPopupMenu());
    assertFalse(((HexEditor) component).isManagingFocus());
    assertFalse(((HexEditor) component).isPaintingForPrint());
    assertFalse(((HexEditor) component).isPaintingTile());
    assertFalse(((HexEditor) component).isValidateRoot());
    assertTrue(component.getFocusTraversalKeysEnabled());
    assertTrue(component.isBackgroundSet());
    assertTrue(component.isDoubleBuffered());
    assertTrue(component.isEnabled());
    assertTrue(component.isFocusable());
    assertTrue(component.isFontSet());
    assertTrue(component.isForegroundSet());
    assertTrue(component.isOpaque());
    assertTrue(component.isVisible());
    assertTrue(((HexEditor) component).getVerifyInputWhenFocusTarget());
    assertTrue(((HexEditor) component).isOptimizedDrawingEnabled());
    assertTrue(((HexEditor) component).isRequestFocusEnabled());
    assertEquals(boundsResult, component.bounds());
    assertEquals(boundsResult, pane.getBounds());
    assertEquals(boundsResult, component.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, pane.getVisibleRect());
    assertEquals(boundsResult, ((HexEditor) component).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Dimension size = pane.getSize();
    assertEquals(size, component.getSize());
    assertEquals(size, pane.size());
    assertEquals(size, component.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    assertEquals(minimumSize, component.getMinimumSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(preferredSize, component.getPreferredSize());
    assertEquals(preferredSize, preferredSize.getSize());
    assertSame(pane, component.getParent());
  }

  /**
   * Method under test: {@link HexView#changeData(byte[])}
   */
  @Test
  void testChangeData2() {
    // Arrange
    HexView hexView = new HexView();

    // Act
    hexView.changeData(new byte[]{});

    // Assert
    JComponent pane = hexView.getPane();
    Component[] components = pane.getComponents();
    Component component = components[0];
    LayoutManager layout = ((HexEditor) component).getLayout();
    assertTrue(layout instanceof GridBagLayout);
    Rectangle boundsResult = pane.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(pane instanceof JPanel);
    Component[] components2 = ((HexEditor) component).getComponents();
    assertTrue(components2[1] instanceof JScrollPane);
    assertTrue(component instanceof HexEditor);
    assertTrue(components2[2] instanceof StatusPane);
    assertTrue(components2[0] instanceof UpperPane);
    assertEquals("PanelUI", ((HexEditor) component).getUIClassID());
    assertNull(((GridBagLayout) layout).columnWeights);
    assertNull(((GridBagLayout) layout).rowWeights);
    assertNull(((GridBagLayout) layout).columnWidths);
    assertNull(((GridBagLayout) layout).rowHeights);
    assertNull(((HexEditor) component).getNextFocusableComponent());
    assertNull(component.getFocusCycleRootAncestor());
    assertNull(((HexEditor) component).getTopLevelAncestor());
    assertNull(((HexEditor) component).getFocusTraversalPolicy());
    assertNull(component.getGraphics());
    assertNull(component.getGraphicsConfiguration());
    assertNull(component.getDropTarget());
    assertNull(component.getInputContext());
    assertNull(component.getInputMethodRequests());
    assertNull(component.getName());
    assertNull(((HexEditor) component).getToolTipText());
    assertNull(((HexEditor) component).getInputVerifier());
    assertNull(((HexEditor) component).getComponentPopupMenu());
    assertNull(((HexEditor) component).getRootPane());
    assertNull(((HexEditor) component).getTransferHandler());
    assertNull(((HexEditor) component).getBorder());
    assertEquals(0, component.getHeight());
    assertEquals(0, component.getWidth());
    assertEquals(0, component.getX());
    assertEquals(0, component.getY());
    assertEquals(0, ((HexEditor) component).getDebugGraphicsOptions());
    assertEquals(0, component.getComponentListeners().length);
    assertEquals(0, component.getFocusListeners().length);
    assertEquals(0, component.getHierarchyBoundsListeners().length);
    assertEquals(0, component.getHierarchyListeners().length);
    assertEquals(0, component.getInputMethodListeners().length);
    assertEquals(0, component.getKeyListeners().length);
    assertEquals(0, component.getMouseListeners().length);
    assertEquals(0, component.getMouseMotionListeners().length);
    assertEquals(0, component.getMouseWheelListeners().length);
    assertEquals(0, component.getPropertyChangeListeners().length);
    assertEquals(0, ((HexEditor) component).getContainerListeners().length);
    assertEquals(0, ((HexEditor) component).getAncestorListeners().length);
    assertEquals(0, ((HexEditor) component).getVetoableChangeListeners().length);
    assertEquals(0.5f, component.getAlignmentX());
    assertEquals(0.5f, component.getAlignmentY());
    assertEquals(1, pane.getComponentCount());
    assertEquals(1, components.length);
    assertEquals(1, ((HexEditor) component).getRegisteredKeyStrokes().length);
    Dimension minimumSize = pane.getMinimumSize();
    assertEquals(170, minimumSize.width);
    assertEquals(170.0d, minimumSize.getWidth());
    assertEquals(3, ((HexEditor) component).getComponentCount());
    assertEquals(3, components2.length);
    assertEquals(59, minimumSize.height);
    assertEquals(59.0d, minimumSize.getHeight());
    Dimension preferredSize = pane.getPreferredSize();
    assertEquals(72, preferredSize.height);
    assertEquals(72.0d, preferredSize.getHeight());
    assertEquals(992, preferredSize.width);
    assertEquals(992.0d, preferredSize.getWidth());
    assertEquals(Component.BaselineResizeBehavior.OTHER, component.getBaselineResizeBehavior());
    assertFalse(component.getIgnoreRepaint());
    assertFalse(component.hasFocus());
    assertFalse(component.isCursorSet());
    assertFalse(component.isDisplayable());
    assertFalse(component.isFocusOwner());
    assertFalse(component.isLightweight());
    assertFalse(component.isMaximumSizeSet());
    assertFalse(component.isMinimumSizeSet());
    assertFalse(component.isPreferredSizeSet());
    assertFalse(component.isShowing());
    assertFalse(component.isValid());
    assertFalse(((HexEditor) component).isFocusCycleRoot());
    assertFalse(((HexEditor) component).isFocusTraversalPolicyProvider());
    assertFalse(((HexEditor) component).isFocusTraversalPolicySet());
    assertFalse(((HexEditor) component).getAutoscrolls());
    assertFalse(((HexEditor) component).getInheritsPopupMenu());
    assertFalse(((HexEditor) component).isManagingFocus());
    assertFalse(((HexEditor) component).isPaintingForPrint());
    assertFalse(((HexEditor) component).isPaintingTile());
    assertFalse(((HexEditor) component).isValidateRoot());
    assertTrue(component.getFocusTraversalKeysEnabled());
    assertTrue(component.isBackgroundSet());
    assertTrue(component.isDoubleBuffered());
    assertTrue(component.isEnabled());
    assertTrue(component.isFocusable());
    assertTrue(component.isFontSet());
    assertTrue(component.isForegroundSet());
    assertTrue(component.isOpaque());
    assertTrue(component.isVisible());
    assertTrue(((HexEditor) component).getVerifyInputWhenFocusTarget());
    assertTrue(((HexEditor) component).isOptimizedDrawingEnabled());
    assertTrue(((HexEditor) component).isRequestFocusEnabled());
    assertEquals(boundsResult, component.bounds());
    assertEquals(boundsResult, pane.getBounds());
    assertEquals(boundsResult, component.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, pane.getVisibleRect());
    assertEquals(boundsResult, ((HexEditor) component).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Dimension size = pane.getSize();
    assertEquals(size, component.getSize());
    assertEquals(size, pane.size());
    assertEquals(size, component.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    assertEquals(minimumSize, component.getMinimumSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(preferredSize, component.getPreferredSize());
    assertEquals(preferredSize, preferredSize.getSize());
    assertSame(pane, component.getParent());
  }

  /**
   * Method under test: {@link HexView#getPane()}
   */
  @Test
  void testGetPane() {
    // Arrange, Act and Assert
    assertTrue((new HexView()).getPane() instanceof JPanel);
  }
}
