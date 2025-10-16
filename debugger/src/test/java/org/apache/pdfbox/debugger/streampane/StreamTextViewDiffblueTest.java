package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.image.DirectColorModel;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.StyleSheet;
import org.apache.pdfbox.debugger.streampane.tooltip.ToolTipController;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StreamTextViewDiffblueTest {
  /**
   * Test {@link StreamTextView#StreamTextView(StyledDocument, ToolTipController)}.
   *
   * <ul>
   *   <li>When {@link DefaultStyledDocument#DefaultStyledDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link StreamTextView#StreamTextView(StyledDocument, ToolTipController)}
   */
  @Test
  @DisplayName(
      "Test new StreamTextView(StyledDocument, ToolTipController); when DefaultStyledDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamTextView.<init>(StyledDocument, ToolTipController)"})
  void testNewStreamTextView_whenDefaultStyledDocument() {
    // Arrange
    DefaultStyledDocument document = new DefaultStyledDocument();

    // Act
    StreamTextView actualStreamTextView =
        new StreamTextView(document, new ToolTipController(new PDResources()));

    // Assert
    JComponent view = actualStreamTextView.getView();
    assertTrue(view.getColorModel() instanceof DirectColorModel);
    assertTrue(view.getLayout() instanceof BoxLayout);
    assertTrue(view instanceof JPanel);
    assertEquals(1, view.getPropertyChangeListeners().length);
    assertEquals(1, view.getAncestorListeners().length);
    assertEquals(2, view.getComponents().length);
  }

  /**
   * Test {@link StreamTextView#StreamTextView(StyledDocument, ToolTipController)}.
   *
   * <ul>
   *   <li>When {@link HTMLDocument#HTMLDocument(StyleSheet)} with {@link StyleSheet} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link StreamTextView#StreamTextView(StyledDocument, ToolTipController)}
   */
  @Test
  @DisplayName(
      "Test new StreamTextView(StyledDocument, ToolTipController); when HTMLDocument(StyleSheet) with StyleSheet (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamTextView.<init>(StyledDocument, ToolTipController)"})
  void testNewStreamTextView_whenHTMLDocumentWithStyleSheet() {
    // Arrange
    HTMLDocument document = new HTMLDocument(new StyleSheet());

    // Act
    StreamTextView actualStreamTextView =
        new StreamTextView(document, new ToolTipController(new PDResources()));

    // Assert
    JComponent view = actualStreamTextView.getView();
    assertTrue(view.getColorModel() instanceof DirectColorModel);
    assertTrue(view.getLayout() instanceof BoxLayout);
    assertTrue(view instanceof JPanel);
    assertEquals(1, view.getPropertyChangeListeners().length);
    assertEquals(1, view.getAncestorListeners().length);
    assertEquals(2, view.getComponents().length);
  }

  /**
   * Test {@link StreamTextView#mouseMoved(MouseEvent)}.
   *
   * <ul>
   *   <li>Given {@link ToolTipController} {@link ToolTipController#getToolTip(int, JTextComponent)}
   *       return {@code 127.0.0.1}.
   *   <li>Then calls {@link ToolTipController#getToolTip(int, JTextComponent)}.
   * </ul>
   *
   * <p>Method under test: {@link StreamTextView#mouseMoved(MouseEvent)}
   */
  @Test
  @DisplayName(
      "Test mouseMoved(MouseEvent); given ToolTipController getToolTip(int, JTextComponent) return '127.0.0.1'; then calls getToolTip(int, JTextComponent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamTextView.mouseMoved(MouseEvent)"})
  void testMouseMoved_givenToolTipControllerGetToolTipReturn127001_thenCallsGetToolTip() {
    // Arrange
    ToolTipController controller = mock(ToolTipController.class);
    when(controller.getToolTip(anyInt(), Mockito.<JTextComponent>any())).thenReturn("127.0.0.1");
    StreamTextView streamTextView = new StreamTextView(new DefaultStyledDocument(), controller);
    MouseEvent mouseEvent = new MouseEvent(new Canvas(), 1, 1L, 1, 1, 1, 1, true);

    // Act
    streamTextView.mouseMoved(mouseEvent);

    // Assert
    verify(controller).getToolTip(eq(-1), isA(JTextComponent.class));
  }
}
