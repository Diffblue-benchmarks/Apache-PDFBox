package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertNull;
import java.awt.event.MouseEvent;
import org.junit.jupiter.api.Test;

class TreeDiffblueTest {
  /**
   * Method under test: {@link Tree#getPopupLocation(MouseEvent)}
   */
  @Test
  void testGetPopupLocation() {
    // Arrange, Act and Assert
    assertNull((new Tree()).getPopupLocation(null));
  }
}
