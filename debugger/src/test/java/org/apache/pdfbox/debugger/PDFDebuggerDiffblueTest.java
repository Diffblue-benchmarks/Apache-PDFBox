package org.apache.pdfbox.debugger;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFDebuggerDiffblueTest {
  /**
   * Test {@link PDFDebugger#getPageLabel(PDDocument, int)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFDebugger#getPageLabel(PDDocument, int)}
   */
  @Test
  @DisplayName("Test getPageLabel(PDDocument, int); when PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDFDebugger.getPageLabel(PDDocument, int)"})
  void testGetPageLabel_whenPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDFDebugger.getPageLabel(new PDDocument(), 1));
  }
}
