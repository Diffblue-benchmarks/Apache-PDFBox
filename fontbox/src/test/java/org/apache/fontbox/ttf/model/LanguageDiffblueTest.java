package org.apache.fontbox.ttf.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class LanguageDiffblueTest {
  /**
   * Method under test: {@link Language#getScriptNames()}
   */
  @Test
  void testGetScriptNames() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"bng2", "beng"}, Language.valueOf("BENGALI").getScriptNames());
  }
}
