package org.apache.pdfbox.contentstream.operator.markedcontent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EndMarkedContentSequenceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EndMarkedContentSequence#EndMarkedContentSequence(PDFStreamEngine)}
   *   <li>{@link EndMarkedContentSequence#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EndMarkedContentSequence.<init>(PDFStreamEngine)",
    "java.lang.String EndMarkedContentSequence.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("EMC", new EndMarkedContentSequence(new PDFMarkedContentExtractor()).getName());
  }
}
