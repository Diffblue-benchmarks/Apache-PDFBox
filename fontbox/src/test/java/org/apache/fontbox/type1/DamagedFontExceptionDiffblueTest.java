package org.apache.fontbox.type1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DamagedFontExceptionDiffblueTest {
  /**
   * Test {@link DamagedFontException#DamagedFontException(String)}.
   *
   * <p>Method under test: {@link DamagedFontException#DamagedFontException(String)}
   */
  @Test
  @DisplayName("Test new DamagedFontException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DamagedFontException.<init>(String)"})
  void testNewDamagedFontException() {
    // Arrange and Act
    DamagedFontException actualDamagedFontException = new DamagedFontException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDamagedFontException.getMessage());
    assertNull(actualDamagedFontException.getCause());
    assertEquals(0, actualDamagedFontException.getSuppressed().length);
  }
}
