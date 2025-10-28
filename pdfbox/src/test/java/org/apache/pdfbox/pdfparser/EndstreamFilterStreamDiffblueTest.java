package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EndstreamFilterStreamDiffblueTest {
  /**
   * Method under test: {@link EndstreamFilterStream#calculateLength()}
   */
  @Test
  void testCalculateLength() {
    // Arrange, Act and Assert
    assertEquals(0L, (new EndstreamFilterStream()).calculateLength());
  }
}
