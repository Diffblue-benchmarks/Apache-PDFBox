package org.apache.pdfbox.debugger.ui.textsearcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultEditorKit;
import org.apache.pdfbox.debugger.PDFDebugger;
import org.junit.jupiter.api.Test;

class SearchPanelDiffblueTest {
  /**
   * Method under test: {@link SearchPanel#isCaseSensitive()}
   */
  @Test
  void testIsCaseSensitive() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    DefaultEditorKit.BeepAction nextAction = new DefaultEditorKit.BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new DefaultEditorKit.BeepAction());

    // Act
    boolean actualIsCaseSensitiveResult = searchPanel.isCaseSensitive();

    // Assert
    JPanel panel = searchPanel.getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Component[] components = panel.getComponents();
    assertTrue(components[3] instanceof JButton);
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals(8, components.length);
    assertFalse(actualIsCaseSensitiveResult);
    assertEquals(boundsResult, panel.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, panel.getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
  }

  /**
   * Method under test: {@link SearchPanel#getSearchWord()}
   */
  @Test
  void testGetSearchWord() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    DefaultEditorKit.BeepAction nextAction = new DefaultEditorKit.BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new DefaultEditorKit.BeepAction());

    // Act
    String actualSearchWord = searchPanel.getSearchWord();

    // Assert
    Component[] components = searchPanel.getPanel().getComponents();
    assertTrue(components[3] instanceof JButton);
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals("", actualSearchWord);
    assertEquals(8, components.length);
  }

  /**
   * Method under test: {@link SearchPanel#reset()}
   */
  @Test
  void testReset() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    DefaultEditorKit.BeepAction nextAction = new DefaultEditorKit.BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new DefaultEditorKit.BeepAction());

    // Act
    searchPanel.reset();

    // Assert that nothing has changed
    JPanel panel = searchPanel.getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertEquals(boundsResult, panel.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, panel.getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
  }

  /**
   * Method under test: {@link SearchPanel#updateCounterLabel(int, int)}
   */
  @Test
  void testUpdateCounterLabel() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    DefaultEditorKit.BeepAction nextAction = new DefaultEditorKit.BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new DefaultEditorKit.BeepAction());

    // Act
    searchPanel.updateCounterLabel(3, 3);

    // Assert that nothing has changed
    JPanel panel = searchPanel.getPanel();
    Component[] components = panel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" 3 of 3 ", ((JLabel) component).getText());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(15, maximumSize.height);
    Dimension minimumSize = panel.getMinimumSize();
    assertEquals(393, minimumSize.width);
    assertEquals(393.0d, minimumSize.getWidth());
    assertEquals(46, maximumSize.width);
    assertEquals(8, components.length);
    assertTrue(component.isVisible());
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, panel.getPreferredSize());
  }

  /**
   * Method under test: {@link SearchPanel#updateCounterLabel(int, int)}
   */
  @Test
  void testUpdateCounterLabel2() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    DefaultEditorKit.BeepAction nextAction = new DefaultEditorKit.BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new DefaultEditorKit.BeepAction());

    // Act
    searchPanel.updateCounterLabel(3, 0);

    // Assert that nothing has changed
    JPanel panel = searchPanel.getPanel();
    Component[] components = panel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" No match found ", ((JLabel) component).getText());
    Dimension maximumSize = component.getMaximumSize();
    assertEquals(119, maximumSize.width);
    assertEquals(15, maximumSize.height);
    Dimension minimumSize = panel.getMinimumSize();
    assertEquals(466, minimumSize.width);
    assertEquals(466.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertTrue(component.isVisible());
    assertEquals(maximumSize, component.getMinimumSize());
    assertEquals(maximumSize, component.getPreferredSize());
    assertEquals(minimumSize, minimumSize.getSize());
    assertEquals(minimumSize, panel.getPreferredSize());
  }

  /**
   * Method under test: {@link SearchPanel#reFocus()}
   */
  @Test
  void testReFocus() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    DefaultEditorKit.BeepAction nextAction = new DefaultEditorKit.BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new DefaultEditorKit.BeepAction());

    // Act
    searchPanel.reFocus();

    // Assert that nothing has changed
    JPanel panel = searchPanel.getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Component[] components = panel.getComponents();
    assertTrue(components[3] instanceof JButton);
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals(8, components.length);
    assertEquals(boundsResult, panel.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, panel.getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
  }

  /**
   * Method under test: {@link SearchPanel#addMenuListeners(PDFDebugger)}
   */
  @Test
  void testAddMenuListeners() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    DefaultEditorKit.BeepAction nextAction = new DefaultEditorKit.BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new DefaultEditorKit.BeepAction());
    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu("foo"));

    // Act
    searchPanel.addMenuListeners(frame);

    // Assert that nothing has changed
    verify(frame).getFindMenu();
    verify(frame).getFindMenuItem();
    verify(frame).getFindNextMenuItem();
    verify(frame).getFindPreviousMenuItem();
  }

  /**
   * Method under test: {@link SearchPanel#removeMenuListeners(PDFDebugger)}
   */
  @Test
  void testRemoveMenuListeners() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    DefaultEditorKit.BeepAction nextAction = new DefaultEditorKit.BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new DefaultEditorKit.BeepAction());
    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu("foo"));

    // Act
    searchPanel.removeMenuListeners(frame);

    // Assert that nothing has changed
    verify(frame).getFindMenu();
    verify(frame).getFindMenuItem();
    verify(frame).getFindNextMenuItem();
    verify(frame).getFindPreviousMenuItem();
    JPanel panel = searchPanel.getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame2 = boundsResult.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertEquals(boundsResult, panel.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, panel.getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame2);
  }
}
