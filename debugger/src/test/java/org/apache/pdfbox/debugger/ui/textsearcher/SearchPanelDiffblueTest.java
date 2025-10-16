package org.apache.pdfbox.debugger.ui.textsearcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ComponentListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultEditorKit.BeepAction;
import org.apache.pdfbox.debugger.PDFDebugger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SearchPanelDiffblueTest {
  /**
   * Test {@link SearchPanel#SearchPanel(DocumentListener, ChangeListener, ComponentListener,
   * Action, Action)}.
   *
   * <p>Method under test: {@link SearchPanel#SearchPanel(DocumentListener, ChangeListener,
   * ComponentListener, Action, Action)}
   */
  @Test
  @DisplayName(
      "Test new SearchPanel(DocumentListener, ChangeListener, ComponentListener, Action, Action)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchPanel.<init>(DocumentListener, ChangeListener, ComponentListener, Action, Action)"
  })
  void testNewSearchPanel() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    // Act
    SearchPanel actualSearchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Assert
    assertEquals("", actualSearchPanel.getSearchWord());
    assertFalse(actualSearchPanel.isCaseSensitive());
  }

  /**
   * Test {@link SearchPanel#isCaseSensitive()}.
   *
   * <p>Method under test: {@link SearchPanel#isCaseSensitive()}
   */
  @Test
  @DisplayName("Test isCaseSensitive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SearchPanel.isCaseSensitive()"})
  void testIsCaseSensitive() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Act and Assert
    assertFalse(searchPanel.isCaseSensitive());
  }

  /**
   * Test {@link SearchPanel#getSearchWord()}.
   *
   * <p>Method under test: {@link SearchPanel#getSearchWord()}
   */
  @Test
  @DisplayName("Test getSearchWord()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SearchPanel.getSearchWord()"})
  void testGetSearchWord() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Act and Assert
    assertEquals("", searchPanel.getSearchWord());
  }

  /**
   * Test {@link SearchPanel#updateCounterLabel(int, int)}.
   *
   * <ul>
   *   <li>Then third element Text is {@code 3 of 3}.
   * </ul>
   *
   * <p>Method under test: {@link SearchPanel#updateCounterLabel(int, int)}
   */
  @Test
  @DisplayName("Test updateCounterLabel(int, int); then third element Text is '3 of 3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchPanel.updateCounterLabel(int, int)"})
  void testUpdateCounterLabel_thenThirdElementTextIs3Of3() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Act
    searchPanel.updateCounterLabel(3, 3);

    // Assert
    JPanel panel = searchPanel.getPanel();
    Component[] components = panel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" 3 of 3 ", ((JLabel) component).getText());
    Dimension minimumSize = panel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(393, size.getSize().width);
    assertEquals(393, size.width);
    assertEquals(393, minimumSize.width);
    assertEquals(393.0d, size.getWidth());
    assertEquals(393.0d, minimumSize.getWidth());
    assertEquals(46, component.getMaximumSize().width);
    assertEquals(8, components.length);
  }

  /**
   * Test {@link SearchPanel#updateCounterLabel(int, int)}.
   *
   * <ul>
   *   <li>Then third element Text is {@code No match found}.
   * </ul>
   *
   * <p>Method under test: {@link SearchPanel#updateCounterLabel(int, int)}
   */
  @Test
  @DisplayName("Test updateCounterLabel(int, int); then third element Text is 'No match found'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchPanel.updateCounterLabel(int, int)"})
  void testUpdateCounterLabel_thenThirdElementTextIsNoMatchFound() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Act
    searchPanel.updateCounterLabel(3, 0);

    // Assert
    JPanel panel = searchPanel.getPanel();
    Component[] components = panel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" No match found ", ((JLabel) component).getText());
    assertEquals(119, component.getMaximumSize().width);
    Dimension minimumSize = panel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(466, size.getSize().width);
    assertEquals(466, size.width);
    assertEquals(466, minimumSize.width);
    assertEquals(466.0d, size.getWidth());
    assertEquals(466.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
  }

  /**
   * Test {@link SearchPanel#addMenuListeners(PDFDebugger)}.
   *
   * <ul>
   *   <li>Given {@link JMenu#JMenu()}.
   *   <li>Then fourth element {@link JButton}.
   * </ul>
   *
   * <p>Method under test: {@link SearchPanel#addMenuListeners(PDFDebugger)}
   */
  @Test
  @DisplayName("Test addMenuListeners(PDFDebugger); given JMenu(); then fourth element JButton")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchPanel.addMenuListeners(PDFDebugger)"})
  void testAddMenuListeners_givenJMenu_thenFourthElementJButton() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu());

    // Act
    searchPanel.addMenuListeners(frame);

    // Assert
    verify(frame).getFindMenu();
    verify(frame).getFindMenuItem();
    verify(frame).getFindNextMenuItem();
    verify(frame).getFindPreviousMenuItem();
    Component[] components = searchPanel.getPanel().getComponents();
    assertTrue(components[3] instanceof JButton);
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals(8, components.length);
  }

  /**
   * Test {@link SearchPanel#removeMenuListeners(PDFDebugger)}.
   *
   * <p>Method under test: {@link SearchPanel#removeMenuListeners(PDFDebugger)}
   */
  @Test
  @DisplayName("Test removeMenuListeners(PDFDebugger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchPanel.removeMenuListeners(PDFDebugger)"})
  void testRemoveMenuListeners() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu());

    // Act
    searchPanel.removeMenuListeners(frame);

    // Assert
    verify(frame).getFindMenu();
    verify(frame).getFindMenuItem();
    verify(frame).getFindNextMenuItem();
    verify(frame).getFindPreviousMenuItem();
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
    Rectangle2D frame2 = boundsResult.getFrame();
    Rectangle2D bounds2D5 = frame2.getBounds2D();
    assertTrue(bounds2D5 instanceof Double);
    assertTrue(frame2 instanceof Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Double);
    Rectangle2D frame4 = bounds2.getFrame();
    assertTrue(frame4 instanceof Double);
    Rectangle2D frame5 = bounds2D.getFrame();
    assertTrue(frame5 instanceof Double);
    Rectangle2D frame6 = frame2.getFrame();
    assertTrue(frame6 instanceof Double);
    assertEquals(boundsResult, bounds2D2);
    assertEquals(boundsResult, bounds2D3);
    assertEquals(boundsResult, bounds2D4);
    assertEquals(boundsResult, bounds2D5);
    assertEquals(boundsResult, frame3);
    assertEquals(boundsResult, frame4);
    assertEquals(boundsResult, frame5);
    assertEquals(boundsResult, frame6);
  }
}
