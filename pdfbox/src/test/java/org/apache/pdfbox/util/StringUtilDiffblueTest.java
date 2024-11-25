package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilDiffblueTest {
  /**
   * Test {@link StringUtil#splitOnSpace(String)}.
   * <p>
   * Method under test: {@link StringUtil#splitOnSpace(String)}
   */
  @Test
  @DisplayName("Test splitOnSpace(String)")
  void testSplitOnSpace() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"foo"}, StringUtil.splitOnSpace("foo"));
  }

  /**
   * Test {@link StringUtil#tokenizeOnSpace(String)}.
   * <p>
   * Method under test: {@link StringUtil#tokenizeOnSpace(String)}
   */
  @Test
  @DisplayName("Test tokenizeOnSpace(String)")
  void testTokenizeOnSpace() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"foo"}, StringUtil.tokenizeOnSpace("foo"));
  }
}
