package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class OpenTypeScriptDiffblueTest {
  /**
   * Method under test: {@link OpenTypeScript#getScriptTags(int)}
   */
  @Test
  void testGetScriptTags() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{OpenTypeScript.TAG_DEFAULT}, OpenTypeScript.getScriptTags(1));
    assertArrayEquals(new String[]{OpenTypeScript.TAG_DEFAULT}, OpenTypeScript.getScriptTags(0));
    assertThrows(IllegalArgumentException.class, () -> OpenTypeScript.getScriptTags(-1));
    assertArrayEquals(new String[]{OpenTypeScript.TAG_DEFAULT}, OpenTypeScript.getScriptTags(1114111));
    assertThrows(IllegalArgumentException.class, () -> OpenTypeScript.getScriptTags(1114112));
  }
}
