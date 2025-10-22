package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OpenTypeScriptDiffblueTest {
  /**
   * Test {@link OpenTypeScript#getScriptTags(int)}.
   * <ul>
   *   <li>When {@code 1114111}.</li>
   *   <li>Then return array of {@link String} with {@link OpenTypeScript#TAG_DEFAULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OpenTypeScript#getScriptTags(int)}
   */
  @Test
  @DisplayName("Test getScriptTags(int); when '1114111'; then return array of String with TAG_DEFAULT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] OpenTypeScript.getScriptTags(int)"})
  void testGetScriptTags_when1114111_thenReturnArrayOfStringWithTag_default() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{OpenTypeScript.TAG_DEFAULT}, OpenTypeScript.getScriptTags(1114111));
  }

  /**
   * Test {@link OpenTypeScript#getScriptTags(int)}.
   * <ul>
   *   <li>When {@code 1114112}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OpenTypeScript#getScriptTags(int)}
   */
  @Test
  @DisplayName("Test getScriptTags(int); when '1114112'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] OpenTypeScript.getScriptTags(int)"})
  void testGetScriptTags_when1114112_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> OpenTypeScript.getScriptTags(1114112));
  }

  /**
   * Test {@link OpenTypeScript#getScriptTags(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OpenTypeScript#getScriptTags(int)}
   */
  @Test
  @DisplayName("Test getScriptTags(int); when minus one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] OpenTypeScript.getScriptTags(int)"})
  void testGetScriptTags_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> OpenTypeScript.getScriptTags(-1));
  }

  /**
   * Test {@link OpenTypeScript#getScriptTags(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return array of {@link String} with {@link OpenTypeScript#TAG_DEFAULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OpenTypeScript#getScriptTags(int)}
   */
  @Test
  @DisplayName("Test getScriptTags(int); when one; then return array of String with TAG_DEFAULT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] OpenTypeScript.getScriptTags(int)"})
  void testGetScriptTags_whenOne_thenReturnArrayOfStringWithTag_default() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{OpenTypeScript.TAG_DEFAULT}, OpenTypeScript.getScriptTags(1));
  }

  /**
   * Test {@link OpenTypeScript#getScriptTags(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return array of {@link String} with {@link OpenTypeScript#TAG_DEFAULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OpenTypeScript#getScriptTags(int)}
   */
  @Test
  @DisplayName("Test getScriptTags(int); when zero; then return array of String with TAG_DEFAULT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] OpenTypeScript.getScriptTags(int)"})
  void testGetScriptTags_whenZero_thenReturnArrayOfStringWithTag_default() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{OpenTypeScript.TAG_DEFAULT}, OpenTypeScript.getScriptTags(0));
  }
}
