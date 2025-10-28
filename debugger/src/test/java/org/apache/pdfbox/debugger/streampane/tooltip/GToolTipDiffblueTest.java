package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class GToolTipDiffblueTest {
  /**
   * Method under test: {@link GToolTip#GToolTip(String)}
   */
  @Test
  void testNewGToolTip() {
    // Arrange, Act and Assert
    assertNull((new GToolTip("Row Text")).getToolTipText());
  }
}
