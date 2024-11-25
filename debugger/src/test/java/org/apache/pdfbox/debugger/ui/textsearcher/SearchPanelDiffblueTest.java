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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearchPanelDiffblueTest {
  /**
   * Test {@link SearchPanel#isCaseSensitive()}.
   * <p>
   * Method under test: {@link SearchPanel#isCaseSensitive()}
   */
  @Test
  @DisplayName("Test isCaseSensitive()")
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
    Component[] components = searchPanel.getPanel().getComponents();
    assertTrue(components[3] instanceof JButton);
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals(8, components.length);
    assertFalse(actualIsCaseSensitiveResult);
  }

  /**
   * Test {@link SearchPanel#getSearchWord()}.
   * <p>
   * Method under test: {@link SearchPanel#getSearchWord()}
   */
  @Test
  @DisplayName("Test getSearchWord()")
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
    JPanel panel = searchPanel.getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = boundsResult.getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    Rectangle bounds2 = panel.getVisibleRect().getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame.getBounds2D() instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(bounds.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2D.getFrame() instanceof Rectangle2D.Double);
    assertTrue(frame.getFrame() instanceof Rectangle2D.Double);
    assertEquals("", actualSearchWord);
  }

  /**
   * Test {@link SearchPanel#reset()}.
   * <p>
   * Method under test: {@link SearchPanel#reset()}
   */
  @Test
  @DisplayName("Test reset()")
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
    Rectangle bounds = boundsResult.getBounds().getBounds();
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle bounds2 = panel.getVisibleRect().getBounds();
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
   * Test {@link SearchPanel#updateCounterLabel(int, int)}.
   * <p>
   * Method under test: {@link SearchPanel#updateCounterLabel(int, int)}
   */
  @Test
  @DisplayName("Test updateCounterLabel(int, int)")
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
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = boundsResult.getBounds().getBounds();
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle bounds2 = panel.getVisibleRect().getBounds();
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
    Component[] components = panel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" 3 of 3 ", ((JLabel) component).getText());
    Dimension minimumSize = panel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(345, size.getSize().width);
    assertEquals(345, size.width);
    assertEquals(345, minimumSize.width);
    assertEquals(345.0d, size.getWidth());
    assertEquals(345.0d, minimumSize.getWidth());
    assertEquals(37, component.getMaximumSize().width);
    assertEquals(8, components.length);
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
   * Test {@link SearchPanel#updateCounterLabel(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then third element Text is {@code No match found}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchPanel#updateCounterLabel(int, int)}
   */
  @Test
  @DisplayName("Test updateCounterLabel(int, int); when zero; then third element Text is 'No match found'")
  void testUpdateCounterLabel_whenZero_thenThirdElementTextIsNoMatchFound() {
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
    Dimension minimumSize = panel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(403, size.getSize().width);
    assertEquals(403, size.width);
    assertEquals(403, minimumSize.width);
    assertEquals(403.0d, size.getWidth());
    assertEquals(403.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
    assertEquals(95, component.getMaximumSize().width);
  }

  /**
   * Test {@link SearchPanel#addMenuListeners(PDFDebugger)}.
   * <ul>
   *   <li>Given {@link JMenu#JMenu(String)} with {@code foo}.</li>
   *   <li>Then calls {@link PDFDebugger#getFindMenu()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchPanel#addMenuListeners(PDFDebugger)}
   */
  @Test
  @DisplayName("Test addMenuListeners(PDFDebugger); given JMenu(String) with 'foo'; then calls getFindMenu()")
  void testAddMenuListeners_givenJMenuWithFoo_thenCallsGetFindMenu() {
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
   * Test {@link SearchPanel#removeMenuListeners(PDFDebugger)}.
   * <p>
   * Method under test: {@link SearchPanel#removeMenuListeners(PDFDebugger)}
   */
  @Test
  @DisplayName("Test removeMenuListeners(PDFDebugger)")
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
    Rectangle bounds = boundsResult.getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    Rectangle bounds2 = panel.getVisibleRect().getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    Rectangle2D frame2 = boundsResult.getFrame();
    assertTrue(frame2.getBounds2D() instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(bounds.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2D.getFrame() instanceof Rectangle2D.Double);
    assertTrue(frame2.getFrame() instanceof Rectangle2D.Double);
    Component[] components = panel.getComponents();
    assertTrue(components[3] instanceof JButton);
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals(8, components.length);
  }
}
