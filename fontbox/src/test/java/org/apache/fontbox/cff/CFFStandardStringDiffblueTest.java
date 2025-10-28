package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CFFStandardStringDiffblueTest {
  /**
   * Method under test: {@link CFFStandardString#getName(int)}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("space", CFFStandardString.getName(1));
  }
}
