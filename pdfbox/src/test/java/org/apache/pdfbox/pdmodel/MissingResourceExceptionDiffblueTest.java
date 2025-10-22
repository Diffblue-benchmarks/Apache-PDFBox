package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MissingResourceExceptionDiffblueTest {
  /**
   * Test {@link MissingResourceException#MissingResourceException(String)}.
   * <p>
   * Method under test: {@link MissingResourceException#MissingResourceException(String)}
   */
  @Test
  @DisplayName("Test new MissingResourceException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MissingResourceException.<init>(String)"})
  void testNewMissingResourceException() {
    // Arrange and Act
    MissingResourceException actualMissingResourceException = new MissingResourceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualMissingResourceException.getMessage());
    assertNull(actualMissingResourceException.getCause());
    assertEquals(0, actualMissingResourceException.getSuppressed().length);
  }
}
