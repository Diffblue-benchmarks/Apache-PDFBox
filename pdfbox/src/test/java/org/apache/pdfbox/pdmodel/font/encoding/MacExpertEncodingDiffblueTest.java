package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class MacExpertEncodingDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MacExpertEncoding#getCOSObject()}
   *   <li>{@link MacExpertEncoding#getEncodingName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MacExpertEncoding macExpertEncoding = new MacExpertEncoding();

    // Act
    COSBase actualCOSObject = macExpertEncoding.getCOSObject();

    // Assert
    assertEquals("MacExpertEncoding", macExpertEncoding.getEncodingName());
    assertSame(((COSName) actualCOSObject).MAC_EXPERT_ENCODING, actualCOSObject);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link MacExpertEncoding}
   */
  @Test
  void testNewMacExpertEncoding() {
    // Arrange and Act
    MacExpertEncoding actualMacExpertEncoding = new MacExpertEncoding();

    // Assert
    COSBase cOSObject = actualMacExpertEncoding.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    Map<Integer, String> integerStringMap = actualMacExpertEncoding.codeToName;
    assertEquals(165, integerStringMap.size());
    assertEquals("Hungarumlautsmall", integerStringMap.get(34));
    assertEquals("MacExpertEncoding", ((COSName) cOSObject).getName());
    assertEquals("MacExpertEncoding", actualMacExpertEncoding.getEncodingName());
    assertEquals("centoldstyle", integerStringMap.get(35));
    assertEquals("dollaroldstyle", integerStringMap.get(36));
    assertEquals("dollarsuperior", integerStringMap.get(37));
    assertEquals("exclamsmall", integerStringMap.get(33));
    assertEquals("space", integerStringMap.get(Integer.SIZE));
    assertNull(cOSObject.getKey());
    Map<String, Integer> stringIntegerMap = actualMacExpertEncoding.inverted;
    assertEquals(165, stringIntegerMap.size());
    assertEquals(124, stringIntegerMap.get("onefitted").intValue());
    assertEquals(140, stringIntegerMap.get("Aringsmall").intValue());
    assertEquals(165, stringIntegerMap.get("eightinferior").intValue());
    assertEquals(34, stringIntegerMap.get("Hungarumlautsmall").intValue());
    assertEquals(42, stringIntegerMap.get("twodotenleader").intValue());
    assertEquals(74, stringIntegerMap.get("oneeighth").intValue());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    Map<Integer, String> expectedCodeToNameMap = actualMacExpertEncoding.codeToName;
    assertEquals(expectedCodeToNameMap, actualMacExpertEncoding.getCodeToNameMap());
    Map<String, Integer> expectedNameToCodeMap = actualMacExpertEncoding.inverted;
    assertEquals(expectedNameToCodeMap, actualMacExpertEncoding.getNameToCodeMap());
  }
}
