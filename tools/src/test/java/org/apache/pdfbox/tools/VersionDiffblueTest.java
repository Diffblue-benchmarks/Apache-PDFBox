package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VersionDiffblueTest {
  /**
   * Test {@link Version#Version()}.
   * <p>
   * Method under test: default or parameterless constructor of {@link Version}
   */
  @Test
  @DisplayName("Test new Version()")
  void testNewVersion() {
    // Arrange, Act and Assert
    assertNull((new Version()).spec);
  }
}
