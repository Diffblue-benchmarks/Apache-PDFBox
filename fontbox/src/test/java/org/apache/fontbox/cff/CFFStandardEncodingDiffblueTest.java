package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class CFFStandardEncodingDiffblueTest {
  /**
   * Method under test: {@link CFFStandardEncoding#getInstance()}
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CFFStandardEncoding actualInstance = CFFStandardEncoding.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance.getInstance());
  }
}
