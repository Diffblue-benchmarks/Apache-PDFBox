package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MacRomanEncodingDiffblueTest {
  /**
   * Test {@link MacRomanEncoding#MacRomanEncoding()}.
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link MacRomanEncoding}
   */
  @Test
  @DisplayName("Test new MacRomanEncoding()")
  void testNewMacRomanEncoding() {
    // Arrange and Act
    MacRomanEncoding actualMacRomanEncoding = new MacRomanEncoding();

    // Assert
    COSBase cOSObject = actualMacRomanEncoding.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertEquals("MacRomanEncoding", ((COSName) cOSObject).getName());
    assertEquals("MacRomanEncoding", actualMacRomanEncoding.getEncodingName());
    Map<Integer, String> integerStringMap = actualMacRomanEncoding.codeToName;
    assertEquals(208, integerStringMap.size());
    assertEquals("dollar", integerStringMap.get(36));
    assertEquals("exclam", integerStringMap.get(33));
    assertEquals("numbersign", integerStringMap.get(35));
    assertEquals("percent", integerStringMap.get(37));
    assertEquals("quotedbl", integerStringMap.get(34));
    assertEquals("space", integerStringMap.get(Integer.SIZE));
    assertNull(cOSObject.getKey());
    Map<String, Integer> stringIntegerMap = actualMacRomanEncoding.inverted;
    assertEquals(208, stringIntegerMap.size());
    assertEquals(124, stringIntegerMap.get("bar").intValue());
    assertEquals(168, stringIntegerMap.get("registered").intValue());
    assertEquals(251, stringIntegerMap.get("ring").intValue());
    assertEquals(252, stringIntegerMap.get("cedilla").intValue());
    assertEquals(41, stringIntegerMap.get("parenright").intValue());
    assertEquals(42, stringIntegerMap.get("asterisk").intValue());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    Map<Integer, String> expectedCodeToNameMap = actualMacRomanEncoding.codeToName;
    assertEquals(expectedCodeToNameMap, actualMacRomanEncoding.getCodeToNameMap());
    Map<String, Integer> expectedNameToCodeMap = actualMacRomanEncoding.inverted;
    assertEquals(expectedNameToCodeMap, actualMacRomanEncoding.getNameToCodeMap());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MacRomanEncoding#getCOSObject()}
   *   <li>{@link MacRomanEncoding#getEncodingName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    MacRomanEncoding macRomanEncoding = new MacRomanEncoding();

    // Act
    COSBase actualCOSObject = macRomanEncoding.getCOSObject();

    // Assert
    assertEquals("MacRomanEncoding", macRomanEncoding.getEncodingName());
    assertSame(((COSName) actualCOSObject).MAC_ROMAN_ENCODING, actualCOSObject);
  }
}
