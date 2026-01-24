package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GToolTipDiffblueTest {
  /**
   * Test {@link GToolTip#GToolTip(String)}.
   *
   * <ul>
   *   <li>When {@code Row Text}.
   *   <li>Then return ToolTipText is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GToolTip#GToolTip(String)}
   */
  @Test
  @DisplayName("Test new GToolTip(String); when 'Row Text'; then return ToolTipText is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GToolTip.<init>(String)"})
  void testNewGToolTip_whenRowText_thenReturnToolTipTextIsNull() {
    // Arrange, Act and Assert
    assertNull(new GToolTip("Row Text").getToolTipText());
  }
}
