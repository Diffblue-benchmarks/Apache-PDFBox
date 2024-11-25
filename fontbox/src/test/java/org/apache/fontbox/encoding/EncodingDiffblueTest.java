package org.apache.fontbox.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EncodingDiffblueTest {
  /**
   * Test {@link Encoding#getName(int)}.
   * <ul>
   *   <li>Given {@link StandardEncoding} (default constructor).</li>
   *   <li>Then return {@code .notdef}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Encoding#getName(int)}
   */
  @Test
  @DisplayName("Test getName(int); given StandardEncoding (default constructor); then return '.notdef'")
  void testGetName_givenStandardEncoding_thenReturnNotdef() {
    // Arrange, Act and Assert
    assertEquals(".notdef", (new StandardEncoding()).getName(1));
  }
}
