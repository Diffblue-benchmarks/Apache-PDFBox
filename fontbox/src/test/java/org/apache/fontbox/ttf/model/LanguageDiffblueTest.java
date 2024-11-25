package org.apache.fontbox.ttf.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LanguageDiffblueTest {
  /**
   * Test {@link Language#getScriptNames()}.
   * <p>
   * Method under test: {@link Language#getScriptNames()}
   */
  @Test
  @DisplayName("Test getScriptNames()")
  void testGetScriptNames() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"bng2", "beng"}, Language.valueOf("BENGALI").getScriptNames());
  }
}
