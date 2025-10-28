package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;

class SetStrokingColorNDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetStrokingColorN#SetStrokingColorN(PDFStreamEngine)}
   *   <li>{@link SetStrokingColorN#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("SCN", (new SetStrokingColorN(new PDFMarkedContentExtractor())).getName());
  }
}
