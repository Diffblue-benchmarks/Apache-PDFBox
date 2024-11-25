package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.util.Locale;
import javax.accessibility.AccessibleContext;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FlagBitsPaneViewDiffblueTest {
  /**
   * Test
   * {@link FlagBitsPaneView#FlagBitsPaneView(String, String, Object[][], String[])}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then first element Layout return {@link FlowLayout}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FlagBitsPaneView#FlagBitsPaneView(String, String, Object[][], String[])}
   */
  @Test
  @DisplayName("Test new FlagBitsPaneView(String, String, Object[][], String[]); when '42'; then first element Layout return FlowLayout")
  void testNewFlagBitsPaneView_when42_thenFirstElementLayoutReturnFlowLayout() {
    // Arrange, Act and Assert
    JPanel panel = (new FlagBitsPaneView("Flag Header", "42", new Object[][]{new Object[]{"Table Row Data"}},
        new String[]{"Column Names"})).getPanel();
    Component[] components = panel.getComponents();
    Component component = components[0];
    assertTrue(((JPanel) component).getLayout() instanceof FlowLayout);
    LayoutManager layout = panel.getLayout();
    assertTrue(layout instanceof GridBagLayout);
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component component2 = components[1];
    assertTrue(component2 instanceof Box);
    assertTrue(((Box) component2).getLayout() instanceof BoxLayout);
    Component[] components2 = ((Box) component2).getComponents();
    assertTrue(components2[0] instanceof JLabel);
    Component[] components3 = ((JPanel) component).getComponents();
    assertTrue(components3[0] instanceof JLabel);
    assertTrue(component instanceof JPanel);
    assertTrue(components2[1] instanceof JScrollPane);
    assertEquals("ComponentUI", ((Box) component2).getUIClassID());
    assertEquals("PanelUI", ((JPanel) component).getUIClassID());
    assertNull(((GridBagLayout) layout).columnWeights);
    assertNull(((GridBagLayout) layout).rowWeights);
    assertNull(((GridBagLayout) layout).columnWidths);
    assertNull(((GridBagLayout) layout).rowHeights);
    assertNull(((Box) component2).getNextFocusableComponent());
    assertNull(((JPanel) component).getNextFocusableComponent());
    assertNull(component.getFocusCycleRootAncestor());
    assertNull(component2.getFocusCycleRootAncestor());
    assertNull(((Box) component2).getTopLevelAncestor());
    assertNull(((JPanel) component).getTopLevelAncestor());
    assertNull(((Box) component2).getFocusTraversalPolicy());
    assertNull(((JPanel) component).getFocusTraversalPolicy());
    assertNull(component.getGraphics());
    assertNull(component2.getGraphics());
    assertNull(component.getGraphicsConfiguration());
    assertNull(component2.getGraphicsConfiguration());
    assertNull(component.getDropTarget());
    assertNull(component2.getDropTarget());
    assertNull(component.getInputContext());
    assertNull(component2.getInputContext());
    assertNull(component.getInputMethodRequests());
    assertNull(component2.getInputMethodRequests());
    assertNull(component.getName());
    assertNull(component2.getName());
    assertNull(((Box) component2).getToolTipText());
    assertNull(((JPanel) component).getToolTipText());
    assertNull(((Box) component2).getInputVerifier());
    assertNull(((JPanel) component).getInputVerifier());
    assertNull(((Box) component2).getComponentPopupMenu());
    assertNull(((JPanel) component).getComponentPopupMenu());
    assertNull(((Box) component2).getRootPane());
    assertNull(((JPanel) component).getRootPane());
    assertNull(((Box) component2).getTransferHandler());
    assertNull(((JPanel) component).getTransferHandler());
    assertNull(((Box) component2).getBorder());
    assertNull(((JPanel) component).getBorder());
    assertEquals(0, component.getHeight());
    assertEquals(0, component2.getHeight());
    assertEquals(0, component.getWidth());
    assertEquals(0, component2.getWidth());
    assertEquals(0, component.getX());
    assertEquals(0, component2.getX());
    assertEquals(0, component.getY());
    assertEquals(0, component2.getY());
    assertEquals(0, ((Box) component2).getDebugGraphicsOptions());
    assertEquals(0, ((JPanel) component).getDebugGraphicsOptions());
    assertEquals(0, component.getComponentListeners().length);
    assertEquals(0, component2.getComponentListeners().length);
    assertEquals(0, component.getFocusListeners().length);
    assertEquals(0, component2.getFocusListeners().length);
    assertEquals(0, component.getHierarchyBoundsListeners().length);
    assertEquals(0, component2.getHierarchyBoundsListeners().length);
    assertEquals(0, component.getHierarchyListeners().length);
    assertEquals(0, component2.getHierarchyListeners().length);
    assertEquals(0, component.getInputMethodListeners().length);
    assertEquals(0, component2.getInputMethodListeners().length);
    assertEquals(0, component.getKeyListeners().length);
    assertEquals(0, component2.getKeyListeners().length);
    assertEquals(0, component.getMouseListeners().length);
    assertEquals(0, component2.getMouseListeners().length);
    assertEquals(0, component.getMouseMotionListeners().length);
    assertEquals(0, component2.getMouseMotionListeners().length);
    assertEquals(0, component.getMouseWheelListeners().length);
    assertEquals(0, component2.getMouseWheelListeners().length);
    assertEquals(0, component.getPropertyChangeListeners().length);
    assertEquals(0, component2.getPropertyChangeListeners().length);
    assertEquals(0, ((Box) component2).getContainerListeners().length);
    assertEquals(0, ((JPanel) component).getContainerListeners().length);
    assertEquals(0, ((Box) component2).getAncestorListeners().length);
    assertEquals(0, ((JPanel) component).getAncestorListeners().length);
    assertEquals(0, ((Box) component2).getRegisteredKeyStrokes().length);
    assertEquals(0, ((JPanel) component).getRegisteredKeyStrokes().length);
    assertEquals(0, ((Box) component2).getVetoableChangeListeners().length);
    assertEquals(0, ((JPanel) component).getVetoableChangeListeners().length);
    double[][] layoutWeights = ((GridBagLayout) layout).getLayoutWeights();
    assertEquals(0, (layoutWeights[0]).length);
    assertEquals(0, (layoutWeights[1]).length);
    int[][] layoutDimensions = ((GridBagLayout) layout).getLayoutDimensions();
    assertEquals(0, (layoutDimensions[0]).length);
    assertEquals(0, (layoutDimensions[1]).length);
    assertEquals(0.0f, component.getAlignmentX());
    assertEquals(0.0f, component2.getAlignmentX());
    assertEquals(0.5f, component.getAlignmentY());
    assertEquals(0.5f, component2.getAlignmentY());
    assertEquals(1, ((JPanel) component).getComponentCount());
    assertEquals(1, components3.length);
    assertEquals(2, panel.getComponentCount());
    assertEquals(2, ((Box) component2).getComponentCount());
    assertEquals(2, components.length);
    assertEquals(2, components2.length);
    assertEquals(2, layoutDimensions.length);
    assertEquals(2, layoutWeights.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(2.147483647E9d, maximumSize.getHeight());
    assertEquals(2.147483647E9d, maximumSize.getWidth());
    Dimension minimumSize = component.getMinimumSize();
    assertEquals(208, minimumSize.width);
    Dimension minimumSize2 = panel.getMinimumSize();
    assertEquals(208, minimumSize2.width);
    assertEquals(208.0d, minimumSize2.getWidth());
    Dimension minimumSize3 = component2.getMinimumSize();
    assertEquals(24, minimumSize3.width);
    Dimension preferredSize = panel.getPreferredSize();
    assertEquals(300, preferredSize.width);
    assertEquals(300.0d, preferredSize.getWidth());
    Dimension maximumSize2 = component.getMaximumSize();
    assertEquals(32767, maximumSize2.height);
    assertEquals(32767, maximumSize2.width);
    Dimension maximumSize3 = component2.getMaximumSize();
    assertEquals(32767, maximumSize3.width);
    assertEquals(32794, maximumSize3.height);
    Dimension preferredSize2 = component2.getPreferredSize();
    assertEquals(430, preferredSize2.height);
    assertEquals(453, preferredSize2.width);
    assertEquals(49, minimumSize3.height);
    assertEquals(50, minimumSize.height);
    assertEquals(500, preferredSize.height);
    assertEquals(500.0d, preferredSize.getHeight());
    assertEquals(99, minimumSize2.height);
    assertEquals(99.0d, minimumSize2.getHeight());
    assertEquals(Component.BaselineResizeBehavior.OTHER, component.getBaselineResizeBehavior());
    assertEquals(Component.BaselineResizeBehavior.OTHER, component2.getBaselineResizeBehavior());
    assertFalse(component.getIgnoreRepaint());
    assertFalse(component2.getIgnoreRepaint());
    assertFalse(component.hasFocus());
    assertFalse(component2.hasFocus());
    assertFalse(component2.isBackgroundSet());
    assertFalse(component.isCursorSet());
    assertFalse(component2.isCursorSet());
    assertFalse(component.isDisplayable());
    assertFalse(component2.isDisplayable());
    assertFalse(component2.isDoubleBuffered());
    assertFalse(component.isFocusOwner());
    assertFalse(component2.isFocusOwner());
    assertFalse(component2.isFontSet());
    assertFalse(component2.isForegroundSet());
    assertFalse(component.isLightweight());
    assertFalse(component2.isLightweight());
    assertFalse(component.isMaximumSizeSet());
    assertFalse(component2.isMaximumSizeSet());
    assertFalse(component.isMinimumSizeSet());
    assertFalse(component2.isMinimumSizeSet());
    assertFalse(component2.isOpaque());
    assertFalse(component.isPreferredSizeSet());
    assertFalse(component2.isPreferredSizeSet());
    assertFalse(component.isShowing());
    assertFalse(component2.isShowing());
    assertFalse(component.isValid());
    assertFalse(component2.isValid());
    assertFalse(((Box) component2).isFocusCycleRoot());
    assertFalse(((JPanel) component).isFocusCycleRoot());
    assertFalse(((Box) component2).isFocusTraversalPolicyProvider());
    assertFalse(((JPanel) component).isFocusTraversalPolicyProvider());
    assertFalse(((Box) component2).isFocusTraversalPolicySet());
    assertFalse(((JPanel) component).isFocusTraversalPolicySet());
    assertFalse(((Box) component2).getAutoscrolls());
    assertFalse(((JPanel) component).getAutoscrolls());
    assertFalse(((Box) component2).getInheritsPopupMenu());
    assertFalse(((JPanel) component).getInheritsPopupMenu());
    assertFalse(((Box) component2).isManagingFocus());
    assertFalse(((JPanel) component).isManagingFocus());
    assertFalse(((Box) component2).isPaintingForPrint());
    assertFalse(((JPanel) component).isPaintingForPrint());
    assertFalse(((Box) component2).isPaintingTile());
    assertFalse(((JPanel) component).isPaintingTile());
    assertFalse(((Box) component2).isValidateRoot());
    assertFalse(((JPanel) component).isValidateRoot());
    assertTrue(component.getFocusTraversalKeysEnabled());
    assertTrue(component2.getFocusTraversalKeysEnabled());
    assertTrue(component.isBackgroundSet());
    assertTrue(component.isDoubleBuffered());
    assertTrue(component.isEnabled());
    assertTrue(component2.isEnabled());
    assertTrue(component.isFocusable());
    assertTrue(component2.isFocusable());
    assertTrue(component.isFontSet());
    assertTrue(component.isForegroundSet());
    assertTrue(component.isOpaque());
    assertTrue(panel.isPreferredSizeSet());
    assertTrue(component.isVisible());
    assertTrue(component2.isVisible());
    assertTrue(((Box) component2).getVerifyInputWhenFocusTarget());
    assertTrue(((JPanel) component).getVerifyInputWhenFocusTarget());
    assertTrue(((Box) component2).isOptimizedDrawingEnabled());
    assertTrue(((JPanel) component).isOptimizedDrawingEnabled());
    assertTrue(((Box) component2).isRequestFocusEnabled());
    assertTrue(((JPanel) component).isRequestFocusEnabled());
    Color background = panel.getBackground();
    Color brighterResult = background.brighter();
    Color brighterResult2 = brighterResult.brighter();
    assertEquals(brighterResult2, brighterResult.darker().brighter().brighter());
    assertEquals(brighterResult2, background.darker().brighter().brighter());
    assertEquals(brighterResult2, brighterResult2);
    assertEquals(boundsResult, component.bounds());
    assertEquals(boundsResult, component2.bounds());
    assertEquals(boundsResult, panel.getBounds());
    assertEquals(boundsResult, component.getBounds());
    assertEquals(boundsResult, component2.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, panel.getVisibleRect());
    assertEquals(boundsResult, ((Box) component2).getVisibleRect());
    assertEquals(boundsResult, ((JPanel) component).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Point location = panel.getLocation();
    assertEquals(location, component.getLocation());
    assertEquals(location, component2.getLocation());
    assertEquals(location, ((GridBagLayout) layout).getLayoutOrigin());
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    assertEquals(minimumSize, component.getPreferredSize());
    Dimension size = panel.getSize();
    assertEquals(size, component.getSize());
    assertEquals(size, component2.getSize());
    assertEquals(size, panel.size());
    assertEquals(size, component.size());
    assertEquals(size, component2.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    assertEquals(maximumSize, maximumSize.getSize());
    assertEquals(minimumSize2, minimumSize2.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
    assertEquals(Integer.MAX_VALUE, maximumSize.height);
    assertEquals(Integer.MAX_VALUE, maximumSize.width);
    assertSame(background, component.getBackground());
    assertSame(background, component2.getBackground());
    Color foreground = panel.getForeground();
    assertSame(foreground, component.getForeground());
    assertSame(foreground, component2.getForeground());
    Locale locale = panel.getLocale();
    assertSame(locale, component.getLocale());
    assertSame(locale, component2.getLocale());
    AccessibleContext accessibleContext = panel.getAccessibleContext();
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(panel, component.getParent());
    assertSame(panel, component2.getParent());
    assertSame(colorModel, component.getColorModel());
    assertSame(colorModel, component2.getColorModel());
  }

  /**
   * Test
   * {@link FlagBitsPaneView#FlagBitsPaneView(String, String, Object[][], String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Panel PreferredSize is Panel MinimumSize.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FlagBitsPaneView#FlagBitsPaneView(String, String, Object[][], String[])}
   */
  @Test
  @DisplayName("Test new FlagBitsPaneView(String, String, Object[][], String[]); when 'null'; then return Panel PreferredSize is Panel MinimumSize")
  void testNewFlagBitsPaneView_whenNull_thenReturnPanelPreferredSizeIsPanelMinimumSize() {
    // Arrange, Act and Assert
    JPanel panel = (new FlagBitsPaneView("Flag Header", null, new Object[][]{new Object[]{"Table Row Data"}},
        new String[]{"Column Names"})).getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(panel.getColorModel() instanceof DirectColorModel);
    Color background = panel.getBackground();
    Color brighterResult = background.brighter();
    Color brighterResult2 = brighterResult.brighter();
    assertEquals(brighterResult2, brighterResult.darker().brighter().brighter());
    assertEquals(brighterResult2, background.darker().brighter().brighter());
    assertEquals(brighterResult2, brighterResult2);
    assertEquals(boundsResult, panel.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, panel.getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Point location = panel.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    Dimension size = panel.getSize();
    assertEquals(size, panel.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(maximumSize, maximumSize.getSize());
    Dimension minimumSize = panel.getMinimumSize();
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, panel.getPreferredSize());
    AccessibleContext accessibleContext = panel.getAccessibleContext();
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
  }

  /**
   * Test
   * {@link FlagBitsPaneView#FlagBitsPaneView(String, String, Object[][], String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Panel PreferredSize is Panel MinimumSize.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FlagBitsPaneView#FlagBitsPaneView(String, String, Object[][], String[])}
   */
  @Test
  @DisplayName("Test new FlagBitsPaneView(String, String, Object[][], String[]); when 'null'; then return Panel PreferredSize is Panel MinimumSize")
  void testNewFlagBitsPaneView_whenNull_thenReturnPanelPreferredSizeIsPanelMinimumSize2() {
    // Arrange, Act and Assert
    JPanel panel = (new FlagBitsPaneView("Flag Header", "42", null, new String[]{"Column Names"})).getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(panel.getColorModel() instanceof DirectColorModel);
    Color background = panel.getBackground();
    Color brighterResult = background.brighter();
    Color brighterResult2 = brighterResult.brighter();
    assertEquals(brighterResult2, brighterResult.darker().brighter().brighter());
    assertEquals(brighterResult2, background.darker().brighter().brighter());
    assertEquals(brighterResult2, brighterResult2);
    assertEquals(boundsResult, panel.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, panel.getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Point location = panel.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    Dimension size = panel.getSize();
    assertEquals(size, panel.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(maximumSize, maximumSize.getSize());
    Dimension minimumSize = panel.getMinimumSize();
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, panel.getPreferredSize());
    AccessibleContext accessibleContext = panel.getAccessibleContext();
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
  }
}
