package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmptyGraphicsStackExceptionDiffblueTest {
  /**
   * Test {@link EmptyGraphicsStackException#EmptyGraphicsStackException()}.
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link EmptyGraphicsStackException}
   */
  @Test
  @DisplayName("Test new EmptyGraphicsStackException()")
  void testNewEmptyGraphicsStackException() {
    // Arrange and Act
    EmptyGraphicsStackException actualEmptyGraphicsStackException = new EmptyGraphicsStackException();

    // Assert
    assertEquals("Cannot execute restore, the graphics stack is empty", actualEmptyGraphicsStackException.getMessage());
    assertNull(actualEmptyGraphicsStackException.getCause());
    assertEquals(0, actualEmptyGraphicsStackException.getSuppressed().length);
  }
}
