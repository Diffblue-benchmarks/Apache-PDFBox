package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RenderingIntentDiffblueTest {
  /**
   * Method under test: {@link RenderingIntent#fromString(String)}
   */
  @Test
  void testFromString() {
    // Arrange, Act and Assert
    assertEquals(RenderingIntent.RELATIVE_COLORIMETRIC, RenderingIntent.fromString("42"));
    assertEquals(RenderingIntent.ABSOLUTE_COLORIMETRIC, RenderingIntent.fromString("AbsoluteColorimetric"));
  }

  /**
   * Method under test: {@link RenderingIntent#stringValue()}
   */
  @Test
  void testStringValue() {
    // Arrange, Act and Assert
    assertEquals("AbsoluteColorimetric", RenderingIntent.ABSOLUTE_COLORIMETRIC.stringValue());
  }
}
