package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LogDialogDiffblueTest {
  /**
   * Test {@link LogDialog#instance()}.
   * <p>
   * Method under test: {@link LogDialog#instance()}
   */
  @Test
  @DisplayName("Test instance()")
  void testInstance() {
    // Arrange, Act and Assert
    assertNull(LogDialog.instance());
  }
}
