package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetStrokingColorNDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetStrokingColorN#SetStrokingColorN(PDFStreamEngine)}
   *   <li>{@link SetStrokingColorN#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SetStrokingColorN.<init>(PDFStreamEngine)",
    "java.lang.String SetStrokingColorN.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("SCN", new SetStrokingColorN(new PDFMarkedContentExtractor()).getName());
  }
}
