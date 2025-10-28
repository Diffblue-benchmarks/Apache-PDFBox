package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class InvalidPasswordExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link InvalidPasswordException#InvalidPasswordException(String)}
   */
  @Test
  void testNewInvalidPasswordException() {
    // Arrange and Act
    InvalidPasswordException actualInvalidPasswordException = new InvalidPasswordException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInvalidPasswordException.getMessage());
    assertNull(actualInvalidPasswordException.getCause());
    assertEquals(0, actualInvalidPasswordException.getSuppressed().length);
  }
}
