package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.FlowLayout;
import java.awt.image.DirectColorModel;
import javax.swing.border.MatteBorder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UpperPaneDiffblueTest {
  /**
   * Test new {@link UpperPane} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link UpperPane}
   */
  @Test
  @DisplayName("Test new UpperPane (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpperPane.<init>()"})
  void testNewUpperPane() {
    // Arrange and Act
    UpperPane actualUpperPane = new UpperPane();

    // Assert
    assertTrue(actualUpperPane.getLayout() instanceof FlowLayout);
    assertTrue(actualUpperPane.getColorModel() instanceof DirectColorModel);
    assertTrue(actualUpperPane.getBorder() instanceof MatteBorder);
    assertEquals("PanelUI", actualUpperPane.getUIClassID());
    assertNull(actualUpperPane.getNextFocusableComponent());
    assertNull(actualUpperPane.getFocusCycleRootAncestor());
    assertNull(actualUpperPane.getParent());
    assertNull(actualUpperPane.getTopLevelAncestor());
    assertNull(actualUpperPane.getFocusTraversalPolicy());
    assertNull(actualUpperPane.getGraphics());
    assertNull(actualUpperPane.getGraphicsConfiguration());
    assertNull(actualUpperPane.getDropTarget());
    assertNull(actualUpperPane.getInputContext());
    assertNull(actualUpperPane.getInputMethodRequests());
    assertNull(actualUpperPane.getName());
    assertNull(actualUpperPane.getToolTipText());
    assertNull(actualUpperPane.getInputVerifier());
    assertNull(actualUpperPane.getComponentPopupMenu());
    assertNull(actualUpperPane.getRootPane());
    assertNull(actualUpperPane.getTransferHandler());
    assertEquals(0, actualUpperPane.getComponentCount());
    assertEquals(0, actualUpperPane.getDebugGraphicsOptions());
    assertEquals(0, actualUpperPane.getHeight());
    assertEquals(0, actualUpperPane.getWidth());
    assertEquals(0, actualUpperPane.getX());
    assertEquals(0, actualUpperPane.getY());
    assertEquals(0, actualUpperPane.getComponentListeners().length);
    assertEquals(0, actualUpperPane.getFocusListeners().length);
    assertEquals(0, actualUpperPane.getHierarchyBoundsListeners().length);
    assertEquals(0, actualUpperPane.getHierarchyListeners().length);
    assertEquals(0, actualUpperPane.getInputMethodListeners().length);
    assertEquals(0, actualUpperPane.getKeyListeners().length);
    assertEquals(0, actualUpperPane.getMouseListeners().length);
    assertEquals(0, actualUpperPane.getMouseMotionListeners().length);
    assertEquals(0, actualUpperPane.getMouseWheelListeners().length);
    assertEquals(0, actualUpperPane.getPropertyChangeListeners().length);
    assertEquals(0, actualUpperPane.getComponents().length);
    assertEquals(0, actualUpperPane.getContainerListeners().length);
    assertEquals(0, actualUpperPane.getAncestorListeners().length);
    assertEquals(0, actualUpperPane.getRegisteredKeyStrokes().length);
    assertEquals(0, actualUpperPane.getVetoableChangeListeners().length);
    assertEquals(0.5f, actualUpperPane.getAlignmentX());
    assertEquals(0.5f, actualUpperPane.getAlignmentY());
    assertEquals(BaselineResizeBehavior.OTHER, actualUpperPane.getBaselineResizeBehavior());
    assertFalse(actualUpperPane.getIgnoreRepaint());
    assertFalse(actualUpperPane.hasFocus());
    assertFalse(actualUpperPane.isCursorSet());
    assertFalse(actualUpperPane.isDisplayable());
    assertFalse(actualUpperPane.isFocusOwner());
    assertFalse(actualUpperPane.isLightweight());
    assertFalse(actualUpperPane.isMaximumSizeSet());
    assertFalse(actualUpperPane.isMinimumSizeSet());
    assertFalse(actualUpperPane.isShowing());
    assertFalse(actualUpperPane.isValid());
    assertFalse(actualUpperPane.isFocusCycleRoot());
    assertFalse(actualUpperPane.isFocusTraversalPolicyProvider());
    assertFalse(actualUpperPane.isFocusTraversalPolicySet());
    assertFalse(actualUpperPane.getAutoscrolls());
    assertFalse(actualUpperPane.getInheritsPopupMenu());
    assertFalse(actualUpperPane.isManagingFocus());
    assertFalse(actualUpperPane.isPaintingForPrint());
    assertFalse(actualUpperPane.isPaintingTile());
    assertFalse(actualUpperPane.isValidateRoot());
    assertTrue(actualUpperPane.getFocusTraversalKeysEnabled());
    assertTrue(actualUpperPane.isBackgroundSet());
    assertTrue(actualUpperPane.isEnabled());
    assertTrue(actualUpperPane.isFocusable());
    assertTrue(actualUpperPane.isFontSet());
    assertTrue(actualUpperPane.isForegroundSet());
    assertTrue(actualUpperPane.isPreferredSizeSet());
    assertTrue(actualUpperPane.isVisible());
    assertTrue(actualUpperPane.getVerifyInputWhenFocusTarget());
    assertTrue(actualUpperPane.isDoubleBuffered());
    assertTrue(actualUpperPane.isOpaque());
    assertTrue(actualUpperPane.isOptimizedDrawingEnabled());
    assertTrue(actualUpperPane.isRequestFocusEnabled());
  }
}
