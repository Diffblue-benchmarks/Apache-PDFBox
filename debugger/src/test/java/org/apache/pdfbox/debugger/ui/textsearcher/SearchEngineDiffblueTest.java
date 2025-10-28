package org.apache.pdfbox.debugger.ui.textsearcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JEditorPane;
import javax.swing.plaf.basic.BasicTextUI;
import javax.swing.text.Caret;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import org.junit.jupiter.api.Test;

class SearchEngineDiffblueTest {
  /**
   * Method under test:
   * {@link SearchEngine#SearchEngine(JTextComponent, Highlighter.HighlightPainter)}
   */
  @Test
  void testNewSearchEngine() {
    // Arrange
    JEditorPane textComponent = new JEditorPane();

    // Act
    SearchEngine actualSearchEngine = new SearchEngine(textComponent, mock(Highlighter.HighlightPainter.class));

    // Assert
    Rectangle boundsResult = textComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Caret caret = textComponent.getCaret();
    assertTrue(((BasicTextUI.BasicCaret) caret).getBounds2D() instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = ((BasicTextUI.BasicCaret) caret).getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(caret instanceof BasicTextUI.BasicCaret);
    assertTrue(actualSearchEngine.search("Search Key", true).isEmpty());
    assertEquals(boundsResult, textComponent.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((BasicTextUI.BasicCaret) caret).getBounds());
    assertEquals(boundsResult, textComponent.getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    assertEquals(boundsResult, frame2);
  }

  /**
   * Method under test: {@link SearchEngine#search(String, boolean)}
   */
  @Test
  void testSearch() {
    // Arrange, Act and Assert
    assertTrue(
        (new SearchEngine(new JEditorPane(), mock(Highlighter.HighlightPainter.class))).search("Search Key", true)
            .isEmpty());
    assertTrue(
        (new SearchEngine(new JEditorPane(), mock(Highlighter.HighlightPainter.class))).search(null, true).isEmpty());
    assertTrue(
        (new SearchEngine(new JEditorPane(), mock(Highlighter.HighlightPainter.class))).search("", true).isEmpty());
    assertTrue(
        (new SearchEngine(new JEditorPane(), mock(Highlighter.HighlightPainter.class))).search("Search Key", false)
            .isEmpty());
  }
}
