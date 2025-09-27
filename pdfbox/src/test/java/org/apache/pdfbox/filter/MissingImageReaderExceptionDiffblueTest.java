package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MissingImageReaderExceptionDiffblueTest {
  /**
   * Test {@link MissingImageReaderException#MissingImageReaderException(String)}.
   *
   * <p>Method under test: {@link MissingImageReaderException#MissingImageReaderException(String)}
   */
  @Test
  @DisplayName("Test new MissingImageReaderException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MissingImageReaderException.<init>(String)"})
  void testNewMissingImageReaderException() {
    // Arrange and Act
    MissingImageReaderException actualMissingImageReaderException =
        new MissingImageReaderException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualMissingImageReaderException.getMessage());
    assertNull(actualMissingImageReaderException.getCause());
    assertEquals(0, actualMissingImageReaderException.getSuppressed().length);
  }
}
