package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.image.DirectColorModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AddressPaneDiffblueTest {
  /**
   * Test {@link AddressPane#AddressPane(int)}.
   * <p>
   * Method under test: {@link AddressPane#AddressPane(int)}
   */
  @Test
  @DisplayName("Test new AddressPane(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AddressPane.<init>(int)"})
  void testNewAddressPane() {
    // Arrange and Act
    AddressPane actualAddressPane = new AddressPane(1);

    // Assert
    assertTrue(actualAddressPane.getColorModel() instanceof DirectColorModel);
    assertEquals("ComponentUI", actualAddressPane.getUIClassID());
    assertNull(actualAddressPane.getBackground());
    assertNull(actualAddressPane.getForeground());
    assertNull(actualAddressPane.getNextFocusableComponent());
    assertNull(actualAddressPane.getFocusCycleRootAncestor());
    assertNull(actualAddressPane.getParent());
    assertNull(actualAddressPane.getTopLevelAncestor());
    assertNull(actualAddressPane.getFocusTraversalPolicy());
    assertNull(actualAddressPane.getGraphics());
    assertNull(actualAddressPane.getGraphicsConfiguration());
    assertNull(actualAddressPane.getLayout());
    assertNull(actualAddressPane.getDropTarget());
    assertNull(actualAddressPane.getInputContext());
    assertNull(actualAddressPane.getInputMethodRequests());
    assertNull(actualAddressPane.getName());
    assertNull(actualAddressPane.getToolTipText());
    assertNull(actualAddressPane.getAccessibleContext());
    assertNull(actualAddressPane.getInputVerifier());
    assertNull(actualAddressPane.getComponentPopupMenu());
    assertNull(actualAddressPane.getRootPane());
    assertNull(actualAddressPane.getTransferHandler());
    assertNull(actualAddressPane.getBorder());
    assertEquals(0, actualAddressPane.getComponentCount());
    assertEquals(0, actualAddressPane.getDebugGraphicsOptions());
    assertEquals(0, actualAddressPane.getHeight());
    assertEquals(0, actualAddressPane.getWidth());
    assertEquals(0, actualAddressPane.getX());
    assertEquals(0, actualAddressPane.getY());
    assertEquals(0, actualAddressPane.getComponentListeners().length);
    assertEquals(0, actualAddressPane.getFocusListeners().length);
    assertEquals(0, actualAddressPane.getHierarchyBoundsListeners().length);
    assertEquals(0, actualAddressPane.getHierarchyListeners().length);
    assertEquals(0, actualAddressPane.getInputMethodListeners().length);
    assertEquals(0, actualAddressPane.getKeyListeners().length);
    assertEquals(0, actualAddressPane.getMouseListeners().length);
    assertEquals(0, actualAddressPane.getMouseMotionListeners().length);
    assertEquals(0, actualAddressPane.getMouseWheelListeners().length);
    assertEquals(0, actualAddressPane.getPropertyChangeListeners().length);
    assertEquals(0, actualAddressPane.getComponents().length);
    assertEquals(0, actualAddressPane.getContainerListeners().length);
    assertEquals(0, actualAddressPane.getAncestorListeners().length);
    assertEquals(0, actualAddressPane.getRegisteredKeyStrokes().length);
    assertEquals(0, actualAddressPane.getVetoableChangeListeners().length);
    assertEquals(0.5f, actualAddressPane.getAlignmentX());
    assertEquals(0.5f, actualAddressPane.getAlignmentY());
    assertEquals(BaselineResizeBehavior.OTHER, actualAddressPane.getBaselineResizeBehavior());
    assertFalse(actualAddressPane.getIgnoreRepaint());
    assertFalse(actualAddressPane.hasFocus());
    assertFalse(actualAddressPane.isBackgroundSet());
    assertFalse(actualAddressPane.isCursorSet());
    assertFalse(actualAddressPane.isDisplayable());
    assertFalse(actualAddressPane.isFocusOwner());
    assertFalse(actualAddressPane.isForegroundSet());
    assertFalse(actualAddressPane.isLightweight());
    assertFalse(actualAddressPane.isMaximumSizeSet());
    assertFalse(actualAddressPane.isMinimumSizeSet());
    assertFalse(actualAddressPane.isShowing());
    assertFalse(actualAddressPane.isValid());
    assertFalse(actualAddressPane.isFocusCycleRoot());
    assertFalse(actualAddressPane.isFocusTraversalPolicyProvider());
    assertFalse(actualAddressPane.isFocusTraversalPolicySet());
    assertFalse(actualAddressPane.getAutoscrolls());
    assertFalse(actualAddressPane.getInheritsPopupMenu());
    assertFalse(actualAddressPane.isDoubleBuffered());
    assertFalse(actualAddressPane.isManagingFocus());
    assertFalse(actualAddressPane.isOpaque());
    assertFalse(actualAddressPane.isPaintingForPrint());
    assertFalse(actualAddressPane.isPaintingTile());
    assertFalse(actualAddressPane.isValidateRoot());
    assertTrue(actualAddressPane.getFocusTraversalKeysEnabled());
    assertTrue(actualAddressPane.isEnabled());
    assertTrue(actualAddressPane.isFocusable());
    assertTrue(actualAddressPane.isFontSet());
    assertTrue(actualAddressPane.isPreferredSizeSet());
    assertTrue(actualAddressPane.isVisible());
    assertTrue(actualAddressPane.getVerifyInputWhenFocusTarget());
    assertTrue(actualAddressPane.isOptimizedDrawingEnabled());
    assertTrue(actualAddressPane.isRequestFocusEnabled());
  }
}
