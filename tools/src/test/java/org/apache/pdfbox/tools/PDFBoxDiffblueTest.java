package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFBoxDiffblueTest {
  /**
   * Test new {@link PDFBox} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PDFBox}
   */
  @Test
  @DisplayName("Test new PDFBox (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFBox.<init>()"})
  void testNewPDFBox() {
    // Arrange, Act and Assert
    assertNull((new PDFBox()).spec);
  }
}
