package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class XmpSchemaExceptionDiffblueTest {
  /**
   * Test {@link XmpSchemaException#XmpSchemaException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSchemaException#XmpSchemaException(String)}
   */
  @Test
  @DisplayName("Test new XmpSchemaException(String); when 'An error occurred'; then return Cause is 'null'")
  void testNewXmpSchemaException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    XmpSchemaException actualXmpSchemaException = new XmpSchemaException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualXmpSchemaException.getMessage());
    assertNull(actualXmpSchemaException.getCause());
    assertEquals(0, actualXmpSchemaException.getSuppressed().length);
  }

  /**
   * Test {@link XmpSchemaException#XmpSchemaException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XmpSchemaException#XmpSchemaException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new XmpSchemaException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  void testNewXmpSchemaException_whenThrowable_thenReturnCauseIsThrowable() {
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
