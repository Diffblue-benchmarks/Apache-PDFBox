package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PDPageContentStreamDiffblueTest {
  /**
   * Method under test: {@link PDPageContentStream.AppendMode#isOverwrite()}
   */
  @Test
  void testAppendModeIsOverwrite() {
    // Arrange, Act and Assert
    assertTrue(PDPageContentStream.AppendMode.OVERWRITE.isOverwrite());
    assertFalse(PDPageContentStream.AppendMode.APPEND.isOverwrite());
  }

  /**
   * Method under test: {@link PDPageContentStream.AppendMode#isPrepend()}
   */
  @Test
  void testAppendModeIsPrepend() {
    // Arrange, Act and Assert
    assertFalse(PDPageContentStream.AppendMode.OVERWRITE.isPrepend());
    assertTrue(PDPageContentStream.AppendMode.PREPEND.isPrepend());
  }
}
