package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class COSDictionaryMapDiffblueTest {
  /**
   * Method under test: {@link COSDictionaryMap#convert(Map)}
   */
  @Test
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
   * Method under test:
   * {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}
   */
  @Test
  void testConvertBasicTypesToMap() throws IOException {
    // Arrange and Act
    COSDictionaryMap<String, Object> actualConvertBasicTypesToMapResult = COSDictionaryMap
        .convertBasicTypesToMap(new COSDictionary());

    // Assert
    assertTrue(actualConvertBasicTypesToMapResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}
   */
  @Test
  void testConvertBasicTypesToMap2() throws IOException {
    // Arrange and Act
    COSDictionaryMap<String, Object> actualConvertBasicTypesToMapResult = COSDictionaryMap.convertBasicTypesToMap(null);

    // Assert
    assertNull(actualConvertBasicTypesToMapResult);
  }

  /**
   * Method under test:
   * {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}
   */
  @Test
  void testConvertBasicTypesToMap3() throws IOException {
    // Arrange and Act
    COSDictionaryMap<String, Object> actualConvertBasicTypesToMapResult = COSDictionaryMap
        .convertBasicTypesToMap(new COSStream());

    // Assert
    assertEquals(1, actualConvertBasicTypesToMapResult.size());
    assertTrue(actualConvertBasicTypesToMapResult.containsKey("Length"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSDictionaryMap#COSDictionaryMap(Map, COSDictionary)}
   *   <li>{@link COSDictionaryMap#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HashMap<Object, Object> actualsMap = new HashMap<>();

    // Act
    COSDictionaryMap<Object, Object> actualObjectObjectMap = new COSDictionaryMap<>(actualsMap, new COSDictionary());

    // Assert
    assertEquals("{}", actualObjectObjectMap.toString());
  }
}
