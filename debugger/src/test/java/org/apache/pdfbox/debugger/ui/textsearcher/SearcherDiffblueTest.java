package org.apache.pdfbox.debugger.ui.textsearcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.DirectColorModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.JTextComponent;
import javax.swing.text.SimpleAttributeSet;
import org.apache.pdfbox.debugger.PDFDebugger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SearcherDiffblueTest {
  /**
   * Test {@link Searcher#Searcher(JTextComponent)}.
   *
   * <ul>
   *   <li>When {@link JEditorPane#JEditorPane()}.
   *   <li>Then SearchPanel ColorModel return {@link DirectColorModel}.
   * </ul>
   *
   * <p>Method under test: {@link Searcher#Searcher(JTextComponent)}
   */
  @Test
  @DisplayName(
      "Test new Searcher(JTextComponent); when JEditorPane(); then SearchPanel ColorModel return DirectColorModel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.<init>(JTextComponent)"})
  void testNewSearcher_whenJEditorPane_thenSearchPanelColorModelReturnDirectColorModel() {
    // Arrange, Act and Assert
    JPanel searchPanel = new Searcher(new JEditorPane()).getSearchPanel();
    assertTrue(searchPanel.getColorModel() instanceof DirectColorModel);
    assertTrue(searchPanel.getLayout() instanceof BoxLayout);
    assertTrue(searchPanel.getBorder() instanceof MatteBorder);
    assertEquals("PanelUI", searchPanel.getUIClassID());
    assertNull(searchPanel.getNextFocusableComponent());
    assertNull(searchPanel.getFocusCycleRootAncestor());
    assertNull(searchPanel.getParent());
    assertNull(searchPanel.getTopLevelAncestor());
    assertNull(searchPanel.getFocusTraversalPolicy());
    assertNull(searchPanel.getGraphics());
    assertNull(searchPanel.getGraphicsConfiguration());
    assertNull(searchPanel.getDropTarget());
    assertNull(searchPanel.getInputContext());
    assertNull(searchPanel.getInputMethodRequests());
    assertNull(searchPanel.getName());
    assertNull(searchPanel.getToolTipText());
    assertNull(searchPanel.getInputVerifier());
    assertNull(searchPanel.getComponentPopupMenu());
    assertNull(searchPanel.getRootPane());
    assertNull(searchPanel.getTransferHandler());
    assertEquals(0, searchPanel.getDebugGraphicsOptions());
    assertEquals(0, searchPanel.getHeight());
    assertEquals(0, searchPanel.getWidth());
    assertEquals(0, searchPanel.getX());
    assertEquals(0, searchPanel.getY());
    assertEquals(0, searchPanel.getFocusListeners().length);
    assertEquals(0, searchPanel.getHierarchyBoundsListeners().length);
    assertEquals(0, searchPanel.getHierarchyListeners().length);
    assertEquals(0, searchPanel.getInputMethodListeners().length);
    assertEquals(0, searchPanel.getKeyListeners().length);
    assertEquals(0, searchPanel.getMouseListeners().length);
    assertEquals(0, searchPanel.getMouseMotionListeners().length);
    assertEquals(0, searchPanel.getMouseWheelListeners().length);
    assertEquals(0, searchPanel.getPropertyChangeListeners().length);
    assertEquals(0, searchPanel.getContainerListeners().length);
    assertEquals(0, searchPanel.getAncestorListeners().length);
    assertEquals(0, searchPanel.getRegisteredKeyStrokes().length);
    assertEquals(0, searchPanel.getVetoableChangeListeners().length);
    assertEquals(0.48f, searchPanel.getAlignmentY());
    assertEquals(0.5f, searchPanel.getAlignmentX());
    assertEquals(1, searchPanel.getComponentListeners().length);
    assertEquals(8, searchPanel.getComponentCount());
    assertEquals(8, searchPanel.getComponents().length);
    assertEquals(BaselineResizeBehavior.OTHER, searchPanel.getBaselineResizeBehavior());
    assertFalse(searchPanel.getIgnoreRepaint());
    assertFalse(searchPanel.hasFocus());
    assertFalse(searchPanel.isCursorSet());
    assertFalse(searchPanel.isDisplayable());
    assertFalse(searchPanel.isFocusOwner());
    assertFalse(searchPanel.isLightweight());
    assertFalse(searchPanel.isMaximumSizeSet());
    assertFalse(searchPanel.isMinimumSizeSet());
    assertFalse(searchPanel.isPreferredSizeSet());
    assertFalse(searchPanel.isShowing());
    assertFalse(searchPanel.isValid());
    assertFalse(searchPanel.isFocusCycleRoot());
    assertFalse(searchPanel.isFocusTraversalPolicyProvider());
    assertFalse(searchPanel.isFocusTraversalPolicySet());
    assertFalse(searchPanel.getAutoscrolls());
    assertFalse(searchPanel.getInheritsPopupMenu());
    assertFalse(searchPanel.isManagingFocus());
    assertFalse(searchPanel.isPaintingForPrint());
    assertFalse(searchPanel.isPaintingTile());
    assertFalse(searchPanel.isValidateRoot());
    assertTrue(searchPanel.getFocusTraversalKeysEnabled());
    assertTrue(searchPanel.isBackgroundSet());
    assertTrue(searchPanel.isEnabled());
    assertTrue(searchPanel.isFocusable());
    assertTrue(searchPanel.isFontSet());
    assertTrue(searchPanel.isForegroundSet());
    assertTrue(searchPanel.isVisible());
    assertTrue(searchPanel.getVerifyInputWhenFocusTarget());
    assertTrue(searchPanel.isDoubleBuffered());
    assertTrue(searchPanel.isOpaque());
    assertTrue(searchPanel.isOptimizedDrawingEnabled());
    assertTrue(searchPanel.isRequestFocusEnabled());
  }

  /**
   * Test {@link Searcher#getSearchPanel()}.
   *
   * <p>Method under test: {@link Searcher#getSearchPanel()}
   */
  @Test
  @DisplayName("Test getSearchPanel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JPanel Searcher.getSearchPanel()"})
  void testGetSearchPanel() {
    // Arrange and Act
    JPanel actualSearchPanel = new Searcher(new JEditorPane()).getSearchPanel();

    // Assert
    assertTrue(actualSearchPanel.getColorModel() instanceof DirectColorModel);
    assertTrue(actualSearchPanel.getLayout() instanceof BoxLayout);
    assertTrue(actualSearchPanel.getBorder() instanceof MatteBorder);
    assertEquals("PanelUI", actualSearchPanel.getUIClassID());
    assertNull(actualSearchPanel.getNextFocusableComponent());
    assertNull(actualSearchPanel.getFocusCycleRootAncestor());
    assertNull(actualSearchPanel.getParent());
    assertNull(actualSearchPanel.getTopLevelAncestor());
    assertNull(actualSearchPanel.getFocusTraversalPolicy());
    assertNull(actualSearchPanel.getGraphics());
    assertNull(actualSearchPanel.getGraphicsConfiguration());
    assertNull(actualSearchPanel.getDropTarget());
    assertNull(actualSearchPanel.getInputContext());
    assertNull(actualSearchPanel.getInputMethodRequests());
    assertNull(actualSearchPanel.getName());
    assertNull(actualSearchPanel.getToolTipText());
    assertNull(actualSearchPanel.getInputVerifier());
    assertNull(actualSearchPanel.getComponentPopupMenu());
    assertNull(actualSearchPanel.getRootPane());
    assertNull(actualSearchPanel.getTransferHandler());
    assertEquals(0, actualSearchPanel.getDebugGraphicsOptions());
    assertEquals(0, actualSearchPanel.getHeight());
    assertEquals(0, actualSearchPanel.getWidth());
    assertEquals(0, actualSearchPanel.getX());
    assertEquals(0, actualSearchPanel.getY());
    assertEquals(0, actualSearchPanel.getFocusListeners().length);
    assertEquals(0, actualSearchPanel.getHierarchyBoundsListeners().length);
    assertEquals(0, actualSearchPanel.getHierarchyListeners().length);
    assertEquals(0, actualSearchPanel.getInputMethodListeners().length);
    assertEquals(0, actualSearchPanel.getKeyListeners().length);
    assertEquals(0, actualSearchPanel.getMouseListeners().length);
    assertEquals(0, actualSearchPanel.getMouseMotionListeners().length);
    assertEquals(0, actualSearchPanel.getMouseWheelListeners().length);
    assertEquals(0, actualSearchPanel.getPropertyChangeListeners().length);
    assertEquals(0, actualSearchPanel.getContainerListeners().length);
    assertEquals(0, actualSearchPanel.getAncestorListeners().length);
    assertEquals(0, actualSearchPanel.getRegisteredKeyStrokes().length);
    assertEquals(0, actualSearchPanel.getVetoableChangeListeners().length);
    assertEquals(0.48f, actualSearchPanel.getAlignmentY());
    assertEquals(0.5f, actualSearchPanel.getAlignmentX());
    assertEquals(1, actualSearchPanel.getComponentListeners().length);
    assertEquals(8, actualSearchPanel.getComponentCount());
    assertEquals(8, actualSearchPanel.getComponents().length);
    assertEquals(BaselineResizeBehavior.OTHER, actualSearchPanel.getBaselineResizeBehavior());
    assertFalse(actualSearchPanel.getIgnoreRepaint());
    assertFalse(actualSearchPanel.hasFocus());
    assertFalse(actualSearchPanel.isCursorSet());
    assertFalse(actualSearchPanel.isDisplayable());
    assertFalse(actualSearchPanel.isFocusOwner());
    assertFalse(actualSearchPanel.isLightweight());
    assertFalse(actualSearchPanel.isMaximumSizeSet());
    assertFalse(actualSearchPanel.isMinimumSizeSet());
    assertFalse(actualSearchPanel.isPreferredSizeSet());
    assertFalse(actualSearchPanel.isShowing());
    assertFalse(actualSearchPanel.isValid());
    assertFalse(actualSearchPanel.isFocusCycleRoot());
    assertFalse(actualSearchPanel.isFocusTraversalPolicyProvider());
    assertFalse(actualSearchPanel.isFocusTraversalPolicySet());
    assertFalse(actualSearchPanel.getAutoscrolls());
    assertFalse(actualSearchPanel.getInheritsPopupMenu());
    assertFalse(actualSearchPanel.isManagingFocus());
    assertFalse(actualSearchPanel.isPaintingForPrint());
    assertFalse(actualSearchPanel.isPaintingTile());
    assertFalse(actualSearchPanel.isValidateRoot());
    assertTrue(actualSearchPanel.getFocusTraversalKeysEnabled());
    assertTrue(actualSearchPanel.isBackgroundSet());
    assertTrue(actualSearchPanel.isEnabled());
    assertTrue(actualSearchPanel.isFocusable());
    assertTrue(actualSearchPanel.isFontSet());
    assertTrue(actualSearchPanel.isForegroundSet());
    assertTrue(actualSearchPanel.isVisible());
    assertTrue(actualSearchPanel.getVerifyInputWhenFocusTarget());
    assertTrue(actualSearchPanel.isDoubleBuffered());
    assertTrue(actualSearchPanel.isOpaque());
    assertTrue(actualSearchPanel.isOptimizedDrawingEnabled());
    assertTrue(actualSearchPanel.isRequestFocusEnabled());
  }

  /**
   * Test {@link Searcher#insertUpdate(DocumentEvent)}.
   *
   * <ul>
   *   <li>Given {@link JEditorPane#JEditorPane(String, String)} with {@code foo} and {@code foo}.
   *   <li>Then third element Text is {@code 1 of 1}.
   * </ul>
   *
   * <p>Method under test: {@link Searcher#insertUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName(
      "Test insertUpdate(DocumentEvent); given JEditorPane(String, String) with 'foo' and 'foo'; then third element Text is '1 of 1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.insertUpdate(DocumentEvent)"})
  void testInsertUpdate_givenJEditorPaneWithFooAndFoo_thenThirdElementTextIs1Of1()
      throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane("foo", "foo"));

    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument();
    defaultStyledDocument.insertString(0, "foo", new SimpleAttributeSet());

    // Act
    searcher.insertUpdate(defaultStyledDocument.new DefaultDocumentEvent(1, 1, null));

    // Assert
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" 1 of 1 ", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(393, size.getSize().width);
    assertEquals(393, size.width);
    assertEquals(393, minimumSize.width);
    assertEquals(393.0d, size.getWidth());
    assertEquals(393.0d, minimumSize.getWidth());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(46, maximumSize.width);
    assertEquals(8, components.length);
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
  }

  /**
   * Test {@link Searcher#insertUpdate(DocumentEvent)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then third element Text is {@code No match found}.
   * </ul>
   *
   * <p>Method under test: {@link Searcher#insertUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName(
      "Test insertUpdate(DocumentEvent); given zero; then third element Text is 'No match found'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.insertUpdate(DocumentEvent)"})
  void testInsertUpdate_givenZero_thenThirdElementTextIsNoMatchFound() throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument();
    defaultStyledDocument.insertString(0, "foo", new SimpleAttributeSet());

    // Act
    searcher.insertUpdate(defaultStyledDocument.new DefaultDocumentEvent(1, 1, null));

    // Assert
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" No match found ", ((JLabel) component).getText());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(119, maximumSize.width);
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(466, size.getSize().width);
    assertEquals(466, size.width);
    assertEquals(466, minimumSize.width);
    assertEquals(466.0d, size.getWidth());
    assertEquals(466.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
  }

  /**
   * Test {@link Searcher#insertUpdate(DocumentEvent)}.
   *
   * <ul>
   *   <li>Then third element Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Searcher#insertUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test insertUpdate(DocumentEvent); then third element Text is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.insertUpdate(DocumentEvent)"})
  void testInsertUpdate_thenThirdElementTextIsEmptyString() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    // Act
    searcher.insertUpdate(new DefaultStyledDocument().new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals("", ((JLabel) component).getText());
    assertEquals(0, component.getMaximumSize().width);
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(347, size.getSize().width);
    assertEquals(347, size.width);
    assertEquals(347, minimumSize.width);
    assertEquals(347.0d, size.getWidth());
    assertEquals(347.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
  }

  /**
   * Test {@link Searcher#removeUpdate(DocumentEvent)}.
   *
   * <p>Method under test: {@link Searcher#removeUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test removeUpdate(DocumentEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.removeUpdate(DocumentEvent)"})
  void testRemoveUpdate() throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument();
    defaultStyledDocument.insertString(0, "foo", new SimpleAttributeSet());

    // Act
    searcher.removeUpdate(defaultStyledDocument.new DefaultDocumentEvent(1, 1, null));

    // Assert
    JPanel searchPanel = searcher.getSearchPanel();
    Rectangle boundsResult = searchPanel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = searchPanel.getVisibleRect().getBounds();
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2D.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    Rectangle2D bounds2D4 = frame.getBounds2D();
    assertTrue(bounds2D4 instanceof Double);
    assertTrue(frame instanceof Double);
    Rectangle2D frame2 = bounds.getFrame();
    assertTrue(frame2 instanceof Double);
    Rectangle2D frame3 = bounds2D.getFrame();
    assertTrue(frame3 instanceof Double);
    Rectangle2D frame4 = frame.getFrame();
    assertTrue(frame4 instanceof Double);
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" No match found ", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(466, size.width);
    assertEquals(466, minimumSize.width);
    assertEquals(466.0d, size.getWidth());
    assertEquals(466.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertEquals(boundsResult, bounds2D2);
    assertEquals(boundsResult, bounds2D3);
    assertEquals(boundsResult, bounds2D4);
    assertEquals(boundsResult, frame2);
    assertEquals(boundsResult, frame3);
    assertEquals(boundsResult, frame4);
  }

  /**
   * Test {@link Searcher#removeUpdate(DocumentEvent)}.
   *
   * <p>Method under test: {@link Searcher#removeUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test removeUpdate(DocumentEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.removeUpdate(DocumentEvent)"})
  void testRemoveUpdate2() throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane("foo", "foo"));

    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument();
    defaultStyledDocument.insertString(0, "foo", new SimpleAttributeSet());

    // Act
    searcher.removeUpdate(defaultStyledDocument.new DefaultDocumentEvent(1, 1, null));

    // Assert
    JPanel searchPanel = searcher.getSearchPanel();
    Rectangle boundsResult = searchPanel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = searchPanel.getVisibleRect().getBounds();
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2D.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    Rectangle2D bounds2D4 = frame.getBounds2D();
    assertTrue(bounds2D4 instanceof Double);
    assertTrue(frame instanceof Double);
    Rectangle2D frame2 = bounds.getFrame();
    assertTrue(frame2 instanceof Double);
    Rectangle2D frame3 = bounds2D.getFrame();
    assertTrue(frame3 instanceof Double);
    Rectangle2D frame4 = frame.getFrame();
    assertTrue(frame4 instanceof Double);
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" 1 of 1 ", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(393, size.width);
    assertEquals(393, minimumSize.width);
    assertEquals(393.0d, size.getWidth());
    assertEquals(393.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertEquals(boundsResult, bounds2D2);
    assertEquals(boundsResult, bounds2D3);
    assertEquals(boundsResult, bounds2D4);
    assertEquals(boundsResult, frame2);
    assertEquals(boundsResult, frame3);
    assertEquals(boundsResult, frame4);
  }

  /**
   * Test {@link Searcher#removeUpdate(DocumentEvent)}.
   *
   * <ul>
   *   <li>Then third element Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Searcher#removeUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test removeUpdate(DocumentEvent); then third element Text is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.removeUpdate(DocumentEvent)"})
  void testRemoveUpdate_thenThirdElementTextIsEmptyString() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    // Act
    searcher.removeUpdate(new DefaultStyledDocument().new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals("", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(347, size.width);
    assertEquals(347, minimumSize.width);
    assertEquals(347.0d, size.getWidth());
    assertEquals(347.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
  }

  /**
   * Test {@link Searcher#changedUpdate(DocumentEvent)}.
   *
   * <ul>
   *   <li>Given {@link JEditorPane#JEditorPane(String, String)} with {@code foo} and {@code foo}.
   *   <li>Then third element Text is {@code 1 of 1}.
   * </ul>
   *
   * <p>Method under test: {@link Searcher#changedUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName(
      "Test changedUpdate(DocumentEvent); given JEditorPane(String, String) with 'foo' and 'foo'; then third element Text is '1 of 1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.changedUpdate(DocumentEvent)"})
  void testChangedUpdate_givenJEditorPaneWithFooAndFoo_thenThirdElementTextIs1Of1()
      throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane("foo", "foo"));

    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument();
    defaultStyledDocument.insertString(0, "foo", new SimpleAttributeSet());

    // Act
    searcher.changedUpdate(defaultStyledDocument.new DefaultDocumentEvent(1, 1, null));

    // Assert
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" 1 of 1 ", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(393, size.getSize().width);
    assertEquals(393, size.width);
    assertEquals(393, minimumSize.width);
    assertEquals(393.0d, size.getWidth());
    assertEquals(393.0d, minimumSize.getWidth());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(46, maximumSize.width);
    assertEquals(8, components.length);
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
  }

  /**
   * Test {@link Searcher#changedUpdate(DocumentEvent)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then third element Text is {@code No match found}.
   * </ul>
   *
   * <p>Method under test: {@link Searcher#changedUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName(
      "Test changedUpdate(DocumentEvent); given zero; then third element Text is 'No match found'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.changedUpdate(DocumentEvent)"})
  void testChangedUpdate_givenZero_thenThirdElementTextIsNoMatchFound()
      throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument();
    defaultStyledDocument.insertString(0, "foo", new SimpleAttributeSet());

    // Act
    searcher.changedUpdate(defaultStyledDocument.new DefaultDocumentEvent(1, 1, null));

    // Assert
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" No match found ", ((JLabel) component).getText());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(119, maximumSize.width);
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(466, size.getSize().width);
    assertEquals(466, size.width);
    assertEquals(466, minimumSize.width);
    assertEquals(466.0d, size.getWidth());
    assertEquals(466.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
  }

  /**
   * Test {@link Searcher#changedUpdate(DocumentEvent)}.
   *
   * <ul>
   *   <li>Then third element Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Searcher#changedUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test changedUpdate(DocumentEvent); then third element Text is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.changedUpdate(DocumentEvent)"})
  void testChangedUpdate_thenThirdElementTextIsEmptyString() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    // Act
    searcher.changedUpdate(new DefaultStyledDocument().new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals("", ((JLabel) component).getText());
    assertEquals(0, component.getMaximumSize().width);
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(347, size.getSize().width);
    assertEquals(347, size.width);
    assertEquals(347, minimumSize.width);
    assertEquals(347.0d, size.getWidth());
    assertEquals(347.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
  }

  /**
   * Test {@link Searcher#addMenuListeners(PDFDebugger)}.
   *
   * <ul>
   *   <li>Then calls {@link PDFDebugger#getFindMenu()}.
   * </ul>
   *
   * <p>Method under test: {@link Searcher#addMenuListeners(PDFDebugger)}
   */
  @Test
  @DisplayName("Test addMenuListeners(PDFDebugger); then calls getFindMenu()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.addMenuListeners(PDFDebugger)"})
  void testAddMenuListeners_thenCallsGetFindMenu() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu());

    // Act
    searcher.addMenuListeners(frame);

    // Assert
    verify(frame).getFindMenu();
    verify(frame).getFindMenuItem();
    verify(frame).getFindNextMenuItem();
    verify(frame).getFindPreviousMenuItem();
  }

  /**
   * Test {@link Searcher#removeMenuListeners(PDFDebugger)}.
   *
   * <ul>
   *   <li>Then fourth element {@link JButton}.
   * </ul>
   *
   * <p>Method under test: {@link Searcher#removeMenuListeners(PDFDebugger)}
   */
  @Test
  @DisplayName("Test removeMenuListeners(PDFDebugger); then fourth element JButton")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Searcher.removeMenuListeners(PDFDebugger)"})
  void testRemoveMenuListeners_thenFourthElementJButton() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu());

    // Act
    searcher.removeMenuListeners(frame);

    // Assert
    verify(frame).getFindMenu();
    verify(frame).getFindMenuItem();
    verify(frame).getFindNextMenuItem();
    verify(frame).getFindPreviousMenuItem();
    Component[] components = searcher.getSearchPanel().getComponents();
    assertTrue(components[3] instanceof JButton);
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals(8, components.length);
  }
}
