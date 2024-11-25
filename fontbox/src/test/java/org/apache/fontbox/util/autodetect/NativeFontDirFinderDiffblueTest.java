package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NativeFontDirFinderDiffblueTest {
  /**
   * Test {@link NativeFontDirFinder#find()}.
   * <p>
   * Method under test: {@link NativeFontDirFinder#find()}
   */
  @Test
  @DisplayName("Test find()")
  void testFind() {
    // Arrange, Act and Assert
    assertTrue((new MacFontDirFinder()).find().isEmpty());
  }
}
