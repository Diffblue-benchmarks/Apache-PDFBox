package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RGToolTipDiffblueTest {
  /**
   * Test {@link RGToolTip#RGToolTip(String)}.
   *
   * <ul>
   *   <li>When {@code PluginManager '{}' found {} plugins}.
   *   <li>Then return ToolTipText is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RGToolTip#RGToolTip(String)}
   */
  @Test
  @DisplayName(
      "Test new RGToolTip(String); when 'PluginManager '{}' found {} plugins'; then return ToolTipText is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RGToolTip.<init>(String)"})
  void testNewRGToolTip_whenPluginManagerFoundPlugins_thenReturnToolTipTextIsNull() {
    // Arrange, Act and Assert
    assertNull(new RGToolTip("PluginManager '{}' found {} plugins").getToolTipText());
  }
}
