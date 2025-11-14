package org.apache.pdfbox.debugger.treestatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.DirectColorModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeListenerProxy;
import java.util.Locale;
import java.util.MissingResourceException;
import javax.accessibility.AccessibleContext;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TreeStatusPaneDiffblueTest {
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
   * Test {@link TreeStatusPane#getPanel()}.
   *
   * <p>Method under test: {@link TreeStatusPane#getPanel()}
   */
  @Test
  @DisplayName("Test getPanel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JPanel TreeStatusPane.getPanel()"})
  void testGetPanel() throws MissingResourceException {
    // Arrange and Act
    JPanel actualPanel = new TreeStatusPane(new JTree()).getPanel();

    // Assert
    assertTrue(actualPanel.getLayout() instanceof BorderLayout);
    Rectangle boundsResult = actualPanel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Color background = actualPanel.getBackground();
    ColorSpace colorSpace = background.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Double);
    assertTrue(actualPanel.getColorModel() instanceof DirectColorModel);
    Toolkit toolkit = actualPanel.getToolkit();
    PropertyChangeListener[] propertyChangeListeners = toolkit.getPropertyChangeListeners();
    assertTrue(propertyChangeListeners[0] instanceof PropertyChangeListenerProxy);
    Component[] components = actualPanel.getComponents();
    assertTrue(components[0] instanceof JTextField);
    Locale locale = actualPanel.getLocale();
    assertEquals("", locale.getCountry());
    assertEquals("", locale.getDisplayCountry());
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getISO3Country());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    Cursor cursor = actualPanel.getCursor();
    assertEquals("Default Cursor", cursor.getName());
    Font font = actualPanel.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("English", locale.getDisplayName());
    assertEquals("PanelUI", actualPanel.getUIClassID());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    assertNull(actualPanel.getNextFocusableComponent());
    assertNull(actualPanel.getFocusCycleRootAncestor());
    assertNull(actualPanel.getParent());
    assertNull(actualPanel.getTopLevelAncestor());
    assertNull(actualPanel.getFocusTraversalPolicy());
    assertNull(actualPanel.getGraphics());
    assertNull(actualPanel.getGraphicsConfiguration());
    assertNull(actualPanel.getDropTarget());
    assertNull(actualPanel.getInputContext());
    assertNull(actualPanel.getInputMethodRequests());
    ActionMap actionMap = actualPanel.getActionMap();
    assertNull(actionMap.keys());
    assertNull(actualPanel.getName());
    AccessibleContext accessibleContext = actualPanel.getAccessibleContext();
    assertNull(accessibleContext.getAccessibleDescription());
    assertNull(accessibleContext.getAccessibleName());
    assertNull(actualPanel.getToolTipText());
    assertNull(accessibleContext.getAccessibleParent());
    assertNull(accessibleContext.getAccessibleAction());
    assertNull(accessibleContext.getAccessibleEditableText());
    assertNull(accessibleContext.getAccessibleIcon());
    assertNull(accessibleContext.getAccessibleSelection());
    assertNull(accessibleContext.getAccessibleTable());
    assertNull(accessibleContext.getAccessibleText());
    assertNull(accessibleContext.getAccessibleValue());
    assertNull(actionMap.getParent());
    InputMap inputMap = actualPanel.getInputMap();
    assertNull(inputMap.getParent());
    assertNull(actualPanel.getInputVerifier());
    assertNull(actualPanel.getComponentPopupMenu());
    assertNull(actualPanel.getRootPane());
    assertNull(inputMap.keys());
    assertNull(actualPanel.getTransferHandler());
    assertNull(actualPanel.getBorder());
    Color brighterResult = background.brighter();
    assertEquals(-1, brighterResult.getRGB());
    Color foreground = actualPanel.getForeground();
    Color brighterResult2 = foreground.brighter();
    Color brighterResult3 = brighterResult2.brighter();
    assertEquals(-10066330, brighterResult3.getRGB());
    assertEquals(-1118482, background.getRGB());
    Color darkerResult = background.darker();
    Color darkerResult2 = darkerResult.darker();
    Color darkerResult3 = darkerResult2.darker();
    assertEquals(-11447983, darkerResult3.getRGB());
    Color brighterResult4 = darkerResult.brighter();
    assertEquals(-1184275, brighterResult4.getRGB());
    assertEquals(-12040120, brighterResult2.getRGB());
    assertEquals(-13421773, foreground.getRGB());
    Color darkerResult4 = brighterResult2.darker();
    assertEquals(-13487566, darkerResult4.getRGB());
    Color darkerResult5 = foreground.darker();
    assertEquals(-14474461, darkerResult5.getRGB());
    Color darkerResult6 = darkerResult5.darker();
    assertEquals(-15198184, darkerResult6.getRGB());
    Color darkerResult7 = brighterResult.darker();
    assertEquals(-5066062, darkerResult7.getRGB());
    assertEquals(-5855578, darkerResult.getRGB());
    Color darkerResult8 = brighterResult4.darker();
    assertEquals(-5921371, darkerResult8.getRGB());
    Color brighterResult5 = darkerResult7.brighter();
    assertEquals(-65794, brighterResult5.getRGB());
    Color darkerResult9 = darkerResult7.darker();
    assertEquals(-8618884, darkerResult9.getRGB());
    assertEquals(-9145228, darkerResult2.getRGB());
    assertEquals(0, cursor.getType());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, accessibleContext.getAccessibleRelationSet().size());
    assertEquals(0, actionMap.size());
    assertEquals(0, inputMap.size());
    assertEquals(0, actualPanel.getDebugGraphicsOptions());
    assertEquals(0, actualPanel.getHeight());
    assertEquals(0, actualPanel.getWidth());
    assertEquals(0, actualPanel.getX());
    assertEquals(0, actualPanel.getY());
    assertEquals(0, actualPanel.getComponentListeners().length);
    assertEquals(0, actualPanel.getFocusListeners().length);
    assertEquals(0, actualPanel.getHierarchyBoundsListeners().length);
    assertEquals(0, actualPanel.getHierarchyListeners().length);
    assertEquals(0, actualPanel.getInputMethodListeners().length);
    assertEquals(0, actualPanel.getKeyListeners().length);
    assertEquals(0, actualPanel.getMouseListeners().length);
    assertEquals(0, actualPanel.getMouseMotionListeners().length);
    assertEquals(0, actualPanel.getMouseWheelListeners().length);
    assertEquals(0, actualPanel.getPropertyChangeListeners().length);
    assertEquals(0, actualPanel.getContainerListeners().length);
    assertEquals(0, toolkit.getAWTEventListeners().length);
    assertEquals(0, actualPanel.getAncestorListeners().length);
    assertEquals(0, actualPanel.getRegisteredKeyStrokes().length);
    assertEquals(0, actualPanel.getVetoableChangeListeners().length);
    Dimension size = actualPanel.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Insets insets = actualPanel.getInsets();
    assertEquals(0, insets.bottom);
    assertEquals(0, insets.left);
    assertEquals(0, insets.right);
    assertEquals(0, insets.top);
    Point location = actualPanel.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, boundsResult.height);
    assertEquals(0, boundsResult.width);
    assertEquals(0, boundsResult.x);
    assertEquals(0, boundsResult.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, boundsResult.getHeight());
    assertEquals(0.0d, boundsResult.getWidth());
    assertEquals(0.0d, boundsResult.getX());
    assertEquals(0.0d, boundsResult.getY());
    assertEquals(0.0d, transform.getShearX());
    assertEquals(0.0d, transform.getShearY());
    assertEquals(0.0d, transform.getTranslateX());
    assertEquals(0.0d, transform.getTranslateY());
    assertEquals(0.0d, boundsResult.getCenterX());
    assertEquals(0.0d, boundsResult.getCenterY());
    assertEquals(0.0d, boundsResult.getMaxX());
    assertEquals(0.0d, boundsResult.getMaxY());
    assertEquals(0.0d, boundsResult.getMinX());
    assertEquals(0.0d, boundsResult.getMinY());
    assertEquals(0.0f, font.getItalicAngle());
    assertEquals(0.5f, actualPanel.getAlignmentX());
    assertEquals(0.5f, actualPanel.getAlignmentY());
    assertEquals(1, brighterResult3.getTransparency());
    assertEquals(1, brighterResult5.getTransparency());
    assertEquals(1, brighterResult4.getTransparency());
    assertEquals(1, brighterResult.getTransparency());
    assertEquals(1, brighterResult2.getTransparency());
    assertEquals(1, darkerResult8.getTransparency());
    assertEquals(1, darkerResult7.getTransparency());
    assertEquals(1, darkerResult4.getTransparency());
    assertEquals(1, darkerResult9.getTransparency());
    assertEquals(1, darkerResult3.getTransparency());
    assertEquals(1, darkerResult2.getTransparency());
    assertEquals(1, darkerResult6.getTransparency());
    assertEquals(1, darkerResult.getTransparency());
    assertEquals(1, darkerResult5.getTransparency());
    assertEquals(1, background.getTransparency());
    assertEquals(1, foreground.getTransparency());
    assertEquals(1, actualPanel.getComponentCount());
    assertEquals(1, components.length);
    assertEquals(1, propertyChangeListeners.length);
    assertEquals(1.0d, transform.getDeterminant());
    assertEquals(1.0d, transform.getScaleX());
    assertEquals(1.0d, transform.getScaleY());
    assertEquals(102, brighterResult3.getBlue());
    assertEquals(102, brighterResult3.getGreen());
    assertEquals(102, brighterResult3.getRed());
    assertEquals(116, darkerResult2.getBlue());
    assertEquals(116, darkerResult2.getGreen());
    assertEquals(116, darkerResult2.getRed());
    assertEquals(12, font.getSize());
    assertEquals(12.0f, font.getSize2D());
    assertEquals(124, darkerResult9.getBlue());
    assertEquals(124, darkerResult9.getGreen());
    assertEquals(124, darkerResult9.getRed());
    assertEquals(165, darkerResult8.getBlue());
    assertEquals(165, darkerResult8.getGreen());
    assertEquals(165, darkerResult8.getRed());
    assertEquals(166, darkerResult.getBlue());
    assertEquals(166, darkerResult.getGreen());
    assertEquals(166, darkerResult.getRed());
    assertEquals(178, darkerResult7.getBlue());
    assertEquals(178, darkerResult7.getGreen());
    assertEquals(178, darkerResult7.getRed());
    Dimension minimumSize = actualPanel.getMinimumSize();
    assertEquals(19, minimumSize.height);
    assertEquals(19.0d, minimumSize.getHeight());
    Dimension maximumSize = actualPanel.getMaximumSize();
    assertEquals(2.147483647E9d, maximumSize.getHeight());
    assertEquals(2.147483647E9d, maximumSize.getWidth());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(237, brighterResult4.getBlue());
    assertEquals(237, brighterResult4.getGreen());
    assertEquals(237, brighterResult4.getRed());
    assertEquals(238, background.getBlue());
    assertEquals(238, background.getGreen());
    assertEquals(238, background.getRed());
    assertEquals(24, darkerResult6.getBlue());
    assertEquals(24, darkerResult6.getGreen());
    assertEquals(24, darkerResult6.getRed());
    assertEquals(254, brighterResult5.getBlue());
    assertEquals(254, brighterResult5.getGreen());
    assertEquals(254, brighterResult5.getRed());
    assertEquals(255, brighterResult3.getAlpha());
    assertEquals(255, brighterResult5.getAlpha());
    assertEquals(255, brighterResult4.getAlpha());
    assertEquals(255, brighterResult.getAlpha());
    assertEquals(255, brighterResult2.getAlpha());
    assertEquals(255, darkerResult8.getAlpha());
    assertEquals(255, darkerResult7.getAlpha());
    assertEquals(255, darkerResult4.getAlpha());
    assertEquals(255, darkerResult9.getAlpha());
    assertEquals(255, darkerResult3.getAlpha());
    assertEquals(255, darkerResult2.getAlpha());
    assertEquals(255, darkerResult6.getAlpha());
    assertEquals(255, darkerResult.getAlpha());
    assertEquals(255, darkerResult5.getAlpha());
    assertEquals(255, background.getAlpha());
    assertEquals(255, foreground.getAlpha());
    assertEquals(255, brighterResult.getBlue());
    assertEquals(255, brighterResult.getGreen());
    assertEquals(255, brighterResult.getRed());
    assertEquals(35, darkerResult5.getBlue());
    assertEquals(35, darkerResult5.getGreen());
    assertEquals(35, darkerResult5.getRed());
    assertEquals(5, minimumSize.width);
    assertEquals(5.0d, minimumSize.getWidth());
    assertEquals(50, darkerResult4.getBlue());
    assertEquals(50, darkerResult4.getGreen());
    assertEquals(50, darkerResult4.getRed());
    assertEquals(51, foreground.getBlue());
    assertEquals(51, foreground.getGreen());
    assertEquals(51, foreground.getRed());
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(72, brighterResult2.getBlue());
    assertEquals(72, brighterResult2.getGreen());
    assertEquals(72, brighterResult2.getRed());
    assertEquals(8, font.getAttributes().size());
    assertEquals(81, darkerResult3.getBlue());
    assertEquals(81, darkerResult3.getGreen());
    assertEquals(81, darkerResult3.getRed());
    assertEquals(BaselineResizeBehavior.OTHER, actualPanel.getBaselineResizeBehavior());
    assertFalse(actualPanel.getIgnoreRepaint());
    assertFalse(actualPanel.hasFocus());
    assertFalse(actualPanel.isCursorSet());
    assertFalse(actualPanel.isDisplayable());
    assertFalse(actualPanel.isFocusOwner());
    assertFalse(actualPanel.isLightweight());
    assertFalse(actualPanel.isMaximumSizeSet());
    assertFalse(actualPanel.isMinimumSizeSet());
    assertFalse(actualPanel.isPreferredSizeSet());
    assertFalse(actualPanel.isShowing());
    assertFalse(actualPanel.isValid());
    assertFalse(actualPanel.isFocusCycleRoot());
    assertFalse(actualPanel.isFocusTraversalPolicyProvider());
    assertFalse(actualPanel.isFocusTraversalPolicySet());
    assertFalse(font.hasLayoutAttributes());
    assertFalse(font.hasUniformLineMetrics());
    assertFalse(font.isBold());
    assertFalse(font.isItalic());
    assertFalse(font.isTransformed());
    assertFalse(toolkit.isAlwaysOnTopSupported());
    assertFalse(locale.hasExtensions());
    assertFalse(actualPanel.getAutoscrolls());
    assertFalse(actualPanel.getInheritsPopupMenu());
    assertFalse(actualPanel.isManagingFocus());
    assertFalse(actualPanel.isPaintingForPrint());
    assertFalse(actualPanel.isPaintingTile());
    assertFalse(actualPanel.isValidateRoot());
    assertTrue(actualPanel.getFocusTraversalKeysEnabled());
    assertTrue(actualPanel.isBackgroundSet());
    assertTrue(actualPanel.isEnabled());
    assertTrue(actualPanel.isFocusable());
    assertTrue(actualPanel.isFontSet());
    assertTrue(actualPanel.isForegroundSet());
    assertTrue(actualPanel.isVisible());
    ComponentOrientation componentOrientation = actualPanel.getComponentOrientation();
    assertTrue(componentOrientation.isHorizontal());
    assertTrue(componentOrientation.isLeftToRight());
    assertTrue(font.isPlain());
    assertTrue(boundsResult.isEmpty());
    assertTrue(transform.isIdentity());
    assertTrue(locale.getExtensionKeys().isEmpty());
    assertTrue(actualPanel.getVerifyInputWhenFocusTarget());
    assertTrue(actualPanel.isDoubleBuffered());
    assertTrue(actualPanel.isOpaque());
    assertTrue(actualPanel.isOptimizedDrawingEnabled());
    assertTrue(actualPanel.isRequestFocusEnabled());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    assertEquals(Integer.MAX_VALUE, maximumSize.height);
    assertEquals(Integer.MAX_VALUE, maximumSize.width);
    assertSame(colorSpace, brighterResult3.getColorSpace());
    assertSame(colorSpace, brighterResult5.getColorSpace());
    assertSame(colorSpace, brighterResult4.getColorSpace());
    assertSame(colorSpace, brighterResult.getColorSpace());
    assertSame(colorSpace, brighterResult2.getColorSpace());
    assertSame(colorSpace, darkerResult8.getColorSpace());
    assertSame(colorSpace, darkerResult7.getColorSpace());
    assertSame(colorSpace, darkerResult4.getColorSpace());
    assertSame(colorSpace, darkerResult9.getColorSpace());
    assertSame(colorSpace, darkerResult3.getColorSpace());
    assertSame(colorSpace, darkerResult2.getColorSpace());
    assertSame(colorSpace, darkerResult6.getColorSpace());
    assertSame(colorSpace, darkerResult.getColorSpace());
    assertSame(colorSpace, darkerResult5.getColorSpace());
    assertSame(colorSpace, foreground.getColorSpace());
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
    // Arrange
    TreeStatusPane treeStatusPane = new TreeStatusPane(new JTree());

    // Act
    treeStatusPane.updateTreeStatus(new TreeStatus("Root Node"));

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
