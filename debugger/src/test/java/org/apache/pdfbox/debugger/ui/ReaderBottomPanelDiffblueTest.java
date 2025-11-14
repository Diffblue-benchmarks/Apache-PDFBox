package org.apache.pdfbox.debugger.ui;

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
import javax.swing.border.EmptyBorder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReaderBottomPanelDiffblueTest {
  /**
   * Test new {@link ReaderBottomPanel} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ReaderBottomPanel}
   */
  @Test
  @DisplayName("Test new ReaderBottomPanel (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReaderBottomPanel.<init>()"})
  void testNewReaderBottomPanel() {
    // Arrange and Act
    ReaderBottomPanel actualReaderBottomPanel = new ReaderBottomPanel();

    // Assert
    assertTrue(actualReaderBottomPanel.getLayout() instanceof BorderLayout);
    assertTrue(actualReaderBottomPanel.getColorModel() instanceof DirectColorModel);
    assertTrue(actualReaderBottomPanel.getBorder() instanceof EmptyBorder);
    assertEquals("PanelUI", actualReaderBottomPanel.getUIClassID());
    assertNull(actualReaderBottomPanel.getNextFocusableComponent());
    assertNull(actualReaderBottomPanel.getFocusCycleRootAncestor());
    assertNull(actualReaderBottomPanel.getParent());
    assertNull(actualReaderBottomPanel.getTopLevelAncestor());
    assertNull(actualReaderBottomPanel.getFocusTraversalPolicy());
    assertNull(actualReaderBottomPanel.getGraphics());
    assertNull(actualReaderBottomPanel.getGraphicsConfiguration());
    assertNull(actualReaderBottomPanel.getDropTarget());
    assertNull(actualReaderBottomPanel.getInputContext());
    assertNull(actualReaderBottomPanel.getInputMethodRequests());
    assertNull(actualReaderBottomPanel.getName());
    assertNull(actualReaderBottomPanel.getToolTipText());
    assertNull(actualReaderBottomPanel.getInputVerifier());
    assertNull(actualReaderBottomPanel.getComponentPopupMenu());
    assertNull(actualReaderBottomPanel.getRootPane());
    assertNull(actualReaderBottomPanel.getTransferHandler());
    assertEquals(0, actualReaderBottomPanel.getDebugGraphicsOptions());
    assertEquals(0, actualReaderBottomPanel.getHeight());
    assertEquals(0, actualReaderBottomPanel.getWidth());
    assertEquals(0, actualReaderBottomPanel.getX());
    assertEquals(0, actualReaderBottomPanel.getY());
    assertEquals(0, actualReaderBottomPanel.getComponentListeners().length);
    assertEquals(0, actualReaderBottomPanel.getFocusListeners().length);
    assertEquals(0, actualReaderBottomPanel.getHierarchyBoundsListeners().length);
    assertEquals(0, actualReaderBottomPanel.getHierarchyListeners().length);
    assertEquals(0, actualReaderBottomPanel.getInputMethodListeners().length);
    assertEquals(0, actualReaderBottomPanel.getKeyListeners().length);
    assertEquals(0, actualReaderBottomPanel.getMouseListeners().length);
    assertEquals(0, actualReaderBottomPanel.getMouseMotionListeners().length);
    assertEquals(0, actualReaderBottomPanel.getMouseWheelListeners().length);
    assertEquals(0, actualReaderBottomPanel.getPropertyChangeListeners().length);
    assertEquals(0, actualReaderBottomPanel.getContainerListeners().length);
    assertEquals(0, actualReaderBottomPanel.getAncestorListeners().length);
    assertEquals(0, actualReaderBottomPanel.getRegisteredKeyStrokes().length);
    assertEquals(0, actualReaderBottomPanel.getVetoableChangeListeners().length);
    assertEquals(0.5f, actualReaderBottomPanel.getAlignmentX());
    assertEquals(0.5f, actualReaderBottomPanel.getAlignmentY());
    assertEquals(2, actualReaderBottomPanel.getComponentCount());
    assertEquals(2, actualReaderBottomPanel.getComponents().length);
    assertEquals(BaselineResizeBehavior.OTHER, actualReaderBottomPanel.getBaselineResizeBehavior());
    assertFalse(actualReaderBottomPanel.getIgnoreRepaint());
    assertFalse(actualReaderBottomPanel.hasFocus());
    assertFalse(actualReaderBottomPanel.isCursorSet());
    assertFalse(actualReaderBottomPanel.isDisplayable());
    assertFalse(actualReaderBottomPanel.isFocusOwner());
    assertFalse(actualReaderBottomPanel.isLightweight());
    assertFalse(actualReaderBottomPanel.isMaximumSizeSet());
    assertFalse(actualReaderBottomPanel.isMinimumSizeSet());
    assertFalse(actualReaderBottomPanel.isShowing());
    assertFalse(actualReaderBottomPanel.isValid());
    assertFalse(actualReaderBottomPanel.isFocusCycleRoot());
    assertFalse(actualReaderBottomPanel.isFocusTraversalPolicyProvider());
    assertFalse(actualReaderBottomPanel.isFocusTraversalPolicySet());
    assertFalse(actualReaderBottomPanel.getAutoscrolls());
    assertFalse(actualReaderBottomPanel.getInheritsPopupMenu());
    assertFalse(actualReaderBottomPanel.isManagingFocus());
    assertFalse(actualReaderBottomPanel.isPaintingForPrint());
    assertFalse(actualReaderBottomPanel.isPaintingTile());
    assertFalse(actualReaderBottomPanel.isValidateRoot());
    assertTrue(actualReaderBottomPanel.getFocusTraversalKeysEnabled());
    assertTrue(actualReaderBottomPanel.isBackgroundSet());
    assertTrue(actualReaderBottomPanel.isEnabled());
    assertTrue(actualReaderBottomPanel.isFocusable());
    assertTrue(actualReaderBottomPanel.isFontSet());
    assertTrue(actualReaderBottomPanel.isForegroundSet());
    assertTrue(actualReaderBottomPanel.isPreferredSizeSet());
    assertTrue(actualReaderBottomPanel.isVisible());
    assertTrue(actualReaderBottomPanel.getVerifyInputWhenFocusTarget());
    assertTrue(actualReaderBottomPanel.isDoubleBuffered());
    assertTrue(actualReaderBottomPanel.isOpaque());
    assertTrue(actualReaderBottomPanel.isOptimizedDrawingEnabled());
    assertTrue(actualReaderBottomPanel.isRequestFocusEnabled());
  }
}
