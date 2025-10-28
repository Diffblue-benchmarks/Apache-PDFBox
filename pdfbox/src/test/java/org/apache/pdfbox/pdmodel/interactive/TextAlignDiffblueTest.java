package org.apache.pdfbox.pdmodel.interactive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TextAlignDiffblueTest {
  /**
   * Method under test: {@link TextAlign#getTextAlign()}
   */
  @Test
  void testGetTextAlign() {
    // Arrange, Act and Assert
    assertEquals(0, TextAlign.valueOf("LEFT").getTextAlign());
  }

  /**
   * Method under test: {@link TextAlign#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertEquals(TextAlign.CENTER, TextAlign.valueOf(1));
    assertEquals(TextAlign.LEFT, TextAlign.valueOf(-1));
  }
}
