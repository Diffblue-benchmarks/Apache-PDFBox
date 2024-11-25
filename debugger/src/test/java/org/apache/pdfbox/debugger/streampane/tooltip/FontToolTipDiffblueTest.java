package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FontToolTipDiffblueTest {
  /**
   * Test {@link FontToolTip#FontToolTip(PDResources, String)}.
   * <p>
   * Method under test: {@link FontToolTip#FontToolTip(PDResources, String)}
   */
  @Test
  @DisplayName("Test new FontToolTip(PDResources, String)")
  void testNewFontToolTip() {
    // Arrange, Act and Assert
    assertNull((new FontToolTip(new PDResources(), "Row Text")).getToolTipText());
  }

  /**
   * Test {@link FontToolTip#getToolTipText()}.
   * <p>
   * Method under test: {@link FontToolTip#getToolTipText()}
   */
  @Test
  @DisplayName("Test getToolTipText()")
  void testGetToolTipText() {
    // Arrange, Act and Assert
    assertNull((new FontToolTip(new PDResources(), "Row Text")).getToolTipText());
  }
}
