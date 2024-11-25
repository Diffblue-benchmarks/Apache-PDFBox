package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KToolTipDiffblueTest {
  /**
   * Test {@link KToolTip#KToolTip(String)}.
   * <ul>
   *   <li>When {@code Row Text}.</li>
   *   <li>Then return ToolTipText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KToolTip#KToolTip(String)}
   */
  @Test
  @DisplayName("Test new KToolTip(String); when 'Row Text'; then return ToolTipText is 'null'")
  void testNewKToolTip_whenRowText_thenReturnToolTipTextIsNull() {
    // Arrange, Act and Assert
    assertNull((new KToolTip("Row Text")).getToolTipText());
  }

  /**
   * Test {@link KToolTip#KToolTip(String)}.
   * <ul>
   *   <li>When {@code Row}.</li>
   *   <li>Then return ToolTipText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KToolTip#KToolTip(String)}
   */
  @Test
  @DisplayName("Test new KToolTip(String); when 'Row'; then return ToolTipText is 'null'")
  void testNewKToolTip_whenRow_thenReturnToolTipTextIsNull() {
    // Arrange, Act and Assert
    assertNull((new KToolTip("Row")).getToolTipText());
  }

  /**
   * Test {@link KToolTip#getICCColorSpace()}.
   * <p>
   * Method under test: {@link KToolTip#getICCColorSpace()}
   */
  @Test
  @DisplayName("Test getICCColorSpace()")
  void testGetICCColorSpace() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new KToolTip("Row Text")).getICCColorSpace());
  }

  /**
   * Test {@link KToolTip#getICCProfile()}.
   * <p>
   * Method under test: {@link KToolTip#getICCProfile()}
   */
  @Test
  @DisplayName("Test getICCProfile()")
  void testGetICCProfile() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new KToolTip("Row Text")).getICCProfile());
  }
}
