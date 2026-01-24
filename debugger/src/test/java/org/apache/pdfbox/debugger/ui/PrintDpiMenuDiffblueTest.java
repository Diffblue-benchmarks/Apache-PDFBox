package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrintDpiMenuDiffblueTest {
  /**
   * Test {@link PrintDpiMenu#changeDpiSelection(int)}.
   *
   * <ul>
   *   <li>When one hundred.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PrintDpiMenu#changeDpiSelection(int)}
   */
  @Test
  @DisplayName("Test changeDpiSelection(int); when one hundred; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintDpiMenu.changeDpiSelection(int)"})
  void testChangeDpiSelection_whenOneHundred_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> PrintDpiMenu.getInstance().changeDpiSelection(100));
  }

  /**
   * Test {@link PrintDpiMenu#changeDpiSelection(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PrintDpiMenu#changeDpiSelection(int)}
   */
  @Test
  @DisplayName("Test changeDpiSelection(int); when one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintDpiMenu.changeDpiSelection(int)"})
  void testChangeDpiSelection_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> PrintDpiMenu.getInstance().changeDpiSelection(1));
  }
}
