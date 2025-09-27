package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.List;
import javax.swing.JEditorPane;
import javax.swing.plaf.basic.BasicTextUI;
import javax.swing.plaf.basic.BasicTextUI.BasicCaret;
import javax.swing.text.Caret;
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
   *   <li>Then {@link JEditorPane#JEditorPane()} VisibleRect Bounds is {@link
   *       JEditorPane#JEditorPane()} bounds.
   * </ul>
   *
   * <p>Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  @DisplayName(
      "Test getToolTip(int, JTextComponent); then JEditorPane() VisibleRect Bounds is JEditorPane() bounds")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ToolTipController.getToolTip(int, JTextComponent)"})
  void testGetToolTip_thenJEditorPaneVisibleRectBoundsIsJEditorPaneBounds() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());

    JEditorPane textComponent = new JEditorPane();
    textComponent.setDocument(new DefaultStyledDocument());

    // Act
    toolTipController.getToolTip(2, textComponent);

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
   * Test {@link ToolTipController#getToolTip(int, JTextComponent)}.
   *
   * <ul>
   *   <li>When {@link JEditorPane#JEditorPane()}.
   *   <li>Then {@link JEditorPane#JEditorPane()} Caret Bounds2D {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  @DisplayName(
      "Test getToolTip(int, JTextComponent); when JEditorPane(); then JEditorPane() Caret Bounds2D Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ToolTipController.getToolTip(int, JTextComponent)"})
  void testGetToolTip_whenJEditorPane_thenJEditorPaneCaretBounds2DRectangle() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());
    JEditorPane textComponent = new JEditorPane();

    // Act
    toolTipController.getToolTip(2, textComponent);

    // Assert that nothing has changed
    Caret caret = textComponent.getCaret();
    assertTrue(((BasicCaret) caret).getBounds2D() instanceof Rectangle);
    assertTrue(((BasicCaret) caret).getFrame() instanceof Double);
    assertTrue(caret instanceof BasicCaret);
  }
}
