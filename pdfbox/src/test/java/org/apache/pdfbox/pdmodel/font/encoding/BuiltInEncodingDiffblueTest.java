package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
   *   <li>Then return CodeToNameMap size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  @DisplayName("Test new BuiltInEncoding(Map); given one; then return CodeToNameMap size is two")
  void testNewBuiltInEncoding_givenOne_thenReturnCodeToNameMapSizeIsTwo() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.put(1, "42");
    codeToName.put(250, "foo");

    // Act
    BuiltInEncoding actualBuiltInEncoding = new BuiltInEncoding(codeToName);

    // Assert
    Map<Integer, String> codeToNameMap = actualBuiltInEncoding.getCodeToNameMap();
    assertEquals(2, codeToNameMap.size());
    assertEquals("42", codeToNameMap.get(1));
    Map<Integer, String> integerStringMap = actualBuiltInEncoding.codeToName;
    assertEquals(2, integerStringMap.size());
    assertEquals("42", integerStringMap.get(1));
    Map<String, Integer> nameToCodeMap = actualBuiltInEncoding.getNameToCodeMap();
    assertEquals(2, nameToCodeMap.size());
    assertEquals(1, nameToCodeMap.get("42").intValue());
    Map<String, Integer> stringIntegerMap = actualBuiltInEncoding.inverted;
    assertEquals(2, stringIntegerMap.size());
    assertEquals(1, stringIntegerMap.get("42").intValue());
    assertTrue(codeToNameMap.containsKey(250));
    assertTrue(nameToCodeMap.containsKey("foo"));
    assertTrue(integerStringMap.containsKey(250));
    assertTrue(stringIntegerMap.containsKey("foo"));
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

    // Act
    BuiltInEncoding actualBuiltInEncoding = new BuiltInEncoding(codeToName);

    // Assert
    Map<Integer, String> codeToNameMap = actualBuiltInEncoding.getCodeToNameMap();
    assertEquals(1, codeToNameMap.size());
    Map<String, Integer> nameToCodeMap = actualBuiltInEncoding.getNameToCodeMap();
    assertEquals(1, nameToCodeMap.size());
    Map<Integer, String> integerStringMap = actualBuiltInEncoding.codeToName;
    assertEquals(1, integerStringMap.size());
    Map<String, Integer> stringIntegerMap = actualBuiltInEncoding.inverted;
    assertEquals(1, stringIntegerMap.size());
    assertTrue(codeToNameMap.containsKey(250));
    assertTrue(nameToCodeMap.containsKey("foo"));
    assertTrue(integerStringMap.containsKey(250));
    assertTrue(stringIntegerMap.containsKey("foo"));
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
    // Arrange and Act
    BuiltInEncoding actualBuiltInEncoding = new BuiltInEncoding(new HashMap<>());

    // Assert
    assertTrue(actualBuiltInEncoding.getCodeToNameMap().isEmpty());
    assertTrue(actualBuiltInEncoding.getNameToCodeMap().isEmpty());
    assertTrue(actualBuiltInEncoding.codeToName.isEmpty());
    assertTrue(actualBuiltInEncoding.inverted.isEmpty());
  }

  /**
   * Test {@link BuiltInEncoding#getCOSObject()}.
   * <p>
   * Method under test: {@link BuiltInEncoding#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new BuiltInEncoding(new HashMap<>())).getCOSObject());
  }

  /**
   * Test {@link BuiltInEncoding#getEncodingName()}.
   * <p>
   * Method under test: {@link BuiltInEncoding#getEncodingName()}
   */
  @Test
  @DisplayName("Test getEncodingName()")
  void testGetEncodingName() {
    // Arrange, Act and Assert
    assertEquals("built-in (TTF)", (new BuiltInEncoding(new HashMap<>())).getEncodingName());
  }
}
