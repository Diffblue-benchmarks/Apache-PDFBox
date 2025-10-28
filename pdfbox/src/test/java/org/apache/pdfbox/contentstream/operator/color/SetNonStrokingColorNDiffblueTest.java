package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;

class SetNonStrokingColorNDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetNonStrokingColorN#SetNonStrokingColorN(PDFStreamEngine)}
   *   <li>{@link SetNonStrokingColorN#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("scn", (new SetNonStrokingColorN(new PDFMarkedContentExtractor())).getName());
  }
}
