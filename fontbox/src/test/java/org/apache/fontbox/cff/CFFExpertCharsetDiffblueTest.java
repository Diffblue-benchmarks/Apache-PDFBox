package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CFFExpertCharsetDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Method under test: {@link CFFExpertCharset#getInstance()}
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CFFExpertCharset actualInstance = CFFExpertCharset.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance.getInstance());
  }
}
