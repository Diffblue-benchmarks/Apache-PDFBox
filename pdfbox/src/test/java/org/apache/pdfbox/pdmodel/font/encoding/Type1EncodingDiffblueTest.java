package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.fontbox.afm.CharMetric;
import org.apache.fontbox.afm.FontMetrics;
import org.apache.fontbox.encoding.BuiltInEncoding;
import org.apache.fontbox.encoding.Encoding;
import org.apache.fontbox.encoding.StandardEncoding;
import org.apache.pdfbox.cos.COSBase;
import org.junit.jupiter.api.Test;

class Type1EncodingDiffblueTest {
  /**
   * Method under test: {@link Type1Encoding#fromFontBox(Encoding)}
   */
  @Test
  void testFromFontBox() {
    // Arrange
    StandardEncoding encoding = new StandardEncoding();

    // Act
    Type1Encoding actualFromFontBoxResult = Type1Encoding.fromFontBox(encoding);

    // Assert
    assertEquals("built-in (Type 1)", actualFromFontBoxResult.getEncodingName());
    Map<Integer, String> integerStringMap = actualFromFontBoxResult.codeToName;
    assertEquals(149, integerStringMap.size());
    assertEquals("dollar", integerStringMap.get(36));
    assertEquals("exclam", integerStringMap.get(33));
    assertEquals("numbersign", integerStringMap.get(35));
    assertEquals("percent", integerStringMap.get(37));
    assertEquals("quotedbl", integerStringMap.get(34));
    assertEquals("space", integerStringMap.get(Integer.SIZE));
    assertNull(actualFromFontBoxResult.getCOSObject());
    Map<String, Integer> stringIntegerMap = actualFromFontBoxResult.inverted;
    assertEquals(149, stringIntegerMap.size());
    assertEquals(125, stringIntegerMap.get("braceright").intValue());
    assertEquals(202, stringIntegerMap.get("ring").intValue());
    assertEquals(203, stringIntegerMap.get("cedilla").intValue());
    assertEquals(41, stringIntegerMap.get("parenright").intValue());
    assertEquals(42, stringIntegerMap.get("asterisk").intValue());
    assertEquals(51, stringIntegerMap.get("three").intValue());
    Map<Integer, String> integerStringMap2 = actualFromFontBoxResult.codeToName;
    assertEquals(integerStringMap2, encoding.getCodeToNameMap());
    assertEquals(integerStringMap2, actualFromFontBoxResult.getCodeToNameMap());
    Map<String, Integer> expectedNameToCodeMap = actualFromFontBoxResult.inverted;
    assertEquals(expectedNameToCodeMap, actualFromFontBoxResult.getNameToCodeMap());
  }

  /**
   * Method under test: {@link Type1Encoding#fromFontBox(Encoding)}
   */
  @Test
  void testFromFontBox2() {
    // Arrange and Act
    Type1Encoding actualFromFontBoxResult = Type1Encoding.fromFontBox(new BuiltInEncoding(new HashMap<>()));

    // Assert
    assertEquals("built-in (Type 1)", actualFromFontBoxResult.getEncodingName());
    assertNull(actualFromFontBoxResult.getCOSObject());
    assertTrue(actualFromFontBoxResult.getCodeToNameMap().isEmpty());
    assertTrue(actualFromFontBoxResult.getNameToCodeMap().isEmpty());
    assertTrue(actualFromFontBoxResult.codeToName.isEmpty());
    assertTrue(actualFromFontBoxResult.inverted.isEmpty());
  }

  /**
   * Method under test: {@link Type1Encoding#fromFontBox(Encoding)}
   */
  @Test
  void testFromFontBox3() {
    // Arrange
    HashMap<Integer, String> codeToName = new HashMap<>();
    codeToName.computeIfPresent(250, mock(BiFunction.class));

    // Act
    Type1Encoding actualFromFontBoxResult = Type1Encoding.fromFontBox(new BuiltInEncoding(codeToName));

    // Assert
    assertEquals("built-in (Type 1)", actualFromFontBoxResult.getEncodingName());
    assertNull(actualFromFontBoxResult.getCOSObject());
    assertTrue(actualFromFontBoxResult.getCodeToNameMap().isEmpty());
    assertTrue(actualFromFontBoxResult.getNameToCodeMap().isEmpty());
    assertTrue(actualFromFontBoxResult.codeToName.isEmpty());
    assertTrue(actualFromFontBoxResult.inverted.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Type1Encoding#getCOSObject()}
   *   <li>{@link Type1Encoding#getEncodingName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Type1Encoding type1Encoding = new Type1Encoding();

    // Act
    COSBase actualCOSObject = type1Encoding.getCOSObject();

    // Assert
    assertEquals("built-in (Type 1)", type1Encoding.getEncodingName());
    assertNull(actualCOSObject);
  }

  /**
   * Method under test: {@link Type1Encoding#Type1Encoding()}
   */
  @Test
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
   * Method under test: {@link Type1Encoding#Type1Encoding(FontMetrics)}
   */
  @Test
  void testNewType1Encoding2() {
    // Arrange and Act
    Type1Encoding actualType1Encoding = new Type1Encoding(new FontMetrics());

    // Assert
    assertEquals("built-in (Type 1)", actualType1Encoding.getEncodingName());
    assertNull(actualType1Encoding.getCOSObject());
    assertTrue(actualType1Encoding.getCodeToNameMap().isEmpty());
    assertTrue(actualType1Encoding.getNameToCodeMap().isEmpty());
    assertTrue(actualType1Encoding.codeToName.isEmpty());
    assertTrue(actualType1Encoding.inverted.isEmpty());
  }

  /**
   * Method under test: {@link Type1Encoding#Type1Encoding(FontMetrics)}
   */
  @Test
  void testNewType1Encoding3() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(new CharMetric());

    // Act
    Type1Encoding actualType1Encoding = new Type1Encoding(fontMetrics);

    // Assert
    assertEquals("built-in (Type 1)", actualType1Encoding.getEncodingName());
    Map<Integer, String> codeToNameMap = actualType1Encoding.getCodeToNameMap();
    assertEquals(1, codeToNameMap.size());
    assertNull(codeToNameMap.get(0));
    Map<Integer, String> integerStringMap = actualType1Encoding.codeToName;
    assertEquals(1, integerStringMap.size());
    assertNull(integerStringMap.get(0));
    assertNull(actualType1Encoding.getCOSObject());
    Map<String, Integer> nameToCodeMap = actualType1Encoding.getNameToCodeMap();
    assertEquals(1, nameToCodeMap.size());
    assertEquals(0, nameToCodeMap.get(null).intValue());
    Map<String, Integer> stringIntegerMap = actualType1Encoding.inverted;
    assertEquals(1, stringIntegerMap.size());
    assertEquals(0, stringIntegerMap.get(null).intValue());
  }
}
