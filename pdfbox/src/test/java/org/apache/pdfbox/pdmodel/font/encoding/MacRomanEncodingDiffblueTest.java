package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MacRomanEncodingDiffblueTest {
  /**
   * Test {@link MacRomanEncoding#MacRomanEncoding()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link MacRomanEncoding}
   */
  @Test
  @DisplayName("Test new MacRomanEncoding()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MacRomanEncoding.<init>()"})
  void testNewMacRomanEncoding() {
    // Arrange and Act
    MacRomanEncoding actualMacRomanEncoding = new MacRomanEncoding();

    // Assert
    assertTrue(actualMacRomanEncoding.getCOSObject() instanceof COSName);
    assertEquals("MacRomanEncoding", actualMacRomanEncoding.getEncodingName());
    Map<Integer, String> integerStringMap = actualMacRomanEncoding.codeToName;
    assertEquals(208, integerStringMap.size());
    Map<String, Integer> stringIntegerMap = actualMacRomanEncoding.inverted;
    assertEquals(208, stringIntegerMap.size());
    assertTrue(integerStringMap.containsKey(33));
    assertTrue(integerStringMap.containsKey(34));
    assertTrue(integerStringMap.containsKey(35));
    assertTrue(integerStringMap.containsKey(36));
    assertTrue(integerStringMap.containsKey(37));
    assertTrue(integerStringMap.containsKey(Integer.SIZE));
    assertTrue(stringIntegerMap.containsKey("asterisk"));
    assertTrue(stringIntegerMap.containsKey("bar"));
    assertTrue(stringIntegerMap.containsKey("cedilla"));
    assertTrue(stringIntegerMap.containsKey("parenright"));
    assertTrue(stringIntegerMap.containsKey("registered"));
    assertTrue(stringIntegerMap.containsKey("ring"));
    Map<Integer, String> expectedCodeToNameMap = actualMacRomanEncoding.codeToName;
    assertEquals(expectedCodeToNameMap, actualMacRomanEncoding.getCodeToNameMap());
    Map<String, Integer> expectedNameToCodeMap = actualMacRomanEncoding.inverted;
    assertEquals(expectedNameToCodeMap, actualMacRomanEncoding.getNameToCodeMap());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MacRomanEncoding#getCOSObject()}
   *   <li>{@link MacRomanEncoding#getEncodingName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "COSBase MacRomanEncoding.getCOSObject()",
    "String MacRomanEncoding.getEncodingName()"
  })
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
