package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.Dimension;
import java.awt.image.DirectColorModel;
import java.io.UnsupportedEncodingException;
import javax.swing.JComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HexViewDiffblueTest {
  /**
   * Test {@link HexView#HexView()}.
   *
   * <p>Method under test: {@link HexView#HexView()}
   */
  @Test
  @DisplayName("Test new HexView()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexView.<init>()"})
  void testNewHexView() {
    // Arrange, Act and Assert
    JComponent pane = new HexView().getPane();
    assertTrue(pane.getLayout() instanceof BorderLayout);
    assertTrue(pane.getColorModel() instanceof DirectColorModel);
    assertEquals("PanelUI", pane.getUIClassID());
    assertNull(pane.getNextFocusableComponent());
    assertNull(pane.getFocusCycleRootAncestor());
    assertNull(pane.getParent());
    assertNull(pane.getTopLevelAncestor());
    assertNull(pane.getFocusTraversalPolicy());
    assertNull(pane.getGraphics());
    assertNull(pane.getGraphicsConfiguration());
    assertNull(pane.getDropTarget());
    assertNull(pane.getInputContext());
    assertNull(pane.getInputMethodRequests());
    assertNull(pane.getName());
    assertNull(pane.getToolTipText());
    assertNull(pane.getInputVerifier());
    assertNull(pane.getComponentPopupMenu());
    assertNull(pane.getRootPane());
    assertNull(pane.getTransferHandler());
    assertNull(pane.getBorder());
    assertEquals(0, pane.getComponentCount());
    assertEquals(0, pane.getDebugGraphicsOptions());
    assertEquals(0, pane.getHeight());
    assertEquals(0, pane.getWidth());
    assertEquals(0, pane.getX());
    assertEquals(0, pane.getY());
    assertEquals(0, pane.getComponentListeners().length);
    assertEquals(0, pane.getFocusListeners().length);
    assertEquals(0, pane.getHierarchyBoundsListeners().length);
    assertEquals(0, pane.getHierarchyListeners().length);
    assertEquals(0, pane.getInputMethodListeners().length);
    assertEquals(0, pane.getKeyListeners().length);
    assertEquals(0, pane.getMouseListeners().length);
    assertEquals(0, pane.getMouseMotionListeners().length);
    assertEquals(0, pane.getMouseWheelListeners().length);
    assertEquals(0, pane.getPropertyChangeListeners().length);
    assertEquals(0, pane.getComponents().length);
    assertEquals(0, pane.getContainerListeners().length);
    assertEquals(0, pane.getAncestorListeners().length);
    assertEquals(0, pane.getRegisteredKeyStrokes().length);
    assertEquals(0, pane.getVetoableChangeListeners().length);
    assertEquals(0.5f, pane.getAlignmentX());
    assertEquals(0.5f, pane.getAlignmentY());
    assertEquals(BaselineResizeBehavior.OTHER, pane.getBaselineResizeBehavior());
    assertFalse(pane.getIgnoreRepaint());
    assertFalse(pane.hasFocus());
    assertFalse(pane.isCursorSet());
    assertFalse(pane.isDisplayable());
    assertFalse(pane.isFocusOwner());
    assertFalse(pane.isLightweight());
    assertFalse(pane.isMaximumSizeSet());
    assertFalse(pane.isMinimumSizeSet());
    assertFalse(pane.isPreferredSizeSet());
    assertFalse(pane.isShowing());
    assertFalse(pane.isValid());
    assertFalse(pane.isFocusCycleRoot());
    assertFalse(pane.isFocusTraversalPolicyProvider());
    assertFalse(pane.isFocusTraversalPolicySet());
    assertFalse(pane.getAutoscrolls());
    assertFalse(pane.getInheritsPopupMenu());
    assertFalse(pane.isManagingFocus());
    assertFalse(pane.isPaintingForPrint());
    assertFalse(pane.isPaintingTile());
    assertFalse(pane.isValidateRoot());
    assertTrue(pane.getFocusTraversalKeysEnabled());
    assertTrue(pane.isBackgroundSet());
    assertTrue(pane.isEnabled());
    assertTrue(pane.isFocusable());
    assertTrue(pane.isFontSet());
    assertTrue(pane.isForegroundSet());
    assertTrue(pane.isVisible());
    assertTrue(pane.getVerifyInputWhenFocusTarget());
    assertTrue(pane.isDoubleBuffered());
    assertTrue(pane.isOpaque());
    assertTrue(pane.isOptimizedDrawingEnabled());
    assertTrue(pane.isRequestFocusEnabled());
  }

  /**
   * Test {@link HexView#HexView(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link HexView#HexView(byte[])}
   */
  @Test
  @DisplayName("Test new HexView(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexView.<init>(byte[])"})
  void testNewHexView_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    JComponent pane = new HexView("AXAXAXAX".getBytes("UTF-8")).getPane();
    assertTrue(pane.getColorModel() instanceof DirectColorModel);
    assertEquals(1, pane.getComponents().length);
  }

  /**
   * Test {@link HexView#HexView(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link HexView#HexView(byte[])}
   */
  @Test
  @DisplayName("Test new HexView(byte[]); when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexView.<init>(byte[])"})
  void testNewHexView_whenEmptyArrayOfByte() {
    // Arrange and Act
    HexView actualHexView = new HexView(new byte[] {});

    // Assert
    JComponent pane = actualHexView.getPane();
    assertTrue(pane.getColorModel() instanceof DirectColorModel);
    assertEquals(1, pane.getComponents().length);
  }

  /**
   * Test {@link HexView#changeData(byte[])}.
   *
   * <ul>
   *   <li>Given {@link HexView#HexView(byte[])} with bytes is A backspace A backspace A backspace A
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link HexView#changeData(byte[])}
   */
  @Test
  @DisplayName(
      "Test changeData(byte[]); given HexView(byte[]) with bytes is A backspace A backspace A backspace A Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexView.changeData(byte[])"})
  void testChangeData_givenHexViewWithBytesIsABackspaceABackspaceABackspaceABytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    HexView hexView = new HexView("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    hexView.changeData("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertEquals(1, hexView.getPane().getComponents().length);
  }

  /**
   * Test {@link HexView#changeData(byte[])}.
   *
   * <ul>
   *   <li>Given {@link HexView#HexView()}.
   *   <li>Then first element PreferredSize {@link Dimension#height} is ninety-two.
   * </ul>
   *
   * <p>Method under test: {@link HexView#changeData(byte[])}
   */
  @Test
  @DisplayName(
      "Test changeData(byte[]); given HexView(); then first element PreferredSize height is ninety-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexView.changeData(byte[])"})
  void testChangeData_givenHexView_thenFirstElementPreferredSizeHeightIsNinetyTwo()
      throws UnsupportedEncodingException {
    // Arrange
    HexView hexView = new HexView();

    // Act
    hexView.changeData("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    JComponent pane = hexView.getPane();
    Component[] components = pane.getComponents();
    Component component = components[0];
    assertTrue(component instanceof HexEditor);
    assertEquals(1, components.length);
    assertEquals(92, component.getPreferredSize().height);
    Dimension preferredSize = pane.getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(92, size2.getSize().height);
    assertEquals(92, size2.height);
    assertEquals(92, size.height);
    assertEquals(92, preferredSize.height);
    assertEquals(92.0d, size2.getHeight());
    assertEquals(92.0d, size.getHeight());
    assertEquals(92.0d, preferredSize.getHeight());
  }

  /**
   * Test {@link HexView#changeData(byte[])}.
   *
   * <ul>
   *   <li>Then first element PreferredSize {@link Dimension#height} is seventy-two.
   * </ul>
   *
   * <p>Method under test: {@link HexView#changeData(byte[])}
   */
  @Test
  @DisplayName("Test changeData(byte[]); then first element PreferredSize height is seventy-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexView.changeData(byte[])"})
  void testChangeData_thenFirstElementPreferredSizeHeightIsSeventyTwo() {
    // Arrange
    HexView hexView = new HexView();

    // Act
    hexView.changeData(new byte[] {});

    // Assert
    JComponent pane = hexView.getPane();
    Component[] components = pane.getComponents();
    Component component = components[0];
    assertTrue(component instanceof HexEditor);
    assertEquals(1, components.length);
    assertEquals(72, component.getPreferredSize().height);
    Dimension preferredSize = pane.getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(72, size2.getSize().height);
    assertEquals(72, size2.height);
    assertEquals(72, size.height);
    assertEquals(72, preferredSize.height);
    assertEquals(72.0d, size2.getHeight());
    assertEquals(72.0d, size.getHeight());
    assertEquals(72.0d, preferredSize.getHeight());
  }
}
