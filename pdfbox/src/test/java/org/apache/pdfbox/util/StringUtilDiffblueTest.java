package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class StringUtilDiffblueTest {
  /**
   * Method under test: {@link StringUtil#splitOnSpace(String)}
   */
  @Test
  void testSplitOnSpace() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"foo"}, StringUtil.splitOnSpace("foo"));
  }

  /**
   * Method under test: {@link StringUtil#tokenizeOnSpace(String)}
   */
  @Test
  void testTokenizeOnSpace() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"foo"}, StringUtil.tokenizeOnSpace("foo"));
  }
}
