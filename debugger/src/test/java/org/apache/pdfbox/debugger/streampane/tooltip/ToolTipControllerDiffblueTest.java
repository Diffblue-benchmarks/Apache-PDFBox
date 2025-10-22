package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
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
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToolTipController#getWords(String)}
   */
  @Test
  @DisplayName("Test getWords(String); when space; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ToolTipController.getWords(String)"})
  void testGetWords_whenSpace_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualWords = ToolTipController.getWords(" ");

    // Assert
    assertTrue(actualWords.isEmpty());
  }

  /**
   * Test {@link ToolTipController#getWords(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToolTipController#getWords(String)}
   */
  @Test
  @DisplayName("Test getWords(String); when 'Str'; then return size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link DefaultStyledDocument#DefaultStyledDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  @DisplayName("Test getToolTip(int, JTextComponent); given DefaultStyledDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ToolTipController.getToolTip(int, JTextComponent)"})
  void testGetToolTip_givenDefaultStyledDocument() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());

    JEditorPane textComponent = new JEditorPane();
    textComponent.setDocument(new DefaultStyledDocument());

    // Act and Assert
    assertNull(toolTipController.getToolTip(2, textComponent));
    Rectangle boundsResult = textComponent.bounds();
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, textComponent.getVisibleRect());
  }

  /**
   * Test {@link ToolTipController#getToolTip(int, JTextComponent)}.
   * <ul>
   *   <li>When {@link JEditorPane#JEditorPane()}.</li>
   *   <li>Then {@link JEditorPane#JEditorPane()} bounds Bounds is {@link JEditorPane#JEditorPane()} bounds.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  @DisplayName("Test getToolTip(int, JTextComponent); when JEditorPane(); then JEditorPane() bounds Bounds is JEditorPane() bounds")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ToolTipController.getToolTip(int, JTextComponent)"})
  void testGetToolTip_whenJEditorPane_thenJEditorPaneBoundsBoundsIsJEditorPaneBounds() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());
    JEditorPane textComponent = new JEditorPane();

    // Act and Assert
    assertNull(toolTipController.getToolTip(2, textComponent));
    Rectangle boundsResult = textComponent.bounds();
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, textComponent.getVisibleRect());
  }

  /**
   * Test {@link ToolTipController#getToolTip(int, JTextComponent)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  @DisplayName("Test getToolTip(int, JTextComponent); when zero; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ToolTipController.getToolTip(int, JTextComponent)"})
  void testGetToolTip_whenZero_thenReturnNull() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());

    // Act and Assert
    assertNull(toolTipController.getToolTip(0, new JEditorPane()));
  }
}
