package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DictionaryEncodingDiffblueTest {
  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSName, COSArray); when A")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding_whenA() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new DictionaryEncoding(COSName.A, new COSArray()));

  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return EncodingName is {@code differences}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSDictionary)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSDictionary); when COSDictionary(); then return EncodingName is 'differences'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSDictionary)"})
  void testNewDictionaryEncoding_whenCOSDictionary_thenReturnEncodingNameIsDifferences() {
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
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then BaseEncoding return {@link MacExpertEncoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSDictionary, boolean, Encoding); when 'false'; then BaseEncoding return MacExpertEncoding")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSDictionary, boolean, Encoding)"})
  void testNewDictionaryEncoding_whenFalse_thenBaseEncodingReturnMacExpertEncoding() {
    // Arrange
    MacExpertEncoding builtIn = MacExpertEncoding.INSTANCE;

    // Act
    DictionaryEncoding actualDictionaryEncoding = new DictionaryEncoding(new COSDictionary(), false, builtIn);

    // Assert
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof MacExpertEncoding);
    assertEquals("MacExpertEncoding with differences", actualDictionaryEncoding.getEncodingName());
    Map<Integer, String> integerStringMap = builtIn.codeToName;
    assertEquals(integerStringMap, actualDictionaryEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, actualDictionaryEncoding.codeToName);
    Map<String, Integer> stringIntegerMap = builtIn.inverted;
    assertEquals(stringIntegerMap, actualDictionaryEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, actualDictionaryEncoding.inverted);
    assertSame(builtIn.INSTANCE, baseEncoding);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSDictionary, boolean, Encoding); when 'false'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSDictionary, boolean, Encoding)"})
  void testNewDictionaryEncoding_whenFalse_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new DictionaryEncoding(new COSDictionary(), false, null));

  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSName, COSArray); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new DictionaryEncoding(null, new COSArray()));

  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then BaseEncoding return {@link StandardEncoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSDictionary, boolean, Encoding); when 'true'; then BaseEncoding return StandardEncoding")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSDictionary, boolean, Encoding)"})
  void testNewDictionaryEncoding_whenTrue_thenBaseEncodingReturnStandardEncoding() {
    // Arrange and Act
    DictionaryEncoding actualDictionaryEncoding = new DictionaryEncoding(new COSDictionary(), true,
        MacExpertEncoding.INSTANCE);

    // Assert
    assertTrue(actualDictionaryEncoding.getBaseEncoding() instanceof StandardEncoding);
    assertEquals("StandardEncoding with differences", actualDictionaryEncoding.getEncodingName());
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(149, integerStringMap.size());
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
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
    Map<Integer, String> expectedCodeToNameMap = actualDictionaryEncoding.codeToName;
    assertEquals(expectedCodeToNameMap, actualDictionaryEncoding.getCodeToNameMap());
    Map<String, Integer> expectedNameToCodeMap = actualDictionaryEncoding.inverted;
    assertEquals(expectedNameToCodeMap, actualDictionaryEncoding.getNameToCodeMap());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DictionaryEncoding#getBaseEncoding()}
   *   <li>{@link DictionaryEncoding#getCOSObject()}
   *   <li>{@link DictionaryEncoding#getDifferences()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Encoding DictionaryEncoding.getBaseEncoding()", "COSBase DictionaryEncoding.getCOSObject()",
      "Map DictionaryEncoding.getDifferences()"})
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
   * Test {@link DictionaryEncoding#getEncodingName()}.
   * <ul>
   *   <li>Then return {@code differences}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DictionaryEncoding#getEncodingName()}
   */
  @Test
  @DisplayName("Test getEncodingName(); then return 'differences'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DictionaryEncoding.getEncodingName()"})
  void testGetEncodingName_thenReturnDifferences() {
    // Arrange, Act and Assert
    assertEquals("differences", (new DictionaryEncoding(new COSDictionary())).getEncodingName());
  }

  /**
   * Test {@link DictionaryEncoding#getEncodingName()}.
   * <ul>
   *   <li>Then return {@code StandardEncoding with differences}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DictionaryEncoding#getEncodingName()}
   */
  @Test
  @DisplayName("Test getEncodingName(); then return 'StandardEncoding with differences'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DictionaryEncoding.getEncodingName()"})
  void testGetEncodingName_thenReturnStandardEncodingWithDifferences() {
    // Arrange, Act and Assert
    assertEquals("StandardEncoding with differences",
        (new DictionaryEncoding(new COSDictionary(), true, MacExpertEncoding.INSTANCE)).getEncodingName());
  }
}
