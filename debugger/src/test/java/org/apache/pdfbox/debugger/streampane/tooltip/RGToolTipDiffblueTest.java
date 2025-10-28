package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class RGToolTipDiffblueTest {
  /**
   * Method under test: {@link RGToolTip#RGToolTip(String)}
   */
  @Test
  void testNewRGToolTip() {
    // Arrange, Act and Assert
    assertNull((new RGToolTip("Row Text")).getToolTipText());
  }
}
