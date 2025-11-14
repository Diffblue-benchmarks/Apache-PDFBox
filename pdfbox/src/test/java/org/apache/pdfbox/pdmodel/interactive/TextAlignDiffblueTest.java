package org.apache.pdfbox.pdmodel.interactive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TextAlignDiffblueTest {
  /**
   * Test {@link TextAlign#getTextAlign()}.
   *
   * <p>Method under test: {@link TextAlign#getTextAlign()}
   */
  @Test
  @DisplayName("Test getTextAlign()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TextAlign.getTextAlign()"})
  void testGetTextAlign() {
    // Arrange, Act and Assert
    assertEquals(0, TextAlign.valueOf("LEFT").getTextAlign());
  }

  /**
   * Test {@link TextAlign#valueOf(int)} with {@code alignment}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code LEFT}.
   * </ul>
   *
   * <p>Method under test: {@link TextAlign#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'alignment'; when minus one; then return 'LEFT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextAlign TextAlign.valueOf(int)"})
  void testValueOfWithAlignment_whenMinusOne_thenReturnLeft() {
    // Arrange, Act and Assert
    assertEquals(TextAlign.LEFT, TextAlign.valueOf(-1));
  }

  /**
   * Test {@link TextAlign#valueOf(int)} with {@code alignment}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code CENTER}.
   * </ul>
   *
   * <p>Method under test: {@link TextAlign#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'alignment'; when one; then return 'CENTER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextAlign TextAlign.valueOf(int)"})
  void testValueOfWithAlignment_whenOne_thenReturnCenter() {
    // Arrange, Act and Assert
    assertEquals(TextAlign.CENTER, TextAlign.valueOf(1));
  }
}
