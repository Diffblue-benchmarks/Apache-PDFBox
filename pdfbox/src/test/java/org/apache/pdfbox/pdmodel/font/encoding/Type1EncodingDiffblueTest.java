package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.afm.CharMetric;
import org.apache.fontbox.afm.FontMetrics;
import org.apache.fontbox.encoding.BuiltInEncoding;
import org.apache.fontbox.encoding.StandardEncoding;
import org.apache.pdfbox.cos.COSBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Type1EncodingDiffblueTest {
  /**
   * Test {@link Type1Encoding#fromFontBox(Encoding)}.
   *
   * <ul>
   *   <li>Then {@link BuiltInEncoding#BuiltInEncoding(Map)} with codeToName is {@link
   *       HashMap#HashMap()} CodeToNameMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link Type1Encoding#fromFontBox(org.apache.fontbox.encoding.Encoding)}
   */
  @Test
  @DisplayName(
      "Test fromFontBox(Encoding); then BuiltInEncoding(Map) with codeToName is HashMap() CodeToNameMap Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Type1Encoding Type1Encoding.fromFontBox(org.apache.fontbox.encoding.Encoding)"
  })
  void testFromFontBox_thenBuiltInEncodingWithCodeToNameIsHashMapCodeToNameMapEmpty() {
    // Arrange
    BuiltInEncoding encoding = new BuiltInEncoding(new HashMap<>());

    // Act
    Type1Encoding actualFromFontBoxResult = Type1Encoding.fromFontBox(encoding);

    // Assert
    assertTrue(encoding.getCodeToNameMap().isEmpty());
    assertTrue(actualFromFontBoxResult.getCodeToNameMap().isEmpty());
    assertTrue(actualFromFontBoxResult.getNameToCodeMap().isEmpty());
    assertTrue(actualFromFontBoxResult.codeToName.isEmpty());
    assertTrue(actualFromFontBoxResult.inverted.isEmpty());
  }

  /**
   * Test {@link Type1Encoding#fromFontBox(Encoding)}.
   *
   * <ul>
   *   <li>Then return {@link Encoding#codeToName} size is one hundred forty-nine.
   * </ul>
   *
   * <p>Method under test: {@link Type1Encoding#fromFontBox(org.apache.fontbox.encoding.Encoding)}
   */
  @Test
  @DisplayName("Test fromFontBox(Encoding); then return codeToName size is one hundred forty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Type1Encoding Type1Encoding.fromFontBox(org.apache.fontbox.encoding.Encoding)"
  })
  void testFromFontBox_thenReturnCodeToNameSizeIsOneHundredFortyNine() {
    // Arrange
    StandardEncoding encoding = new StandardEncoding();

    // Act
    Type1Encoding actualFromFontBoxResult = Type1Encoding.fromFontBox(encoding);

    // Assert
    Map<Integer, String> integerStringMap = actualFromFontBoxResult.codeToName;
    assertEquals(149, integerStringMap.size());
    Map<String, Integer> stringIntegerMap = actualFromFontBoxResult.inverted;
    assertEquals(149, stringIntegerMap.size());
    assertTrue(integerStringMap.containsKey(33));
    assertTrue(integerStringMap.containsKey(34));
    assertTrue(integerStringMap.containsKey(35));
    assertTrue(integerStringMap.containsKey(36));
    assertTrue(integerStringMap.containsKey(37));
    assertTrue(integerStringMap.containsKey(Integer.SIZE));
    assertTrue(stringIntegerMap.containsKey("asterisk"));
    assertTrue(stringIntegerMap.containsKey("braceright"));
    assertTrue(stringIntegerMap.containsKey("cedilla"));
    assertTrue(stringIntegerMap.containsKey("parenright"));
    assertTrue(stringIntegerMap.containsKey("ring"));
    assertTrue(stringIntegerMap.containsKey("three"));
    Map<Integer, String> integerStringMap2 = actualFromFontBoxResult.codeToName;
    assertEquals(integerStringMap2, encoding.getCodeToNameMap());
    assertEquals(integerStringMap2, actualFromFontBoxResult.getCodeToNameMap());
    Map<String, Integer> expectedNameToCodeMap = actualFromFontBoxResult.inverted;
    assertEquals(expectedNameToCodeMap, actualFromFontBoxResult.getNameToCodeMap());
  }

  /**
   * Test {@link Type1Encoding#Type1Encoding()}.
   *
   * <p>Method under test: {@link Type1Encoding#Type1Encoding()}
   */
  @Test
  @DisplayName("Test new Type1Encoding()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Encoding.<init>()"})
  void testNewType1Encoding() {
    // Arrange and Act
    Type1Encoding actualType1Encoding = new Type1Encoding();

    // Assert
    assertEquals("built-in (Type 1)", actualType1Encoding.getEncodingName());
    assertNull(actualType1Encoding.getCOSObject());
    assertTrue(actualType1Encoding.getCodeToNameMap().isEmpty());
    assertTrue(actualType1Encoding.getNameToCodeMap().isEmpty());
    assertTrue(actualType1Encoding.codeToName.isEmpty());
    assertTrue(actualType1Encoding.inverted.isEmpty());
  }

  /**
   * Test {@link Type1Encoding#Type1Encoding(FontMetrics)}.
   *
   * <ul>
   *   <li>Given {@link CharMetric} (default constructor).
   *   <li>Then return CodeToNameMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link Type1Encoding#Type1Encoding(FontMetrics)}
   */
  @Test
  @DisplayName(
      "Test new Type1Encoding(FontMetrics); given CharMetric (default constructor); then return CodeToNameMap size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Encoding.<init>(FontMetrics)"})
  void testNewType1Encoding_givenCharMetric_thenReturnCodeToNameMapSizeIsOne() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(new CharMetric());

    // Act
    Type1Encoding actualType1Encoding = new Type1Encoding(fontMetrics);

    // Assert
    Map<Integer, String> codeToNameMap = actualType1Encoding.getCodeToNameMap();
    assertEquals(1, codeToNameMap.size());
    assertNull(codeToNameMap.get(0));
    Map<Integer, String> integerStringMap = actualType1Encoding.codeToName;
    assertEquals(1, integerStringMap.size());
    assertNull(integerStringMap.get(0));
    Map<String, Integer> nameToCodeMap = actualType1Encoding.getNameToCodeMap();
    assertEquals(1, nameToCodeMap.size());
    assertEquals(0, nameToCodeMap.get(null).intValue());
    Map<String, Integer> stringIntegerMap = actualType1Encoding.inverted;
    assertEquals(1, stringIntegerMap.size());
    assertEquals(0, stringIntegerMap.get(null).intValue());
  }

  /**
   * Test {@link Type1Encoding#Type1Encoding(FontMetrics)}.
   *
   * <ul>
   *   <li>When {@link FontMetrics} (default constructor).
   *   <li>Then return CodeToNameMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link Type1Encoding#Type1Encoding(FontMetrics)}
   */
  @Test
  @DisplayName(
      "Test new Type1Encoding(FontMetrics); when FontMetrics (default constructor); then return CodeToNameMap Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Encoding.<init>(FontMetrics)"})
  void testNewType1Encoding_whenFontMetrics_thenReturnCodeToNameMapEmpty() {
    // Arrange and Act
    Type1Encoding actualType1Encoding = new Type1Encoding(new FontMetrics());

    // Assert
    assertTrue(actualType1Encoding.getCodeToNameMap().isEmpty());
    assertTrue(actualType1Encoding.getNameToCodeMap().isEmpty());
    assertTrue(actualType1Encoding.codeToName.isEmpty());
    assertTrue(actualType1Encoding.inverted.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Type1Encoding#getCOSObject()}
   *   <li>{@link Type1Encoding#getEncodingName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "COSBase Type1Encoding.getCOSObject()",
    "String Type1Encoding.getEncodingName()"
  })
  void testGettersAndSetters() {
    // Arrange
    Type1Encoding type1Encoding = new Type1Encoding();

    // Act
    COSBase actualCOSObject = type1Encoding.getCOSObject();

    // Assert
    assertEquals("built-in (Type 1)", type1Encoding.getEncodingName());
    assertNull(actualCOSObject);
  }
}
