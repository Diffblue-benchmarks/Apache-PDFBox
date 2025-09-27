package org.apache.pdfbox.examples.pdmodel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EmbeddedMultipleFontsDiffblueTest {
  /**
   * Test {@link EmbeddedMultipleFonts#isWinAnsiEncoding(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedMultipleFonts#isWinAnsiEncoding(int)}
   */
  @Test
  @DisplayName("Test isWinAnsiEncoding(int); when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmbeddedMultipleFonts.isWinAnsiEncoding(int)"})
  void testIsWinAnsiEncoding_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EmbeddedMultipleFonts.isWinAnsiEncoding(1));
  }

  /**
   * Test {@link EmbeddedMultipleFonts#isWinAnsiEncoding(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedMultipleFonts#isWinAnsiEncoding(int)}
   */
  @Test
  @DisplayName("Test isWinAnsiEncoding(int); when zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmbeddedMultipleFonts.isWinAnsiEncoding(int)"})
  void testIsWinAnsiEncoding_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EmbeddedMultipleFonts.isWinAnsiEncoding(0));
  }
}
