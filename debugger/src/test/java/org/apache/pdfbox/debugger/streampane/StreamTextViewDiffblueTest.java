package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.text.DefaultStyledDocument;
import org.apache.pdfbox.debugger.streampane.tooltip.ToolTipController;
import org.apache.pdfbox.debugger.ui.PDFTreeCellRenderer;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.Test;

class StreamTextViewDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StreamTextView#ancestorMoved(AncestorEvent)}
   *   <li>{@link StreamTextView#getView()}
   * </ul>
   */
  @Test
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
