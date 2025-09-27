package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OverlayPDFDiffblueTest {
  /**
   * Test new {@link OverlayPDF} (default constructor).
   *
   * <ul>
   *   <li>Then return {@link OverlayPDF#specificPageOverlayFile} Empty.
   * </ul>
   *
   * <p>Method under test: default or parameterless constructor of {@link OverlayPDF}
   */
  @Test
  @DisplayName(
      "Test new OverlayPDF (default constructor); then return specificPageOverlayFile Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OverlayPDF.<init>()"})
  void testNewOverlayPDF_thenReturnSpecificPageOverlayFileEmpty() {
    // Arrange, Act and Assert
    assertTrue(new OverlayPDF().specificPageOverlayFile.isEmpty());
  }
}
