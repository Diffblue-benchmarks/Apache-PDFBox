package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFBoxDiffblueTest {
  /**
   * Test new {@link PDFBox} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PDFBox}
   */
  @Test
  @DisplayName("Test new PDFBox (default constructor)")
  void testNewPDFBox() {
    // Arrange, Act and Assert
    assertNull((new PDFBox()).spec);
  }
}
