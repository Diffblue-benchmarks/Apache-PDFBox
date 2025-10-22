package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSDictionaryMapDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSDictionaryMap#COSDictionaryMap(Map, COSDictionary)}
   *   <li>{@link COSDictionaryMap#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDictionaryMap.<init>(Map, COSDictionary)", "String COSDictionaryMap.toString()"})
  void testGettersAndSetters() {
    // Arrange
    HashMap<Object, Object> actualsMap = new HashMap<>();

    // Act
    COSDictionaryMap<Object, Object> actualObjectObjectMap = new COSDictionaryMap<>(actualsMap, new COSDictionary());

    // Assert
    assertEquals("{}", actualObjectObjectMap.toString());
  }

  /**
   * Test {@link COSDictionaryMap#convert(Map)}.
   * <p>
   * Method under test: {@link COSDictionaryMap#convert(Map)}
   */
  @Test
  @DisplayName("Test convert(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary COSDictionaryMap.convert(Map)"})
  void testConvert() {
    // Arrange and Act
    COSDictionary actualConvertResult = COSDictionaryMap.convert(new HashMap<>());

    // Assert
    COSUpdateState updateState = actualConvertResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualConvertResult.getKey());
    assertEquals(0, actualConvertResult.size());
    COSIncrement toIncrementResult = actualConvertResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualConvertResult.isDirect());
    assertFalse(actualConvertResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualConvertResult.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}
   */
  @Test
  @DisplayName("Test convertBasicTypesToMap(COSDictionary); when COSDictionary(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionaryMap COSDictionaryMap.convertBasicTypesToMap(COSDictionary)"})
  void testConvertBasicTypesToMap_whenCOSDictionary_thenReturnEmpty() throws IOException {
    // Arrange and Act
    COSDictionaryMap<String, Object> actualConvertBasicTypesToMapResult = COSDictionaryMap
        .convertBasicTypesToMap(new COSDictionary());

    // Assert
    assertTrue(actualConvertBasicTypesToMapResult.isEmpty());
  }

  /**
   * Test {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}
   */
  @Test
  @DisplayName("Test convertBasicTypesToMap(COSDictionary); when COSStream(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionaryMap COSDictionaryMap.convertBasicTypesToMap(COSDictionary)"})
  void testConvertBasicTypesToMap_whenCOSStream_thenReturnSizeIsOne() throws IOException {
    // Arrange and Act
    COSDictionaryMap<String, Object> actualConvertBasicTypesToMapResult = COSDictionaryMap
        .convertBasicTypesToMap(new COSStream());

    // Assert
    assertEquals(1, actualConvertBasicTypesToMapResult.size());
    assertEquals(0, ((Integer) actualConvertBasicTypesToMapResult.get("Length")).intValue());
  }

  /**
   * Test {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}
   */
  @Test
  @DisplayName("Test convertBasicTypesToMap(COSDictionary); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionaryMap COSDictionaryMap.convertBasicTypesToMap(COSDictionary)"})
  void testConvertBasicTypesToMap_whenNull_thenReturnNull() throws IOException {
    // Arrange and Act
    COSDictionaryMap<String, Object> actualConvertBasicTypesToMapResult = COSDictionaryMap.convertBasicTypesToMap(null);

    // Assert
    assertNull(actualConvertBasicTypesToMapResult);
  }
}
