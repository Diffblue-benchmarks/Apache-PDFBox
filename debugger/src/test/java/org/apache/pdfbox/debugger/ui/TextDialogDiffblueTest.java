package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TextDialogDiffblueTest {
  /**
   * Method under test: {@link TextDialog#instance()}
   */
  @Test
  void testInstance() {
    // Arrange, Act and Assert
    assertNull(TextDialog.instance());
  }
}
