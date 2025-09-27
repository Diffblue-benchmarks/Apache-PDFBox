package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EmptyGraphicsStackExceptionDiffblueTest {
  /**
   * Test {@link EmptyGraphicsStackException#EmptyGraphicsStackException()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * EmptyGraphicsStackException}
   */
  @Test
  @DisplayName("Test new EmptyGraphicsStackException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmptyGraphicsStackException.<init>()"})
  void testNewEmptyGraphicsStackException() {
    // Arrange and Act
    EmptyGraphicsStackException actualEmptyGraphicsStackException =
        new EmptyGraphicsStackException();

    // Assert
    assertEquals(
        "Cannot execute restore, the graphics stack is empty",
        actualEmptyGraphicsStackException.getMessage());
    assertNull(actualEmptyGraphicsStackException.getCause());
    assertEquals(0, actualEmptyGraphicsStackException.getSuppressed().length);
  }
}
