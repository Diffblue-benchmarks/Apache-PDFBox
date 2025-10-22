package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LogDialogDiffblueTest {
  /**
   * Test {@link LogDialog#instance()}.
   * <p>
   * Method under test: {@link LogDialog#instance()}
   */
  @Test
  @DisplayName("Test instance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogDialog LogDialog.instance()"})
  void testInstance() {
    // Arrange, Act and Assert
    assertNull(LogDialog.instance());
  }
}
