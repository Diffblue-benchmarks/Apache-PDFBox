package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
   *   <li>Then return NameToCodeMap size is two.
   * </ul>
   *
   * <p>Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  @DisplayName("Test new BuiltInEncoding(Map); given one; then return NameToCodeMap size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuiltInEncoding.<init>(Map)"})
  void testNewBuiltInEncoding_givenOne_thenReturnNameToCodeMapSizeIsTwo() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.put(1, "Value");
    codeToName.put(250, "42");

    // Act
    BuiltInEncoding actualBuiltInEncoding = new BuiltInEncoding(codeToName);

    // Assert
    Map<String, Integer> nameToCodeMap = actualBuiltInEncoding.getNameToCodeMap();
    assertEquals(2, nameToCodeMap.size());
    assertEquals(1, nameToCodeMap.get("Value").intValue());
    Map<String, Integer> stringIntegerMap = actualBuiltInEncoding.inverted;
    assertEquals(2, stringIntegerMap.size());
    assertEquals(1, stringIntegerMap.get("Value").intValue());
    assertTrue(nameToCodeMap.containsKey("42"));
    assertTrue(stringIntegerMap.containsKey("42"));
  }

  /**
   * Test {@link BuiltInEncoding#BuiltInEncoding(Map)}.
   *
   * <ul>
   *   <li>Given two hundred fifty.
   *   <li>Then return NameToCodeMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link BuiltInEncoding#BuiltInEncoding(Map)}
   */
  @Test
  @DisplayName(
      "Test new BuiltInEncoding(Map); given two hundred fifty; then return NameToCodeMap size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuiltInEncoding.<init>(Map)"})
  void testNewBuiltInEncoding_givenTwoHundredFifty_thenReturnNameToCodeMapSizeIsOne() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.put(250, "42");

    // Act
    BuiltInEncoding actualBuiltInEncoding = new BuiltInEncoding(codeToName);

    // Assert
    Map<String, Integer> nameToCodeMap = actualBuiltInEncoding.getNameToCodeMap();
    assertEquals(1, nameToCodeMap.size());
    Map<String, Integer> stringIntegerMap = actualBuiltInEncoding.inverted;
    assertEquals(1, stringIntegerMap.size());
    assertEquals(250, nameToCodeMap.get("42").intValue());
    assertEquals(250, stringIntegerMap.get("42").intValue());
    assertEquals(codeToName, actualBuiltInEncoding.getCodeToNameMap());
    assertEquals(codeToName, actualBuiltInEncoding.codeToName);
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
   *
   * <p>Method under test: {@link BuiltInEncoding#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSBase BuiltInEncoding.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new BuiltInEncoding(new HashMap<>()).getCOSObject());
  }

  /**
   * Test {@link BuiltInEncoding#getEncodingName()}.
   *
   * <p>Method under test: {@link BuiltInEncoding#getEncodingName()}
   */
  @Test
  @DisplayName("Test getEncodingName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BuiltInEncoding.getEncodingName()"})
  void testGetEncodingName() {
    // Arrange, Act and Assert
    assertEquals("built-in (TTF)", new BuiltInEncoding(new HashMap<>()).getEncodingName());
  }
}
