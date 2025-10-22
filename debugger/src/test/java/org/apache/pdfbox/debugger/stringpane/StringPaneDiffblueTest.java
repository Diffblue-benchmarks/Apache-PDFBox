package org.apache.pdfbox.debugger.stringpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import javax.swing.DefaultSingleSelectionModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringPaneDiffblueTest {
  /**
   * Test {@link StringPane#StringPane(COSString)}.
   * <ul>
   *   <li>When parseHex {@code 42}.</li>
   *   <li>Then Pane ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringPane#StringPane(COSString)}
   */
  @Test
  @DisplayName("Test new StringPane(COSString); when parseHex '42'; then Pane ColorModel return DirectColorModel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StringPane.<init>(COSString)"})
  void testNewStringPane_whenParseHex42_thenPaneColorModelReturnDirectColorModel() throws IOException {
    // Arrange, Act and Assert
    JTabbedPane pane = (new StringPane(COSString.parseHex("42"))).getPane();
    assertTrue(pane.getColorModel() instanceof DirectColorModel);
    assertTrue(pane.getModel() instanceof DefaultSingleSelectionModel);
    assertTrue(pane.getSelectedComponent() instanceof JTextPane);
    assertEquals(1, pane.getFocusListeners().length);
    assertEquals(1, pane.getMouseListeners().length);
    assertEquals(1, pane.getMouseMotionListeners().length);
    assertEquals(1, pane.getPropertyChangeListeners().length);
    assertEquals(1, pane.getContainerListeners().length);
    assertEquals(2, pane.getComponents().length);
  }

  /**
   * Test {@link StringPane#StringPane(COSString)}.
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringPane#StringPane(COSString)}
   */
  @Test
  @DisplayName("Test new StringPane(COSString); when parseHex '0123456789ABCDEF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StringPane.<init>(COSString)"})
  void testNewStringPane_whenParseHex0123456789abcdef() throws IOException {
    // Arrange, Act and Assert
    JTabbedPane pane = (new StringPane(COSString.parseHex("0123456789ABCDEF"))).getPane();
    assertTrue(pane.getColorModel() instanceof DirectColorModel);
    assertTrue(pane.getModel() instanceof DefaultSingleSelectionModel);
    assertTrue(pane.getSelectedComponent() instanceof JTextPane);
    assertEquals(1, pane.getFocusListeners().length);
    assertEquals(1, pane.getMouseListeners().length);
    assertEquals(1, pane.getMouseMotionListeners().length);
    assertEquals(1, pane.getPropertyChangeListeners().length);
    assertEquals(1, pane.getContainerListeners().length);
    assertEquals(2, pane.getComponents().length);
  }

  /**
   * Test {@link StringPane#StringPane(COSString)}.
   * <ul>
   *   <li>When parseHex empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringPane#StringPane(COSString)}
   */
  @Test
  @DisplayName("Test new StringPane(COSString); when parseHex empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StringPane.<init>(COSString)"})
  void testNewStringPane_whenParseHexEmptyString() throws IOException {
    // Arrange, Act and Assert
    JTabbedPane pane = (new StringPane(COSString.parseHex(""))).getPane();
    assertTrue(pane.getColorModel() instanceof DirectColorModel);
    assertTrue(pane.getModel() instanceof DefaultSingleSelectionModel);
    assertTrue(pane.getSelectedComponent() instanceof JTextPane);
    assertEquals(1, pane.getFocusListeners().length);
    assertEquals(1, pane.getMouseListeners().length);
    assertEquals(1, pane.getMouseMotionListeners().length);
    assertEquals(1, pane.getPropertyChangeListeners().length);
    assertEquals(1, pane.getContainerListeners().length);
    assertEquals(2, pane.getComponents().length);
  }
}
