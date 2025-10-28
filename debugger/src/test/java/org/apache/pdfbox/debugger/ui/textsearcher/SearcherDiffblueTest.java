package org.apache.pdfbox.debugger.ui.textsearcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import org.junit.jupiter.api.Test;

class SearcherDiffblueTest {
  /**
   * Method under test: {@link Searcher#insertUpdate(DocumentEvent)}
   */
  @Test
  void testInsertUpdate() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    // Act
    searcher.insertUpdate((new DefaultStyledDocument()).new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    assertTrue(components[3] instanceof JButton);
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals("", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(347, minimumSize.width);
    assertEquals(347.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertFalse(component.isVisible());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#insertUpdate(DocumentEvent)}
   */
  @Test
  void testInsertUpdate2() {
    // Arrange
    JEditorPane textComponent = new JEditorPane();
    textComponent.addHyperlinkListener(mock(HyperlinkListener.class));
    Searcher searcher = new Searcher(textComponent);

    // Act
    searcher.insertUpdate((new DefaultStyledDocument()).new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    assertTrue(components[3] instanceof JButton);
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals("", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(347, minimumSize.width);
    assertEquals(347.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertFalse(component.isVisible());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#insertUpdate(DocumentEvent)}
   */
  @Test
  void testInsertUpdate3() throws BadLocationException {
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
    assertTrue(components[1] instanceof JTextField);
    assertEquals(" No match found ", ((JLabel) component).getText());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(119, maximumSize.width);
    assertEquals(15, maximumSize.height);
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(466, minimumSize.width);
    assertEquals(466.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertTrue(component.isVisible());
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#insertUpdate(DocumentEvent)}
   */
  @Test
  void testInsertUpdate4() throws BadLocationException {
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
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(15, maximumSize.height);
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(393, minimumSize.width);
    assertEquals(393.0d, minimumSize.getWidth());
    assertEquals(46, maximumSize.width);
    assertEquals(8, components.length);
    assertTrue(component.isVisible());
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#removeUpdate(DocumentEvent)}
   */
  @Test
  void testRemoveUpdate() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    // Act
    searcher.removeUpdate((new DefaultStyledDocument()).new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals("", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(347, minimumSize.width);
    assertEquals(347.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertFalse(component.isVisible());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#removeUpdate(DocumentEvent)}
   */
  @Test
  void testRemoveUpdate2() {
    // Arrange
    JEditorPane textComponent = new JEditorPane();
    textComponent.addHyperlinkListener(mock(HyperlinkListener.class));
    Searcher searcher = new Searcher(textComponent);

    // Act
    searcher.removeUpdate((new DefaultStyledDocument()).new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals("", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(347, minimumSize.width);
    assertEquals(347.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertFalse(component.isVisible());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#removeUpdate(DocumentEvent)}
   */
  @Test
  void testRemoveUpdate3() throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument();
    defaultStyledDocument.insertString(0, "foo", new SimpleAttributeSet());

    // Act
    searcher.removeUpdate(defaultStyledDocument.new DefaultDocumentEvent(1, 1, null));

    // Assert
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" No match found ", ((JLabel) component).getText());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(119, maximumSize.width);
    assertEquals(15, maximumSize.height);
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(466, minimumSize.width);
    assertEquals(466.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertTrue(component.isVisible());
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#removeUpdate(DocumentEvent)}
   */
  @Test
  void testRemoveUpdate4() throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane("foo", "foo"));

    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument();
    defaultStyledDocument.insertString(0, "foo", new SimpleAttributeSet());

    // Act
    searcher.removeUpdate(defaultStyledDocument.new DefaultDocumentEvent(1, 1, null));

    // Assert
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" 1 of 1 ", ((JLabel) component).getText());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(15, maximumSize.height);
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(393, minimumSize.width);
    assertEquals(393.0d, minimumSize.getWidth());
    assertEquals(46, maximumSize.width);
    assertEquals(8, components.length);
    assertTrue(component.isVisible());
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#changedUpdate(DocumentEvent)}
   */
  @Test
  void testChangedUpdate() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    // Act
    searcher.changedUpdate((new DefaultStyledDocument()).new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    assertTrue(components[3] instanceof JButton);
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals("", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(347, minimumSize.width);
    assertEquals(347.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertFalse(component.isVisible());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#changedUpdate(DocumentEvent)}
   */
  @Test
  void testChangedUpdate2() {
    // Arrange
    JEditorPane textComponent = new JEditorPane();
    textComponent.addHyperlinkListener(mock(HyperlinkListener.class));
    Searcher searcher = new Searcher(textComponent);

    // Act
    searcher.changedUpdate((new DefaultStyledDocument()).new DefaultDocumentEvent(1, 1, null));

    // Assert that nothing has changed
    JPanel searchPanel = searcher.getSearchPanel();
    Component[] components = searchPanel.getComponents();
    assertTrue(components[3] instanceof JButton);
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals("", ((JLabel) component).getText());
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(347, minimumSize.width);
    assertEquals(347.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertFalse(component.isVisible());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#changedUpdate(DocumentEvent)}
   */
  @Test
  void testChangedUpdate3() throws BadLocationException {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

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
    assertEquals(" No match found ", ((JLabel) component).getText());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(119, maximumSize.width);
    assertEquals(15, maximumSize.height);
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(466, minimumSize.width);
    assertEquals(466.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertTrue(component.isVisible());
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#changedUpdate(DocumentEvent)}
   */
  @Test
  void testChangedUpdate4() throws BadLocationException {
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
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(15, maximumSize.height);
    Dimension minimumSize = searchPanel.getMinimumSize();
    assertEquals(393, minimumSize.width);
    assertEquals(393.0d, minimumSize.getWidth());
    assertEquals(46, maximumSize.width);
    assertEquals(8, components.length);
    assertTrue(component.isVisible());
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, searchPanel.getPreferredSize());
  }

  /**
   * Method under test: {@link Searcher#stateChanged(ChangeEvent)}
   */
  @Test
  void testStateChanged() {
    // Arrange
    Searcher searcher = new Searcher(new JEditorPane());

    // Act
    searcher.stateChanged(new ChangeEvent("42"));

    // Assert that nothing has changed
    Component[] components = searcher.getSearchPanel().getComponents();
    assertTrue(components[3] instanceof JButton);
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals(8, components.length);
  }

  /**
   * Method under test: {@link Searcher#stateChanged(ChangeEvent)}
   */
  @Test
  void testStateChanged2() {
    // Arrange
    JEditorPane textComponent = new JEditorPane();
    textComponent.addHyperlinkListener(mock(HyperlinkListener.class));
    Searcher searcher = new Searcher(textComponent);

    // Act
    searcher.stateChanged(new ChangeEvent("42"));

    // Assert that nothing has changed
    Component[] components = searcher.getSearchPanel().getComponents();
    assertTrue(components[3] instanceof JButton);
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals(8, components.length);
  }
}
