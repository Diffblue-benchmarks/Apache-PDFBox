package org.apache.pdfbox.debugger.ui.textsearcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ComponentListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.Action;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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
   * Test {@link SearchPanel#SearchPanel(DocumentListener, ChangeListener, ComponentListener, Action, Action)}.
   * <p>
   * Method under test: {@link SearchPanel#SearchPanel(DocumentListener, ChangeListener, ComponentListener, Action, Action)}
   */
  @Test
  @DisplayName("Test new SearchPanel(DocumentListener, ChangeListener, ComponentListener, Action, Action)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SearchPanel.<init>(DocumentListener, ChangeListener, ComponentListener, Action, Action)"})
  void testNewSearchPanel() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    // Act
    SearchPanel actualSearchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new BeepAction());

    // Assert
    assertEquals("", actualSearchPanel.getSearchWord());
    assertFalse(actualSearchPanel.isCaseSensitive());
  }

  /**
   * Test {@link SearchPanel#isCaseSensitive()}.
   * <p>
   * Method under test: {@link SearchPanel#isCaseSensitive()}
   */
  @Test
  @DisplayName("Test isCaseSensitive()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SearchPanel.isCaseSensitive()"})
  void testIsCaseSensitive() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    // Act and Assert
    assertFalse((new SearchPanel(documentListener, changeListener, compListener, nextAction, new BeepAction()))
        .isCaseSensitive());
  }

  /**
   * Test {@link SearchPanel#getSearchWord()}.
   * <p>
   * Method under test: {@link SearchPanel#getSearchWord()}
   */
  @Test
  @DisplayName("Test getSearchWord()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String SearchPanel.getSearchWord()"})
  void testGetSearchWord() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    // Act and Assert
    assertEquals("", (new SearchPanel(documentListener, changeListener, compListener, nextAction, new BeepAction()))
        .getSearchWord());
  }

  /**
   * Test {@link SearchPanel#updateCounterLabel(int, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then third element Text is {@code 3 of 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchPanel#updateCounterLabel(int, int)}
   */
  @Test
  @DisplayName("Test updateCounterLabel(int, int); when three; then third element Text is '3 of 3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SearchPanel.updateCounterLabel(int, int)"})
  void testUpdateCounterLabel_whenThree_thenThirdElementTextIs3Of3() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new BeepAction());

    // Act
    searchPanel.updateCounterLabel(3, 3);

    // Assert
    JPanel panel = searchPanel.getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = panel.getVisibleRect().getBounds();
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
    Component[] components = panel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" 3 of 3 ", ((JLabel) component).getText());
    Dimension minimumSize = panel.getMinimumSize();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SearchPanel.updateCounterLabel(int, int)"})
  void testUpdateCounterLabel_whenZero_thenThirdElementTextIsNoMatchFound() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new BeepAction());

    // Act
    searchPanel.updateCounterLabel(3, 0);

    // Assert
    JPanel panel = searchPanel.getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = panel.getVisibleRect().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame.getBounds2D() instanceof Double);
    assertTrue(frame instanceof Double);
    assertTrue(bounds.getFrame() instanceof Double);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertTrue(frame.getFrame() instanceof Double);
    Component[] components = panel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" No match found ", ((JLabel) component).getText());
    Dimension minimumSize = panel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(466, size.width);
    assertEquals(466, minimumSize.width);
    assertEquals(466.0d, size.getWidth());
    assertEquals(466.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
  }

  /**
   * Test {@link SearchPanel#reFocus()}.
   * <p>
   * Method under test: {@link SearchPanel#reFocus()}
   */
  @Test
  @DisplayName("Test reFocus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SearchPanel.reFocus()"})
  void testReFocus() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new BeepAction());

    // Act
    searchPanel.reFocus();

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
    assertTrue(frame.getBounds2D() instanceof Double);
    assertTrue(frame instanceof Double);
    assertTrue(bounds.getFrame() instanceof Double);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertTrue(frame.getFrame() instanceof Double);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SearchPanel.addMenuListeners(PDFDebugger)"})
  void testAddMenuListeners_givenJMenuWithFoo_thenCallsGetFindMenu() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new BeepAction());
    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu("foo"));

    // Act
    searchPanel.addMenuListeners(frame);

    // Assert
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SearchPanel.removeMenuListeners(PDFDebugger)"})
  void testRemoveMenuListeners() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();
    SearchPanel searchPanel = new SearchPanel(documentListener, changeListener, compListener, nextAction,
        new BeepAction());
    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu("foo"));

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
