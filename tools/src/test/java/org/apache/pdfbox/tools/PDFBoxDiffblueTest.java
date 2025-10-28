package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class PDFBoxDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link PDFBox}
   */
  @Test
  void testNewPDFBox() {
    // Arrange, Act and Assert
    assertNull((new PDFBox()).spec);
  }
}
