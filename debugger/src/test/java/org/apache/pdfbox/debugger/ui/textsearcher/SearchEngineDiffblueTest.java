package org.apache.pdfbox.debugger.ui.textsearcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JEditorPane;
import javax.swing.plaf.basic.BasicTextUI;
import javax.swing.plaf.basic.BasicTextUI.BasicCaret;
import javax.swing.text.Caret;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.JTextComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SearchEngineDiffblueTest {
  /**
   * Test {@link SearchEngine#SearchEngine(JTextComponent, HighlightPainter)}.
   *
   * <ul>
   *   <li>When {@link JEditorPane#JEditorPane()}.
   *   <li>Then {@link JEditorPane#JEditorPane()} bounds Bounds2D {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link SearchEngine#SearchEngine(JTextComponent, HighlightPainter)}
   */
  @Test
  @DisplayName(
      "Test new SearchEngine(JTextComponent, HighlightPainter); when JEditorPane(); then JEditorPane() bounds Bounds2D Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchEngine.<init>(JTextComponent, HighlightPainter)"})
  void testNewSearchEngine_whenJEditorPane_thenJEditorPaneBoundsBounds2DRectangle() {
    // Arrange
    JEditorPane textComponent = new JEditorPane();

    // Act
    SearchEngine actualSearchEngine = new SearchEngine(textComponent, mock(HighlightPainter.class));

    // Assert
    Rectangle boundsResult = textComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle visibleRect = textComponent.getVisibleRect();
    Rectangle2D bounds2D2 = visibleRect.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Caret caret = textComponent.getCaret();
    Rectangle2D bounds2D3 = ((BasicCaret) caret).getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D frame2 = visibleRect.getFrame();
    assertTrue(frame2 instanceof Double);
    Rectangle2D frame3 = ((BasicCaret) caret).getFrame();
    assertTrue(frame3 instanceof Double);
    assertTrue(caret instanceof BasicCaret);
    assertTrue(actualSearchEngine.search("Search Key", true).isEmpty());
    assertEquals(boundsResult, visibleRect.getBounds());
    assertEquals(boundsResult, ((BasicCaret) caret).getBounds());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, bounds2D2);
    assertEquals(boundsResult, bounds2D3);
    assertEquals(boundsResult, frame);
    assertEquals(boundsResult, frame2);
    assertEquals(boundsResult, frame3);
  }

  /**
   * Test {@link SearchEngine#search(String, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link SearchEngine#search(String, boolean)}
   */
  @Test
  @DisplayName("Test search(String, boolean); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List SearchEngine.search(String, boolean)"})
  void testSearch_whenEmptyString() {
    // Arrange
    SearchEngine searchEngine = new SearchEngine(new JEditorPane(), mock(HighlightPainter.class));

    // Act and Assert
    assertTrue(searchEngine.search("", true).isEmpty());
  }

  /**
   * Test {@link SearchEngine#search(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SearchEngine#search(String, boolean)}
   */
  @Test
  @DisplayName("Test search(String, boolean); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List SearchEngine.search(String, boolean)"})
  void testSearch_whenFalse() {
    // Arrange
    SearchEngine searchEngine = new SearchEngine(new JEditorPane(), mock(HighlightPainter.class));

    // Act and Assert
    assertTrue(searchEngine.search("Search Key", false).isEmpty());
  }

  /**
   * Test {@link SearchEngine#search(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SearchEngine#search(String, boolean)}
   */
  @Test
  @DisplayName("Test search(String, boolean); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List SearchEngine.search(String, boolean)"})
  void testSearch_whenNull() {
    // Arrange
    SearchEngine searchEngine = new SearchEngine(new JEditorPane(), mock(HighlightPainter.class));

    // Act and Assert
    assertTrue(searchEngine.search(null, true).isEmpty());
  }

  /**
   * Test {@link SearchEngine#search(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code Search Key}.
   * </ul>
   *
   * <p>Method under test: {@link SearchEngine#search(String, boolean)}
   */
  @Test
  @DisplayName("Test search(String, boolean); when 'Search Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List SearchEngine.search(String, boolean)"})
  void testSearch_whenSearchKey() {
    // Arrange
    SearchEngine searchEngine = new SearchEngine(new JEditorPane(), mock(HighlightPainter.class));

    // Act and Assert
    assertTrue(searchEngine.search("Search Key", true).isEmpty());
  }
}
