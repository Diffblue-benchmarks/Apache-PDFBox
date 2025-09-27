package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ColorToolTipDiffblueTest {
  /**
   * Test {@link ColorToolTip#colorHexValue(Color)}.
   *
   * <ul>
   *   <li>When decode {@code 42}.
   *   <li>Then return {@code 00002a}.
   * </ul>
   *
   * <p>Method under test: {@link ColorToolTip#colorHexValue(Color)}
   */
  @Test
  @DisplayName("Test colorHexValue(Color); when decode '42'; then return '00002a'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ColorToolTip.colorHexValue(Color)"})
  void testColorHexValue_whenDecode42_thenReturn00002a() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals("00002a", ColorToolTip.colorHexValue(Color.decode("42")));
  }

  /**
   * Test {@link ColorToolTip#extractColorValues(String)}.
   *
   * <ul>
   *   <li>When {@code Rowtext}.
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link ColorToolTip#extractColorValues(String)}
   */
  @Test
  @DisplayName("Test extractColorValues(String); when 'Rowtext'; then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] ColorToolTip.extractColorValues(String)"})
  void testExtractColorValues_whenRowtext_thenReturnEmptyArrayOfFloat() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[] {}, new GToolTip("Row Text").extractColorValues("Rowtext"), 0.0f);
  }

  /**
   * Test {@link ColorToolTip#getMarkUp(String)}.
   *
   * <p>Method under test: {@link ColorToolTip#getMarkUp(String)}
   */
  @Test
  @DisplayName("Test getMarkUp(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ColorToolTip.getMarkUp(String)"})
  void testGetMarkUp() {
    // Arrange, Act and Assert
    assertEquals(
        "<html>\n"
            + "<body bgcolor=#ffffff>\n"
            + "<div style=\"width:50px;height:20px;border:1px; background-color:#42;\"></div></body>\n"
            + "</html>",
        new GToolTip("Row Text").getMarkUp("42"));
  }

  /**
   * Test {@link ColorToolTip#getToolTipText()}.
   *
   * <p>Method under test: {@link ColorToolTip#getToolTipText()}
   */
  @Test
  @DisplayName("Test getToolTipText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ColorToolTip.getToolTipText()"})
  void testGetToolTipText() {
    // Arrange, Act and Assert
    assertNull(new GToolTip("Row Text").getToolTipText());
  }
}
