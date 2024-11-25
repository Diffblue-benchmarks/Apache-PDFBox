package org.apache.pdfbox.debugger.ui.textsearcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import org.apache.pdfbox.debugger.PDFDebugger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearcherDiffblueTest {
  /**
   * Test {@link Searcher#insertUpdate(DocumentEvent)}.
   * <ul>
   *   <li>Given {@link JEditorPane#JEditorPane(String, String)} with {@code foo}
   * and {@code foo}.</li>
   *   <li>Then third element Text is {@code 1 of 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Searcher#insertUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test insertUpdate(DocumentEvent); given JEditorPane(String, String) with 'foo' and 'foo'; then third element Text is '1 of 1'")
  void testInsertUpdate_givenJEditorPaneWithFooAndFoo_thenThirdElementTextIs1Of1() throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane("foo", "foo"));

    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument();
    defaultStyledDocument.insertString(0, "foo", new SimpleAttributeSet());

    // Act
    searcher.insertUpdate(defaultStyledDocument.new DefaultDocumentEvent(1, 1, null));

    // Assert
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    assertTrue(components[3] instanceof JButton);
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" 1 of 1 ", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(345, size.getSize().width);
    assertEquals(345, size.width);
    assertEquals(345, minimumSize.width);
    assertEquals(345.0d, size.getWidth());
    assertEquals(345.0d, minimumSize.getWidth());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(37, maximumSize.width);
    assertEquals(8, components.length);
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
  }

  /**
   * Test {@link Searcher#insertUpdate(DocumentEvent)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>Then third element Text is {@code No match found}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Searcher#insertUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test insertUpdate(DocumentEvent); given zero; then third element Text is 'No match found'")
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
    assertTrue(components[3] instanceof JButton);
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" No match found ", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(403, size.getSize().width);
    assertEquals(403, size.width);
    assertEquals(403, minimumSize.width);
    assertEquals(403.0d, size.getWidth());
    assertEquals(403.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(95, maximumSize.width);
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
  }

  /**
   * Test {@link Searcher#insertUpdate(DocumentEvent)}.
   * <ul>
   *   <li>Then third element Text is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Searcher#insertUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test insertUpdate(DocumentEvent); then third element Text is empty string")
  void testInsertUpdate_thenThirdElementTextIsEmptyString() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    // Act
    searcher.insertUpdate((new DefaultStyledDocument()).new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals("", ((JLabel) component).getText());
    assertEquals(0, component.getMaximumSize().width);
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(308, size.getSize().width);
    assertEquals(308, size.width);
    assertEquals(308, minimumSize.width);
    assertEquals(308.0d, size.getWidth());
    assertEquals(308.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
  }

  /**
   * Test {@link Searcher#removeUpdate(DocumentEvent)}.
   * <p>
   * Method under test: {@link Searcher#removeUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test removeUpdate(DocumentEvent)")
  void testRemoveUpdate() throws BadLocationException {
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
    Rectangle bounds = boundsResult.getBounds().getBounds();
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle bounds2 = searchPanel.getVisibleRect().getBounds();
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds2D.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    Rectangle2D bounds2D5 = frame.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds2.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds2D.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = frame.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    Component[] components = searchPanel.getComponents();
    Component component = components[3];
    assertTrue(component instanceof JButton);
    Component component2 = components[2];
    assertTrue(component2 instanceof JLabel);
    assertEquals(" 1 of 1 ", ((JLabel) component2).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(345, size.getSize().width);
    assertEquals(345, size.width);
    assertEquals(345, minimumSize.width);
    assertEquals(345.0d, size.getWidth());
    assertEquals(345.0d, minimumSize.getWidth());
    Dimension maximumSize = component2.getMaximumSize();
    assertEquals(37, maximumSize.width);
    assertEquals(8, components.length);
    assertEquals(boundsResult, component.getBounds());
    assertEquals(boundsResult, bounds2D2);
    assertEquals(boundsResult, bounds2D3);
    assertEquals(boundsResult, bounds2D4);
    assertEquals(boundsResult, bounds2D5);
    assertEquals(boundsResult, frame2);
    assertEquals(boundsResult, frame3);
    assertEquals(boundsResult, frame4);
    assertEquals(boundsResult, frame5);
    assertEquals(maximumSize, component2.getMinimumSize());
    assertEquals(maximumSize, component2.getPreferredSize());
  }

  /**
   * Test {@link Searcher#removeUpdate(DocumentEvent)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>Then third element Text is {@code No match found}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Searcher#removeUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test removeUpdate(DocumentEvent); given zero; then third element Text is 'No match found'")
  void testRemoveUpdate_givenZero_thenThirdElementTextIsNoMatchFound() throws BadLocationException {
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
    Rectangle bounds = boundsResult.getBounds().getBounds();
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle bounds2 = searchPanel.getVisibleRect().getBounds();
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds2D.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    Rectangle2D bounds2D5 = frame.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds2.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds2D.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = frame.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    Component[] components = searchPanel.getComponents();
    Component component = components[3];
    assertTrue(component instanceof JButton);
    Component component2 = components[2];
    assertTrue(component2 instanceof JLabel);
    assertEquals(" No match found ", ((JLabel) component2).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(403, size.getSize().width);
    assertEquals(403, size.width);
    assertEquals(403, minimumSize.width);
    assertEquals(403.0d, size.getWidth());
    assertEquals(403.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    Dimension maximumSize = component2.getMaximumSize();
    assertEquals(95, maximumSize.width);
    assertEquals(boundsResult, component.getBounds());
    assertEquals(boundsResult, bounds2D2);
    assertEquals(boundsResult, bounds2D3);
    assertEquals(boundsResult, bounds2D4);
    assertEquals(boundsResult, bounds2D5);
    assertEquals(boundsResult, frame2);
    assertEquals(boundsResult, frame3);
    assertEquals(boundsResult, frame4);
    assertEquals(boundsResult, frame5);
    assertEquals(maximumSize, component2.getMinimumSize());
    assertEquals(maximumSize, component2.getPreferredSize());
  }

  /**
   * Test {@link Searcher#removeUpdate(DocumentEvent)}.
   * <ul>
   *   <li>Then third element Text is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Searcher#removeUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test removeUpdate(DocumentEvent); then third element Text is empty string")
  void testRemoveUpdate_thenThirdElementTextIsEmptyString() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    // Act
    searcher.removeUpdate((new DefaultStyledDocument()).new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Rectangle boundsResult = searchPanel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = boundsResult.getBounds().getBounds();
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle bounds2 = searchPanel.getVisibleRect().getBounds();
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds2D.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    Rectangle2D bounds2D5 = frame.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds2.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds2D.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = frame.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    Component[] components = searchPanel.getComponents();
    Component component = components[3];
    assertTrue(component instanceof JButton);
    Component component2 = components[2];
    assertTrue(component2 instanceof JLabel);
    assertEquals("", ((JLabel) component2).getText());
    assertEquals(0, component2.getMaximumSize().width);
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(308, size.getSize().width);
    assertEquals(308, size.width);
    assertEquals(308, minimumSize.width);
    assertEquals(308.0d, size.getWidth());
    assertEquals(308.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertEquals(boundsResult, component.getBounds());
    assertEquals(boundsResult, bounds2D2);
    assertEquals(boundsResult, bounds2D3);
    assertEquals(boundsResult, bounds2D4);
    assertEquals(boundsResult, bounds2D5);
    assertEquals(boundsResult, frame2);
    assertEquals(boundsResult, frame3);
    assertEquals(boundsResult, frame4);
    assertEquals(boundsResult, frame5);
  }

  /**
   * Test {@link Searcher#changedUpdate(DocumentEvent)}.
   * <p>
   * Method under test: {@link Searcher#changedUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test changedUpdate(DocumentEvent)")
  void testChangedUpdate() throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument();
    defaultStyledDocument.insertString(0, "foo", new SimpleAttributeSet());

    // Act
    searcher.changedUpdate(defaultStyledDocument.new DefaultDocumentEvent(1, 1, null));

    // Assert
    JPanel searchPanel = searcher.getSearchPanel();
    Rectangle boundsResult = searchPanel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = boundsResult.getBounds().getBounds();
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle bounds2 = searchPanel.getVisibleRect().getBounds();
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds2D.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    Rectangle2D bounds2D5 = frame.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds2.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds2D.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = frame.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    Component[] components = searchPanel.getComponents();
    Component component = components[3];
    assertTrue(component instanceof JButton);
    Component component2 = components[2];
    assertTrue(component2 instanceof JLabel);
    assertEquals(" No match found ", ((JLabel) component2).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(403, size.getSize().width);
    assertEquals(403, size.width);
    assertEquals(403, minimumSize.width);
    assertEquals(403.0d, size.getWidth());
    assertEquals(403.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    Dimension maximumSize = component2.getMaximumSize();
    assertEquals(95, maximumSize.width);
    assertEquals(boundsResult, component.getBounds());
    assertEquals(boundsResult, bounds2D2);
    assertEquals(boundsResult, bounds2D3);
    assertEquals(boundsResult, bounds2D4);
    assertEquals(boundsResult, bounds2D5);
    assertEquals(boundsResult, frame2);
    assertEquals(boundsResult, frame3);
    assertEquals(boundsResult, frame4);
    assertEquals(boundsResult, frame5);
    assertEquals(maximumSize, component2.getMinimumSize());
    assertEquals(maximumSize, component2.getPreferredSize());
  }

  /**
   * Test {@link Searcher#changedUpdate(DocumentEvent)}.
   * <ul>
   *   <li>Given {@link JEditorPane#JEditorPane(String, String)} with {@code foo}
   * and {@code foo}.</li>
   *   <li>Then second element {@link JTextField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Searcher#changedUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test changedUpdate(DocumentEvent); given JEditorPane(String, String) with 'foo' and 'foo'; then second element JTextField")
  void testChangedUpdate_givenJEditorPaneWithFooAndFoo_thenSecondElementJTextField() throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane("foo", "foo"));

    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument();
    defaultStyledDocument.insertString(0, "foo", new SimpleAttributeSet());

    // Act
    searcher.changedUpdate(defaultStyledDocument.new DefaultDocumentEvent(1, 1, null));

    // Assert
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    assertTrue(components[3] instanceof JButton);
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals(" 1 of 1 ", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(345, size.getSize().width);
    assertEquals(345, size.width);
    assertEquals(345, minimumSize.width);
    assertEquals(345.0d, size.getWidth());
    assertEquals(345.0d, minimumSize.getWidth());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(37, maximumSize.width);
    assertEquals(8, components.length);
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
  }

  /**
   * Test {@link Searcher#changedUpdate(DocumentEvent)}.
   * <ul>
   *   <li>Then third element Text is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Searcher#changedUpdate(DocumentEvent)}
   */
  @Test
  @DisplayName("Test changedUpdate(DocumentEvent); then third element Text is empty string")
  void testChangedUpdate_thenThirdElementTextIsEmptyString() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    // Act
    searcher.changedUpdate((new DefaultStyledDocument()).new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals("", ((JLabel) component).getText());
    assertEquals(0, component.getMaximumSize().width);
    Dimension minimumSize = searchPanel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(308, size.getSize().width);
    assertEquals(308, size.width);
    assertEquals(308, minimumSize.width);
    assertEquals(308.0d, size.getWidth());
    assertEquals(308.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
  }

  /**
   * Test {@link Searcher#addMenuListeners(PDFDebugger)}.
   * <p>
   * Method under test: {@link Searcher#addMenuListeners(PDFDebugger)}
   */
  @Test
  @DisplayName("Test addMenuListeners(PDFDebugger)")
  void testAddMenuListeners() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());
    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu("foo"));

    // Act
    searcher.addMenuListeners(frame);

    // Assert that nothing has changed
    verify(frame).getFindMenu();
    verify(frame).getFindMenuItem();
    verify(frame).getFindNextMenuItem();
    verify(frame).getFindPreviousMenuItem();
    JPanel searchPanel = searcher.getSearchPanel();
    Rectangle boundsResult = searchPanel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = boundsResult.getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    Rectangle bounds2 = searchPanel.getVisibleRect().getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    Rectangle2D frame2 = boundsResult.getFrame();
    assertTrue(frame2.getBounds2D() instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(bounds.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2D.getFrame() instanceof Rectangle2D.Double);
    assertTrue(frame2.getFrame() instanceof Rectangle2D.Double);
  }

  /**
   * Test {@link Searcher#removeMenuListeners(PDFDebugger)}.
   * <ul>
   *   <li>Then third element {@link JLabel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Searcher#removeMenuListeners(PDFDebugger)}
   */
  @Test
  @DisplayName("Test removeMenuListeners(PDFDebugger); then third element JLabel")
  void testRemoveMenuListeners_thenThirdElementJLabel() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());
    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu("foo"));

    // Act
    searcher.removeMenuListeners(frame);

    // Assert that nothing has changed
    verify(frame).getFindMenu();
    verify(frame).getFindMenuItem();
    verify(frame).getFindNextMenuItem();
    verify(frame).getFindPreviousMenuItem();
    Component[] components = searcher.getSearchPanel().getComponents();
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals(8, components.length);
  }
}
