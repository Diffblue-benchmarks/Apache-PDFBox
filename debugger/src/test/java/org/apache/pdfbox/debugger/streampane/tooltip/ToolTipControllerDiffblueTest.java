package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.util.List;
import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.JTextComponent;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ToolTipControllerDiffblueTest {
  @Mock private JTextComponent jTextComponent;

  @InjectMocks private ToolTipController toolTipController;

  /**
   * Test {@link ToolTipController#getWords(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToolTipController#getWords(String)}
   */
  @Test
  @DisplayName("Test getWords(String); when empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToolTipController.getWords(String)"})
  void testGetWords_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualWords = ToolTipController.getWords("");

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
   *   <li>Then calls {@link JTextComponent#getDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link ToolTipController#getToolTip(int, JTextComponent)}
   */
  @Test
  @DisplayName("Test getToolTip(int, JTextComponent); then calls getDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ToolTipController.getToolTip(int, JTextComponent)"})
  void testGetToolTip_thenCallsGetDocument() throws BadLocationException {
    // Arrange
    when(jTextComponent.modelToView(anyInt())).thenReturn(new Rectangle());
    when(jTextComponent.modelToView2D(anyInt())).thenReturn(new Float());
    when(jTextComponent.getDocument()).thenReturn(new DefaultStyledDocument());

    // Act
    String actualToolTip = toolTipController.getToolTip(0, jTextComponent);

    // Assert
    verify(jTextComponent, atLeast(1)).getDocument();
    verify(jTextComponent).modelToView(0);
    verify(jTextComponent).modelToView2D(0);
    assertNull(actualToolTip);
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
