package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CFFStandardEncodingDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Method under test: {@link CFFStandardEncoding#getInstance()}
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CFFStandardEncoding actualInstance = CFFStandardEncoding.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance.getInstance());
  }
}
