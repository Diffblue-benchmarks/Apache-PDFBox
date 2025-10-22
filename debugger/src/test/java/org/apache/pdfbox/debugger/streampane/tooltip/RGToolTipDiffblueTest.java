package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RGToolTipDiffblueTest {
  /**
   * Test {@link RGToolTip#RGToolTip(String)}.
   * <ul>
   *   <li>When {@code Row Text}.</li>
   *   <li>Then return ToolTipText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RGToolTip#RGToolTip(String)}
   */
  @Test
  @DisplayName("Test new RGToolTip(String); when 'Row Text'; then return ToolTipText is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RGToolTip.<init>(String)"})
  void testNewRGToolTip_whenRowText_thenReturnToolTipTextIsNull() {
    // Arrange, Act and Assert
    assertNull((new RGToolTip("Row Text")).getToolTipText());
  }
}
