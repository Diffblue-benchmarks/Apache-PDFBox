package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class XmpParsingExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link XmpParsingException#XmpParsingException(XmpParsingException.ErrorType, String)}
   *   <li>{@link XmpParsingException#getErrorType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
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
   * Methods under test:
   * <ul>
   *   <li>
   * {@link XmpParsingException#XmpParsingException(XmpParsingException.ErrorType, String, Throwable)}
   *   <li>{@link XmpParsingException#getErrorType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
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
