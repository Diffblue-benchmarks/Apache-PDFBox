package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class XmpSerializationExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link XmpSerializationException#XmpSerializationException(String)}
   */
  @Test
  void testNewXmpSerializationException() {
    // Arrange and Act
    XmpSerializationException actualXmpSerializationException = new XmpSerializationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualXmpSerializationException.getMessage());
    assertNull(actualXmpSerializationException.getCause());
    assertEquals(0, actualXmpSerializationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link XmpSerializationException#XmpSerializationException(String, Throwable)}
   */
  @Test
  void testNewXmpSerializationException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    XmpSerializationException actualXmpSerializationException = new XmpSerializationException("An error occurred",
        cause);

    // Assert
    assertEquals("An error occurred", actualXmpSerializationException.getMessage());
    assertEquals(0, actualXmpSerializationException.getSuppressed().length);
    assertSame(cause, actualXmpSerializationException.getCause());
  }
}
