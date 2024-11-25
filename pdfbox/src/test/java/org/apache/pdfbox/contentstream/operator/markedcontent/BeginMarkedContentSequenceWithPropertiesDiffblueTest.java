package org.apache.pdfbox.contentstream.operator.markedcontent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BeginMarkedContentSequenceWithPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BeginMarkedContentSequenceWithProperties#BeginMarkedContentSequenceWithProperties(PDFStreamEngine)}
   *   <li>{@link BeginMarkedContentSequenceWithProperties#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("BDC", (new BeginMarkedContentSequenceWithProperties(new PDFMarkedContentExtractor())).getName());
  }
}
