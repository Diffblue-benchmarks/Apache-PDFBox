package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BadFieldValueExceptionDiffblueTest {
  /**
   * Test {@link BadFieldValueException#BadFieldValueException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BadFieldValueException#BadFieldValueException(String)}
   */
  @Test
  @DisplayName("Test new BadFieldValueException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BadFieldValueException.<init>(String)",
      "void BadFieldValueException.<init>(String, Throwable)"})
  void testNewBadFieldValueException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    BadFieldValueException actualBadFieldValueException = new BadFieldValueException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadFieldValueException.getMessage());
    assertNull(actualBadFieldValueException.getCause());
    assertEquals(0, actualBadFieldValueException.getSuppressed().length);
  }

  /**
   * Test {@link BadFieldValueException#BadFieldValueException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BadFieldValueException#BadFieldValueException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new BadFieldValueException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BadFieldValueException.<init>(String)",
      "void BadFieldValueException.<init>(String, Throwable)"})
  void testNewBadFieldValueException_whenThrowable_thenReturnCauseIsThrowable() {
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
