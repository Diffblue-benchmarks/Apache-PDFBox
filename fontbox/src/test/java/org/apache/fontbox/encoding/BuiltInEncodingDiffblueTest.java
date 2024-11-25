package org.apache.fontbox.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuiltInEncodingDiffblueTest {
  /**
   * Test {@link BuiltInEncoding#BuiltInEncoding(Map)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return CodeToNameMap is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  @DisplayName("Test new BuiltInEncoding(Map); given one; then return CodeToNameMap is HashMap()")
  void testNewBuiltInEncoding_givenOne_thenReturnCodeToNameMapIsHashMap() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.put(1, "42");
    codeToName.put(250, "foo");

    // Act and Assert
    assertEquals(codeToName, (new BuiltInEncoding(codeToName)).getCodeToNameMap());
  }

  /**
   * Test {@link BuiltInEncoding#BuiltInEncoding(Map)}.
   * <ul>
   *   <li>Given two hundred fifty.</li>
   *   <li>Then return CodeToNameMap size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  @DisplayName("Test new BuiltInEncoding(Map); given two hundred fifty; then return CodeToNameMap size is one")
  void testNewBuiltInEncoding_givenTwoHundredFifty_thenReturnCodeToNameMapSizeIsOne() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.put(250, "foo");

    // Act and Assert
    Map<Integer, String> codeToNameMap = (new BuiltInEncoding(codeToName)).getCodeToNameMap();
    assertEquals(1, codeToNameMap.size());
    assertEquals("foo", codeToNameMap.get(250));
  }

  /**
   * Test {@link BuiltInEncoding#BuiltInEncoding(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return CodeToNameMap Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  @DisplayName("Test new BuiltInEncoding(Map); when HashMap(); then return CodeToNameMap Empty")
  void testNewBuiltInEncoding_whenHashMap_thenReturnCodeToNameMapEmpty() {
    // Arrange, Act and Assert
    assertTrue((new BuiltInEncoding(new HashMap<>())).getCodeToNameMap().isEmpty());
  }
}
