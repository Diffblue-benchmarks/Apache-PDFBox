package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.image.DirectColorModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ASCIIPaneDiffblueTest {
  @Mock private HexModel hexModel;

  /**
   * Test {@link ASCIIPane#ASCIIPane(HexModel)}.
   *
   * <p>Method under test: {@link ASCIIPane#ASCIIPane(HexModel)}
   */
  @Test
  @DisplayName("Test new ASCIIPane(HexModel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCIIPane.<init>(HexModel)"})
  void testNewASCIIPane() {
    // Arrange
    when(hexModel.totalLine()).thenReturn(2);
    doNothing().when(hexModel).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());

    // Act
    ASCIIPane actualAsciiPane = new ASCIIPane(hexModel);

    // Assert
    verify(hexModel).addHexModelChangeListener(isA(HexModelChangeListener.class));
    verify(hexModel).totalLine();
    assertTrue(actualAsciiPane.getColorModel() instanceof DirectColorModel);
    assertEquals("ComponentUI", actualAsciiPane.getUIClassID());
    assertNull(actualAsciiPane.getBackground());
    assertNull(actualAsciiPane.getForeground());
    assertNull(actualAsciiPane.getNextFocusableComponent());
    assertNull(actualAsciiPane.getFocusCycleRootAncestor());
    assertNull(actualAsciiPane.getParent());
    assertNull(actualAsciiPane.getTopLevelAncestor());
    assertNull(actualAsciiPane.getFocusTraversalPolicy());
    assertNull(actualAsciiPane.getGraphics());
    assertNull(actualAsciiPane.getGraphicsConfiguration());
    assertNull(actualAsciiPane.getLayout());
    assertNull(actualAsciiPane.getDropTarget());
    assertNull(actualAsciiPane.getInputContext());
    assertNull(actualAsciiPane.getInputMethodRequests());
    assertNull(actualAsciiPane.getName());
    assertNull(actualAsciiPane.getToolTipText());
    assertNull(actualAsciiPane.getAccessibleContext());
    assertNull(actualAsciiPane.getInputVerifier());
    assertNull(actualAsciiPane.getComponentPopupMenu());
    assertNull(actualAsciiPane.getRootPane());
    assertNull(actualAsciiPane.getTransferHandler());
    assertNull(actualAsciiPane.getBorder());
    assertNull(actualAsciiPane.getUI());
    assertEquals(0, actualAsciiPane.getComponentCount());
    assertEquals(0, actualAsciiPane.getDebugGraphicsOptions());
    assertEquals(0, actualAsciiPane.getHeight());
    assertEquals(0, actualAsciiPane.getWidth());
    assertEquals(0, actualAsciiPane.getX());
    assertEquals(0, actualAsciiPane.getY());
    assertEquals(0, actualAsciiPane.getComponentListeners().length);
    assertEquals(0, actualAsciiPane.getFocusListeners().length);
    assertEquals(0, actualAsciiPane.getHierarchyBoundsListeners().length);
    assertEquals(0, actualAsciiPane.getHierarchyListeners().length);
    assertEquals(0, actualAsciiPane.getInputMethodListeners().length);
    assertEquals(0, actualAsciiPane.getKeyListeners().length);
    assertEquals(0, actualAsciiPane.getMouseListeners().length);
    assertEquals(0, actualAsciiPane.getMouseMotionListeners().length);
    assertEquals(0, actualAsciiPane.getMouseWheelListeners().length);
    assertEquals(0, actualAsciiPane.getPropertyChangeListeners().length);
    assertEquals(0, actualAsciiPane.getComponents().length);
    assertEquals(0, actualAsciiPane.getContainerListeners().length);
    assertEquals(0, actualAsciiPane.getAncestorListeners().length);
    assertEquals(0, actualAsciiPane.getRegisteredKeyStrokes().length);
    assertEquals(0, actualAsciiPane.getVetoableChangeListeners().length);
    assertEquals(0.5f, actualAsciiPane.getAlignmentX());
    assertEquals(0.5f, actualAsciiPane.getAlignmentY());
    assertEquals(BaselineResizeBehavior.OTHER, actualAsciiPane.getBaselineResizeBehavior());
    assertFalse(actualAsciiPane.getIgnoreRepaint());
    assertFalse(actualAsciiPane.hasFocus());
    assertFalse(actualAsciiPane.isBackgroundSet());
    assertFalse(actualAsciiPane.isCursorSet());
    assertFalse(actualAsciiPane.isDisplayable());
    assertFalse(actualAsciiPane.isFocusOwner());
    assertFalse(actualAsciiPane.isForegroundSet());
    assertFalse(actualAsciiPane.isLightweight());
    assertFalse(actualAsciiPane.isMaximumSizeSet());
    assertFalse(actualAsciiPane.isMinimumSizeSet());
    assertFalse(actualAsciiPane.isShowing());
    assertFalse(actualAsciiPane.isValid());
    assertFalse(actualAsciiPane.isFocusCycleRoot());
    assertFalse(actualAsciiPane.isFocusTraversalPolicyProvider());
    assertFalse(actualAsciiPane.isFocusTraversalPolicySet());
    assertFalse(actualAsciiPane.getAutoscrolls());
    assertFalse(actualAsciiPane.getInheritsPopupMenu());
    assertFalse(actualAsciiPane.isDoubleBuffered());
    assertFalse(actualAsciiPane.isManagingFocus());
    assertFalse(actualAsciiPane.isOpaque());
    assertFalse(actualAsciiPane.isPaintingForPrint());
    assertFalse(actualAsciiPane.isPaintingTile());
    assertFalse(actualAsciiPane.isValidateRoot());
    assertTrue(actualAsciiPane.getFocusTraversalKeysEnabled());
    assertTrue(actualAsciiPane.isEnabled());
    assertTrue(actualAsciiPane.isFocusable());
    assertTrue(actualAsciiPane.isFontSet());
    assertTrue(actualAsciiPane.isPreferredSizeSet());
    assertTrue(actualAsciiPane.isVisible());
    assertTrue(actualAsciiPane.getVerifyInputWhenFocusTarget());
    assertTrue(actualAsciiPane.isOptimizedDrawingEnabled());
    assertTrue(actualAsciiPane.isRequestFocusEnabled());
  }
}
