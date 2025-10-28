package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class CFFExpertCharsetDiffblueTest {
  /**
   * Method under test: {@link CFFExpertCharset#getInstance()}
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CFFExpertCharset actualInstance = CFFExpertCharset.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance.getInstance());
  }
}
