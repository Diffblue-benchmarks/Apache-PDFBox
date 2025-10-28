package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class CFFISOAdobeCharsetDiffblueTest {
  /**
   * Method under test: {@link CFFISOAdobeCharset#getInstance()}
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CFFISOAdobeCharset actualInstance = CFFISOAdobeCharset.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance.getInstance());
  }
}
