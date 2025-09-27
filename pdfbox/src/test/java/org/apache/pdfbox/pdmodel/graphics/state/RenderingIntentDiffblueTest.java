package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RenderingIntentDiffblueTest {
  /**
   * Test {@link RenderingIntent#fromString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code RELATIVE_COLORIMETRIC}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingIntent#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String); when '42'; then return 'RELATIVE_COLORIMETRIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderingIntent RenderingIntent.fromString(String)"})
  void testFromString_when42_thenReturnRelativeColorimetric() {
    // Arrange, Act and Assert
    assertEquals(RenderingIntent.RELATIVE_COLORIMETRIC, RenderingIntent.fromString("42"));
  }

  /**
   * Test {@link RenderingIntent#fromString(String)}.
   *
   * <ul>
   *   <li>When {@code AbsoluteColorimetric}.
   *   <li>Then return {@code ABSOLUTE_COLORIMETRIC}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingIntent#fromString(String)}
   */
  @Test
  @DisplayName(
      "Test fromString(String); when 'AbsoluteColorimetric'; then return 'ABSOLUTE_COLORIMETRIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderingIntent RenderingIntent.fromString(String)"})
  void testFromString_whenAbsoluteColorimetric_thenReturnAbsoluteColorimetric() {
    // Arrange, Act and Assert
    assertEquals(
        RenderingIntent.ABSOLUTE_COLORIMETRIC, RenderingIntent.fromString("AbsoluteColorimetric"));
  }

  /**
   * Test {@link RenderingIntent#stringValue()}.
   *
   * <p>Method under test: {@link RenderingIntent#stringValue()}
   */
  @Test
  @DisplayName("Test stringValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RenderingIntent.stringValue()"})
  void testStringValue() {
    // Arrange, Act and Assert
    assertEquals("AbsoluteColorimetric", RenderingIntent.ABSOLUTE_COLORIMETRIC.stringValue());
  }
}
