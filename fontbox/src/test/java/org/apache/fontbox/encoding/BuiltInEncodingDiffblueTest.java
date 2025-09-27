package org.apache.fontbox.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BuiltInEncodingDiffblueTest {
  /**
   * Test {@link BuiltInEncoding#BuiltInEncoding(Map)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashMap#HashMap()} one is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  @DisplayName("Test new BuiltInEncoding(Map); given one; when HashMap() one is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuiltInEncoding.<init>(Map)"})
  void testNewBuiltInEncoding_givenOne_whenHashMapOneIs42() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.put(1, "42");
    codeToName.put(250, "foo");

    // Act and Assert
    assertEquals(codeToName, new BuiltInEncoding(codeToName).getCodeToNameMap());
  }

  /**
   * Test {@link BuiltInEncoding#BuiltInEncoding(Map)}.
   *
   * <ul>
   *   <li>Given two hundred fifty.
   *   <li>Then return CodeToNameMap is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  @DisplayName(
      "Test new BuiltInEncoding(Map); given two hundred fifty; then return CodeToNameMap is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuiltInEncoding.<init>(Map)"})
  void testNewBuiltInEncoding_givenTwoHundredFifty_thenReturnCodeToNameMapIsHashMap() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.put(250, "foo");

    // Act and Assert
    assertEquals(codeToName, new BuiltInEncoding(codeToName).getCodeToNameMap());
  }

  /**
   * Test {@link BuiltInEncoding#BuiltInEncoding(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return CodeToNameMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  @DisplayName("Test new BuiltInEncoding(Map); when HashMap(); then return CodeToNameMap Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuiltInEncoding.<init>(Map)"})
  void testNewBuiltInEncoding_whenHashMap_thenReturnCodeToNameMapEmpty() {
    // Arrange, Act and Assert
    assertTrue(new BuiltInEncoding(new HashMap<>()).getCodeToNameMap().isEmpty());
  }
}
