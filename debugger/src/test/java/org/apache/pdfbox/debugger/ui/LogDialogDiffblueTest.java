package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class LogDialogDiffblueTest {
  /**
   * Method under test: {@link LogDialog#instance()}
   */
  @Test
  void testInstance() {
    // Arrange, Act and Assert
    assertNull(LogDialog.instance());
  }
}
