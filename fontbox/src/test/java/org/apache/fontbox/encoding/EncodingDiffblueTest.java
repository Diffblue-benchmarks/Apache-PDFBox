package org.apache.fontbox.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EncodingDiffblueTest {
  /**
   * Method under test: {@link Encoding#getName(int)}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals(".notdef", (new StandardEncoding()).getName(1));
  }
}
