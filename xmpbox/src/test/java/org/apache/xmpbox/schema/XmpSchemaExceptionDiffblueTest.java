package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class XmpSchemaExceptionDiffblueTest {
  /**
   * Method under test: {@link XmpSchemaException#XmpSchemaException(String)}
   */
  @Test
  void testNewXmpSchemaException() {
    // Arrange and Act
    XmpSchemaException actualXmpSchemaException = new XmpSchemaException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualXmpSchemaException.getMessage());
    assertNull(actualXmpSchemaException.getCause());
    assertEquals(0, actualXmpSchemaException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link XmpSchemaException#XmpSchemaException(String, Throwable)}
   */
  @Test
  void testNewXmpSchemaException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    XmpSchemaException actualXmpSchemaException = new XmpSchemaException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualXmpSchemaException.getMessage());
    assertEquals(0, actualXmpSchemaException.getSuppressed().length);
    assertSame(cause, actualXmpSchemaException.getCause());
  }
}
