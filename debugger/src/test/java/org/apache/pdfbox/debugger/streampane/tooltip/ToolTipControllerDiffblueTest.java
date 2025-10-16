package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import javax.swing.JEditorPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.JTextComponent;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToolTipControllerDiffblueTest {
  /**
   * Test {@link ToolTipController#getWords(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToolTipController#getWords(String)}
   */
  @Test
  @DisplayName("Test getWords(String); when space; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToolTipController.getWords(String)"})
  void testGetWords_whenSpace_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualWords = ToolTipController.getWords(" ");

    // Assert
    assertTrue(actualWords.isEmpty());
  }

  /**
   * Test {@link ToolTipController#getWords(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ToolTipController#getWords(String)}
   */
  @Test
  @DisplayName("Test getWords(String); when 'Str'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToolTipController.getWords(String)"})
  void testGetWords_whenStr_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualWords = ToolTipController.getWords("Str");

    // Assert
    assertEquals(1, actualWords.size());
    assertEquals("Str", actualWords.get(0));
  }

  /**
   * Test {@link ToolTipController#getToolTip(int, JTextComponent)}.
   *
   * <ul>
   *   <li>Given {@link DefaultStyledDocument#DefaultStyledDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  @DisplayName("Test getToolTip(int, JTextComponent); given DefaultStyledDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ToolTipController.getToolTip(int, JTextComponent)"})
  void testGetToolTip_givenDefaultStyledDocument() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());

    JEditorPane textComponent = new JEditorPane();
    textComponent.setDocument(new DefaultStyledDocument());

    // Act and Assert
    assertNull(toolTipController.getToolTip(2, textComponent));
  }

  /**
   * Test {@link ToolTipController#getToolTip(int, JTextComponent)}.
   *
   * <ul>
   *   <li>When {@link JEditorPane#JEditorPane()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  @DisplayName("Test getToolTip(int, JTextComponent); when JEditorPane(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ToolTipController.getToolTip(int, JTextComponent)"})
  void testGetToolTip_whenJEditorPane_thenReturnNull() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());

    // Act and Assert
    assertNull(toolTipController.getToolTip(2, new JEditorPane()));
  }

  /**
   * Test {@link ToolTipController#getToolTip(int, JTextComponent)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  @DisplayName("Test getToolTip(int, JTextComponent); when zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ToolTipController.getToolTip(int, JTextComponent)"})
  void testGetToolTip_whenZero_thenReturnNull() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());

    // Act and Assert
    assertNull(toolTipController.getToolTip(0, new JEditorPane()));
  }
}
