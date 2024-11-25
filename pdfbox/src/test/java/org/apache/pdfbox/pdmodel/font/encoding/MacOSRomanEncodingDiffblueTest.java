package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MacOSRomanEncodingDiffblueTest {
  /**
   * Test new {@link MacOSRomanEncoding} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link MacOSRomanEncoding}
   */
  @Test
  @DisplayName("Test new MacOSRomanEncoding (default constructor)")
  void testNewMacOSRomanEncoding() {
    // Arrange and Act
    MacOSRomanEncoding actualMacOSRomanEncoding = new MacOSRomanEncoding();

    // Assert
    assertEquals("MacRomanEncoding", actualMacOSRomanEncoding.getEncodingName());
    Map<Integer, String> integerStringMap = actualMacOSRomanEncoding.codeToName;
    assertEquals(223, integerStringMap.size());
    assertEquals("dollar", integerStringMap.get(36));
    assertEquals("exclam", integerStringMap.get(33));
    assertEquals("numbersign", integerStringMap.get(35));
    assertEquals("percent", integerStringMap.get(37));
    assertEquals("quotedbl", integerStringMap.get(34));
    assertEquals("space", integerStringMap.get(Integer.SIZE));
    assertNull(actualMacOSRomanEncoding.getCOSObject());
    Map<String, Integer> stringIntegerMap = actualMacOSRomanEncoding.inverted;
    assertEquals(224, stringIntegerMap.size());
    assertEquals(168, stringIntegerMap.get("registered").intValue());
    assertEquals(173, stringIntegerMap.get("notequal").intValue());
    assertEquals(197, stringIntegerMap.get("approxequal").intValue());
    assertEquals(251, stringIntegerMap.get("ring").intValue());
    assertEquals(41, stringIntegerMap.get("parenright").intValue());
    assertEquals(42, stringIntegerMap.get("asterisk").intValue());
    Map<Integer, String> expectedCodeToNameMap = actualMacOSRomanEncoding.codeToName;
    assertEquals(expectedCodeToNameMap, actualMacOSRomanEncoding.getCodeToNameMap());
    Map<String, Integer> expectedNameToCodeMap = actualMacOSRomanEncoding.inverted;
    assertEquals(expectedNameToCodeMap, actualMacOSRomanEncoding.getNameToCodeMap());
  }

  /**
   * Test {@link MacOSRomanEncoding#getCOSObject()}.
   * <p>
   * Method under test: {@link MacOSRomanEncoding#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange, Act and Assert
    assertNull((new MacOSRomanEncoding()).getCOSObject());
  }
}
