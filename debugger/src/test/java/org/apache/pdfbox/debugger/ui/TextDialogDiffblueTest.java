package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TextDialogDiffblueTest {
  /**
   * Test {@link TextDialog#instance()}.
   * <p>
   * Method under test: {@link TextDialog#instance()}
   */
  @Test
  @DisplayName("Test instance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextDialog TextDialog.instance()"})
  void testInstance() {
    // Arrange, Act and Assert
    assertNull(TextDialog.instance());
  }
}
