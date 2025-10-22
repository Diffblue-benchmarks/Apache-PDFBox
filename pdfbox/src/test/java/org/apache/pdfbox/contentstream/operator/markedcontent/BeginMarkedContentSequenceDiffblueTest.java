package org.apache.pdfbox.contentstream.operator.markedcontent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BeginMarkedContentSequenceDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BeginMarkedContentSequence#BeginMarkedContentSequence(PDFStreamEngine)}
   *   <li>{@link BeginMarkedContentSequence#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BeginMarkedContentSequence.<init>(PDFStreamEngine)",
      "java.lang.String BeginMarkedContentSequence.getName()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("BMC", (new BeginMarkedContentSequence(new PDFMarkedContentExtractor())).getName());
  }
}
