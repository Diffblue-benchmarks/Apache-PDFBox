package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VersionDiffblueTest {
  /**
   * Test {@link Version#getVersion()}.
   * <p>
   * Method under test: {@link Version#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion()")
  void testGetVersion() {
    // Arrange, Act and Assert
    assertEquals("4.0.0-SNAPSHOT", Version.getVersion());
  }
}
