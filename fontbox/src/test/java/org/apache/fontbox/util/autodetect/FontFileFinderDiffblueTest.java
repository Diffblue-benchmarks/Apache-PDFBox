package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FontFileFinderDiffblueTest {
  /**
   * Test {@link FontFileFinder#find(String)} with {@code String}.
   * <p>
   * Method under test: {@link FontFileFinder#find(String)}
   */
  @Test
  @DisplayName("Test find(String) with 'String'")
  void testFindWithString() {
    // Arrange, Act and Assert
    assertTrue((new FontFileFinder()).find("Dir").isEmpty());
  }
}
