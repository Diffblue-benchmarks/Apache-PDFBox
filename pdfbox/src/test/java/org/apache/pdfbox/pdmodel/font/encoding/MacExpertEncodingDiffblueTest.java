package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MacExpertEncodingDiffblueTest {
  /**
   * Test new {@link MacExpertEncoding} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MacExpertEncoding}
   */
  @Test
  @DisplayName("Test new MacExpertEncoding (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MacExpertEncoding.<init>()"})
  void testNewMacExpertEncoding() {
    // Arrange and Act
    MacExpertEncoding actualMacExpertEncoding = new MacExpertEncoding();

    // Assert
    assertTrue(actualMacExpertEncoding.getCOSObject() instanceof COSName);
    assertEquals("MacExpertEncoding", actualMacExpertEncoding.getEncodingName());
    Map<Integer, String> integerStringMap = actualMacExpertEncoding.codeToName;
    assertEquals(165, integerStringMap.size());
    Map<String, Integer> stringIntegerMap = actualMacExpertEncoding.inverted;
    assertEquals(165, stringIntegerMap.size());
    assertTrue(integerStringMap.containsKey(33));
    assertTrue(integerStringMap.containsKey(34));
    assertTrue(integerStringMap.containsKey(35));
    assertTrue(integerStringMap.containsKey(36));
    assertTrue(integerStringMap.containsKey(37));
    assertTrue(integerStringMap.containsKey(Integer.SIZE));
    assertTrue(stringIntegerMap.containsKey("Aringsmall"));
    assertTrue(stringIntegerMap.containsKey("Hungarumlautsmall"));
    assertTrue(stringIntegerMap.containsKey("eightinferior"));
    assertTrue(stringIntegerMap.containsKey("oneeighth"));
    assertTrue(stringIntegerMap.containsKey("onefitted"));
    assertTrue(stringIntegerMap.containsKey("twodotenleader"));
    Map<Integer, String> expectedCodeToNameMap = actualMacExpertEncoding.codeToName;
    assertEquals(expectedCodeToNameMap, actualMacExpertEncoding.getCodeToNameMap());
    Map<String, Integer> expectedNameToCodeMap = actualMacExpertEncoding.inverted;
    assertEquals(expectedNameToCodeMap, actualMacExpertEncoding.getNameToCodeMap());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MacExpertEncoding#getCOSObject()}
   *   <li>{@link MacExpertEncoding#getEncodingName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase MacExpertEncoding.getCOSObject()", "String MacExpertEncoding.getEncodingName()"})
  void testGettersAndSetters() {
    // Arrange
    MacExpertEncoding macExpertEncoding = new MacExpertEncoding();

    // Act
    COSBase actualCOSObject = macExpertEncoding.getCOSObject();

    // Assert
    assertEquals("MacExpertEncoding", macExpertEncoding.getEncodingName());
    assertSame(((COSName) actualCOSObject).MAC_EXPERT_ENCODING, actualCOSObject);
  }
}
