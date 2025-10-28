package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class KToolTipDiffblueTest {
  /**
   * Method under test: {@link KToolTip#getICCColorSpace()}
   */
  @Test
  void testGetICCColorSpace() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new KToolTip("Row Text")).getICCColorSpace());
  }

  /**
   * Method under test: {@link KToolTip#getICCProfile()}
   */
  @Test
  void testGetICCProfile() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new KToolTip("Row Text")).getICCProfile());
  }

  /**
   * Method under test: {@link KToolTip#KToolTip(String)}
   */
  @Test
  void testNewKToolTip() {
    // Arrange, Act and Assert
    assertNull((new KToolTip("Row Text")).getToolTipText());
    assertNull((new KToolTip("Row")).getToolTipText());
  }
}
