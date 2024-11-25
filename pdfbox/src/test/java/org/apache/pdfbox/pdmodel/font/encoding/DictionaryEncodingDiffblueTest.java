package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DictionaryEncodingDiffblueTest {
  /**
   * Test
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}.
   * <p>
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSDictionary, boolean, Encoding)")
  void testNewDictionaryEncoding() {
    // Arrange
    MacExpertEncoding builtIn = MacExpertEncoding.INSTANCE;

    // Act
    DictionaryEncoding actualDictionaryEncoding = new DictionaryEncoding(new COSDictionary(), false, builtIn);

    // Assert
    assertEquals("MacExpertEncoding with differences", actualDictionaryEncoding.getEncodingName());
    Map<Integer, String> integerStringMap = builtIn.codeToName;
    assertEquals(integerStringMap, actualDictionaryEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, actualDictionaryEncoding.codeToName);
    Map<String, Integer> stringIntegerMap = builtIn.inverted;
    assertEquals(stringIntegerMap, actualDictionaryEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, actualDictionaryEncoding.inverted);
    MacExpertEncoding expectedBaseEncoding = builtIn.INSTANCE;
    assertSame(expectedBaseEncoding, actualDictionaryEncoding.getBaseEncoding());
  }

  /**
   * Test
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}.
   * <ul>
   *   <li>Then BaseEncoding return {@link StandardEncoding}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSDictionary, boolean, Encoding); then BaseEncoding return StandardEncoding")
  void testNewDictionaryEncoding_thenBaseEncodingReturnStandardEncoding() {
    // Arrange and Act
    DictionaryEncoding actualDictionaryEncoding = new DictionaryEncoding(new COSDictionary(), true,
        MacExpertEncoding.INSTANCE);

    // Assert
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof StandardEncoding);
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap, actualDictionaryEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap, actualDictionaryEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, ((StandardEncoding) baseEncoding).inverted);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSName, COSArray); when A")
  void testNewDictionaryEncoding_whenA() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new DictionaryEncoding(COSName.A, new COSArray()));

  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSDictionary); when COSDictionary(); then return COSObject is COSDictionary()")
  void testNewDictionaryEncoding_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary fontEncoding = new COSDictionary();

    // Act and Assert
    assertSame(fontEncoding, (new DictionaryEncoding(fontEncoding)).getCOSObject());
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSDictionary); when COSStream(); then return COSObject is COSStream()")
  void testNewDictionaryEncoding_whenCOSStream_thenReturnCOSObjectIsCOSStream() {
    // Arrange
    COSStream fontEncoding = new COSStream();

    // Act and Assert
    assertSame(fontEncoding, (new DictionaryEncoding(fontEncoding)).getCOSObject());
  }

  /**
   * Test
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSDictionary, boolean, Encoding); when COSStream(); then return COSObject is COSStream()")
  void testNewDictionaryEncoding_whenCOSStream_thenReturnCOSObjectIsCOSStream2() {
    // Arrange
    COSStream fontEncoding = new COSStream();

    // Act
    DictionaryEncoding actualDictionaryEncoding = new DictionaryEncoding(fontEncoding, true,
        MacExpertEncoding.INSTANCE);

    // Assert
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof StandardEncoding);
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap, actualDictionaryEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap, actualDictionaryEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, ((StandardEncoding) baseEncoding).inverted);
    assertSame(fontEncoding, actualDictionaryEncoding.getCOSObject());
  }

  /**
   * Test
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSDictionary, boolean, Encoding); when 'false'; then throw IllegalArgumentException")
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
   * Method under test:
   * {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSName, COSArray); when 'null'")
  void testNewDictionaryEncoding_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new DictionaryEncoding(null, new COSArray()));

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
  void testGetEncodingName_thenReturnStandardEncodingWithDifferences() {
    // Arrange, Act and Assert
    assertEquals("StandardEncoding with differences",
        (new DictionaryEncoding(new COSDictionary(), true, MacExpertEncoding.INSTANCE)).getEncodingName());
  }
}
