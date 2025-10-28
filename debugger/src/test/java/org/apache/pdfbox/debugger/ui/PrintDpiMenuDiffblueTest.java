package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class PrintDpiMenuDiffblueTest {
  /**
   * Method under test: {@link PrintDpiMenu#changeDpiSelection(int)}
   */
  @Test
  void testChangeDpiSelection() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PrintDpiMenu.getInstance().changeDpiSelection(1));
  }
}
