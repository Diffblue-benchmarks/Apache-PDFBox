package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class BuiltInEncodingDiffblueTest {
  /**
   * Method under test: {@link BuiltInEncoding#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new BuiltInEncoding(new HashMap<>())).getCOSObject());
  }

  /**
   * Method under test: {@link BuiltInEncoding#getEncodingName()}
   */
  @Test
  void testGetEncodingName() {
    // Arrange, Act and Assert
    assertEquals("built-in (TTF)", (new BuiltInEncoding(new HashMap<>())).getEncodingName());
  }

  /**
   * Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  void testNewBuiltInEncoding() {
    // Arrange and Act
    BuiltInEncoding actualBuiltInEncoding = new BuiltInEncoding(new HashMap<>());

    // Assert
    assertEquals("built-in (TTF)", actualBuiltInEncoding.getEncodingName());
    assertTrue(actualBuiltInEncoding.getCodeToNameMap().isEmpty());
    assertTrue(actualBuiltInEncoding.getNameToCodeMap().isEmpty());
    assertTrue(actualBuiltInEncoding.codeToName.isEmpty());
    assertTrue(actualBuiltInEncoding.inverted.isEmpty());
  }

  /**
   * Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  void testNewBuiltInEncoding2() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.put(250, "foo");

    // Act
    BuiltInEncoding actualBuiltInEncoding = new BuiltInEncoding(codeToName);

    // Assert
    assertEquals("built-in (TTF)", actualBuiltInEncoding.getEncodingName());
    Map<Integer, String> codeToNameMap = actualBuiltInEncoding.getCodeToNameMap();
    assertEquals(1, codeToNameMap.size());
    assertEquals("foo", codeToNameMap.get(250));
    Map<Integer, String> integerStringMap = actualBuiltInEncoding.codeToName;
    assertEquals(1, integerStringMap.size());
    assertEquals("foo", integerStringMap.get(250));
    Map<String, Integer> nameToCodeMap = actualBuiltInEncoding.getNameToCodeMap();
    assertEquals(1, nameToCodeMap.size());
    Map<String, Integer> stringIntegerMap = actualBuiltInEncoding.inverted;
    assertEquals(1, stringIntegerMap.size());
    assertEquals(250, nameToCodeMap.get("foo").intValue());
    assertEquals(250, stringIntegerMap.get("foo").intValue());
  }

  /**
   * Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  void testNewBuiltInEncoding3() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.put(1, "42");
    codeToName.put(250, "foo");

    // Act
    BuiltInEncoding actualBuiltInEncoding = new BuiltInEncoding(codeToName);

    // Assert
    assertEquals("built-in (TTF)", actualBuiltInEncoding.getEncodingName());
    Map<String, Integer> stringIntegerMap = actualBuiltInEncoding.inverted;
    assertEquals(2, stringIntegerMap.size());
    assertEquals(1, stringIntegerMap.get("42").intValue());
    assertEquals(250, stringIntegerMap.get("foo").intValue());
    assertEquals(codeToName, actualBuiltInEncoding.getCodeToNameMap());
    assertEquals(codeToName, actualBuiltInEncoding.codeToName);
    Map<String, Integer> expectedNameToCodeMap = actualBuiltInEncoding.inverted;
    assertEquals(expectedNameToCodeMap, actualBuiltInEncoding.getNameToCodeMap());
  }

  /**
   * Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  void testNewBuiltInEncoding4() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.computeIfPresent(250, mock(BiFunction.class));
    codeToName.put(250, "foo");

    // Act
    BuiltInEncoding actualBuiltInEncoding = new BuiltInEncoding(codeToName);

    // Assert
    assertEquals("built-in (TTF)", actualBuiltInEncoding.getEncodingName());
    Map<Integer, String> codeToNameMap = actualBuiltInEncoding.getCodeToNameMap();
    assertEquals(1, codeToNameMap.size());
    assertEquals("foo", codeToNameMap.get(250));
    Map<Integer, String> integerStringMap = actualBuiltInEncoding.codeToName;
    assertEquals(1, integerStringMap.size());
    assertEquals("foo", integerStringMap.get(250));
    Map<String, Integer> nameToCodeMap = actualBuiltInEncoding.getNameToCodeMap();
    assertEquals(1, nameToCodeMap.size());
    Map<String, Integer> stringIntegerMap = actualBuiltInEncoding.inverted;
    assertEquals(1, stringIntegerMap.size());
    assertEquals(250, nameToCodeMap.get("foo").intValue());
    assertEquals(250, stringIntegerMap.get("foo").intValue());
  }
}
