package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.JTextComponent;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.Test;

class ToolTipControllerDiffblueTest {
  /**
   * Method under test: {@link ToolTipController#getWords(String)}
   */
  @Test
  void testGetWords() {
    // Arrange and Act
    List<String> actualWords = ToolTipController.getWords("Str");

    // Assert
    assertEquals(1, actualWords.size());
    assertEquals("Str", actualWords.get(0));
  }

  /**
   * Method under test: {@link ToolTipController#getWords(String)}
   */
  @Test
  void testGetWords2() {
    // Arrange and Act
    List<String> actualWords = ToolTipController.getWords(" ");

    // Assert
    assertTrue(actualWords.isEmpty());
  }

  /**
   * Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  void testGetToolTip() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());

    // Act and Assert
    assertNull(toolTipController.getToolTip(2, new JEditorPane()));
  }

  /**
   * Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  void testGetToolTip2() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());

    // Act and Assert
    assertNull(toolTipController.getToolTip(0, new JEditorPane()));
  }

  /**
   * Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  void testGetToolTip3() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());

    JEditorPane textComponent = new JEditorPane();
    textComponent.addHyperlinkListener(mock(HyperlinkListener.class));

    // Act and Assert
    assertNull(toolTipController.getToolTip(2, textComponent));
  }

  /**
   * Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  void testGetToolTip4() {
    // Arrange
    ToolTipController toolTipController = new ToolTipController(new PDResources());

    JEditorPane textComponent = new JEditorPane();
    textComponent.setDocument(new DefaultStyledDocument());
    textComponent.addHyperlinkListener(mock(HyperlinkListener.class));

    // Act and Assert
    assertNull(toolTipController.getToolTip(2, textComponent));
  }
}
