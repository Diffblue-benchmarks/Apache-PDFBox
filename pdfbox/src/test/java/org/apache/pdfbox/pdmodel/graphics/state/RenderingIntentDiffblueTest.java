package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RenderingIntentDiffblueTest {
  /**
   * Test {@link RenderingIntent#fromString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code RELATIVE_COLORIMETRIC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RenderingIntent#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String); when '42'; then return 'RELATIVE_COLORIMETRIC'")
  void testFromString_when42_thenReturnRelativeColorimetric() {
    // Arrange, Act and Assert
    assertEquals(RenderingIntent.RELATIVE_COLORIMETRIC, RenderingIntent.fromString("42"));
  }

  /**
   * Test {@link RenderingIntent#fromString(String)}.
   * <ul>
   *   <li>When {@code AbsoluteColorimetric}.</li>
   *   <li>Then return {@code ABSOLUTE_COLORIMETRIC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RenderingIntent#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String); when 'AbsoluteColorimetric'; then return 'ABSOLUTE_COLORIMETRIC'")
  void testFromString_whenAbsoluteColorimetric_thenReturnAbsoluteColorimetric() {
    // Arrange, Act and Assert
    assertEquals(RenderingIntent.ABSOLUTE_COLORIMETRIC, RenderingIntent.fromString("AbsoluteColorimetric"));
  }

  /**
   * Test {@link RenderingIntent#stringValue()}.
   * <p>
   * Method under test: {@link RenderingIntent#stringValue()}
   */
  @Test
  @DisplayName("Test stringValue()")
  void testStringValue() {
    // Arrange, Act and Assert
    assertEquals("AbsoluteColorimetric", RenderingIntent.ABSOLUTE_COLORIMETRIC.stringValue());
  }
}
