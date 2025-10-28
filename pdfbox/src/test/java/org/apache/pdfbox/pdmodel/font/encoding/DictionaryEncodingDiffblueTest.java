package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class DictionaryEncodingDiffblueTest {
  /**
   * Method under test: {@link DictionaryEncoding#getEncodingName()}
   */
  @Test
  void testGetEncodingName() {
    // Arrange, Act and Assert
    assertEquals("differences", (new DictionaryEncoding(new COSDictionary())).getEncodingName());
    assertEquals("StandardEncoding with differences",
        (new DictionaryEncoding(new COSDictionary(), true, MacExpertEncoding.INSTANCE)).getEncodingName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DictionaryEncoding#getBaseEncoding()}
   *   <li>{@link DictionaryEncoding#getCOSObject()}
   *   <li>{@link DictionaryEncoding#getDifferences()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary fontEncoding = new COSDictionary();
    DictionaryEncoding dictionaryEncoding = new DictionaryEncoding(fontEncoding);

    // Act
    Encoding actualBaseEncoding = dictionaryEncoding.getBaseEncoding();
    COSBase actualCOSObject = dictionaryEncoding.getCOSObject();

    // Assert
    assertNull(actualBaseEncoding);
    assertTrue(dictionaryEncoding.getDifferences().isEmpty());
    assertSame(fontEncoding, actualCOSObject);
  }

  /**
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary)}
   */
  @Test
  void testNewDictionaryEncoding() {
    // Arrange
    COSDictionary fontEncoding = new COSDictionary();

    // Act
    DictionaryEncoding actualDictionaryEncoding = new DictionaryEncoding(fontEncoding);

    // Assert
    assertEquals("differences", actualDictionaryEncoding.getEncodingName());
    assertNull(actualDictionaryEncoding.getBaseEncoding());
    assertTrue(actualDictionaryEncoding.getDifferences().isEmpty());
    assertTrue(actualDictionaryEncoding.getCodeToNameMap().isEmpty());
    assertTrue(actualDictionaryEncoding.getNameToCodeMap().isEmpty());
    assertTrue(actualDictionaryEncoding.codeToName.isEmpty());
    assertTrue(actualDictionaryEncoding.inverted.isEmpty());
    assertSame(fontEncoding, actualDictionaryEncoding.getCOSObject());
  }

  /**
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}
   */
  @Test
  void testNewDictionaryEncoding2() {
    // Arrange
    COSDictionary fontEncoding = new COSDictionary();

    // Act
    DictionaryEncoding actualDictionaryEncoding = new DictionaryEncoding(fontEncoding, true,
        MacExpertEncoding.INSTANCE);

    // Assert
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    COSBase cOSObject = baseEncoding.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(baseEncoding instanceof StandardEncoding);
    assertEquals("StandardEncoding with differences", actualDictionaryEncoding.getEncodingName());
    assertEquals("StandardEncoding", ((COSName) cOSObject).getName());
    assertEquals("StandardEncoding", baseEncoding.getEncodingName());
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(149, integerStringMap.size());
    assertEquals("dollar", integerStringMap.get(36));
    assertEquals("exclam", integerStringMap.get(33));
    assertEquals("numbersign", integerStringMap.get(35));
    assertEquals("percent", integerStringMap.get(37));
    assertEquals("quotedbl", integerStringMap.get(34));
    assertEquals("space", integerStringMap.get(Integer.SIZE));
    assertNull(cOSObject.getKey());
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(149, stringIntegerMap.size());
    assertEquals(125, stringIntegerMap.get("braceright").intValue());
    assertEquals(202, stringIntegerMap.get("ring").intValue());
    assertEquals(203, stringIntegerMap.get("cedilla").intValue());
    assertEquals(41, stringIntegerMap.get("parenright").intValue());
    assertEquals(42, stringIntegerMap.get("asterisk").intValue());
    assertEquals(51, stringIntegerMap.get("three").intValue());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertTrue(actualDictionaryEncoding.getDifferences().isEmpty());
    Map<Integer, String> integerStringMap2 = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap2, actualDictionaryEncoding.getCodeToNameMap());
    assertEquals(integerStringMap2, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap2, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap2 = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap2, actualDictionaryEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap2, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap2, ((StandardEncoding) baseEncoding).inverted);
    assertSame(fontEncoding, actualDictionaryEncoding.getCOSObject());
  }

  /**
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}
   */
  @Test
  void testNewDictionaryEncoding3() {
    // Arrange
    COSDictionary fontEncoding = new COSDictionary();
    MacExpertEncoding builtIn = MacExpertEncoding.INSTANCE;

    // Act
    DictionaryEncoding actualDictionaryEncoding = new DictionaryEncoding(fontEncoding, false, builtIn);

    // Assert
    assertEquals("MacExpertEncoding with differences", actualDictionaryEncoding.getEncodingName());
    assertTrue(actualDictionaryEncoding.getDifferences().isEmpty());
    Map<Integer, String> integerStringMap = builtIn.codeToName;
    assertEquals(integerStringMap, actualDictionaryEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, actualDictionaryEncoding.codeToName);
    Map<String, Integer> stringIntegerMap = builtIn.inverted;
    assertEquals(stringIntegerMap, actualDictionaryEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, actualDictionaryEncoding.inverted);
    assertSame(fontEncoding, actualDictionaryEncoding.getCOSObject());
    MacExpertEncoding expectedBaseEncoding = builtIn.INSTANCE;
    assertSame(expectedBaseEncoding, actualDictionaryEncoding.getBaseEncoding());
  }

  /**
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}
   */
  @Test
  void testNewDictionaryEncoding4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new DictionaryEncoding(new COSDictionary(), false, null));

  }

  /**
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  void testNewDictionaryEncoding5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new DictionaryEncoding(COSName.A, new COSArray()));

  }

  /**
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  void testNewDictionaryEncoding6() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new DictionaryEncoding(null, new COSArray()));

  }
}
