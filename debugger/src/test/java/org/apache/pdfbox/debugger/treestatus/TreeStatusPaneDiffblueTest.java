package org.apache.pdfbox.debugger.treestatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.image.DirectColorModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TreeStatusPaneDiffblueTest {
  @Mock private JTree jTree;

  @Mock private TreeStatus treeStatus;

  @InjectMocks private TreeStatusPane treeStatusPane;

  /**
   * Test {@link TreeStatusPane#TreeStatusPane(JTree)}.
   *
   * <p>Method under test: {@link TreeStatusPane#TreeStatusPane(JTree)}
   */
  @Test
  @DisplayName("Test new TreeStatusPane(JTree)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TreeStatusPane.<init>(JTree)"})
  void testNewTreeStatusPane() {
    // Arrange, Act and Assert
    JPanel panel = new TreeStatusPane(new JTree()).getPanel();
    assertTrue(panel.getLayout() instanceof BorderLayout);
    assertTrue(panel.getColorModel() instanceof DirectColorModel);
    assertEquals("PanelUI", panel.getUIClassID());
    assertNull(panel.getNextFocusableComponent());
    assertNull(panel.getFocusCycleRootAncestor());
    assertNull(panel.getParent());
    assertNull(panel.getTopLevelAncestor());
    assertNull(panel.getFocusTraversalPolicy());
    assertNull(panel.getGraphics());
    assertNull(panel.getGraphicsConfiguration());
    assertNull(panel.getDropTarget());
    assertNull(panel.getInputContext());
    assertNull(panel.getInputMethodRequests());
    assertNull(panel.getName());
    assertNull(panel.getToolTipText());
    assertNull(panel.getInputVerifier());
    assertNull(panel.getComponentPopupMenu());
    assertNull(panel.getRootPane());
    assertNull(panel.getTransferHandler());
    assertNull(panel.getBorder());
    assertEquals(0, panel.getDebugGraphicsOptions());
    assertEquals(0, panel.getHeight());
    assertEquals(0, panel.getWidth());
    assertEquals(0, panel.getX());
    assertEquals(0, panel.getY());
    assertEquals(0, panel.getComponentListeners().length);
    assertEquals(0, panel.getFocusListeners().length);
    assertEquals(0, panel.getHierarchyBoundsListeners().length);
    assertEquals(0, panel.getHierarchyListeners().length);
    assertEquals(0, panel.getInputMethodListeners().length);
    assertEquals(0, panel.getKeyListeners().length);
    assertEquals(0, panel.getMouseListeners().length);
    assertEquals(0, panel.getMouseMotionListeners().length);
    assertEquals(0, panel.getMouseWheelListeners().length);
    assertEquals(0, panel.getPropertyChangeListeners().length);
    assertEquals(0, panel.getContainerListeners().length);
    assertEquals(0, panel.getAncestorListeners().length);
    assertEquals(0, panel.getRegisteredKeyStrokes().length);
    assertEquals(0, panel.getVetoableChangeListeners().length);
    assertEquals(0.5f, panel.getAlignmentX());
    assertEquals(0.5f, panel.getAlignmentY());
    assertEquals(1, panel.getComponentCount());
    assertEquals(1, panel.getComponents().length);
    assertEquals(BaselineResizeBehavior.OTHER, panel.getBaselineResizeBehavior());
    assertFalse(panel.getIgnoreRepaint());
    assertFalse(panel.hasFocus());
    assertFalse(panel.isCursorSet());
    assertFalse(panel.isDisplayable());
    assertFalse(panel.isFocusOwner());
    assertFalse(panel.isLightweight());
    assertFalse(panel.isMaximumSizeSet());
    assertFalse(panel.isMinimumSizeSet());
    assertFalse(panel.isPreferredSizeSet());
    assertFalse(panel.isShowing());
    assertFalse(panel.isValid());
    assertFalse(panel.isFocusCycleRoot());
    assertFalse(panel.isFocusTraversalPolicyProvider());
    assertFalse(panel.isFocusTraversalPolicySet());
    assertFalse(panel.getAutoscrolls());
    assertFalse(panel.getInheritsPopupMenu());
    assertFalse(panel.isManagingFocus());
    assertFalse(panel.isPaintingForPrint());
    assertFalse(panel.isPaintingTile());
    assertFalse(panel.isValidateRoot());
    assertTrue(panel.getFocusTraversalKeysEnabled());
    assertTrue(panel.isBackgroundSet());
    assertTrue(panel.isEnabled());
    assertTrue(panel.isFocusable());
    assertTrue(panel.isFontSet());
    assertTrue(panel.isForegroundSet());
    assertTrue(panel.isVisible());
    assertTrue(panel.getVerifyInputWhenFocusTarget());
    assertTrue(panel.isDoubleBuffered());
    assertTrue(panel.isOpaque());
    assertTrue(panel.isOptimizedDrawingEnabled());
    assertTrue(panel.isRequestFocusEnabled());
  }

  /**
   * Test {@link TreeStatusPane#updateTreeStatus(TreeStatus)}.
   *
   * <p>Method under test: {@link TreeStatusPane#updateTreeStatus(TreeStatus)}
   */
  @Test
  @DisplayName("Test updateTreeStatus(TreeStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TreeStatusPane.updateTreeStatus(TreeStatus)"})
  void testUpdateTreeStatus() {
    // Arrange and Act
    treeStatusPane.updateTreeStatus(treeStatus);

    // Assert
    Component[] components = treeStatusPane.getPanel().getComponents();
    Component component = components[0];
    assertTrue(component instanceof JTextField);
    assertTrue(((JTextField) component).getBorder() instanceof BevelBorder);
    assertEquals(1, components.length);
    assertTrue(component.isCursorSet());
    assertTrue(((JTextField) component).isEditable());
  }
}
