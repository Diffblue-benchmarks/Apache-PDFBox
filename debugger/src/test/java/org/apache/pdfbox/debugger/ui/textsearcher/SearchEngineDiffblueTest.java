package org.apache.pdfbox.debugger.ui.textsearcher;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.swing.JEditorPane;
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
   *   <li>Then return search {@code Search Key} and {@code true} Empty.
   * </ul>
   *
   * <p>Method under test: {@link SearchEngine#SearchEngine(JTextComponent, HighlightPainter)}
   */
  @Test
  @DisplayName(
      "Test new SearchEngine(JTextComponent, HighlightPainter); when JEditorPane(); then return search 'Search Key' and 'true' Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchEngine.<init>(JTextComponent, HighlightPainter)"})
  void testNewSearchEngine_whenJEditorPane_thenReturnSearchSearchKeyAndTrueEmpty() {
    // Arrange and Act
    SearchEngine actualSearchEngine =
        new SearchEngine(new JEditorPane(), mock(HighlightPainter.class));

    // Assert
    assertTrue(actualSearchEngine.search("Search Key", true).isEmpty());
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
