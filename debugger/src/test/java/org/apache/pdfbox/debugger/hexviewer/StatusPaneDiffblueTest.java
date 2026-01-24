package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.DirectColorModel;
import javax.swing.JLabel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StatusPaneDiffblueTest {
  /**
   * Test new {@link StatusPane} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StatusPane}
   */
  @Test
  @DisplayName("Test new StatusPane (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusPane.<init>()"})
  void testNewStatusPane() {
    // Arrange and Act
    StatusPane actualStatusPane = new StatusPane();

    // Assert
    assertTrue(actualStatusPane.getLayout() instanceof FlowLayout);
    assertTrue(actualStatusPane.getColorModel() instanceof DirectColorModel);
    assertEquals("PanelUI", actualStatusPane.getUIClassID());
    assertNull(actualStatusPane.getNextFocusableComponent());
    assertNull(actualStatusPane.getFocusCycleRootAncestor());
    assertNull(actualStatusPane.getParent());
    assertNull(actualStatusPane.getTopLevelAncestor());
    assertNull(actualStatusPane.getFocusTraversalPolicy());
    assertNull(actualStatusPane.getGraphics());
    assertNull(actualStatusPane.getGraphicsConfiguration());
    assertNull(actualStatusPane.getDropTarget());
    assertNull(actualStatusPane.getInputContext());
    assertNull(actualStatusPane.getInputMethodRequests());
    assertNull(actualStatusPane.getName());
    assertNull(actualStatusPane.getToolTipText());
    assertNull(actualStatusPane.getInputVerifier());
    assertNull(actualStatusPane.getComponentPopupMenu());
    assertNull(actualStatusPane.getRootPane());
    assertNull(actualStatusPane.getTransferHandler());
    assertNull(actualStatusPane.getBorder());
    assertEquals(0, actualStatusPane.getDebugGraphicsOptions());
    assertEquals(0, actualStatusPane.getHeight());
    assertEquals(0, actualStatusPane.getWidth());
    assertEquals(0, actualStatusPane.getX());
    assertEquals(0, actualStatusPane.getY());
    assertEquals(0, actualStatusPane.getComponentListeners().length);
    assertEquals(0, actualStatusPane.getFocusListeners().length);
    assertEquals(0, actualStatusPane.getHierarchyBoundsListeners().length);
    assertEquals(0, actualStatusPane.getHierarchyListeners().length);
    assertEquals(0, actualStatusPane.getInputMethodListeners().length);
    assertEquals(0, actualStatusPane.getKeyListeners().length);
    assertEquals(0, actualStatusPane.getMouseListeners().length);
    assertEquals(0, actualStatusPane.getMouseMotionListeners().length);
    assertEquals(0, actualStatusPane.getMouseWheelListeners().length);
    assertEquals(0, actualStatusPane.getPropertyChangeListeners().length);
    assertEquals(0, actualStatusPane.getContainerListeners().length);
    assertEquals(0, actualStatusPane.getAncestorListeners().length);
    assertEquals(0, actualStatusPane.getRegisteredKeyStrokes().length);
    assertEquals(0, actualStatusPane.getVetoableChangeListeners().length);
    assertEquals(0.5f, actualStatusPane.getAlignmentX());
    assertEquals(0.5f, actualStatusPane.getAlignmentY());
    assertEquals(6, actualStatusPane.getComponentCount());
    assertEquals(6, actualStatusPane.getComponents().length);
    assertEquals(BaselineResizeBehavior.OTHER, actualStatusPane.getBaselineResizeBehavior());
    assertFalse(actualStatusPane.getIgnoreRepaint());
    assertFalse(actualStatusPane.hasFocus());
    assertFalse(actualStatusPane.isCursorSet());
    assertFalse(actualStatusPane.isDisplayable());
    assertFalse(actualStatusPane.isFocusOwner());
    assertFalse(actualStatusPane.isLightweight());
    assertFalse(actualStatusPane.isMaximumSizeSet());
    assertFalse(actualStatusPane.isMinimumSizeSet());
    assertFalse(actualStatusPane.isPreferredSizeSet());
    assertFalse(actualStatusPane.isShowing());
    assertFalse(actualStatusPane.isValid());
    assertFalse(actualStatusPane.isFocusCycleRoot());
    assertFalse(actualStatusPane.isFocusTraversalPolicyProvider());
    assertFalse(actualStatusPane.isFocusTraversalPolicySet());
    assertFalse(actualStatusPane.getAutoscrolls());
    assertFalse(actualStatusPane.getInheritsPopupMenu());
    assertFalse(actualStatusPane.isManagingFocus());
    assertFalse(actualStatusPane.isPaintingForPrint());
    assertFalse(actualStatusPane.isPaintingTile());
    assertFalse(actualStatusPane.isValidateRoot());
    assertTrue(actualStatusPane.getFocusTraversalKeysEnabled());
    assertTrue(actualStatusPane.isBackgroundSet());
    assertTrue(actualStatusPane.isEnabled());
    assertTrue(actualStatusPane.isFocusable());
    assertTrue(actualStatusPane.isFontSet());
    assertTrue(actualStatusPane.isForegroundSet());
    assertTrue(actualStatusPane.isVisible());
    assertTrue(actualStatusPane.getVerifyInputWhenFocusTarget());
    assertTrue(actualStatusPane.isDoubleBuffered());
    assertTrue(actualStatusPane.isOpaque());
    assertTrue(actualStatusPane.isOptimizedDrawingEnabled());
    assertTrue(actualStatusPane.isRequestFocusEnabled());
  }

  /**
   * Test {@link StatusPane#updateStatus(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then second element Text is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link StatusPane#updateStatus(int)}
   */
  @Test
  @DisplayName("Test updateStatus(int); when minus one; then second element Text is '0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusPane.updateStatus(int)"})
  void testUpdateStatus_whenMinusOne_thenSecondElementTextIs0() {
    // Arrange
    StatusPane statusPane = new StatusPane();

    // Act
    statusPane.updateStatus(-1);

    // Assert
    Component[] components = statusPane.getComponents();
    Component component = components[1];
    assertTrue(component instanceof JLabel);
    Component component2 = components[3];
    assertTrue(component2 instanceof JLabel);
    assertEquals("0", ((JLabel) component).getText());
    assertEquals("0", ((JLabel) component2).getText());
    Dimension minimumSize = statusPane.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(199, size.width);
    assertEquals(199, minimumSize.width);
    assertEquals(199.0d, size.getWidth());
    assertEquals(199.0d, minimumSize.getWidth());
    Dimension preferredSize = statusPane.getPreferredSize();
    Dimension size2 = preferredSize.getSize();
    assertEquals(383, size2.width);
    assertEquals(383, preferredSize.width);
    assertEquals(383.0d, size2.getWidth());
    assertEquals(383.0d, preferredSize.getWidth());
    assertEquals(6, components.length);
  }

  /**
   * Test {@link StatusPane#updateStatus(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then second element Text is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link StatusPane#updateStatus(int)}
   */
  @Test
  @DisplayName("Test updateStatus(int); when one; then second element Text is '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusPane.updateStatus(int)"})
  void testUpdateStatus_whenOne_thenSecondElementTextIs1() {
    // Arrange
    StatusPane statusPane = new StatusPane();

    // Act
    statusPane.updateStatus(1);

    // Assert
    Component[] components = statusPane.getComponents();
    Component component = components[1];
    assertTrue(component instanceof JLabel);
    Component component2 = components[3];
    assertTrue(component2 instanceof JLabel);
    assertEquals("1", ((JLabel) component).getText());
    assertEquals("2", ((JLabel) component2).getText());
    Dimension minimumSize = statusPane.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(194, size.width);
    assertEquals(194, minimumSize.width);
    assertEquals(194.0d, size.getWidth());
    assertEquals(194.0d, minimumSize.getWidth());
    Dimension preferredSize = statusPane.getPreferredSize();
    Dimension size2 = preferredSize.getSize();
    assertEquals(378, size2.width);
    assertEquals(378, preferredSize.width);
    assertEquals(378.0d, size2.getWidth());
    assertEquals(378.0d, preferredSize.getWidth());
    assertEquals(6, components.length);
  }
}
