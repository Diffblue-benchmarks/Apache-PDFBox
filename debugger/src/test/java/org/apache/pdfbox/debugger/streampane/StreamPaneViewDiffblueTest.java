package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Dictionary;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.AncestorListener;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
import org.apache.pdfbox.debugger.streampane.tooltip.ToolTipController;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StreamPaneViewDiffblueTest {
  /**
   * Test
   * {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}.
   * <ul>
   *   <li>Then {@link StreamPaneView} (default constructor) StreamPanel bounds
   * Bounds2D {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}
   */
  @Test
  @DisplayName("Test showStreamText(StyledDocument, ToolTipController); then StreamPaneView (default constructor) StreamPanel bounds Bounds2D Rectangle")
  void testShowStreamText_thenStreamPaneViewStreamPanelBoundsBounds2DRectangle() {
    // Arrange
    StreamPaneView streamPaneView = new StreamPaneView();
    DefaultStyledDocument document = new DefaultStyledDocument();

    // Act
    streamPaneView.showStreamText(document, new ToolTipController(new PDResources()));

    // Assert
    JPanel streamPanel = streamPaneView.getStreamPanel();
    Rectangle boundsResult = streamPanel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = streamPanel.getBounds();
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle bounds2 = boundsResult.getBounds();
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle bounds3 = bounds.getBounds();
    Rectangle2D bounds2D4 = bounds3.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle visibleRect = streamPanel.getVisibleRect();
    Rectangle2D bounds2D5 = visibleRect.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Dictionary<Object, Object> documentProperties = document.getDocumentProperties();
    assertTrue(documentProperties instanceof Map);
    Component[] components = streamPanel.getComponents();
    Component component = components[0];
    assertTrue(((JPanel) component).getLayout() instanceof BoxLayout);
    assertTrue(component instanceof JPanel);
    Component[] components2 = ((JPanel) component).getComponents();
    assertTrue(components2[0] instanceof JPanel);
    assertTrue(components2[1] instanceof JScrollPane);
    AncestorListener[] ancestorListeners = ((JPanel) component).getAncestorListeners();
    assertTrue(ancestorListeners[0] instanceof StreamTextView);
    assertEquals("PanelUI", ((JPanel) component).getUIClassID());
    assertNull(((JPanel) component).getNextFocusableComponent());
    assertNull(component.getFocusCycleRootAncestor());
    assertNull(((JPanel) component).getTopLevelAncestor());
    assertNull(((JPanel) component).getFocusTraversalPolicy());
    assertNull(component.getGraphics());
    assertNull(component.getGraphicsConfiguration());
    assertNull(component.getDropTarget());
    assertNull(component.getInputContext());
    assertNull(component.getInputMethodRequests());
    assertNull(component.getName());
    assertNull(((JPanel) component).getToolTipText());
    assertNull(((JPanel) component).getInputVerifier());
    assertNull(((JPanel) component).getComponentPopupMenu());
    assertNull(((JPanel) component).getRootPane());
    assertNull(((JPanel) component).getTransferHandler());
    assertNull(((JPanel) component).getBorder());
    assertEquals(0, component.getHeight());
    assertEquals(0, component.getWidth());
    assertEquals(0, component.getX());
    assertEquals(0, component.getY());
    assertEquals(0, ((JPanel) component).getDebugGraphicsOptions());
    assertEquals(0, component.getFocusListeners().length);
    assertEquals(0, component.getHierarchyBoundsListeners().length);
    assertEquals(0, component.getHierarchyListeners().length);
    assertEquals(0, component.getInputMethodListeners().length);
    assertEquals(0, component.getKeyListeners().length);
    assertEquals(0, component.getMouseListeners().length);
    assertEquals(0, component.getMouseMotionListeners().length);
    assertEquals(0, component.getMouseWheelListeners().length);
    assertEquals(0, ((JPanel) component).getContainerListeners().length);
    assertEquals(0, ((JPanel) component).getRegisteredKeyStrokes().length);
    assertEquals(0, ((JPanel) component).getVetoableChangeListeners().length);
    assertEquals(0.5f, component.getAlignmentX());
    assertEquals(0.5f, component.getAlignmentY());
    assertEquals(1, streamPanel.getComponentCount());
    assertEquals(1, component.getComponentListeners().length);
    assertEquals(1, component.getPropertyChangeListeners().length);
    assertEquals(1, components.length);
    assertEquals(1, ancestorListeners.length);
    Dimension preferredSize = streamPanel.getPreferredSize();
    assertEquals(10, preferredSize.width);
    assertEquals(10.0d, preferredSize.getWidth());
    assertEquals(2, ((JPanel) component).getComponentCount());
    assertEquals(2, documentProperties.size());
    assertEquals(2, components2.length);
    assertEquals(2, document.getDocumentListeners().length);
    Dimension minimumSize = streamPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    assertEquals(22, size3.height);
    assertEquals(22, size2.height);
    assertEquals(22, size.height);
    assertEquals(22, minimumSize.height);
    assertEquals(22, size3.width);
    assertEquals(22, size2.width);
    assertEquals(22, size.width);
    assertEquals(22, minimumSize.width);
    assertEquals(22.0d, size2.getHeight());
    assertEquals(22.0d, size.getHeight());
    assertEquals(22.0d, minimumSize.getHeight());
    assertEquals(22.0d, size2.getWidth());
    assertEquals(22.0d, size.getWidth());
    assertEquals(22.0d, minimumSize.getWidth());
    assertEquals(27, preferredSize.height);
    assertEquals(27.0d, preferredSize.getHeight());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(32767, maximumSize.height);
    assertEquals(32767, maximumSize.width);
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
    assertFalse(((JPanel) component).isFocusCycleRoot());
    assertFalse(((JPanel) component).isFocusTraversalPolicyProvider());
    assertFalse(((JPanel) component).isFocusTraversalPolicySet());
    assertFalse(((JPanel) component).getAutoscrolls());
    assertFalse(((JPanel) component).getInheritsPopupMenu());
    assertFalse(((JPanel) component).isManagingFocus());
    assertFalse(((JPanel) component).isPaintingForPrint());
    assertFalse(((JPanel) component).isPaintingTile());
    assertFalse(((JPanel) component).isValidateRoot());
    assertTrue(component.getFocusTraversalKeysEnabled());
    assertTrue(component.isBackgroundSet());
    assertTrue(component.isDoubleBuffered());
    assertTrue(component.isEnabled());
    assertTrue(component.isFocusable());
    assertTrue(component.isFontSet());
    assertTrue(component.isForegroundSet());
    assertTrue(component.isOpaque());
    assertTrue(component.isVisible());
    assertTrue(((Map<Object, Boolean>) documentProperties).containsKey("i18n"));
    assertTrue(((JPanel) component).getVerifyInputWhenFocusTarget());
    assertTrue(((JPanel) component).isOptimizedDrawingEnabled());
    assertTrue(((JPanel) component).isRequestFocusEnabled());
    assertEquals(boundsResult, component.bounds());
    assertEquals(boundsResult, component.getBounds());
    assertEquals(boundsResult, ((JPanel) component).getVisibleRect());
    Dimension size4 = streamPanel.getSize();
    assertEquals(size4, component.getSize());
    assertEquals(size4, streamPanel.size());
    assertEquals(size4, component.size());
    assertEquals(size4, size4.getSize());
    assertEquals(size4, bounds3.getSize().getSize());
    Rectangle bounds4 = bounds2.getBounds();
    Dimension size5 = bounds4.getSize();
    assertEquals(size4, size5.getSize());
    Rectangle bounds5 = bounds3.getBounds();
    assertEquals(size4, bounds5.getSize().getSize());
    Rectangle bounds6 = visibleRect.getBounds();
    assertEquals(size4, bounds6.getSize().getSize());
    assertEquals(size4, ((Rectangle) bounds2D).getSize().getSize());
    assertEquals(size4, boundsResult.getSize());
    assertEquals(size4, bounds.getSize());
    assertEquals(size4, bounds2.getSize());
    assertEquals(size4, size5);
    assertEquals(size4, bounds4.getBounds().getSize());
    assertEquals(size4, bounds5.getBounds().getSize());
    assertEquals(size4, bounds6.getBounds().getSize());
    assertEquals(size4, bounds2D.getBounds().getSize());
    assertEquals(size4, frame.getBounds().getSize());
    assertEquals(size4, visibleRect.getSize());
    assertEquals(size4, ((Rectangle) bounds2D2).getSize());
    assertEquals(size4, ((Rectangle) bounds2D3).getSize());
    assertEquals(size4, ((Rectangle) bounds2D4).getSize());
    assertEquals(size4, ((Rectangle) bounds2D5).getSize());
    assertEquals(minimumSize, component.getMinimumSize());
    assertEquals(preferredSize, component.getPreferredSize());
    assertEquals(preferredSize, preferredSize.getSize());
    assertSame(streamPanel, component.getParent());
  }

  /**
   * Test
   * {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}.
   * <ul>
   *   <li>When {@link ToolTipController#ToolTipController(PDResources)} with
   * resources is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}
   */
  @Test
  @DisplayName("Test showStreamText(StyledDocument, ToolTipController); when ToolTipController(PDResources) with resources is 'null'")
  void testShowStreamText_whenToolTipControllerWithResourcesIsNull() {
    // Arrange
    StreamPaneView streamPaneView = new StreamPaneView();
    DefaultStyledDocument document = new DefaultStyledDocument();

    // Act
    streamPaneView.showStreamText(document, new ToolTipController(null));

    // Assert
    JPanel streamPanel = streamPaneView.getStreamPanel();
    Rectangle boundsResult = streamPanel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = streamPanel.getBounds();
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle bounds2 = boundsResult.getBounds();
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle bounds3 = bounds.getBounds();
    Rectangle2D bounds2D4 = bounds3.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle visibleRect = streamPanel.getVisibleRect();
    Rectangle2D bounds2D5 = visibleRect.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Dictionary<Object, Object> documentProperties = document.getDocumentProperties();
    assertTrue(documentProperties instanceof Map);
    Component[] components = streamPanel.getComponents();
    Component component = components[0];
    assertTrue(((JPanel) component).getLayout() instanceof BoxLayout);
    assertTrue(component instanceof JPanel);
    Component[] components2 = ((JPanel) component).getComponents();
    assertTrue(components2[0] instanceof JPanel);
    assertTrue(components2[1] instanceof JScrollPane);
    AncestorListener[] ancestorListeners = ((JPanel) component).getAncestorListeners();
    assertTrue(ancestorListeners[0] instanceof StreamTextView);
    assertEquals("PanelUI", ((JPanel) component).getUIClassID());
    assertNull(((JPanel) component).getNextFocusableComponent());
    assertNull(component.getFocusCycleRootAncestor());
    assertNull(((JPanel) component).getTopLevelAncestor());
    assertNull(((JPanel) component).getFocusTraversalPolicy());
    assertNull(component.getGraphics());
    assertNull(component.getGraphicsConfiguration());
    assertNull(component.getDropTarget());
    assertNull(component.getInputContext());
    assertNull(component.getInputMethodRequests());
    assertNull(component.getName());
    assertNull(((JPanel) component).getToolTipText());
    assertNull(((JPanel) component).getInputVerifier());
    assertNull(((JPanel) component).getComponentPopupMenu());
    assertNull(((JPanel) component).getRootPane());
    assertNull(((JPanel) component).getTransferHandler());
    assertNull(((JPanel) component).getBorder());
    assertEquals(0, component.getHeight());
    assertEquals(0, component.getWidth());
    assertEquals(0, component.getX());
    assertEquals(0, component.getY());
    assertEquals(0, ((JPanel) component).getDebugGraphicsOptions());
    assertEquals(0, component.getFocusListeners().length);
    assertEquals(0, component.getHierarchyBoundsListeners().length);
    assertEquals(0, component.getHierarchyListeners().length);
    assertEquals(0, component.getInputMethodListeners().length);
    assertEquals(0, component.getKeyListeners().length);
    assertEquals(0, component.getMouseListeners().length);
    assertEquals(0, component.getMouseMotionListeners().length);
    assertEquals(0, component.getMouseWheelListeners().length);
    assertEquals(0, ((JPanel) component).getContainerListeners().length);
    assertEquals(0, ((JPanel) component).getRegisteredKeyStrokes().length);
    assertEquals(0, ((JPanel) component).getVetoableChangeListeners().length);
    assertEquals(0.5f, component.getAlignmentX());
    assertEquals(0.5f, component.getAlignmentY());
    assertEquals(1, streamPanel.getComponentCount());
    assertEquals(1, component.getComponentListeners().length);
    assertEquals(1, component.getPropertyChangeListeners().length);
    assertEquals(1, components.length);
    assertEquals(1, ancestorListeners.length);
    Dimension preferredSize = streamPanel.getPreferredSize();
    assertEquals(10, preferredSize.width);
    assertEquals(10.0d, preferredSize.getWidth());
    assertEquals(2, ((JPanel) component).getComponentCount());
    assertEquals(2, documentProperties.size());
    assertEquals(2, components2.length);
    assertEquals(2, document.getDocumentListeners().length);
    Dimension minimumSize = streamPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    assertEquals(22, size3.height);
    assertEquals(22, size2.height);
    assertEquals(22, size.height);
    assertEquals(22, minimumSize.height);
    assertEquals(22, size3.width);
    assertEquals(22, size2.width);
    assertEquals(22, size.width);
    assertEquals(22, minimumSize.width);
    assertEquals(22.0d, size2.getHeight());
    assertEquals(22.0d, size.getHeight());
    assertEquals(22.0d, minimumSize.getHeight());
    assertEquals(22.0d, size2.getWidth());
    assertEquals(22.0d, size.getWidth());
    assertEquals(22.0d, minimumSize.getWidth());
    assertEquals(27, preferredSize.height);
    assertEquals(27.0d, preferredSize.getHeight());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(32767, maximumSize.height);
    assertEquals(32767, maximumSize.width);
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
    assertFalse(((JPanel) component).isFocusCycleRoot());
    assertFalse(((JPanel) component).isFocusTraversalPolicyProvider());
    assertFalse(((JPanel) component).isFocusTraversalPolicySet());
    assertFalse(((JPanel) component).getAutoscrolls());
    assertFalse(((JPanel) component).getInheritsPopupMenu());
    assertFalse(((JPanel) component).isManagingFocus());
    assertFalse(((JPanel) component).isPaintingForPrint());
    assertFalse(((JPanel) component).isPaintingTile());
    assertFalse(((JPanel) component).isValidateRoot());
    assertTrue(component.getFocusTraversalKeysEnabled());
    assertTrue(component.isBackgroundSet());
    assertTrue(component.isDoubleBuffered());
    assertTrue(component.isEnabled());
    assertTrue(component.isFocusable());
    assertTrue(component.isFontSet());
    assertTrue(component.isForegroundSet());
    assertTrue(component.isOpaque());
    assertTrue(component.isVisible());
    assertTrue(((Map<Object, Boolean>) documentProperties).containsKey("i18n"));
    assertTrue(((JPanel) component).getVerifyInputWhenFocusTarget());
    assertTrue(((JPanel) component).isOptimizedDrawingEnabled());
    assertTrue(((JPanel) component).isRequestFocusEnabled());
    assertEquals(boundsResult, component.bounds());
    assertEquals(boundsResult, component.getBounds());
    assertEquals(boundsResult, ((JPanel) component).getVisibleRect());
    Dimension size4 = streamPanel.getSize();
    assertEquals(size4, component.getSize());
    assertEquals(size4, streamPanel.size());
    assertEquals(size4, component.size());
    assertEquals(size4, size4.getSize());
    assertEquals(size4, bounds3.getSize().getSize());
    Rectangle bounds4 = bounds2.getBounds();
    Dimension size5 = bounds4.getSize();
    assertEquals(size4, size5.getSize());
    Rectangle bounds5 = bounds3.getBounds();
    assertEquals(size4, bounds5.getSize().getSize());
    Rectangle bounds6 = visibleRect.getBounds();
    assertEquals(size4, bounds6.getSize().getSize());
    assertEquals(size4, ((Rectangle) bounds2D).getSize().getSize());
    assertEquals(size4, boundsResult.getSize());
    assertEquals(size4, bounds.getSize());
    assertEquals(size4, bounds2.getSize());
    assertEquals(size4, size5);
    assertEquals(size4, bounds4.getBounds().getSize());
    assertEquals(size4, bounds5.getBounds().getSize());
    assertEquals(size4, bounds6.getBounds().getSize());
    assertEquals(size4, bounds2D.getBounds().getSize());
    assertEquals(size4, frame.getBounds().getSize());
    assertEquals(size4, visibleRect.getSize());
    assertEquals(size4, ((Rectangle) bounds2D2).getSize());
    assertEquals(size4, ((Rectangle) bounds2D3).getSize());
    assertEquals(size4, ((Rectangle) bounds2D4).getSize());
    assertEquals(size4, ((Rectangle) bounds2D5).getSize());
    assertEquals(minimumSize, component.getMinimumSize());
    assertEquals(preferredSize, component.getPreferredSize());
    assertEquals(preferredSize, preferredSize.getSize());
    assertSame(streamPanel, component.getParent());
  }
}
