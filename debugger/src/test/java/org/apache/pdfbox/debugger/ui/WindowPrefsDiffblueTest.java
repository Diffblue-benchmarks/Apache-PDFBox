package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WindowPrefsDiffblueTest {
  /**
   * Test {@link WindowPrefs#setExtendedState(int)}.
   * <p>
   * Method under test: {@link WindowPrefs#setExtendedState(int)}
   */
  @Test
  @DisplayName("Test setExtendedState(int)")
  void testSetExtendedState() {
    // Arrange
    Class<Object> className = Object.class;
    WindowPrefs windowPrefs = new WindowPrefs(className);

    // Act
    windowPrefs.setExtendedState(3);

    // Assert that nothing has changed
    assertEquals(3, windowPrefs.getExtendedState());
  }
}
