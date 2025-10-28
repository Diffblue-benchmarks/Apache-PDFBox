package org.apache.fontbox.type1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class DamagedFontExceptionDiffblueTest {
  /**
   * Method under test: {@link DamagedFontException#DamagedFontException(String)}
   */
  @Test
  void testNewDamagedFontException() {
    // Arrange and Act
    DamagedFontException actualDamagedFontException = new DamagedFontException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDamagedFontException.getMessage());
    assertNull(actualDamagedFontException.getCause());
    assertEquals(0, actualDamagedFontException.getSuppressed().length);
  }
}
