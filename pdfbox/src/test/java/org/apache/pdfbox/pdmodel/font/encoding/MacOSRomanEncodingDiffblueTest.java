package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MacOSRomanEncodingDiffblueTest {
  /**
   * Test new {@link MacOSRomanEncoding} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MacOSRomanEncoding}
   */
  @Test
  @DisplayName("Test new MacOSRomanEncoding (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MacOSRomanEncoding.<init>()"})
  void testNewMacOSRomanEncoding() {
    // Arrange and Act
    MacOSRomanEncoding actualMacOSRomanEncoding = new MacOSRomanEncoding();

    // Assert
    assertEquals("MacRomanEncoding", actualMacOSRomanEncoding.getEncodingName());
    assertNull(actualMacOSRomanEncoding.getCOSObject());
    Map<Integer, String> integerStringMap = actualMacOSRomanEncoding.codeToName;
    assertEquals(223, integerStringMap.size());
    Map<String, Integer> stringIntegerMap = actualMacOSRomanEncoding.inverted;
    assertEquals(224, stringIntegerMap.size());
    assertTrue(integerStringMap.containsKey(33));
    assertTrue(integerStringMap.containsKey(34));
    assertTrue(integerStringMap.containsKey(35));
    assertTrue(integerStringMap.containsKey(36));
    assertTrue(integerStringMap.containsKey(37));
    assertTrue(integerStringMap.containsKey(Integer.SIZE));
    assertTrue(stringIntegerMap.containsKey("approxequal"));
    assertTrue(stringIntegerMap.containsKey("asterisk"));
    assertTrue(stringIntegerMap.containsKey("notequal"));
    assertTrue(stringIntegerMap.containsKey("parenright"));
    assertTrue(stringIntegerMap.containsKey("registered"));
    assertTrue(stringIntegerMap.containsKey("ring"));
    Map<Integer, String> expectedCodeToNameMap = actualMacOSRomanEncoding.codeToName;
    assertEquals(expectedCodeToNameMap, actualMacOSRomanEncoding.getCodeToNameMap());
    Map<String, Integer> expectedNameToCodeMap = actualMacOSRomanEncoding.inverted;
    assertEquals(expectedNameToCodeMap, actualMacOSRomanEncoding.getNameToCodeMap());
  }

  /**
   * Test {@link MacOSRomanEncoding#getCOSObject()}.
   *
   * <p>Method under test: {@link MacOSRomanEncoding#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSBase MacOSRomanEncoding.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange, Act and Assert
    assertNull(new MacOSRomanEncoding().getCOSObject());
  }
}
