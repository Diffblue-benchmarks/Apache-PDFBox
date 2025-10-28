package org.apache.fontbox.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class BuiltInEncodingDiffblueTest {
  /**
   * Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  void testNewBuiltInEncoding() {
    // Arrange, Act and Assert
    assertTrue((new BuiltInEncoding(new HashMap<>())).getCodeToNameMap().isEmpty());
  }

  /**
   * Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  void testNewBuiltInEncoding2() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.put(250, "foo");

    // Act and Assert
    Map<Integer, String> codeToNameMap = (new BuiltInEncoding(codeToName)).getCodeToNameMap();
    assertEquals(1, codeToNameMap.size());
    assertEquals("foo", codeToNameMap.get(250));
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

    // Act and Assert
    assertEquals(codeToName, (new BuiltInEncoding(codeToName)).getCodeToNameMap());
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

    // Act and Assert
    Map<Integer, String> codeToNameMap = (new BuiltInEncoding(codeToName)).getCodeToNameMap();
    assertEquals(1, codeToNameMap.size());
    assertEquals("foo", codeToNameMap.get(250));
  }
}
