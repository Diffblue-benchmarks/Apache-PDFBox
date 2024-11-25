package org.apache.pdfbox.debugger.ui.textsearcher;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import javax.swing.JEditorPane;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearchEngineDiffblueTest {
  /**
   * Test {@link SearchEngine#SearchEngine(JTextComponent, HighlightPainter)}.
   * <ul>
   *   <li>When {@link JEditorPane#JEditorPane()}.</li>
   *   <li>Then return search {@code Search Key} and {@code true} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchEngine#SearchEngine(JTextComponent, Highlighter.HighlightPainter)}
   */
  @Test
  @DisplayName("Test new SearchEngine(JTextComponent, HighlightPainter); when JEditorPane(); then return search 'Search Key' and 'true' Empty")
  void testNewSearchEngine_whenJEditorPane_thenReturnSearchSearchKeyAndTrueEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new SearchEngine(new JEditorPane(), mock(Highlighter.HighlightPainter.class))).search("Search Key", true)
            .isEmpty());
  }

  /**
   * Test {@link SearchEngine#search(String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchEngine#search(String, boolean)}
   */
  @Test
  @DisplayName("Test search(String, boolean); when empty string")
  void testSearch_whenEmptyString() {
    // Arrange, Act and Assert
    assertTrue(
        (new SearchEngine(new JEditorPane(), mock(Highlighter.HighlightPainter.class))).search("", true).isEmpty());
  }

  /**
   * Test {@link SearchEngine#search(String, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchEngine#search(String, boolean)}
   */
  @Test
  @DisplayName("Test search(String, boolean); when 'false'")
  void testSearch_whenFalse() {
    // Arrange, Act and Assert
    assertTrue(
        (new SearchEngine(new JEditorPane(), mock(Highlighter.HighlightPainter.class))).search("Search Key", false)
            .isEmpty());
  }

  /**
   * Test {@link SearchEngine#search(String, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchEngine#search(String, boolean)}
   */
  @Test
  @DisplayName("Test search(String, boolean); when 'null'")
  void testSearch_whenNull() {
    // Arrange, Act and Assert
    assertTrue(
        (new SearchEngine(new JEditorPane(), mock(Highlighter.HighlightPainter.class))).search(null, true).isEmpty());
  }

  /**
   * Test {@link SearchEngine#search(String, boolean)}.
   * <ul>
   *   <li>When {@code Search Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchEngine#search(String, boolean)}
   */
  @Test
  @DisplayName("Test search(String, boolean); when 'Search Key'")
  void testSearch_whenSearchKey() {
    // Arrange, Act and Assert
    assertTrue(
        (new SearchEngine(new JEditorPane(), mock(Highlighter.HighlightPainter.class))).search("Search Key", true)
            .isEmpty());
  }
}
