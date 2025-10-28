package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class VersionDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Version}
   */
  @Test
  void testNewVersion() {
    // Arrange, Act and Assert
    assertNull((new Version()).spec);
  }
}
