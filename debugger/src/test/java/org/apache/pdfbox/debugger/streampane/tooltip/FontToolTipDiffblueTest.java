package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FontToolTipDiffblueTest {
  /**
   * Test {@link FontToolTip#FontToolTip(PDResources, String)}.
   * <p>
   * Method under test: {@link FontToolTip#FontToolTip(PDResources, String)}
   */
  @Test
  @DisplayName("Test new FontToolTip(PDResources, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontToolTip.<init>(PDResources, String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FontToolTip.getToolTipText()"})
  void testGetToolTipText() {
    // Arrange, Act and Assert
    assertNull((new FontToolTip(new PDResources(), "Row Text")).getToolTipText());
  }
}
