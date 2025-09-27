package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DecompressObjectstreamsDiffblueTest {
  /**
   * Test new {@link DecompressObjectstreams} (default constructor).
   *
   * <ul>
   *   <li>Then return not {@link DecompressObjectstreams#usageHelpRequested}.
   * </ul>
   *
   * <p>Method under test: default or parameterless constructor of {@link DecompressObjectstreams}
   */
  @Test
  @DisplayName(
      "Test new DecompressObjectstreams (default constructor); then return not usageHelpRequested")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DecompressObjectstreams.<init>()"})
  void testNewDecompressObjectstreams_thenReturnNotUsageHelpRequested() {
    // Arrange, Act and Assert
    assertFalse(new DecompressObjectstreams().usageHelpRequested);
  }
}
