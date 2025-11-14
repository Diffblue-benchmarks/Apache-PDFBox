package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringUtilDiffblueTest {
  /**
   * Test {@link StringUtil#splitOnSpace(String)}.
   *
   * <p>Method under test: {@link StringUtil#splitOnSpace(String)}
   */
  @Test
  @DisplayName("Test splitOnSpace(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] StringUtil.splitOnSpace(String)"})
  void testSplitOnSpace() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[] {"foo"}, StringUtil.splitOnSpace("foo"));
  }

  /**
   * Test {@link StringUtil#tokenizeOnSpace(String)}.
   *
   * <p>Method under test: {@link StringUtil#tokenizeOnSpace(String)}
   */
  @Test
  @DisplayName("Test tokenizeOnSpace(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] StringUtil.tokenizeOnSpace(String)"})
  void testTokenizeOnSpace() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[] {"foo"}, StringUtil.tokenizeOnSpace("foo"));
  }
}
