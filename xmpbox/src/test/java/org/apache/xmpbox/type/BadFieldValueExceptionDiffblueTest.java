package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class BadFieldValueExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link BadFieldValueException#BadFieldValueException(String)}
   */
  @Test
  void testNewBadFieldValueException() {
    // Arrange and Act
    BadFieldValueException actualBadFieldValueException = new BadFieldValueException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadFieldValueException.getMessage());
    assertNull(actualBadFieldValueException.getCause());
    assertEquals(0, actualBadFieldValueException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link BadFieldValueException#BadFieldValueException(String, Throwable)}
   */
  @Test
  void testNewBadFieldValueException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    BadFieldValueException actualBadFieldValueException = new BadFieldValueException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualBadFieldValueException.getMessage());
    assertEquals(0, actualBadFieldValueException.getSuppressed().length);
    assertSame(cause, actualBadFieldValueException.getCause());
  }
}
