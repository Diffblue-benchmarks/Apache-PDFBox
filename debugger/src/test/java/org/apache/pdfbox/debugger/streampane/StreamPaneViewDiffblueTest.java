package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.DirectColorModel;
import javax.swing.JPanel;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import org.apache.pdfbox.debugger.streampane.tooltip.ToolTipController;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StreamPaneViewDiffblueTest {
  /**
   * Test new {@link StreamPaneView} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StreamPaneView}
   */
  @Test
  @DisplayName("Test new StreamPaneView (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamPaneView.<init>()"})
  void testNewStreamPaneView() {
    // Arrange, Act and Assert
    JPanel streamPanel = new StreamPaneView().getStreamPanel();
    assertTrue(streamPanel.getLayout() instanceof BorderLayout);
    assertTrue(streamPanel.getColorModel() instanceof DirectColorModel);
    assertEquals("PanelUI", streamPanel.getUIClassID());
    assertNull(streamPanel.getNextFocusableComponent());
    assertNull(streamPanel.getFocusCycleRootAncestor());
    assertNull(streamPanel.getParent());
    assertNull(streamPanel.getTopLevelAncestor());
    assertNull(streamPanel.getFocusTraversalPolicy());
    assertNull(streamPanel.getGraphics());
    assertNull(streamPanel.getGraphicsConfiguration());
    assertNull(streamPanel.getDropTarget());
    assertNull(streamPanel.getInputContext());
    assertNull(streamPanel.getInputMethodRequests());
    assertNull(streamPanel.getName());
    assertNull(streamPanel.getToolTipText());
    assertNull(streamPanel.getInputVerifier());
    assertNull(streamPanel.getComponentPopupMenu());
    assertNull(streamPanel.getRootPane());
    assertNull(streamPanel.getTransferHandler());
    assertNull(streamPanel.getBorder());
    assertEquals(0, streamPanel.getComponentCount());
    assertEquals(0, streamPanel.getDebugGraphicsOptions());
    assertEquals(0, streamPanel.getHeight());
    assertEquals(0, streamPanel.getWidth());
    assertEquals(0, streamPanel.getX());
    assertEquals(0, streamPanel.getY());
    assertEquals(0, streamPanel.getComponentListeners().length);
    assertEquals(0, streamPanel.getFocusListeners().length);
    assertEquals(0, streamPanel.getHierarchyBoundsListeners().length);
    assertEquals(0, streamPanel.getHierarchyListeners().length);
    assertEquals(0, streamPanel.getInputMethodListeners().length);
    assertEquals(0, streamPanel.getKeyListeners().length);
    assertEquals(0, streamPanel.getMouseListeners().length);
    assertEquals(0, streamPanel.getMouseMotionListeners().length);
    assertEquals(0, streamPanel.getMouseWheelListeners().length);
    assertEquals(0, streamPanel.getPropertyChangeListeners().length);
    assertEquals(0, streamPanel.getComponents().length);
    assertEquals(0, streamPanel.getContainerListeners().length);
    assertEquals(0, streamPanel.getAncestorListeners().length);
    assertEquals(0, streamPanel.getRegisteredKeyStrokes().length);
    assertEquals(0, streamPanel.getVetoableChangeListeners().length);
    assertEquals(0.5f, streamPanel.getAlignmentX());
    assertEquals(0.5f, streamPanel.getAlignmentY());
    assertEquals(BaselineResizeBehavior.OTHER, streamPanel.getBaselineResizeBehavior());
    assertFalse(streamPanel.getIgnoreRepaint());
    assertFalse(streamPanel.hasFocus());
    assertFalse(streamPanel.isCursorSet());
    assertFalse(streamPanel.isDisplayable());
    assertFalse(streamPanel.isFocusOwner());
    assertFalse(streamPanel.isLightweight());
    assertFalse(streamPanel.isMaximumSizeSet());
    assertFalse(streamPanel.isMinimumSizeSet());
    assertFalse(streamPanel.isPreferredSizeSet());
    assertFalse(streamPanel.isShowing());
    assertFalse(streamPanel.isValid());
    assertFalse(streamPanel.isFocusCycleRoot());
    assertFalse(streamPanel.isFocusTraversalPolicyProvider());
    assertFalse(streamPanel.isFocusTraversalPolicySet());
    assertFalse(streamPanel.getAutoscrolls());
    assertFalse(streamPanel.getInheritsPopupMenu());
    assertFalse(streamPanel.isManagingFocus());
    assertFalse(streamPanel.isPaintingForPrint());
    assertFalse(streamPanel.isPaintingTile());
    assertFalse(streamPanel.isValidateRoot());
    assertTrue(streamPanel.getFocusTraversalKeysEnabled());
    assertTrue(streamPanel.isBackgroundSet());
    assertTrue(streamPanel.isEnabled());
    assertTrue(streamPanel.isFocusable());
    assertTrue(streamPanel.isFontSet());
    assertTrue(streamPanel.isForegroundSet());
    assertTrue(streamPanel.isVisible());
    assertTrue(streamPanel.getVerifyInputWhenFocusTarget());
    assertTrue(streamPanel.isDoubleBuffered());
    assertTrue(streamPanel.isOpaque());
    assertTrue(streamPanel.isOptimizedDrawingEnabled());
    assertTrue(streamPanel.isRequestFocusEnabled());
  }

  /**
   * Test {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}.
   *
   * <ul>
   *   <li>Given {@link UndoableEditListener}.
   * </ul>
   *
   * <p>Method under test: {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}
   */
  @Test
  @DisplayName("Test showStreamText(StyledDocument, ToolTipController); given UndoableEditListener")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamPaneView.showStreamText(StyledDocument, ToolTipController)"})
  void testShowStreamText_givenUndoableEditListener() {
    // Arrange
    StreamPaneView streamPaneView = new StreamPaneView();

    DefaultStyledDocument document = new DefaultStyledDocument();
    document.addUndoableEditListener(mock(UndoableEditListener.class));

    // Act
    streamPaneView.showStreamText(document, new ToolTipController(new PDResources()));

    // Assert
    JPanel streamPanel = streamPaneView.getStreamPanel();
    assertTrue(streamPanel.getBounds().getBounds().getBounds2D() instanceof Rectangle);
    Component[] components = streamPanel.getComponents();
    Component component = components[0];
    assertTrue(component instanceof JPanel);
    assertEquals(1, components.length);
    assertEquals(26, component.getPreferredSize().height);
    Dimension preferredSize = streamPanel.getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(26, size2.getSize().height);
    assertEquals(26, size2.height);
    assertEquals(26, size.height);
    assertEquals(26, preferredSize.height);
    assertEquals(26.0d, size2.getHeight());
    assertEquals(26.0d, size.getHeight());
    assertEquals(26.0d, preferredSize.getHeight());
  }

  /**
   * Test {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}.
   *
   * <ul>
   *   <li>Then first element PreferredSize {@link Dimension#height} is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}
   */
  @Test
  @DisplayName(
      "Test showStreamText(StyledDocument, ToolTipController); then first element PreferredSize height is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamPaneView.showStreamText(StyledDocument, ToolTipController)"})
  void testShowStreamText_thenFirstElementPreferredSizeHeightIsTwentyFour() {
    // Arrange
    StreamPaneView streamPaneView = new StreamPaneView();
    HTMLDocument document = new HTMLDocument();

    // Act
    streamPaneView.showStreamText(document, new ToolTipController(new PDResources()));

    // Assert
    JPanel streamPanel = streamPaneView.getStreamPanel();
    Component[] components = streamPanel.getComponents();
    Component component = components[0];
    assertTrue(component instanceof JPanel);
    assertEquals(1, components.length);
    assertEquals(1, document.getStyleSheet().getChangeListeners().length);
    assertEquals(24, component.getPreferredSize().height);
    Dimension preferredSize = streamPanel.getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(24, size2.getSize().height);
    assertEquals(24, size2.height);
    assertEquals(24, size.height);
    assertEquals(24, preferredSize.height);
    assertEquals(24.0d, size2.getHeight());
    assertEquals(24.0d, size.getHeight());
    assertEquals(24.0d, preferredSize.getHeight());
  }

  /**
   * Test {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}.
   *
   * <ul>
   *   <li>When {@link DefaultStyledDocument#DefaultStyledDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}
   */
  @Test
  @DisplayName(
      "Test showStreamText(StyledDocument, ToolTipController); when DefaultStyledDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamPaneView.showStreamText(StyledDocument, ToolTipController)"})
  void testShowStreamText_whenDefaultStyledDocument() {
    // Arrange
    StreamPaneView streamPaneView = new StreamPaneView();
    DefaultStyledDocument document = new DefaultStyledDocument();

    // Act
    streamPaneView.showStreamText(document, new ToolTipController(new PDResources()));

    // Assert
    JPanel streamPanel = streamPaneView.getStreamPanel();
    assertTrue(streamPanel.getBounds().getBounds().getBounds2D() instanceof Rectangle);
    Component[] components = streamPanel.getComponents();
    Component component = components[0];
    assertTrue(component instanceof JPanel);
    assertEquals(1, components.length);
    assertEquals(26, component.getPreferredSize().height);
    Dimension preferredSize = streamPanel.getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(26, size2.getSize().height);
    assertEquals(26, size2.height);
    assertEquals(26, size.height);
    assertEquals(26, preferredSize.height);
    assertEquals(26.0d, size2.getHeight());
    assertEquals(26.0d, size.getHeight());
    assertEquals(26.0d, preferredSize.getHeight());
  }
}
