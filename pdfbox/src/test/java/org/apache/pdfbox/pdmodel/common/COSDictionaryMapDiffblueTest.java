package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSDictionaryMap#COSDictionaryMap(Map, COSDictionary)}
   *   <li>{@link COSDictionaryMap#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void COSDictionaryMap.<init>(Map, COSDictionary)",
    "String COSDictionaryMap.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    HashMap<Object, Object> actualsMap = new HashMap<>();

    // Act
    COSDictionaryMap<Object, Object> actualObjectObjectMap =
        new COSDictionaryMap<>(actualsMap, new COSDictionary());

    // Assert
    assertEquals("{}", actualObjectObjectMap.toString());
  }

  /**
   * Test {@link COSDictionaryMap#containsKey(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionaryMap#containsKey(Object)}
   */
  @Test
  @DisplayName(
      "Test containsKey(Object); given HashMap() '42' is '42'; when '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionaryMap.containsKey(Object)"})
  void testContainsKey_givenHashMap42Is42_when42_thenReturnTrue() {
    // Arrange
    HashMap<Object, Object> actualsMap = new HashMap<>();
    actualsMap.put("42", "42");
    COSDictionaryMap<Object, Object> objectObjectMap =
        new COSDictionaryMap<>(actualsMap, new COSDictionary());

    // Act and Assert
    assertTrue(objectObjectMap.containsKey("42"));
  }

  /**
   * Test {@link COSDictionaryMap#containsKey(Object)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionaryMap#containsKey(Object)}
   */
  @Test
  @DisplayName("Test containsKey(Object); when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionaryMap.containsKey(Object)"})
  void testContainsKey_whenKey_thenReturnFalse() {
    // Arrange
    HashMap<Object, Object> actualsMap = new HashMap<>();
    COSDictionaryMap<Object, Object> objectObjectMap =
        new COSDictionaryMap<>(actualsMap, new COSDictionary());

    // Act and Assert
    assertFalse(objectObjectMap.containsKey("Key"));
  }

  /**
   * Test {@link COSDictionaryMap#containsValue(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionaryMap#containsValue(Object)}
   */
  @Test
  @DisplayName(
      "Test containsValue(Object); given HashMap() '42' is '42'; when '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionaryMap.containsValue(Object)"})
  void testContainsValue_givenHashMap42Is42_when42_thenReturnTrue() {
    // Arrange
    HashMap<Object, Object> actualsMap = new HashMap<>();
    actualsMap.put("42", "42");
    actualsMap.put("Actuals Map", "Actuals Map");
    COSDictionaryMap<Object, Object> objectObjectMap =
        new COSDictionaryMap<>(actualsMap, new COSDictionary());

    // Act and Assert
    assertTrue(objectObjectMap.containsValue("42"));
  }

  /**
   * Test {@link COSDictionaryMap#containsValue(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionaryMap#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); when 'Value'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionaryMap.containsValue(Object)"})
  void testContainsValue_whenValue_thenReturnFalse() {
    // Arrange
    HashMap<Object, Object> actualsMap = new HashMap<>();
    actualsMap.put("Actuals Map", "Actuals Map");
    COSDictionaryMap<Object, Object> objectObjectMap =
        new COSDictionaryMap<>(actualsMap, new COSDictionary());

    // Act and Assert
    assertFalse(objectObjectMap.containsValue("Value"));
  }

  /**
   * Test {@link COSDictionaryMap#convert(Map)}.
   *
   * <p>Method under test: {@link COSDictionaryMap#convert(Map)}
   */
  @Test
  @DisplayName("Test convert(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test convertBasicTypesToMap(COSDictionary); when COSDictionary(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionaryMap COSDictionaryMap.convertBasicTypesToMap(COSDictionary)"})
  void testConvertBasicTypesToMap_whenCOSDictionary_thenReturnEmpty() throws IOException {
    // Arrange and Act
    COSDictionaryMap<String, Object> actualConvertBasicTypesToMapResult =
        COSDictionaryMap.convertBasicTypesToMap(new COSDictionary());

    // Assert
    assertTrue(actualConvertBasicTypesToMapResult.isEmpty());
  }

  /**
   * Test {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test convertBasicTypesToMap(COSDictionary); when COSStream(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionaryMap COSDictionaryMap.convertBasicTypesToMap(COSDictionary)"})
  void testConvertBasicTypesToMap_whenCOSStream_thenReturnSizeIsOne() throws IOException {
    // Arrange and Act
    COSDictionaryMap<String, Object> actualConvertBasicTypesToMapResult =
        COSDictionaryMap.convertBasicTypesToMap(new COSStream());

    // Assert
    assertEquals(1, actualConvertBasicTypesToMapResult.size());
    assertEquals(0, ((Integer) actualConvertBasicTypesToMapResult.get("Length")).intValue());
  }

  /**
   * Test {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionaryMap#convertBasicTypesToMap(COSDictionary)}
   */
  @Test
  @DisplayName("Test convertBasicTypesToMap(COSDictionary); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionaryMap COSDictionaryMap.convertBasicTypesToMap(COSDictionary)"})
  void testConvertBasicTypesToMap_whenNull_thenReturnNull() throws IOException {
    // Arrange and Act
    COSDictionaryMap<String, Object> actualConvertBasicTypesToMapResult =
        COSDictionaryMap.convertBasicTypesToMap(null);

    // Assert
    assertNull(actualConvertBasicTypesToMapResult);
  }
}
