package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.image.DirectColorModel;
import java.util.Dictionary;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.GapContent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import org.apache.pdfbox.debugger.streampane.tooltip.ToolTipController;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StreamPaneViewDiffblueTest {
  /**
   * Test new {@link StreamPaneView} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link StreamPaneView}
   */
  @Test
  @DisplayName("Test new StreamPaneView (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StreamPaneView.<init>()"})
  void testNewStreamPaneView() {
    // Arrange, Act and Assert
    JPanel streamPanel = (new StreamPaneView()).getStreamPanel();
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
   * <p>
   * Method under test: {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}
   */
  @Test
  @DisplayName("Test showStreamText(StyledDocument, ToolTipController)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StreamPaneView.showStreamText(StyledDocument, ToolTipController)"})
  void testShowStreamText() {
    // Arrange
    StreamPaneView streamPaneView = new StreamPaneView();
    GapContent gapContent = new GapContent(13);
    DefaultStyledDocument document = new DefaultStyledDocument(gapContent, StyleContext.getDefaultStyleContext());

    // Act
    streamPaneView.showStreamText(document, new ToolTipController(new PDResources()));

    // Assert
    Dictionary<Object, Object> documentProperties = document.getDocumentProperties();
    assertTrue(documentProperties instanceof Map);
    JPanel streamPanel = streamPaneView.getStreamPanel();
    assertEquals(1, streamPanel.getComponentCount());
    assertEquals(1, streamPanel.getComponents().length);
    assertEquals(2, documentProperties.size());
    assertEquals(2, document.getDocumentListeners().length);
    assertTrue(((Map<Object, Boolean>) documentProperties).containsKey("i18n"));
  }

  /**
   * Test {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}.
   * <ul>
   *   <li>Given {@link SimpleAttributeSet#SimpleAttributeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}
   */
  @Test
  @DisplayName("Test showStreamText(StyledDocument, ToolTipController); given SimpleAttributeSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StreamPaneView.showStreamText(StyledDocument, ToolTipController)"})
  void testShowStreamText_givenSimpleAttributeSet() {
    // Arrange
    StreamPaneView streamPaneView = new StreamPaneView();
    StyleContext defaultStyleContext = StyleContext.getDefaultStyleContext();
    SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
    defaultStyleContext.addAttributes(simpleAttributeSet, new SimpleAttributeSet());
    DefaultStyledDocument document = new DefaultStyledDocument(new GapContent(13), defaultStyleContext);

    // Act
    streamPaneView.showStreamText(document, new ToolTipController(new PDResources()));

    // Assert
    Dictionary<Object, Object> documentProperties = document.getDocumentProperties();
    assertTrue(documentProperties instanceof Map);
    JPanel streamPanel = streamPaneView.getStreamPanel();
    assertEquals(1, streamPanel.getComponentCount());
    assertEquals(1, streamPanel.getComponents().length);
    assertEquals(2, documentProperties.size());
    assertEquals(2, document.getDocumentListeners().length);
    assertTrue(((Map<Object, Boolean>) documentProperties).containsKey("i18n"));
  }

  /**
   * Test {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}.
   * <ul>
   *   <li>Then {@link DefaultStyledDocument#DefaultStyledDocument()} DocumentProperties size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}
   */
  @Test
  @DisplayName("Test showStreamText(StyledDocument, ToolTipController); then DefaultStyledDocument() DocumentProperties size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StreamPaneView.showStreamText(StyledDocument, ToolTipController)"})
  void testShowStreamText_thenDefaultStyledDocumentDocumentPropertiesSizeIsThree() {
    // Arrange
    StreamPaneView streamPaneView = new StreamPaneView();

    DefaultStyledDocument document = new DefaultStyledDocument();
    document.putProperty("42", 0);

    // Act
    streamPaneView.showStreamText(document, new ToolTipController(new PDResources()));

    // Assert
    Dictionary<Object, Object> documentProperties = document.getDocumentProperties();
    assertTrue(documentProperties instanceof Map);
    JPanel streamPanel = streamPaneView.getStreamPanel();
    assertEquals(1, streamPanel.getComponentCount());
    assertEquals(1, streamPanel.getComponents().length);
    assertEquals(2, document.getDocumentListeners().length);
    assertEquals(3, documentProperties.size());
    assertTrue(((Map<Object, Object>) documentProperties).containsKey("42"));
    assertTrue(((Map<Object, Object>) documentProperties).containsKey("i18n"));
  }

  /**
   * Test {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}.
   * <ul>
   *   <li>Then {@link DefaultStyledDocument#DefaultStyledDocument()} DocumentProperties size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamPaneView#showStreamText(StyledDocument, ToolTipController)}
   */
  @Test
  @DisplayName("Test showStreamText(StyledDocument, ToolTipController); then DefaultStyledDocument() DocumentProperties size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StreamPaneView.showStreamText(StyledDocument, ToolTipController)"})
  void testShowStreamText_thenDefaultStyledDocumentDocumentPropertiesSizeIsTwo() {
    // Arrange
    StreamPaneView streamPaneView = new StreamPaneView();
    DefaultStyledDocument document = new DefaultStyledDocument();

    // Act
    streamPaneView.showStreamText(document, new ToolTipController(new PDResources()));

    // Assert
    Dictionary<Object, Object> documentProperties = document.getDocumentProperties();
    assertTrue(documentProperties instanceof Map);
    JPanel streamPanel = streamPaneView.getStreamPanel();
    assertEquals(1, streamPanel.getComponentCount());
    assertEquals(1, streamPanel.getComponents().length);
    assertEquals(2, documentProperties.size());
    assertEquals(2, document.getDocumentListeners().length);
    assertTrue(((Map<Object, Boolean>) documentProperties).containsKey("i18n"));
  }
}
