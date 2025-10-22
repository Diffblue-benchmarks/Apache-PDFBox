package org.apache.pdfbox.debugger.signaturepane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import javax.swing.DefaultSingleSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SignaturePaneDiffblueTest {
  /**
   * Test {@link SignaturePane#SignaturePane(COSString)}.
   * <ul>
   *   <li>When {@link COSString#COSString(String)} with text is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SignaturePane#SignaturePane(COSString)}
   */
  @Test
  @DisplayName("Test new SignaturePane(COSString); when COSString(String) with text is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SignaturePane.<init>(COSString)"})
  void testNewSignaturePane_whenCOSStringWithTextIs42() {
    // Arrange, Act and Assert
    JTabbedPane pane = (new SignaturePane(new COSString("42"))).getPane();
    assertTrue(pane.getColorModel() instanceof DirectColorModel);
    assertTrue(pane.getModel() instanceof DefaultSingleSelectionModel);
    assertTrue(pane.getSelectedComponent() instanceof JScrollPane);
    assertEquals(1, pane.getFocusListeners().length);
    assertEquals(1, pane.getMouseListeners().length);
    assertEquals(1, pane.getMouseMotionListeners().length);
    assertEquals(1, pane.getPropertyChangeListeners().length);
    assertEquals(1, pane.getComponents().length);
    assertEquals(1, pane.getContainerListeners().length);
  }

  /**
   * Test {@link SignaturePane#SignaturePane(COSString)}.
   * <ul>
   *   <li>When parseHex {@code 42}.</li>
   *   <li>Then Pane ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SignaturePane#SignaturePane(COSString)}
   */
  @Test
  @DisplayName("Test new SignaturePane(COSString); when parseHex '42'; then Pane ColorModel return DirectColorModel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SignaturePane.<init>(COSString)"})
  void testNewSignaturePane_whenParseHex42_thenPaneColorModelReturnDirectColorModel() throws IOException {
    // Arrange, Act and Assert
    JTabbedPane pane = (new SignaturePane(COSString.parseHex("42"))).getPane();
    assertTrue(pane.getColorModel() instanceof DirectColorModel);
    assertTrue(pane.getModel() instanceof DefaultSingleSelectionModel);
    assertTrue(pane.getSelectedComponent() instanceof JScrollPane);
    assertEquals(1, pane.getFocusListeners().length);
    assertEquals(1, pane.getMouseListeners().length);
    assertEquals(1, pane.getMouseMotionListeners().length);
    assertEquals(1, pane.getPropertyChangeListeners().length);
    assertEquals(1, pane.getComponents().length);
    assertEquals(1, pane.getContainerListeners().length);
  }

  /**
   * Test {@link SignaturePane#SignaturePane(COSString)}.
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SignaturePane#SignaturePane(COSString)}
   */
  @Test
  @DisplayName("Test new SignaturePane(COSString); when parseHex '0123456789ABCDEF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SignaturePane.<init>(COSString)"})
  void testNewSignaturePane_whenParseHex0123456789abcdef() throws IOException {
    // Arrange, Act and Assert
    JTabbedPane pane = (new SignaturePane(COSString.parseHex("0123456789ABCDEF"))).getPane();
    assertTrue(pane.getColorModel() instanceof DirectColorModel);
    assertTrue(pane.getModel() instanceof DefaultSingleSelectionModel);
    assertTrue(pane.getSelectedComponent() instanceof JScrollPane);
    assertEquals(1, pane.getFocusListeners().length);
    assertEquals(1, pane.getMouseListeners().length);
    assertEquals(1, pane.getMouseMotionListeners().length);
    assertEquals(1, pane.getPropertyChangeListeners().length);
    assertEquals(1, pane.getComponents().length);
    assertEquals(1, pane.getContainerListeners().length);
  }

  /**
   * Test {@link SignaturePane#SignaturePane(COSString)}.
   * <ul>
   *   <li>When parseHex {@code 420123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SignaturePane#SignaturePane(COSString)}
   */
  @Test
  @DisplayName("Test new SignaturePane(COSString); when parseHex '420123456789ABCDEF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SignaturePane.<init>(COSString)"})
  void testNewSignaturePane_whenParseHex420123456789abcdef() throws IOException {
    // Arrange, Act and Assert
    JTabbedPane pane = (new SignaturePane(COSString.parseHex("420123456789ABCDEF"))).getPane();
    assertTrue(pane.getColorModel() instanceof DirectColorModel);
    assertTrue(pane.getModel() instanceof DefaultSingleSelectionModel);
    assertTrue(pane.getSelectedComponent() instanceof JScrollPane);
    assertEquals(1, pane.getFocusListeners().length);
    assertEquals(1, pane.getMouseListeners().length);
    assertEquals(1, pane.getMouseMotionListeners().length);
    assertEquals(1, pane.getPropertyChangeListeners().length);
    assertEquals(1, pane.getComponents().length);
    assertEquals(1, pane.getContainerListeners().length);
  }
}
