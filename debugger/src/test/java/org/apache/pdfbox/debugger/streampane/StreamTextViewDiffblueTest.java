package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.GapContent;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyleContext;
import org.apache.pdfbox.debugger.streampane.tooltip.ToolTipController;
import org.apache.pdfbox.debugger.ui.PDFTreeCellRenderer;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StreamTextViewDiffblueTest {
  /**
   * Test {@link StreamTextView#mouseMoved(MouseEvent)}.
   * <p>
   * Method under test: {@link StreamTextView#mouseMoved(MouseEvent)}
   */
  @Test
  @DisplayName("Test mouseMoved(MouseEvent)")
  void testMouseMoved() {
    // Arrange
    ToolTipController controller = mock(ToolTipController.class);
    when(controller.getToolTip(anyInt(), Mockito.<JTextComponent>any())).thenReturn("127.0.0.1");
    StreamTextView streamTextView = new StreamTextView(new DefaultStyledDocument(), controller);

    // Act
    streamTextView.mouseMoved(new MouseEvent(new Canvas(), 1, 1L, 1, 1, 1, 1, true));

    // Assert that nothing has changed
    verify(controller).getToolTip(eq(-1), isA(JTextComponent.class));
  }

  /**
   * Test {@link StreamTextView#mouseMoved(MouseEvent)}.
   * <ul>
   *   <li>Given {@link GapContent#GapContent(int)} with one.</li>
   *   <li>Then calls
   * {@link ToolTipController#getToolTip(int, JTextComponent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamTextView#mouseMoved(MouseEvent)}
   */
  @Test
  @DisplayName("Test mouseMoved(MouseEvent); given GapContent(int) with one; then calls getToolTip(int, JTextComponent)")
  void testMouseMoved_givenGapContentWithOne_thenCallsGetToolTip() {
    // Arrange
    ToolTipController controller = mock(ToolTipController.class);
    when(controller.getToolTip(anyInt(), Mockito.<JTextComponent>any())).thenReturn("127.0.0.1");
    GapContent gapContent = new GapContent(1);
    StreamTextView streamTextView = new StreamTextView(
        new DefaultStyledDocument(gapContent, StyleContext.getDefaultStyleContext()), controller);

    // Act
    streamTextView.mouseMoved(new MouseEvent(new Canvas(), 1, 1L, 1, 1, 1, 1, true));

    // Assert that nothing has changed
    verify(controller).getToolTip(eq(-1), isA(JTextComponent.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StreamTextView#ancestorMoved(AncestorEvent)}
   *   <li>{@link StreamTextView#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    DefaultStyledDocument document = new DefaultStyledDocument();
    StreamTextView streamTextView = new StreamTextView(document, new ToolTipController(new PDResources()));
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    Container container = new Container();

    // Act
    streamTextView.ancestorMoved(new AncestorEvent(pdfTreeCellRenderer, 1, container, new Container()));

    // Assert that nothing has changed
    assertTrue(streamTextView.getView() instanceof JPanel);
  }
}
