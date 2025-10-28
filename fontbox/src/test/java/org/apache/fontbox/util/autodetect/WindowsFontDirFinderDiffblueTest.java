package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class WindowsFontDirFinderDiffblueTest {
  /**
   * Method under test: {@link WindowsFontDirFinder#find()}
   */
  @Test
  void testFind() {
    // Arrange, Act and Assert
    assertTrue((new WindowsFontDirFinder()).find().isEmpty());
  }
}
