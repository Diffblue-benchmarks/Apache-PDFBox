package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XmpSerializationExceptionDiffblueTest {
  /**
   * Test {@link XmpSerializationException#XmpSerializationException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializationException#XmpSerializationException(String)}
   */
  @Test
  @DisplayName(
      "Test new XmpSerializationException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void XmpSerializationException.<init>(String)",
    "void XmpSerializationException.<init>(String, Throwable)"
  })
  void testNewXmpSerializationException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    XmpSerializationException actualXmpSerializationException =
        new XmpSerializationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualXmpSerializationException.getMessage());
    assertNull(actualXmpSerializationException.getCause());
    assertEquals(0, actualXmpSerializationException.getSuppressed().length);
  }

  /**
   * Test {@link XmpSerializationException#XmpSerializationException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializationException#XmpSerializationException(String,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test new XmpSerializationException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void XmpSerializationException.<init>(String)",
    "void XmpSerializationException.<init>(String, Throwable)"
  })
  void testNewXmpSerializationException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    XmpSerializationException actualXmpSerializationException =
        new XmpSerializationException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualXmpSerializationException.getMessage());
    assertEquals(0, actualXmpSerializationException.getSuppressed().length);
    assertSame(cause, actualXmpSerializationException.getCause());
  }
}
