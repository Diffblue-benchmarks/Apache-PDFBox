package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class MissingResourceExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link MissingResourceException#MissingResourceException(String)}
   */
  @Test
  void testNewMissingResourceException() {
    // Arrange and Act
    MissingResourceException actualMissingResourceException = new MissingResourceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualMissingResourceException.getMessage());
    assertNull(actualMissingResourceException.getCause());
    assertEquals(0, actualMissingResourceException.getSuppressed().length);
  }
}
