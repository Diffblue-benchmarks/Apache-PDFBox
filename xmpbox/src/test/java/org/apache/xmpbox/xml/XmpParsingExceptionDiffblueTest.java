package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class XmpParsingExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link XmpParsingException#XmpParsingException(XmpParsingException.ErrorType, String)}
   *   <li>{@link XmpParsingException#getErrorType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'An error occurred'; then return Cause is 'null'")
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    XmpParsingException actualXmpParsingException = new XmpParsingException(XmpParsingException.ErrorType.Undefined,
        "An error occurred");
    XmpParsingException.ErrorType actualErrorType = actualXmpParsingException.getErrorType();

    // Assert
    assertEquals("An error occurred", actualXmpParsingException.getMessage());
    assertNull(actualXmpParsingException.getCause());
    assertEquals(0, actualXmpParsingException.getSuppressed().length);
    assertEquals(XmpParsingException.ErrorType.Undefined, actualErrorType);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link XmpParsingException#XmpParsingException(XmpParsingException.ErrorType, String, Throwable)}
   *   <li>{@link XmpParsingException#getErrorType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Throwable(); then return Cause is Throwable()")
  void testGettersAndSetters_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    XmpParsingException actualXmpParsingException = new XmpParsingException(XmpParsingException.ErrorType.Undefined,
        "An error occurred", cause);
    XmpParsingException.ErrorType actualErrorType = actualXmpParsingException.getErrorType();

    // Assert
    assertEquals("An error occurred", actualXmpParsingException.getMessage());
    assertEquals(0, actualXmpParsingException.getSuppressed().length);
    assertEquals(XmpParsingException.ErrorType.Undefined, actualErrorType);
    assertSame(cause, actualXmpParsingException.getCause());
  }
}
