package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GToolTipDiffblueTest {
  /**
   * Test {@link GToolTip#GToolTip(String)}.
   * <ul>
   *   <li>When {@code Row Text}.</li>
   *   <li>Then return ToolTipText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GToolTip#GToolTip(String)}
   */
  @Test
  @DisplayName("Test new GToolTip(String); when 'Row Text'; then return ToolTipText is 'null'")
  void testNewGToolTip_whenRowText_thenReturnToolTipTextIsNull() {
    // Arrange, Act and Assert
    assertNull((new GToolTip("Row Text")).getToolTipText());
  }
}
